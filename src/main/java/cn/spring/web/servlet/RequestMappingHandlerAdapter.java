package cn.spring.web.servlet;

import cn.spring.beans.BeansException;
import cn.spring.web.*;
import cn.spring.web.bind.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 请求处理类
 */
public class RequestMappingHandlerAdapter implements HandlerAdapter {
	WebApplicationContext wac = null;
	private WebBindingInitializer webBindingInitializer = null;
	private DefaultHttpMessageConverter httpMessageConverter = null;

	public RequestMappingHandlerAdapter(WebApplicationContext wac) {
		this.wac = wac;
		try {
			this.webBindingInitializer = (WebBindingInitializer) this.wac.getBean("webBindingInitializer");
			this.httpMessageConverter = (DefaultHttpMessageConverter) this.wac.getBean("httpMessageConverter");

		} catch (BeansException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return handleInternal(request, response, (HandlerMethod) handler);
	}

	private ModelAndView handleInternal(HttpServletRequest request, HttpServletResponse response,
										HandlerMethod handler) {
		ModelAndView mv = null;

		try {
			invokeHandlerMethod(request, response, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;

	}

	protected void invokeHandlerMethod(HttpServletRequest request,
									   HttpServletResponse response, HandlerMethod handlerMethod) throws Exception {


		WebDataBinderFactory binderFactory = new WebDataBinderFactory();

		Parameter[] methodParameters = handlerMethod.getMethod().getParameters();
		Object[] methodParamObjs = new Object[methodParameters.length];

		int i = 0;
		for (Parameter methodParameter : methodParameters) {
			Object methodParamObj = methodParameter.getType().newInstance();
			WebDataBinder wdb = binderFactory.createBinder(request, methodParamObj, methodParameter.getName());
			webBindingInitializer.initBinder(wdb);
			wdb.bind(request);
			methodParamObjs[i] = methodParamObj;
			i++;
		}

		Method invocableMethod = handlerMethod.getMethod();
		Object returnObj = invocableMethod.invoke(handlerMethod.getBean(), methodParamObjs);

		if (invocableMethod.isAnnotationPresent(ResponseBody.class)){ //ResponseBody
			this.httpMessageConverter.write(returnObj, response);
		}
		response.getWriter().append(returnObj.toString());

	}

	public WebBindingInitializer getWebBindingInitializer() {
		return webBindingInitializer;
	}

	public void setWebBindingInitializer(WebBindingInitializer webBindingInitializer) {
		this.webBindingInitializer = webBindingInitializer;
	}

}
