package fii.admission.candidati_forms;

/**
 * Created by andy on 16.05.2017.
 */

import fii.admission.MainApp;
import fii.admission.candidati.Candidat;
import fii.admission.forms.Form;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatFormService {
    static public List<CandidatForm> getAllCandidatForm() {
        ArrayList<CandidatForm> result = new ArrayList<CandidatForm>();
        Connection con = MainApp.getDBConnection();
        String query = "SELECT * FROM CANDIDAT JOIN FORM ON CNP = CANDIDATCNP";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //salvam campurile pentru candidat in candidat
                Candidat candidat = new Candidat();
                candidat.setCNP(rs.getString("CNP"));
                candidat.setTelefon(rs.getString("TELEFON"));
                candidat.setNume("NUME");
                candidat.setPrenume("PRENUME");
                candidat.setUserEmail("USEREMAIL");
                //salvam campurile pentru formular in form
                Form form = new Form();
                form.setCandidatCnp(rs.getString("CANDIDATCNP"));
                form.setInformatii(rs.getString("FORMULAR"));
                form.setStatus(rs.getString("STATUS"));
                //punem candidatul si formularul in candidatform
                CandidatForm candidatForm = new CandidatForm();
                candidatForm.setCandidat(candidat);
                candidatForm.setForm(form);
                //adaugam rezultatul in lista
                result.add(candidatForm);
            }
            stmt.close();
            rs.close();
            if (result.isEmpty())
                return null;
            else
                return result;
        } catch (Exception exc) {
            System.out.printf("[error][getAllCandidatForm] %s\n", exc.getMessage());
        }
        return null;
    }
}
