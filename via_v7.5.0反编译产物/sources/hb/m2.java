package hb;

import android.R;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m2 extends m8.f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public t5.f f5964u0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public u9.l f5966w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public q9.d f5967x0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public String f5965v0 = "";

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final List f5968y0 = new ArrayList();

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final LruCache f5969z0 = new LruCache(12);
    public final Set A0 = new HashSet();
    public final n8.f B0 = new n8.f(this);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends v5.j {
        public a() {
        }

        @Override // v5.j, t5.d
        /* JADX INFO: renamed from: m */
        public void b(w5.g gVar, v5.g gVar2) {
            super.b(gVar, gVar2);
            q9.a aVar = (q9.a) m2.this.f5968y0.get(gVar.l());
            TextView textView = (TextView) gVar.P(v5.i.f13392c);
            if (aVar.a().isEmpty()) {
                textView.setTypeface(Typeface.DEFAULT);
            } else {
                textView.setTypeface(m2.this.v3(aVar));
                textView.setAlpha(m2.this.x3(aVar) ? 0.5f : 1.0f);
            }
        }
    }

    private void B3(List list) {
        t5.f fVar = this.f5964u0;
        if (fVar == null) {
            return;
        }
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(fVar.H(), list));
        this.f5964u0.M(list);
        eVarB.c(this.f5964u0);
    }

    public static /* synthetic */ boolean f3(final m2 m2Var, View view, final int i10, v5.g gVar) {
        m2Var.getClass();
        if (i10 == 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        if (!m2Var.x3((q9.a) m2Var.f5968y0.get(i10))) {
            arrayList.add(new q5.k.l(1, m2Var.X0(w7.u.E)));
        }
        arrayList.add(new q5.k.l(2, m2Var.X0(w7.u.f14298y)));
        q5.k.l(m2Var.G()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: hb.i2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                m2.k3(this.f5899a, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
        return true;
    }

    public static /* synthetic */ x.d h3(m2 m2Var, Uri uri) {
        String strK = x8.b1.k(m2Var.G(), uri);
        String strT = x8.c1.t(strK);
        if (strT == null || !(strT.equalsIgnoreCase("ttf") || strT.equalsIgnoreCase("otf") || strT.equalsIgnoreCase("woff") || strT.equalsIgnoreCase("woff2"))) {
            return x.d.a(1, null);
        }
        if (x8.b1.j(m2Var.G(), uri) > 52428800) {
            return x.d.a(2, null);
        }
        File file = new File(m2Var.f5967x0.e(), strK);
        if (file.exists() && !file.delete()) {
            return x.d.a(3, null);
        }
        String strB = x8.c1.b(m2Var.G(), uri, file);
        if (strB == null) {
            return x.d.a(4, null);
        }
        q9.a aVarC = m2Var.f5967x0.c(strB);
        return aVarC == null ? x.d.a(5, null) : x.d.a(0, aVarC);
    }

    public static /* synthetic */ void i3(m2 m2Var, x.d dVar) {
        m2Var.getClass();
        q9.a aVar = (q9.a) dVar.f14456b;
        if (aVar == null) {
            com.tuyafeng.support.utils.n.s(m2Var.G(), m2Var.Y0(w7.u.rh, dVar.f14455a));
            return;
        }
        m2Var.A0.remove(aVar.b());
        m2Var.f5969z0.remove(aVar.b());
        String str = m2Var.f5965v0;
        if (str != null && str.equals(aVar.a()) && m2Var.v3(aVar) == Typeface.DEFAULT && !m2Var.f5968y0.isEmpty()) {
            m2Var.A3((q9.a) m2Var.f5968y0.get(0));
        }
        m2Var.y3();
    }

    public static /* synthetic */ void j3(m2 m2Var, String str, String str2, String str3, int i10, View view, q5.k.p pVar) {
        String str4;
        m2Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        String str5 = pVar.f11819c[0];
        if (str.equalsIgnoreCase(str5)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str5);
        if (str2.isEmpty()) {
            str4 = "";
        } else {
            str4 = "." + str2;
        }
        sb2.append(str4);
        String string = sb2.toString();
        boolean zEquals = str3.equals(m2Var.f5965v0);
        q9.a aVarI = m2Var.f5967x0.i(str3, string);
        if (aVarI == null) {
            return;
        }
        m2Var.f5968y0.set(i10, aVarI);
        if (zEquals) {
            m2Var.A3(aVarI);
        }
        m2Var.B3(m2Var.t3());
    }

    public static /* synthetic */ void k3(m2 m2Var, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (j10 == 1) {
            m2Var.z3(i10);
        } else {
            m2Var.u3(i10);
        }
    }

    public static /* synthetic */ void n3(m2 m2Var, List list) {
        m2Var.f5965v0 = m2Var.f5966w0.c1();
        m2Var.f5968y0.clear();
        m2Var.f5968y0.addAll(list);
        m2Var.B3(m2Var.t3());
    }

    public static /* synthetic */ void o3(m2 m2Var, View view, int i10, v5.g gVar) {
        if (m2Var.A3((q9.a) m2Var.f5968y0.get(i10))) {
            m2Var.B3(m2Var.t3());
        }
    }

    private List t3() {
        ArrayList arrayList = new ArrayList();
        for (q9.a aVar : this.f5968y0) {
            arrayList.add(new v5.g(aVar.hashCode(), com.tuyafeng.support.utils.p.n(aVar.a(), X0(w7.u.f14110k3)), aVar.a().equals(this.f5965v0)));
        }
        return arrayList;
    }

    private void y3() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.f2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f5863c.f5967x0.h();
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.g2
            @Override // u6.f
            public final void accept(Object obj) {
                m2.n3(this.f5878c, (List) obj);
            }
        }, new w7.e0());
    }

    public final boolean A3(q9.a aVar) {
        if (aVar == null || aVar.a().equals(this.f5965v0) || x3(aVar)) {
            return false;
        }
        String strA = aVar.a();
        this.f5965v0 = strA;
        this.f5966w0.q(strA);
        return true;
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5966w0 = la.s.j();
        this.f5967x0 = la.s.g();
        this.f5964u0 = new t5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: hb.d2
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                m2.o3(this.f5839a, view2, i10, (v5.g) obj);
            }
        });
        aVar.k(new t5.h() { // from class: hb.e2
            @Override // t5.h
            public final boolean a(View view2, int i10, Object obj) {
                return m2.f3(this.f5851a, view2, i10, (v5.g) obj);
            }
        });
        this.f5964u0.K(v5.g.class, aVar);
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f7946t0.setAdapter(this.f5964u0);
        y3();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.W5);
        e0Var.c(new com.tuyafeng.support.widget.e0.b(1, 1, lb.g.a(G(), w7.o.f13810m, w7.u.ge), X0(w7.u.O)), new View.OnClickListener() { // from class: hb.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5824a.s3();
            }
        });
    }

    public final void s3() {
        this.B0.b(new String[]{"font/ttf", "font/otf", "font/woff", "font/woff2"}, new n8.f.a() { // from class: hb.h2
            @Override // n8.f.a
            public final void a(Uri uri) {
                this.f5885a.w3(uri);
            }
        });
    }

    public final void u3(int i10) {
        q9.a aVar;
        if (i10 < 0 || i10 >= this.f5968y0.size() || (aVar = (q9.a) this.f5968y0.remove(i10)) == null) {
            return;
        }
        if (aVar.a().equals(this.f5965v0)) {
            A3((q9.a) this.f5968y0.get(0));
        }
        B3(t3());
        this.f5967x0.d(aVar.a());
    }

    public final Typeface v3(q9.a aVar) {
        if (aVar == null || com.tuyafeng.support.utils.p.f(aVar.a())) {
            return Typeface.DEFAULT;
        }
        String strB = aVar.b();
        if (this.A0.contains(strB)) {
            return Typeface.DEFAULT;
        }
        Typeface typefaceCreateFromFile = (Typeface) this.f5969z0.get(strB);
        if (typefaceCreateFromFile == null) {
            try {
                typefaceCreateFromFile = Typeface.createFromFile(aVar.b());
            } catch (Exception e10) {
                tc.a.a(e10.getMessage(), new Object[0]);
            }
            if (typefaceCreateFromFile == null) {
                this.A0.add(strB);
                return Typeface.DEFAULT;
            }
            this.f5969z0.put(strB, typefaceCreateFromFile);
        }
        return typefaceCreateFromFile;
    }

    public final void w3(final Uri uri) {
        if (uri == null) {
            return;
        }
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.j2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m2.h3(this.f5919c, uri);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.k2
            @Override // u6.f
            public final void accept(Object obj) {
                m2.i3(this.f5934c, (x.d) obj);
            }
        }, new w7.e0());
    }

    public final boolean x3(q9.a aVar) {
        if (aVar == null || com.tuyafeng.support.utils.p.f(aVar.a())) {
            return false;
        }
        return this.A0.contains(aVar.b());
    }

    public final void z3(final int i10) {
        q9.a aVar;
        if (i10 < 0 || i10 >= this.f5968y0.size() || (aVar = (q9.a) this.f5968y0.get(i10)) == null) {
            return;
        }
        final String strA = aVar.a();
        int iLastIndexOf = strA.lastIndexOf(46);
        final String strSubstring = iLastIndexOf > 0 ? strA.substring(0, iLastIndexOf) : strA;
        final String strSubstring2 = iLastIndexOf > 0 ? strA.substring(iLastIndexOf + 1) : "";
        q5.k.l(G()).g0(X0(w7.u.f14062gb)).g(1, strSubstring, strSubstring, 1).X(R.string.ok, new q5.k.m() { // from class: hb.l2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                m2.j3(this.f5946a, strSubstring, strSubstring2, strA, i10, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }
}
