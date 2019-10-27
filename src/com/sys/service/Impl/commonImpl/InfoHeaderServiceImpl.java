package com.sys.service.Impl.commonImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.apache.commons.codec.binary.Base64;
import com.sys.dao.common.InfoHeaderDao;
import com.sys.entity.CodeItem;
import com.sys.entity.CodeTable;
import com.sys.entity.Infoheader;
import com.sys.service.common.InfoHeaderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("infoHeaderService")
public class InfoHeaderServiceImpl implements InfoHeaderService {
	@Autowired
	@Qualifier("infoHeaderDao")
	private InfoHeaderDao infoHeaderDao;
	@Override
	public	Infoheader searchBaseInfo(String recordNumber) {
		List<Infoheader> infoheader=infoHeaderDao.searchBaseInfo(recordNumber);
		for(Infoheader i:infoheader){
		 //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
			String header ="data:image/jpeg;base64,"; 
			InputStream in = null;
	         byte[] data = null;
	         //读取图片字节数组
	         
             try {
            	//正面
            	if(i.getFrontalView()!=null&&!i.getFrontalView().trim().equals("")){
					in = new FileInputStream(i.getFrontalView());
					data = new byte[in.available()];
			        in.read(data);
			        in.close();
			        i.setFrontalView(header+new String(Base64.encodeBase64(data)));
		        }
		        //右侧
		        if(i.getRightView()!=null&&!i.getRightView().trim().equals("")){
					in = new FileInputStream(i.getRightView());
					data = new byte[in.available()];
			        in.read(data);
			        in.close();
			        i.setRightView(header+new String(Base64.encodeBase64(data)));
		        }
		        //左侧
		        if(i.getLeftView()!=null&&!i.getLeftView().trim().equals("")){
					in = new FileInputStream(i.getLeftView());
					data = new byte[in.available()];
			        in.read(data);
			        in.close();
			        i.setLeftView(header+new String(Base64.encodeBase64(data)));
		        }
		        //证件照
		        if(i.getIDPicture()!=null&&!i.getIDPicture().trim().equals("")){
		        	in = new FileInputStream(i.getIDPicture());
					data = new byte[in.available()];
			        in.read(data);
			        in.close();
			        i.setIDPicture(header+new String(Base64.encodeBase64(data)));
		        }
			} catch (IOException  e) {
				e.printStackTrace();
			}        
	            
			        
		}
		
		if(infoheader.size()!=0){
			return infoheader.get(0);
		}
		return null;
	}
	@Override
	public List<CodeItem> getListByCodeName(String codeName) {
		
		return infoHeaderDao.getListByCodeName(codeName);
	}
	@Override
	public List<CodeTable> getAllField() {
		
		return infoHeaderDao.getAllField();
	}
	@Override
	public List<CodeItem> saveOrUpdateField(CodeItem codeItem) {
		
		if(codeItem.getItemCaption()==null||codeItem.getItemCaption().trim().equals("")||codeItem.getItemCode()==null||codeItem.getItemCode().trim().equals("")){
			//字段或编码为空则不进行对表的操作
		}else{
			if(codeItem.getId()==0){
				infoHeaderDao.addField(codeItem);//id等于0说明是增加数据
			}
			else{
				infoHeaderDao.alterField(codeItem);//id不等于0说明是修改某一个数据
			}
		}

		List<CodeItem> list=infoHeaderDao.getListByCodeName(codeItem.getCodeName());
		
		return list;
	}
	@Override
	public String deleteField(String id,String codeName) {
		infoHeaderDao.deleteField(id);
		List<CodeItem> list=infoHeaderDao.getListByCodeName(codeName);
		JSONArray json = new JSONArray();
		for(CodeItem e:list){
			 JSONObject jo = new JSONObject();
			jo.put("name", e.getItemCaption());
			jo.put("code", e.getItemCode());
			jo.put("id", e.getId());
			json.add(jo);
		}
		return json.toString();
	}
	@Override
	public String getItemCaptionbyCode(String codeName, String itemCode) {
		
		return infoHeaderDao.getItemCaptionbyCode(codeName, itemCode);
	}
	

}
