package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Namespace(prefix = "D", reference = "DAV:")
@Root
public class Link {
    private List<String> dst;
    private List<String> src;

    public List<String> getDst() {
        if (this.dst == null) {
            this.dst = new ArrayList();
        }
        return this.dst;
    }

    public List<String> getSrc() {
        if (this.src == null) {
            this.src = new ArrayList();
        }
        return this.src;
    }
}
