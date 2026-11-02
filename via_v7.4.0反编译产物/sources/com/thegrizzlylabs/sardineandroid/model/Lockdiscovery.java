package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes.dex */
public class Lockdiscovery {

    @ElementList(inline = true, required = false)
    private List<Activelock> activelock;

    public List<Activelock> getActivelock() {
        if (this.activelock == null) {
            this.activelock = new ArrayList();
        }
        return this.activelock;
    }
}
