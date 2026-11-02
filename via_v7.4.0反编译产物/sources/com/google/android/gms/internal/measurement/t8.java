package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t8 {

    /* renamed from: a, reason: collision with root package name */
    public static final r8 f3780a = new s8();

    /* renamed from: b, reason: collision with root package name */
    public static final r8 f3781b;

    static {
        r8 r8Var = null;
        try {
            r8Var = (r8) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f3781b = r8Var;
    }

    public static r8 a() {
        r8 r8Var = f3781b;
        if (r8Var != null) {
            return r8Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static r8 b() {
        return f3780a;
    }
}
