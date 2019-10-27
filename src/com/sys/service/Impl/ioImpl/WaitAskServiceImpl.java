package com.sys.service.Impl.ioImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.io.WaitAskDao;
import com.sys.entity.Infoheader;
import com.sys.entity.WaitAsk;
import com.sys.service.io.WaitAskService;
@Service("waitAskService")
public class WaitAskServiceImpl implements WaitAskService {
	@Autowired
	@Qualifier("waitAskDao")
	private WaitAskDao waitAskDao ;
	@Override
	public void entryWaitAsk(WaitAsk waitAsk) {
		waitAskDao.entryWaitAsk(waitAsk);
		
	}

	@Override
	public void leaveWaitAsk(WaitAsk waitAsk) {
		waitAskDao.leaveWaitAsk(waitAsk);
		
	}

	@Override
	public List<Infoheader> searchWaitPerson(String roomCode, String policeStation) {
		List<Infoheader>infoheader=waitAskDao.searchWaitPerson(roomCode, policeStation);
		for(Infoheader i:infoheader){

			 //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
				String header ="data:image/jpeg;base64,"; 
				InputStream in = null;
		         byte[] data = null;
		         //读取图片字节数组
	             try {
	            	 if(i.getIDPicture()!=null&&!i.getIDPicture().trim().equals("")){
	            		//正面
	 					in = new FileInputStream(i.getIDPicture());
	 					data = new byte[in.available()];
	 			        in.read(data);
	 			        in.close();
	 			        i.setIDPicture(header+new String(Base64.encodeBase64(data)));
	            	 }
				} catch (IOException  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        
		}
		return infoheader;
	}

	@Override
	public Infoheader searchPersonEntry(String recordNumber) {
		List<Infoheader>infoheader=waitAskDao.searchPersonEntry(recordNumber);
		for(Infoheader i:infoheader){
			 //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
				String header ="data:image/jpeg;base64,"; 
				InputStream in = null;
		         byte[] data = null;
		         //读取图片字节数组
		         
	             try {
	            	//正面
					in = new FileInputStream(i.getFrontalView());
					data = new byte[in.available()];
			        in.read(data);
			        in.close();
			        i.setFrontalView(header+new String(Base64.encodeBase64(data)));
			        //右侧
					in = new FileInputStream(i.getRightView());
					data = new byte[in.available()];
			        in.read(data);
			        in.close();
			        i.setRightView(header+new String(Base64.encodeBase64(data)));
			        //左侧
					in = new FileInputStream(i.getLeftView());
					data = new byte[in.available()];
			        in.read(data);
			        in.close();
			        i.setLeftView(header+new String(Base64.encodeBase64(data)));
				} catch (IOException  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        
		            
				        
			}
			
			if(infoheader.size()!=0){
				return infoheader.get(0);
			}
			return null;
	}
	

}
