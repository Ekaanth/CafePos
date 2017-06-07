package com.squapl.sa.service;

import java.security.Principal;
import java.util.List;

import com.squapl.sa.util.constants.Active;

import com.squapl.sa.domain.Items;

public interface ItemsService {
	
	List<Items> findItemsList(Principal principal);

    Items saveItems(Items items);
    
    void deleteItemsById(Long itemsId);
    
    Items findItemsById(Long itemsId);
    
    List<Items> findByIsValid(Active isvalid);
	

}
