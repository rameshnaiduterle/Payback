package com.softpath.paybackpoc.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



/**
 * @author Anusha
 *
 *This is for MemeberManagement Data 
 *here it contains the registration details like LCN, firstname, Lastname,Middlename..etc
 * Here we write setters and getters method to all the fields.
 * 
 * This class is used in member enrollment service.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String salutation;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	
	private Long primaryPhone;
	private Long secondaryPhone;
	private String primaryEmail;
	private String secondaryEmail;
	private String city;
	private String state;
	private String country;
	private Integer pinCode;
	//private String lcn;
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public String getCity() {
		return city;
	}
	public Long getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(Long primaryPhone) {
		this.primaryPhone = primaryPhone;
	}
	public Long getSecondaryPhone() {
		return secondaryPhone;
	}
	public void setSecondaryPhone(Long secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}