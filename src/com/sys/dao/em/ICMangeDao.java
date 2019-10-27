package com.sys.dao.em;

import org.springframework.stereotype.Repository;

import com.sys.entity.ICCard;
@Repository("iCMangeDao")
public interface ICMangeDao {

	ICCard saveIC(ICCard iCCard);

	void updateIC(ICCard iCCard);

	void deleteIC(ICCard iCCard);

}
