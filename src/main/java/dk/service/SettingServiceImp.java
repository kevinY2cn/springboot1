package dk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dk.bean.PageBean;
import dk.mapper.SettingMapper;
import dk.pojo.ModuleOption;
import dk.pojo.Permission;


@Service
@Transactional(rollbackFor = Exception.class)
public class SettingServiceImp implements SettingService {
	
	@Autowired
	private SettingMapper mapper;

	@Override
	public List<ModuleOption> getModuleOptions() throws Exception{
		return mapper.getModuleOptions();
	}

	@Override
	public List<Permission> getPermissionListByPage(PageBean bean) throws Exception{
		return mapper.getPermissionListByPage(bean);
	}

	@Override
	public int getPermissionCount() throws Exception{
		return mapper.getPermissionCount();
	}

	@Override
	public void addPermission(List<Permission> list) throws Exception {
		mapper.addPermission(list);
		
	}

	@Override
	public void updatePermission(List<Permission> list) throws Exception {
		mapper.updatePermission(list);
	}

	@Override
	public void deletePermission(List<Integer> list) throws Exception {
		mapper.deletePermission(list);
		
	}

	@Override
	public Permission queryPermissionById(int id) throws Exception {
		return mapper.queryPermissionById(id);
	}

}
