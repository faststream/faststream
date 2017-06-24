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
package org.cakeframework.internal.db.nodes.view.mapview;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
import java.util.Objects;
import java.util.function.Predicate;

import org.cakeframework.internal.db.query.node.QueryOperationNode;
import org.cakeframework.internal.db.query.node.QueryOperationNodeDefinition;
import org.cakeframework.internal.db.query.node.defaults.MapQueryOperations;

@SuppressWarnings("rawtypes")
public class MV_FilterOnValue extends AbstractMapView implements MapViewVisitable {

    private static final long serialVersionUID = 1L;

    private final Predicate predicate;

    public MV_FilterOnValue(QueryOperationNode parent, Predicate predicate) {
        super(parent);
        this.predicate = Objects.requireNonNull(predicate, "predicate is null");
    }

    public QueryOperationNodeDefinition getOperationPackage() {
        return QueryOperationNodeDefinition.create(MapQueryOperations.M_FILTER_BY_VALUE_PREDICATE, "predicate", Predicate.class);
    }

    public String name() {
        return "filterOnValue";
    }

    public int getNodeId() {
        return 5;
    }

    @Override
    public final int getNodeType() {
        return 6;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void accept(MapViewVisitable.MapViewVisitor visitor) {
        visitor.filterOnValue(this);
    }
}
