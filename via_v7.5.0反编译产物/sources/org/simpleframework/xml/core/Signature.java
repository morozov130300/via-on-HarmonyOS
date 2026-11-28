package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class Signature implements Iterable<Parameter> {
    private final Constructor factory;
    private final ParameterMap parameters;
    private final Class type;

    public Signature(Signature signature) {
        this(signature.factory, signature.type);
    }

    public void add(Parameter parameter) {
        Object key = parameter.getKey();
        if (key != null) {
            this.parameters.put(key, parameter);
        }
    }

    public boolean contains(Object obj) {
        return this.parameters.containsKey(obj);
    }

    public Signature copy() {
        Signature signature = new Signature(this);
        Iterator<Parameter> it = iterator();
        while (it.hasNext()) {
            signature.add(it.next());
        }
        return signature;
    }

    public Object create() {
        if (!this.factory.isAccessible()) {
            this.factory.setAccessible(true);
        }
        return this.factory.newInstance(null);
    }

    public Parameter get(int i10) {
        return this.parameters.get(i10);
    }

    public List<Parameter> getAll() {
        return this.parameters.getAll();
    }

    public Class getType() {
        return this.type;
    }

    public boolean isEmpty() {
        return this.parameters.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Parameter> iterator() {
        return this.parameters.iterator();
    }

    public Parameter remove(Object obj) {
        return this.parameters.remove(obj);
    }

    public void set(Object obj, Parameter parameter) {
        this.parameters.put(obj, parameter);
    }

    public int size() {
        return this.parameters.size();
    }

    public String toString() {
        return this.factory.toString();
    }

    public Signature(Constructor constructor) {
        this(constructor, constructor.getDeclaringClass());
    }

    public Parameter get(Object obj) {
        return this.parameters.get(obj);
    }

    public Signature(Constructor constructor, Class cls) {
        this.parameters = new ParameterMap();
        this.factory = constructor;
        this.type = cls;
    }

    public Object create(Object[] objArr) {
        if (!this.factory.isAccessible()) {
            this.factory.setAccessible(true);
        }
        return this.factory.newInstance(objArr);
    }
}
