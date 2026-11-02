package com.thegrizzlylabs.sardineandroid.model;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes.dex */
public class Multistatus {

    @ElementList(inline = true)
    protected List<Response> response;

    @Element(required = false)
    protected String responsedescription;
    protected String syncToken;

    public List<Response> getResponse() {
        if (this.response == null) {
            this.response = new ArrayList();
        }
        return this.response;
    }

    public String getResponsedescription() {
        return this.responsedescription;
    }

    public String getSyncToken() {
        return this.syncToken;
    }

    public void setResponsedescription(String str) {
        this.responsedescription = str;
    }

    public void setSyncToken(String str) {
        this.syncToken = str;
    }
}
