package com.googlecode.struts2yuiplugin.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.googlecode.struts2yuiplugin.components.Head;
import com.opensymphony.xwork2.util.ValueStack;

public class HeadTag extends AbstractUITag {
    private String datepicker;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req,
        HttpServletResponse res) {
        return new Head(stack, req, res);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Head head = (Head) this.component;
        head.setDatepicker(this.datepicker);
    }

    public void setDatepicker(String datepicker) {
        this.datepicker = datepicker;
    }
}
