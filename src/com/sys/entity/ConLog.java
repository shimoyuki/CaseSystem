package com.sys.entity;

import java.io.Serializable;
/**
 * ��½��־ʵ��
 * @author zhengxixian
 *
 */
public class ConLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//
	private int userID;//�û�ID.
	private String userName;//�û���
	private String loginTime;//��¼ʱ��
	private int isSucceed;//�Ƿ��¼�ɹ� 0��ʾ�ǣ�1��ʾ��
	private String IP;//����IP��ַ
	private String logoutTime;//����ʱ��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	
	public int getIsSucceed() {
		return isSucceed;
	}
	public void setIsSucceed(int isSucceed) {
		this.isSucceed = isSucceed;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	@Override
	public String toString() {
		return "ConLog [id=" + id + ", userID=" + userID + ", userName=" + userName + ", loginTime=" + loginTime
				+ ", isSucceed=" + isSucceed + ", IP=" + IP + ", logoutTime=" + logoutTime + "]";
	}
	
	
	

}
