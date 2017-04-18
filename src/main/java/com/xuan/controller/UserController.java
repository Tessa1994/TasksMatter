package com.xuan.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuan.bean.User;
import com.xuan.respository.UserRepository;
import com.xuan.tools.EmailSender;

@Controller
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailSender emailSender;

	@PostMapping(path = "/signup")
	public @ResponseBody ResponseInfo signup(@RequestBody User user) {
		String email = user.getEmail();
		if (userRepository.findByEmail(email).size() == 0) {
			userRepository.save(user);
			return new ResponseInfo(200, "success");
		} else {
			return new ResponseInfo(400, "failed");
		}
	}

	@GetMapping(path = "/login")
	public @ResponseBody ResponseInfo login(@RequestBody User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		List<User> userList = userRepository.findByEmail(email);
		if (userList.size() != 0) {
			if (StringUtils.equals(password, userList.get(0).getPassword())) {
				return new ResponseInfo(200, "success", userList.get(0));
			} else {
				return new ResponseInfo(400, "wrong password");
			}

		} else {
			return new ResponseInfo(400, "please sign up");
		}
	}

	@PutMapping(path = "/password")
	public @ResponseBody ResponseInfo password(@RequestBody User user) {
		String newPassword = user.getPassword();
		emailSender.sendEmail("dreamlock0630@gmail.com", "test", "1111");
		return new ResponseInfo(200, "asd");
	}
}
