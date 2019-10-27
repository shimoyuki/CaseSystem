package com.sys.entity;

import java.io.Serializable;

public class CheckGoods implements Serializable {

	/**
	 * 人身安全检查随身物品登记表 郑羲贤
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//自增主键
	private String goodsName;//物品名称及特征
	private String goodsType;//物品分类编号 与物品分类表(goodsType)变关联
	private String quantityUnits;//数量单位
	private double quantity;//数量
	private String units;//单位
	private String custody;//保管措施
	private String cabinetsNumber;//保管柜号
	private String checkPolice;//办案人员人员签名
	private String goodsAdmin;//随身物品管理员签名
	private String suspect;//涉案人员签名
	private String handling;//离区物品处理情况(已还，未还) （0,1表示）0表示未还 1表示已还
	private String handlingTime;//离区物品返还时间
	private String recordNumber;//人身安全检查ID 与人身安全检查表关联
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getQuantityUnits() {
		return quantityUnits;
	}
	public void setQuantityUnits(String quantityUnits) {
		this.quantityUnits = quantityUnits;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getCustody() {
		return custody;
	}
	public void setCustody(String custody) {
		this.custody = custody;
	}
	public String getCabinetsNumber() {
		return cabinetsNumber;
	}
	public void setCabinetsNumber(String cabinetsNumber) {
		this.cabinetsNumber = cabinetsNumber;
	}
	public String getCheckPolice() {
		return checkPolice;
	}
	public void setCheckPolice(String checkPolice) {
		this.checkPolice = checkPolice;
	}
	public String getGoodsAdmin() {
		return goodsAdmin;
	}
	public void setGoodsAdmin(String goodsAdmin) {
		this.goodsAdmin = goodsAdmin;
	}
	public String getSuspect() {
		return suspect;
	}
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	
	public String getHandling() {
		return handling;
	}
	public void setHandling(String handling) {
		this.handling = handling;
	}
	public String getHandlingTime() {
		return handlingTime;
	}
	public void setHandlingTime(String handlingTime) {
		this.handlingTime = handlingTime;
	}
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	@Override
	public String toString() {
		return "CheckGoods [id=" + id + ", goodsName=" + goodsName + ", goodsType="
				+ goodsType + ", quantityUnits=" + quantityUnits + ", quantity=" + quantity + ", units=" + units
				+ ", custody=" + custody + ", cabinetsNumber=" + cabinetsNumber + ", checkPolice=" + checkPolice
				+ ", goodsAdmin=" + goodsAdmin + ", suspect=" + suspect + ", handling=" + handling + ", handlingTime="
				+ handlingTime + ", recordNumber=" + recordNumber + "]";
	}
	
	
	
}