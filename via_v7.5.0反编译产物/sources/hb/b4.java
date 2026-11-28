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
import android.widget.AdapterView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tuyafeng.support.utils.FragmentUtils;
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
import mark.via.browser.kd;
import mark.via.data.backup2.ZipBackupManager;
import mark.via.settings.search.SettingsSearchLocator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b4 extends m8.f {
    public String I0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public u9.l f5806u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public u4.a f5807v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public m9.c f5808w0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public t5.f f5810y0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f5809x0 = "";

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ZipBackupManager f5811z0 = null;
    public int A0 = 0;
    public q5.k B0 = null;
    public final androidx.activity.result.b C0 = w2(new s5.d(), new androidx.activity.result.a() { // from class: hb.j3
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            b4.L3(this.f5921a, (Uri) obj);
        }
    });
    public String[][] D0 = (String[][]) Array.newInstance((Class<?>) String.class, 0, 0);
    public int E0 = 0;
    public final List F0 = new ArrayList();
    public int G0 = 0;
    public final wa.a H0 = new wa.r(this);
    public final n8.d J0 = new n8.d(this, "application/zip");
    public final n8.f K0 = new n8.f(this);
    public final n8.d L0 = new n8.d(this, "text/html");

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends wa.s {
        public a(Context context) {
            super(context);
        }

        public static /* synthetic */ void b(a aVar, View view, q5.k.p pVar) {
            b4.this.I0 = com.tuyafeng.support.utils.p.n(pVar.f11819c[0], "3_=cZHGxZ#FZgZA@");
            b4.this.Z3();
        }

        @Override // wa.b
        public void onSuccess() {
            q5.k.l(b4.this.G()).f0(w7.u.O4).J(w7.u.P4).i("", b4.this.X0(w7.u.f14266v6), 1).X(R.string.ok, new q5.k.m() { // from class: hb.a4
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    b4.a.b(this.f5787a, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        }
    }

    public static /* synthetic */ Integer B3(b4 b4Var, Uri uri) {
        b4Var.getClass();
        try {
            InputStream inputStreamI = x8.b1.i(b4Var.G(), uri);
            try {
                Integer numValueOf = Integer.valueOf(b4Var.f5808w0.A(x8.n.f(inputStreamI)));
                if (inputStreamI != null) {
                    inputStreamI.close();
                }
                return numValueOf;
            } catch (Throwable th) {
                if (inputStreamI != null) {
                    try {
                        inputStreamI.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            tc.a.j(e10);
            return 0;
        }
    }

    public static /* synthetic */ void C3(b4 b4Var, v5.q qVar, int i10, View view, q5.k.p pVar) {
        b4Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        String strW = c6.a2.f1958a.w(pVar.f11819c[0], null);
        if (strW.contains("://")) {
            b4Var.f5806u0.y1(strW);
            qVar.h(strW);
            u9.n.e().w(true);
            b4Var.f5810y0.m(i10);
        }
    }

    public static /* synthetic */ void E3(b4 b4Var, View view, q5.k.p pVar) {
        b4Var.getClass();
        int[] iArr = pVar.f11817a;
        if (iArr == null || iArr.length == 0) {
            return;
        }
        b4Var.A0 = 0;
        for (int i10 : iArr) {
            if (i10 == 0) {
                b4Var.A0 |= 2;
            } else if (i10 == 1) {
                b4Var.A0 |= 4;
            } else if (i10 == 2) {
                b4Var.A0 |= 8;
            } else if (i10 == 3) {
                b4Var.A0 |= 16;
            } else if (i10 == 4) {
                b4Var.A0 |= 1;
            } else if (i10 == 5) {
                b4Var.A0 |= 32;
            }
        }
        if ((b4Var.A0 & 32) != 0 && la.s.i().j()) {
            b4Var.A0 &= -33;
        }
        if (b4Var.A0 != 0) {
            b4Var.z4();
        }
    }

    private void E4() {
        q5.k kVar = this.B0;
        if (kVar != null) {
            kVar.h0();
            return;
        }
        q5.k kVarV = q5.k.l(G()).Z(w7.u.si).u(false).v(false);
        this.B0 = kVarV;
        kVarV.h0();
    }

    public static /* synthetic */ void F3(b4 b4Var, String str) {
        int iD4;
        v5.q qVarF4;
        if (b4Var.f5810y0 == null || (iD4 = b4Var.d4(2)) < 0 || (qVarF4 = b4Var.f4(iD4)) == null) {
            return;
        }
        qVarF4.h(str);
        b4Var.f5810y0.m(iD4);
    }

    public static /* synthetic */ void G3(b4 b4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 != 0) {
            b4Var.B4();
        } else {
            b4Var.f5806u0.r(null);
            b4Var.F4();
        }
    }

    public static /* synthetic */ void H3(b4 b4Var, v5.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        b4Var.f5806u0.C0(i11);
        qVar.h(com.tuyafeng.support.utils.e.c(b4Var.G(), w7.j.f13715f, i11));
        b4Var.f5810y0.m(i10);
        if (i11 != 0) {
            com.tuyafeng.support.utils.n.q(b4Var.G(), w7.u.Cb);
        }
    }

    public static /* synthetic */ Boolean K3(b4 b4Var, String str, Uri uri) {
        String strK = x8.c1.k(b4Var.G(), "temp", UUID.randomUUID().toString() + ".zip");
        ZipBackupManager zipBackupManagerC4 = b4Var.c4();
        return (strK == null || !zipBackupManagerC4.a(new File(strK), b4Var.A0, str)) ? Boolean.valueOf(zipBackupManagerC4.b(x8.b1.l(b4Var.G(), uri), b4Var.A0, str)) : Boolean.valueOf(x8.b1.b(b4Var.G(), Uri.fromFile(new File(strK)), uri));
    }

    public static /* synthetic */ void L3(b4 b4Var, Uri uri) {
        if (uri == null) {
            b4Var.getClass();
            return;
        }
        b4Var.G().getContentResolver().takePersistableUriPermission(uri, 3);
        b4Var.f5806u0.r(uri.toString());
        b4Var.F4();
    }

    public static /* synthetic */ void M3(b4 b4Var, v5.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        b4Var.f5806u0.T0(i11 + 1);
        qVar.h(com.tuyafeng.support.utils.e.c(b4Var.G(), w7.j.f13716g, i11));
        b4Var.f5810y0.m(i10);
        b4Var.y4();
    }

    public static /* synthetic */ void N3(b4 b4Var, Throwable th) {
        b4Var.V3();
        tc.a.j(th);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0102  */
    /* JADX WARN: Code duplicated, block: B:57:0x0105  */
    public static /* synthetic */ Integer O3(b4 b4Var, Uri uri, String str) throws Throwable {
        int i10;
        String strK = x8.b1.k(b4Var.G(), uri);
        long j10 = x8.b1.j(b4Var.G(), uri);
        if (strK == null || j10 <= 0) {
            return Integer.valueOf(w7.u.U6);
        }
        if (j10 > 67108864) {
            return Integer.valueOf(w7.u.V6);
        }
        if (strK.toLowerCase(Locale.ROOT).endsWith(".zip")) {
            String strK2 = x8.c1.k(b4Var.G(), "temp", UUID.randomUUID().toString() + ".zip");
            Uri uriFromFile = strK2 == null ? null : Uri.fromFile(new File(strK2));
            Uri uri2 = (uriFromFile == null || x8.b1.b(b4Var.G(), uri, Uri.fromFile(new File(strK2)))) ? uriFromFile : null;
            ZipBackupManager zipBackupManagerC4 = b4Var.c4();
            Context contextG = b4Var.G();
            if (uri2 != null) {
                uri = uri2;
            }
            ZipBackupManager.RestoreResult restoreResultE = zipBackupManagerC4.e(x8.b1.i(contextG, uri), str);
            if (restoreResultE == ZipBackupManager.RestoreResult.ENCRYPTED_DATA_SKIPPED) {
                return Integer.valueOf(w7.u.T6);
            }
            return Integer.valueOf(restoreResultE == ZipBackupManager.RestoreResult.SUCCESS ? w7.u.W6 : w7.u.U6);
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(x8.b1.i(b4Var.G(), uri)));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb2.append(line);
                    if (j9.d.b(b4Var.f5806u0, la.s.f(), la.s.k(), b4Var.f5807v0, kd.c().f(), la.s.d(), sb2.toString())) {
                        i10 = w7.u.W6;
                    } else {
                        i10 = w7.u.U6;
                    }
                    return Integer.valueOf(i10);
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
                tc.a.j(e);
            }
            bufferedReader.close();
        } catch (Exception e10) {
            tc.a.j(e10);
        }
        if (j9.d.b(b4Var.f5806u0, la.s.f(), la.s.k(), b4Var.f5807v0, kd.c().f(), la.s.d(), sb2.toString())) {
            i10 = w7.u.W6;
        } else {
            i10 = w7.u.U6;
        }
        return Integer.valueOf(i10);
    }

    public static /* synthetic */ void Q3(b4 b4Var, String str, Integer num) {
        b4Var.V3();
        if (num.intValue() == 0) {
            com.tuyafeng.support.utils.n.q(b4Var.G(), w7.u.W8);
        } else if (num.intValue() > 0) {
            if (str == null) {
                com.tuyafeng.support.utils.n.q(b4Var.G(), w7.u.P1);
            } else {
                com.tuyafeng.support.utils.n.m(b4Var.G(), b4Var.X0(w7.u.I3), b4Var.Y0(w7.u.f14070h5, str));
            }
        }
    }

    public static /* synthetic */ void R3(b4 b4Var, int i10, String[] strArr, v5.q qVar, int i11, AdapterView adapterView, View view, int i12, long j10) {
        if (i10 == i12) {
            b4Var.getClass();
            return;
        }
        b4Var.f5806u0.A1(strArr[i12]);
        u9.n.e().n(true);
        b4Var.f5806u0.r2(u9.n.e().a());
        qVar.h(x8.f1.a(strArr[i12], b4Var.X0(w7.u.T5)));
        b4Var.f5810y0.m(i11);
        b4Var.A4();
    }

    private void V3() {
        q5.k kVar = this.B0;
        if (kVar == null) {
            return;
        }
        kVar.o();
        this.B0 = null;
    }

    private void X3() {
        this.L0.d(G().getResources().getString(w7.u.f14066h1) + "_" + G().getResources().getString(w7.u.f14092j) + "_" + this.f5809x0 + ".html", new n8.d.a() { // from class: hb.z2
            @Override // n8.d.a
            public final void a(Uri uri, String str) {
                this.f6173a.Y3(uri, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y3(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        E4();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.b3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b4.t3(this.f5804c, uri);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: hb.c3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.Q3(this.f5825c, str, (Integer) obj);
            }
        }, new u6.f() { // from class: hb.d3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.o3(this.f5840c, (Throwable) obj);
            }
        });
    }

    public static List e4(Context context) {
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, b4.class, w7.u.Fc);
        hVar.b(26, w7.u.Id, new String[0]);
        hVar.c("mark.via.settings.site.UserAgentSettingsFragment.1", 2, w7.u.F0, "UA", "user agent", "浏览器标识");
        hVar.b(3, w7.u.f14137m2, new String[0]);
        hVar.b(4, w7.u.G1, new String[0]);
        hVar.b(5, w7.u.Xc, new String[0]);
        hVar.b(36, w7.u.f14229sa, new String[0]);
        hVar.b(6, w7.u.Q, new String[0]);
        hVar.b(30, w7.u.Za, new String[0]);
        hVar.b(32, w7.u.Ug, new String[0]);
        hVar.b(28, w7.u.f14012d3, new String[0]);
        hVar.b(37, w7.u.f13998c3, new String[0]);
        hVar.b(9, w7.u.H7, "language");
        hVar.b(10, w7.u.D6, new String[0]);
        hVar.b(31, w7.u.f14161nc, new String[0]);
        hVar.b(34, w7.u.U0, new String[0]);
        hVar.b(13, w7.u.f13991ba, new String[0]);
        hVar.b(14, w7.u.Z3, "下载目录", "下载路径", "download directory");
        hVar.b(15, w7.u.C0, new String[0]);
        hVar.b(27, w7.u.f14182p5, new String[0]);
        hVar.b(18, w7.u.f14151n2, new String[0]);
        hVar.b(35, w7.u.W5, new String[0]);
        hVar.b(19, w7.u.Gc, new String[0]);
        hVar.b(20, w7.u.X6, new String[0]);
        hVar.b(21, w7.u.S6, new String[0]);
        hVar.b(22, w7.u.f14084i5, new String[0]);
        hVar.b(23, w7.u.Ab, "恢复标签", "保留标签");
        hVar.b(33, w7.u.Sc, new String[0]);
        hVar.b(24, w7.u.Ac, new String[0]);
        return hVar.f();
    }

    public static /* synthetic */ void f3(b4 b4Var, Throwable th) {
        b4Var.V3();
        tc.a.j(th);
    }

    public static /* synthetic */ void h3(b4 b4Var, String str, String[][] strArr) {
        b4Var.D0 = strArr;
        b4Var.E0 = 0;
        int i10 = 0;
        while (true) {
            String[] strArr2 = strArr[0];
            if (i10 >= strArr2.length) {
                break;
            }
            if (strArr2[i10].equals(str)) {
                b4Var.E0 = i10;
                break;
            }
            i10++;
        }
        b4Var.G4(15, b4Var.D0[1][b4Var.E0]);
    }

    public static /* synthetic */ void i3(b4 b4Var, Integer num) {
        b4Var.V3();
        com.tuyafeng.support.utils.n.q(b4Var.G(), num.intValue());
        if (num.intValue() == w7.u.W6 || num.intValue() == w7.u.T6) {
            b4Var.o4();
            b4Var.p4();
        }
    }

    private void i4() {
        this.K0.b(new String[]{"text/html"}, new n8.f.a() { // from class: hb.s2
            @Override // n8.f.a
            public final void a(Uri uri) {
                this.f6059a.j4(uri);
            }
        });
    }

    public static /* synthetic */ void k3(b4 b4Var, View view, q5.k.p pVar) {
        b4Var.getClass();
        int[] iArr = pVar.f11817a;
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
        b4Var.f5806u0.g(i10);
        u9.n.e().u(true);
    }

    public static /* synthetic */ void l3(b4 b4Var, View view, q5.k.p pVar) {
        b4Var.getClass();
        String[] strArr = pVar.f11819c;
        String strN = strArr.length > 0 ? x8.c1.n(strArr[0]) : null;
        if (strN == null || strN.isEmpty()) {
            strN = null;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), strN);
        b4Var.f5806u0.r((file.isDirectory() || file.mkdirs()) ? strN : null);
        b4Var.F4();
    }

    public static /* synthetic */ void m3(b4 b4Var, v5.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        b4Var.f5806u0.K1((String) ((x.d) b4Var.F0.get(i11)).f14455a);
        qVar.h((String) ((x.d) b4Var.F0.get(i11)).f14456b);
        b4Var.f5810y0.m(i10);
        b4Var.G0 = i11;
    }

    public static /* synthetic */ void n3(b4 b4Var, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            b4Var.X3();
        } else if (i10 == 1) {
            b4Var.i4();
        } else {
            b4Var.getClass();
        }
    }

    public static /* synthetic */ void o3(b4 b4Var, Throwable th) {
        b4Var.V3();
        tc.a.j(th);
    }

    private void o4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v5.q(26, X0(w7.u.Id)));
        arrayList.add(new v5.q(2, X0(w7.u.F0)));
        arrayList.add(new v5.q(3, X0(w7.u.f14137m2)));
        arrayList.add(new v5.q(4, X0(w7.u.G1)));
        arrayList.add(new v5.q(5, X0(w7.u.Xc)));
        arrayList.add(new v5.q(36, X0(w7.u.f14229sa)));
        arrayList.add(new v5.q(6, X0(w7.u.Q)));
        arrayList.add(new v5.q(30, X0(w7.u.Za)));
        arrayList.add(new v5.q(32, X0(w7.u.Ug)));
        arrayList.add(new v5.q(28, X0(w7.u.f14012d3)));
        arrayList.add(new v5.q(37, X0(w7.u.f13998c3)));
        arrayList.add(new v5.q(9, X0(w7.u.H7), x8.f1.a(this.f5806u0.M0(), X0(w7.u.T5))));
        int iC = this.f5806u0.C();
        arrayList.add(new v5.q(10, X0(w7.u.D6), iC == 3 ? this.f5806u0.p() : com.tuyafeng.support.utils.e.c(G(), w7.j.f13713d, iC)));
        arrayList.add(new v5.q(31, X0(w7.u.f14161nc)));
        arrayList.add(new v5.q(34, X0(w7.u.U0)));
        boolean zA = x8.j3.a(G());
        v5.q qVar = new v5.q(13, X0(w7.u.f13991ba), com.tuyafeng.support.utils.e.c(G(), w7.j.f13716g, zA ? this.f5806u0.l0() - 1 : 0));
        qVar.g(!zA);
        arrayList.add(qVar);
        arrayList.add(new v5.q(14, X0(w7.u.Z3), this.f5806u0.Q(G())));
        this.D0 = new String[][]{new String[]{""}, new String[]{X0(w7.u.R1)}};
        this.E0 = 0;
        v5.q qVar2 = new v5.q(15, X0(w7.u.C0), this.D0[1][this.E0]);
        qVar2.g(true);
        arrayList.add(qVar2);
        this.F0.clear();
        this.F0.add(x.d.a("", X0(w7.u.Ia)));
        this.G0 = 0;
        v5.q qVar3 = new v5.q(27, X0(w7.u.f14182p5), (String) ((x.d) this.F0.get(this.G0)).f14456b);
        qVar3.g(true);
        arrayList.add(qVar3);
        arrayList.add(new v5.q(18, X0(w7.u.f14151n2)));
        arrayList.add(new v5.q(35, X0(w7.u.W5), this.f5806u0.c1()));
        arrayList.add(new v5.q(19, X0(w7.u.Gc), X0(w7.u.O9)));
        arrayList.add(new v5.q(20, X0(w7.u.X6)));
        arrayList.add(new v5.q(21, X0(w7.u.S6)));
        arrayList.add(new v5.q(22, X0(w7.u.f14084i5), X0(w7.u.f14098j5)));
        arrayList.add(new v5.q(23, X0(w7.u.Ab), com.tuyafeng.support.utils.e.c(G(), w7.j.f13715f, this.f5806u0.v1())));
        arrayList.add(new v5.n(33, X0(w7.u.Sc), X0(w7.u.Tc), this.f5806u0.v().s()));
        arrayList.add(new v5.q(24, X0(w7.u.Ac)));
        this.f5810y0.M(arrayList);
        this.f5810y0.l();
        s4();
        r4();
    }

    public static /* synthetic */ void q3(b4 b4Var, String str, List list) {
        b4Var.F0.clear();
        b4Var.F0.addAll(list);
        b4Var.G0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (((String) ((x.d) list.get(i10)).f14455a).equals(str)) {
                b4Var.G0 = i10;
                break;
            }
        }
        b4Var.G4(27, (String) ((x.d) b4Var.F0.get(b4Var.G0)).f14456b);
    }

    public static /* synthetic */ void r3(b4 b4Var, v5.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        b4Var.f5806u0.G0(b4Var.D0[0][i11]);
        qVar.h(b4Var.D0[1][i11]);
        b4Var.f5810y0.m(i10);
        b4Var.E0 = i11;
    }

    public static /* synthetic */ Integer t3(b4 b4Var, Uri uri) {
        b4Var.getClass();
        int iG = 0;
        try {
            OutputStream outputStreamL = x8.b1.l(b4Var.G(), uri);
            try {
                iG = x8.n.g(outputStreamL, x.d.a(b4Var.f5808w0.j(), b4Var.f5808w0.u()));
                if (outputStreamL != null) {
                    outputStreamL.close();
                }
            } catch (Throwable th) {
                if (outputStreamL != null) {
                    try {
                        outputStreamL.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            tc.a.j(e10);
        }
        return Integer.valueOf(iG);
    }

    public static /* synthetic */ void u3(b4 b4Var, String str, Boolean bool) {
        b4Var.V3();
        if (bool.booleanValue()) {
            if (str != null) {
                com.tuyafeng.support.utils.n.l(b4Var.G(), w7.u.I3, b4Var.G().getString(w7.u.f14112k5, str));
            } else {
                com.tuyafeng.support.utils.n.q(b4Var.G(), w7.u.f14040f3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u4(View view, int i10, v5.n nVar) {
        if (nVar.c() == 33) {
            nVar.j(!nVar.i());
            u9.a aVarV = this.f5806u0.v();
            aVarV.K(nVar.i());
            this.f5806u0.Z(aVarV);
            this.f5810y0.m(i10);
        }
    }

    public static /* synthetic */ void v3(b4 b4Var, v5.q qVar, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == 3) {
            b4Var.g4(qVar, i10);
            return;
        }
        b4Var.f5806u0.y1(new String[]{"about:home", "about:blank", "about:bookmarks"}[i11]);
        qVar.h(com.tuyafeng.support.utils.e.c(b4Var.G(), w7.j.f13713d, i11));
        b4Var.f5810y0.m(i10);
        u9.n.e().w(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v4(View view, final int i10, final v5.q qVar) {
        switch (qVar.c()) {
            case 2:
                FragmentUtils.i(this, w7.class);
                break;
            case 3:
                x8.f0.e(G(), this.f5806u0, la.s.m().f(), la.s.l(), la.s.f());
                break;
            case 4:
                FragmentUtils.i(this, y7.d.class);
                break;
            case 5:
                FragmentUtils.i(this, jb.y4.class);
                break;
            case 6:
                FragmentUtils.i(this, o4.class);
                break;
            case 9:
                n4(qVar, i10);
                break;
            case 10:
                h4(qVar, i10);
                break;
            case 11:
                FragmentUtils.i(this, w5.class);
                break;
            case 12:
                C4(qVar, i10);
                break;
            case 13:
                q5.k.l(G()).f0(w7.u.f13991ba).b0(w7.j.f13716g, this.f5806u0.l0() - 1, new AdapterView.OnItemClickListener() { // from class: hb.z3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        b4.M3(this.f6174a, qVar, i10, adapterView, view2, i11, j10);
                    }
                }).h0();
                break;
            case 14:
                W3();
                break;
            case 15:
                q5.k.l(G()).f0(w7.u.C0).d0(this.D0[1], this.E0, new AdapterView.OnItemClickListener() { // from class: hb.q2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        b4.r3(this.f6031a, qVar, i10, adapterView, view2, i11, j10);
                    }
                }).h0();
                break;
            case 18:
                x8.f0.f(G(), this.f5806u0);
                break;
            case 19:
                FragmentUtils.i(this, v4.class);
                break;
            case 20:
                q5.k.l(G()).f0(w7.u.X6).G(new String[]{G().getString(w7.u.f14056g5), G().getString(w7.u.R6)}, new AdapterView.OnItemClickListener() { // from class: hb.o2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        b4.n3(this.f5998a, adapterView, view2, i11, j10);
                    }
                }).h0();
                break;
            case 21:
                k4();
                break;
            case 22:
                this.A0 = 31;
                a4();
                break;
            case 23:
                q5.k.l(G()).f0(w7.u.Ab).b0(w7.j.f13715f, this.f5806u0.v1(), new AdapterView.OnItemClickListener() { // from class: hb.p2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                        b4.H3(this.f6021a, qVar, i10, adapterView, view2, i11, j10);
                    }
                }).h0();
                break;
            case 24:
                x8.z.V(G());
                break;
            case 25:
                D4();
                break;
            case 26:
                FragmentUtils.i(this, a7.class);
                break;
            case 27:
                int size = this.F0.size();
                String[] strArr = new String[size];
                for (int i11 = 0; i11 < size; i11++) {
                    strArr[i11] = (String) ((x.d) this.F0.get(i11)).f14456b;
                }
                q5.k.l(G()).f0(w7.u.f14182p5).J(w7.u.f14196q5).d0(strArr, this.G0, new AdapterView.OnItemClickListener() { // from class: hb.r2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                        b4.m3(this.f6047a, qVar, i10, adapterView, view2, i12, j10);
                    }
                }).h0();
                break;
            case 28:
                FragmentUtils.i(this, g8.s.class);
                break;
            case 30:
                FragmentUtils.i(this, o5.class);
                break;
            case 31:
                FragmentUtils.i(this, b6.class);
                break;
            case 32:
                FragmentUtils.i(this, l7.class);
                break;
            case 34:
                FragmentUtils.i(this, y8.o.class);
                break;
            case 35:
                FragmentUtils.i(this, m2.class);
                break;
            case 36:
                FragmentUtils.i(this, va.e1.class);
                break;
            case 37:
                FragmentUtils.i(this, g8.w.class);
                break;
        }
    }

    public static /* synthetic */ void x3(b4 b4Var, Integer num) {
        b4Var.V3();
        if (num.intValue() <= 0) {
            com.tuyafeng.support.utils.n.q(b4Var.G(), w7.u.Q6);
        } else {
            com.tuyafeng.support.utils.n.s(b4Var.G(), b4Var.Y0(w7.u.Q1, num));
            b4Var.t4();
        }
    }

    public static /* synthetic */ void y3(b4 b4Var, Throwable th) {
        b4Var.V3();
        tc.a.j(th);
    }

    public static /* synthetic */ void z3(b4 b4Var, Uri uri, View view, q5.k.p pVar) {
        b4Var.getClass();
        b4Var.m4(uri, com.tuyafeng.support.utils.p.n(pVar.f11819c[0], "3_=cZHGxZ#FZgZA@"));
    }

    public final void A4() {
        q5.k.l(G()).f0(w7.u.H7).J(w7.u.f14310yb).X(w7.u.U2, new q5.k.m() { // from class: hb.l3
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                x8.f.k(this.f5951a.G());
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void B4() {
        String strY = this.f5806u0.y();
        if (Build.VERSION.SDK_INT < 21) {
            q5.k.l(G()).f0(w7.u.Z3).K(x8.c1.q(File.separator)).i(strY, X0(w7.u.L3), 1).X(R.string.ok, new q5.k.m() { // from class: hb.m3
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    b4.l3(this.f5971a, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
            return;
        }
        try {
            this.C0.a(x8.b1.o(strY) ? Uri.parse(strY) : null);
        } catch (ActivityNotFoundException e10) {
            tc.a.j(e10);
        }
    }

    public final void C4(v5.q qVar, int i10) {
        FragmentUtils.i(this, jb.k5.class);
    }

    public final void D4() {
        String[] strArr = {X0(w7.u.Ld), X0(w7.u.f14092j), X0(w7.u.sg), X0(w7.u.I), X0(w7.u.Xb)};
        int iX1 = this.f5806u0.X1();
        int[] iArr = new int[10];
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            if (((1 << i11) & iX1) != 0) {
                iArr[i10] = i11;
                i10++;
            }
        }
        q5.k.l(G()).g0(X0(w7.u.xg)).K(X0(w7.u.f14268v8)).M(strArr, Arrays.copyOf(iArr, i10)).X(R.string.ok, new q5.k.m() { // from class: hb.u2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                b4.k3(this.f6088a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void F4() {
        int iD4 = d4(14);
        v5.q qVarF4 = f4(iD4);
        if (qVarF4 == null) {
            return;
        }
        qVarF4.h(this.f5806u0.Q(G()));
        this.f5810y0.m(iD4);
    }

    public final void G4(int i10, String str) {
        int iD4;
        v5.q qVarF4;
        if (this.f5810y0 == null || (iD4 = d4(i10)) < 0 || (qVarF4 = f4(iD4)) == null) {
            return;
        }
        qVarF4.h(str);
        qVarF4.g(false);
        this.f5810y0.m(iD4);
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        p4();
        s4();
        r4();
        q4();
    }

    public final boolean U3(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(x8.b1.i(G(), uri));
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
                } catch (Throwable th) {
                    try {
                        zipInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
                tc.a.b(e);
            }
        } catch (IOException e10) {
            tc.a.b(e10);
        }
        return false;
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f5809x0 = x8.s1.d();
        t5.f fVar = new t5.f(Collections.EMPTY_LIST);
        this.f5810y0 = fVar;
        fVar.K(v5.q.class, new v5.s(new t5.g() { // from class: hb.t3
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6073a.v4(view2, i10, (v5.q) obj);
            }
        }));
        this.f5810y0.K(v5.n.class, new v5.p(new t5.g() { // from class: hb.u3
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f6089a.u4(view2, i10, (v5.n) obj);
            }
        }));
        this.f7946t0.setLayoutManager(new LinearLayoutManager(G()));
        this.f7946t0.setItemAnimator(null);
        this.f7946t0.setAdapter(this.f5810y0);
        SettingsSearchLocator.b(this, this.f7946t0);
        o4();
    }

    public final void W3() {
        if (Environment.DIRECTORY_DOWNLOADS.equals(this.f5806u0.y())) {
            B4();
            return;
        }
        q5.k kVarL = q5.k.l(G());
        kVarL.f0(w7.u.Z3);
        kVarL.G(new String[]{X0(w7.u.f14285x), X0(w7.u.f14106k)}, new AdapterView.OnItemClickListener() { // from class: hb.a3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                b4.G3(this.f5786a, adapterView, view, i10, j10);
            }
        });
        kVarL.h0();
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        x8.v3.a(e0Var, w7.u.Fc);
    }

    public final void Z3() {
        this.J0.d(X0(w7.u.f14066h1) + "_" + X0(w7.u.f14054g3) + "_" + this.f5809x0 + ".zip", new n8.d.a() { // from class: hb.e3
            @Override // n8.d.a
            public final void a(Uri uri, String str) {
                this.f5852a.b4(uri, str);
            }
        });
    }

    public final void a4() {
        q5.k.l(G()).g0(X0(w7.u.f14084i5)).M(new String[]{X0(w7.u.f14092j), X0(w7.u.Ld), X0(w7.u.I), X0(w7.u.f14020db), X0(w7.u.Bc), X0(w7.u.f14296xa)}, new int[]{0, 1, 2, 3, 4}).X(R.string.ok, new q5.k.m() { // from class: hb.w2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                b4.E3(this.f6117a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void b4(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        final String str2 = this.I0;
        this.I0 = null;
        E4();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.q3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b4.K3(this.f6034c, str2, uri);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.b(this, Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: hb.r3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.u3(this.f6050c, str, (Boolean) obj);
            }
        }, new u6.f() { // from class: hb.s3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.y3(this.f6060c, (Throwable) obj);
            }
        });
    }

    public ZipBackupManager c4() {
        if (this.f5811z0 == null) {
            this.f5811z0 = new ZipBackupManager(G(), this.f5806u0, la.s.f(), this.f5807v0, kd.c().f(), la.s.k(), la.s.d(), la.s.l(), la.s.i());
        }
        return this.f5811z0;
    }

    public final int d4(int i10) {
        List listH = this.f5810y0.H();
        for (int i11 = 0; i11 < listH.size(); i11++) {
            Object obj = listH.get(i11);
            if ((obj instanceof v5.q) && ((v5.q) obj).c() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final v5.q f4(int i10) {
        List listH = this.f5810y0.H();
        if (i10 < 0 || i10 >= listH.size() || !(listH.get(i10) instanceof v5.q)) {
            return null;
        }
        return (v5.q) listH.get(i10);
    }

    public final void g4(final v5.q qVar, final int i10) {
        q5.k.l(G()).f0(w7.u.hg).i(this.f5806u0.C() == 3 ? this.f5806u0.p() : k8.a.f7220c, X0(w7.u.hg), 3).X(R.string.ok, new q5.k.m() { // from class: hb.k3
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                b4.C3(this.f5935a, qVar, i10, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void h4(final v5.q qVar, final int i10) {
        q5.k.l(G()).f0(w7.u.D6).b0(w7.j.f13713d, this.f5806u0.C(), new AdapterView.OnItemClickListener() { // from class: hb.t2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                b4.v3(this.f6070a, qVar, i10, adapterView, view, i11, j10);
            }
        }).h0();
    }

    public final void j4(final Uri uri) {
        if (uri == null) {
            return;
        }
        E4();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.g3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b4.B3(this.f5879c, uri);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.h3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.x3(this.f5886c, (Integer) obj);
            }
        }, new u6.f() { // from class: hb.i3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.N3(this.f5901c, (Throwable) obj);
            }
        });
    }

    public final void k4() {
        this.K0.b(new String[]{"text/plain", "application/zip"}, new n8.f.a() { // from class: hb.v2
            @Override // n8.f.a
            public final void a(Uri uri) {
                this.f6099a.l4(uri);
            }
        });
    }

    public final void l4(final Uri uri) {
        if (U3(uri)) {
            q5.k.l(G()).f0(w7.u.f14243ta).J(w7.u.f14257ua).i("", X0(w7.u.f14266v6), 1).X(R.string.ok, new q5.k.m() { // from class: hb.f3
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    b4.z3(this.f5864a, uri, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        } else {
            m4(uri, null);
        }
    }

    public final void m4(final Uri uri, final String str) {
        if (uri == null) {
            return;
        }
        E4();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.n3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b4.O3(this.f5986c, uri, str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.o3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.i3(this.f5999c, (Integer) obj);
            }
        }, new u6.f() { // from class: hb.p3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.f3(this.f6024c, (Throwable) obj);
            }
        });
    }

    public final void n4(final v5.q qVar, final int i10) {
        Map mapB = x8.f1.b();
        mapB.put("", X0(w7.u.T5));
        final String[] strArr = (String[]) mapB.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        String[] strArr2 = new String[strArr.length];
        String strM0 = this.f5806u0.M0();
        int length = strArr.length;
        final int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (strArr[i12].equals(strM0)) {
                i11 = i12;
            }
            strArr2[i12] = (String) mapB.get(strArr[i12]);
        }
        q5.k.l(G()).f0(w7.u.H7).d0(strArr2, i11, new AdapterView.OnItemClickListener() { // from class: hb.x2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i13, long j10) {
                b4.R3(this.f6139a, i11, strArr, qVar, i10, adapterView, view, i13, j10);
            }
        }).h0();
    }

    public final void p4() {
        final Context applicationContext = G().getApplicationContext();
        final String strO2 = this.f5806u0.O2();
        final String strY0 = this.f5806u0.y0();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.v3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6100c.w4(applicationContext);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.w3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.h3(this.f6118c, strO2, (String[][]) obj);
            }
        }, new w7.e0());
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.x3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6144c.x4(applicationContext);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.y3
            @Override // u6.f
            public final void accept(Object obj) {
                b4.q3(this.f6159c, strY0, (List) obj);
            }
        }, new w7.e0());
    }

    public final void q4() {
        int iD4;
        v5.q qVarF4;
        if (this.f5810y0 == null || (iD4 = d4(35)) < 0 || (qVarF4 = f4(iD4)) == null) {
            return;
        }
        qVarF4.h(this.f5806u0.c1());
        this.f5810y0.m(iD4);
    }

    public final void r4() {
        int iD4;
        v5.q qVarF4;
        if (this.f5810y0 == null || (iD4 = d4(12)) < 0 || (qVarF4 = f4(iD4)) == null) {
            return;
        }
        qVarF4.h(String.format(Locale.ROOT, "%d%%", Integer.valueOf(this.f5806u0.H0())));
        this.f5810y0.m(iD4);
    }

    public final void s4() {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: hb.n2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                b4 b4Var = this.f5985c;
                return x8.c4.d(b4Var.G(), b4Var.f5806u0.o0());
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: hb.y2
            @Override // u6.f
            public final void accept(Object obj) {
                b4.F3(this.f6158c, (String) obj);
            }
        }, new w7.e0());
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).j(this);
    }

    public final void t4() {
        u9.n.e().q(true);
    }

    public final String[][] w4(Context context) {
        return mark.via.download.u1.d().c(context);
    }

    public final List x4(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x.d.a("", context.getString(w7.u.Ia)));
        Intent intentH = x8.e1.h("https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_480_1_5MG.mp4", null);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intentH, 0).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo.enabled) {
                    arrayList.add(x.d.a(activityInfo.packageName, activityInfo.loadLabel(packageManager).toString()));
                }
            }
        }
        return arrayList;
    }

    public final void y4() {
        int iL0 = this.f5806u0.l0();
        int i10 = 2;
        if (iL0 == 2) {
            i10 = 10;
        } else if (iL0 == 3) {
            i10 = 1;
        } else if (iL0 == 4) {
            i10 = 0;
        }
        x8.j3.i(G(), i10);
    }

    public final void z4() {
        if ((this.A0 & 32) == 0) {
            Z3();
        } else {
            this.H0.a(X0(w7.u.f14084i5), X0(w7.u.xh), new a(G()));
        }
    }
}
