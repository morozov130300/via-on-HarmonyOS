package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class InstantiatorBuilder {
    private Detail detail;
    private Instantiator factory;
    private Scanner scanner;
    private List<Creator> options = new ArrayList();
    private Comparer comparer = new Comparer();
    private LabelMap attributes = new LabelMap();
    private LabelMap elements = new LabelMap();
    private LabelMap texts = new LabelMap();

    public InstantiatorBuilder(Scanner scanner, Detail detail) {
        this.scanner = scanner;
        this.detail = detail;
    }

    private Instantiator build(Detail detail) {
        if (this.factory == null) {
            this.factory = create(detail);
        }
        return this.factory;
    }

    private boolean contains(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2 == str || str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private Creator create(Signature signature) {
        SignatureCreator signatureCreator = new SignatureCreator(signature);
        if (signature != null) {
            this.options.add(signatureCreator);
        }
        return signatureCreator;
    }

    private Instantiator create(Detail detail) {
        Signature signature = this.scanner.getSignature();
        return new ClassInstantiator(this.options, signature != null ? new SignatureCreator(signature) : null, this.scanner.getParameters(), detail);
    }

    private Parameter create(Parameter parameter) {
        Label labelResolve = resolve(parameter);
        if (labelResolve != null) {
            return new CacheParameter(parameter, labelResolve);
        }
        return null;
    }

    private void populate(Detail detail) {
        Iterator<Signature> it = this.scanner.getSignatures().iterator();
        while (it.hasNext()) {
            populate(it.next());
        }
    }

    private void populate(Signature signature) {
        Signature signature2 = new Signature(signature);
        Iterator<Parameter> it = signature.iterator();
        while (it.hasNext()) {
            Parameter parameterCreate = create(it.next());
            if (parameterCreate != null) {
                signature2.add(parameterCreate);
            }
        }
        create(signature2);
    }

    private void register(Label label, LabelMap labelMap) {
        String name = label.getName();
        String path = label.getPath();
        if (!labelMap.containsKey(name)) {
            labelMap.put(name, label);
        } else if (!labelMap.get(name).getPath().equals(name)) {
            labelMap.remove(name);
        }
        labelMap.put(path, label);
    }

    private Label resolve(Parameter parameter) {
        return parameter.isAttribute() ? resolve(parameter, this.attributes) : parameter.isText() ? resolve(parameter, this.texts) : resolve(parameter, this.elements);
    }

    private Label resolve(Parameter parameter, LabelMap labelMap) {
        String name = parameter.getName();
        Label label = labelMap.get(parameter.getPath());
        return label == null ? labelMap.get(name) : label;
    }

    private void validate(Detail detail) throws ConstructorException {
        for (Parameter parameter : this.scanner.getParameters().getAll()) {
            Label labelResolve = resolve(parameter);
            String path = parameter.getPath();
            if (labelResolve == null) {
                throw new ConstructorException("Parameter '%s' does not have a match in %s", path, detail);
            }
            validateParameter(labelResolve, parameter);
        }
        validateConstructors();
    }

    private void validateAnnotations(Label label, Parameter parameter) throws ConstructorException {
        Annotation annotation = label.getAnnotation();
        Annotation annotation2 = parameter.getAnnotation();
        String name = parameter.getName();
        if (this.comparer.equals(annotation, annotation2)) {
            return;
        }
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Class<? extends Annotation> clsAnnotationType2 = annotation2.annotationType();
        if (!clsAnnotationType.equals(clsAnnotationType2)) {
            throw new ConstructorException("Annotation %s does not match %s for '%s' in %s", clsAnnotationType2, clsAnnotationType, name, parameter);
        }
    }

    private void validateConstructor(Label label, List<Creator> list) {
        Iterator<Creator> it = list.iterator();
        while (it.hasNext()) {
            Signature signature = it.next().getSignature();
            Contact contact = label.getContact();
            Object key = label.getKey();
            if (contact.isReadOnly() && signature.get(key) == null) {
                it.remove();
            }
        }
    }

    private void validateConstructors() throws ConstructorException {
        List<Creator> creators = this.factory.getCreators();
        if (this.factory.isDefault()) {
            validateConstructors(this.elements);
            validateConstructors(this.attributes);
        }
        if (creators.isEmpty()) {
            return;
        }
        validateConstructors(this.elements, creators);
        validateConstructors(this.attributes, creators);
    }

    private void validateConstructors(LabelMap labelMap) throws ConstructorException {
        Iterator<Label> it = labelMap.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next != null && next.getContact().isReadOnly()) {
                throw new ConstructorException("Default constructor can not accept read only %s in %s", next, this.detail);
            }
        }
    }

    private void validateConstructors(LabelMap labelMap, List<Creator> list) throws ConstructorException {
        Iterator<Label> it = labelMap.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next != null) {
                validateConstructor(next, list);
            }
        }
        if (list.isEmpty()) {
            throw new ConstructorException("No constructor accepts all read only values in %s", this.detail);
        }
    }

    private void validateNames(Label label, Parameter parameter) throws ConstructorException {
        String name;
        String[] names = label.getNames();
        String name2 = parameter.getName();
        if (contains(names, name2) || name2 == (name = label.getName())) {
            return;
        }
        if (name2 == null || name == null) {
            throw new ConstructorException("Annotation does not match %s for '%s' in %s", label, name2, parameter);
        }
        if (!name2.equals(name)) {
            throw new ConstructorException("Annotation does not match %s for '%s' in %s", label, name2, parameter);
        }
    }

    private void validateParameter(Label label, Parameter parameter) throws ConstructorException {
        Contact contact = label.getContact();
        String name = parameter.getName();
        if (!Support.isAssignable(parameter.getType(), contact.getType())) {
            throw new ConstructorException("Type is not compatible with %s for '%s' in %s", label, name, parameter);
        }
        validateNames(label, parameter);
        validateAnnotations(label, parameter);
    }

    public Instantiator build() throws ConstructorException {
        if (this.factory == null) {
            populate(this.detail);
            build(this.detail);
            validate(this.detail);
        }
        return this.factory;
    }

    public void register(Label label) {
        if (label.isAttribute()) {
            register(label, this.attributes);
        } else if (label.isText()) {
            register(label, this.texts);
        } else {
            register(label, this.elements);
        }
    }
}
