package com.googlecode.struts2yuiplugin.tools;

public class YUITools {

     /**
     * Remove characters that are unsafe for use as a javascript variable name
     *
     * This is the same implementation as appears in UIBean but here it's available to support classes
     *
     * @param name
     * @return
     */
    public static String sanitizeForJavascript(String name) {
        if (name != null) {
            return name.replaceAll("[\\.\\[\\]]", "_");
        } else {
            return "";
        }
    }
}
