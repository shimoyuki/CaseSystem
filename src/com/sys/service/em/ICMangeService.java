package com.sys.service.em;

import com.sys.entity.ICCard;

public interface ICMangeService {
	//����IC��
	ICCard saveIC(ICCard iCCard);
	//��ϸIC��
	void updateIC(ICCard iCCard);
	//ɾ��IC��
	void deleteIC(ICCard iCCard);


}
