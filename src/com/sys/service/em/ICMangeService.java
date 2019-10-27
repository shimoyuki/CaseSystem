package com.sys.service.em;

import com.sys.entity.ICCard;

public interface ICMangeService {
	//Ôö¼ÓIC¿¨
	ICCard saveIC(ICCard iCCard);
	//¸üÏ¸IC¿¨
	void updateIC(ICCard iCCard);
	//É¾³ýIC¿¨
	void deleteIC(ICCard iCCard);


}
