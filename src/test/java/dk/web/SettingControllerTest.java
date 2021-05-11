package dk.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.List;

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

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;

import dk.pojo.ModuleOption;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SettingControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mvc;
	
	
	@Before
	public void setupMockMvc() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testGetModuleOptions() throws Exception {
		String str = mvc.perform(get("/module/list")
				.contentType(MediaType.APPLICATION_JSON)
				).andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
		List<ModuleOption> list = JSON.parseArray(str, ModuleOption.class);
		for(ModuleOption o: list) {
			if(o.getId() == 1) {
				assertEquals("权限管理模块", o.getModuleName());
			}
		}
	}

}
