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
package org.cakeframework.internal.db.nodes.stream.stream;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
import java.util.Objects;
import java.util.function.Predicate;

import org.cakeframework.internal.db.nodes.stream.StreamContext;
import org.cakeframework.internal.db.query.node.QueryOperationNode;
import org.cakeframework.internal.db.query.node.QueryOperationNodeDefinition;
import org.cakeframework.internal.db.query.node.TerminalQueryOperationNode;
import org.cakeframework.internal.db.query.node.defaults.CollectionQueryOperations;

@SuppressWarnings("rawtypes")
public class SOT_AnyMatch extends TerminalQueryOperationNode implements StreamVisitable {

    private static final long serialVersionUID = 1L;

    private final Predicate predicate;

    public SOT_AnyMatch(QueryOperationNode parent, StreamContext context, Predicate predicate) {
        super(parent);
        this.predicate = Objects.requireNonNull(predicate, "predicate is null");
        context.consume();
    }

    public QueryOperationNodeDefinition getOperationPackage() {
        return QueryOperationNodeDefinition.create(CollectionQueryOperations.CT_MATCH_ANY, "predicate", Predicate.class);
    }

    public String name() {
        return "anyMatch";
    }

    public int getNodeId() {
        return 11;
    }

    @Override
    public final int getNodeType() {
        return 2;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void accept(StreamVisitable.StreamVisitor visitor) {
        visitor.anyMatch(this);
    }
}
