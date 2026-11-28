package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t9 extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ fb f3081m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t9(oa oaVar, String str, fb fbVar) {
        super("getValue");
        this.f3081m = fbVar;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        r5.h("getValue", 2, list);
        r rVarB = q4Var.b((r) list.get(0));
        r rVarB2 = q4Var.b((r) list.get(1));
        String strB = this.f3081m.b(rVarB.f());
        return strB != null ? new v(strB) : rVarB2;
    }
}
