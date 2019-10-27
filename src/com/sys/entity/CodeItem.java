package com.sys.entity;

import java.io.Serializable;
/**
 * 字典汇总表 
 * @author 佘开 伟
 *
 */
public class CodeItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String codeName;//字典表字段名
	
	private String itemCaption;//解释名
	
	private String itemCode;//对应编码
	
	private CodeTable codeTable;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getItemCaption() {
		return itemCaption;
	}

	public void setItemCaption(String itemCaption) {
		this.itemCaption = itemCaption;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public CodeTable getCodeTable() {
		return codeTable;
	}

	public void setCodeTable(CodeTable codeTable) {
		this.codeTable = codeTable;
	}

	@Override
	public String toString() {
		return "CodeItem [id=" + id + ", codeName=" + codeName + ", itemCaption=" + itemCaption + ", itemCode="
				+ itemCode + ", codeTable=" + codeTable + "]";
	}
	
	
}
