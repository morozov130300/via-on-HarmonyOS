package m9;

import com.tuyafeng.support.utils.p;
import java.util.UUID;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f7957g = new a("", null, "", 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7963f;

    public a() {
        this.f7960c = "";
    }

    public static boolean g(String str) {
        return "".equals(str);
    }

    public static a h(String str) {
        return i(UUID.randomUUID().toString(), str);
    }

    public static a i(String str, String str2) {
        return j(str, str2, "");
    }

    public static a j(String str, String str2, String str3) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        return new a(str, str2, str3, 0, jCurrentTimeMillis, jCurrentTimeMillis);
    }

    public static a k(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(aVar.b(), aVar.e(), aVar.d(), aVar.c(), aVar.a(), aVar.f());
    }

    public static a r() {
        return f7957g;
    }

    public long a() {
        return this.f7962e;
    }

    public String b() {
        return this.f7958a;
    }

    public int c() {
        return this.f7961d;
    }

    public String d() {
        return this.f7960c;
    }

    public String e() {
        return this.f7959b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f7961d == aVar.f7961d && this.f7962e == aVar.f7962e && this.f7963f == aVar.f7963f && t1.a(this.f7958a, aVar.f7958a) && t1.a(this.f7959b, aVar.f7959b) && t1.a(this.f7960c, aVar.f7960c)) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f7963f;
    }

    public int hashCode() {
        return t1.b(this.f7958a, this.f7959b, this.f7960c, Integer.valueOf(this.f7961d), Long.valueOf(this.f7962e), Long.valueOf(this.f7963f));
    }

    public void l(long j10) {
        this.f7962e = j10;
    }

    public void m(String str) {
        this.f7958a = str;
    }

    public void n(int i10) {
        this.f7961d = i10;
    }

    public void o(String str) {
        this.f7960c = str;
    }

    public void p(String str) {
        this.f7959b = p.l(str);
    }

    public void q(long j10) {
        this.f7963f = j10;
    }

    public String toString() {
        return "BookmarkFolder{id='" + this.f7958a + "', title='" + this.f7959b + "', parentFolderId='" + this.f7960c + "', order=" + this.f7961d + ", createdAt=" + this.f7962e + ", updatedAt=" + this.f7963f + '}';
    }

    public a(String str, String str2, String str3, int i10, long j10, long j11) {
        this.f7958a = str;
        this.f7959b = str2;
        this.f7960c = str3;
        this.f7961d = i10;
        this.f7962e = j10;
        this.f7963f = j11;
    }
}
