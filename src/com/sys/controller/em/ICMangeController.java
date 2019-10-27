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

import com.sys.entity.ICCard;
import com.sys.service.em.ICMangeService;

/**
 * IC������
 * @author zhengxixian
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/iCMange")
public class ICMangeController {
	
	@Autowired
	@Qualifier("iCMangeService")
	private ICMangeService iCMangeService;
	/**
	 * ����IC��
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/saveIC",method=RequestMethod.POST)
	public void saveIC(ICCard iCCard,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			iCMangeService.saveIC(iCCard);			
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");

		}

	}
	/**
	 * �޸�IC����Ϣ
	 * @param iCCard
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/updateIC",method=RequestMethod.POST)
	public void updateIC(ICCard iCCard,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			iCMangeService.updateIC(iCCard);			
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");

		}

	}
	/**
	 * ɾ��IC��
	 * @param iCCard
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/deleteIC",method=RequestMethod.POST)
	public void deleteIC(ICCard iCCard,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
		try {
			iCMangeService.deleteIC(iCCard);			
			pw.write("true");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");

		}

	}
	

}
