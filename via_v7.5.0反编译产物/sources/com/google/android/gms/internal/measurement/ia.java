package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ia {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ia f2858c = new ia();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f2860b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ma f2859a = new u9();

    public static ia a() {
        return f2858c;
    }

    public final la b(Class cls) {
        h9.c(cls, "messageType");
        la laVar = (la) this.f2860b.get(cls);
        if (laVar != null) {
            return laVar;
        }
        la laVarA = this.f2859a.a(cls);
        h9.c(cls, "messageType");
        h9.c(laVarA, "schema");
        la laVar2 = (la) this.f2860b.putIfAbsent(cls, laVarA);
        return laVar2 == null ? laVarA : laVar2;
    }
}
