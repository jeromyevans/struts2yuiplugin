package com.googlecode.struts2yuiplugin.views.velocity.components;

import org.apache.struts2.views.velocity.components.AbstractDirective;

/**
 * Overwrite name prefix 
 *
 */
public abstract class YUIAbstractDirective extends AbstractDirective {
    @Override
    public String getName() {
        return "yui" + this.getBeanName();
    }
}
