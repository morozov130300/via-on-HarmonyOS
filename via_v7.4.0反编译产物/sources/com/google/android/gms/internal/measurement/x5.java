package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x5 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y5 f3881a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x5(y5 y5Var, Handler handler) {
        super(null);
        this.f3881a = y5Var;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.f3881a.f();
    }
}
