package com.sys.entity;

import java.io.Serializable;
/**
 * 登陆日志实体
 * @author zhengxixian
 *
 */
public class ConLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//
	private int userID;//用户ID.
	private String userName;//用户名
	private String loginTime;//登录时间
	private int isSucceed;//是否登录成功 0表示是，1表示否
	private String IP;//电脑IP地址
	private String logoutTime;//下线时间
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
