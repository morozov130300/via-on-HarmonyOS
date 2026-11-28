package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class bf extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Callable f2717m;

    public bf(String str, Callable callable) {
        super("internal.appMetadata");
        this.f2717m = callable;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        try {
            return t6.b(this.f2717m.call());
        } catch (Exception unused) {
            return r.f3013a;
        }
    }
}
