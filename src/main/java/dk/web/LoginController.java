package dk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.pojo.DkUser;
import dk.pojo.Result;
import dk.pojo.Result.STATUS_CODE;
import dk.service.UserService;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
	
	@Autowired
	UserService userServiceImp;
	
	@GetMapping("/do")
	public Result processLogin() {
		return new Result(STATUS_CODE.SUCCESS,null,null);
	}
	
	@PostMapping("/do")
	public Result processLogin(@RequestBody DkUser user) {
		DkUser queryUser = userServiceImp.getUserByName(user.getUsername());
		if(queryUser == null || !queryUser.getPassword().equals(user.getPassword())) {
			return new Result(STATUS_CODE.FAILED,"密码不正确",null);
		}
		
		return new Result(STATUS_CODE.SUCCESS,null,null);
	}
	
}
