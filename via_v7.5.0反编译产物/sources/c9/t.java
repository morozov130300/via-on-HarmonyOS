package c9;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.i0;
import com.tuyafeng.support.utils.FragmentUtils;
import hb.k1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import w7.a0;
import x8.c1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t extends j {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public g9.d f2347u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public u9.c f2348v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final androidx.activity.result.b f2349w0 = w2(new s5.e(), new androidx.activity.result.a() { // from class: c9.l
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            t tVar = this.f2334a;
            ((autodispose2.m) x8.b.c(tVar.G(), (Uri) obj, "logo", ".png").k(q6.b.b()).p(s8.b.a(tVar.b1()))).a(new u6.f() { // from class: c9.n
                @Override // u6.f
                public final void accept(Object obj2) {
                    t.Z2(tVar, (String) obj2);
                }
            }, new a0());
        }
    });

    public static /* synthetic */ void Z2(t tVar, String str) {
        tVar.f2325p0.l(1);
        tVar.f2325p0.B0("<img class=\"smaller\" src=\"file://" + str + "\" />");
        u9.n.e().u(true);
        tVar.f2347u0.k(80);
        tVar.f2347u0.n(80);
        tVar.f2347u0.m(100);
        tVar.Y2();
        tVar.f2324o0.j();
        tVar.f2324o0.u(tVar.f2347u0);
    }

    public static /* synthetic */ void b3(t tVar, AdapterView adapterView, View view, int i10, long j10) {
        tVar.getClass();
        if (i10 == 0) {
            tVar.k3();
            return;
        }
        if (i10 == 1) {
            try {
                tVar.f2349w0.a(null);
                return;
            } catch (ActivityNotFoundException e10) {
                tc.a.e(e10);
                return;
            }
        }
        if (i10 == 2) {
            tVar.i3(false);
            return;
        }
        if (i10 == 3) {
            tVar.l3();
            return;
        }
        if (i10 != 4) {
            return;
        }
        tVar.f2325p0.B0("<br>");
        tVar.f2325p0.l(4);
        tVar.Y2();
        u9.n.e().u(true);
        tVar.f2324o0.p();
    }

    public static /* synthetic */ void e3(final t tVar, FragmentManager fragmentManager, String str, Bundle bundle) {
        tVar.getClass();
        final String string = bundle.getString("text", null);
        if (string != null) {
            tVar.f2325p0.B0(string.isEmpty() ? "<br>" : string);
            tVar.f2325p0.l(3);
            tVar.Y2();
            u9.n.e().u(true);
            tVar.f2324o0.p();
            x8.h.b(new Runnable() { // from class: c9.q
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f2341c.f2348v0.d("KEY_LOGO_HTML", string);
                }
            });
        }
        fragmentManager.x("edit_text_result");
    }

    public static /* synthetic */ void f3(final t tVar, boolean z10, View view, q5.k.p pVar) {
        tVar.getClass();
        final String str = pVar.f11819c[0];
        if (str == null) {
            return;
        }
        if (z10 && !"<img class=\"smaller\" src=\"file:///android_asset/logo.svg\" />".contains(str)) {
            tVar.f2325p0.B0(str);
            tVar.f2325p0.l(3);
            tVar.Y2();
            x8.h.b(new Runnable() { // from class: c9.r
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f2343c.f2348v0.d("KEY_LOGO_HTML", str);
                }
            });
        } else if (!z10) {
            tVar.f2325p0.l(2);
            tVar.f2325p0.B0(str);
            tVar.Y2();
            x8.h.b(new Runnable() { // from class: c9.s
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f2345c.f2348v0.d("KEY_LOGO_TEXT", str);
                }
            });
        }
        u9.n.e().u(true);
        tVar.f2324o0.p();
    }

    public static List h3(Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("settings_search_section", w7.p.f13907s0);
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, b9.q.class, bundle, w7.u.Kc, w7.u.hd);
        hVar.c("custom.logo.1", 1, w7.u.hd, new String[0]);
        int iS1 = la.s.j().S1();
        if (iS1 == 2) {
            hVar.c("custom.logo.5", 5, w7.u.ed, new String[0]);
            hVar.c("custom.logo.6", 6, w7.u.X5, new String[0]);
        } else if (iS1 == 0 || iS1 == 1) {
            hVar.c("custom.logo.3", 3, w7.u.yi, new String[0]);
            hVar.c("custom.logo.2", 2, w7.u.f14169o6, new String[0]);
            hVar.c("custom.logo.4", 4, w7.u.R2, new String[0]);
        }
        return hVar.f();
    }

    @Override // c9.j
    public List T2() {
        int iS1 = this.f2325p0.S1();
        ArrayList arrayList = new ArrayList();
        arrayList.add(f9.a.f(1).d(X0(w7.u.hd)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.A0)).c(com.tuyafeng.support.utils.e.c(G(), w7.j.f13714e, this.f2325p0.S1())).a());
        if (iS1 == 0 || iS1 == 1) {
            arrayList.add(f9.a.e(3).g(X0(w7.u.yi)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.J1)).d(10, 127).c(this.f2347u0.e() == 0 ? 10 : this.f2347u0.e()).f("%dpx").e(10, X0(w7.u.f14177p0)).a());
            arrayList.add(f9.a.e(2).g(X0(w7.u.f14169o6)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13814n0)).d(10, 127).c(this.f2347u0.c() == 0 ? 10 : this.f2347u0.c()).f("%dpx").e(10, X0(w7.u.f14177p0)).a());
            arrayList.add(f9.a.e(4).g(X0(w7.u.R2)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.R0)).d(0, 100).c(this.f2347u0.d()).f("%d%%").e(-1, null).a());
            return arrayList;
        }
        if (iS1 != 2) {
            return arrayList;
        }
        arrayList.add(f9.a.e(5).g(X0(w7.u.ed)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13793g0)).d(10, 63).c(this.f2347u0.b()).f("%dpx").a());
        arrayList.add(f9.a.f(6).d(X0(w7.u.X5)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13799i0)).c((this.f2347u0.f() || this.f2347u0.g()) ? String.format(Locale.getDefault(), "%s %s", X0(w7.u.M1), X0(w7.u.f14280w7)).trim() : null).a());
        return arrayList;
    }

    @Override // c9.j
    public void U2(f9.a aVar, int i10) {
        String strTrim;
        super.U2(aVar, i10);
        switch (aVar.b()) {
            case 1:
                j3();
                break;
            case 2:
                f9.b bVar = (f9.b) aVar;
                this.f2347u0.k(bVar.j() != bVar.k() ? bVar.j() : 0);
                this.f2324o0.u(this.f2347u0);
                break;
            case 3:
                f9.b bVar2 = (f9.b) aVar;
                this.f2347u0.n(bVar2.j() != bVar2.k() ? bVar2.j() : 0);
                this.f2324o0.u(this.f2347u0);
                break;
            case 4:
                this.f2347u0.m(((f9.b) aVar).j());
                this.f2324o0.u(this.f2347u0);
                break;
            case 5:
                this.f2347u0.j(((f9.b) aVar).j());
                this.f2324o0.u(this.f2347u0);
                break;
            case 6:
                int i11 = (this.f2347u0.f() ? 1 : 0) + (this.f2347u0.g() ? 2 : 0) + 1;
                if (i11 > 3) {
                    i11 = 0;
                }
                this.f2347u0.h((i11 & 1) != 0);
                this.f2347u0.l((i11 & 2) != 0);
                this.f2324o0.u(this.f2347u0);
                if (this.f2347u0.f() || this.f2347u0.g()) {
                    strTrim = String.format(Locale.getDefault(), "%s %s", this.f2347u0.f() ? X0(w7.u.M1) : "", this.f2347u0.g() ? X0(w7.u.f14280w7) : "").trim();
                } else {
                    strTrim = null;
                }
                ((f9.c) aVar).h(strTrim);
                this.f2327r0.m(i10);
                break;
        }
    }

    public final void i3(final boolean z10) {
        int iS1 = this.f2325p0.S1();
        String strD0 = ((iS1 != 2 || z10) && !(z10 && iS1 == 3)) ? null : this.f2325p0.d0();
        if (strD0 == null || strD0.isEmpty()) {
            strD0 = this.f2348v0.b(z10 ? "KEY_LOGO_HTML" : "KEY_LOGO_TEXT", "");
        }
        q5.k.l(G()).f0(z10 ? w7.u.E6 : w7.u.Tf).g(0, strD0, "", 4).X(R.string.ok, new q5.k.m() { // from class: c9.o
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                t.f3(this.f2337a, z10, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void j3() {
        q5.k.l(G()).f0(w7.u.hd).b0(w7.j.f13714e, this.f2325p0.S1(), new AdapterView.OnItemClickListener() { // from class: c9.m
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                t.b3(this.f2335a, adapterView, view, i10, j10);
            }
        }).h0();
    }

    public final void k3() {
        this.f2325p0.l(0);
        this.f2325p0.B0(null);
        u9.n.e().u(true);
        this.f2347u0.k(72);
        this.f2347u0.n(0);
        this.f2347u0.m(0);
        Y2();
        this.f2324o0.u(this.f2347u0);
    }

    public final void l3() {
        final FragmentManager fragmentManagerL0 = K0() == null ? L0() : K0().L0();
        fragmentManagerL0.z1("edit_text_result", this, new i0() { // from class: c9.p
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                t.e3(this.f2339a, fragmentManagerL0, str, bundle);
            }
        });
        String strD0 = this.f2325p0.S1() == 3 ? this.f2325p0.d0() : null;
        if (strD0 == null || strD0.isEmpty()) {
            strD0 = this.f2348v0.b("KEY_LOGO_HTML", "");
        }
        FragmentUtils.j(K0(), k1.class, k1.g3(X0(w7.u.E6), strD0, X0(w7.u.E6), true));
    }

    @Override // c9.j, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f2348v0 = new u9.c(c1.E(G()));
        this.f2347u0 = this.f2324o0.n();
    }
}
