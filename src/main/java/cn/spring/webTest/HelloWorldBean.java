package cn.spring.webTest;

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
