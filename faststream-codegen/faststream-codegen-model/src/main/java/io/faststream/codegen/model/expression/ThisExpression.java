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
package io.faststream.codegen.model.expression;

import java.util.Objects;

import io.faststream.codegen.model.visitor.CodegenVisitor;
import io.faststream.codegen.model.visitor.ModifyingCodegenVisitor;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
public class ThisExpression extends Expression {

    /** An optional class expresion. */
    private Expression classExpression;

    public ThisExpression() {}

    public ThisExpression(Expression classExpression) {
        this.classExpression = classExpression;
    }

    public Expression getClassExpression() {
        return classExpression;
    }

    public void setClassExpression(Expression classExpression) {
        this.classExpression = classExpression;
    }

    public void accept(CodegenVisitor visitor) {
        visitor.visit(this);
    }

    public Object accept(ModifyingCodegenVisitor visitor) {
        return visitor.visit(this);
    }

    /** {@inheritDoc} */
    public boolean equals(Object other) {
        return other instanceof ThisExpression && equals((ThisExpression) other);
    }

    public boolean equals(ThisExpression other) {
        return super.equals(this) && Objects.equals(classExpression, other.classExpression);
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return Objects.hash(classExpression);
    }
}
