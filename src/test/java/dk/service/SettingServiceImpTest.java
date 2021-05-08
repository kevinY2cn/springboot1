package dk.service;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dk.bean.PageBean;
import dk.pojo.ModuleOption;
import dk.pojo.Permission;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SettingServiceImpTest {
	
	@Autowired
	SettingService settingServiceImp;

	@Test
	public void testGetModuleOptions() {
		List<ModuleOption> list = settingServiceImp.getModuleOptions();
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void testGetPermissionList() {
		PageBean bean = new PageBean();
		bean.setLimit(10);
		bean.setOffset(0);
		List<Permission> list = settingServiceImp.getPermissionListByPage(bean);
		assertTrue(list.size() > 0);
	}

}
