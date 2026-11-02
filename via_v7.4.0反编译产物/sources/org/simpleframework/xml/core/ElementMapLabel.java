package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class ElementMapLabel extends TemplateLabel {
    private Expression cache;
    private boolean data;
    private Decorator decorator;
    private Introspector detail;
    private Entry entry;
    private Format format;
    private boolean inline;
    private Class[] items;
    private ElementMap label;
    private String name;
    private String override;
    private String parent;
    private String path;
    private boolean required;
    private Class type;

    public ElementMapLabel(Contact contact, ElementMap elementMap, Format format) {
        this.detail = new Introspector(contact, this, format);
        this.decorator = new Qualifier(contact);
        this.entry = new Entry(contact, elementMap);
        this.required = elementMap.required();
        this.type = contact.getType();
        this.inline = elementMap.inline();
        this.override = elementMap.name();
        this.data = elementMap.data();
        this.format = format;
        this.label = elementMap;
    }

    private Type getMap() {
        return new ClassType(this.type);
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
    public Converter getConverter(Context context) {
        Type map = getMap();
        return !this.label.inline() ? new CompositeMap(context, this.entry, map) : new CompositeInlineMap(context, this.entry, map);
    }

    @Override // org.simpleframework.xml.core.Label
    public Decorator getDecorator() {
        return this.decorator;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public Type getDependent() throws ElementException {
        Contact contact = getContact();
        if (this.items == null) {
            this.items = contact.getDependents();
        }
        Class[] clsArr = this.items;
        if (clsArr != null) {
            return clsArr.length == 0 ? new ClassType(Object.class) : new ClassType(clsArr[0]);
        }
        throw new ElementException("Unable to determine type for %s", contact);
    }

    @Override // org.simpleframework.xml.core.Label
    public Object getEmpty(Context context) {
        MapFactory mapFactory = new MapFactory(context, new ClassType(this.type));
        if (this.label.empty()) {
            return null;
        }
        return mapFactory.getInstance();
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public String getEntry() {
        Style style = this.format.getStyle();
        if (this.detail.isEmpty(this.parent)) {
            this.parent = this.detail.getEntry();
        }
        return style.getElement(this.parent);
    }

    @Override // org.simpleframework.xml.core.Label
    public Expression getExpression() {
        if (this.cache == null) {
            this.cache = this.detail.getExpression();
        }
        return this.cache;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getName() {
        if (this.name == null) {
            Style style = this.format.getStyle();
            String entry = this.entry.getEntry();
            if (!this.label.inline()) {
                entry = this.detail.getName();
            }
            this.name = style.getElement(entry);
        }
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getOverride() {
        return this.override;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getPath() {
        if (this.path == null) {
            this.path = getExpression().getElement(getName());
        }
        return this.path;
    }

    @Override // org.simpleframework.xml.core.Label
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public boolean isCollection() {
        return true;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isData() {
        return this.data;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public boolean isInline() {
        return this.inline;
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
