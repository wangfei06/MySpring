package cn.spring.webTest.controller;

import cn.spring.web.RequestMapping;


public class HelloWorldBean {
	@RequestMapping("/")
	public String helloWorld(){
		return "Hello World";
	}

	@RequestMapping("/test1")
	public String doTest1() {
		return "test 1, hello world!";
	}

}
