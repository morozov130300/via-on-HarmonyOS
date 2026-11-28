package z7;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.recyclerview.widget.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f15217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15218b;

    public b(List list, List list2) {
        this.f15217a = list;
        this.f15218b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        return this.f15217a.get(i10).equals(this.f15218b.get(i11));
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f15217a.get(i10);
        Object obj2 = this.f15218b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof a ? x8.t1.a(((a) obj).a().b(), ((a) obj2).a().b()) : obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f15217a.get(i10).getClass() != this.f15218b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f15218b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f15217a.size();
    }
}
