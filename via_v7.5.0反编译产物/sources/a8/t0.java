package a8;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class t0 extends z7.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f191d;

    public t0(m9.a aVar, int i10, boolean z10, boolean z11) {
        super(aVar, i10, z10);
        this.f191d = z11;
    }

    public boolean e() {
        return this.f191d;
    }

    @Override // z7.a
    public boolean equals(Object obj) {
        return super.equals(obj) && this.f191d == ((t0) obj).f191d;
    }

    @Override // z7.a
    public int hashCode() {
        return (super.hashCode() * 31) + (this.f191d ? 1 : 0);
    }
}
