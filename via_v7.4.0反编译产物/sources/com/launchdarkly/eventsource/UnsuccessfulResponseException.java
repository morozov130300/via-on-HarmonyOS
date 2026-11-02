package com.launchdarkly.eventsource;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class UnsuccessfulResponseException extends Exception {
    private final int code;
    private final String response;

    public UnsuccessfulResponseException(int i10) {
        this(i10, null);
    }

    public UnsuccessfulResponseException(int i10, String str) {
        super("Unsuccessful response code received from stream: " + i10 + ", response: " + str);
        this.code = i10;
        this.response = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getResponse() {
        return this.response;
    }
}
