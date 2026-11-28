package mark.via.download;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.FragmentUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import mark.via.browser.zc;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m1 extends m8.g implements j5.c, j5.a {
    public FrameLayout A0;
    public RecyclerView B0;
    public View C0;
    public EditText D0;
    public c5.a E0;
    public w5.a F0;
    public o8.b G0;
    public t5.f H0;
    public DownloadTaskViewDelegate I0;
    public String J0;
    public l8.b K0;
    public com.tuyafeng.support.widget.d0 M0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public RadioGroup f10236s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f10237t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public long f10238u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public com.tuyafeng.support.widget.f0 f10239v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public com.tuyafeng.support.widget.f0.b f10240w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public com.tuyafeng.support.widget.f0.b f10241x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public com.tuyafeng.support.widget.f0.b f10242y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public com.tuyafeng.support.widget.f0.b f10243z0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f10235r0 = 0;
    public boolean L0 = true;
    public final t8.b N0 = new t8.b();
    public final HashMap O0 = new HashMap();
    public int P0 = 0;
    public WeakReference Q0 = null;
    public g5.c R0 = null;
    public final androidx.activity.result.b S0 = x8.y1.d(this, new Runnable() { // from class: mark.via.download.e1
        @Override // java.lang.Runnable
        public final void run() {
            this.f10178c.y4();
        }
    });
    public final androidx.activity.result.b T0 = w2(new s5.d(), new androidx.activity.result.a() { // from class: mark.via.download.g1
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            m1.N3(this.f10191a, (Uri) obj);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i10) {
            int i11 = m1.this.f10235r0;
            if (i10 == w7.p.f13906s) {
                i11 = 0;
            } else if (i10 == w7.p.f13909t) {
                i11 = 3;
            } else if (i10 == w7.p.f13912u) {
                i11 = 5;
            } else if (i10 == w7.p.f13918w) {
                i11 = 6;
            } else if (i10 == w7.p.f13921x) {
                i11 = 7;
            } else if (i10 == w7.p.f13927z) {
                i11 = 2;
            } else if (i10 == w7.p.f13924y) {
                i11 = 8;
            } else if (i10 == w7.p.f13915v) {
                i11 = 1;
            }
            if (i11 != m1.this.f10235r0) {
                m1.this.f10235r0 = i11;
                m1.this.m4(true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements w5.a.InterfaceC0153a {
        public b() {
        }

        @Override // w5.a.InterfaceC0153a
        public void a(int i10) {
            m1 m1Var;
            int i11;
            boolean z10 = m1.this.H0.g() > 0 && m1.this.H0.g() == i10;
            com.tuyafeng.support.widget.f0.b bVar = m1.this.f10241x0;
            if (z10) {
                m1Var = m1.this;
                i11 = w7.u.W1;
            } else {
                m1Var = m1.this;
                i11 = w7.u.uc;
            }
            bVar.l(m1Var.X0(i11));
            m1.this.f10242y0.j(i10 <= 0);
            m1.this.f10242y0.h(i10 > 0);
            m1.this.f10242y0.l(i10 == 0 ? m1.this.X0(w7.u.f14298y) : m1.this.Y0(w7.u.f14194q3, Integer.valueOf(i10)));
            m1.this.f10239v0.l(m1.this.f10241x0, m1.this.f10242y0);
        }

        @Override // w5.a.InterfaceC0153a
        public void b(boolean z10) {
            m1.this.I0.I(z10);
            m1.this.H0.l();
            m1.this.z4(z10);
            if (z10) {
                a(m1.this.F0.a());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements l8.a {
        public c() {
        }

        @Override // l8.a
        public boolean a(int i10) {
            return m1.this.F0.d(i10);
        }

        @Override // l8.a
        public void b(int i10, boolean z10) {
            if (m1.this.F0.j(i10, z10)) {
                m1.this.H0.m(i10);
            }
        }

        @Override // l8.a
        public boolean c(int i10) {
            return m1.this.F0.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements o8.a {
        public e() {
        }

        public static /* synthetic */ long e(g5.c cVar) {
            return cVar.b() * 1000;
        }

        @Override // o8.a
        public void c(List list) {
            m1.this.N0.g(list, new t8.c() { // from class: mark.via.download.n1
                @Override // t8.c
                public final long a(Object obj) {
                    return m1.e.e((g5.c) obj);
                }
            });
            m1.this.H0.l();
            m1.this.p4(list.isEmpty());
        }

        @Override // o8.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(int i10, g5.c cVar) {
            m1.S3(m1.this);
            m1.this.N0.a(cVar.b() * 1000);
            m1.this.H0.o(i10);
            m1.this.p4(false);
        }

        @Override // o8.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(int i10, g5.c cVar) {
            m1.T3(m1.this);
            w5.b bVarC = m1.this.N0.c(i10);
            m1.this.N0.f(i10);
            m1.this.H0.u(i10);
            if (bVarC.c()) {
                m1.this.H0.n(i10 - 1, Boolean.FALSE);
            }
            m1 m1Var = m1.this;
            m1Var.p4(m1Var.G0.e());
        }

        @Override // o8.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void b(int i10, g5.c cVar, Object obj) {
            m1.this.H0.n(i10, obj);
        }
    }

    public static /* synthetic */ void A3(m1 m1Var, View view, q5.k.p pVar) {
        m1Var.getClass();
        String[] strArr = pVar.f11819c;
        if (strArr == null || strArr.length < 2) {
            return;
        }
        String str = strArr[0];
        c6.a2 a2Var = c6.a2.f1958a;
        if (!a2Var.t(str) || !a2Var.u(str)) {
            com.tuyafeng.support.utils.n.q(m1Var.G(), w7.u.X1);
            return;
        }
        String strB = l5.b.b(Uri.parse(str).getEncodedPath(), null, null);
        String str2 = pVar.f11819c[1];
        if (str2 == null || str2.isEmpty()) {
            str2 = strB;
        }
        String strN4 = n4(str2);
        if (strN4 == null && !str2.equals(strB)) {
            strN4 = n4(strB);
        }
        g5.c cVar = new g5.c();
        cVar.K(str2);
        cVar.L(m1Var.J0);
        cVar.T(str);
        cVar.O(true);
        cVar.x(8);
        cVar.U(strN4 == null);
        if (strN4 == null) {
            strN4 = "application/octet-stream";
        }
        cVar.J(strN4);
        cVar.Q(90);
        int i10 = t1.i(m1Var.G(), cVar, m1Var.J0);
        if (i10 == 2) {
            com.tuyafeng.support.utils.n.q(m1Var.G(), w7.u.f14027e4);
            return;
        }
        if (i10 == 3) {
            m1Var.u4(cVar);
            return;
        }
        long j10 = m1Var.E0.j(cVar);
        cVar.H(j10);
        if (j10 > 0) {
            k.c(m1Var.G(), j10);
            int checkedRadioButtonId = m1Var.f10236s0.getCheckedRadioButtonId();
            int i11 = w7.p.f13906s;
            if (checkedRadioButtonId == i11) {
                m1Var.G0.a(0, cVar);
            } else {
                m1Var.f10236s0.check(i11);
            }
            m1Var.B0.p1(0);
        }
    }

    public static /* synthetic */ void B3(final m1 m1Var, View view, final q5.k.p pVar) {
        m1Var.getClass();
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.download.q0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m1.d3(this.f10281c, pVar);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(m1Var.b1()))).a(new u6.f() { // from class: mark.via.download.r0
            @Override // u6.f
            public final void accept(Object obj) {
                m1.q3(this.f10287c, (int[]) obj);
            }
        }, new w7.a0());
    }

    public static /* synthetic */ Pair D3(m1 m1Var, int i10, String str) {
        List<g5.c> listA = m1Var.E0.a();
        if (i10 == 0 && str.isEmpty()) {
            return Pair.create(listA, Integer.valueOf(listA.size()));
        }
        ArrayList arrayList = new ArrayList();
        for (g5.c cVar : listA) {
            if (m1Var.i4(cVar, str, i10)) {
                arrayList.add(cVar);
            }
        }
        return Pair.create(arrayList, Integer.valueOf(listA.size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D4(boolean z10) {
        com.tuyafeng.support.widget.d0 d0Var;
        if (U2() && (d0Var = this.M0) != null) {
            d0Var.setGestureEnabled(z10);
        }
    }

    public static /* synthetic */ void E3(m1 m1Var, RecyclerView recyclerView, DownloadTaskViewDelegate downloadTaskViewDelegate) {
        if (m1Var.B0 == recyclerView && m1Var.I0 == downloadTaskViewDelegate && recyclerView.isAttachedToWindow()) {
            downloadTaskViewDelegate.N(true);
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iA2 = linearLayoutManager.a2();
                int iD2 = linearLayoutManager.d2();
                if (iA2 == -1 || iD2 < iA2) {
                    return;
                }
                m1Var.H0.r(iA2, (iD2 - iA2) + 1, 2);
            }
        }
    }

    public static /* synthetic */ String H3(m1 m1Var, g5.c cVar) throws IOException {
        InputStream inputStreamOpenInputStream = m1Var.G().getContentResolver().openInputStream(cVar.f());
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
            if (bitmapDecodeStream == null) {
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return "";
            }
            try {
                String strM = com.tuyafeng.support.utils.p.m(n5.z.c(bitmapDecodeStream));
                if (!bitmapDecodeStream.isRecycled()) {
                    bitmapDecodeStream.recycle();
                }
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return strM;
            } catch (Throwable th) {
                if (!bitmapDecodeStream.isRecycled()) {
                    bitmapDecodeStream.recycle();
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public static /* synthetic */ void J3(HorizontalScrollView horizontalScrollView) {
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setVerticalScrollBarEnabled(false);
    }

    public static /* synthetic */ boolean K3(m1 m1Var, long j10, Pair pair) {
        return j10 == m1Var.f10238u0;
    }

    public static /* synthetic */ void L3(m1 m1Var, g5.c cVar, String str, Uri uri) {
        cVar.K(x8.b1.k(m1Var.G(), uri));
        if (str != null) {
            cVar.J(str);
        }
        cVar.C(uri);
        m1Var.E0.b(cVar);
        m1Var.E4(cVar, false);
    }

    public static /* synthetic */ void M3(m1 m1Var, boolean z10, Pair pair) {
        m1Var.getClass();
        List list = (List) pair.first;
        m1Var.f10237t0 = ((Integer) pair.second).intValue();
        w5.a aVar = m1Var.F0;
        aVar.k(aVar.c() && !list.isEmpty());
        if (z10 && m1Var.F0.c()) {
            m1Var.F0.n();
        }
        m1Var.G0.l(list);
    }

    public static /* synthetic */ void N3(m1 m1Var, Uri uri) {
        if (uri == null) {
            m1Var.getClass();
            return;
        }
        m1Var.G().getContentResolver().takePersistableUriPermission(uri, 3);
        la.s.j().r(uri.toString());
        m1Var.J0 = la.s.j().y();
        m1Var.y4();
    }

    public static /* synthetic */ void O3(m1 m1Var, long j10, Object obj) {
        int iK4 = m1Var.k4(j10);
        if (iK4 >= 0) {
            m1Var.H0.n(iK4, obj);
        }
    }

    public static /* synthetic */ int S3(m1 m1Var) {
        int i10 = m1Var.f10237t0;
        m1Var.f10237t0 = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int T3(m1 m1Var) {
        int i10 = m1Var.f10237t0;
        m1Var.f10237t0 = i10 - 1;
        return i10;
    }

    public static /* synthetic */ boolean a3(m1 m1Var, View view, int i10, g5.c cVar) {
        if (m1Var.F0.c()) {
            m1Var.K0.n(true, i10);
            return true;
        }
        m1Var.C4(view, i10);
        return true;
    }

    public static /* synthetic */ void b3(m1 m1Var, TextView textView) {
        m1Var.getClass();
        r3.f(textView);
        textView.setTextSize(0, v8.h.s(m1Var.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(m1Var.G(), w7.k.f13733m));
        textView.setGravity(17);
        textView.setVisibility(8);
    }

    public static /* synthetic */ void c3(m1 m1Var, int i10, Boolean bool) {
        m1Var.getClass();
        if (bool.booleanValue()) {
            m1Var.G0.j(i10);
        }
    }

    public static /* synthetic */ int[] d3(m1 m1Var, q5.k.p pVar) {
        int[] iArrB = m1Var.F0.b(true);
        int[] iArr = new int[iArrB.length];
        int i10 = 0;
        for (int i11 : iArrB) {
            g5.c cVar = (g5.c) m1Var.G0.c(i11);
            if (m1Var.g4(cVar, !g5.b.e(cVar.q()) || pVar.f11818b)) {
                iArr[i10] = i11;
                i10++;
            }
        }
        return iArr;
    }

    public static /* synthetic */ void e3(m1 m1Var, com.tuyafeng.support.widget.f0 f0Var) {
        m1Var.f10240w0 = new com.tuyafeng.support.widget.f0.b(w7.p.L0, m1Var.X0(w7.u.O));
        com.tuyafeng.support.widget.f0.b bVar = new com.tuyafeng.support.widget.f0.b(w7.p.S0, m1Var.X0(w7.u.uc));
        m1Var.f10241x0 = bVar;
        bVar.k(true);
        com.tuyafeng.support.widget.f0.b bVar2 = new com.tuyafeng.support.widget.f0.b(w7.p.M0, m1Var.X0(w7.u.f14298y));
        m1Var.f10242y0 = bVar2;
        bVar2.i(true);
        m1Var.f10242y0.j(true);
        m1Var.f10242y0.k(true);
        m1Var.f10243z0 = new com.tuyafeng.support.widget.f0.b(w7.p.N0, m1Var.X0(w7.u.E));
        f0Var.b(m1Var.f10240w0);
        f0Var.b(m1Var.f10241x0);
        f0Var.b(m1Var.f10242y0);
        f0Var.c(m1Var.f10243z0);
    }

    public static /* synthetic */ void f3(m1 m1Var, g5.c cVar, View view, q5.k.p pVar) {
        boolean z10 = true;
        if (x8.b1.p(m1Var.G(), cVar.f())) {
            boolean zE = x8.b1.e(m1Var.G(), cVar.f());
            if (zE || m1Var.J0.equals(cVar.m())) {
                z10 = zE;
            } else {
                cVar.L(m1Var.J0);
            }
        }
        if (z10) {
            int i10 = t1.i(m1Var.G(), cVar, m1Var.J0);
            if (i10 == 2) {
                com.tuyafeng.support.utils.n.q(m1Var.G(), w7.u.f14027e4);
            } else if (i10 == 3) {
                m1Var.u4(cVar);
            } else {
                m1Var.E0.b(cVar);
                k.b(m1Var.G(), cVar.j());
            }
        }
    }

    public static /* synthetic */ void g3(m1 m1Var, g5.c cVar, Uri uri, View view, q5.k.p pVar) {
        m1Var.R0 = cVar;
        try {
            m1Var.T0.a(uri);
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    public static /* synthetic */ void h3(m1 m1Var, View view, com.tuyafeng.support.widget.f0.b bVar) {
        m1Var.getClass();
        int iA = bVar.a();
        if (iA == w7.p.L0) {
            m1Var.v4();
            return;
        }
        if (iA == w7.p.N0) {
            w5.a aVar = m1Var.F0;
            aVar.k(!aVar.c());
            return;
        }
        if (iA != w7.p.S0) {
            if (iA == w7.p.M0) {
                m1Var.s4();
                return;
            }
            return;
        }
        int iG = m1Var.H0.g();
        if (iG == 0) {
            return;
        }
        if (iG == m1Var.F0.a()) {
            m1Var.F0.l(0, iG);
        } else {
            m1Var.F0.f(0, iG);
        }
        m1Var.H0.q(0, iG);
    }

    public static /* synthetic */ void i3(m1 m1Var, int i10, g5.c cVar, AdapterView adapterView, View view, int i11, long j10) {
        m1Var.getClass();
        switch ((int) j10) {
            case 1:
                m1Var.r4(i10);
                break;
            case 2:
                m1Var.x4(i10);
                break;
            case 3:
                m1Var.t4(i10);
                break;
            case 4:
                m1Var.f4(i10);
                break;
            case 5:
                m1Var.A4(i10);
                break;
            case 6:
                m1Var.q4((g5.c) m1Var.G0.c(i10), true);
                break;
            case 7:
                m1Var.B4(cVar.j(), cVar.l());
                break;
        }
    }

    public static /* synthetic */ void k3(mark.via.common.widget.v0 v0Var) {
        r3.i(v0Var);
        r3.e(v0Var);
    }

    public static /* synthetic */ void l3(m1 m1Var, CharSequence charSequence) {
        m1Var.f10238u0++;
    }

    public static /* synthetic */ void n3(EditText editText, View view, boolean z10) {
        if (z10) {
            String string = editText.getText().toString();
            int iLastIndexOf = string.lastIndexOf(".");
            if (iLastIndexOf == -1 || string.length() - iLastIndexOf >= 7) {
                editText.selectAll();
            } else {
                editText.setSelection(0, iLastIndexOf);
            }
        }
    }

    public static String n4(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            return l5.c.c(str.substring(iLastIndexOf + 1), null);
        }
        return null;
    }

    public static /* synthetic */ void o3(final m1 m1Var, boolean z10, final g5.c cVar, final int i10, View view, q5.k.p pVar) {
        m1Var.getClass();
        final boolean z11 = !z10 || pVar.f11818b;
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.download.d1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(this.f10172c.g4(cVar, z11));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(m1Var.b1()))).a(new u6.f() { // from class: mark.via.download.f1
            @Override // u6.f
            public final void accept(Object obj) {
                m1.c3(this.f10184c, i10, (Boolean) obj);
            }
        }, new w7.a0());
    }

    public static Bundle o4(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("draggable", z10);
        return bundle;
    }

    public static /* synthetic */ void p3(m1 m1Var, View view, int i10) {
        g5.c cVar = (g5.c) m1Var.G0.c(i10);
        if (g5.b.d(cVar.q())) {
            k.a(m1Var.G(), cVar.j());
            return;
        }
        int i11 = t1.i(m1Var.G(), cVar, m1Var.J0);
        if (i11 == 1) {
            m1Var.E0.b(cVar);
        } else if (i11 == 2) {
            com.tuyafeng.support.utils.n.q(m1Var.G(), w7.u.f14027e4);
            return;
        } else if (i11 == 3) {
            m1Var.u4(cVar);
            return;
        }
        k.c(m1Var.G(), cVar.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p4(boolean z10) {
        boolean z11 = this.D0.length() > 0 || this.f10237t0 > 0;
        if (!z11 && this.D0.hasFocus()) {
            x8.f.e(this.D0);
            this.D0.clearFocus();
        }
        this.D0.setVisibility(z11 ? 0 : 8);
        ((View) this.f10236s0.getParent()).setVisibility(z11 ? 0 : 8);
        if (z10 == (this.A0.getVisibility() == 8)) {
            return;
        }
        this.f10243z0.j(z10);
        this.f10239v0.j(this.f10243z0);
        if (z10) {
            this.A0.setVisibility(8);
            this.C0.setVisibility(0);
        } else {
            this.A0.setVisibility(0);
            this.C0.setVisibility(8);
        }
    }

    public static /* synthetic */ void q3(m1 m1Var, int[] iArr) {
        m1Var.getClass();
        for (int i10 : iArr) {
            m1Var.G0.j(i10);
        }
        m1Var.F0.k(false);
    }

    public static /* synthetic */ void r3(m1 m1Var, com.tuyafeng.support.widget.b bVar) {
        m1Var.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tuyafeng.support.widget.b.C0051b(w7.p.f13906s, m1Var.X0(w7.u.f14055g4)));
        arrayList.add(new com.tuyafeng.support.widget.b.C0051b(w7.p.f13918w, m1Var.X0(w7.u.f14111k4)));
        arrayList.add(new com.tuyafeng.support.widget.b.C0051b(w7.p.f13912u, m1Var.X0(w7.u.f14083i4)));
        arrayList.add(new com.tuyafeng.support.widget.b.C0051b(w7.p.f13909t, m1Var.X0(w7.u.f14069h4)));
        arrayList.add(new com.tuyafeng.support.widget.b.C0051b(w7.p.f13921x, m1Var.X0(w7.u.f14125l4)));
        arrayList.add(new com.tuyafeng.support.widget.b.C0051b(w7.p.f13927z, m1Var.X0(w7.u.f14153n4)));
        arrayList.add(new com.tuyafeng.support.widget.b.C0051b(w7.p.f13915v, m1Var.X0(w7.u.f14097j4)));
        arrayList.add(new com.tuyafeng.support.widget.b.C0051b(w7.p.f13924y, m1Var.X0(w7.u.f14139m4)));
        bVar.setFilters(arrayList);
        bVar.check(w7.p.f13906s);
    }

    public static /* synthetic */ void s3(m1 m1Var, long j10, int i10, int i11, String str) {
        m1Var.O0.put(Long.valueOf(j10), str);
        WeakReference weakReference = m1Var.Q0;
        q5.k kVar = weakReference == null ? null : (q5.k) weakReference.get();
        if (str.isEmpty() || m1Var.P0 != i10 || kVar == null || !kVar.s()) {
            return;
        }
        RecyclerView.o layoutManager = m1Var.B0.getLayoutManager();
        View viewD = layoutManager != null ? layoutManager.D(i11) : null;
        if (viewD == null) {
            return;
        }
        m1Var.C4(viewD, i11);
    }

    public static /* synthetic */ Uri t3(m1 m1Var, g5.c cVar, String str, String str2) {
        if (x8.b1.s(m1Var.G(), cVar.f(), str)) {
            return cVar.f();
        }
        Uri uriC = x8.b1.c(m1Var.G(), cVar.m(), str, str2);
        if (x8.b1.r(m1Var.G(), cVar.f(), uriC)) {
            return uriC;
        }
        return null;
    }

    public static /* synthetic */ void u3(m1 m1Var, View view, int i10, g5.c cVar) {
        if (!m1Var.F0.c()) {
            m1Var.q4((g5.c) m1Var.G0.c(i10), false);
        } else {
            m1Var.F0.h(i10);
            m1Var.H0.m(i10);
        }
    }

    public static /* synthetic */ void x3(m1 m1Var, EditText editText) {
        m1Var.getClass();
        v8.g.h(editText);
        editText.setTextSize(0, v8.h.q(m1Var.G()));
        editText.setTextColor(com.tuyafeng.support.utils.e.a(m1Var.G(), w7.k.f13732l));
        editText.setHintTextColor(com.tuyafeng.support.utils.e.a(m1Var.G(), w7.k.f13731k));
        editText.setCompoundDrawablePadding(com.tuyafeng.support.utils.x.h(m1Var.G(), 12.0f));
        editText.setHint(w7.u.f14063gc);
        editText.setVisibility(8);
        editText.setInputType(1);
        editText.setImeOptions(6);
        Drawable drawableA = lb.g.a(m1Var.G(), w7.o.f13846y, w7.u.je);
        com.tuyafeng.support.utils.h.a(drawableA, com.tuyafeng.support.utils.e.a(m1Var.G(), w7.k.f13729i));
        com.tuyafeng.support.utils.x.Q(editText, drawableA);
        r3.o(editText);
        v8.g.d(editText);
    }

    public static /* synthetic */ void y3(final m1 m1Var, final g5.c cVar, View view, q5.k.p pVar) {
        m1Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        final String str = pVar.f11819c[0];
        if (cVar.l().equalsIgnoreCase(str)) {
            return;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        final String strC = iLastIndexOf > 0 ? l5.c.c(str.substring(iLastIndexOf + 1), "application/octet-stream") : "application/octet-stream";
        ((autodispose2.m) r6.f.h(new Callable() { // from class: mark.via.download.z0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m1.t3(this.f10325c, cVar, str, strC);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(m1Var.b1()))).a(new u6.f() { // from class: mark.via.download.a1
            @Override // u6.f
            public final void accept(Object obj) {
                m1.L3(this.f10154c, cVar, strC, (Uri) obj);
            }
        }, new w7.a0());
    }

    public static /* synthetic */ void z3(View view) {
        final EditText editText = (EditText) view;
        editText.setSelectAllOnFocus(true);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: mark.via.download.b1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                m1.n3(editText, view2, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z4(boolean z10) {
        this.f10243z0.l(X0(z10 ? w7.u.X3 : w7.u.E));
        this.f10241x0.k(!z10);
        this.f10242y0.k(!z10);
        this.f10240w0.k(z10);
        this.f10239v0.l(this.f10243z0, this.f10241x0, this.f10242y0, this.f10240w0);
    }

    public final void A4(int i10) {
        g5.c cVar = (g5.c) this.G0.c(i10);
        if ((g5.b.e(cVar.q()) && (!x8.f.j(this, 2) || x8.e1.m(G(), cVar.f(), cVar.k()))) || cVar.t() == null || cVar.t().isEmpty()) {
            return;
        }
        x8.e1.k(G(), cVar.t());
    }

    public final void B4(long j10, String str) {
        final String str2 = (String) this.O0.get(Long.valueOf(j10));
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        q5.k kVarX = q5.k.l(G()).g0(str).K(str2).X(R.string.ok, null);
        if (c6.a2.f1958a.t(str2)) {
            kVarX.T(w7.u.f14228s9, new View.OnClickListener() { // from class: mark.via.download.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x8.z.O(this.f10315a.G(), str2);
                }
            });
        } else {
            kVarX.T(w7.u.f14272w, new View.OnClickListener() { // from class: mark.via.download.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.tuyafeng.support.utils.n.a(this.f10320a.G(), str2, w7.u.Eg);
                }
            });
        }
        kVarX.h0();
    }

    public final void C4(View view, final int i10) {
        ArrayList arrayList = new ArrayList();
        final g5.c cVar = (g5.c) this.G0.c(i10);
        int iQ = cVar.q();
        if (g5.b.e(iQ)) {
            arrayList.add(new q5.k.l(6, X0(w7.u.H9)));
            arrayList.add(new q5.k.l(1, X0(w7.u.f14062gb)));
        }
        if (!g5.b.d(iQ) && cVar.t() != null && !cVar.t().isEmpty()) {
            arrayList.add(new q5.k.l(2, X0(w7.u.Y)));
        }
        if (cVar.t() != null && !cVar.t().isEmpty()) {
            arrayList.add(new q5.k.l(4, X0(w7.u.f14232t)));
        }
        String str = (String) this.O0.get(Long.valueOf(cVar.j()));
        if (str == null) {
            w4(i10);
        } else if (!str.isEmpty()) {
            arrayList.add(new q5.k.l(7, X0(w7.u.Qb)));
        }
        arrayList.add(new q5.k.l(5, X0(w7.u.f14037f0)));
        arrayList.add(new q5.k.l(3, X0(w7.u.f14298y)));
        WeakReference weakReference = this.Q0;
        q5.k kVar = weakReference == null ? null : (q5.k) weakReference.get();
        if (kVar != null && kVar.s()) {
            kVar.m0(arrayList);
            return;
        }
        q5.k kVarD = q5.k.l(G()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: mark.via.download.m0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                m1.i3(this.f10232a, i10, cVar, adapterView, view2, i11, j10);
            }
        });
        this.Q0 = new WeakReference(kVarD);
        kVarD.j0(view);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void D1() {
        DownloadTaskViewDelegate downloadTaskViewDelegate = this.I0;
        if (downloadTaskViewDelegate != null) {
            downloadTaskViewDelegate.F();
        }
        super.D1();
    }

    public final void E4(g5.c cVar, boolean z10) {
        int iK4;
        if (cVar == null || this.B0 == null || this.H0 == null || (iK4 = k4(cVar.j())) == -1) {
            return;
        }
        this.G0.k(iK4, cVar, z10 ? 1 : null);
    }

    @Override // j5.c
    public void I(g5.c cVar, int i10, int i11) {
        if (g5.b.e(i11) && cVar.k() != null && cVar.k().startsWith("image/")) {
            t1.g(G(), cVar.f());
        }
        E4(cVar, false);
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void M1() {
        this.E0.f(this);
        this.E0.c(this);
        super.M1();
    }

    @Override // m8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        this.E0.d(this);
        this.E0.e(this);
        if (this.L0) {
            this.L0 = false;
        } else {
            m4(false);
        }
    }

    @Override // m8.g
    public void S2() {
        if (U2()) {
            super.S2();
        }
    }

    @Override // m8.g
    public void T2() {
        if (this.F0.c()) {
            this.F0.k(false);
        } else {
            super.T2();
        }
    }

    @Override // m8.g
    public boolean U2() {
        return w0() == null || w0().getBoolean("draggable", true);
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.M0 = (com.tuyafeng.support.widget.d0) view.findViewById(com.tuyafeng.support.utils.x.f3593a);
        ((autodispose2.n) s8.c.a(this.D0).E(1L).n(new u6.f() { // from class: mark.via.download.h1
            @Override // u6.f
            public final void accept(Object obj) {
                m1.l3(this.f10196c, (CharSequence) obj);
            }
        }).g(100L, TimeUnit.MILLISECONDS).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.download.i1
            @Override // u6.f
            public final void accept(Object obj) {
                this.f10217c.m4(true);
            }
        }, new w7.e0());
        this.f10236s0.setOnCheckedChangeListener(new a());
        this.E0 = c5.b.r(G());
        this.B0.setLayoutManager(new LinearLayoutManager(G()));
        androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e();
        eVar.U(false);
        this.B0.setItemAnimator(eVar);
        this.N0.h(new t8.a(G()));
        Context contextG = G();
        t8.b bVar = this.N0;
        Objects.requireNonNull(bVar);
        x5.b bVar2 = new x5.b(contextG, new zc(bVar));
        bVar2.n(com.tuyafeng.support.utils.e.a(G(), w7.k.f13722b));
        bVar2.o(1);
        bVar2.p(com.tuyafeng.support.utils.x.h(G(), 6.0f));
        this.B0.k(bVar2);
        this.B0.n(bVar2);
        this.G0 = new o8.b();
        w5.a aVar = new w5.a();
        this.F0 = aVar;
        aVar.i(new b());
        this.H0 = new t5.f(this.G0.d());
        DownloadTaskViewDelegate downloadTaskViewDelegate = new DownloadTaskViewDelegate();
        this.I0 = downloadTaskViewDelegate;
        downloadTaskViewDelegate.J(new DownloadTaskViewDelegate.f() { // from class: mark.via.download.j1
            @Override // mark.via.download.DownloadTaskViewDelegate.f
            public final void a(View view2, int i10, g5.c cVar) {
                m1.u3(this.f10225a, view2, i10, cVar);
            }
        });
        this.I0.K(new DownloadTaskViewDelegate.g() { // from class: mark.via.download.k1
            @Override // mark.via.download.DownloadTaskViewDelegate.g
            public final boolean a(View view2, int i10, g5.c cVar) {
                return m1.a3(this.f10227a, view2, i10, cVar);
            }
        });
        this.I0.M(new DownloadTaskViewDelegate.h() { // from class: mark.via.download.l1
            @Override // mark.via.download.DownloadTaskViewDelegate.h
            public final void a(View view2, int i10) {
                m1.p3(this.f10231a, view2, i10);
            }
        });
        this.I0.H(new DownloadTaskViewDelegate.e() { // from class: mark.via.download.y
            @Override // mark.via.download.DownloadTaskViewDelegate.e
            public final boolean a(int i10, g5.c cVar) {
                return this.f10319a.F0.d(i10);
            }
        });
        this.I0.L(new DownloadTaskViewDelegate.i() { // from class: mark.via.download.z
            @Override // mark.via.download.DownloadTaskViewDelegate.i
            public final void a(long j10, Object obj) {
                m1.O3(this.f10324a, j10, obj);
            }
        });
        this.H0.K(g5.c.class, this.I0);
        this.B0.setAdapter(this.H0);
        h4();
        l8.b bVar3 = new l8.b(G(), new c());
        this.K0 = bVar3;
        bVar3.p(com.tuyafeng.support.utils.x.h(G(), com.tuyafeng.support.utils.l.d(G()) ? 48.0f : -48.0f));
        this.K0.o(new d());
        this.B0.n(this.K0);
        l4();
        this.J0 = la.s.j().y();
        this.L0 = true;
        m4(true);
        this.f10239v0.setOnActionClickListener(new com.tuyafeng.support.widget.f0.c() { // from class: mark.via.download.a0
            @Override // com.tuyafeng.support.widget.f0.c
            public final void a(View view2, com.tuyafeng.support.widget.f0.b bVar4) {
                m1.h3(this.f10153a, view2, bVar4);
            }
        });
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.D0 = (EditText) new b6.a(new EditText(G()), new FrameLayout.LayoutParams(-1, -2)).w(com.tuyafeng.support.utils.x.h(G(), 14.0f)).A(com.tuyafeng.support.utils.x.h(G(), 10.0f)).s(com.tuyafeng.support.utils.x.h(G(), 4.0f)).M(com.tuyafeng.support.utils.x.h(G(), 16.0f)).S(com.tuyafeng.support.utils.x.h(G(), 10.0f)).d(com.tuyafeng.support.utils.e.b(G(), w7.k.f13721a)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.download.b0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                m1.x3(this.f10158a, (EditText) obj);
            }
        }).l();
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) new b6.a(new HorizontalScrollView(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.x.h(G(), 36.0f))).V(new b6.a.InterfaceC0033a() { // from class: mark.via.download.c0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                m1.J3((HorizontalScrollView) obj);
            }
        }).l();
        horizontalScrollView.setVisibility(8);
        this.f10236s0 = (RadioGroup) new b6.a(new com.tuyafeng.support.widget.b(G()), new FrameLayout.LayoutParams(-1, -1)).M(com.tuyafeng.support.utils.x.h(G(), 12.0f)).T(1, 2).V(new b6.a.InterfaceC0033a() { // from class: mark.via.download.d0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                m1.r3(this.f10171a, (com.tuyafeng.support.widget.b) obj);
            }
        }).l();
        this.A0 = (FrameLayout) new b6.a(new FrameLayout(G()), new LinearLayout.LayoutParams(-1, 0)).W(1.0f).l();
        this.B0 = (RecyclerView) new b6.a(new mark.via.common.widget.v0(G()), new FrameLayout.LayoutParams(-1, -1)).o(R.id.list).V(new b6.a.InterfaceC0033a() { // from class: mark.via.download.e0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                m1.k3((mark.via.common.widget.v0) obj);
            }
        }).l();
        this.C0 = new b6.a(new TextView(G()), new LinearLayout.LayoutParams(-1, 0)).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: mark.via.download.f0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                m1.b3(this.f10183a, (TextView) obj);
            }
        }).l();
        this.f10239v0 = (com.tuyafeng.support.widget.f0) new b6.a(new com.tuyafeng.support.widget.f0(G()), new FrameLayout.LayoutParams(-1, -2)).p(80).V(new b6.a.InterfaceC0033a() { // from class: mark.via.download.g0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                m1.e3(this.f10190a, (com.tuyafeng.support.widget.f0) obj);
            }
        }).l();
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.download.h0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        linearLayout.addView(this.D0);
        horizontalScrollView.addView(this.f10236s0);
        linearLayout.addView(horizontalScrollView);
        this.A0.addView(this.B0);
        linearLayout.addView(this.A0);
        linearLayout.addView(this.C0);
        linearLayout.addView(this.f10239v0);
        return linearLayout;
    }

    @Override // m8.g
    public void Z2(com.tuyafeng.support.widget.e0 e0Var) {
        super.Z2(e0Var);
        v3.b(e0Var, X0(w7.u.D));
    }

    public final void f4(int i10) {
        g5.c cVar = (g5.c) this.G0.c(i10);
        if (cVar.t() == null || cVar.t().isEmpty()) {
            return;
        }
        com.tuyafeng.support.utils.n.b(G(), cVar.t(), X0(w7.u.Fg));
    }

    public final boolean g4(final g5.c cVar, boolean z10) {
        boolean zM = this.E0.m(cVar.j());
        if (zM) {
            i.y(G()).D(cVar.t());
            if (z10) {
                x8.b1.e(G(), cVar.f());
            }
            final n nVarE = n.e(G());
            this.B0.post(new Runnable() { // from class: mark.via.download.c1
                @Override // java.lang.Runnable
                public final void run() {
                    nVarE.b(cVar.j());
                }
            });
        }
        return zM;
    }

    public final void h4() {
        final RecyclerView recyclerView = this.B0;
        final DownloadTaskViewDelegate downloadTaskViewDelegate = this.I0;
        recyclerView.post(new Runnable() { // from class: mark.via.download.j0
            @Override // java.lang.Runnable
            public final void run() {
                m1.E3(this.f10222c, recyclerView, downloadTaskViewDelegate);
            }
        });
    }

    public final boolean i4(g5.c cVar, String str, int i10) {
        String strC;
        if (i10 != 0) {
            int iLastIndexOf = cVar.l().lastIndexOf(46);
            String str2 = "";
            if (iLastIndexOf > 0) {
                String lowerCase = cVar.l().substring(iLastIndexOf + 1).toLowerCase(Locale.ROOT);
                str2 = lowerCase;
                strC = l5.c.c(lowerCase, "");
            } else {
                strC = "";
            }
            if (i10 != j4(str2, strC)) {
                return false;
            }
        }
        return str == null || str.isEmpty() || cVar.l() == null || cVar.l().contains(str);
    }

    public final int j4(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 8;
        }
        if (str2.startsWith("audio/")) {
            return 1;
        }
        if (str2.startsWith("video/")) {
            return 2;
        }
        if (str2.startsWith("image/")) {
            return 7;
        }
        if (str.equals("apk") || str.equals("xapk")) {
            return 3;
        }
        if (str2.startsWith("text/")) {
            return 6;
        }
        if (!str.isEmpty()) {
            if (",mht,docx,doc,xml,xul,xls,xlsx,json,jsonld,epub,js,pdf,ppt,pptx,ts,azw,rtf,odp,ods,odt,sh,php,py,".contains("," + str + ",")) {
                return 6;
            }
        }
        if (!str.isEmpty()) {
            if (",zip,rar,gz,7z,tar,gtar,bz,bz2,xz,lzma,z,arj,cab,lzh,iso,jar,ace,tgz,".contains("," + str + ",")) {
                return 5;
            }
        }
        return 8;
    }

    public final int k4(long j10) {
        List listD = this.G0.d();
        int size = listD.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((g5.c) listD.get(i10)).j() == j10) {
                return i10;
            }
        }
        return -1;
    }

    @Override // m8.g
    public boolean l() {
        return !this.F0.c();
    }

    public final void l4() {
        this.G0.b(new e());
    }

    public final void m4(final boolean z10) {
        final String strTrim = this.D0.getText().toString().trim();
        final int i10 = this.f10235r0;
        final long j10 = this.f10238u0 + 1;
        this.f10238u0 = j10;
        ((autodispose2.m) r6.q.f(new Callable() { // from class: mark.via.download.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m1.D3(this.f10312c, i10, strTrim);
            }
        }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: mark.via.download.i0
            @Override // u6.i
            public final boolean test(Object obj) {
                return m1.K3(this.f10215c, j10, (Pair) obj);
            }
        }).p(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.download.t0
            @Override // u6.f
            public final void accept(Object obj) {
                m1.M3(this.f10294c, z10, (Pair) obj);
            }
        }, new w7.a0());
    }

    public final void q4(g5.c cVar, boolean z10) {
        int i10 = Build.VERSION.SDK_INT;
        if ((i10 >= 24 || x8.f.j(this, 0)) && cVar != null && g5.b.e(cVar.q())) {
            if (!x8.b1.p(G(), cVar.f())) {
                com.tuyafeng.support.utils.n.q(G(), w7.u.F5);
                return;
            }
            if (z10) {
                a2.r3(cVar.g(), cVar.k()).g3(x0(), null);
                return;
            }
            boolean zJ = x8.e1.j(G(), x8.e1.b(cVar));
            if (!zJ) {
                zJ = x8.e1.j(G(), Intent.createChooser(x8.e1.b(cVar), cVar.l()));
            }
            if (zJ) {
                return;
            }
            if (i10 < 21 || !"application/pdf".equals(cVar.k())) {
                com.tuyafeng.support.utils.n.q(G(), w7.u.B9);
            } else {
                FragmentUtils.j(this, za.g.class, p5.a.b().e("pdfPath", cVar.f().toString()).e("pdfName", cVar.l()).a());
            }
        }
    }

    public final void r4(int i10) {
        final g5.c cVar = (g5.c) this.G0.c(i10);
        if (g5.b.e(cVar.q())) {
            q5.k.l(G()).g0(X0(w7.u.f14062gb)).g(1, cVar.l(), cVar.l(), 1).j(1, new q5.k.n() { // from class: mark.via.download.o0
                @Override // q5.k.n
                public final void a(View view) {
                    m1.z3(view);
                }
            }).X(R.string.ok, new q5.k.m() { // from class: mark.via.download.p0
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    m1.y3(this.f10273a, cVar, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        }
    }

    public final void s4() {
        if (!this.F0.c() || this.F0.a() <= 0) {
            return;
        }
        q5.k.l(G()).f0(w7.u.f14298y).K(Y0(w7.u.f14115k8, Integer.valueOf(this.F0.a()))).y(X0(w7.u.f14073h8), false).X(R.string.ok, new q5.k.m() { // from class: mark.via.download.n0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                m1.B3(this.f10259a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void t4(final int i10) {
        final g5.c cVar = (g5.c) this.G0.c(i10);
        final boolean zE = g5.b.e(cVar.q());
        q5.k.l(G()).f0(w7.u.f14298y).J(zE ? w7.u.f14087i8 : w7.u.f14101j8).y(zE ? X0(w7.u.f14073h8) : null, false).X(R.string.ok, new q5.k.m() { // from class: mark.via.download.u0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                m1.o3(this.f10297a, zE, cVar, i10, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    @Override // j5.a
    public void u(g5.c cVar, long j10, long j11) {
        E4(cVar, true);
    }

    public final void u4(final g5.c cVar) {
        this.R0 = null;
        if (this.J0.startsWith("content://")) {
            final Uri uri = Uri.parse(this.J0);
            q5.k.l(G()).g0(X0(w7.u.tg)).K(X0(w7.u.f14241t8)).X(R.string.ok, new q5.k.m() { // from class: mark.via.download.l0
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    m1.g3(this.f10228a, cVar, uri, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23 || i10 >= 29) {
            return;
        }
        this.R0 = cVar;
        try {
            this.S0.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    public final void v4() {
        q5.k.l(G()).f0(w7.u.O).f(0, "https://", w7.u.f14305y6, 1).f(1, "", w7.u.I5, 1).X(w7.u.B, new q5.k.m() { // from class: mark.via.download.k0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                m1.A3(this.f10226a, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void w4(final int i10) {
        if (i10 < 0 || i10 >= this.G0.m()) {
            return;
        }
        final g5.c cVar = (g5.c) this.G0.c(i10);
        if (this.O0.get(Long.valueOf(cVar.j())) == null && g5.b.e(cVar.q()) && cVar.k() != null && cVar.r() <= 204800 && cVar.k().startsWith("image/")) {
            final long j10 = cVar.j();
            final int i11 = this.P0 + 1;
            this.P0 = i11;
            ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.download.v0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return m1.H3(this.f10304c, cVar);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.download.w0
                @Override // u6.f
                public final void accept(Object obj) {
                    m1.s3(this.f10307c, j10, i11, i10, (String) obj);
                }
            }, new w7.e0());
        }
    }

    public final void x4(int i10) {
        final g5.c cVar = (g5.c) this.G0.c(i10);
        q5.k.l(G()).f0(w7.u.Y).K(Y0(w7.u.f14213r8, cVar.l())).X(R.string.ok, new q5.k.m() { // from class: mark.via.download.s0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                m1.f3(this.f10291a, cVar, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void y4() {
        if (this.R0 == null) {
            return;
        }
        int i10 = t1.i(G(), this.R0, this.J0);
        if (i10 == 2) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.f14027e4);
        } else {
            if (i10 == 3) {
                return;
            }
            if (i10 == 1) {
                this.E0.b(this.R0);
            }
            k.c(G(), this.R0.j());
            this.R0 = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements l8.b.InterfaceC0093b {
        public d() {
        }

        @Override // l8.b.InterfaceC0093b
        public void a(boolean z10) {
            m1.this.D4(!z10);
        }

        @Override // l8.b.InterfaceC0093b
        public void b(boolean z10) {
        }
    }
}
