package ib;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s extends v5.k {
    public s(List list, List list2) {
        super(list, list2);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof r ? obj.equals(obj2) : super.a(i10, i11);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof r) {
            return ((r) obj).a() == ((r) obj2).a();
        }
        return super.b(i10, i11);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        return super.c(i10, i11);
    }
}
