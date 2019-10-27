package com.sys.controller.em;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sys.annotation.SystemControllerLog;
import com.sys.entity.Bracelet;
import com.sys.service.em.BraceletMangeService;

@Scope("prototype")
@Controller
@RequestMapping("/braceletMange")
public class BraceletMangeController {
	
	@Autowired
	@Qualifier("braceletMangeService")
	private BraceletMangeService braceletMangeService;
	
	/**
	 * �����ֻ�
	 * @param bracelet
	 * @param response
	 * @throws IOException
	 */
	
	//�˴�Ϊ��¼AOP����Controller��¼�û�����    
	@RequestMapping(value="/saveBracelet",method=RequestMethod.POST)
	@SystemControllerLog(description = "�����ֻ�") 
	public void saveBracelet(Bracelet bracelet,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			braceletMangeService.saveBracelet(bracelet);			
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");

		}

	}
	/**
	 * �޸��ֻ�
	 * @param bracelet
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/updateBracelet",method=RequestMethod.POST)
	public void updateBracelet(Bracelet bracelet,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			braceletMangeService.updateBracelet(bracelet);			
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");

		}

	}
	/**
	 * ɾ���ֻ�
	 * @param bracelet
	 * @param response
	 * @throws IOException
	 */
	
	@RequestMapping(value="/deleteBracelet",method=RequestMethod.POST)
	public void deleteBracelet(Bracelet bracelet,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			braceletMangeService.deleteBracelet(bracelet);			
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");

		}

	}
	

}
