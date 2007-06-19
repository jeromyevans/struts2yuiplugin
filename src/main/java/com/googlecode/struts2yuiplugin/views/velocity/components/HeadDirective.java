/*
 * $Id: HeadDirective.java 536387 2007-05-09 01:07:14Z musachy $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.googlecode.struts2yuiplugin.views.velocity.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.googlecode.struts2yuiplugin.components.Head;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see Head
 */
public class HeadDirective extends YUIAbstractDirective {
    @Override
    protected Component getBean(ValueStack stack, HttpServletRequest req,
        HttpServletResponse res) {
        return new Head(stack, req, res);
    }

    @Override
    public String getBeanName() {
        return "head";
    }
}
