package com.softpath.paybackpoc.dao;

import com.softpath.paybackpoc.model.MemberContains;

/**
 * @author Sravani 
 * This interface is about to deal with DAO .
 *
 *	Methods
 *  1. memberEnroll Service with input parameters as member model.
 */
public interface DataDao {

	public String memberEnroll(MemberContains member) throws Exception;

}
