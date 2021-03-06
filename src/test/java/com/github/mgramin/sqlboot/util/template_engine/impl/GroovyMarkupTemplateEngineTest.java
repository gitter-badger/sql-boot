/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 Maksim Gramin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.mgramin.sqlboot.util.template_engine.impl;

import java.util.HashMap;
import java.util.Map;
import com.github.mgramin.sqlboot.tools.template.engine.impl.GroovyMarkupTemplateEngine;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by mgramin on 06.01.2017.
 */
public class GroovyMarkupTemplateEngineTest {

    @Test
    public void processXml() throws Exception {
        Map<String, Object> variables = new HashMap<>();
        variables.put("val", "foo");
        assertEquals("<value>foo</value>",
                new GroovyMarkupTemplateEngine("value(val)").process(variables));
    }

    @Test
    public void processHtml() throws Exception {
        Map<String, Object> variables = new HashMap<>();
        variables.put("border_val", "1");
        assertEquals("<table border='1'><caption>\"HR\".\"USERS\"</caption><tr/></table>",
                new GroovyMarkupTemplateEngine("table(border:border_val){caption('\"HR\".\"USERS\"')tr()}")
                    .process(variables));
    }

}