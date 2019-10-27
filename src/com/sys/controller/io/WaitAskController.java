package com.sys.controller.io;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

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

import com.sys.entity.Infoheader;
import com.sys.entity.WaitAsk;
import com.sys.service.io.WaitAskService;

import net.sf.json.JSONArray;

/**
 * 候问等待
 * @author 佘开 伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/waitAsk")
public class WaitAskController {
	@Autowired
	@Qualifier("waitAskService")
	private WaitAskService waitAskService;
	
	@ResponseBody
	@RequestMapping(value="/entryWaitAsk",method=RequestMethod.POST)
	public String  entryWaitAsk(HttpServletRequest req,WaitAsk waitAsk,HttpServletResponse res) throws IOException {
		res.setContentType("charset=UTF-8");
		waitAsk.setPoliceStation("1");
		waitAsk.setRecordNumber("CH201705110002");
		waitAskService.entryWaitAsk(waitAsk);
		List<Infoheader> infoheader=waitAskService.searchWaitPerson(waitAsk.getRoomCode(), waitAsk.getPoliceStation());
		res.getWriter().print(JSONArray.fromObject(infoheader).toString());
		return null;
		
	}
	@ResponseBody
	@RequestMapping(value="/leaveWaitAsk",method=RequestMethod.POST)
	public String  leaveWaitAsk(HttpServletRequest req,WaitAsk waitAsk) throws UnsupportedEncodingException {
		waitAskService.leaveWaitAsk(waitAsk);
		return null;
		
	}
	@ResponseBody
	@RequestMapping(value="/searchWaitPerson",method=RequestMethod.POST)
	public String  searchWaitPerson(@RequestParam("roomCode") String roomCode,@RequestParam("policeStation") String policeStation) throws UnsupportedEncodingException {
		List<Infoheader> infoheader=waitAskService.searchWaitPerson(roomCode, policeStation);
		System.out.println(infoheader.get(0).getName());
		return JSONArray.fromObject(infoheader).toString();
		
	}
	/**
	 * 
	 * @param roomCode
	 * @param policeStation
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/searchPersonEntry",method=RequestMethod.POST)
	public String  searchPersonEntry(@RequestParam("recordNumber") String recordNumber,HttpServletResponse res) throws IOException {
		res.setContentType("charset=UTF-8");
		Infoheader infoheader=waitAskService.searchPersonEntry(recordNumber);
		res.getWriter().print(JSONArray.fromObject(infoheader).toString());
		return null;
		
	}
}
