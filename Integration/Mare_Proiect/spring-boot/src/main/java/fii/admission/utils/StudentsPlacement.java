package fii.admission.utils;

import fii.admission.sali.Sali;

/**
 * Created by andy on 07.06.2017.
 */
//exam-option-alfa
public class StudentsPlacement {
    private String nume;
    private String prenume;
    private String sala;
    private String proba;
    private String data;
    private String ora;

    public String getNume(){
        return  nume;
    }
    public String getPrenume(){
        return  prenume;
    }
    public String getSala(){
        return  sala;
    }
    public String getProba(){
        return  proba;
    }
    public String getData(){
        return  data;
    }
    public String getOra(){
        return  ora;
    }
    public void setNume(String nume){
        this.nume=nume;
    }
    public void setPrenume(String prenume){
        this.prenume=prenume;
    }
    public void setSala(String sala){
        this.sala=sala;
    }
    public void setProba(String proba){
        this.proba=proba;
    }
    public void setData(String data){
        this.data=data;
    }
    public void setOra(String ora){
        this.ora=ora;
    }

    public StudentsPlacement(StudentForm sf, Sali sala,String data, String ora){
        nume=sf.getNume();
        prenume=sf.getPrenume();
        proba=sf.getProba();
        this.data=data;
        this.sala=sala.getLocatie();
        this.ora=ora;
    }
}
