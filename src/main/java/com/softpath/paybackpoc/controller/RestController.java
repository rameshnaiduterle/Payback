package com.softpath.paybackpoc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.softpath.paybackpoc.model.MemberContains;
import com.softpath.paybackpoc.services.DataServices;



/**
 * @author Ramesh Naidu
 *
 * This controller is used for Rest Services for member enrollment and static login
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/payback")
public class RestController {

	
	@Autowired
	private DataServices dataServices;

	private final Logger logger = Logger.getLogger(RestController.class);

	/**
	 * Sample Service for checking Connection 
	 * 
	 */
	
	 @RequestMapping("/welcome")
	 String home() {
		 System.out.println("${URL}");
	    return "Hello PayBack Its Working!";
	 }
	
	 /**
		 * @param member
		 * @param ucBuilder
		 * @throws Exception
		 * This is for member enrollment service
		 * @return enrolled member data  
		 */
		@RequestMapping(value = "/memberEnrollment/", method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<String> memberEnroll(@RequestBody MemberContains member, UriComponentsBuilder ucBuilder) throws Exception {
			String memberEnrollData = dataServices.memberEnroll(member);
			return new ResponseEntity<>(memberEnrollData, HttpStatus.ACCEPTED);
		}
}