package com.squapl.sa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.squapl.sa.util.constants.BillPaidStatus;
import com.squapl.sa.util.constants.BillStatus;

@Entity
public class Billingmst {

	@Id
	@GeneratedValue
	private Long id;
	private Integer orderid;
	private Date datetime;
	private Integer total;
	private String discode;
	private Integer discount;
	private Integer noofitems;
	
	@Enumerated(EnumType.STRING)
	private BillStatus billstatus;
	
	@Enumerated(EnumType.STRING)
	private BillPaidStatus billpaid;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getDiscode() {
		return discode;
	}
	public void setDiscode(String discode) {
		this.discode = discode;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getNoofitems() {
		return noofitems;
	}
	public void setNoofitems(Integer noofitems) {
		this.noofitems = noofitems;
	}
	public BillStatus getBillstatus() {
		return billstatus;
	}
	public void setBillstatus(BillStatus billstatus) {
		this.billstatus = billstatus;
	}
	public BillPaidStatus getBillpaid() {
		return billpaid;
	}
	public void setBillpaid(BillPaidStatus billpaid) {
		this.billpaid = billpaid;
	}
	
	
}
