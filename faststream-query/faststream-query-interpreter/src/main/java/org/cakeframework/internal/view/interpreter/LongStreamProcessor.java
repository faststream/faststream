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
/* 
 * This class was automatically generated by cake.bootstrap.view.GenerateAll 
 * Available in the https://github.com/cakeframework/cake-developers/ project 
 */
package org.cakeframework.internal.view.interpreter;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.LongStream;

import org.cakeframework.internal.db.nodes.stream.longstream.LongStreamVisitable;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_AllMatch;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_AnyMatch;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Average;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Collect;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Count;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_FindAny;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_FindFirst;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_ForEach;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_ForEachOrdered;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Iterator;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Max;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Min;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_NoneMatch;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Reduce;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Spliterator;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_Sum;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_SummaryStatistics;
import org.cakeframework.internal.db.nodes.stream.longstream.SLT_ToArray;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_AsDoubleStream;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Boxed;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Distinct;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Filter;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_FlatMap;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Limit;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Map;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_MapToDouble;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_MapToInt;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_MapToObj;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Parallel;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Peek;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Sequential;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Skip;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Sorted;
import org.cakeframework.internal.db.nodes.stream.longstream.SL_Unordered;
import org.cakeframework.internal.db.query.node.EmptyResult;
import org.cakeframework.internal.db.query.node.QueryOperationNode;

@SuppressWarnings("unchecked" )
public class LongStreamProcessor extends AbstractSingleNodeViewQueryProcessor implements LongStreamVisitable.LongStreamVisitor {

    private final LongStream s;

    public LongStreamProcessor(LongStream s) {
        this.s = Objects.requireNonNull(s);
    }

    public void allMatch(SLT_AllMatch node) {
        setResult(s.allMatch(node.getLongPredicate()));
    }

    public void anyMatch(SLT_AnyMatch node) {
        setResult(s.anyMatch(node.getLongPredicate()));
    }

    public void asDoubleStream(SL_AsDoubleStream node) {
        setNext(new DoubleStreamProcessor(s.asDoubleStream()));
    }

    public void average(SLT_Average node) {
        OptionalDouble opt = s.average();
        setResult(opt.isPresent() ? opt.getAsDouble() : EmptyResult.EMPTY_RESULT);
    }

    public void boxed(SL_Boxed node) {
        setNext(new StreamProcessor(s.boxed()));
    }

    public void collect(SLT_Collect node) {
        setResult(s.collect(node.getSupplier(), node.getObjLongConsumer(), node.getBiConsumer()));
    }

    public void count(SLT_Count node) {
        setResult(s.count());
    }

    public void distinct(SL_Distinct node) {
        setNext(new LongStreamProcessor(s.distinct()));
    }

    public void filter(SL_Filter node) {
        setNext(new LongStreamProcessor(s.filter(node.getLongPredicate())));
    }

    public void findAny(SLT_FindAny node) {
        OptionalLong opt = s.findAny();
        setResult(opt.isPresent() ? opt.getAsLong() : EmptyResult.EMPTY_RESULT);
    }

    public void findFirst(SLT_FindFirst node) {
        OptionalLong opt = s.findFirst();
        setResult(opt.isPresent() ? opt.getAsLong() : EmptyResult.EMPTY_RESULT);
    }

    public void flatMap(SL_FlatMap node) {
        setNext(new LongStreamProcessor(s.flatMap(node.getMapper())));
    }

    public void forEach(SLT_ForEach node) {
        s.forEach(node.getAction());
        setResult(null);
    }

    public void forEachOrdered(SLT_ForEachOrdered node) {
        s.forEachOrdered(node.getAction());
        setResult(null);
    }

    public void iterator(SLT_Iterator node) {
        setResult(s.iterator());
    }

    public void limit(SL_Limit node) {
        setNext(new LongStreamProcessor(s.limit(node.getMaxSize())));
    }

    public void map(SL_Map node) {
        setNext(new LongStreamProcessor(s.map(node.getLongUnaryOperator())));
    }

    public void mapToDouble(SL_MapToDouble node) {
        setNext(new DoubleStreamProcessor(s.mapToDouble(node.getMapper())));
    }

    public void mapToInt(SL_MapToInt node) {
        setNext(new IntStreamProcessor(s.mapToInt(node.getMapper())));
    }

    public void mapToObj(SL_MapToObj node) {
        setNext(new StreamProcessor(s.mapToObj(node.getMapper())));
    }

    public void max(SLT_Max node) {
        OptionalLong opt = s.max();
        setResult(opt.isPresent() ? opt.getAsLong() : EmptyResult.EMPTY_RESULT);
    }

    public void min(SLT_Min node) {
        OptionalLong opt = s.min();
        setResult(opt.isPresent() ? opt.getAsLong() : EmptyResult.EMPTY_RESULT);
    }

    public void noneMatch(SLT_NoneMatch node) {
        setResult(s.noneMatch(node.getLongPredicate()));
    }

    public void parallel(SL_Parallel node) {
        setNext(new LongStreamProcessor(s.parallel()));
    }

    public void peek(SL_Peek node) {
        setNext(new LongStreamProcessor(s.peek(node.getLongConsumer())));
    }

    public void reduce(SLT_Reduce node) {
        OptionalLong opt = s.reduce(node.getOp());
        setResult(opt.isPresent() ? opt.getAsLong() : EmptyResult.EMPTY_RESULT);
    }

    public void sequential(SL_Sequential node) {
        setNext(new LongStreamProcessor(s.sequential()));
    }

    public void skip(SL_Skip node) {
        setNext(new LongStreamProcessor(s.skip(node.getN())));
    }

    public void sorted(SL_Sorted node) {
        setNext(new LongStreamProcessor(s.sorted()));
    }

    public void spliterator(SLT_Spliterator node) {
        setResult(s.spliterator());
    }

    public void sum(SLT_Sum node) {
        setResult(s.sum());
    }

    public void summaryStatistics(SLT_SummaryStatistics node) {
        setResult(s.summaryStatistics());
    }

    public void toArray(SLT_ToArray node) {
        setResult(s.toArray());
    }

    public void unordered(SL_Unordered node) {
        setNext(new LongStreamProcessor(s.unordered()));
    }

    void process(QueryOperationNode node) {
        ((LongStreamVisitable) node).accept(this);
    }
}
