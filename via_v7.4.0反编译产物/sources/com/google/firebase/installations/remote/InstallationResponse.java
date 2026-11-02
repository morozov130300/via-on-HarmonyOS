package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class InstallationResponse {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class a {
        public abstract InstallationResponse a();

        public abstract a b(TokenResult tokenResult);

        public abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(ResponseCode responseCode);

        public abstract a f(String str);
    }

    public static a a() {
        return new a.b();
    }

    public abstract TokenResult b();

    public abstract String c();

    public abstract String d();

    public abstract ResponseCode e();

    public abstract String f();
}
