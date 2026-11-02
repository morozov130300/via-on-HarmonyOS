package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n9 extends p9 {
    public /* synthetic */ n9(m9 m9Var) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final void a(Object obj, long j10) {
        ((g9) ab.k(obj, j10)).a();
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final void b(Object obj, Object obj2, long j10) {
        g9 g9VarJ = (g9) ab.k(obj, j10);
        g9 g9Var = (g9) ab.k(obj2, j10);
        int size = g9VarJ.size();
        int size2 = g9Var.size();
        if (size > 0 && size2 > 0) {
            if (!g9VarJ.b()) {
                g9VarJ = g9VarJ.j(size2 + size);
            }
            g9VarJ.addAll(g9Var);
        }
        if (size > 0) {
            g9Var = g9VarJ;
        }
        ab.x(obj, j10, g9Var);
    }
}
