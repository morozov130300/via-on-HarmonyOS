package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class GroupExtractor implements Group {
    private final LabelMap elements;
    private final ExtractorFactory factory;
    private final Annotation label;
    private final Registry registry;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class Registry extends LinkedHashMap<Class, Label> implements Iterable<Label> {
        private LabelMap elements;
        private Label text;

        public Registry(LabelMap labelMap) {
            this.elements = labelMap;
        }

        private void registerElement(Class cls, Label label) {
            String name = label.getName();
            if (!this.elements.containsKey(name)) {
                this.elements.put(name, label);
            }
            if (containsKey(cls)) {
                return;
            }
            put(cls, label);
        }

        private void registerText(Label label) {
            Text text = (Text) label.getContact().getAnnotation(Text.class);
            if (text != null) {
                this.text = new TextListLabel(label, text);
            }
        }

        private Label resolveElement(Class cls) {
            while (cls != null) {
                Label label = get(cls);
                if (label != null) {
                    return label;
                }
                cls = cls.getSuperclass();
            }
            return null;
        }

        private Label resolveText(Class cls) {
            Label label = this.text;
            if (label == null || cls != String.class) {
                return null;
            }
            return label;
        }

        public boolean isText() {
            return this.text != null;
        }

        @Override // java.lang.Iterable
        public Iterator<Label> iterator() {
            return values().iterator();
        }

        public void register(Class cls, Label label) {
            CacheLabel cacheLabel = new CacheLabel(label);
            registerElement(cls, cacheLabel);
            registerText(cacheLabel);
        }

        public Label resolve(Class cls) {
            Label labelResolveText = resolveText(cls);
            return labelResolveText == null ? resolveElement(cls) : labelResolveText;
        }

        public Label resolveText() {
            return resolveText(String.class);
        }
    }

    public GroupExtractor(Contact contact, Annotation annotation, Format format) {
        this.factory = new ExtractorFactory(contact, annotation, format);
        LabelMap labelMap = new LabelMap();
        this.elements = labelMap;
        this.registry = new Registry(labelMap);
        this.label = annotation;
        extract();
    }

    private void extract() {
        Extractor extractorFactory = this.factory.getInstance();
        if (extractorFactory != null) {
            extract(extractorFactory);
        }
    }

    private void extract(Extractor extractor) {
        for (Annotation annotation : extractor.getAnnotations()) {
            extract(extractor, annotation);
        }
    }

    private void extract(Extractor extractor, Annotation annotation) {
        Label label = extractor.getLabel(annotation);
        Class type = extractor.getType(annotation);
        Registry registry = this.registry;
        if (registry != null) {
            registry.register(type, label);
        }
    }

    @Override // org.simpleframework.xml.core.Group
    public LabelMap getElements() {
        return this.elements.getLabels();
    }

    @Override // org.simpleframework.xml.core.Group
    public Label getLabel(Class cls) {
        return this.registry.resolve(cls);
    }

    public String[] getNames() {
        return this.elements.getKeys();
    }

    public String[] getPaths() {
        return this.elements.getPaths();
    }

    @Override // org.simpleframework.xml.core.Group
    public Label getText() {
        return this.registry.resolveText();
    }

    public boolean isDeclared(Class cls) {
        return this.registry.containsKey(cls);
    }

    @Override // org.simpleframework.xml.core.Group
    public boolean isInline() {
        Iterator<Label> it = this.registry.iterator();
        while (it.hasNext()) {
            if (!it.next().isInline()) {
                return false;
            }
        }
        return !this.registry.isEmpty();
    }

    @Override // org.simpleframework.xml.core.Group
    public boolean isTextList() {
        return this.registry.isText();
    }

    public boolean isValid(Class cls) {
        return this.registry.resolve(cls) != null;
    }

    @Override // org.simpleframework.xml.core.Group
    public String toString() {
        return this.label.toString();
    }
}
