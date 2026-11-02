package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ze extends k {

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3918k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3919l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ af f3920m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ze(af afVar, boolean z10, boolean z11) {
        super("log");
        this.f3920m = afVar;
        this.f3918k = z10;
        this.f3919l = z11;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r5.i("log", 1, list);
        if (list.size() == 1) {
            this.f3920m.f3403k.a(3, q4Var.b((r) list.get(0)).f(), Collections.EMPTY_LIST, this.f3918k, this.f3919l);
            return r.f3714a;
        }
        int iB = r5.b(q4Var.b((r) list.get(0)).e().doubleValue());
        int i10 = iB != 2 ? iB != 3 ? iB != 5 ? iB != 6 ? 3 : 2 : 5 : 1 : 4;
        String strF = q4Var.b((r) list.get(1)).f();
        if (list.size() == 2) {
            this.f3920m.f3403k.a(i10, strF, Collections.EMPTY_LIST, this.f3918k, this.f3919l);
            return r.f3714a;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 2; i11 < Math.min(list.size(), 5); i11++) {
            arrayList.add(q4Var.b((r) list.get(i11)).f());
        }
        this.f3920m.f3403k.a(i10, strF, arrayList, this.f3918k, this.f3919l);
        return r.f3714a;
    }
}
