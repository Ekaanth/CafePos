package com.squapl.sa.service.serviceimpl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Billingmst;
import com.squapl.sa.jparepository.BillingMstDao;
import com.squapl.sa.service.BillingMstService;
import com.squapl.sa.util.constants.BillStatus;

@Service
public class BillingsMstServiceImpl implements BillingMstService {

	@Autowired
	private BillingMstDao billingMstDao;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Collection<Billingmst> getAll() {
		// TODO Auto-generated method stub
		Collection<Billingmst> getall = billingMstDao.findAll();

		return getall;
	}

	@Override
	public Collection<Billingmst> findByBillStatus(BillStatus status) {
		
		Collection<Billingmst> itemsByStatus = billingMstDao.findByBillstatus(status);

		return itemsByStatus;
	}

	@Override
	public Collection<Billingmst> findByOrderid(Integer id) {
		Collection<Billingmst> itemById = billingMstDao.findByOrderid(id);

		return itemById;
	}

	
	
	

	
}
