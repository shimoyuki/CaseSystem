package com.sys.entity;

import java.io.Serializable;
/**
 * 入区登记值班干警前置实体类
 * @author 佘开 伟
 *
 */
public class EntryDutypolice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String recordNumber;//档案号
	
	private String dutyPolice;//姓名
	
	private String code;//警编

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "EntryDutypolice [id=" + id + ", recordNumber=" + recordNumber + ", dutyPolice=" + dutyPolice + ", code="
				+ code + "]";
	}
}
