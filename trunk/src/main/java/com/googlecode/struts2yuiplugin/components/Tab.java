package com.googlecode.struts2yuiplugin.components;

import com.opensymphony.xwork2.util.ValueStack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import java.io.Writer;

/**
 * The model for a Tab in a YUI TabView
 */
@StrutsTag(name = "tab", tldTagClass = "com.googlecode.struts2yuiplugin.views.jsp.ui.TabTag", description = "Renders a Tab in a YUI TabView")
public class Tab extends ClosingYUIBean implements OGNLEvaluator {

    private static final String OPEN_TEMPLATE = "yuitab";
    private static final String TEMPLATE = OPEN_TEMPLATE +"-close";

    private boolean selected;

    public Tab(ValueStack valueStack, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        super(valueStack, httpServletRequest, httpServletResponse);
    }

    @Override
    public void evaluateParams() {
        super.evaluateParams();

        addParameter("selected", selected);
    }

    public String getDefaultOpenTemplate() {
        return OPEN_TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
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

    @Override
    public boolean start(Writer writer) {
        return true; // evaluate body
    }

    /** This component uses the body so it needs to be buffered */
    @Override
    public boolean usesBody() {
        return true;
    }

    /** There is no template merging and don't write to output */
    @Override
    public boolean end(Writer writer, String body) {
        evaluateParams();
        parameters.put("body", body);
        popComponentStack();
        return false;  // don't evaluate body again
    }

    public String getBody() {
        return (String) parameters.get("body");
    }

    public String getId() {
        return (String) parameters.get("id");
    }

    public String getLabel() {
        return (String) parameters.get("label");
    }

    public boolean isSelected() {
        return selected;
    }

    public String getCssClass() {
        return (String) parameters.get("cssClass");
    }

    @Override
    @StrutsTagAttribute(description = "HTML id attribute", required = true, rtexprvalue = true)
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    @StrutsTagAttribute(description = "Label expression used for rendering a element specific label", required = true)
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @StrutsTagAttribute(description = "Identifies a tab that is initially selected", required = false)
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
