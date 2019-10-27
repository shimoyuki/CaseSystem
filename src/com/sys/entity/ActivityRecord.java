package com.sys.entity;

import java.io.Serializable;
/**
 * 嫌疑人活动登记表
 * @author 佘开 伟
 *
 */
public class ActivityRecord implements Serializable {
	private int ID;
	
	private String recordNumber;//档案号
	
	private String events;//活动项目
	
	private String enterTime;//进入时间
	
	private String leaveTime;//离开时间
	
	private String roomCode;//房间编号
	
	private String policeStation;//所属派出所
	
	private String activity;//活动内容
	
	private String audioVideo;//音视频编码
	
	private String detainHour;//羁押时间
	
	private String detail;//备注

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	
	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	public String getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
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

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getAudioVideo() {
		return audioVideo;
	}

	public void setAudioVideo(String audioVideo) {
		this.audioVideo = audioVideo;
	}

	public String getDetainHour() {
		return detainHour;
	}

	public void setDetainHour(String detainHour) {
		this.detainHour = detainHour;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "ActivityRecord [ID=" + ID + ", recordNumber=" + recordNumber + ", events=" + events + ", enterTime="
				+ enterTime + ", leaveTime=" + leaveTime + ", roomCode=" + roomCode + ", policeStation=" + policeStation
				+ ", activity=" + activity + ", audioVideo=" + audioVideo + ", detainHour=" + detainHour + ", detail="
				+ detail + "]";
	}
	
	
}
