package cn.spring.webTest.controller;

import cn.spring.entity.ApiParam;
import cn.spring.entity.User;
import cn.spring.test.service.UserService;
import cn.spring.web.RequestMapping;
import cn.spring.web.bind.ResponseBody;

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

	@RequestMapping("/test3")
	@ResponseBody
	public User doTest3(){
		UserService userService = new UserService();
		return userService.getUserInfo();
	}

}
