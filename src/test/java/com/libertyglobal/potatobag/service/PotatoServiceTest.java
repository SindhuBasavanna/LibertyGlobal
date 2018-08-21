package com.libertyglobal.potatobag.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.libertyglobal.potatobag.exception.PotatoBagException;
import com.libertyglobal.potatobag.model.GenearteRandomString;
import com.libertyglobal.potatobag.model.PotatoBag;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class PotatoServiceTest {
	PotatoService potatoservice;
	String jsonString;
	List<PotatoBag> potatobags;
	PotatoBag potatoBag,potatoBag3;
	PotatoBag potatoBag2;
	
	@Mock
	GenearteRandomString genearteRandomStringMock;
	
	@Before
	public void setup() throws Exception{
		potatobags = new ArrayList<PotatoBag>();		
		potatoBag = new PotatoBag();
		potatoBag.setNoOfPotato(100);
		potatoBag.setPrice(40);
		potatoBag.setSupplier("De Coster");
		potatoservice = new PotatoService();
	}
	
	@Test(expected = PotatoBagException.class)
	public void test_NoOfPotato_Greater_Than_Hundread() throws PotatoBagException   {
		potatoBag = new PotatoBag();
		potatoBag.setNoOfPotato(180);
		potatoBag.setPrice(40);
		potatoBag.setSupplier("De Coster");
		potatoservice.validate(potatoBag);		
	}
	
	@Test(expected = PotatoBagException.class)
	public void test_NoOfPotato_Less_Than_One() throws PotatoBagException   {	
		potatoBag = new PotatoBag();
		potatoBag.setNoOfPotato(0);
		potatoBag.setPrice(40);
		potatoBag.setSupplier("De Coster");
		potatoservice.validate(potatoBag);		
	}
	
	@Test(expected = PotatoBagException.class)
	public void test_Price_Greater_Than_Fifty() throws PotatoBagException   {
		potatoBag = new PotatoBag();
		potatoBag.setNoOfPotato(60);
		potatoBag.setPrice(90);
		potatoBag.setSupplier("De Coster");
		potatoservice.validate(potatoBag);		
	}
	
	@Test(expected = PotatoBagException.class)
	public void test_Price_Less_Than_One() throws PotatoBagException   {	
		potatoBag = new PotatoBag();
		potatoBag.setNoOfPotato(60);
		potatoBag.setPrice(0);
		potatoBag.setSupplier("De Coster");
		potatoservice.validate(potatoBag);		
	}
	
	@Test(expected = PotatoBagException.class)
	public void test_Supplier_Name_NotPresent() throws PotatoBagException   {
		potatoBag = new PotatoBag();
		potatoBag.setNoOfPotato(60);
		potatoBag.setPrice(40);
		potatoBag.setSupplier("Coster");
		potatoservice.validate(potatoBag);		
	}

}
