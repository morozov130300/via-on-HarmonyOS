package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class w9 {

    /* renamed from: a, reason: collision with root package name */
    public static final v9 f3869a;

    /* renamed from: b, reason: collision with root package name */
    public static final v9 f3870b;

    static {
        v9 v9Var = null;
        try {
            v9Var = (v9) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f3869a = v9Var;
        f3870b = new v9();
    }

    public static v9 a() {
        return f3869a;
    }

    public static v9 b() {
        return f3870b;
    }
}
