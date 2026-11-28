package sb;

import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f12316c;

    public r(int i10, String str) {
        this(i10, str, null);
    }

    public static r a(String str) {
        return new r(1, str, null);
    }

    public static r b(String str) {
        return new r(0, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            r rVar = (r) obj;
            if (this.f12314a == rVar.f12314a && t1.a(this.f12315b, rVar.f12315b) && t1.a(this.f12316c, rVar.f12316c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return t1.b(Integer.valueOf(this.f12314a), this.f12315b, this.f12316c);
    }

    public String toString() {
        return "UpdateResult{code=" + this.f12314a + ", message='" + this.f12315b + "', error=" + this.f12316c + '}';
    }

    public r(int i10, String str, Throwable th) {
        this.f12314a = i10;
        this.f12315b = str;
        this.f12316c = th;
    }
}
