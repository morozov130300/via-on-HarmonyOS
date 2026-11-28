package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Namespace(prefix = "D", reference = "DAV:")
@Root
public class Propfind {

    @Element(required = false)
    private Allprop allprop;

    @Element(required = false)
    private Prop prop;

    @Element(required = false)
    private Propname propname;

    public Allprop getAllprop() {
        return this.allprop;
    }

    public Prop getProp() {
        return this.prop;
    }

    public Propname getPropname() {
        return this.propname;
    }

    public void setAllprop(Allprop allprop) {
        this.allprop = allprop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public void setPropname(Propname propname) {
        this.propname = propname;
    }
}
