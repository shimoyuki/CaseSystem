package com.sys.entity;

import java.io.Serializable;

/**
 * �����ʵ����
 * @author �ܿ� ΰ
 *
 */
public class Locker implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;//������
	
	private String name;//�������
	
	private int isAvailable;//�Ƿ����
	
	private String policeStation;//�����ɳ���

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	@Override
	public String toString() {
		return "Locker [code=" + code + ", name=" + name + ", isAvailable=" + isAvailable + ", policeStation="
				+ policeStation + "]";
	}
	
	
}
