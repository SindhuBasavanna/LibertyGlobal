package com.libertyglobal.potatobag.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libertyglobal.potatobag.util.PotatoBagConstants;

/**
 * Bean class for potatobag
 * 
 * @author sindhu
 *
 */
public class PotatoBag {
	private String id;
	private int noOfPotato;
	private String supplier;
	@JsonIgnore
	private Date createdAt;
	private int price;
	private String createdAtStr;

	public PotatoBag() {

	}

	public PotatoBag(String id, int noOfPotato, String supplier, int price) {
		this.id = id;
		this.noOfPotato = noOfPotato;
		this.supplier = supplier;
		this.price = price;
		this.createdAt = new Date();
	}

	public String getId() {
		return id;
	}

	public int getNoOfPotato() {
		return noOfPotato;
	}

	public String getSupplier() {
		return supplier;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public int getPrice() {
		return price;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNoOfPotato(int noOfPotato) {
		this.noOfPotato = noOfPotato;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public void setCreatedAt(Date createdAt) {
		SimpleDateFormat dateAndTime = new SimpleDateFormat(
				PotatoBagConstants.DATE_TIME_FORMAT);
		this.createdAt = createdAt;
		this.createdAtStr = dateAndTime.format(this.createdAt).toString();
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCreatedAtStr() {
		return createdAtStr;
	}

	public void setCreatedAtStr(String createdAtStr) {
		this.createdAtStr = createdAtStr;
	}

}
