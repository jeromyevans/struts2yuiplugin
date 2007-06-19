package com.googlecode.struts2yuiplugin.components;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "datepicker", tldTagClass = "com.googlecode.struts2yuiplugin.views.jsp.ui.DatePickerTag", description = "Renders YUI datepicker")
public class DatePicker extends UIBean {
    public static final String TEMPLATE = "yuidatepicker";
    final protected static Log LOG = LogFactory.getLog(DatePicker.class);
    final protected static DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    final protected static DateFormat PAGE_DATE_FORMAT = new SimpleDateFormat("MM/yyyy");
    final private static SimpleDateFormat RFC3339_FORMAT = new SimpleDateFormat(
        "yyyy-MM-dd");

    protected String startDate;
    protected String endDate;
    protected String mode;
    protected String autoClose;
    protected String iconPath;
    protected String iconCssClass;
    protected String formatFunction;
    
    public DatePicker(ValueStack stack, HttpServletRequest request,
        HttpServletResponse response) {
        super(stack, request, response);
    }

    public void evaluateParams() {
        super.evaluateParams();

        if (value != null)
            addParameter("value", format(findValue(value)));
        if (startDate != null)
            addParameter("startDate", format(findValue(startDate)));
        if (endDate != null)
            addParameter("endDate", format(findValue(endDate)));
        if (mode != null)
            addParameter("mode", findString(mode));
        else
            addParameter("mode", "input");
        if (iconCssClass != null)
            addParameter("iconCssClass", findString(iconCssClass));
        if (iconPath != null)
            addParameter("iconPath", findString(iconPath));
        if (autoClose != null)
            addParameter("autoClose", findValue(autoClose, Boolean.class));
        if (formatFunction != null)
            addParameter("formatFunction", findString(formatFunction));

        String nameValue = null;

        if (parameters.containsKey("value")) {
            nameValue = (String) parameters.get("value");
            addParameter("nameValue", nameValue);
        } else if (name != null) {
            nameValue = format(findValue(name));
            addParameter("nameValue", nameValue);
        }

        if (nameValue != null) {
            try {
                Date dateValue = DATE_FORMAT.parse(nameValue);
                addParameter("pagedate", PAGE_DATE_FORMAT.format(dateValue));
                addParameter("rfcValue", RFC3339_FORMAT.format(dateValue));
            } catch (ParseException e) {
                LOG.error("Unable to build page date from specified value");
            }
        }
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    private String format(Object obj) {
        if (obj == null)
            return null;
        if (obj instanceof Date) {
            return DATE_FORMAT.format((Date) obj);
        } else if (obj instanceof Calendar) {
            return DATE_FORMAT.format(((Calendar) obj).getTime());
        } else {
            // try to parse a date
            String dateStr = obj.toString();
            if (dateStr.equalsIgnoreCase("today"))
                return DATE_FORMAT.format(new Date());

            Date date = null;
            //formats used to parse the date
            List<DateFormat> formats = new ArrayList<DateFormat>();
            formats.add(RFC3339_FORMAT);
            formats.add(SimpleDateFormat.getTimeInstance(DateFormat.SHORT));
            formats.add(SimpleDateFormat.getDateInstance(DateFormat.SHORT));
            formats.add(SimpleDateFormat.getDateInstance(DateFormat.MEDIUM));
            formats.add(SimpleDateFormat.getDateInstance(DateFormat.FULL));
            formats.add(SimpleDateFormat.getDateInstance(DateFormat.LONG));

            for (DateFormat format : formats) {
                try {
                    date = format.parse(dateStr);
                    if (date != null)
                        return DATE_FORMAT.format(date);
                } catch (Exception e) {
                    //keep going
                }
            }

            // last resource, assume already in correct/default format
            if (LOG.isDebugEnabled())
                LOG.debug("Unable to parse date " + dateStr);
            return dateStr;
        }
    }
    
    @StrutsTagAttribute(description = "Sets how the datepicker is to be rendered, should be one of 'input', 'static', 'label'", defaultValue = "input")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    @StrutsTagAttribute(description = "Used as HTML id attribute", required = true)
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    @StrutsTagAttribute(description = "Name of the field that will cotainf the date value", required = true)
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnblur(String onblur) {
        super.setOnblur(onblur);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnchange(String onchange) {
        super.setOnchange(onchange);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnclick(String onclick) {
        super.setOnclick(onclick);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOndblclick(String ondblclick) {
        super.setOndblclick(ondblclick);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnfocus(String onfocus) {
        super.setOnfocus(onfocus);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnkeydown(String onkeydown) {
        super.setOnkeydown(onkeydown);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnkeypress(String onkeypress) {
        super.setOnkeypress(onkeypress);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnkeyup(String onkeyup) {
        super.setOnkeyup(onkeyup);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnmousedown(String onmousedown) {
        super.setOnmousedown(onmousedown);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnmousemove(String onmousemove) {
        super.setOnmousemove(onmousemove);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnmouseout(String onmouseout) {
        super.setOnmouseout(onmouseout);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnmouseover(String onmouseover) {
        super.setOnmouseover(onmouseover);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnmouseup(String onmouseup) {
        super.setOnmouseup(onmouseup);
    }

    @Override
    @StrutsTagSkipInheritance
    public void setOnselect(String onselect) {
        super.setOnselect(onselect);
    }

    @StrutsTagAttribute(description = "Last available date in the calendar set", type = "Date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @StrutsTagAttribute(description = "First available date in the calendar set", type = "Date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @StrutsTagAttribute(description = "Hide datepicker when a date is selected. Applies only when 'mode' is 'input' or 'label'", type = "Boolean", defaultValue="true")
    public void setAutoClose(String autoClose) {
        this.autoClose = autoClose;
    }

    @StrutsTagAttribute(description = "URL of icon used for the dropdown image. Applies only when 'mode' is 'input' or 'label'")
    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @StrutsTagAttribute(description = "Css class of icon used for the dropdown image. Applies only when 'mode' is 'input' or 'label'")
    public void setIconCssClass(String iconCssClass) {
        this.iconCssClass = iconCssClass;
    }

    @StrutsTagAttribute(description = "Function used to format the selected value. The value returned by this function will be displayed" +
    		" on the input field. When the page loads an String will be passed to this function with the value specified on the 'value' attribute." +
    		"When the user selects a value using the datepicker a JavaScript object of type Date will be passed. Applies only when 'mode' is 'input' or 'label'")
    public void setFormatFunction(String formatFunction) {
        this.formatFunction = formatFunction;
    }
}
