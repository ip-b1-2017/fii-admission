package fii.admission.examene;

public class Examen {
	String id, start_date,end_date, tip;   
        int nr_proba;
	
	public String getId() {
		return id;
	}
	public String getStartDate(){
            return start_date;
        }
        public String getEndDate(){
            return end_date;
        }
        public String getTip(){
            return tip;
        }
        public int getNrProba(){
            return nr_proba;
        }
        public void setNrProba(int nr_proba){
            this.nr_proba=nr_proba;
        }
        public void setTip(String tip){
            this.tip=tip;
        }
        public void setId(String id){
            this.id=id;
        }
        public void setStartDate(String start_date){
            this.start_date=start_date;
        }
        public void setEndDate(String end_date){
            this.end_date=end_date;
        }
}
