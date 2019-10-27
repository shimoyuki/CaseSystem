package com.sys.entity;

import java.io.Serializable;

/**
 * 绑定设备实体
 * @author 佘开 伟
 *
 */
public class Binding implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String code;
	
	private int state;
	
	private String policeStation;
	
	private String bindingType;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public String getBindingType() {
		return bindingType;
	}

	public void setBindingType(String bindingType) {
		this.bindingType = bindingType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Binding [ID=" + ID + ", code=" + code + ", state=" + state + ", policeStation=" + policeStation
				+ ", bindingType=" + bindingType + "]";
	}
	
	
	
	
}
