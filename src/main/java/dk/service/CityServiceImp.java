package dk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dk.mapper.CityMapper;
import dk.pojo.City;


@Service
public class CityServiceImp implements CityService {
	
	@Autowired
	private CityMapper cityMapper;

	@Override
	public List<City> queryAll() {
		return cityMapper.queryAll();
	}

	@Override
	public List<City> queryCityByProvince(Integer provinceId) {
		return cityMapper.queryCityByProvince(provinceId);
	}

}
