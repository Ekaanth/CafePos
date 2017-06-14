package com.squapl.sa.service;

import java.util.Collection;
import java.util.List;

import com.squapl.sa.domain.Billingdtl;
import com.squapl.sa.domain.Billingmst;


public interface BillingDltService {

	List serveitems();

	Collection<Billingdtl> findByOrderid(Integer i);

	List findItemDetails(Integer i);

	List deleteItembyId(Integer oid, Integer iid);

	List findByOrderId(Object next);

}
