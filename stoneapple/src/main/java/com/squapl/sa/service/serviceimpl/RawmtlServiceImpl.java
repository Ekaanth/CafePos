package com.squapl.sa.service.serviceimpl;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.squapl.sa.domain.Rawmtl;
import com.squapl.sa.jparepository.RawmtlDao;
import com.squapl.sa.service.RawmtlService;
import com.squapl.sa.util.constants.Active;

@Service
@Transactional
public class RawmtlServiceImpl implements RawmtlService{
	
	@Autowired
	RawmtlDao rawmtlDao;

	@Override
	public List<Rawmtl> findByRawmtlList(Principal principal) {
	List<Rawmtl> mtls=rawmtlDao.findAll();
		return mtls;
	}

	@Override
	public Rawmtl saveRawmtl(Rawmtl rawmtl) {
		
		return rawmtlDao.save(rawmtl);
	}

	@Override
	public Rawmtl findRawmtlById(Long rawmtlId) {
		
		return rawmtlDao.findOne(rawmtlId);
	}

	@Override
	public void deleteRawmtlById(Long rawmtlId) {
		rawmtlDao.deleteById(rawmtlId);
		
	}



	@Override
	public List<Rawmtl> findByIsValid(Active isvalid) {
		// TODO Auto-generated method stub
		return null;
	}

}
