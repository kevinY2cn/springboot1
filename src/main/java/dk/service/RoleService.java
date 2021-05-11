package dk.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dk.bean.PageBean;
import dk.pojo.Role;

public interface RoleService {
	
	public List<Role> queryAll(PageBean pageBean) throws Exception;
	
	@Transactional(rollbackFor = Exception.class)
	public void addRole(List<Role> list) throws Exception;
	
	@Transactional(rollbackFor = Exception.class)
	public void deleteRole(List<Integer> list)throws Exception;
	
	@Transactional(rollbackFor = Exception.class)
	public void updateRole(List<Role> list) throws Exception;

	public int getRowCount();
 

}
