package com.googlecode.struts2yuiplugin.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.TagLibrary;

import com.opensymphony.xwork2.util.ValueStack;

public class YUITagLibrary implements TagLibrary {

    public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req,
        HttpServletResponse res) {

        return null;
    }

    public List<Class> getVelocityDirectiveClasses() {
        // TODO Auto-generated method stub
        return null;
    }

}
