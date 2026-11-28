package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class StructureBuilder {
    private ModelAssembler assembler;
    private LabelMap attributes;
    private ExpressionBuilder builder;
    private LabelMap elements;
    private Instantiator factory;
    private boolean primitive;
    private InstantiatorBuilder resolver;
    private Model root;
    private Scanner scanner;
    private Support support;
    private Label text;
    private LabelMap texts;
    private Label version;

    public StructureBuilder(Scanner scanner, Detail detail, Support support) {
        ExpressionBuilder expressionBuilder = new ExpressionBuilder(detail, support);
        this.builder = expressionBuilder;
        this.assembler = new ModelAssembler(expressionBuilder, detail, support);
        this.resolver = new InstantiatorBuilder(scanner, detail);
        this.root = new TreeModel(scanner, detail);
        this.attributes = new LabelMap(scanner);
        this.elements = new LabelMap(scanner);
        this.texts = new LabelMap(scanner);
        this.scanner = scanner;
        this.support = support;
    }

    private Model create(Expression expression) {
        Model modelRegister = this.root;
        while (modelRegister != null) {
            String prefix = expression.getPrefix();
            String first = expression.getFirst();
            int index = expression.getIndex();
            if (first != null) {
                modelRegister = modelRegister.register(first, prefix, index);
            }
            if (!expression.isPath()) {
                return modelRegister;
            }
            expression = expression.getPath(1);
        }
        return modelRegister;
    }

    private boolean isAttribute(String str) {
        Expression expressionBuild = this.builder.build(str);
        Model modelLookup = lookup(expressionBuild);
        if (modelLookup != null) {
            return !expressionBuild.isPath() ? modelLookup.isAttribute(str) : modelLookup.isAttribute(expressionBuild.getLast());
        }
        return false;
    }

    private boolean isElement(String str) {
        Expression expressionBuild = this.builder.build(str);
        Model modelLookup = lookup(expressionBuild);
        if (modelLookup != null) {
            String last = expressionBuild.getLast();
            int index = expressionBuild.getIndex();
            if (modelLookup.isElement(last)) {
                return true;
            }
            return modelLookup.isModel(last) && !modelLookup.lookup(last, index).isEmpty();
        }
        return false;
    }

    private boolean isEmpty() {
        if (this.text != null) {
            return false;
        }
        return this.root.isEmpty();
    }

    private Model lookup(Expression expression) {
        return expression.isPath() ? this.root.lookup(expression.getPath(0, 1)) : this.root;
    }

    private Model register(Expression expression) {
        Model modelLookup = this.root.lookup(expression);
        return modelLookup != null ? modelLookup : create(expression);
    }

    private void text(Contact contact, Annotation annotation) throws TextException {
        Label label = this.support.getLabel(contact, annotation);
        Expression expression = label.getExpression();
        String path = label.getPath();
        Model modelRegister = this.root;
        if (!expression.isEmpty()) {
            modelRegister = register(expression);
        }
        if (this.texts.get(path) != null) {
            throw new TextException("Multiple text annotations in %s", annotation);
        }
        this.resolver.register(label);
        modelRegister.register(label);
        this.texts.put(path, label);
    }

    private void union(Contact contact, Annotation annotation, LabelMap labelMap) throws PersistenceException {
        for (Label label : this.support.getLabels(contact, annotation)) {
            String path = label.getPath();
            String name = label.getName();
            if (labelMap.get(path) != null) {
                throw new PersistenceException("Duplicate annotation of name '%s' on %s", name, label);
            }
            process(contact, label, labelMap);
        }
    }

    private void validateAttributes(Class cls, Order order) throws AttributeException {
        if (order != null) {
            for (String str : order.attributes()) {
                if (!isAttribute(str)) {
                    throw new AttributeException("Ordered attribute '%s' missing in %s", str, cls);
                }
            }
        }
    }

    private void validateElements(Class cls, Order order) throws ElementException {
        if (order != null) {
            for (String str : order.elements()) {
                if (!isElement(str)) {
                    throw new ElementException("Ordered element '%s' missing for %s", str, cls);
                }
            }
        }
    }

    private void validateModel(Class cls) {
        if (this.root.isEmpty()) {
            return;
        }
        this.root.validate(cls);
    }

    private void validateText(Class cls) throws TextException {
        Label text = this.root.getText();
        if (text == null) {
            if (this.scanner.isEmpty()) {
                this.primitive = isEmpty();
            }
        } else {
            if (text.isTextList()) {
                return;
            }
            if (!this.elements.isEmpty()) {
                throw new TextException("Elements used with %s in %s", text, cls);
            }
            if (this.root.isComposite()) {
                throw new TextException("Paths used with %s in %s", text, cls);
            }
        }
    }

    private void validateTextList(Class cls) throws TextException {
        Label text = this.root.getText();
        if (text == null || !text.isTextList()) {
            return;
        }
        Object key = text.getKey();
        for (Label label : this.elements) {
            if (!label.getKey().equals(key)) {
                throw new TextException("Elements used with %s in %s", text, cls);
            }
            Class type = label.getDependent().getType();
            if (type == String.class) {
                throw new TextException("Illegal entry of %s with text annotations on %s in %s", type, text, cls);
            }
        }
        if (this.root.isComposite()) {
            throw new TextException("Paths used with %s in %s", text, cls);
        }
    }

    private void validateUnions(Class cls) throws UnionException {
        for (Label label : this.elements) {
            String[] paths = label.getPaths();
            Contact contact = label.getContact();
            for (String str : paths) {
                Annotation annotation = contact.getAnnotation();
                Label label2 = this.elements.get(str);
                if (label.isInline() != label2.isInline()) {
                    throw new UnionException("Inline must be consistent in %s for %s", annotation, contact);
                }
                if (label.isRequired() != label2.isRequired()) {
                    throw new UnionException("Required must be consistent in %s for %s", annotation, contact);
                }
            }
        }
    }

    private void version(Contact contact, Annotation annotation) throws AttributeException {
        Label label = this.support.getLabel(contact, annotation);
        if (this.version != null) {
            throw new AttributeException("Multiple version annotations in %s", annotation);
        }
        this.version = label;
    }

    public void assemble(Class cls) {
        Order order = this.scanner.getOrder();
        if (order != null) {
            this.assembler.assemble(this.root, order);
        }
    }

    public Structure build(Class cls) {
        return new Structure(this.factory, this.root, this.version, this.text, this.primitive);
    }

    public void commit(Class cls) {
        if (this.factory == null) {
            this.factory = this.resolver.build();
        }
    }

    public void process(Contact contact, Annotation annotation) {
        if (annotation instanceof Attribute) {
            process(contact, annotation, this.attributes);
        }
        if (annotation instanceof ElementUnion) {
            union(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementListUnion) {
            union(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementMapUnion) {
            union(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementList) {
            process(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementArray) {
            process(contact, annotation, this.elements);
        }
        if (annotation instanceof ElementMap) {
            process(contact, annotation, this.elements);
        }
        if (annotation instanceof Element) {
            process(contact, annotation, this.elements);
        }
        if (annotation instanceof Version) {
            version(contact, annotation);
        }
        if (annotation instanceof Text) {
            text(contact, annotation);
        }
    }

    public void validate(Class cls) {
        Order order = this.scanner.getOrder();
        validateUnions(cls);
        validateElements(cls, order);
        validateAttributes(cls, order);
        validateModel(cls);
        validateText(cls);
        validateTextList(cls);
    }

    private void process(Contact contact, Annotation annotation, LabelMap labelMap) throws PersistenceException {
        Label label = this.support.getLabel(contact, annotation);
        String path = label.getPath();
        String name = label.getName();
        if (labelMap.get(path) == null) {
            process(contact, label, labelMap);
            return;
        }
        throw new PersistenceException("Duplicate annotation of name '%s' on %s", name, contact);
    }

    private void process(Contact contact, Label label, LabelMap labelMap) {
        Expression expression = label.getExpression();
        String path = label.getPath();
        Model modelRegister = this.root;
        if (!expression.isEmpty()) {
            modelRegister = register(expression);
        }
        this.resolver.register(label);
        modelRegister.register(label);
        labelMap.put(path, label);
    }
}
