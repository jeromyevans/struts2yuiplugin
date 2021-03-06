package com.googlecode.struts2yuiplugin.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@StrutsTagSkipInheritance
@StrutsTag(name = "head", tldTagClass = "com.googlecode.struts2yuiplugin.views.jsp.ui.HeadTag", description = "Renders required YUI files")
public class Head extends UIBean {
    public static final String TEMPLATE = "yuihead";
    
    private String datepicker;
    private String autocompleter;
    private String languages;
    private String tabview;
    private String cssreset;
    private String cssfonts;
    private String cssgrids;
    private String cssbase;

    public Head(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void evaluateParams() {
        super.evaluateParams();
        
        if (this.datepicker != null) {
            this.parameters.put("datepicker", this.findValue(this.datepicker, Boolean.class));
        }
        if (this.autocompleter != null) {
            this.parameters.put("autocompleter", this.findValue(this.autocompleter, Boolean.class));
        }
        if (this.tabview != null){
        	 this.parameters.put("tabview", this.findValue(this.tabview, Boolean.class));
        }
        if (this.cssreset != null) {
        	this.parameters.put("cssreset", this.findValue(this.cssreset, Boolean.class));
        }
        if(this.cssfonts != null) {
        	this.parameters.put("cssfonts", this.findValue(this.cssfonts, Boolean.class));
        }
        if(this.cssgrids != null) {
        	this.parameters.put("cssgrids", this.findValue(this.cssgrids, Boolean.class));
        }
        if(this.cssbase != null){
        	this.parameters.put("cssbase", this.findValue(this.cssbase, Boolean.class));
        }
        if (this.languages != null) {
            String evalLanguages = this.findString(this.languages);
            if (evalLanguages != null)
                this.addParameter("languages", evalLanguages.split(","));
        } else {
            ActionContext context = ActionContext.getContext();
            HttpServletRequest request = (HttpServletRequest) context
                .get(StrutsStatics.HTTP_REQUEST);
            this.addParameter("languages", new String[] { request.getLocale()
                .getLanguage() });
        }
    }

    @Override
    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    @StrutsTagAttribute(description = "Include javascript files to use YUI datepicker", type = "Boolean", defaultValue = "false")
    public void setDatepicker(String datepicker) {
        this.datepicker = datepicker;
    }

    @StrutsTagAttribute(description = "Comma separated list of language names(2 lower case letters). Use to load resources. For example: de,ja")
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @StrutsTagAttribute(description = "Include javascript files to use YUI Autocomplete", type = "Boolean", defaultValue = "false")
    public void setAutocompleter(String autocompleter) {
        this.autocompleter = autocompleter;
    }
    
    @StrutsTagAttribute(description = "Include javascript files to use YUI TabView", type = "Boolean", defaultValue = "false")
    public void setTabview(String tabview){
    	this.tabview = tabview;
    }

    @StrutsTagAttribute(description = "Include YUI Reset CSS file", type = "Boolean", defaultValue = "false")
	public void setCssreset(String cssreset) {
		this.cssreset = cssreset;
	}

    @StrutsTagAttribute(description = "Include YUI Fonts CSS file", type = "Boolean", defaultValue = "false")
	public void setCssfonts(String cssfonts) {
		this.cssfonts = cssfonts;
	}

    @StrutsTagAttribute(description = "Include YUI Grids CSS file", type = "Boolean", defaultValue = "false")
	public void setCssgrids(String cssgrids) {
		this.cssgrids = cssgrids;
	}

    @StrutsTagAttribute(description = "Include YUI Base CSS file", type = "Boolean", defaultValue = "false")
	public void setCssbase(String cssbase) {
		this.cssbase = cssbase;
	}
    
    
    
    
}
