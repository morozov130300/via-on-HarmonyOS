package e8;

import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4305c;

    public m(String str, String str2, boolean z10) {
        this.f4303a = str;
        this.f4304b = str2;
        this.f4305c = z10;
    }

    public String a() {
        return this.f4304b;
    }

    public String b() {
        return this.f4303a;
    }

    public boolean c() {
        return this.f4305c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            m mVar = (m) obj;
            if (this.f4305c == mVar.f4305c && t1.a(this.f4303a, mVar.f4303a) && t1.a(this.f4304b, mVar.f4304b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return t1.b(this.f4303a, this.f4304b, Boolean.valueOf(this.f4305c));
    }
}
