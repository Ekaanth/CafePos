package com.squapl.sa.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.squapl.sa.util.constants.Active;
import com.squapl.sa.domain.Vendor;

public interface VendorDao extends CrudRepository<Vendor, Long>{
	
	List<Vendor> findAll();

	void deleteById(Long vendorId);
	
	Vendor findByVendorname(String Vendorname);
	
	List<Vendor> findByIsactive(Active isactive);

}
