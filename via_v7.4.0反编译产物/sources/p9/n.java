package p9;

import java.util.UUID;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public String f11053a;

    /* renamed from: b, reason: collision with root package name */
    public String f11054b;

    /* renamed from: c, reason: collision with root package name */
    public String f11055c;

    /* renamed from: d, reason: collision with root package name */
    public String f11056d;

    /* renamed from: e, reason: collision with root package name */
    public String f11057e;

    /* renamed from: f, reason: collision with root package name */
    public int f11058f;

    /* renamed from: g, reason: collision with root package name */
    public long f11059g;

    /* renamed from: h, reason: collision with root package name */
    public long f11060h;

    public static n a(String str, String str2) {
        return j(str, "assistant", str2);
    }

    public static n j(String str, String str2, String str3) {
        n nVar = new n();
        nVar.n(UUID.randomUUID().toString());
        nVar.q(str3);
        nVar.p(str2);
        nVar.k(str);
        nVar.l(System.currentTimeMillis());
        nVar.r(nVar.c());
        return nVar;
    }

    public static n s(String str, String str2) {
        return j(str, "system", str2);
    }

    public static n u(String str, String str2) {
        return j(str, "user", str2);
    }

    public String b() {
        return this.f11055c;
    }

    public long c() {
        return this.f11059g;
    }

    public int d() {
        return this.f11058f;
    }

    public String e() {
        return this.f11053a;
    }

    public String f() {
        return this.f11056d;
    }

    public String g() {
        return this.f11057e;
    }

    public String h() {
        return this.f11054b;
    }

    public long i() {
        return this.f11060h;
    }

    public void k(String str) {
        this.f11055c = str;
    }

    public void l(long j10) {
        this.f11059g = j10;
    }

    public void m(int i10) {
        this.f11058f = i10;
    }

    public void n(String str) {
        this.f11053a = str;
    }

    public void o(String str) {
        this.f11056d = str;
    }

    public void p(String str) {
        this.f11057e = str;
    }

    public void q(String str) {
        this.f11054b = str;
    }

    public void r(long j10) {
        this.f11060h = j10;
    }

    public e t() {
        e eVar = new e();
        eVar.h(this.f11057e);
        eVar.f(this.f11055c);
        return eVar;
    }

    public String toString() {
        return "CopilotMessage{id='" + this.f11053a + "', threadId='" + this.f11054b + "', content='" + this.f11055c + "', reasoningContent='" + this.f11056d + "', role='" + this.f11057e + "', flags=" + this.f11058f + ", createdAt=" + this.f11059g + ", updatedAt=" + this.f11060h + '}';
    }
}
