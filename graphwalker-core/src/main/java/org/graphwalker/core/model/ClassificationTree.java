package org.graphwalker.core.model;

/*
 * #%L
 * GraphWalker Core
 * %%
 * Copyright (C) 2005 - 2014 GraphWalker
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import java.util.List;

/**
 * @author Nils Olsson
 */
public final class ClassificationTree implements Builder<ClassificationTree.RuntimeClassificationTree> {

    private final Classification classification = new Classification();

    public ClassificationTree addClassification(Classification classification) {
        this.classification.addClassification(classification);
        return this;
    }

    public Classification getRoot() {
        return classification;
    }

    @Override
    public RuntimeClassificationTree build() {
        return new RuntimeClassificationTree(this);
    }

    public static class RuntimeClassificationTree {

        private final Classification.RuntimeClassification root;

        private RuntimeClassificationTree(ClassificationTree classificationTree) {
            this.root = classificationTree.getRoot().build();
        }

        public Classification.RuntimeClassification getRoot() {
            return root;
        }
    }
}
