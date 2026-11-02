package org.simpleframework.xml.core;

import java.util.Map;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class CompositeMap implements Converter {
    private final Entry entry;
    private final MapFactory factory;
    private final Converter key;
    private final Style style;
    private final Converter value;

    public CompositeMap(Context context, Entry entry, Type type) {
        this.factory = new MapFactory(context, type);
        this.value = entry.getValue(context);
        this.key = entry.getKey(context);
        this.style = context.getStyle();
        this.entry = entry;
    }

    private Object populate(InputNode inputNode, Object obj) {
        Map map = (Map) obj;
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                return map;
            }
            map.put(this.key.read(next), this.value.read(next));
        }
    }

    private boolean validate(InputNode inputNode, Class cls) {
        InputNode next;
        do {
            next = inputNode.getNext();
            if (next == null) {
                return true;
            }
            if (!this.key.validate(next)) {
                return false;
            }
        } while (this.value.validate(next));
        return false;
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) throws InstantiationException {
        Instance mapFactory = this.factory.getInstance(inputNode);
        Object instance = mapFactory.getInstance();
        return !mapFactory.isReference() ? populate(inputNode, instance) : instance;
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws InstantiationException {
        Instance mapFactory = this.factory.getInstance(inputNode);
        if (mapFactory.isReference()) {
            return mapFactory.getInstance();
        }
        mapFactory.setInstance(obj);
        return obj != null ? populate(inputNode, obj) : obj;
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) throws InstantiationException {
        Instance mapFactory = this.factory.getInstance(inputNode);
        if (mapFactory.isReference()) {
            return true;
        }
        mapFactory.setInstance(null);
        return validate(inputNode, mapFactory.getType());
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) {
        Map map = (Map) obj;
        for (Object obj2 : map.keySet()) {
            OutputNode child = outputNode.getChild(this.style.getElement(this.entry.getEntry()));
            Object obj3 = map.get(obj2);
            this.key.write(child, obj2);
            this.value.write(child, obj3);
        }
    }
}
