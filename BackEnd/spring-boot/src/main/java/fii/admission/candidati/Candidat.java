package fii.admission.candidati;

public class Candidat {
	String CNP;
	String telefon;
	String nume;
	String prenume;
	String useremail;
	
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getCNP() {
		return CNP;
	}
	public void setCNP(String CNP) {
		this.CNP = CNP;
	}
	public String getUserEmail() {
		return useremail;
	}
	public void setUserEmail(String useremail) {
		this.useremail = useremail;
	}
}

