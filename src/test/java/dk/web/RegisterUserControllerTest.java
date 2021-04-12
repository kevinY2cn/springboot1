package dk.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import dk.pojo.DkUser;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterUserControllerTest {

	@Autowired
    private WebApplicationContext wac;
	
	private MockMvc mvc;
	
	@Before
	public void setupMockMvc() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	@Rollback(true)
	public void testProcessRegister() throws Exception{
		DkUser user = new DkUser();
		user.setUsername("t");
		user.setPassword("test");
		String requestJson = new ObjectMapper().writeValueAsString(user);
		String response = mvc.perform(post("/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
		.andReturn()
		.getResponse()
		.getContentAsString(Charset.forName("utf-8"));
		System.out.println("response:"+response);
		assertNotEquals(response, "1234");
	}

}
