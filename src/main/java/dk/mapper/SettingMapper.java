package dk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dk.bean.PageBean;
import dk.pojo.ModuleOption;
import dk.pojo.Permission;

@Mapper
public interface SettingMapper {

	public List<ModuleOption> getModuleOptions() throws Exception;
	
	public List<Permission> getPermissionListByPage(PageBean bean) throws Exception;

	public int getPermissionCount() throws Exception;

	public void addPermission(List<Permission> list) throws Exception;

	public void updatePermission(List<Permission> list) throws Exception;

	public void deletePermission(List<Integer> list);

	public Permission queryPermissionById(int id);

}
