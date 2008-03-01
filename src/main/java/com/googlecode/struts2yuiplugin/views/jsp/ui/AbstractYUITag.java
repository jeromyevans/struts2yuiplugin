package com.googlecode.struts2yuiplugin.views.jsp.ui;

import com.googlecode.struts2yuiplugin.components.YUIBean;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

/**
 * Includes attributes common for all the YUI Tags
 */
public abstract class AbstractYUITag extends AbstractUITag {

    private String widget;
    private String noscript;

    @Override
    protected void populateParams() {
        super.populateParams();

        YUIBean yuiBean = (YUIBean) this.component;
        yuiBean.setWidget(widget);
        yuiBean.setNoscript(noscript);
    }

    /**
     * Specify the javascript name of the widget
     *
     * @param widget   the javascipt name of the widget
     **/
    public void setWidget(String widget) {
        this.widget = widget;
    }

    /**
     * Disable inclusion of javascript
     *
     * @param noscript   true to disable inclusion of javascript (default is false)
     **/
    public void setNoscript(String noscript) {
        this.noscript = noscript;
    }
}
