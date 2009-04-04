package com.googlecode.struts2yuiplugin.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.googlecode.struts2yuiplugin.components.Head;
import com.opensymphony.xwork2.util.ValueStack;

public class HeadTag extends AbstractUITag {
        
    private String datepicker;
    private String autocompleter;
    private String languages;
    private String tabview;
    private String cssreset;
    private String cssfonts;
    private String cssgrids;
    private String cssbase;

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
        head.setLanguages(this.languages);
        head.setAutocompleter(this.autocompleter);
        head.setTabview(this.tabview);
        head.setCssreset(this.cssreset);
        head.setCssfonts(this.cssfonts);
        head.setCssgrids(this.cssgrids);
        head.setCssbase(this.cssbase);
        
    }

    public void setDatepicker(String datepicker) {
        this.datepicker = datepicker;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public void setAutocompleter(String autocompleter) {
        this.autocompleter = autocompleter;
    }
    
    public void setTabview(String tabview) {
    	this.tabview = tabview;
    }

	public void setCssreset(String cssreset) {
		this.cssreset = cssreset;
	}

	public void setCssfonts(String cssfonts) {
		this.cssfonts = cssfonts;
	}

	public void setCssgrids(String cssgrids) {
		this.cssgrids = cssgrids;
	}

	public void setCssbase(String cssbase) {
		this.cssbase = cssbase;
	}
    
    
}
