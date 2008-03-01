package com.googlecode.struts2yuiplugin.views.jsp.ui;

import com.googlecode.struts2yuiplugin.components.XHRComponent;
import com.googlecode.struts2yuiplugin.components.Submit;
import com.googlecode.struts2yuiplugin.components.PushButton;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.FormTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.Tag;

/**
 * Tag for a YUI button widget of type PushButton
 */
public class PushButtonTag extends AbstractYUITag implements XHRComponent {

    private String formId;
    private String href;
    private String method;
    private String target;
    private String callback;
    private String clickListener;

    @Override
    protected void populateParams() {
        super.populateParams();

        PushButton button = (PushButton) this.component;

        button.setFormId(formId);
        button.setHref(href);
        button.setMethod(method);
        button.setTarget(target);
        button.setCallback(callback);
        button.setClickListener(clickListener);
    }

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new PushButton(valueStack, httpServletRequest, httpServletResponse);
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

    public void setTarget(String target) {
        this.target = target;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public void setClickListener(String clickListener) {
        this.clickListener = clickListener;
    }

}
