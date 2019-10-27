package com.sys.entity;

import java.io.Serializable;
/**
 * 采集项目实体类
 * @author 佘开 伟
 *
 */
public class CollectionProject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String recordNumber;
	
	private String name;
	
	

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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Collectionproject [ID=" + ID + ", recordNumber=" + recordNumber + ", name=" + name + "]";
	}

	

	
	
}
