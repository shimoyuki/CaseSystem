package com.sys.service.Impl.ioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sys.dao.io.TempOutDao;
import com.sys.entity.TempOut;
import com.sys.entity.TempoutPolicemen;
import com.sys.service.io.TempOutService;
@Service("tempOutService")
public class TempOutServiceImpl implements TempOutService{
	@Autowired
	@Qualifier("tempOutDao")
	private TempOutDao tempOutDao;
	
	@Override
	public void saveTempOut(TempOut tempOut) {
			tempOutDao.saveTempOut(tempOut);
	}

	@Override
	public List<TempOut> getTempOutbyRemb(String recordNumber,int intPage,int  number) {
		PageHelper.startPage(intPage, number);
		return tempOutDao.getTempOutbyRemb(recordNumber);
	}

	@Override
	public int getTempOutbyRembTotal(String recordNumber) {
		// TODO Auto-generated method stub
		return tempOutDao.getTempOutbyRembTotal(recordNumber);
	}

	@Override
	public void saveTempOutPolice(List<TempoutPolicemen> tempoutPolicemen) {
		for(TempoutPolicemen t:tempoutPolicemen){
			tempOutDao.saveTempOutPolice(t);
		}
		
	}

}
