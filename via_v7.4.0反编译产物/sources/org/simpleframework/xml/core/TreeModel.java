package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class TreeModel implements Model {
    private LabelMap attributes;
    private Detail detail;
    private LabelMap elements;
    private Expression expression;
    private int index;
    private Label list;
    private ModelMap models;
    private String name;
    private OrderList order;
    private Policy policy;
    private String prefix;
    private Label text;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class OrderList extends ArrayList<String> {
    }

    public TreeModel(Policy policy, Detail detail) {
        this(policy, detail, null, null, 1);
    }

    public TreeModel(Policy policy, Detail detail, String str, String str2, int i10) {
        this.attributes = new LabelMap(policy);
        this.elements = new LabelMap(policy);
        this.models = new ModelMap(detail);
        this.order = new OrderList();
        this.detail = detail;
        this.policy = policy;
        this.prefix = str2;
        this.index = i10;
        this.name = str;
    }

    private Model create(String str, String str2, int i10) {
        TreeModel treeModel = new TreeModel(this.policy, this.detail, str, str2, i10);
        if (str != null) {
            this.models.register(str, treeModel);
            this.order.add(str);
        }
        return treeModel;
    }

    private void validateAttributes(Class cls) throws AttributeException {
        for (String str : this.attributes.keySet()) {
            if (this.attributes.get(str) == null) {
                throw new AttributeException("Ordered attribute '%s' does not exist in %s", str, cls);
            }
            Expression expression = this.expression;
            if (expression != null) {
                expression.getAttribute(str);
            }
        }
    }

    private void validateElements(Class cls) throws ElementException {
        for (String str : this.elements.keySet()) {
            ModelList modelList = this.models.get(str);
            Label label = this.elements.get(str);
            if (modelList == null && label == null) {
                throw new ElementException("Ordered element '%s' does not exist in %s", str, cls);
            }
            if (modelList != null && label != null && !modelList.isEmpty()) {
                throw new ElementException("Element '%s' is also a path name in %s", str, cls);
            }
            Expression expression = this.expression;
            if (expression != null) {
                expression.getElement(str);
            }
        }
    }

    private void validateExpression(Label label) throws PathException {
        Expression expression = label.getExpression();
        Expression expression2 = this.expression;
        if (expression2 == null) {
            this.expression = expression;
            return;
        }
        String path = expression2.getPath();
        String path2 = expression.getPath();
        if (!path.equals(path2)) {
            throw new PathException("Path '%s' does not match '%s' in %s", path, path2, this.detail);
        }
    }

    private void validateExpressions(Class cls) throws PathException {
        Iterator<Label> it = this.elements.iterator();
        while (it.hasNext()) {
            Label next = it.next();
            if (next != null) {
                validateExpression(next);
            }
        }
        Iterator<Label> it2 = this.attributes.iterator();
        while (it2.hasNext()) {
            Label next2 = it2.next();
            if (next2 != null) {
                validateExpression(next2);
            }
        }
        Label label = this.text;
        if (label != null) {
            validateExpression(label);
        }
    }

    private void validateModels(Class cls) throws ElementException {
        Iterator<ModelList> it = this.models.iterator();
        while (it.hasNext()) {
            Iterator<Model> it2 = it.next().iterator();
            int i10 = 1;
            while (it2.hasNext()) {
                Model next = it2.next();
                if (next != null) {
                    String name = next.getName();
                    int index = next.getIndex();
                    int i11 = i10 + 1;
                    if (index != i10) {
                        throw new ElementException("Path section '%s[%s]' is out of sequence in %s", name, Integer.valueOf(index), cls);
                    }
                    next.validate(cls);
                    i10 = i11;
                }
            }
        }
    }

    private void validateText(Class cls) throws TextException {
        if (this.text != null) {
            if (!this.elements.isEmpty()) {
                throw new TextException("Text annotation %s used with elements in %s", this.text, cls);
            }
            if (isComposite()) {
                throw new TextException("Text annotation %s can not be used with paths in %s", this.text, cls);
            }
        }
    }

    @Override // org.simpleframework.xml.core.Model
    public LabelMap getAttributes() {
        return this.attributes.getLabels();
    }

    @Override // org.simpleframework.xml.core.Model
    public LabelMap getElements() {
        return this.elements.getLabels();
    }

    @Override // org.simpleframework.xml.core.Model
    public Expression getExpression() {
        return this.expression;
    }

    @Override // org.simpleframework.xml.core.Model
    public int getIndex() {
        return this.index;
    }

    @Override // org.simpleframework.xml.core.Model
    public ModelMap getModels() {
        return this.models.getModels();
    }

    @Override // org.simpleframework.xml.core.Model
    public String getName() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Model
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.simpleframework.xml.core.Model
    public Label getText() {
        Label label = this.list;
        return label != null ? label : this.text;
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isAttribute(String str) {
        return this.attributes.containsKey(str);
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isComposite() {
        Iterator<ModelList> it = this.models.iterator();
        while (it.hasNext()) {
            Iterator<Model> it2 = it.next().iterator();
            while (it2.hasNext()) {
                Model next = it2.next();
                if (next != null && !next.isEmpty()) {
                    return true;
                }
            }
        }
        return !this.models.isEmpty();
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isElement(String str) {
        return this.elements.containsKey(str);
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isEmpty() {
        if (this.text == null && this.elements.isEmpty() && this.attributes.isEmpty()) {
            return !isComposite();
        }
        return false;
    }

    @Override // org.simpleframework.xml.core.Model
    public boolean isModel(String str) {
        return this.models.containsKey(str);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.order.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList.iterator();
    }

    @Override // org.simpleframework.xml.core.Model
    public Model lookup(String str, int i10) {
        return this.models.lookup(str, i10);
    }

    @Override // org.simpleframework.xml.core.Model
    public Model lookup(Expression expression) {
        Model modelLookup = lookup(expression.getFirst(), expression.getIndex());
        if (expression.isPath()) {
            Expression path = expression.getPath(1, 0);
            if (modelLookup != null) {
                return modelLookup.lookup(path);
            }
        }
        return modelLookup;
    }

    @Override // org.simpleframework.xml.core.Model
    public Model register(String str, String str2, int i10) {
        Model modelLookup = this.models.lookup(str, i10);
        return modelLookup == null ? create(str, str2, i10) : modelLookup;
    }

    @Override // org.simpleframework.xml.core.Model
    public void register(Label label) throws ElementException, AttributeException, TextException {
        if (label.isAttribute()) {
            registerAttribute(label);
        } else if (label.isText()) {
            registerText(label);
        } else {
            registerElement(label);
        }
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerAttribute(String str) {
        this.attributes.put(str, null);
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerAttribute(Label label) throws AttributeException {
        String name = label.getName();
        if (this.attributes.get(name) != null) {
            throw new AttributeException("Duplicate annotation of name '%s' on %s", name, label);
        }
        this.attributes.put(name, label);
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerElement(String str) {
        if (!this.order.contains(str)) {
            this.order.add(str);
        }
        this.elements.put(str, null);
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerElement(Label label) throws ElementException {
        String name = label.getName();
        if (this.elements.get(name) != null) {
            throw new ElementException("Duplicate annotation of name '%s' on %s", name, label);
        }
        if (!this.order.contains(name)) {
            this.order.add(name);
        }
        if (label.isTextList()) {
            this.list = label;
        }
        this.elements.put(name, label);
    }

    @Override // org.simpleframework.xml.core.Model
    public void registerText(Label label) throws TextException {
        if (this.text != null) {
            throw new TextException("Duplicate text annotation on %s", label);
        }
        this.text = label;
    }

    public String toString() {
        return String.format("model '%s[%s]'", this.name, Integer.valueOf(this.index));
    }

    @Override // org.simpleframework.xml.core.Model
    public void validate(Class cls) throws ElementException, PathException, AttributeException, TextException {
        validateExpressions(cls);
        validateAttributes(cls);
        validateElements(cls);
        validateModels(cls);
        validateText(cls);
    }
}
