package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t9 extends k {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ fb f3782k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t9(oa oaVar, String str, fb fbVar) {
        super("getValue");
        this.f3782k = fbVar;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r5.h("getValue", 2, list);
        r rVarB = q4Var.b((r) list.get(0));
        r rVarB2 = q4Var.b((r) list.get(1));
        String strB = this.f3782k.b(rVarB.f());
        return strB != null ? new v(strB) : rVarB2;
    }
}
