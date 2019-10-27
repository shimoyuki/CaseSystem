package com.sys.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 临时离区实体类
 * @author 佘开 伟
 *
 */
public class TempOut implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String recordNumber;//档案号
	
	private String tempOutTime;//离开时间
	
	private String tempOutCause;//临时离开原因
	
	private String detail;//离区备注
	
	private String returnTime;//返回时间
	
	private List<TempoutPolicemen> tempoutPolicemen;//业务干警签名

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

	public String getTempOutTime() {
		return tempOutTime;
	}

	public void setTempOutTime(String tempOutTime) {
		this.tempOutTime = tempOutTime;
	}

	public String getTempOutCause() {
		return tempOutCause;
	}

	public void setTempOutCause(String tempOutCause) {
		this.tempOutCause = tempOutCause;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	
	public List<TempoutPolicemen> getTempoutPolicemen() {
		return tempoutPolicemen;
	}

	public void setTempoutPolicemen(List<TempoutPolicemen> tempoutPolicemen) {
		this.tempoutPolicemen = tempoutPolicemen;
	}

	@Override
	public String toString() {
		return "TempOut [ID=" + ID + ", recordNumber=" + recordNumber + ", tempOutTime=" + tempOutTime
				+ ", tempOutCause=" + tempOutCause + ", detail=" + detail + ", returnTime=" + returnTime
				+ ", tempoutPolicemen=" + tempoutPolicemen + "]";
	}
	
	
}
