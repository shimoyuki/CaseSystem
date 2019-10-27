package com.sys.entity;

import java.io.Serializable;
/**
 * 案件-被害人实体类
 * @author 佘开 伟
 *
 */
public class CaseVictim implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int caseID;//案件ID
	
	private String vIDCode;//证人证件号
	
	private String name;//姓名
	
	private String sex;//性别
	
	private String frontalView;//正面照
	
	private String nation;//民族

	public int getCaseID() {
		return caseID;
	}

	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}

	public String getvIDCode() {
		return vIDCode;
	}

	public void setvIDCode(String vIDCode) {
		this.vIDCode = vIDCode;
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

	public String getFrontalView() {
		return frontalView;
	}

	public void setFrontalView(String frontalView) {
		this.frontalView = frontalView;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Override
	public String toString() {
		return "CaseVictim [caseID=" + caseID + ", vIDCode=" + vIDCode + ", name=" + name + ", sex=" + sex
				+ ", frontalView=" + frontalView + ", nation=" + nation + "]";
	}
	
	
}
