package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Namespace(prefix = "D", reference = "DAV:")
@Root
public class SearchRequest {
    private String language;
    private String query;

    public SearchRequest() {
        this.language = "davbasic";
        this.query = "";
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getQuery() {
        return this.query;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public SearchRequest(String str, String str2) {
        this.language = str;
        this.query = str2;
    }
}
