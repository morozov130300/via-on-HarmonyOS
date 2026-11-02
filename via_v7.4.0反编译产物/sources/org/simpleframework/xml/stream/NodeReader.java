package org.simpleframework.xml.stream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class NodeReader {
    private final EventReader reader;
    private final StringBuilder text = new StringBuilder();
    private final InputStack stack = new InputStack();

    public NodeReader(EventReader eventReader) {
        this.reader = eventReader;
    }

    private void fillText(InputNode inputNode) {
        EventNode eventNodePeek = this.reader.peek();
        if (eventNodePeek.isText()) {
            this.text.append(eventNodePeek.getValue());
        }
    }

    private boolean isName(EventNode eventNode, String str) {
        String name = eventNode.getName();
        if (name == null) {
            return false;
        }
        return name.equals(str);
    }

    private String readBuffer(InputNode inputNode) {
        if (this.text.length() <= 0) {
            return null;
        }
        String string = this.text.toString();
        this.text.setLength(0);
        return string;
    }

    private InputNode readStart(InputNode inputNode, EventNode eventNode) {
        InputElement inputElement = new InputElement(inputNode, this, eventNode);
        if (this.text.length() > 0) {
            this.text.setLength(0);
        }
        return eventNode.isStart() ? this.stack.push(inputElement) : inputElement;
    }

    private String readText(InputNode inputNode) {
        EventNode eventNodePeek = this.reader.peek();
        while (this.stack.top() == inputNode && eventNodePeek.isText()) {
            fillText(inputNode);
            this.reader.next();
            eventNodePeek = this.reader.peek();
        }
        return readBuffer(inputNode);
    }

    public boolean isEmpty(InputNode inputNode) {
        return this.stack.top() == inputNode && this.reader.peek().isEnd();
    }

    public boolean isRoot(InputNode inputNode) {
        return this.stack.bottom() == inputNode;
    }

    public InputNode readElement(InputNode inputNode) {
        if (!this.stack.isRelevant(inputNode)) {
            return null;
        }
        EventNode next = this.reader.next();
        while (next != null) {
            if (next.isEnd()) {
                if (this.stack.pop() == inputNode) {
                    return null;
                }
            } else if (next.isStart()) {
                return readStart(inputNode, next);
            }
            next = this.reader.next();
        }
        return null;
    }

    public InputNode readElement(InputNode inputNode, String str) {
        if (!this.stack.isRelevant(inputNode)) {
            return null;
        }
        EventNode eventNodePeek = this.reader.peek();
        while (true) {
            if (eventNodePeek == null) {
                break;
            }
            if (eventNodePeek.isText()) {
                fillText(inputNode);
            } else if (eventNodePeek.isEnd()) {
                if (this.stack.top() == inputNode) {
                    return null;
                }
                this.stack.pop();
            } else if (eventNodePeek.isStart()) {
                if (isName(eventNodePeek, str)) {
                    return readElement(inputNode);
                }
            }
            this.reader.next();
            eventNodePeek = this.reader.peek();
        }
        return null;
    }

    public InputNode readRoot() throws NodeException {
        if (!this.stack.isEmpty()) {
            return null;
        }
        InputNode element = readElement(null);
        if (element != null) {
            return element;
        }
        throw new NodeException("Document has no root element");
    }

    public String readValue(InputNode inputNode) {
        if (!this.stack.isRelevant(inputNode)) {
            return null;
        }
        if (this.text.length() <= 0 && this.reader.peek().isEnd()) {
            if (this.stack.top() == inputNode) {
                return null;
            }
            this.stack.pop();
            this.reader.next();
        }
        return readText(inputNode);
    }

    public void skipElement(InputNode inputNode) {
        while (readElement(inputNode) != null) {
        }
    }
}
