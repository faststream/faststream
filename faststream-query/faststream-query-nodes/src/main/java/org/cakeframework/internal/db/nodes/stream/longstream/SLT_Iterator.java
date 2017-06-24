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
import org.cakeframework.internal.db.nodes.stream.StreamContext;
import org.cakeframework.internal.db.query.node.QueryOperationNode;
import org.cakeframework.internal.db.query.node.QueryOperationNodeDefinition;
import org.cakeframework.internal.db.query.node.TerminalQueryOperationNode;
import org.cakeframework.internal.db.query.node.defaults.CollectionQueryOperations;

public class SLT_Iterator extends TerminalQueryOperationNode implements LongStreamVisitable {

    private static final long serialVersionUID = 1L;

    public SLT_Iterator(QueryOperationNode parent, StreamContext context) {
        super(parent);
        context.consume();
    }

    public QueryOperationNodeDefinition getOperationPackage() {
        return QueryOperationNodeDefinition.create(CollectionQueryOperations.CT_TO_ITERATOR);
    }

    public String name() {
        return "iterator";
    }

    public int getNodeId() {
        return 58;
    }

    @Override
    public final int getNodeType() {
        return 4;
    }

    public void accept(LongStreamVisitable.LongStreamVisitor visitor) {
        visitor.iterator(this);
    }
}
