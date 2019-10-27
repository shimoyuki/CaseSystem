package com.sys.dao.em;

import org.springframework.stereotype.Repository;

import com.sys.entity.Bracelet;
@Repository("braceletMangeDao")
public interface BraceletMangeDao {

	void saveBracelet(Bracelet bracelet);

	void updateBracelet(Bracelet bracelet);

	void deleteBracelet(Bracelet bracelet);

}
