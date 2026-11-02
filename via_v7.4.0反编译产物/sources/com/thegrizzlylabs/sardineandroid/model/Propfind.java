package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes.dex */
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
