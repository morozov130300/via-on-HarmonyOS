package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes.dex */
public class Ace {

    @Element(required = false)
    private Deny deny;

    @Element(required = false)
    private Grant grant;

    @Element(required = false)
    private Inherited inherited;

    @Element(required = false)
    private Principal principal;

    @Element(name = "protected", required = false)
    private Protected protected1;

    public Deny getDeny() {
        return this.deny;
    }

    public Grant getGrant() {
        return this.grant;
    }

    public Inherited getInherited() {
        return this.inherited;
    }

    public Principal getPrincipal() {
        return this.principal;
    }

    public Protected getProtected() {
        return this.protected1;
    }

    public void setDeny(Deny deny) {
        this.deny = deny;
    }

    public void setGrant(Grant grant) {
        this.grant = grant;
    }

    public void setInherited(Inherited inherited) {
        this.inherited = inherited;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public void setProtected(Protected r12) {
        this.protected1 = r12;
    }
}
