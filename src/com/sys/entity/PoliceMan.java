package com.sys.entity;

import java.io.Serializable;

/**
 * 警务人员实体类
 * @author 佘开 伟
 *
 */
public class PoliceMan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private String name;//姓名
	
	private String picture;//照片
	
	private String code;//警员编号
	
	private String birthday;//出生日期
	
	private String sex;//性别
	
	private String nation;//民族
	
	private String nativePlace;//籍贯
	
	private String idcode;//身份证
	
	private String currentAddr;//民族
	
	private String department;//部门
	
	private String duty;//职务
	
	private String formation;//编制
	
	private String location;//办公位置
	
	private String phone;//电话
	
	private String policeStation;//所属派出所

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	public String getCurrentAddr() {
		return currentAddr;
	}

	public void setCurrentAddr(String currentAddr) {
		this.currentAddr = currentAddr;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	@Override
	public String toString() {
		return "PoliceMan [ID=" + ID + ", name=" + name + ", picture=" + picture + ", code=" + code + ", birthday="
				+ birthday + ", sex=" + sex + ", nation=" + nation + ", nativePlace=" + nativePlace + ", idcode="
				+ idcode + ", currentAddr=" + currentAddr + ", department=" + department + ", duty=" + duty
				+ ", formation=" + formation + ", location=" + location + ", phone=" + phone + ", policeStation="
				+ policeStation + "]";
	}
	
}
