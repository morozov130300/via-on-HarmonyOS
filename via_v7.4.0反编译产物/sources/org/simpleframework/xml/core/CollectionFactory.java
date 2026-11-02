package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class CollectionFactory extends Factory {
    public CollectionFactory(Context context, Type type) {
        super(context, type);
    }

    private boolean isCollection(Class cls) {
        return Collection.class.isAssignableFrom(cls);
    }

    public Class getConversion(Class cls) throws InstantiationException {
        if (cls.isAssignableFrom(ArrayList.class)) {
            return ArrayList.class;
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return HashSet.class;
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return TreeSet.class;
        }
        throw new InstantiationException("Cannot instantiate %s for %s", cls, this.type);
    }

    @Override // org.simpleframework.xml.core.Factory
    public Object getInstance() throws InstantiationException {
        Class type = getType();
        Class conversion = !Factory.isInstantiable(type) ? getConversion(type) : type;
        if (isCollection(conversion)) {
            return conversion.newInstance();
        }
        throw new InstantiationException("Invalid collection %s for %s", type, this.type);
    }

    public Instance getInstance(Value value) throws InstantiationException {
        Class type = value.getType();
        if (!Factory.isInstantiable(type)) {
            type = getConversion(type);
        }
        if (isCollection(type)) {
            return new ConversionInstance(this.context, value, type);
        }
        throw new InstantiationException("Invalid collection %s for %s", type, this.type);
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
        if (isCollection(type)) {
            return this.context.getInstance(type);
        }
        throw new InstantiationException("Invalid collection %s for %s", type, this.type);
    }
}
