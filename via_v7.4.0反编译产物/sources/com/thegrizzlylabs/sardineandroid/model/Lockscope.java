package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes.dex */
public class Lockscope {

    @Element(required = false)
    private Exclusive exclusive;

    @Element(required = false)
    private Shared shared;

    public Exclusive getExclusive() {
        return this.exclusive;
    }

    public Shared getShared() {
        return this.shared;
    }

    public void setExclusive(Exclusive exclusive) {
        this.exclusive = exclusive;
    }

    public void setShared(Shared shared) {
        this.shared = shared;
    }
}
