package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class w9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v9 f3168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v9 f3169b;

    static {
        v9 v9Var = null;
        try {
            v9Var = (v9) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f3168a = v9Var;
        f3169b = new v9();
    }

    public static v9 a() {
        return f3168a;
    }

    public static v9 b() {
        return f3169b;
    }
}
