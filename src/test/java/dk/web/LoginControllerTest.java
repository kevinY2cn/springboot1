package dk.web;


import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

	@Autowired
    private WebApplicationContext wac;
	
	private MockMvc mvc;
	
	@Before
	public void setupMockMvc() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testLogin() throws Exception {
		mvc.perform(get("/login"))
		.andExpect(status().isOk())
		.andExpect(view().name("login"))
		.andExpect(content().string(containsString("登陆界面")));
	}
	
	@Test
	public void testProcessLogin() throws Exception{
		mvc.perform(post("/login")
				.param("username", "123456")
				.param("password", "test")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("loginFailed"));
	}
}
