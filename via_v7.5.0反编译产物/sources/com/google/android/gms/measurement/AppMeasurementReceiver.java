package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import g0.a;
import g2.p4;
import g2.q4;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends a implements p4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q4 f3247c;

    @Override // g2.p4
    public void a(Context context, Intent intent) {
        a.c(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f3247c == null) {
            this.f3247c = new q4(this);
        }
        this.f3247c.a(context, intent);
    }
}
