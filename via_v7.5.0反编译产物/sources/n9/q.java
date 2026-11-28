package n9;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f10793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f10794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10798i;

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
        return this.f10792c;
    }

    public long b() {
        return this.f10797h;
    }

    public int c() {
        return this.f10796g;
    }

    public String d() {
        return this.f10790a;
    }

    public String e() {
        return this.f10791b;
    }

    public List f() {
        return this.f10794e;
    }

    public int g() {
        return this.f10795f;
    }

    public long h() {
        return this.f10798i;
    }

    public boolean i() {
        List list = this.f10794e;
        return list == null || list.isEmpty();
    }

    public void l(String str) {
        this.f10792c = str;
    }

    public void m(long j10) {
        this.f10797h = j10;
    }

    public void n(int i10) {
        this.f10796g = i10;
    }

    public void o(String str) {
        this.f10790a = str;
    }

    public void p(String str) {
        this.f10791b = str;
    }

    public void q(List list) {
        this.f10794e = list;
    }

    public void r(int i10) {
        this.f10795f = i10;
    }

    public void s(long j10) {
        this.f10798i = j10;
    }

    public String toString() {
        return "CopilotSuggestion{id='" + this.f10790a + "', name='" + this.f10791b + "', content='" + this.f10792c + "', vendors=" + this.f10793d + ", required=" + this.f10794e + ", type=" + this.f10795f + ", flags=" + this.f10796g + ", createdAt=" + this.f10797h + ", updatedAt=" + this.f10798i + '}';
    }
}
