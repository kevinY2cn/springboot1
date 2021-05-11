package dk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dk.bean.PageBean;
import dk.mapper.RoleMapper;
import dk.pojo.Role;


@Service
public class RoleServiceImp implements RoleService {
	
	@Autowired
	private RoleMapper mapper;

	@Override
	public List<Role> queryAll(PageBean pageBean) throws Exception {
		return mapper.queryAll(pageBean);
	}

	@Override
	public void addRole(List<Role> list) throws Exception {
		mapper.addRole(list);
	}

	@Override
	public void deleteRole(List<Integer> list) throws Exception {
		mapper.deleteRole(list);
	}

	@Override
	public void updateRole(List<Role> list) throws Exception {
		mapper.updateRole(list);
	}

}
