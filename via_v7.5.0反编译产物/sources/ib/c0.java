package ib;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends v5.k {
    public c0(List list, List list2) {
        super(list, list2);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        if (obj.getClass() != this.f13400b.get(i11).getClass()) {
            return false;
        }
        if (obj instanceof b0) {
            return true;
        }
        return super.b(i10, i11);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (!(obj instanceof b0) || !(obj2 instanceof b0)) {
            return super.c(i10, i11);
        }
        b0 b0Var = (b0) obj;
        b0 b0Var2 = (b0) obj2;
        int i12 = b0Var.a() != b0Var2.a() ? 1 : 0;
        if (b0Var.c() != b0Var2.c()) {
            i12 |= 2;
        }
        if (b0Var.b() != b0Var2.b()) {
            i12 |= 4;
        }
        return Integer.valueOf(i12);
    }
}
