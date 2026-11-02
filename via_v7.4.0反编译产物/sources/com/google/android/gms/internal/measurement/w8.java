package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w8 implements y9 {

    /* renamed from: a, reason: collision with root package name */
    public static final w8 f3868a = new w8();

    public static w8 c() {
        return f3868a;
    }

    @Override // com.google.android.gms.internal.measurement.y9
    public final x9 a(Class cls) {
        if (!a9.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (x9) a9.n(cls.asSubclass(a9.class)).C(3, null, null);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y9
    public final boolean b(Class cls) {
        return a9.class.isAssignableFrom(cls);
    }
}
