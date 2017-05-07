package com.ip_b1.fii.admission.DTO;

import java.util.ArrayList;

public class AvailableExamClassromEntity{
	private String sessionName;
	private ArrayList<ClassroomEntity> classroomList;

	public AvailableExamClassromEntity(){

	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public ArrayList<ClassroomEntity> getHollList() {
		return classroomList;
	}

	public void setHollList(ArrayList<ClassroomEntity> classroomList) {
		this.classroomList = classroomList;
	}
}
