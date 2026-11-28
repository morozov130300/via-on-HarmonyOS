package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Namespace(prefix = "D", reference = "DAV:")
@Root
public class Supportedlock {

    @ElementList(inline = true, required = false)
    private List<Lockentry> lockentryList;

    public List<Lockentry> getLockentryList() {
        if (this.lockentryList == null) {
            this.lockentryList = new ArrayList();
        }
        return this.lockentryList;
    }
}
