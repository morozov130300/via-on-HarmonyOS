package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l2 extends j2 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bundle f2904o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Activity f2905p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ t2 f2906q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(t2 t2Var, Bundle bundle, Activity activity) {
        super(t2Var.f3078c, true);
        this.f2906q = t2Var;
        this.f2904o = bundle;
        this.f2905p = activity;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        Bundle bundle;
        if (this.f2904o != null) {
            bundle = new Bundle();
            if (this.f2904o.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f2904o.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((h1) u1.f.h(this.f2906q.f3078c.f3119i)).onActivityCreated(z1.b.b0(this.f2905p), bundle, this.f2868e);
    }
}
