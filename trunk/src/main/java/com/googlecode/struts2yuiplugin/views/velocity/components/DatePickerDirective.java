package com.googlecode.struts2yuiplugin.views.velocity.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.googlecode.struts2yuiplugin.components.DatePicker;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see DateTimePicker
 */
public class DatePickerDirective extends YUIAbstractDirective {

    @Override
    protected Component getBean(ValueStack stack, HttpServletRequest req,
        HttpServletResponse res) {
        return new DatePicker(stack, req, res);
    }

    @Override
    public String getBeanName() {
        return "datepicker";
    }
}
