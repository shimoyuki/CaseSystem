package com.sys.entity;

import java.io.Serializable;

public class ICCard implements Serializable {

	/**
	 * IC��ʵ����
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//
	private String code;//IC�����
	private String state;//���豸״̬ ��0,1��ʾ��0��ʾ���� 1��ʾ������
	private String policeStation;//�����ɳ���  ���ɳ���(policeStation)����
	private String detail;//��ע
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
