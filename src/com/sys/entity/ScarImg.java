package com.sys.entity;

import java.io.Serializable;

public class ScarImg implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//自增主键
	private int scarID;//对应伤情ID
	private String scarFigure;//伤痕附件
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScarID() {
		return scarID;
	}
	public void setScarID(int scarID) {
		this.scarID = scarID;
	}
	public String getScarFigure() {
		return scarFigure;
	}
	public void setScarFigure(String scarFigure) {
		this.scarFigure = scarFigure;
	}
	@Override
	public String toString() {
		return "ScarImg [id=" + id + ", scarID=" + scarID + ", scarFigure=" + scarFigure + "]";
	}
	
	
	
	

}
