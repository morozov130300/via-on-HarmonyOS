package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Source implements Context {
    private TemplateEngine engine;
    private Filter filter;
    private Session session;
    private Strategy strategy;
    private Support support;

    public Source(Strategy strategy, Support support, Session session) {
        TemplateFilter templateFilter = new TemplateFilter(this, support);
        this.filter = templateFilter;
        this.engine = new TemplateEngine(templateFilter);
        this.strategy = strategy;
        this.support = support;
        this.session = session;
    }

    private Scanner getScanner(Class cls) {
        return this.support.getScanner(cls);
    }

    @Override // org.simpleframework.xml.core.Context
    public Object getAttribute(Object obj) {
        return this.session.get(obj);
    }

    @Override // org.simpleframework.xml.core.Context
    public Caller getCaller(Class cls) {
        return getScanner(cls).getCaller(this);
    }

    @Override // org.simpleframework.xml.core.Context
    public Decorator getDecorator(Class cls) {
        return getScanner(cls).getDecorator();
    }

    @Override // org.simpleframework.xml.core.Context
    public Instance getInstance(Class cls) {
        return this.support.getInstance(cls);
    }

    @Override // org.simpleframework.xml.core.Context
    public Instance getInstance(Value value) {
        return this.support.getInstance(value);
    }

    @Override // org.simpleframework.xml.core.Context
    public String getName(Class cls) {
        return this.support.getName(cls);
    }

    @Override // org.simpleframework.xml.core.Context
    public Value getOverride(Type type, InputNode inputNode) throws PersistenceException {
        NodeMap<InputNode> attributes = inputNode.getAttributes();
        if (attributes != null) {
            return this.strategy.read(type, attributes, this.session);
        }
        throw new PersistenceException("No attributes for %s", inputNode);
    }

    @Override // org.simpleframework.xml.core.Context
    public String getProperty(String str) {
        return this.engine.process(str);
    }

    @Override // org.simpleframework.xml.core.Context
    public Schema getSchema(Class cls) throws PersistenceException {
        Scanner scanner = getScanner(cls);
        if (scanner != null) {
            return new ClassSchema(scanner, this);
        }
        throw new PersistenceException("Invalid schema class %s", cls);
    }

    @Override // org.simpleframework.xml.core.Context
    public Session getSession() {
        return this.session;
    }

    @Override // org.simpleframework.xml.core.Context
    public Style getStyle() {
        return this.support.getStyle();
    }

    @Override // org.simpleframework.xml.core.Context
    public Support getSupport() {
        return this.support;
    }

    @Override // org.simpleframework.xml.core.Context
    public Class getType(Type type, Object obj) {
        return obj != null ? obj.getClass() : type.getType();
    }

    @Override // org.simpleframework.xml.core.Context
    public Version getVersion(Class cls) {
        return getScanner(cls).getRevision();
    }

    @Override // org.simpleframework.xml.core.Context
    public boolean isFloat(Class cls) {
        return Support.isFloat(cls);
    }

    @Override // org.simpleframework.xml.core.Context
    public boolean isFloat(Type type) {
        return isFloat(type.getType());
    }

    @Override // org.simpleframework.xml.core.Context
    public boolean isPrimitive(Class cls) {
        return this.support.isPrimitive(cls);
    }

    @Override // org.simpleframework.xml.core.Context
    public boolean isPrimitive(Type type) {
        return isPrimitive(type.getType());
    }

    @Override // org.simpleframework.xml.core.Context
    public boolean isStrict() {
        return this.session.isStrict();
    }

    @Override // org.simpleframework.xml.core.Context
    public boolean setOverride(Type type, Object obj, OutputNode outputNode) throws PersistenceException {
        NodeMap<OutputNode> attributes = outputNode.getAttributes();
        if (attributes != null) {
            return this.strategy.write(type, obj, attributes, this.session);
        }
        throw new PersistenceException("No attributes for %s", outputNode);
    }
}
