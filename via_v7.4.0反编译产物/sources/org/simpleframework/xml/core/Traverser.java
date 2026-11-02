package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Traverser {
    private final Context context;
    private final Style style;

    public Traverser(Context context) {
        this.style = context.getStyle();
        this.context = context;
    }

    private Composite getComposite(Class cls) throws RootException {
        Type type = getType(cls);
        if (cls != null) {
            return new Composite(this.context, type);
        }
        throw new RootException("Can not instantiate null class", new Object[0]);
    }

    private Decorator getDecorator(Class cls) {
        return this.context.getDecorator(cls);
    }

    private Type getType(Class cls) {
        return new ClassType(cls);
    }

    private Object read(InputNode inputNode, Class cls, Object obj) throws RootException {
        if (getName(cls) != null) {
            return obj;
        }
        throw new RootException("Root annotation required for %s", cls);
    }

    public String getName(Class cls) {
        return this.style.getElement(this.context.getName(cls));
    }

    public Object read(InputNode inputNode, Class cls) {
        Object obj = getComposite(cls).read(inputNode);
        if (obj != null) {
            return read(inputNode, obj.getClass(), obj);
        }
        return null;
    }

    public Object read(InputNode inputNode, Object obj) {
        Class<?> cls = obj.getClass();
        return read(inputNode, cls, getComposite(cls).read(inputNode, obj));
    }

    public boolean validate(InputNode inputNode, Class cls) {
        Composite composite = getComposite(cls);
        if (getName(cls) != null) {
            return composite.validate(inputNode);
        }
        throw new RootException("Root annotation required for %s", cls);
    }

    public void write(OutputNode outputNode, Object obj) {
        write(outputNode, obj, obj.getClass());
    }

    public void write(OutputNode outputNode, Object obj, Class cls) throws RootException {
        Class<?> cls2 = obj.getClass();
        String name = getName(cls2);
        if (name == null) {
            throw new RootException("Root annotation required for %s", cls2);
        }
        write(outputNode, obj, cls, name);
    }

    public void write(OutputNode outputNode, Object obj, Class cls, String str) {
        OutputNode child = outputNode.getChild(str);
        Type type = getType(cls);
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            Decorator decorator = getDecorator(cls2);
            if (decorator != null) {
                decorator.decorate(child);
            }
            if (!this.context.setOverride(type, obj, child)) {
                getComposite(cls2).write(child, obj);
            }
        }
        child.commit();
    }
}
