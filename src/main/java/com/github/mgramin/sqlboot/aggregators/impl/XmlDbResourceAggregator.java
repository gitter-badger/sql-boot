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

package com.github.mgramin.sqlboot.aggregators.impl;

import java.util.List;
import com.github.mgramin.sqlboot.aggregators.AbstractDbResourceAggregator;
import com.github.mgramin.sqlboot.aggregators.DbResourceAggregator;
import com.github.mgramin.sqlboot.exceptions.BootException;
import com.github.mgramin.sqlboot.model.DbResource;
import com.thoughtworks.xstream.XStream;

/**
 * Created by maksim on 21.05.17.
 */
public final class XmlDbResourceAggregator extends AbstractDbResourceAggregator implements DbResourceAggregator {

    public XmlDbResourceAggregator(String name) {
        this.name = name;
    }

    @Override
    public byte[] aggregate(List<DbResource> objects) throws BootException {
        XStream xstream = new XStream();
        String xml = xstream.toXML(objects);
        return xml.getBytes();
    }

}
