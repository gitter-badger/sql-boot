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

package com.github.mgramin.sqlboot.actions.generator.wrappers;

import java.util.List;
import java.util.Map;
import com.github.mgramin.sqlboot.actions.generator.ActionGenerator;
import com.github.mgramin.sqlboot.exceptions.BootException;
import com.github.mgramin.sqlboot.model.IDbResourceCommand;
import com.github.mgramin.sqlboot.tools.sql.ISqlHelper;
import lombok.ToString;

/**
 *
 *
 * @author Maksim Gramin (mgramin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ToString
public final class SqlWrapper implements ActionGenerator {

    final private ActionGenerator origin;
    final private ISqlHelper sqlHelper;

    public SqlWrapper(ActionGenerator origin, ISqlHelper sqlHelper) {
        this.origin = origin;
        this.sqlHelper = sqlHelper;
    }

    @Override
    public String generate(Map<String, Object> variables) throws BootException {
        return generate(origin.generate(variables));
    }

    @Override
    public String generate(List<Object> variables) throws BootException {
        return generate(origin.generate(variables));
    }

    @Override
    public IDbResourceCommand command() {
        return origin.command();
    }

    @Override
    public String aggregators() {
        return origin.aggregators();
    }

    private String generate(String sql) {
        List<Map<String, String>> maps = sqlHelper.select(sql);
        return maps.get(0).entrySet().iterator().next().getValue();
    }

}
