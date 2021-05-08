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
	public List<ModuleOption> getModuleOptions() {
		return mapper.getModuleOptions();
	}

	@Override
	public List<Permission> getPermissionListByPage(PageBean bean) {
		return mapper.getPermissionListByPage(bean);
	}

	@Override
	public int getPermissionCount() {
		return mapper.getPermissionCount();
	}

}
