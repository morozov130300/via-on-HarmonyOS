package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class CompositeListUnion implements Repeater {
    private final Context context;
    private final LabelMap elements;
    private final Group group;
    private final Expression path;
    private final Style style;
    private final Type type;

    public CompositeListUnion(Context context, Group group, Expression expression, Type type) {
        this.elements = group.getElements();
        this.style = context.getStyle();
        this.context = context;
        this.group = group;
        this.type = type;
        this.path = expression;
    }

    private Object readElement(InputNode inputNode) {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).read(inputNode);
    }

    private Object readElement(InputNode inputNode, Object obj) {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).read(inputNode, obj);
    }

    private Object readText(InputNode inputNode) {
        return this.group.getText().getConverter(this.context).read(inputNode);
    }

    private Object readText(InputNode inputNode, Object obj) {
        return this.group.getText().getConverter(this.context).read(inputNode.getParent(), obj);
    }

    private void write(OutputNode outputNode, Object obj, Label label) {
        Converter converter = label.getConverter(this.context);
        Set setSingleton = Collections.singleton(obj);
        if (!label.isInline()) {
            String element = this.style.getElement(label.getName());
            if (!outputNode.isCommitted()) {
                outputNode.setName(element);
            }
        }
        converter.write(outputNode, setSingleton);
    }

    private void write(OutputNode outputNode, Collection collection) throws UnionException {
        for (Object obj : collection) {
            if (obj != null) {
                Class<?> cls = obj.getClass();
                Label label = this.group.getLabel(cls);
                if (label == null) {
                    throw new UnionException("Entry of %s not declared in %s with annotation %s", cls, this.type, this.group);
                }
                write(outputNode, obj, label);
            }
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) {
        return this.group.getText() == null ? readElement(inputNode) : readText(inputNode);
    }

    @Override // org.simpleframework.xml.core.Repeater, org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) {
        return this.group.getText() != null ? readText(inputNode, obj) : readElement(inputNode, obj);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).validate(inputNode);
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws UnionException {
        Collection collection = (Collection) obj;
        if (!this.group.isInline()) {
            write(outputNode, collection);
        } else if (!collection.isEmpty()) {
            write(outputNode, collection);
        } else {
            if (outputNode.isCommitted()) {
                return;
            }
            outputNode.remove();
        }
    }
}
