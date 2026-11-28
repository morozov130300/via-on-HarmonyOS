package com.launchdarkly.eventsource;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class UnsuccessfulResponseException extends Exception {
    private final int code;
    private final String response;

    public UnsuccessfulResponseException(int i10) {
        this(i10, null);
    }

    public int getCode() {
        return this.code;
    }

    public String getResponse() {
        return this.response;
    }

    public UnsuccessfulResponseException(int i10, String str) {
        super("Unsuccessful response code received from stream: " + i10 + ", response: " + str);
        this.code = i10;
        this.response = str;
    }
}
