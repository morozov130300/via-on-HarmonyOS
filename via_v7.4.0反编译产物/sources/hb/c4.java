package hb;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import c8.lc;
import com.tuyafeng.support.widget.c;
import h6.a;
import hb.c4;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import mark.via.data.backup2.ZipBackupManager;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p8.d;
import p8.f;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c4 extends o8.g {
    public String G0;

    /* renamed from: r0, reason: collision with root package name */
    public w9.l f6501r0;

    /* renamed from: s0, reason: collision with root package name */
    public u4.a f6502s0;

    /* renamed from: t0, reason: collision with root package name */
    public o9.c f6503t0;

    /* renamed from: v0, reason: collision with root package name */
    public y5.f f6505v0;

    /* renamed from: u0, reason: collision with root package name */
    public String f6504u0 = "";

    /* renamed from: w0, reason: collision with root package name */
    public ZipBackupManager f6506w0 = null;

    /* renamed from: x0, reason: collision with root package name */
    public int f6507x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    public w5.k f6508y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    public final androidx.activity.result.b f6509z0 = y2(new x5.d(), new androidx.activity.result.a() { // from class: hb.g3
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            c4.L3(this.f6557a, (Uri) obj);
        }
    });
    public String[][] A0 = (String[][]) Array.newInstance((Class<?>) String.class, 0, 0);
    public int B0 = 0;
    public final List C0 = new ArrayList();
    public int D0 = 0;
    public com.tuyafeng.support.widget.c E0 = null;
    public final wa.a F0 = new wa.r(this);
    public final p8.d H0 = new p8.d(this, "application/zip");
    public final p8.f I0 = new p8.f(this);
    public final p8.d J0 = new p8.d(this, "text/html");

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends wa.s {
        public a(Context context) {
            super(context);
        }

        public static /* synthetic */ void b(a aVar, View view, k.p pVar) {
            c4.this.G0 = g6.p.n(pVar.f13339c[0], "3_=cZHGxZ#FZgZA@");
            c4.this.e4();
        }

        @Override // wa.b
        public void onSuccess() {
            w5.k.l(c4.this.I()).d0(x7.u.B4).I(x7.u.C4).i("", c4.this.Z0(x7.u.f14033j6), 1).V(R.string.ok, new k.m() { // from class: hb.b4
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    c4.a.b(this.f6480a, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
        }
    }

    public static /* synthetic */ void A3(c4 c4Var, Throwable th) {
        c4Var.a4();
        pc.a.i(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A4(View view, int i10, a6.n nVar) {
        int iC = nVar.c();
        if (iC == 17) {
            nVar.j(!nVar.i());
            this.f6501r0.X0(nVar.i());
            this.f6505v0.m(i10);
            return;
        }
        if (iC != 29) {
            if (iC != 33) {
                return;
            }
            nVar.j(!nVar.i());
            w9.a aVarV = this.f6501r0.v();
            aVarV.L(nVar.i());
            this.f6501r0.q0(aVarV);
            this.f6505v0.m(i10);
            return;
        }
        boolean zI = nVar.i();
        boolean z10 = !zI;
        if (zI || !(this.f6501r0.x0() == 0 || this.f6501r0.x0() == 3)) {
            w9.a aVarV2 = this.f6501r0.v();
            nVar.j(z10);
            aVarV2.M(z10);
            this.f6501r0.q0(aVarV2);
            this.f6505v0.m(i10);
            return;
        }
        int iJ4 = j4(8);
        a6.q qVarL4 = l4(iJ4);
        if (qVarL4 == null) {
            return;
        }
        g6.n.q(I(), x7.u.qg);
        L4(qVarL4, iJ4, true);
    }

    public static /* synthetic */ void B3(c4 c4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 != 0) {
            c4Var.H4();
        } else {
            c4Var.f6501r0.p(null);
            c4Var.M4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B4(View view, final int i10, final a6.q qVar) {
        switch (qVar.c()) {
            case 2:
                g6.i.g(this, y7.class);
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                z8.h0.e(I(), this.f6501r0, pa.r.m().d(), pa.r.l(), pa.r.f());
                break;
            case 4:
                g6.i.g(this, z7.d.class);
                break;
            case 5:
                g6.i.g(this, jb.y4.class);
                break;
            case 6:
                g6.i.g(this, p4.class);
                break;
            case 7:
                h4(qVar, i10);
                break;
            case 8:
                L4(qVar, i10, false);
                break;
            case 9:
                t4(qVar, i10);
                break;
            case 10:
                n4(qVar, i10);
                break;
            case 11:
                g6.i.g(this, w5.class);
                break;
            case 12:
                I4(qVar, i10);
                break;
            case 13:
                w5.k.l(I()).d0(x7.u.P9).Z(x7.j.f13650g, this.f6501r0.i0() - 1, new AdapterView.OnItemClickListener() { // from class: hb.m2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        c4.w3(this.f6655a, qVar, i10, adapterView, view2, i11, j10);
                    }
                }).f0();
                break;
            case 14:
                b4();
                break;
            case 15:
                w5.k.l(I()).d0(x7.u.A0).b0(this.A0[1], this.B0, new AdapterView.OnItemClickListener() { // from class: hb.q2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        c4.p3(this.f6717a, qVar, i10, adapterView, view2, i11, j10);
                    }
                }).f0();
                break;
            case 16:
                w5.k.l(I()).d0(x7.u.oh).Z(x7.j.f13653j, this.f6501r0.g1(), new AdapterView.OnItemClickListener() { // from class: hb.n2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        c4.r3(this.f6671a, qVar, i10, adapterView, view2, i11, j10);
                    }
                }).f0();
                break;
            case 18:
                z8.h0.f(I(), this.f6501r0);
                break;
            case 19:
                g6.i.g(this, u4.class);
                break;
            case 20:
                w5.k.l(I()).d0(x7.u.L6).F(new String[]{I().getString(x7.u.T4), I().getString(x7.u.F6)}, new AdapterView.OnItemClickListener() { // from class: hb.o2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        c4.O3(this.f6686a, adapterView, view2, i11, j10);
                    }
                }).f0();
                break;
            case 21:
                q4();
                break;
            case 22:
                this.f6507x0 = 31;
                f4();
                break;
            case 23:
                w5.k.l(I()).d0(x7.u.f14094nb).Z(x7.j.f13649f, this.f6501r0.u1(), new AdapterView.OnItemClickListener() { // from class: hb.p2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        c4.V3(this.f6702a, qVar, i10, adapterView, view2, i11, j10);
                    }
                }).f0();
                break;
            case 24:
                z8.b0.W(I());
                break;
            case 25:
                J4();
                break;
            case 26:
                g6.i.g(this, a7.class);
                break;
            case 27:
                int size = this.C0.size();
                String[] strArr = new String[size];
                for (int i11 = 0; i11 < size; i11++) {
                    strArr[i11] = (String) ((w.d) this.C0.get(i11)).f13208b;
                }
                w5.k.l(I()).d0(x7.u.f13934c5).I(x7.u.f13948d5).b0(strArr, this.D0, new AdapterView.OnItemClickListener() { // from class: hb.r2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                        c4.U3(this.f6729a, qVar, i10, adapterView, view2, i12, j10);
                    }
                }).f0();
                break;
            case 28:
                g6.i.g(this, i8.s.class);
                break;
            case 30:
                g6.i.g(this, o5.class);
                break;
            case 31:
                g6.i.g(this, b6.class);
                break;
            case 32:
                g6.i.g(this, n7.class);
                break;
            case 34:
                g6.i.g(this, a9.o.class);
                break;
            case 35:
                g6.i.g(this, j2.class);
                break;
            case 36:
                g6.i.g(this, va.c1.class);
                break;
            case 37:
                g6.i.g(this, i8.w.class);
                break;
        }
    }

    public static /* synthetic */ void E3(c4 c4Var, a6.q qVar, int i10, View view, k.p pVar) {
        c4Var.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        String strV = i6.i0.f7006a.v(pVar.f13339c[0], null);
        if (strV.contains("://")) {
            c4Var.f6501r0.x1(strV);
            qVar.h(strV);
            w9.n.e().y(true);
            c4Var.f6505v0.m(i10);
        }
    }

    public static /* synthetic */ void F3(c4 c4Var, Integer num) {
        c4Var.a4();
        if (num.intValue() <= 0) {
            g6.n.q(c4Var.I(), x7.u.E6);
        } else {
            g6.n.s(c4Var.I(), c4Var.a1(x7.u.D1, num));
            c4Var.z4();
        }
    }

    public static /* synthetic */ void G3(c4 c4Var, String str) {
        int iJ4;
        a6.q qVarL4;
        if (c4Var.f6505v0 == null || (iJ4 = c4Var.j4(2)) < 0 || (qVarL4 = c4Var.l4(iJ4)) == null) {
            return;
        }
        qVarL4.h(str);
        c4Var.f6505v0.m(iJ4);
    }

    public static /* synthetic */ Integer H3(c4 c4Var, Uri uri) throws IOException {
        c4Var.getClass();
        int iR = 0;
        try {
            OutputStream outputStreamL = z8.b1.l(c4Var.I(), uri);
            try {
                iR = z8.p.r(outputStreamL, w.d.a(c4Var.f6503t0.k(), c4Var.f6503t0.u()));
                if (outputStreamL != null) {
                    outputStreamL.close();
                }
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
        }
        return Integer.valueOf(iR);
    }

    public static /* synthetic */ void I3(c4 c4Var, Throwable th) {
        c4Var.a4();
        pc.a.i(th);
    }

    public static /* synthetic */ void L3(c4 c4Var, Uri uri) {
        if (uri == null) {
            c4Var.getClass();
            return;
        }
        c4Var.I().getContentResolver().takePersistableUriPermission(uri, 3);
        c4Var.f6501r0.p(uri.toString());
        c4Var.M4();
    }

    public static /* synthetic */ void M3(c4 c4Var, Throwable th) {
        c4Var.a4();
        pc.a.i(th);
    }

    public static /* synthetic */ void N3(c4 c4Var, String str, Integer num) {
        c4Var.a4();
        if (num.intValue() == 0) {
            g6.n.q(c4Var.I(), x7.u.K8);
        } else if (num.intValue() > 0) {
            if (str == null) {
                g6.n.q(c4Var.I(), x7.u.C1);
            } else {
                g6.n.m(c4Var.I(), c4Var.Z0(x7.u.f14193v3), c4Var.a1(x7.u.U4, str));
            }
        }
    }

    public static /* synthetic */ void O3(c4 c4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            c4Var.c4();
        } else if (i10 == 1) {
            c4Var.o4();
        } else {
            c4Var.getClass();
        }
    }

    public static /* synthetic */ void P3(c4 c4Var, Throwable th) {
        c4Var.a4();
        pc.a.i(th);
    }

    public static /* synthetic */ void R3(c4 c4Var, a6.q qVar, int i10, w5.k kVar, int i11) {
        c4Var.f6501r0.u2(i11);
        w9.n.e().y(true);
        qVar.h(g6.e.c(c4Var.I(), x7.j.f13646c, i11));
        c4Var.f6505v0.m(i10);
        kVar.n();
    }

    public static /* synthetic */ void S3(c4 c4Var, Uri uri, View view, k.p pVar) {
        c4Var.getClass();
        c4Var.s4(uri, g6.p.n(pVar.f13339c[0], "3_=cZHGxZ#FZgZA@"));
    }

    public static /* synthetic */ void T3(c4 c4Var, a6.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == 3) {
            c4Var.m4(qVar, i10);
            return;
        }
        c4Var.f6501r0.x1(new String[]{"about:home", "about:blank", "about:bookmarks"}[i11]);
        qVar.h(g6.e.c(c4Var.I(), x7.j.f13647d, i11));
        c4Var.f6505v0.m(i10);
        w9.n.e().y(true);
    }

    public static /* synthetic */ void U3(c4 c4Var, a6.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        c4Var.f6501r0.K1((String) ((w.d) c4Var.C0.get(i11)).f13207a);
        qVar.h((String) ((w.d) c4Var.C0.get(i11)).f13208b);
        c4Var.f6505v0.m(i10);
        c4Var.D0 = i11;
    }

    public static /* synthetic */ void V3(c4 c4Var, a6.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        c4Var.f6501r0.A0(i11);
        qVar.h(g6.e.c(c4Var.I(), x7.j.f13649f, i11));
        c4Var.f6505v0.m(i10);
        if (i11 != 0) {
            g6.n.q(c4Var.I(), x7.u.f14122pb);
        }
    }

    public static /* synthetic */ void W3(c4 c4Var, int i10, String[] strArr, a6.q qVar, int i11, AdapterView adapterView, View view, int i12, long j10) {
        if (i10 == i12) {
            c4Var.getClass();
            return;
        }
        c4Var.f6501r0.z1(strArr[i12]);
        w9.n.e().p(true);
        c4Var.f6501r0.q2(w9.n.e().a());
        qVar.h(z8.g1.a(strArr[i12], c4Var.Z0(x7.u.H5)));
        c4Var.f6505v0.m(i11);
        c4Var.G4();
    }

    public static /* synthetic */ void g3(c4 c4Var, String str, Boolean bool) {
        c4Var.a4();
        if (bool.booleanValue()) {
            if (str != null) {
                g6.n.l(c4Var.I(), x7.u.f14193v3, c4Var.I().getString(x7.u.X4, str));
            } else {
                g6.n.q(c4Var.I(), x7.u.T2);
            }
        }
    }

    public static /* synthetic */ void h3(c4 c4Var, a6.q qVar, int i10, w5.k kVar, boolean z10, int i11) {
        a6.n nVarK4;
        c4Var.f6501r0.j(i11);
        qVar.h(g6.e.c(c4Var.I(), x7.j.f13651h, i11));
        c4Var.f6505v0.m(i10);
        kVar.n();
        int iJ4 = c4Var.j4(29);
        if (iJ4 >= 0 && (nVarK4 = c4Var.k4(iJ4)) != null) {
            boolean z11 = (i11 == 3 || i11 == 0 || (!nVarK4.i() && !z10)) ? false : true;
            w9.a aVarV = c4Var.f6501r0.v();
            if (aVarV.t() != z11) {
                aVarV.M(z11);
                c4Var.f6501r0.q0(aVarV);
            }
            if (z11 != nVarK4.i()) {
                nVarK4.j(z11);
                c4Var.f6505v0.m(iJ4);
            }
        }
    }

    public static /* synthetic */ void j3(c4 c4Var, String str, String[][] strArr) {
        c4Var.A0 = strArr;
        c4Var.B0 = 0;
        int i10 = 0;
        while (true) {
            String[] strArr2 = strArr[0];
            if (i10 >= strArr2.length) {
                break;
            }
            if (strArr2[i10].equals(str)) {
                c4Var.B0 = i10;
                break;
            }
            i10++;
        }
        c4Var.N4(15, c4Var.A0[1][c4Var.B0]);
    }

    public static /* synthetic */ void k3(c4 c4Var, View view, k.p pVar) {
        c4Var.getClass();
        int[] iArr = pVar.f13337a;
        if (iArr == null || iArr.length == 0) {
            return;
        }
        c4Var.f6507x0 = 0;
        for (int i10 : iArr) {
            if (i10 == 0) {
                c4Var.f6507x0 |= 2;
            } else if (i10 == 1) {
                c4Var.f6507x0 |= 4;
            } else if (i10 == 2) {
                c4Var.f6507x0 |= 8;
            } else if (i10 == 3) {
                c4Var.f6507x0 |= 16;
            } else if (i10 == 4) {
                c4Var.f6507x0 |= 1;
            } else if (i10 == 5) {
                c4Var.f6507x0 |= 32;
            }
        }
        if ((c4Var.f6507x0 & 32) != 0 && pa.r.i().j()) {
            c4Var.f6507x0 &= -33;
        }
        if (c4Var.f6507x0 != 0) {
            c4Var.F4();
        }
    }

    public static /* synthetic */ void m3(c4 c4Var, View view, k.p pVar) {
        c4Var.getClass();
        int[] iArr = pVar.f13337a;
        int i10 = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i11 = 0;
            while (i10 < length) {
                i11 += 1 << iArr[i10];
                i10++;
            }
            i10 = i11;
        }
        c4Var.f6501r0.f(i10);
        w9.n.e().w(true);
    }

    public static /* synthetic */ Integer n3(c4 c4Var, Uri uri) throws IOException {
        c4Var.getClass();
        try {
            InputStream inputStreamI = z8.b1.i(c4Var.I(), uri);
            try {
                Integer numValueOf = Integer.valueOf(c4Var.f6503t0.z(z8.p.q(inputStreamI)));
                if (inputStreamI != null) {
                    inputStreamI.close();
                }
                return numValueOf;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return 0;
        }
    }

    public static /* synthetic */ Boolean o3(c4 c4Var, String str, Uri uri) {
        String strK = z8.c1.k(c4Var.I(), "temp", UUID.randomUUID().toString() + ".zip");
        ZipBackupManager zipBackupManagerI4 = c4Var.i4();
        return (strK == null || !zipBackupManagerI4.a(new File(strK), c4Var.f6507x0, str)) ? Boolean.valueOf(zipBackupManagerI4.b(z8.b1.l(c4Var.I(), uri), c4Var.f6507x0, str)) : Boolean.valueOf(z8.b1.b(c4Var.I(), Uri.fromFile(new File(strK)), uri));
    }

    public static /* synthetic */ void p3(c4 c4Var, a6.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        c4Var.f6501r0.E0(c4Var.A0[0][i11]);
        qVar.h(c4Var.A0[1][i11]);
        c4Var.f6505v0.m(i10);
        c4Var.B0 = i11;
    }

    public static /* synthetic */ void q3(c4 c4Var, Integer num) {
        c4Var.a4();
        g6.n.q(c4Var.I(), num.intValue());
        if (num.intValue() == x7.u.K6 || num.intValue() == x7.u.H6) {
            c4Var.u4();
        }
    }

    public static /* synthetic */ void r3(c4 c4Var, a6.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        c4Var.f6501r0.C0(i11);
        qVar.h(g6.e.c(c4Var.I(), x7.j.f13653j, i11));
        c4Var.f6505v0.m(i10);
    }

    public static /* synthetic */ Integer s3(c4 c4Var, Uri uri, String str) throws Throwable {
        String strK = z8.b1.k(c4Var.I(), uri);
        long j10 = z8.b1.j(c4Var.I(), uri);
        if (strK == null || j10 <= 0) {
            return Integer.valueOf(x7.u.I6);
        }
        if (j10 > 67108864) {
            return Integer.valueOf(x7.u.J6);
        }
        if (!strK.toLowerCase(Locale.ROOT).endsWith(".zip")) {
            StringBuilder sb2 = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(z8.b1.i(c4Var.I(), uri)));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line);
                    } finally {
                    }
                }
                bufferedReader.close();
            } catch (Exception e10) {
                pc.a.i(e10);
            }
            return Integer.valueOf(l9.d.b(c4Var.f6501r0, pa.r.f(), pa.r.k(), c4Var.f6502s0, lc.c().d(), pa.r.d(), sb2.toString()) ? x7.u.K6 : x7.u.I6);
        }
        String strK2 = z8.c1.k(c4Var.I(), "temp", UUID.randomUUID().toString() + ".zip");
        Uri uriFromFile = strK2 == null ? null : Uri.fromFile(new File(strK2));
        Uri uri2 = (uriFromFile == null || z8.b1.b(c4Var.I(), uri, Uri.fromFile(new File(strK2)))) ? uriFromFile : null;
        ZipBackupManager zipBackupManagerI4 = c4Var.i4();
        Context contextI = c4Var.I();
        if (uri2 != null) {
            uri = uri2;
        }
        ZipBackupManager.RestoreResult restoreResultE = zipBackupManagerI4.e(z8.b1.i(contextI, uri), str);
        if (restoreResultE == ZipBackupManager.RestoreResult.ENCRYPTED_DATA_SKIPPED) {
            return Integer.valueOf(x7.u.H6);
        }
        return Integer.valueOf(restoreResultE == ZipBackupManager.RestoreResult.SUCCESS ? x7.u.K6 : x7.u.I6);
    }

    public static /* synthetic */ void u3(c4 c4Var, View view, k.p pVar) {
        c4Var.getClass();
        String[] strArr = pVar.f13339c;
        String strM = strArr.length > 0 ? z8.c1.m(strArr[0]) : null;
        if (strM == null || strM.isEmpty()) {
            strM = null;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), strM);
        c4Var.f6501r0.p((file.isDirectory() || file.mkdirs()) ? strM : null);
        c4Var.M4();
    }

    private void u4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a6.q(26, Z0(x7.u.sd)));
        arrayList.add(new a6.q(2, Z0(x7.u.C0)));
        arrayList.add(new a6.q(3, Z0(x7.u.Z1)));
        arrayList.add(new a6.q(4, Z0(x7.u.f14165t1)));
        arrayList.add(new a6.q(5, Z0(x7.u.Ic)));
        arrayList.add(new a6.q(36, Z0(x7.u.f13995ga)));
        arrayList.add(new a6.q(6, Z0(x7.u.P)));
        arrayList.add(new a6.q(30, Z0(x7.u.Na)));
        arrayList.add(new a6.q(32, Z0(x7.u.Hg)));
        arrayList.add(new a6.q(28, Z0(x7.u.R2)));
        arrayList.add(new a6.q(37, Z0(x7.u.Q2)));
        arrayList.add(new a6.q(9, Z0(x7.u.f14197v7), z8.g1.a(this.f6501r0.K0(), Z0(x7.u.H5))));
        int iB = this.f6501r0.B();
        arrayList.add(new a6.q(10, Z0(x7.u.f14144r6), iB == 3 ? this.f6501r0.n() : g6.e.c(I(), x7.j.f13647d, iB)));
        arrayList.add(new a6.q(31, Z0(x7.u.Zb)));
        arrayList.add(new a6.q(34, Z0(x7.u.R0)));
        boolean zA = z8.n3.a(I());
        a6.q qVar = new a6.q(13, Z0(x7.u.P9), g6.e.c(I(), x7.j.f13650g, zA ? this.f6501r0.i0() - 1 : 0));
        qVar.g(!zA);
        arrayList.add(qVar);
        arrayList.add(new a6.q(14, Z0(x7.u.M3), this.f6501r0.P(I())));
        this.A0 = new String[][]{new String[]{""}, new String[]{Z0(x7.u.E1)}};
        this.B0 = 0;
        a6.q qVar2 = new a6.q(15, Z0(x7.u.A0), this.A0[1][this.B0]);
        qVar2.g(true);
        arrayList.add(qVar2);
        this.C0.clear();
        this.C0.add(w.d.a("", Z0(x7.u.f14213wa)));
        this.D0 = 0;
        a6.q qVar3 = new a6.q(27, Z0(x7.u.f13934c5), (String) ((w.d) this.C0.get(this.D0)).f13208b);
        qVar3.g(true);
        arrayList.add(qVar3);
        arrayList.add(new a6.q(18, Z0(x7.u.f13903a2)));
        arrayList.add(new a6.q(35, Z0(x7.u.K5), this.f6501r0.a1()));
        arrayList.add(new a6.q(19, Z0(x7.u.sc), Z0(x7.u.C9)));
        arrayList.add(new a6.q(20, Z0(x7.u.L6)));
        arrayList.add(new a6.q(21, Z0(x7.u.G6)));
        arrayList.add(new a6.q(22, Z0(x7.u.V4), Z0(x7.u.W4)));
        arrayList.add(new a6.q(23, Z0(x7.u.f14094nb), g6.e.c(I(), x7.j.f13649f, this.f6501r0.u1())));
        arrayList.add(new a6.n(33, Z0(x7.u.Dc), Z0(x7.u.Ec), this.f6501r0.v().s()));
        arrayList.add(new a6.q(24, Z0(x7.u.f14081mc)));
        this.f6505v0.M(arrayList);
        this.f6505v0.l();
        y4();
        x4();
    }

    public static /* synthetic */ void v3(c4 c4Var, String str, List list) {
        c4Var.C0.clear();
        c4Var.C0.addAll(list);
        int i10 = 0;
        c4Var.D0 = 0;
        while (true) {
            if (i10 >= list.size()) {
                break;
            }
            if (((String) ((w.d) list.get(i10)).f13207a).equals(str)) {
                c4Var.D0 = i10;
                break;
            }
            i10++;
        }
        c4Var.N4(27, (String) ((w.d) c4Var.C0.get(c4Var.D0)).f13208b);
    }

    public static /* synthetic */ void w3(c4 c4Var, a6.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        c4Var.f6501r0.Q0(i11 + 1);
        qVar.h(g6.e.c(c4Var.I(), x7.j.f13650g, i11));
        c4Var.f6505v0.m(i10);
        c4Var.E4();
    }

    public static /* synthetic */ void y3(c4 c4Var, com.tuyafeng.support.widget.c cVar) {
        int[] iArr = {x7.o.f13778x0, x7.o.f13772v0, x7.o.f13769u0, x7.o.f13775w0};
        cVar.setItemTextColor(x8.h.p(c4Var.I()));
        cVar.setItemHighlightColor(x8.h.j(c4Var.I()));
        cVar.setItemDrawableTint(x8.h.l(c4Var.I()));
        cVar.setItemDrawaleHeight(g6.y.h(c4Var.I(), 90.0f));
        cVar.setItemDrawableWidth(g6.y.h(c4Var.I(), 50.0f));
        cVar.setItemBackground(g6.f.e(c4Var.I(), x7.o.f13720e));
        cVar.setItemTextSize(x8.h.v(c4Var.I()));
        cVar.c(x7.j.f13651h, iArr, c4Var.f6501r0.x0());
    }

    public final String[][] C4(Context context) {
        return mark.via.download.j1.e().d(context);
    }

    public final List D4(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(w.d.a("", context.getString(x7.u.f14213wa)));
        Intent intentH = z8.f1.h("https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_480_1_5MG.mp4", null);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intentH, 0).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo.enabled) {
                    arrayList.add(w.d.a(activityInfo.packageName, activityInfo.loadLabel(packageManager).toString()));
                }
            }
        }
        return arrayList;
    }

    public final void E4() {
        int iI0 = this.f6501r0.i0();
        int i10 = 2;
        if (iI0 == 2) {
            i10 = 10;
        } else if (iI0 == 3) {
            i10 = 1;
        } else if (iI0 == 4) {
            i10 = 0;
        }
        z8.n3.i(I(), i10);
    }

    public final void F4() {
        if ((this.f6507x0 & 32) == 0) {
            e4();
        } else {
            this.F0.a(Z0(x7.u.V4), Z0(x7.u.Yg), new a(I()));
        }
    }

    public final void G4() {
        w5.k.l(I()).d0(x7.u.f14197v7).I(x7.u.f14080mb).V(x7.u.I2, new k.m() { // from class: hb.m3
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                z8.f.k(this.f6658a.I());
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void H4() {
        String strX = this.f6501r0.x();
        if (Build.VERSION.SDK_INT < 21) {
            w5.k.l(I()).d0(x7.u.M3).J(z8.c1.p(File.separator)).i(strX, Z0(x7.u.f14232y3), 1).V(R.string.ok, new k.m() { // from class: hb.n3
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    c4.u3(this.f6674a, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
            return;
        }
        try {
            this.f6509z0.a(z8.b1.o(strX) ? Uri.parse(strX) : null);
        } catch (ActivityNotFoundException e10) {
            pc.a.i(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(boolean z10) {
        super.I1(z10);
        if (z10) {
            return;
        }
        y4();
        x4();
        w4();
    }

    public final void I4(a6.q qVar, int i10) {
        g6.i.g(this, jb.k5.class);
    }

    public final void J4() {
        String[] strArr = {Z0(x7.u.vd), Z0(x7.u.f14026j), Z0(x7.u.cg), Z0(x7.u.H), Z0(x7.u.Kb)};
        int iX1 = this.f6501r0.X1();
        int[] iArr = new int[10];
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            if (((1 << i11) & iX1) != 0) {
                iArr[i10] = i11;
                i10++;
            }
        }
        w5.k.l(I()).e0(Z0(x7.u.hg)).J(Z0(x7.u.f14035j8)).L(strArr, Arrays.copyOf(iArr, i10)).V(R.string.ok, new k.m() { // from class: hb.w2
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                c4.m3(this.f6805a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void K4() {
        w5.k kVar = this.f6508y0;
        if (kVar != null) {
            kVar.f0();
            return;
        }
        w5.k kVarU = w5.k.l(I()).X(x7.u.Nh).t(false).u(false);
        this.f6508y0 = kVarU;
        kVarU.f0();
    }

    public final void L4(final a6.q qVar, final int i10, final boolean z10) {
        com.tuyafeng.support.widget.c cVar = (com.tuyafeng.support.widget.c) new h6.a(new com.tuyafeng.support.widget.c(I()), new LinearLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: hb.a4
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                c4.y3(this.f6465a, (com.tuyafeng.support.widget.c) obj);
            }
        }).l();
        final w5.k kVarS = w5.k.l(I()).d0(x7.u.Pg).y(cVar).s(z10 ? 2 : 1);
        kVarS.f0();
        cVar.setHighlightChangedListener(new c.b() { // from class: hb.l2
            @Override // com.tuyafeng.support.widget.c.b
            public final void a(int i11) {
                c4.h3(this.f6634a, qVar, i10, kVarS, z10, i11);
            }
        });
    }

    public final void M4() {
        int iJ4 = j4(14);
        a6.q qVarL4 = l4(iJ4);
        if (qVarL4 == null) {
            return;
        }
        qVarL4.h(this.f6501r0.P(I()));
        this.f6505v0.m(iJ4);
    }

    public final void N4(int i10, String str) {
        int iJ4;
        a6.q qVarL4;
        if (this.f6505v0 == null || (iJ4 = j4(i10)) < 0 || (qVarL4 = l4(iJ4)) == null) {
            return;
        }
        qVarL4.h(str);
        qVarL4.g(false);
        this.f6505v0.m(iJ4);
    }

    @Override // o8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        v4();
        y4();
        x4();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6504u0 = z8.t1.d();
        y5.f fVar = new y5.f(Collections.EMPTY_LIST);
        this.f6505v0 = fVar;
        fVar.K(a6.q.class, new a6.s(new y5.g() { // from class: hb.r3
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6732a.B4(view2, i10, (a6.q) obj);
            }
        }));
        this.f6505v0.K(a6.n.class, new a6.p(new y5.g() { // from class: hb.v3
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6795a.A4(view2, i10, (a6.n) obj);
            }
        }));
        this.f10459q0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10459q0.setItemAnimator(null);
        this.f10459q0.setAdapter(this.f6505v0);
        u4();
    }

    public final boolean Z3(Uri uri) throws IOException {
        if (uri == null) {
            return false;
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(z8.b1.i(I(), uri));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory() && nextEntry.getName().endsWith(".enc")) {
                        zipInputStream.close();
                        return true;
                    }
                } finally {
                }
            }
        } catch (IOException e10) {
            pc.a.b(e10);
        }
        return false;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        z8.v3.a(zVar, x7.u.rc);
    }

    public final void a4() {
        w5.k kVar = this.f6508y0;
        if (kVar == null) {
            return;
        }
        kVar.n();
        this.f6508y0 = null;
    }

    public final void b4() {
        if (Environment.DIRECTORY_DOWNLOADS.equals(this.f6501r0.x())) {
            H4();
            return;
        }
        w5.k kVarL = w5.k.l(I());
        kVarL.d0(x7.u.M3);
        kVarL.F(new String[]{Z0(x7.u.f14202w), Z0(x7.u.f14040k)}, new AdapterView.OnItemClickListener() { // from class: hb.b3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                c4.B3(this.f6479a, adapterView, view, i10, j10);
            }
        });
        kVarL.f0();
    }

    public final void c4() {
        this.J0.d(I().getResources().getString(x7.u.f13958e1) + "_" + I().getResources().getString(x7.u.f14026j) + "_" + this.f6504u0 + ".html", new d.a() { // from class: hb.a3
            @Override // p8.d.a
            public final void a(Uri uri, String str) {
                this.f6464a.d4(uri, str);
            }
        });
    }

    public final void d4(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        K4();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.c3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c4.H3(this.f6499e, uri);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new a7.e() { // from class: hb.d3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.N3(this.f6520e, str, (Integer) obj);
            }
        }, new a7.e() { // from class: hb.e3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.M3(this.f6531e, (Throwable) obj);
            }
        });
    }

    public final void e4() {
        this.H0.d(Z0(x7.u.f13958e1) + "_" + Z0(x7.u.U2) + "_" + this.f6504u0 + ".zip", new d.a() { // from class: hb.f3
            @Override // p8.d.a
            public final void a(Uri uri, String str) {
                this.f6544a.g4(uri, str);
            }
        });
    }

    public final void f4() {
        w5.k.l(I()).e0(Z0(x7.u.V4)).L((String[]) Arrays.copyOf(new String[]{Z0(x7.u.f14026j), Z0(x7.u.vd), Z0(x7.u.H), Z0(x7.u.Ra), Z0(x7.u.f14095nc), Z0(x7.u.f14065la)}, 6), new int[]{0, 1, 2, 3, 4}).V(R.string.ok, new k.m() { // from class: hb.y2
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                c4.k3(this.f6837a, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void g4(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        final String str2 = this.G0;
        this.G0 = null;
        K4();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.s3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c4.o3(this.f6741e, str2, uri);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new a7.e() { // from class: hb.t3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.g3(this.f6757e, str, (Boolean) obj);
            }
        }, new a7.e() { // from class: hb.u3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.P3(this.f6778e, (Throwable) obj);
            }
        });
    }

    public final void h4(final a6.q qVar, final int i10) {
        com.tuyafeng.support.widget.c cVar = this.E0;
        if (cVar == null) {
            com.tuyafeng.support.widget.c cVar2 = new com.tuyafeng.support.widget.c(I());
            this.E0 = cVar2;
            int[] iArr = {x7.o.f13778x0, x7.o.f13781y0, x7.o.f13784z0};
            cVar2.setItemTextColor(x8.h.p(I()));
            this.E0.setItemHighlightColor(x8.h.j(I()));
            this.E0.setItemDrawableTint(x8.h.l(I()));
            this.E0.setItemDrawaleHeight(g6.y.h(I(), 90.0f));
            this.E0.setItemDrawableWidth(g6.y.h(I(), 50.0f));
            this.E0.setItemTextSize(x8.h.v(I()));
            this.E0.setItemBackground(g6.f.e(I(), x7.o.f13720e));
            this.E0.c(x7.j.f13646c, iArr, this.f6501r0.r2());
        } else {
            ((ViewGroup) cVar.getParent()).removeAllViews();
        }
        final w5.k kVarY = w5.k.l(I()).d0(x7.u.P5).y(this.E0);
        kVarY.f0();
        this.E0.setHighlightChangedListener(new c.b() { // from class: hb.u2
            @Override // com.tuyafeng.support.widget.c.b
            public final void a(int i11) {
                c4.R3(this.f6774a, qVar, i10, kVarY, i11);
            }
        });
    }

    public ZipBackupManager i4() {
        if (this.f6506w0 == null) {
            this.f6506w0 = new ZipBackupManager(I(), this.f6501r0, pa.r.f(), this.f6502s0, lc.c().d(), pa.r.k(), pa.r.d(), pa.r.l(), pa.r.i());
        }
        return this.f6506w0;
    }

    public final int j4(int i10) {
        List listH = this.f6505v0.H();
        for (int i11 = 0; i11 < listH.size(); i11++) {
            Object obj = listH.get(i11);
            if ((obj instanceof a6.q) && ((a6.q) obj).c() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final a6.n k4(int i10) {
        a6.q qVarL4 = l4(i10);
        if (qVarL4 instanceof a6.n) {
            return (a6.n) qVarL4;
        }
        return null;
    }

    public final a6.q l4(int i10) {
        List listH = this.f6505v0.H();
        if (i10 < 0 || i10 >= listH.size() || !(listH.get(i10) instanceof a6.q)) {
            return null;
        }
        return (a6.q) listH.get(i10);
    }

    public final void m4(final a6.q qVar, final int i10) {
        w5.k.l(I()).d0(x7.u.Rf).i(this.f6501r0.B() == 3 ? this.f6501r0.n() : m8.a.f8679d, Z0(x7.u.Rf), 3).V(R.string.ok, new k.m() { // from class: hb.l3
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                c4.E3(this.f6639a, qVar, i10, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void n4(final a6.q qVar, final int i10) {
        w5.k.l(I()).d0(x7.u.f14144r6).Z(x7.j.f13647d, this.f6501r0.B(), new AdapterView.OnItemClickListener() { // from class: hb.t2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                c4.T3(this.f6754a, qVar, i10, adapterView, view, i11, j10);
            }
        }).f0();
    }

    public final void o4() {
        this.I0.b(new String[]{"text/html"}, new f.a() { // from class: hb.s2
            @Override // p8.f.a
            public final void a(Uri uri) {
                this.f6740a.p4(uri);
            }
        });
    }

    public final void p4(final Uri uri) {
        if (uri == null) {
            return;
        }
        K4();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.i3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c4.n3(this.f6584e, uri);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.j3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.F3(this.f6615e, (Integer) obj);
            }
        }, new a7.e() { // from class: hb.k3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.I3(this.f6626e, (Throwable) obj);
            }
        });
    }

    public final void q4() {
        this.I0.b(new String[]{"text/plain", "application/zip"}, new f.a() { // from class: hb.x2
            @Override // p8.f.a
            public final void a(Uri uri) {
                this.f6825a.r4(uri);
            }
        });
    }

    public final void r4(final Uri uri) {
        if (Z3(uri)) {
            w5.k.l(I()).d0(x7.u.f14009ha).I(x7.u.f14023ia).i("", Z0(x7.u.f14033j6), 1).V(R.string.ok, new k.m() { // from class: hb.h3
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    c4.S3(this.f6567a, uri, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
        } else {
            s4(uri, null);
        }
    }

    public final void s4(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        K4();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.o3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c4.s3(this.f6687e, uri, str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.p3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.q3(this.f6705e, (Integer) obj);
            }
        }, new a7.e() { // from class: hb.q3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.A3(this.f6720e, (Throwable) obj);
            }
        });
    }

    public final void t4(final a6.q qVar, final int i10) {
        Map mapB = z8.g1.b();
        mapB.put("", Z0(x7.u.H5));
        final String[] strArr = (String[]) mapB.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        String[] strArr2 = new String[strArr.length];
        String strK0 = this.f6501r0.K0();
        int length = strArr.length;
        final int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (strArr[i12].equals(strK0)) {
                i11 = i12;
            }
            strArr2[i12] = (String) mapB.get(strArr[i12]);
        }
        w5.k.l(I()).d0(x7.u.f14197v7).b0(strArr2, i11, new AdapterView.OnItemClickListener() { // from class: hb.z2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i13, long j10) {
                c4.W3(this.f6857a, i11, strArr, qVar, i10, adapterView, view, i13, j10);
            }
        }).f0();
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        pa.r.b(context).k(this);
    }

    public final void v4() {
        final Context applicationContext = I().getApplicationContext();
        final String strK2 = this.f6501r0.K2();
        final String strW0 = this.f6501r0.w0();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.w3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6806e.C4(applicationContext);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.x3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.j3(this.f6826e, strK2, (String[][]) obj);
            }
        }, new x7.g0());
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.y3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6838e.D4(applicationContext);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.z3
            @Override // a7.e
            public final void accept(Object obj) {
                c4.v3(this.f6862e, strW0, (List) obj);
            }
        }, new x7.g0());
    }

    public final void w4() {
        int iJ4;
        a6.q qVarL4;
        if (this.f6505v0 == null || (iJ4 = j4(35)) < 0 || (qVarL4 = l4(iJ4)) == null) {
            return;
        }
        qVarL4.h(this.f6501r0.a1());
        this.f6505v0.m(iJ4);
    }

    public final void x4() {
        int iJ4;
        a6.q qVarL4;
        if (this.f6505v0 == null || (iJ4 = j4(12)) < 0 || (qVarL4 = l4(iJ4)) == null) {
            return;
        }
        qVarL4.h(String.format(Locale.ROOT, "%d%%", Integer.valueOf(this.f6501r0.F0())));
        this.f6505v0.m(iJ4);
    }

    public final void y4() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: hb.k2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                c4 c4Var = this.f6625e;
                return z8.b4.d(c4Var.I(), c4Var.f6501r0.l0());
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: hb.v2
            @Override // a7.e
            public final void accept(Object obj) {
                c4.G3(this.f6794e, (String) obj);
            }
        }, new x7.g0());
    }

    public final void z4() {
        w9.n.e().s(true);
    }
}
