/*
 * Copyright (c) 2008 Kasper Nielsen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.faststream.sisyphus.javautil.stream.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;

import io.faststream.sisyphus.annotations.RndTest;

/**
 * Test {@link Stream#findAny()} and {@link Stream#findFirst()}.
 * 
 * @author Kasper Nielsen
 */
public class Find<E> extends AbstractRandomStreamTestCase<E> {

    @RndTest
    public void findAny() {
        if (expected().size() == 0) {
            assertFalse(actual().findAny().isPresent());
        } else {
            Optional<E> l = actual().findAny();
            assertTrue(l.isPresent());
            if (!expected().contains(l.get())) {
                fail("LongStream.findAny() returned an unexpected element, expected one of " + expected().asList() + ", but was " + l.get());
            }
        }
        consumed();
    }

    @RndTest
    public void findFirst() {
        if (expected().size() == 0) {
            assertFalse(actual().findFirst().isPresent());
        } else {
            Optional<E> l = actual().findFirst();
            assertTrue(l.isPresent());
            if (!expected().contains(l.get())) {
                fail("LongStream.findFirst() returned an unexpected element, expected one of " + expected().asList() + ", but was " + l.get());
            }
            if (isOrdered()) {
                assertEquals(expected().asList().get(0), l.get());
            }
        }
        consumed();
    }
}
