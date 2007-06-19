package com.googlecode.struts2yuiplugin.views;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.TagLibrary;

import com.googlecode.struts2yuiplugin.views.freemarker.tags.YUIModels;
import com.googlecode.struts2yuiplugin.views.velocity.components.DatePickerDirective;
import com.googlecode.struts2yuiplugin.views.velocity.components.HeadDirective;
import com.opensymphony.xwork2.util.ValueStack;

public class YUITagLibrary implements TagLibrary {

    public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req,
        HttpServletResponse res) {
        return new YUIModels(stack, req, res);
    }

    @SuppressWarnings("unchecked")
    public List<Class> getVelocityDirectiveClasses() {
        Class[] directives = new Class[] { HeadDirective.class, DatePickerDirective.class };
        return Arrays.asList(directives);
    }

}
