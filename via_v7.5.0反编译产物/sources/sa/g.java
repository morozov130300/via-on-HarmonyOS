package sa;

import java.util.List;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g extends v5.k {
    public g(List list, List list2) {
        super(list, list2);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof i0) {
            return obj.equals(obj2);
        }
        return obj instanceof a ? obj.equals(obj2) : super.a(i10, i11);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof i0) {
            return t1.a(((i0) obj).a(), ((i0) obj2).a());
        }
        return obj instanceof a ? t1.a(((a) obj).b(), ((a) obj2).b()) : super.b(i10, i11);
    }
}
