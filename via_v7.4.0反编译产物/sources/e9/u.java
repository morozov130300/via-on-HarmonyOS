package e9;

import android.R;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.i0;
import hb.i1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import w5.k;
import x7.c0;
import z8.c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class u extends k {

    /* renamed from: s0, reason: collision with root package name */
    public i9.d f4930s0;

    /* renamed from: t0, reason: collision with root package name */
    public w9.c f4931t0;

    /* renamed from: u0, reason: collision with root package name */
    public final androidx.activity.result.b f4932u0 = y2(new x5.e(), new androidx.activity.result.a() { // from class: e9.m
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            u uVar = this.f4917a;
            ((autodispose2.m) z8.b.c(uVar.I(), (Uri) obj, "logo", ".png").k(w6.b.b()).p(u8.b.a(uVar.d1()))).a(new a7.e() { // from class: e9.o
                @Override // a7.e
                public final void accept(Object obj2) {
                    u.b3(uVar, (String) obj2);
                }
            }, new c0());
        }
    });

    public static /* synthetic */ void b3(u uVar, String str) {
        uVar.f4908n0.k(1);
        uVar.f4908n0.z0("<img class=\"smaller\" src=\"file://" + str + "\" />");
        w9.n.e().w(true);
        uVar.f4930s0.k(80);
        uVar.f4930s0.n(80);
        uVar.f4930s0.m(100);
        uVar.a3();
        uVar.f4907m0.j();
        uVar.f4907m0.u(uVar.f4930s0);
    }

    public static /* synthetic */ void d3(u uVar, AdapterView adapterView, View view, int i10, long j10) {
        uVar.getClass();
        if (i10 == 0) {
            uVar.l3();
            return;
        }
        if (i10 == 1) {
            try {
                uVar.f4932u0.a(null);
                return;
            } catch (ActivityNotFoundException e10) {
                pc.a.d(e10);
                return;
            }
        }
        if (i10 == 2) {
            uVar.j3(false);
            return;
        }
        if (i10 == 3) {
            uVar.m3();
            return;
        }
        if (i10 != 4) {
            return;
        }
        uVar.f4908n0.z0("<br>");
        uVar.f4908n0.k(4);
        uVar.a3();
        w9.n.e().w(true);
        uVar.f4907m0.p();
    }

    public static /* synthetic */ void g3(final u uVar, FragmentManager fragmentManager, String str, Bundle bundle) {
        uVar.getClass();
        final String string = bundle.getString("text", null);
        if (string != null) {
            uVar.f4908n0.z0(string.isEmpty() ? "<br>" : string);
            uVar.f4908n0.k(3);
            uVar.a3();
            w9.n.e().w(true);
            uVar.f4907m0.p();
            z8.h.b(new Runnable() { // from class: e9.r
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f4924e.f4931t0.d("KEY_LOGO_HTML", string);
                }
            });
        }
        fragmentManager.x("edit_text_result");
    }

    public static /* synthetic */ void h3(final u uVar, boolean z10, View view, k.p pVar) {
        uVar.getClass();
        final String str = pVar.f13339c[0];
        if (str == null) {
            return;
        }
        if (z10 && !"<img class=\"smaller\" src=\"file:///android_asset/logo.svg\" />".contains(str)) {
            uVar.f4908n0.z0(str);
            uVar.f4908n0.k(3);
            uVar.a3();
            z8.h.b(new Runnable() { // from class: e9.s
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f4926e.f4931t0.d("KEY_LOGO_HTML", str);
                }
            });
        } else if (!z10) {
            uVar.f4908n0.k(2);
            uVar.f4908n0.z0(str);
            uVar.a3();
            z8.h.b(new Runnable() { // from class: e9.t
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f4928e.f4931t0.d("KEY_LOGO_TEXT", str);
                }
            });
        }
        w9.n.e().w(true);
        uVar.f4907m0.p();
    }

    @Override // e9.k
    public List V2() {
        int iR1 = this.f4908n0.R1();
        ArrayList arrayList = new ArrayList();
        arrayList.add(h9.a.f(1).d(Z0(x7.u.Sc)).b(g6.f.e(I(), x7.o.C0)).c(g6.e.c(I(), x7.j.f13648e, this.f4908n0.R1())).a());
        if (iR1 == 0 || iR1 == 1) {
            arrayList.add(h9.a.e(3).g(Z0(x7.u.Th)).b(g6.f.e(I(), x7.o.M1)).d(10, 127).c(this.f4930s0.e() == 0 ? 10 : this.f4930s0.e()).f("%dpx").e(10, Z0(x7.u.f14083n0)).a());
            arrayList.add(h9.a.e(2).g(Z0(x7.u.f13935c6)).b(g6.f.e(I(), x7.o.f13745m0)).d(10, 127).c(this.f4930s0.c() == 0 ? 10 : this.f4930s0.c()).f("%dpx").e(10, Z0(x7.u.f14083n0)).a());
            arrayList.add(h9.a.e(4).g(Z0(x7.u.F2)).b(g6.f.e(I(), x7.o.T0)).d(0, 100).c(this.f4930s0.d()).f("%d%%").e(-1, null).a());
            return arrayList;
        }
        if (iR1 != 2) {
            return arrayList;
        }
        arrayList.add(h9.a.e(5).g(Z0(x7.u.Pc)).b(g6.f.e(I(), x7.o.f13727g0)).d(10, 63).c(this.f4930s0.b()).f("%dpx").a());
        arrayList.add(h9.a.f(6).d(Z0(x7.u.L5)).b(g6.f.e(I(), x7.o.f13733i0)).c((this.f4930s0.f() || this.f4930s0.g()) ? String.format(Locale.getDefault(), "%s %s", Z0(x7.u.f14243z1), Z0(x7.u.f14048k7)).trim() : null).a());
        return arrayList;
    }

    @Override // e9.k
    public void W2(h9.a aVar, int i10) {
        String strTrim;
        super.W2(aVar, i10);
        switch (aVar.b()) {
            case 1:
                k3();
                break;
            case 2:
                h9.b bVar = (h9.b) aVar;
                this.f4930s0.k(bVar.j() != bVar.k() ? bVar.j() : 0);
                this.f4907m0.u(this.f4930s0);
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                h9.b bVar2 = (h9.b) aVar;
                this.f4930s0.n(bVar2.j() != bVar2.k() ? bVar2.j() : 0);
                this.f4907m0.u(this.f4930s0);
                break;
            case 4:
                this.f4930s0.m(((h9.b) aVar).j());
                this.f4907m0.u(this.f4930s0);
                break;
            case 5:
                this.f4930s0.j(((h9.b) aVar).j());
                this.f4907m0.u(this.f4930s0);
                break;
            case 6:
                int i11 = (this.f4930s0.f() ? 1 : 0) + (this.f4930s0.g() ? 2 : 0) + 1;
                if (i11 > 3) {
                    i11 = 0;
                }
                this.f4930s0.h((i11 & 1) != 0);
                this.f4930s0.l((i11 & 2) != 0);
                this.f4907m0.u(this.f4930s0);
                if (this.f4930s0.f() || this.f4930s0.g()) {
                    strTrim = String.format(Locale.getDefault(), "%s %s", this.f4930s0.f() ? Z0(x7.u.f14243z1) : "", this.f4930s0.g() ? Z0(x7.u.f14048k7) : "").trim();
                } else {
                    strTrim = null;
                }
                ((h9.c) aVar).h(strTrim);
                this.f4910p0.m(i10);
                break;
        }
    }

    public final void j3(final boolean z10) {
        int iR1 = this.f4908n0.R1();
        String strA0 = ((iR1 != 2 || z10) && !(z10 && iR1 == 3)) ? null : this.f4908n0.a0();
        if (strA0 == null || strA0.isEmpty()) {
            strA0 = this.f4931t0.b(z10 ? "KEY_LOGO_HTML" : "KEY_LOGO_TEXT", "");
        }
        w5.k.l(I()).d0(z10 ? x7.u.f14157s6 : x7.u.Df).g(0, strA0, "", 4).V(R.string.ok, new k.m() { // from class: e9.p
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                u.h3(this.f4920a, z10, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void k3() {
        w5.k.l(I()).d0(x7.u.Sc).Z(x7.j.f13648e, this.f4908n0.R1(), new AdapterView.OnItemClickListener() { // from class: e9.n
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                u.d3(this.f4918a, adapterView, view, i10, j10);
            }
        }).f0();
    }

    public final void l3() {
        this.f4908n0.k(0);
        this.f4908n0.z0(null);
        w9.n.e().w(true);
        this.f4930s0.k(72);
        this.f4930s0.n(0);
        this.f4930s0.m(0);
        a3();
        this.f4907m0.u(this.f4930s0);
    }

    public final void m3() {
        final FragmentManager fragmentManagerN0 = M0() == null ? N0() : M0().N0();
        fragmentManagerN0.y1("edit_text_result", this, new i0() { // from class: e9.q
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                u.g3(this.f4922a, fragmentManagerN0, str, bundle);
            }
        });
        String strA0 = this.f4908n0.R1() == 3 ? this.f4908n0.a0() : null;
        if (strA0 == null || strA0.isEmpty()) {
            strA0 = this.f4931t0.b("KEY_LOGO_HTML", "");
        }
        g6.i.h(M0(), i1.class, i1.g3(Z0(x7.u.f14157s6), strA0, Z0(x7.u.f14157s6), true));
    }

    @Override // e9.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f4931t0 = new w9.c(c1.E(I()));
        this.f4930s0 = this.f4907m0.n();
    }
}
