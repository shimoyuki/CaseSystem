package com.sys.service.Impl.ioImpl;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.sys.dao.io.ArchivesManagementDao;
import com.sys.entity.CurrentSuspectsList;
import com.sys.entity.Infoheader;
import com.sys.service.io.ArchivesManagementService;
@Service("archivesManagementService")
public class ArchivesManagementServiceImpl implements ArchivesManagementService {
	
	@Autowired
	@Qualifier("archivesManagementDao")
	private ArchivesManagementDao archivesManagementDao;

	@Override
	public List<Infoheader> getCurrentSuspects(String curentTime) {
		List<Infoheader> infoheader = archivesManagementDao.getCurrentSuspects(curentTime);
		for(Infoheader i:infoheader){
			 //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
				String header ="data:image/jpeg;base64,"; 
				InputStream in = null;
		         byte[] data = null;
		         //读取图片字节数组
	             try {
	            	 if(i.getFrontalView()!=null&&!i.getFrontalView().trim().equals(""))
	            	//正面
					in = new FileInputStream(i.getFrontalView());
					data = new byte[in.available()];
			        in.read(data);
			        in.close();
			        i.setFrontalView(header+new String(Base64.encodeBase64(data)));
				} catch (IOException  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        
		}
		return infoheader;
	}

	@Override
	public List<CurrentSuspectsList> getCurrentSuspectsList(Map<String, Object> recordFilter,int intPage, int number) {
		PageHelper.startPage(intPage, number);
		return archivesManagementDao.getCurrentSuspectsList(recordFilter);
	}

	@Override
	public int getCurrentSuspectsTotal(Map<String, Object> recordFilter) {
		// TODO Auto-generated method stub
		return archivesManagementDao.getCurrentSuspectsTotal(recordFilter);
	}

	@Override
	public String getCodeByPoliceID(int id) {
		// TODO Auto-generated method stub
		return archivesManagementDao.getCodeByPoliceID(id);
	}

	@Override
	public Model showReport(String recordNumber, Model model) {
		
		Infoheader  infoheader=archivesManagementDao.showEntry(recordNumber);
		//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		String header ="data:image/jpeg;base64,"; 
		InputStream in = null;
         byte[] data = null;
         //读取图片字节数组
         try {
        	//正面
        	if(infoheader.getFrontalView()!=null&&!infoheader.getFrontalView().trim().equals("")){
				in = new FileInputStream(infoheader.getFrontalView());
				data = new byte[in.available()];
		        in.read(data);
		        in.close();
		        infoheader.setFrontalView(header+new String(Base64.encodeBase64(data)));
	        }
	        //右侧
	        if(infoheader.getRightView()!=null&&!infoheader.getRightView().trim().equals("")){
				in = new FileInputStream(infoheader.getRightView());
				data = new byte[in.available()];
		        in.read(data);
		        in.close();
		        infoheader.setRightView(header+new String(Base64.encodeBase64(data)));
	        }
	        //左侧
	        if(infoheader.getLeftView()!=null&&!infoheader.getLeftView().trim().equals("")){
				in = new FileInputStream(infoheader.getLeftView());
				data = new byte[in.available()];
		        in.read(data);
		        in.close();
		        infoheader.setLeftView(header+new String(Base64.encodeBase64(data)));
	        }
	        //证件照
	        if(infoheader.getIDPicture()!=null&&!infoheader.getIDPicture().trim().equals("")){
	        	in = new FileInputStream(infoheader.getIDPicture());
				data = new byte[in.available()];
		        in.read(data);
		        in.close();
		        infoheader.setIDPicture(header+new String(Base64.encodeBase64(data)));
	        }
		} catch (IOException  e) {
			e.printStackTrace();
		}        
		model.addAttribute("entry",infoheader);
		model.addAttribute("entryPolice", archivesManagementDao.showEntryPolice(recordNumber));
		model.addAttribute("entryDutyPolice", archivesManagementDao.showEntryDutyPolice(recordNumber));
		model.addAttribute("personscrutiny", archivesManagementDao.showPersonscrutiny(recordNumber));
		model.addAttribute("scarDetail", archivesManagementDao.showScarDetail(recordNumber));
		model.addAttribute("scarPolice", archivesManagementDao.showScarPolice(recordNumber));
		model.addAttribute("scarParty", archivesManagementDao.showScarParty(recordNumber));
		model.addAttribute("goods", archivesManagementDao.showGoods(recordNumber));
		model.addAttribute("goodsPolice", archivesManagementDao.showGoodsPolice(recordNumber));
		model.addAttribute("goodsDutyPolice", archivesManagementDao.showGoodsDutyPolice(recordNumber));
		model.addAttribute("goodsParty", archivesManagementDao.showGoodsParty(recordNumber));
		model.addAttribute("inforCollection", archivesManagementDao.showInforCollection(recordNumber));
		model.addAttribute("activityrecord", archivesManagementDao.showActivityrecord(recordNumber));
		model.addAttribute("tempOut", archivesManagementDao.showTempOut(recordNumber));
		model.addAttribute("finalLeave", archivesManagementDao.showFinalLeave(recordNumber));
		model.addAttribute("returnGoods", archivesManagementDao.showReturnGoods(recordNumber));
		//计算羁押时间
        try {
        	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		String entryTime=infoheader.getEntryTime();
    		String leaveTime=archivesManagementDao.showFinalLeave(recordNumber).getLeaveTime();
			long hour = (sd.parse(leaveTime).getTime() - sd.parse(entryTime).getTime())/3600000;//小时
			long minute=((sd.parse(leaveTime).getTime() - sd.parse(entryTime).getTime())%3600000)/60000;//分钟
			long seconds=((sd.parse(leaveTime).getTime() - sd.parse(entryTime).getTime())%60000)/1000;//秒
			String detentionTime=""+hour+"小时"+minute+"分"+seconds+"秒";
			model.addAttribute("detentionTime", detentionTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return model;
	}
	

}
