package ib;

import java.util.List;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends v5.k {
    public h(List list, List list2) {
        super(list, list2);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        if (obj.getClass() == this.f13400b.get(i11).getClass() && !(obj instanceof w4.c)) {
            return super.a(i10, i11);
        }
        return false;
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof w4.c ? t1.a(((w4.c) obj).g(), ((w4.c) obj2).g()) : super.b(i10, i11);
    }
}
