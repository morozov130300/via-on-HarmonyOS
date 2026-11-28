package org.simpleframework.xml.core;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
interface Model extends Iterable<String> {
    LabelMap getAttributes();

    LabelMap getElements();

    Expression getExpression();

    int getIndex();

    ModelMap getModels();

    String getName();

    String getPrefix();

    Label getText();

    boolean isAttribute(String str);

    boolean isComposite();

    boolean isElement(String str);

    boolean isEmpty();

    boolean isModel(String str);

    Model lookup(String str, int i10);

    Model lookup(Expression expression);

    Model register(String str, String str2, int i10);

    void register(Label label);

    void registerAttribute(String str);

    void registerAttribute(Label label);

    void registerElement(String str);

    void registerElement(Label label);

    void registerText(Label label);

    void validate(Class cls);
}
