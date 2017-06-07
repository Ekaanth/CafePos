package com.squapl.sa.jparepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.squapl.sa.util.constants.Active;
import com.squapl.sa.domain.Rawmtl;

public interface RawmtlDao extends CrudRepository<Rawmtl, Long>{
	
	List<Rawmtl> findAll();

	void deleteById(Long rawmtlId);
	
	List<Rawmtl> findByIsvalid(Active isvalid);

}
