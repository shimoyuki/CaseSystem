package com.sys.entity;

import java.io.Serializable;
/**
 * 最终离开办案区实体类
 * @author 佘开 伟
 *
 */
public class FinallyLeave implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String recordNumber;//档案号
	
	private String leaveTime;//离开时间
	
	private String leaveCause;//离开原因编码
	
	private String goodsDispose;//物品返回情况
	
	private String goodsReceiptor;//领取人签名
	
	private String receiptorID;//领取人证件号
	
	private String receiptorTime;//返还时间
	
	private String leaveAdmin;//离区管理员签名
	
	private String adminTime;//离区管理员签名

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

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getLeaveCause() {
		return leaveCause;
	}

	public void setLeaveCause(String leaveCause) {
		this.leaveCause = leaveCause;
	}

	public String getGoodsDispose() {
		return goodsDispose;
	}

	public void setGoodsDispose(String goodsDispose) {
		this.goodsDispose = goodsDispose;
	}

	public String getGoodsReceiptor() {
		return goodsReceiptor;
	}

	public void setGoodsReceiptor(String goodsReceiptor) {
		this.goodsReceiptor = goodsReceiptor;
	}

	public String getReceiptorID() {
		return receiptorID;
	}

	public void setReceiptorID(String receiptorID) {
		this.receiptorID = receiptorID;
	}

	public String getReceiptorTime() {
		return receiptorTime;
	}

	public void setReceiptorTime(String receiptorTime) {
		this.receiptorTime = receiptorTime;
	}

	
	
	public String getLeaveAdmin() {
		return leaveAdmin;
	}

	public void setLeaveAdmin(String leaveAdmin) {
		this.leaveAdmin = leaveAdmin;
	}

	public String getAdminTime() {
		return adminTime;
	}

	public void setAdminTime(String adminTime) {
		this.adminTime = adminTime;
	}

	@Override
	public String toString() {
		return "FinallyLeave [ID=" + ID + ", recordNumber=" + recordNumber + ", leaveTime=" + leaveTime
				+ ", leaveCause=" + leaveCause + ", goodsDispose=" + goodsDispose + ", goodsReceiptor=" + goodsReceiptor
				+ ", receiptorID=" + receiptorID + ", receiptorTime=" + receiptorTime + ", leaveAdmin=" + leaveAdmin
				+ ", adminTime=" + adminTime + "]";
	}
	
	
}
