package com.sys.service.Impl.emImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.em.IdreaderDao;
import com.sys.entity.Idreader;
import com.sys.service.em.Idreaderservice;
@Service("idreaderService")
public class IdreaderServiceImpl implements Idreaderservice {
	@Autowired
	@Qualifier("idreaderDao")
	private IdreaderDao idreaderDao;
	@Override
	public void addIdreader(Idreader idreader) {
		idreaderDao.addIdreader(idreader);
		
	}

	@Override
	public void updateIdreader(Idreader idreader) {
		idreaderDao.updateIdreader(idreader);
		
	}

	@Override
	public void deleteIdreader(Idreader idreader) {
		idreaderDao.deleteIdreader(idreader);
		
	}

}
