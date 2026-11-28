package ib;

import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6354c;

    public b0(int i10, boolean z10, int i11) {
        this.f6352a = i10;
        this.f6353b = z10;
        this.f6354c = i11;
    }

    public int a() {
        return this.f6352a;
    }

    public int b() {
        return this.f6354c;
    }

    public boolean c() {
        return this.f6353b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b0 b0Var = (b0) obj;
            if (this.f6352a == b0Var.f6352a && this.f6353b == b0Var.f6353b && this.f6354c == b0Var.f6354c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return t1.b(Integer.valueOf(this.f6352a), Boolean.valueOf(this.f6353b), Integer.valueOf(this.f6354c));
    }
}
