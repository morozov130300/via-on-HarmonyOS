package org.simpleframework.xml.stream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface OutputNode extends Node {
    void commit();

    NodeMap<OutputNode> getAttributes();

    OutputNode getChild(String str);

    String getComment();

    Mode getMode();

    NamespaceMap getNamespaces();

    @Override // org.simpleframework.xml.stream.Node
    OutputNode getParent();

    String getPrefix();

    String getPrefix(boolean z10);

    String getReference();

    boolean isCommitted();

    boolean isRoot();

    void remove();

    OutputNode setAttribute(String str, String str2);

    void setComment(String str);

    void setData(boolean z10);

    void setMode(Mode mode);

    void setName(String str);

    void setReference(String str);

    void setValue(String str);
}
