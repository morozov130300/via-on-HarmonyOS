package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class CacheLabel implements Label {
    private final Annotation annotation;
    private final boolean attribute;
    private final boolean collection;
    private final Contact contact;
    private final boolean data;
    private final Decorator decorator;
    private final Type depend;
    private final String entry;
    private final Expression expression;
    private final boolean inline;
    private final Object key;
    private final Label label;
    private final boolean list;
    private final String name;
    private final String[] names;
    private final String override;
    private final String path;
    private final String[] paths;
    private final boolean required;
    private final boolean text;
    private final Class type;
    private final boolean union;

    public CacheLabel(Label label) {
        this.annotation = label.getAnnotation();
        this.expression = label.getExpression();
        this.decorator = label.getDecorator();
        this.attribute = label.isAttribute();
        this.collection = label.isCollection();
        this.contact = label.getContact();
        this.depend = label.getDependent();
        this.required = label.isRequired();
        this.override = label.getOverride();
        this.list = label.isTextList();
        this.inline = label.isInline();
        this.union = label.isUnion();
        this.names = label.getNames();
        this.paths = label.getPaths();
        this.path = label.getPath();
        this.type = label.getType();
        this.name = label.getName();
        this.entry = label.getEntry();
        this.data = label.isData();
        this.text = label.isText();
        this.key = label.getKey();
        this.label = label;
    }

    @Override // org.simpleframework.xml.core.Label
    public Annotation getAnnotation() {
        return this.annotation;
    }

    @Override // org.simpleframework.xml.core.Label
    public Contact getContact() {
        return this.contact;
    }

    @Override // org.simpleframework.xml.core.Label
    public Converter getConverter(Context context) {
        return this.label.getConverter(context);
    }

    @Override // org.simpleframework.xml.core.Label
    public Decorator getDecorator() {
        return this.decorator;
    }

    @Override // org.simpleframework.xml.core.Label
    public Type getDependent() {
        return this.depend;
    }

    @Override // org.simpleframework.xml.core.Label
    public Object getEmpty(Context context) {
        return this.label.getEmpty(context);
    }

    @Override // org.simpleframework.xml.core.Label
    public String getEntry() {
        return this.entry;
    }

    @Override // org.simpleframework.xml.core.Label
    public Expression getExpression() {
        return this.expression;
    }

    @Override // org.simpleframework.xml.core.Label
    public Object getKey() {
        return this.key;
    }

    @Override // org.simpleframework.xml.core.Label
    public Label getLabel(Class cls) {
        return this.label.getLabel(cls);
    }

    @Override // org.simpleframework.xml.core.Label
    public String getName() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Label
    public String[] getNames() {
        return this.names;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getOverride() {
        return this.override;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getPath() {
        return this.path;
    }

    @Override // org.simpleframework.xml.core.Label
    public String[] getPaths() {
        return this.paths;
    }

    @Override // org.simpleframework.xml.core.Label
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Label
    public Type getType(Class cls) {
        return this.label.getType(cls);
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isAttribute() {
        return this.attribute;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isCollection() {
        return this.collection;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isData() {
        return this.data;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isInline() {
        return this.inline;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isRequired() {
        return this.required;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isText() {
        return this.text;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isTextList() {
        return this.list;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isUnion() {
        return this.union;
    }

    @Override // org.simpleframework.xml.core.Label
    public String toString() {
        return this.label.toString();
    }
}
