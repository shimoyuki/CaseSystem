package com.sys.entity;

import java.io.Serializable;
/**
 * 编码流程实体类
 * @author 佘开 伟
 *
 */
public class RecordState implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String recordNumber;
	
	private int lastState;
	
	private int currentState;

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

	public int getLastState() {
		return lastState;
	}

	public void setLastState(int lastState) {
		this.lastState = lastState;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	@Override
	public String toString() {
		return "RecordState [ID=" + ID + ", recordNumber=" + recordNumber + ", lastState=" + lastState
				+ ", currentState=" + currentState + "]";
	}
	
	
	
}
