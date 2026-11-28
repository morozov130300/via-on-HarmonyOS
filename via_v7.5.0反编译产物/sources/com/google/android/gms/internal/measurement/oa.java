package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class oa extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final fb f2947m;

    public oa(String str, fb fbVar) {
        super("internal.remoteConfig");
        this.f2947m = fbVar;
        this.f2885e.put("getValue", new t9(this, "getValue", fbVar));
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        return r.f3013a;
    }
}
