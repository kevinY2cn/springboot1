package dk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.bean.PageBean;
import dk.pojo.Role;
import dk.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	@GetMapping("/list")
	public List<Role> getRoleList() throws Exception{
		PageBean pageBean = new PageBean();
		
		return service.queryAll(pageBean);
	}

}
