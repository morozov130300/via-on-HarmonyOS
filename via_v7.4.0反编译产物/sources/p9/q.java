package p9;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public String f11061a;

    /* renamed from: b, reason: collision with root package name */
    public String f11062b;

    /* renamed from: c, reason: collision with root package name */
    public String f11063c;

    /* renamed from: d, reason: collision with root package name */
    public Map f11064d;

    /* renamed from: e, reason: collision with root package name */
    public List f11065e;

    /* renamed from: f, reason: collision with root package name */
    public int f11066f;

    /* renamed from: g, reason: collision with root package name */
    public int f11067g;

    /* renamed from: h, reason: collision with root package name */
    public long f11068h;

    /* renamed from: i, reason: collision with root package name */
    public long f11069i;

    public static q j(String str, String str2) {
        q qVar = new q();
        qVar.o(UUID.randomUUID().toString());
        qVar.p(str);
        qVar.l(str2);
        qVar.r(2);
        if (str2 != null && !str2.isEmpty()) {
            List listI = s.i(str2, qVar.g());
            if (!listI.isEmpty()) {
                qVar.q(listI);
            }
        }
        qVar.m(System.currentTimeMillis());
        qVar.s(qVar.b());
        return qVar;
    }

    public static q k(String str, String str2) {
        q qVar = new q();
        qVar.o(UUID.randomUUID().toString());
        qVar.p(str);
        qVar.l(str2);
        qVar.r(1);
        if (str2 != null && !str2.isEmpty()) {
            List listI = s.i(str2, qVar.g());
            if (!listI.isEmpty()) {
                qVar.q(listI);
            }
        }
        qVar.n(s.g(qVar.f()));
        qVar.m(System.currentTimeMillis());
        qVar.s(qVar.b());
        return qVar;
    }

    public String a() {
        return this.f11063c;
    }

    public long b() {
        return this.f11068h;
    }

    public int c() {
        return this.f11067g;
    }

    public String d() {
        return this.f11061a;
    }

    public String e() {
        return this.f11062b;
    }

    public List f() {
        return this.f11065e;
    }

    public int g() {
        return this.f11066f;
    }

    public long h() {
        return this.f11069i;
    }

    public boolean i() {
        List list = this.f11065e;
        return list == null || list.isEmpty();
    }

    public void l(String str) {
        this.f11063c = str;
    }

    public void m(long j10) {
        this.f11068h = j10;
    }

    public void n(int i10) {
        this.f11067g = i10;
    }

    public void o(String str) {
        this.f11061a = str;
    }

    public void p(String str) {
        this.f11062b = str;
    }

    public void q(List list) {
        this.f11065e = list;
    }

    public void r(int i10) {
        this.f11066f = i10;
    }

    public void s(long j10) {
        this.f11069i = j10;
    }

    public String toString() {
        return "CopilotSuggestion{id='" + this.f11061a + "', name='" + this.f11062b + "', content='" + this.f11063c + "', vendors=" + this.f11064d + ", required=" + this.f11065e + ", type=" + this.f11066f + ", flags=" + this.f11067g + ", createdAt=" + this.f11068h + ", updatedAt=" + this.f11069i + '}';
    }
}
