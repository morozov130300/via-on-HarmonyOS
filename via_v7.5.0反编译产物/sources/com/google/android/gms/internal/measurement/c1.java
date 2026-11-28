package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f2722a;

    public c1(Looper looper) {
        super(looper);
        this.f2722a = Looper.getMainLooper();
    }
}
