package fii.admission.note;

public class Note {
	float valoare;
        String candidatcnp;
	String examenid;
        
	public float getValoare(){
            return valoare;
        }
        public String getCandidatCNP(){
            return candidatcnp;
        }
        public String getExamenId(){
            return examenid;
        }
        public void setValoare(float valoare){
            this.valoare= valoare;
        }
        public void setCandidatCNP(String candidatcnp){
            this.candidatcnp=candidatcnp;
        }
        public void setExamenId(String examendid){
            this.examenid=examenid;
        }
}
