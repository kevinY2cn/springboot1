package dk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dk.pojo.DkUser;
import dk.service.UserService;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
	
	@Autowired
	UserService userServiceImp;
	
	
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public String processLogin(DkUser user) {
		DkUser queryUser = userServiceImp.getUserByName(user.getUsername());
		if(queryUser == null || !queryUser.getPassword().equals(user.getPassword())) {
			return "loginFailed";
		}
		
		return "loginSuccess";
	}
	
	
	@GetMapping("/form")
	public String loginForm() {
		return "loginForm";
	}
}
