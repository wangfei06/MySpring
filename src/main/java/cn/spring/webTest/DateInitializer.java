package cn.spring.webTest;

import cn.spring.beans.CustomNumberEditor;
import cn.spring.web.WebBindingInitializer;
import cn.spring.web.WebDataBinder;

import java.util.Date;

public class DateInitializer implements WebBindingInitializer {
	@Override
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(Date.class,"yyyy-MM-dd", false));
	}
}
