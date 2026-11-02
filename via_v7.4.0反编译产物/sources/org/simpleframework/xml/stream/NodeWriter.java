package org.simpleframework.xml.stream;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class NodeWriter {
    private final Set active;
    private final OutputStack stack;
    private final boolean verbose;
    private final Formatter writer;

    public NodeWriter(Writer writer) {
        this(writer, new Format());
    }

    public NodeWriter(Writer writer, Format format) {
        this(writer, format, false);
    }

    private NodeWriter(Writer writer, Format format, boolean z10) {
        this.writer = new Formatter(writer, format);
        HashSet hashSet = new HashSet();
        this.active = hashSet;
        this.stack = new OutputStack(hashSet);
        this.verbose = z10;
    }

    private void writeAttributes(OutputNode outputNode) throws NodeException, IOException {
        NodeMap<OutputNode> attributes = outputNode.getAttributes();
        for (String str : attributes) {
            OutputNode outputNode2 = (OutputNode) attributes.get(str);
            this.writer.writeAttribute(str, outputNode2.getValue(), outputNode2.getPrefix(this.verbose));
        }
        this.active.remove(outputNode);
    }

    private void writeComment(OutputNode outputNode) {
        String comment = outputNode.getComment();
        if (comment != null) {
            this.writer.writeComment(comment);
        }
    }

    private void writeEnd(OutputNode outputNode) throws IOException {
        String name = outputNode.getName();
        String prefix = outputNode.getPrefix(this.verbose);
        if (outputNode.getValue() != null) {
            writeValue(outputNode);
        }
        if (name != null) {
            this.writer.writeEnd(name, prefix);
            this.writer.flush();
        }
    }

    private void writeName(OutputNode outputNode) throws IOException {
        String prefix = outputNode.getPrefix(this.verbose);
        String name = outputNode.getName();
        if (name != null) {
            this.writer.writeStart(name, prefix);
        }
    }

    private void writeNamespaces(OutputNode outputNode) throws NodeException, IOException {
        NamespaceMap namespaces = outputNode.getNamespaces();
        for (String str : namespaces) {
            this.writer.writeNamespace(str, namespaces.getPrefix(str));
        }
    }

    private OutputNode writeStart(OutputNode outputNode, String str) throws NodeException {
        OutputElement outputElement = new OutputElement(outputNode, this, str);
        if (str != null) {
            return this.stack.push(outputElement);
        }
        throw new NodeException("Can not have a null name");
    }

    private void writeStart(OutputNode outputNode) throws NodeException, IOException {
        writeComment(outputNode);
        writeName(outputNode);
        writeAttributes(outputNode);
        writeNamespaces(outputNode);
    }

    private void writeValue(OutputNode outputNode) throws IOException {
        Mode mode = outputNode.getMode();
        String value = outputNode.getValue();
        if (value != null) {
            Iterator<OutputNode> it = this.stack.iterator();
            while (it.hasNext()) {
                OutputNode next = it.next();
                if (mode != Mode.INHERIT) {
                    break;
                } else {
                    mode = next.getMode();
                }
            }
            this.writer.writeText(value, mode);
        }
        outputNode.setValue(null);
    }

    public void commit(OutputNode outputNode) throws NodeException, IOException {
        if (this.stack.contains(outputNode)) {
            OutputNode pVar = this.stack.top();
            if (!isCommitted(pVar)) {
                writeStart(pVar);
            }
            while (this.stack.top() != outputNode) {
                writeEnd(this.stack.pop());
            }
            writeEnd(outputNode);
            this.stack.pop();
        }
    }

    public boolean isCommitted(OutputNode outputNode) {
        return !this.active.contains(outputNode);
    }

    public boolean isRoot(OutputNode outputNode) {
        return this.stack.bottom() == outputNode;
    }

    public void remove(OutputNode outputNode) throws NodeException {
        if (this.stack.top() != outputNode) {
            throw new NodeException("Cannot remove node");
        }
        this.stack.pop();
    }

    public OutputNode writeElement(OutputNode outputNode, String str) throws NodeException, IOException {
        if (this.stack.isEmpty()) {
            return writeStart(outputNode, str);
        }
        if (!this.stack.contains(outputNode)) {
            return null;
        }
        OutputNode pVar = this.stack.top();
        if (!isCommitted(pVar)) {
            writeStart(pVar);
        }
        while (this.stack.top() != outputNode) {
            writeEnd(this.stack.pop());
        }
        if (!this.stack.isEmpty()) {
            writeValue(outputNode);
        }
        return writeStart(outputNode, str);
    }

    public OutputNode writeRoot() throws IOException {
        OutputDocument outputDocument = new OutputDocument(this, this.stack);
        if (this.stack.isEmpty()) {
            this.writer.writeProlog();
        }
        return outputDocument;
    }
}
