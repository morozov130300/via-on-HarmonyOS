package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Namespace(prefix = "D", reference = "DAV:")
@Root(strict = false)
public class Activelock {

    @Element
    private String depth;

    @Element
    private Lockscope lockscope;

    @Element(required = false)
    private Locktoken locktoken;

    @Element
    private Locktype locktype;

    @Element(required = false)
    private Owner owner;

    @Element(required = false)
    private String timeout;

    public String getDepth() {
        return this.depth;
    }

    public Lockscope getLockscope() {
        return this.lockscope;
    }

    public Locktoken getLocktoken() {
        return this.locktoken;
    }

    public Locktype getLocktype() {
        return this.locktype;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public void setDepth(String str) {
        this.depth = str;
    }

    public void setLockscope(Lockscope lockscope) {
        this.lockscope = lockscope;
    }

    public void setLocktoken(Locktoken locktoken) {
        this.locktoken = locktoken;
    }

    public void setLocktype(Locktype locktype) {
        this.locktype = locktype;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setTimeout(String str) {
        this.timeout = str;
    }
}
