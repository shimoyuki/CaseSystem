package com.sys.entity;

import java.io.Serializable;

/**
 * 派出所实体
 * @author 佘开 伟
 *
 */
public class PoliceStation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String policeStation;//派出所编号
	
	private String name;//名称
	
	private String abbre;//名称缩写
	
	private String addr;//地址
	
	private String postCode;//邮编
	
	private String phone;//联系方式
	
	private String province;//省/直辖市
	
	private String city;//地市名称
	
	private String county;//区县名称
	
	private String station;//派出所定义
	
	private String identification;//派出所标识(如：晋LL-JC-TN)

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbre() {
		return abbre;
	}

	public void setAbbre(String abbre) {
		this.abbre = abbre;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	@Override
	public String toString() {
		return "PoliceStation [policeStation=" + policeStation + ", name=" + name + ", abbre=" + abbre + ", addr="
				+ addr + ", postCode=" + postCode + ", phone=" + phone + ", province=" + province + ", city=" + city
				+ ", county=" + county + ", station=" + station + ", identification=" + identification + "]";
	}
	
}
