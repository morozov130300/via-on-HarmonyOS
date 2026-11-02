package org.simpleframework.xml.core;

import java.util.Collection;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class PrimitiveInlineList implements Repeater {
    private final Type entry;
    private final CollectionFactory factory;
    private final String parent;
    private final Primitive root;

    public PrimitiveInlineList(Context context, Type type, Type type2, String str) {
        this.factory = new CollectionFactory(context, type);
        this.root = new Primitive(context, type2);
        this.parent = str;
        this.entry = type2;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj) {
        return this.factory.setOverride(this.entry, obj, outputNode);
    }

    private Object read(InputNode inputNode, Collection collection) {
        InputNode parent = inputNode.getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            Object obj = this.root.read(inputNode);
            if (obj != null) {
                collection.add(obj);
            }
            inputNode = parent.getNext(name);
        }
        return collection;
    }

    private void write(OutputNode outputNode, Object obj, Mode mode) {
        for (Object obj2 : (Collection) obj) {
            if (obj2 != null) {
                OutputNode child = outputNode.getChild(this.parent);
                if (!isOverridden(child, obj2)) {
                    child.setMode(mode);
                    this.root.write(child, obj2);
                }
            }
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) {
        Collection collection = (Collection) this.factory.getInstance();
        if (collection != null) {
            return read(inputNode, collection);
        }
        return null;
    }

    @Override // org.simpleframework.xml.core.Repeater, org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) {
        Collection collection = (Collection) obj;
        return collection != null ? read(inputNode, collection) : read(inputNode);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) {
        InputNode parent = inputNode.getParent();
        String name = inputNode.getName();
        while (inputNode != null) {
            if (!this.root.validate(inputNode)) {
                return false;
            }
            inputNode = parent.getNext(name);
        }
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) {
        OutputNode parent = outputNode.getParent();
        Mode mode = outputNode.getMode();
        if (!outputNode.isCommitted()) {
            outputNode.remove();
        }
        write(parent, obj, mode);
    }
}
