package c8;

import ab.a;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ComponentCallbacks2;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.MailTo;
import android.net.ParseException;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.SystemClock;
import android.print.PrintAttributes;
import android.print.PrintManager;
import android.provider.MediaStore;
import android.text.Html;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import c8.k6;
import c8.qa;
import com.tuyafeng.support.widget.a;
import com.tuyafeng.support.widget.z;
import e8.c0;
import e8.i;
import e8.i0;
import e8.j;
import e8.k;
import e8.k0;
import e8.l;
import e8.m;
import e8.n0;
import e8.z0;
import f6.h;
import f8.h;
import f8.l0;
import f8.q;
import f8.w;
import h6.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.CustomTab;
import mark.via.Shell;
import mark.via.common.widget.GestureTouchEvent;
import mark.via.common.widget.f;
import mark.via.common.widget.k1;
import mark.via.common.widget.m;
import mark.via.common.widget.t;
import mark.via.common.widget.t0;
import mark.via.download.e;
import mark.via.download.m;
import o5.a;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;
import ua.y;
import w5.k;
import x.k0;
import x6.n;
import y8.h;
import z5.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k6 extends Fragment implements o8.b, pa, r4.f, ComponentCallbacks2, o8.e, n0.a, k.a, l.a, c0.a, i.a, i0.a, k0.a, j.a, o8.d, o8.c {
    public mark.via.common.widget.t A0;
    public mark.via.common.widget.m B0;
    public mark.via.common.widget.f C0;
    public BroadcastReceiver D0;
    public ValueCallback E0;
    public ValueCallback F0;
    public WebChromeClient.CustomViewCallback G0;
    public long H0;
    public int I0;
    public qa J0;
    public d8.e K0;
    public o4.a L0;
    public int L1;
    public ab.a M0;
    public z0.a M1;
    public GestureDetector N0;
    public String[] N1;
    public mark.via.download.j1 O0;
    public c5.a P0;
    public n5.b Q0;
    public int U0;
    public long V1;
    public com.tuyafeng.support.widget.z W1;

    /* renamed from: f1, reason: collision with root package name */
    public String f2573f1;

    /* renamed from: h1, reason: collision with root package name */
    public j8.d f2575h1;

    /* renamed from: m0, reason: collision with root package name */
    public na f2580m0;

    /* renamed from: n0, reason: collision with root package name */
    public w9.l f2582n0;

    /* renamed from: o0, reason: collision with root package name */
    public y7 f2584o0;

    /* renamed from: p0, reason: collision with root package name */
    public FrameLayout f2586p0;

    /* renamed from: q0, reason: collision with root package name */
    public ProgressBar f2588q0;

    /* renamed from: r0, reason: collision with root package name */
    public View f2590r0;

    /* renamed from: s0, reason: collision with root package name */
    public com.tuyafeng.support.widget.v f2592s0;

    /* renamed from: s1, reason: collision with root package name */
    public ValueAnimator f2593s1;

    /* renamed from: t0, reason: collision with root package name */
    public ImageView f2594t0;

    /* renamed from: t1, reason: collision with root package name */
    public boolean f2595t1;

    /* renamed from: u0, reason: collision with root package name */
    public com.tuyafeng.support.widget.a f2596u0;

    /* renamed from: v0, reason: collision with root package name */
    public mark.via.common.widget.g0 f2598v0;

    /* renamed from: v1, reason: collision with root package name */
    public int f2599v1;

    /* renamed from: w0, reason: collision with root package name */
    public LinearLayout f2600w0;

    /* renamed from: w1, reason: collision with root package name */
    public int[] f2601w1;

    /* renamed from: x0, reason: collision with root package name */
    public mark.via.common.widget.n0 f2602x0;

    /* renamed from: x1, reason: collision with root package name */
    public GestureTouchEvent f2603x1;

    /* renamed from: y0, reason: collision with root package name */
    public LinearLayout f2604y0;

    /* renamed from: z0, reason: collision with root package name */
    public ViewGroup f2606z0;
    public final mc R0 = new mc();
    public final Map S0 = new HashMap();
    public long T0 = 0;
    public boolean V0 = false;
    public int W0 = -1;
    public int X0 = -1;
    public boolean Y0 = false;
    public boolean Z0 = false;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f2568a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    public boolean f2569b1 = false;

    /* renamed from: c1, reason: collision with root package name */
    public final ColorDrawable f2570c1 = new ColorDrawable(0);

    /* renamed from: d1, reason: collision with root package name */
    public long f2571d1 = -1;

    /* renamed from: e1, reason: collision with root package name */
    public WeakReference f2572e1 = null;

    /* renamed from: g1, reason: collision with root package name */
    public int f2574g1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    public String f2576i1 = null;

    /* renamed from: j1, reason: collision with root package name */
    public mark.via.common.widget.k1 f2577j1 = null;

    /* renamed from: k1, reason: collision with root package name */
    public boolean f2578k1 = false;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f2579l1 = false;

    /* renamed from: m1, reason: collision with root package name */
    public a.InterfaceC0102a f2581m1 = null;

    /* renamed from: n1, reason: collision with root package name */
    public boolean f2583n1 = false;

    /* renamed from: o1, reason: collision with root package name */
    public final androidx.activity.o f2585o1 = new k(true);

    /* renamed from: p1, reason: collision with root package name */
    public final j5.c f2587p1 = new n();

    /* renamed from: q1, reason: collision with root package name */
    public boolean f2589q1 = true;

    /* renamed from: r1, reason: collision with root package name */
    public float f2591r1 = 0.0f;

    /* renamed from: u1, reason: collision with root package name */
    public boolean f2597u1 = false;

    /* renamed from: y1, reason: collision with root package name */
    public boolean f2605y1 = false;

    /* renamed from: z1, reason: collision with root package name */
    public final wa.a f2607z1 = new wa.r(this);
    public final Map A1 = new HashMap();
    public int B1 = 0;
    public int C1 = 0;
    public boolean D1 = false;
    public boolean E1 = false;
    public boolean F1 = false;
    public boolean G1 = false;
    public final v5.c H1 = new f();
    public j8.q I1 = null;
    public boolean J1 = false;
    public final View.OnLongClickListener K1 = new h();
    public final androidx.activity.result.b O1 = y2(new e.f(), new androidx.activity.result.a() { // from class: c8.p1
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            k6.C4(this.f2758a, (Map) obj);
        }
    });
    public mark.via.download.e P1 = null;
    public String Q1 = null;
    public final androidx.activity.result.b R1 = z8.z1.d(this, new Runnable() { // from class: c8.a2
        @Override // java.lang.Runnable
        public final void run() {
            this.f2325e.Y8();
        }
    });
    public final androidx.activity.result.b S1 = z8.z1.d(this, new Runnable() { // from class: c8.l2
        @Override // java.lang.Runnable
        public final void run() {
            this.f2653e.Z8();
        }
    });
    public final androidx.activity.result.b T1 = y2(new x5.d(), new androidx.activity.result.a() { // from class: c8.w2
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            k6.U2(this.f2894a, (Uri) obj);
        }
    });
    public final androidx.activity.result.b U1 = z8.z1.e(this, null, null);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements GestureTouchEvent.b {
        public a() {
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public boolean a() {
            return k6.this.f2589q1;
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void b() {
            k6.this.ta();
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void c(View view, int i10) {
            if (i10 == 1) {
                ((ImageView) view).setImageDrawable(lb.b.a(k6.this.I(), x7.o.f13759r, x7.u.Sd));
            } else {
                if (i10 != 2) {
                    return;
                }
                ((ImageView) view).setImageDrawable(lb.b.a(k6.this.I(), x7.o.f13736j0, x7.u.ge));
            }
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public boolean d(View view) {
            return ((t4.b) view).l();
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void e(boolean z10) throws Resources.NotFoundException {
            k6.this.G8(z10);
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public int f(View view) {
            int i10 = 0;
            if (!k6.this.f2605y1 || (k6.this.f2583n1 && k6.this.f2578k1 && !k6.this.f2589q1)) {
                return 0;
            }
            t4.b bVar = (t4.b) view;
            boolean z10 = (bVar.canScrollHorizontally(1) || bVar.canScrollHorizontally(-1)) ? false : true;
            int i11 = (z10 && k6.this.V7()) ? 1 : 0;
            if (z10 && k6.this.W7()) {
                i10 = 2;
            }
            return i11 | i10;
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public boolean g() {
            return k6.this.f2582n0.r2() == 1;
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void h(int i10) throws Resources.NotFoundException {
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                k6.this.V8();
            } else if (k6.this.f2583n1) {
                k6.this.I9();
            } else {
                k6.this.U8();
            }
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void i(float f10) {
            k6.this.db(f10);
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void j(boolean z10) throws Resources.NotFoundException {
            k6.this.S7(z10);
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public boolean k(View view) {
            int iR2 = k6.this.f2582n0.r2();
            return (iR2 == 1 || (iR2 == 2 && k6.this.f2591r1 < 1.0f)) && k6.this.X0 == 1 && !k6.this.D1 && !k6.this.f2578k1 && k6.this.f2590r0 == null && !((t4.b) view).m();
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public int l() {
            return Math.max(k6.this.f2604y0.getHeight(), k6.this.f2600w0.getHeight());
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public float m() {
            return k6.this.f2591r1;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements m.d {
        public b() {
        }

        @Override // mark.via.common.widget.m.d
        public boolean a(ja.c cVar) {
            String strS8 = k6.this.S8();
            w.d dVarI = k6.this.B0.i(strS8);
            if (cVar == null || dVarI == null || TextUtils.isEmpty((CharSequence) dVarI.f13208b)) {
                return false;
            }
            String str = (String) dVarI.f13208b;
            z9.h hVarC = z8.v2.c(cVar.d(), cVar.a());
            String strA = k6.this.f2580m0.d1(strS8) ? hVarC.a() : hVarC.getUrl();
            r4.a aVarD = k6.this.d();
            if (aVarD != null) {
                List listA = aVarD.A();
                for (int size = listA.size() - 1; size >= 0; size--) {
                    if (str.equalsIgnoreCase(i6.g0.f6993a.g((String) listA.get(size), strA)) && aVarD.r(size)) {
                        return true;
                    }
                }
            }
            final String strH = i6.g0.f6993a.h(strA, str);
            if (strH.isEmpty()) {
                return false;
            }
            if (!i6.i0.f7006a.t(strH)) {
                w5.k.l(k6.this.I()).d0(x7.u.f13950d7).J(strH).V(R.string.copy, new k.m() { // from class: c8.l6
                    @Override // w5.k.m
                    public final void a(View view, k.p pVar) {
                        g6.n.a(k6.this.I(), strH, x7.u.og);
                    }
                }).N(R.string.cancel, null).f0();
                return false;
            }
            t8.f.a().g(hVarC.b());
            k6.this.f2580m0.m0(str);
            k6.this.y9(strH);
            return true;
        }

        @Override // mark.via.common.widget.m.d
        public void b() {
            g6.i.g(k6.this, hb.b6.class);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements f.e {
        public c() {
        }

        @Override // mark.via.common.widget.f.e
        public void a() {
            k6.this.vb();
        }

        @Override // mark.via.common.widget.f.e
        public void b(v9.f fVar) {
            k6.this.D8(fVar);
        }

        @Override // mark.via.common.widget.f.e
        public void c() {
            g6.i.g(k6.this, va.c1.class);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends wa.s {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v9.f f2611b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f2612c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, v9.f fVar, WeakReference weakReference) {
            super(context);
            this.f2611b = fVar;
            this.f2612c = weakReference;
        }

        public static /* synthetic */ void b(d dVar, v9.f fVar, String str) {
            dVar.getClass();
            if (!"0".equals(str) || k6.this.C0 == null) {
                return;
            }
            k6.this.C0.setPassDetail(fVar);
        }

        public static /* synthetic */ v9.f c(v9.f fVar) {
            v9.f fVarF = pa.r.i().f(fVar.b());
            if (fVarF == null) {
                return null;
            }
            if (fVarF.h() == null && fVarF.e() == null) {
                return null;
            }
            return fVarF;
        }

        public static /* synthetic */ void d(final d dVar, WeakReference weakReference, final v9.f fVar) {
            dVar.getClass();
            WebView webView = (WebView) weakReference.get();
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(fb.a(k6.this.I(), g6.p.m(fVar.h()), g6.p.m(fVar.e())), new ValueCallback() { // from class: c8.o6
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    k6.d.b(this.f2735a, fVar, (String) obj);
                }
            });
        }

        @Override // wa.b
        public void onSuccess() {
            final v9.f fVar = this.f2611b;
            autodispose2.m mVar = (autodispose2.m) x6.f.h(new Callable() { // from class: c8.m6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return k6.d.c(fVar);
                }
            }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(k6.this.d1()));
            final WeakReference weakReference = this.f2612c;
            mVar.a(new a7.e() { // from class: c8.n6
                @Override // a7.e
                public final void accept(Object obj) {
                    k6.d.d(this.f2693e, weakReference, (v9.f) obj);
                }
            }, new x7.g0());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class e implements t0.c {

        /* renamed from: a, reason: collision with root package name */
        public int f2614a;

        public e() {
        }

        @Override // mark.via.common.widget.t0.c
        public void a() throws Resources.NotFoundException {
            k6.this.Ga();
        }

        @Override // mark.via.common.widget.t0.c
        public void b(int i10) throws Resources.NotFoundException {
            if (i10 == 1) {
                k6 k6Var = k6.this;
                k6Var.ra(k6Var.f2582n0.v0());
                return;
            }
            if (i10 == 2) {
                k6 k6Var2 = k6.this;
                k6Var2.ra(k6Var2.f2582n0.c1());
            } else if (i10 == 4) {
                k6 k6Var3 = k6.this;
                k6Var3.ra(k6Var3.f2582n0.i2());
            } else {
                if (i10 != 8) {
                    return;
                }
                k6 k6Var4 = k6.this;
                k6Var4.ra(k6Var4.f2582n0.z2());
            }
        }

        @Override // mark.via.common.widget.t0.c
        public void c(int i10) {
            if (this.f2614a != i10) {
                this.f2614a = i10;
                mark.via.common.widget.u0.a(k6.this.f2594t0, i10, k6.this.f2582n0);
            }
        }

        @Override // mark.via.common.widget.t0.c
        public void d() throws Resources.NotFoundException {
            k6.this.ub();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
        @Override // mark.via.common.widget.t0.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int[] e(View view, int i10, int i11) throws Resources.NotFoundException {
            int[] iArr = new int[2];
            int height = ((View) view.getParent()).getHeight();
            int width = ((View) view.getParent()).getWidth();
            int dimensionPixelSize = k6.this.T0().getDimensionPixelSize(x7.n.f13688g);
            int width2 = view.getWidth();
            int height2 = view.getHeight();
            int i12 = width / 3;
            int i13 = 0;
            if (i10 >= i12) {
                if (i10 > i12 * 2) {
                    iArr[0] = (width - width2) - dimensionPixelSize;
                } else {
                    if (i11 >= ((height / 4) * 3) - dimensionPixelSize) {
                        iArr[0] = (width - width2) / 2;
                        if (i13 == 0 || i11 >= ((height / 4) * 3) - dimensionPixelSize) {
                            iArr[1] = (height - height2) - dimensionPixelSize;
                            i13 |= 80;
                        } else {
                            iArr[1] = (height - height2) / 2;
                        }
                        k6.this.f2582n0.o2(i13);
                        return iArr;
                    }
                    if (i10 < width / 2) {
                        iArr[0] = dimensionPixelSize;
                    } else {
                        iArr[0] = (width - width2) - dimensionPixelSize;
                    }
                }
                i13 = 5;
                if (i13 == 0) {
                    iArr[1] = (height - height2) - dimensionPixelSize;
                    i13 |= 80;
                }
                k6.this.f2582n0.o2(i13);
                return iArr;
            }
            iArr[0] = dimensionPixelSize;
            i13 = 3;
            if (i13 == 0) {
            }
            k6.this.f2582n0.o2(i13);
            return iArr;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f extends v5.c {
        public f() {
        }

        @Override // v5.c
        public void a(View view) throws Resources.NotFoundException {
            int id = view.getId();
            if (id == mark.via.common.widget.n0.f9702v) {
                if (k6.this.d9()) {
                    return;
                }
                if (!k6.this.f2602x0.o() || k6.this.f2582n0.v().o()) {
                    k6.this.Bb();
                    return;
                } else {
                    k6.this.B8();
                    return;
                }
            }
            if (id == mark.via.common.widget.n0.f9704x) {
                if (k6.this.f2602x0.p()) {
                    k6.this.ga();
                    return;
                } else if (k6.this.f2602x0.n()) {
                    k6.this.Gb();
                    return;
                } else {
                    k6.this.wa();
                    return;
                }
            }
            if (id == mark.via.common.widget.n0.f9705y) {
                k6.this.d9();
                k6.this.na();
                return;
            }
            if (id == mark.via.common.widget.n0.f9703w) {
                k6.this.f2580m0.u1();
                return;
            }
            if (id == mark.via.common.widget.g0.f9639p) {
                k6.this.U8();
                return;
            }
            if (id == mark.via.common.widget.g0.f9640q) {
                k6.this.V8();
                return;
            }
            if (id == mark.via.common.widget.g0.f9643t) {
                k6.this.tb();
                return;
            }
            if (id == mark.via.common.widget.g0.f9642s) {
                k6.this.ra(23);
                return;
            }
            if (id == mark.via.common.widget.g0.f9641r) {
                if (k6.this.d9()) {
                    return;
                }
                if (k6.this.L0.d() != null) {
                    k6.this.f2580m0.V0();
                    return;
                } else {
                    k6.this.f2580m0.j1(null, true);
                    return;
                }
            }
            if (id == x7.p.f13792c) {
                k6.this.ra(5);
            } else if (id == x7.p.K1) {
                k6.this.d9();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f2617a = null;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f2618b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f2619c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f2620d;

        public g(TextView textView, boolean z10, String str) {
            this.f2618b = textView;
            this.f2619c = z10;
            this.f2620d = str;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            int i11 = (i10 * 5) + 50;
            this.f2618b.setText(String.format(Locale.ROOT, "%d%%", Integer.valueOf(i11)));
            WeakReference weakReference = this.f2617a;
            WebView webView = weakReference != null ? (WebView) weakReference.get() : null;
            if (webView != null) {
                webView.getSettings().setTextZoom(i11);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            t4.b bVarO8 = k6.this.O8();
            if (bVarO8 == null || i6.i0.f7006a.l(bVarO8.getUrl())) {
                this.f2617a = null;
            } else {
                this.f2617a = new WeakReference(bVarO8);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int progress = (seekBar.getProgress() * 5) + 50;
            if (this.f2619c) {
                k6.this.f2580m0.Q1(this.f2620d, progress);
            } else {
                k6.this.f2582n0.J(progress);
            }
            w9.n.e().y(true);
            k6.this.f2580m0.m1(false);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class h implements View.OnLongClickListener {
        public h() {
        }

        public static /* synthetic */ void a(h hVar, View view) throws Resources.NotFoundException {
            k6.this.d9();
            k6 k6Var = k6.this;
            k6Var.oa(g6.n.d(k6Var.I()));
        }

        public static /* synthetic */ void b(h hVar, List list, int i10, AdapterView adapterView, View view, int i11, long j10) {
            hVar.getClass();
            ja.c cVar = (ja.c) list.get(i11);
            if (cVar.d() == i10) {
                return;
            }
            if (z8.v2.g(cVar.d())) {
                k6.this.f2582n0.o1(cVar.a());
            }
            k6.this.f2582n0.q(cVar.d());
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) throws Resources.NotFoundException {
            int id = view.getId();
            if (id == mark.via.common.widget.g0.f9643t) {
                k6 k6Var = k6.this;
                k6Var.ra(k6Var.f2582n0.w1());
            } else if (id == mark.via.common.widget.g0.f9642s) {
                k6 k6Var2 = k6.this;
                k6Var2.ra(k6Var2.f2582n0.h0());
            } else if (id == mark.via.common.widget.g0.f9641r) {
                k6 k6Var3 = k6.this;
                k6Var3.ra(k6Var3.f2582n0.E());
            } else if (id == mark.via.common.widget.g0.f9640q) {
                k6 k6Var4 = k6.this;
                k6Var4.ra(k6Var4.f2582n0.c2());
            } else if (id == mark.via.common.widget.g0.f9639p) {
                k6 k6Var5 = k6.this;
                k6Var5.ra(k6Var5.f2582n0.k0());
            } else if (id == mark.via.common.widget.n0.f9703w) {
                k6.this.d9();
                k6.this.f2580m0.t1();
            } else {
                int i10 = 0;
                if (id == mark.via.common.widget.n0.f9705y) {
                    final String strS8 = k6.this.S8();
                    if (!TextUtils.isEmpty(strS8) && !u9.d.m(k6.this.I(), strS8)) {
                        i10 = 1;
                    }
                    z5.a aVarE = z5.a.e(k6.this.I());
                    if (i10 != 0) {
                        aVarE.a(new a.c(k6.this.Z0(R.string.copy), new View.OnClickListener() { // from class: c8.p6
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                g6.n.a(k6.this.I(), strS8, x7.u.pg);
                            }
                        }));
                    }
                    aVarE.a(new a.c(k6.this.Z0(R.string.paste), new View.OnClickListener() { // from class: c8.q6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) throws Resources.NotFoundException {
                            k6.h.a(this.f2782a, view2);
                        }
                    })).a(new a.c(k6.this.Z0(x7.u.f14093na), new View.OnClickListener() { // from class: c8.r6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) throws Resources.NotFoundException {
                            k6.this.sa();
                        }
                    })).f(k6.this.f2602x0);
                } else if (id == mark.via.common.widget.n0.f9702v) {
                    final List listE = z8.v2.e(k6.this.I());
                    int size = listE.size();
                    String[] strArr = new String[size];
                    final int iM1 = k6.this.f2582n0.M1();
                    int i11 = -1;
                    while (i10 < size) {
                        strArr[i10] = ((ja.c) listE.get(i10)).g();
                        if (((ja.c) listE.get(i10)).d() == iM1) {
                            i11 = i10;
                        }
                        i10++;
                    }
                    w5.k.l(k6.this.I()).d0(x7.u.Kb).b0(strArr, i11, new AdapterView.OnItemClickListener() { // from class: c8.s6
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                            k6.h.b(this.f2826a, listE, iM1, adapterView, view2, i12, j10);
                        }
                    }).f0();
                }
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class i implements w.b {
        public i() {
        }

        @Override // f8.w.b
        public void a() throws Resources.NotFoundException {
            k6.this.d9();
            k6.this.Ub();
        }

        @Override // f8.w.b
        public void b() throws Resources.NotFoundException {
            k6.this.d9();
            k6.this.Ab();
        }

        @Override // f8.w.b
        public void c() throws Resources.NotFoundException {
            k6.this.d9();
            k6 k6Var = k6.this;
            k6Var.yb(k6Var.S8());
        }

        @Override // f8.w.b
        public void d() throws Resources.NotFoundException {
            k6.this.d9();
            k6 k6Var = k6.this;
            k6Var.jb(k6Var.S8());
        }

        @Override // f8.w.b
        public void e() throws Resources.NotFoundException {
            k6.this.d9();
            k6 k6Var = k6.this;
            k6Var.wb(k6Var.S8());
        }

        @Override // f8.w.b
        public void f() throws Resources.NotFoundException {
            k6.this.d9();
            k6.this.y8();
        }

        @Override // f8.w.b
        public void g() {
            k6.this.T7();
        }

        @Override // f8.w.b
        public void h() throws Resources.NotFoundException {
            k6.this.d9();
            k6.this.la();
        }

        @Override // f8.w.b
        public void i(boolean z10) throws Resources.NotFoundException {
            k6.this.d9();
            if (z10) {
                k6.this.B8();
            } else {
                k6.this.m8();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class j implements q.b {
        public j() {
        }

        @Override // f8.q.b
        public void a() {
            i6.b.f6981a.f(k6.this.T8());
        }

        @Override // f8.q.b
        public void b() {
            i6.b.f6981a.e(k6.this.T8());
        }

        @Override // f8.q.b
        public void c() throws Resources.NotFoundException {
            i6.b.f6981a.a(k6.this.T8());
            k6.this.d9();
            k6.this.f2574g1 = 0;
        }

        @Override // f8.q.b
        public void d() {
            i6.b.f6981a.b(k6.this.T8());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class k extends androidx.activity.o {
        public k(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.o
        public void d() throws Resources.NotFoundException {
            k6.this.I9();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class l implements h.b {
        public l() {
        }

        @Override // f8.h.b
        public void a(boolean z10) {
            k6.this.E8(z10);
        }

        @Override // f8.h.b
        public void b(boolean z10) throws Resources.NotFoundException {
            k6.this.F8("");
            if (z10) {
                k6.this.d9();
                z8.f.e(k6.this.f2584o0);
            }
        }

        @Override // f8.h.b
        public void c(String str) {
            k6.this.F8(str);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class m implements l0.b {
        public m() {
        }

        @Override // f8.l0.b
        public void a(int i10) throws Resources.NotFoundException {
            if (i10 < 0 || i10 >= k6.this.i()) {
                return;
            }
            k6.this.d9();
            k6 k6Var = k6.this;
            k6Var.s8((r4.a) k6Var.c().get(i10));
        }

        @Override // f8.l0.b
        public void b(int i10, int i11) throws Resources.NotFoundException {
            if (i11 == 4 || ((i11 == 1 && i10 != k6.this.k()) || ((i11 == 2 && k6.this.k() > i10) || (i11 == 3 && k6.this.k() < i10)))) {
                k6.this.d9();
            }
            k6.this.j8(i10, i11);
        }

        @Override // f8.l0.b
        public void c(r4.f fVar) {
            k6.this.L0.r(fVar);
        }

        @Override // f8.l0.b
        public void d() {
            k6.this.f2580m0.j1(null, true);
        }

        @Override // f8.l0.b
        public void e(int i10) {
            k6.this.f2580m0.C0(i10);
        }

        @Override // f8.l0.b
        public void f() throws Resources.NotFoundException {
            k6.this.d9();
            k6.this.ia();
        }

        @Override // f8.l0.b
        public void g(r4.f fVar) {
            k6.this.L0.o(fVar);
        }

        @Override // f8.l0.b
        public boolean h(int i10, int i11) {
            return k6.this.L0.p(i10, i11);
        }

        @Override // f8.l0.b
        public void i(int i10) throws Resources.NotFoundException {
            k6.this.f2580m0.X1(i10);
            k6.this.d9();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class n implements j5.c {
        public n() {
        }

        public static /* synthetic */ void a(n nVar, g5.c cVar, String str, h.a aVar, Boolean bool) {
            nVar.getClass();
            if (bool.booleanValue()) {
                y8.h.w(k6.this.l0(), aVar, cVar.f());
            } else {
                y8.h.s(k6.this.I(), cVar);
                g6.n.s(k6.this.I(), k6.this.a1(x7.u.f14208w5, str));
            }
        }

        public static /* synthetic */ void c(n nVar, g5.c cVar, View view) {
            nVar.getClass();
            z8.f1.j(k6.this.I(), z8.f1.b(cVar));
        }

        @Override // j5.c
        public void J(final g5.c cVar, int i10, int i11) {
            if (k6.this.q1()) {
                boolean zE = g5.b.e(i11);
                if (g5.b.a(i11)) {
                    final String strQ = g6.p.q(cVar.l(), 24);
                    String strK = cVar.k();
                    boolean zEquals = "application/vnd.android.package-archive".equals(cVar.k());
                    if (zE && zEquals) {
                        final h.a aVarP = y8.h.p(k6.this.I(), cVar);
                        if (aVarP != null) {
                            ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.t6
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    return Boolean.valueOf(y8.h.y(k6.this.I(), cVar, aVarP));
                                }
                            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(k6.this.d1()))).a(new a7.e() { // from class: c8.u6
                                @Override // a7.e
                                public final void accept(Object obj) {
                                    k6.n.a(this.f2863e, cVar, strQ, aVarP, (Boolean) obj);
                                }
                            }, new x7.g0());
                            return;
                        } else {
                            g6.n.t(k6.this.I(), k6.this.a1(x7.u.f14195v5, strQ), k6.this.Z0(x7.u.f13936c7), new View.OnClickListener() { // from class: c8.v6
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    k6.n.c(this.f2883a, cVar, view);
                                }
                            });
                            return;
                        }
                    }
                    if (zE && strK != null && strK.startsWith("image/")) {
                        mark.via.download.i1.f(k6.this.I(), cVar.f());
                    }
                    g6.n.t(k6.this.I(), zE ? k6.this.a1(x7.u.f14195v5, strQ) : k6.this.a1(x7.u.f14208w5, strQ), k6.this.Z0(x7.u.Jh), new View.OnClickListener() { // from class: c8.w6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            k6.this.ca();
                        }
                    });
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class o extends BroadcastReceiver {
        public o() {
        }

        public static /* synthetic */ void a(o oVar, String str) throws NumberFormatException {
            oVar.getClass();
            int i10 = 0;
            if (str.length() > 1 && str.charAt(0) == str.charAt(str.length() - 1) && str.charAt(0) == '\"') {
                str = str.substring(1, str.length() - 1);
            }
            try {
                i10 = Integer.parseInt(str);
            } catch (Exception e10) {
                pc.a.b(e10);
            }
            z8.g2.f(k6.this.A0(), i10);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            t4.b bVarO8 = k6.this.O8();
            if (bVarO8 == null) {
                return;
            }
            if ("mark.via.MEDIA_PLAY".equals(action)) {
                String strD = nc.d(bVarO8.getContext());
                if (strD != null) {
                    bVarO8.evaluateJavascript(strD, new ValueCallback() { // from class: c8.x6
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(Object obj) throws NumberFormatException {
                            k6.o.a(this.f2915a, (String) obj);
                        }
                    });
                    return;
                }
                return;
            }
            if ("mark.via.MEDIA_REWIND".equals(action) || "mark.via.MEDIA_FASTFORWARD".equals(action)) {
                s4.b.g(bVarO8, nc.c(bVarO8.getContext(), "mark.via.MEDIA_REWIND".equals(action) ? -15 : 15));
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class p extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f2630a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f2631b;

        public p(ValueAnimator valueAnimator, boolean z10) {
            this.f2630a = valueAnimator;
            this.f2631b = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
            if (k6.this.f2593s1 == this.f2630a) {
                k6.this.f2593s1 = null;
                k6.this.G8(this.f2631b);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class q extends GestureDetector.SimpleOnGestureListener {
        public q() {
        }

        public static /* synthetic */ void a(q qVar, MotionEvent motionEvent, String str, String str2, String str3) {
            qVar.getClass();
            k6.this.z9((int) motionEvent.getRawX(), (int) motionEvent.getRawY(), z8.w2.f(str), str2, str3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(final MotionEvent motionEvent) {
            if (k6.this.J0 == null) {
                k6.this.J0 = new qa();
                k6.this.J0.a(new qa.a() { // from class: c8.y6
                    @Override // c8.qa.a
                    public final void a(String str, String str2, String str3) {
                        k6.q.a(this.f2931a, motionEvent, str, str2, str3);
                    }
                });
            }
            Message messageObtainMessage = k6.this.J0.obtainMessage();
            messageObtainMessage.setTarget(k6.this.J0);
            t4.b bVarO8 = k6.this.O8();
            if (bVarO8 != null) {
                bVarO8.requestFocusNodeHref(messageObtainMessage);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class r extends p4.a {
        public r() {
        }

        public static /* synthetic */ void G(r rVar, int i10, String str, View view) {
            r4.a aVarD = k6.this.d();
            if (aVarD == null || aVarD.getId() != i10) {
                return;
            }
            aVarD.v(str);
        }

        @Override // p4.a
        public int E(t4.b bVar, final String str, boolean z10, boolean z11) {
            if (k6.this.v9()) {
                return 3;
            }
            String url = bVar.getUrl();
            i6.i0 i0Var = i6.i0.f7006a;
            if (!i0Var.s(url) || !i0Var.s(str) || k6.this.f2580m0.c1(url)) {
                return super.E(bVar, str, z10, z11);
            }
            String strB = i0Var.b(url);
            String strB2 = i0Var.b(str);
            if (!strB.isEmpty() && strB2.equalsIgnoreCase(strB)) {
                return super.E(bVar, str, z10, z11);
            }
            if (k6.this.q1() && !z11) {
                final int id = k6.this.d() != null ? k6.this.d().getId() : -1;
                g6.n.t(k6.this.l0(), strB2.isEmpty() ? k6.this.Z0(x7.u.V0) : k6.this.a1(x7.u.W0, strB2), k6.this.Z0(x7.u.X0), new View.OnClickListener() { // from class: c8.z6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        k6.r.G(this.f2963a, id, str, view);
                    }
                });
            }
            return 3;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class s implements a.InterfaceC0102a {
        public s() {
        }

        public static /* synthetic */ void d(s sVar, int i10, String str, boolean z10) {
            if (i10 < 0 || i10 > k6.this.i()) {
                i10 = k6.this.k() + 1;
            }
            k6.this.f2580m0.g1(str, z10, i10);
        }

        @Override // o5.a.InterfaceC0102a
        public void a(String str, String str2) {
            if (str2 == null || str2.startsWith("text/") || "text".equalsIgnoreCase(str2)) {
                g6.n.b(k6.this.I(), str, null);
            }
        }

        @Override // o5.a.InterfaceC0102a
        public void b(String str, String str2) {
            int iLastIndexOf;
            k6.this.mb(new e.b().k(k6.this.f2582n0.L1()).c("attachment").g((str2 == null || str2.isEmpty() || (iLastIndexOf = str2.lastIndexOf(46)) < 0) ? null : l5.c.c(str2.substring(iLastIndexOf + 1), "application/octet-stream")).d(0L).j(str).e(str2).f(g6.p.f(str2)).b());
        }

        @Override // o5.a.InterfaceC0102a
        public void c(final String str, final boolean z10, final int i10) {
            if (str == null || str.isEmpty()) {
                return;
            }
            z8.h.c(k6.this.l0(), new Runnable() { // from class: c8.a7
                @Override // java.lang.Runnable
                public final void run() {
                    k6.s.d(this.f2334e, i10, str, z10);
                }
            });
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class t implements m.a {
        public t() {
        }

        @Override // e8.m.a
        public void a(HttpAuthHandler httpAuthHandler, String str, String str2) {
            k6.this.rb(httpAuthHandler, str, str2);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class u implements e8.z0 {
        public u() {
        }

        @Override // e8.z0
        public void a(String str, String[] strArr, z0.a aVar) {
            k6.this.Ca(str, strArr, aVar);
        }

        @Override // e8.z0
        public Context b() {
            return k6.this.A0();
        }

        @Override // e8.z0
        public void c(String[] strArr, z0.a aVar) {
            k6.this.Ba(strArr, aVar);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class v implements d8.e {
        public v() {
        }

        public /* synthetic */ v(k6 k6Var, k kVar) {
            this();
        }

        public static /* synthetic */ void c(v vVar, JSONObject jSONObject) {
            f8.q qVar = (f8.q) k6.this.z0().n0(f8.q.f6015u0);
            if (qVar != null) {
                qVar.f3(jSONObject.optString("filter"));
            }
        }

        public static /* synthetic */ void d(v vVar, String str, String str2, String str3) {
            if (k6.this.R0.c(str) == 0) {
                k6.this.mb(new e.b().j(str2).e(str3).b());
            } else {
                k6 k6Var = k6.this;
                k6Var.r8(str, str2, k6Var.R0.c(str));
            }
        }

        public static /* synthetic */ void o(v vVar, String str, String str2, View view, k.p pVar) throws Resources.NotFoundException {
            k6.this.f2580m0.h0(str, str2);
            k6.this.d9();
            r4.a aVarN = k6.this.L0.n(k6.this.f2574g1);
            if (aVarN != null) {
                i6.b.f6981a.c(new i6.e(aVarN.p()), str2);
            }
        }

        @JavascriptInterface
        public void addon(String str) {
            k6.this.t9(str);
        }

        @JavascriptInterface
        public int cmd(int i10) {
            if (i10 == 257) {
                w6.b.b().c().b(new Runnable() { // from class: c8.p7
                    @Override // java.lang.Runnable
                    public final void run() {
                        k6.this.ja(true);
                    }
                });
            } else if (i10 == 514) {
                n.b bVarC = w6.b.b().c();
                final k6 k6Var = k6.this;
                bVarC.b(new Runnable() { // from class: c8.c7
                    @Override // java.lang.Runnable
                    public final void run() {
                        k6Var.na();
                    }
                });
            } else {
                if (i10 == 515) {
                    return (k6.this.f2589q1 || k6.this.f2597u1) ? 1 : 0;
                }
                if (i10 == 516) {
                    w6.b.b().c().b(new Runnable() { // from class: c8.d7
                        @Override // java.lang.Runnable
                        public final void run() {
                            k6.this.ua();
                        }
                    });
                } else if (i10 == 517) {
                    n.b bVarC2 = w6.b.b().c();
                    final k6 k6Var2 = k6.this;
                    bVarC2.b(new Runnable() { // from class: c8.e7
                        @Override // java.lang.Runnable
                        public final void run() {
                            k6Var2.C9();
                        }
                    });
                }
            }
            return 0;
        }

        @JavascriptInterface
        public void download(String str, final String str2, final String str3) {
            if (k6.this.u9(str)) {
                return;
            }
            Bundle bundleC = v5.b.d().c("dl");
            final String string = bundleC != null ? bundleC.getString(str2, null) : null;
            w6.b.b().c().b(new Runnable() { // from class: c8.f7
                @Override // java.lang.Runnable
                public final void run() {
                    k6.v.d(this.f2446e, str2, str3, string);
                }
            });
        }

        @JavascriptInterface
        public String getInstalledAddonID() {
            List<r5.c> listO = k6.this.Q0.d().o();
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (r5.c cVar : listO) {
                if (cVar.c() != null && cVar.c().startsWith("https://app.viayoo.com/addons/")) {
                    String strSubstring = cVar.c().substring(30);
                    if (TextUtils.isDigitsOnly(strSubstring)) {
                        sb2.append(',');
                        sb2.append(strSubstring);
                    }
                }
            }
            if (sb2.length() > 1) {
                sb2.deleteCharAt(1);
            }
            sb2.append(']');
            return sb2.toString();
        }

        @JavascriptInterface
        public void postMessage(String str, String str2) {
            if (k6.this.u9(str) || str2 == null || str2.length() < 2) {
                return;
            }
            try {
                final JSONObject jSONObject = new JSONObject(str2);
                int iOptInt = jSONObject.optInt("action", 0);
                if (iOptInt == 0) {
                    return;
                }
                pc.a.a("post message, action: %d, json: %s", Integer.valueOf(iOptInt), Integer.valueOf(str2.length()));
                switch (iOptInt) {
                    case 101:
                        final int iOptInt2 = jSONObject.optInt("runAt", 0);
                        final int iOptInt3 = jSONObject.optInt("from", 0);
                        if (iOptInt3 == 0 || iOptInt2 == 0) {
                            return;
                        }
                        z8.h.c(k6.this.l0(), new Runnable() { // from class: c8.b7
                            @Override // java.lang.Runnable
                            public final void run() {
                                k6.v vVar = this.f2353e;
                                k6.this.Ja(k6.this.L0.q(iOptInt3), iOptInt2);
                            }
                        });
                        return;
                    case 102:
                        z8.h.c(k6.this.l0(), new Runnable() { // from class: c8.h7
                            @Override // java.lang.Runnable
                            public final void run() {
                                k6.v.c(this.f2485e, jSONObject);
                            }
                        });
                        return;
                    case 103:
                        final String strOptString = jSONObject.optString("host");
                        final String strOptString2 = jSONObject.optString("filter");
                        if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                            z8.h.c(k6.this.l0(), new Runnable() { // from class: c8.i7
                                @Override // java.lang.Runnable
                                public final void run() {
                                    k6.v vVar = this.f2498e;
                                    String str3 = strOptString2;
                                    w5.k.l(k6.this.I()).d0(x7.u.L).J(k6.this.I().getResources().getString(x7.u.f14180u3) + "(" + str3 + ")").V(R.string.ok, new k.m() { // from class: c8.g7
                                        @Override // w5.k.m
                                        public final void a(View view, k.p pVar) throws Resources.NotFoundException {
                                            k6.v.o(this.f2465a, str, str3, view, pVar);
                                        }
                                    }).N(R.string.cancel, null).f0();
                                }
                            });
                            return;
                        }
                        return;
                    case 104:
                        String strOptString3 = jSONObject.optString("url");
                        String strOptString4 = jSONObject.optString("name");
                        if (!strOptString3.isEmpty() && !strOptString4.isEmpty()) {
                            v5.b.a().e("dl").f(60).d(strOptString3, strOptString4).a();
                            return;
                        }
                        return;
                    case 105:
                        final String strOptString5 = jSONObject.optString("text");
                        if (strOptString5.isEmpty()) {
                            return;
                        }
                        z8.h.d(k6.this, new Runnable() { // from class: c8.j7
                            @Override // java.lang.Runnable
                            public final void run() throws Resources.NotFoundException {
                                k6.this.Ra(strOptString5);
                            }
                        });
                        return;
                    case 106:
                        final String strOptString6 = jSONObject.optString("text");
                        z8.h.d(k6.this, new Runnable() { // from class: c8.k7
                            @Override // java.lang.Runnable
                            public final void run() {
                                k6.this.f2580m0.C1(strOptString6);
                            }
                        });
                        return;
                    case 107:
                        final String strOptString7 = jSONObject.optString("url");
                        if (!strOptString7.isEmpty()) {
                            w6.b.b().c().b(new Runnable() { // from class: c8.l7
                                @Override // java.lang.Runnable
                                public final void run() {
                                    k6.this.mb(new e.b().j(strOptString7).b());
                                }
                            });
                            break;
                        } else {
                            return;
                        }
                    case 108:
                        break;
                    case 109:
                        final boolean z10 = jSONObject.optInt("show", 0) > 0;
                        w6.b.b().c().b(new Runnable() { // from class: c8.n7
                            @Override // java.lang.Runnable
                            public final void run() {
                                k6.this.Qb(z10);
                            }
                        });
                        return;
                    case 110:
                        final String strOptString8 = jSONObject.optString("user");
                        final String strOptString9 = jSONObject.optString("pass");
                        final String strOptString10 = jSONObject.optString("url");
                        w6.b.b().c().b(new Runnable() { // from class: c8.o7
                            @Override // java.lang.Runnable
                            public final void run() {
                                k6.this.c8(strOptString10, strOptString8, strOptString9);
                            }
                        });
                        return;
                    default:
                        return;
                }
                w6.b.b().c().b(new Runnable() { // from class: c8.m7
                    @Override // java.lang.Runnable
                    public final void run() {
                        k6.this.Db(false);
                    }
                });
            } catch (Exception e10) {
                pc.a.i(e10);
            }
        }

        @JavascriptInterface
        public void record(String str, String str2) {
            if (str == null || str.isEmpty() || str.startsWith("file://")) {
                return;
            }
            k6.this.f2580m0.h0(str, str2);
        }

        @JavascriptInterface
        public void toast(String str) {
            g6.n.s(k6.this.I(), str);
        }
    }

    public static /* synthetic */ void A3(k6 k6Var, String str, Bundle bundle) {
        v9.f fVarH;
        k6Var.getClass();
        String string = bundle.getString(Name.MARK);
        if (string != null && (fVarH = pa.r.i().h(string)) != null) {
            k6Var.D8(fVarH);
        }
        k6Var.z0().x("passresult");
    }

    public static /* synthetic */ void A5(k6 k6Var) {
        k6Var.getClass();
        new ib().g(k6Var.f2592s0).b(k6Var.O8()).e(k6Var.L1).c(!k6Var.f2578k1 && k6Var.f2582n0.E1()).f(!k6Var.f2578k1).d();
    }

    public static /* synthetic */ x5.a B3(g5.c cVar, File file, m5.j jVar) {
        if (jVar.b()) {
            cVar.P(100);
            return x5.a.f(file);
        }
        cVar.P(200);
        if (jVar.a() != null) {
            cVar.A(jVar.a().c());
            cVar.B(jVar.a().d());
            mark.via.download.i1.e(cVar);
            file.delete();
        }
        return x5.a.f(null);
    }

    public static /* synthetic */ void B5(k6 k6Var, ValueAnimator valueAnimator) {
        k6Var.getClass();
        k6Var.db(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void C4(k6 k6Var, Map map) {
        z0.a aVar = k6Var.M1;
        if (aVar == null) {
            k6Var.N1 = null;
            return;
        }
        if (map == null) {
            aVar.a(k6Var.N1, false);
            k6Var.M1 = null;
            k6Var.N1 = null;
            return;
        }
        HashSet hashSet = new HashSet();
        String[] strArr = k6Var.N1;
        if (strArr != null) {
            for (String str : strArr) {
                if (map.get(str) != Boolean.FALSE) {
                    hashSet.add(str);
                }
            }
        }
        k6Var.M1.a((String[]) hashSet.toArray(new String[0]), false);
        k6Var.M1 = null;
        k6Var.N1 = null;
        if (hashSet.isEmpty()) {
            z8.z1.f(k6Var.l0());
        }
    }

    public static /* synthetic */ void D4(k6 k6Var, View view, k.p pVar) {
        k6Var.getClass();
        if (pVar.f13338b) {
            w9.a aVarV = k6Var.f2582n0.v();
            aVarV.C(false);
            k6Var.f2582n0.q0(aVarV);
        }
        k6Var.l0().finish();
    }

    public static /* synthetic */ void D5(k6 k6Var, String str, Bundle bundle) {
        k6Var.f2580m0.w1();
        k6Var.N0().x("favoriteChanged");
    }

    public static /* synthetic */ void E3(k6 k6Var, int i10) {
        k6Var.getClass();
        pc.a.a("on action: %d", Integer.valueOf(i10));
        if (i10 == 1) {
            j8.e.b(k6Var.I(), k6Var.f2576i1);
            return;
        }
        if (i10 == 2) {
            j8.e.a(k6Var.I(), k6Var.f2576i1);
            return;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                return;
            }
            k6Var.ha();
        } else {
            j8.e.d(k6Var.I());
            k6Var.f2576i1 = null;
            k6Var.xb(null, false);
        }
    }

    public static /* synthetic */ void F3(k6 k6Var, String[] strArr, AdapterView adapterView, View view, int i10, long j10) {
        k6Var.getClass();
        k6Var.U7(strArr[i10], k6Var.Q8());
    }

    public static /* synthetic */ void F4(k6 k6Var, Boolean bool) {
        k6Var.getClass();
        if (bool.booleanValue()) {
            g6.n.q(k6Var.l0(), x7.u.f14051ka);
        }
    }

    public static /* synthetic */ j7.f G3(final k6 k6Var, final String str, final String str2, final String str3, final int i10, String str4) {
        k6Var.getClass();
        final List listA = j8.u.a(str4);
        if (listA.isEmpty()) {
            g6.n.q(k6Var.I(), x7.u.L1);
            return null;
        }
        z8.h.c(k6Var.l0(), new Runnable() { // from class: c8.l5
            @Override // java.lang.Runnable
            public final void run() {
                k6.p3(this.f2656e, str, str2, str3, listA, i10);
            }
        });
        return null;
    }

    public static /* synthetic */ void G5(k6 k6Var, String str, Bundle bundle) throws Resources.NotFoundException, NumberFormatException {
        k6Var.getClass();
        String string = bundle.getString("input", null);
        if (!TextUtils.isEmpty(string)) {
            if (bundle.getInt("input_action", 0) == 2) {
                k6Var.Sa(bundle.getString("input_query", string), bundle.getInt("input_engine"));
            } else if (string.startsWith("VIA-SWITCH-TAB:")) {
                try {
                    int i10 = Integer.parseInt(string.substring(15));
                    na naVar = k6Var.f2580m0;
                    naVar.X1(naVar.F0(i10));
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } else {
                k6Var.Ra(string);
            }
        }
        k6Var.N0().x("input");
    }

    private void H8() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        x.r.d0(this.f2606z0, new x.m() { // from class: c8.u4
            @Override // x.m
            public final x.k0 a(View view, x.k0 k0Var) {
                return k6.V5(this.f2861a, view, k0Var);
            }
        });
    }

    public static /* synthetic */ void I4(final k6 k6Var, final String str, String str2, final String str3, x5.a aVar) {
        k6Var.getClass();
        if (!aVar.d()) {
            k6Var.R7(str, str2, str3);
        } else {
            if (str3.equals(((v9.f) aVar.b()).e())) {
                return;
            }
            final v9.f fVar = (v9.f) aVar.b();
            w5.k.l(k6Var.I()).d0(x7.u.fh).J(k6Var.a1(x7.u.gh, i6.i0.f7006a.e(str))).V(R.string.ok, new k.m() { // from class: c8.c2
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    k6.X2(this.f2366a, fVar, str3, str, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
        }
    }

    public static /* synthetic */ List J3(k6 k6Var) {
        int[] iArrP = g6.p.p(g6.p.m(k6Var.f2582n0.C()), ',');
        int iM1 = k6Var.f2582n0.M1();
        List listE = z8.v2.e(k6Var.I());
        for (int size = listE.size() - 1; size >= 0; size--) {
            int iD = ((ja.c) listE.get(size)).d();
            if (iM1 != iD && g6.a.b(iArrP, iD)) {
                listE.remove(size);
            }
        }
        return listE;
    }

    public static /* synthetic */ void J4(final k6 k6Var, final WeakReference weakReference) {
        k6Var.getClass();
        if (((t4.b) weakReference.get()) == null) {
            return;
        }
        k6Var.d8(new k8.o() { // from class: c8.r4
            @Override // k8.o
            public final void a(Object obj) {
                k6.h3(this.f2801a, weakReference, (Integer) obj);
            }
        });
    }

    public static /* synthetic */ void J5(k6 k6Var, Throwable th) {
        k6Var.getClass();
        pc.a.d(th);
        g6.n.g(k6Var.I(), "Download error", th.toString(), null);
    }

    public static /* synthetic */ void K3(k6 k6Var, String str, Bundle bundle) throws Resources.NotFoundException {
        k6Var.getClass();
        List<l8.a> listA = l8.b.a(bundle);
        if (listA != null && !listA.isEmpty()) {
            for (l8.a aVar : listA) {
                int iB = aVar.b();
                if (iB == 1) {
                    k6Var.f2580m0.j1(aVar.a(), true);
                } else if (iB == 2) {
                    k6Var.f2580m0.j1(aVar.a(), false);
                } else if (iB != 3) {
                    k6Var.Ra(aVar.a());
                } else {
                    k6Var.g(new r4.b(aVar.a()), k6Var.f2580m0.S0(), false);
                }
            }
        }
        k6Var.N0().x("result");
    }

    public static /* synthetic */ void K5(k6 k6Var, Activity activity) {
        c5.a aVar;
        k6Var.getClass();
        int iB = z8.b0.B(activity);
        pc.a.a("on network changed, current: %d", Integer.valueOf(iB));
        if (iB != 0 && (aVar = k6Var.P0) != null && aVar.i()) {
            mark.via.download.a.d(activity);
        }
        boolean z10 = 2 != iB;
        if (z10 != k6Var.f2582n0.m2().x()) {
            k6Var.f2582n0.m2().a0(z10);
            k6Var.f2580m0.l1();
        }
    }

    public static /* synthetic */ void L3(final k6 k6Var) {
        final androidx.fragment.app.q qVarU0 = k6Var.u0();
        if (qVarU0 == null) {
            return;
        }
        qVarU0.runOnUiThread(new Runnable() { // from class: c8.f0
            @Override // java.lang.Runnable
            public final void run() {
                k6.K5(this.f2431e, qVarU0);
            }
        });
    }

    public static /* synthetic */ void L4(k6 k6Var, w.d dVar, View view) {
        k6Var.getClass();
        try {
            k6Var.P2(z8.f1.i(k6Var.I(), (Uri) dVar.f13207a, (String) dVar.f13208b));
        } catch (Exception e10) {
            pc.a.i(e10);
            g6.n.q(k6Var.I(), x7.u.xg);
        }
    }

    public static /* synthetic */ void M3(final k6 k6Var, x5.a aVar) {
        k6Var.getClass();
        if (!aVar.d()) {
            g6.n.q(k6Var.I(), x7.u.xg);
        } else {
            final w.d dVar = (w.d) aVar.b();
            g6.n.r(k6Var.I(), x7.u.f14222x6, x7.u.Jh, new View.OnClickListener() { // from class: c8.o0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k6.L4(this.f2723a, dVar, view);
                }
            });
        }
    }

    public static /* synthetic */ void M5(k6 k6Var, String str, int i10, x5.a aVar) {
        k6Var.getClass();
        if (!aVar.d()) {
            g6.n.q(k6Var.I(), x7.u.R3);
            return;
        }
        File file = (File) aVar.b();
        if (str != null) {
            k6Var.S0.put(str, file.getAbsolutePath());
        }
        k6Var.X8(str, file, i10);
    }

    public static /* synthetic */ void N3(final k6 k6Var, final String str) {
        if (str != null) {
            k6Var.getClass();
            if (!str.isEmpty()) {
                w5.k.l(k6Var.I()).d0(x7.u.Ea).J(str).N(R.string.cancel, null).R(R.string.copy, new View.OnClickListener() { // from class: c8.e2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g6.n.a(this.f2417a.I(), str, x7.u.og);
                    }
                }).V(i6.i0.f7006a.t(str) ? x7.u.R : x7.u.Tb, new k.m() { // from class: c8.f2
                    @Override // w5.k.m
                    public final void a(View view, k.p pVar) {
                        k6.f5(this.f2434a, str, view, pVar);
                    }
                }).f0();
                return;
            }
        }
        g6.n.q(k6Var.I(), x7.u.Da);
    }

    public static /* synthetic */ void N5(k6 k6Var, String str, String str2, View view) {
        k6Var.getClass();
        if (z8.b0.p(str)) {
            g6.n.s(k6Var.I(), k6Var.a1(x7.u.ng, str2));
        }
    }

    public static /* synthetic */ void O3(k6 k6Var, String str, View view, k.p pVar) {
        if (k6Var.f2580m0.z0(str)) {
            w9.n.e().s(true);
            k6Var.f2580m0.y1();
        }
    }

    public static /* synthetic */ void P3(k6 k6Var, String str, Bundle bundle) {
        k6Var.getClass();
        if (bundle.getInt("result_id", -1) >= 0) {
            w9.n.e().w(true);
            if (u9.d.m(k6Var.I(), k6Var.S8())) {
                k6Var.f2580m0.y1();
            } else {
                g6.n.q(k6Var.I(), x7.u.f14242z0);
            }
        }
        k6Var.N0().x("fav_result");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void Q3(final k6 k6Var, String str, String str2, int i10, int i11, int i12, String str3, String str4, AdapterView adapterView, View view, int i13, long j10) throws UnsupportedEncodingException {
        final String strI;
        k6Var.getClass();
        int i14 = (int) j10;
        switch (i14) {
            case 0:
            case 1:
                k6Var.f2580m0.i1(str, i14 == 1);
                break;
            case 2:
                k6Var.f2580m0.k1(str2, true);
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                g6.n.a(k6Var.I(), i10 == 6 ? str.substring(str.indexOf("://") + 3) : str, x7.u.pg);
                break;
            case 6:
                k6Var.La(str2);
                break;
            case 7:
                k6Var.Qa(str2, i11, i12);
                break;
            case 8:
                k6Var.z8();
                break;
            case 9:
                k6Var.t8(str);
                break;
            case 10:
                if (k6Var.f2580m0.l0(str)) {
                    w9.n.e().w(true);
                    g6.n.q(k6Var.I(), x7.u.f14242z0);
                    break;
                }
                break;
            case 11:
                if (k6Var.f2580m0.A0(str)) {
                    w9.n.e().s(true);
                    k6Var.f2580m0.y1();
                    break;
                }
                break;
            case 12:
            case 13:
                if (z8.w2.t(str)) {
                    String strSubstring = str.substring(9);
                    try {
                        strSubstring = URLDecoder.decode(str.substring(9), "utf-8");
                    } catch (UnsupportedEncodingException unused) {
                    }
                    o9.a aVarJ = pa.r.d().j(strSubstring);
                    strI = aVarJ != null ? aVarJ.b() : null;
                } else if (z8.w2.p(str)) {
                    strI = z8.w2.i(str);
                }
                if (strI != null) {
                    if (i14 != 12) {
                        w5.k.l(k6Var.I()).d0(x7.u.f14215x).J(k6Var.a1(x7.u.f13988g3, strI)).V(x7.u.f14215x, new k.m() { // from class: c8.m2
                            @Override // w5.k.m
                            public final void a(View view2, k.p pVar) {
                                k6.O3(this.f2671a, strI, view2, pVar);
                            }
                        }).N(R.string.cancel, null).f0();
                        break;
                    } else {
                        k6Var.N0().y1(a8.d0.f155w0, k6Var, new androidx.fragment.app.i0() { // from class: c8.k2
                            @Override // androidx.fragment.app.i0
                            public final void a(String str5, Bundle bundle) {
                                this.f2559a.N0().x(a8.d0.f155w0);
                            }
                        });
                        g6.i.h(k6Var, a8.d0.class, a8.d0.s3(strI, null, true));
                        break;
                    }
                }
                break;
            case 14:
                k6Var.w8(str);
                break;
            case 15:
                Context contextI = k6Var.I();
                final na naVar = k6Var.f2580m0;
                Objects.requireNonNull(naVar);
                t9.a.a(contextI, str, new Runnable() { // from class: c8.n2
                    @Override // java.lang.Runnable
                    public final void run() {
                        naVar.y1();
                    }
                });
                break;
            case 16:
                t9.e.f(k6Var.I(), str);
                k6Var.f2580m0.y1();
                break;
            case 17:
                Context contextI2 = k6Var.I();
                final na naVar2 = k6Var.f2580m0;
                Objects.requireNonNull(naVar2);
                t9.e.e(contextI2, new Runnable() { // from class: c8.n2
                    @Override // java.lang.Runnable
                    public final void run() {
                        naVar2.y1();
                    }
                });
                break;
            case 18:
                String str5 = str.substring(7, str.lastIndexOf(47) + 1) + Uri.decode(str.substring(str.lastIndexOf("/") + 1));
                if (!z8.c1.g(str5)) {
                    g6.n.s(k6Var.I(), k6Var.T0().getString(x7.u.f14016i3) + str5);
                    break;
                } else {
                    k6Var.f2580m0.y1();
                    break;
                }
            case 19:
                k6Var.U7(str, k6Var.R8(str));
                break;
            case 20:
                k6Var.mb(new e.b().j(str).k(k6Var.f2582n0.L1()).c("attachment").d(-1L).b());
                break;
            case 21:
                g6.n.e(k6Var.I(), x7.u.f14228y, x7.u.f14219x3, new k.m() { // from class: c8.o2
                    @Override // w5.k.m
                    public final void a(View view2, k.p pVar) {
                        this.f2726a.f2580m0.t0();
                    }
                });
                break;
            case 22:
                StringBuilder sb2 = new StringBuilder();
                String strR8 = k6Var.R8(str3);
                if (strR8 != null && !strR8.isEmpty()) {
                    sb2.append(k6Var.Z0(x7.u.V9));
                    sb2.append("\n");
                    sb2.append(strR8);
                }
                if (str3 != null && !str3.isEmpty()) {
                    if (sb2.length() > 0) {
                        sb2.append("\n\n");
                    }
                    sb2.append(k6Var.Z0(x7.u.W9));
                    sb2.append("\n");
                    sb2.append(str3);
                }
                if (str != null && !str.isEmpty()) {
                    if (sb2.length() > 0) {
                        sb2.append("\n\n");
                    }
                    sb2.append(k6Var.Z0(x7.u.U9));
                    sb2.append("\n");
                    sb2.append(str);
                }
                g6.n.l(k6Var.I(), x7.u.S, sb2.toString());
                break;
            case 23:
                k6Var.C9();
                break;
            case 24:
            case 25:
                if (i14 == 24) {
                    k6Var.f2580m0.j0(str);
                } else {
                    k6Var.f2580m0.A1(str);
                }
                g6.n.s(k6Var.I(), k6Var.a1(i14 == 24 ? x7.u.f14178u1 : x7.u.Tg, i6.i0.f7006a.f(str)));
                break;
            case 26:
            case 27:
                if (i14 == 26) {
                    k6Var.f2580m0.k0(str);
                } else {
                    k6Var.f2580m0.B1(str);
                }
                g6.n.s(k6Var.I(), k6Var.a1(i14 == 26 ? x7.u.f14178u1 : x7.u.Tg, str.substring(str.indexOf("://") + 3)));
                break;
            case 29:
                if (str4 != null) {
                    g6.n.a(k6Var.I(), str4.trim(), x7.u.og);
                    break;
                }
                break;
            case 31:
                z8.f1.k(k6Var.I(), str);
                break;
            case 32:
                k6Var.da(str);
                break;
            case 33:
                k6Var.hb(str2);
                break;
            case 34:
                k6Var.Pa(str2);
                break;
            case 35:
                k6Var.J8(i11, i12);
                break;
            case 36:
                k6Var.A9(i11, i12, str, str2, str4, true);
                break;
            case 37:
                g6.i.g(k6Var, i8.w.class);
                break;
            case 38:
                k6Var.q8(str2);
                break;
        }
    }

    public static /* synthetic */ void Q4(k6 k6Var, Integer num) {
        k6Var.getClass();
        if (num.intValue() == 1) {
            k6Var.f2602x0.v(true);
        } else if (num.intValue() == 5) {
            k6Var.B8();
        }
    }

    public static /* synthetic */ void Q5(k6 k6Var, Intent intent, View view, k.p pVar) {
        k6Var.getClass();
        try {
            k6Var.P2(intent);
        } catch (Exception unused) {
            g6.n.q(k6Var.I(), x7.u.xg);
        }
    }

    public static /* synthetic */ void R3(k6 k6Var, ImageView imageView) {
        k6Var.getClass();
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setId(x7.p.f13840s);
        imageView.setImageResource(x7.o.E0);
        imageView.setImageDrawable(lb.b.a(k6Var.I(), x7.o.E0, x7.u.ne));
        imageView.setColorFilter(-1);
        imageView.setBackgroundResource(x7.o.f13717d);
        imageView.setContentDescription(k6Var.Z0(x7.u.rg));
        imageView.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setElevation(g6.y.h(k6Var.I(), 12.0f));
        }
        k6Var.f2606z0.addView(imageView);
    }

    public static /* synthetic */ j7.f R4(k6 k6Var, Integer num) {
        k6Var.getClass();
        int iIntValue = num == null ? 4 : num.intValue();
        if (iIntValue == 0) {
            k6Var.T7();
            g6.n.q(k6Var.I(), x7.u.Ma);
            mark.via.common.widget.n0 n0Var = k6Var.f2602x0;
            if (n0Var == null) {
                return null;
            }
            n0Var.v(false);
            return null;
        }
        if (iIntValue == 3) {
            g6.n.q(k6Var.I(), x7.u.Ff);
            return null;
        }
        if (iIntValue == 1) {
            g6.n.q(k6Var.I(), x7.u.N1);
            return null;
        }
        if (iIntValue != 4) {
            return null;
        }
        g6.n.q(k6Var.I(), x7.u.M1);
        return null;
    }

    public static /* synthetic */ void R5(k6 k6Var, FragmentManager fragmentManager, Fragment fragment) {
        if (fragment instanceof f8.l0) {
            k6Var.S9((f8.l0) fragment);
            return;
        }
        if (fragment instanceof f8.h) {
            k6Var.H9((f8.h) fragment);
            return;
        }
        if (fragment instanceof mark.via.download.m) {
            k6Var.F9((mark.via.download.m) fragment);
            return;
        }
        if (fragment instanceof ua.y) {
            k6Var.Q9((ua.y) fragment);
            return;
        }
        if (fragment instanceof f8.q) {
            k6Var.N9((f8.q) fragment);
            return;
        }
        if (fragment instanceof f8.w) {
            k6Var.R9((f8.w) fragment);
        } else if (fragment instanceof i8.k) {
            k6Var.E9((i8.k) fragment);
        } else {
            k6Var.getClass();
        }
    }

    public static /* synthetic */ void S3(k6 k6Var) {
        k6Var.f2594t0.setAlpha(0.0f);
        k6Var.f2594t0.setVisibility(0);
    }

    public static /* synthetic */ void S5(WeakReference weakReference) {
        WebView webView = (WebView) weakReference.get();
        if (webView != null) {
            webView.setVisibility(0);
        }
    }

    public static /* synthetic */ x5.a T3(String str, String str2) {
        o9.c cVarD = pa.r.d();
        o9.a aVarF = cVarD.f(str);
        if (aVarF == null) {
            aVarF = cVarD.j(str2);
        }
        return x5.a.f(aVarF);
    }

    public static /* synthetic */ void T5(k6 k6Var, List list, View view, k.p pVar) {
        int iK = k6Var.k() + 1;
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            k6Var.f2580m0.g1((String) list.get(i10), i10 == size + (-1), iK);
            i10++;
            iK++;
        }
    }

    public static /* synthetic */ void U2(k6 k6Var, Uri uri) {
        if (uri == null) {
            k6Var.getClass();
            return;
        }
        k6Var.I().getContentResolver().takePersistableUriPermission(uri, 3);
        k6Var.f2582n0.p(uri.toString());
        k6Var.Y8();
    }

    public static /* synthetic */ void U3(k6 k6Var, boolean z10) {
        if (k6Var.i1()) {
            k6Var.Lb();
            if (!k6Var.f2583n1) {
                k6Var.f2580m0.R1(z10);
                return;
            }
            Intent intent = k6Var.l0().getIntent();
            if (intent != null) {
                k6Var.f2580m0.q1(intent);
            }
        }
    }

    public static /* synthetic */ j7.f U4(k6 k6Var, Boolean bool) {
        k6Var.getClass();
        if (!bool.booleanValue()) {
            return null;
        }
        k6Var.b8();
        return null;
    }

    public static /* synthetic */ void V3(k6 k6Var, x5.a aVar) {
        k6Var.getClass();
        k6Var.Y9(aVar.d() ? ((o9.a) aVar.b()).b() : null);
    }

    public static /* synthetic */ x.k0 V5(k6 k6Var, View view, x.k0 k0Var) {
        k6Var.getClass();
        int iF = k0.m.f() | k0.m.b() | k0.m.c();
        k0.b bVar = new k0.b(k0Var);
        r.f fVar = r.f.f11464e;
        x.k0 k0VarA = bVar.b(iF, fVar).e(k0.m.c(), false).a();
        z8.l3.s(k0Var);
        if (!z8.l3.i(k0Var, view)) {
            k6Var.I8(view, k0Var, true);
            return k0VarA;
        }
        r.f fVarF = k0Var.f(k0.m.b());
        if (fVar.equals(fVarF)) {
            k6Var.I8(view, k0Var, false);
            return k0VarA;
        }
        if (!k6Var.f2582n0.O1() && k6Var.f2578k1) {
            if (Resources.getSystem().getConfiguration().orientation == 2) {
                view.setPadding(fVarF.f11465a, 0, fVarF.f11467c, 0);
            } else {
                view.setPadding(0, fVarF.f11466b, 0, fVarF.f11468d);
            }
            k6Var.f2604y0.setPadding(0, 0, 0, 0);
            k6Var.f2600w0.setPadding(0, 0, 0, 0);
            k6Var.f2596u0.setPadding(0, 0, 0, 0);
            return k0VarA;
        }
        x.c cVarE = k0Var.e();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (cVarE != null && measuredWidth > 0 && measuredHeight > 0) {
            r.f fVarF2 = k0Var.f(k0.m.c());
            List<Rect> listA = cVarE.a();
            int[] iArr = {0, 0, 0, 0};
            int[] iArr2 = {0, 0, 0, 0};
            int iH = g6.y.h(view.getContext(), 16.0f);
            for (Rect rect : listA) {
                if (rect.top <= iH) {
                    int i10 = rect.left;
                    int i11 = iH * 2;
                    if (i10 < i11) {
                        iArr[0] = Math.max(iArr[0], rect.right);
                    } else if (rect.right >= measuredWidth - i11) {
                        iArr[2] = Math.max(iArr[2], measuredWidth - i10);
                    }
                    iArr[1] = Math.max(iArr[1], rect.bottom);
                } else if (fVarF2.f11468d <= 0 && rect.bottom >= measuredHeight - iH) {
                    int i12 = rect.left;
                    int i13 = iH * 2;
                    if (i12 < i13) {
                        iArr2[0] = Math.max(iArr2[0], rect.right);
                    } else if (rect.right >= measuredWidth - i13) {
                        iArr2[2] = Math.max(iArr2[2], measuredWidth - i12);
                    }
                    iArr2[3] = Math.max(iArr2[3], measuredHeight - rect.top);
                }
            }
            if (!k6Var.f2569b1 || k6Var.A0 == null || (k6Var.W0 != 1 ? iArr2[3] >= (k6Var.f2600w0.getMeasuredHeight() / 2) * 3 : iArr[1] >= (k6Var.f2604y0.getMeasuredHeight() / 2) * 3)) {
                k6Var.f2604y0.setPadding(iArr[0], 0, iArr[2], 0);
                k6Var.f2600w0.setPadding(iArr2[0], 0, iArr2[2], 0);
                k6Var.f2596u0.setPadding(0, 0, 0, 0);
            } else {
                k6Var.f2604y0.setPadding(0, 0, 0, 0);
                k6Var.f2600w0.setPadding(0, 0, 0, 0);
                if (k6Var.W0 == 1) {
                    k6Var.f2596u0.setPadding(iArr[0], 0, iArr[2], 0);
                } else {
                    k6Var.f2596u0.setPadding(iArr2[0], 0, iArr2[2], 0);
                }
            }
            view.setPadding(0, 0, 0, 0);
        }
        return k0VarA;
    }

    public static /* synthetic */ void W2(k6 k6Var, String str, String str2) throws NumberFormatException {
        int i10;
        k6Var.getClass();
        if (str2.length() <= 0 || !TextUtils.isDigitsOnly(str2)) {
            k6Var.ea(0, 0, str);
            return;
        }
        try {
            i10 = Integer.parseInt(str2);
        } catch (Exception unused) {
            i10 = 0;
        }
        int i11 = i10 & 63;
        int i12 = i10 >> 6;
        if (i12 > 0) {
            height = ((k6Var.f2606z0.getHeight() - g6.y.h(k6Var.I(), i12)) - (k6Var.f2604y0.getVisibility() == 0 ? k6Var.f2604y0.getHeight() : 0)) + g6.f.d(k6Var.I(), x7.n.B) + g6.y.h(k6Var.I(), 4.0f);
        }
        k6Var.ea(i11, height, str);
    }

    public static /* synthetic */ void W4(k6 k6Var, float f10, boolean z10) throws Resources.NotFoundException {
        k6Var.getClass();
        int i10 = 0;
        int i11 = 1;
        boolean z11 = ((double) Math.abs(f10)) > 0.8d;
        if (z10 && z11) {
            k6Var.ra(f10 > 0.0f ? k6Var.f2582n0.g2() : k6Var.f2582n0.m1());
        }
        if (z11) {
            int iG2 = f10 > 0.0f ? k6Var.f2582n0.g2() : k6Var.f2582n0.m1();
            if (iG2 == 10) {
                i10 = -1;
            } else if (iG2 == 11) {
                i10 = 1;
            }
        }
        if (k6Var.B1 == i10) {
            return;
        }
        k6Var.B1 = i10;
        int i12 = k6Var.i();
        if (i10 == 0) {
            k6Var.f2598v0.l(-1, i12);
            return;
        }
        int iK = k6Var.k() + 1 + i10;
        if (iK <= 0) {
            i11 = i12;
        } else if (iK <= i12) {
            i11 = iK;
        }
        k6Var.f2598v0.l(i11, i12);
    }

    public static /* synthetic */ void W5(k6 k6Var, mark.via.download.e eVar, Uri uri, View view, k.p pVar) {
        k6Var.P1 = eVar;
        try {
            k6Var.T1.a(uri);
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    public static /* synthetic */ void X2(final k6 k6Var, final v9.f fVar, String str, String str2, View view, k.p pVar) {
        k6Var.getClass();
        fVar.m(str);
        fVar.o(str2);
        fVar.n(System.currentTimeMillis());
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.v2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                v9.f fVar2 = fVar;
                return Boolean.valueOf(pa.r.i().b(fVar2.b(), fVar2));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(k6Var.d1()))).a(new a7.e() { // from class: c8.x2
            @Override // a7.e
            public final void accept(Object obj) {
                k6.F4(this.f2910e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public static /* synthetic */ void X3(k6 k6Var, boolean z10, int i10, DialogInterface dialogInterface) {
        if (z10) {
            k6Var.ma(i10 | 4);
        } else {
            k6Var.getClass();
        }
    }

    public static /* synthetic */ void X5(k6 k6Var, String str, Bundle bundle) throws Resources.NotFoundException, URISyntaxException, PackageManager.NameNotFoundException {
        k6Var.getClass();
        int i10 = bundle.getInt(Name.MARK, 0);
        int i11 = bundle.getInt("flags", 0);
        if (i10 != 0) {
            if ((i11 & 2) != 0) {
                k6Var.P9(i10, i11);
            } else if ((i11 & 1) != 0) {
                k6Var.O9(i10, i11);
            }
        }
        k6Var.z0().x("menu_result");
    }

    public static /* synthetic */ void Y5(k6 k6Var, String str, Bundle bundle) {
        k6Var.getClass();
        if (bundle.getString(Name.MARK) != null) {
            k6Var.f2580m0.y1();
        }
        k6Var.N0().x("bookmarkDialogResult2");
    }

    public static /* synthetic */ void Z2(k6 k6Var, Boolean bool) {
        k6Var.getClass();
        if (bool.booleanValue()) {
            g6.n.q(k6Var.l0(), x7.u.f14037ja);
        }
    }

    public static /* synthetic */ void Z4(k6 k6Var, int i10, String[] strArr, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == i10) {
            k6Var.getClass();
            return;
        }
        w9.p pVarM2 = k6Var.f2582n0.m2();
        if (i11 == 0) {
            pVarM2.U(false);
            pVarM2.T(true);
        } else if (i11 == 1) {
            pVarM2.U(false);
            pVarM2.T(false);
        } else if (i11 == 2) {
            pVarM2.U(true);
            pVarM2.T(true);
        }
        k6Var.f2582n0.g0(pVarM2);
        k6Var.f2580m0.m1(true);
        g6.n.s(k6Var.I(), strArr[i11]);
    }

    public static /* synthetic */ void Z5(k6 k6Var, Map map, AdapterView adapterView, View view, int i10, long j10) throws Resources.NotFoundException, PendingIntent.CanceledException {
        k6Var.getClass();
        int i11 = (int) j10;
        PendingIntent pendingIntent = (PendingIntent) map.get(Integer.valueOf(i11));
        if (pendingIntent != null) {
            k6Var.Va(pendingIntent);
        }
        String strS8 = k6Var.S8();
        switch (i11) {
            case 990:
                if (strS8 != null && !strS8.isEmpty()) {
                    z8.f1.k(k6Var.I(), strS8);
                    break;
                }
                break;
            case 992:
                if (strS8 != null && !strS8.isEmpty()) {
                    g6.n.a(k6Var.I(), strS8, x7.u.pg);
                    break;
                }
                break;
            case 993:
                k6Var.ra(14);
                break;
            case 994:
                k6Var.ra(6);
                break;
            case 995:
                if (strS8 != null && !strS8.isEmpty()) {
                    z8.b0.P(k6Var.I(), strS8);
                    k6Var.l0().finish();
                    break;
                }
                break;
            case 996:
                k6Var.ra(15);
                break;
            case 997:
                if (strS8 != null && !strS8.isEmpty()) {
                    k6Var.yb(strS8);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Za(int i10, int i11, boolean z10) {
        f8.h hVar = (f8.h) z0().n0(f8.h.f5979v0);
        if (hVar == null) {
            return;
        }
        hVar.h3(i10, i11, z10);
    }

    public static /* synthetic */ boolean a3(k6 k6Var, String[] strArr, AdapterView adapterView, View view, int i10, long j10) {
        g6.n.a(k6Var.I(), strArr[i10], x7.u.pg);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a4(final k6 k6Var, mark.via.common.widget.t tVar) {
        boolean zD = k6Var.f2582n0.d();
        int iC0 = k6Var.U0;
        boolean z10 = false;
        boolean z11 = iC0 == 0;
        i9.a aVarM2 = k6Var.f2582n0.M2();
        if (!zD) {
            if (!z11 || !aVarM2.c()) {
                if (z11) {
                    iC0 = k6Var.f2582n0.c0();
                }
                if (g6.y.C(iC0)) {
                    z10 = true;
                }
            } else if (aVarM2.d()) {
            }
        }
        Context contextI = k6Var.I();
        int i10 = R.color.white;
        int iB = g6.f.b(contextI, zD ? x7.m.f13678h : z10 ? x7.m.f13677g : R.color.white);
        Context contextI2 = k6Var.I();
        if (zD) {
            i10 = x7.m.f13675e;
        } else if (z10) {
            i10 = x7.m.f13674d;
        }
        tVar.y(iB, g6.f.b(contextI2, i10));
        tVar.setTabs(k6Var.L0.c());
        tVar.setOnDeleteItemClickListener(new t.d() { // from class: c8.u5
            @Override // mark.via.common.widget.t.d
            public final void a(int i11) {
                this.f2862a.f2580m0.C0(i11);
            }
        });
        tVar.setOnNewTabButtonClickListener(new t.h() { // from class: c8.v5
            @Override // mark.via.common.widget.t.h
            public final void onClick(View view) {
                this.f2882a.f2580m0.j1(null, true);
            }
        });
        tVar.setOnTabItemClickListener(new t.i() { // from class: c8.w5
            @Override // mark.via.common.widget.t.i
            public final void a(int i11) {
                this.f2898a.f2580m0.X1(i11);
            }
        });
        tVar.setOnMoveTabListener(new t.g() { // from class: c8.x5
            @Override // mark.via.common.widget.t.g
            public final boolean onMove(int i11, int i12) {
                return this.f2914a.L0.p(i11, i12);
            }
        });
        tVar.setOnDeleteTabsListener(new t.e() { // from class: c8.y5
            @Override // mark.via.common.widget.t.e
            public final void b(int i11, int i12) {
                this.f2930a.j8(i11, i12);
            }
        });
        tVar.setOnDuplicateTabListener(new t.f() { // from class: c8.z5
            @Override // mark.via.common.widget.t.f
            public final void a(int i11) {
                k6.y4(this.f2962a, i11);
            }
        });
    }

    public static /* synthetic */ void a5(k6 k6Var, String[][] strArr, AdapterView adapterView, View view, int i10, long j10) throws Resources.NotFoundException {
        k6Var.getClass();
        String str = strArr[0][i10];
        k6Var.f2582n0.E0(str);
        k6Var.O0.j(str);
        g6.n.s(k6Var.I(), k6Var.a1(x7.u.f14171t7, k6Var.Z0(x7.u.A0), strArr[1][i10]));
        k6Var.d9();
    }

    public static /* synthetic */ void a6(k6 k6Var, String str, Bundle bundle) {
        k6Var.getClass();
        if (bundle.getString(Name.MARK) != null) {
            k6Var.f2580m0.y1();
        }
        k6Var.N0().x("bookmarkDialogResult2");
    }

    public static /* synthetic */ void b5(t4.b bVar, String str, WebView.WebViewTransport webViewTransport, Message message) {
        bVar.setTag(e8.i.f4821d, Boolean.TRUE);
        bVar.setReferer(str);
        webViewTransport.setWebView(bVar);
        message.sendToTarget();
    }

    public static /* synthetic */ void b6(k6 k6Var) {
        k6Var.getClass();
        ia.d.g(pa.r.f(), k6Var.Q0.d());
    }

    public static /* synthetic */ j7.f c3(k6 k6Var, Integer num) {
        k6Var.getClass();
        int iIntValue = num == null ? 2 : num.intValue();
        if (iIntValue != 0) {
            if (iIntValue != 1) {
                return null;
            }
            g6.n.q(k6Var.I(), x7.u.N1);
            return null;
        }
        t4.b bVarO8 = k6Var.O8();
        d8.g.c().e(bVarO8.getUrl());
        bVarO8.setAccentColor(-1);
        k6Var.Nb(-1, false);
        g6.n.q(k6Var.I(), x7.u.La);
        return null;
    }

    public static /* synthetic */ void c4(k6 k6Var, ValueAnimator valueAnimator) {
        if (k6Var.i1()) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            k6Var.f2584o0.k(iIntValue, valueAnimator.getAnimatedFraction() != 1.0f);
            k6Var.f2600w0.setBackgroundColor(iIntValue);
            mark.via.common.widget.m mVar = k6Var.B0;
            if (mVar != null) {
                mVar.setBackgroundColor(iIntValue);
            }
        }
    }

    public static /* synthetic */ o9.b c6(String str, String str2) {
        o9.b bVarA = pa.r.d().a(str);
        if (bVarA != null) {
            return bVarA;
        }
        o9.b bVar = new o9.b();
        bVar.n(str);
        bVar.l(str2);
        return bVar;
    }

    public static /* synthetic */ void d3(k6 k6Var) {
        k6Var.f2595t1 = false;
        if (x.r.F(k6Var.f2606z0)) {
            x.r.U(k6Var.f2606z0);
        }
    }

    public static /* synthetic */ void d6(k6 k6Var, androidx.lifecycle.h hVar, Lifecycle.Event event) {
        k6Var.getClass();
        if (event == Lifecycle.Event.ON_DESTROY) {
            y7 y7Var = k6Var.f2584o0;
            if (y7Var != null) {
                y7Var.setBlurEnabled(false);
                k6Var.f2584o0.setDescendantFocusability(262144);
            }
            if (k6Var.B0 != null) {
                k6Var.gb(true);
            }
        }
    }

    public static /* synthetic */ void e5(final k6 k6Var, View view, k.p pVar) {
        k6Var.getClass();
        if (g6.e.e(pVar.f13339c, 1)) {
            return;
        }
        w9.a aVarV = k6Var.f2582n0.v();
        boolean zP = aVarV.p();
        boolean z10 = pVar.f13338b;
        if (zP != z10) {
            aVarV.I(z10);
            k6Var.f2582n0.q0(aVarV);
        }
        ((autodispose2.n) k6Var.f2580m0.O1(z8.c1.n(pVar.f13339c[0]), pVar.f13338b).I(u8.b.a(k6Var.d1()))).a(new a7.e() { // from class: c8.m1
            @Override // a7.e
            public final void accept(Object obj) {
                k6.u5(this.f2670e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public static /* synthetic */ void e6(k6 k6Var, String str, Bundle bundle) {
        k6Var.z0().x("menu_result");
        if (bundle.getInt("action", 0) != 0) {
            g6.i.g(k6Var, a9.o.class);
        }
    }

    public static /* synthetic */ void f3(k6 k6Var, String str, String str2, Bundle bundle) {
        k6Var.getClass();
        int i10 = bundle.getInt("changed", 0);
        if ((i10 & 2) != 0) {
            k6Var.qb(true, i10);
        } else if ((i10 & 1) != 0) {
            k6Var.f2580m0.v1(str);
        }
        k6Var.N0().x("result");
    }

    public static /* synthetic */ void f4(k6 k6Var, int i10, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == i10) {
            k6Var.getClass();
            return;
        }
        k6Var.f2582n0.Q0(i11 + 1);
        int iI0 = k6Var.f2582n0.i0();
        z8.n3.i(k6Var.I(), iI0 != 2 ? iI0 != 3 ? iI0 != 4 ? 2 : 0 : 1 : 10);
        g6.n.s(k6Var.I(), k6Var.a1(x7.u.f14171t7, k6Var.Z0(x7.u.P9), g6.e.c(k6Var.I(), x7.j.f13650g, i11)));
    }

    public static /* synthetic */ void f5(k6 k6Var, String str, View view, k.p pVar) {
        k6Var.getClass();
        k6Var.f2580m0.i1(i6.i0.f7006a.v(str, k6Var.f2582n0.Z0()), true);
    }

    public static /* synthetic */ void f6(k6 k6Var, TextView textView) {
        k6Var.getClass();
        textView.setText(x7.u.f13966e9);
        textView.setGravity(17);
        textView.setTextSize(0, x8.h.u(k6Var.I()));
        textView.setTextColor(x8.h.q(k6Var.I()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    public static /* synthetic */ x5.a g3(k6 k6Var, String str, String str2) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStream;
        k6Var.getClass();
        String strB = l5.c.b(l5.a.d(str));
        StringBuilder sb2 = new StringBuilder();
        if (str2 == null) {
            str2 = str;
        }
        sb2.append(z8.v0.g(str2));
        sb2.append(".");
        if (strB == null) {
            strB = "png";
        }
        sb2.append(strB);
        ?? string = sb2.toString();
        File file = new File(z8.c1.k(k6Var.I(), "download", string));
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                } catch (IOException e10) {
                    e = e10;
                    pc.a.i(e);
                    g6.j.a(fileOutputStream);
                    return x5.a.f(null);
                }
            } catch (Throwable th2) {
                th = th2;
                g6.j.a(string);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            fileOutputStream = null;
        } catch (Throwable th3) {
            string = 0;
            th = th3;
            g6.j.a(string);
            throw th;
        }
        if (l5.a.h(str, fileOutputStream)) {
            x5.a aVarF = x5.a.f(file);
            g6.j.a(fileOutputStream);
            return aVarF;
        }
        file.delete();
        g6.j.a(fileOutputStream);
        return x5.a.f(null);
    }

    public static /* synthetic */ mark.via.common.widget.o0 g4(k6 k6Var, boolean z10, String str, String str2, int i10, int i11) {
        Bitmap bitmapC;
        k6Var.getClass();
        if (z10) {
            bitmapC = BitmapFactory.decodeFile(str);
        } else {
            bitmapC = z8.i.c(str2, i10, i11);
            pc.a.a("using file does not exists, load from original picture", new Object[0]);
        }
        if (bitmapC == null) {
            return null;
        }
        return new mark.via.common.widget.o0(k6Var.T0(), bitmapC);
    }

    public static /* synthetic */ void g5(k6 k6Var, int i10, boolean z10, int i11, TextView textView, String str, mark.via.common.widget.w0 w0Var) {
        k6Var.getClass();
        w0Var.setMax(30);
        w0Var.setProgress((i10 - 50) / 5);
        if (!z10) {
            i11 = 100;
        }
        w0Var.setHighlightProgress((i11 - 50) / 5);
        z8.r3.g(w0Var);
        w0Var.setMinimumHeight(g6.y.h(k6Var.I(), 2.0f));
        w0Var.setOnSeekBarChangeListener(k6Var.new g(textView, z10, str));
    }

    public static /* synthetic */ j7.f g6(k8.o oVar, Integer num) {
        oVar.a(Integer.valueOf(num == null ? 0 : num.intValue()));
        return null;
    }

    public static /* synthetic */ void h3(k6 k6Var, WeakReference weakReference, Integer num) {
        k6Var.getClass();
        if (((t4.b) weakReference.get()) == null || num.intValue() != 3) {
            return;
        }
        k6Var.T7();
    }

    public static /* synthetic */ void h5(k6 k6Var, HttpAuthHandler httpAuthHandler, String str, String str2, String str3, Bundle bundle) {
        k6Var.getClass();
        String string = bundle.getString("username");
        String string2 = bundle.getString("password");
        if (g6.p.f(string) || g6.p.f(string2)) {
            httpAuthHandler.cancel();
        } else {
            httpAuthHandler.proceed(string, string2);
            k6Var.Ka(str, string, string2);
            k6Var.c8(str2, string, string2);
        }
        k6Var.N0().x("url");
    }

    public static /* synthetic */ void i3(k6 k6Var) throws Resources.NotFoundException {
        boolean zO1 = k6Var.f2582n0.O1();
        boolean z10 = !zO1;
        k6Var.f2582n0.b(z10);
        k6Var.ab(z10);
        k6Var.Jb();
        g6.n.s(k6Var.I(), k6Var.a1(!zO1 ? x7.u.f14006h7 : x7.u.f13992g7, k6Var.Z0(x7.u.G)));
    }

    public static /* synthetic */ void i5(final k6 k6Var, mark.via.common.widget.o0 o0Var) {
        k6Var.getClass();
        pc.a.a("init home view done", new Object[0]);
        k6Var.f2584o0.setWindowBackgroundImage(o0Var);
        k6Var.f2586p0.post(new Runnable() { // from class: c8.b5
            @Override // java.lang.Runnable
            public final void run() {
                this.f2351e.Ob();
            }
        });
    }

    public static /* synthetic */ void j3(k6 k6Var, List list, View view, k.p pVar) {
        int iK = k6Var.k() + 1;
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            k6Var.f2580m0.g1((String) list.get(i10), i10 == size + (-1), iK);
            i10++;
            iK++;
        }
    }

    public static /* synthetic */ void j5(k6 k6Var, t4.b bVar, String str, String str2) {
        if (k6Var.O8() == null) {
            return;
        }
        s4.b.g(bVar, k6Var.Q0.a().b(k6Var.Q0.c(), str, str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void k3(k6 k6Var, String str, Bundle bundle) {
        r4.a aVarD = k6Var.d();
        if (aVarD != null && bundle.containsKey("qrcode")) {
            String string = bundle.getString("qrcode", "");
            i6.i0 i0Var = i6.i0.f7006a;
            if (i0Var.t(string)) {
                String strV = i0Var.v(string, k6Var.f2582n0.Z0());
                if (i0Var.s(strV) || i0Var.l(strV) || i0Var.k(strV)) {
                    aVarD.v(strV);
                } else {
                    aVarD.v(i0Var.a(string, k6Var.Z0(x7.u.Ea)));
                }
            }
        }
        k6Var.N0().x("qrcode");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void k4(k6 k6Var, mark.via.common.widget.m mVar) {
        boolean zD = k6Var.f2582n0.d();
        int i10 = k6Var.U0;
        boolean z10 = false;
        boolean z11 = i10 == 0;
        i9.a aVarM2 = k6Var.f2582n0.M2();
        if (!zD) {
            if (!z11 || !aVarM2.c()) {
                if (g6.y.C(z11 ? k6Var.f2582n0.c0() : i10)) {
                    z10 = true;
                }
            } else if (aVarM2.d()) {
            }
        }
        Context contextI = k6Var.I();
        int i11 = R.color.white;
        int iB = g6.f.b(contextI, zD ? x7.m.f13678h : z10 ? x7.m.f13677g : R.color.white);
        Context contextI2 = k6Var.I();
        if (zD) {
            i11 = x7.m.f13675e;
        } else if (z10) {
            i11 = x7.m.f13674d;
        }
        mVar.l(iB, g6.f.b(contextI2, i11));
        mVar.setBackgroundColor(i10);
    }

    public static /* synthetic */ void k5(k6 k6Var, x5.a aVar) {
        k6Var.getClass();
        k6Var.Y9(aVar.d() ? ((o9.a) aVar.b()).b() : null);
    }

    public static /* synthetic */ void k6(k6 k6Var, String str, AdapterView adapterView, View view, int i10, long j10) {
        String str2;
        k6Var.getClass();
        switch ((int) j10) {
            case 2:
                str2 = "https://lens.google.com/uploadbyurl?url=";
                break;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                str2 = "https://www.bing.com/images/search?view=detailv2&iss=sbi&form=SBIVSP&sbisrc=UrlPaste&q=imgurl:";
                break;
            case 4:
                str2 = "https://tineye.com/search/?url=";
                break;
            case 5:
                str2 = "https://yandex.com/images/touch/search?family=yes&rpt=imageview&url=";
                break;
            case 6:
                str2 = "https://graph.baidu.com/details?isfromtusoupc=1&tn=pc&carousel=0&promotion_name=pc_image_shituindex&extUiData%5bisLogoShow%5d=1&image=";
                break;
            case 7:
                str2 = "https://st.so.com/r?img_url=";
                break;
            case 8:
                str2 = "https://saucenao.com/search.php?db=999&url=";
                break;
            case 9:
                str2 = "https://iqdb.org/?url=";
                break;
            case 10:
                str2 = "https://3d.iqdb.org/?url=";
                break;
            case 11:
                str2 = "https://trace.moe/?url=";
                break;
            case 12:
                str2 = "https://ascii2d.net/search/url/";
                break;
            default:
                str2 = "https://www.google.com/searchbyimage?safe=off&sbisrc=tg&image_url=";
                break;
        }
        k6Var.f2580m0.i1(str2 + Uri.encode(str), true);
    }

    public static /* synthetic */ void l3(k6 k6Var, List list, int i10, boolean z10, String[] strArr, AdapterView adapterView, View view, int i11, long j10) throws Resources.NotFoundException {
        k6Var.getClass();
        ja.c cVar = (ja.c) list.get(i11);
        if (cVar.d() == i10) {
            return;
        }
        if (z10) {
            k6Var.f2582n0.D2(cVar.d());
            if (z8.b4.f(cVar.d())) {
                k6Var.f2582n0.P2(cVar.a());
            }
        } else {
            k6Var.f2582n0.I(cVar.d());
            if (z8.b4.f(cVar.d())) {
                k6Var.f2582n0.f2(cVar.a());
            }
        }
        k6Var.f2580m0.l1();
        String strS8 = k6Var.S8();
        if (!u9.d.m(k6Var.I(), strS8)) {
            String strF = i6.i0.f7006a.f(strS8);
            if (!TextUtils.isEmpty(strF) && !"pan.baidu.com".equalsIgnoreCase(strF) && !"yun.baidu.com".equalsIgnoreCase(strF) && !"eyun.baidu.com".equalsIgnoreCase(strF)) {
                k6Var.wa();
            }
        }
        g6.n.s(k6Var.I(), k6Var.a1(x7.u.f14171t7, k6Var.Z0(x7.u.C0), strArr[i11]));
        k6Var.d9();
    }

    public static /* synthetic */ x5.a l4(String str, String str2) {
        v9.g gVarI = pa.r.i();
        String strM = gVarI.m(i6.i0.f7006a.e(str), str2);
        return x5.a.f(strM == null ? null : gVarI.f(strM));
    }

    public static /* synthetic */ void l5(final k6 k6Var, final String str, String str2, String str3, AdapterView adapterView, View view, int i10, long j10) {
        k6Var.getClass();
        if (i10 == 1) {
            g7.a.c().d(new Runnable() { // from class: c8.z2
                @Override // java.lang.Runnable
                public final void run() {
                    pa.r.i().c(str, false);
                }
            });
            return;
        }
        if (i10 == 2) {
            return;
        }
        final v9.f fVar = new v9.f();
        fVar.j(UUID.randomUUID().toString().toLowerCase(Locale.ROOT));
        fVar.k(i6.i0.f7006a.e(str));
        fVar.o(str);
        fVar.p(str2);
        fVar.m(str3);
        fVar.i(System.currentTimeMillis());
        fVar.n(fVar.a());
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.a3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(pa.r.i().k(fVar));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(k6Var.d1()))).a(new a7.e() { // from class: c8.b3
            @Override // a7.e
            public final void accept(Object obj) {
                k6.Z2(this.f2349e, (Boolean) obj);
            }
        }, new x7.g0());
    }

    public static /* synthetic */ void m4(k6 k6Var, androidx.lifecycle.h hVar, Lifecycle.Event event) {
        y7 y7Var;
        k6Var.getClass();
        if (event != Lifecycle.Event.ON_DESTROY || (y7Var = k6Var.f2584o0) == null) {
            return;
        }
        y7Var.setBlurEnabled(false);
        k6Var.f2584o0.setDescendantFocusability(262144);
    }

    public static /* synthetic */ void m5(final k6 k6Var, String str, String str2, Integer num) {
        k6Var.getClass();
        if (num.intValue() != -1 && (!w8.e.f13354a.contains("huawei") || k6Var.f2582n0.U2() >= 1)) {
            a8.u1.x3(str, str2).h3(k6Var.z0(), null);
            return;
        }
        w9.l lVar = k6Var.f2582n0;
        lVar.d1(lVar.U2() + 1);
        w5.k.l(k6Var.I()).d0(x7.u.f14203w0).I(x7.u.D8).V(x7.u.f14095nc, new k.m() { // from class: c8.b2
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                w8.e.g(this.f2348a.I());
            }
        }).N(R.string.cancel, null).f0();
    }

    public static /* synthetic */ void n3(k6 k6Var, List list) {
        k6Var.getClass();
        if (list.size() <= 1) {
            if (k6Var.B0 != null) {
                k6Var.gb(false);
                return;
            }
            return;
        }
        if (k6Var.B0 == null) {
            k6Var.n9();
        }
        if (k6Var.B0 != null) {
            Collections.sort(list, new ib.q(k6Var.f2582n0.I1()));
            k6Var.B0.m(list, null);
            k6Var.Rb(k6Var.S8());
        }
    }

    public static /* synthetic */ void n4(k6 k6Var, o9.b bVar) {
        k6Var.getClass();
        if (bVar.c() != null) {
            k6Var.v8(bVar.c());
        } else {
            k6Var.e8(bVar.g(), bVar.e());
        }
    }

    public static /* synthetic */ boolean o3(final k6 k6Var, final String str, final Intent intent, View view) {
        k6Var.getClass();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        w5.k.l(k6Var.I()).d0(x7.u.f14036j9).J(str).V(x7.u.f14008h9, new k.m() { // from class: c8.g2
            @Override // w5.k.m
            public final void a(View view2, k.p pVar) {
                k6.Q5(this.f2459a, intent, view2, pVar);
            }
        }).N(R.string.cancel, null).R(R.string.copy, new View.OnClickListener() { // from class: c8.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g6.n.a(this.f2478a.I(), str, x7.u.pg);
            }
        }).f0();
        return true;
    }

    public static /* synthetic */ void o5(k6 k6Var, View view, k.p pVar) {
        int i10 = k6Var.i();
        if (i10 <= 0) {
            return;
        }
        int[] iArr = new int[i10];
        int i11 = i10 - 1;
        int i12 = 0;
        while (i11 >= 0) {
            iArr[i12] = i11;
            i11--;
            i12++;
        }
        k6Var.i8(iArr);
    }

    public static /* synthetic */ void p3(final k6 k6Var, String str, String str2, String str3, List list, int i10) {
        k6Var.getClass();
        j8.t tVar = new j8.t(str, str2, str3, list, i10);
        String strI = k6Var.I1.i(tVar);
        if (strI != null) {
            k6Var.f2576i1 = strI;
            j8.e.b(k6Var.I(), strI);
            g6.n.r(k6Var.I(), x7.u.id, x7.u.Jh, new View.OnClickListener() { // from class: c8.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2344a.ha();
                }
            });
            k6Var.xb(tVar, false);
        }
    }

    public static /* synthetic */ void p5(k6 k6Var, int i10, TextView textView) {
        k6Var.getClass();
        textView.setText(String.format(Locale.ROOT, "%d%%", Integer.valueOf(i10)));
        textView.setGravity(17);
        textView.setTextSize(0, x8.h.s(k6Var.I()));
        textView.setTextColor(g6.e.a(k6Var.I(), x7.k.f13665k));
    }

    public static /* synthetic */ w.d q3(k6 k6Var, mark.via.download.e eVar, String str) {
        k6Var.getClass();
        g5.c cVar = new g5.c();
        cVar.J(eVar.d());
        cVar.K(eVar.f() == null ? str : eVar.f());
        cVar.S(eVar.h());
        cVar.N(true);
        cVar.I(eVar.e());
        cVar.Q(eVar.c());
        cVar.P(90);
        if (URLUtil.isNetworkUrl(cVar.t())) {
            cVar.x(8);
            HashMap map = new HashMap();
            if (!g6.p.f(eVar.i())) {
                map.put("User-Agent", eVar.i());
            }
            if (!g6.p.f(eVar.g())) {
                map.put("Referer", eVar.g());
            }
            if (!g6.p.f(eVar.a())) {
                map.put("Authorization", eVar.a());
            }
            if (!map.isEmpty()) {
                cVar.G(map);
            }
        } else {
            cVar.x(1);
        }
        return w.d.a(Integer.valueOf(mark.via.download.i1.h(k6Var.I(), cVar, str)), cVar);
    }

    public static /* synthetic */ void r4(k6 k6Var, Intent intent, View view) {
        k6Var.getClass();
        try {
            k6Var.P2(intent);
        } catch (Exception unused) {
            g6.n.q(k6Var.I(), x7.u.xg);
        }
    }

    public static /* synthetic */ void s3(k6 k6Var, int[] iArr, final String str, View view, k.p pVar) {
        final int i10;
        k6Var.getClass();
        int[] iArr2 = pVar.f13337a;
        if (iArr2 == null || iArr2.length <= 0) {
            i10 = 0;
        } else {
            i10 = 0;
            for (int i11 : iArr2) {
                if (i11 > 0) {
                    i10 += iArr[i11];
                }
            }
        }
        String[] strArr = pVar.f13339c;
        final String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
        if (g6.p.f(str2) && i10 == 0) {
            return;
        }
        final String strQ8 = k6Var.Q8();
        z8.h.b(new Runnable() { // from class: c8.j2
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                z8.h2.a(str, strQ8, i10, str2);
            }
        });
        g6.n.q(k6Var.I(), x7.u.Wa);
    }

    public static /* synthetic */ void s4(k6 k6Var, x5.a aVar) {
        if (k6Var.C0 == null) {
            return;
        }
        if (!aVar.d()) {
            k6Var.Qb(false);
            return;
        }
        k6Var.C0.setPassList((List) aVar.c());
        if (k6Var.C0.getVisibility() == 0) {
            return;
        }
        k6Var.C0.setAlpha(0.0f);
        k6Var.C0.setVisibility(0);
        x.r.c(k6Var.C0).a(1.0f).d(150L).f();
    }

    public static /* synthetic */ String s5(k6 k6Var, Uri uri) throws IOException {
        k6Var.getClass();
        try {
            InputStream inputStreamI = z8.b1.i(k6Var.I(), uri);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamI);
                String strC = t5.z.c(bitmapDecodeStream);
                if (bitmapDecodeStream != null && !bitmapDecodeStream.isRecycled()) {
                    bitmapDecodeStream.recycle();
                }
                if (inputStreamI != null) {
                    inputStreamI.close();
                }
                return strC;
            } finally {
            }
        } catch (IOException e10) {
            pc.a.i(e10);
            return "";
        }
    }

    public static /* synthetic */ void t3(WeakReference weakReference, Integer num) {
        i8.k kVar = (i8.k) weakReference.get();
        if (kVar == null || !kVar.i1()) {
            return;
        }
        kVar.A3(num.intValue());
    }

    public static /* synthetic */ x5.a t4(String str) {
        v9.g gVarI = pa.r.i();
        return x5.a.f(!gVarI.j() ? gVarI.e(str) : null);
    }

    public static /* synthetic */ void t5(k6 k6Var) throws Resources.NotFoundException {
        if (k6Var.E1) {
            k6Var.f2600w0.setVisibility(0);
        }
        if (k6Var.F1) {
            k6Var.pb();
        }
        k6Var.G1 = false;
    }

    public static /* synthetic */ void u5(final k6 k6Var, Boolean bool) {
        k6Var.getClass();
        if (bool.booleanValue()) {
            g6.n.r(k6Var.l0(), x7.u.Cb, x7.u.Jh, new View.OnClickListener() { // from class: c8.p2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2759a.ka();
                }
            });
        }
    }

    public static /* synthetic */ void v3(k6 k6Var, View view) {
        String strS8 = k6Var.S8();
        if (strS8 == null || strS8.isEmpty()) {
            return;
        }
        z8.f1.k(k6Var.I(), strS8);
    }

    public static /* synthetic */ boolean v4(k6 k6Var, View view, DragEvent dragEvent) {
        k6Var.getClass();
        int action = dragEvent.getAction();
        if (action == 3) {
            x.r.c(view).a(1.0f).d(180L).f();
            return k6Var.W8(dragEvent.getClipData());
        }
        if (action != 4) {
            if (action == 5) {
                x.r.c(view).a(0.3f).d(100L).f();
                return true;
            }
            if (action != 6) {
                return true;
            }
        }
        x.r.c(view).a(1.0f).d(100L).f();
        return true;
    }

    public static /* synthetic */ j7.f v5(k6 k6Var, String str, String str2, String str3, int i10, String str4) {
        k6Var.getClass();
        b9.g.t3(str, new c9.z(str2, str3, str4), i10).h3(k6Var.z0(), null);
        return null;
    }

    public static /* synthetic */ void w3(k6 k6Var, Integer num) {
        k6Var.getClass();
        if (num.intValue() == 3) {
            k6Var.m8();
        } else {
            k6Var.B8();
        }
    }

    public static /* synthetic */ void w4(final k6 k6Var, final mark.via.download.e eVar, w.d dVar) {
        k6Var.getClass();
        int iIntValue = ((Integer) dVar.f13207a).intValue();
        if (iIntValue == 2) {
            g6.n.q(k6Var.I(), x7.u.R3);
            return;
        }
        if (iIntValue == 3) {
            g6.n.r(k6Var.I(), x7.u.dg, x7.u.X5, new View.OnClickListener() { // from class: c8.t2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2838a.za(eVar);
                }
            });
            return;
        }
        long j10 = k6Var.P0.j((g5.c) dVar.f13208b);
        if (j10 > 0) {
            mark.via.download.a.c(k6Var.I(), j10);
            g6.n.r(k6Var.I(), x7.u.f13919b4, x7.u.Jh, new View.OnClickListener() { // from class: c8.u2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2858a.ca();
                }
            });
        }
    }

    public static /* synthetic */ void w5(WeakReference weakReference, Integer num) {
        f8.w wVar = (f8.w) weakReference.get();
        if (wVar == null || !wVar.i1()) {
            return;
        }
        wVar.l3(num.intValue());
    }

    public static /* synthetic */ void x3(ua.y yVar, String str) {
        if ("null".equals(str)) {
            return;
        }
        if (str.length() >= 2) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        }
        yVar.p3(str);
    }

    public static /* synthetic */ void x4(k6 k6Var) {
        mark.via.common.widget.k1 k1Var = k6Var.f2577j1;
        if (k1Var == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) k1Var.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(k6Var.f2577j1);
        }
        k6Var.f2577j1 = null;
    }

    public static /* synthetic */ void x5(k6 k6Var, String str, Bundle bundle) {
        k6Var.getClass();
        k6Var.f2580m0.F1(bundle.getStringArray("tabs"), bundle.getString("selected"));
        k6Var.N0().x("restore_tabs");
    }

    public static /* synthetic */ void y3(k6 k6Var, String str, String str2, AdapterView adapterView, View view, int i10, long j10) {
        k6Var.getClass();
        switch ((int) j10) {
            case 1:
            case 2:
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                k6Var.f2580m0.i1(j10 == 1 ? i6.f0.f6991a.a(str, str2) : j10 == 2 ? i6.f0.f6991a.d(str, str2) : i6.f0.f6991a.c(str, str2), true);
                break;
            case 4:
                k6Var.f2580m0.a2();
                break;
            case 5:
                k6Var.Eb(null);
                break;
            case 6:
                k6Var.f2580m0.b2();
                break;
        }
    }

    public static /* synthetic */ void y4(k6 k6Var, int i10) {
        if (i10 < 0) {
            k6Var.getClass();
        } else if (i10 < k6Var.i()) {
            k6Var.s8((r4.a) k6Var.c().get(i10));
        }
    }

    public static /* synthetic */ void y5(k6 k6Var, FragmentManager fragmentManager, String str, Bundle bundle) {
        k6Var.getClass();
        String string = bundle.getString("text", null);
        if (string != null) {
            k6Var.f2582n0.k2(string);
            k6Var.T7();
        }
        fragmentManager.x("edit_text_result");
    }

    public static /* synthetic */ void z4(k6 k6Var, DialogInterface dialogInterface) {
        r4.a aVarD = k6Var.L0.d();
        if (aVarD != null) {
            aVarD.o();
        }
    }

    @Override // e8.n0.a
    public void A(int i10) {
        int i11 = i10 + 20;
        this.f2584o0.setProgress(i11);
        if (i11 >= 100) {
            this.f2602x0.s(false, u9.d.o(I(), S8()));
        } else {
            this.f2602x0.s(true, false);
        }
    }

    public final void A8() {
        w9.p pVarM2 = this.f2582n0.m2();
        pVarM2.V(true);
        this.f2582n0.g0(pVarM2);
        w9.n.e().u(true);
        this.f2598v0.j();
        g6.n.q(I(), x7.u.R6);
        this.f2580m0.l1();
        this.f2602x0.setIncognitoModeEnabled(true ^ this.f2580m0.W1(S8()));
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A9(final int i10, final int i11, final String str, final String str2, final String str3, boolean z10) {
        int[] iArrD1;
        ArrayList arrayList;
        boolean zV0;
        boolean zW0;
        this.f2579l1 = !TextUtils.isEmpty(str);
        final String strS8 = S8();
        final int iD = u9.d.d(I(), strS8);
        if (iD == 0 && str2 != null) {
            q8(str2);
            return;
        }
        if (O8() == null) {
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (iD == 1 && str != null && str.equals(strS8)) {
            return;
        }
        if (str2 != null && !str2.isEmpty() && iD == 13) {
            q8(str2);
            return;
        }
        if (iD == -1 && this.f2592s0 == null && this.f2590r0 == null) {
            Fb(i10, i11);
        }
        ArrayList arrayList2 = new ArrayList();
        if (!this.f2583n1 && URLUtil.isNetworkUrl(str)) {
            arrayList2.add(new k.l(0, Z0(x7.u.Q)));
            arrayList2.add(new k.l(1, Z0(x7.u.R)));
        }
        int size = 2;
        if (iD != -1) {
            if (iD != 1) {
                if (iD == 2) {
                    if (str != null && !str.isEmpty()) {
                        int size2 = arrayList2.size();
                        boolean zP = z8.w2.p(str);
                        if (str.charAt(str.length() - 1) != '=') {
                            arrayList2.add(new k.l(zP ? 12 : 9, Z0(x7.u.D)));
                            if (!zP) {
                                arrayList2.add(new k.l(10, Z0(x7.u.f13956e)));
                            }
                            arrayList2.add(new k.l(zP ? 13 : 11, Z0(x7.u.f14215x)));
                        }
                        size = arrayList2.size() - size2;
                    }
                } else if (iD == 3) {
                    arrayList2.add(new k.l(16, Z0(x7.u.f14215x)));
                    arrayList2.add(new k.l(17, Z0(x7.u.f14228y)));
                } else if (iD == 6) {
                    int size3 = arrayList2.size();
                    if (iD == 6 && this.f2580m0.b1(str)) {
                        zV0 = this.f2580m0.v0(str);
                        zW0 = this.f2580m0.w0(str);
                        if (!zV0 || zW0 || this.f2580m0.T1(str)) {
                            arrayList2.add(new k.l(!zV0 ? 25 : 24, Z0(!zV0 ? x7.u.f13999h0 : x7.u.f13998h)));
                            arrayList2.add(new k.l(!zW0 ? 27 : 26, Z0(!zW0 ? x7.u.f14013i0 : x7.u.f14012i)));
                        }
                    }
                    if (iD == 10) {
                        arrayList2.add(new k.l(19, Z0(x7.u.V)));
                    }
                    arrayList2.add(new k.l(20, Z0(x7.u.A)));
                    arrayList2.add(new k.l(21, Z0(x7.u.f14228y)));
                    size = arrayList2.size() - size3;
                } else if (iD != 7) {
                    if (iD != 10) {
                        if (iD == 11) {
                        }
                    }
                    int size32 = arrayList2.size();
                    if (iD == 6) {
                        zV0 = this.f2580m0.v0(str);
                        zW0 = this.f2580m0.w0(str);
                        if (!zV0) {
                            arrayList2.add(new k.l(!zV0 ? 25 : 24, Z0(!zV0 ? x7.u.f13999h0 : x7.u.f13998h)));
                            arrayList2.add(new k.l(!zW0 ? 27 : 26, Z0(!zW0 ? x7.u.f14013i0 : x7.u.f14012i)));
                        }
                    }
                    if (iD == 10) {
                    }
                    arrayList2.add(new k.l(20, Z0(x7.u.A)));
                    arrayList2.add(new k.l(21, Z0(x7.u.f14228y)));
                    size = arrayList2.size() - size32;
                } else {
                    arrayList2.add(new k.l(18, Z0(x7.u.f14215x)));
                    size = 1;
                }
            } else if (str2 == null) {
                arrayList2.add(new k.l(32, Z0(x7.u.Uc)));
                arrayList2.add(new k.l(14, Z0(x7.u.D)));
                arrayList2.add(new k.l(15, Z0(x7.u.f14215x)));
                size = 3;
            }
            if (!TextUtils.isEmpty(str) && !z8.w2.t(str) && !z8.w2.z(str) && !i6.i0.f7006a.l(str)) {
                arrayList2.add(new k.l(3, Z0(x7.u.f14150s)));
                arrayList2.add(new k.l(31, Z0(x7.u.f13943d0)));
            }
            iArrD1 = this.f2582n0.D1();
            if (iArrD1.length > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                    if (g6.a.b(iArrD1, ((k.l) arrayList2.get(size4)).a())) {
                        arrayList3.add(0, (k.l) arrayList2.remove(size4));
                    }
                    if (arrayList3.size() == iArrD1.length) {
                        break;
                    }
                }
                if (z10) {
                    if (!arrayList3.isEmpty()) {
                        arrayList3.add(new k.l(37, Z0(x7.u.R2)));
                    }
                    arrayList2 = arrayList3;
                } else if (!arrayList3.isEmpty()) {
                    arrayList2.add(new k.l(36, Z0(x7.u.f14211w8)));
                } else if (arrayList2.size() > size) {
                    arrayList2.add(new k.l(37, Z0(x7.u.R2)));
                }
            } else if (arrayList2.size() > size) {
                arrayList2.add(new k.l(37, Z0(x7.u.R2)));
            }
            arrayList = arrayList2;
            if (arrayList.isEmpty()) {
                return;
            }
            w5.k.l(I()).C(arrayList, new AdapterView.OnItemClickListener() { // from class: c8.j0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) throws UnsupportedEncodingException {
                    k6.Q3(this.f2525a, str, str2, iD, i10, i11, strS8, str3, adapterView, view, i12, j10);
                }
            }).U(new DialogInterface.OnDismissListener() { // from class: c8.k0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    k6.z4(this.f2555e, dialogInterface);
                }
            }).g0(i10, i11);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            i6.i0 i0Var = i6.i0.f7006a;
            boolean z11 = i0Var.s(str2) || i0Var.k(str2) || i0Var.l(str2);
            if (!TextUtils.isEmpty(str2)) {
                arrayList2.add(new k.l(2, Z0(x7.u.f14041k0)));
                arrayList2.add(new k.l(38, Z0(x7.u.B)));
                arrayList2.add(new k.l(6, Z0(x7.u.f13901a0)));
                if (z11) {
                    arrayList2.add(new k.l(33, Z0(x7.u.wc)));
                }
                if (URLUtil.isNetworkUrl(str2)) {
                    arrayList2.add(new k.l(7, Z0(x7.u.Rb)));
                }
                if (i6.i0.f7006a.s(strS8) && this.f2580m0.e1(strS8)) {
                    arrayList2.add(new k.l(8, Z0(x7.u.U)));
                }
            }
            arrayList2.add(new k.l(22, Z0(x7.u.S)));
            if (i6.i0.f7006a.s(strS8) && this.f2580m0.b1(strS8) && this.f2580m0.e1(strS8)) {
                arrayList2.add(new k.l(23, Z0(x7.u.L)));
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(new k.l(29, Z0(x7.u.f14176u)));
            }
            if (z11) {
                arrayList2.add(new k.l(34, Z0(x7.u.Db)));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList2.add(new k.l(3, Z0(x7.u.f14150s)));
            arrayList2.add(new k.l(31, Z0(x7.u.f13943d0)));
        }
        iArrD1 = this.f2582n0.D1();
        if (iArrD1.length > 0) {
        }
        arrayList = arrayList2;
        if (arrayList.isEmpty()) {
        }
        size = 0;
        if (!TextUtils.isEmpty(str)) {
        }
        iArrD1 = this.f2582n0.D1();
        if (iArrD1.length > 0) {
        }
        arrayList = arrayList2;
        if (arrayList.isEmpty()) {
        }
    }

    public final void Aa() {
        if (Build.VERSION.SDK_INT < 21 || this.X0 != 1) {
            return;
        }
        x.r.U(this.f2606z0);
    }

    public final void Ab() {
        w5.k.l(I()).d0(x7.u.V1).J(z8.b0.t(I(), L8())).V(R.string.ok, null).f0();
    }

    @Override // e8.j.a
    public void B(final boolean z10) {
        if (!this.f2568a1 || z10 == this.J1) {
            return;
        }
        this.J1 = z10;
        this.f2602x0.post(new Runnable() { // from class: c8.d5
            @Override // java.lang.Runnable
            public final void run() {
                this.f2399e.f2602x0.t(!z10, true);
            }
        });
    }

    public final void B8() {
        i6.e eVarT8 = T8();
        if (eVarT8 == null) {
            return;
        }
        if (r9.g.a().c(eVarT8.getUrl())) {
            g6.n.q(I(), x7.u.O1);
        } else {
            i6.c0.f6985a.j(eVarT8, new q7.l() { // from class: c8.p4
                @Override // q7.l
                public final Object invoke(Object obj) {
                    return k6.R4(this.f2761e, (Integer) obj);
                }
            });
        }
    }

    public final String B9(String str) {
        return "android.webkit.resource.AUDIO_CAPTURE".equals(str) ? a1(x7.u.f14161sa, Z0(x7.u.f14135qa), Z0(x7.u.f14148ra)) : "android.webkit.resource.VIDEO_CAPTURE".equals(str) ? a1(x7.u.f14161sa, Z0(x7.u.f14107oa), Z0(x7.u.f14121pa)) : str;
    }

    public final void Ba(String[] strArr, z0.a aVar) {
        if (strArr == null || strArr.length == 0) {
            aVar.a(new String[0], false);
            return;
        }
        String[] strArr2 = new String[strArr.length];
        int i10 = 0;
        for (String str : strArr) {
            if (!g6.f.g(I(), str)) {
                strArr2[i10] = str;
                i10++;
            }
        }
        String[] strArr3 = (String[]) Arrays.copyOf(strArr2, i10);
        if (strArr3.length == 0) {
            aVar.a(strArr, false);
            return;
        }
        this.M1 = aVar;
        this.N1 = strArr;
        try {
            this.O1.a(strArr3);
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    public final void Bb() {
        String strS8 = S8();
        String strR8 = R8(strS8);
        i6.i0 i0Var = i6.i0.f7006a;
        boolean zS = i0Var.s(strS8);
        if (!zS && strS8 != null && strS8.length() > 0) {
            int length = strS8.length();
            strS8 = z8.w2.f(strS8);
            if (length != strS8.length()) {
                strR8 = i0Var.f(strS8);
            }
        }
        int i10 = ((!zS || L8() == null) ? 0 : 1) | (zS && this.f2580m0.X0(strS8) ? 2 : 0);
        int i11 = this.W0;
        z0().q().c(x7.p.C, f8.w.class, f8.d.f().g(((i11 == 2 || i11 == 3) ? 80 : 48) | 8388611).j(N8()).i(this.V0 && b9()).e("title", strR8).e("url", strS8).d("flag", i10).a(), null).g(null).i();
        zb();
        e9();
    }

    @Override // e8.i.a
    public void C(n4.a aVar, String str) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iA = aVar.a();
        if (iA == e8.i.f4823f) {
            if (u(str)) {
                return;
            }
            Ua(str, false, true);
        } else if (iA == e8.i.f4824g) {
            O8().k();
            ob(str);
        } else if (iA == e8.i.f4826i) {
            Eb(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        pc.a.a("BrowserFragment::onCreateView", new Object[0]);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        y7 y7Var = new y7(I());
        y7Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f2584o0 = y7Var;
        pc.a.a("BrowserFragment::onCreateView, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return y7Var;
    }

    public final void C8() {
        this.f2580m0.N1();
        if (this.f2582n0.v().k() && this.f2582n0.m2().s() && (!u9.d.o(I(), S8()) || i() > 1)) {
            w5.k.l(I()).d0(x7.u.N4).I(x7.u.O4).w(x7.u.L3, false).V(x7.u.N4, new k.m() { // from class: c8.y4
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    k6.D4(this.f2929a, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
        } else {
            l0().finish();
        }
    }

    public final void C9() {
        r4.a aVarN;
        if (SystemClock.elapsedRealtime() - this.V1 < 300) {
            return;
        }
        this.V1 = SystemClock.elapsedRealtime();
        if (!i1() || d9()) {
            return;
        }
        r4.a aVarD = d();
        if (aVarD != null) {
            i6.i0 i0Var = i6.i0.f7006a;
            String url = aVarD.getUrl();
            if (i0Var.s(url)) {
                if (!this.f2580m0.e1(url)) {
                    g6.n.q(I(), x7.u.N1);
                    return;
                }
                if (r9.g.a().n(url)) {
                    g6.n.q(I(), x7.u.O1);
                    return;
                }
                int i10 = this.f2574g1;
                this.f2574g1 = aVarD.getId();
                i6.b bVar = i6.b.f6981a;
                bVar.g(T8(), this.f2573f1);
                sb();
                if (i10 == aVarD.getId() || (aVarN = this.L0.n(i10)) == null) {
                    return;
                }
                bVar.a(new i6.e(aVarN.p()));
                return;
            }
        }
        g6.n.q(I(), x7.u.M1);
    }

    public final void Ca(final String str, final String[] strArr, final z0.a aVar) {
        if (strArr == null || strArr.length == 0) {
            aVar.a(new String[0], false);
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArr) {
            if (sb2.length() > 0) {
                sb2.append("\n");
            }
            sb2.append(a1(x7.u.C7, B9(str2)));
        }
        l0().runOnUiThread(new Runnable() { // from class: c8.h0
            @Override // java.lang.Runnable
            public final void run() {
                k6 k6Var = this.f2472e;
                String str3 = str;
                StringBuilder sb3 = sb2;
                z0.a aVar2 = aVar;
                w5.k.l(k6Var.I()).e0(k6Var.a1(x7.u.f13965e8, g6.p.n(str3, k6Var.Z0(x7.u.Vg)))).J(sb3.toString()).w(x7.u.Ta, false).V(x7.u.f13970f, new k.m() { // from class: c8.v1
                    @Override // w5.k.m
                    public final void a(View view, k.p pVar) {
                        aVar2.a(strArr, pVar.f13338b);
                    }
                }).P(x7.u.f14241z, new k.m() { // from class: c8.w1
                    @Override // w5.k.m
                    public final void a(View view, k.p pVar) {
                        aVar2.a(new String[0], pVar.f13338b);
                    }
                }).T(new DialogInterface.OnCancelListener() { // from class: c8.x1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        aVar2.a(new String[0], false);
                    }
                }).f0();
            }
        });
    }

    public final void Cb() {
        z0().q().c(x7.p.C, f8.l0.class, f8.d.f().g((this.W0 == 1 ? 48 : 80) | 8388613).j(N8()).i(this.V0 && b9()).d("max_height", this.f2584o0.f2937m.getHeight() - g6.y.h(I(), 16.0f)).a(), null).g(null).i();
        zb();
        e9();
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        if (this.I1 != null && this.f2576i1 != null) {
            j8.e.d(I());
        }
        this.M0.b(I());
        I().unregisterReceiver(this.D0);
        this.R1.c();
        this.O1.c();
        super.D1();
    }

    public final void D8(v9.f fVar) {
        t4.b bVarO8 = O8();
        if (bVarO8 == null) {
            return;
        }
        this.f2607z1.a(Z0(x7.u.f14247z5), Z0(x7.u.Zg), new d(I(), fVar, new WeakReference(bVarO8)));
    }

    public final void D9() {
        Lb();
        int i10 = this.L0.i();
        if (i10 == 0) {
            return;
        }
        this.f2598v0.setTabSize(i10);
    }

    public final void Da() {
        w5.k.l(I()).d0(x7.u.Pf).I(x7.u.T7).V(x7.u.f14054l, new k.m() { // from class: c8.a4
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                k6.o5(this.f2327a, view, pVar);
            }
        }).N(x7.u.J, null).f0();
    }

    public final void Db(boolean z10) {
        final String strS8 = S8();
        if (!URLUtil.isNetworkUrl(strS8)) {
            g6.n.q(I(), x7.u.M1);
            return;
        }
        final String strG = z8.t1.g();
        boolean z11 = z8.c0.f() || z8.f.h();
        ArrayList arrayList = new ArrayList();
        if (z11) {
            if (z10) {
                arrayList.add(new k.l(6, Z0(x7.u.Ng)));
            }
            arrayList.add(new k.l(1, Z0(x7.u.Jg)));
        }
        if (z10) {
            arrayList.add(new k.l(4, Z0(x7.u.Lg)));
        }
        arrayList.add(new k.l(3, Z0(x7.u.Kg)));
        arrayList.add(new k.l(5, Z0(x7.u.Mg)));
        w5.k.l(I()).d0(x7.u.f13985g0).C(arrayList, new AdapterView.OnItemClickListener() { // from class: c8.z0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                k6.y3(this.f2953a, strS8, strG, adapterView, view, i10, j10);
            }
        }).f0();
    }

    @Override // e8.i.a
    public boolean E(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        if (this.f2603x1 == null) {
            this.f2603x1 = new GestureTouchEvent(this.f2584o0.f2940p, f8());
        }
        this.f2603x1.g(view, motionEvent);
        if (!this.f2578k1) {
            this.N0.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void E8(boolean z10) {
        t4.b bVarO8 = O8();
        if (bVarO8 == null) {
            return;
        }
        bVarO8.findNext(z10);
    }

    public final void E9(i8.k kVar) {
        final WeakReference weakReference = new WeakReference(kVar);
        d8(new k8.o() { // from class: c8.i5
            @Override // k8.o
            public final void a(Object obj) {
                k6.t3(weakReference, (Integer) obj);
            }
        });
    }

    public final void Ea(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        i6.i0 i0Var = i6.i0.f7006a;
        if (i0Var.k(str)) {
            r8(null, str, i10);
            return;
        }
        if (i0Var.l(str)) {
            X8(str, new File(Uri.parse(str).getPath()), i10);
            return;
        }
        String str2 = (String) this.S0.get(str);
        if (str2 != null && !str2.isEmpty()) {
            File file = new File(str2);
            if (file.isFile() && file.lastModified() >= System.currentTimeMillis() - 86400000) {
                X8(str, file, i10);
                return;
            }
        }
        t4.b bVarO8 = O8();
        if (bVarO8 == null) {
            return;
        }
        if (this.f2580m0.e1(bVarO8.getUrl())) {
            this.R0.a(str, i10);
            s4.b.g(bVarO8, "javascript:(function(){var a=new XMLHttpRequest;a.open(\"GET\",\"__URL__\",!0);a.responseType=\"blob\";a.onload=function(){if(200===a.status){var b=new FileReader;b.onloadend=function(){window.via.download(\"__SECRET__\",\"__URL__\",b.result)};b.readAsDataURL(a.response)}else window.via.download(\"__SECRET__\",\"__URL__\",\"\")};a.onerror=function(){window.via.download(\"__SECRET__\",\"__URL__\",\"\")};a.send()})();".replace("__URL__", str).replace("__SECRET__", this.f2573f1));
        } else {
            r8(str, null, i10);
        }
        g6.n.q(I(), x7.u.Nh);
    }

    public final void Eb(String str) {
        EditText editText = (EditText) this.f2584o0.f2937m.findViewById(x7.p.f13825n);
        if (editText == null) {
            z0().q().c(x7.p.C, f8.w0.class, f8.d.f().g((this.W0 == 1 ? 48 : 80) | 8388613).j(N8()).i(this.V0 && b9()).e("text", str).a(), f8.w0.class.getSimpleName()).g(null).i();
            e9();
        } else {
            editText.setText(str);
            View viewFindViewById = this.f2584o0.f2937m.findViewById(x7.p.f13817k0);
            if (viewFindViewById != null) {
                viewFindViewById.performClick();
            }
        }
    }

    @Override // e8.n0.a
    public void F(String str) {
        int iIndexOf;
        String strF = z8.w2.f(str);
        Mb(strF);
        this.f2602x0.u(URLUtil.isHttpsUrl(strF), !this.f2580m0.W1(strF));
        int iG1 = this.f2582n0.g1();
        if (this.f2569b1 && iG1 == 0) {
            iG1 = 2;
        }
        Rb(strF);
        com.tuyafeng.support.widget.z zVar = this.W1;
        if (zVar != null) {
            zVar.setTitle(i6.i0.f7006a.f(strF));
        }
        if (iG1 == 0 || TextUtils.isEmpty(strF) || u9.d.m(I(), strF)) {
            return;
        }
        String strE = z8.b0.E(strF);
        if (iG1 == 2) {
            String strF2 = i6.i0.f7006a.f(strE);
            if (strF2 != null && !strF2.isEmpty()) {
                strE = strF2;
            }
        } else if (URLUtil.isNetworkUrl(strE) && (iIndexOf = (strE = strE.substring(strE.indexOf("://") + 3)).indexOf(47)) == strE.length() - 1) {
            strE = strE.substring(0, iIndexOf);
        }
        this.f2602x0.setTitle(strE);
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() throws Resources.NotFoundException {
        j8.d dVar;
        Ha();
        j8.q qVar = this.I1;
        if (qVar != null && (dVar = this.f2575h1) != null) {
            qVar.d(dVar);
        }
        this.f2586p0.removeAllViews();
        this.L0.h();
        this.f2580m0.o1();
        super.F1();
    }

    public final void F8(String str) {
        t4.b bVarO8 = O8();
        if (bVarO8 == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (str.isEmpty()) {
            bVarO8.setFindListener(null);
            Za(-1, 0, true);
        } else {
            bVarO8.setFindListener(new WebView.FindListener() { // from class: c8.j6
                @Override // android.webkit.WebView.FindListener
                public final void onFindResultReceived(int i10, int i11, boolean z10) {
                    this.f2542a.Za(i10, i11, z10);
                }
            });
        }
        bVarO8.findAllAsync(str);
    }

    public final void F9(mark.via.download.m mVar) {
        mVar.s3(new m.a() { // from class: c8.v4
            @Override // mark.via.download.m.a
            public final void a(mark.via.download.e eVar) {
                this.f2881a.o8(eVar);
            }
        });
    }

    public final void Fa() {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT < 30 || this.X0 != 1 || this.f2595t1 || (viewGroup = this.f2606z0) == null) {
            return;
        }
        this.f2595t1 = true;
        viewGroup.postOnAnimation(new Runnable() { // from class: c8.j3
            @Override // java.lang.Runnable
            public final void run() {
                k6.d3(this.f2538e);
            }
        });
    }

    public final void Fb(int i10, int i11) {
        t4.b bVarO8 = O8();
        if (bVarO8 == null || bVarO8.getWidth() <= 0 || bVarO8.getHeight() <= 0) {
            return;
        }
        bVarO8.getLocationOnScreen(new int[2]);
        s4.b.g(bVarO8, sa.a(A0(), (i10 - r1[0]) / bVarO8.getWidth(), (i11 - r1[1]) / bVarO8.getHeight()));
    }

    @Override // r4.f
    public void G(int i10, int i11, int i12) {
        mark.via.common.widget.t tVar = this.A0;
        if (tVar == null) {
            return;
        }
        tVar.v(i10, i11);
        this.A0.x(i12);
    }

    @Override // androidx.fragment.app.Fragment
    public void G1() {
        I().unregisterComponentCallbacks(this);
        super.G1();
    }

    public final void G8(boolean z10) throws Resources.NotFoundException {
        db(z10 ? 0.0f : 1.0f);
        if (z10) {
            this.f2604y0.setVisibility(0);
            this.f2600w0.setVisibility(0);
        } else {
            this.f2604y0.setVisibility(8);
            this.f2600w0.setVisibility(8);
            this.f2588q0.setTranslationY(0.0f);
            this.f2584o0.f2937m.setTranslationY(0.0f);
            mark.via.common.widget.m mVar = this.B0;
            if (mVar != null) {
                mVar.setTranslationY(0.0f);
            }
            mark.via.common.widget.f fVar = this.C0;
            if (fVar != null) {
                fVar.setTranslationY(0.0f);
            }
        }
        this.f2589q1 = z10;
        if (z10) {
            e9();
        } else {
            pb();
        }
    }

    public final void G9(qa.e1 e1Var) {
        this.f2584o0.setBlurEnabled(true);
        this.f2584o0.setDescendantFocusability(393216);
        this.f2584o0.clearFocus();
        e1Var.k0().a(new androidx.lifecycle.f() { // from class: c8.o4
            @Override // androidx.lifecycle.f
            public final void a(androidx.lifecycle.h hVar, Lifecycle.Event event) {
                k6.m4(this.f2732e, hVar, event);
            }
        });
    }

    public final void Ga() throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(T0().getDimensionPixelSize(x7.n.f13689h), T0().getDimensionPixelSize(x7.n.f13689h));
        int dimensionPixelSize = T0().getDimensionPixelSize(x7.n.f13688g);
        int iS = this.f2582n0.S();
        if ((iS & 3) == 3) {
            layoutParams.addRule(9, -1);
        } else {
            if ((iS & 5) != 5) {
                layoutParams.addRule(14, -1);
                layoutParams.addRule(12, -1);
                layoutParams.topMargin = dimensionPixelSize;
                layoutParams.bottomMargin = dimensionPixelSize;
                layoutParams.leftMargin = dimensionPixelSize;
                layoutParams.rightMargin = dimensionPixelSize;
                this.f2594t0.setLayoutParams(layoutParams);
            }
            layoutParams.addRule(11, -1);
        }
        if ((iS & 80) == 80) {
            layoutParams.addRule(12, -1);
        } else {
            layoutParams.addRule(15, -1);
        }
        layoutParams.topMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        this.f2594t0.setLayoutParams(layoutParams);
    }

    public final void Gb() {
        r4.a aVarD = this.L0.d();
        if (d9() || aVarD == null) {
            return;
        }
        if (aVarD.q()) {
            aVarD.s();
        } else {
            A(100);
        }
    }

    @Override // r4.f
    public void H(int i10) {
        D9();
        mark.via.common.widget.t tVar = this.A0;
        if (tVar == null) {
            return;
        }
        tVar.w(i10);
    }

    public final void H9(f8.h hVar) {
        hVar.g3(new l());
    }

    public final void Ha() throws Resources.NotFoundException {
        GestureTouchEvent gestureTouchEvent = this.f2603x1;
        if (gestureTouchEvent != null) {
            gestureTouchEvent.i();
        }
        X7();
        Y7();
        G8(this.f2589q1);
    }

    public final void Hb(boolean z10) throws Resources.NotFoundException {
        String str;
        w9.n.e().p(true);
        l0().setTheme(z10 ? x7.v.f14254a : x7.v.f14255b);
        d9();
        this.U0 = g6.y.H(this.U0);
        if (u9.d.m(I(), S8())) {
            Nb(0, false);
        } else {
            Nb(g6.e.a(I(), x7.k.f13656b), false);
        }
        Tb(this.W0);
        int i10 = g6.y.C(this.f2582n0.c0()) ? 128 : 64;
        if (!z10) {
            i10 = 0;
        }
        this.f2584o0.setWindowFilterColor(Color.argb(Math.max(i10, (int) ((this.f2582n0.M2().b() / 100.0f) * 255.0f)), 0, 0, 0));
        this.f2580m0.w1();
        this.f2580m0.n1(false, true);
        j8.q qVar = this.I1;
        if (qVar != null && (str = this.f2576i1) != null) {
            xb(qVar.f(str), true);
        }
        if (this.C0 != null) {
            fb(false);
            fb(true);
        }
        this.f2584o0.setNightModeEnabled(z10);
        if (this.f2582n0.Z()) {
            return;
        }
        FrameLayout frameLayout = this.f2586p0;
        frameLayout.dispatchConfigurationChanged(frameLayout.getResources().getConfiguration());
    }

    @Override // androidx.fragment.app.Fragment
    public void I1(boolean z10) throws Resources.NotFoundException {
        super.I1(z10);
        if (!z10) {
            Ia();
            T1();
            return;
        }
        Na();
        int iA = x8.h.a(I());
        z8.l3.r(I(), iA);
        z8.l3.q(I(), iA);
        O1();
    }

    public final void I8(View view, x.k0 k0Var, boolean z10) {
        if (!z8.l3.f14720a || k0Var == null || view == null) {
            return;
        }
        if (!z10) {
            view.setPadding(0, 0, 0, 0);
            return;
        }
        r.f fVarG = k0Var.g(k0.m.f() | k0.m.b() | k0.m.a());
        view.setPadding(fVarG.f11465a, fVarG.f11466b, fVarG.f11467c, fVarG.f11468d);
    }

    public void I9() throws Resources.NotFoundException {
        if (!w9()) {
            N0().e1();
            return;
        }
        if (d9()) {
            return;
        }
        if (this.f2592s0 != null || this.f2590r0 != null) {
            V();
            return;
        }
        if (this.f2578k1) {
            if (SystemClock.elapsedRealtime() - this.T0 > 1500) {
                g6.n.q(I(), x7.u.R5);
                this.T0 = SystemClock.elapsedRealtime();
                return;
            } else {
                this.T0 = 0L;
                bb(false);
                return;
            }
        }
        if (this.f2583n1) {
            r4.a aVarD = this.L0.d();
            if (aVarD != null && aVarD.j()) {
                aVarD.g();
                return;
            } else if (i() > 1) {
                this.f2580m0.B0();
                return;
            } else {
                l0().finish();
                return;
            }
        }
        if (!u9.d.o(I(), S8())) {
            U8();
            return;
        }
        if (this.L0.i() > 1) {
            this.f2580m0.B0();
        } else if (SystemClock.elapsedRealtime() - this.T0 <= 1500) {
            C8();
        } else {
            g6.n.s(I(), T0().getString(x7.u.Z7));
            this.T0 = SystemClock.elapsedRealtime();
        }
    }

    public final void Ia() {
        if (Build.VERSION.SDK_INT >= 21 && this.f2599v1 == this.U0) {
            z8.l3.k(I(), this.f2601w1);
        }
    }

    public final void Ib() throws Resources.NotFoundException {
        boolean zD = this.f2582n0.d();
        pc.a.a("current night mode: %s", Boolean.valueOf(zD));
        if (!q1()) {
            Hb(zD);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2606z0, "alpha", 0.2f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        Hb(zD);
        objectAnimatorOfFloat.start();
    }

    public final void J8(int i10, int i11) {
        String strC;
        t4.b bVarO8 = O8();
        if (bVarO8 == null || (strC = sa.c(A0())) == null) {
            return;
        }
        int[] iArr = new int[2];
        bVarO8.getLocationOnScreen(iArr);
        int i12 = i10 - iArr[0];
        int i13 = i11 - iArr[1];
        s4.b.g(bVarO8, strC.replace("__X__", String.valueOf(i12)).replace("__Y__", String.valueOf(i13)).replace("__WW__", String.valueOf(bVarO8.getWidth())).replace("__WH__", String.valueOf(bVarO8.getHeight())));
        this.N0.setIsLongpressEnabled(false);
        g6.y.Y(bVarO8, i12, i13);
        bVarO8.postDelayed(new Runnable() { // from class: c8.y2
            @Override // java.lang.Runnable
            public final void run() {
                this.f2927e.N0.setIsLongpressEnabled(true);
            }
        }, 1000L);
    }

    public final boolean J9() throws Resources.NotFoundException {
        if (!this.f2582n0.y2()) {
            return false;
        }
        ra(18);
        return true;
    }

    public boolean Ja(WebView webView, int i10) {
        String url;
        if (webView != null && webView.getSettings().getJavaScriptEnabled() && (url = webView.getUrl()) != null && !url.isEmpty()) {
            i6.i0 i0Var = i6.i0.f7006a;
            if (!i0Var.l(url)) {
                String strF = i0Var.f(url);
                if (!TextUtils.isEmpty(strF)) {
                    if (i10 == 4) {
                        i6.b.f6981a.d(new i6.e(webView), this.f2573f1);
                        b8();
                        return !this.f2582n0.m2().D() || !this.f2582n0.m2().D() || r9.g.a().e(url) || this.Q0.b(webView, url, 4);
                    }
                    if (i10 == 1) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.f2580m0.b1(url) && i0Var.s(url)) {
                            sb2.append(m8.b.b(strF));
                            s4.b.g(webView, this.f2580m0.I0(strF));
                        }
                        if (!"music.163.com".equals(strF) && !"taobao.com".equals(strF) && this.f2580m0.d1(url)) {
                            sb2.append(kc.a(A0(), 1280));
                        } else if (this.f2582n0.m2().n()) {
                            sb2.append(kc.b(A0()));
                        }
                        int iJ0 = this.f2580m0.J0(url);
                        if (iJ0 == 2) {
                            sb2.append(ra.b(A0()));
                        } else if (iJ0 != 3) {
                            sb2.append(ra.c(A0()));
                        } else {
                            sb2.append(ra.a(A0()));
                        }
                        if (this.f2582n0.B1() && this.f2582n0.d()) {
                            sb2.append("(function(){if(!document.getElementById('via_inject_css_night')){var css=document.createElement('style');css.id='via_inject_css_night';css.type='text/css';css.rel=\"stylesheet\";var textNode=document.createTextNode('html{background-color:#000!important}*{color:#999!important;box-shadow:none!important;background-color:transparent!important;border-color:#444!important;border-top-color:#444!important;border-bottom-color:#444!important;border-left-color:#444!important;border-right-color:#444!important}body{background-color:transparent!important}:after,:before{background-color:transparent!important;border-color:#444!important}a,a *{color:#409B9B!important;text-decoration:none!important}.link:hover,.link:hover *,[role=button]:hover *,[role=link]:hover,[role=link]:hover *,[role=menuitem]:hover,[role=menuitem]:hover *,a:hover,a:hover *,a:visited:hover,a:visited:hover *,div[onclick]:hover,span[onclick]:hover{color:#F0F0F0!important}a:visited,a:visited *{color:#607069!important}.selected,.selected *,[href=\"#\"],a.active,a.active *,a.highlight,a.highlight *{color:#DDD!important;font-weight:700!important}[class*=header],[class*=header] td,[class*=headline],[id*=header],[id*=headline],h1,h1 *,h2,h2 *,h3,h3 *,h4,h5,h6,strong{color:#DDD!important}[class*=alert],[class*=error],code,div[onclick],span[onclick]{color:#900!important}::-moz-selection{background-color:#377!important;color:#000!important}::selection{background-color:#377!important;color:#000!important}:focus{outline:0!important}div[role=navigation],div[style=\"display: block;\"]{background-color:rgba(0,0,0,.5)!important}table{background-color:rgba(40,30,30,.6)!important;border-radius:6px!important}table>tbody>tr:nth-child(even),table>tbody>tr>td:nth-child(even){background-color:rgba(0,0,0,.2)!important}#ghostery-purple-bubble,#translator-popup,.hovercard,.menu,.tooltip,.vbmenu_popup,[class*=dropdown],[class*=nav] ul,[class*=popup],[class=title],[id*=Menu],[id*=menu],[id*=nav] ul,a[id*=ghosteryfirefox],a[onclick][style*=display],div[role=dialog],div[role=menu],div[style*=\"position:\"][style*=\"left:\"][style*=visible],div[style*=\"z-index:\"][style*=\"left:\"][style*=visible],div[style*=\"-moz-user-select\"],embed,iframe,label [onclick],nav,nav ul,span[class*=script] div,ul[class*=menu],ul[style*=\"display:\"],ul[style*=\"visibility:\"] ul{background-color:rgba(5,5,5,.9)!important;border-radius:5px;box-shadow:1px 1px 5px #000!important}#footer,#header,footer,header{background-color:rgba(19,19,19,.9)!important;box-shadow:0 0 5px #000!important}body>#dialog,body>.xenOverlay{background-color:rgba(19,19,19,.96)!important;background-clip:padding-box!important;box-shadow:0 0 15px #000,inset 0 0 0 1px rgba(200,200,200,.5),inset 0 0 5px #111!important}[id*=lightbox],[id*=overlay],blockquote{background-color:rgba(35,35,35,.9)!important;border-radius:5px}.Message code,dl,pre{background-color:rgba(5,5,5,.5)!important}.install[onclick],[role=button],a.BigButton,a.TabLink,a.button,a.submit,button,input,select{-moz-appearance:none!important;-webkit-appearance:none!important;transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty),a[href=\"javascript:;\"],a[id*=Button]:not(:empty),a[id*=button]:not(:empty),div[class*=button][onclick]{transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;border-color:#333!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty):hover,a[href=\"javascript:;\"]:hover,a[id*=Button]:not(:empty):hover,a[id*=button]:hover,div[class*=button][onclick]:hover{background-color:#151515!important;color:#FFF!important}a.button *,a.submit *,button *,input *,select *{color:#BBB!important}[role=button]:hover,a.BigButton:hover,a.TabLink:hover,a.button:hover,a.submit:hover,button:hover,input:hover,input[type=button]:hover,select:hover{border-top-color:#555!important;border-bottom-color:#555!important;border-left-color:#555!important;border-right-color:#555!important}input:focus,select:focus{box-shadow:0 0 5px #077!important}input :hover *{color:#F0F0F0!important}button[disabled],button[disabled]:focus,button[disabled]:hover,input[disabled],input[disabled]:focus,input[disabled]:hover,select[disabled],select[disabled]:focus,select[disabled]:hover{opacity:.5!important;border-color:#333!important}input[type=checkbox]{border-radius:1px!important}input[type=radio],input[type=radio]:focus{border-radius:100%!important}input[type=checkbox],input[type=radio]{min-width:12px;min-height:12px}input[type=checkbox]:checked,input[type=radio]:checked{border-color:#077!important;box-shadow:0 0 5px #077!important}select{padding-right:15px!important;background-color:#060606!important;transition:border-color .3s,background-position .3s!important}.Active .TabLink,a.BigButton:active,a.TabLink:active,a.button:active,a.submit:active,a[class*=button]:not(:empty):active,button:active,input[type=button]:active,input[type=submit]:active{background-color:#292929!important;color:#FFF!important}textarea{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:rgba(0,0,0,.3)!important;border-radius:3px!important;box-shadow:inset 0 0 8px #000!important;transition:border-color,background,.3s!important}textarea,textarea *{color:#C8C8C8!important}textarea:focus:hover,textarea:hover{border-color:#333!important}textarea:focus{background-color:rgba(0,0,0,.5)!important;border-color:#222!important}textarea:focus,textarea:focus>*{box-shadow:none!important}optgroup,option{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:0 0!important;color:#666!important}optgroup{background-color:#222!important;color:#DDD!important}option:checked,option:focus,option:not([disabled]):hover{background-color:linear-gradient(#333,#292929)!important;color:#DDD!important}img{opacity:.7!important;transition:opacity .2s}#mpiv-popup,a:hover img,img:hover{opacity:1!important}.read-whole-mask .exp-mask,.se-head-tabcover,.wgt-exp-content .exp-img-mask{background-image:none!important}.s_card{background:0 0!important}');css.appendChild(textNode);var o=document.getElementsByTagName(\"head\");if(o.length>0&&o[0].appendChild(css)){}};})();");
                            final WeakReference weakReference = new WeakReference(webView);
                            webView.postDelayed(new Runnable() { // from class: c8.g5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    k6.S5(weakReference);
                                }
                            }, 300L);
                        }
                        sb2.append(sa.b(A0(), this.f2573f1));
                        sb2.append(c8.a.b(A0()));
                        sb2.append("(function(){var n=\"via-fake-print\";if(!window[n])try{window[n]=!0;var i=window.print;\"function\"==typeof i&&/\\{\\s*\\[native code\\]\\s*\\}/.test(Function.prototype.toString.call(i))&&(window.print=function(){window.via.cmd(516)})}catch(n){}})();");
                        sb2.append("(function(){if(!window[\"via-fake-notification\"])try{window[\"via-fake-notification\"]=!0,window.Notification=function(a,b){},window.Notification.permission=\"denied\",window.Notification.requestPermission=function(a){\"function\"===typeof a&&a(\"denied\");return Promise.resolve(\"denied\")}}catch(a){}})();");
                        if (!this.f2582n0.m2().E()) {
                            sb2.append("(function(){if(!window[\"via-fake-vibrate\"])try{window[\"via-fake-vibrate\"]=!0;var b=function(a){return!0}.bind(window);window.navigator.vibrate=b}catch(a){}})();");
                        }
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 >= 21 && i11 < 28) {
                            sb2.append(i6.q.f7045a.a());
                        }
                        sb2.append(fb.b(I(), this.f2573f1));
                        String strA1 = this.f2582n0.a1();
                        if (strA1 != null && !strA1.isEmpty()) {
                            sb2.append(ta.a(I(), "/" + strA1));
                        }
                        if (sb2.length() > 0) {
                            s4.b.g(webView, sb2.toString());
                        }
                        return !this.f2582n0.m2().D() || r9.g.a().e(url) || this.Q0.b(webView, url, 1);
                    }
                    char c10 = (this.f2582n0.m2().D() && !r9.g.a().e(url) && this.Q0.b(webView, url, 2)) ? (char) 1 : (char) 0;
                    i6.c0.f6985a.q(new i6.e(webView), new q7.l() { // from class: c8.h5
                        @Override // q7.l
                        public final Object invoke(Object obj) {
                            return k6.U4(this.f2483e, (Boolean) obj);
                        }
                    });
                    if (c10 > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void Jb() throws Resources.NotFoundException {
        int i10 = (this.f2583n1 || !(this.f2578k1 || this.f2582n0.O1() || this.f2582n0.r2() > 0)) ? 0 : 1;
        if (this.X0 == i10) {
            return;
        }
        Ha();
        if (i10 != 0) {
            boolean z10 = this.f2582n0.x0() == 2;
            this.f2586p0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (this.f2604y0.getVisibility() == 0) {
                this.f2586p0.setTranslationY(z10 ? 0.0f : this.f2604y0.getHeight());
            }
        } else {
            G8(true);
            this.f2604y0.setVisibility(0);
            this.f2600w0.setVisibility(0);
            this.f2586p0.setTranslationY(0.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.f2604y0.getId());
            layoutParams.addRule(2, this.f2600w0.getId());
            this.f2586p0.setLayoutParams(layoutParams);
        }
        this.X0 = i10;
        if (i10 != 0) {
            Fa();
        }
    }

    public final String K8(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return (String) this.A1.get(str);
    }

    public final boolean K9() throws Resources.NotFoundException {
        if (!this.f2582n0.y2()) {
            return false;
        }
        ra(17);
        return true;
    }

    public final void Ka(String str, String str2, String str3) {
        if (g6.p.f(str)) {
            return;
        }
        if (g6.p.f(str2) && g6.p.f(str3)) {
            return;
        }
        this.A1.put(str, okhttp3.l.a(str2, str3));
    }

    public final void Kb() {
        if (O8() != null) {
            d8(new k8.o() { // from class: c8.p3
                @Override // k8.o
                public final void a(Object obj) {
                    k6.w3(this.f2760a, (Integer) obj);
                }
            });
        }
    }

    @Override // e8.c0.a
    public void L(boolean z10, boolean z11, final Message message) {
        if (v9()) {
            message.sendToTarget();
            return;
        }
        String strS8 = S8();
        String strZ0 = null;
        if (!this.f2580m0.V1(null, strS8)) {
            if (this.f2582n0.m2().h() && !z11) {
                strZ0 = Z0(x7.u.f14191v1);
            } else if (i6.i0.f7006a.s(strS8) && !this.f2580m0.c1(strS8)) {
                strZ0 = Z0(x7.u.V0);
            }
        }
        if (strZ0 == null) {
            qa(message);
        } else {
            if (!q1()) {
                message.sendToTarget();
                return;
            }
            h.b bVarE = new h.b(l0()).h(strZ0).b(x7.u.X0).e(new View.OnClickListener() { // from class: c8.p5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2762a.qa(message);
                }
            });
            Objects.requireNonNull(message);
            bVarE.g(new h.c() { // from class: c8.q5
                @Override // f6.h.c
                public final void onCancel() {
                    message.sendToTarget();
                }
            }).a().s();
        }
    }

    public SslCertificate L8() {
        r4.a aVarD = this.L0.d();
        if (aVarD == null) {
            return null;
        }
        return aVarD.w();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean L9(int i10, KeyEvent keyEvent) throws Resources.NotFoundException {
        if (i10 != 3) {
            if (i10 != 30) {
                if (i10 != 40) {
                    if (i10 != 46) {
                        if (i10 != 51) {
                            if (i10 != 61) {
                                if (i10 == 82) {
                                    if (i10 == 82 || keyEvent.isAltPressed()) {
                                        tb();
                                        return true;
                                    }
                                } else {
                                    if (i10 == 84) {
                                        ra(4);
                                        return true;
                                    }
                                    if (i10 == 111) {
                                        d9();
                                        return true;
                                    }
                                    if (i10 == 135) {
                                        ra(1);
                                        return true;
                                    }
                                    if (i10 == 21 || i10 == 22) {
                                        if (keyEvent.isAltPressed()) {
                                            ra(i10 == 21 ? 12 : 13);
                                            return true;
                                        }
                                    } else {
                                        if (i10 == 24) {
                                            return this.f2592s0 == null && this.f2590r0 == null && !this.f2578k1 && !a9() && K9();
                                        }
                                        if (i10 == 25) {
                                            return this.f2592s0 == null && this.f2590r0 == null && !this.f2578k1 && !a9() && J9();
                                        }
                                        if (i10 != 48) {
                                            if (i10 != 49) {
                                                if (i10 == 92 || i10 == 93) {
                                                    z8.b0.V(O8(), i10 == 92 ? 2 : 3);
                                                    return true;
                                                }
                                                switch (i10) {
                                                    case 8:
                                                    case 9:
                                                    case 10:
                                                    case 11:
                                                    case 12:
                                                    case 13:
                                                    case 14:
                                                    case 15:
                                                    case 16:
                                                        if (keyEvent.isCtrlPressed()) {
                                                            this.f2580m0.X1(i10 == 16 ? this.L0.i() - 1 : i10 - 8);
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        switch (i10) {
                                                            case 32:
                                                                if (keyEvent.isCtrlPressed()) {
                                                                    ra(6);
                                                                    break;
                                                                }
                                                                break;
                                                            case 34:
                                                                if (!keyEvent.isCtrlPressed()) {
                                                                    if (keyEvent.isAltPressed()) {
                                                                        tb();
                                                                        break;
                                                                    }
                                                                } else {
                                                                    ra(14);
                                                                    break;
                                                                }
                                                                break;
                                                            case 35:
                                                                if (keyEvent.isCtrlPressed()) {
                                                                    ra(keyEvent.isShiftPressed() ? 22 : 21);
                                                                    break;
                                                                }
                                                                break;
                                                            case 36:
                                                                if (keyEvent.isCtrlPressed()) {
                                                                    ra(8);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                }
                                                return true;
                                            }
                                            if (keyEvent.isCtrlPressed()) {
                                                ra(20);
                                                return true;
                                            }
                                        } else if (keyEvent.isCtrlPressed()) {
                                            ra(5);
                                            na();
                                            return true;
                                        }
                                    }
                                }
                            } else if (keyEvent.isCtrlPressed()) {
                                ra(keyEvent.isShiftPressed() ? 10 : 11);
                                return true;
                            }
                        } else if (keyEvent.isCtrlPressed()) {
                            ra(9);
                            return true;
                        }
                    } else if (keyEvent.isCtrlPressed()) {
                        ra(1);
                        return true;
                    }
                } else if (keyEvent.isCtrlPressed()) {
                    ra(4);
                    return true;
                }
            } else if (keyEvent.isCtrlPressed() && keyEvent.isShiftPressed()) {
                ra(7);
                return true;
            }
        } else if (keyEvent.isAltPressed()) {
            this.f2580m0.V0();
            return true;
        }
        return false;
    }

    public final void La(String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29 || i10 < 23 || g6.f.g(I(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Ea(str, 4);
            return;
        }
        this.Q1 = str;
        try {
            this.S1.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    public final void Lb() {
        Mb(S8());
    }

    @Override // e8.i0.a
    public void M(WebView webView) {
        String url;
        if (webView == null || !webView.getSettings().getJavaScriptEnabled() || (url = webView.getUrl()) == null || url.isEmpty() || i6.i0.f7006a.l(url)) {
            return;
        }
        i6.s.f7047a.a(new i6.e(webView), this.f2573f1, String.valueOf(webView.getId()));
    }

    public final float M8() {
        FrameLayout frameLayout = this.f2584o0.f2937m;
        if (frameLayout.getChildCount() == 1 && (frameLayout.getChildAt(0) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) frameLayout.getChildAt(0);
            if (viewGroup.getChildCount() != 0 && (viewGroup.getChildAt(0).getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                return (((FrameLayout.LayoutParams) viewGroup.getChildAt(0).getLayoutParams()).gravity & 80) == 80 ? this.f2600w0.getHeight() : -this.f2604y0.getHeight();
            }
        }
        return 0.0f;
    }

    public boolean M9(int i10, KeyEvent keyEvent) {
        return (i10 == 24 || i10 == 25) && this.f2592s0 == null && this.f2590r0 == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final w.d Ma(File file, String str) throws Throwable {
        OutputStream fileOutputStream;
        InputStream inputStream;
        Uri uri;
        Uri uriFromFile;
        InputStream inputStream2 = null;
        if (file == null || !file.isFile()) {
            return null;
        }
        String strR = z8.c1.r(file.getPath());
        String strC = l5.c.c(strR, "image/*");
        String strB = l5.b.b(str, null, strC);
        int iLastIndexOf = strB.lastIndexOf(46);
        if (strR != null && iLastIndexOf > 0 && iLastIndexOf > (strB.length() - strR.length()) - 3) {
            int i10 = iLastIndexOf + 1;
            if (!strR.equals(strB.substring(i10))) {
                strB = strB.substring(0, i10) + strR;
            }
        }
        try {
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_display_name", strB);
                    contentValues.put("mime_type", strC);
                    contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/Via");
                    uriFromFile = I().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    if (uriFromFile == null) {
                        g6.j.a(null);
                        g6.j.a(null);
                        return null;
                    }
                    try {
                        fileOutputStream = I().getContentResolver().openOutputStream(uriFromFile);
                        if (fileOutputStream != null) {
                            g6.j.a(null);
                            g6.j.a(fileOutputStream);
                            return null;
                        }
                        try {
                            InputStream inputStreamI = z8.b1.i(I(), Uri.fromFile(file));
                            if (inputStreamI == null) {
                                g6.j.a(inputStreamI);
                                g6.j.a(fileOutputStream);
                                return null;
                            }
                            try {
                                z8.x2.a(inputStreamI, fileOutputStream);
                                fileOutputStream.flush();
                                mark.via.download.i1.f(I(), uriFromFile);
                                w.d dVarA = w.d.a(uriFromFile, strC);
                                g6.j.a(inputStreamI);
                                g6.j.a(fileOutputStream);
                                return dVarA;
                            } catch (Exception e10) {
                                Uri uri2 = uriFromFile;
                                inputStream = inputStreamI;
                                e = e10;
                                uri = uri2;
                                try {
                                    pc.a.i(e);
                                    if (Build.VERSION.SDK_INT >= 29) {
                                    }
                                    g6.j.a(inputStream);
                                    g6.j.a(fileOutputStream);
                                    return null;
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream2 = inputStream;
                                }
                            } catch (Throwable th2) {
                                inputStream2 = inputStreamI;
                                th = th2;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            uri = uriFromFile;
                            inputStream = null;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        uri = uriFromFile;
                        inputStream = null;
                        fileOutputStream = null;
                        pc.a.i(e);
                        if (Build.VERSION.SDK_INT >= 29) {
                            z8.b1.e(I(), uri);
                        }
                        g6.j.a(inputStream);
                        g6.j.a(fileOutputStream);
                        return null;
                    }
                } else {
                    File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Via");
                    File file3 = new File(file2, z8.c1.K(file2.getAbsolutePath(), strB));
                    fileOutputStream = new FileOutputStream(file3);
                    try {
                        try {
                            uriFromFile = Uri.fromFile(file3);
                            if (fileOutputStream != null) {
                            }
                        } catch (Exception e13) {
                            e = e13;
                            inputStream = null;
                            uri = null;
                            pc.a.i(e);
                            if (Build.VERSION.SDK_INT >= 29 && uri != null) {
                                z8.b1.e(I(), uri);
                            }
                            g6.j.a(inputStream);
                            g6.j.a(fileOutputStream);
                            return null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Exception e14) {
                e = e14;
                inputStream = null;
                uri = null;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        g6.j.a(inputStream2);
        g6.j.a(fileOutputStream);
        throw th;
    }

    public final void Mb(String str) {
        this.f2585o1.j(!(z8.n3.g(I()) && ib(str)));
    }

    @Override // c8.pa
    public void N(String str) {
        g6.n.s(I(), str);
    }

    public final int N8() {
        ViewGroup viewGroup = this.f2606z0;
        int iMin = viewGroup == null ? 0 : Math.min(viewGroup.getMeasuredWidth(), this.f2606z0.getMeasuredHeight());
        if (iMin == 0) {
            iMin = g6.y.p(I());
        }
        return (!this.Z0 || this.W0 == 0) ? iMin : Math.min(iMin - g6.y.h(I(), 96.0f), g6.y.h(I(), 384.0f));
    }

    public final void N9(f8.q qVar) {
        qVar.e3(new j());
    }

    public final void Na() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.f2601w1 = z8.l3.l(I());
        this.f2599v1 = this.U0;
    }

    public final void Nb(int i10, boolean z10) {
        if (this.U0 == 0) {
            z10 = false;
        }
        if (i10 != 0) {
            if (!this.f2582n0.A2() || this.f2582n0.d()) {
                i10 = g6.e.a(I(), x7.k.f13656b);
            }
            if (i10 != this.U0 || this.V0) {
                Z7(i10, z10, false);
                return;
            }
            return;
        }
        if (!b9()) {
            i10 = this.f2582n0.c0();
            if (i10 == -1) {
                i10 = g6.e.a(I(), x7.k.f13656b);
            } else if (this.f2582n0.d()) {
                i10 = g6.y.G(-16777216, i10, 0.5f);
            }
        }
        if (i10 == this.U0 && this.V0) {
            return;
        }
        Z7(i10, z10, true);
    }

    @Override // c8.pa
    public void O(Runnable runnable) {
        z8.h.d(this, runnable);
    }

    @Override // androidx.fragment.app.Fragment
    public void O1() throws Resources.NotFoundException {
        Ha();
        this.f2580m0.p1();
        if (this.D1) {
            z8.f.e(this.f2584o0);
        }
        com.tuyafeng.support.widget.v vVar = this.f2592s0;
        if (vVar == null || !vVar.z()) {
            this.L0.f();
        }
        this.P0.c(this.f2587p1);
        super.O1();
    }

    public t4.b O8() {
        r4.a aVarD = d();
        if (aVarD == null) {
            return null;
        }
        return aVarD.p();
    }

    public final void O9(int i10, int i11) throws Resources.NotFoundException, URISyntaxException {
        if (i10 != 21) {
            t8.f.a().e(i10);
        }
        switch (i10) {
            case 1:
                boolean z10 = !this.f2582n0.d();
                boolean zA = g6.q.a(I());
                if (z10 == zA && Build.VERSION.SDK_INT >= 29) {
                    g6.n.q(I(), x7.u.I5);
                }
                this.f2582n0.T0(z10, zA);
                Ib();
                break;
            case 2:
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
            case 13:
                if (i10 == 13) {
                    ka();
                    break;
                } else {
                    ja(i10 == 2);
                    break;
                }
            case 4:
                if (!this.O0.i(I())) {
                    ca();
                    break;
                }
                break;
            case 5:
                cb();
                break;
            case 6:
                this.f2580m0.S1();
                break;
            case 7:
                P7();
                break;
            case 8:
                w9.p pVarM2 = this.f2582n0.m2();
                boolean zL = pVarM2.l();
                boolean z11 = !zL;
                g6.n.s(I(), a1(!zL ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.T)));
                pVarM2.O(z11);
                this.f2582n0.g0(pVarM2);
                this.f2580m0.m1(true);
                if (!u9.d.m(I(), S8())) {
                    xa(z11);
                    break;
                }
                break;
            case 10:
                ra(26);
                break;
            case 11:
                ra(14);
                break;
            case 12:
                ra(19);
                break;
            case 14:
                ra(15);
                break;
            case 15:
                ra(20);
                break;
            case 16:
                this.f2584o0.postDelayed(new Runnable() { // from class: c8.s
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        k6.i3(this.f2810e);
                    }
                }, 100L);
                break;
            case 17:
                final String[] strArr = {Z0(x7.u.f14209w6), Z0(x7.u.f14196v6), Z0(x7.u.f14183u6)};
                w9.p pVarM22 = this.f2582n0.m2();
                final int i12 = pVarM22.r() ? 2 : pVarM22.q() ? 0 : 1;
                w5.k.l(I()).d0(x7.u.f14235y6).b0(strArr, i12, new AdapterView.OnItemClickListener() { // from class: c8.t
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i13, long j10) {
                        k6.Z4(this.f2832a, i12, strArr, adapterView, view, i13, j10);
                    }
                }).f0();
                break;
            case 18:
                this.f2580m0.t1();
                break;
            case 19:
                eb();
                break;
            case 20:
                this.f2580m0.r1();
                break;
            case 21:
                C8();
                break;
            case 23:
                C9();
                break;
            case 24:
                wa();
                break;
            case 25:
                ga();
                break;
            case 26:
                la();
                break;
            case 27:
                boolean zD = this.f2582n0.m2().D();
                String strS8 = S8();
                if (i6.i0.f7006a.s(strS8) && !r9.g.a().e(strS8) && lc.c().d().C(strS8)) {
                    z = true;
                }
                if (!zD) {
                    w9.p pVarM23 = this.f2582n0.m2();
                    pVarM23.i0(true);
                    this.f2582n0.g0(pVarM23);
                    if (z) {
                        wa();
                    }
                    g6.n.q(I(), x7.u.Jb);
                    break;
                } else if (!z) {
                    g6.i.g(this, sa.d1.class);
                    break;
                } else {
                    d9();
                    yb(S8());
                    break;
                }
                break;
            case 28:
                w9.p pVarM24 = this.f2582n0.m2();
                pVarM24.I(!pVarM24.g());
                this.f2582n0.g0(pVarM24);
                this.f2580m0.l1();
                g6.n.s(I(), a1(pVarM24.g() ? x7.u.f14006h7 : x7.u.f13992g7, Z0(x7.u.f14165t1)));
                break;
            case 29:
                qb(false, 0);
                break;
            case 30:
                final int iI0 = this.f2582n0.i0() - 1;
                w5.k.l(I()).d0(x7.u.P9).Z(x7.j.f13650g, iI0, new AdapterView.OnItemClickListener() { // from class: c8.u
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i13, long j10) {
                        k6.f4(this.f2852a, iI0, adapterView, view, i13, j10);
                    }
                }).f0();
                break;
            case 31:
                z8.h0.e(I(), this.f2582n0, pa.r.m().d(), pa.r.l(), pa.r.f());
                break;
            case 32:
                ua();
                break;
            case 33:
                va(d());
                break;
            case 34:
                Wa();
                break;
            case 35:
                g6.i.g(this, i8.s.class);
                break;
            case 36:
                if ((i11 & 8) == 0) {
                    B8();
                    break;
                } else {
                    m8();
                    break;
                }
            case 37:
                pa(S8());
                break;
            case 38:
                bb(!this.f2582n0.S0());
                break;
            case 39:
                ba();
                break;
            case 40:
                Q7();
                break;
            case 41:
                ya();
                break;
        }
    }

    public final void Oa(final Uri uri) {
        if (uri == null) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.t1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k6.s5(this.f2836e, uri);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: c8.u1
            @Override // a7.e
            public final void accept(Object obj) {
                k6.N3(this.f2857e, (String) obj);
            }
        }, new x7.g0());
    }

    public final void Ob() {
        if (u9.d.m(I(), S8())) {
            pc.a.a("is in home page, change color for homepage", new Object[0]);
            this.U0 = g6.y.H(this.U0);
            j0(0);
        }
    }

    @Override // e8.n0.a
    public void P(int i10) {
        int iE = this.L0.e(i10);
        if (iE < 0) {
            return;
        }
        f(this.L0.k(iE), iE);
    }

    @Override // androidx.fragment.app.Fragment
    public void P1(boolean z10) {
        super.P1(z10);
        com.tuyafeng.support.widget.v vVar = this.f2592s0;
        if (vVar != null) {
            vVar.setInPipMode(z10);
        }
        if (z10) {
            this.f2604y0.setVisibility(8);
            this.f2600w0.setVisibility(8);
            return;
        }
        this.f2604y0.setVisibility(0);
        this.f2600w0.setVisibility(0);
        t4.b bVarO8 = O8();
        if (bVarO8 != null) {
            bVarO8.onPause();
        }
    }

    public final void P7() {
        String strS8 = S8();
        String strR8 = R8(strS8);
        if (strR8 == null || strR8.isEmpty()) {
            strR8 = Z0(x7.u.bh);
        }
        u8(strS8, strR8);
    }

    public final com.tuyafeng.support.widget.z P8() {
        if (this.W1 == null) {
            com.tuyafeng.support.widget.z zVar = (com.tuyafeng.support.widget.z) new h6.a(new com.tuyafeng.support.widget.z(I()), new RelativeLayout.LayoutParams(-1, -2)).o(g6.y.l()).V(new a.InterfaceC0076a() { // from class: c8.s3
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    ((com.tuyafeng.support.widget.z) obj).setTitle(this.f2823a.Z0(x7.u.bh));
                }
            }).l();
            Bundle bundleY0 = y0();
            if (bundleY0 != null) {
                Bitmap bitmap = (Bitmap) g6.d.a(bundleY0, "android.support.customtabs.extra.CLOSE_BUTTON_ICON", Bitmap.class);
                zVar.l(bitmap != null ? new BitmapDrawable(T0(), bitmap) : lb.b.a(I(), x7.o.f13783z, x7.u.Ud), Z0(x7.u.C8), new View.OnClickListener() { // from class: c8.t3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f2840a.l0().finish();
                    }
                });
                Bundle bundle = bundleY0.getBundle("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE");
                if (bundle != null) {
                    Bitmap bitmap2 = (Bitmap) g6.d.a(bundle, "android.support.customtabs.customaction.ICON", Bitmap.class);
                    String string = bundle.getString("android.support.customtabs.customaction.DESCRIPTION");
                    final PendingIntent pendingIntent = (PendingIntent) g6.d.a(bundle, "android.support.customtabs.customaction.PENDING_INTENT", PendingIntent.class);
                    zVar.c(new z.b(2, 0, bitmap2 == null ? null : new BitmapDrawable(T0(), bitmap2), string), new View.OnClickListener() { // from class: c8.u3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) throws PendingIntent.CanceledException {
                            this.f2859a.Va(pendingIntent);
                        }
                    });
                } else {
                    zVar.c(new z.b(990, 0, lb.b.a(I(), x7.o.f13749n1, x7.u.tf), Z0(x7.u.f13943d0)), new View.OnClickListener() { // from class: c8.v3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            k6.v3(this.f2880a, view);
                        }
                    });
                }
                zVar.c(new z.b(991, 0, lb.b.a(I(), x7.o.K0, x7.u.cf), Z0(x7.u.f14198v8)), new View.OnClickListener() { // from class: c8.w3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f2895a.kb(view);
                    }
                });
            }
            this.W1 = zVar;
        }
        return this.W1;
    }

    public final void P9(int i10, int i11) throws URISyntaxException, PackageManager.NameNotFoundException {
        if (i10 == 1) {
            g6.i.g(this, hb.p4.class);
            return;
        }
        if (i10 == 2) {
            W9();
            return;
        }
        if (i10 == 3) {
            this.f2580m0.s1(3, null);
            return;
        }
        if (i10 == 4) {
            final String[][] strArrD = this.O0.d(l0());
            String strK2 = this.f2582n0.K2();
            int i12 = 0;
            if (strK2 != null) {
                int length = strArrD[0].length;
                int i13 = 0;
                for (int i14 = 0; i14 < length; i14++) {
                    if (strK2.equals(strArrD[0][i14])) {
                        i13 = i14;
                    }
                }
                i12 = i13;
            }
            w5.k.l(I()).d0(x7.u.A0).b0(strArrD[1], i12, new AdapterView.OnItemClickListener() { // from class: c8.e6
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i15, long j10) throws Resources.NotFoundException {
                    k6.a5(this.f2423a, strArrD, adapterView, view, i15, j10);
                }
            }).f0();
            return;
        }
        if (i10 == 14) {
            Db(true);
            return;
        }
        if (i10 == 16) {
            g6.i.g(this, hb.n7.class);
            return;
        }
        if (i10 != 23) {
            if (i10 == 33) {
                ha();
                return;
            }
            if (i10 == 36) {
                if ((i11 & 8) != 0) {
                    Bb();
                    return;
                } else {
                    g6.i.g(this, hb.o5.class);
                    return;
                }
            }
            if (i10 == 39) {
                g6.i.g(this, a9.o.class);
                return;
            }
            if (i10 == 19) {
                g6.i.g(this, hb.y7.class);
                return;
            }
            if (i10 != 20) {
                switch (i10) {
                    case 6:
                        pa(S8());
                        break;
                    case 7:
                        Wa();
                        break;
                    case 8:
                        eb();
                        break;
                    case 9:
                        this.f2580m0.t1();
                        break;
                    case 10:
                        g6.i.g(this, i8.s.class);
                        break;
                    default:
                        switch (i10) {
                            case 26:
                                g6.i.g(this, jb.y4.class);
                                break;
                            case 27:
                                g6.i.g(this, sa.d1.class);
                                break;
                            case 28:
                                g6.i.g(this, z7.d.class);
                                break;
                            case 29:
                                g6.i.g(this, jb.k5.class);
                                break;
                        }
                }
                return;
            }
        }
        g6.i.g(this, z7.v.class);
    }

    public final void Pa(String str) {
        Ea(str, 2);
    }

    public final void Pb() {
        if (k1()) {
            return;
        }
        final String strC = this.f2582n0.c();
        File file = (strC == null || strC.isEmpty()) ? null : new File(strC);
        if (file == null || !file.exists()) {
            pc.a.a("no background image, use default color", new Object[0]);
            if (b9()) {
                this.f2584o0.k(g6.e.a(I(), x7.k.f13656b), false);
                this.f2584o0.setWindowBackgroundImage(null);
                Ob();
                return;
            }
            return;
        }
        final String strB = j9.a.b(I());
        File file2 = new File(strB);
        final boolean zExists = file2.exists();
        long jLastModified = file2.lastModified() + this.f2582n0.M2().a();
        final int iS = g6.y.s(I());
        final int iQ = g6.y.q(I());
        if (zExists && jLastModified == this.f2571d1) {
            pc.a.a("init home view, no changed", new Object[0]);
            return;
        }
        this.f2571d1 = jLastModified;
        ((autodispose2.m) x6.f.h(new Callable() { // from class: c8.k3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k6.g4(this.f2560e, zExists, strB, strC, iS, iQ);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: c8.l3
            @Override // a7.e
            public final void accept(Object obj) {
                k6.i5(this.f2654e, (mark.via.common.widget.o0) obj);
            }
        }, new x7.c0());
        if (zExists) {
            return;
        }
        z8.h.b(new Runnable() { // from class: c8.m3
            @Override // java.lang.Runnable
            public final void run() {
                j9.a.c(this.f2673e.I(), strC);
            }
        });
    }

    @Override // e8.i.a
    public o5.a Q(WebView webView) {
        return new o5.a(webView, this.Q0, this.f2581m1);
    }

    public final void Q7() {
        String strS8 = S8();
        if (u9.d.m(I(), strS8)) {
            x8("https://", null);
        } else {
            x8(strS8, Q8());
        }
    }

    public final String Q8() {
        r4.a aVarD = this.L0.d();
        if (aVarD == null) {
            return null;
        }
        return aVarD.getTitle();
    }

    public final void Q9(final ua.y yVar) {
        final t4.b bVarO8 = O8();
        if (bVarO8 != null) {
            bVarO8.evaluateJavascript(this.Q0.a().c(this.Q0.c()), new ValueCallback() { // from class: c8.e5
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    k6.x3(yVar, (String) obj);
                }
            });
            yVar.o3(new y.a() { // from class: c8.f5
                @Override // ua.y.a
                public final void a(String str, String str2) {
                    k6.j5(this.f2443a, bVarO8, str, str2);
                }
            });
        }
    }

    public final void Qa(final String str, int i10, int i11) {
        boolean z10 = z8.c0.f() || z8.f.h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new k.l(1, Z0(x7.u.W5)));
        arrayList.add(new k.l(2, Z0(x7.u.V5)));
        arrayList.add(new k.l(3, Z0(x7.u.f14126q1)));
        arrayList.add(new k.l(4, Z0(x7.u.Lf)));
        arrayList.add(new k.l(5, Z0(x7.u.Wh)));
        if (z10) {
            arrayList.add(new k.l(6, Z0(x7.u.f14112p1)));
            arrayList.add(new k.l(7, Z0(x7.u.Z5)));
        }
        arrayList.add(new k.l(8, Z0(x7.u.f14188ub)));
        arrayList.add(new k.l(9, Z0(x7.u.f13978f7)));
        arrayList.add(new k.l(10, Z0(x7.u.f13964e7)));
        arrayList.add(new k.l(11, Z0(x7.u.Sh)));
        arrayList.add(new k.l(12, Z0(x7.u.f13986g1)));
        w5.k.l(I()).d0(x7.u.Rb).C(arrayList, new AdapterView.OnItemClickListener() { // from class: c8.r2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                k6.k6(this.f2798a, str, adapterView, view, i12, j10);
            }
        }).g0(i10, i11);
    }

    public final void Qb(boolean z10) {
        mark.via.common.widget.f fVar = this.C0;
        if (fVar == null) {
            return;
        }
        if (z10) {
            final String strS8 = S8();
            ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.h6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return k6.t4(strS8);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: c8.i6
                @Override // a7.e
                public final void accept(Object obj) {
                    k6.s4(this.f2497e, (x5.a) obj);
                }
            }, new x7.g0());
        } else if (fVar.getVisibility() != 8) {
            x.r.c(this.C0).a(0.0f).i(new Runnable() { // from class: c8.g6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2464e.C0.setVisibility(8);
                }
            }).d(150L).f();
        }
    }

    public final void R7(final String str, final String str2, final String str3) {
        w5.k.l(l0()).e0(a1(x7.u.Ab, i6.i0.f7006a.e(str))).v(true).B(g6.y.h(I(), 268.0f)).z(new String[]{Z0(x7.u.f14253zb), Z0(x7.u.F8), Z0(R.string.cancel)}, new AdapterView.OnItemClickListener() { // from class: c8.q2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                k6.l5(this.f2775a, str, str2, str3, adapterView, view, i10, j10);
            }
        }).f0();
    }

    public final String R8(String str) {
        return z8.b0.G(Q8(), str);
    }

    public final void R9(f8.w wVar) {
        final WeakReference weakReference = new WeakReference(wVar);
        d8(new k8.o() { // from class: c8.k5
            @Override // k8.o
            public final void a(Object obj) {
                k6.w5(weakReference, (Integer) obj);
            }
        });
        wVar.k3(new i());
    }

    public final void Ra(String str) throws Resources.NotFoundException {
        Ta(str, false);
    }

    public final void Rb(String str) {
        mark.via.common.widget.m mVar = this.B0;
        if (mVar == null) {
            return;
        }
        boolean z10 = !this.f2578k1 && mVar.n(str);
        if (z10 == (this.B0.getParent() != null)) {
            return;
        }
        if (z10) {
            int i10 = this.B0.getLayoutParams().height;
            this.f2606z0.addView(this.B0, Math.max(this.f2606z0.indexOfChild(this.f2584o0), 0) + 1);
            this.f2586p0.setPadding(0, 0, 0, i10);
        } else {
            this.f2586p0.setPadding(0, 0, 0, 0);
            ViewParent parent = this.B0.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.B0);
            }
        }
    }

    @Override // e8.i.a
    public boolean S() {
        return this.f2579l1;
    }

    public final void S7(boolean z10) throws Resources.NotFoundException {
        ta();
        this.f2589q1 = z10;
        float f10 = z10 ? 0.0f : 1.0f;
        if (Math.abs(this.f2591r1 - f10) < 0.001f) {
            G8(z10);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f2591r1, f10);
        this.f2593s1 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(Math.max(1L, (long) (Math.abs(f10 - this.f2591r1) * 180.0f)));
        valueAnimatorOfFloat.setInterpolator(x8.h.b());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c8.n4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                k6.B5(this.f2690a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new p(valueAnimatorOfFloat, z10));
        valueAnimatorOfFloat.start();
    }

    public final String S8() {
        r4.a aVarD = this.L0.d();
        if (aVarD == null) {
            return null;
        }
        return aVarD.getUrl();
    }

    public final void S9(f8.l0 l0Var) {
        o4.a aVar = this.L0;
        if (aVar == null) {
            return;
        }
        l0Var.s3(aVar.c(), this.L0.m());
        l0Var.r3(new m());
    }

    public final void Sa(String str, int i10) throws Resources.NotFoundException {
        ja.c cVar;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            Iterator it = z8.v2.e(I()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                } else {
                    cVar = (ja.c) it.next();
                    if (cVar.d() == i10) {
                        break;
                    }
                }
            }
            if (cVar == null) {
                Ra(strTrim);
                return;
            }
            z9.h hVarC = z8.v2.c(cVar.d(), cVar.a());
            String strH = i6.g0.f6993a.h(hVarC.getUrl(), strTrim);
            t8.f.a().g(hVarC.b());
            this.f2580m0.m0(strTrim);
            r4.a aVarD = this.L0.d();
            if (aVarD != null) {
                aVarD.v(strH);
                aVarD.o();
            } else {
                this.f2580m0.i1(strH, true);
            }
            d9();
        }
    }

    public final void Sb(int i10) {
        if (i10 == 0 || i10 == 3) {
            this.f2598v0.k();
        } else {
            this.f2598v0.f(this.f2602x0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void T1() throws Resources.NotFoundException {
        String str;
        com.tuyafeng.support.widget.v vVar;
        super.T1();
        Lb();
        boolean z10 = w9() || !k1();
        if (z10 && ((vVar = this.f2592s0) == null || !vVar.z())) {
            this.L0.a();
        }
        if (z10 && this.f2590r0 == null) {
            m9();
            if (w9.n.e().n()) {
                this.f2580m0.m1(true);
            }
            this.f2580m0.w1();
            this.P0.e(this.f2587p1);
            this.f2580m0.Y1();
            j8.q qVar = this.I1;
            if (qVar != null && (str = this.f2576i1) != null) {
                xb(qVar.f(str), false);
            }
            a8();
        }
    }

    public final void T7() {
        i6.e eVarT8 = T8();
        if (eVarT8 == null) {
            return;
        }
        int iMin = Math.min(84, Math.max(8, this.f2582n0.Z1()));
        int iB2 = this.f2582n0.b2();
        if (iB2 == 0) {
            iB2 = -1;
        }
        i6.c0.f6985a.f(eVarT8, iB2, iMin, this.f2582n0.y0());
        d8.g.c().f(eVarT8.getUrl(), iB2);
        O8().setAccentColor(iB2);
        Nb(iB2, true);
    }

    public final i6.e T8() {
        t4.b bVarO8 = O8();
        if (bVarO8 == null) {
            return null;
        }
        return new i6.e(bVarO8);
    }

    public final void T9(tb.k0 k0Var) {
        this.f2584o0.setBlurEnabled(true);
        this.f2584o0.setDescendantFocusability(393216);
        this.f2584o0.clearFocus();
        k0Var.k0().a(new androidx.lifecycle.f() { // from class: c8.k4
            @Override // androidx.lifecycle.f
            public final void a(androidx.lifecycle.h hVar, Lifecycle.Event event) {
                k6.d6(this.f2566e, hVar, event);
            }
        });
        if (this.L0 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (r4.a aVar : this.L0.c()) {
            n9.b bVar = new n9.b(aVar.getUrl(), aVar.getTitle());
            bVar.m(aVar.getId());
            arrayList.add(bVar);
        }
        k0Var.P3(arrayList);
    }

    public final void Ta(String str, boolean z10) throws Resources.NotFoundException {
        Ua(str, z10, false);
    }

    public final void Tb(int i10) {
        if (i10 == 0) {
            this.f2602x0.setBackgroundColor(0);
            return;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new g6.g().h(this.f2582n0.d() ? 587202559 : 268435456).c(x8.h.e(I())).a()});
        int iH = g6.y.h(I(), 4.0f);
        if (i10 == 3) {
            int i11 = iH * 4;
            this.f2602x0.setPadding(i11, 0, i11, 0);
            layerDrawable.setLayerInset(0, i11, iH, i11, iH);
        } else {
            this.f2602x0.setPadding(0, 0, 0, 0);
            layerDrawable.setLayerInset(0, iH, iH, iH, iH);
        }
        g6.y.O(this.f2602x0, layerDrawable);
    }

    @Override // c8.pa
    public void U(int i10, int i11, View.OnClickListener onClickListener) {
        g6.n.r(I(), i10, i11, onClickListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void U1(Bundle bundle) {
        super.U1(bundle);
        if (this.f2583n1) {
            return;
        }
        this.f2580m0.N1();
    }

    public final void U7(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Intent intentH = z8.f1.h(str, str2);
        String strW0 = this.f2582n0.w0();
        if (strW0 == null || strW0.isEmpty()) {
            z8.f1.j(I(), intentH);
            return;
        }
        intentH.setPackage(strW0);
        if (z8.f1.j(I(), intentH)) {
            return;
        }
        intentH.setPackage(null);
        z8.f1.j(I(), intentH);
    }

    public final void U8() {
        r4.a aVarD = this.L0.d();
        if (d9() || aVarD == null) {
            return;
        }
        if (aVarD.j()) {
            if (aVarD.q()) {
                aVarD.s();
            }
            aVarD.g();
        } else {
            if (u9.d.o(I(), aVarD.getUrl())) {
                return;
            }
            this.f2580m0.B0();
        }
    }

    public void U9(boolean z10) {
        if (this.f2582n0.O1()) {
            ab(true);
        }
    }

    public final void Ua(String str, boolean z10, boolean z11) throws Resources.NotFoundException {
        String strV;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strZ0 = this.f2582n0.Z0();
            i6.i0 i0Var = i6.i0.f7006a;
            if (!i0Var.t(strTrim) || (z10 && i0Var.p(strTrim))) {
                String strH = i6.g0.f6993a.h(strZ0, strTrim);
                t8.f.a().g(this.f2582n0.Q2());
                this.f2580m0.m0(strTrim);
                strV = strH;
            } else {
                strV = i0Var.v(strTrim, strZ0);
                if (u(strV)) {
                    return;
                }
            }
            r4.a aVarD = this.L0.d();
            if (aVarD == null || z11) {
                this.f2580m0.i1(strV, true);
            } else {
                aVarD.v(strV);
                aVarD.o();
            }
            d9();
        }
    }

    public final void Ub() {
        String strB = i6.i0.f7006a.b(S8());
        if (strB.isEmpty()) {
            v5.b.d().b("HISTORY_CACHE");
        } else {
            v5.b.a().e("HISTORY_CACHE").f(180).d("query", strB).a();
        }
        ja(false);
    }

    @Override // e8.l.a
    public void V() throws Resources.NotFoundException {
        pc.a.a("on hide custom view", new Object[0]);
        if (this.f2590r0 == null || this.G0 == null || this.L0.d() == null) {
            WebChromeClient.CustomViewCallback customViewCallback = this.G0;
            if (customViewCallback != null) {
                try {
                    customViewCallback.onCustomViewHidden();
                } catch (Exception unused) {
                }
                this.G0 = null;
                return;
            }
            return;
        }
        if (SystemClock.elapsedRealtime() - this.H0 < 800) {
            this.I0++;
        } else {
            this.I0 = 0;
        }
        z8.n3.i(I(), this.L1);
        this.f2586p0.setVisibility(0);
        this.f2590r0.setKeepScreenOn(false);
        com.tuyafeng.support.widget.v vVar = this.f2592s0;
        if (vVar != null) {
            ViewGroup viewGroup = (ViewGroup) vVar.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f2592s0);
            }
            this.f2592s0.removeAllViews();
        }
        ab(this.f2578k1 || this.f2582n0.O1());
        this.f2592s0 = null;
        this.f2590r0 = null;
        try {
            this.G0.onCustomViewHidden();
        } catch (Exception unused2) {
        }
        this.G0 = null;
        if (!this.f2578k1 && !z8.g2.d(A0())) {
            ub();
        }
        Lb();
    }

    public final boolean V7() {
        r4.a aVarD = this.L0.d();
        if (aVarD != null) {
            return aVarD.j() || !u9.d.o(I(), aVarD.getUrl());
        }
        return false;
    }

    public final void V8() {
        r4.a aVarD = this.L0.d();
        if (d9() || aVarD == null) {
            return;
        }
        if (!aVarD.n()) {
            this.f2580m0.U0();
            return;
        }
        if (aVarD.q()) {
            aVarD.s();
        }
        aVarD.l();
        this.f2580m0.s0();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean V9(final String str) throws ParseException, URISyntaxException {
        final Intent intentC;
        String str2;
        String strA;
        if (str.startsWith("mailto:")) {
            MailTo mailTo = MailTo.parse(str);
            intentC = z8.f1.g(mailTo.getTo(), mailTo.getSubject(), mailTo.getBody(), mailTo.getCc());
        } else if (str.startsWith("tel:") || str.startsWith("sms:")) {
            intentC = new Intent("android.intent.action.VIEW", Uri.parse(str));
        } else if (str.startsWith("magnet:") || str.startsWith("intent://")) {
            intentC = z8.f1.c(I(), str);
        } else if (str.startsWith("tg:")) {
            if (str.startsWith("tg://")) {
                str2 = str;
            } else {
                str2 = "tg://" + str.substring(str.indexOf("tg:") + 3);
            }
            intentC = z8.f1.c(I(), str2);
        } else if (str.contains("://")) {
            i6.i0 i0Var = i6.i0.f7006a;
            intentC = (i0Var.l(str) || i0Var.s(str) || z8.w2.z(str) || z8.w2.t(str) || z8.w2.s(str) || str.startsWith("data:") || str.startsWith("javascript:") || str.startsWith("ftp://") || str.startsWith("tg:") || str.startsWith("view-source:")) ? null : z8.f1.c(I(), str);
        } else if (str.indexOf(58) > 0 && !str.startsWith("data:") && !str.startsWith("javascript:") && !str.startsWith("about:")) {
            intentC = z8.f1.c(I(), str);
        }
        if (intentC == null) {
            return false;
        }
        int iP0 = this.f2580m0.P0(S8());
        if (iP0 == 2 || !w9() || (strA = z8.f1.a(I(), intentC)) == null) {
            return true;
        }
        if (iP0 != 1) {
            new h.b(l0()).h(strA.isEmpty() ? Z0(x7.u.B8) : a1(x7.u.Y0, strA)).b(R.string.ok).e(new View.OnClickListener() { // from class: c8.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k6.r4(this.f2323a, intentC, view);
                }
            }).f(new View.OnLongClickListener() { // from class: c8.b1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return k6.o3(this.f2345a, str, intentC, view);
                }
            }).a().s();
            return true;
        }
        try {
            P2(intentC);
        } catch (Exception unused) {
            g6.n.q(I(), x7.u.xg);
        }
        return true;
    }

    public final void Va(PendingIntent pendingIntent) throws PendingIntent.CanceledException {
        Intent data;
        if (pendingIntent == null) {
            return;
        }
        String strS8 = S8();
        if (strS8 != null) {
            try {
                data = strS8.isEmpty() ? null : new Intent().setData(Uri.parse(strS8));
            } catch (Exception e10) {
                pc.a.i(e10);
                return;
            }
        }
        Intent intent = data;
        if (Build.VERSION.SDK_INT < 34) {
            pendingIntent.send(l0(), 0, intent);
            return;
        }
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        z8.d.b(activityOptionsMakeBasic);
        pendingIntent.send(l0(), 0, intent, null, null, null, activityOptionsMakeBasic.toBundle());
    }

    public final boolean W7() {
        r4.a aVarD = this.L0.d();
        return (aVarD != null && aVarD.n()) || this.f2580m0.W0();
    }

    public final boolean W8(ClipData clipData) {
        int itemCount = clipData == null ? 0 : clipData.getItemCount();
        if (itemCount == 0) {
            return false;
        }
        CharSequence string = null;
        for (int i10 = 0; i10 < itemCount; i10++) {
            ClipData.Item itemAt = clipData.getItemAt(i10);
            if (itemAt.getUri() != null) {
                string = itemAt.getUri().toString();
            } else if (itemAt.getText() != null) {
                string = itemAt.getText();
            } else {
                int i11 = Build.VERSION.SDK_INT;
                if (itemAt.getHtmlText() != null) {
                    string = i11 >= 24 ? Html.fromHtml(itemAt.getHtmlText(), 0).toString() : Html.fromHtml(itemAt.getHtmlText()).toString();
                }
            }
            if (string != null && string.length() > 0) {
                break;
            }
        }
        if (string != null && string.length() != 0) {
            String string2 = string.toString();
            List listE = i6.g0.f6993a.e(string2);
            if (listE.size() == 1) {
                oa((String) listE.get(0));
            } else {
                oa(string2);
            }
        }
        return true;
    }

    public final void W9() {
        x9();
        a8.k.o3().h3(z0(), a8.k.class.getSimpleName());
    }

    public final void Wa() {
        String strS8 = S8();
        String strR8 = R8(strS8);
        if (strS8 == null || u9.d.m(I(), strS8)) {
            strS8 = "";
            strR8 = "";
        }
        if (strR8 == null || strR8.isEmpty()) {
            strR8 = Z0(x7.u.f13958e1);
        }
        Xa(strS8, strR8);
    }

    @Override // e8.j.a
    public WebResourceResponse X(WebResourceRequest webResourceRequest, String str, String str2) {
        return this.f2580m0.E0(webResourceRequest, str, str2);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        pc.a.a("BrowserFragment::onViewCreated", new Object[0]);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f2582n0.b1();
        String strT1 = this.f2582n0.T1();
        if (strT1 != null && !strT1.isEmpty()) {
            lb.b.c(z8.c1.G(I(), strT1));
        }
        j9();
        l9();
        s9();
        r9();
        i9();
        final boolean z10 = bundle != null;
        this.f2584o0.post(new Runnable() { // from class: c8.h3
            @Override // java.lang.Runnable
            public final void run() {
                k6.U3(this.f2480e, z10);
            }
        });
        H8();
        pc.a.a("BrowserFragment::onViewCreated, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    public final void X7() {
        ValueAnimator valueAnimator = this.f2593s1;
        if (valueAnimator != null) {
            this.f2593s1 = null;
            valueAnimator.cancel();
        }
    }

    public final void X8(final String str, final File file, int i10) {
        if (i10 == 0 || file == null) {
            return;
        }
        if ((i10 & 4) != 0) {
            this.R0.d(str, 4);
            ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.c6
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return x5.a.f(this.f2374e.Ma(file, str));
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: c8.d6
                @Override // a7.e
                public final void accept(Object obj) {
                    k6.M3(this.f2401e, (x5.a) obj);
                }
            }, new x7.g0());
        }
        Uri uriFromFile = Uri.fromFile(file);
        if ((i10 & 1) != 0) {
            this.R0.d(str, 1);
            int iLastIndexOf = file.getName().lastIndexOf(46);
            z8.f1.m(I(), uriFromFile, iLastIndexOf > 0 ? l5.c.c(file.getName().substring(iLastIndexOf + 1), "image/*") : "image/*");
        }
        if ((i10 & 2) != 0) {
            this.R0.d(str, 2);
            Oa(uriFromFile);
        }
    }

    public final void X9(final String str, final String str2) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.e1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k6.T3(str, str2);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(this))).a(new a7.e() { // from class: c8.f1
            @Override // a7.e
            public final void accept(Object obj) {
                k6.V3(this.f2433e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    public final void Xa(final String str, final String str2) {
        if (!p.z.e(I())) {
            g6.n.q(I(), x7.u.xg);
        } else if (Build.VERSION.SDK_INT >= 26) {
            a8.u1.x3(str, str2).h3(z0(), null);
        } else {
            ((autodispose2.n) x6.j.s(new Callable() { // from class: c8.j1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Integer.valueOf(w8.e.e(this.f2533e.I()));
                }
            }).D(g7.a.c()).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: c8.k1
                @Override // a7.e
                public final void accept(Object obj) {
                    k6.m5(this.f2556e, str, str2, (Integer) obj);
                }
            }, new x7.c0());
        }
    }

    @Override // c8.pa
    public void Y(String str, int i10, View.OnClickListener onClickListener) {
        new h.b(l0()).h(str).j(true).c(i10, onClickListener).a().s();
    }

    public final void Y7() {
        x.r.c(this.f2586p0).b();
        x.r.c(this.f2604y0).b();
        x.r.c(this.f2600w0).b();
        x.r.c(this.f2588q0).b();
        x.r.c(this.f2584o0.f2937m).b();
        mark.via.common.widget.m mVar = this.B0;
        if (mVar != null) {
            x.r.c(mVar).b();
        }
        mark.via.common.widget.f fVar = this.C0;
        if (fVar != null) {
            x.r.c(fVar).b();
        }
    }

    public final void Y8() {
        mark.via.download.e eVar = this.P1;
        if (eVar == null) {
            return;
        }
        mb(eVar);
        this.P1 = null;
    }

    public final void Y9(String str) {
        x9();
        a8.k.p3(str).h3(z0(), a8.k.class.getSimpleName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0074  */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.fragment.app.Fragment, c8.k6] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [int] */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v23, types: [w9.l] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Ya(int i10, boolean z10) throws Resources.NotFoundException {
        boolean z11;
        Ha();
        pc.a.a("try to set ui mode: %d, tab bar enabled: %s, orientation: %d", Integer.valueOf(i10), Boolean.valueOf(z10), Integer.valueOf(this.C1));
        int i11 = i10;
        if (i10 < 0 || i10 > 4) {
            i11 = -1;
        }
        ?? r11 = i11;
        if (this.f2583n1) {
            r11 = 4;
            z10 = false;
        }
        if (r11 == -1) {
            r11 = this.Z0;
            this.f2582n0.j(r11);
        }
        if (r11 == 0 || r11 == 3) {
            r11 = r11;
            if (this.C1 == 2) {
                r11 = r11 == 3 ? 2 : 1;
            }
            z10 = false;
        }
        if (this.W0 == r11 && z10 == this.f2569b1) {
            Sb(r11);
            return;
        }
        d9();
        int i12 = this.W0;
        if (i12 == -1) {
            z11 = true;
        } else {
            if ((i12 == 0) == (r11 == 0)) {
                if ((i12 == 3) == (r11 == 3)) {
                    z11 = false;
                }
            }
        }
        this.f2604y0.removeAllViews();
        this.f2600w0.removeAllViews();
        g8(z10);
        if (z11) {
            Sb(r11);
        }
        if (r11 == 0) {
            this.f2604y0.addView(this.f2602x0);
            mark.via.common.widget.t tVar = this.A0;
            if (tVar != null) {
                this.f2604y0.addView(tVar);
            }
            this.f2600w0.addView(this.f2596u0);
        } else if (r11 == 1 || r11 == 2) {
            if (r11 == 1) {
                this.f2604y0.addView(this.f2596u0);
                mark.via.common.widget.t tVar2 = this.A0;
                if (tVar2 != null) {
                    this.f2604y0.addView(tVar2);
                }
            } else {
                mark.via.common.widget.t tVar3 = this.A0;
                if (tVar3 != null) {
                    this.f2600w0.addView(tVar3);
                }
                this.f2600w0.addView(this.f2596u0);
            }
        } else if (r11 == 3) {
            this.f2600w0.addView(this.f2602x0);
            this.f2600w0.addView(this.f2596u0);
        } else if (r11 == 4) {
            this.f2604y0.addView(P8());
        }
        int iD = g6.f.d(I(), x7.n.f13704w);
        int iD2 = g6.f.d(I(), x7.n.F) + (z10 ? iD : 0);
        int iD3 = g6.f.d(I(), x7.n.f13683b);
        ViewGroup.LayoutParams layoutParams = this.f2604y0.getLayoutParams();
        layoutParams.height = (r11 == 2 || r11 == 3) ? 0 : iD2;
        this.f2604y0.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f2600w0.getLayoutParams();
        if (r11 == 3) {
            layoutParams2.height = iD3 + iD2;
        } else if (r11 == 1 || r11 == 4) {
            layoutParams2.height = 0;
        } else {
            if (r11 == 0 || !z10) {
                iD = 0;
            }
            layoutParams2.height = iD3 + iD;
        }
        this.f2600w0.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2588q0.getLayoutParams();
        boolean z12 = this.f2604y0.getChildCount() > 0;
        layoutParams3.addRule(3, z12 ? this.f2604y0.getId() : 0);
        layoutParams3.addRule(2, z12 ? 0 : this.f2600w0.getId());
        this.f2588q0.setLayoutParams(layoutParams3);
        Tb(r11);
        if (this.f2589q1 && this.X0 == 1) {
            this.f2586p0.setTranslationY((r11 == 2 || r11 == 3) ? 0.0f : iD2);
        }
        this.W0 = r11;
        this.f2569b1 = z10;
        Aa();
    }

    @Override // e8.k.a
    public boolean Z(ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.F0 = valueCallback;
        try {
            Intent intentCreateIntent = fileChooserParams.createIntent();
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            ArrayList arrayList = new ArrayList();
            if (acceptTypes != null && acceptTypes.length > 0) {
                for (String str : acceptTypes) {
                    if (str != null) {
                        String strTrim = str.trim();
                        if (!strTrim.isEmpty()) {
                            if (strTrim.charAt(0) == '.') {
                                strTrim = l5.c.c(strTrim.substring(1), null);
                            }
                            if (strTrim != null && !arrayList.contains(strTrim)) {
                                arrayList.add(strTrim);
                            }
                        }
                    }
                }
            }
            pc.a.a("upload file, mime types: %s", arrayList);
            if (arrayList.isEmpty()) {
                intentCreateIntent.setType("*/*");
            } else if (arrayList.size() == 1) {
                intentCreateIntent.setType((String) arrayList.get(0));
            } else {
                intentCreateIntent.setType("*/*");
                intentCreateIntent.putExtra("android.intent.extra.MIME_TYPES", (String[]) arrayList.toArray(new String[0]));
            }
            String strZ0 = (String) fileChooserParams.getTitle();
            if (TextUtils.isEmpty(strZ0)) {
                strZ0 = Z0(x7.u.Wf);
            }
            R2(Intent.createChooser(intentCreateIntent, strZ0), 111);
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z7(int i10, boolean z10, boolean z11) {
        boolean z12;
        Window window;
        pc.a.a("change color: %s, %s", Integer.toHexString(i10), String.valueOf(z10));
        WeakReference weakReference = this.f2572e1;
        if (weakReference != null) {
            Animator animator = (Animator) weakReference.get();
            if (animator != null && animator.isRunning()) {
                animator.cancel();
            }
            this.f2572e1 = null;
        }
        boolean zB9 = b9();
        boolean z13 = i10 == 0;
        boolean zD = this.f2582n0.d();
        i9.a aVarM2 = this.f2582n0.M2();
        if (zD) {
            z12 = false;
        } else if (!z13 || !aVarM2.c()) {
            if (g6.y.C(z13 ? this.f2582n0.c0() : i10)) {
                z12 = true;
            }
        } else if (aVarM2.d()) {
        }
        Context contextI = I();
        int i11 = R.color.white;
        int iB = g6.f.b(contextI, zD ? x7.m.f13678h : z12 ? x7.m.f13677g : R.color.white);
        Context contextI2 = I();
        if (zD) {
            i11 = x7.m.f13675e;
        } else if (z12) {
            i11 = x7.m.f13674d;
        }
        int iB2 = g6.f.b(contextI2, i11);
        this.f2598v0.setAccentColor(iB2);
        this.f2602x0.r(iB2, iB);
        mark.via.common.widget.t tVar = this.A0;
        if (tVar != null) {
            tVar.y(iB2, iB);
        }
        mark.via.common.widget.m mVar = this.B0;
        if (mVar != null) {
            mVar.l(iB2, iB);
        }
        com.tuyafeng.support.widget.z zVar = this.W1;
        if (zVar != null) {
            zVar.setContentColor(iB);
        }
        this.f2570c1.setColor(Color.argb((!zD || z11) ? 0 : this.f2582n0.n2(), 0, 0, 0));
        boolean zP = z8.l3.p(l0(), z12);
        boolean zO = z8.l3.o(l0(), z12);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 21 && (window = l0().getWindow()) != null) {
            window.setStatusBarColor((!z12 || zP) ? 0 : Color.argb(51, 0, 0, 0));
            int iArgb = (!z12 || zO) ? 0 : Color.argb(51, 0, 0, 0);
            if (i12 < 29 && !z13) {
                iArgb = (!z12 || zO) ? i10 : g6.y.G(i10, -16777216, 0.2f);
            }
            window.setNavigationBarColor(iArgb);
            if (i12 >= 28) {
                window.setNavigationBarDividerColor(iArgb);
            }
        }
        int i13 = this.U0;
        this.U0 = i10;
        this.V0 = z11;
        if (i13 == i10) {
            z10 = false;
        }
        if (z10) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i13), Integer.valueOf(i10));
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c8.y3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    k6.c4(this.f2928a, valueAnimator);
                }
            });
            valueAnimatorOfObject.setDuration(T0().getInteger(x7.q.f13864a));
            valueAnimatorOfObject.start();
            this.f2572e1 = new WeakReference(valueAnimatorOfObject);
            return;
        }
        if (z13 && zB9) {
            this.f2600w0.setBackgroundColor(0);
            return;
        }
        this.f2584o0.k(i10, false);
        this.f2600w0.setBackgroundColor(i10);
        mark.via.common.widget.m mVar2 = this.B0;
        if (mVar2 != null) {
            mVar2.setBackgroundColor(i10);
        }
    }

    public final void Z8() {
        String str = this.Q1;
        if (str == null || str.isEmpty()) {
            return;
        }
        String str2 = this.Q1;
        this.Q1 = null;
        Ea(str2, 4);
    }

    public final void Z9(final String str) {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.n1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x5.a.f(pa.r.d().j(str));
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(this))).a(new a7.e() { // from class: c8.o1
            @Override // a7.e
            public final void accept(Object obj) {
                k6.k5(this.f2725e, (x5.a) obj);
            }
        }, new x7.g0());
    }

    @Override // o8.d
    public void a(boolean z10) throws Resources.NotFoundException {
        if (this.D1 != z10 || this.G1) {
            return;
        }
        Ha();
        if (z10) {
            this.G1 = true;
            this.f2584o0.post(new Runnable() { // from class: c8.i0
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    k6.t5(this.f2491e);
                }
            });
            this.D1 = false;
            return;
        }
        this.G1 = true;
        boolean z11 = this.f2600w0.getVisibility() == 0;
        this.E1 = z11;
        this.F1 = this.f2597u1;
        if (z11) {
            this.f2600w0.setVisibility(8);
        }
        if (this.F1) {
            f9(false);
        }
        this.G1 = false;
        this.D1 = true;
    }

    @Override // r4.f
    public void a0(int i10, int i11) throws Resources.NotFoundException {
        Ha();
        if (v9()) {
            d9();
        }
        Qb(false);
        mark.via.common.widget.t tVar = this.A0;
        if (tVar == null) {
            return;
        }
        tVar.x(i11);
    }

    public final void a8() {
        if (w9.n.e().m()) {
            w9.n.e().x(false);
            t4.b bVarO8 = O8();
            if (bVarO8 == null) {
                return;
            }
            final WeakReference weakReference = new WeakReference(bVarO8);
            bVarO8.post(new Runnable() { // from class: c8.j4
                @Override // java.lang.Runnable
                public final void run() {
                    k6.J4(this.f2539e, weakReference);
                }
            });
        }
    }

    public final boolean a9() {
        return z0().u0() > 0;
    }

    public final void aa(String str) {
        x9();
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                cb.e0.T3(strTrim);
            }
        }
        g6.i.i(this, bb.i.class, bb.i.n3(true, 1), "RecordContainerFragment");
    }

    public final void ab(boolean z10) {
        pc.a.a("set fullscreen: %s", Boolean.valueOf(z10));
        androidx.fragment.app.q qVarL0 = l0();
        if (qVarL0 instanceof Shell) {
            ((Shell) qVarL0).j0(z10);
        } else if (qVarL0 instanceof CustomTab) {
            ((CustomTab) qVarL0).X(z10);
        }
        z8.l3.n(l0().getWindow(), z10);
        if (z10) {
            return;
        }
        this.f2606z0.setPadding(0, 0, 0, 0);
        this.f2604y0.setPadding(0, 0, 0, 0);
        this.f2600w0.setPadding(0, 0, 0, 0);
        this.f2596u0.setPadding(0, 0, 0, 0);
    }

    @Override // c8.pa
    public void b(int i10) {
        this.f2580m0.K1(this.L0.k(i10));
        this.L0.b(i10);
    }

    @Override // r4.f
    public void b0(r4.a aVar, int i10) throws Resources.NotFoundException {
        d9();
        if (this.L0.i() > 1) {
            this.f2598v0.j();
        }
        D9();
        mark.via.common.widget.t tVar = this.A0;
        if (tVar == null) {
            return;
        }
        tVar.u(i10);
    }

    public final void b8() {
        d8(new k8.o() { // from class: c8.g0
            @Override // k8.o
            public final void a(Object obj) {
                k6.Q4(this.f2457a, (Integer) obj);
            }
        });
    }

    public final boolean b9() {
        return this.f2584o0.h();
    }

    public final void ba() {
        String strN0;
        if (z8.c0.j() && ((strN0 = this.f2582n0.n0()) == null || strN0.isEmpty())) {
            g6.i.g(this, a9.o.class);
            return;
        }
        z0().y1("result", d1(), new androidx.fragment.app.i0() { // from class: c8.n3
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                k6.e6(this.f2689a, str, bundle);
            }
        });
        final int i10 = (this.W0 == 1 ? 48 : 80) | 8388613;
        t4.b bVarO8 = O8();
        final String strS8 = S8();
        final String strZ = pa.r.e().z(strS8);
        if (bVarO8 == null || !bVarO8.getSettings().getJavaScriptEnabled() || !i6.i0.f7006a.s(strS8)) {
            b9.g.s3(strZ, i10).h3(z0(), null);
        } else {
            final String strQ8 = Q8();
            i6.c0.f6985a.l(new i6.e(bVarO8), new q7.l() { // from class: c8.o3
                @Override // q7.l
                public final Object invoke(Object obj) {
                    return k6.v5(this.f2727e, strZ, strS8, strQ8, i10, (String) obj);
                }
            });
        }
    }

    public final void bb(boolean z10) throws Resources.NotFoundException {
        if (this.f2578k1 == z10) {
            return;
        }
        this.f2578k1 = z10;
        this.f2582n0.T(z10);
        Rb(S8());
        if (z10) {
            ab(true);
            Jb();
            g9();
        } else {
            ub();
            ab(this.f2582n0.O1());
            this.f2586p0.postDelayed(new Runnable() { // from class: c8.t5
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f2842e.Jb();
                }
            }, 200L);
        }
        g6.n.s(I(), z10 ? Z0(x7.u.S5) : a1(x7.u.f13992g7, Z0(x7.u.Q5)));
        Lb();
    }

    @Override // c8.pa
    public List c() {
        return this.L0.c();
    }

    @Override // o8.e
    public boolean c0(Intent intent) {
        if (intent == null) {
            return false;
        }
        boolean zH = z8.b0.H(intent);
        if (zH) {
            N0().g1(null, 1);
        }
        this.f2580m0.q1(intent);
        return zH;
    }

    public final void c8(final String str, final String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !pa.r.i().o(str)) {
            return;
        }
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.r1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k6.l4(str, str2);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: c8.s1
            @Override // a7.e
            public final void accept(Object obj) {
                k6.I4(this.f2817e, str, str2, str3, (x5.a) obj);
            }
        }, new x7.g0());
    }

    public final boolean c9() {
        r4.a aVarD = d();
        return aVarD != null && d8.d.c().g(aVarD.getId());
    }

    public final void ca() {
        x9();
        if (this.Z0) {
            lb();
        } else {
            g6.i.g(this, mark.via.download.b1.class);
        }
    }

    public final void cb() {
        boolean zS = this.f2582n0.m2().s();
        boolean z10 = zS && (i() > 1 || V7() || W7());
        if (!zS) {
            A8();
        } else if (z10) {
            w5.k.l(I()).d0(x7.u.Pf).I(x7.u.U7).V(x7.u.f14054l, new k.m() { // from class: c8.l0
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    this.f2648a.l8(false);
                }
            }).N(x7.u.J, new View.OnClickListener() { // from class: c8.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2669a.l8(true);
                }
            }).f0();
        } else {
            l8(true);
        }
    }

    @Override // c8.pa
    public r4.a d() {
        o4.a aVar = this.L0;
        if (aVar == null) {
            return null;
        }
        return aVar.d();
    }

    @Override // o8.b
    public void d0(boolean z10) throws Resources.NotFoundException {
        Ib();
    }

    public final void d8(final k8.o oVar) {
        t4.b bVarO8 = this.L0 == null ? null : O8();
        if (oVar == null || bVarO8 == null || !bVarO8.isShown()) {
            return;
        }
        i6.c0.f6985a.g(new i6.e(bVarO8), new q7.l() { // from class: c8.r5
            @Override // q7.l
            public final Object invoke(Object obj) {
                return k6.g6(oVar, (Integer) obj);
            }
        });
    }

    public final boolean d9() throws Resources.NotFoundException {
        if (z0().u0() <= 0) {
            return false;
        }
        pb();
        h9();
        z0().e1();
        return true;
    }

    public void da(final String str) {
        t4.b bVarO8 = O8();
        if (bVarO8 != null) {
            bVarO8.evaluateJavascript("javascript:(function(){var a=document.getElementsByClassName(\"box\"),b=0,c=a.length;if(0<c){var d=a[0].getBoundingClientRect().top;for(i=0;i<c;i++)if(a[i].getBoundingClientRect().top==d)b++;else break;return (d>0?d<<6:0)|b}return b})();", new ValueCallback() { // from class: c8.s2
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) throws NumberFormatException {
                    k6.W2(this.f2821a, str, (String) obj);
                }
            });
        } else {
            ea(0, 0, str);
        }
    }

    public final void db(float f10) {
        this.f2591r1 = this.X0 == 1 ? Math.max(0.0f, Math.min(1.0f, f10)) : 0.0f;
        int height = this.f2604y0.getHeight();
        int height2 = this.f2600w0.getHeight();
        this.f2586p0.setTranslationY(this.X0 == 1 ? height * (1.0f - this.f2591r1) : 0.0f);
        Fa();
        this.f2604y0.setTranslationY((-this.f2591r1) * height);
        float f11 = height2;
        this.f2600w0.setTranslationY(this.f2591r1 * f11);
        ProgressBar progressBar = this.f2588q0;
        float f12 = this.f2591r1;
        if (this.f2604y0.getChildCount() > 0) {
            height2 = -height;
        }
        progressBar.setTranslationY(f12 * height2);
        mark.via.common.widget.m mVar = this.B0;
        if (mVar != null) {
            mVar.setTranslationY(this.f2591r1 * f11);
        }
        mark.via.common.widget.f fVar = this.C0;
        if (fVar != null && fVar.getVisibility() == 0) {
            this.C0.setTranslationY(this.f2591r1 * f11);
        }
        this.f2584o0.f2937m.setTranslationY(this.f2591r1 * M8());
    }

    @Override // c8.pa
    public int e(int i10) {
        return this.L0.e(i10);
    }

    @Override // c8.pa
    public String e0() {
        return this.f2573f1;
    }

    public final void e8(String str, String str2) {
        N0().y1("bookmarkDialogResult2", this, new androidx.fragment.app.i0() { // from class: c8.s5
            @Override // androidx.fragment.app.i0
            public final void a(String str3, Bundle bundle) {
                k6.Y5(this.f2825a, str3, bundle);
            }
        });
        b8.n.q3(str, str2).h3(z0(), b8.n.class.getSimpleName());
    }

    public final void e9() {
        f9(true);
    }

    public final void ea(int i10, int i11, String str) {
        N0().y1("favoriteChanged", this, new androidx.fragment.app.i0() { // from class: c8.c3
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                k6.D5(this.f2370a, str2, bundle);
            }
        });
        androidx.fragment.app.l0 l0VarX = N0().q().x(true);
        int i12 = x7.i.f13636a;
        int i13 = x7.i.f13642g;
        l0VarX.v(i12, i13, i13, x7.i.f13637b).c(g6.i.f6223a, qa.e1.class, qa.e1.c3(i10, i11), null).g(null).i();
    }

    public final void eb() {
        final boolean zL = this.f2582n0.m2().l();
        final List listE = z8.b4.e(I());
        if (zL) {
            for (int size = listE.size() - 1; size >= 0; size--) {
                int iD = ((ja.c) listE.get(size)).d();
                if (iD < 0 && iD != -3 && iD != -4 && iD != -5) {
                    listE.remove(size);
                }
            }
        }
        w9.l lVar = this.f2582n0;
        final int iU = zL ? lVar.U() : lVar.l0();
        int size2 = listE.size();
        final String[] strArr = new String[size2];
        int i10 = 0;
        for (int i11 = 0; i11 < size2; i11++) {
            strArr[i11] = ((ja.c) listE.get(i11)).g();
            if (iU == ((ja.c) listE.get(i11)).d()) {
                i10 = i11;
            }
        }
        w5.k.l(I()).d0(zL ? x7.u.sh : x7.u.C0).b0(strArr, i10, new AdapterView.OnItemClickListener() { // from class: c8.e0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) throws Resources.NotFoundException {
                k6.l3(this.f2410a, listE, iU, zL, strArr, adapterView, view, i12, j10);
            }
        }).f0();
    }

    @Override // r4.f
    public void f(r4.a aVar, int i10) {
        mark.via.common.widget.t tVar = this.A0;
        if (tVar == null) {
            return;
        }
        tVar.t(i10);
    }

    @Override // e8.c0.a
    public void f0(t4.b bVar) {
        o4.a aVar;
        if (bVar == null || (aVar = this.L0) == null) {
            return;
        }
        int i10 = aVar.i();
        for (int i11 = 0; i11 < i10; i11++) {
            r4.a aVarK = this.L0.k(i11);
            if (aVarK != null && aVarK.p() == bVar) {
                this.f2580m0.C0(i11);
                return;
            }
        }
    }

    public final GestureTouchEvent.b f8() {
        return new a();
    }

    public final void f9(boolean z10) {
        ImageView imageView;
        if (!this.f2597u1 || (imageView = this.f2594t0) == null) {
            return;
        }
        if (z10) {
            x.r.c(imageView).i(new Runnable() { // from class: c8.i3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2494e.f2594t0.setVisibility(8);
                }
            }).h(g6.y.h(I(), 32.0f)).a(0.0f).d(160L).f();
        } else {
            imageView.setVisibility(8);
        }
        this.f2597u1 = false;
    }

    public final void fa() {
        x9();
        g6.i.i(this, bb.i.class, bb.i.n3(true, 2), "RecordContainerFragment");
    }

    public final void fb(boolean z10) {
        if (c1() == null) {
            return;
        }
        if (!z10) {
            mark.via.common.widget.f fVar = this.C0;
            if (fVar != null) {
                ViewParent parent = fVar.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.C0);
                }
                this.C0 = null;
                return;
            }
            return;
        }
        if (this.C0 == null) {
            mark.via.common.widget.f fVar2 = (mark.via.common.widget.f) new h6.a(new mark.via.common.widget.f(I()), new RelativeLayout.LayoutParams(-1, g6.y.h(I(), 40.0f))).g(64, x7.p.U0).f(g6.e.a(I(), x7.k.f13657c)).c(true).l();
            this.C0 = fVar2;
            fVar2.setVisibility(8);
            this.C0.setCallback(new c());
            mark.via.common.widget.m mVar = this.B0;
            this.f2606z0.addView(this.C0, (mVar != null ? Math.max(this.f2606z0.indexOfChild(mVar), 0) : Math.max(this.f2606z0.indexOfChild(this.f2584o0), 0)) + 1);
        }
    }

    @Override // c8.pa
    public void g(r4.g gVar, int i10, boolean z10) {
        r4.a aVarD = this.L0.d();
        r4.a aVarG = this.L0.g(gVar, i10, z10);
        if (this.f2583n1) {
            aVarG.x();
        }
        if (gVar instanceof na.g) {
            this.f2580m0.o0(((na.g) gVar).c(), aVarG == null ? -1 : aVarG.getId(), z10);
        }
        if (aVarG == null || !z10 || aVarD == null || aVarD.q()) {
            return;
        }
        this.f2580m0.M1(aVarD);
    }

    @Override // c8.pa
    public void g0(final String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            B(false);
        } else if (strArr.length == 1) {
            U7(strArr[0], str);
        } else {
            w5.k.l(I()).e0(Q8()).G(strArr, new AdapterView.OnItemClickListener() { // from class: c8.n5
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    k6.F3(this.f2691a, strArr, adapterView, view, i10, j10);
                }
            }, new AdapterView.OnItemLongClickListener() { // from class: c8.o5
                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
                    return k6.a3(this.f2733a, strArr, adapterView, view, i10, j10);
                }
            }).f0();
        }
    }

    public final void g8(boolean z10) {
        mark.via.common.widget.t tVar = this.A0;
        if (z10 == (tVar != null)) {
            return;
        }
        if (z10) {
            this.A0 = (mark.via.common.widget.t) new h6.a(new mark.via.common.widget.t(I()), new FrameLayout.LayoutParams(-1, g6.f.d(I(), x7.n.f13704w))).V(new a.InterfaceC0076a() { // from class: c8.g3
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    k6.a4(this.f2461a, (mark.via.common.widget.t) obj);
                }
            }).l();
            return;
        }
        tVar.setOnTabItemClickListener(null);
        this.A0.setOnNewTabButtonClickListener(null);
        this.A0.setOnDeleteItemClickListener(null);
        this.A0.setOnMoveTabListener(null);
        this.A0.setOnDeleteTabsListener(null);
        this.A0.setOnDuplicateTabListener(null);
        this.A0 = null;
    }

    public final void g9() throws Resources.NotFoundException {
        if (this.X0 == 0 || this.D1) {
            return;
        }
        if (this.f2589q1 || this.f2591r1 < 1.0f) {
            S7(false);
        }
    }

    public final void ga() {
        N0().y1("qrcode", this, new androidx.fragment.app.i0() { // from class: c8.t4
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                k6.k3(this.f2841a, str, bundle);
            }
        });
        g6.i.g(this, fb.q.class);
    }

    public final void gb(boolean z10) {
        if (c1() == null) {
            return;
        }
        if (!this.f2578k1 && z10) {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.q3
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return k6.J3(this.f2779e);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: c8.r3
                @Override // a7.e
                public final void accept(Object obj) {
                    k6.n3(this.f2800e, (List) obj);
                }
            }, new x7.g0());
        } else if (this.B0 != null) {
            Rb(null);
            this.B0 = null;
        }
    }

    @Override // e8.i.a
    public boolean h0(String str) {
        return u(str);
    }

    public final void h8(WebView webView) {
        if (webView == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Context contextL0 = l0();
        if (contextL0 instanceof Shell) {
            contextL0 = ((Shell) l0()).f0();
        }
        PrintManager printManager = (PrintManager) g6.f.f(contextL0, PrintManager.class);
        if (printManager == null) {
            g6.n.q(I(), x7.u.xg);
            return;
        }
        String title = webView.getTitle();
        if (title == null || title.isEmpty()) {
            title = i6.i0.f7006a.f(webView.getUrl());
        }
        if (title == null || title.isEmpty()) {
            title = String.format(Locale.getDefault(), "%s - %s", Z0(x7.u.bh), z8.t1.d());
        }
        try {
            printManager.print(title, webView.createPrintDocumentAdapter(title), new PrintAttributes.Builder().build());
        } catch (Exception unused) {
            g6.n.q(I(), x7.u.xg);
        }
    }

    public final void h9() {
        if (this.f2584o0.i()) {
            this.f2586p0.setImportantForAccessibility(0);
            z8.l.b(this.B0);
        }
    }

    public final void ha() {
        if (g6.i.d(this)) {
            return;
        }
        j8.p.E3().h3(z0(), null);
    }

    public final void hb(String str) {
        Ea(str, 1);
    }

    @Override // c8.pa
    public int i() {
        o4.a aVar = this.L0;
        if (aVar == null) {
            return 0;
        }
        return aVar.i();
    }

    @Override // e8.n0.a
    public void i0(String str, String str2) {
        if (!u9.d.k(I(), str2)) {
            this.f2580m0.s0();
        }
        if (this.f2580m0.W1(str2)) {
            t9.e.d(I(), str2, z8.b0.G(str, str2));
        }
    }

    public final void i8(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        if (iArr.length == 1) {
            this.f2580m0.C0(iArr[0]);
            return;
        }
        pc.a.a("delete tabs: %s", Arrays.toString(iArr));
        ArrayList arrayList = new ArrayList();
        int iK = k();
        boolean z10 = false;
        for (int i10 : iArr) {
            if (i10 == iK) {
                z10 = true;
            }
            r4.a aVarK = this.L0.k(i10);
            if (aVarK != null) {
                arrayList.add(aVarK);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f2580m0.L1(arrayList);
        if (z10) {
            int i11 = iArr[iArr.length - 1] - 1;
            int i12 = i();
            if (i11 < 0) {
                i11 = iArr[0];
                int i13 = i11 + 1;
                if (i13 >= i12) {
                    int length = iArr.length;
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length) {
                            i11 = -1;
                            break;
                        } else {
                            if (i11 != iArr[i14]) {
                                break;
                            }
                            i11--;
                            i14++;
                        }
                    }
                } else {
                    i11 = i13;
                }
            }
            if (i11 >= 0) {
                this.L0.j(i11);
            } else {
                this.f2580m0.g1("", false, i12);
                if (this.L0.j(i12)) {
                    this.f2580m0.V0();
                }
            }
        }
        for (int i15 : iArr) {
            this.L0.b(i15);
        }
    }

    public final void i9() {
        Nb(0, false);
        this.f2586p0.setBackgroundColor(0);
        this.f2586p0.setForeground(this.f2570c1);
        this.f2580m0.r0();
        this.f2580m0.q0();
        this.f2580m0.p0();
        if (this.f2582n0.v().l()) {
            return;
        }
        z8.l3.n(z8.l3.e(A0()), false);
    }

    public final void ia() {
        N0().y1("restore_tabs", this, new androidx.fragment.app.i0() { // from class: c8.i2
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                k6.x5(this.f2493a, str, bundle);
            }
        });
        g6.i.g(this, ic.class);
    }

    public final boolean ib(String str) {
        return i1() && w9() && !a9() && this.f2592s0 == null && this.f2590r0 == null && !this.f2578k1 && !this.f2583n1 && i() <= 1 && u9.d.o(I(), str);
    }

    @Override // c8.pa
    public void j(int i10) {
        r4.a aVarD = d();
        if (!this.L0.j(i10) || aVarD == null || aVarD.q()) {
            return;
        }
        this.f2580m0.M1(aVarD);
    }

    @Override // e8.k0.a
    public void j0(int i10) {
        Nb(i10, true);
    }

    public final void j8(int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        if (i11 == 4 || i11 == 2 || i11 == 1) {
            int i12 = i11 == 4 ? 0 : i10 + 1;
            for (int i13 = i() - 1; i13 >= i12; i13--) {
                arrayList.add(Integer.valueOf(i13));
            }
        }
        if (i11 == 3 || i11 == 1) {
            for (int i14 = i10 - 1; i14 >= 0; i14--) {
                arrayList.add(Integer.valueOf(i14));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        i8(g6.a.d(arrayList));
    }

    public final void j9() {
        ab.a aVarA = ab.b.a();
        this.M0 = aVarA;
        aVarA.c(new a.InterfaceC0005a() { // from class: c8.b6
            @Override // ab.a.InterfaceC0005a
            public final void a() {
                k6.L3(this.f2352a);
            }
        });
        this.M0.a(I());
    }

    public final void ja(boolean z10) {
        if (z10) {
            aa(null);
        } else {
            fa();
        }
    }

    public final void jb(final String str) {
        final String strF = i6.i0.f7006a.f(str);
        if (strF == null || strF.isEmpty()) {
            return;
        }
        final String strV = z8.b0.v(str);
        if (strV == null || strV.isEmpty()) {
            w5.k.l(I()).e0(a1(x7.u.Qf, strF)).I(x7.u.f13951d8).V(R.string.ok, null).f0();
        } else {
            w5.k.l(I()).e0(a1(x7.u.Qf, strF)).J(strV).V(R.string.copy, new k.m() { // from class: c8.c1
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    g6.n.a(this.f2364a.I(), strV, x7.u.og);
                }
            }).N(R.string.cancel, null).R(x7.u.f14215x, new View.OnClickListener() { // from class: c8.d1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k6.N5(this.f2392a, str, strF, view);
                }
            }).f0();
        }
    }

    @Override // c8.pa
    public int k() {
        return this.L0.m();
    }

    public final void k8() throws Resources.NotFoundException {
        GestureTouchEvent gestureTouchEvent = this.f2603x1;
        if (gestureTouchEvent != null) {
            gestureTouchEvent.i();
        }
        this.f2571d1 = -1L;
        if (this.f2590r0 == null && i1() && !p1()) {
            Ya(this.f2582n0.x0(), this.f2582n0.v().t());
        }
    }

    public final void k9() throws Resources.NotFoundException {
        if (this.f2594t0 != null) {
            return;
        }
        this.f2594t0 = (ImageView) new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(-2, -2)).E(g6.y.h(I(), 10.0f)).V(new a.InterfaceC0076a() { // from class: c8.s4
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k6.R3(this.f2824a, (ImageView) obj);
            }
        }).l();
        Ga();
        new mark.via.common.widget.t0(this.f2594t0).k(new e());
    }

    public final void ka() {
        x9();
        g6.i.i(this, bb.i.class, bb.i.n3(true, 3), "RecordContainerFragment");
    }

    public final void kb(View view) {
        ArrayList arrayList = new ArrayList();
        final HashMap map = new HashMap();
        Bundle bundleY0 = y0();
        ArrayList<Bundle> arrayListB = bundleY0 == null ? null : g6.d.b(bundleY0, "android.support.customtabs.extra.MENU_ITEMS", Bundle.class);
        if (arrayListB != null) {
            int i10 = 0;
            for (Bundle bundle : arrayListB) {
                String string = bundle.getString("android.support.customtabs.customaction.MENU_ITEM_TITLE");
                PendingIntent pendingIntent = (PendingIntent) g6.d.a(bundle, "android.support.customtabs.customaction.PENDING_INTENT", PendingIntent.class);
                if (string != null && pendingIntent != null) {
                    i10++;
                    map.put(Integer.valueOf(i10), pendingIntent);
                    arrayList.add(new k.l(i10, string));
                }
            }
        }
        com.tuyafeng.support.widget.z zVar = this.W1;
        if (zVar != null && zVar.findViewById(990) == null) {
            arrayList.add(new k.l(990, Z0(x7.u.f13943d0)));
        }
        arrayList.add(new k.l(994, Z0(x7.u.f13928c)));
        arrayList.add(new k.l(993, Z0(x7.u.F)));
        arrayList.add(new k.l(996, Z0(x7.u.f13985g0)));
        boolean zD = this.f2582n0.m2().D();
        String strS8 = S8();
        if (zD && i6.i0.f7006a.s(strS8) && !r9.g.a().e(strS8) && lc.c().d().C(strS8)) {
            arrayList.add(new k.l(997, Z0(x7.u.Lh)));
        }
        arrayList.add(new k.l(992, Z0(x7.u.f14150s)));
        arrayList.add(new k.l(995, Z0(x7.u.f14147r9)));
        w5.k.l(I()).C(arrayList, new AdapterView.OnItemClickListener() { // from class: c8.v
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) throws Resources.NotFoundException, PendingIntent.CanceledException {
                k6.Z5(this.f2873a, map, adapterView, view2, i11, j10);
            }
        }).i0(view, view.getWidth(), g6.y.h(I(), 4.0f));
    }

    public final void l8(boolean z10) {
        if (!z10) {
            int i10 = i();
            this.f2580m0.g1(null, true, i10);
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                this.f2580m0.C0(i11);
            }
            z8.h.b(new Runnable() { // from class: c8.d2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2395e.f2580m0.h2();
                }
            });
        }
        w9.p pVarM2 = this.f2582n0.m2();
        pVarM2.V(false);
        this.f2582n0.g0(pVarM2);
        w9.n.e().u(true);
        g6.n.q(I(), x7.u.Q6);
        this.f2580m0.l1();
        this.f2602x0.setIncognitoModeEnabled(true ^ this.f2580m0.W1(S8()));
    }

    public final void l9() {
        this.D0 = new o();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("mark.via.MEDIA_PLAY");
        intentFilter.addAction("mark.via.MEDIA_FASTFORWARD");
        intentFilter.addAction("mark.via.MEDIA_REWIND");
        if (Build.VERSION.SDK_INT >= 33) {
            I().registerReceiver(this.D0, intentFilter, 4);
        } else {
            I().registerReceiver(this.D0, intentFilter);
        }
    }

    public final void la() {
        ma(2);
    }

    public final void lb() {
        z0().q().c(x7.p.C, f8.z.class, f8.d.f().g((this.W0 == 1 ? 48 : 80) | 8388613).j(N8()).h(-1).a(), null).g(null).i();
        zb();
        e9();
    }

    @Override // o8.c
    public void m(FragmentManager fragmentManager, Fragment fragment) {
        if (fragment instanceof tb.k0) {
            T9((tb.k0) fragment);
        } else if (fragment instanceof qa.e1) {
            G9((qa.e1) fragment);
        }
    }

    @Override // c8.pa
    public void m0(String str) {
        w5.k kVarN = w5.k.l(I()).d0(x7.u.f13915b0).f(0, str, x7.u.f14061l6, 1).V(R.string.ok, new k.m() { // from class: c8.c5
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                k6.e5(this.f2373a, view, pVar);
            }
        }).N(R.string.cancel, null);
        if (Build.VERSION.SDK_INT >= 21) {
            kVarN.w(x7.u.f14214wb, this.f2582n0.v().p());
        }
        kVarN.f0();
    }

    public final void m8() {
        i6.e eVarT8 = T8();
        if (eVarT8 == null) {
            return;
        }
        i6.c0.f6985a.i(eVarT8, new q7.l() { // from class: c8.w0
            @Override // q7.l
            public final Object invoke(Object obj) {
                return k6.c3(this.f2892e, (Integer) obj);
            }
        });
    }

    public final void m9() throws Resources.NotFoundException {
        int iI0 = this.f2582n0.i0();
        z8.n3.i(I(), iI0 != 2 ? iI0 != 3 ? iI0 != 4 ? 2 : 0 : 1 : 10);
        this.O0.j(this.f2582n0.K2());
        boolean zF = this.f2582n0.F();
        this.f2568a1 = zF;
        this.f2602x0.t((zF && c9()) ? false : true, false);
        this.f2605y1 = this.f2582n0.w2();
        Jb();
        Ya(this.f2582n0.x0(), this.f2582n0.v().t());
        this.Y0 = this.f2582n0.r2() == 2;
        boolean z10 = z8.l3.f14720a && !z8.l.d();
        this.f2584o0.n(z10);
        this.f2584o0.m(z10);
        Pb();
        this.f2570c1.setColor(Color.argb((!this.f2582n0.d() || this.V0) ? 0 : this.f2582n0.n2(), 0, 0, 0));
        int i10 = g6.y.C(this.f2582n0.c0()) ? 128 : 64;
        if (!this.f2582n0.d()) {
            i10 = 0;
        }
        this.f2584o0.setWindowFilterColor(Color.argb(Math.max(i10, (int) ((this.f2582n0.M2().b() / 100.0f) * 255.0f)), 0, 0, 0));
        this.f2580m0.Y0();
        gb(this.f2582n0.v().r());
        x8.g.f(this.f2602x0);
        this.f2580m0.g2();
        fb(true);
    }

    public final void ma(int i10) {
        String strS8 = S8();
        if (strS8 != null && !strS8.isEmpty()) {
            i6.i0 i0Var = i6.i0.f7006a;
            if (!i0Var.l(strS8)) {
                final String strE = i0Var.e(strS8);
                if (TextUtils.isEmpty(strE)) {
                    return;
                }
                N0().y1("result", this, new androidx.fragment.app.i0() { // from class: c8.v0
                    @Override // androidx.fragment.app.i0
                    public final void a(String str, Bundle bundle) {
                        k6.f3(this.f2875a, strE, str, bundle);
                    }
                });
                g6.i.h(this, jb.u4.class, jb.u4.W3(strE, i10));
                return;
            }
        }
        g6.i.g(this, jb.y4.class);
    }

    public final void mb(mark.via.download.e eVar) {
        boolean zA;
        if (g6.i.d(this) || eVar == null || eVar.h() == null) {
            return;
        }
        if (this.O0.f() && this.O0.a(l0(), eVar.h())) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33 && !g6.f.g(I(), "android.permission.POST_NOTIFICATIONS")) {
            try {
                this.U1.a("android.permission.POST_NOTIFICATIONS");
            } catch (Exception e10) {
                pc.a.i(e10);
            }
        }
        if (!this.O0.h() && eVar.h().startsWith("blob:")) {
            t4.b bVarO8 = O8();
            if (bVarO8 == null) {
                g6.n.q(I(), x7.u.K1);
                return;
            } else {
                g6.n.q(I(), x7.u.Ba);
                s4.b.g(bVarO8, c8.a.a(A0(), this.f2573f1, eVar.h()));
                return;
            }
        }
        if (eVar.h().startsWith("https://wormhole.app/download-stream/")) {
            t4.b bVarO82 = O8();
            if (bVarO82 == null) {
                g6.n.q(I(), x7.u.K1);
                return;
            }
            g6.n.q(I(), x7.u.Ba);
            String strB = l5.b.b(eVar.h(), eVar.b(), eVar.e());
            if (!g6.p.f(strB)) {
                v5.b.a().e("dl").f(60).d(eVar.h(), strB).a();
            }
            s4.b.g(bVarO82, "javascript:(function(){(function(a){return fetch(a).then(function(c){return c.blob()}).then(function(c){return new Promise(function(d,e){var b=new FileReader;b.onloadend=function(){return d(b.result)};b.onerror=e;b.readAsDataURL(c)})})})(\"__URL__\").then(function(a){window.via.download(\"__SECRET__\",\"__URL__\",a)}).catch(function(a){})})();".replace("__URL__", eVar.h()).replace("__SECRET__", this.f2573f1));
            return;
        }
        String strX = this.f2582n0.x();
        if (z8.b1.o(strX)) {
            zA = z8.b1.a(I(), Uri.parse(strX));
        } else {
            int i10 = Build.VERSION.SDK_INT;
            zA = i10 >= 29 || i10 < 23 || g6.f.g(I(), "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (zA) {
            mark.via.download.m.p3(eVar).h3(z0(), null);
        } else {
            za(eVar);
        }
    }

    @Override // c8.pa
    public void n(int i10) {
        g6.n.q(I(), i10);
    }

    public boolean n8(KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        boolean zW9 = w9();
        int keyCode = keyEvent.getKeyCode();
        int action = keyEvent.getAction();
        if (zW9) {
            if (action == 0) {
                return L9(keyCode, keyEvent);
            }
            if (action == 1) {
                return M9(keyCode, keyEvent);
            }
            return false;
        }
        if (action != 0 || keyCode != 111) {
            return false;
        }
        N0().e1();
        return true;
    }

    public final void n9() {
        if (this.B0 != null) {
            return;
        }
        mark.via.common.widget.m mVar = (mark.via.common.widget.m) new h6.a(new mark.via.common.widget.m(I()), new RelativeLayout.LayoutParams(-1, g6.y.h(I(), 40.0f))).g(64, x7.p.U0).c(true).V(new a.InterfaceC0076a() { // from class: c8.f6
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k6.k4(this.f2445a, (mark.via.common.widget.m) obj);
            }
        }).l();
        this.B0 = mVar;
        mVar.m(Collections.EMPTY_LIST, null);
        this.B0.setCallback(new b());
    }

    public final void na() {
        oa("");
    }

    public final void nb() {
        ob(null);
    }

    @Override // e8.i0.a
    public void o(WebView webView) {
        if (webView == null) {
            return;
        }
        s4.b.g(webView, "javascript:(function(){ window.__VIA_SECRET__='__SECRET__' })();".replace("__SECRET__", this.f2573f1));
        String strA1 = this.f2582n0.a1();
        if (strA1 == null || strA1.isEmpty()) {
            return;
        }
        s4.b.g(webView, ta.a(I(), "/" + strA1));
    }

    public final void o8(mark.via.download.e eVar) {
        if (eVar == null || eVar.d() == null || eVar.h() == null) {
            return;
        }
        String strH = eVar.h();
        if (this.O0.h()) {
            if (!URLUtil.isNetworkUrl(strH)) {
                g6.n.q(I(), x7.u.M1);
                return;
            } else if (this.O0.c(I(), eVar.h(), eVar.d(), eVar.i(), eVar.e()) > 0) {
                g6.n.r(I(), x7.u.f13919b4, x7.u.Jh, new View.OnClickListener() { // from class: c8.g1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        k6 k6Var = this.f2458a;
                        k6Var.O0.i(k6Var.I());
                    }
                });
                return;
            } else {
                g6.n.q(I(), x7.u.R3);
                return;
            }
        }
        if (!this.O0.g()) {
            p8(eVar);
        } else if (URLUtil.isNetworkUrl(strH)) {
            ((autodispose2.n) this.O0.b(null, strH, eVar.d()).z(w6.b.b()).I(u8.b.a(d1()))).a(new a7.e() { // from class: c8.h1
                @Override // a7.e
                public final void accept(Object obj) {
                    g6.n.g(this.f2477e.I(), "Download message", (String) obj, null);
                }
            }, new a7.e() { // from class: c8.i1
                @Override // a7.e
                public final void accept(Object obj) {
                    k6.J5(this.f2492e, (Throwable) obj);
                }
            });
        } else {
            g6.n.q(I(), x7.u.M1);
        }
    }

    public final void o9() {
        this.f2573f1 = UUID.randomUUID().toString();
        this.Q0 = lc.c();
        z8.h.b(new Runnable() { // from class: c8.m5
            @Override // java.lang.Runnable
            public final void run() {
                k6.b6(this.f2676e);
            }
        });
    }

    public final void oa(String str) {
        if (w9()) {
            N0().y1("input", this, new androidx.fragment.app.i0() { // from class: c8.i4
                @Override // androidx.fragment.app.i0
                public final void a(String str2, Bundle bundle) throws Resources.NotFoundException, NumberFormatException {
                    k6.G5(this.f2495a, str2, bundle);
                }
            });
            int i10 = this.W0;
            boolean z10 = (i10 == 2 || i10 == 3) ? false : true;
            boolean z11 = (this.U0 == 0 || this.f2582n0.d()) ? false : true;
            boolean z12 = z10 && !z11 && b9();
            String strS8 = S8();
            mark.via.common.widget.m mVar = this.B0;
            w.d dVarI = mVar == null ? null : mVar.i(strS8);
            String str2 = dVarI == null ? null : (String) dVarI.f13208b;
            ja.c cVar = dVarI == null ? null : (ja.c) dVarI.f13207a;
            int iD = (cVar == null || !TextUtils.isEmpty(str)) ? 0 : cVar.d();
            boolean z13 = !this.f2580m0.W1(strS8);
            androidx.fragment.app.l0 l0VarX = N0().q().x(true);
            int i11 = x7.i.f13636a;
            int i12 = x7.i.f13642g;
            l0VarX.v(i11, i12, i12, x7.i.f13637b).c(g6.i.f6223a, tb.k0.class, tb.k0.C3(str, strS8, str2, iD, z10, z11, this.U0, z12, z13), "UrlInputFragment").g(null).i();
        }
    }

    public final void ob(String str) {
        EditText editText = (EditText) this.f2584o0.f2937m.findViewById(f8.o.f6007e);
        if (editText != null) {
            editText.setText(str);
            return;
        }
        int i10 = this.W0;
        z0().q().c(x7.p.C, f8.h.class, f8.d.f().g(((i10 == 1 || i10 == 4) ? 48 : 80) | 8388613).j(N8()).i(this.V0 && b9()).e("TEXT", str).a(), f8.h.f5979v0).g(null).i();
        e9();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        int i10 = configuration.orientation;
        if (i10 != this.C1) {
            this.C1 = i10;
            pc.a.a("on configuration changed, orientation: %d", Integer.valueOf(i10));
            k8();
        }
        Pb();
    }

    @Override // e8.i.a
    public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        String url;
        int iLastIndexOf;
        String strR;
        if (this.f2592s0 == null && q1()) {
            t4.b bVarO8 = O8();
            if (str == null || bVarO8 == null) {
                url = null;
            } else {
                url = bVarO8.getUrl();
                if (url == null || url.isEmpty() || url.equals(str)) {
                    url = bVarO8.getReferer() != null ? bVarO8.getReferer() : null;
                }
                if (bVarO8.getProgress() >= 100) {
                    bVarO8.stopLoading();
                }
            }
            Bundle bundleC = v5.b.d().c("dl");
            String string = bundleC != null ? bundleC.getString(str, null) : null;
            if (string != null && !string.isEmpty() && (((iLastIndexOf = string.lastIndexOf(46)) < 0 || iLastIndexOf < string.length() - 11 || iLastIndexOf == string.length() - 1) && (strR = z8.c1.r(l5.b.b(str, str3, str4))) != null && strR.length() < 10 && !"bin".equals(strR))) {
                string = string + "." + strR;
            }
            mb(new e.b().j(str).k(str2).c(str3).g(str4).i(url).d(j10).e(string).a(K8(i6.i0.f7006a.f(url))).b());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    @Override // android.content.ComponentCallbacks2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTrimMemory(int i10) {
        int i11;
        if (this.L0 == null) {
            return;
        }
        if (i10 > 15) {
            if (i10 <= 80) {
                if (i10 < 60) {
                    return;
                } else {
                    if (i10 > 60) {
                    }
                }
            }
            i11 = 3;
        } else if (i10 < 10) {
            return;
        } else {
            i11 = i10 > 10 ? 2 : 1;
        }
        pc.a.a("on trim memory, tab level: %d", Integer.valueOf(i11));
        for (r4.a aVar : this.L0.c()) {
            if (aVar != null) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        aVar.m(aVar.d() ? 4 : 2);
                    } else if (i11 == 3) {
                        aVar.m(aVar.d() ? 2 : 1);
                    }
                } else if (!aVar.d()) {
                    aVar.m(4);
                }
            }
        }
    }

    @Override // c8.pa
    public void p(final String str, final List list) {
        if (list == null || list.isEmpty()) {
            if (str == null || str.isEmpty()) {
                return;
            }
            w5.k.l(I()).d0(x7.u.f14193v3).J(str).V(x7.u.Tb, new k.m() { // from class: c8.d3
                @Override // w5.k.m
                public final void a(View view, k.p pVar) throws Resources.NotFoundException {
                    this.f2396a.Ra(str);
                }
            }).N(R.string.cancel, null).f0();
            return;
        }
        if (list.size() == 1) {
            this.f2580m0.i1((String) list.get(0), true);
        } else {
            w5.k.l(I()).d0(x7.u.f14193v3).J(str).F((String[]) list.toArray(new String[0]), new AdapterView.OnItemClickListener() { // from class: c8.e3
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    this.f2419a.f2580m0.i1((String) list.get(i10), true);
                }
            }).V(x7.u.f14022i9, new k.m() { // from class: c8.f3
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    k6.j3(this.f2436a, list, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
        }
    }

    public final void p8(final mark.via.download.e eVar) {
        if (eVar == null || eVar.d() == null || eVar.h() == null) {
            return;
        }
        final String strX = this.f2582n0.x();
        ((autodispose2.r) x6.o.g(new Callable() { // from class: c8.y1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k6.q3(this.f2924e, eVar, strX);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: c8.z1
            @Override // a7.e
            public final void accept(Object obj) {
                k6.w4(this.f2956e, eVar, (w.d) obj);
            }
        }, new x7.g0());
    }

    public final void p9() {
        if (this.f2596u0 == null) {
            this.f2596u0 = (com.tuyafeng.support.widget.a) new h6.a(new com.tuyafeng.support.widget.a(I()), new FrameLayout.LayoutParams(-1, -2)).l();
            mark.via.common.widget.g0 g0Var = (mark.via.common.widget.g0) new h6.a(new mark.via.common.widget.g0(I()), new FrameLayout.LayoutParams(-1, g6.f.d(I(), x7.n.f13683b))).l();
            this.f2598v0 = g0Var;
            this.f2596u0.addView(g0Var);
            this.f2596u0.setDragDistance(g6.y.h(I(), 84.0f));
            this.f2596u0.g(new a.b() { // from class: c8.q1
                @Override // com.tuyafeng.support.widget.a.b
                public final void a(float f10, boolean z10) throws Resources.NotFoundException {
                    k6.W4(this.f2774a, f10, z10);
                }
            });
            this.f2598v0.setOnItemClickListener(this.H1);
            this.f2598v0.setOnItemLongClickListener(this.K1);
        }
    }

    public final void pa(String str) throws URISyntaxException {
        Intent intentF = z8.f1.f(I(), str);
        if (intentF == null) {
            g6.n.q(I(), x7.u.f14120p9);
            return;
        }
        try {
            P2(intentF);
        } catch (ActivityNotFoundException unused) {
            g6.n.q(I(), x7.u.f14120p9);
        }
    }

    public final void pb() throws Resources.NotFoundException {
        if (this.f2578k1 || this.f2597u1 || !this.Y0 || this.f2589q1) {
            return;
        }
        if (this.f2594t0 == null) {
            k9();
        }
        x.r.c(this.f2594t0).j(new Runnable() { // from class: c8.g4
            @Override // java.lang.Runnable
            public final void run() {
                k6.S3(this.f2462e);
            }
        }).h(0.0f).a(1.0f).d(160L).f();
        this.f2597u1 = true;
    }

    @Override // e8.i0.a
    public void q(String str) {
        new z8.t2(this).p(str);
    }

    public final void q8(String str) {
        if (g6.p.f(str)) {
            return;
        }
        mb(new e.b().j(str).k(this.f2582n0.L1()).c("attachment").g(URLUtil.isNetworkUrl(str) ? "image/*" : null).i(S8()).d(-1L).b());
    }

    public final void q9() {
        if (this.f2602x0 == null) {
            mark.via.common.widget.n0 n0Var = (mark.via.common.widget.n0) new h6.a(new mark.via.common.widget.n0(I()), new FrameLayout.LayoutParams(-1, g6.f.d(I(), x7.n.F))).l();
            this.f2602x0 = n0Var;
            n0Var.setOnItemClickListener(this.H1);
            this.f2602x0.setOnItemLongClickListener(this.K1);
            this.f2602x0.setOnDragListener(new View.OnDragListener() { // from class: c8.y0
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view, DragEvent dragEvent) {
                    return k6.v4(this.f2923a, view, dragEvent);
                }
            });
            this.U0 = -1;
        }
    }

    public final void qa(final Message message) {
        final t4.b bVarP;
        if (message == null) {
            return;
        }
        final WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        if (webViewTransport == null) {
            message.sendToTarget();
            return;
        }
        final String strS8 = S8();
        this.f2580m0.i1("", true);
        r4.a aVarK0 = this.f2580m0.K0();
        if (aVarK0 == null || (bVarP = aVarK0.p()) == null) {
            message.sendToTarget();
        } else {
            bVarP.post(new Runnable() { // from class: c8.l1
                @Override // java.lang.Runnable
                public final void run() {
                    k6.b5(bVarP, strS8, webViewTransport, message);
                }
            });
        }
    }

    public final void qb(final boolean z10, final int i10) {
        final String strS8 = S8();
        final int iT0 = this.f2580m0.T0(strS8);
        final int iF0 = this.f2582n0.F0();
        final boolean z11 = iT0 > 0 || z10;
        if (z11 && iT0 == 0) {
            iT0 = iF0;
        }
        if (!z11) {
            iT0 = iF0;
        }
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -2)).V(new a.InterfaceC0076a() { // from class: c8.q0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        final TextView textView = (TextView) new h6.a(new TextView(I()), new LinearLayout.LayoutParams(-1, -2)).r(1, 0, 16, 0, 16).V(new a.InterfaceC0076a() { // from class: c8.r0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k6.p5(this.f2794a, iT0, (TextView) obj);
            }
        }).l();
        final int i11 = iT0;
        mark.via.common.widget.w0 w0Var = (mark.via.common.widget.w0) new h6.a(new mark.via.common.widget.w0(new ContextThemeWrapper(l0(), x7.v.f14259f)), new LinearLayout.LayoutParams(-1, -2)).H(1, 16, 0, 16, 0).t(1, 16).V(new a.InterfaceC0076a() { // from class: c8.s0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                k6.g5(this.f2811a, i11, z11, iF0, textView, strS8, (mark.via.common.widget.w0) obj);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(w0Var);
        if (z11) {
            linearLayout.addView((TextView) new h6.a(new TextView(I()), new LinearLayout.LayoutParams(-1, -2)).r(1, 0, 2, 0, 8).V(new a.InterfaceC0076a() { // from class: c8.t0
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    k6.f6(this.f2835a, (TextView) obj);
                }
            }).l());
        }
        w5.k.l(I()).y(linearLayout).s(2).T(new DialogInterface.OnCancelListener() { // from class: c8.u0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                k6.X3(this.f2854e, z10, i10, dialogInterface);
            }
        }).f0();
    }

    @Override // e8.n0.a
    public void r(t4.b bVar) {
        if (bVar == null && this.f2586p0.getChildCount() == 0) {
            return;
        }
        if (this.f2586p0.getChildCount() == 1 && this.f2586p0.getChildAt(0) == bVar) {
            return;
        }
        this.f2586p0.removeAllViews();
        if (bVar == null) {
            return;
        }
        bVar.setFocusable(true);
        this.f2586p0.addView(bVar);
    }

    public final void r8(final String str, final String str2, final int i10) {
        x6.o oVarI;
        if (i10 == 0) {
            return;
        }
        i6.i0 i0Var = i6.i0.f7006a;
        if (i0Var.k(str2)) {
            oVarI = x6.o.g(new Callable() { // from class: c8.w
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return k6.g3(this.f2889e, str2, str);
                }
            });
        } else {
            if (!i0Var.s(str)) {
                g6.n.q(I(), x7.u.M1);
                return;
            }
            String strG = z8.v0.g(str);
            String strC = mark.via.download.i1.c(str, "image/*");
            String strB = l5.c.b(strC);
            if (strB != null) {
                strG = strG + "." + strB;
            }
            final File file = new File(z8.c1.k(I(), "download", strG));
            final g5.c cVar = new g5.c();
            cVar.J(file.getName());
            cVar.S(str);
            cVar.M(S8());
            cVar.I(strC);
            cVar.N(true);
            cVar.x(1);
            cVar.P(80);
            cVar.C(Uri.fromFile(file));
            oVarI = x6.o.g(this.P0.l(cVar)).i(new a7.f() { // from class: c8.x
                @Override // a7.f
                public final Object apply(Object obj) {
                    return k6.B3(cVar, file, (m5.j) obj);
                }
            });
        }
        ((autodispose2.r) oVarI.l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).b(new a7.e() { // from class: c8.y
            @Override // a7.e
            public final void accept(Object obj) {
                k6.M5(this.f2920e, str, i10, (x5.a) obj);
            }
        });
    }

    public final void r9() {
        this.f2606z0 = this.f2584o0.f2933e;
        Window window = l0().getWindow();
        if (window != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                window.setNavigationBarContrastEnforced(false);
            }
            if (i10 >= 21) {
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                if (i10 >= 28) {
                    window.setNavigationBarDividerColor(0);
                }
            }
        }
        this.f2584o0.f2936l.setOnClickListener(this.H1);
        y7 y7Var = this.f2584o0;
        this.f2604y0 = y7Var.f2938n;
        this.f2600w0 = y7Var.f2939o;
        this.f2586p0 = y7Var.f2934j;
        this.f2588q0 = y7Var.f2935k;
        p9();
        q9();
    }

    public final void ra(int i10) throws Resources.NotFoundException {
        int i11 = 0;
        switch (i10) {
            case 1:
                wa();
                break;
            case 2:
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                z8.b0.V(O8(), i10 != 2 ? 1 : 0);
                break;
            case 4:
                ub();
                na();
                break;
            case 5:
                this.f2580m0.j1(null, true);
                break;
            case 6:
                P7();
                break;
            case 7:
            case 8:
                ja(i10 == 7);
                break;
            case 9:
                this.f2580m0.B0();
                break;
            case 10:
            case 11:
                int iL0 = this.f2580m0.L0() + (i10 == 10 ? -1 : 1);
                int i12 = this.L0.i();
                if (iL0 < 0) {
                    i11 = i12 - 1;
                } else if (iL0 < i12) {
                    i11 = iL0;
                }
                this.f2580m0.X1(i11);
                d9();
                break;
            case 12:
            case 13:
                if (i10 != 12) {
                    V8();
                    break;
                } else {
                    U8();
                    break;
                }
            case 14:
                if (!d9()) {
                    nb();
                    break;
                }
                break;
            case 15:
                this.f2580m0.Z1();
                break;
            case 16:
                Da();
                break;
            case 17:
            case 18:
                z8.b0.V(O8(), i10 != 17 ? 3 : 2);
                break;
            case 19:
                this.f2580m0.P1();
                break;
            case 20:
                this.f2580m0.i2();
                break;
            case 21:
            case 22:
                E8(i10 == 21);
                break;
            case 23:
                if (!d9()) {
                    Cb();
                    break;
                }
                break;
            case 24:
                va(d());
                break;
            case 25:
                Kb();
                break;
            case 26:
                g6.i.g(this, hb.o6.class);
                break;
            case 27:
                s8(d());
                break;
            case 28:
                ca();
                break;
            case 29:
                ba();
                break;
            case 30:
                W9();
                break;
        }
    }

    public final void rb(final HttpAuthHandler httpAuthHandler, final String str, String str2) {
        final String str3 = "https://" + str;
        N0().y1("url", this, new androidx.fragment.app.i0() { // from class: c8.a6
            @Override // androidx.fragment.app.i0
            public final void a(String str4, Bundle bundle) {
                k6.h5(this.f2330a, httpAuthHandler, str, str3, str4, bundle);
            }
        });
        za.v3(str3).h3(N0(), null);
    }

    @Override // e8.k.a
    public void s(ValueCallback valueCallback) {
        this.E0 = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        R2(Intent.createChooser(intent, Z0(x7.u.Wf)), 111);
    }

    public final void s8(r4.a aVar) {
        int iE;
        if (aVar != null && (iE = e(aVar.getId())) >= 0) {
            this.f2580m0.h1(new r4.b(aVar.b()), true, iE + 1);
        }
    }

    public final void s9() {
        o9();
        c5.b bVarR = c5.b.r(I());
        this.P0 = bVarR;
        if (!bVarR.o()) {
            this.P0.k();
        }
        this.O0 = mark.via.download.j1.e();
        this.Z0 = g6.y.E(I());
        this.C1 = T0().getConfiguration().orientation;
        this.N0 = new GestureDetector(l0(), new q());
        o4.c cVar = new o4.c(I());
        this.L0 = cVar;
        cVar.l(new r());
        this.L0.l(new e8.n0(this.f2582n0, this));
        this.L0.l(new e8.e0());
        this.L0.l(new e8.j(d8.d.c(), this));
        this.L0.l(new e8.k(this));
        this.L0.l(new e8.l(I(), this));
        this.L0.l(new e8.c0(this));
        this.L0.l(new e8.i(pa.r.k(), this.f2582n0, this));
        this.L0.l(new e8.h0(this.f2582n0));
        this.f2581m1 = new s();
        this.L0.l(new e8.i0(this));
        this.L0.l(new e8.b0());
        e8.m mVar = new e8.m();
        mVar.G(new t());
        this.L0.l(mVar);
        this.L0.l(new e8.k0(d8.g.c(), this.f2582n0, this));
        this.L0.l(new e8.y0(pa.r.k(), this.f2582n0, new u()));
        this.L0.r(this);
    }

    public final void sa() throws Resources.NotFoundException {
        String strD = g6.n.d(I());
        if (strD == null || strD.isEmpty()) {
            return;
        }
        final List listE = i6.g0.f6993a.e(strD);
        if (listE.size() > 1) {
            w5.k.l(I()).d0(x7.u.f14193v3).J(strD).F((String[]) listE.toArray(new String[0]), new AdapterView.OnItemClickListener() { // from class: c8.c0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    this.f2362a.f2580m0.i1((String) listE.get(i10), true);
                }
            }).V(x7.u.f14022i9, new k.m() { // from class: c8.d0
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    k6.T5(this.f2390a, listE, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
            return;
        }
        if (!listE.isEmpty()) {
            strD = (String) listE.get(0);
        }
        Ra(strD);
    }

    public final void sb() {
        int i10 = this.W0;
        z0().q().c(x7.p.C, f8.q.class, f8.d.f().g(((i10 == 1 || i10 == 4) ? 48 : 80) | 8388613).j(N8()).a(), f8.q.f6015u0).g(null).i();
        e9();
    }

    @Override // e8.n0.a
    public void t(String str, String str2, SslCertificate sslCertificate) {
        if (str2 != null) {
            int length = str2.length();
            str2 = z8.w2.f(str2);
            if (length != str2.length()) {
                str = z8.b0.E(str2);
            }
        }
        if (u9.d.m(I(), str2)) {
            this.f2602x0.setTitle(str);
        } else {
            if (this.f2582n0.g1() != 0 || this.f2569b1) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = Z0(x7.u.bh);
            }
            this.f2602x0.setTitle(z8.b0.G(str, str2));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(int i10, int i11, Intent intent) {
        Uri[] result = null;
        if (i10 == 911) {
            if (intent == null || !intent.hasExtra("data")) {
                return;
            }
            final String stringExtra = intent.getStringExtra("data");
            w5.k.l(I()).d0(x7.u.f14193v3).J(stringExtra).u(false).V(R.string.ok, new k.m() { // from class: c8.z4
                @Override // w5.k.m
                public final void a(View view, k.p pVar) throws Resources.NotFoundException {
                    this.f2960a.Ra(stringExtra);
                }
            }).N(R.string.cancel, null).R(R.string.copy, new View.OnClickListener() { // from class: c8.a5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k6 k6Var = this.f2328a;
                    g6.n.b(k6Var.I(), stringExtra, k6Var.T0().getString(x7.u.og));
                }
            }).f0();
            return;
        }
        if (i10 == 111) {
            if (Build.VERSION.SDK_INT < 21) {
                if (this.E0 == null) {
                    return;
                }
                this.E0.onReceiveValue((intent == null || i11 != -1) ? null : intent.getData());
                this.E0 = null;
                return;
            }
            if (this.F0 == null) {
                return;
            }
            if (i11 == -1) {
                try {
                    ClipData clipData = intent.getClipData();
                    if (clipData != null) {
                        result = new Uri[clipData.getItemCount()];
                        for (int i12 = 0; i12 < clipData.getItemCount(); i12++) {
                            result[i12] = clipData.getItemAt(i12).getUri();
                        }
                    }
                } catch (Exception e10) {
                    pc.a.b(e10);
                }
            }
            if (result == null || result.length == 0) {
                result = WebChromeClient.FileChooserParams.parseResult(i11, intent);
            }
            this.F0.onReceiveValue(result);
        }
    }

    public final void t8(String str) {
        u8(str, "");
    }

    public final void t9(String str) {
        new z8.t2(this).o(str);
    }

    public final void ta() {
        X7();
        Y7();
        this.f2604y0.setVisibility(0);
        this.f2600w0.setVisibility(0);
        db(this.f2591r1);
    }

    public final void tb() {
        if (d9()) {
            return;
        }
        z0().y1("menu_result", d1(), new androidx.fragment.app.i0() { // from class: c8.b4
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) throws Resources.NotFoundException, URISyntaxException, PackageManager.NameNotFoundException {
                k6.X5(this.f2350a, str, bundle);
            }
        });
        int i10 = this.W0 == 1 ? 48 : 80;
        i8.k.y3(S8(), Q8(), N8(), i10 | 8388613).h3(z0(), null);
    }

    @Override // c8.pa
    public boolean u(String str) throws Resources.NotFoundException {
        Object obj;
        if (str != null && str.length() >= 6 && "via://".equalsIgnoreCase(str.substring(0, 6))) {
            str = "v://" + str.substring(6);
        }
        if (z8.w2.t(str)) {
            String strSubstring = str.substring(9);
            int iD = u9.d.d(I(), S8());
            if (iD == 2 || iD == 11) {
                this.f2580m0.s1(strSubstring.isEmpty() ? 2 : 11, strSubstring);
            } else {
                Z9(Uri.decode(strSubstring));
            }
            return true;
        }
        if (z8.w2.u(str)) {
            this.f2580m0.s1(3, null);
            return true;
        }
        if (!z8.w2.z(str)) {
            if (str.startsWith("thunder://") || str.startsWith("qqdl://") || str.startsWith("flashget://")) {
                String strD = z8.b0.D(str);
                if (!TextUtils.isEmpty(strD)) {
                    mb(new e.b().j(strD).k(this.f2582n0.L1()).c("attachment").d(-1L).b());
                }
                return true;
            }
            if (str.startsWith("baidubox://") || str.startsWith("baiduboxapp://") || str.startsWith("baiduboxlite://")) {
                return true;
            }
            if (Build.VERSION.SDK_INT < 21 || !str.startsWith("file://") || !"pdf".equals(i6.i0.f7006a.c(str))) {
                return V9(str);
            }
            g6.i.h(this, za.g.class, v5.a.b().e("pdfPath", str).a());
            return true;
        }
        if (z8.w2.o(str)) {
            final String strB = z8.w2.b(str);
            i6.i0 i0Var = i6.i0.f7006a;
            if (i0Var.s(strB)) {
                this.f2580m0.n0(i0Var.f(strB));
                this.f2606z0.post(new Runnable() { // from class: c8.w4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2896e.y9(strB);
                    }
                });
            }
            return true;
        }
        if (z8.w2.r(str)) {
            final String strF = z8.w2.f(str);
            if (!TextUtils.isEmpty(strF) && !i6.i0.f7006a.p(strF)) {
                this.f2606z0.post(new Runnable() { // from class: c8.x4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2912e.y9(strF);
                    }
                });
            }
            return true;
        }
        if (z8.w2.w(str)) {
            ga();
            return true;
        }
        if (z8.w2.y(str)) {
            g6.i.g(this, lb.k.class);
            return true;
        }
        if (z8.w2.x(str)) {
            String strK = z8.w2.k(str);
            if (strK == null || strK.isEmpty()) {
                na();
            } else {
                Ta(strK, true);
            }
            return true;
        }
        if (z8.w2.s(str)) {
            if (u9.d.d(I(), S8()) == 5) {
                this.f2580m0.s1(3, null);
            } else {
                fa();
            }
            return true;
        }
        if (z8.w2.q(str)) {
            ca();
            return true;
        }
        if (z8.w2.v(str)) {
            ha();
            return true;
        }
        if (z8.w2.p(str)) {
            w.d dVarH = z8.w2.h(str);
            int iD2 = u9.d.d(I(), S8());
            if (iD2 == 2 || iD2 == 11 || iD2 == 5) {
                this.f2580m0.s1(g6.p.f((String) dVarH.f13207a) ? 2 : 11, (String) dVarH.f13207a);
            } else if (iD2 == 1) {
                X9((String) dVarH.f13207a, (String) dVarH.f13208b);
            } else {
                aa((String) dVarH.f13207a);
            }
            return true;
        }
        if (z8.w2.B(str)) {
            Eb(z8.w2.m(str));
            return true;
        }
        if (!z8.w2.A(str)) {
            int iIntValue = ((Integer) z8.b0.Q(str).f13207a).intValue();
            if (iIntValue != 1) {
                this.f2580m0.s1(iIntValue, null);
            } else {
                this.f2580m0.V0();
            }
            return true;
        }
        w.d dVarJ = z8.w2.j(str);
        if (dVarJ != null && (obj = dVarJ.f13207a) != null && ((String[]) obj).length > 0) {
            this.f2580m0.F1((String[]) obj, (String) dVarJ.f13208b);
        }
        return true;
    }

    public final void u8(final String str, final String str2) {
        if (str == null || u9.d.m(I(), str)) {
            e8("https://", "");
            return;
        }
        if (str2 == null) {
            str2 = Z0(x7.u.bh);
        }
        ((autodispose2.m) x6.f.h(new Callable() { // from class: c8.c4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k6.c6(str, str2);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: c8.d4
            @Override // a7.e
            public final void accept(Object obj) {
                k6.n4(this.f2398e, (o9.b) obj);
            }
        }, new x7.c0());
    }

    public final boolean u9(String str) {
        return str == null || str.isEmpty() || !str.equals(this.f2573f1);
    }

    public final void ua() {
        h8(O8());
    }

    public final void ub() throws Resources.NotFoundException {
        if (this.X0 == 0 || this.D1) {
            return;
        }
        if (!this.f2589q1 || this.f2591r1 > 0.0f) {
            S7(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        l0().h().h(this, this.f2585o1);
        z0().l(new androidx.fragment.app.h0() { // from class: c8.z3
            @Override // androidx.fragment.app.h0
            public final void k(FragmentManager fragmentManager, Fragment fragment) {
                k6.R5(this.f2959e, fragmentManager, fragment);
            }
        });
        I().registerComponentCallbacks(this);
    }

    public final void v8(String str) {
        N0().y1("bookmarkDialogResult2", this, new androidx.fragment.app.i0() { // from class: c8.j5
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                k6.a6(this.f2541a, str2, bundle);
            }
        });
        b8.n.o3(str).h3(z0(), b8.n.class.getSimpleName());
    }

    public final boolean v9() {
        return this.f2574g1 > 0;
    }

    public final void va(r4.a aVar) {
        t4.b bVarP = aVar == null ? null : aVar.p();
        if (Build.VERSION.SDK_INT <= 19 || bVarP == null || !bVarP.isShown()) {
            return;
        }
        final String url = bVarP.getUrl();
        if (!this.f2580m0.e1(url)) {
            g6.n.q(I(), x7.u.N1);
            return;
        }
        if (this.I1 == null) {
            this.I1 = j8.c.n(I());
            j8.d dVar = new j8.d() { // from class: c8.e4
                @Override // j8.d
                public final void a(j8.t tVar) {
                    this.f2421e.xb(tVar, false);
                }
            };
            this.f2575h1 = dVar;
            this.I1.b(dVar);
            this.I1.g().g(this.f2582n0.O());
        }
        int iE = this.I1.g().e();
        if (iE != 0 && iE != 1 && iE != 2) {
            g6.n.q(I(), x7.u.Og);
            return;
        }
        g6.n.q(I(), x7.u.Nh);
        final String strReplace = UUID.randomUUID().toString().replace("-", "");
        final String title = bVarP.getTitle();
        final int i10 = 0;
        i6.c0.f6985a.o(new i6.e(bVarP), new q7.l() { // from class: c8.f4
            @Override // q7.l
            public final Object invoke(Object obj) {
                return k6.G3(this.f2438e, strReplace, url, title, i10, (String) obj);
            }
        });
    }

    public final void vb() {
        z0().y1("passresult", this, new androidx.fragment.app.i0() { // from class: c8.a0
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                k6.A3(this.f2322a, str, bundle);
            }
        });
        va.c0.x3(i6.i0.f7006a.e(S8())).h3(z0(), va.c0.class.getSimpleName());
    }

    public final void w8(String str) {
        x8(str, null);
    }

    public final boolean w9() {
        return N0().u0() == 0;
    }

    public final void wa() {
        r4.a aVarD = this.L0.d();
        if (d9() || aVarD == null) {
            return;
        }
        d8.g.c().e(aVarD.getUrl());
        aVarD.c();
    }

    public final void wb(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (str.length() > 1024) {
            g6.n.r(I(), x7.u.B7, x7.u.f14150s, new View.OnClickListener() { // from class: c8.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g6.n.a(this.f2756a.I(), str, x7.u.pg);
                }
            });
        } else {
            rb.s3(str).h3(z0(), null);
        }
    }

    public final void x8(String str, String str2) {
        if (g6.i.d(this)) {
            return;
        }
        N0().y1("fav_result", this, new androidx.fragment.app.i0() { // from class: c8.x0
            @Override // androidx.fragment.app.i0
            public final void a(String str3, Bundle bundle) {
                k6.P3(this.f2908a, str3, bundle);
            }
        });
        qa.h0.G3(str, str2).h3(z0(), qa.h0.class.getSimpleName());
    }

    public final void x9() {
        N0().y1("result", this, new androidx.fragment.app.i0() { // from class: c8.h4
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) throws Resources.NotFoundException {
                k6.K3(this.f2482a, str, bundle);
            }
        });
    }

    public final void xa(boolean z10) {
        r4.a aVarD = this.L0.d();
        if (d9() || aVarD == null) {
            return;
        }
        String strM = i6.h.f6994a.m(aVarD.getUrl(), z10 | this.Z0);
        if (strM == null || strM.isEmpty()) {
            aVarD.c();
        } else {
            d8.g.c().e(strM);
            aVarD.v(strM);
        }
    }

    public final void xb(j8.t tVar, boolean z10) {
        if (c1() == null) {
            return;
        }
        if (tVar == null || this.f2576i1 == null) {
            if (this.f2577j1 != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("y", (int) this.f2577j1.getTranslationY());
                v5.b.d().e(mark.via.common.widget.k1.class.getName(), bundle);
                x.r.c(this.f2577j1).a(0.0f).d(100L).i(new Runnable() { // from class: c8.l4
                    @Override // java.lang.Runnable
                    public final void run() {
                        k6.x4(this.f2655e);
                    }
                }).f();
                return;
            }
            return;
        }
        if (z10 && this.f2577j1 != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("y", (int) this.f2577j1.getTranslationY());
            v5.b.d().e(mark.via.common.widget.k1.class.getName(), bundle2);
            ViewGroup viewGroup = (ViewGroup) this.f2577j1.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f2577j1);
            }
            this.f2577j1 = null;
        }
        if (this.f2577j1 == null) {
            mark.via.common.widget.k1 k1Var = (mark.via.common.widget.k1) new h6.a(new mark.via.common.widget.k1(I()), new RelativeLayout.LayoutParams(-2, -2)).l();
            this.f2577j1 = k1Var;
            k1Var.setCallback(new k1.a() { // from class: c8.m4
                @Override // mark.via.common.widget.k1.a
                public final void a(int i10) {
                    k6.E3(this.f2675a, i10);
                }
            });
            this.f2577j1.setAlpha(0.0f);
            this.f2606z0.addView(this.f2577j1);
            Bundle bundleC = v5.b.d().c(mark.via.common.widget.k1.class.getName());
            int height = bundleC != null ? bundleC.getInt("y", -1) : -1;
            if (height == -1) {
                height = this.f2606z0.getHeight() / 2;
            }
            this.f2577j1.setTranslationY(height);
            x.r.c(this.f2577j1).a(1.0f).d(100L).f();
        }
        pc.a.a("playing: %s", Boolean.valueOf(tVar.h()));
        this.f2577j1.setPlaying(tVar.h());
    }

    @Override // e8.i.a
    public d8.e y() {
        if (this.K0 == null) {
            this.K0 = new v(this, null);
        }
        return this.K0;
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        pa.r.b(I()).h().a(this).a(this);
        boolean z10 = false;
        if (y0() != null && y0().getBoolean("CUSTOM_TAB", false)) {
            z10 = true;
        }
        this.f2583n1 = z10;
        z0().m(new FragmentManager.m() { // from class: c8.x3
            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void a(androidx.activity.b bVar) {
                androidx.fragment.app.e0.c(this, bVar);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void b(Fragment fragment, boolean z11) {
                androidx.fragment.app.e0.b(this, fragment, z11);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void c(Fragment fragment, boolean z11) {
                androidx.fragment.app.e0.d(this, fragment, z11);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void d() {
                androidx.fragment.app.e0.a(this);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public final void onBackStackChanged() {
                this.f2911a.Lb();
            }
        });
    }

    public final void y8() {
        final FragmentManager fragmentManagerN0 = N0();
        fragmentManagerN0.y1("edit_text_result", this, new androidx.fragment.app.i0() { // from class: c8.n0
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                k6.y5(this.f2685a, fragmentManagerN0, str, bundle);
            }
        });
        g6.i.h(this, hb.i1.class, hb.i1.g3(Z0(x7.u.N2), this.f2582n0.y0(), Z0(x7.u.N2), true));
    }

    public final void y9(String str) {
        r4.a aVarD = this.L0.d();
        if (d9() || aVarD == null || str == null || str.isEmpty()) {
            return;
        }
        aVarD.v(str);
    }

    public final void ya() {
        final String strS8 = S8();
        if (i6.i0.f7006a.s(strS8)) {
            final int[] iArr = {1, 2, 4};
            w5.k.l(I()).d0(x7.u.Va).a0(new String[]{Z0(x7.u.Qa), Z0(x7.u.Oa), Z0(x7.u.Pa)}, -1).i("", Z0(x7.u.Sa), 1).V(R.string.ok, new k.m() { // from class: c8.z
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    k6.s3(this.f2950a, iArr, strS8, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
        }
    }

    public final void yb(String str) {
        if (g6.i.d(this)) {
            return;
        }
        if (u9.d.m(I(), str)) {
            str = null;
        }
        ua.y.n3(str).h3(z0(), ua.y.class.getSimpleName());
    }

    @Override // e8.l.a
    public void z(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback) {
        pc.a.a("on show custom view", new Object[0]);
        if (view == null) {
            return;
        }
        if (this.f2590r0 != null && this.G0 != null) {
            try {
                customViewCallback.onCustomViewHidden();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        this.H0 = SystemClock.elapsedRealtime();
        if (this.I0 > 1) {
            this.f2582n0.m(0);
        }
        this.L1 = l0().getRequestedOrientation();
        view.setKeepScreenOn(true);
        this.f2590r0 = view;
        pc.a.a("custom view: %s", view);
        this.G0 = customViewCallback;
        FrameLayout frameLayout = (FrameLayout) l0().getWindow().getDecorView();
        this.f2592s0 = (com.tuyafeng.support.widget.v) new h6.a(new com.tuyafeng.support.widget.v(I()), new FrameLayout.LayoutParams(-1, -1)).f(-16777216).l();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.addView(this.f2592s0, layoutParams);
        this.f2592s0.addView(this.f2590r0, 0, layoutParams);
        this.f2592s0.setTitle(Q8());
        this.f2592s0.postDelayed(new Runnable() { // from class: c8.q4
            @Override // java.lang.Runnable
            public final void run() {
                k6.A5(this.f2780e);
            }
        }, 150L);
        this.f2586p0.setVisibility(4);
        ab(true);
        f9(false);
        Lb();
    }

    public final void z8() {
        if (O8() == null) {
            return;
        }
        y9(db.a(A0()));
    }

    public final void z9(int i10, int i11, String str, String str2, String str3) {
        A9(i10, i11, str, str2, str3, false);
    }

    public final void za(final mark.via.download.e eVar) {
        this.P1 = null;
        String strX = this.f2582n0.x();
        if (z8.b1.o(strX)) {
            this.P1 = eVar;
            final Uri uri = Uri.parse(strX);
            w5.k.l(I()).e0(Z0(x7.u.dg)).J(Z0(x7.u.f14007h8)).V(R.string.ok, new k.m() { // from class: c8.r
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    k6.W5(this.f2791a, eVar, uri, view, pVar);
                }
            }).N(R.string.cancel, null).f0();
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23 || i10 >= 29) {
            return;
        }
        this.P1 = eVar;
        try {
            this.R1.a("android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    public final void zb() {
        if (this.f2584o0.l()) {
            this.f2586p0.setImportantForAccessibility(4);
            z8.l.c(this.B0);
        }
    }
}
