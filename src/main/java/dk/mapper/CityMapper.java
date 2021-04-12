package dk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dk.pojo.City;

@Mapper
public interface CityMapper {
	
	public List<City> queryAll();
	
	public List<City> queryCityByProvince(Integer provinceId);

}
