package com.sys.service.Impl.emImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.em.AccessCardDao;
import com.sys.entity.AccessCard;
import com.sys.service.em.AccessCardService;
@Service("accessCardService")
public class AccessCardServiceImpl implements AccessCardService {
	@Autowired
	@Qualifier("accessCardDao")
	private AccessCardDao accessCardDao;
	@Override 
	public void addAccessCard(AccessCard accessCard) {
		accessCardDao.addAccessCard(accessCard);
	}

	@Override
	public void updateAccessCard(AccessCard accessCard) {
		accessCardDao.updateAccessCard(accessCard);
		
	}

	@Override
	public void deleteAccessCard(AccessCard accessCard) {
		accessCardDao.deleteAccessCard(accessCard);
		
	}
	
}
