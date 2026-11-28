package mc;

import oc.h;
import oc.t;
import oc.x;
import oc.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements rc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f10400a;

    public b(char c10) {
        this.f10400a = c10;
    }

    @Override // rc.a
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

    @Override // rc.a
    public char b() {
        return this.f10400a;
    }

    @Override // rc.a
    public int c(rc.b bVar, rc.b bVar2) {
        if ((bVar.c() || bVar2.b()) && bVar2.a() % 3 != 0 && (bVar.a() + bVar2.a()) % 3 == 0) {
            return 0;
        }
        return (bVar.length() < 2 || bVar2.length() < 2) ? 1 : 2;
    }

    @Override // rc.a
    public int d() {
        return 1;
    }

    @Override // rc.a
    public char e() {
        return this.f10400a;
    }
}
