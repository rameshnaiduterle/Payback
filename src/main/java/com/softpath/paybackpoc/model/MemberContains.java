
package com.softpath.paybackpoc.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Anusha
 * This is for MemberManagement registration data 
 * here it contains the details of member Registration data.
 * Here we providing setters, getters, toString  method to all the fields in this model
 * This class is used in Member enrolment service.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class MemberContains implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// memberRegData - is for this is how IIB people are accessing the member model data
	private Member memberRegData;

	public Member getMemberRegData() {
		return memberRegData;
	}

	public void setMemberRegData(Member memberRegData) {
		this.memberRegData = memberRegData;
	}

	@Override
	public String toString() {
		return "MemberContains [memberRegData=" + memberRegData + "]";
	}
}
