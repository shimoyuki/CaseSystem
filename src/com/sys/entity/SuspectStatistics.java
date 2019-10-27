package com.sys.entity;

import java.io.Serializable;
/**
 * 业务统计--历史嫌疑人页面的实体类
 * @author zhengxixian
 *
 */
public class SuspectStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String itemCaption;//入区类型
	private int causeCodeNum;//入区类型对应的数量
	public String getItemCaption() {
		return itemCaption;
	}
	public void setItemCaption(String itemCaption) {
		this.itemCaption = itemCaption;
	}
	public int getCauseCodeNum() {
		return causeCodeNum;
	}
	public void setCauseCodeNum(int causeCodeNum) {
		this.causeCodeNum = causeCodeNum;
	}
	@Override
	public String toString() {
		return "SuspectStatistics [itemCaption=" + itemCaption + ", causeCodeNum=" + causeCodeNum + "]";
	}
	
	

}
