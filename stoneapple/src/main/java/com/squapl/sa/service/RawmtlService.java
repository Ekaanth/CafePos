package com.squapl.sa.service;

import java.security.Principal;
import java.util.List;

import com.squapl.sa.util.constants.Active;

import com.squapl.sa.domain.Rawmtl;

public interface RawmtlService {
	
	
	 List<Rawmtl> findByRawmtlList(Principal principal);
		
		Rawmtl saveRawmtl(Rawmtl rawmtl);
		
		Rawmtl findRawmtlById(Long rawmtlId);
		
		void deleteRawmtlById(Long rawmtlId);
		
		List<Rawmtl> findByIsValid(Active isvalid);

}
