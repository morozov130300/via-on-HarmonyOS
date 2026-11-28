package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class t8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r8 f3079a = new s8();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r8 f3080b;

    static {
        r8 r8Var = null;
        try {
            r8Var = (r8) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f3080b = r8Var;
    }

    public static r8 a() {
        r8 r8Var = f3080b;
        if (r8Var != null) {
            return r8Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static r8 b() {
        return f3079a;
    }
}
