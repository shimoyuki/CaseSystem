package com.sys.entity;

import java.io.Serializable;
/**
 * 案件折线图统计，页面实体类
 * @author zhengxixian
 *
 */
public class CaseStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String itemCaption;//案件类型
	private int caseTypeNum;//对应类型案件的数量。
	public String getItemCaption() {
		return itemCaption;
	}
	public void setItemCaption(String itemCaption) {
		this.itemCaption = itemCaption;
	}
	public int getCaseTypeNum() {
		return caseTypeNum;
	}
	public void setCaseTypeNum(int caseTypeNum) {
		this.caseTypeNum = caseTypeNum;
	}
	@Override
	public String toString() {
		return "CaseStatistics [itemCaption=" + itemCaption + ", caseTypeNum=" + caseTypeNum + "]";
	}
	

}
