package dk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dk.pojo.Province;

@Mapper
public interface ProvinceMapper {
	
	public List<Province> queryAll();
	
	public Province queryById(Integer id);
	

}
