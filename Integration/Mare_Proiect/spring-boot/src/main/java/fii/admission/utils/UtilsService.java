package fii.admission.utils;


import fii.admission.MainApp;
import fii.admission.candidati.Candidat;
import fii.admission.candidati.CandidatService;
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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 * Created by andy on 07.06.2017.
 */
@Service
public class UtilsService {
    static public void getStudentsPlacement() {
        Connection con = MainApp.getDBConnection();
        JasperReportBuilder report = DynamicReports.report();
        report
                .columns(
                        Columns.column("Nume Canditat", "", DataTypes.stringType()),
                        Columns.column("Prenume Candidat", "", DataTypes.stringType()),
                        Columns.column("Last Name", "last_name", DataTypes.stringType()),
                        Columns.column("Date", "date", DataTypes.dateType()))
                .title(//title of the report
                        Components.text("Inscrieri")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource("SELECT id, first_name, last_name, date FROM customers",
                        con);
        try {
            //show the report
            report.show();

            //export the report to a pdf file
            report.toPdf(new FileOutputStream("report.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            FileOutputStream out = new FileOutputStream(new File(fileName));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            System.out.printf("[error][exportStudents] %s\n", e.getMessage());
        }

    }

    public static void getProfesoriPlacement() {
    }
}
