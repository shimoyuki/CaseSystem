package com.sys.entity;

import java.io.Serializable;
/**
 * 人身安全检查自诉情况表+ 伤痕的签名
 * @author 郑羲贤
 *
 */
public class PersonScrutiny implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String recordNumber;//档案号
	
	private String isDrink;//是否饮酒
	
	private String isContage;//是否有传染病
	
	private String readmeSymptom;//自诉症状״
	
	
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getReadmeSymptom() {
		return readmeSymptom;
	}

	public void setReadmeSymptom(String readmeSymptom) {
		this.readmeSymptom = readmeSymptom;
	}

	public String getIsDrink() {
		return isDrink;
	}

	public void setIsDrink(String isDrink) {
		this.isDrink = isDrink;
	}

	public String getIsContage() {
		return isContage;
	}

	public void setIsContage(String isContage) {
		this.isContage = isContage;
	}

	@Override
	public String toString() {
		return "PersonScrutiny [id=" + id + ", recordNumber=" + recordNumber + ", isDrink=" + isDrink + ", isContage="
				+ isContage + ", readmeSymptom=" + readmeSymptom + "]";
	}
		
	
	
	
	
	
}
