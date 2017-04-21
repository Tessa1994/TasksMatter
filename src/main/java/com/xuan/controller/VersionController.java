package com.xuan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	@GetMapping(path = "version")
	public String getVersion() {
		return "1.0";
	}

}
