package cn.spring.web;

import cn.spring.beans.AbstractPropertyAccessor;
import cn.spring.beans.PropertyEditor;
import cn.spring.beans.PropertyValues;
import cn.spring.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebDataBinder {
    private Object target;
    private Class<?> clz;

    private String objectName;
    AbstractPropertyAccessor propertyAccessor;

    public WebDataBinder(Object target) {
        this(target,"");
    }
    public WebDataBinder(Object target, String targetName) {
        this.target = target;
        this.objectName = targetName;
        this.clz = this.target.getClass();
        this.propertyAccessor = new BeanWrapperImpl(this.target);
    }

    public void bind(HttpServletRequest request) {
        PropertyValues mpvs = assignParameters(request);
        addBindValues(mpvs, request);
        doBind(mpvs);
    }

    private void doBind(PropertyValues mpvs) {
        applyPropertyValues(mpvs);

    }

    protected void applyPropertyValues(PropertyValues mpvs) {
        getPropertyAccessor().setPropertyValues(mpvs);
    }

    protected AbstractPropertyAccessor getPropertyAccessor() {
        return this.propertyAccessor;
    }

    /**
     * 将HttpServletRequest中的参数放入Map中
     * @param request
     * @return
     */
    private PropertyValues assignParameters(HttpServletRequest request) {
        Map<String,Object> map = WebUtils.getParametersStartingWith(request, "");

        return new PropertyValues(map);
    }

    public void registerCustomEditor(Class<?> requiredType, PropertyEditor propertyEditor) {
        getPropertyAccessor().registerCustomEditor(requiredType, propertyEditor);
    }

    protected void addBindValues(PropertyValues mpvs, HttpServletRequest request) {
    }
}
