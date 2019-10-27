package com.sys.dao.io;

import java.util.List;

import com.sys.entity.TempOut;
import com.sys.entity.TempoutPolicemen;

public interface TempOutDao {
	void saveTempOut(TempOut tempOut);
	
	List<TempOut> getTempOutbyRemb(String recordNumber);
	
	int getTempOutbyRembTotal(String recordNumber);
	
	void saveTempOutPolice(TempoutPolicemen tempoutPolicemen);
}
