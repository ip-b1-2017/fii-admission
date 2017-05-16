package fii.admission.notificari;

public class Notificari {
	private int userid;
	private String text;
	private String seen;
	private String useremail;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSeen() {
		return seen;
	}

	public void setSeen(String seen) {
		this.seen = seen;
	}

	public String getUserEmail() {
		return useremail;
	}

	public void setUserEmail(String useremail) {
		this.useremail = useremail;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
