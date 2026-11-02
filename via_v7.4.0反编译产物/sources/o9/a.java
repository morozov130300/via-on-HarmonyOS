package o9;

import g6.p;
import java.util.UUID;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f10469g = new a("", null, "", 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public String f10470a;

    /* renamed from: b, reason: collision with root package name */
    public String f10471b;

    /* renamed from: c, reason: collision with root package name */
    public String f10472c;

    /* renamed from: d, reason: collision with root package name */
    public int f10473d;

    /* renamed from: e, reason: collision with root package name */
    public long f10474e;

    /* renamed from: f, reason: collision with root package name */
    public long f10475f;

    public a() {
        this.f10472c = "";
    }

    public a(String str, String str2, String str3, int i10, long j10, long j11) {
        this.f10470a = str;
        this.f10471b = str2;
        this.f10472c = str3;
        this.f10473d = i10;
        this.f10474e = j10;
        this.f10475f = j11;
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
        return f10469g;
    }

    public long a() {
        return this.f10474e;
    }

    public String b() {
        return this.f10470a;
    }

    public int c() {
        return this.f10473d;
    }

    public String d() {
        return this.f10472c;
    }

    public String e() {
        return this.f10471b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f10473d == aVar.f10473d && this.f10474e == aVar.f10474e && this.f10475f == aVar.f10475f && u1.a(this.f10470a, aVar.f10470a) && u1.a(this.f10471b, aVar.f10471b) && u1.a(this.f10472c, aVar.f10472c)) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f10475f;
    }

    public int hashCode() {
        return u1.b(this.f10470a, this.f10471b, this.f10472c, Integer.valueOf(this.f10473d), Long.valueOf(this.f10474e), Long.valueOf(this.f10475f));
    }

    public void l(long j10) {
        this.f10474e = j10;
    }

    public void m(String str) {
        this.f10470a = str;
    }

    public void n(int i10) {
        this.f10473d = i10;
    }

    public void o(String str) {
        this.f10472c = str;
    }

    public void p(String str) {
        this.f10471b = p.l(str);
    }

    public void q(long j10) {
        this.f10475f = j10;
    }

    public String toString() {
        return "BookmarkFolder{id='" + this.f10470a + "', title='" + this.f10471b + "', parentFolderId='" + this.f10472c + "', order=" + this.f10473d + ", createdAt=" + this.f10474e + ", updatedAt=" + this.f10475f + '}';
    }
}
