package com.thegrizzlylabs.sardineandroid.impl;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class SardineException extends IOException {
    private static final long serialVersionUID = -3900043433469104564L;
    private String responsePhrase;
    private final int statusCode;

    public SardineException(String str, int i10, String str2) {
        super(str);
        this.statusCode = i10;
        this.responsePhrase = str2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format(Locale.US, "%s (%d %s)", super.getMessage(), Integer.valueOf(getStatusCode()), getResponsePhrase());
    }

    public String getResponsePhrase() {
        return this.responsePhrase;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
