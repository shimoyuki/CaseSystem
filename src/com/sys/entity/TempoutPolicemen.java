package com.sys.entity;

import java.io.Serializable;
/**
 * 临时离区登记业务干警签名实体类
 * @author 佘开 伟
 *
 */
public class TempoutPolicemen implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private int temID;//临时出区ID
	
	private String tempoutPolice;//姓名
	
	private String code;//警编

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getTemID() {
		return temID;
	}

	public void setTemID(int temID) {
		this.temID = temID;
	}

	public String getTempoutPolice() {
		return tempoutPolice;
	}

	public void setTempoutPolice(String tempoutPolice) {
		this.tempoutPolice = tempoutPolice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "TempoutPolicemen [id=" + id + ", temID=" + temID + ", tempoutPolice=" + tempoutPolice + ", code=" + code
				+ "]";
	}
	
	
}
