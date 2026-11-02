package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class TextList implements Repeater {
    private final CollectionFactory factory;
    private final Primitive primitive;
    private final Type type;

    public TextList(Context context, Type type, Label label) {
        ClassType classType = new ClassType(String.class);
        this.type = classType;
        this.factory = new CollectionFactory(context, type);
        this.primitive = new Primitive(context, classType);
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws InstantiationException {
        Instance collectionFactory = this.factory.getInstance(inputNode);
        return collectionFactory.isReference() ? collectionFactory.getInstance() : read(inputNode, collectionFactory.getInstance());
    }

    @Override // org.simpleframework.xml.core.Repeater, org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) {
        Collection collection = (Collection) obj;
        Object obj2 = this.primitive.read(inputNode);
        if (obj2 != null) {
            collection.add(obj2);
        }
        return obj;
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) {
        return true;
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) {
        OutputNode parent = outputNode.getParent();
        Iterator it = ((Collection) obj).iterator();
        while (it.hasNext()) {
            this.primitive.write(parent, it.next());
        }
    }
}
