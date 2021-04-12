package dk.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dk.mapper.UserMapper;
import dk.pojo.DkUser;

@Service
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImp implements UserService {
	
	public static final Logger log = LoggerFactory.getLogger(UserServiceImp.class);
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public DkUser getUserByName(String username) {
		if(log.isDebugEnabled()) {
			log.debug("queryUserByName:"+username);
		}
		return userMapper.queryByName(username);
	}

	@Override
	public void addUser(DkUser dkUser) throws Exception{
		if(log.isDebugEnabled()) {
			log.debug("addUser:"+ dkUser.getUsername());
		}
		userMapper.addUser(dkUser);
	}

	@Override
	public void udpateUser(DkUser dkUser) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
	}

}
