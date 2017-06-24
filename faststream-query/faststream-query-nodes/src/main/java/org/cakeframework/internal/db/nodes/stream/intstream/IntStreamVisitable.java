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
package org.cakeframework.internal.db.nodes.stream.intstream;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
public interface IntStreamVisitable {

    void accept(IntStreamVisitor visitor);

    interface IntStreamVisitor {

        void allMatch(SIT_AllMatch node);

        void anyMatch(SIT_AnyMatch node);

        void asDoubleStream(SI_AsDoubleStream node);

        void asLongStream(SI_AsLongStream node);

        void average(SIT_Average node);

        void boxed(SI_Boxed node);

        void collect(SIT_Collect node);

        void count(SIT_Count node);

        void distinct(SI_Distinct node);

        void filter(SI_Filter node);

        void findAny(SIT_FindAny node);

        void findFirst(SIT_FindFirst node);

        void flatMap(SI_FlatMap node);

        void forEach(SIT_ForEach node);

        void forEachOrdered(SIT_ForEachOrdered node);

        void iterator(SIT_Iterator node);

        void limit(SI_Limit node);

        void map(SI_Map node);

        void mapToDouble(SI_MapToDouble node);

        void mapToLong(SI_MapToLong node);

        void mapToObj(SI_MapToObj node);

        void max(SIT_Max node);

        void min(SIT_Min node);

        void noneMatch(SIT_NoneMatch node);

        void parallel(SI_Parallel node);

        void peek(SI_Peek node);

        void reduce(SIT_Reduce node);

        void sequential(SI_Sequential node);

        void skip(SI_Skip node);

        void sorted(SI_Sorted node);

        void spliterator(SIT_Spliterator node);

        void sum(SIT_Sum node);

        void summaryStatistics(SIT_SummaryStatistics node);

        void toArray(SIT_ToArray node);

        void unordered(SI_Unordered node);
    }
}
