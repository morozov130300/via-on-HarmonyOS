package oa;

import java.util.List;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h1 extends v5.k {
    public h1(List list, List list2) {
        super(list, list2);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (!(obj instanceof g1)) {
            return super.a(i10, i11);
        }
        g1 g1Var = (g1) obj;
        g1 g1Var2 = (g1) obj2;
        if (g1Var.b() != g1Var2.b()) {
            return false;
        }
        ra.c cVarA = g1Var.a();
        ra.c cVarA2 = g1Var2.a();
        return cVarA.j() == cVarA2.j() && cVarA.k() == cVarA2.k() && t1.a(cVarA.g(), cVarA2.g()) && t1.a(cVarA.i(), cVarA2.i());
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof g1) {
            return ((g1) obj).a().e() == ((g1) obj2).a().e();
        }
        return super.b(i10, i11);
    }
}
