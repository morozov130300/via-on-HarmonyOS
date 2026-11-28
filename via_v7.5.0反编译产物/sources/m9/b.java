package m9;

import com.tuyafeng.support.utils.p;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7970g;

    public b() {
        this.f7967d = "";
    }

    public long a() {
        return this.f7969f;
    }

    public String b() {
        return this.f7967d;
    }

    public String c() {
        return this.f7964a;
    }

    public int d() {
        return this.f7968e;
    }

    public String e() {
        return this.f7966c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f7968e == bVar.f7968e && this.f7969f == bVar.f7969f && this.f7970g == bVar.f7970g && t1.a(this.f7964a, bVar.f7964a) && t1.a(this.f7965b, bVar.f7965b) && t1.a(this.f7966c, bVar.f7966c) && t1.a(this.f7967d, bVar.f7967d)) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f7970g;
    }

    public String g() {
        return this.f7965b;
    }

    public void h(long j10) {
        this.f7969f = j10;
    }

    public int hashCode() {
        return t1.b(this.f7964a, this.f7965b, this.f7966c, this.f7967d, Integer.valueOf(this.f7968e), Long.valueOf(this.f7969f), Long.valueOf(this.f7970g));
    }

    public void i(String str) {
        this.f7967d = str;
    }

    public void j(String str) {
        this.f7964a = str;
    }

    public void k(int i10) {
        this.f7968e = i10;
    }

    public void l(String str) {
        this.f7966c = p.l(str);
    }

    public void m(long j10) {
        this.f7970g = j10;
    }

    public void n(String str) {
        this.f7965b = str;
    }

    public String toString() {
        return "BookmarkItem{id='" + this.f7964a + "', url='" + this.f7965b + "', title='" + this.f7966c + "', folderId='" + this.f7967d + "', order=" + this.f7968e + ", createdAt=" + this.f7969f + ", updatedAt=" + this.f7970g + '}';
    }

    public b(String str, String str2, String str3, String str4, int i10, long j10, long j11) {
        this.f7964a = str;
        this.f7965b = str2;
        this.f7966c = str3;
        this.f7967d = str4;
        this.f7968e = i10;
        this.f7969f = j10;
        this.f7970g = j11;
    }
}
