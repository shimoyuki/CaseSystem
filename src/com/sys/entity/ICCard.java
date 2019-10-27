package com.sys.entity;

import java.io.Serializable;

public class ICCard implements Serializable {

	/**
	 * IC卡实体类
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//
	private String code;//IC卡编号
	private String state;//绑定设备状态 （0,1表示）0表示可用 1表示不可用
	private String policeStation;//所属派出所  与派出所(policeStation)关联
	private String detail;//备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "ICCard [id=" + id + ", code=" + code + ", state=" + state + ", policeStation=" + policeStation
				+ ", detail=" + detail + "]";
	}
	
	
	

}
