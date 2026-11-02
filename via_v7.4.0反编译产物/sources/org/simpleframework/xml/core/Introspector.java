package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Introspector {
    private final Contact contact;
    private final Format format;
    private final Label label;
    private final Annotation marker;

    public Introspector(Contact contact, Label label, Format format) {
        this.marker = contact.getAnnotation();
        this.contact = contact;
        this.format = format;
        this.label = label;
    }

    private String getDefault() {
        String override = this.label.getOverride();
        return !isEmpty(override) ? override : this.contact.getName();
    }

    private String getName(Class cls) {
        String root = getRoot(cls);
        return root != null ? root : Reflector.getName(cls.getSimpleName());
    }

    private String getRoot(Class cls) {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            String root = getRoot(cls, superclass);
            if (root != null) {
                return root;
            }
        }
        return null;
    }

    private String getRoot(Class<?> cls, Class<?> cls2) {
        String simpleName = cls2.getSimpleName();
        Root root = (Root) cls2.getAnnotation(Root.class);
        if (root == null) {
            return null;
        }
        String strName = root.name();
        return !isEmpty(strName) ? strName : Reflector.getName(simpleName);
    }

    public Contact getContact() {
        return this.contact;
    }

    public Type getDependent() {
        return this.label.getDependent();
    }

    public String getEntry() {
        Class<?> type = getDependent().getType();
        if (type.isArray()) {
            type = type.getComponentType();
        }
        return getName(type);
    }

    public Expression getExpression() {
        String path = getPath();
        return path != null ? new PathParser(path, this.contact, this.format) : new EmptyExpression(this.format);
    }

    public String getName() {
        return !this.label.isInline() ? getDefault() : this.label.getEntry();
    }

    public String getPath() {
        Path path = (Path) this.contact.getAnnotation(Path.class);
        if (path == null) {
            return null;
        }
        return path.value();
    }

    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public String toString() {
        return String.format("%s on %s", this.marker, this.contact);
    }
}
