package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class af extends k {

    /* renamed from: k, reason: collision with root package name */
    public final ge f3403k;

    public af(ge geVar) {
        super("internal.logger");
        this.f3403k = geVar;
        this.f3586j.put("log", new ze(this, false, true));
        this.f3586j.put("silent", new ec(this, "silent"));
        ((k) this.f3586j.get("silent")).n("log", new ze(this, true, true));
        this.f3586j.put("unmonitored", new fd(this, "unmonitored"));
        ((k) this.f3586j.get("unmonitored")).n("log", new ze(this, false, false));
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        return r.f3714a;
    }
}
