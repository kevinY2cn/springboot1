package dk.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dk.Order;
import dk.OrderRunner;
import dk.bean.PageBean;
import dk.pojo.Role;

@RunWith(OrderRunner.class)
@SpringBootTest
public class RoleServiceImpTest {
	
	@Autowired
	private RoleService service;
	
	
	@Test
	@Order(1)
	public void testQueryAll() throws Exception {
		PageBean pageBean = new PageBean();
		List<Role> list = service.queryAll(pageBean);
		assertTrue(list.size() > 0);
	}

	
	static List<Role> roles = new ArrayList<Role>();
	static List<Integer> list = new ArrayList<Integer>();
	
	@Test
	@Order(2)
	public void testAddRole() throws Exception {
		String test1 = "test1"+new Date();
		String test2 = "test2"+new Date();
		Role role1 = new Role();
		Role role2 = new Role();
		roles.add(role1);
		roles.add(role2);
		role1.setRoleName(test1);
		role2.setRoleName(test2);
		service.addRole(roles);
	}

	

	@Test
	@Order(3)
	public void testUpdateRole() throws Exception {
		String test3 = "test3"+new Date();
		String test4 = "test4"+new Date();
		Role role1 = roles.get(0);
		Role role2 = roles.get(1);
		role1.setRoleName(test3);
		role2.setRoleName(test4);
		service.updateRole(roles);
	}
	
	@Test
	@Order(4)
	public void testDeleteRole() throws Exception {
		list.add(roles.get(0).getId());
		list.add(roles.get(1).getId());
		service.deleteRole(list);
	}

}
