package com.squapl.sa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;


import com.squapl.sa.util.constants.Active;
import com.squapl.sa.util.constants.ItemsCat;
import com.squapl.sa.util.constants.ItemsUom;


@Entity

public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Size(min=4, max=30) 
	private String itemname;
	
	@Enumerated(EnumType.STRING)
	private ItemsUom uom;
	
	private Integer unitcp;
	private Integer unitsp;
	
	@Enumerated(EnumType.STRING)
	private Active isvalid;
	
	private Date effdate;
	private Date deldate;

	@ManyToOne
	@JoinColumn(name = "vendorid")
	private Vendor vendor;
	
	@Enumerated(EnumType.STRING)
	private ItemsCat itemcat;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public ItemsUom getUom() {
		return uom;
	}
	public void setUom(ItemsUom uom) {
		this.uom = uom;
	}
	
	public Integer getUnitcp() {
		return unitcp;
	}
	public void setUnitcp(Integer unitcp) {
		this.unitcp = unitcp;
	}
	public Integer getUnitsp() {
		return unitsp;
	}
	public void setUnitsp(Integer unitsp) {
		this.unitsp = unitsp;
	}
	
	public Active getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(Active isvalid) {
		this.isvalid = isvalid;
	}
	public Date getEffdate() {
		return effdate;
	}
	public void setEffdate(Date effdate) {
		this.effdate = effdate;
	}
	public Date getDeldate() {
		return deldate;
	}
	public void setDeldate(Date deldate) {
		this.deldate = deldate;
	}

	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public ItemsCat getItemcat() {
		return itemcat;
	}
	public void setItemcat(ItemsCat itemcat) {
		this.itemcat = itemcat;
	}
	
	

}
