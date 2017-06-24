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
package org.cakeframework.internal.db.query.plan.logical;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.cakeframework.internal.db.query.plan.QueryNode;

/**
 *
 * @author Kasper Nielsen
 */
public class LogicalReferenceTracker {

    final Set<LogicalReferenceTracker> dependencies;

    public LogicalReferenceTracker() {
        dependencies = Collections.emptySet();
    }

    public LogicalReferenceTracker(LogicalReferenceTracker... dependencies) {
        this.dependencies = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(dependencies)));
    }

    public Set<LogicalReferenceTracker> getDependencies() {
        return dependencies;
    }

    public void touch(QueryNode node) {

    }
}
