package lc;

import java.util.ArrayList;
import java.util.List;
import oc.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l extends qc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.o f7700a = new oc.o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7701b = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends qc.b {
        @Override // qc.e
        public qc.f a(qc.h hVar, qc.g gVar) {
            return (hVar.b() < nc.d.f10854a || hVar.a() || (hVar.d().f() instanceof v)) ? qc.f.c() : qc.f.d(new l()).a(hVar.e() + nc.d.f10854a);
        }
    }

    @Override // qc.a, qc.d
    public void c() {
        int size = this.f7701b.size() - 1;
        while (size >= 0 && nc.d.f((CharSequence) this.f7701b.get(size))) {
            size--;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size + 1; i10++) {
            sb2.append((CharSequence) this.f7701b.get(i10));
            sb2.append('\n');
        }
        this.f7700a.o(sb2.toString());
    }

    @Override // qc.d
    public oc.a f() {
        return this.f7700a;
    }

    @Override // qc.d
    public qc.c g(qc.h hVar) {
        if (hVar.b() >= nc.d.f10854a) {
            return qc.c.a(hVar.e() + nc.d.f10854a);
        }
        return hVar.a() ? qc.c.b(hVar.c()) : qc.c.d();
    }

    @Override // qc.a, qc.d
    public void h(CharSequence charSequence) {
        this.f7701b.add(charSequence);
    }
}
