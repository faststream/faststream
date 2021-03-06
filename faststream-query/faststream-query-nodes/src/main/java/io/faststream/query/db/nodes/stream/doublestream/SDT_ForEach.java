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
package io.faststream.query.db.nodes.stream.doublestream;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
import java.util.Objects;
import java.util.function.DoubleConsumer;

import io.faststream.query.db.nodes.stream.StreamContext;
import io.faststream.query.db.query.node.QueryOperationNode;
import io.faststream.query.db.query.node.QueryOperationNodeDefinition;
import io.faststream.query.db.query.node.TerminalQueryOperationNode;
import io.faststream.query.db.query.node.defaults.CollectionQueryOperations;

public class SDT_ForEach extends TerminalQueryOperationNode implements DoubleStreamVisitable {

    private static final long serialVersionUID = 1L;

    private final DoubleConsumer action;

    public SDT_ForEach(QueryOperationNode parent, StreamContext context, DoubleConsumer action) {
        super(parent);
        this.action = Objects.requireNonNull(action, "action is null");
        context.consume();
    }

    public QueryOperationNodeDefinition getOperationPackage() {
        return QueryOperationNodeDefinition.create(CollectionQueryOperations.CT_FOR_EACH, "action", DoubleConsumer.class);
    }

    public String name() {
        return "forEach";
    }

    public int getNodeId() {
        return 75;
    }

    @Override
    public final int getNodeType() {
        return 5;
    }

    public DoubleConsumer getAction() {
        return action;
    }

    public void accept(DoubleStreamVisitable.DoubleStreamVisitor visitor) {
        visitor.forEach(this);
    }
}
