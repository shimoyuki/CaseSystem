package com.sys.entity;

import java.io.Serializable;

/**
 * 视图 嫌疑人常用信息头
 * @author 佘开 伟
 *
 */
public class Infoheader implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String recordNumber;//档案号
	
	private String recognition;//设备识别码
	
	private String causeCode;//入区原因
	
	private String frontalView;//嫌疑人正面照
	
	private String rightView;//嫌疑人右侧面照
	
	private String leftView;//嫌疑人左侧面照
	
	private String IDPicture;//证件头像
	
	private String name;//姓名
	
	private String sex;//性别
	
	private String nation;//民族
	
	private String birthday;//出生年月日
	
	private String language;//语言
	
	private String papersType;//证件类型
	
	private String personType;//入区身份
	
	private String IDCode;//证件号
	
	private String address;//家庭地址
	
	private String currentAddr;//现地址
	
	private String entryTime;//入区时间
	
	private String telephone;//联系方式

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}

	public String getFrontalView() {
		return frontalView;
	}

	public void setFrontalView(String frontalView) {
		this.frontalView = frontalView;
	}

	public String getRightView() {
		return rightView;
	}

	public void setRightView(String rightView) {
		this.rightView = rightView;
	}

	public String getLeftView() {
		return leftView;
	}

	public void setLeftView(String leftView) {
		this.leftView = leftView;
	}

	public String getIDPicture() {
		return IDPicture;
	}

	public void setIDPicture(String iDPicture) {
		IDPicture = iDPicture;
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

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPapersType() {
		return papersType;
	}

	public void setPapersType(String papersType) {
		this.papersType = papersType;
	}

	public String getIDCode() {
		return IDCode;
	}

	public void setIDCode(String iDCode) {
		IDCode = iDCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCurrentAddr() {
		return currentAddr;
	}

	public void setCurrentAddr(String currentAddr) {
		this.currentAddr = currentAddr;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	@Override
	public String toString() {
		return "Infoheader [recordNumber=" + recordNumber + ", recognition=" + recognition + ", causeCode=" + causeCode
				+ ", frontalView=" + frontalView + ", rightView=" + rightView + ", leftView=" + leftView
				+ ", IDPicture=" + IDPicture + ", name=" + name + ", sex=" + sex + ", nation=" + nation + ", birthday="
				+ birthday + ", language=" + language + ", papersType=" + papersType + ", personType=" + personType
				+ ", IDCode=" + IDCode + ", address=" + address + ", currentAddr=" + currentAddr + ", entryTime="
				+ entryTime + ", telephone=" + telephone + "]";
	}

	
	
}
