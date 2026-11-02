package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class OutputNodeMap extends LinkedHashMap<String, OutputNode> implements NodeMap<OutputNode> {
    private final OutputNode source;

    public OutputNodeMap(OutputNode outputNode) {
        this.source = outputNode;
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    public OutputNode get(String str) {
        return (OutputNode) super.get((Object) str);
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    public String getName() {
        return this.source.getName();
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    public OutputNode getNode() {
        return this.source;
    }

    @Override // org.simpleframework.xml.stream.NodeMap, java.lang.Iterable
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    public OutputNode put(String str, String str2) {
        OutputAttribute outputAttribute = new OutputAttribute(this.source, str, str2);
        if (this.source != null) {
            put((OutputNodeMap) str, (String) outputAttribute);
        }
        return outputAttribute;
    }

    @Override // org.simpleframework.xml.stream.NodeMap
    public OutputNode remove(String str) {
        return (OutputNode) super.remove((Object) str);
    }
}
