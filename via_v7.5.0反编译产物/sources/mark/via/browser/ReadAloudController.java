package mark.via.browser;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.utils.FragmentUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class ReadAloudController implements androidx.lifecycle.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f8973c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u9.l f8974e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h8.d f8975m = new h8.d() { // from class: mark.via.browser.fc
        @Override // h8.d
        public final void a(h8.t tVar) {
            this.f9146c.s(false);
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h8.q f8976n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f8977o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f8978p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public mark.via.common.widget.k1 f8979q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ab f8980r;

    public ReadAloudController(final Fragment fragment, u9.l lVar) {
        this.f8973c = fragment;
        this.f8974e = lVar;
        FragmentUtils.f(fragment, this);
        fragment.h0().a(new androidx.lifecycle.d() { // from class: mark.via.browser.ReadAloudController.1
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
                if (ReadAloudController.this.f8977o != null) {
                    h8.e.d(fragment.G());
                }
            }

            @Override // androidx.lifecycle.d
            public /* synthetic */ void j(androidx.lifecycle.j jVar) {
                androidx.lifecycle.c.d(this, jVar);
            }
        });
    }

    public static /* synthetic */ void k(final ReadAloudController readAloudController, ab abVar, String str, String str2, String str3, String str4) {
        if (readAloudController.f8980r != abVar) {
            return;
        }
        readAloudController.f8980r = null;
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() >= 2) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    arrayList.add(jSONArray.optString(i10));
                }
            } catch (JSONException e10) {
                tc.a.b(e10);
            }
        }
        List listA = c6.a1.f1956a.a(arrayList);
        if (listA.isEmpty()) {
            com.tuyafeng.support.utils.n.q(readAloudController.f8973c.G(), w7.u.Y1);
            return;
        }
        String strC = readAloudController.f8976n.c(new h8.t(str2, str3, str4, listA, 0));
        if (strC != null) {
            readAloudController.f8977o = strC;
            h8.e.b(readAloudController.f8973c.G(), strC);
            com.tuyafeng.support.utils.n.r(readAloudController.f8973c.G(), w7.u.yd, w7.u.oi, new View.OnClickListener() { // from class: mark.via.browser.hc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f9207a.u();
                }
            });
            readAloudController.s(false);
        }
    }

    public static /* synthetic */ void l(ReadAloudController readAloudController, mark.via.common.widget.k1 k1Var) {
        if (readAloudController.f8979q == k1Var) {
            readAloudController.t();
        }
    }

    public static /* synthetic */ void m(ReadAloudController readAloudController, int i10) {
        if (i10 == 1) {
            h8.e.b(readAloudController.f8973c.G(), readAloudController.f8977o);
            return;
        }
        if (i10 == 2) {
            h8.e.a(readAloudController.f8973c.G(), readAloudController.f8977o);
            return;
        }
        if (i10 == 3) {
            h8.e.d(readAloudController.f8973c.G());
            readAloudController.f8977o = null;
            readAloudController.s(false);
        } else if (i10 != 4) {
            readAloudController.getClass();
        } else {
            readAloudController.u();
        }
    }

    @Override // androidx.lifecycle.d
    public void b(androidx.lifecycle.j jVar) {
        s(false);
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
        q();
    }

    @Override // androidx.lifecycle.d
    public /* synthetic */ void j(androidx.lifecycle.j jVar) {
        androidx.lifecycle.c.d(this, jVar);
    }

    public void o(ViewGroup viewGroup) {
        if (this.f8978p == viewGroup) {
            return;
        }
        q();
        this.f8978p = viewGroup;
        h8.q qVar = this.f8976n;
        if (qVar != null) {
            qVar.g(this.f8975m);
        }
    }

    public void p(WebView webView) {
        ab abVar = this.f8980r;
        if (abVar != null) {
            if (webView == null || abVar.f9009a == webView) {
                abVar.d();
                this.f8980r = null;
            }
        }
    }

    public final void q() {
        h8.q qVar;
        p(null);
        if (this.f8978p != null && (qVar = this.f8976n) != null) {
            qVar.e(this.f8975m);
        }
        this.f8978p = null;
        t();
    }

    public void r(WebView webView) {
        if (this.f8978p == null) {
            return;
        }
        p(null);
        if (this.f8976n == null) {
            h8.c cVarN = h8.c.n(this.f8973c.G());
            this.f8976n = cVarN;
            cVarN.g(this.f8975m);
            this.f8976n.h().g(this.f8974e.P());
        }
        int iE = this.f8976n.h().e();
        if (iE != 0 && iE != 1 && iE != 2) {
            com.tuyafeng.support.utils.n.q(this.f8973c.G(), w7.u.nh);
            return;
        }
        com.tuyafeng.support.utils.n.q(this.f8973c.G(), w7.u.si);
        final String strReplace = UUID.randomUUID().toString().replace("-", "");
        final String url = webView.getUrl();
        final String title = webView.getTitle();
        final ab abVar = new ab(webView, q9.s());
        this.f8980r = abVar;
        abVar.f(new ValueCallback() { // from class: mark.via.browser.ec
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                ReadAloudController readAloudController = this.f9118a;
                x8.h.c(readAloudController.f8973c.s0(), new Runnable() { // from class: mark.via.browser.gc
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadAloudController.k(readAloudController, abVar, str, str, str, str);
                    }
                });
            }
        });
    }

    public void s(boolean z10) {
        String str;
        if (this.f8978p == null) {
            return;
        }
        h8.q qVar = this.f8976n;
        h8.t tVarF = (qVar == null || (str = this.f8977o) == null) ? null : qVar.f(str);
        if (tVarF == null) {
            final mark.via.common.widget.k1 k1Var = this.f8979q;
            if (k1Var != null) {
                y.r.c(k1Var).a(0.0f).d(100L).i(new Runnable() { // from class: mark.via.browser.cc
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReadAloudController.l(this.f9067c, k1Var);
                    }
                }).f();
                return;
            }
            return;
        }
        if (z10) {
            t();
        }
        mark.via.common.widget.k1 k1Var2 = this.f8979q;
        if (k1Var2 == null) {
            mark.via.common.widget.k1 k1Var3 = new mark.via.common.widget.k1(this.f8973c.G());
            this.f8979q = k1Var3;
            k1Var3.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f8979q.setCallback(new mark.via.common.widget.k1.a() { // from class: mark.via.browser.dc
                @Override // mark.via.common.widget.k1.a
                public final void a(int i10) {
                    ReadAloudController.m(this.f9096a, i10);
                }
            });
            Bundle bundleC = p5.b.d().c(mark.via.common.widget.k1.class.getName());
            int height = bundleC == null ? -1 : bundleC.getInt("y", -1);
            mark.via.common.widget.k1 k1Var4 = this.f8979q;
            if (height == -1) {
                height = this.f8978p.getHeight() / 2;
            }
            k1Var4.setTranslationY(height);
            this.f8979q.setAlpha(0.0f);
            this.f8978p.addView(this.f8979q);
            y.r.c(this.f8979q).a(1.0f).d(100L).f();
        } else {
            y.r.c(k1Var2).i(null).b();
            this.f8979q.setAlpha(1.0f);
        }
        this.f8979q.setPlaying(tVarF.h());
    }

    public final void t() {
        if (this.f8979q == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("y", (int) this.f8979q.getTranslationY());
        p5.b.d().e(mark.via.common.widget.k1.class.getName(), bundle);
        y.r.c(this.f8979q).i(null).b();
        this.f8979q.setPlaying(false);
        this.f8979q.setCallback(null);
        ViewGroup viewGroup = (ViewGroup) this.f8979q.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.f8979q);
        }
        this.f8979q = null;
    }

    public void u() {
        if (FragmentUtils.e(this.f8973c)) {
            return;
        }
        h8.p.E3().g3(this.f8973c.x0(), null);
    }
}
