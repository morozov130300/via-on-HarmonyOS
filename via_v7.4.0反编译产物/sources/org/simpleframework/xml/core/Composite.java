package org.simpleframework.xml.core;

import java.util.Iterator;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class Composite implements Converter {
    private final Context context;
    private final Criteria criteria;
    private final ObjectFactory factory;
    private final Primitive primitive;
    private final Revision revision;
    private final Type type;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class Builder {
        protected final Composite composite;
        protected final Criteria criteria;
        protected final Schema schema;
        protected final Instance value;

        public Builder(Composite composite, Criteria criteria, Schema schema, Instance instance) {
            this.composite = composite;
            this.criteria = criteria;
            this.schema = schema;
            this.value = instance;
        }

        public Object read(InputNode inputNode) throws ElementException, AttributeException, ValueRequiredException {
            Object instance = this.value.getInstance();
            Section section = this.schema.getSection();
            this.value.setInstance(instance);
            this.composite.readVersion(inputNode, instance, this.schema);
            this.composite.readText(inputNode, instance, section);
            this.composite.readAttributes(inputNode, instance, section);
            this.composite.readElements(inputNode, instance, section);
            this.criteria.commit(instance);
            return instance;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class Injector extends Builder {
        private Injector(Composite composite, Criteria criteria, Schema schema, Instance instance) {
            super(composite, criteria, schema, instance);
        }

        private Object readInject(InputNode inputNode) {
            Object instantiator = this.schema.getInstantiator().getInstance(this.criteria);
            this.value.setInstance(instantiator);
            this.criteria.commit(instantiator);
            return instantiator;
        }

        @Override // org.simpleframework.xml.core.Composite.Builder
        public Object read(InputNode inputNode) throws ElementException, AttributeException, ValueRequiredException {
            Section section = this.schema.getSection();
            this.composite.readVersion(inputNode, (Object) null, this.schema);
            this.composite.readText(inputNode, null, section);
            this.composite.readAttributes(inputNode, null, section);
            this.composite.readElements(inputNode, null, section);
            return readInject(inputNode);
        }
    }

    public Composite(Context context, Type type) {
        this(context, type, null);
    }

    public Composite(Context context, Type type, Class cls) {
        this.factory = new ObjectFactory(context, type, cls);
        this.primitive = new Primitive(context, type);
        this.criteria = new Collector();
        this.revision = new Revision();
        this.context = context;
        this.type = type;
    }

    private boolean isOverridden(OutputNode outputNode, Object obj, Type type) {
        return this.factory.setOverride(type, obj, outputNode);
    }

    private Object read(InputNode inputNode, Instance instance, Class cls) throws ElementException, AttributeException, ValueRequiredException {
        Schema schema = this.context.getSchema(cls);
        Caller caller = schema.getCaller();
        Object obj = read(schema, instance).read(inputNode);
        caller.validate(obj);
        caller.commit(obj);
        instance.setInstance(obj);
        return readResolve(inputNode, obj, caller);
    }

    private Builder read(Schema schema, Instance instance) {
        return schema.getInstantiator().isDefault() ? new Builder(this, this.criteria, schema, instance) : new Injector(this, this.criteria, schema, instance);
    }

    private void read(InputNode inputNode, Object obj, Schema schema) throws AttributeException, ValueRequiredException {
        Section section = schema.getSection();
        readVersion(inputNode, obj, schema);
        readSection(inputNode, obj, section);
    }

    private void readAttribute(InputNode inputNode, Object obj, Section section, LabelMap labelMap) throws AttributeException, ValueRequiredException {
        String attribute = section.getAttribute(inputNode.getName());
        Label label = labelMap.getLabel(attribute);
        if (label != null) {
            readInstance(inputNode, obj, label);
            return;
        }
        Position position = inputNode.getPosition();
        Class type = this.context.getType(this.type, obj);
        if (labelMap.isStrict(this.context) && this.revision.isEqual()) {
            throw new AttributeException("Attribute '%s' does not have a match in %s at %s", attribute, type, position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readAttributes(InputNode inputNode, Object obj, Section section) throws AttributeException, ValueRequiredException {
        NodeMap<InputNode> attributes = inputNode.getAttributes();
        LabelMap attributes2 = section.getAttributes();
        Iterator<String> it = attributes.iterator();
        while (it.hasNext()) {
            InputNode attribute = inputNode.getAttribute(it.next());
            if (attribute != null) {
                readAttribute(attribute, obj, section, attributes2);
            }
        }
        validate(inputNode, attributes2, obj);
    }

    private void readElement(InputNode inputNode, Object obj, Section section, LabelMap labelMap) throws ElementException, ValueRequiredException {
        String path = section.getPath(inputNode.getName());
        Label label = labelMap.getLabel(path);
        if (label == null) {
            label = this.criteria.resolve(path);
        }
        if (label != null) {
            readUnion(inputNode, obj, labelMap, label);
            return;
        }
        Position position = inputNode.getPosition();
        Class type = this.context.getType(this.type, obj);
        if (labelMap.isStrict(this.context) && this.revision.isEqual()) {
            throw new ElementException("Element '%s' does not have a match in %s at %s", path, type, position);
        }
        inputNode.skip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readElements(InputNode inputNode, Object obj, Section section) throws ElementException, AttributeException, ValueRequiredException {
        LabelMap elements = section.getElements();
        InputNode next = inputNode.getNext();
        while (next != null) {
            Section section2 = section.getSection(next.getName());
            if (section2 != null) {
                readSection(next, obj, section2);
            } else {
                readElement(next, obj, section, elements);
            }
            next = inputNode.getNext();
        }
        validate(inputNode, elements, obj);
    }

    private Object readInstance(InputNode inputNode, Object obj, Label label) throws ValueRequiredException {
        Object variable = readVariable(inputNode, obj, label);
        if (variable == null) {
            Position position = inputNode.getPosition();
            Class type = this.context.getType(this.type, obj);
            if (label.isRequired() && this.revision.isEqual()) {
                throw new ValueRequiredException("Empty value for %s in %s at %s", label, type, position);
            }
        } else if (variable != label.getEmpty(this.context)) {
            this.criteria.set(label, variable);
        }
        return variable;
    }

    private Object readPrimitive(InputNode inputNode, Instance instance) {
        Class type = instance.getType();
        Object obj = this.primitive.read(inputNode, type);
        if (type != null) {
            instance.setInstance(obj);
        }
        return obj;
    }

    private Object readResolve(InputNode inputNode, Object obj, Caller caller) throws ElementException {
        if (obj == null) {
            return obj;
        }
        Position position = inputNode.getPosition();
        Object objResolve = caller.resolve(obj);
        Class type = this.type.getType();
        Class<?> cls = objResolve.getClass();
        if (type.isAssignableFrom(cls)) {
            return objResolve;
        }
        throw new ElementException("Type %s does not match %s at %s", cls, type, position);
    }

    private void readSection(InputNode inputNode, Object obj, Section section) throws AttributeException, ValueRequiredException {
        readText(inputNode, obj, section);
        readAttributes(inputNode, obj, section);
        readElements(inputNode, obj, section);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readText(InputNode inputNode, Object obj, Section section) throws ValueRequiredException {
        Label text = section.getText();
        if (text != null) {
            readInstance(inputNode, obj, text);
        }
    }

    private void readUnion(InputNode inputNode, Object obj, LabelMap labelMap, Label label) throws ValueRequiredException {
        Object instance = readInstance(inputNode, obj, label);
        for (String str : label.getPaths()) {
            labelMap.getLabel(str);
        }
        if (label.isInline()) {
            this.criteria.set(label, instance);
        }
    }

    private Object readVariable(InputNode inputNode, Object obj, Label label) {
        Object obj2;
        Converter converter = label.getConverter(this.context);
        if (label.isCollection()) {
            Variable variable = this.criteria.get(label);
            Contact contact = label.getContact();
            if (variable != null) {
                return converter.read(inputNode, variable.getValue());
            }
            if (obj != null && (obj2 = contact.get(obj)) != null) {
                return converter.read(inputNode, obj2);
            }
        }
        return converter.read(inputNode);
    }

    private void readVersion(InputNode inputNode, Object obj, Label label) throws ValueRequiredException {
        Object instance = readInstance(inputNode, obj, label);
        Class type = this.type.getType();
        if (instance != null) {
            Double dValueOf = Double.valueOf(this.context.getVersion(type).revision());
            if (instance.equals(this.revision)) {
                return;
            }
            this.revision.compare(dValueOf, instance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readVersion(InputNode inputNode, Object obj, Schema schema) throws ValueRequiredException {
        Label version = schema.getVersion();
        Class type = this.type.getType();
        if (version != null) {
            InputNode inputNode2 = (InputNode) inputNode.getAttributes().remove(version.getName());
            if (inputNode2 != null) {
                readVersion(inputNode2, obj, version);
                return;
            }
            Version version2 = this.context.getVersion(type);
            Double dValueOf = Double.valueOf(this.revision.getDefault());
            Double dValueOf2 = Double.valueOf(version2.revision());
            this.criteria.set(version, dValueOf);
            this.revision.compare(dValueOf2, dValueOf);
        }
    }

    private void validate(InputNode inputNode, Label label) throws PersistenceException {
        Converter converter = label.getConverter(this.context);
        Position position = inputNode.getPosition();
        Class type = this.type.getType();
        if (!converter.validate(inputNode)) {
            throw new PersistenceException("Invalid value for %s in %s at %s", label, type, position);
        }
        this.criteria.set(label, null);
    }

    private void validate(InputNode inputNode, LabelMap labelMap) throws ValueRequiredException {
        Position position = inputNode.getPosition();
        Iterator<Label> it = labelMap.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            Class type = this.type.getType();
            if (next.isRequired() && this.revision.isEqual()) {
                throw new ValueRequiredException("Unable to satisfy %s for %s at %s", next, type, position);
            }
        }
    }

    private void validate(InputNode inputNode, LabelMap labelMap, Object obj) throws ValueRequiredException {
        Class type = this.context.getType(this.type, obj);
        Position position = inputNode.getPosition();
        Iterator<Label> it = labelMap.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next.isRequired() && this.revision.isEqual()) {
                throw new ValueRequiredException("Unable to satisfy %s for %s at %s", next, type, position);
            }
            Object empty = next.getEmpty(this.context);
            if (empty != null) {
                this.criteria.set(next, empty);
            }
        }
    }

    private boolean validate(InputNode inputNode, Class cls) throws PersistenceException {
        Schema schema = this.context.getSchema(cls);
        Section section = schema.getSection();
        validateText(inputNode, schema);
        validateSection(inputNode, section);
        return inputNode.isElement();
    }

    private void validateAttribute(InputNode inputNode, Section section, LabelMap labelMap) throws PersistenceException {
        Position position = inputNode.getPosition();
        String attribute = section.getAttribute(inputNode.getName());
        Label label = labelMap.getLabel(attribute);
        if (label != null) {
            validate(inputNode, label);
            return;
        }
        Class type = this.type.getType();
        if (labelMap.isStrict(this.context) && this.revision.isEqual()) {
            throw new AttributeException("Attribute '%s' does not exist for %s at %s", attribute, type, position);
        }
    }

    private void validateAttributes(InputNode inputNode, Section section) throws PersistenceException {
        NodeMap<InputNode> attributes = inputNode.getAttributes();
        LabelMap attributes2 = section.getAttributes();
        Iterator<String> it = attributes.iterator();
        while (it.hasNext()) {
            InputNode attribute = inputNode.getAttribute(it.next());
            if (attribute != null) {
                validateAttribute(attribute, section, attributes2);
            }
        }
        validate(inputNode, attributes2);
    }

    private void validateElement(InputNode inputNode, Section section, LabelMap labelMap) throws PersistenceException {
        String path = section.getPath(inputNode.getName());
        Label label = labelMap.getLabel(path);
        if (label == null) {
            label = this.criteria.resolve(path);
        }
        if (label != null) {
            validateUnion(inputNode, labelMap, label);
            return;
        }
        Position position = inputNode.getPosition();
        Class type = this.type.getType();
        if (labelMap.isStrict(this.context) && this.revision.isEqual()) {
            throw new ElementException("Element '%s' does not exist for %s at %s", path, type, position);
        }
        inputNode.skip();
    }

    private void validateElements(InputNode inputNode, Section section) throws PersistenceException {
        LabelMap elements = section.getElements();
        InputNode next = inputNode.getNext();
        while (next != null) {
            Section section2 = section.getSection(next.getName());
            if (section2 != null) {
                validateSection(next, section2);
            } else {
                validateElement(next, section, elements);
            }
            next = inputNode.getNext();
        }
        validate(inputNode, elements);
    }

    private void validateSection(InputNode inputNode, Section section) throws PersistenceException {
        validateAttributes(inputNode, section);
        validateElements(inputNode, section);
    }

    private void validateText(InputNode inputNode, Schema schema) throws PersistenceException {
        Label text = schema.getText();
        if (text != null) {
            validate(inputNode, text);
        }
    }

    private void validateUnion(InputNode inputNode, LabelMap labelMap, Label label) throws PersistenceException {
        for (String str : label.getPaths()) {
            labelMap.getLabel(str);
        }
        if (label.isInline()) {
            this.criteria.set(label, null);
        }
        validate(inputNode, label);
    }

    private void write(OutputNode outputNode, Object obj, Schema schema) throws ElementException, AttributeException, TextException {
        Section section = schema.getSection();
        writeVersion(outputNode, obj, schema);
        writeSection(outputNode, obj, section);
    }

    private void writeAttribute(OutputNode outputNode, Object obj, Label label) {
        if (obj != null) {
            label.getDecorator().decorate(outputNode.setAttribute(label.getName(), this.factory.getText(obj)));
        }
    }

    private void writeAttributes(OutputNode outputNode, Object obj, Section section) throws AttributeException {
        Iterator<Label> it = section.getAttributes().iterator();
        while (it.hasNext()) {
            Label next = it.next();
            Object empty = next.getContact().get(obj);
            Class type = this.context.getType(this.type, obj);
            if (empty == null) {
                empty = next.getEmpty(this.context);
            }
            if (empty == null && next.isRequired()) {
                throw new AttributeException("Value for %s is null in %s", next, type);
            }
            writeAttribute(outputNode, empty, next);
        }
    }

    private void writeElement(OutputNode outputNode, Object obj, Converter converter) {
        converter.write(outputNode, obj);
    }

    private void writeElement(OutputNode outputNode, Object obj, Label label) {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Label label2 = label.getLabel(cls);
            String name = label2.getName();
            Type type = label.getType(cls);
            OutputNode child = outputNode.getChild(name);
            if (!label2.isInline()) {
                writeNamespaces(child, type, label2);
            }
            if (label2.isInline() || !isOverridden(child, obj, type)) {
                Converter converter = label2.getConverter(this.context);
                child.setData(label2.isData());
                writeElement(child, obj, converter);
            }
        }
    }

    private void writeElements(OutputNode outputNode, Object obj, Section section) throws ElementException, AttributeException {
        for (String str : section) {
            Section section2 = section.getSection(str);
            if (section2 != null) {
                writeSection(outputNode.getChild(str), obj, section2);
            } else {
                Label element = section.getElement(section.getPath(str));
                Class type = this.context.getType(this.type, obj);
                if (this.criteria.get(element) != null) {
                    continue;
                } else {
                    if (element == null) {
                        throw new ElementException("Element '%s' not defined in %s", str, type);
                    }
                    writeUnion(outputNode, obj, section, element);
                }
            }
        }
    }

    private void writeNamespaces(OutputNode outputNode, Type type, Label label) {
        label.getDecorator().decorate(outputNode, this.context.getDecorator(type.getType()));
    }

    private Object writeReplace(Object obj) {
        if (obj == null) {
            return obj;
        }
        return this.context.getCaller(obj.getClass()).replace(obj);
    }

    private void writeSection(OutputNode outputNode, Object obj, Section section) throws ElementException, AttributeException, TextException {
        NamespaceMap namespaces = outputNode.getNamespaces();
        String prefix = section.getPrefix();
        if (prefix != null) {
            String reference = namespaces.getReference(prefix);
            if (reference == null) {
                throw new ElementException("Namespace prefix '%s' in %s is not in scope", prefix, this.type);
            }
            outputNode.setReference(reference);
        }
        writeAttributes(outputNode, obj, section);
        writeElements(outputNode, obj, section);
        writeText(outputNode, obj, section);
    }

    private void writeText(OutputNode outputNode, Object obj, Label label) {
        if (obj == null || label.isTextList()) {
            return;
        }
        String text = this.factory.getText(obj);
        outputNode.setData(label.isData());
        outputNode.setValue(text);
    }

    private void writeText(OutputNode outputNode, Object obj, Section section) throws TextException {
        Label text = section.getText();
        if (text != null) {
            Object empty = text.getContact().get(obj);
            Class type = this.context.getType(this.type, obj);
            if (empty == null) {
                empty = text.getEmpty(this.context);
            }
            if (empty == null && text.isRequired()) {
                throw new TextException("Value for %s is null in %s", text, type);
            }
            writeText(outputNode, empty, text);
        }
    }

    private void writeUnion(OutputNode outputNode, Object obj, Section section, Label label) throws ElementException {
        Object obj2 = label.getContact().get(obj);
        Class type = this.context.getType(this.type, obj);
        if (obj2 == null && label.isRequired()) {
            throw new ElementException("Value for %s is null in %s", label, type);
        }
        Object objWriteReplace = writeReplace(obj2);
        if (objWriteReplace != null) {
            writeElement(outputNode, objWriteReplace, label);
        }
        this.criteria.set(label, objWriteReplace);
    }

    private void writeVersion(OutputNode outputNode, Object obj, Schema schema) {
        Version revision = schema.getRevision();
        Label version = schema.getVersion();
        if (revision != null) {
            Double dValueOf = Double.valueOf(this.revision.getDefault());
            Double dValueOf2 = Double.valueOf(revision.revision());
            if (!this.revision.compare(dValueOf2, dValueOf)) {
                writeAttribute(outputNode, dValueOf2, version);
            } else if (version.isRequired()) {
                writeAttribute(outputNode, dValueOf2, version);
            }
        }
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode) {
        Instance objectFactory = this.factory.getInstance(inputNode);
        Class type = objectFactory.getType();
        return objectFactory.isReference() ? objectFactory.getInstance() : this.context.isPrimitive(type) ? readPrimitive(inputNode, objectFactory) : read(inputNode, objectFactory, type);
    }

    @Override // org.simpleframework.xml.core.Converter
    public Object read(InputNode inputNode, Object obj) throws AttributeException, ValueRequiredException {
        Schema schema = this.context.getSchema(obj.getClass());
        Caller caller = schema.getCaller();
        read(inputNode, obj, schema);
        this.criteria.commit(obj);
        caller.validate(obj);
        caller.commit(obj);
        return readResolve(inputNode, obj, caller);
    }

    @Override // org.simpleframework.xml.core.Converter
    public boolean validate(InputNode inputNode) {
        Instance objectFactory = this.factory.getInstance(inputNode);
        if (objectFactory.isReference()) {
            return true;
        }
        objectFactory.setInstance(null);
        return validate(inputNode, objectFactory.getType());
    }

    @Override // org.simpleframework.xml.core.Converter
    public void write(OutputNode outputNode, Object obj) {
        Schema schema = this.context.getSchema(obj.getClass());
        Caller caller = schema.getCaller();
        try {
            if (schema.isPrimitive()) {
                this.primitive.write(outputNode, obj);
            } else {
                caller.persist(obj);
                write(outputNode, obj, schema);
            }
            caller.complete(obj);
        } catch (Throwable th) {
            caller.complete(obj);
            throw th;
        }
    }
}
