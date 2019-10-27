package com.sys.service.io;

import java.util.List;

import com.sys.entity.TempOut;
import com.sys.entity.TempoutPolicemen;

public interface TempOutService {
	void saveTempOut(TempOut tempOut);
	
	List<TempOut> getTempOutbyRemb(String recordNumber,int intPage,int  number);
	
	int getTempOutbyRembTotal(String recordNumber);
	
	void saveTempOutPolice(List<TempoutPolicemen> tempoutPolicemen);
}
