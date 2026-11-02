package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Position;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ArrayFactory extends Factory {
    public ArrayFactory(Context context, Type type) {
        super(context, type);
    }

    private Class getComponentType() throws InstantiationException {
        Class type = getType();
        if (type.isArray()) {
            return type.getComponentType();
        }
        throw new InstantiationException("The %s not an array for %s", type, this.type);
    }

    private Instance getInstance(Value value, Class cls) throws InstantiationException {
        Class componentType = getComponentType();
        if (componentType.isAssignableFrom(cls)) {
            return new ArrayInstance(value);
        }
        throw new InstantiationException("Array of type %s cannot hold %s for %s", componentType, cls, this.type);
    }

    @Override // org.simpleframework.xml.core.Factory
    public Object getInstance() throws InstantiationException {
        Class componentType = getComponentType();
        if (componentType != null) {
            return Array.newInstance((Class<?>) componentType, 0);
        }
        return null;
    }

    public Instance getInstance(InputNode inputNode) throws ElementException, InstantiationException {
        Position position = inputNode.getPosition();
        Value override = getOverride(inputNode);
        if (override != null) {
            return getInstance(override, override.getType());
        }
        throw new ElementException("Array length required for %s at %s", this.type, position);
    }
}
