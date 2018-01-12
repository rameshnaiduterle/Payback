package com.softpath.paybackpoc.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softpath.paybackpoc.dao.DataDao;
import com.softpath.paybackpoc.model.MemberContains;
import com.softpath.paybackpoc.services.DataServices;

/**
 * @author Lavanya
 * implementing interface from DataserviceImpl for access method  
 *
 */
@Service("DataServices")
public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	static final Logger logger = Logger.getLogger(DataServicesImpl.class);
	
	/** 
	 * @Override method from service interface to provide implementation for method
	 * return dataDao to member variable 
	 */
	
	@Override
	public String memberEnroll(MemberContains member) throws Exception {
		return dataDao.memberEnroll(member);
	}
	

	
}
