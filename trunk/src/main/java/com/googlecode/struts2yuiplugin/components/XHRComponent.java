package com.googlecode.struts2yuiplugin.components;

import org.apache.struts2.views.annotations.StrutsTagAttribute;

/**
 * Properties common to components that perform XHR operations
 */
public interface XHRComponent {

    /**
     * An alterative javascript callback function for the YUI Connection Manager response
     */
    @StrutsTagAttribute(description = "An alternative javascript callback for the YUI Connection Manager's response", required = false)
    void setCallback(String callback);
    
    /**
     * The ID Of the form to include in the request
     */
    @StrutsTagAttribute(description = "The ID of the form to include in the request", required = false)
    void setFormId(String formId);

    /**
     * If optional the href to send the request to.  I not provided, the form's action will used
     */
    @StrutsTagAttribute(description = "The URL to make the request to if not than the form's action", required = false, rtexprvalue = true)
    void setHref(String href);

    /**
     * HTTP method to use when HREF is specified. Default is GET
     */
    @StrutsTagAttribute(description = "The HTTP method to use", required = false, defaultValue = "GET")
    void setMethod(String method);
}
