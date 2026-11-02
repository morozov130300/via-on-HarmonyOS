package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c1 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final Looper f3423a;

    public c1(Looper looper) {
        super(looper);
        this.f3423a = Looper.getMainLooper();
    }
}
