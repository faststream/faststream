/*
 * Janino - An embedded Java[TM] compiler
 *
 * Copyright (c) 2001-2010, Arno Unkrig
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *       following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 *       following disclaimer in the documentation and/or other materials provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote products derived from this software without
 *       specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package io.faststream.codegen.janino;

import java.security.AccessController;
import java.security.PrivilegedAction;

import io.faststream.codegen.janino.compiler.AbstractCompilerFactory;
import io.faststream.codegen.janino.compiler.AbstractJavaSourceClassLoader;
import io.faststream.codegen.janino.compiler.IClassBodyEvaluator;
import io.faststream.codegen.janino.compiler.ISimpleCompiler;

public class CompilerFactory extends AbstractCompilerFactory {

    public String getId() {
        return "org.codehaus.janino";
    }

    public String getImplementationVersion() {
        return CompilerFactory.class.getPackage().getImplementationVersion();
    }

    public IClassBodyEvaluator newClassBodyEvaluator() {
        return new ClassBodyEvaluator();
    }

    public ISimpleCompiler newSimpleCompiler() {
        return new SimpleCompiler();
    }

    public AbstractJavaSourceClassLoader newJavaSourceClassLoader() {
        return (AbstractJavaSourceClassLoader) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                return new JavaSourceClassLoader();
            }
        });
    }

    public AbstractJavaSourceClassLoader newJavaSourceClassLoader(final ClassLoader parentClassLoader) {
        return (AbstractJavaSourceClassLoader) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                return new JavaSourceClassLoader(parentClassLoader);
            }
        });
    }
}
