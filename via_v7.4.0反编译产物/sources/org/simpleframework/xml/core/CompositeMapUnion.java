package org.simpleframework.xml.core;

import java.util.Collections;
import java.util.Map;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class CompositeMapUnion implements Repeater {
    private final Context context;
    private final LabelMap elements;
    private final Group group;
    private final Expression path;
    private final Style style;
    private final Type type;

    public CompositeMapUnion(Context context, Group group, Expression expression, Type type) {
        this.elements = group.getElements();
        this.style = context.getStyle();
        this.context = context;
        this.group = group;
        this.type = type;
        this.path = expression;
    }

    private void write(OutputNode outputNode, Object obj, Object obj2, Label label) {
        Converter converter = label.getConverter(this.context);
        Map mapSingletonMap = Collections.singletonMap(obj, obj2);
        if (!label.isInline()) {
            String element = this.style.getElement(label.getName());
            if (!outputNode.isCommitted()) {
                outputNode.setName(element);
            }
        }
        converter.write(outputNode, mapSingletonMap);
    }

    private void write(OutputNode outputNode, Map map) throws UnionException {
        for (Object obj : map.keySet()) {
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                Class<?> cls = obj2.getClass();
                Label label = this.group.getLabel(cls);
                if (label == null) {
                    throw new UnionException("Value of %s not declared in %s with annotation %s", cls, this.type, this.group);
                }
                write(outputNode, obj, obj2, label);
            }
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).read(inputNode);
    }

    @Override // org.simpleframework.xml.core.Repeater, org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).read(inputNode, obj);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) {
        return this.elements.get(this.path.getElement(inputNode.getName())).getConverter(this.context).validate(inputNode);
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws UnionException {
        Map map = (Map) obj;
        if (!this.group.isInline()) {
            write(outputNode, map);
        } else if (!map.isEmpty()) {
            write(outputNode, map);
        } else {
            if (outputNode.isCommitted()) {
                return;
            }
            outputNode.remove();
        }
    }
}
