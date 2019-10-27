package com.sys.service.Impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.sys.dao.IUserDao;
import com.sys.entity.Menu;
import com.sys.entity.PoliceMan;
import com.sys.entity.PoliceStation;
import com.sys.entity.Role;
import com.sys.entity.User;
import com.sys.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Override
	public boolean checkUser(User user,HttpSession httpSession) {
		User userNew = userDao.getUserByName(user);
		if (userNew!=null) {
			PoliceStation ps=userDao.getPoliceStation(userNew.getId());
			httpSession.setAttribute("policeStation", ps);
			httpSession.setAttribute("user",userNew);
			
			List<String> UserMenu = new ArrayList<String>();
			for (Role role : userNew.getRole()) {
				for (Menu menu : role.getMenu()) {
					UserMenu.add(""+menu.getId());
				}
			}
			httpSession.setAttribute("menu",UserMenu);//拥有的权限
			List<String> allMenu = userDao.getAllMenu();
			for (String s:UserMenu) {
				if(allMenu.contains(s)){
					allMenu.remove(s);
				}	
			}
			
			httpSession.setAttribute("disabledMenu", allMenu);//没有的权限
			// 设置session有效时间
			httpSession.setMaxInactiveInterval(3600);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public PoliceMan getPoliceInfor(int id) {
		List<PoliceMan> pl=userDao.getPoliceInfor(id);
		String header ="data:image/jpeg;base64,"; 
		InputStream in = null;
         byte[] data = null;
         PoliceMan pm;
         if(pl!=null){
        	 pm=pl.get(0);
 				try {
 					if(pm.getPicture()!=null&&!pm.getPicture().trim().equals("")){
						in = new FileInputStream(pm.getPicture());
						data = new byte[in.available()];
		 		        in.read(data);
		 		        in.close();
		 		        pm.setPicture(header+new String(Base64.encodeBase64(data)));
 					 }
				} catch (IOException   e) {
					e.printStackTrace();
				}
 				return pm;	
         }
         
		return null;
	}

}
