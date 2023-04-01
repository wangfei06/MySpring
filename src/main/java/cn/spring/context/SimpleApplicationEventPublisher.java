package cn.spring.context;

import cn.spring.context.ApplicationEvent;
import cn.spring.context.ApplicationEventPublisher;
import cn.spring.context.ApplicationListener;

import java.util.ArrayList;
import java.util.List;

public class SimpleApplicationEventPublisher implements ApplicationEventPublisher {
	List<ApplicationListener> listeners = new ArrayList<>();

	@Override
	public void publishEvent(ApplicationEvent event) {
		for (ApplicationListener listener : listeners) {
			listener.onApplicationEvent(event);
		}
	}


	@Override
	public void addApplicationListener(ApplicationListener listener) {
		this.listeners.add(listener);
	}


}
