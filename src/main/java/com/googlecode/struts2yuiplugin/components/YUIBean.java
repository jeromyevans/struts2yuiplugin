package com.googlecode.struts2yuiplugin.components;

import com.googlecode.struts2yuiplugin.tools.YUITools;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * YUIBean is a standard base-class for the YUI components.
 * The main purpose is to remove the attributes inherited from UIBean and to support the 'noscript' feature
 *
 */
public abstract class YUIBean extends UIBean {

    private String widget;
    private String noscript;

    protected YUIBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        super(valueStack, httpServletRequest, httpServletResponse);
    }

    @Override
    public void evaluateParams() {
        super.evaluateParams();

        populateWidgetName();

        if (noscript != null) {
            this.addParameter("noscript", findValue(noscript, Boolean.class));
        } 

        this.addParameter("defaultHandler", true);
    }

    /**
     * Generate the javascript name for this widget if not explictly specified.
     * The name is generated from the escaped Id generated by UIBean
     */
    private void populateWidgetName() {
        String widgetName;
        if (widget != null) {
            widgetName = widget;
        } else {
            widgetName = YUITools.sanitizeForJavascript(getId()+"Widget");
        }
        addParameter("widget", widgetName);
    }


    @Override
    @StrutsTagAttribute(description = "HTML id attribute", rtexprvalue = true)
    public void setId(String id) {
        super.setId(id);
    }

    @StrutsTagAttribute(description = "A unique javascript name to assign to this widget.  Use to specify a namespace.", required = false)
    public void setWidget(String widget) {
        this.widget = widget;
    }

    @StrutsTagAttribute(description = "If true the tag will not include any associated javascript", required = false, defaultValue = "false")
    public void setNoscript(String noscript) {
        this.noscript = noscript;
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnclick(String string) {
        super.setOnclick(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOndblclick(String string) {
        super.setOndblclick(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnmousedown(String string) {
        super.setOnmousedown(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnmouseup(String string) {
        super.setOnmouseup(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnmouseover(String string) {
        super.setOnmouseover(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnmousemove(String string) {
        super.setOnmousemove(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnmouseout(String string) {
        super.setOnmouseout(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnfocus(String string) {
        super.setOnfocus(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnblur(String string) {
        super.setOnblur(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnkeypress(String string) {
        super.setOnkeypress(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnkeydown(String string) {
        super.setOnkeydown(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnkeyup(String string) {
        super.setOnkeyup(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnselect(String string) {
        super.setOnselect(string);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported - use the YUI event utility")
    public void setOnchange(String string) {
        super.setOnchange(string);
    }
}
