package com.sys.entity;

import java.io.Serializable;

public class ScarInspectPolice implements Serializable {

	/**
	 * 伤痕检查-业务干警签名 ZXX
	 */
	private static final long serialVersionUID = 1L;
	private int id;//自增主键
	private String recordNumber;//档案编号
	private String scarPolice;//业务干警
	private String code;//警员编号
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
	public String getScarPolice() {
		return scarPolice;
	}
	public void setScarPolice(String scarPolice) {
		this.scarPolice = scarPolice;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "scarInspectPolice [id=" + id + ", recordNumber=" + recordNumber + ", scarPolice=" + scarPolice
				+ ", code=" + code + "]";
	}
	
	
	

}
