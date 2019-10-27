package com.sys.entity;

import java.io.Serializable;
/**
 * 嫌疑人信息采集实体类
 * @author 佘开 伟
 *
 */
public class InforCollection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ID;

	private String recordNumber;//档案号 与嫌疑人入区信息登记表关联
	
	private String  photo;//免冠照 （0,1表示）0表示否 1表示是
	
	private String height;//身高（0,1表示）0表示否 1表示是
	
	private String weight;//体重（0,1表示）0表示否 1表示是
	
	private String fingerprint;//指纹（0,1表示）0表示否 1表示是
	
	private String blood;//血样（0,1表示）0表示否 1表示是
	
	private String bodyFeature;//身体特征（0,1表示）0表示否 1表示是
	
	private String handwriting;//笔迹（0,1表示）0表示否 1表示是
	
	private String accent;//口音（0,1表示）0表示否 1表示是
	
	private String DNA;//DNA（0,1表示）0表示否 1表示是
	
	private String phoneSIS;//手机SIS（0,1表示）0表示否 1表示是
	
	private String otherProject;//其他采集项
	
	private String frontalPicture;//正面照
	
	private String rightPicture;//右侧面照
	
	private String leftPicture;//左侧面照

	
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


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getFingerprint() {
		return fingerprint;
	}


	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}


	public String getBlood() {
		return blood;
	}


	public void setBlood(String blood) {
		this.blood = blood;
	}


	public String getBodyFeature() {
		return bodyFeature;
	}


	public void setBodyFeature(String bodyFeature) {
		this.bodyFeature = bodyFeature;
	}


	public String getHandwriting() {
		return handwriting;
	}


	public void setHandwriting(String handwriting) {
		this.handwriting = handwriting;
	}


	public String getAccent() {
		return accent;
	}


	public void setAccent(String accent) {
		this.accent = accent;
	}


	public String getDNA() {
		return DNA;
	}


	public void setDNA(String dNA) {
		DNA = dNA;
	}


	public String getPhoneSIS() {
		return phoneSIS;
	}


	public void setPhoneSIS(String phoneSIS) {
		this.phoneSIS = phoneSIS;
	}


	public String getOtherProject() {
		return otherProject;
	}


	public void setOtherProject(String otherProject) {
		this.otherProject = otherProject;
	}


	public String getFrontalPicture() {
		return frontalPicture;
	}


	public void setFrontalPicture(String frontalPicture) {
		this.frontalPicture = frontalPicture;
	}


	public String getRightPicture() {
		return rightPicture;
	}


	public void setRightPicture(String rightPicture) {
		this.rightPicture = rightPicture;
	}


	public String getLeftPicture() {
		return leftPicture;
	}


	public void setLeftPicture(String leftPicture) {
		this.leftPicture = leftPicture;
	}


	@Override
	public String toString() {
		return "InforCollection [ID=" + ID + ", recordNumber=" + recordNumber + ", photo=" + photo + ", height="
				+ height + ", weight=" + weight + ", fingerprint=" + fingerprint + ", blood=" + blood + ", bodyFeature="
				+ bodyFeature + ", handwriting=" + handwriting + ", accent=" + accent + ", DNA=" + DNA + ", phoneSIS="
				+ phoneSIS + ", otherProject=" + otherProject + ", frontalPicture=" + frontalPicture + ", rightPicture="
				+ rightPicture + ", leftPicture=" + leftPicture + "]";
	}
}
