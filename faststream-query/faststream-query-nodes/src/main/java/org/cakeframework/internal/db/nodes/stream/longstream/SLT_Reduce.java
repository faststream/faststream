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
package org.cakeframework.internal.db.nodes.stream.longstream;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
import java.util.Objects;
import java.util.function.LongBinaryOperator;

import org.cakeframework.internal.db.nodes.stream.StreamContext;
import org.cakeframework.internal.db.query.node.QueryOperationNode;
import org.cakeframework.internal.db.query.node.QueryOperationNodeDefinition;
import org.cakeframework.internal.db.query.node.TerminalQueryOperationNode;
import org.cakeframework.internal.db.query.node.defaults.CollectionQueryOperations;

public class SLT_Reduce extends TerminalQueryOperationNode implements LongStreamVisitable {

    private static final long serialVersionUID = 1L;

    private final LongBinaryOperator op;

    public SLT_Reduce(QueryOperationNode parent, StreamContext context, LongBinaryOperator op) {
        super(parent);
        this.op = Objects.requireNonNull(op, "op is null");
        context.consume();
    }

    public QueryOperationNodeDefinition getOperationPackage() {
        return QueryOperationNodeDefinition.create(CollectionQueryOperations.CT_REDUCE_OPERATOR, "op", LongBinaryOperator.class);
    }

    public String name() {
        return "reduce";
    }

    public int getNodeId() {
        return 62;
    }

    @Override
    public final int getNodeType() {
        return 4;
    }

    public LongBinaryOperator getOp() {
        return op;
    }

    public void accept(LongStreamVisitable.LongStreamVisitor visitor) {
        visitor.reduce(this);
    }
}
