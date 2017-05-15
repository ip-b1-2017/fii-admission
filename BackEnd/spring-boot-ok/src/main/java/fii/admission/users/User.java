package fii.admission.users;

public class User {
	private int id;
	private String role;
	private String email;
	private String firstname;
	private String lastname;
	private String parola;
	private String token;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
