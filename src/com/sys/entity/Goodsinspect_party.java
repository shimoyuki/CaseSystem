package com.sys.entity;

import java.io.Serializable;
/**
 * 随身物品检查--被检查人签字 郑羲贤
 * @author zhengxixian
 *
 */
public class Goodsinspect_party implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//自增主键
	private String recordNumber;//档案编号
	private String goodsParty;//当事人
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
	public String getGoodsParty() {
		return goodsParty;
	}
	public void setGoodsParty(String goodsParty) {
		this.goodsParty = goodsParty;
	}
	@Override
	public String toString() {
		return "Goodsinspect_party [id=" + id + ", recordNumber=" + recordNumber + ", goodsParty=" + goodsParty + "]";
	}
	
	

}
