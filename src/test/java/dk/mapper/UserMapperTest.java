package dk.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dk.pojo.DkUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	public UserMapper userMapper;
	
	@Test
	public void testQueryByName() {
		DkUser user = userMapper.queryByName("test");
		assertEquals(user.getUsername(), "test");
		assertNotNull(user.getPassword());
		assertNotNull(user);
	}
	
	@Test
	public void testAddUser() {
		DkUser user = new DkUser();
		String username = "test"+UUID.randomUUID().toString();
		String password = "test";
		user.setUsername(username);
		user.setPassword(password);
		try {
			userMapper.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
