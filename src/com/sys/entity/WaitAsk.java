package com.sys.entity;

import java.io.Serializable;

/**
 * 候问等待表
 * @author 佘开 伟
 *
 */
public class WaitAsk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String recognition;//设备识别码
	
	private String recordNumber;//档案号
	
	private String roomCode;//房间编号
	
	private String policeStation;//所属派出所
	
	private String entryTime;//进入时间
	
	private String ltime;//离开时间
	
	private int isLeave;//是否离开
	
	private Entry entry;//入区档案信息

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
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

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getLtime() {
		return ltime;
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	public int getIsLeave() {
		return isLeave;
	}

	public void setIsLeave(int isLeave) {
		this.isLeave = isLeave;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	@Override
	public String toString() {
		return "WaitAsk [ID=" + ID + ", recognition=" + recognition + ", recordNumber=" + recordNumber + ", roomCode="
				+ roomCode + ", policeStation=" + policeStation + ", entryTime=" + entryTime + ", ltime=" + ltime
				+ ", isLeave=" + isLeave + ", entry=" + entry + "]";
	}
	
	
}
