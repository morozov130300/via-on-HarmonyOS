package n9;

import c6.a2;
import com.launchdarkly.eventsource.ReadyState;
import com.launchdarkly.eventsource.UnsuccessfulResponseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.x;
import okhttp3.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final okhttp3.t f10771d = okhttp3.t.d("application/json; charset=utf-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.u f10772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.launchdarkly.eventsource.a f10773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f4.l f10774c = null;

    public m() {
        okhttp3.u.b bVar = new okhttp3.u.b();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f10772a = bVar.c(30L, timeUnit).h(30L, timeUnit).l(60L, timeUnit).b();
    }

    public boolean c() {
        com.launchdarkly.eventsource.a aVar = this.f10773b;
        boolean z10 = false;
        if (aVar != null) {
            z10 = aVar.m() == ReadyState.CONNECTING;
            this.f10773b.close();
            this.f10773b = null;
        }
        return z10;
    }

    public c d(l lVar, String str, List list) {
        return e(lVar, str, list, null);
    }

    public c e(l lVar, String str, List list, List list2) {
        if (i(lVar)) {
            throw new IllegalArgumentException("Invalid backend");
        }
        y yVarC = this.f10772a.v(g(lVar, str, list, false, list2)).c();
        try {
            if (yVarC.c() == 200 && yVarC.a() != null) {
                c cVarA = c.a(yVarC.a().j());
                yVarC.close();
                return cVarA;
            }
            throw new UnsuccessfulResponseException(yVarC.c(), yVarC.a() == null ? null : yVarC.a().j());
        } catch (Throwable th) {
            if (yVarC == null) {
                throw th;
            }
            try {
                yVarC.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public void f(l lVar, String str, List list, List list2, h hVar) {
        j(lVar, str, list, list2, hVar);
    }

    public final okhttp3.w g(l lVar, String str, List list, boolean z10, List list2) {
        String strA;
        String strI = lVar.i();
        if (!strI.endsWith("/chat/completions")) {
            if (strI.charAt(strI.length() - 1) == '/') {
                strI = strI + "chat/completions";
            } else {
                strI = strI + "/chat/completions";
            }
        }
        String str2 = strI;
        try {
            strA = new f(str, list, z10, 0.5d, list2).a();
        } catch (Exception e10) {
            tc.a.j(e10);
            strA = "";
        }
        return new okhttp3.w.a().j(str2).d("Authorization", "Bearer " + lVar.e()).g(x.d(f10771d, strA)).b();
    }

    public f4.l h() {
        f4.l lVar = this.f10774c;
        if (lVar != null) {
            return lVar;
        }
        b bVar = new b();
        this.f10774c = bVar;
        return bVar;
    }

    public final boolean i(l lVar) {
        if (lVar == null) {
            return true;
        }
        a2 a2Var = a2.f1958a;
        if ((!a2Var.t(lVar.i()) && !a2Var.m(lVar.i())) || lVar.e() == null || lVar.e().isEmpty()) {
            return true;
        }
        int length = lVar.e().length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = lVar.e().charAt(i10);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                return true;
            }
        }
        return false;
    }

    public final void j(l lVar, String str, List list, List list2, h hVar) {
        if (i(lVar)) {
            hVar.a(g.a(104, new IllegalArgumentException("Invalid backend")));
            return;
        }
        okhttp3.w wVarG = g(lVar, str, list, true, list2);
        com.launchdarkly.eventsource.a aVar = this.f10773b;
        if (aVar != null) {
            aVar.close();
        }
        com.launchdarkly.eventsource.a aVarR = new com.launchdarkly.eventsource.a.d(new a(hVar), wVarG.h()).q(wVarG.a()).v(wVarG.d()).x(wVarG.f()).s(this.f10772a).w(h()).r();
        this.f10773b = aVarR;
        aVarR.u();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements f4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f10775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10776b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10777c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f10778d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h f10779e;

        public a(h hVar) {
            this.f10779e = hVar;
        }

        @Override // f4.c
        public void c() {
            if (this.f10776b) {
                return;
            }
            this.f10779e.a(g.c(this.f10775a, this.f10777c, null));
        }

        @Override // f4.c
        public void d(String str, f4.m mVar) {
            String strA = mVar.a();
            if (strA.equals("[DONE]")) {
                this.f10776b = true;
                this.f10779e.a(g.k(this.f10775a, this.f10777c));
                m.this.f10773b.close();
                m.this.f10773b = null;
                return;
            }
            if (strA.isEmpty()) {
                return;
            }
            try {
                d dVarA = d.a(strA);
                if (dVarA.c().isEmpty()) {
                    return;
                }
                e eVarB = ((n9.b) dVarA.c().get(0)).b();
                String strC = ((n9.b) dVarA.c().get(0)).c();
                if (strC != null && !strC.isEmpty()) {
                    this.f10777c = strC;
                }
                if (this.f10775a == null) {
                    e eVar = new e();
                    this.f10775a = eVar;
                    eVar.h(eVarB.d());
                }
                if (eVarB.b() != null) {
                    if (this.f10775a.b() == null) {
                        this.f10775a.f("");
                    }
                    this.f10775a.f(this.f10775a.b() + eVarB.b());
                }
                if (eVarB.c() != null) {
                    if (this.f10775a.c() == null) {
                        this.f10775a.g("");
                    }
                    this.f10775a.g(this.f10775a.c() + eVarB.c());
                }
                if (eVarB.e() != null) {
                    if (this.f10775a.e() == null) {
                        this.f10775a.j(new ArrayList());
                    }
                    List listE = this.f10775a.e();
                    for (i iVar : eVarB.e()) {
                        if (listE.size() <= iVar.d()) {
                            i iVar2 = new i();
                            iVar2.g(iVar.d());
                            iVar2.f("");
                            iVar2.h("function");
                            iVar2.e(new j("", ""));
                            listE.add(iVar2);
                        }
                        i iVar3 = (i) listE.get(iVar.d());
                        if (iVar.c() != null) {
                            iVar3.f(iVar3.c() + iVar.c());
                        }
                        if (iVar.b() != null) {
                            if (iVar.b().c() != null) {
                                iVar3.b().e(iVar3.b().c() + iVar.b().c());
                            }
                            if (iVar.b().b() != null) {
                                iVar3.b().d(iVar3.b().b() + iVar.b().b());
                            }
                        }
                    }
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f10778d > 50) {
                    this.f10778d = jCurrentTimeMillis;
                    this.f10779e.a(g.l(this.f10775a));
                }
            } catch (Exception e10) {
                tc.a.j(e10);
                if (m.this.f10773b == null) {
                    return;
                }
                this.f10776b = true;
                this.f10779e.a(g.c(this.f10775a, this.f10777c, e10));
                m.this.f10773b.close();
                m.this.f10773b = null;
            }
        }

        @Override // f4.c
        public void onError(Throwable th) {
            if (m.this.f10773b == null) {
                return;
            }
            this.f10776b = true;
            tc.a.j(th);
            this.f10779e.a(g.c(this.f10775a, this.f10777c, th));
            m.this.f10773b.close();
            m.this.f10773b = null;
        }

        @Override // f4.c
        public void a(String str) {
        }

        @Override // f4.c
        public void b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements f4.l {
        public b() {
        }

        @Override // f4.l
        public void d(String str) {
            tc.a.i(str, new Object[0]);
        }

        @Override // f4.l
        public void c(String str) {
        }

        @Override // f4.l
        public void b(String str, Object obj) {
        }

        @Override // f4.l
        public void a(String str, Object obj, Object obj2) {
        }
    }
}
