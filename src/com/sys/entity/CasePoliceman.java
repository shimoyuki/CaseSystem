package com.sys.entity;

import java.io.Serializable;
/**
 * 案件-办案组员
 * @author 佘开 伟
 *
 */
public class CasePoliceman implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int caseID;//案件ID
	
	private String policeID;//警员ID
	
	private String name;//姓名
	
	private String sex;//性别
	
	private String picture;//证件照

	public int getCaseID() {
		return caseID;
	}

	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}


	public String getPoliceID() {
		return policeID;
	}

	public void setPoliceID(String policeID) {
		this.policeID = policeID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "CasePoliceman [caseID=" + caseID + ", policeID=" + policeID + ", name=" + name + ", sex=" + sex
				+ ", picture=" + picture + "]";
	}
	
	
}
