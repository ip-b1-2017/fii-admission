package fii.admission.notificari;

public class Notificari {
	String text, seen, useremail;
	
	public String getText(){
            return text;
        }
        public String getSeen(){
            return seen;
        }
        public String getUserEmail(){
            return useremail;
        }
        public void setText(String text){
            this.text=text;
        }
        public void setSeen(String seen){
            this.seen=seen;
        }
        public void setUserEmail(String useremail){
            this.useremail=useremail;
        }
}
