package com.sys.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.entity.CodeItem;
import com.sys.entity.CodeTable;
import com.sys.entity.Infoheader;

public interface InfoHeaderDao {
	List<Infoheader> searchBaseInfo(String recordNumber);
	
	List<CodeItem> getListByCodeName(String codeName);
	
	List<CodeTable> getAllField();
	
	void addField(CodeItem codeItem);
	
	void alterField(CodeItem codeItem);
	
	void deleteField(String id);
	
	String getItemCaptionbyCode(@Param("codeName") String codeName,@Param("itemCode") String itemCode);
	
}
