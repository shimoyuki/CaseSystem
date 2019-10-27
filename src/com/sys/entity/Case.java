package com.sys.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 案件实体类
 * @author佘开伟
 *
 */
public class Case implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String name;//案件名称
	
	private String code;//案件编号
	
	private String caseNo;//案件宗号
	
	private String storageLoc;//保存位置
	
	private String startTime;//案发时间
	
	private String finishTime;//结案时间
	
	private String  caseType;//案件类型
	
	private String caseState;//案件状态
	
	private String leaderID;//案件组长
	
	private String CaseDescribe;//案件描述
	
	private String policeStation;//负责单位
	
	private List<CaseCriminal> caseCriminal;//嫌疑人
	
	private List<CaseWitness> caseWitness;//证人
	
	private List<CaseVictim> caseVictim;//被害人
	
	private List<CasePoliceman> casePoliceman;//案件负责组员

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getStorageLoc() {
		return storageLoc;
	}

	public void setStorageLoc(String storageLoc) {
		this.storageLoc = storageLoc;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getCaseState() {
		return caseState;
	}

	public void setCaseState(String caseState) {
		this.caseState = caseState;
	}

	public String getLeaderID() {
		return leaderID;
	}

	public void setLeaderID(String leaderID) {
		this.leaderID = leaderID;
	}

	

	public String getCaseDescribe() {
		return CaseDescribe;
	}

	public void setCaseDescribe(String caseDescribe) {
		CaseDescribe = caseDescribe;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public List<CaseCriminal> getCaseCriminal() {
		return caseCriminal;
	}

	public void setCaseCriminal(List<CaseCriminal> caseCriminal) {
		this.caseCriminal = caseCriminal;
	}

	public List<CaseWitness> getCaseWitness() {
		return caseWitness;
	}

	public void setCaseWitness(List<CaseWitness> caseWitness) {
		this.caseWitness = caseWitness;
	}

	public List<CaseVictim> getCaseVictim() {
		return caseVictim;
	}

	public void setCaseVictim(List<CaseVictim> caseVictim) {
		this.caseVictim = caseVictim;
	}

	public List<CasePoliceman> getCasePoliceman() {
		return casePoliceman;
	}

	public void setCasePoliceman(List<CasePoliceman> casePoliceman) {
		this.casePoliceman = casePoliceman;
	}

	@Override
	public String toString() {
		return "Case [ID=" + ID + ", name=" + name + ", code=" + code + ", caseNo=" + caseNo + ", storageLoc="
				+ storageLoc + ", startTime=" + startTime + ", finishTime=" + finishTime + ", caseType=" + caseType
				+ ", caseState=" + caseState + ", leaderID=" + leaderID + ", CaseDescribe=" + CaseDescribe
				+ ", policeStation=" + policeStation + ", caseCriminal=" + caseCriminal + ", caseWitness=" + caseWitness
				+ ", caseVictim=" + caseVictim + ", casePoliceman=" + casePoliceman + "]";
	}

	
	
	
}
