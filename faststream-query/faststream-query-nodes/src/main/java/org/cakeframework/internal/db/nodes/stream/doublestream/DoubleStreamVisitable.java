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
package org.cakeframework.internal.db.nodes.stream.doublestream;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
public interface DoubleStreamVisitable {

    void accept(DoubleStreamVisitor visitor);

    interface DoubleStreamVisitor {

        void allMatch(SDT_AllMatch node);

        void anyMatch(SDT_AnyMatch node);

        void average(SDT_Average node);

        void boxed(SD_Boxed node);

        void collect(SDT_Collect node);

        void count(SDT_Count node);

        void distinct(SD_Distinct node);

        void filter(SD_Filter node);

        void findAny(SDT_FindAny node);

        void findFirst(SDT_FindFirst node);

        void flatMap(SD_FlatMap node);

        void forEach(SDT_ForEach node);

        void forEachOrdered(SDT_ForEachOrdered node);

        void iterator(SDT_Iterator node);

        void limit(SD_Limit node);

        void map(SD_Map node);

        void mapToInt(SD_MapToInt node);

        void mapToLong(SD_MapToLong node);

        void mapToObj(SD_MapToObj node);

        void max(SDT_Max node);

        void min(SDT_Min node);

        void noneMatch(SDT_NoneMatch node);

        void parallel(SD_Parallel node);

        void peek(SD_Peek node);

        void reduce(SDT_Reduce node);

        void sequential(SD_Sequential node);

        void skip(SD_Skip node);

        void sorted(SD_Sorted node);

        void spliterator(SDT_Spliterator node);

        void sum(SDT_Sum node);

        void summaryStatistics(SDT_SummaryStatistics node);

        void toArray(SDT_ToArray node);

        void unordered(SD_Unordered node);
    }
}