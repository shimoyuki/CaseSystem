package com.sys.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 入区信息登记实体类
 * @author佘开伟
 *
 */
public class Entry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  String recordNumber;
	
	private String IDCode;
	
	private String papersType;
	
	private String staffNo;
	
	private String frontalView;
	
	private String rightView;
	
	private String leftView;
	
	private int caseID;
	
	private String IDNumber;
	
	private String currentAddr;
	
	private String language;
	
	private String telephone;
	
	private String entryTime;
	
	private String personType;
	
	private int bindingType;
	
	private String recognition;
	
	private String causeCode;
	
	private IdentityCard identityCard;
	
	private List<EntryPolicemen> entryPolicemen;
	
	private List<EntryDutypolice> entryDutypolice;

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getIDCode() {
		return IDCode;
	}

	public void setIDCode(String iDCode) {
		IDCode = iDCode;
	}

	public String getPapersType() {
		return papersType;
	}

	public void setPapersType(String papersType) {
		this.papersType = papersType;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
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

	public int getCaseID() {
		return caseID;
	}

	public void setCaseID(int caseID) {
		this.caseID = caseID;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getCurrentAddr() {
		return currentAddr;
	}

	public void setCurrentAddr(String currentAddr) {
		this.currentAddr = currentAddr;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public int getBindingType() {
		return bindingType;
	}

	public void setBindingType(int bindingType) {
		this.bindingType = bindingType;
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

	public IdentityCard getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(IdentityCard identityCard) {
		this.identityCard = identityCard;
	}

	public List<EntryPolicemen> getEntryPolicemen() {
		return entryPolicemen;
	}

	public void setEntryPolicemen(List<EntryPolicemen> entryPolicemen) {
		this.entryPolicemen = entryPolicemen;
	}
	
	public List<EntryDutypolice> getEntryDutypolice() {
		return entryDutypolice;
	}

	public void setEntryDutypolice(List<EntryDutypolice> entryDutypolice) {
		this.entryDutypolice = entryDutypolice;
	}

	@Override
	public String toString() {
		return "Entry [recordNumber=" + recordNumber + ", IDCode=" + IDCode + ", papersType=" + papersType
				+ ", staffNo=" + staffNo + ", frontalView=" + frontalView + ", rightView=" + rightView + ", leftView="
				+ leftView + ", caseID=" + caseID + ", IDNumber=" + IDNumber + ", currentAddr=" + currentAddr
				+ ", language=" + language + ", telephone=" + telephone + ", entryTime=" + entryTime + ", personType="
				+ personType + ", bindingType=" + bindingType + ", recognition=" + recognition + ", causeCode="
				+ causeCode + ", identityCard=" + identityCard + ", entryPolicemen=" + entryPolicemen
				+ ", entryDutypolice=" + entryDutypolice + "]";
	}

	

	
	
	
	
	
	
}
