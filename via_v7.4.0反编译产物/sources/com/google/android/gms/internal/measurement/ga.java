package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ga {

    /* renamed from: a, reason: collision with root package name */
    public static final fa f3516a;

    /* renamed from: b, reason: collision with root package name */
    public static final fa f3517b;

    static {
        fa faVar = null;
        try {
            faVar = (fa) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f3516a = faVar;
        f3517b = new fa();
    }

    public static fa a() {
        return f3516a;
    }

    public static fa b() {
        return f3517b;
    }
}
