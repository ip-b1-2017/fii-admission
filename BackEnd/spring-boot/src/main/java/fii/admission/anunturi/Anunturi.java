/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fii.admission.anunturi;

public class Anunturi {
	private int id;
	private String anunt;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public String getAnunt() {
		return anunt;
	}

	public void setAnunt(String anunt) {
		this.anunt = anunt;
	}
}