package com.sys.entity;

import java.io.Serializable;
/**
 * 档案管理--当前嫌疑人的列表--页面返回实体类
 * @author zhengxixian
 *
 */
public class CurrentSuspectsList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;//嫌疑人姓名
	private String IDNumber;//证件号码
	private String caseName;//案件名称
	private String entryCasue;//入区是由
	private String outCasue;//出区原因
	private String busPolice;//业务干警
	private String entryTime;//入区时间
	private String recordNumber;//档案号
	
	
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getEntryCasue() {
		return entryCasue;
	}
	public void setEntryCasue(String entryCasue) {
		this.entryCasue = entryCasue;
	}
	public String getOutCasue() {
		return outCasue;
	}
	public void setOutCasue(String outCasue) {
		this.outCasue = outCasue;
	}
	public String getBusPolice() {
		return busPolice;
	}
	public void setBusPolice(String busPolice) {
		this.busPolice = busPolice;
	}
	
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	@Override
	public String toString() {
		return "CurrentSuspectsList [id=" + id + ", name=" + name + ", IDNumber=" + IDNumber + ", caseName=" + caseName
				+ ", entryCasue=" + entryCasue + ", outCasue=" + outCasue + ", busPolice=" + busPolice + ", entryTime="
				+ entryTime + ", recordNumber=" + recordNumber + "]";
	}
	
	
	

}
