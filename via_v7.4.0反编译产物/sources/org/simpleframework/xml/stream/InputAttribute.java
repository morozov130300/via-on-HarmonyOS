package org.simpleframework.xml.stream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class InputAttribute implements InputNode {
    private String name;
    private InputNode parent;
    private String prefix;
    private String reference;
    private Object source;
    private String value;

    public InputAttribute(InputNode inputNode, String str, String str2) {
        this.parent = inputNode;
        this.value = str2;
        this.name = str;
    }

    public InputAttribute(InputNode inputNode, Attribute attribute) {
        this.reference = attribute.getReference();
        this.prefix = attribute.getPrefix();
        this.source = attribute.getSource();
        this.value = attribute.getValue();
        this.name = attribute.getName();
        this.parent = inputNode;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getAttribute(String str) {
        return null;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public NodeMap<InputNode> getAttributes() {
        return new InputNodeMap(this);
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getName() {
        return this.name;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getNext() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getNext(String str) {
        return null;
    }

    @Override // org.simpleframework.xml.stream.Node
    public InputNode getParent() {
        return this.parent;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public Position getPosition() {
        return this.parent.getPosition();
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public String getReference() {
        return this.reference;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public Object getSource() {
        return this.source;
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getValue() {
        return this.value;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isElement() {
        return false;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isEmpty() {
        return false;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isRoot() {
        return false;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public void skip() {
    }

    public String toString() {
        return String.format("attribute %s='%s'", this.name, this.value);
    }
}
