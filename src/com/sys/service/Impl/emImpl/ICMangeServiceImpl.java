package com.sys.service.Impl.emImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.em.ICMangeDao;
import com.sys.entity.ICCard;
import com.sys.service.em.ICMangeService;
@Service("iCMangeService")
public class ICMangeServiceImpl implements ICMangeService {
	
	@Autowired
	@Qualifier("iCMangeDao")
	private ICMangeDao iCMangeDao;

	@Override
	public ICCard saveIC(ICCard iCCard) {
		// TODO Auto-generated method stub
		return iCMangeDao.saveIC(iCCard);
	}

	@Override
	public void updateIC(ICCard iCCard) {
		// TODO Auto-generated method stub
		iCMangeDao.updateIC(iCCard);
	}

	@Override
	public void deleteIC(ICCard iCCard) {
		// TODO Auto-generated method stub
		iCMangeDao.deleteIC(iCCard);
	}
	
	

}
