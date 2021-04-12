package dk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dk.mapper.ProvinceMapper;
import dk.pojo.Province;

@Service
public class ProvinceServiceImp implements ProvinceService {
	
	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public List<Province> queryAll() {
		return provinceMapper.queryAll();
	}

	@Override
	public Province queryById(Integer id) {
		return provinceMapper.queryById(id);
	}

}
