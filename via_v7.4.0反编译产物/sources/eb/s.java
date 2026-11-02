package eb;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b6.a;
import bb.i;
import c8.ac;
import com.tuyafeng.support.widget.a0;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import mark.via.common.widget.r0;
import n8.b;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p8.d;
import v5.b;
import w5.k;
import x7.c0;
import x7.g0;
import z8.b0;
import z8.b1;
import z8.c1;
import z8.e4;
import z8.f1;
import z8.r3;
import z8.t1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s extends Fragment implements i.c {
    public bb.v A0;
    public y B0;

    /* renamed from: m0, reason: collision with root package name */
    public r0 f4968m0;

    /* renamed from: n0, reason: collision with root package name */
    public RecyclerView f4969n0;

    /* renamed from: o0, reason: collision with root package name */
    public TextView f4970o0;

    /* renamed from: p0, reason: collision with root package name */
    public EditText f4971p0;

    /* renamed from: q0, reason: collision with root package name */
    public a0 f4972q0;

    /* renamed from: r0, reason: collision with root package name */
    public a0.b f4973r0;

    /* renamed from: s0, reason: collision with root package name */
    public a0.b f4974s0;

    /* renamed from: t0, reason: collision with root package name */
    public a0.b f4975t0;

    /* renamed from: u0, reason: collision with root package name */
    public a0.b f4976u0;

    /* renamed from: v0, reason: collision with root package name */
    public y5.f f4977v0;

    /* renamed from: y0, reason: collision with root package name */
    public w5.k f4980y0;

    /* renamed from: z0, reason: collision with root package name */
    public n8.b f4981z0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f4978w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    public Uri f4979x0 = null;
    public final v8.b C0 = new v8.b();
    public final b6.a D0 = new b6.a();
    public final p8.d E0 = new p8.d(this, "application/pdf");
    public final p8.d F0 = new p8.d(this, "multipart/related");
    public final p8.d G0 = new p8.d(this, "application/zip");

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.InterfaceC0033a {
        public a() {
        }

        @Override // b6.a.InterfaceC0033a
        public void a(int i10) {
            s.this.f4973r0.l(s.this.Z0(i10 > 0 && s.this.f4977v0.g() == i10 ? x7.u.J1 : x7.u.f13997gc));
            s.this.f4974s0.j(i10 <= 0);
            s.this.f4974s0.h(i10 > 0);
            a0.b bVar = s.this.f4974s0;
            s sVar = s.this;
            bVar.l(i10 == 0 ? sVar.Z0(x7.u.f14215x) : sVar.a1(x7.u.f13960e3, Integer.valueOf(i10)));
            s.this.f4976u0.j(i10 <= 0);
            s.this.f4972q0.j(s.this.f4973r0, s.this.f4974s0, s.this.f4976u0);
        }

        @Override // b6.a.InterfaceC0033a
        public void b(boolean z10) {
            s.this.f4977v0.l();
            s.this.G3(z10);
            if (z10) {
                a(s.this.D0.a());
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends y5.i {
        public b() {
        }

        @Override // y5.i
        public View o(ViewGroup viewGroup) {
            View viewA = b6.c.g().a(viewGroup);
            ImageView imageView = (ImageView) viewA.findViewById(b6.c.f1830e);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = g6.f.d(imageView.getContext(), x7.n.f13703v);
                layoutParams.width = g6.f.d(imageView.getContext(), x7.n.f13703v);
                imageView.setLayoutParams(layoutParams);
            }
            imageView.setColorFilter(g6.e.a(viewA.getContext(), x7.k.f13662h));
            TextView textView = (TextView) viewA.findViewById(b6.c.f1829d);
            r3.p(textView);
            x8.g.d((TextView) viewA.findViewById(b6.c.f1828c));
            x8.g.d(textView);
            CheckBox checkBox = (CheckBox) viewA.findViewById(b6.c.f1832g);
            checkBox.setClickable(false);
            checkBox.setFocusable(false);
            return viewA;
        }

        @Override // y5.i
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(b6.g gVar, n9.d dVar, int i10) {
            int i11 = b6.c.f1832g;
            gVar.Y(i11, s.this.D0.c());
            gVar.T(i11, s.this.D0.c() && s.this.D0.d(i10));
            gVar.X(b6.c.f1828c, dVar.d());
            gVar.X(b6.c.f1829d, b0.w(s.this.I(), dVar.e()));
            gVar.W(b6.c.f1830e, dVar.g() ? x7.o.Y : x7.o.f13709a0);
        }

        @Override // y5.i
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void m(b6.g gVar, n9.d dVar, int i10, List list) {
            for (Object obj : list) {
                if (obj instanceof Boolean) {
                    gVar.T(b6.c.f1832g, ((Boolean) obj).booleanValue());
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements n8.a {
        public c() {
        }

        @Override // n8.a
        public boolean a(int i10) {
            return s.this.D0.d(i10);
        }

        @Override // n8.a
        public void b(int i10, boolean z10) {
            if (s.this.D0.j(i10, z10)) {
                s.this.f4977v0.n(i10, Boolean.valueOf(z10));
            }
        }

        @Override // n8.a
        public boolean c(int i10) {
            return s.this.D0.c();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements b.InterfaceC0100b {
        public d() {
        }

        @Override // n8.b.InterfaceC0100b
        public void a(boolean z10) {
            s.this.A0.M(!z10);
        }

        @Override // n8.b.InterfaceC0100b
        public void b(boolean z10) {
        }
    }

    private void A3() {
        this.B0.p().g(d1(), new androidx.lifecycle.m() { // from class: eb.b
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                s.U2(this.f4942a, (List) obj);
            }
        });
        this.B0.q().g(d1(), new androidx.lifecycle.m() { // from class: eb.j
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                s.V2(this.f4958a, (Boolean) obj);
            }
        });
    }

    private void B3() {
        Bundle bundleC = v5.b.d().c("OFFLINE_CACHE");
        if (bundleC != null) {
            this.f4971p0.setText(bundleC.getString("query", ""));
        }
        ((autodispose2.n) u8.c.a(this.f4971p0).f(200L, TimeUnit.MILLISECONDS).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: eb.m
            @Override // a7.e
            public final void accept(Object obj) {
                s.b3(this.f4961e, (CharSequence) obj);
            }
        }, new g0());
        this.f4972q0.setOnActionClickListener(new a0.c() { // from class: eb.n
            @Override // com.tuyafeng.support.widget.a0.c
            public final void a(View view, a0.b bVar) {
                s.Z2(this.f4962a, view, bVar);
            }
        });
    }

    private void F3() {
        RecyclerView recyclerView = this.f4969n0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        b.C0148b c0148bF = v5.b.a().e("OFFLINE_CACHE").f(180);
        EditText editText = this.f4971p0;
        if (editText != null) {
            c0148bF.d("query", editText.getText().toString());
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f4969n0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0148bF.b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0148bF.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3(boolean z10) {
        this.f4975t0.l(Z0(z10 ? x7.u.K3 : x7.u.D));
        this.f4973r0.k(!z10);
        this.f4974s0.k(!z10);
        this.f4976u0.k(!z10);
        this.f4972q0.j(this.f4975t0, this.f4973r0, this.f4974s0, this.f4976u0);
    }

    private void I3() {
        w5.k kVar = this.f4980y0;
        if (kVar != null) {
            kVar.f0();
            return;
        }
        w5.k kVarU = w5.k.l(I()).X(x7.u.Nh).t(false).u(false);
        this.f4980y0 = kVarU;
        kVarU.f0();
    }

    public static /* synthetic */ void U2(s sVar, List list) {
        RecyclerView recyclerView;
        sVar.C0.g(list, new v8.c() { // from class: eb.o
            @Override // v8.c
            public final long a(Object obj) {
                return ((n9.d) obj).b();
            }
        });
        sVar.f4977v0.M(list);
        sVar.f4977v0.l();
        if (sVar.f4978w0) {
            return;
        }
        sVar.f4978w0 = true;
        Bundle bundleC = v5.b.d().c("OFFLINE_CACHE");
        if (bundleC == null || (recyclerView = sVar.f4969n0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutManager) sVar.f4969n0.getLayoutManager()).B2(bundleC.getInt("position", 0), bundleC.getInt("offset", 0));
    }

    public static /* synthetic */ void V2(s sVar, Boolean bool) {
        sVar.f4968m0.setEmpty(bool.booleanValue());
        sVar.f4975t0.j(bool.booleanValue());
        sVar.f4972q0.h(sVar.f4975t0);
    }

    public static /* synthetic */ Boolean X2(s sVar, String str, List list, Uri uri) {
        sVar.getClass();
        if (!e4.c(str, list) || !b1.b(sVar.I(), Uri.fromFile(new File(str)), uri)) {
            return Boolean.FALSE;
        }
        c1.g(str);
        return Boolean.TRUE;
    }

    public static /* synthetic */ void Y2(s sVar, String str, Boolean bool) {
        sVar.u3();
        if (bool.booleanValue()) {
            if (str != null) {
                g6.n.l(sVar.I(), x7.u.f14193v3, sVar.I().getString(x7.u.X4, str));
            } else {
                g6.n.q(sVar.I(), x7.u.f13906a5);
            }
        }
    }

    public static /* synthetic */ void Z2(s sVar, View view, a0.b bVar) {
        sVar.getClass();
        int iA = bVar.a();
        if (iA == x7.p.N0) {
            sVar.D0.k(!r1.c());
            return;
        }
        if (iA != x7.p.S0) {
            if (iA == x7.p.M0) {
                sVar.t3();
                return;
            } else {
                if (iA == x7.p.O0) {
                    sVar.x3();
                    return;
                }
                return;
            }
        }
        int iG = sVar.f4977v0.g();
        if (iG == 0) {
            return;
        }
        if (iG == sVar.D0.a()) {
            sVar.D0.l(0, iG);
        } else {
            sVar.D0.f(0, iG);
        }
        sVar.f4977v0.q(0, iG);
    }

    public static /* synthetic */ void a3(s sVar, Throwable th) {
        sVar.u3();
        pc.a.i(th);
    }

    public static /* synthetic */ void b3(s sVar, CharSequence charSequence) {
        sVar.B0.t(charSequence.toString());
        sVar.D0.k(false);
    }

    public static /* synthetic */ void c3(s sVar, View view, int i10, n9.d dVar) {
        if (!sVar.D0.c()) {
            sVar.C3(dVar, 0);
        } else {
            sVar.D0.h(i10);
            sVar.f4977v0.n(i10, Boolean.valueOf(sVar.D0.d(i10)));
        }
    }

    public static /* synthetic */ void d3(s sVar, n9.d dVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        sVar.getClass();
        boolean zG = dVar.g();
        switch ((int) j10) {
            case 1:
                sVar.C3(dVar, 2);
                break;
            case 2:
                try {
                    sVar.P2(Intent.createChooser(f1.i(sVar.I(), dVar.a(), dVar.c()), sVar.Z0(x7.u.f14199v9)));
                    break;
                } catch (Exception e10) {
                    pc.a.i(e10);
                    return;
                }
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                sVar.f4979x0 = dVar.a();
                try {
                    if (!zG) {
                        sVar.F0.d(dVar.d() + ".mht", new p(sVar));
                        break;
                    } else {
                        sVar.E0.d(dVar.d() + ".pdf", new p(sVar));
                        break;
                    }
                } catch (Exception e11) {
                    pc.a.i(e11);
                    return;
                }
            case 4:
                sVar.s3(dVar, i10);
                break;
            case 5:
            case 6:
                sVar.C3(dVar, j10 != 5 ? 1 : 2);
                break;
            case 7:
                f1.m(sVar.I(), dVar.a(), dVar.c());
                break;
        }
    }

    public static /* synthetic */ void e3(s sVar, String str, Boolean bool) {
        sVar.getClass();
        if (bool.booleanValue()) {
            if (str != null) {
                g6.n.l(sVar.I(), x7.u.f14193v3, sVar.I().getString(x7.u.X4, str));
            } else {
                g6.n.q(sVar.I(), x7.u.f13906a5);
            }
        }
    }

    public static /* synthetic */ void g3(s sVar, int i10, View view, k.p pVar) {
        if (sVar.B0.s(i10) != null) {
            b6.b bVarC = sVar.C0.c(i10);
            sVar.C0.f(i10);
            sVar.f4977v0.u(i10);
            if (bVarC.c()) {
                sVar.f4977v0.n(i10 - 1, 1);
            }
        }
    }

    public static /* synthetic */ boolean h3(s sVar, View view, int i10, n9.d dVar) {
        if (sVar.D0.c()) {
            sVar.f4981z0.n(true, i10);
            return true;
        }
        sVar.H3(view, dVar, i10);
        return true;
    }

    public static /* synthetic */ Boolean i3(s sVar, Uri uri) throws IOException {
        sVar.getClass();
        boolean z10 = false;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(b1.i(sVar.I(), sVar.f4979x0));
            try {
                OutputStream outputStreamL = b1.l(sVar.I(), uri);
                if (outputStreamL != null) {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i10 = bufferedInputStream.read(bArr);
                            if (i10 <= 0) {
                                break;
                            }
                            outputStreamL.write(bArr, 0, i10);
                            outputStreamL.flush();
                        }
                        z10 = true;
                    } finally {
                    }
                }
                if (outputStreamL != null) {
                    outputStreamL.close();
                }
                bufferedInputStream.close();
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (z10) {
            sVar.E3(sVar.f4979x0, uri);
        }
        return Boolean.valueOf(z10);
    }

    public static /* synthetic */ void j3(s sVar, int[] iArr, View view, k.p pVar) {
        sVar.getClass();
        for (int i10 : iArr) {
            if (sVar.B0.s(i10) != null) {
                b6.b bVarC = sVar.C0.c(i10);
                sVar.C0.f(i10);
                sVar.f4977v0.u(i10);
                if (bVarC.c()) {
                    sVar.f4977v0.n(i10 - 1, 1);
                }
            }
        }
        sVar.D0.k(false);
    }

    private void u3() {
        w5.k kVar = this.f4980y0;
        if (kVar == null) {
            return;
        }
        kVar.n();
        this.f4980y0 = null;
    }

    private void z3() {
        this.D0.i(new a());
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        r0 r0Var = (r0) new h6.a(new r0(I()), new ViewGroup.LayoutParams(-1, -1)).l();
        RecyclerView recyclerView = r0Var.f9734e;
        this.f4969n0 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.C0.h(new v8.a(I()));
        Context contextI = I();
        v8.b bVar = this.C0;
        Objects.requireNonNull(bVar);
        c6.b bVar2 = new c6.b(contextI, new ac(bVar));
        bVar2.o(1);
        bVar2.n(g6.e.a(I(), x7.k.f13655a));
        this.f4969n0.k(bVar2);
        this.f4971p0 = r0Var.f9737l;
        this.f4970o0 = r0Var.f9736k;
        this.f4972q0 = r0Var.f9738m;
        a0.b bVar3 = new a0.b(x7.p.S0, Z0(x7.u.f13997gc));
        this.f4973r0 = bVar3;
        bVar3.k(true);
        a0.b bVar4 = new a0.b(x7.p.M0, Z0(x7.u.f14215x));
        this.f4974s0 = bVar4;
        bVar4.i(true);
        this.f4974s0.j(true);
        this.f4974s0.k(true);
        a0.b bVar5 = new a0.b(x7.p.O0, Z0(x7.u.S4));
        this.f4976u0 = bVar5;
        bVar5.j(true);
        this.f4976u0.k(true);
        this.f4975t0 = new a0.b(x7.p.N0, Z0(x7.u.D));
        this.f4972q0.b(this.f4973r0);
        this.f4972q0.b(this.f4974s0);
        this.f4972q0.b(this.f4976u0);
        this.f4972q0.c(this.f4975t0);
        this.f4968m0 = r0Var;
        return r0Var;
    }

    public final void C3(n9.d dVar, int i10) {
        if (dVar.g()) {
            D3(dVar.f());
        } else {
            this.A0.H(dVar.f(), i10);
        }
    }

    public final void D3(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        g6.i.h(M0(), za.g.class, v5.a.b().e("pdfPath", str).a());
    }

    public final void E3(Uri uri, Uri uri2) {
        if (b1.q(uri) && b1.q(uri2)) {
            String path = uri.getPath();
            String path2 = uri2.getPath();
            if (path == null || path2 == null) {
                return;
            }
            try {
                long jLastModified = new File(path).lastModified();
                if (jLastModified > 0) {
                    new File(path2).setLastModified(jLastModified);
                }
            } catch (Exception e10) {
                pc.a.b(e10);
            }
        }
    }

    public final void H3(View view, final n9.d dVar, final int i10) {
        ArrayList arrayList = new ArrayList();
        if (dVar.g()) {
            arrayList.add(new k.l(1, Z0(x7.u.W)));
            arrayList.add(new k.l(2, Z0(x7.u.f14199v9)));
        } else {
            arrayList.add(new k.l(5, Z0(x7.u.Q)));
            arrayList.add(new k.l(6, Z0(x7.u.R)));
        }
        arrayList.add(new k.l(7, Z0(x7.u.f13943d0)));
        arrayList.add(new k.l(3, Z0(x7.u.S4)));
        arrayList.add(new k.l(4, Z0(x7.u.f14215x)));
        w5.k.l(I()).C(arrayList, new AdapterView.OnItemClickListener() { // from class: eb.r
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                s.d3(this.f4965a, dVar, i10, adapterView, view2, i11, j10);
            }
        }).h0(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void O1() {
        F3();
        super.O1();
    }

    @Override // bb.i.c
    public boolean W() {
        if (this.D0.c()) {
            this.D0.k(false);
            return true;
        }
        if (this.f4971p0.getText().length() <= 0) {
            return false;
        }
        this.f4971p0.setText("");
        this.f4971p0.clearFocus();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        z3();
        y3();
        B3();
        A3();
    }

    @Override // bb.i.c
    public boolean l() {
        return !this.D0.c() && this.f4971p0.getText().length() == 0;
    }

    public final void s3(n9.d dVar, final int i10) {
        if (dVar == null) {
            return;
        }
        w5.k.l(I()).d0(x7.u.f14215x).J(a1(x7.u.f13988g3, dVar.d())).V(R.string.ok, new k.m() { // from class: eb.i
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                s.g3(this.f4956a, i10, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void t3() {
        String strA1;
        if (!this.D0.c() || this.D0.a() <= 0) {
            return;
        }
        final int[] iArrB = this.D0.b(true);
        if (iArrB.length == 1) {
            List list = (List) this.B0.p().e();
            if (list == null || iArrB[0] >= list.size()) {
                return;
            }
            strA1 = a1(x7.u.f13988g3, ((n9.d) list.get(iArrB[0])).d());
        } else {
            strA1 = a1(x7.u.f14002h3, Integer.valueOf(iArrB.length));
        }
        w5.k.l(I()).d0(x7.u.f14215x).J(strA1).V(R.string.ok, new k.m() { // from class: eb.c
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                s.j3(this.f4943a, iArrB, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        pa.r.b(context).d().a().a(this);
    }

    public final void v3(final Uri uri, final String str) {
        if (uri == null || this.f4979x0 == null) {
            return;
        }
        ((autodispose2.n) x6.j.s(new Callable() { // from class: eb.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s.i3(this.f4952e, uri);
            }
        }).D(g7.a.c()).z(w6.b.b()).I(u8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new a7.e() { // from class: eb.h
            @Override // a7.e
            public final void accept(Object obj) {
                s.e3(this.f4954e, str, (Boolean) obj);
            }
        }, new c0());
    }

    public final void w3(final Uri uri, final String str) {
        List list;
        final String strK;
        n9.d dVar;
        String path;
        if (uri == null) {
            return;
        }
        int[] iArrB = this.D0.b(false);
        if (iArrB.length == 0 || (list = (List) this.B0.p().e()) == null || (strK = c1.k(I(), "temp", UUID.randomUUID().toString())) == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (int i10 : iArrB) {
            if (i10 < list.size() && (dVar = (n9.d) list.get(i10)) != null && dVar.a() != null && (path = dVar.a().getPath()) != null && !path.isEmpty()) {
                arrayList.add(new File(path));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        I3();
        ((autodispose2.n) x6.j.s(new Callable() { // from class: eb.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s.X2(this.f4945e, strK, arrayList, uri);
            }
        }).D(g7.a.c()).z(w6.b.b()).I(u8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new a7.e() { // from class: eb.e
            @Override // a7.e
            public final void accept(Object obj) {
                s.Y2(this.f4949e, str, (Boolean) obj);
            }
        }, new a7.e() { // from class: eb.f
            @Override // a7.e
            public final void accept(Object obj) {
                s.a3(this.f4951e, (Throwable) obj);
            }
        });
    }

    public final void x3() {
        List list;
        int iA = this.D0.c() ? this.D0.a() : 0;
        if (iA <= 0) {
            return;
        }
        if (iA != 1) {
            this.G0.d(String.format(Locale.getDefault(), "%s_%s.zip", Z0(x7.u.f13929c0), t1.d()), new d.a() { // from class: eb.q
                @Override // p8.d.a
                public final void a(Uri uri, String str) {
                    this.f4964a.w3(uri, str);
                }
            });
            return;
        }
        int[] iArrB = this.D0.b(false);
        if (iArrB.length == 0 || (list = (List) this.B0.p().e()) == null || iArrB[0] >= list.size()) {
            return;
        }
        n9.d dVar = (n9.d) list.get(iArrB[0]);
        this.f4979x0 = dVar.a();
        try {
            if (dVar.g()) {
                this.E0.d(dVar.d() + ".pdf", new p(this));
                return;
            }
            this.F0.d(dVar.d() + ".mht", new p(this));
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.A0 = (bb.v) new androidx.lifecycle.y(B2(), pa.r.n()).a(bb.v.class);
    }

    public final void y3() {
        this.f4977v0 = new y5.f(new ArrayList());
        b bVar = new b();
        bVar.j(new y5.g() { // from class: eb.k
            @Override // y5.g
            public final void a(View view, int i10, Object obj) {
                s.c3(this.f4959a, view, i10, (n9.d) obj);
            }
        });
        bVar.k(new y5.h() { // from class: eb.l
            @Override // y5.h
            public final boolean a(View view, int i10, Object obj) {
                return s.h3(this.f4960a, view, i10, (n9.d) obj);
            }
        });
        this.f4977v0.K(n9.d.class, bVar);
        this.f4969n0.setAdapter(this.f4977v0);
        n8.b bVar2 = new n8.b(I(), new c());
        this.f4981z0 = bVar2;
        bVar2.p(g6.y.h(I(), g6.l.d(I()) ? 48.0f : -48.0f));
        this.f4981z0.o(new d());
        this.f4969n0.n(this.f4981z0);
    }
}
