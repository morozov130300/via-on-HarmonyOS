package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ze extends k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f3217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f3218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ af f3219o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ze(af afVar, boolean z10, boolean z11) {
        super("log");
        this.f3219o = afVar;
        this.f3217m = z10;
        this.f3218n = z11;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        int i10;
        r5.i("log", 1, list);
        if (list.size() == 1) {
            this.f3219o.f2702m.a(3, q4Var.b((r) list.get(0)).f(), Collections.EMPTY_LIST, this.f3217m, this.f3218n);
            return r.f3013a;
        }
        int iB = r5.b(q4Var.b((r) list.get(0)).e().doubleValue());
        if (iB == 2) {
            i10 = 4;
        } else if (iB == 3) {
            i10 = 1;
        } else if (iB != 5) {
            i10 = iB != 6 ? 3 : 2;
        } else {
            i10 = 5;
        }
        String strF = q4Var.b((r) list.get(1)).f();
        if (list.size() == 2) {
            this.f3219o.f2702m.a(i10, strF, Collections.EMPTY_LIST, this.f3217m, this.f3218n);
            return r.f3013a;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 2; i11 < Math.min(list.size(), 5); i11++) {
            arrayList.add(q4Var.b((r) list.get(i11)).f());
        }
        this.f3219o.f2702m.a(i10, strF, arrayList, this.f3217m, this.f3218n);
        return r.f3013a;
    }
}
