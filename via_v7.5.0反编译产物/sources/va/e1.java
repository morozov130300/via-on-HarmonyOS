package va;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.settings.search.SettingsSearchLocator;
import x8.s1;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e1 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f13474u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f13475v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t9.g f13476w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final wa.a f13477x0 = new wa.r(this);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final n8.d f13478y0 = new n8.d(this, "text/csv");

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final n8.f f13479z0 = new n8.f(this);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends wa.s {
        public a(Context context) {
            super(context);
        }

        @Override // wa.b
        public void onSuccess() {
            e1.this.f13478y0.d(e1.this.X0(w7.u.f14066h1) + "_" + e1.this.X0(w7.u.f14296xa) + "_" + s1.d() + ".csv", new n8.d.a() { // from class: va.d1
                @Override // n8.d.a
                public final void a(Uri uri, String str) {
                    e1.this.q3(uri, str);
                }
            });
        }
    }

    public static /* synthetic */ Boolean f3(e1 e1Var, Uri uri) throws IOException {
        List listN = e1Var.f13476w0.n();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(x8.b1.l(e1Var.G(), uri)));
        try {
            f1.b(bufferedWriter, listN);
            Boolean bool = Boolean.TRUE;
            bufferedWriter.close();
            return bool;
        } catch (Throwable th) {
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static /* synthetic */ void g3(e1 e1Var, String str, Boolean bool) {
        e1Var.getClass();
        if (bool.booleanValue()) {
            if (str != null) {
                com.tuyafeng.support.utils.n.l(e1Var.G(), w7.u.I3, e1Var.G().getString(w7.u.f14112k5, str));
            } else {
                com.tuyafeng.support.utils.n.q(e1Var.G(), w7.u.f14040f3);
            }
        }
    }

    public static /* synthetic */ void h3(e1 e1Var, Integer num) {
        e1Var.getClass();
        if (num.intValue() > 0) {
            com.tuyafeng.support.utils.n.s(e1Var.G(), e1Var.Y0(w7.u.f14309ya, num));
        } else if (num.intValue() < 0) {
            com.tuyafeng.support.utils.n.q(e1Var.G(), w7.u.f14252u5);
        }
    }

    public static /* synthetic */ void i3(e1 e1Var, View view, int i10, v5.q qVar) {
        e1Var.getClass();
        int iC = qVar.c();
        if (iC == 2) {
            FragmentUtils.i(e1Var, t0.class);
            return;
        }
        if (iC == 5) {
            FragmentUtils.i(e1Var, f.class);
        } else if (iC == 4) {
            e1Var.p3();
        } else if (iC == 3) {
            e1Var.s3();
        }
    }

    public static /* synthetic */ void j3(e1 e1Var, View view, int i10, v5.n nVar) {
        e1Var.getClass();
        if (nVar.c() == 1) {
            boolean z10 = !nVar.i();
            u9.a aVarV = e1Var.f13474u0.v();
            aVarV.I(z10);
            e1Var.f13474u0.Z(aVarV);
            nVar.j(z10);
            e1Var.f13475v0.m(i10);
        }
    }

    public static /* synthetic */ Integer l3(e1 e1Var, Uri uri) throws IOException {
        e1Var.getClass();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(x8.b1.i(e1Var.G(), uri)));
        try {
            List listA = f1.a(bufferedReader);
            if (listA == null) {
                bufferedReader.close();
                return -1;
            }
            if (listA.isEmpty()) {
                bufferedReader.close();
                return 0;
            }
            Integer numValueOf = Integer.valueOf(e1Var.f13476w0.i(listA) ? listA.size() : -2);
            bufferedReader.close();
            return numValueOf;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private List o3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.n(1, X0(w7.u.f14130l9), this.f13474u0.v().q()));
        arrayList.add(new v5.q(2, X0(w7.u.f14296xa)));
        arrayList.add(new v5.q(5, X0(w7.u.dd)));
        arrayList.add(new v5.q(3, X0(w7.u.Y6), X0(w7.u.Z6)));
        arrayList.add(new v5.q(4, X0(w7.u.f14126l5), X0(w7.u.f14140m5)));
        return arrayList;
    }

    public static List r3(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, e1.class, w7.u.Fc, w7.u.f14229sa);
        hVar.b(1, w7.u.f14130l9, new String[0]);
        hVar.b(2, w7.u.f14296xa, new String[0]);
        hVar.b(5, w7.u.dd, new String[0]);
        hVar.b(3, w7.u.Y6, new String[0]);
        hVar.b(4, w7.u.f14126l5, new String[0]);
        return hVar.f();
    }

    private void u3(List list) {
        t5.f fVar = this.f13475v0;
        if (fVar == null) {
            return;
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(fVar.H(), list));
        this.f13475v0.M(list);
        eVarB.c(this.f13475v0);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f13476w0 = la.s.i();
        this.f13474u0 = la.s.j();
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f13475v0 = new t5.f(Collections.EMPTY_LIST);
        v5.s sVar = new v5.s();
        sVar.j(new t5.g() { // from class: va.w0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                e1.i3(this.f13548a, view2, i10, (v5.q) obj);
            }
        });
        this.f13475v0.K(v5.q.class, sVar);
        v5.p pVar = new v5.p();
        pVar.j(new t5.g() { // from class: va.x0
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                e1.j3(this.f13550a, view2, i10, (v5.n) obj);
            }
        });
        this.f13475v0.K(v5.n.class, pVar);
        this.f7946t0.setAdapter(this.f13475v0);
        SettingsSearchLocator.b(this, this.f7946t0);
        u3(o3());
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        v3.b(e0Var, X0(w7.u.f14229sa));
    }

    public final void p3() {
        if (this.f13476w0.j()) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.f14032e9);
        } else {
            this.f13477x0.a(X0(w7.u.f14126l5), X0(w7.u.xh), new a(G()));
        }
    }

    public final void q3(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: va.z0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e1.f3(this.f13555c, uri);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: va.a1
            @Override // u6.f
            public final void accept(Object obj) {
                e1.g3(this.f13458c, str, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public final void s3() {
        this.f13479z0.b(new String[]{"text/*"}, new n8.f.a() { // from class: va.y0
            @Override // n8.f.a
            public final void a(Uri uri) {
                this.f13553a.t3(uri);
            }
        });
    }

    public final void t3(final Uri uri) {
        if (uri == null) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: va.b1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e1.l3(this.f13462c, uri);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: va.c1
            @Override // u6.f
            public final void accept(Object obj) {
                e1.h3(this.f13467c, (Integer) obj);
            }
        }, new w7.e0());
    }
}
