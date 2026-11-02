package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class bf extends k {

    /* renamed from: k, reason: collision with root package name */
    public final Callable f3418k;

    public bf(String str, Callable callable) {
        super("internal.appMetadata");
        this.f3418k = callable;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        try {
            return t6.b(this.f3418k.call());
        } catch (Exception unused) {
            return r.f3714a;
        }
    }
}
