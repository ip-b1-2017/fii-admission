package fii.admission.utils;

import com.google.gson.JsonObject;
import netscape.javascript.JSObject;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andy on 12.06.2017.
 */
public class StudentForm {
    private String nume;
    private String prenume;
//    private String formular;
    private String proba;

    public void setNume(String nume){
        this.nume=nume;
    }
    public void setPreume(String prenume){
        this.prenume=prenume;
    }
//    public void setFormular(String formular){
//        this.formular=formular;
//        Pattern pattern = Pattern.compile("'EXAM-OPTION-ALFA': '(.*?)'");
//        Matcher matcher = pattern.matcher(formular);
//        if (matcher.find())
//            proba=matcher.group(1);
//    }
    public void setFields(String formular){
//        System.out.println(formular);
        Pattern pattern = Pattern.compile("\"EXAM-OPTION-ALFA\": \"(.*?)\"");
        Matcher matcher = pattern.matcher(formular);
        if (matcher.find()) {
            proba = matcher.group(1);
//            System.out.println(proba);
        }
    }

    public String getNume(){
        return  nume;
    }

    public String getPrenume(){
        return prenume;
    }
//    public String getFormular(){
//        return formular;
//    }
    public String getProba(){
        return proba;
    }
//    public Comparator int compare(StudentForm o1, StudentForm o2){
//        if(o1.proba!=o2.proba)
//            return o1.proba<o2.proba;
//        if (o1.nume != o2.nume)
//            return o1.nume<o2.nume;
//        if (o1.prenume < o2.prenume) return true;
//        else return false;
//    }
}
