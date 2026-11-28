package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class af extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ge f2702m;

    public af(ge geVar) {
        super("internal.logger");
        this.f2702m = geVar;
        this.f2885e.put("log", new ze(this, false, true));
        this.f2885e.put("silent", new ec(this, "silent"));
        ((k) this.f2885e.get("silent")).n("log", new ze(this, true, true));
        this.f2885e.put("unmonitored", new fd(this, "unmonitored"));
        ((k) this.f2885e.get("unmonitored")).n("log", new ze(this, false, false));
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        return r.f3013a;
    }
}
