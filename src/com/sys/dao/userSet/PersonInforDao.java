package com.sys.dao.userSet;

import org.apache.ibatis.annotations.Param;

import com.sys.entity.PoliceMan;
import com.sys.entity.User;

public interface PersonInforDao {
	PoliceMan getpoliceInfor(String ID);
	
	void modifyPoliceInfor(PoliceMan policeMan);
	
	User getUserAndRole(int ID);
	
	boolean confirmUserPass(@Param("id") String id,@Param("pass") String pass);
	
	void  modifyUserPass(@Param("id") String id,@Param("pass") String pass);
	
	
}
