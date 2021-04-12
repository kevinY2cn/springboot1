package dk.service;




import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dk.pojo.DkUser;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImpTest {

	@Autowired
	UserService userServiceImp;
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void testAdd() {
		DkUser user = new DkUser();
		user.setUsername("test1");
		user.setPassword("test1");
		try {
			userServiceImp.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddForRollback() {
		DkUser user = new DkUser();
		String username = "test"+UUID.randomUUID().toString();
		String password = "test";
		user.setUsername(username);
		user.setPassword(password);
		try {
			userServiceImp.addUser(user);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
