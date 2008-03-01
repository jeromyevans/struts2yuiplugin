package com.googlecode.struts2yuiplugin.components;

import com.opensymphony.xwork2.util.ValueStack;
import com.googlecode.struts2yuiplugin.tools.YUITools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTag;

/**
 * A div that can load its own HTML content via XHR
 */
@StrutsTag(name = "div", tldTagClass = "com.googlecode.struts2yuiplugin.views.jsp.ui.DivTag", description = "Renders a div with content loaded via XHR")
public class Div extends ClosingYUIBean implements XHRComponent, OGNLEvaluator {

    public static final String OPEN_TEMPLATE = "yuidiv";
    public static final String TEMPLATE = OPEN_TEMPLATE +"-close";

    private XHRSupport xhrSupport;

    public Div(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        super(valueStack, httpServletRequest, httpServletResponse);
        xhrSupport = new XHRSupport(this);
    }

    @Override
    public void evaluateParams() {
        super.evaluateParams();
        xhrSupport.evaluateParams(this);

        populateOnLoadListenerName();
        addParameter("target", getId()); // target is self
    }

    /**
      * Generate the javascript onload listener name if not explictly specified
      * The name is generated from the id but sanitized for javascript
      */
    private void populateOnLoadListenerName() {
        String onLoadListener = YUITools.sanitizeForJavascript(getId()+"OnLoad");
        addParameter("onLoadListener", onLoadListener);
    }

    public String getDefaultOpenTemplate() {
        return OPEN_TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    @Override
    @StrutsTagAttribute(description = "Mandatory id attribute", required = true, rtexprvalue = true)
    public void setId(String id) {
        super.setId(id);
    }

    /**
     * The optional ID of the form to include in the request
     */
    @StrutsTagAttribute(description = "The ID of the form to include in the request", required = false)
    public void setFormId(String formId) {
        xhrSupport.setFormId(formId);
    }

    /**
     * Optional href to send the request to.  If not provided, the form's action will used
     */
    @StrutsTagAttribute(description = "The URL to make the request to if other than the form's action", required = false, rtexprvalue = true)
    public void setHref(String href) {
        xhrSupport.setHref(href);
    }

    /**
     * HTTP method to use when HREF is specified. Default is GET
     */
    @StrutsTagAttribute(description = "The HTTP method to use", required = false, defaultValue = "GET")
    public void setMethod(String method) {
        xhrSupport.setMethod(method);
    }

     /**
     * The name of an alternative javascript callback for the YUI Connection Manager's response
     */
    @StrutsTagAttribute(description = "An alternative javascript callback for the YUI Connection Manager's response", required = false)
    public void setCallback(String callback) {
        xhrSupport.setCallback(callback);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setDisabled(String disabled) {
        super.setDisabled(disabled);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setLabelSeparator(String labelseparator) {
        super.setLabelSeparator(labelseparator);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setLabelposition(String labelPosition) {
        super.setLabelposition(labelPosition);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setRequiredposition(String requiredposition) {
        super.setRequiredposition(requiredposition);    
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setRequired(String required) {
        super.setRequired(required);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setTabindex(String tabindex) {
        super.setTabindex(tabindex);
    }

    @Override
    @StrutsTagAttribute(description = "Not supported")
    public void setAccesskey(String accesskey) {
        super.setAccesskey(accesskey);
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
