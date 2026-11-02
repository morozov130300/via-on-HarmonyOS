package org.simpleframework.xml.strategy;

import java.util.HashMap;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ReadGraph extends HashMap {
    private final String label;
    private final String length;
    private final Loader loader;

    /* renamed from: mark, reason: collision with root package name */
    private final String f10888mark;
    private final String refer;

    public ReadGraph(Contract contract, Loader loader) {
        this.refer = contract.getReference();
        this.f10888mark = contract.getIdentity();
        this.length = contract.getLength();
        this.label = contract.getLabel();
        this.loader = loader;
    }

    private Value readArray(Type type, Class cls, NodeMap nodeMap) {
        Node nodeRemove = nodeMap.remove(this.length);
        return new ArrayValue(cls, nodeRemove != null ? Integer.parseInt(nodeRemove.getValue()) : 0);
    }

    private Value readInstance(Type type, Class cls, NodeMap nodeMap) throws CycleException {
        Node nodeRemove = nodeMap.remove(this.f10888mark);
        if (nodeRemove == null) {
            return readReference(type, cls, nodeMap);
        }
        String value = nodeRemove.getValue();
        if (containsKey(value)) {
            throw new CycleException("Element '%s' already exists", value);
        }
        return readValue(type, cls, nodeMap, value);
    }

    private Value readReference(Type type, Class cls, NodeMap nodeMap) throws CycleException {
        Node nodeRemove = nodeMap.remove(this.refer);
        if (nodeRemove == null) {
            return readValue(type, cls, nodeMap);
        }
        String value = nodeRemove.getValue();
        V v10 = get(value);
        if (containsKey(value)) {
            return new Reference(v10, cls);
        }
        throw new CycleException("Invalid reference '%s' found", value);
    }

    private Value readValue(Type type, Class cls, NodeMap nodeMap) {
        return type.getType().isArray() ? readArray(type, cls, nodeMap) : new ObjectValue(cls);
    }

    private Value readValue(Type type, Class cls, NodeMap nodeMap, String str) {
        Value value = readValue(type, cls, nodeMap);
        return str != null ? new Allocate(value, this, str) : value;
    }

    public Value read(Type type, NodeMap nodeMap) {
        Node nodeRemove = nodeMap.remove(this.label);
        Class type2 = type.getType();
        if (type2.isArray()) {
            type2 = type2.getComponentType();
        }
        if (nodeRemove != null) {
            type2 = this.loader.load(nodeRemove.getValue());
        }
        return readInstance(type, type2, nodeMap);
    }
}
