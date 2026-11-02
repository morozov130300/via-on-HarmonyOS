package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ia {

    /* renamed from: c, reason: collision with root package name */
    public static final ia f3559c = new ia();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f3561b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final ma f3560a = new u9();

    public static ia a() {
        return f3559c;
    }

    public final la b(Class cls) {
        h9.c(cls, "messageType");
        la laVar = (la) this.f3561b.get(cls);
        if (laVar != null) {
            return laVar;
        }
        la laVarA = this.f3560a.a(cls);
        h9.c(cls, "messageType");
        h9.c(laVarA, "schema");
        la laVar2 = (la) this.f3561b.putIfAbsent(cls, laVarA);
        return laVar2 == null ? laVarA : laVar2;
    }
}
