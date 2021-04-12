package dk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import dk.pojo.DkUser;

@Mapper
@Repository
public interface UserMapper {
	
	//根据用户名查询用户
	public DkUser queryByName(String username);
	
	//添加用户
	public void addUser(DkUser dkUser) throws Exception;
	
	//更新用户
	public void updateUser(DkUser dkUser) throws Exception;
	
	//删除用户
	public void deleteUser(int id) throws Exception;

}
