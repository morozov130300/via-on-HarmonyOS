package org.simpleframework.xml.convert;

import java.util.Map;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class RegistryStrategy implements Strategy {
    private final Registry registry;
    private final Strategy strategy;

    public RegistryStrategy(Registry registry) {
        this(registry, new TreeStrategy());
    }

    public RegistryStrategy(Registry registry, Strategy strategy) {
        this.registry = registry;
        this.strategy = strategy;
    }

    private boolean isReference(Value value) {
        return value != null && value.isReference();
    }

    private Converter lookup(Type type, Object obj) {
        Class<?> type2 = type.getType();
        if (obj != null) {
            type2 = obj.getClass();
        }
        return this.registry.lookup(type2);
    }

    private Converter lookup(Type type, Value value) {
        Class type2 = type.getType();
        if (value != null) {
            type2 = value.getType();
        }
        return this.registry.lookup(type2);
    }

    private Value read(Type type, NodeMap<InputNode> nodeMap, Value value) {
        Converter converterLookup = lookup(type, value);
        InputNode inputNode = (InputNode) nodeMap.getNode();
        if (converterLookup == null) {
            return value;
        }
        Object obj = converterLookup.read(inputNode);
        Class type2 = type.getType();
        if (value != null) {
            value.setValue(obj);
        }
        return new Reference(value, obj, type2);
    }

    private boolean write(Type type, Object obj, NodeMap<OutputNode> nodeMap) {
        Converter converterLookup = lookup(type, obj);
        OutputNode outputNode = (OutputNode) nodeMap.getNode();
        if (converterLookup == null) {
            return false;
        }
        converterLookup.write(outputNode, obj);
        return true;
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public Value read(Type type, NodeMap<InputNode> nodeMap, Map map) {
        Value value = this.strategy.read(type, nodeMap, map);
        return isReference(value) ? value : read(type, nodeMap, value);
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public boolean write(Type type, Object obj, NodeMap<OutputNode> nodeMap, Map map) {
        boolean zWrite = this.strategy.write(type, obj, nodeMap, map);
        return !zWrite ? write(type, obj, nodeMap) : zWrite;
    }
}
