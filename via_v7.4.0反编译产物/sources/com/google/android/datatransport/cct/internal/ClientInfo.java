package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ClientInfo {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int i10) {
            this.value = i10;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class a {
        public abstract ClientInfo a();

        public abstract a b(c1.a aVar);

        public abstract a c(ClientType clientType);
    }

    public static a a() {
        return new b.C0044b();
    }

    public abstract c1.a b();

    public abstract ClientType c();
}
