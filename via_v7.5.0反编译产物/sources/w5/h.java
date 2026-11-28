package w5;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends androidx.recyclerview.widget.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f13673b;

    public h(List list, List list2) {
        this.f13672a = list;
        this.f13673b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        return true;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        return ((String) this.f13672a.get(i10)).equals((String) this.f13673b.get(i11));
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f13673b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f13672a.size();
    }
}
