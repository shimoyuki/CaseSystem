package com.sys.controller.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.TempOut;
import com.sys.entity.TempoutPolicemen;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.InforCollection;
import com.sys.entity.TempOut;
import com.sys.service.io.TempOutService;
import com.sys.util.Tools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 临时出区
 * @author 佘开伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/tempOut")
public class TempOutController {
	@Autowired
	@Qualifier("tempOutService")
	private TempOutService tempOutService;

	@ResponseBody
	@RequestMapping(value="/saveTempOut",method=RequestMethod.POST)
	public String  saveTempOut(HttpServletRequest req,TempOut tempout,TempoutPolicemen tp) throws IOException{
		String[] nameList=tp.getTempoutPolice().split(",");//对入区登记业务签名的处理
		String[] codeList=tp.getCode().split(",");
		List<TempoutPolicemen> tpList=new ArrayList<TempoutPolicemen>();
		tempOutService.saveTempOut(tempout);
		for(int i=0;i<nameList.length;i++){
			TempoutPolicemen ep=new TempoutPolicemen();
			ep.setTemID(tempout.getID());
			ep.setCode(codeList[i]);
			ep.setTempoutPolice(nameList[i]);
			tpList.add(ep);
		}
		tempOutService.saveTempOutPolice(tpList);
		return null;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/getTempOutbyRemb",method=RequestMethod.POST)
	public String getTempOutbyRemb(HttpServletRequest req,@RequestParam("pageSize") int pageSize,@RequestParam("pageNumber") int pageNumber) throws IOException{
		String recordNumber=req.getParameter("recordNumber");
		int intPage = pageNumber == 0 ? 1:pageNumber; 
		int number = pageSize == 0 ? 10:pageSize;
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<TempOut> tempOutList=tempOutService.getTempOutbyRemb(recordNumber,intPage,number);
		int total=tempOutService.getTempOutbyRembTotal(recordNumber);
		
		for(TempOut t:tempOutList){
			List<TempoutPolicemen> tp=t.getTempoutPolicemen();
			List<String> sb = new ArrayList<>();
			for(TempoutPolicemen e:tp){
				sb.add(e.getTempoutPolice());
			}
			t.setDetail(sb.toString());
		}
		jsonMap.put("res", tempOutList);//对应前台bootstrap的 dataField: "res"
		jsonMap.put("total",total);
		JsonConfig jsonConfig=Tools.getJsonConfig();
		jsonConfig.setExcludes(new String[]{}); 
		JSONObject jsonObject= JSONObject.fromObject(jsonMap,jsonConfig);
		return jsonObject.toString();
	}
	
}
