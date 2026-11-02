package org.simpleframework.xml.core;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.stream.Format;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ModelAssembler {
    private final ExpressionBuilder builder;
    private final Detail detail;
    private final Format format;

    public ModelAssembler(ExpressionBuilder expressionBuilder, Detail detail, Support support) {
        this.format = support.getFormat();
        this.builder = expressionBuilder;
        this.detail = detail;
    }

    private void assembleAttributes(Model model, Order order) throws PathException {
        for (String str : order.attributes()) {
            Expression expressionBuild = this.builder.build(str);
            if (!expressionBuild.isAttribute() && expressionBuild.isPath()) {
                throw new PathException("Ordered attribute '%s' references an element in %s", expressionBuild, this.detail);
            }
            if (expressionBuild.isPath()) {
                registerAttributes(model, expressionBuild);
            } else {
                model.registerAttribute(this.format.getStyle().getAttribute(str));
            }
        }
    }

    private void assembleElements(Model model, Order order) throws PathException {
        for (String str : order.elements()) {
            Expression expressionBuild = this.builder.build(str);
            if (expressionBuild.isAttribute()) {
                throw new PathException("Ordered element '%s' references an attribute in %s", expressionBuild, this.detail);
            }
            registerElements(model, expressionBuild);
        }
    }

    private void registerAttribute(Model model, Expression expression) {
        String first = expression.getFirst();
        if (first != null) {
            model.registerAttribute(first);
        }
    }

    private void registerAttributes(Model model, Expression expression) throws PathException {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (!expression.isPath()) {
            registerAttribute(model, expression);
            return;
        }
        Model modelRegister = model.register(first, prefix, index);
        Expression path = expression.getPath(1);
        if (modelRegister == null) {
            throw new PathException("Element '%s' does not exist in %s", first, this.detail);
        }
        registerAttributes(modelRegister, path);
    }

    private void registerElement(Model model, Expression expression) throws PathException {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (index > 1 && model.lookup(first, index - 1) == null) {
            throw new PathException("Ordered element '%s' in path '%s' is out of sequence for %s", first, expression, this.detail);
        }
        model.register(first, prefix, index);
    }

    private void registerElements(Model model, Expression expression) throws PathException {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (first != null) {
            Model modelRegister = model.register(first, prefix, index);
            Expression path = expression.getPath(1);
            if (expression.isPath()) {
                registerElements(modelRegister, path);
            }
        }
        registerElement(model, expression);
    }

    public void assemble(Model model, Order order) throws PathException {
        assembleElements(model, order);
        assembleAttributes(model, order);
    }
}
