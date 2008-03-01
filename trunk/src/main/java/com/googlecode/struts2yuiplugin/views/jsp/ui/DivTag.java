package com.googlecode.struts2yuiplugin.views.jsp.ui;

import com.googlecode.struts2yuiplugin.components.Anchor;
import com.googlecode.struts2yuiplugin.components.Div;
import com.googlecode.struts2yuiplugin.components.XHRComponent;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A div that can load its own HTML content via XHR
 * 
 */
public class DivTag extends AbstractYUITag implements XHRComponent {

    private String formId;
    private String href;
    private String method;
    private String callback;

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new Div(valueStack, httpServletRequest, httpServletResponse);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Div div = (Div) this.component;
        div.setFormId(formId);
        div.setHref(href);
        div.setMethod(method);
        div.setCallback(callback);
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

}
