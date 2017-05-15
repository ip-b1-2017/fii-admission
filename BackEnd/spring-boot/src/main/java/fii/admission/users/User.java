package fii.admission.users;

public class User {
<<<<<<< HEAD
	private String rol;
=======
	private int id;
	private String role;
>>>>>>> 023589181397ba2ec6f7f1dc9fcd09c786d579d2
	private String email;
	private String password;
	private String token;
<<<<<<< HEAD

	public String getRol() {
		return rol;
=======
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getFirstName() {
		return firstname;
>>>>>>> 023589181397ba2ec6f7f1dc9fcd09c786d579d2
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParola() {
		return password;
	}

	public void setParola(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
