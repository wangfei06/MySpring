package cn.spring.webTest.controller;

import cn.spring.entity.ApiParam;
import cn.spring.web.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class HelloWorldBean {
	@RequestMapping("/")
	public String helloWorld(){
		return "Hello World";
	}

	@RequestMapping("/test1")
	public String doTest1() {
		return "test 1, hello world!";
	}

	/**
	 * 测试DataBind
	 * @param apiParam 接口参数类
	 * @return msg
	 */
	@RequestMapping("/test2")
	public String doTest2(ApiParam apiParam){
		System.out.println("apiParam = " + apiParam.getName());
		return "params are printed";
	}

}
