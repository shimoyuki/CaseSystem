package com.sys.entity;

import java.io.Serializable;

/**
 * 储物柜实体类
 * @author 佘开 伟
 *
 */
public class Locker implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;//储物柜号
	
	private String name;//储物柜名
	
	private int isAvailable;//是否可用
	
	private String policeStation;//所属派出所

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
