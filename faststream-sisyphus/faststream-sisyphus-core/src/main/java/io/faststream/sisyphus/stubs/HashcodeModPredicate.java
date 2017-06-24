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
package io.faststream.sisyphus.stubs;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/**
 * 
 * @param <E>
 *            the type of elements to test
 * @author Kasper Nielsen
 */
public class HashcodeModPredicate<E> implements Predicate<E>, LongPredicate, IntPredicate, DoublePredicate {
    /** {@inheritDoc} */
    @Override
    public HashcodeModPredicate<E> negate() {
        throw new UnsupportedOperationException();
    }

    final int i;

    public HashcodeModPredicate(int i) {
        this.i = i;
    }

    @Override
    public boolean test(E a) {
        if (a == null) {
            return i % 2 == 0;
        } else {
            return a.hashCode() % i == 0;
        }
    }

    public String toString() {
        return "HashcodeModPredicate.from(" + i + ")";
    }

    public static <E> HashcodeModPredicate<E> from(int mod) {
        return new HashcodeModPredicate<>(mod);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public boolean test(int value) {
        return test((E) Integer.valueOf(value));
        // return Long.hashCode(value) % i == 0;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public boolean test(long value) {
        return test((E) Long.valueOf(value));
        // return Long.hashCode(value) % i == 0;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public boolean test(double value) {
        return test((E) Double.valueOf(value));
        // return Long.hashCode(value) % i == 0;
    }
};
