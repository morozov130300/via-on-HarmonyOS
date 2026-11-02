package ic;

import kc.h;
import kc.t;
import kc.x;
import kc.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b implements nc.a {

    /* renamed from: a, reason: collision with root package name */
    public final char f7189a;

    public b(char c10) {
        this.f7189a = c10;
    }

    @Override // nc.a
    public void a(y yVar, y yVar2, int i10) {
        t xVar;
        String strValueOf = String.valueOf(e());
        if (i10 == 1) {
            xVar = new h(strValueOf);
        } else {
            xVar = new x(strValueOf + strValueOf);
        }
        t tVarE = yVar.e();
        while (tVarE != null && tVarE != yVar2) {
            t tVarE2 = tVarE.e();
            xVar.b(tVarE);
            tVarE = tVarE2;
        }
        yVar.h(xVar);
    }

    @Override // nc.a
    public int b(nc.b bVar, nc.b bVar2) {
        if ((bVar.c() || bVar2.b()) && bVar2.a() % 3 != 0 && (bVar.a() + bVar2.a()) % 3 == 0) {
            return 0;
        }
        return (bVar.length() < 2 || bVar2.length() < 2) ? 1 : 2;
    }

    @Override // nc.a
    public char c() {
        return this.f7189a;
    }

    @Override // nc.a
    public int d() {
        return 1;
    }

    @Override // nc.a
    public char e() {
        return this.f7189a;
    }
}
