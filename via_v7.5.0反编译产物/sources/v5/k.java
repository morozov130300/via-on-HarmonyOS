package v5;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends androidx.recyclerview.widget.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f13400b;

    public k(List list, List list2) {
        this.f13399a = list;
        this.f13400b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        return this.f13399a.get(i10).equals(this.f13400b.get(i11));
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f13399a.get(i10);
        Object obj2 = this.f13400b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof q) {
            return ((q) obj).c() == ((q) obj2).c();
        }
        if (obj instanceof e) {
            return ((e) obj).d() == ((e) obj2).d();
        }
        if (obj instanceof l) {
            return true;
        }
        return obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f13399a.get(i10).getClass() != this.f13400b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f13400b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f13399a.size();
    }
}
