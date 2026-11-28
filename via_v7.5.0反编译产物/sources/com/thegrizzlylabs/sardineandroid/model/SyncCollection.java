package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Namespace(prefix = "D", reference = "DAV:")
@Root
public class SyncCollection {
    protected Limit limit;
    protected Prop prop;
    protected String syncLevel;
    protected String syncToken;

    public Limit getLimit() {
        return this.limit;
    }

    public Prop getProp() {
        return this.prop;
    }

    public String getSyncLevel() {
        return this.syncLevel;
    }

    public String getSyncToken() {
        return this.syncToken;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public void setSyncLevel(String str) {
        this.syncLevel = str;
    }

    public void setSyncToken(String str) {
        this.syncToken = str;
    }
}
