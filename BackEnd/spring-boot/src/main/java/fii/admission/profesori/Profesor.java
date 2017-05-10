package fii.admission.profesori;

public class Profesor {
	private String nume;
	private String prenume;
	private String PCNP;
	private String sali_examensaliid;
	private String sali_examenexamenid;
	
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
	public String getPCNP() {
		return PCNP;
	}
	public void setPCNP(String PCNP) {
		this.PCNP = PCNP;
	}
	public String getSaliExamenSaliId() {
		return sali_examensaliid;
	}
	public void setSaliExamenSaliId(String sali_examensaliid) {
		this.sali_examensaliid = sali_examensaliid;
	}
	public String getSaliExamenExamenId() {
		return sali_examenexamenid;
	}
	public void setSaliExamenExamenId(String sali_examenexamenid) {
		this.sali_examenexamenid = sali_examenexamenid;
	}
}
