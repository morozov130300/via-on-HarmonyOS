package org.simpleframework.xml.stream;

import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
abstract class EventToken implements EventNode {
    @Override // org.simpleframework.xml.stream.EventNode
    public int getLine() {
        return -1;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public String getName() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public String getPrefix() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public String getReference() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public Object getSource() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public String getValue() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public boolean isEnd() {
        return false;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public boolean isStart() {
        return false;
    }

    @Override // org.simpleframework.xml.stream.EventNode
    public boolean isText() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Attribute> iterator() {
        return null;
    }
}
