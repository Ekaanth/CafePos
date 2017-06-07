package com.squapl.sa.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.squapl.sa.domain.Items;
import com.squapl.sa.util.constants.Active;

public interface ItemsDao extends CrudRepository<Items, Long> {
	
	List<Items> findAll();
	
	void deleteById(Long itemsId);
	
	List<Items> findByIsvalid(Active isvalid);
}