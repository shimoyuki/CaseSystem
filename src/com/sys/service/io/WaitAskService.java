package com.sys.service.io;

import java.util.List;


import com.sys.entity.Infoheader;
import com.sys.entity.WaitAsk;

public interface WaitAskService {
	void entryWaitAsk(WaitAsk waitAsk);
	
	void leaveWaitAsk(WaitAsk waitAsk);
	
	List<Infoheader> searchWaitPerson(String roomCode, String policeStation);

	Infoheader searchPersonEntry(String recordNumber);
}
