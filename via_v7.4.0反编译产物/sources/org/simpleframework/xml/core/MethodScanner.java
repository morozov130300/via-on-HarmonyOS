package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Transient;
import org.simpleframework.xml.Version;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class MethodScanner extends ContactList {
    private final Detail detail;
    private final MethodPartFactory factory;
    private final PartMap read;
    private final Support support;
    private final PartMap write;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class PartMap extends LinkedHashMap<String, MethodPart> implements Iterable<String> {
        private PartMap() {
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return keySet().iterator();
        }

        public MethodPart take(String str) {
            return remove(str);
        }
    }

    public MethodScanner(Detail detail, Support support) throws MethodException {
        this.factory = new MethodPartFactory(detail, support);
        this.write = new PartMap();
        this.read = new PartMap();
        this.support = support;
        this.detail = detail;
        scan(detail);
    }

    private void build() throws MethodException {
        Iterator<String> it = this.read.iterator();
        while (it.hasNext()) {
            String next = it.next();
            MethodPart methodPart = this.read.get(next);
            if (methodPart != null) {
                build(methodPart, next);
            }
        }
    }

    private void build(MethodPart methodPart) {
        add(new MethodContact(methodPart));
    }

    private void build(MethodPart methodPart, String str) throws MethodException {
        MethodPart methodPartTake = this.write.take(str);
        if (methodPartTake != null) {
            build(methodPart, methodPartTake);
        } else {
            build(methodPart);
        }
    }

    private void build(MethodPart methodPart, MethodPart methodPart2) throws MethodException {
        Annotation annotation = methodPart.getAnnotation();
        String name = methodPart.getName();
        if (!methodPart2.getAnnotation().equals(annotation)) {
            throw new MethodException("Annotations do not match for '%s' in %s", name, this.detail);
        }
        Class type = methodPart.getType();
        if (type != methodPart2.getType()) {
            throw new MethodException("Method types do not match for %s in %s", name, type);
        }
        add(new MethodContact(methodPart, methodPart2));
    }

    private void extend(Class cls, DefaultType defaultType) {
        Iterator<Contact> it = this.support.getMethods(cls, defaultType).iterator();
        while (it.hasNext()) {
            process((MethodContact) it.next());
        }
    }

    private void extract(Detail detail) throws MethodException {
        for (MethodDetail methodDetail : detail.getMethods()) {
            Annotation[] annotations = methodDetail.getAnnotations();
            Method method = methodDetail.getMethod();
            for (Annotation annotation : annotations) {
                scan(method, annotation, annotations);
            }
        }
    }

    private void extract(Detail detail, DefaultType defaultType) {
        List<MethodDetail> methods = detail.getMethods();
        if (defaultType == DefaultType.PROPERTY) {
            for (MethodDetail methodDetail : methods) {
                Annotation[] annotations = methodDetail.getAnnotations();
                Method method = methodDetail.getMethod();
                if (this.factory.getType(method) != null) {
                    process(method, annotations);
                }
            }
        }
    }

    private void insert(MethodPart methodPart, PartMap partMap) {
        String name = methodPart.getName();
        MethodPart methodPartRemove = partMap.remove(name);
        if (methodPartRemove != null && isText(methodPart)) {
            methodPart = methodPartRemove;
        }
        partMap.put(name, methodPart);
    }

    private boolean isText(MethodPart methodPart) {
        return methodPart.getAnnotation() instanceof Text;
    }

    private void process(Method method, Annotation annotation, Annotation[] annotationArr) throws MethodException {
        MethodPart methodPartFactory = this.factory.getInstance(method, annotation, annotationArr);
        MethodType methodType = methodPartFactory.getMethodType();
        if (methodType == MethodType.GET) {
            process(methodPartFactory, this.read);
        }
        if (methodType == MethodType.IS) {
            process(methodPartFactory, this.read);
        }
        if (methodType == MethodType.SET) {
            process(methodPartFactory, this.write);
        }
    }

    private void process(Method method, Annotation[] annotationArr) {
        MethodPart methodPartFactory = this.factory.getInstance(method, annotationArr);
        MethodType methodType = methodPartFactory.getMethodType();
        if (methodType == MethodType.GET) {
            process(methodPartFactory, this.read);
        }
        if (methodType == MethodType.IS) {
            process(methodPartFactory, this.read);
        }
        if (methodType == MethodType.SET) {
            process(methodPartFactory, this.write);
        }
    }

    private void process(MethodContact methodContact) {
        MethodPart read = methodContact.getRead();
        MethodPart write = methodContact.getWrite();
        if (write != null) {
            insert(write, this.write);
        }
        insert(read, this.read);
    }

    private void process(MethodPart methodPart, PartMap partMap) {
        String name = methodPart.getName();
        if (name != null) {
            partMap.put(name, methodPart);
        }
    }

    private void remove(Method method, Annotation annotation, Annotation[] annotationArr) throws MethodException {
        MethodPart methodPartFactory = this.factory.getInstance(method, annotation, annotationArr);
        MethodType methodType = methodPartFactory.getMethodType();
        if (methodType == MethodType.GET) {
            remove(methodPartFactory, this.read);
        }
        if (methodType == MethodType.IS) {
            remove(methodPartFactory, this.read);
        }
        if (methodType == MethodType.SET) {
            remove(methodPartFactory, this.write);
        }
    }

    private void remove(MethodPart methodPart, PartMap partMap) {
        String name = methodPart.getName();
        if (name != null) {
            partMap.remove(name);
        }
    }

    private void scan(Method method, Annotation annotation, Annotation[] annotationArr) throws MethodException {
        if (annotation instanceof Attribute) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof ElementUnion) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof ElementListUnion) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof ElementMapUnion) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof ElementList) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof ElementArray) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof ElementMap) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof Element) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof Version) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof Text) {
            process(method, annotation, annotationArr);
        }
        if (annotation instanceof Transient) {
            remove(method, annotation, annotationArr);
        }
    }

    private void scan(Detail detail) throws MethodException {
        DefaultType override = detail.getOverride();
        DefaultType access = detail.getAccess();
        Class cls = detail.getSuper();
        if (cls != null) {
            extend(cls, override);
        }
        extract(detail, access);
        extract(detail);
        build();
        validate();
    }

    private void validate() throws MethodException {
        Iterator<String> it = this.write.iterator();
        while (it.hasNext()) {
            String next = it.next();
            MethodPart methodPart = this.write.get(next);
            if (methodPart != null) {
                validate(methodPart, next);
            }
        }
    }

    private void validate(MethodPart methodPart, String str) throws MethodException {
        MethodPart methodPartTake = this.read.take(str);
        Method method = methodPart.getMethod();
        if (methodPartTake == null) {
            throw new MethodException("No matching get method for %s in %s", method, this.detail);
        }
    }
}
