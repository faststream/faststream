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
import java.util.Objects;
import java.util.function.DoublePredicate;

import org.cakeframework.internal.db.nodes.stream.StreamContext;
import org.cakeframework.internal.db.query.node.QueryOperationNode;
import org.cakeframework.internal.db.query.node.QueryOperationNodeDefinition;
import org.cakeframework.internal.db.query.node.TerminalQueryOperationNode;
import org.cakeframework.internal.db.query.node.defaults.CollectionQueryOperations;

public class SDT_NoneMatch extends TerminalQueryOperationNode implements DoubleStreamVisitable {

    private static final long serialVersionUID = 1L;

    private final DoublePredicate doublePredicate;

    public SDT_NoneMatch(QueryOperationNode parent, StreamContext context, DoublePredicate doublePredicate) {
        super(parent);
        this.doublePredicate = Objects.requireNonNull(doublePredicate, "doublePredicate is null");
        context.consume();
    }

    public QueryOperationNodeDefinition getOperationPackage() {
        return QueryOperationNodeDefinition.create(CollectionQueryOperations.CT_MATCH_NONE, "doublePredicate", DoublePredicate.class);
    }

    public String name() {
        return "noneMatch";
    }

    public int getNodeId() {
        return 80;
    }

    @Override
    public final int getNodeType() {
        return 5;
    }

    public DoublePredicate getDoublePredicate() {
        return doublePredicate;
    }

    public void accept(DoubleStreamVisitable.DoubleStreamVisitor visitor) {
        visitor.noneMatch(this);
    }
}
