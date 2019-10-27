package com.sys.controller.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.EntryDutypolice;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.InforCollection;
import com.sys.service.io.InforCollectionService;
import com.sys.util.Tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import sun.misc.BASE64Decoder;


/**
 * 信息采集
 * @author 佘开伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/inforCollection")
public class InforCollectionController{
	@Autowired
	@Qualifier("inforCollectionService")
	private InforCollectionService inforCollectionService;
	
	@ResponseBody
	@RequestMapping(value="/saveInforCollection",method=RequestMethod.POST)
	public String  SaveInforCollection(HttpServletRequest req,InforCollection inforCollection) throws IOException{
		
		String header ="data:image/jpeg;base64,";  
		String recordNumber=inforCollection.getRecordNumber();
		// 写入磁盘  
		BASE64Decoder decoder = new BASE64Decoder();  
		try{  
			//存储正面照
			if(inforCollection.getFrontalPicture()!=null&&!inforCollection.getFrontalPicture().trim().equals("")){
				String frontImage = inforCollection.getFrontalPicture().substring(header.length()); 
				byte[] frontdecodedBytes = decoder.decodeBuffer(frontImage);
				String frontPath ="D://images/"+recordNumber+"front.jpg";//正面图片名:档案号+front
				FileOutputStream out = new FileOutputStream(frontPath);  
				out.write(frontdecodedBytes);  
				out.close();  
				inforCollection.setFrontalPicture(frontPath);//数据库保存图片存储路径
			}

			//存储右侧面照
			if(inforCollection.getRightPicture()!=null&&!inforCollection.getRightPicture().trim().equals("")){
				String rightImage = inforCollection.getRightPicture().substring(header.length());
				byte[] rightdecodedBytes = decoder.decodeBuffer(rightImage); 
				String rightPath ="D://images/"+recordNumber+"right.jpg";//右侧面图片名:档案号+right
				FileOutputStream out = new FileOutputStream(rightPath);  
				out.write(rightdecodedBytes);  
				out.close();  
				inforCollection.setRightPicture(rightPath);
			}
			//存储左侧面照
			if(inforCollection.getRightPicture()!=null&&!inforCollection.getRightPicture().trim().equals("")){
				String leftImage = inforCollection.getLeftPicture().substring(header.length());
				byte[] leftdecodedBytes = decoder.decodeBuffer(leftImage);
				String leftPath ="D://images/"+recordNumber+"left.jpg";//右侧面图片名:档案号+left
				FileOutputStream out  = new FileOutputStream(leftPath);  
				out.write(leftdecodedBytes);  
				out.close();  
				inforCollection.setLeftPicture(leftPath);
			}
		}catch(Exception e){    
			e.printStackTrace();  
		}  
		
		System.out.println(inforCollection);
		
		inforCollectionService.saveInforCollection(inforCollection);
		
		return null;
	}
	@ResponseBody
	@RequestMapping(value="/showPoliceSigned",method=RequestMethod.POST)
	public String  showPoliceSigned(HttpServletRequest req) throws IOException{
		String recordNumber=req.getParameter("recordNumber");
		List<EntryPolicemen>  epList=inforCollectionService.getEntryPolice(recordNumber);
		EntryDutypolice edp=inforCollectionService.getEntryDutyPolice(recordNumber);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("police", epList);//对应前台bootstrap的 dataField: "res"
		jsonMap.put("dutyPolice",edp);
		JsonConfig jsonConfig=Tools.getJsonConfig();
		jsonConfig.setExcludes(new String[]{}); 
		JSONObject jsonObject= JSONObject.fromObject(jsonMap,jsonConfig);
		return  jsonObject.toString();
		
	}
}

