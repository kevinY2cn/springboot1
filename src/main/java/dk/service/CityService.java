package dk.service;

import java.util.List;

import dk.pojo.City;

public interface CityService {

	public List<City> queryAll();
	
	public List<City> queryCityByProvince(Integer provinceId);
	
}
