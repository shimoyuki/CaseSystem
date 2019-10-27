package com.sys.entity;

import java.io.Serializable;

/**
 * 房间实体类
 * @author 佘开 伟
 *
 */
public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roomCode;//房间编号
	
	private String roomName;//房间名称
	
	private String function;//房间功能
	
	private String isAvailable;//是否可用
	
	private String device;//是否可用
	
	private String ip;//终端设备IP
	
	private String policeStation;

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	@Override
	public String toString() {
		return "Room [roomCode=" + roomCode + ", roomName=" + roomName + ", function=" + function + ", isAvailable="
				+ isAvailable + ", device=" + device + ", ip=" + ip + ", policeStation=" + policeStation + "]";
	}

	
}
