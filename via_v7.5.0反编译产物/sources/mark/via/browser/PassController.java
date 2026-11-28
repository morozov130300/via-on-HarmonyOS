package mark.via.browser;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.webkit.JavaScriptExecutionException;
import com.tuyafeng.support.utils.FragmentUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class PassController implements androidx.lifecycle.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f8955c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x.h f8956e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final wa.a f8957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public mark.via.common.widget.f f8958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f8959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public q9.b f8960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f8961q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f8962r;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements mark.via.common.widget.f.e {
        public a() {
        }

        @Override // mark.via.common.widget.f.e
        public void a(t9.f fVar) {
            PassController.this.D(fVar);
        }

        @Override // mark.via.common.widget.f.e
        public void b() {
            PassController.this.M();
        }

        @Override // mark.via.common.widget.f.e
        public void c() {
            FragmentUtils.i(PassController.this.f8955c, va.e1.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends wa.s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f8964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t9.f f8965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WeakReference f8966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f8967e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ long f8968f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ q9.b f8969g;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements r0.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f8971a;

            public a(long j10) {
                this.f8971a = j10;
            }

            @Override // r0.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(JavaScriptExecutionException javaScriptExecutionException) {
                if (this.f8971a == PassController.this.f8962r) {
                    PassController.this.C();
                }
            }

            @Override // r0.m
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onResult(String str) {
                if ("0".equals(str) && this.f8971a == PassController.this.f8962r) {
                    PassController.this.C();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, long j10, t9.f fVar, WeakReference weakReference, String str, long j11, q9.b bVar) {
            super(context);
            this.f8964b = j10;
            this.f8965c = fVar;
            this.f8966d = weakReference;
            this.f8967e = str;
            this.f8968f = j11;
            this.f8969g = bVar;
        }

        public static /* synthetic */ void b(b bVar, t9.f fVar, String str) {
            bVar.getClass();
            if (!"0".equals(str) || PassController.this.f8958n == null) {
                return;
            }
            PassController.this.f8958n.setPassDetail(fVar);
        }

        public static /* synthetic */ void c(final b bVar, WeakReference weakReference, long j10, String str, long j11, q9.b bVar2, final t9.f fVar) {
            bVar.getClass();
            WebView webView = (WebView) weakReference.get();
            if (webView != null && webView == PassController.this.f8956e.get() && j10 == PassController.this.f8962r && TextUtils.equals(str, webView.getUrl())) {
                String strA = c6.t0.f2104a.a(com.tuyafeng.support.utils.p.m(fVar.h()), com.tuyafeng.support.utils.p.m(fVar.e()), j11);
                if (bVar2 != null) {
                    bVar2.c(strA, bVar.new a(j10));
                } else {
                    webView.evaluateJavascript(strA, new ValueCallback() { // from class: mark.via.browser.qb
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(Object obj) {
                            PassController.b.b(this.f9577a, fVar, (String) obj);
                        }
                    });
                }
            }
        }

        public static /* synthetic */ t9.f d(t9.f fVar) {
            t9.f fVarF = la.s.i().f(fVar.b());
            if (fVarF == null) {
                return null;
            }
            if (fVarF.h() == null && fVarF.e() == null) {
                return null;
            }
            return fVarF;
        }

        @Override // wa.b
        public void onSuccess() {
            if (PassController.this.f8955c.a1() == null || this.f8964b != PassController.this.f8962r) {
                return;
            }
            final t9.f fVar = this.f8965c;
            autodispose2.m mVar = (autodispose2.m) r6.f.h(new Callable() { // from class: mark.via.browser.ob
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return PassController.b.d(fVar);
                }
            }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(PassController.this.f8955c.b1()));
            final WeakReference weakReference = this.f8966d;
            final long j10 = this.f8964b;
            final String str = this.f8967e;
            final long j11 = this.f8968f;
            final q9.b bVar = this.f8969g;
            mVar.a(new u6.f() { // from class: mark.via.browser.pb
                @Override // u6.f
                public final void accept(Object obj) {
                    PassController.b.c(this.f9442c, weakReference, j10, str, j11, bVar, (t9.f) obj);
                }
            }, new w7.e0());
        }
    }

    public PassController(Fragment fragment, x.h hVar) {
        this.f8955c = fragment;
        this.f8956e = hVar;
        this.f8957m = new wa.r(fragment);
        FragmentUtils.f(fragment, this);
    }

    public static /* synthetic */ void a(final PassController passController, final String str, String str2, final String str3, s5.a aVar) {
        passController.getClass();
        if (!aVar.d()) {
            passController.A(str, str2, str3);
        } else {
            if (str3.equals(((t9.f) aVar.b()).e())) {
                return;
            }
            final t9.f fVar = (t9.f) aVar.b();
            q5.k.l(passController.f8955c.G()).f0(w7.u.Eh).K(passController.f8955c.Y0(w7.u.Fh, c6.a2.f1958a.f(str))).X(R.string.ok, new q5.k.m() { // from class: mark.via.browser.jb
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    PassController.k(this.f9263a, fVar, str3, str, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        }
    }

    public static /* synthetic */ s5.a d(String str, String str2) {
        t9.g gVarI = la.s.i();
        String strM = gVarI.m(c6.a2.f1958a.f(str), str2);
        return s5.a.f(strM == null ? null : gVarI.f(strM));
    }

    public static /* synthetic */ void h(PassController passController, long j10, String str, Bundle bundle) {
        t9.f fVarH;
        passController.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null && j10 == passController.f8962r && (fVarH = la.s.i().h(string)) != null) {
            passController.D(fVarH);
        }
        passController.f8955c.x0().x("passresult");
    }

    public static /* synthetic */ void k(final PassController passController, final t9.f fVar, String str, String str2, View view, q5.k.p pVar) {
        passController.getClass();
        fVar.m(str);
        fVar.o(str2);
        fVar.n(System.currentTimeMillis());
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.mb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                t9.f fVar2 = fVar;
                return Boolean.valueOf(la.s.i().k(fVar2.b(), fVar2));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(passController.f8955c.b1()))).a(new u6.f() { // from class: mark.via.browser.nb
            @Override // u6.f
            public final void accept(Object obj) {
                PassController.m(this.f9375c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public static /* synthetic */ void m(PassController passController, Boolean bool) {
        passController.getClass();
        if (bool.booleanValue()) {
            com.tuyafeng.support.utils.n.q(passController.f8955c.i0(), w7.u.f14283wa);
        }
    }

    public static /* synthetic */ void o(PassController passController, Boolean bool) {
        passController.getClass();
        if (bool.booleanValue()) {
            com.tuyafeng.support.utils.n.q(passController.f8955c.i0(), w7.u.f14270va);
        }
    }

    public static /* synthetic */ void r(final PassController passController, final String str, String str2, String str3, AdapterView adapterView, View view, int i10, long j10) {
        passController.getClass();
        if (i10 == 1) {
            a7.a.c().d(new Runnable() { // from class: mark.via.browser.cb
                @Override // java.lang.Runnable
                public final void run() {
                    la.s.i().c(str, false);
                }
            });
            return;
        }
        if (i10 == 2) {
            return;
        }
        final t9.f fVar = new t9.f();
        fVar.j(UUID.randomUUID().toString().toLowerCase(Locale.ROOT));
        fVar.k(c6.a2.f1958a.f(str));
        fVar.o(str);
        fVar.p(str2);
        fVar.m(str3);
        fVar.i(System.currentTimeMillis());
        fVar.n(fVar.a());
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.db
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(la.s.i().b(fVar));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(passController.f8955c.b1()))).a(new u6.f() { // from class: mark.via.browser.eb
            @Override // u6.f
            public final void accept(Object obj) {
                PassController.o(this.f9117c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public static /* synthetic */ s5.a s(String str) {
        t9.g gVarI = la.s.i();
        return s5.a.f(!gVarI.j() ? gVarI.e(str) : null);
    }

    public static /* synthetic */ void t(PassController passController, long j10, mark.via.common.widget.f fVar, long j11, String str, s5.a aVar) {
        if (j10 == passController.f8959o && passController.f8958n == fVar && j11 == passController.f8962r) {
            q9.b bVar = passController.f8960p;
            if (TextUtils.equals(str, bVar != null ? bVar.f9564c.toString() : passController.E())) {
                if (aVar.d()) {
                    fVar.setPassList((List) aVar.c());
                }
                passController.K(fVar, aVar.d());
            }
        }
    }

    public final void A(final String str, final String str2, final String str3) {
        q5.k.l(this.f8955c.i0()).g0(this.f8955c.Y0(w7.u.Nb, c6.a2.f1958a.f(str))).w(true).C(com.tuyafeng.support.utils.x.h(this.f8955c.G(), 268.0f)).A(new String[]{this.f8955c.X0(w7.u.Mb), this.f8955c.X0(w7.u.R8), this.f8955c.X0(R.string.cancel)}, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.lb
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                PassController.r(this.f9318a, str, str2, str3, adapterView, view, i10, j10);
            }
        }).h0();
    }

    public void B(final String str, final String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !la.s.i().o(str)) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.fb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PassController.d(str, str2);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f8955c.b1()))).a(new u6.f() { // from class: mark.via.browser.gb
            @Override // u6.f
            public final void accept(Object obj) {
                PassController.a(this.f9170c, str, str2, str3, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public void C() {
        this.f8962r++;
        this.f8960p = null;
        this.f8961q = 0L;
        this.f8959o++;
        mark.via.common.widget.f fVar = this.f8958n;
        if (fVar != null) {
            y.r.c(fVar).i(null).b();
            this.f8958n.setVisibility(8);
            this.f8958n.setPassList(Collections.EMPTY_LIST);
        }
    }

    public final void D(t9.f fVar) {
        t4.b bVar = (t4.b) this.f8956e.get();
        if (bVar == null) {
            return;
        }
        WeakReference weakReference = new WeakReference(bVar);
        q9.b bVar2 = this.f8960p;
        long j10 = this.f8961q;
        long j11 = this.f8962r;
        String url = bVar.getUrl();
        if (q9.s() && bVar2 == null) {
            return;
        }
        this.f8957m.a(this.f8955c.X0(w7.u.K5), this.f8955c.X0(w7.u.yh), new b(this.f8955c.G(), j11, fVar, weakReference, url, j10, bVar2));
    }

    public final String E() {
        t4.b bVar = (t4.b) this.f8956e.get();
        if (bVar == null) {
            return null;
        }
        return bVar.getUrl();
    }

    public void F(ViewGroup viewGroup, View view) {
        if (this.f8958n != null) {
            return;
        }
        mark.via.common.widget.f fVar = (mark.via.common.widget.f) new b6.a(new mark.via.common.widget.f(this.f8955c.G()), new RelativeLayout.LayoutParams(-1, com.tuyafeng.support.utils.x.h(this.f8955c.G(), 40.0f))).g(128, w7.p.B).f(com.tuyafeng.support.utils.e.a(this.f8955c.G(), w7.k.f13724d)).c(true).l();
        this.f8958n = fVar;
        fVar.setVisibility(8);
        this.f8958n.setCallback(new a());
        viewGroup.addView(this.f8958n, Math.max(viewGroup.indexOfChild(view), 0) + 1);
    }

    public void G(JSONObject jSONObject, q9.b bVar) {
        long jOptLong = jSONObject.optLong("form");
        int iOptInt = jSONObject.optInt("action");
        if (iOptInt != 109) {
            if (iOptInt == 110) {
                String strOptString = jSONObject.optString("url");
                if (q9.r(strOptString, bVar.f9564c.toString())) {
                    B(strOptString, jSONObject.optString("user"), jSONObject.optString("pass"));
                    return;
                }
                return;
            }
            return;
        }
        if (jSONObject.optInt("show") > 0 && jOptLong > 0) {
            if (this.f8960p != bVar || this.f8961q != jOptLong) {
                C();
                this.f8960p = bVar;
                this.f8961q = jOptLong;
            }
            N(true);
            return;
        }
        if (this.f8960p == bVar && this.f8961q == jOptLong) {
            if (jSONObject.optBoolean("retired")) {
                C();
            } else {
                N(false);
            }
        }
    }

    public void H(ViewGroup viewGroup, View view) {
        if (this.f8958n == null) {
            return;
        }
        J();
        F(viewGroup, view);
    }

    public void I(q9.b bVar) {
        if (this.f8960p == bVar) {
            C();
        }
    }

    public final void J() {
        mark.via.common.widget.f fVar = this.f8958n;
        if (fVar != null) {
            y.r.c(fVar).i(null).b();
            ViewParent parent = this.f8958n.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f8958n);
            }
            this.f8958n = null;
        }
    }

    public final void K(final mark.via.common.widget.f fVar, boolean z10) {
        y.r.c(fVar).i(null).b();
        if (fVar.getVisibility() != 0) {
            if (!z10) {
                return;
            }
            fVar.setAlpha(0.0f);
            fVar.setVisibility(0);
        }
        y.r.c(fVar).a(z10 ? 1.0f : 0.0f).i(z10 ? null : new Runnable() { // from class: mark.via.browser.kb
            @Override // java.lang.Runnable
            public final void run() {
                fVar.setVisibility(8);
            }
        }).d(150L).f();
    }

    public void L(float f10) {
        mark.via.common.widget.f fVar = this.f8958n;
        if (fVar != null) {
            if (f10 == 0.0f || fVar.getVisibility() == 0) {
                this.f8958n.setTranslationY(f10);
            }
        }
    }

    public final void M() {
        final long j10 = this.f8962r;
        this.f8955c.x0().z1("passresult", this.f8955c, new androidx.fragment.app.i0() { // from class: mark.via.browser.bb
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                PassController.h(this.f9036a, j10, str, bundle);
            }
        });
        c6.a2 a2Var = c6.a2.f1958a;
        q9.b bVar = this.f8960p;
        va.d0.x3(a2Var.f(bVar != null ? bVar.f9564c.toString() : E())).g3(this.f8955c.x0(), va.d0.class.getSimpleName());
    }

    public void N(boolean z10) {
        final long j10 = this.f8959o + 1;
        this.f8959o = j10;
        final mark.via.common.widget.f fVar = this.f8958n;
        if (fVar == null) {
            return;
        }
        if (!z10) {
            K(fVar, false);
            return;
        }
        q9.b bVar = this.f8960p;
        final String string = bVar != null ? bVar.f9564c.toString() : E();
        final long j11 = this.f8962r;
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.hb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PassController.s(string);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this.f8955c.b1()))).a(new u6.f() { // from class: mark.via.browser.ib
            @Override // u6.f
            public final void accept(Object obj) {
                PassController.t(this.f9234c, j10, fVar, j11, string, (s5.a) obj);
            }
        }, new w7.e0());
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void b(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.c(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void c(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.a(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void f(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.b(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void g(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.e(this, jVar);
    }

    @Override // androidx.lifecycle.d
    public void i(androidx.lifecycle.j jVar) {
        C();
        this.f8955c.x0().x("passresult");
        J();
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void j(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.d(this, jVar);
    }
}
