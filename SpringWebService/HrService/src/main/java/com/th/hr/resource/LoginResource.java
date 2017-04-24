package com.th.hr.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.th.hr.model.Login;
import com.th.hr.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginResource {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Login validateUsers(@RequestBody Login login) {
		
		boolean validateUser= loginService.validateUser(login.getUserId(),login.getPassword());
		
		System.out.println(validateUser);
		Login log = null;
		if(validateUser){
			log=new Login();
			log.setUserId(login.getUserId());
			log.setPassword(login.getPassword());
			
		}else{
			log=null;
		}
		return log;
	}
	/*@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Login get(@RequestBody String userId, @RequestBody String password){
		return validateUsers(userId,password);
		
	}*/
	
}