package sa;

import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12266c;

    public i0(String str, boolean z10, boolean z11) {
        this.f12264a = str;
        this.f12265b = z10;
        this.f12266c = z11;
    }

    public String a() {
        return this.f12264a;
    }

    public boolean b() {
        return this.f12266c;
    }

    public boolean c() {
        return this.f12265b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            i0 i0Var = (i0) obj;
            if (this.f12265b == i0Var.f12265b && this.f12266c == i0Var.f12266c && t1.a(this.f12264a, i0Var.f12264a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return t1.b(this.f12264a, Boolean.valueOf(this.f12265b), Boolean.valueOf(this.f12266c));
    }
}
