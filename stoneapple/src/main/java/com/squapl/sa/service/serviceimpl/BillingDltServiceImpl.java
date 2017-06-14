package com.squapl.sa.service.serviceimpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedWebappClassLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.fabric.xmlrpc.base.Array;
import com.squapl.sa.domain.Billingdtl;
import com.squapl.sa.domain.Billingmst;
import com.squapl.sa.jparepository.BillingDltDao;
import com.squapl.sa.service.BillingDltService;

@Service
@Transactional
public class BillingDltServiceImpl implements BillingDltService {

	@PersistenceContext
    EntityManager entityManager;
	
	@Autowired
	BillingDltDao billingDltDao;
	
	@Override
	public List serveitems() {
		   Query query = entityManager.createNativeQuery("SELECT orderid FROM stoneapple.billingmst where billstatus='OPEN' and noofitems is not 0;");
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
		Query query = entityManager.createNativeQuery("SELECT dtl.itemid, itm.itemname  FROM billingdtl dtl, items itm where dtl.orderid='?' and dtl.itemid = itm.id ");
	    query.setParameter(1, i);  
		return query.getResultList();
	}

	@Override
	public List findItemDetails(Integer i) {
		Query query = entityManager.createNativeQuery("SELECT dtl.orderid,dtl.itemid, itm.itemname , dtl.qty  FROM stoneapple.billingdtl dtl, items itm where dtl.orderid= ? and dtl.itemid = itm.id and dtl.status='YES'");
	    query.setParameter(1, i);  
		return query.getResultList();
	}

	@Override
	public List deleteItembyId(Integer oid, Integer iid) {
		Query query1 = entityManager.createNativeQuery("UPDATE billingdtl SET status='NO' WHERE orderid= ?1 and itemid= ?2");
	    query1.setParameter(1, oid);  
	    query1.setParameter(2, iid);  
		 query1.executeUpdate();
		 
		 Query query2 = entityManager.createNativeQuery("SELECT dtl.rate FROM billingdtl dtl WHERE dtl.orderid= ?1 and dtl.itemid= ?2 ");
		 query2.setParameter(1, oid);  
		 query2.setParameter(2, iid);  
		 List cost = query2.getResultList();    
		 
		Query query3 = entityManager.createNativeQuery("SELECT mst.total FROM billingmst mst where mst.orderid=?");
		 query3.setParameter(1, oid);   
		 List totalcost = query3.getResultList();
		 
		 Iterator it = cost.iterator();
		 Integer billcost=0;
		 while(it.hasNext()){
			 Integer i1 =(Integer) it.next();
			 Integer i2 = (Integer) totalcost.get(0);
			 billcost = i2-i1;
		 }
				 
				 
		 
		 Query query4 = entityManager.createNativeQuery("UPDATE billingmst SET total=? , noofitems= ? WHERE orderid= ?");
		    query4.setParameter(1, billcost);  
		    query4.setParameter(2, -1);  
		    query4.setParameter(3, oid);  
			 query4.executeUpdate();
			 
			 
		return null;
	}

	

}
