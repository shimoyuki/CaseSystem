package com.sys.service.userSet;


import com.sys.entity.PoliceMan;
import com.sys.entity.User;

public interface PersonInforService {
	PoliceMan getpoliceInfor(String ID);
	
	void modifyPoliceInfor(PoliceMan policeMan);
	
	User getUserAndRole(int ID);
	
	boolean  confirmUserPass(String id, String pass);
	
	boolean   modifyUserPass( String id, String pass);
}
