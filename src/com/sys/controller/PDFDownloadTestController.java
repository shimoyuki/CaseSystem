package com.sys.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sys.util.PDFUtil;

@Scope("prototype")
@Controller
@RequestMapping("/pdf")
public class PDFDownloadTestController {

	@RequestMapping("test")
	public String showTestPage() {
		return "pdfTest";
	}
	
	@RequestMapping("download")
	public void download(HttpServletResponse response) {
		//System.out.println(httpSession.getServletContext().getRealPath("/"));
		//System.out.println( PDFDownloadTestController.class.getClassLoader().getResource("/").getPath());
		PDFUtil pu = new PDFUtil(PDFDownloadTestController.class.getClassLoader().getResource("/").getPath().replace("WEB-INF/classes/", ""));
		pu.testCase();//案件报告
		pu.testArchive();//档案报告
		pu.testLeave();//离区报告
		
		StringBuffer xmlContent = new StringBuffer();
		/*SimpleDateFormat sdfStart = new SimpleDateFormat("yyyy-MM-dd HH:mm"),
				sdfEnd = new SimpleDateFormat("HH:mm"),
				sdfSlot = new SimpleDateFormat("HH:mm:ss");*/
		
		xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		xmlContent.append("<ItemListReport>");
		xmlContent.append("	<RegisterHeader>");
		xmlContent.append("		<Icon>"+pu.getPath()+"images/gh-ico.png</Icon>");
		xmlContent.append("		<Title>入区登记</Title>");
		xmlContent.append("		<Time>2017年07月20日</Time>");
		xmlContent.append("		<Code>20170520A</Code>");
		xmlContent.append("		<QRCode>"+pu.getPath()+"images/ewm.jpg</QRCode>");
		xmlContent.append("	</RegisterHeader>");
		
		xmlContent.append("	<RegisterBody>");
		xmlContent.append("		<IdentityTable>");
		xmlContent.append("		    <Photo>"+pu.getPath()+"images/sfzz.jpg</Photo>");
		xmlContent.append("		    <PhotoLeft>"+pu.getPath()+"images/pic-1.jpg</PhotoLeft>");
		xmlContent.append("		    <PhotoFront>"+pu.getPath()+"images/pic-2.jpg</PhotoFront>");
		xmlContent.append("		    <PhotoRight>"+pu.getPath()+"images/pic-3.jpg</PhotoRight>");
		xmlContent.append("		</IdentityTable>");
		xmlContent.append("		<RegisterTable>");
		xmlContent.append("		    <Name>Name</Name>");
		xmlContent.append("		    <Gender>Gender</Gender>");
		xmlContent.append("		    <Nation>Nation</Nation>");
		xmlContent.append("		    <Lang>Lang</Lang>");
		xmlContent.append("		    <Birth>Birth</Birth>");
		xmlContent.append("		    <House>House</House>");
		xmlContent.append("		    <Contact>Contact</Contact>");
		xmlContent.append("		    <Addr>Addr</Addr>");
		xmlContent.append("		    <Brace>Brace</Brace>");
		xmlContent.append("		    <Identity>Identity</Identity>");
		xmlContent.append("		    <Time>Time</Time>");
		xmlContent.append("		    <Reason>Reason</Reason>");
		xmlContent.append("		    <Remark>Remark</Remark>");
		xmlContent.append("		</RegisterTable>");
		xmlContent.append("		<SignTable>");
		xmlContent.append("		</SignTable>");
		xmlContent.append("	</RegisterBody>");
		
		xmlContent.append("	<SecurityHeader>");
		xmlContent.append("		<Title>人身安全检查</Title>");
		xmlContent.append("		<Drink>Drink</Drink>");
		xmlContent.append("		<Disease>Disease</Disease>");
		xmlContent.append("		<Symptom>Symptom</Symptom>");
		xmlContent.append("	</SecurityHeader>");
		
		xmlContent.append("	<SecurityBody>");
		xmlContent.append("		<SecurityTable>");
		xmlContent.append("		    <Image>"+pu.getPath()+"images/rtt.jpg</Image>");
		xmlContent.append("		    <SecurityRow>");
		xmlContent.append("		        <Number>Number1</Number>");
		xmlContent.append("		        <Explain>Explain1</Explain>");
		xmlContent.append("		        <Description>Description1</Description>");
		xmlContent.append("		        <Photo>Photo1</Photo>");
		xmlContent.append("		    </SecurityRow>");
		xmlContent.append("		    <SecurityRow>");
		xmlContent.append("		        <Number>Number2</Number>");
		xmlContent.append("		        <Explain>Explain2</Explain>");
		xmlContent.append("		        <Description>Description2</Description>");
		xmlContent.append("		        <Photo>Photo2</Photo>");
		xmlContent.append("		    </SecurityRow>");
		xmlContent.append("		    <PoliceSign>PoliceSign</PoliceSign>");
		xmlContent.append("		    <GuardianSign>GuardianSign</GuardianSign>");
		xmlContent.append("		</SecurityTable>");
		xmlContent.append("		<FinanceTable>");
		xmlContent.append("		    <FinanceRow>");
		xmlContent.append("		        <Number>Number1</Number>");
		xmlContent.append("		        <Name>Name1</Name>");
		xmlContent.append("		        <Feature>Feature1</Feature>");
		xmlContent.append("		        <Amount>Amount1</Amount>");
		xmlContent.append("		        <Classify>Classify1</Classify>");
		xmlContent.append("		        <Method>Method1</Method>");
		xmlContent.append("		        <Position>Position1</Position>");
		xmlContent.append("		        <Time>Time1</Time>");
		xmlContent.append("		    </FinanceRow>");
		xmlContent.append("		    <InvolveSign>InvolveSign</InvolveSign>");
		xmlContent.append("		</FinanceTable>");
		xmlContent.append("		<SignTable>");
		xmlContent.append("		</SignTable>");
		xmlContent.append("	</SecurityBody>");
		
		//Calendar calendar = Calendar.getInstance();
		xmlContent.append("	<InformationBody>");
		xmlContent.append("		<InformationTable>");
		xmlContent.append("		<Title>信息采集</Title>");
		//xmlContent.append("		<StartTime>"+sdfStart.format(calendar.getTime())+"</StartTime>");
		//calendar.add(Calendar.MINUTE, 30);
		//xmlContent.append("		<EndTime>"+sdfEnd.format(calendar.getTime())+"</EndTime>");
		xmlContent.append("		<StartTime>StartTime</StartTime>");
		xmlContent.append("		<EndTime>EndTime</EndTime>");
		xmlContent.append("		<Integrity>Integrity</Integrity>");
		xmlContent.append("		    <InformationRow>");
		xmlContent.append("	        	<Number>Number</Number>");
		xmlContent.append("		        <Project>Project</Project>");
		xmlContent.append("	        	<Content>Content</Content>");
		xmlContent.append("	        	<Time>Time</Time>");
		xmlContent.append("		    </InformationRow>");
		xmlContent.append("		</InformationTable>");
		xmlContent.append("	</InformationBody>");
		
		/*calendar = Calendar.getInstance();
		Date dateStart = calendar.getTime(), dateEnd, dateSlot;
		calendar.add(Calendar.SECOND, 1000000);
		dateEnd = calendar.getTime();
		dateSlot = new Date(dateEnd.getTime() - dateStart.getTime());*/
		xmlContent.append("	<ActivityBody>");
		xmlContent.append("		<ActivityTable>");
		xmlContent.append("		<Title>入区活动记录</Title>");
		xmlContent.append("		<Name>Name</Name>");
		//xmlContent.append("		<Time>"+sdfSlot.format(dateSlot)+"</Time>");
		xmlContent.append("		<Time>Time</Time>");
		xmlContent.append("		    <ActivityRow>");
		xmlContent.append("	        	<Number>Number</Number>");
		xmlContent.append("		        <Project>Project</Project>");
		xmlContent.append("	        	<Room>Room</Room>");
		xmlContent.append("	        	<StartTime>StartTime</StartTime>");
		xmlContent.append("	        	<EndTime>EndTime</EndTime>");
		xmlContent.append("	        	<Record>Record</Record>");
		xmlContent.append("	        	<Remark>Remark</Remark>");
		xmlContent.append("		    </ActivityRow>");
		xmlContent.append("		</ActivityTable>");
		xmlContent.append("	</ActivityBody>");
		
		xmlContent.append("	<LeaveBody>");
		xmlContent.append("		<TemporaryTable>");
		xmlContent.append("		<Title>临时离区记录</Title>");
		xmlContent.append("		    <TemporaryRow>");
		xmlContent.append("	        	<Number>Number</Number>");
		xmlContent.append("		        <Name>Name</Name>");
		xmlContent.append("	        	<ID>ID</ID>");
		xmlContent.append("	        	<LeaveTime>LeaveTime</LeaveTime>");
		xmlContent.append("	        	<ReturnTime>ReturnTime</ReturnTime>");
		xmlContent.append("	        	<Reason>Reason</Reason>");
		xmlContent.append("	        	<Police>Police</Police>");
		xmlContent.append("		    </TemporaryRow>");
		xmlContent.append("		    <ChargeSign>ChargeSign</ChargeSign>");
		xmlContent.append("		</TemporaryTable>");
		xmlContent.append("		<FinalTable>");
		xmlContent.append("		<LeaveTime>LeaveTime</LeaveTime>");
		xmlContent.append("		<DetainTime>DetainTime</DetainTime>");
		xmlContent.append("		<Reason>Reason</Reason>");
		xmlContent.append("		<Return>Return</Return>");
		xmlContent.append("		<Code>Code</Code>");
		xmlContent.append("		<Cabinet>Cabinet</Cabinet>");
		xmlContent.append("		    <FinalRow>");
		xmlContent.append("	        	<Number>Number</Number>");
		xmlContent.append("		        <Name>Name</Name>");
		xmlContent.append("	        	<Feature>Feature</Feature>");
		xmlContent.append("	        	<Amount>Amount</Amount>");
		xmlContent.append("	        	<Classify>Classify</Classify>");
		xmlContent.append("	        	<Method>Method</Method>");
		xmlContent.append("	        	<Situation>Situation</Situation>");
		xmlContent.append("	        	<RuturnTime>RuturnTime</RuturnTime>");
		xmlContent.append("		    </FinalRow>");
		xmlContent.append("		<Sign>Sign</Sign>");
		xmlContent.append("		<Identity>Identity</Identity>");
		xmlContent.append("		<Time>Time</Time>");
		xmlContent.append("		</FinalTable>");
		xmlContent.append("		<SignTable>");
		xmlContent.append("		</SignTable>");
		xmlContent.append("	</LeaveBody>");
		
		xmlContent.append("	<ReportFooter>");
		xmlContent.append("	</ReportFooter>");
		xmlContent.append("</ItemListReport>");
		
		String fileName = "ArchiveReport.pdf";
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("multipart/form-data");
		 OutputStream os = null;
		try {
			response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("gbk"),"iso-8859-1"));
			 os = response.getOutputStream();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 pu.writePdf(xmlContent, "report/ArchiveReport.xsl", os);
	}
}
