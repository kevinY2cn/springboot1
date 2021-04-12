package dk.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dk.pojo.DkUser;
import dk.pojo.Result;
import dk.pojo.Result.STATUS_CODE;
import dk.service.UserService;



@Controller
@RequestMapping("/register")
public class RegisterUserController {
	
	@Autowired
	UserService userServiceImp;
	
	@GetMapping
	public String register() {
		return "register";
	}
	
	@GetMapping("/checkUserIsExist/{username}")
	@ResponseBody
	public boolean existUser(@PathVariable("username") String username) {
		DkUser user = userServiceImp.getUserByName(username);
		return user!=null;
	}
	
	@PostMapping
	@ResponseBody
	public Result processRegister(
			@RequestBody @Valid DkUser user,
			BindingResult bindingResult) {
		Result result = new Result();
		if(bindingResult.hasErrors()) {
			result.setResultMessage("字段有问题");
			result.setStatusCode(STATUS_CODE.FAILED);
		}else {
			try {
				userServiceImp.addUser(user);
				result.setResultMessage("注册成功");
				result.setStatusCode(STATUS_CODE.SUCCESS);
				result.setResultObject(user);
			} catch (Exception e) {
				result.setResultMessage("注册失败");
				result.setStatusCode(STATUS_CODE.FAILED);
			}
		}
		return result;
	}

}
