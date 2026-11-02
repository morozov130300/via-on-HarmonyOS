package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import f0.a;
import f2.p4;
import f2.q4;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends a implements p4 {

    /* renamed from: c, reason: collision with root package name */
    public q4 f3948c;

    @Override // f2.p4
    public void a(Context context, Intent intent) {
        a.c(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f3948c == null) {
            this.f3948c = new q4(this);
        }
        this.f3948c.a(context, intent);
    }
}
