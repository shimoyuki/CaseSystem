package com.sys.entity;

import java.io.Serializable;

/**
 * ���ʵȴ���
 * @author �ܿ� ΰ
 *
 */
public class WaitAsk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String recognition;//�豸ʶ����
	
	private String recordNumber;//������
	
	private String roomCode;//������
	
	private String policeStation;//�����ɳ���
	
	private String entryTime;//����ʱ��
	
	private String ltime;//�뿪ʱ��
	
	private int isLeave;//�Ƿ��뿪
	
	private Entry entry;//����������Ϣ

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
