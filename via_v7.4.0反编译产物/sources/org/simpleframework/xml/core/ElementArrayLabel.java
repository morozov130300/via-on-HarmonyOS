package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ElementArrayLabel extends TemplateLabel {
    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private String entry;
    private Format format;
    private ElementArray label;
    private String name;
    private Expression path;
    private boolean required;
    private Class type;

    public ElementArrayLabel(Contact contact, ElementArray elementArray, Format format) {
        this.detail = new Introspector(contact, this, format);
        this.decorator = new Qualifier(contact);
        this.required = elementArray.required();
        this.type = contact.getType();
        this.entry = elementArray.entry();
        this.data = elementArray.data();
        this.name = elementArray.name();
        this.format = format;
        this.label = elementArray;
    }

    private Converter getConverter(Context context, String str) {
        Type dependent = getDependent();
        Contact contact = getContact();
        return !context.isPrimitive(dependent) ? new CompositeArray(context, contact, dependent, str) : new PrimitiveArray(context, contact, dependent, str);
    }

    @Override // org.simpleframework.xml.core.Label
    public Annotation getAnnotation() {
        return this.label;
    }

    @Override // org.simpleframework.xml.core.Label
    public Contact getContact() {
        return this.detail.getContact();
    }

    @Override // org.simpleframework.xml.core.Label
    public Converter getConverter(Context context) throws InstantiationException {
        Contact contact = getContact();
        String entry = getEntry();
        if (this.type.isArray()) {
            return getConverter(context, entry);
        }
        throw new InstantiationException("Type is not an array %s for %s", this.type, contact);
    }

    @Override // org.simpleframework.xml.core.Label
    public Decorator getDecorator() {
        return this.decorator;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public Type getDependent() {
        Class<?> componentType = this.type.getComponentType();
        return componentType == null ? new ClassType(this.type) : new ClassType(componentType);
    }

    @Override // org.simpleframework.xml.core.Label
    public Object getEmpty(Context context) {
        ArrayFactory arrayFactory = new ArrayFactory(context, new ClassType(this.type));
        if (this.label.empty()) {
            return null;
        }
        return arrayFactory.getInstance();
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public String getEntry() {
        Style style = this.format.getStyle();
        if (this.detail.isEmpty(this.entry)) {
            this.entry = this.detail.getEntry();
        }
        return style.getElement(this.entry);
    }

    @Override // org.simpleframework.xml.core.Label
    public Expression getExpression() {
        if (this.path == null) {
            this.path = this.detail.getExpression();
        }
        return this.path;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getName() {
        return this.format.getStyle().getElement(this.detail.getName());
    }

    @Override // org.simpleframework.xml.core.Label
    public String getOverride() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getPath() {
        return getExpression().getElement(getName());
    }

    @Override // org.simpleframework.xml.core.Label
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isData() {
        return this.data;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isRequired() {
        return this.required;
    }

    @Override // org.simpleframework.xml.core.Label
    public String toString() {
        return this.detail.toString();
    }
}
