package com.wl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test1")
public class Test1Controller {

	@GetMapping("f1")
	public String f1() {
		return "f1";
	}
}
