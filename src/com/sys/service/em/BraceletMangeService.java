package com.sys.service.em;

import com.sys.entity.Bracelet;

public interface BraceletMangeService {
	//增加手环
	void saveBracelet(Bracelet bracelet);
	//修改手环
	void updateBracelet(Bracelet bracelet);
	//删除手环
	void deleteBracelet(Bracelet bracelet);

}
