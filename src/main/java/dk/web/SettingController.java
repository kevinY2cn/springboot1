package dk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dk.bean.PageBean;
import dk.pojo.ModuleOption;
import dk.pojo.PagedResult;
import dk.pojo.Permission;
import dk.service.SettingService;

@RestController
public class SettingController {
	
	@Autowired
	private SettingService service;
	
	
	@GetMapping("/module/list")
	public List<ModuleOption> getModuleOptions() throws Exception{
		return service.getModuleOptions();
	}
	
	@GetMapping("/permission/list")
	public PagedResult<Permission> getPermissionList(Integer page,Integer pageSize) throws Exception{
		PageBean pageBean = new PageBean();
		if(page != null) {
			pageBean.setOffset((page-1)*10);
		}else {
			pageBean.setOffset(0);
		}
		
		if(pageSize != null) {
			pageBean.setLimit(pageSize);
		}else {
			pageBean.setLimit(10);
		}
		List<Permission> list = service.getPermissionListByPage(pageBean);
		int totalSize = service.getPermissionCount();
		PagedResult<Permission> pageResult = new PagedResult<Permission>();
		pageResult.setRows(list);
		pageResult.setTotalSize(totalSize);
		return pageResult;
		
	}
	
	@PostMapping("/permission/delete")
	public void deletePermission(@RequestBody List<Integer> idList) throws Exception{
		if(idList != null && idList.size() > 0)
		service.deletePermission(idList);
	}
	
	@PostMapping("/permission/update")
	public void updatePermission(@RequestBody List<Permission> list) throws Exception{
		if(list != null && list.size() > 0)
		service.updatePermission(list);
	}
	
	
	@PostMapping("/permission/add")
	public void addPermission(@RequestBody List<Permission> list) throws Exception{
		if(list != null && list.size() > 0)
		service.addPermission(list);
	}
	


}
