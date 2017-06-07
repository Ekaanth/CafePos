package com.squapl.sa.service.serviceimpl;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.squapl.sa.domain.Items;
import com.squapl.sa.jparepository.ItemsDao;
import com.squapl.sa.service.ItemsService;
import com.squapl.sa.util.constants.Active;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	ItemsDao itemsDao;
	
	@Override
	public List<Items> findItemsList(Principal principal) {
		List<Items> items=itemsDao.findAll();
		return items;
	}

	@Override
	public Items saveItems(Items items) {
		return itemsDao.save(items);
	}

	@Override
	public void deleteItemsById(Long itemsId) {
		itemsDao.deleteById(itemsId);
		
	}

	@Override
	public Items findItemsById(Long itemsId) {
		
		return itemsDao.findOne(itemsId);
	}


	@Override
	public List<Items> findByIsValid(Active isvalid) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Items> findByIsvalid() {
//		
//		return itemsDao.findByIsvalid();
//	}

}
