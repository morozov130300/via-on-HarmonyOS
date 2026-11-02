package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class CompositeArray implements Converter {
    private final Type entry;
    private final ArrayFactory factory;
    private final String parent;
    private final Traverser root;
    private final Type type;

    public CompositeArray(Context context, Type type, Type type2, String str) {
        this.factory = new ArrayFactory(context, type);
        this.root = new Traverser(context);
        this.parent = str;
        this.entry = type2;
        this.type = type;
    }

    private void read(InputNode inputNode, Object obj, int i10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Array.set(obj, i10, !inputNode.isEmpty() ? this.root.read(inputNode, this.entry.getType()) : null);
    }

    private boolean validate(InputNode inputNode, Class cls) {
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                return true;
            }
            if (!next.isEmpty()) {
                this.root.validate(next, cls);
            }
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws ElementException, InstantiationException {
        Instance arrayFactory = this.factory.getInstance(inputNode);
        Object instance = arrayFactory.getInstance();
        return !arrayFactory.isReference() ? read(inputNode, instance) : instance;
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws ElementException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int length = Array.getLength(obj);
        int i10 = 0;
        while (true) {
            Position position = inputNode.getPosition();
            InputNode next = inputNode.getNext();
            if (next == null) {
                return obj;
            }
            if (i10 >= length) {
                throw new ElementException("Array length missing or incorrect for %s at %s", this.type, position);
            }
            read(next, obj, i10);
            i10++;
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws ElementException, InstantiationException {
        Instance arrayFactory = this.factory.getInstance(inputNode);
        if (arrayFactory.isReference()) {
            return true;
        }
        arrayFactory.setInstance(null);
        return validate(inputNode, arrayFactory.getType());
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.root.write(outputNode, Array.get(obj, i10), this.entry.getType(), this.parent);
        }
        outputNode.commit();
    }
}
