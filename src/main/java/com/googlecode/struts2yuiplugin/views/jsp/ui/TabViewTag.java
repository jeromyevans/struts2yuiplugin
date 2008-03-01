package com.googlecode.struts2yuiplugin.views.jsp.ui;

import org.apache.struts2.components.Component;
import com.opensymphony.xwork2.util.ValueStack;
import com.googlecode.struts2yuiplugin.components.TabView;
import com.googlecode.struts2yuiplugin.components.Tab;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A YUI TabbedView
 */
public class TabViewTag extends AbstractYUITag {

    private String selectedTab;

    @Override
    public Component getBean(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new TabView(valueStack, httpServletRequest, httpServletResponse);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        TabView tabView = (TabView) this.component;
        tabView.setSelectedTab(selectedTab);
    }

    /** Add a tab to this tab view */
    public boolean addTab(Tab tab) {
        TabView tabView = (TabView) this.component;
        return tabView.addTab(tab);
    }


    /** Optional id of the tab to make initially selected */
    public void setSelectedTab(String selectedTab) {
        this.selectedTab = selectedTab;
    }
}
