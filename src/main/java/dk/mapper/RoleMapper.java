package dk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dk.bean.PageBean;
import dk.pojo.Role;

@Mapper
public interface RoleMapper {
	
	public List<Role> queryAll(PageBean pageBean) throws Exception;
	
	public void addRole(List<Role> list) throws Exception;
	
	public void deleteRole(List<Integer> list)throws Exception;
	
	public void updateRole(List<Role> list) throws Exception;

}
