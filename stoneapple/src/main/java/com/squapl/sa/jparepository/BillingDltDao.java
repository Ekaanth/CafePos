package com.squapl.sa.jparepository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squapl.sa.domain.Billingdtl;
import com.squapl.sa.domain.Billingmst;

@Repository
public interface BillingDltDao extends JpaRepository<Billingdtl, Long> {

	Collection<Billingdtl> findByOrderid(Integer i);

}
