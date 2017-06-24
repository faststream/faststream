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
package org.cakeframework.test.random.view.multimapview;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import org.cakeframework.util.Multimap;
import org.cakeframework.util.view.MultimapView;

import io.faststream.sisyphus.annotations.RndTest;

/**
 * Test the {@link MultimapView#unique()} operation.
 * 
 * @param <K>
 *            the type of keys tested
 * @param <V>
 *            the type of values tested
 * @author Kasper Nielsen
 */
public class Unique<K, V> extends AbstractMultimapViewRandomTestCase<K, V> {

    @RndTest
    public void unique() {
        Multimap<K, V> multimap = newMultiMap();
        Map<K, Collection<V>> m = expected().asMap();
        for (Map.Entry<K, Collection<V>> me : m.entrySet()) {
            multimap.putAll(me.getKey(), new HashSet<>(me.getValue()));
        }
        setNext(multimap, actual().unique(), isKeysOrdered(), false);
    }
}
