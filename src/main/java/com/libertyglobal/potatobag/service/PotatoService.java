package com.libertyglobal.potatobag.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libertyglobal.potatobag.exception.PotatoBagException;
import com.libertyglobal.potatobag.model.GenearteRandomString;
import com.libertyglobal.potatobag.model.PotatoBag;
import com.libertyglobal.potatobag.util.PotatoBagConstants;
import com.libertyglobal.potatobag.util.Supplier;
/**
 * Service class for PotatoBag
 * @author sindhu
 */
@Service
public class PotatoService {	
	GenearteRandomString randomString;
	
	@Autowired
	public void setRandomString(GenearteRandomString randomString) {
		this.randomString = randomString;
	}
	private List<PotatoBag> potatoBag = new ArrayList<PotatoBag>();
	private static Logger log = Logger.getLogger(PotatoService.class);
		
	/**
	 * Fetch potatoBag based on user input. If user is not specifying any input then return
	 * 3 potatobag
	 * @param id
	 * @return
	 */
	public List<PotatoBag> getPotatoBag(int id){
		log.info("Entering getPotatoBag method of PotatoService Class");
		if(id<0){
			id=0;
		}
		return  potatoBag.stream().limit(id).collect(Collectors.toList());	
	}	
	
	
	/**
	 * Adding potatoBag into the list
	 * @param potatoBagdata
	 * @return
	 * @throws PotatoBagException 
	 */
	public String addPotatoBag(PotatoBag potatoBagdata) throws PotatoBagException {
		log.info("Entering addPotatoBag method of PotatoService Class");
		validate(potatoBagdata);
			potatoBagdata.setId(randomString.generateRandomString());
			potatoBagdata.setCreatedAt(new Date());
			potatoBag.add(potatoBagdata);			 
		return "PotatoBag successfully insterted";
	}

	/**
	 * Validation of requestparameter of potatoBag 
	 * @param eachpotatoBag
	 * @return String
	 */
	public void validate(PotatoBag potatoBag) throws PotatoBagException{
		if (potatoBag.getNoOfPotato() > PotatoBagConstants.POTATOBAG_POTATOS_MAX_LIMIT
				|| potatoBag.getNoOfPotato() <= PotatoBagConstants.POTATOBAG_POTATOS_MIN_LIMIT) {
			throw new PotatoBagException("Noofpotato should be in between 1 and 100.");
		}
		if (potatoBag.getPrice() >PotatoBagConstants.POTATOBAG_PRICE_MAX_LIMIT 
				|| potatoBag.getPrice() <= PotatoBagConstants.POTATOBAG_POTATOS_MIN_LIMIT) {
			throw new PotatoBagException("Potato price should be between 1 to 50");
		}
		if(Supplier.getSupplier(potatoBag.getSupplier())==null){
			throw new PotatoBagException("Supplier name is incorrect. Please provide proper supplier name");
		}				
	}
}
