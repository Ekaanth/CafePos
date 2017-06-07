package com.squapl.sa.service.serviceimpl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.Billingdtl;
import com.squapl.sa.domain.Billingmst;
import com.squapl.sa.jparepository.BillingDltDao;
import com.squapl.sa.service.BillingDltService;

@Service
public class BillingDltServiceImpl implements BillingDltService {

	@PersistenceContext
    EntityManager entityManager;
	
	@Autowired
	BillingDltDao billingDltDao;
	
	@Override
	public List serveitems() {
		   Query query = entityManager.createNativeQuery("SELECT orderid FROM billingmst where billstatus='OPEN';");
	       // query.setParameter(1, priority);
//SELECT mst.orderid, dtl.itemid, dtl.qty FROM stoneapple.billingmst mst, stoneapple.billingdtl dtl 
 //where mst.orderid = dtl.orderid and mst.billstatus = 'C';	        
	        return query.getResultList();
		
	}

	@Override
	public List findByOrderId(Object object) {
		
		Query query = entityManager.createNativeQuery("SELECT itemid , qty FROM stoneapple.billingdtl where orderid=?");
	    query.setParameter(1, object);  
	    
		return query.getResultList();
		
		
	}

	@Override
	public Collection<Billingdtl> findByOrderid(Integer i) {
		Collection<Billingdtl> itemById = billingDltDao.findByOrderid(i);

		return itemById;
	}

}
