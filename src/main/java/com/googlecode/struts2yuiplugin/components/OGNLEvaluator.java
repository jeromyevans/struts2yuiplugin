package com.googlecode.struts2yuiplugin.components;

/**
 * Simplified interface to evaluate an OGNL expression
 *
 * The purpose at the moment is to allow the AjaxBeanSupport to call-back into the expression evaluation
 * currenly embedded within Component 
 */
public interface OGNLEvaluator {

    /**
     * Evaluates the OGNL expression within a context
     *
     * @param expr  OGNL expression.
     * @return  the String value found.
     */
    String evaluateExpression(String expr);
}
