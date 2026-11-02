package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final Map f3905a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final m0 f3906b = new m0();

    public z() {
        b(new x());
        b(new a0());
        b(new b0());
        b(new f0());
        b(new k0());
        b(new l0());
        b(new n0());
    }

    public final r a(q4 q4Var, r rVar) {
        r5.c(q4Var);
        if (!(rVar instanceof s)) {
            return rVar;
        }
        s sVar = (s) rVar;
        ArrayList arrayListB = sVar.b();
        String strA = sVar.a();
        return (this.f3905a.containsKey(strA) ? (y) this.f3905a.get(strA) : this.f3906b).a(strA, q4Var, arrayListB);
    }

    public final void b(y yVar) {
        Iterator it = yVar.f3889a.iterator();
        while (it.hasNext()) {
            this.f3905a.put(((zzbl) it.next()).zzb().toString(), yVar);
        }
    }
}
