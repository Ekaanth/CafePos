package com.squapl.sa.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squapl.sa.domain.OpenRegister;

public interface OpenRegisterDAO  extends JpaRepository<OpenRegister,Long>{

	
	public OpenRegister findById(Long id);
}
