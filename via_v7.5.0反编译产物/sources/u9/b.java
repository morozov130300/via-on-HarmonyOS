package u9;

import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12908a;

    public b(int i10) {
        this.f12908a = i10;
    }

    public int a() {
        return this.f12908a;
    }

    public boolean b(int i10) {
        return (this.f12908a & i10) == i10;
    }

    public void c(int i10, boolean z10) {
        if (z10) {
            this.f12908a = i10 | this.f12908a;
        } else {
            this.f12908a = (i10 ^ (-1)) & this.f12908a;
        }
    }

    public void d(int i10) {
        this.f12908a = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f12908a == ((b) obj).f12908a;
    }

    public int hashCode() {
        return t1.b(Integer.valueOf(this.f12908a));
    }
}
