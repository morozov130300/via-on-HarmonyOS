package org.simpleframework.xml.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class MapFactory extends Factory {
    public MapFactory(Context context, Type type) {
        super(context, type);
    }

    private boolean isMap(Class cls) {
        return Map.class.isAssignableFrom(cls);
    }

    public Class getConversion(Class cls) throws InstantiationException {
        if (cls.isAssignableFrom(HashMap.class)) {
            return HashMap.class;
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return TreeMap.class;
        }
        throw new InstantiationException("Cannot instantiate %s for %s", cls, this.type);
    }

    @Override // org.simpleframework.xml.core.Factory
    public Object getInstance() throws InstantiationException {
        Class type = getType();
        Class conversion = !Factory.isInstantiable(type) ? getConversion(type) : type;
        if (isMap(conversion)) {
            return conversion.newInstance();
        }
        throw new InstantiationException("Invalid map %s for %s", type, this.type);
    }

    public Instance getInstance(InputNode inputNode) throws InstantiationException {
        Value override = getOverride(inputNode);
        Class type = getType();
        if (override != null) {
            return getInstance(override);
        }
        if (!Factory.isInstantiable(type)) {
            type = getConversion(type);
        }
        if (isMap(type)) {
            return this.context.getInstance(type);
        }
        throw new InstantiationException("Invalid map %s for %s", type, this.type);
    }

    public Instance getInstance(Value value) throws InstantiationException {
        Class type = value.getType();
        if (!Factory.isInstantiable(type)) {
            type = getConversion(type);
        }
        if (isMap(type)) {
            return new ConversionInstance(this.context, value, type);
        }
        throw new InstantiationException("Invalid map %s for %s", type, this.type);
    }
}
