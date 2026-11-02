package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes.dex */
public class Principal {

    @Element(required = false)
    private All all;

    @Element(required = false)
    private Authenticated authenticated;

    @Element(required = false)
    private String href;

    @Element(required = false)
    private Property property;

    @Element(required = false)
    private Self self;

    @Element(required = false)
    private Unauthenticated unauthenticated;

    public All getAll() {
        return this.all;
    }

    public Authenticated getAuthenticated() {
        return this.authenticated;
    }

    public String getHref() {
        return this.href;
    }

    public Property getProperty() {
        return this.property;
    }

    public Self getSelf() {
        return this.self;
    }

    public Unauthenticated getUnauthenticated() {
        return this.unauthenticated;
    }

    public void setAll(All all) {
        this.all = all;
    }

    public void setAuthenticated(Authenticated authenticated) {
        this.authenticated = authenticated;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public void setUnauthenticated(Unauthenticated unauthenticated) {
        this.unauthenticated = unauthenticated;
    }
}
