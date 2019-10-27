package com.sys.entity;

import java.io.Serializable;

/**
 * 值班实体类
 * @author 佘开 伟
 *
 */
public class Duty implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String roomCode;
	
	private int policeID;
	
	private String watchHour;
	
	private String policeStation;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public int getPoliceID() {
		return policeID;
	}

	public void setPoliceID(int policeID) {
		this.policeID = policeID;
	}

	public String getWatchHour() {
		return watchHour;
	}

	public void setWatchHour(String watchHour) {
		this.watchHour = watchHour;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	@Override
	public String toString() {
		return "Duty [ID=" + ID + ", roomCode=" + roomCode + ", policeID=" + policeID + ", watchHour=" + watchHour
				+ ", policeStation=" + policeStation + "]";
	}
	
	
	
}
