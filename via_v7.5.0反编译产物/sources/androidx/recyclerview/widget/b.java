package androidx.recyclerview.widget;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f1281a;

    public b(RecyclerView.Adapter adapter) {
        this.f1281a = adapter;
    }

    @Override // androidx.recyclerview.widget.o
    public void a(int i10, int i11) {
        this.f1281a.p(i10, i11);
    }

    @Override // androidx.recyclerview.widget.o
    public void b(int i10, int i11) {
        this.f1281a.s(i10, i11);
    }

    @Override // androidx.recyclerview.widget.o
    public void c(int i10, int i11) {
        this.f1281a.t(i10, i11);
    }

    @Override // androidx.recyclerview.widget.o
    public void d(int i10, int i11, Object obj) {
        this.f1281a.r(i10, i11, obj);
    }
}
