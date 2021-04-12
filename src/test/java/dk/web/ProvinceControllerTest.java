package dk.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvinceControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mvc;

	@Before
	public void setupMockMvc() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testGetJsonData() throws Exception {
		String responString = mvc.perform(get("/province/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept("application/json;charset=UTF-8")
				).andReturn().getResponse().getContentAsString();
		System.out.println(responString);
		assertTrue(responString.length() > 0);
	}
	

	@Test
	public void testGetCitysByProvince() throws Exception {
		String responString = mvc.perform(get("/province/1/city")
				.contentType(MediaType.APPLICATION_JSON)
				.accept("application/json;charset=UTF-8")
				).andReturn().getResponse().getContentAsString();
		System.out.println(responString);
		assertTrue(responString.length() > 0);
	}

}
