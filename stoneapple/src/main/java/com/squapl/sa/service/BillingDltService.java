package com.squapl.sa.service;

import java.util.Collection;
import java.util.List;

import com.squapl.sa.domain.Billingdtl;
import com.squapl.sa.domain.Billingmst;


public interface BillingDltService {

	List serveitems();

	List findByOrderId(Object object);

	Collection<Billingdtl> findByOrderid(Integer i);

}
