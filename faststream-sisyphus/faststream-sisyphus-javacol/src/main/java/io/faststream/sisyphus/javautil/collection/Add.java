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
package io.faststream.sisyphus.javautil.collection;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import io.faststream.sisyphus.annotations.Create;
import io.faststream.sisyphus.annotations.FailWith;
import io.faststream.sisyphus.annotations.LifecycleTestMethod;
import io.faststream.sisyphus.annotations.RndTest;

/**
 * Tests {@link Collection#add(Object)}.
 * 
 * @param <E>
 *            the elements in the collection
 * 
 * @author Kasper Nielsen
 */
public class Add<E> extends AbstractRandomCollectionTestCase<E> {

    @Create
    @RndTest
    @LifecycleTestMethod
    public void add() {
        assumeAddSupported();

        E e = mix().get();
        assertEquals(expected().add(e), actual().add(e));
    }

    // ************************* CORNER CASES *************************

    @RndTest()
    @FailWith(NullPointerException.class)
    public void addNull() {
        assumeAddSupported();
        assumeNullUnsupported();

        actual().add(null);
    }

    /** Gives precedents to {@link UnsupportedOperationException} over other exceptions */
    @FailWith(UnsupportedOperationException.class)
    public void addUnsupported() {
        assumeAddUnsupported();

        actual().add(mix().get());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @FailWith(ClassCastException.class)
    public void addIncompatibleType() {
        assumeAddSupported();
        assumeIncompatibleTypesExist();

        ((Collection) actual()).add(incompatibleTypes().get());
    }

    @FailWith(IllegalArgumentException.class)
    public void addIllegalElement() {
        assumeAddSupported();
        assumeIllegalTypesExist();

        actual().add(illegalElements().get());
    }
    // TODO I dont know other implementatations then Queue who throws IllegalStateException
}
