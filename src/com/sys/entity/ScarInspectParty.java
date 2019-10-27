package com.sys.entity;

import java.io.Serializable;

public class ScarInspectParty implements Serializable {

	/**
	 * 伤痕检查-被检查/监护人签名 ZXX
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//自增主键
	private String recordNumber;//档案编号
	private String scarParty;//当事人
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
	public String getScarParty() {
		return scarParty;
	}
	public void setScarParty(String scarParty) {
		this.scarParty = scarParty;
	}
	@Override
	public String toString() {
		return "scarInspectParty [id=" + id + ", recordNumber=" + recordNumber + ", scarParty=" + scarParty + "]";
	}
	
	
}
