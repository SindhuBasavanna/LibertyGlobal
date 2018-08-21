package com.libertyglobal.potatobag.resource;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libertyglobal.potatobag.exception.PotatoBagException;
import com.libertyglobal.potatobag.model.PotatoBag;
import com.libertyglobal.potatobag.service.PotatoService;

@RestController
public class PotatoController {
	@Autowired
	PotatoService service;
	/**
	 * To fetch no of PotatoBags based on user input
	 * 
	 * @param noOfPotatoBags
	 * @return
	 */
	@RequestMapping("/potatobags")
	public List<PotatoBag> getPotatoBag(
			@RequestParam(required = false) Integer noOfPotatoBags) {
		noOfPotatoBags = (noOfPotatoBags == null || noOfPotatoBags == 0) ? 3
				: noOfPotatoBags;
			return service.getPotatoBag(noOfPotatoBags);
	}

	/**
	 * To post PotatoBag. Body will be sent by user
	 * 
	 * @param listpotatoBag
	 * @return
	 */
	@RequestMapping(value = "/potatobag", method = RequestMethod.POST, consumes = "application/json")
	public String addPotatoBag(@RequestBody PotatoBag potatoBag) {
		try {
			return service.addPotatoBag(potatoBag);
		} catch (PotatoBagException e) {
			return e.getMessage();
		}
	}
}
