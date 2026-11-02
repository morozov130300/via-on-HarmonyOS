package ib;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c0 extends a6.k {
    public c0(List list, List list2) {
        super(list, list2);
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        Object obj2 = this.f116b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof b0 ? obj.equals(obj2) : super.a(i10, i11);
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        if (obj.getClass() != this.f116b.get(i11).getClass()) {
            return false;
        }
        if (obj instanceof b0) {
            return true;
        }
        return super.b(i10, i11);
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        Object obj2 = this.f116b.get(i11);
        if (!(obj instanceof b0) || !(obj2 instanceof b0)) {
            return super.c(i10, i11);
        }
        b0 b0Var = (b0) obj;
        b0 b0Var2 = (b0) obj2;
        int i12 = b0Var.b() != b0Var2.b() ? 1 : 0;
        if (b0Var.e() != b0Var2.e()) {
            i12 |= 2;
        }
        if (b0Var.c() != b0Var2.c()) {
            i12 |= 4;
        }
        if (b0Var.d() != b0Var2.d() || b0Var.a() != b0Var2.a()) {
            i12 |= 8;
        }
        return Integer.valueOf(i12);
    }
}
