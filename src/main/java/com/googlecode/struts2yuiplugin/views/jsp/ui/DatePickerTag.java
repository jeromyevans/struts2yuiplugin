package com.googlecode.struts2yuiplugin.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.googlecode.struts2yuiplugin.components.DatePicker;
import com.opensymphony.xwork2.util.ValueStack;

public class DatePickerTag extends AbstractUITag {
    protected String startDate;
    protected String endDate;
    protected String autoClose;
    protected String iconPath;
    protected String iconCssClass;
    protected String formatFunction;
    protected String mode;

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req,
        HttpServletResponse res) {
        return new DatePicker(stack, req, res);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        DatePicker datePicker = (DatePicker) this.component;
        datePicker.setStartDate(this.startDate);
        datePicker.setEndDate(this.endDate);
        datePicker.setAutoClose(this.autoClose);
        datePicker.setIconCssClass(this.iconCssClass);
        datePicker.setIconPath(this.iconPath);
        datePicker.setFormatFunction(this.formatFunction);
        datePicker.setMode(this.mode);
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setAutoClose(String autoClose) {
        this.autoClose = autoClose;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setIconCssClass(String iconCssClass) {
        this.iconCssClass = iconCssClass;
    }

    public void setFormatFunction(String formatFunction) {
        this.formatFunction = formatFunction;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

}
