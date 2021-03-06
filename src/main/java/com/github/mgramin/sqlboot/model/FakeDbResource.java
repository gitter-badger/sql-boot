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

import java.util.Map;
import lombok.ToString;
import static com.google.common.collect.ImmutableMap.of;

/**
 * Created by maksim on 22.05.17.
 */
@ToString
public final class FakeDbResource implements DbResource {

    @Override
    public String name() {
        return "FAKE_DB_RESOURCE";
    }

    @Override
    public ResourceType type() {
        return new FakeDbResourceType();
    }

    @Override
    public Uri dbUri() {
        return new DbUri("table/hr.persons?file=table.hr.persons.sql");
    }

    @Override
    public Map<String, String> headers() {
        return of("schema", "hr",
                "table", "persons",
                "file", "table.hr.persons.sql");
    }

    @Override
    public String body() {
        return "BODY";
    }

}
