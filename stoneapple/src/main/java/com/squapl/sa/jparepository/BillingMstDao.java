package com.squapl.sa.jparepository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squapl.sa.domain.Billingmst;
import com.squapl.sa.util.constants.BillStatus;

@Repository
public interface BillingMstDao extends JpaRepository<Billingmst,Long> {

	Collection<Billingmst> findByBillstatus(BillStatus status);

	Collection<Billingmst> findByOrderid(Integer id);


	
}
