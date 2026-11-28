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
import com.tuyafeng.support.utils.FragmentUtils;
import com.tuyafeng.support.widget.f0;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import mark.via.browser.zc;
import mark.via.common.widget.r0;
import w7.e0;
import x8.b1;
import x8.c1;
import x8.e1;
import x8.f4;
import x8.r3;
import x8.s1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t extends Fragment implements bb.i.c {
    public q5.k A0;
    public l8.b B0;
    public bb.x C0;
    public b0 D0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public r0 f4363o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public RecyclerView f4364p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public TextView f4365q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public EditText f4366r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public f0 f4367s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public f0.b f4368t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public f0.b f4369u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public f0.b f4370v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public f0.b f4371w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public t5.f f4372x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f4373y0 = false;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Uri f4374z0 = null;
    public final t8.b E0 = new t8.b();
    public final w5.a F0 = new w5.a();
    public final n8.d G0 = new n8.d(this, "application/pdf");
    public final n8.d H0 = new n8.d(this, "multipart/related");
    public final n8.d I0 = new n8.d(this, "application/zip");

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements w5.a.InterfaceC0153a {
        public a() {
        }

        @Override // w5.a.InterfaceC0153a
        public void a(int i10) {
            t.this.f4368t0.l(t.this.X0(i10 > 0 && t.this.f4372x0.g() == i10 ? w7.u.W1 : w7.u.uc));
            t.this.f4369u0.j(i10 <= 0);
            t.this.f4369u0.h(i10 > 0);
            f0.b bVar = t.this.f4369u0;
            t tVar = t.this;
            bVar.l(i10 == 0 ? tVar.X0(w7.u.f14298y) : tVar.Y0(w7.u.f14194q3, Integer.valueOf(i10)));
            t.this.f4371w0.j(i10 <= 0);
            t.this.f4367s0.l(t.this.f4368t0, t.this.f4369u0, t.this.f4371w0);
        }

        @Override // w5.a.InterfaceC0153a
        public void b(boolean z10) {
            t.this.f4372x0.l();
            t.this.F3(z10);
            if (z10) {
                a(t.this.F0.a());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends t5.i {
        public b() {
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            View viewA = w5.c.g().a(viewGroup);
            ImageView imageView = (ImageView) viewA.findViewById(w5.c.f13661e);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = com.tuyafeng.support.utils.f.d(imageView.getContext(), w7.n.f13769v);
                layoutParams.width = com.tuyafeng.support.utils.f.d(imageView.getContext(), w7.n.f13769v);
                imageView.setLayoutParams(layoutParams);
            }
            imageView.setColorFilter(com.tuyafeng.support.utils.e.a(viewA.getContext(), w7.k.f13729i));
            TextView textView = (TextView) viewA.findViewById(w5.c.f13660d);
            r3.q(textView);
            v8.g.d((TextView) viewA.findViewById(w5.c.f13659c));
            v8.g.d(textView);
            CheckBox checkBox = (CheckBox) viewA.findViewById(w5.c.f13663g);
            checkBox.setClickable(false);
            checkBox.setFocusable(false);
            return viewA;
        }

        @Override // t5.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void l(w5.g gVar, l9.d dVar, int i10) {
            int i11 = w5.c.f13663g;
            gVar.Y(i11, t.this.F0.c());
            gVar.T(i11, t.this.F0.c() && t.this.F0.d(i10));
            gVar.X(w5.c.f13659c, dVar.d());
            gVar.X(w5.c.f13660d, x8.z.v(t.this.G(), dVar.e()));
            gVar.W(w5.c.f13661e, dVar.g() ? w7.o.X : w7.o.Z);
        }

        @Override // t5.i
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void m(w5.g gVar, l9.d dVar, int i10, List list) {
            for (Object obj : list) {
                if (obj instanceof Boolean) {
                    gVar.T(w5.c.f13663g, ((Boolean) obj).booleanValue());
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements l8.a {
        public c() {
        }

        @Override // l8.a
        public boolean a(int i10) {
            return t.this.F0.d(i10);
        }

        @Override // l8.a
        public void b(int i10, boolean z10) {
            if (t.this.F0.j(i10, z10)) {
                t.this.f4372x0.n(i10, Boolean.valueOf(z10));
            }
        }

        @Override // l8.a
        public boolean c(int i10) {
            return t.this.F0.c();
        }
    }

    private void A3() {
        Bundle bundleC = p5.b.d().c("OFFLINE_CACHE");
        if (bundleC != null) {
            this.f4366r0.setText(bundleC.getString("query", ""));
        }
        ((autodispose2.n) s8.c.a(this.f4366r0).n(new u6.f() { // from class: eb.n
            @Override // u6.f
            public final void accept(Object obj) {
                this.f4358c.D0.s();
            }
        }).g(200L, TimeUnit.MILLISECONDS).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: eb.o
            @Override // u6.f
            public final void accept(Object obj) {
                t.h3(this.f4359c, (CharSequence) obj);
            }
        }, new e0());
        this.f4367s0.setOnActionClickListener(new f0.c() { // from class: eb.p
            @Override // com.tuyafeng.support.widget.f0.c
            public final void a(View view, f0.b bVar) {
                t.V2(this.f4360a, view, bVar);
            }
        });
    }

    private void E3() {
        RecyclerView recyclerView = this.f4364p0;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        p5.b.C0110b c0110bF = p5.b.a().e("OFFLINE_CACHE").f(180);
        EditText editText = this.f4366r0;
        if (editText != null) {
            c0110bF.d("query", editText.getText().toString());
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f4364p0.getLayoutManager();
        View viewJ = linearLayoutManager.J(0);
        if (viewJ != null) {
            c0110bF.b("position", linearLayoutManager.i0(viewJ)).b("offset", viewJ.getTop());
        }
        c0110bF.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F3(boolean z10) {
        this.f4370v0.l(X0(z10 ? w7.u.X3 : w7.u.E));
        this.f4368t0.k(!z10);
        this.f4369u0.k(!z10);
        this.f4371w0.k(!z10);
        this.f4367s0.l(this.f4370v0, this.f4368t0, this.f4369u0, this.f4371w0);
    }

    private void H3() {
        q5.k kVar = this.A0;
        if (kVar != null) {
            kVar.h0();
            return;
        }
        q5.k kVarV = q5.k.l(G()).Z(w7.u.si).u(false).v(false);
        this.A0 = kVarV;
        kVarV.h0();
    }

    public static /* synthetic */ Boolean S2(t tVar, Uri uri) {
        tVar.getClass();
        boolean z10 = false;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(b1.i(tVar.G(), tVar.f4374z0));
            try {
                OutputStream outputStreamL = b1.l(tVar.G(), uri);
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
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                            throw th;
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        try {
                            outputStreamL.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
                if (outputStreamL != null) {
                    outputStreamL.close();
                }
                bufferedInputStream.close();
            } catch (Throwable th4) {
                bufferedInputStream.close();
                throw th4;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (z10) {
            tVar.D3(tVar.f4374z0, uri);
        }
        return Boolean.valueOf(z10);
    }

    public static /* synthetic */ void T2(t tVar, l9.d dVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        tVar.getClass();
        boolean zG = dVar.g();
        switch ((int) j10) {
            case 1:
                tVar.B3(dVar, 2);
                break;
            case 2:
                try {
                    tVar.N2(Intent.createChooser(e1.i(tVar.G(), dVar.a(), dVar.c()), tVar.X0(w7.u.H9)));
                } catch (Exception e10) {
                    tc.a.j(e10);
                    return;
                }
                break;
            case 3:
                tVar.f4374z0 = dVar.a();
                try {
                    if (!zG) {
                        tVar.H0.d(dVar.d() + ".mht", new q(tVar));
                    } else {
                        tVar.G0.d(dVar.d() + ".pdf", new q(tVar));
                    }
                } catch (Exception e11) {
                    tc.a.j(e11);
                    return;
                }
                break;
            case 4:
                tVar.r3(dVar, i10);
                break;
            case 5:
            case 6:
                tVar.B3(dVar, j10 != 5 ? 1 : 2);
                break;
            case 7:
                e1.m(tVar.G(), dVar.a(), dVar.c());
                break;
        }
    }

    public static /* synthetic */ void U2(t tVar, String str, Boolean bool) {
        tVar.t3();
        if (bool.booleanValue()) {
            if (str != null) {
                com.tuyafeng.support.utils.n.l(tVar.G(), w7.u.I3, tVar.G().getString(w7.u.f14112k5, str));
            } else {
                com.tuyafeng.support.utils.n.q(tVar.G(), w7.u.f14154n5);
            }
        }
    }

    public static /* synthetic */ void V2(t tVar, View view, f0.b bVar) {
        tVar.getClass();
        int iA = bVar.a();
        if (iA == w7.p.N0) {
            w5.a aVar = tVar.F0;
            aVar.k(!aVar.c());
            return;
        }
        if (iA != w7.p.S0) {
            if (iA == w7.p.M0) {
                tVar.s3();
                return;
            } else {
                if (iA == w7.p.O0) {
                    tVar.w3();
                    return;
                }
                return;
            }
        }
        int iG = tVar.f4372x0.g();
        if (iG == 0) {
            return;
        }
        if (iG == tVar.F0.a()) {
            tVar.F0.l(0, iG);
        } else {
            tVar.F0.f(0, iG);
        }
        tVar.f4372x0.q(0, iG);
    }

    public static /* synthetic */ void W2(t tVar, int[] iArr, View view, q5.k.p pVar) {
        tVar.getClass();
        for (int i10 : iArr) {
            if (tVar.D0.v(i10) != null) {
                w5.b bVarC = tVar.E0.c(i10);
                tVar.E0.f(i10);
                tVar.f4372x0.u(i10);
                if (bVarC.c()) {
                    tVar.f4372x0.n(i10 - 1, 1);
                }
            }
        }
        tVar.F0.k(false);
    }

    public static /* synthetic */ boolean X2(t tVar, View view, int i10, l9.d dVar) {
        if (tVar.F0.c()) {
            tVar.B0.n(true, i10);
            return true;
        }
        tVar.G3(view, dVar, i10);
        return true;
    }

    public static /* synthetic */ void Y2(t tVar, List list) {
        RecyclerView recyclerView;
        tVar.E0.g(list, new t8.c() { // from class: eb.s
            @Override // t8.c
            public final long a(Object obj) {
                return ((l9.d) obj).b();
            }
        });
        tVar.f4372x0.M(list);
        tVar.f4372x0.l();
        if (tVar.f4373y0) {
            return;
        }
        tVar.f4373y0 = true;
        Bundle bundleC = p5.b.d().c("OFFLINE_CACHE");
        if (bundleC == null || (recyclerView = tVar.f4364p0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutManager) tVar.f4364p0.getLayoutManager()).B2(bundleC.getInt("position", 0), bundleC.getInt("offset", 0));
    }

    public static /* synthetic */ void a3(t tVar, int i10, View view, q5.k.p pVar) {
        if (tVar.D0.v(i10) != null) {
            w5.b bVarC = tVar.E0.c(i10);
            tVar.E0.f(i10);
            tVar.f4372x0.u(i10);
            if (bVarC.c()) {
                tVar.f4372x0.n(i10 - 1, 1);
            }
        }
    }

    public static /* synthetic */ void b3(t tVar, Boolean bool) {
        tVar.f4363o0.setSearchVisible(tVar.f4366r0.length() > 0 || !bool.booleanValue());
        tVar.f4363o0.setEmpty(bool.booleanValue());
        tVar.f4370v0.j(bool.booleanValue());
        tVar.f4367s0.j(tVar.f4370v0);
    }

    public static /* synthetic */ Boolean c3(t tVar, String str, List list, Uri uri) {
        tVar.getClass();
        if (!f4.c(str, list) || !b1.b(tVar.G(), Uri.fromFile(new File(str)), uri)) {
            return Boolean.FALSE;
        }
        c1.g(str);
        return Boolean.TRUE;
    }

    public static /* synthetic */ void e3(t tVar, String str, Boolean bool) {
        tVar.getClass();
        if (bool.booleanValue()) {
            if (str != null) {
                com.tuyafeng.support.utils.n.l(tVar.G(), w7.u.I3, tVar.G().getString(w7.u.f14112k5, str));
            } else {
                com.tuyafeng.support.utils.n.q(tVar.G(), w7.u.f14154n5);
            }
        }
    }

    public static /* synthetic */ void g3(t tVar, View view, int i10, l9.d dVar) {
        if (!tVar.F0.c()) {
            tVar.B3(dVar, 0);
        } else {
            tVar.F0.h(i10);
            tVar.f4372x0.n(i10, Boolean.valueOf(tVar.F0.d(i10)));
        }
    }

    public static /* synthetic */ void h3(t tVar, CharSequence charSequence) {
        tVar.D0.w(charSequence.toString());
        tVar.F0.k(false);
    }

    public static /* synthetic */ void i3(t tVar, Throwable th) {
        tVar.t3();
        tc.a.j(th);
    }

    private void t3() {
        q5.k kVar = this.A0;
        if (kVar == null) {
            return;
        }
        kVar.o();
        this.A0 = null;
    }

    private void y3() {
        this.F0.i(new a());
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        r0 r0Var = (r0) new b6.a(new r0(G()), new ViewGroup.LayoutParams(-1, -1)).l();
        RecyclerView recyclerView = r0Var.f10038c;
        this.f4364p0 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.E0.h(new t8.a(G()));
        Context contextG = G();
        t8.b bVar = this.E0;
        Objects.requireNonNull(bVar);
        x5.b bVar2 = new x5.b(contextG, new zc(bVar));
        bVar2.o(1);
        bVar2.n(com.tuyafeng.support.utils.e.a(G(), w7.k.f13722b));
        this.f4364p0.k(bVar2);
        this.f4364p0.n(bVar2);
        this.f4366r0 = r0Var.f10041n;
        r0Var.setSearchVisible(false);
        this.f4365q0 = r0Var.f10040m;
        this.f4367s0 = r0Var.f10042o;
        f0.b bVar3 = new f0.b(w7.p.S0, X0(w7.u.uc));
        this.f4368t0 = bVar3;
        bVar3.k(true);
        f0.b bVar4 = new f0.b(w7.p.M0, X0(w7.u.f14298y));
        this.f4369u0 = bVar4;
        bVar4.i(true);
        this.f4369u0.j(true);
        this.f4369u0.k(true);
        f0.b bVar5 = new f0.b(w7.p.O0, X0(w7.u.f14042f5));
        this.f4371w0 = bVar5;
        bVar5.j(true);
        this.f4371w0.k(true);
        this.f4370v0 = new f0.b(w7.p.N0, X0(w7.u.E));
        this.f4367s0.b(this.f4368t0);
        this.f4367s0.b(this.f4369u0);
        this.f4367s0.b(this.f4371w0);
        this.f4367s0.c(this.f4370v0);
        this.f4363o0 = r0Var;
        return r0Var;
    }

    public final void B3(l9.d dVar, int i10) {
        if (dVar.g()) {
            C3(dVar.f());
        } else {
            this.C0.K(dVar.f(), i10);
        }
    }

    public final void C3(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        FragmentUtils.j(K0(), za.g.class, p5.a.b().e("pdfPath", str).a());
    }

    public final void D3(Uri uri, Uri uri2) {
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
                tc.a.b(e10);
            }
        }
    }

    public final void G3(View view, final l9.d dVar, final int i10) {
        ArrayList arrayList = new ArrayList();
        if (dVar.g()) {
            arrayList.add(new q5.k.l(1, X0(w7.u.X)));
            arrayList.add(new q5.k.l(2, X0(w7.u.H9)));
        } else {
            arrayList.add(new q5.k.l(5, X0(w7.u.R)));
            arrayList.add(new q5.k.l(6, X0(w7.u.S)));
        }
        arrayList.add(new q5.k.l(7, X0(w7.u.f14037f0)));
        arrayList.add(new q5.k.l(3, X0(w7.u.f14042f5)));
        arrayList.add(new q5.k.l(4, X0(w7.u.f14298y)));
        q5.k.l(G()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: eb.c
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                t.T2(this.f4336a, dVar, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void M1() {
        E3();
        super.M1();
    }

    @Override // bb.i.c
    public boolean S() {
        if (this.F0.c()) {
            this.F0.k(false);
            return true;
        }
        if (this.f4366r0.getText().length() <= 0) {
            return false;
        }
        this.f4366r0.setText("");
        this.f4366r0.clearFocus();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        y3();
        x3();
        A3();
        z3();
    }

    @Override // bb.i.c
    public boolean l() {
        return !this.F0.c() && this.f4366r0.getText().length() == 0;
    }

    public final void r3(l9.d dVar, final int i10) {
        if (dVar == null) {
            return;
        }
        q5.k.l(G()).f0(w7.u.f14298y).K(Y0(w7.u.f14222s3, dVar.d())).X(R.string.ok, new q5.k.m() { // from class: eb.j
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                t.a3(this.f4353a, i10, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void s3() {
        String strY0;
        if (!this.F0.c() || this.F0.a() <= 0) {
            return;
        }
        final int[] iArrB = this.F0.b(true);
        if (iArrB.length == 1) {
            List list = (List) this.D0.r().e();
            if (list == null || iArrB[0] >= list.size()) {
                return;
            }
            strY0 = Y0(w7.u.f14222s3, ((l9.d) list.get(iArrB[0])).d());
        } else {
            strY0 = Y0(w7.u.f14236t3, Integer.valueOf(iArrB.length));
        }
        q5.k.l(G()).f0(w7.u.f14298y).K(strY0).X(R.string.ok, new q5.k.m() { // from class: eb.d
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                t.W2(this.f4340a, iArrB, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).d().a().a(this);
    }

    public final void u3(final Uri uri, final String str) {
        if (uri == null || this.f4374z0 == null) {
            return;
        }
        ((autodispose2.n) r6.j.v(new Callable() { // from class: eb.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t.S2(this.f4349c, uri);
            }
        }).G(a7.a.c()).C(q6.b.b()).L(s8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: eb.i
            @Override // u6.f
            public final void accept(Object obj) {
                t.e3(this.f4351c, str, (Boolean) obj);
            }
        }, new w7.a0());
    }

    public final void v3(final Uri uri, final String str) {
        List list;
        final String strK;
        l9.d dVar;
        String path;
        if (uri == null) {
            return;
        }
        int[] iArrB = this.F0.b(false);
        if (iArrB.length == 0 || (list = (List) this.D0.r().e()) == null || (strK = c1.k(G(), "temp", UUID.randomUUID().toString())) == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (int i10 : iArrB) {
            if (i10 < list.size() && (dVar = (l9.d) list.get(i10)) != null && dVar.a() != null && (path = dVar.a().getPath()) != null && !path.isEmpty()) {
                arrayList.add(new File(path));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        H3();
        ((autodispose2.n) r6.j.v(new Callable() { // from class: eb.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t.c3(this.f4342c, strK, arrayList, uri);
            }
        }).G(a7.a.c()).C(q6.b.b()).L(s8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: eb.f
            @Override // u6.f
            public final void accept(Object obj) {
                t.U2(this.f4346c, str, (Boolean) obj);
            }
        }, new u6.f() { // from class: eb.g
            @Override // u6.f
            public final void accept(Object obj) {
                t.i3(this.f4348c, (Throwable) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.C0 = (bb.x) new androidx.lifecycle.a0(z2(), la.s.n()).a(bb.x.class);
    }

    public final void w3() {
        List list;
        int iA = this.F0.c() ? this.F0.a() : 0;
        if (iA <= 0) {
            return;
        }
        if (iA != 1) {
            this.I0.d(String.format(Locale.getDefault(), "%s_%s.zip", X0(w7.u.f14009d0), s1.d()), new n8.d.a() { // from class: eb.r
                @Override // n8.d.a
                public final void a(Uri uri, String str) {
                    this.f4362a.v3(uri, str);
                }
            });
            return;
        }
        int[] iArrB = this.F0.b(false);
        if (iArrB.length == 0 || (list = (List) this.D0.r().e()) == null || iArrB[0] >= list.size()) {
            return;
        }
        l9.d dVar = (l9.d) list.get(iArrB[0]);
        this.f4374z0 = dVar.a();
        try {
            if (dVar.g()) {
                this.G0.d(dVar.d() + ".pdf", new q(this));
                return;
            }
            this.H0.d(dVar.d() + ".mht", new q(this));
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    public final void x3() {
        this.f4372x0 = new t5.f(new ArrayList());
        b bVar = new b();
        bVar.j(new t5.g() { // from class: eb.l
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                t.g3(this.f4356a, view, i10, (l9.d) obj);
            }
        });
        bVar.k(new t5.h() { // from class: eb.m
            @Override // t5.h
            public final boolean a(View view, int i10, Object obj) {
                return t.X2(this.f4357a, view, i10, (l9.d) obj);
            }
        });
        this.f4372x0.K(l9.d.class, bVar);
        this.f4364p0.setAdapter(this.f4372x0);
        l8.b bVar2 = new l8.b(G(), new c());
        this.B0 = bVar2;
        bVar2.p(com.tuyafeng.support.utils.x.h(G(), com.tuyafeng.support.utils.l.d(G()) ? 48.0f : -48.0f));
        this.B0.o(new d());
        this.f4364p0.n(this.B0);
    }

    public final void z3() {
        this.D0.r().g(b1(), new androidx.lifecycle.o() { // from class: eb.b
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                t.Y2(this.f4330a, (List) obj);
            }
        });
        this.D0.t().g(b1(), new androidx.lifecycle.o() { // from class: eb.k
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                t.b3(this.f4355a, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements l8.b.InterfaceC0093b {
        public d() {
        }

        @Override // l8.b.InterfaceC0093b
        public void a(boolean z10) {
            t.this.C0.P(!z10);
        }

        @Override // l8.b.InterfaceC0093b
        public void b(boolean z10) {
        }
    }
}
