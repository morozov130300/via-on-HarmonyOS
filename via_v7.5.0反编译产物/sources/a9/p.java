package a9;

import java.util.List;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p extends androidx.recyclerview.widget.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f266b;

    public p(List list, List list2) {
        this.f265a = list;
        this.f266b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f265a.get(i10);
        Object obj2 = this.f266b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof a) {
            return t1.a(((a) obj).getTitle(), ((a) obj2).getTitle());
        }
        if (!(obj instanceof q)) {
            return this.f265a.get(i10).equals(this.f266b.get(i11));
        }
        q qVar = (q) obj;
        q qVar2 = (q) obj2;
        return qVar.b() == qVar2.b() && t1.a(qVar.a().e(), qVar2.a().e());
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f265a.get(i10);
        Object obj2 = this.f266b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof a) {
            return true;
        }
        return obj instanceof q ? t1.a(((q) obj).a().d(), ((q) obj2).a().d()) : obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f265a.get(i10).getClass() != this.f266b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f266b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f265a.size();
    }
}
