package dk.service;

import java.util.List;

import dk.bean.PageBean;
import dk.pojo.ModuleOption;
import dk.pojo.Permission;

public interface SettingService {
	
	public List<ModuleOption> getModuleOptions();
	
	public List<Permission> getPermissionListByPage(PageBean bean);

	public int getPermissionCount();

}
