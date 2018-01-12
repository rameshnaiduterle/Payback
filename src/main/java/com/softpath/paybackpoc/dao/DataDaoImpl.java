package com.softpath.paybackpoc.dao;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.softpath.paybackpoc.model.MemberContains;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Sravani 
 *  
 * In this DAOImpl layer we invoke IIB services with request as a Model Obj 
 * 
 * Methods
 * 1. memberEnroll Service with input parameters as member model.
 * 
 */
@Repository
public class DataDaoImpl implements DataDao {

	
	
	/**
	 * Here we need dependency of logger to generate logs.
	 */
	static final Logger logger = Logger.getLogger(DataDaoImpl.class);

	/**
	 * 
	 * Member Enrollment Service - We use this service for the enrollment of members
	 * 
	 * In this method we Invoke IIB service by reading IIB IP and IIB ServiceURL from Property file - application.properties 
	 * We create the JSON request in the method and provide input request xml to IIB service. 
	 * 
	 */
	@Value("${memberEnrollmentUrl}")
	String memberEnrollmentUrl; 
	@Override
	public String memberEnroll(MemberContains member1) throws JSONException{		

		System.out.println(memberEnrollmentUrl);
		String output=null;
		try{
			Client client = Client.create();
			WebResource webResource = client.resource(memberEnrollmentUrl);
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("Salutation",member1.getMemberRegData().getSalutation());
			jsonObject1.put("FirstName", member1.getMemberRegData().getFirstName());
			jsonObject1.put("MiddleName",member1.getMemberRegData().getMiddleName());
			jsonObject1.put("LastName", member1.getMemberRegData().getLastName());
			jsonObject1.put("Gender",member1.getMemberRegData().getGender());
			jsonObject1.put("DateOfBirth", member1.getMemberRegData().getDateOfBirth());
			jsonObject1.put("PrimaryMobileNumber", member1.getMemberRegData().getPrimaryPhone());
			jsonObject1.put("SecondaryMobileNumber", member1.getMemberRegData().getSecondaryPhone());
			jsonObject1.put("PrimaryEmailAddress",member1.getMemberRegData().getPrimaryEmail());
			jsonObject1.put("SecondaryEmailAddress", member1.getMemberRegData().getSecondaryEmail());
			jsonObject1.put("City", member1.getMemberRegData().getCity());
			jsonObject1.put("State", member1.getMemberRegData().getState());
			jsonObject1.put("Country", member1.getMemberRegData().getCountry());
			jsonObject1.put("PINCode", member1.getMemberRegData().getPinCode());
			JSONObject jsn=new JSONObject();
			jsn.put("MemberRegData", jsonObject1);
			ClientResponse response1 = webResource.accept("application/json").post(ClientResponse.class, jsn.toString());
			if (response1.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response1.getStatus());
			}
			 output = response1.getEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
		
	
}
