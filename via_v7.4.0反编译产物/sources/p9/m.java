package p9;

import com.launchdarkly.eventsource.ReadyState;
import com.launchdarkly.eventsource.UnsuccessfulResponseException;
import com.launchdarkly.eventsource.a;
import i6.i0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.u;
import okhttp3.w;
import okhttp3.x;
import okhttp3.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m {

    /* renamed from: d, reason: collision with root package name */
    public static final okhttp3.t f11042d = okhttp3.t.d("application/json; charset=utf-8");

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.u f11043a;

    /* renamed from: b, reason: collision with root package name */
    public com.launchdarkly.eventsource.a f11044b;

    /* renamed from: c, reason: collision with root package name */
    public e4.l f11045c = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements e4.c {

        /* renamed from: a, reason: collision with root package name */
        public e f11046a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11047b = false;

        /* renamed from: c, reason: collision with root package name */
        public String f11048c = null;

        /* renamed from: d, reason: collision with root package name */
        public long f11049d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h f11050e;

        public a(h hVar) {
            this.f11050e = hVar;
        }

        @Override // e4.c
        public void a(String str) {
        }

        @Override // e4.c
        public void b() {
        }

        @Override // e4.c
        public void c(String str, e4.m mVar) throws IOException {
            String strA = mVar.a();
            if (strA.equals("[DONE]")) {
                this.f11047b = true;
                this.f11050e.a(g.k(this.f11046a, this.f11048c));
                m.this.f11044b.close();
                m.this.f11044b = null;
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
                e eVarB = ((p9.b) dVarA.c().get(0)).b();
                String strC = ((p9.b) dVarA.c().get(0)).c();
                if (strC != null && !strC.isEmpty()) {
                    this.f11048c = strC;
                }
                if (this.f11046a == null) {
                    e eVar = new e();
                    this.f11046a = eVar;
                    eVar.h(eVarB.d());
                }
                if (eVarB.b() != null) {
                    if (this.f11046a.b() == null) {
                        this.f11046a.f("");
                    }
                    this.f11046a.f(this.f11046a.b() + eVarB.b());
                }
                if (eVarB.c() != null) {
                    if (this.f11046a.c() == null) {
                        this.f11046a.g("");
                    }
                    this.f11046a.g(this.f11046a.c() + eVarB.c());
                }
                if (eVarB.e() != null) {
                    if (this.f11046a.e() == null) {
                        this.f11046a.j(new ArrayList());
                    }
                    List listE = this.f11046a.e();
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
                if (jCurrentTimeMillis - this.f11049d > 50) {
                    this.f11049d = jCurrentTimeMillis;
                    this.f11050e.a(g.l(this.f11046a));
                }
            } catch (Exception e10) {
                pc.a.i(e10);
                if (m.this.f11044b == null) {
                    return;
                }
                this.f11047b = true;
                this.f11050e.a(g.c(this.f11046a, this.f11048c, e10));
                m.this.f11044b.close();
                m.this.f11044b = null;
            }
        }

        @Override // e4.c
        public void d() {
            if (this.f11047b) {
                return;
            }
            this.f11050e.a(g.c(this.f11046a, this.f11048c, null));
        }

        @Override // e4.c
        public void onError(Throwable th) throws IOException {
            if (m.this.f11044b == null) {
                return;
            }
            this.f11047b = true;
            pc.a.i(th);
            this.f11050e.a(g.c(this.f11046a, this.f11048c, th));
            m.this.f11044b.close();
            m.this.f11044b = null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements e4.l {
        public b() {
        }

        @Override // e4.l
        public void a(String str, Object obj, Object obj2) {
        }

        @Override // e4.l
        public void b(String str, Object obj) {
        }

        @Override // e4.l
        public void c(String str) {
        }

        @Override // e4.l
        public void d(String str) {
            pc.a.h(str, new Object[0]);
        }
    }

    public m() {
        u.b bVar = new u.b();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f11043a = bVar.c(30L, timeUnit).h(30L, timeUnit).l(60L, timeUnit).b();
    }

    public boolean c() throws IOException {
        com.launchdarkly.eventsource.a aVar = this.f11044b;
        if (aVar != null) {
            z = aVar.m() == ReadyState.CONNECTING;
            this.f11044b.close();
            this.f11044b = null;
        }
        return z;
    }

    public c d(l lVar, String str, List list) {
        return e(lVar, str, list, null);
    }

    public c e(l lVar, String str, List list, List list2) {
        if (i(lVar)) {
            throw new IllegalArgumentException("Invalid backend");
        }
        y yVarF = this.f11043a.v(g(lVar, str, list, false, list2)).f();
        try {
            if (yVarF.d() == 200 && yVarF.a() != null) {
                c cVarA = c.a(yVarF.a().j());
                yVarF.close();
                return cVarA;
            }
            throw new UnsuccessfulResponseException(yVarF.d(), yVarF.a() == null ? null : yVarF.a().j());
        } finally {
        }
    }

    public void f(l lVar, String str, List list, List list2, h hVar) throws IOException {
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
            pc.a.i(e10);
            strA = "";
        }
        return new w.a().j(str2).d("Authorization", "Bearer " + lVar.e()).g(x.d(f11042d, strA)).b();
    }

    public e4.l h() {
        e4.l lVar = this.f11045c;
        if (lVar != null) {
            return lVar;
        }
        b bVar = new b();
        this.f11045c = bVar;
        return bVar;
    }

    public final boolean i(l lVar) {
        if (lVar == null) {
            return true;
        }
        i0 i0Var = i0.f7006a;
        if ((!i0Var.s(lVar.i()) && !i0Var.l(lVar.i())) || lVar.e() == null || lVar.e().isEmpty()) {
            return true;
        }
        int length = lVar.e().length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = lVar.e().charAt(i10);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= '\u007f') {
                return true;
            }
        }
        return false;
    }

    public final void j(l lVar, String str, List list, List list2, h hVar) throws IOException {
        if (i(lVar)) {
            hVar.a(g.a(104, new IllegalArgumentException("Invalid backend")));
            return;
        }
        okhttp3.w wVarG = g(lVar, str, list, true, list2);
        com.launchdarkly.eventsource.a aVar = this.f11044b;
        if (aVar != null) {
            aVar.close();
        }
        com.launchdarkly.eventsource.a aVarR = new a.d(new a(hVar), wVarG.h()).q(wVarG.a()).v(wVarG.d()).x(wVarG.f()).s(this.f11043a).w(h()).r();
        this.f11044b = aVarR;
        aVarR.u();
    }
}
