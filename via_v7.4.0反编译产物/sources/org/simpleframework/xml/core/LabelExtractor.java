package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class LabelExtractor {
    private final Cache<LabelGroup> cache = new ConcurrentCache();
    private final Format format;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class LabelBuilder {
        private final Class entry;
        private final Class label;
        private final Class type;

        public LabelBuilder(Class cls, Class cls2) {
            this(cls, cls2, null);
        }

        public LabelBuilder(Class cls, Class cls2, Class cls3) {
            this.entry = cls3;
            this.label = cls2;
            this.type = cls;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Constructor getConstructor(Class cls) {
            return this.type.getConstructor(Contact.class, cls, Format.class);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Constructor getConstructor(Class cls, Class cls2) {
            return this.type.getConstructor(Contact.class, cls, cls2, Format.class);
        }

        public Constructor getConstructor() {
            Class cls = this.entry;
            return cls != null ? getConstructor(this.label, cls) : getConstructor(this.label);
        }
    }

    public LabelExtractor(Format format) {
        this.format = format;
    }

    private Annotation[] getAnnotations(Annotation annotation) throws SecurityException {
        Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
        return declaredMethods.length > 0 ? (Annotation[]) declaredMethods[0].invoke(annotation, null) : new Annotation[0];
    }

    private LabelBuilder getBuilder(Annotation annotation) throws PersistenceException {
        if (annotation instanceof Element) {
            return new LabelBuilder(ElementLabel.class, Element.class);
        }
        if (annotation instanceof ElementList) {
            return new LabelBuilder(ElementListLabel.class, ElementList.class);
        }
        if (annotation instanceof ElementArray) {
            return new LabelBuilder(ElementArrayLabel.class, ElementArray.class);
        }
        if (annotation instanceof ElementMap) {
            return new LabelBuilder(ElementMapLabel.class, ElementMap.class);
        }
        if (annotation instanceof ElementUnion) {
            return new LabelBuilder(ElementUnionLabel.class, ElementUnion.class, Element.class);
        }
        if (annotation instanceof ElementListUnion) {
            return new LabelBuilder(ElementListUnionLabel.class, ElementListUnion.class, ElementList.class);
        }
        if (annotation instanceof ElementMapUnion) {
            return new LabelBuilder(ElementMapUnionLabel.class, ElementMapUnion.class, ElementMap.class);
        }
        if (annotation instanceof Attribute) {
            return new LabelBuilder(AttributeLabel.class, Attribute.class);
        }
        if (annotation instanceof Version) {
            return new LabelBuilder(VersionLabel.class, Version.class);
        }
        if (annotation instanceof Text) {
            return new LabelBuilder(TextLabel.class, Text.class);
        }
        throw new PersistenceException("Annotation %s not supported", annotation);
    }

    private Constructor getConstructor(Annotation annotation) {
        Constructor constructor = getBuilder(annotation).getConstructor();
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        return constructor;
    }

    private LabelGroup getGroup(Contact contact, Annotation annotation, Object obj) {
        LabelGroup labelGroupFetch = this.cache.fetch(obj);
        if (labelGroupFetch != null) {
            return labelGroupFetch;
        }
        LabelGroup labels = getLabels(contact, annotation);
        if (labels != null) {
            this.cache.cache(obj, labels);
        }
        return labels;
    }

    private Object getKey(Contact contact, Annotation annotation) {
        return new LabelKey(contact, annotation);
    }

    private Label getLabel(Contact contact, Annotation annotation, Annotation annotation2) {
        Constructor constructor = getConstructor(annotation);
        return annotation2 != null ? (Label) constructor.newInstance(contact, annotation, annotation2, this.format) : (Label) constructor.newInstance(contact, annotation, this.format);
    }

    private LabelGroup getLabels(Contact contact, Annotation annotation) {
        if (!(annotation instanceof ElementUnion) && !(annotation instanceof ElementListUnion) && !(annotation instanceof ElementMapUnion)) {
            return getSingle(contact, annotation);
        }
        return getUnion(contact, annotation);
    }

    private LabelGroup getSingle(Contact contact, Annotation annotation) {
        Label label = getLabel(contact, annotation, null);
        if (label != null) {
            label = new CacheLabel(label);
        }
        return new LabelGroup(label);
    }

    private LabelGroup getUnion(Contact contact, Annotation annotation) throws SecurityException {
        Annotation[] annotations = getAnnotations(annotation);
        if (annotations.length <= 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (Annotation annotation2 : annotations) {
            Label label = getLabel(contact, annotation, annotation2);
            if (label != null) {
                label = new CacheLabel(label);
            }
            linkedList.add(label);
        }
        return new LabelGroup(linkedList);
    }

    public Label getLabel(Contact contact, Annotation annotation) {
        LabelGroup group = getGroup(contact, annotation, getKey(contact, annotation));
        if (group != null) {
            return group.getPrimary();
        }
        return null;
    }

    public List<Label> getList(Contact contact, Annotation annotation) {
        LabelGroup group = getGroup(contact, annotation, getKey(contact, annotation));
        return group != null ? group.getList() : Collections.EMPTY_LIST;
    }
}
