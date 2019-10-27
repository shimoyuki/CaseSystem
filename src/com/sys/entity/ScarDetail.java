package com.sys.entity;

import java.io.Serializable;
/**
 * 伤痕详情表
 * @author 郑羲贤
 *
 */
public class ScarDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;//自增主键
	private String recordNumber; //档案号
	private String orderNumber; //伤情序号
	private String scarArea; //伤情区域
	private String scarPart; //伤情部位
	private String scarType; //伤情类型
	private String scarDescribe; //伤情描述
	private String scarExplain; //伤情说明：区域+部位+类型
	private String numImg; //伤情附件张数
	
	
	
	public String getNumImg() {
		return numImg;
	}
	public void setNumImg(String numImg) {
		this.numImg = numImg;
	}
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
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getScarArea() {
		return scarArea;
	}
	public void setScarArea(String scarArea) {
		this.scarArea = scarArea;
	}
	public String getScarPart() {
		return scarPart;
	}
	public void setScarPart(String scarPart) {
		this.scarPart = scarPart;
	}
	public String getScarType() {
		return scarType;
	}
	public void setScarType(String scarType) {
		this.scarType = scarType;
	}
	public String getScarDescribe() {
		return scarDescribe;
	}
	public void setScarDescribe(String scarDescribe) {
		this.scarDescribe = scarDescribe;
	}
	public String getScarExplain() {
		return scarExplain;
	}
	public void setScarExplain(String scarExplain) {
		this.scarExplain = scarExplain;
	}
	@Override
	public String toString() {
		return "ScarDetail [id=" + id + ", recordNumber=" + recordNumber + ", orderNumber=" + orderNumber
				+ ", scarArea=" + scarArea + ", scarPart=" + scarPart + ", scarType=" + scarType + ", scarDescribe="
				+ scarDescribe + ", scarExplain=" + scarExplain + ", numImg=" + numImg + "]";
	}
	
	
	
}
	
	
	
	
