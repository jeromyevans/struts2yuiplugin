package com.googlecode.struts2yuiplugin.components;

import com.googlecode.struts2yuiplugin.tools.YUITools;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Bean for a YUI button widget of type Submit
 * A submit button needs to be associated with a form, either by containment or through formId
 */
@StrutsTag(name = "submit", tldTagClass = "com.googlecode.struts2yuiplugin.views.jsp.ui.SubmitTag", description = "Renders a YUI button of type Submit")
public class Submit extends YUIBean implements XHRComponent, OGNLEvaluator {

    private static final String TEMPLATE = "yuisubmit";

    private XHRSupport xhrSupport;
    private String target;
    private String clickListener;

    public Submit(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        super(valueStack, httpServletRequest, httpServletResponse);
        xhrSupport = new XHRSupport(this);
    }

    @Override
    public void evaluateParams() {
        super.evaluateParams();

        xhrSupport.evaluateParams(this);

        populateClickListenerName();
        if (target != null) {
            addParameter("target", evaluateExpression(target));
        }
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    /**
     * Generate the javacscript click listener name if not explictly specified
     * The name is generated from the id but sanitized for javascript
     */
    private void populateClickListenerName() {
        String listenerName;
        if (clickListener != null) {
            listenerName = evaluateExpression(clickListener);
            addParameter("customClickListener", true);
        } else {
            listenerName = YUITools.sanitizeForJavascript(getId()+"Click");
            addParameter("customClickListener", false);
        }
        addParameter("clickListener", listenerName);
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
     * Optional the href to send the request to.  If not provided, the form's action will used
     */
    @StrutsTagAttribute(description = "The URL to make the request to if other than the form's action", required = false)
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
     * ID of the target div
     */
    @StrutsTagAttribute(description = "The ID of the target div to render the result", required = false)
    public void setTarget(String target) {
        this.target = target;
    }

     /**
     * The name of an alternative javascript callback for the YUI Connection Manager's respons
     */
    @StrutsTagAttribute(description = "An alternative javascript callback for the YUI Connection Manager's response", required = false)
    public void setCallback(String callback) {
        xhrSupport.setCallback(callback);
    }

    /**
     * An alternative javascript listener function for the click event
     */
    @StrutsTagAttribute(description = "An alternative listener for the click event", required = false)
    public void setClickListener(String listener) {
        this.clickListener = listener;
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
