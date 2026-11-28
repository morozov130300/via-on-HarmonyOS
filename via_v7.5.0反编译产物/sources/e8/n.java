package e8;

import java.util.List;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends v5.k {
    public n(List list, List list2) {
        super(list, list2);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof a) {
            return ((a) obj).a() == ((a) obj2).a();
        }
        if (obj instanceof g) {
            return ((g) obj).a() == ((g) obj2).a();
        }
        return obj instanceof m ? ((m) obj2).equals((m) obj) : super.a(i10, i11);
    }

    @Override // v5.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof m) {
            return t1.a(((m) obj).b(), ((m) obj2).b());
        }
        if (obj instanceof a) {
            return ((a) obj).a() == ((a) obj2).a();
        }
        if (obj instanceof g) {
            return ((g) obj).a() == ((g) obj2).a();
        }
        return super.b(i10, i11);
    }
}
