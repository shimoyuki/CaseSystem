package com.sys.controller.io;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.entity.ActivityRecord;
import com.sys.service.io.ActivityRecordService;

import net.sf.json.JSONArray;

/**
 * 嫌疑人活动记录登记表
 * @author 佘开 伟
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/activityRecord")
public class ActivityRecordController {
	@Autowired
	@Qualifier("activityRecordService")
	private ActivityRecordService activityRecordService;
	
	@ResponseBody
	@RequestMapping(value="/saveActivityRecord",method=RequestMethod.POST)
	public String  saveActivityRecord(HttpServletRequest req,HttpServletResponse res) throws UnsupportedEncodingException {
		String recordNumber=req.getParameter("recordNumber");
		//提取表格里面要用的东西
		String json=new String(req.getParameter("dataJson").getBytes("ISO-8859-1"),"UTF-8"); 
		if(req.getParameter("dataJson")==null||req.getParameter("dataJson").isEmpty()){
			return null;
		}
		JSONArray array = JSONArray.fromObject(json); 
		 List<ActivityRecord> activityRecord = new ArrayList<ActivityRecord>();
		    for (int i = 0; i < array.size(); i++) {  
		    	ActivityRecord a=new ActivityRecord();
				Map jsonObject = array.getJSONObject(i);  
		        String enterTime=(String) jsonObject.get("enterTime");
		        String leaveTime=""+jsonObject.get("leaveTime");
		        String roomCode=""+jsonObject.get("roomCode");
		        String policeStation=""+jsonObject.get("policeStation");
		        String activity=""+jsonObject.get("activity");
		        String audioVideo=""+jsonObject.get("audioVideo");
		        String detainHour=""+jsonObject.get("detainHour");
		        String detail=""+jsonObject.get("detail");
		        a.setRecordNumber(recordNumber);
		        a.setEnterTime(enterTime);
		        a.setLeaveTime(leaveTime);
		        a.setRoomCode(roomCode);
		        a.setPoliceStation(policeStation);
		        a.setActivity(activity);
		        a.setAudioVideo(audioVideo);
		        a.setDetainHour(detainHour);
		        a.setDetail(detail);
		        activityRecord.add(a);
		    } 
		activityRecordService.saveActivityrecord(activityRecord);
		return null;
		
	}
}
