package com.ip_b1.fii.admission.DTO;

public class ClassroomInEntity {
	private Integer classroomId;
	AuthEntity auth;
	public ClassroomInEntity(){
		
	}
	public Integer getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}
	public AuthEntity getAuth() {
		return auth;
	}
	public void setAuth(AuthEntity auth) {
		this.auth = auth;
	}
}
