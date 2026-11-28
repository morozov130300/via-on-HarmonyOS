package n9;

import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f10788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10789h;

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
        return this.f10784c;
    }

    public long c() {
        return this.f10788g;
    }

    public int d() {
        return this.f10787f;
    }

    public String e() {
        return this.f10782a;
    }

    public String f() {
        return this.f10785d;
    }

    public String g() {
        return this.f10786e;
    }

    public String h() {
        return this.f10783b;
    }

    public long i() {
        return this.f10789h;
    }

    public void k(String str) {
        this.f10784c = str;
    }

    public void l(long j10) {
        this.f10788g = j10;
    }

    public void m(int i10) {
        this.f10787f = i10;
    }

    public void n(String str) {
        this.f10782a = str;
    }

    public void o(String str) {
        this.f10785d = str;
    }

    public void p(String str) {
        this.f10786e = str;
    }

    public void q(String str) {
        this.f10783b = str;
    }

    public void r(long j10) {
        this.f10789h = j10;
    }

    public e t() {
        e eVar = new e();
        eVar.h(this.f10786e);
        eVar.f(this.f10784c);
        return eVar;
    }

    public String toString() {
        return "CopilotMessage{id='" + this.f10782a + "', threadId='" + this.f10783b + "', content='" + this.f10784c + "', reasoningContent='" + this.f10785d + "', role='" + this.f10786e + "', flags=" + this.f10787f + ", createdAt=" + this.f10788g + ", updatedAt=" + this.f10789h + '}';
    }
}
