package com.squapl.sa.service;

import com.squapl.sa.domain.OpenRegister;

public interface OpenRegisterService {
	
	public OpenRegister saveRegister(OpenRegister reg);
	
	public void deleteRegister(Long id);
	

	OpenRegister updateRegister(OpenRegister reg);
	
}
