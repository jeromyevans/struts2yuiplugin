package com.googlecode.struts2yuiplugin.views.freemarker.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

public class DatePickerModels {
    private ValueStack stack;
    private HttpServletRequest req;
    private HttpServletResponse res;
    private DatePickerModel datepicker;
    
    public DatePickerModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        this.stack = stack;
        this.req = req;
        this.res = res;
    }
    
    public DatePickerModel getBind() {
        if (datepicker == null) {
            datepicker = new DatePickerModel(stack, req, res);
        }

        return datepicker;
    }
}
