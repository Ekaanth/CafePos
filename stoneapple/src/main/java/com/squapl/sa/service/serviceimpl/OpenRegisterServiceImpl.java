package com.squapl.sa.service.serviceimpl;



import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squapl.sa.domain.OpenRegister;
import com.squapl.sa.jparepository.OpenRegisterDAO;
import com.squapl.sa.service.OpenRegisterService;

@Service
@Transactional

public class OpenRegisterServiceImpl implements OpenRegisterService{

	@Autowired
	OpenRegisterDAO openregisterdao;
	
	@Override
	public OpenRegister saveRegister(OpenRegister reg) {
		OpenRegister save =  openregisterdao.save(reg);
		return save;
	}

	@Override
	public void deleteRegister(Long id) {
	 openregisterdao.delete(id);
	
	}

	@Override
	public OpenRegister updateRegister(OpenRegister reg) {
		OpenRegister element = openregisterdao.save(reg);
		return element;
	}

	
}
