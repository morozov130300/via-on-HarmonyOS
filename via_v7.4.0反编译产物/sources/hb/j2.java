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
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import p8.f;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j2 extends o8.g {

    /* renamed from: r0, reason: collision with root package name */
    public y5.f f6606r0;

    /* renamed from: t0, reason: collision with root package name */
    public w9.l f6608t0;

    /* renamed from: u0, reason: collision with root package name */
    public s9.d f6609u0;

    /* renamed from: s0, reason: collision with root package name */
    public String f6607s0 = "";

    /* renamed from: v0, reason: collision with root package name */
    public final List f6610v0 = new ArrayList();

    /* renamed from: w0, reason: collision with root package name */
    public final LruCache f6611w0 = new LruCache(12);

    /* renamed from: x0, reason: collision with root package name */
    public final Set f6612x0 = new HashSet();

    /* renamed from: y0, reason: collision with root package name */
    public final p8.f f6613y0 = new p8.f(this);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends a6.j {
        public a() {
        }

        @Override // a6.j, y5.d
        /* renamed from: m */
        public void b(b6.g gVar, a6.g gVar2) {
            super.b(gVar, gVar2);
            s9.a aVar = (s9.a) j2.this.f6610v0.get(gVar.l());
            TextView textView = (TextView) gVar.P(a6.i.f108e);
            if (aVar.a().isEmpty()) {
                textView.setTypeface(Typeface.DEFAULT);
            } else {
                textView.setTypeface(j2.this.w3(aVar));
                textView.setAlpha(j2.this.y3(aVar) ? 0.5f : 1.0f);
            }
        }
    }

    private void C3(List list) {
        y5.f fVar = this.f6606r0;
        if (fVar == null) {
            return;
        }
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(fVar.H(), list));
        this.f6606r0.M(list);
        eVarB.c(this.f6606r0);
    }

    public static /* synthetic */ boolean g3(final j2 j2Var, View view, final int i10, a6.g gVar) {
        j2Var.getClass();
        if (i10 == 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        if (!j2Var.y3((s9.a) j2Var.f6610v0.get(i10))) {
            arrayList.add(new k.l(1, j2Var.Z0(x7.u.D)));
        }
        arrayList.add(new k.l(2, j2Var.Z0(x7.u.f14215x)));
        w5.k.l(j2Var.I()).C(arrayList, new AdapterView.OnItemClickListener() { // from class: hb.f2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                j2.l3(this.f6542a, i10, adapterView, view2, i11, j10);
            }
        }).h0(view);
        return true;
    }

    public static /* synthetic */ w.d i3(j2 j2Var, Uri uri) throws IOException {
        String strK = z8.b1.k(j2Var.I(), uri);
        String strR = z8.c1.r(strK);
        if (strR == null || !(strR.equalsIgnoreCase("ttf") || strR.equalsIgnoreCase("otf") || strR.equalsIgnoreCase("woff") || strR.equalsIgnoreCase("woff2"))) {
            return w.d.a(1, null);
        }
        if (z8.b1.j(j2Var.I(), uri) > 52428800) {
            return w.d.a(2, null);
        }
        File file = new File(j2Var.f6609u0.e(), strK);
        if (file.exists() && !file.delete()) {
            return w.d.a(3, null);
        }
        String strB = z8.c1.b(j2Var.I(), uri, file);
        if (strB == null) {
            return w.d.a(4, null);
        }
        s9.a aVarC = j2Var.f6609u0.c(strB);
        return aVarC == null ? w.d.a(5, null) : w.d.a(0, aVarC);
    }

    public static /* synthetic */ void j3(j2 j2Var, w.d dVar) {
        j2Var.getClass();
        s9.a aVar = (s9.a) dVar.f13208b;
        if (aVar == null) {
            g6.n.s(j2Var.I(), j2Var.a1(x7.u.Sg, dVar.f13207a));
            return;
        }
        j2Var.f6612x0.remove(aVar.b());
        j2Var.f6611w0.remove(aVar.b());
        String str = j2Var.f6607s0;
        if (str != null && str.equals(aVar.a()) && j2Var.w3(aVar) == Typeface.DEFAULT && !j2Var.f6610v0.isEmpty()) {
            j2Var.B3((s9.a) j2Var.f6610v0.get(0));
        }
        j2Var.z3();
    }

    public static /* synthetic */ void k3(j2 j2Var, String str, String str2, String str3, int i10, View view, k.p pVar) {
        String str4;
        j2Var.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        String str5 = pVar.f13339c[0];
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
        boolean zEquals = str3.equals(j2Var.f6607s0);
        s9.a aVarI = j2Var.f6609u0.i(str3, string);
        if (aVarI == null) {
            return;
        }
        j2Var.f6610v0.set(i10, aVarI);
        if (zEquals) {
            j2Var.B3(aVarI);
        }
        j2Var.C3(j2Var.u3());
    }

    public static /* synthetic */ void l3(j2 j2Var, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (j10 == 1) {
            j2Var.A3(i10);
        } else {
            j2Var.v3(i10);
        }
    }

    public static /* synthetic */ void o3(j2 j2Var, List list) {
        j2Var.f6607s0 = j2Var.f6608t0.a1();
        j2Var.f6610v0.clear();
        j2Var.f6610v0.addAll(list);
        j2Var.C3(j2Var.u3());
    }

    public static /* synthetic */ void p3(j2 j2Var, View view, int i10, a6.g gVar) {
        if (j2Var.B3((s9.a) j2Var.f6610v0.get(i10))) {
            j2Var.C3(j2Var.u3());
        }
    }

    private List u3() {
        ArrayList arrayList = new ArrayList();
        for (s9.a aVar : this.f6610v0) {
            arrayList.add(new a6.g(aVar.hashCode(), g6.p.n(aVar.a(), Z0(x7.u.Y2)), aVar.a().equals(this.f6607s0)));
        }
        return arrayList;
    }

    private void z3() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.c2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6498e.f6609u0.h();
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.d2
            @Override // a7.e
            public final void accept(Object obj) {
                j2.o3(this.f6519e, (List) obj);
            }
        }, new x7.g0());
    }

    public final void A3(final int i10) {
        s9.a aVar;
        if (i10 < 0 || i10 >= this.f6610v0.size() || (aVar = (s9.a) this.f6610v0.get(i10)) == null) {
            return;
        }
        final String strA = aVar.a();
        int iLastIndexOf = strA.lastIndexOf(46);
        final String strSubstring = iLastIndexOf > 0 ? strA.substring(0, iLastIndexOf) : strA;
        final String strSubstring2 = iLastIndexOf > 0 ? strA.substring(iLastIndexOf + 1) : "";
        w5.k.l(I()).e0(Z0(x7.u.Ua)).g(1, strSubstring, strSubstring, 1).V(R.string.ok, new k.m() { // from class: hb.i2
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                j2.k3(this.f6579a, strSubstring, strSubstring2, strA, i10, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final boolean B3(s9.a aVar) {
        if (aVar == null || aVar.a().equals(this.f6607s0) || y3(aVar)) {
            return false;
        }
        String strA = aVar.a();
        this.f6607s0 = strA;
        this.f6608t0.o(strA);
        return true;
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6608t0 = pa.r.j();
        this.f6609u0 = pa.r.g();
        this.f6606r0 = new y5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: hb.a2
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                j2.p3(this.f6463a, view2, i10, (a6.g) obj);
            }
        });
        aVar.k(new y5.h() { // from class: hb.b2
            @Override // y5.h
            public final boolean a(View view2, int i10, Object obj) {
                return j2.g3(this.f6478a, view2, i10, (a6.g) obj);
            }
        });
        this.f6606r0.K(a6.g.class, aVar);
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f10459q0.setAdapter(this.f6606r0);
        z3();
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.K5);
        zVar.c(new z.b(1, 1, lb.b.a(I(), x7.o.f13747n, x7.u.Rd), Z0(x7.u.N)), new View.OnClickListener() { // from class: hb.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6856a.t3();
            }
        });
    }

    public final void t3() {
        this.f6613y0.b(new String[]{"font/ttf", "font/otf", "font/woff", "font/woff2"}, new f.a() { // from class: hb.e2
            @Override // p8.f.a
            public final void a(Uri uri) {
                this.f6530a.x3(uri);
            }
        });
    }

    public final void v3(int i10) {
        s9.a aVar;
        if (i10 < 0 || i10 >= this.f6610v0.size() || (aVar = (s9.a) this.f6610v0.remove(i10)) == null) {
            return;
        }
        if (aVar.a().equals(this.f6607s0)) {
            B3((s9.a) this.f6610v0.get(0));
        }
        C3(u3());
        this.f6609u0.d(aVar.a());
    }

    public final Typeface w3(s9.a aVar) {
        if (aVar == null || g6.p.f(aVar.a())) {
            return Typeface.DEFAULT;
        }
        String strB = aVar.b();
        if (this.f6612x0.contains(strB)) {
            return Typeface.DEFAULT;
        }
        Typeface typefaceCreateFromFile = (Typeface) this.f6611w0.get(strB);
        if (typefaceCreateFromFile == null) {
            try {
                typefaceCreateFromFile = Typeface.createFromFile(aVar.b());
            } catch (Exception e10) {
                pc.a.a(e10.getMessage(), new Object[0]);
            }
            if (typefaceCreateFromFile == null) {
                this.f6612x0.add(strB);
                return Typeface.DEFAULT;
            }
            this.f6611w0.put(strB, typefaceCreateFromFile);
        }
        return typefaceCreateFromFile;
    }

    public final void x3(final Uri uri) {
        if (uri == null) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.g2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return j2.i3(this.f6555e, uri);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.h2
            @Override // a7.e
            public final void accept(Object obj) {
                j2.j3(this.f6566e, (w.d) obj);
            }
        }, new x7.g0());
    }

    public final boolean y3(s9.a aVar) {
        if (aVar == null || g6.p.f(aVar.a())) {
            return false;
        }
        return this.f6612x0.contains(aVar.b());
    }
}
