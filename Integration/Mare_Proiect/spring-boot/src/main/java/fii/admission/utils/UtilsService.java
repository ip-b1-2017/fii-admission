package fii.admission.utils;


import fii.admission.MainApp;
import fii.admission.candidati.Candidat;
import fii.admission.candidati.CandidatService;
import fii.admission.sali.Sali;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


/**
 * Created by andy on 07.06.2017.
 */
@Service
public class UtilsService {
    public static boolean ok(TreeMap<String, Integer> probe){
        for (Map.Entry<String,Integer>ent:probe.entrySet()){
            if(ent.getValue()!=0)
                return false;
        }
        return true;
    }
    public static int[] generate(int k,List<Sali>sali,TreeMap<String,Integer>probe,int[]aloc){
        if(k>sali.size()) {
            if (ok(probe))
                return aloc;
            return null;
        }
        int old,i=0,dif;
        for (Map.Entry<String,Integer>ent:probe.entrySet()){
            if(ent.getValue()!=0) {
                aloc[k] = i;
                old = ent.getValue();
                dif = old-sali.get(k).getNrLocuri();
                if(dif<0)
                    dif=0;
                ent.setValue(dif);
                int []r = generate(k+1,sali, probe, aloc);
                if(r!=null)
                    return r;
                ent.setValue(old);
            }
            i++;
        }
        generate(k+1,sali, probe, aloc);
        return null;
    }
    public static int[] AssignClasses(List<Sali>sali, TreeMap<String,Integer>probe){
        int totalSali=0;
        int totalCandidati=0;
        int aloc[]=new int[sali.size()];
        for(int i = 0; i < sali.size();i++){
            aloc[i]=-1;
            totalSali+=sali.get(i).getNrLocuri();
        }
        for (Map.Entry<String,Integer>entry:probe.entrySet()) {
            totalCandidati+=entry.getValue();
        }
        if(totalCandidati>totalSali)
            return null;
        aloc=generate(0,sali,probe,aloc);
        return aloc;
    }
    static public List<StudentsPlacement> getStudentsPlacement() {
        Connection con = MainApp.getDBConnection();
        List<StudentsPlacement> listStudents = new ArrayList<>();
        List<Sali>sali=new ArrayList<>();
        TreeMap<String,Integer>probe = new TreeMap<String, Integer>();
//        TreeMap<String ,StudentForm> studentFormList = new TreeMap<>();
        ArrayList<StudentForm>students=new ArrayList<>();

        String query = "SELECT nume,prenume,formular FROM FORM JOIN CANDIDAT ON CNP=CANDIDATCNP";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                StudentForm studentForm = new StudentForm();
                studentForm.setNume(rs.getString("NUME"));
                studentForm.setPreume(rs.getString("PRENUME"));
                studentForm.setFields(rs.getString("FORMULAR"));
                String proba = studentForm.getProba();
                if (!probe.containsKey(proba))
                    probe.put(proba,0);
                probe.put(proba,probe.get(proba)+1);
                students.add(studentForm);
            }
            stmt.close();
            rs.close();
            Collections.sort(students,(StudentForm first, StudentForm second)->{
                if(first.getProba().equals(second.getProba())){
                    if (first.getNume().equals(second.getNume()))
                        return first.getPrenume().compareTo(second.getPrenume());
                    return first.getNume().compareTo(second.getNume());
                }
                return first.getProba().compareTo(second.getProba());
            });
            String queryClass = "SELECT * FROM SALI ORDER BY LOCURI";
            Statement stmtClass = con.createStatement();
            ResultSet rsClass = stmt.executeQuery(queryClass);
            while (rsClass.next()) {
                Sali sala =new Sali();
                sala.setId(rsClass.getString("ID"));
                sala.setLocatie(rsClass.getString("LOCATIE"));
                sala.setNrLocuri(rsClass.getInt("LOCURI"));
                sali.add(sala);
            }
            String data = "17/07/2017";
            stmtClass.close();
            rsClass.close();
            TreeMap<String,Integer>save=new TreeMap<>(probe);
            System.out.println("ok");
            int aloc[]=AssignClasses(sali,probe);
            probe=save;
            int j=0,lg;
            System.out.println(aloc);
            for(int i=0;i<sali.size();i++){
                lg=students.size();
                if(lg>sali.get(i).getNrLocuri())
                    lg=sali.get(i).getNrLocuri();
                if (lg>probe.get(aloc[i]))
                    lg=probe.get(aloc[i]);
                lg=lg+j;
                for(;j<lg;j++){
                    listStudents.add(new StudentsPlacement(students.get(j),sali.get(i),data,"09:00"));
                }
            }

            if (listStudents.isEmpty())
                return null;
            else
                return listStudents;
        } catch (Exception exc) {
            System.out.printf("[error][getStudentsPlacement] %s\n", exc.getMessage());
        }
        return null;
    }

    static public List<StudentsPlacement> getStudentsPlacement(String filename) {
        JasperReportBuilder report = DynamicReports.report();
        final List<StudentsPlacement> listStudents = getStudentsPlacement();
        report
                .columns(
                        Columns.column("Firstname", DataTypes.stringType()),
                        Columns.column("Lastname", DataTypes.stringType()),
                        Columns.column("Class",  DataTypes.stringType()),
                        Columns.column("Type", DataTypes.stringType()),
                        Columns.column("Hour",  DataTypes.stringType()))
                .title(//title of the report
                        Components.text("Students Placement")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
        ;
        try {
            //show the report
            report.setDataSource(listStudents);
            report.show();

            //export the report to a pdf file
            report.toPdf(new FileOutputStream(filename+".pdf"));
            //return listStudents;
        } catch (Exception exc) {
            System.out.printf("[error][getStudentsPlacement( " +filename+
                    " )] %s\n", exc.getMessage());
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Students");
            Map<String, Object[]> data = new TreeMap<String, Object[]>();
            int rowNum = 0;
            for (StudentsPlacement student : listStudents) {
                data.put(String.valueOf((++rowNum)),
                        new Object[]{student.getPrenume(), student.getNume(),
                                student.getSala(),student.getProba(),student.getOra()});
            }
            Set<String> keyset = data.keySet();
            int rownum = 0;
            Row header = sheet.createRow(rownum);
            header.createCell(0).setCellValue("First Name");
            header.createCell(1).setCellValue("Last Name");
            header.createCell(1).setCellValue("Class");
            header.createCell(1).setCellValue("Type");
            header.createCell(1).setCellValue("Hour");
            for (String key : keyset) {
                Row row = sheet.createRow(++rownum);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }
            FileOutputStream out = new FileOutputStream(new File(filename+".xls"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            System.out.printf("[error][exportStudents] %s\n", e.getMessage());
        }
        return null;
    }

    static public void exportStudents(String fileName) {
        try {
            List<Candidat> candidats = CandidatService.getAllCandidat();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Students");
            Map<String, Object[]> data = new TreeMap<String, Object[]>();
            int rowNum = 0;
            for (Candidat candidat : candidats) {
                data.put(String.valueOf((++rowNum)),
                        new Object[]{candidat.getFirstname(), candidat.getLastname()});
            }
            Set<String> keyset = data.keySet();
            int rownum = 0;
            Row header = sheet.createRow(rownum);
            header.createCell(0).setCellValue("First Name");
            header.createCell(1).setCellValue("Last Name");
            for (String key : keyset) {
                Row row = sheet.createRow(++rownum);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    }
                }
            }
            FileOutputStream out = new FileOutputStream(new File(fileName+".xls"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            System.out.printf("[error][exportStudents] %s\n", e.getMessage());
        }

    }

    public static void getProfesoriPlacement() {
    }
}
