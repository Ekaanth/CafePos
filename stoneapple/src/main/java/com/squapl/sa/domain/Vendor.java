package com.squapl.sa.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.squapl.sa.util.constants.Active;


@Entity
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Size(min=4,max=30)
	private String vendorname;
	private String contactno1;
	
	private String contactno2;
	private String address1;
	private String address2;
	private String bankdetails;

	@Enumerated(EnumType.STRING)
	private Active isactive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getContactno1() {
		return contactno1;
	}

	public void setContactno1(String contactno1) {
		this.contactno1 = contactno1;
	}

	public String getContactno2() {
		return contactno2;
	}

	public void setContactno2(String contactno2) {
		this.contactno2 = contactno2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getBankdetails() {
		return bankdetails;
	}

	public void setBankdetails(String bankdetails) {
		this.bankdetails = bankdetails;
	}

	public Active getIsactive() {
		return isactive;
	}

	public void setIsactive(Active isactive) {
		this.isactive = isactive;
	}

}
