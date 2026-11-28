package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fa f2815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final fa f2816b;

    static {
        fa faVar = null;
        try {
            faVar = (fa) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f2815a = faVar;
        f2816b = new fa();
    }

    public static fa a() {
        return f2815a;
    }

    public static fa b() {
        return f2816b;
    }
}
