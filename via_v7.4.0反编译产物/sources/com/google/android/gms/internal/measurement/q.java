package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q extends k implements n {

    /* renamed from: k, reason: collision with root package name */
    public final List f3693k;

    /* renamed from: l, reason: collision with root package name */
    public final List f3694l;

    /* renamed from: m, reason: collision with root package name */
    public q4 f3695m;

    public q(q qVar) {
        super(qVar.f3585e);
        ArrayList arrayList = new ArrayList(qVar.f3693k.size());
        this.f3693k = arrayList;
        arrayList.addAll(qVar.f3693k);
        ArrayList arrayList2 = new ArrayList(qVar.f3694l.size());
        this.f3694l = arrayList2;
        arrayList2.addAll(qVar.f3694l);
        this.f3695m = qVar.f3695m;
    }

    public q(String str, List list, List list2, q4 q4Var) {
        super(str);
        this.f3693k = new ArrayList();
        this.f3695m = q4Var;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f3693k.add(((r) it.next()).f());
            }
        }
        this.f3694l = new ArrayList(list2);
    }

    @Override // com.google.android.gms.internal.measurement.k
    public final r a(q4 q4Var, List list) {
        q4 q4VarA = this.f3695m.a();
        for (int i10 = 0; i10 < this.f3693k.size(); i10++) {
            if (i10 < list.size()) {
                q4VarA.e((String) this.f3693k.get(i10), q4Var.b((r) list.get(i10)));
            } else {
                q4VarA.e((String) this.f3693k.get(i10), r.f3714a);
            }
        }
        for (r rVar : this.f3694l) {
            r rVarB = q4VarA.b(rVar);
            if (rVarB instanceof s) {
                rVarB = q4VarA.b(rVar);
            }
            if (rVarB instanceof h) {
                return ((h) rVarB).a();
            }
        }
        return r.f3714a;
    }

    @Override // com.google.android.gms.internal.measurement.k, com.google.android.gms.internal.measurement.r
    public final r c() {
        return new q(this);
    }
}
