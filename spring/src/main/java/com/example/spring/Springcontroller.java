package com.example.spring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Springcontroller {
	@Autowired
	Springservice springservice;

	@PostMapping("/ins")
	public Map<String, Object> insert(@RequestBody Springpojo springpojo) {
		return springservice.insert(springpojo);
	}
	
	@GetMapping("/in")
	public List display()
	{
		return springservice.display();
	}
}
