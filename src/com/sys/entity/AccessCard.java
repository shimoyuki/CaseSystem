package com.sys.entity;

import java.io.Serializable;

/**
 * 门禁卡实体类
 * @author 佘开 伟
 *
 */
public class AccessCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String code;//门禁卡编码
	
	private int state;//门禁卡状态
	
	private String roomCode;// 所在房间编号
	
	private String policeStation;//所属派出所
	
	private String detail;//备注

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

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
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
		return "AccessCard [ID=" + ID + ", code=" + code + ", state=" + state + ", roomCode=" + roomCode
				+ ", policeStation=" + policeStation + ", detail=" + detail + "]";
	}
	
	
}
