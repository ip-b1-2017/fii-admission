package fii.admission.utils;

/**
 * Created by andy on 07.06.2017.
 */
public class StudentsPlacement {
    private String nume;
    private String prenume;
    private String sala;
    private String etaj;
    private String proba;
    private String data;
    private String ora;

    public void StudentsPlacement(){

    }

    public String getNume(){
        return  nume;
    }
    public String getPrenume(){
        return  prenume;
    }
    public String getSala(){
        return  sala;
    }
    public String getEtaj(){
        return  etaj;
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
    public void setEtaj(String etaj){
        this.etaj=etaj;
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
}
