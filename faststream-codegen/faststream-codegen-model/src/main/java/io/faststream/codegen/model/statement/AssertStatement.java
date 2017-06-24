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
package io.faststream.codegen.model.statement;

import java.util.Objects;

import io.faststream.codegen.model.expression.Expression;
import io.faststream.codegen.model.visitor.CodegenVisitor;
import io.faststream.codegen.model.visitor.ModifyingCodegenVisitor;

/**
 * This class has been autogenerated
 *
 * @author Kasper Nielsen
 */
public class AssertStatement extends Statement {

    /** The thing to check. */
    private Expression check;

    /** The message. */
    private Expression message;

    public AssertStatement() {}

    public AssertStatement(Expression check, Expression message) {
        this.check = check;
        this.message = message;
    }

    public Expression getCheck() {
        return check;
    }

    public Expression getMessage() {
        return message;
    }

    public void setCheck(Expression check) {
        this.check = check;
    }

    public void setMessage(Expression message) {
        this.message = message;
    }

    public void accept(CodegenVisitor visitor) {
        visitor.visit(this);
    }

    public Object accept(ModifyingCodegenVisitor visitor) {
        return visitor.visit(this);
    }

    /** {@inheritDoc} */
    public boolean equals(Object other) {
        return other instanceof AssertStatement && equals((AssertStatement) other);
    }

    public boolean equals(AssertStatement other) {
        return super.equals(this) && Objects.equals(check, other.check) && Objects.equals(message, other.message);
    }

    /** {@inheritDoc} */
    public int hashCode() {
        return Objects.hash(check, message);
    }
}
