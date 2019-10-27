package com.sys.service.io;

import java.util.List;

import com.sys.entity.CheckGoods;
import com.sys.entity.EntryDutypolice;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.Goodsinspect_dutypolice;
import com.sys.entity.Goodsinspect_party;
import com.sys.entity.Goodsinspect_police;
import com.sys.entity.IdentityCard;
import com.sys.entity.PersonScrutiny;
import com.sys.entity.ScarDetail;
import com.sys.entity.ScarInspectParty;
import com.sys.entity.ScarInspectPolice;

public interface SafetyCheckService {
	
	//登记人身安全检查信息
	void saveSafetyCheckInfo(PersonScrutiny personScrutiny);
	//涉案人员随身物品检查登记
	void saveHisBelongings(CheckGoods checkGoods);
	//保存伤痕记录
	void saveScarTreatment(ScarDetail scarDetail);
	//获取物品登记的列表
	List<CheckGoods> getGoodsList(String recordNumber, int intPage, int number);
	//获取物品列表总数
	int getGoodsTotal(String recordNumber);
	//获取伤痕说明列表
	List<ScarDetail> getScarExplainList(String recordNumber, int intPage, int number);
	//获取伤痕列表总数
	int getScarExplainTotal(String recordNumber);
	//业务干警签名
	void savePolicemenSignature(List<ScarInspectPolice> tpList);
	//伤痕检查--被检查人签名
	void saveReviewedSignature(ScarInspectParty scarInspectParty);
	//批量删除随身物品
	void deleteHisBelongings(List<CheckGoods> idList);
	//保存业务干警签字
	void saveGoodsinspect_police(List<Goodsinspect_police> gpList);
	//保存值班干警签字
	void saveGoodsinspect_dutypolice(List<Goodsinspect_dutypolice> gdpList);
	//保存随身物品检查--被检查人签字
	void saveGoodsinspect_party(Goodsinspect_party goodsinspect_party);
	
	List<EntryPolicemen> getEntryPolice(String recordNumber);
	
	EntryDutypolice getEntryDutyPolice(String recordNumber);
}
