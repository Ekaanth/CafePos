package com.squapl.sa.service.serviceimpl;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.squapl.sa.domain.Vendor;
import com.squapl.sa.jparepository.VendorDao;
import com.squapl.sa.service.VendorService;
import com.squapl.sa.util.constants.Active;


@Service
@Transactional
public class VendorServiceImpl  implements VendorService{
	
	@Autowired
	VendorDao vendorDao;

	@Override
	public List<Vendor> findByVendorList(Principal principal) {
		List<Vendor> vendors=vendorDao.findAll();
		return vendors;
	}

	@Override
	public Vendor saveVendor(Vendor vendor) {
		return vendorDao.save(vendor);
	}

	@Override
	public Vendor findVendorById(Long VendorId) {
		return vendorDao.findOne(VendorId);
	}

	@Override
	public void deleteVendorById(Long VendorId) {
		vendorDao.deleteById(VendorId);
		
	}

	@Override
	public Vendor findByVendorName(String name) {
		
		return vendorDao.findByVendorname(name);
	}

	@Override
	public List<Vendor> findByActiveList(Active isactive) {
		
		return vendorDao.findByIsactive(isactive);
	}




}
