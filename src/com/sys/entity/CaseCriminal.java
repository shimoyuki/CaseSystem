package com.sys.entity;

import java.io.Serializable;
/**
 * 案件-嫌疑人实体类
 * @author 佘开 伟
 *
 */
public class CaseCriminal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int caseID;//案件ID
	
	private String cIDCode;//嫌疑人证件号
	
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

	public String getcIDCode() {
		return cIDCode;
	}

	public void setcIDCode(String cIDCode) {
		this.cIDCode = cIDCode;
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
		return "CaseCriminal [caseID=" + caseID + ", cIDCode=" + cIDCode + ", name=" + name + ", sex=" + sex
				+ ", frontalView=" + frontalView + ", nation=" + nation + "]";
	}

	
	
	
}
