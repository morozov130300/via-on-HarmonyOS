package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l2 extends j2 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f3605m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Activity f3606n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ t2 f3607o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(t2 t2Var, Bundle bundle, Activity activity) {
        super(t2Var.f3779e, true);
        this.f3607o = t2Var;
        this.f3605m = bundle;
        this.f3606n = activity;
    }

    @Override // com.google.android.gms.internal.measurement.j2
    public final void a() {
        Bundle bundle;
        if (this.f3605m != null) {
            bundle = new Bundle();
            if (this.f3605m.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f3605m.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((h1) t1.f.h(this.f3607o.f3779e.f3820i)).onActivityCreated(y1.b.b0(this.f3606n), bundle, this.f3569j);
    }
}
