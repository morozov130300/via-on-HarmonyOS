package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class TokenResult {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class a {
        public abstract TokenResult a();

        public abstract a b(ResponseCode responseCode);

        public abstract a c(String str);

        public abstract a d(long j10);
    }

    public static a a() {
        return new b.C0052b().d(0L);
    }

    public abstract ResponseCode b();

    public abstract String c();

    public abstract long d();
}
