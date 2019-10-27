package com.sys.controller.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sys.entity.Entry;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.IdentityCard;
import com.sys.entity.PoliceStation;
import com.sys.service.io.EntryService;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;
/**
 * 身份证信息读取与入区登记
 * @author 佘开 伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/entry")
public class EntryController{
	
	@Autowired
	@Qualifier("entryService")
	private EntryService entryService;
	/**
	 *入区信息登记 以路径方式保存图片
	 * @param req
	 * @param res
	 * @return
	 * @throws IOException
	 */
	@Transactional
	@ResponseBody
	@RequestMapping(value="/saveEntry",method=RequestMethod.POST)
	public String  saveEntry(HttpServletRequest req,Entry entry,IdentityCard identityCard,EntryPolicemen entryPolicemen) throws IOException{

		// 只允许jpg  
		String header ="data:image/jpeg;base64,";  
		String recordNumber=entry.getRecordNumber();
		// 去掉头部  
		String frontImage = entry.getFrontalView().substring(header.length());  
		String rightImage = entry.getRightView().substring(header.length());
		String leftImage = entry.getLeftView().substring(header.length());
		// 写入磁盘  
		
		BASE64Decoder decoder = new BASE64Decoder();  
		try{  
			byte[] rightdecodedBytes = decoder.decodeBuffer(rightImage); 
			byte[] frontdecodedBytes = decoder.decodeBuffer(frontImage);
			byte[] leftdecodedBytes = decoder.decodeBuffer(leftImage);
			byte[] IDPictureBytes=decoder.decodeBuffer(identityCard.getIDPicture());
			System.out.println("身份证照的byte:"+IDPictureBytes);
			String frontPath ="D://images/"+recordNumber+"front.jpg";//正面图片名:档案号+front
			String rightPath ="D://images/"+recordNumber+"right.jpg";//右侧面图片名:档案号+right
			String leftPath ="D://images/"+recordNumber+"left.jpg";//右侧面图片名:档案号+left
			String IDPicturePath="D://images/"+identityCard.getIDCode()+".jpg";
			//存储正面照
			FileOutputStream out = new FileOutputStream(frontPath);  
			out.write(frontdecodedBytes);  
			out.close();  
			entry.setFrontalView(frontPath);//数据库保存图片存储路径
			//存储右侧面照
			out = new FileOutputStream(rightPath);  
			out.write(rightdecodedBytes);  
			out.close();  
			entry.setRightView(rightPath);
			//存储左侧面照
			out = new FileOutputStream(leftPath);  
			out.write(leftdecodedBytes);  
			out.close();  
			entry.setLeftView(leftPath);
			//存储身份证头像照
			out = new FileOutputStream(IDPicturePath);  
			out.write(IDPictureBytes);  
			out.close();  
			identityCard.setIDPicture(IDPicturePath);
		}catch(Exception e){    
			e.printStackTrace();  
		}  
		System.out.println("entry:"+entry);
		/*identityCard.setIDCode(entry.getIDNumber());
		entry.setIDCode(entry.getIDNumber());*/
		
		String[] nameList=entryPolicemen.getEntryPolice().split(",");//对入区登记业务签名的处理
		String[] codeList=entryPolicemen.getCode().split(",");
		List<EntryPolicemen> entryPolicemenList=new ArrayList<EntryPolicemen>();
		for(int i=0;i<nameList.length;i++){
			EntryPolicemen ep=new EntryPolicemen();
			ep.setRecordNumber(recordNumber);
			ep.setCode(codeList[i]);
			ep.setEntryPolice(nameList[i]);
			entryPolicemenList.add(ep);
		}
		
		 entryService.saveIdentityCard(identityCard);
		 entryService.saveEntry(entry);
		 entryService.saveEntryPolicemen(entryPolicemenList);
		
		return null;
		  
	}  
	
	
	@ResponseBody
	@RequestMapping(value="/createRecordNumber",method=RequestMethod.POST)
	public void  createRecordNumber(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		res.setContentType("text/html;   charset=utf-8");   
		PrintWriter pw=res.getWriter();
		String personType=req.getParameter("personType");//人员入区身份
		PoliceStation PoliceStation=(PoliceStation)req.getSession().getAttribute("policeStation");
		String identification=PoliceStation.getIdentification();//派出所标识
		String recordNumber=entryService.createRecordNumber(personType,identification);
		pw.write(recordNumber);;
		
	}
	

	
	
	
}
