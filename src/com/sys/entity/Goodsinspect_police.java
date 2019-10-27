package com.sys.entity;

import java.io.Serializable;
/**
 * 随身物品检查--业务干警签字 郑羲贤
 * @author zhengxixian
 *
 */
public class Goodsinspect_police implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//自增主键
	private String recordNumber;//档案编号
	private String goodsPolice;//业务干警
	private String code;//警编
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
	public String getGoodsPolice() {
		return goodsPolice;
	}
	public void setGoodsPolice(String goodsPolice) {
		this.goodsPolice = goodsPolice;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Goodsinspect_police [id=" + id + ", recordNumber=" + recordNumber + ", goodsPolice=" + goodsPolice
				+ ", code=" + code + "]";
	}
	
	

}
