package com.softpath.paybackpoc.services;

import com.softpath.paybackpoc.model.MemberContains;

/**
 * @author Lavanya 
 * creating memberEnroll interface by passing MemberContains model as a parameter. 
 * 
 * 
 *
 */
public interface DataServices {
	
	
		/**
		 * @param member
		 * @return
		 * @throws Exception
		 * MemberConatins model class is having a all the parameter.which is required for Member Enrollment
		 * 
		 */
		public String memberEnroll(MemberContains member) throws Exception;

}
