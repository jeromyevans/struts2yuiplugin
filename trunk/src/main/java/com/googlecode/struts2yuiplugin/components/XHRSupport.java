package com.googlecode.struts2yuiplugin.components;

import com.googlecode.struts2yuiplugin.tools.YUITools;
import org.apache.struts2.components.UIBean;

/**
 * Delegatable implementation of an XHRComponent.  Provides common behaviour for evaluating the parameters
 */
public class XHRSupport implements XHRComponent {

    private static final String DEFAULT_METHOD = "GET";

    private OGNLEvaluator eval;

    private String callback;
    private String formId;
    private String href;
    private String method;

    public XHRSupport(OGNLEvaluator eval) {
        this.eval = eval;
    }

    /**
     * Adds the common XHR parameters to the UIBean
     * @param uiBean bean to be updated
     */
    public void evaluateParams(UIBean uiBean) {
        populateCallbackName(uiBean);
        populateMethod(uiBean);

        if (formId != null) {
            uiBean.addParameter("formId", eval.evaluateExpression(formId));
        }

        if (href != null) {
            uiBean.addParameter("href", eval.evaluateExpression(href));
        }
    }

    /**
     * Generate the javascript onclick callback name for this widget if not explictly specified.
     * The name is generated from the id but sanitized for javascript
     */
    private void populateCallbackName(UIBean uiBean) {
        String callbackName;
        if (callback != null) {
            callbackName = eval.evaluateExpression(callback);
            uiBean.addParameter("customCallback", true);
        } else {
            callbackName = YUITools.sanitizeForJavascript(uiBean.getId()+"Callback");
            uiBean.addParameter("customCallback", false);
        }
        uiBean.addParameter("callback", callbackName);
    }

    /** Populates the http method property */
    private void populateMethod(UIBean uiBean) {
        String methodName;
        if (method != null) {
            methodName = eval.evaluateExpression(method);
        } else {
            methodName = DEFAULT_METHOD;
        }
        uiBean.addParameter("method", methodName);
    }

    /** An alterative javascript callback function for the YUI Connection Manager's response */
    public void setCallback(String callback) {
        this.callback = callback;
    }

    /**
     * The ID Of the form to include in the request
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }

    /**
     * If the href is provided the widget will send the request to the specified URL.
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * HTTP method to use when HREF is specified. Default is GET
     */
    public void setMethod(String method) {
        this.method = method;
    }
}
