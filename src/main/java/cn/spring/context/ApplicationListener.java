package cn.spring.context;

import java.util.EventListener;

public class ApplicationListener implements EventListener {
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.toString());
	}
}
