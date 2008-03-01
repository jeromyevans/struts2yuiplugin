package com.googlecode.struts2yuiplugin.components;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import com.opensymphony.xwork2.util.ValueStack;
import com.googlecode.struts2yuiplugin.tools.YUITools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.LinkedList;

/**
 * A YUI TabView
 */
@StrutsTag(name = "tabview", tldTagClass = "com.googlecode.struts2yuiplugin.views.jsp.ui.TabViewTag", description = "Renders a YUI TabView")
public class TabView extends ClosingYUIBean implements OGNLEvaluator {

    public static final String OPEN_TEMPLATE = "yuitabview";
    public static final String TEMPLATE = OPEN_TEMPLATE +"-close";

    /** List of tabs added to the TabvVew at creation time */
    private List<Tab> tabs;
    private String selectedTab;
    /** If no tab is selected the first will be automatically selected */
    private boolean noTabSelected;

    public TabView(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        super(valueStack, httpServletRequest, httpServletResponse);
        tabs = new LinkedList<Tab>();
        noTabSelected = true;
    }

    @Override
    public void evaluateParams() {
        super.evaluateParams();
        parameters.put("tabs", tabs);
        parameters.put("noTabSelected", noTabSelected);
    }

    @Override
    protected void evaluateExtraParams() {
        super.evaluateExtraParams();    
    }

    public String getDefaultOpenTemplate() {
        return OPEN_TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    /**
     * Declare a tab to for this TabView 
     * @param tab
     * @return
     */
    public boolean addTab(Tab tab) {
        if (selectedTab != null) {
            if (selectedTab.equals(tab.getId())) {
                tab.setSelected(true);
            }
        }
        if (tab.isSelected()) {
            noTabSelected = false;
        }
        return tabs.add(tab);
    }

    @StrutsTagAttribute(description = "The ID of a tab to make initially selected", required = false)
    public void setSelectedTab(String selectedTab) {
        if (selectedTab != null) {
            this.selectedTab = evaluateExpression(selectedTab);
        }
    }

    /**
     * Evaluates the OGNL expression
     *
     * @param expr OGNL expression.
     * @return the String value found.
     */
    public String evaluateExpression(String expr) {
        return super.findString(expr);
    }


}
