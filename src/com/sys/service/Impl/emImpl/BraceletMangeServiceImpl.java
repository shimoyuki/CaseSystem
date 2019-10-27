package com.sys.service.Impl.emImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.em.BraceletMangeDao;
import com.sys.entity.Bracelet;
import com.sys.service.em.BraceletMangeService;
@Service("braceletMangeService")
public class BraceletMangeServiceImpl implements BraceletMangeService {
	
	@Autowired
	@Qualifier("braceletMangeDao")
	private BraceletMangeDao braceletMangeDao;
	
	@Override
	public void saveBracelet(Bracelet bracelet) {
		// TODO Auto-generated method stub
		braceletMangeDao.saveBracelet(bracelet);
	}

	@Override
	public void updateBracelet(Bracelet bracelet) {
		// TODO Auto-generated method stub
		braceletMangeDao.updateBracelet(bracelet);
	}

	@Override
	public void deleteBracelet(Bracelet bracelet) {
		// TODO Auto-generated method stub
		braceletMangeDao.deleteBracelet(bracelet);
	}

}
