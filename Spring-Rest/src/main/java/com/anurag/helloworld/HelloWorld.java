package com.anurag.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class HelloWorld {
	//@RequestMapping(method=RequestMethod.GET,path="/hello")
	@GetMapping(path="/hello")
	public String helloBoot() {
		return "Hello World";
	}
	
	@GetMapping(path="/helloBean")
	public HelloWorldBean helloBeanBoot() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path="/hello/pathVar/{name}")
	public HelloWorldBean helloPathVarible(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World Bean, %s",name));
	}

}
