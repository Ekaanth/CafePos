package com.squapl.sa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OpenRegister {
	
	@Id
	@GeneratedValue
	private  Long id;
	private Long openmoney;
	private Date date;
	private String note;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOpenmoney() {
		return openmoney;
	}
	public void setOpenmoney(Long openmoney) {
		this.openmoney = openmoney;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	

}
