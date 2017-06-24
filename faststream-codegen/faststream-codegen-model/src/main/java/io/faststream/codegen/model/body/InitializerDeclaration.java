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
 * This class was automatically generated by cake.bootstrap.codegen.model.GenerateModel 
 * Available in the https://github.com/cakeframework/cake-developers/ project 
 */
package io.faststream.codegen.model.body;

import java.util.Objects;

import io.faststream.codegen.model.AbstractASTNode;
import io.faststream.codegen.model.statement.BlockStatement;
import io.faststream.codegen.model.visitor.CodegenVisitor;
import io.faststream.codegen.model.visitor.ModifyingCodegenVisitor;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
public class InitializerDeclaration extends AbstractASTNode {

    /** Static or not. */
    private boolean isStatic;

    /** The body. */
    private BlockStatement body;

    public InitializerDeclaration() {}

    public InitializerDeclaration(boolean isStatic, BlockStatement body) {
        this.isStatic = isStatic;
        this.body = body;
    }

    public boolean getIsStatic() {
        return isStatic;
    }

    public BlockStatement getBody() {
        return body;
    }

    public void setIsStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    public void setBody(BlockStatement body) {
        this.body = body;
    }

    public void accept(CodegenVisitor visitor) {
        visitor.visit(this);
    }

    public Object accept(ModifyingCodegenVisitor visitor) {
        return visitor.visit(this);
    }

    /** {@inheritDoc} */
    public boolean equals(Object other) {
        return other instanceof InitializerDeclaration && equals((InitializerDeclaration) other);
    }

    public boolean equals(InitializerDeclaration other) {
        return super.equals(this) && Objects.equals(isStatic, other.isStatic) && Objects.equals(body, other.body);
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return Objects.hash(isStatic, body);
    }
}
