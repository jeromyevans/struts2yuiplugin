package com.googlecode.struts2yuiplugin.views.jsp.ui;

import com.googlecode.struts2yuiplugin.components.Anchor;
import com.googlecode.struts2yuiplugin.components.XHRComponent;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple anchor with a default click event handler that makes an asynchronous request
 *
 */
public class AnchorTag extends AbstractYUITag implements XHRComponent {

    private String formId;
    private String href;
    private String method;
    private String target;
    private String callback;
    private String clickListener;

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new Anchor(valueStack, httpServletRequest, httpServletResponse);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Anchor anchor = (Anchor) this.component;
        anchor.setFormId(formId);
        anchor.setHref(href);
        anchor.setMethod(method);
        anchor.setTarget(target);
        anchor.setCallback(callback);
        anchor.setClickListener(clickListener);
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
