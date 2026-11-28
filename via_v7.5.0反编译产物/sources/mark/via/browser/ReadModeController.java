package mark.via.browser;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.tuyafeng.support.utils.FragmentUtils;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ReadModeController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f8983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f8984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x.h f8985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f8986d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(int i10, boolean z10);

        void b(boolean z10);
    }

    public ReadModeController(Fragment fragment, u9.l lVar, x.h hVar, a aVar) {
        this.f8983a = fragment;
        this.f8984b = lVar;
        this.f8985c = hVar;
        this.f8986d = aVar;
    }

    public static /* synthetic */ d7.h a(ReadModeController readModeController, WebView webView, String str, androidx.lifecycle.j jVar, i8.o oVar, Integer num) {
        if (!readModeController.v(webView, str, jVar)) {
            return null;
        }
        oVar.a(Integer.valueOf(num == null ? 0 : num.intValue()));
        return null;
    }

    public static /* synthetic */ void b(ReadModeController readModeController, C1Cleanup c1Cleanup, String str, Bundle bundle) {
        readModeController.getClass();
        String string = bundle.getString("text", null);
        if (string != null) {
            readModeController.f8984b.l2(string);
            readModeController.k();
        }
        c1Cleanup.l();
    }

    public static /* synthetic */ d7.h c(ReadModeController readModeController, t4.b bVar, String str, androidx.lifecycle.j jVar, Integer num) {
        if (readModeController.v(bVar, str, jVar)) {
            int iIntValue = num == null ? 4 : num.intValue();
            if (iIntValue == 0) {
                readModeController.l(bVar);
                com.tuyafeng.support.utils.n.q(readModeController.f8983a.G(), w7.u.Ya);
                readModeController.f8986d.b(false);
                return null;
            }
            if (iIntValue == 3) {
                com.tuyafeng.support.utils.n.q(readModeController.f8983a.G(), w7.u.Vf);
                return null;
            }
            if (iIntValue == 1) {
                com.tuyafeng.support.utils.n.q(readModeController.f8983a.G(), w7.u.f13969a2);
                return null;
            }
            if (iIntValue == 4) {
                com.tuyafeng.support.utils.n.q(readModeController.f8983a.G(), w7.u.Z1);
            }
        }
        return null;
    }

    public static /* synthetic */ void d(ReadModeController readModeController, t4.b bVar, Integer num) {
        readModeController.getClass();
        if (num.intValue() == 3) {
            readModeController.l(bVar);
        }
    }

    public static /* synthetic */ d7.h e(ReadModeController readModeController, t4.b bVar, String str, androidx.lifecycle.j jVar, Integer num) {
        if (readModeController.v(bVar, str, jVar)) {
            int iIntValue = num == null ? 2 : num.intValue();
            if (iIntValue == 0) {
                b8.g.c().e(str);
                bVar.setAccentColor(-1);
                readModeController.f8986d.a(-1, false);
                com.tuyafeng.support.utils.n.q(readModeController.f8983a.G(), w7.u.Xa);
                return null;
            }
            if (iIntValue == 1) {
                com.tuyafeng.support.utils.n.q(readModeController.f8983a.G(), w7.u.f13969a2);
            }
        }
        return null;
    }

    public static /* synthetic */ void f(final ReadModeController readModeController, final t4.b bVar, String str, androidx.lifecycle.j jVar) {
        if (readModeController.v(bVar, str, jVar)) {
            readModeController.n(bVar, new i8.o() { // from class: mark.via.browser.mc
                @Override // i8.o
                public final void a(Object obj) {
                    ReadModeController.d(this.f9356a, bVar, (Integer) obj);
                }
            });
        }
    }

    public static /* synthetic */ d7.h g(ReadModeController readModeController, WebView webView, String str, androidx.lifecycle.j jVar, Boolean bool) {
        readModeController.getClass();
        if (!bool.booleanValue() || !readModeController.v(webView, str, jVar)) {
            return null;
        }
        readModeController.m(webView);
        return null;
    }

    public static /* synthetic */ void h(ReadModeController readModeController, t4.b bVar, Integer num) {
        readModeController.getClass();
        if (num.intValue() == 3) {
            readModeController.q(bVar);
        } else {
            readModeController.t(bVar);
        }
    }

    public static /* synthetic */ void i(ReadModeController readModeController, WebView webView, Integer num) {
        readModeController.getClass();
        if (num.intValue() == 1) {
            readModeController.f8986d.b(true);
        } else if (num.intValue() == 5) {
            readModeController.t((t4.b) webView);
        }
    }

    public void k() {
        t4.b bVar = (t4.b) this.f8985c.get();
        if (bVar != null && v(bVar, bVar.getUrl(), (androidx.lifecycle.j) this.f8983a.c1().e())) {
            l(bVar);
        }
    }

    public final void l(t4.b bVar) {
        int iMin = Math.min(84, Math.max(8, this.f8984b.a2()));
        int iC2 = this.f8984b.c2();
        if (iC2 == 0) {
            iC2 = -1;
        }
        c6.g1.f2009a.e(new c6.f(bVar), iC2, iMin, this.f8984b.A0());
        b8.g.c().f(bVar.getUrl(), iC2);
        bVar.setAccentColor(iC2);
        this.f8986d.a(iC2, true);
    }

    public void m(final WebView webView) {
        n(webView, new i8.o() { // from class: mark.via.browser.qc
            @Override // i8.o
            public final void a(Object obj) {
                ReadModeController.i(this.f9579a, webView, (Integer) obj);
            }
        });
    }

    public final void n(final WebView webView, final i8.o oVar) {
        if (oVar == null || webView == null || !webView.isShown()) {
            return;
        }
        final String url = webView.getUrl();
        final androidx.lifecycle.j jVar = (androidx.lifecycle.j) this.f8983a.c1().e();
        if (v(webView, url, jVar)) {
            c6.g1.f2009a.f(new c6.f(webView), new p7.l() { // from class: mark.via.browser.lc
                @Override // p7.l
                public final Object invoke(Object obj) {
                    return ReadModeController.a(this.f9322c, webView, url, jVar, oVar, (Integer) obj);
                }
            });
        }
    }

    public void o(i8.o oVar) {
        n((WebView) this.f8985c.get(), oVar);
    }

    public void p() {
        q((t4.b) this.f8985c.get());
    }

    public final void q(final t4.b bVar) {
        if (bVar == null) {
            return;
        }
        final String url = bVar.getUrl();
        final androidx.lifecycle.j jVar = (androidx.lifecycle.j) this.f8983a.c1().e();
        if (v(bVar, url, jVar)) {
            c6.g1.f2009a.h(new c6.f(bVar), new p7.l() { // from class: mark.via.browser.nc
                @Override // p7.l
                public final Object invoke(Object obj) {
                    return ReadModeController.e(this.f9376c, bVar, url, jVar, (Integer) obj);
                }
            });
        }
    }

    public void r() {
        if (FragmentUtils.e(this.f8983a)) {
            return;
        }
        FragmentManager fragmentManagerL0 = this.f8983a.L0();
        final C1Cleanup c1Cleanup = new C1Cleanup(fragmentManagerL0);
        this.f8983a.h0().a(c1Cleanup);
        fragmentManagerL0.m(c1Cleanup);
        fragmentManagerL0.z1("edit_text_result", this.f8983a, new androidx.fragment.app.i0() { // from class: mark.via.browser.oc
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                ReadModeController.b(this.f9400a, c1Cleanup, str, bundle);
            }
        });
        Fragment fragment = this.f8983a;
        FragmentUtils.j(fragment, hb.k1.class, hb.k1.g3(fragment.X0(w7.u.Z2), this.f8984b.A0(), this.f8983a.X0(w7.u.Z2), true));
    }

    public void s() {
        t((t4.b) this.f8985c.get());
    }

    public final void t(final t4.b bVar) {
        if (bVar == null) {
            return;
        }
        final String url = bVar.getUrl();
        final androidx.lifecycle.j jVar = (androidx.lifecycle.j) this.f8983a.c1().e();
        if (v(bVar, url, jVar)) {
            if (p9.a.a().q(url)) {
                com.tuyafeng.support.utils.n.q(this.f8983a.G(), w7.u.f13983b2);
            } else {
                c6.g1.f2009a.i(new c6.f(bVar), new p7.l() { // from class: mark.via.browser.jc
                    @Override // p7.l
                    public final Object invoke(Object obj) {
                        return ReadModeController.c(this.f9267c, bVar, url, jVar, (Integer) obj);
                    }
                });
            }
        }
    }

    public void u(final WebView webView) {
        final String url = webView.getUrl();
        final androidx.lifecycle.j jVar = (androidx.lifecycle.j) this.f8983a.c1().e();
        c6.g1.f2009a.o(new c6.f(webView), new p7.l() { // from class: mark.via.browser.pc
            @Override // p7.l
            public final Object invoke(Object obj) {
                return ReadModeController.g(this.f9448c, webView, url, jVar, (Boolean) obj);
            }
        });
    }

    public final boolean v(WebView webView, String str, androidx.lifecycle.j jVar) {
        return jVar != null && jVar.h0().b() != Lifecycle.State.DESTROYED && webView == this.f8985c.get() && TextUtils.equals(str, webView.getUrl());
    }

    public void w() {
        if (u9.n.e().l()) {
            u9.n.e().v(false);
            final t4.b bVar = (t4.b) this.f8985c.get();
            if (bVar == null) {
                return;
            }
            final String url = bVar.getUrl();
            final androidx.lifecycle.j jVar = (androidx.lifecycle.j) this.f8983a.c1().e();
            if (v(bVar, url, jVar)) {
                bVar.post(new Runnable() { // from class: mark.via.browser.ic
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadModeController.f(this.f9239c, bVar, url, jVar);
                    }
                });
            }
        }
    }

    public void x() {
        final t4.b bVar = (t4.b) this.f8985c.get();
        n(bVar, new i8.o() { // from class: mark.via.browser.kc
            @Override // i8.o
            public final void a(Object obj) {
                ReadModeController.h(this.f9287a, bVar, (Integer) obj);
            }
        });
    }

    /* JADX INFO: renamed from: mark.via.browser.ReadModeController$1Cleanup, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C1Cleanup implements FragmentManager.m, androidx.lifecycle.h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f8987c;

        public C1Cleanup(FragmentManager fragmentManager) {
            this.f8987c = fragmentManager;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void a(androidx.activity.b bVar) {
            androidx.fragment.app.e0.c(this, bVar);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public void d(Fragment fragment, boolean z10) {
            if (z10 && (fragment instanceof hb.k1)) {
                l();
            }
        }

        @Override // androidx.lifecycle.h
        public void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                l();
            }
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void h(Fragment fragment, boolean z10) {
            androidx.fragment.app.e0.d(this, fragment, z10);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public /* synthetic */ void k() {
            androidx.fragment.app.e0.a(this);
        }

        public void l() {
            this.f8987c.x("edit_text_result");
            this.f8987c.p1(this);
            ReadModeController.this.f8983a.h0().c(this);
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public void onBackStackChanged() {
        }
    }
}
