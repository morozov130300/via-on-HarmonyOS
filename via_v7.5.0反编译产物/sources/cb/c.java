package cb;

import java.util.List;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends androidx.recyclerview.widget.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f2369b;

    public c(List list, List list2) {
        this.f2368a = list;
        this.f2369b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f2368a.get(i10);
        Object obj2 = this.f2369b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (!(obj instanceof a)) {
            return obj.equals(obj2);
        }
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        return aVar.h() == aVar2.h() && (aVar.h() || t1.a(aVar.b().g(), aVar2.b().g())) && t1.a(aVar.g(), aVar2.g()) && aVar.c() == aVar2.c();
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f2368a.get(i10);
        Object obj2 = this.f2369b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (!(obj instanceof a)) {
            return obj.equals(obj2);
        }
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        return aVar.h() == aVar2.h() && t1.a(aVar.e(), aVar2.e());
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f2369b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f2368a.size();
    }
}
