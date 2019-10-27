package com.sys.entity;

import java.io.Serializable;
/**
 * 随身物品检查--值班干警签字 郑羲贤
 * @author zhengxixian
 *
 */
public class Goodsinspect_dutypolice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//自增主键
	private String recordNumber;//档案编号
	private String dutyPolice;//业务干警
	private String dutyCode;//警编
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	public String getDutyPolice() {
		return dutyPolice;
	}
	public void setDutyPolice(String dutyPolice) {
		this.dutyPolice = dutyPolice;
	}
	public String getDutyCode() {
		return dutyCode;
	}
	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}
	@Override
	public String toString() {
		return "Goodsinspect_dutypolice [id=" + id + ", recordNumber=" + recordNumber + ", dutyPolice=" + dutyPolice
				+ ", dutyCode=" + dutyCode + "]";
	}
	
	

}
