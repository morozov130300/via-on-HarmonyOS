package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Namespace(prefix = "D", reference = "DAV:")
@Root
public class Lockinfo {

    @Element
    private Lockscope lockscope;

    @Element
    private Locktype locktype;

    @Element(required = false)
    private Owner owner;

    public Lockscope getLockscope() {
        return this.lockscope;
    }

    public Locktype getLocktype() {
        return this.locktype;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setLockscope(Lockscope lockscope) {
        this.lockscope = lockscope;
    }

    public void setLocktype(Locktype locktype) {
        this.locktype = locktype;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
