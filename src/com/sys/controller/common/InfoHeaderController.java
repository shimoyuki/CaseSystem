package com.sys.controller.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.CodeItem;
import com.sys.entity.CodeTable;
import com.sys.entity.Infoheader;
import com.sys.service.common.InfoHeaderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Scope("prototype")
@Controller
@RequestMapping("/infoHeader")
public class InfoHeaderController {
	@Autowired
	@Qualifier("infoHeaderService")
	private InfoHeaderService infoHeaderService;
	
	
	@ResponseBody
	@RequestMapping(value="/searchBaseInfo",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String  searchBaseInfo(HttpServletRequest res) throws IOException{
		
		String recognition=res.getParameter("recognition");
		System.out.println("手环识别码："+recognition);
		Infoheader infoheader=infoHeaderService.searchBaseInfo(recognition);
		return JSONObject.fromObject(infoheader).toString();
	}
	//获取字典表公共方法
	@ResponseBody
	@RequestMapping(value="/getListByCodeName",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String  getListByCodeName(HttpServletRequest res,HttpServletResponse req) throws IOException{
		String codeName=res.getParameter("codeName");//字段名
		List<CodeItem> codeItem=infoHeaderService.getListByCodeName(codeName);
		JSONArray json = new JSONArray();
		for(CodeItem e:codeItem){
			 JSONObject jo = new JSONObject();
			jo.put("name", e.getItemCaption());
			jo.put("code", e.getItemCode());
			jo.put("id", e.getId());
			json.add(jo);
		}
		return json.toString();
	}
	//获取字段表所有字段
	@ResponseBody
	@RequestMapping(value="/getAllField",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String  getAllField(HttpServletResponse req) throws IOException{
		List<CodeTable> codeTable=infoHeaderService.getAllField();
		return JSONArray.fromObject(codeTable).toString();
	}
	//增加或者更改字段表
	@ResponseBody
	@RequestMapping(value="/saveOrUpdateField",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String  saveOrUpdateField(HttpServletResponse req,CodeItem codeItem) throws IOException{
		System.out.println("codeItem:"+codeItem);
		List<CodeItem> list=infoHeaderService.saveOrUpdateField(codeItem);
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
	//删除字段
	@ResponseBody
	@RequestMapping(value="/deleteField",method=RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
	public String  deleteField(HttpServletResponse req,@RequestParam("id") String id,@RequestParam("codeName") String codeName) throws IOException{
		return infoHeaderService.deleteField(id, codeName);
	}
	
}
