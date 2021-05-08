package dk.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dk.bean.PageBean;
import dk.pojo.DkItem;
import dk.pojo.ModuleOption;
import dk.pojo.PagedResult;
import dk.pojo.Permission;
import dk.service.SettingService;

@Controller
public class SettingController {
	
	@Autowired
	private SettingService service;
	
	
	@GetMapping("/module/list")
	@ResponseBody
	public List<ModuleOption> getModuleOptions(){
		return service.getModuleOptions();
	}
	
	@GetMapping("/permission/list")
	@ResponseBody
	public PagedResult<Permission> getPermissionList(Integer page,Integer pageSize){
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
	

}
