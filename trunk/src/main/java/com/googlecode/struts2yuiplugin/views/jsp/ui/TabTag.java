package com.googlecode.struts2yuiplugin.views.jsp.ui;

import org.apache.struts2.components.Component;
import org.apache.struts2.dispatcher.Dispatcher;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.inject.Container;
import com.googlecode.struts2yuiplugin.components.Tab;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

/**
 * A tab for a YUI TabView
 *
 */
public class TabTag extends AbstractYUITag {

    private boolean selected;

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new Tab(valueStack, httpServletRequest, httpServletResponse);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Tab tab = (Tab) this.component;        
        tab.setSelected(selected);

        TabViewTag tabView = (TabViewTag) findAncestorWithClass(this, TabViewTag.class);
        if (tabView != null) {
            tabView.addTab(tab);
        }
    }

//    @Override
//    public int doEndTag() throws JspException {
//        component.end(pageContext.getOut(), getBody());
//        component = null;
//        return SKIP_BODY;
//    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
