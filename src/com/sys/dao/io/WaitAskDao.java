package com.sys.dao.io;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.entity.Infoheader;
import com.sys.entity.WaitAsk;

public interface WaitAskDao {
	void entryWaitAsk(WaitAsk waitAsk);
	
	void leaveWaitAsk(WaitAsk waitAsk);
	
	List<Infoheader> searchWaitPerson(@Param(value="roomCode") String roomCode,@Param(value="policeStation") String policeStation);

	List<Infoheader> searchPersonEntry(String recordNumber);
}
