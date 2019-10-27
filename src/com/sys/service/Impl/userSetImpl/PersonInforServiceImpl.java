package com.sys.service.Impl.userSetImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.userSet.PersonInforDao;
import com.sys.entity.PoliceMan;
import com.sys.entity.User;
import com.sys.service.userSet.PersonInforService;
@Service("personInforService")
public class PersonInforServiceImpl implements PersonInforService {
	@Autowired
	@Qualifier("personInforDao")
	private PersonInforDao personInforDao;

	@Override
	public PoliceMan getpoliceInfor(String ID)  {
		PoliceMan pm=personInforDao.getpoliceInfor(ID);
		try {
			if(pm.getPicture()!=null&&!pm.getPicture().trim().equals("")){
				String header ="data:image/jpeg;base64,"; 
				InputStream in = null;
		         byte[] data = null;
				in = new FileInputStream(pm.getPicture());
				data = new byte[in.available()];
		        in.read(data);
		        in.close();
		        pm.setPicture(header+new String(Base64.encodeBase64(data)));
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pm;
	}

	@Override
	public void modifyPoliceInfor(PoliceMan policeMan) {
		personInforDao.modifyPoliceInfor(policeMan);
		
	}

	@Override
	public User getUserAndRole(int ID) {
		// TODO Auto-generated method stub
		return personInforDao.getUserAndRole(ID);
	}

	@Override
	public boolean confirmUserPass(String id, String pass) {
		
		return personInforDao.confirmUserPass(id, pass);
	}

	@Override
	public boolean modifyUserPass(String id, String pass) {
		try{
			personInforDao.modifyUserPass(id, pass);
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}
}
