package com.sys.entity;

import java.io.Serializable;

/**
 * �������֤������ʵ����
 * @author �ܿ� ΰ
 *
 */
public class Idreader implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String code;//�������֤���������
	
	private String state;//״̬
	
	private String policeStaion;//�����ɳ���
	
	private String detail ;//��ע

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPoliceStaion() {
		return policeStaion;
	}

	public void setPoliceStaion(String policeStaion) {
		this.policeStaion = policeStaion;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Idreader [ID=" + ID + ", code=" + code + ", state=" + state + ", policeStaion=" + policeStaion
				+ ", detail=" + detail + "]";
	}
	
	
}
