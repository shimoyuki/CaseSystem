package com.sys.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.sys.entity.PoliceMan;
import com.sys.entity.User;



public interface IUserService {

	boolean checkUser(User user,HttpSession httpSession);
	
	PoliceMan getPoliceInfor(int id);

}
