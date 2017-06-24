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
package org.cakeframework.internal.view.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

import org.cakeframework.internal.db.query.compiler.CompiledCollectionViewConfiguration;
import org.cakeframework.internal.db.query.compiler.DataSource;
import org.cakeframework.internal.db.query.plan.QueryEngine;
import org.cakeframework.test.random.view.CollectionViewRandomTestBuilder;
import org.cakeframework.test.random.view.collectionview.AnyFirstLast;
import org.cakeframework.test.random.view.collectionview.Count;
import org.cakeframework.test.random.view.collectionview.Filter;
import org.cakeframework.test.random.view.collectionview.Foreach;
import org.cakeframework.test.random.view.collectionview.Gather;
import org.cakeframework.test.random.view.collectionview.Mapping;
import org.cakeframework.test.random.view.collectionview.One;
import org.cakeframework.test.random.view.collectionview.Reduce;
import org.cakeframework.test.random.view.collectionview.SizeIsEmpty;
import org.cakeframework.test.random.view.collectionview.SortAndOrdering;
import org.cakeframework.test.random.view.collectionview.Take;
import org.cakeframework.test.random.view.collectionview.To;
import org.cakeframework.util.view.CollectionView;
import org.junit.Ignore;
import org.junit.Test;

import io.faststream.codegen.core.Codegen;
import io.faststream.codegen.core.CodegenConfiguration;
import io.faststream.sisyphus.spi.method.TestSelectorProvider;

/**
 *
 * @author Kasper Nielsen
 */
public class FssTest {

    @Test
    @Ignore
    public void test() {
        long start = System.nanoTime();
        // Create the codegen that creates the code
        CodegenConfiguration cc = new CodegenConfiguration();
        // cc.setSourcePath("/Users/kasperni/workspace/cake/private/tmp");
        // cc.setSourcePath("/Users/kasperni/tmp");
        // cc.addCodeWriter(System.out);
        final Codegen code = new Codegen(cc);

        // Create a data source
        // source.setSourceType(TestData.class);
        final CopyOnWriteArraySet<QueryEngine> planners = new CopyOnWriteArraySet<>();

        CollectionViewRandomTestBuilder<Integer> builder = new CollectionViewRandomTestBuilder<Integer>() {
            @Override
            protected CollectionView<Integer> createTestStructure(List<Integer> bootstrap) {
                TestData td = new TestData();
                // System.err.println(Arrays.toString(bootstrap.toArray()));
                td.obj = bootstrap.toArray();
                CompiledCollectionViewConfiguration<Integer> conf = new CompiledCollectionViewConfiguration<>();

                DataSource src = conf.addSource("source", td);
                conf.setMain(src.createIndexBoundComposite("obj"));

                // Identifier src = conf.addData(newIdentifier(TestData.class), td);
                // conf.set(IndexBoundedComposite.create(src.withFieldAccess("obj")));
                return conf.compile(code).create();
            }
        };

        List<Class<?>> c = Arrays.<Class<?>> asList(Filter.class);

        List<Class<?>> cr = Arrays.<Class<?>> asList(AnyFirstLast.class, Foreach.class, SizeIsEmpty.class);

        List<Class<?>> all = new ArrayList<>();
        all.addAll(c);
        all.addAll(cr);
        // all.addAll(mr);
        builder.setTestSelectorProvider(TestSelectorProvider.restrictTests(all.toArray(new Class<?>[0])));

        // builder.setInitialSeed(123456795);
        builder.setExecutor(1);
        builder.start(10000);
        long total = 0;
        long planTime = 0;
        for (QueryEngine pl : planners) {
            total += pl.getNumberOfPlansGenerated();
            planTime += pl.getTotalPlanTime(TimeUnit.NANOSECONDS);
        }
        System.out.println("Number of Plans: " + total);
        // System.out.println("Plan Time:       " + DurationFormatter.DEFAULT.formatNanos(planTime));
        // System.out.println("TOTAL:           " + DurationFormatter.DEFAULT.formatNanos(System.nanoTime() - start));

        List<Class<?>> c_ = Arrays.<Class<?>> asList(Count.class, Filter.class, Gather.class, Mapping.class,
                SortAndOrdering.class, Take.class);

        List<Class<?>> cr_ = Arrays.<Class<?>> asList(AnyFirstLast.class, Foreach.class, One.class, Reduce.class,
                SizeIsEmpty.class, To.class);

        List<Class<?>> mr_ = Arrays.<Class<?>> asList(/* org.cakeframework.test.random.view.mapview.Apply.class, */
                org.cakeframework.test.random.view.mapview.SizeIsEmpty.class,
                org.cakeframework.test.random.view.mapview.To.class);
        System.out.println(c_);
        System.out.println(cr_);
        System.out.println(mr_);
    }

    /** A test stub. */
    public static class TestData {
        public Object[] obj;
    }
}
