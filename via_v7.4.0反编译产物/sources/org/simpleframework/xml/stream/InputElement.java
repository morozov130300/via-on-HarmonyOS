package org.simpleframework.xml.stream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class InputElement implements InputNode {
    private final InputNodeMap map;
    private final EventNode node;
    private final InputNode parent;
    private final NodeReader reader;

    public InputElement(InputNode inputNode, NodeReader nodeReader, EventNode eventNode) {
        this.map = new InputNodeMap(this, eventNode);
        this.reader = nodeReader;
        this.parent = inputNode;
        this.node = eventNode;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getAttribute(String str) {
        return this.map.get(str);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public NodeMap<InputNode> getAttributes() {
        return this.map;
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getName() {
        return this.node.getName();
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getNext() {
        return this.reader.readElement(this);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getNext(String str) {
        return this.reader.readElement(this, str);
    }

    @Override // org.simpleframework.xml.stream.Node
    public InputNode getParent() {
        return this.parent;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public Position getPosition() {
        return new InputPosition(this.node);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public String getPrefix() {
        return this.node.getPrefix();
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public String getReference() {
        return this.node.getReference();
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public Object getSource() {
        return this.node.getSource();
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getValue() {
        return this.reader.readValue(this);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isElement() {
        return true;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isEmpty() {
        if (this.map.isEmpty()) {
            return this.reader.isEmpty(this);
        }
        return false;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isRoot() {
        return this.reader.isRoot(this);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public void skip() {
        this.reader.skipElement(this);
    }

    public String toString() {
        return String.format("element %s", getName());
    }
}
