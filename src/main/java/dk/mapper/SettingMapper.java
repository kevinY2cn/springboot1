package dk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dk.bean.PageBean;
import dk.pojo.ModuleOption;
import dk.pojo.Permission;

@Mapper
public interface SettingMapper {

	public List<ModuleOption> getModuleOptions();
	
	public List<Permission> getPermissionListByPage(PageBean bean);

	public int getPermissionCount();
}
