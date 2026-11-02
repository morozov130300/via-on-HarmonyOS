package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;
import org.simpleframework.xml.transform.Transformer;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Support implements Filter {
    private final DetailExtractor defaults;
    private final DetailExtractor details;
    private final Filter filter;
    private final Format format;
    private final InstanceFactory instances;
    private final LabelExtractor labels;
    private final Matcher matcher;
    private final ScannerFactory scanners;
    private final Transformer transform;

    public Support() {
        this(new PlatformFilter());
    }

    public Support(Filter filter) {
        this(filter, new EmptyMatcher());
    }

    public Support(Filter filter, Matcher matcher) {
        this(filter, matcher, new Format());
    }

    public Support(Filter filter, Matcher matcher, Format format) {
        this.defaults = new DetailExtractor(this, DefaultType.FIELD);
        this.transform = new Transformer(matcher);
        this.scanners = new ScannerFactory(this);
        this.details = new DetailExtractor(this);
        this.labels = new LabelExtractor(format);
        this.instances = new InstanceFactory();
        this.matcher = matcher;
        this.filter = filter;
        this.format = format;
    }

    private String getClassName(Class cls) {
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        String simpleName = cls.getSimpleName();
        return cls.isPrimitive() ? simpleName : Reflector.getName(simpleName);
    }

    public static Class getPrimitive(Class cls) {
        return cls == Double.TYPE ? Double.class : cls == Float.TYPE ? Float.class : cls == Integer.TYPE ? Integer.class : cls == Long.TYPE ? Long.class : cls == Boolean.TYPE ? Boolean.class : cls == Character.TYPE ? Character.class : cls == Short.TYPE ? Short.class : cls == Byte.TYPE ? Byte.class : cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isAssignable(Class cls, Class cls2) {
        if (cls.isPrimitive()) {
            cls = getPrimitive(cls);
        }
        boolean zIsPrimitive = cls2.isPrimitive();
        Class primitive = cls2;
        if (zIsPrimitive) {
            primitive = getPrimitive(cls2);
        }
        return primitive.isAssignableFrom(cls);
    }

    public static boolean isFloat(Class cls) {
        return cls == Double.class || cls == Float.class || cls == Float.TYPE || cls == Double.TYPE;
    }

    public Detail getDetail(Class cls) {
        return getDetail(cls, null);
    }

    public Detail getDetail(Class cls, DefaultType defaultType) {
        return defaultType != null ? this.defaults.getDetail(cls) : this.details.getDetail(cls);
    }

    public ContactList getFields(Class cls) {
        return getFields(cls, null);
    }

    public ContactList getFields(Class cls, DefaultType defaultType) {
        return defaultType != null ? this.defaults.getFields(cls) : this.details.getFields(cls);
    }

    public Format getFormat() {
        return this.format;
    }

    public Instance getInstance(Class cls) {
        return this.instances.getInstance(cls);
    }

    public Instance getInstance(Value value) {
        return this.instances.getInstance(value);
    }

    public Label getLabel(Contact contact, Annotation annotation) {
        return this.labels.getLabel(contact, annotation);
    }

    public List<Label> getLabels(Contact contact, Annotation annotation) {
        return this.labels.getList(contact, annotation);
    }

    public ContactList getMethods(Class cls) {
        return getMethods(cls, null);
    }

    public ContactList getMethods(Class cls, DefaultType defaultType) {
        return defaultType != null ? this.defaults.getMethods(cls) : this.details.getMethods(cls);
    }

    public String getName(Class cls) {
        String name = getScanner(cls).getName();
        return name != null ? name : getClassName(cls);
    }

    public Scanner getScanner(Class cls) {
        return this.scanners.getInstance(cls);
    }

    public Style getStyle() {
        return this.format.getStyle();
    }

    public Transform getTransform(Class cls) {
        return this.matcher.match(cls);
    }

    public boolean isContainer(Class cls) {
        if (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return true;
        }
        return cls.isArray();
    }

    public boolean isPrimitive(Class cls) {
        if (cls == String.class || cls == Float.class || cls == Double.class || cls == Long.class || cls == Integer.class || cls == Boolean.class || cls.isEnum() || cls.isPrimitive()) {
            return true;
        }
        return this.transform.valid(cls);
    }

    public Object read(String str, Class cls) {
        return this.transform.read(str, cls);
    }

    @Override // org.simpleframework.xml.filter.Filter
    public String replace(String str) {
        return this.filter.replace(str);
    }

    public boolean valid(Class cls) {
        return this.transform.valid(cls);
    }

    public String write(Object obj, Class cls) {
        return this.transform.write(obj, cls);
    }
}
