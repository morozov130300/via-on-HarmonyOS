package a9;

import java.util.List;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t extends androidx.recyclerview.widget.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f272b;

    public t(List list, List list2) {
        this.f271a = list;
        this.f272b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f271a.get(i10);
        Object obj2 = this.f272b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (!(obj instanceof n9.r)) {
            return this.f271a.get(i10).equals(this.f272b.get(i11));
        }
        n9.r rVar = (n9.r) obj;
        n9.r rVar2 = (n9.r) obj2;
        return rVar.f() == rVar2.f() && t1.a(rVar.d(), rVar2.d()) && t1.a(rVar.e(), rVar2.e());
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f271a.get(i10);
        Object obj2 = this.f272b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof n9.r ? t1.a(((n9.r) obj).c(), ((n9.r) obj2).c()) : obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f271a.get(i10).getClass() != this.f272b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f272b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f271a.size();
    }
}
