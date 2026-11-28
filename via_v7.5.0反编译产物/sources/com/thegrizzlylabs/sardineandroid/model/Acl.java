package com.thegrizzlylabs.sardineandroid.model;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Namespace(prefix = "D", reference = "DAV:")
@Root
public class Acl {

    @ElementList(inline = true, required = false)
    private List<Ace> ace;

    public List<Ace> getAce() {
        return this.ace;
    }

    public void setAce(List<Ace> list) {
        this.ace = list;
    }
}
