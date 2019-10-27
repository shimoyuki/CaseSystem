package com.sys.entity;

import java.io.Serializable;
/**
 * 入区登记业务干警签名
 * @author 佘开 伟
 *
 */
public class EntryPolicemen implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String recordNumber;//档案号
	
	private String entryPolice;//姓名
	
	private String code;//警编
	
	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getEntryPolice() {
		return entryPolice;
	}

	public void setEntryPolice(String entryPolice) {
		this.entryPolice = entryPolice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "EntryPolicemen [id=" + id + ", recordNumber=" + recordNumber + ", entryPolice=" + entryPolice
				+ ", code=" + code + "]";
	}
	
	
}
