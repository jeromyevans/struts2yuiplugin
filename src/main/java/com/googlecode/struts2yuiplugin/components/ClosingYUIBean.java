package com.googlecode.struts2yuiplugin.components;

import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.util.ValueStack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

/**
 * A specialization of the YUI Bean that handles open and closing tag templates
 *
 */
public abstract class ClosingYUIBean extends YUIBean {

    private static final Log LOG = LogFactory.getLog(ClosingYUIBean.class);

    public ClosingYUIBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    private String openTemplate;

    public abstract String getDefaultOpenTemplate();

    @StrutsTagAttribute(description="Set template to use for opening the rendered html.")
    public void setOpenTemplate(String openTemplate) {
        this.openTemplate = openTemplate;
    }

    public boolean start(Writer writer) {
        boolean result = super.start(writer);
        try {
            evaluateParams();

            mergeTemplate(writer, buildTemplateName(openTemplate, getDefaultOpenTemplate()));
        } catch (Exception e) {
            LOG.error("Could not open template", e);
            e.printStackTrace();
        }

        return result;
    }
}
