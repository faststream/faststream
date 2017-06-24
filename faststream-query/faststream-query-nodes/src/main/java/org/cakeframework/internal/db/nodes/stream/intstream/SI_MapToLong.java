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
import java.util.Objects;
import java.util.function.IntToLongFunction;

import org.cakeframework.internal.db.nodes.stream.StreamContext;
import org.cakeframework.internal.db.nodes.stream.longstream.AbstractLongStream;
import org.cakeframework.internal.db.query.node.QueryOperationNode;
import org.cakeframework.internal.db.query.node.QueryOperationNodeDefinition;
import org.cakeframework.internal.db.query.node.defaults.CollectionQueryOperations;

public class SI_MapToLong extends AbstractLongStream implements IntStreamVisitable {

    private static final long serialVersionUID = 1L;

    private final IntToLongFunction mapper;

    public SI_MapToLong(QueryOperationNode parent, StreamContext context, IntToLongFunction mapper) {
        super(parent, context);
        this.mapper = Objects.requireNonNull(mapper, "mapper is null");
        context.checkNotConsumed();
    }

    public QueryOperationNodeDefinition getOperationPackage() {
        return QueryOperationNodeDefinition.create(CollectionQueryOperations.C_MAP_TO_LONG, "mapper", IntToLongFunction.class);
    }

    public String name() {
        return "mapToLong";
    }

    public int getNodeId() {
        return 9;
    }

    @Override
    public final int getNodeType() {
        return 3;
    }

    public IntToLongFunction getMapper() {
        return mapper;
    }

    public void accept(IntStreamVisitable.IntStreamVisitor visitor) {
        visitor.mapToLong(this);
    }
}
