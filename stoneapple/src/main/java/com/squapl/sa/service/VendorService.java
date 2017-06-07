package com.squapl.sa.service;

import java.security.Principal;
import java.util.List;

import com.squapl.sa.util.constants.Active;
import com.squapl.sa.domain.Vendor;

public interface VendorService {
	
	List<Vendor> findByVendorList(Principal principal);
	
	Vendor saveVendor(Vendor vendor);
	
	Vendor findVendorById(Long VendorId);
	
	void deleteVendorById(Long VendorId);

	Vendor findByVendorName(String name);
	
	List<Vendor> findByActiveList(Active isactive);

		
	

}
