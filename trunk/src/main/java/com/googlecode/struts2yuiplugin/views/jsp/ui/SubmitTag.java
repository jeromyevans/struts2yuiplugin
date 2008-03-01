package com.googlecode.struts2yuiplugin.views.jsp.ui;

import com.googlecode.struts2yuiplugin.components.Submit;
import com.googlecode.struts2yuiplugin.components.XHRComponent;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.FormTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.Tag;

/**
 * Tag for a YUI button widget of type Submit
 */
public class SubmitTag extends AbstractYUITag implements XHRComponent {

    private String formId;
    private String href;
    private String method;
    private String target;
    private String callback;
    private String clickListener;

    @Override
    protected void populateParams() {
        super.populateParams();

        Submit button = (Submit) this.component;
        if (formId == null) {
            formId = findParentFormId();
        }
        button.setFormId(formId);
        button.setHref(href);
        button.setMethod(method);
        button.setTarget(target);
        button.setCallback(callback);
        button.setClickListener(clickListener);
    }

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new Submit(valueStack, httpServletRequest, httpServletResponse);
    }


    /** Lookup the form that contains this submit button. It will only be found it it's a JSP tag */
    private String findParentFormId() {
        String formId = null;
        Tag parent = this;
        while (((parent = parent.getParent()) != null) && (formId == null)) {
            if (FormTag.class.isAssignableFrom(parent.getClass())) {
                formId = ((FormTag) parent).getId();
            }
        }
        return formId;
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
