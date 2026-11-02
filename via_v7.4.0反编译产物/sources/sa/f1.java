package sa;

import java.util.List;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f1 extends a6.k {
    public f1(List list, List list2) {
        super(list, list2);
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        Object obj2 = this.f116b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (!(obj instanceof e1)) {
            return super.a(i10, i11);
        }
        e1 e1Var = (e1) obj;
        e1 e1Var2 = (e1) obj2;
        if (e1Var.b() != e1Var2.b()) {
            return false;
        }
        r5.c cVarA = e1Var.a();
        r5.c cVarA2 = e1Var2.a();
        return cVarA.j() == cVarA2.j() && cVarA.k() == cVarA2.k() && u1.a(cVarA.g(), cVarA2.g()) && u1.a(cVarA.i(), cVarA2.i());
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        Object obj2 = this.f116b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof e1 ? ((e1) obj).a().e() == ((e1) obj2).a().e() : super.b(i10, i11);
    }
}
