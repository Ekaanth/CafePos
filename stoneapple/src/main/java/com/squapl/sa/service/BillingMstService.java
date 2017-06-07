package com.squapl.sa.service;

import java.util.Collection;
import java.util.List;

import com.squapl.sa.domain.Billingmst;
import com.squapl.sa.util.constants.BillStatus;

public interface BillingMstService {

	public Collection<Billingmst> getAll();

	

	Collection<Billingmst> findByBillStatus(BillStatus status);

	

	public Collection<Billingmst> findByOrderid(Integer id);

}
