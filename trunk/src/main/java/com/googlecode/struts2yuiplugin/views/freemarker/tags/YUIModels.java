package com.googlecode.struts2yuiplugin.views.freemarker.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

public class YUIModels {
    private ValueStack stack;
    private HttpServletRequest req;
    private HttpServletResponse res;
    private DatePickerModel datepicker;

    public YUIModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        this.stack = stack;
        this.req = req;
        this.res = res;
    }

    public DatePickerModel getDatepicker() {
        if (this.datepicker == null) {
            this.datepicker = new DatePickerModel(this.stack, this.req, this.res);
        }

        return this.datepicker;
    }
}
