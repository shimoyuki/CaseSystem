package com.sys.service.Impl.ioImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.io.EntryDao;
import com.sys.entity.Entry;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.IdentityCard;
import com.sys.service.io.EntryService;
@Service("entryService")
public class EntryServiceImpl implements EntryService{
	@Autowired
	@Qualifier("entryDao")
	private EntryDao entryDao;
	
	
	@Override
	public void saveIdentityCard(IdentityCard idcard) {
		entryDao.saveIdentityCard(idcard);
		
	}
	@Override
	public List<IdentityCard> getIdentityCardByID(String IDCode) {
		return entryDao.getIdentityCardByID(IDCode);
	}
	@Override
	public void saveEntry(Entry entry) {
		entryDao.saveEntry(entry);
		
	}
	@Override
	public void saveEntryPolicemen(List<EntryPolicemen> entryPolicemen) {
		for(EntryPolicemen e:entryPolicemen){
			entryDao.saveEntryPolicemen(e);
		}
	}
	@Override
	public String createRecordNumber(String personType,String identification) {
		String type="";
		if(Integer.parseInt(personType)%3==0){//	A类，犯罪嫌疑人类；
			type="A";
		}
		if(Integer.parseInt(personType)%3==1){//	B类，证人、被害人、监护人类；
			type="B";
		}
		if(Integer.parseInt(personType)%3==2){//    B类，证人、被害人、监护人类；
			type="C";
		}
		Date date= new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		String dateNowStr = sdf.format(date); 
		String number=identification+"-"+type+dateNowStr.substring(2);
		System.out.println("档案号查找的条件："+number);
		String recordNumber=entryDao.getNewRecordNumber(number);
		if(recordNumber==null||recordNumber.trim().equals("")){
			recordNumber=number+"001";
		}else{
			recordNumber=recordNumber.substring(0, recordNumber.length()-9)+(Integer.parseInt(recordNumber.substring(recordNumber.length()-9))+1);
		}
		System.out.println("档案号查找结果："+recordNumber);
		return recordNumber;
	}

}
