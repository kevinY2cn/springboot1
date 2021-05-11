package dk.service;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
	public void testGetModuleOptions() throws Exception {
		List<ModuleOption> list = settingServiceImp.getModuleOptions();
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void testGetPermissionList() throws Exception {
		PageBean bean = new PageBean();
		bean.setLimit(10);
		bean.setOffset(0);
		List<Permission> list = settingServiceImp.getPermissionListByPage(bean);
		int count = settingServiceImp.getPermissionCount();
		assertTrue(list.size() > 0 && count > 0);
	}
	
	@Test
	public void testAddPermission() throws Exception {
		Permission permission = new Permission();
		permission.setModuleId(1);
		permission.setModuleName("权限管理模块");
		permission.setPermissionName("权限管理");
		List<Permission> list = new ArrayList<Permission>();
		list.add(permission);
		settingServiceImp.addPermission(list);
		assertTrue(true);
	}

	@Test
	public void testUpdatePermission() throws Exception {
		Permission permission1 = new Permission();
		permission1.setId(1);
		permission1.setModuleId(1);
		permission1.setModuleName("权限管理模块");
		permission1.setPermissionName("测试1");
		
		Permission permission2 = new Permission();
		permission2.setId(2);
		permission2.setModuleId(2);
		permission2.setModuleName("权限管理模块");
		permission2.setPermissionName("测试2");
		List<Permission> list = new ArrayList<Permission>();
		list.add(permission1);
		list.add(permission2);
		
		settingServiceImp.updatePermission(list);
		Permission result = settingServiceImp.queryPermissionById(2);
		assertTrue(result.getPermissionName().equals("测试"));
	}
}
