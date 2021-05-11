package dk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.bean.PageBean;
import dk.pojo.PagedResult;
import dk.pojo.Role;
import dk.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	@GetMapping("/list")
	public PagedResult<Role> getRoleList() throws Exception{
		PageBean pageBean = new PageBean();
		
		PagedResult<Role> pagedResult = new PagedResult<Role>();
		List<Role> roles = service.queryAll(pageBean);
		pagedResult.setRows(roles);
		int totalSize = service.getRowCount();
		pagedResult.setTotalSize(totalSize);
		return pagedResult;
	}
	@PostMapping("/add")
	public void addRole(@RequestBody List<Role> list) throws Exception{
		service.addRole(list);
	}
	
	@PostMapping("/delete")
	public void deleteRole(@RequestBody List<Integer> list) throws Exception{
		service.deleteRole(list);
	}
	
	@PostMapping("/update")
	public void updateRole(@RequestBody List<Role> list) throws Exception{
		service.updateRole(list);
	}

}
