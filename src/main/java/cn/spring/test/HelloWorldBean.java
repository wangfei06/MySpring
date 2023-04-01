package cn.spring.test;

import cn.spring.web.RequestMapping;


public class HelloWorldBean {
	@RequestMapping("/test1")
	public String doTest1() {
		return "test 1, hello world!";
	}
	@RequestMapping("/test2")
	public String doTest2() {
		return "test 2, hello world!";
	}
}
