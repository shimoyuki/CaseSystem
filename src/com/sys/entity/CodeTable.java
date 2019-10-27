package com.sys.entity;

import java.io.Serializable;
/**
 * 字典表字段中英参照
 * @author 佘开 伟
 *
 */
public class CodeTable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codeName;//英文字段名
	
	private String caption;//中文字段名

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	public String toString() {
		return "CodeTable [codeName=" + codeName + ", caption=" + caption + "]";
	}
	
}
