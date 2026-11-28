package a9;

import java.util.List;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends androidx.recyclerview.widget.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f205b;

    public b0(List list, List list2) {
        this.f204a = list;
        this.f205b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f204a.get(i10);
        Object obj2 = this.f205b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof a0 ? t1.a(((a0) obj).a(), ((a0) obj2).a()) : this.f204a.get(i10).equals(this.f205b.get(i11));
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f204a.get(i10);
        Object obj2 = this.f205b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof a0 ? t1.a(((a0) obj).getId(), ((a0) obj2).getId()) : obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f204a.get(i10).getClass() != this.f205b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f205b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f204a.size();
    }
}
