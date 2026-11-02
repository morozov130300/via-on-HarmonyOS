package org.simpleframework.xml.stream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class DocumentReader implements EventReader {
    private static final String RESERVED = "xml";
    private EventNode peek;
    private NodeExtractor queue;
    private NodeStack stack;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class End extends EventToken {
        private End() {
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public boolean isEnd() {
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class Entry extends EventAttribute {
        private final org.w3c.dom.Node node;

        public Entry(org.w3c.dom.Node node) {
            this.node = node;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getName() {
            return this.node.getLocalName();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getPrefix() {
            return this.node.getPrefix();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public String getReference() {
            return this.node.getNamespaceURI();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public Object getSource() {
            return this.node;
        }

        @Override // org.simpleframework.xml.stream.Attribute
        public String getValue() {
            return this.node.getNodeValue();
        }

        @Override // org.simpleframework.xml.stream.EventAttribute, org.simpleframework.xml.stream.Attribute
        public boolean isReserved() {
            String prefix = getPrefix();
            return prefix != null ? prefix.startsWith(DocumentReader.RESERVED) : getName().startsWith(DocumentReader.RESERVED);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class Start extends EventElement {
        private final Element element;

        public Start(org.w3c.dom.Node node) {
            this.element = (Element) node;
        }

        public NamedNodeMap getAttributes() {
            return this.element.getAttributes();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getName() {
            return this.element.getLocalName();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getPrefix() {
            return this.element.getPrefix();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public String getReference() {
            return this.element.getNamespaceURI();
        }

        @Override // org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.element;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class Text extends EventToken {
        private final org.w3c.dom.Node node;

        public Text(org.w3c.dom.Node node) {
            this.node = node;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public Object getSource() {
            return this.node;
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public String getValue() {
            return this.node.getNodeValue();
        }

        @Override // org.simpleframework.xml.stream.EventToken, org.simpleframework.xml.stream.EventNode
        public boolean isText() {
            return true;
        }
    }

    public DocumentReader(Document document) {
        this.queue = new NodeExtractor(document);
        NodeStack nodeStack = new NodeStack();
        this.stack = nodeStack;
        nodeStack.push(document);
    }

    private Entry attribute(org.w3c.dom.Node node) {
        return new Entry(node);
    }

    private Start build(Start start) {
        NamedNodeMap attributes = start.getAttributes();
        int length = attributes.getLength();
        for (int i10 = 0; i10 < length; i10++) {
            Entry entryAttribute = attribute(attributes.item(i10));
            if (!entryAttribute.isReserved()) {
                start.add(entryAttribute);
            }
        }
        return start;
    }

    private EventNode convert(org.w3c.dom.Node node) {
        if (node.getNodeType() != 1) {
            return text(node);
        }
        this.stack.push(node);
        return start(node);
    }

    private End end() {
        return new End();
    }

    private EventNode read() {
        org.w3c.dom.Node nodePeek = this.queue.peek();
        return nodePeek == null ? end() : read(nodePeek);
    }

    private EventNode read(org.w3c.dom.Node node) {
        org.w3c.dom.Node parentNode = node.getParentNode();
        org.w3c.dom.Node pVar = this.stack.top();
        if (parentNode == pVar) {
            this.queue.poll();
            return convert(node);
        }
        if (pVar != null) {
            this.stack.pop();
        }
        return end();
    }

    private Start start(org.w3c.dom.Node node) {
        Start start = new Start(node);
        return start.isEmpty() ? build(start) : start;
    }

    private Text text(org.w3c.dom.Node node) {
        return new Text(node);
    }

    @Override // org.simpleframework.xml.stream.EventReader
    public EventNode next() {
        EventNode eventNode = this.peek;
        if (eventNode == null) {
            return read();
        }
        this.peek = null;
        return eventNode;
    }

    @Override // org.simpleframework.xml.stream.EventReader
    public EventNode peek() {
        if (this.peek == null) {
            this.peek = next();
        }
        return this.peek;
    }
}
