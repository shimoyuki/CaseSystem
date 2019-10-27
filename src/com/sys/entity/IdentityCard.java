package com.sys.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;

/**
 * 身份证信息
 * @author �ܿ� ΰ
 *
 */
public class IdentityCard implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String IDCode;
	
	private String name;
	
	private String sex;
	
	private String nation;
	
	private String birthday;
	
	/*private byte[] IDPicture;*/
	private String IDPicture;
	
	private String address;
	
	private String issuingAuthority;
	
	private String issuedValidDate;
	

	public String getIDCode() {
		return IDCode;
	}

	public void setIDCode(String iDCode) {
		IDCode = iDCode;
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

	/*public byte[] getIDPicture() {
		return IDPicture;
	}

	public void setIDPicture(byte[] iDPicture) {
		IDPicture = iDPicture;
	}*/

	

	public String getAddress() {
		return address;
	}

	public String getIDPicture() {
		return IDPicture;
	}

	public void setIDPicture(String iDPicture) {
		IDPicture = iDPicture;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}

	

	public String getIssuedValidDate() {
		return issuedValidDate;
	}

	public void setIssuedValidDate(String issuedValidDate) {
		this.issuedValidDate = issuedValidDate;
	}

	@Override
	public String toString() {
		return "IdentityCard [IDCode=" + IDCode + ", name=" + name + ", sex=" + sex + ", nation=" + nation
				+ ", birthday=" + birthday + ", IDPicture=" + IDPicture + ", address=" + address + ", issuingAuthority="
				+ issuingAuthority + ", issuedValidDate=" + issuedValidDate + "]";
	}
	
	
}
