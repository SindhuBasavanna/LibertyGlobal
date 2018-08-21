package com.libertyglobal.potatobag.resource;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libertyglobal.potatobag.model.PotatoBag;
import com.libertyglobal.potatobag.service.PotatoService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PotatoController.class, secure = false)
@ActiveProfiles("test")
public class PotatoControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PotatoService potatoServiceMock;
	
	String jsonString;
	
	List<PotatoBag> potatobags;
	PotatoBag potatoBag;
	
	@Before
	public void setup() throws Exception{
		potatobags = new ArrayList<PotatoBag>();		
		potatoBag = new PotatoBag();
		potatoBag.setNoOfPotato(100);
		potatoBag.setPrice(40);
		potatoBag.setSupplier("De Coster");
		ObjectMapper mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(potatoBag);
		
	}
	@Test
	public void testAndRetrievePotatobagDetails() throws Exception {
	when(potatoServiceMock.getPotatoBag(1)).thenReturn(potatobags);
	 mockMvc.perform(get(
				"/potatobags").param("noOfPotatoBags","1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200));
	}
	
	@Test
	public void testAndPostPotatoBags() throws Exception {
	when(potatoServiceMock.addPotatoBag(anyObject())).thenReturn("Success");
		 mockMvc.perform(post(
				"/potatobag")
				 .content(jsonString)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200));
	
	}
}
