package sa;

import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12232c;

    public a(String str, String str2, boolean z10) {
        this.f12230a = str;
        this.f12231b = str2;
        this.f12232c = z10;
    }

    public String a() {
        return this.f12231b;
    }

    public String b() {
        return this.f12230a;
    }

    public boolean c() {
        return this.f12232c;
    }

    public void d(boolean z10) {
        this.f12232c = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f12232c == aVar.f12232c && t1.a(this.f12230a, aVar.f12230a) && t1.a(this.f12231b, aVar.f12231b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return t1.b(this.f12230a, this.f12231b, Boolean.valueOf(this.f12232c));
    }
}
