package com.sys.service.common;


import java.util.List;

import com.sys.entity.CodeItem;
import com.sys.entity.CodeTable;
import com.sys.entity.Infoheader;

public interface InfoHeaderService {
	Infoheader searchBaseInfo(String recordNumber);
	
	List<CodeItem> getListByCodeName(String codeName);
	
	List<CodeTable> getAllField();
	
	List<CodeItem>  saveOrUpdateField(CodeItem codeItem);
	
	String deleteField(String id,String codeName);
	
	String getItemCaptionbyCode(String codeName, String itemCode);
}
