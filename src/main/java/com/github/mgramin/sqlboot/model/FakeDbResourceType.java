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

package com.github.mgramin.sqlboot.model;

import java.util.List;
import com.github.mgramin.sqlboot.actions.generator.ActionGenerator;
import com.github.mgramin.sqlboot.exceptions.BootException;
import lombok.ToString;
import static java.util.Arrays.asList;

/**
 * Created by maksim on 22.05.17.
 */
@ToString
public final class FakeDbResourceType implements ResourceType {

    @Override
    public String name() {
        return "fake_resource_type";
    }

    @Override
    public List<String> aliases() {
        return asList("fake_resource_type", "fake_type", "frt", "f");
    }

    @Override
    public List<ActionGenerator> generators() {
        return null;
    }

    @Override
    public List<DbResource> read(
            final Uri uri, final IDbResourceCommand command,
            final String aggregatorName) throws BootException {
        return null;
    }

}
