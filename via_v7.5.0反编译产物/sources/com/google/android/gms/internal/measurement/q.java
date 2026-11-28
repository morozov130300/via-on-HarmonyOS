package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q extends k implements n {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f2992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f2993n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public q4 f2994o;

    public q(q qVar) {
        super(qVar.f2884c);
        ArrayList arrayList = new ArrayList(qVar.f2992m.size());
        this.f2992m = arrayList;
        arrayList.addAll(qVar.f2992m);
        ArrayList arrayList2 = new ArrayList(qVar.f2993n.size());
        this.f2993n = arrayList2;
        arrayList2.addAll(qVar.f2993n);
        this.f2994o = qVar.f2994o;
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        q4 q4VarA = this.f2994o.a();
        for (int i10 = 0; i10 < this.f2992m.size(); i10++) {
            if (i10 < list.size()) {
                q4VarA.e((String) this.f2992m.get(i10), q4Var.b((r) list.get(i10)));
            } else {
                q4VarA.e((String) this.f2992m.get(i10), r.f3013a);
            }
        }
        for (r rVar : this.f2993n) {
            r rVarB = q4VarA.b(rVar);
            if (rVarB instanceof s) {
                rVarB = q4VarA.b(rVar);
            }
            if (rVarB instanceof h) {
                return ((h) rVarB).a();
            }
        }
        return r.f3013a;
    }

    @Override // com.google.android.gms.internal.measurement.k, com.google.android.gms.internal.measurement.r
    public final r c() {
        return new q(this);
    }

    public q(String str, List list, List list2, q4 q4Var) {
        super(str);
        this.f2992m = new ArrayList();
        this.f2994o = q4Var;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f2992m.add(((r) it.next()).f());
            }
        }
        this.f2993n = new ArrayList(list2);
    }
}
