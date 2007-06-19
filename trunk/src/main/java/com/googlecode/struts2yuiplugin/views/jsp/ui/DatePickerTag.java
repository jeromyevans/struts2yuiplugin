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
    
    public Component getBean(ValueStack stack, HttpServletRequest req,
        HttpServletResponse res) {
        return new DatePicker(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        DatePicker datePicker = (DatePicker) component;
        datePicker.setStartDate(startDate);
        datePicker.setEndDate(endDate);
        datePicker.setAutoClose(autoClose);
        datePicker.setIconCssClass(iconCssClass);
        datePicker.setIconPath(iconPath);
        datePicker.setFormatFunction(formatFunction);
        datePicker.setMode(mode);
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
