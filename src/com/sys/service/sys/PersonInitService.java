package com.sys.service.sys;

import java.util.List;

import com.sys.entity.PoliceMan;

public interface PersonInitService {
	void addPerson(PoliceMan policeMan);
	
	void removePerson(PoliceMan policeMan);
	
	List<PoliceMan> searchPerson(PoliceMan policeMan);
	
	void updatePerson(PoliceMan policeMan);
}
