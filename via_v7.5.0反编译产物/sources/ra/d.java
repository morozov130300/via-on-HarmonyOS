package ra;

import com.tuyafeng.wormhole.ScriptRules;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import x.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScriptRules f12099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f12100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f12101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f12102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f12104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12105i;

    public static d l(b bVar) {
        if (bVar == null) {
            return null;
        }
        String strA = bVar.a();
        return m(bVar, strA == null ? 0 : strA.getBytes(StandardCharsets.UTF_8).length, null);
    }

    public static d m(b bVar, int i10, h hVar) {
        d dVar = new d();
        e eVarA = e.a(bVar.m());
        dVar.r(bVar.f());
        dVar.u(bVar.l());
        dVar.o(bVar.n());
        dVar.t((eVarA == null || eVarA.f() == 0) ? bVar.k() : eVarA.f());
        dVar.q(bVar.e());
        dVar.p(bVar.d());
        dVar.f12099c = ScriptRules.f3785e.m(ua.c.b(bVar.h(), bVar.g()), ua.c.b(bVar.b(), bVar.c()), eVarA == null ? Collections.EMPTY_LIST : ua.c.b(eVarA.e(), eVarA.d()), eVarA == null ? Collections.EMPTY_LIST : ua.c.b(eVarA.b(), eVarA.c()));
        List listA = ua.c.a(bVar.i());
        dVar.s((listA == null || listA.isEmpty()) ? null : (String[]) listA.toArray(new String[0]));
        Map mapC = ua.c.c(bVar.j());
        if (mapC == null) {
            mapC = Collections.EMPTY_MAP;
        }
        dVar.f12101e = mapC;
        dVar.f12102f = hVar;
        dVar.f12103g = i10;
        return dVar;
    }

    public int a() {
        return this.f12103g;
    }

    public int b() {
        return this.f12104h >> 4;
    }

    public int c() {
        return this.f12105i;
    }

    public int d() {
        return this.f12097a;
    }

    public String[] e() {
        return this.f12100d;
    }

    public Map f() {
        return this.f12101e;
    }

    public int g() {
        return (this.f12104h >> 1) & 7;
    }

    public String h() {
        return this.f12098b;
    }

    public String i() {
        h hVar = this.f12102f;
        if (hVar == null) {
            return null;
        }
        return (String) hVar.get();
    }

    public boolean j() {
        return this.f12097a < 0;
    }

    public boolean k() {
        return (this.f12104h & 1) == 1;
    }

    public void n(int i10) {
        this.f12103g = i10;
    }

    public void o(boolean z10) {
        if (z10) {
            this.f12104h |= 1;
        } else {
            this.f12104h &= -2;
        }
    }

    public void p(int i10) {
        this.f12104h = (i10 << 4) | (this.f12104h & 15);
    }

    public void q(int i10) {
        this.f12105i = i10;
    }

    public void r(int i10) {
        this.f12097a = i10;
    }

    public void s(String[] strArr) {
        this.f12100d = strArr;
    }

    public void t(int i10) {
        this.f12104h = ((i10 & 7) << 1) | (this.f12104h & (-15));
    }

    public String toString() {
        return "ScriptPattern{id=" + this.f12097a + ", scriptId='" + this.f12098b + "', includes=" + this.f12099c.b() + ", excludes=" + this.f12099c.a() + ", requires=" + Arrays.toString(this.f12100d) + ", resources=" + this.f12101e + ", contentSize=" + this.f12103g + ", flags=" + this.f12104h + ", grant=" + this.f12105i + '}';
    }

    public void u(String str) {
        this.f12098b = str;
    }

    public boolean v(String str) {
        return this.f12099c.c(str);
    }
}
