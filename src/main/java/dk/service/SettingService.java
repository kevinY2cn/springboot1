package dk.service;

import java.util.List;


import dk.bean.PageBean;
import dk.pojo.ModuleOption;
import dk.pojo.Permission;

public interface SettingService {
	
	public List<ModuleOption> getModuleOptions() throws Exception;
	
	public List<Permission> getPermissionListByPage(PageBean bean) throws Exception;

	public int getPermissionCount() throws Exception;
	
	public void addPermission(List<Permission> list) throws Exception;
	
	public void updatePermission(List<Permission> list) throws Exception;
	
	public void deletePermission(List<Integer> list) throws Exception;
	
	public Permission queryPermissionById(int id) throws Exception;


}
