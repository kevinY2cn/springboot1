package dk.service;

import java.util.List;

import dk.pojo.Province;

public interface ProvinceService {
	
	public List<Province> queryAll();
	
	public Province queryById(Integer id);

}
