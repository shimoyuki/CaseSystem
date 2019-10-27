package com.sys.service.Impl.sysImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.sys.PersonInitDao;
import com.sys.entity.PoliceMan;
import com.sys.service.sys.PersonInitService;
@Service("personInitService")
public class PersonInitServiceImpl implements PersonInitService {
	@Autowired
	@Qualifier("personInitDao")
	private PersonInitDao personInitDao;
	@Override
	public void addPerson(PoliceMan policeMan) {
		
		personInitDao.addPerson(policeMan);
	}

	@Override
	public void removePerson(PoliceMan policeMan) {
		personInitDao.removePerson(policeMan);
		
	}

	@Override
	public List<PoliceMan> searchPerson(PoliceMan policeMan) {
		List<PoliceMan> policeList=personInitDao.searchPerson(policeMan);
		return policeList;
	}

	@Override
	public void updatePerson(PoliceMan policeMan) {
		personInitDao.updatePerson(policeMan);
		
	}

}
