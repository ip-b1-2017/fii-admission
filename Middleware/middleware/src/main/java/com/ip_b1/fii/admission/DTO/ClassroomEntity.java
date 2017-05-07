package com.ip_b1.fii.admission.Controllers.DTO;

import java.util.ArrayList;

public class ClassroomEntity {
	private Integer hallId;
	private Integer hallName;
	private ArrayList<ProfessorEntity> professorList;
	public ClassroomEntity(){
		
	}
	public Integer getHallId() {
		return hallId;
	}
	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}
	public Integer getHallName() {
		return hallName;
	}
	public void setHallName(Integer hallName) {
		this.hallName = hallName;
	}
	public ArrayList<ProfessorEntity> getProfessorList() {
		return professorList;
	}
	public void setProfessorList(ArrayList<ProfessorEntity> professorList) {
		this.professorList = professorList;
	}
}
