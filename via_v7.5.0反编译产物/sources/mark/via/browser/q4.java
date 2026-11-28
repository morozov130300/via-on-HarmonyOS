package mark.via.browser;

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
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.print.PrintAttributes;
import android.print.PrintManager;
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
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
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
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.tuyafeng.support.utils.FragmentUtils;
import com.tuyafeng.wormhole.AdMarkingBridge;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import mark.via.Shell;
import mark.via.common.widget.GestureTouchEvent;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q4 extends Fragment implements m8.b, r8, r4.f, ComponentCallbacks2, m8.d, c8.g1.a, c8.d0.a, c8.v0.a, c8.i.a, c8.b1.a, c8.d1.a, c8.j.a, androidx.fragment.app.h0 {
    public LinearLayout A0;
    public ViewGroup B0;
    public mark.via.common.widget.t C0;
    public mark.via.common.widget.m D0;
    public BroadcastReceiver F0;
    public c8.b0 G0;
    public c8.v1.a G1;
    public i8.o H0;
    public String[] H1;
    public i8.o I0;
    public long J1;
    public s8 K0;
    public com.tuyafeng.support.widget.e0 K1;
    public b8.e L0;
    public p4.a M0;
    public ab.a N0;
    public GestureDetector O0;
    public DownloadController P0;
    public c8.f0 Q0;
    public oa.k1 R0;
    public PageImageActions S0;
    public int U0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public String f9476f1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public mark.via.browser.c f9479i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public ReadAloudController f9480j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public ReadModeController f9481k1;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public p8 f9485o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public u9.l f9487p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public z5 f9489q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public r5 f9491r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public FrameLayout f9493s0;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public ValueAnimator f9494s1;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ProgressBar f9495t0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public boolean f9496t1;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public c8.d0 f9497u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ImageView f9499v0;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f9500v1;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public nd f9501w0;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public int[] f9502w1;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public mark.via.common.widget.g0 f9503x0;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public GestureTouchEvent f9504x1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public LinearLayout f9505y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public mark.via.common.widget.n0 f9507z0;
    public final PassController E0 = new PassController(this, new a0(this));
    public final androidx.activity.result.b J0 = w2(new e.g(), new androidx.activity.result.a() { // from class: mark.via.browser.l0
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            q4.Q4(this.f9290a, (Boolean) obj);
        }
    });
    public long T0 = 0;
    public boolean V0 = false;
    public int W0 = -1;
    public int X0 = -1;
    public boolean Y0 = false;
    public boolean Z0 = false;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public boolean f9471a1 = false;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f9472b1 = false;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public final ColorDrawable f9473c1 = new ColorDrawable(0);

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public long f9474d1 = -1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public WeakReference f9475e1 = null;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final FreeSelectController f9477g1 = new FreeSelectController(this);

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public int f9478h1 = 0;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public boolean f9482l1 = false;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f9483m1 = false;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public pa.a.InterfaceC0111a f9484n1 = null;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public boolean f9486o1 = false;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final androidx.activity.o f9488p1 = new k(true);

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public boolean f9490q1 = true;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public float f9492r1 = 0.0f;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public boolean f9498u1 = false;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f9506y1 = false;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public int f9508z1 = 0;
    public boolean A1 = false;
    public boolean B1 = false;
    public boolean C1 = false;
    public final p5.c D1 = new c();
    public boolean E1 = false;
    public final View.OnLongClickListener F1 = new e();
    public final androidx.activity.result.b I1 = w2(new e.f(), new androidx.activity.result.a() { // from class: mark.via.browser.w0
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            q4.C3(this.f9715a, (Map) obj);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements mark.via.common.widget.m.d {
        public a() {
        }

        @Override // mark.via.common.widget.m.d
        public void a() {
            FragmentUtils.i(q4.this, hb.b6.class);
        }

        @Override // mark.via.common.widget.m.d
        public boolean b(ga.c cVar) {
            String strU7 = q4.this.u7();
            x.d dVarI = q4.this.D0.i(strU7);
            if (cVar == null || dVarI == null || TextUtils.isEmpty((CharSequence) dVarI.f14456b)) {
                return false;
            }
            String str = (String) dVarI.f14456b;
            c6.r1 r1VarC = x8.q2.c(cVar.d(), cVar.a());
            String strE = r1VarC.e(q4.this.f9485o0.e1(strU7));
            r4.a aVarD = q4.this.d();
            if (aVarD != null) {
                List listZ = aVarD.z();
                for (int size = listZ.size() - 1; size >= 0; size--) {
                    if (str.equalsIgnoreCase(c6.y1.f2139a.g((String) listZ.get(size), strE)) && aVarD.q(size)) {
                        return true;
                    }
                }
            }
            final String strH = c6.y1.f2139a.h(strE, str);
            if (strH.isEmpty()) {
                return false;
            }
            if (!c6.a2.f1958a.u(strH)) {
                q5.k.l(q4.this.G()).f0(w7.u.f14184p7).K(strH).X(R.string.copy, new q5.k.m() { // from class: mark.via.browser.p4
                    @Override // q5.k.m
                    public final void a(View view, q5.k.p pVar) {
                        com.tuyafeng.support.utils.n.a(q4.this.G(), strH, w7.u.Eg);
                    }
                }).P(R.string.cancel, null).h0();
                return false;
            }
            r8.f.a().h(r1VarC.a());
            q4.this.f9485o0.m0(str);
            q4.this.Y7(strH);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements mark.via.common.widget.t0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9510a;

        public b() {
        }

        @Override // mark.via.common.widget.t0.c
        public void a() {
            q4.this.c9();
        }

        @Override // mark.via.common.widget.t0.c
        public void b(int i10) {
            if (i10 == 1) {
                q4 q4Var = q4.this;
                q4Var.P8(q4Var.f9487p0.x0());
                return;
            }
            if (i10 == 2) {
                q4 q4Var2 = q4.this;
                q4Var2.P8(q4Var2.f9487p0.e1());
            } else if (i10 == 4) {
                q4 q4Var3 = q4.this;
                q4Var3.P8(q4Var3.f9487p0.j2());
            } else {
                if (i10 != 8) {
                    return;
                }
                q4 q4Var4 = q4.this;
                q4Var4.P8(q4Var4.f9487p0.A2());
            }
        }

        @Override // mark.via.common.widget.t0.c
        public void c(int i10) {
            if (this.f9510a != i10) {
                this.f9510a = i10;
                mark.via.common.widget.u0.a(q4.this.f9499v0, i10, q4.this.f9487p0);
            }
        }

        @Override // mark.via.common.widget.t0.c
        public void d() {
            q4.this.K9();
        }

        /* JADX WARN: Code duplicated, block: B:19:0x005b  */
        /* JADX WARN: Code duplicated, block: B:23:0x0068  */
        @Override // mark.via.common.widget.t0.c
        public int[] e(View view, int i10, int i11) {
            int[] iArr = new int[2];
            int height = ((View) view.getParent()).getHeight();
            int width = ((View) view.getParent()).getWidth();
            int dimensionPixelSize = q4.this.R0().getDimensionPixelSize(w7.n.f13754g);
            int width2 = view.getWidth();
            int height2 = view.getHeight();
            int i12 = width / 3;
            int i13 = 0;
            if (i10 >= i12) {
                if (i10 <= i12 * 2) {
                    if (i11 >= ((height / 4) * 3) - dimensionPixelSize) {
                        iArr[0] = (width - width2) / 2;
                    } else if (i10 < width / 2) {
                        iArr[0] = dimensionPixelSize;
                    } else {
                        iArr[0] = (width - width2) - dimensionPixelSize;
                    }
                    if (i13 != 0 || i11 >= ((height / 4) * 3) - dimensionPixelSize) {
                        iArr[1] = (height - height2) - dimensionPixelSize;
                        i13 |= 80;
                    } else {
                        iArr[1] = (height - height2) / 2;
                    }
                    q4.this.f9487p0.p2(i13);
                    return iArr;
                }
                iArr[0] = (width - width2) - dimensionPixelSize;
                i13 = 5;
                if (i13 != 0) {
                    iArr[1] = (height - height2) - dimensionPixelSize;
                    i13 |= 80;
                } else {
                    iArr[1] = (height - height2) - dimensionPixelSize;
                    i13 |= 80;
                }
                q4.this.f9487p0.p2(i13);
                return iArr;
            }
            iArr[0] = dimensionPixelSize;
            i13 = 3;
            if (i13 != 0) {
                iArr[1] = (height - height2) - dimensionPixelSize;
                i13 |= 80;
            } else {
                iArr[1] = (height - height2) - dimensionPixelSize;
                i13 |= 80;
            }
            q4.this.f9487p0.p2(i13);
            return iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends p5.c {
        public c() {
        }

        @Override // p5.c
        public void a(View view) {
            int id = view.getId();
            if (id == mark.via.common.widget.n0.f9993x) {
                if (q4.this.D7()) {
                    return;
                }
                if (!q4.this.f9507z0.o() || q4.this.f9487p0.v().o()) {
                    q4.this.P9();
                    return;
                } else {
                    q4.this.f9481k1.s();
                    return;
                }
            }
            if (id == mark.via.common.widget.n0.f9995z) {
                if (q4.this.f9507z0.p()) {
                    q4.this.E8();
                    return;
                } else if (q4.this.f9507z0.n()) {
                    q4.this.T9();
                    return;
                } else {
                    q4.this.U8();
                    return;
                }
            }
            if (id == mark.via.common.widget.n0.A) {
                q4.this.D7();
                q4.this.L8();
                return;
            }
            if (id == mark.via.common.widget.n0.f9994y) {
                q4.this.f9485o0.v1();
                return;
            }
            if (id == mark.via.common.widget.g0.f9930r) {
                q4.this.w7();
                return;
            }
            if (id == mark.via.common.widget.g0.f9931s) {
                q4.this.x7();
                return;
            }
            if (id == mark.via.common.widget.g0.f9934v) {
                q4.this.J9();
                return;
            }
            if (id == mark.via.common.widget.g0.f9933u) {
                q4.this.P8(23);
                return;
            }
            if (id == mark.via.common.widget.g0.f9932t) {
                if (q4.this.D7()) {
                    return;
                }
                if (q4.this.M0.d() != null) {
                    q4.this.f9485o0.W0();
                    return;
                } else {
                    q4.this.f9485o0.k1(null, true);
                    return;
                }
            }
            if (id == w7.p.f13858c) {
                q4.this.P8(5);
            } else if (id == w7.p.J1) {
                q4.this.D7();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f9513a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f9514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f9515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f9516d;

        public d(TextView textView, boolean z10, String str) {
            this.f9514b = textView;
            this.f9515c = z10;
            this.f9516d = str;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            int i11 = (i10 * 5) + 50;
            this.f9514b.setText(String.format(Locale.ROOT, "%d%%", Integer.valueOf(i11)));
            WeakReference weakReference = this.f9513a;
            WebView webView = weakReference != null ? (WebView) weakReference.get() : null;
            if (webView != null) {
                webView.getSettings().setTextZoom(i11);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            t4.b bVarH = q4.this.H();
            if (bVarH == null || c6.a2.f1958a.m(bVarH.getUrl())) {
                this.f9513a = null;
            } else {
                this.f9513a = new WeakReference(bVarH);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int progress = (seekBar.getProgress() * 5) + 50;
            if (this.f9515c) {
                q4.this.f9485o0.R1(this.f9516d, progress);
            } else {
                q4.this.f9487p0.K(progress);
            }
            u9.n.e().w(true);
            q4.this.f9485o0.n1(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements View.OnLongClickListener {
        public e() {
        }

        public static /* synthetic */ void a(e eVar, View view) {
            q4.this.D7();
            q4 q4Var = q4.this;
            q4Var.M8(com.tuyafeng.support.utils.n.d(q4Var.G()));
        }

        public static /* synthetic */ void c(e eVar, List list, int i10, AdapterView adapterView, View view, int i11, long j10) {
            eVar.getClass();
            ga.c cVar = (ga.c) list.get(i11);
            if (cVar.d() == i10) {
                return;
            }
            if (x8.q2.g(cVar.d())) {
                q4.this.f9487p0.p1(cVar.a());
            }
            q4.this.f9487p0.s(cVar.d());
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int id = view.getId();
            if (id == mark.via.common.widget.g0.f9934v) {
                q4 q4Var = q4.this;
                q4Var.P8(q4Var.f9487p0.x1());
            } else if (id == mark.via.common.widget.g0.f9933u) {
                q4 q4Var2 = q4.this;
                q4Var2.P8(q4Var2.f9487p0.k0());
            } else if (id == mark.via.common.widget.g0.f9932t) {
                q4 q4Var3 = q4.this;
                q4Var3.P8(q4Var3.f9487p0.F());
            } else if (id == mark.via.common.widget.g0.f9931s) {
                q4 q4Var4 = q4.this;
                q4Var4.P8(q4Var4.f9487p0.d2());
            } else if (id == mark.via.common.widget.g0.f9930r) {
                q4 q4Var5 = q4.this;
                q4Var5.P8(q4Var5.f9487p0.n0());
            } else if (id == mark.via.common.widget.n0.f9994y) {
                q4.this.D7();
                q4.this.f9485o0.u1();
            } else {
                int i10 = 0;
                if (id == mark.via.common.widget.n0.A) {
                    final String strU7 = q4.this.u7();
                    if (!TextUtils.isEmpty(strU7) && !s9.d.l(q4.this.G(), strU7)) {
                        i10 = 1;
                    }
                    u5.a aVarE = u5.a.e(q4.this.G());
                    if (i10 != 0) {
                        aVarE.a(new u5.a.c(q4.this.X0(R.string.copy), new View.OnClickListener() { // from class: mark.via.browser.r4
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                com.tuyafeng.support.utils.n.a(q4.this.G(), strU7, w7.u.Fg);
                            }
                        }));
                    }
                    aVarE.a(new u5.a.c(q4.this.X0(R.string.paste), new View.OnClickListener() { // from class: mark.via.browser.s4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            q4.e.a(this.f9637a, view2);
                        }
                    })).a(new u5.a.c(q4.this.X0(w7.u.f14322za), new View.OnClickListener() { // from class: mark.via.browser.t4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            q4.this.Q8();
                        }
                    })).f(q4.this.f9507z0);
                } else if (id == mark.via.common.widget.n0.f9993x) {
                    final List listE = x8.q2.e(q4.this.G());
                    int size = listE.size();
                    String[] strArr = new String[size];
                    final int iM1 = q4.this.f9487p0.M1();
                    int i11 = -1;
                    while (i10 < size) {
                        strArr[i10] = ((ga.c) listE.get(i10)).g();
                        if (((ga.c) listE.get(i10)).d() == iM1) {
                            i11 = i10;
                        }
                        i10++;
                    }
                    q5.k.l(q4.this.G()).f0(w7.u.Xb).d0(strArr, i11, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.u4
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i12, long j10) {
                            q4.e.c(this.f9683a, listE, iM1, adapterView, view2, i12, j10);
                        }
                    }).h0();
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements d8.w.b {
        public f() {
        }

        @Override // d8.w.b
        public void a() {
            q4.this.D7();
            q4.this.ha();
        }

        @Override // d8.w.b
        public void b() {
            q4.this.D7();
            q4.this.O9();
        }

        @Override // d8.w.b
        public void c() {
            q4.this.D7();
            q4 q4Var = q4.this;
            q4Var.M9(q4Var.u7());
        }

        @Override // d8.w.b
        public void d() {
            q4.this.D7();
            q4 q4Var = q4.this;
            q4Var.A9(q4Var.u7());
        }

        @Override // d8.w.b
        public void e() {
            q4.this.D7();
            q4 q4Var = q4.this;
            q4Var.L9(q4Var.u7());
        }

        @Override // d8.w.b
        public void f() {
            q4.this.D7();
            q4.this.f9481k1.r();
        }

        @Override // d8.w.b
        public void g() {
            q4.this.f9481k1.k();
        }

        @Override // d8.w.b
        public void h() {
            q4.this.D7();
            q4.this.J8();
        }

        @Override // d8.w.b
        public void i(boolean z10) {
            q4.this.D7();
            if (z10) {
                q4.this.f9481k1.s();
            } else {
                q4.this.f9481k1.p();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g implements d8.q.b {
        public g() {
        }

        @Override // d8.q.b
        public void a() {
            if (q4.this.f9479i1 != null) {
                q4.this.f9479i1.l();
            } else {
                c6.b.f1959a.i(q4.this.v7());
            }
        }

        @Override // d8.q.b
        public void b() {
            if (q4.this.f9479i1 != null) {
                q4.this.f9479i1.j();
            } else {
                c6.b.f1959a.h(q4.this.v7());
            }
        }

        @Override // d8.q.b
        public void c(boolean z10) {
            if (q4.this.f9479i1 != null) {
                q4.this.f9479i1.k(z10);
                return;
            }
            r4.a aVarM = q4.this.M0.m(q4.this.f9478h1);
            if (aVarM != null) {
                aVarM.o().evaluateJavascript(c6.b.f1959a.d(z10), null);
            }
        }

        @Override // d8.q.b
        public void d() {
            if (q4.this.f9479i1 != null) {
                q4.this.f9479i1.n();
                q4.this.f9479i1 = null;
            } else {
                r4.a aVarM = q4.this.M0.m(q4.this.f9478h1);
                if (aVarM != null) {
                    c6.b.f1959a.a(new c6.f(aVarM.o()));
                }
            }
            q4.this.D7();
            q4.this.f9478h1 = 0;
        }

        @Override // d8.q.b
        public void e() {
            if (q4.this.f9479i1 != null) {
                q4.this.f9479i1.e();
            } else {
                c6.b.f1959a.b(q4.this.v7());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class h implements d8.h.b {
        public h() {
        }

        @Override // d8.h.b
        public void a(boolean z10) {
            q4.this.i7(z10);
        }

        @Override // d8.h.b
        public void b(boolean z10) {
            q4.this.j7("");
            if (z10) {
                q4.this.D7();
                x8.f.e(q4.this.f9489q0);
            }
        }

        @Override // d8.h.b
        public void c(String str) {
            q4.this.j7(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class i implements d8.l0.b {
        public i() {
        }

        @Override // d8.l0.b
        public void a(int i10) {
            if (i10 < 0 || i10 >= q4.this.i()) {
                return;
            }
            q4.this.D7();
            q4 q4Var = q4.this;
            q4Var.a7((r4.a) q4Var.c().get(i10));
        }

        @Override // d8.l0.b
        public void b(int i10, int i11) {
            if (i11 == 4 || ((i11 == 1 && i10 != q4.this.k()) || ((i11 == 2 && q4.this.k() > i10) || (i11 == 3 && q4.this.k() < i10)))) {
                q4.this.D7();
            }
            q4.this.V6(i10, i11);
        }

        @Override // d8.l0.b
        public void c(r4.f fVar) {
            q4.this.M0.r(fVar);
        }

        @Override // d8.l0.b
        public void d() {
            q4.this.f9485o0.k1(null, true);
        }

        @Override // d8.l0.b
        public void e(int i10) {
            q4.this.f9485o0.D0(i10);
        }

        @Override // d8.l0.b
        public void f() {
            q4.this.D7();
            q4.this.F8();
        }

        @Override // d8.l0.b
        public void g(r4.f fVar) {
            q4.this.M0.o(fVar);
        }

        @Override // d8.l0.b
        public boolean h(int i10, int i11) {
            return q4.this.M0.p(i10, i11);
        }

        @Override // d8.l0.b
        public void i(int i10) {
            q4.this.f9485o0.Y1(i10);
            q4.this.D7();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class j implements mark.via.browser.c.a {
        public j() {
        }

        @Override // mark.via.browser.c.a
        public void a(String str) {
            d8.q qVar = (d8.q) q4.this.x0().n0(d8.q.f3984x0);
            if (qVar != null) {
                qVar.f3(str);
            }
        }

        @Override // mark.via.browser.c.a
        public void b(String str, String str2) {
            q4.this.f9485o0.h0(str, str2);
            q4.this.D7();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class k extends androidx.activity.o {
        public k(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.o
        public void d() {
            q4.this.g8();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class l implements ReadModeController.a {
        public l() {
        }

        @Override // mark.via.browser.ReadModeController.a
        public void a(int i10, boolean z10) {
            q4.this.Z9(i10, z10);
        }

        @Override // mark.via.browser.ReadModeController.a
        public void b(boolean z10) {
            q4.this.f9507z0.v(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class m extends BroadcastReceiver {
        public m() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            t4.b bVarH = q4.this.H();
            if (bVarH == null) {
                return;
            }
            if ("mark.via.MEDIA_PLAY".equals(action)) {
                rd.q(bVarH).B(new ValueCallback() { // from class: mark.via.browser.v4
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        x8.f2.f(q4.this.y0(), ((Integer) obj).intValue());
                    }
                });
            } else if ("mark.via.MEDIA_REWIND".equals(action) || "mark.via.MEDIA_FASTFORWARD".equals(action)) {
                rd.q(bVarH).b("mark.via.MEDIA_REWIND".equals(action) ? -15 : 15);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class n extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f9527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f9528b;

        public n(ValueAnimator valueAnimator, boolean z10) {
            this.f9527a = valueAnimator;
            this.f9528b = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (q4.this.f9494s1 == this.f9527a) {
                q4.this.f9494s1 = null;
                q4.this.k7(this.f9528b);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class o extends GestureDetector.SimpleOnGestureListener {
        public o() {
        }

        public static /* synthetic */ void a(o oVar, s8 s8Var, t4.b bVar, String str, int i10, int i11, String str2, String str3, String str4) {
            if (q4.this.K0 == s8Var && q4.this.H() == bVar && TextUtils.equals(str, bVar.getUrl())) {
                q4.this.Z7(i10, i11, str2, str3, str4, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            final t4.b bVarH = q4.this.H();
            if (bVarH == null) {
                return;
            }
            final String url = bVarH.getUrl();
            final int rawX = (int) motionEvent.getRawX();
            final int rawY = (int) motionEvent.getRawY();
            final s8 s8Var = new s8();
            q4.this.K0 = s8Var;
            s8Var.a(new s8.a() { // from class: mark.via.browser.w4
                @Override // mark.via.browser.s8.a
                public final void a(String str, String str2, String str3) {
                    q4.o.a(this.f9723a, s8Var, bVarH, url, rawX, rawY, str, str2, str3);
                }
            });
            bVarH.requestFocusNodeHref(s8Var.obtainMessage());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class p extends q4.a {
        public p() {
        }

        public static /* synthetic */ void J(p pVar, int i10, String str, View view) {
            r4.a aVarD = q4.this.d();
            if (aVarD == null || aVarD.getId() != i10) {
                return;
            }
            aVarD.u(str);
        }

        @Override // q4.a
        public void D(t4.b bVar, String str) {
            if (bVar == q4.this.H()) {
                q4.this.E0.C();
            }
        }

        @Override // q4.a
        public void E(t4.b bVar, int i10) {
            q4.this.f9480j1.p(bVar);
            if ((i10 & 6) != 0) {
                rd.q(bVar).x();
            }
        }

        @Override // q4.a
        public void F(t4.b bVar) {
            if (q9.s() && bVar.getTag(w7.p.H0) == null) {
                int i10 = w7.p.H0;
                String strA = r9.a(q4.this.G(), q4.this.f9476f1, !q9.q());
                Set setSingleton = Collections.singleton("*");
                String str = q4.this.f9476f1;
                final q4 q4Var = q4.this;
                bVar.setTag(i10, q9.v(bVar, strA, "via2", setSingleton, str, new r0.k.a() { // from class: mark.via.browser.x4
                    @Override // r0.k.a
                    public final void a(WebView webView, r0.h hVar, Uri uri, boolean z10, r0.c cVar) {
                        q4Var.f8(webView, hVar, uri, z10, cVar);
                    }
                }));
            }
        }

        @Override // q4.a
        public void G(t4.b bVar, int i10) {
            if ((i10 & 6) != 0) {
                rd.q(bVar).z();
            }
        }

        @Override // q4.a
        public boolean n(t4.b bVar, q4.k kVar) {
            if (q4.this.V7()) {
                return true;
            }
            if (kVar.a() == 0) {
                return false;
            }
            final String strB = kVar.b();
            String url = bVar.getUrl();
            c6.a2 a2Var = c6.a2.f1958a;
            if (!a2Var.t(url) || !a2Var.t(strB) || q4.this.f9485o0.d1(url)) {
                return false;
            }
            String strC = a2Var.c(url);
            String strC2 = a2Var.c(strB);
            if (!strC.isEmpty() && strC2.equalsIgnoreCase(strC)) {
                return false;
            }
            if (!q4.this.o1()) {
                return true;
            }
            final int id = q4.this.d() != null ? q4.this.d().getId() : -1;
            com.tuyafeng.support.utils.n.t(q4.this.i0(), strC2.isEmpty() ? q4.this.X0(w7.u.Y0) : q4.this.Y0(w7.u.Z0, strC2), q4.this.X0(w7.u.f13968a1), new View.OnClickListener() { // from class: mark.via.browser.y4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q4.p.J(this.f9776a, id, strB, view);
                }
            });
            return true;
        }

        @Override // q4.a
        public void p(t4.b bVar, String str, Bitmap bitmap) {
            q4.this.f9480j1.p(bVar);
            if (q9.s()) {
                mark.via.browser.c.f(bVar).c();
            }
            if (bVar == q4.this.H() && q4.this.V7()) {
                q4.this.D7();
            }
            q4.this.P0.I(bVar);
            if (q9.s()) {
                q9.m(bVar).h();
            }
            rd.q(bVar).n();
            if (bVar == q4.this.H()) {
                q4.this.E0.C();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class q implements c8.b0.a {
        public q() {
        }

        @Override // c8.b0.a
        public void a(Intent intent, i8.o oVar) {
            q4.this.H0 = null;
            q4.this.P2(intent, 111);
            q4.this.H0 = oVar;
        }

        @Override // c8.b0.a
        public void b(i8.o oVar) {
            q4.this.I0 = oVar;
            q4.this.J0.a("android.permission.CAMERA");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class r implements pa.a.InterfaceC0111a {
        public r() {
        }

        public static /* synthetic */ void d(r rVar, int i10, String str, boolean z10) {
            if (i10 < 0 || i10 > q4.this.i()) {
                i10 = q4.this.k() + 1;
            }
            q4.this.f9485o0.h1(str, z10, i10);
        }

        @Override // pa.a.InterfaceC0111a
        public void a(String str, String str2) {
            if (str2 == null || str2.startsWith("text/") || "text".equalsIgnoreCase(str2)) {
                com.tuyafeng.support.utils.n.b(q4.this.G(), str, null);
            }
        }

        @Override // pa.a.InterfaceC0111a
        public void b(String str, String str2) {
            int iLastIndexOf;
            q4.this.P0.K(new mark.via.download.o.b().k(q4.this.f9487p0.L1()).c("attachment").g((str2 == null || str2.isEmpty() || (iLastIndexOf = str2.lastIndexOf(46)) < 0) ? null : l5.c.c(str2.substring(iLastIndexOf + 1), "application/octet-stream")).d(0L).j(str).e(str2).f(com.tuyafeng.support.utils.p.f(str2)).b());
        }

        @Override // pa.a.InterfaceC0111a
        public void c(final String str, final boolean z10, final int i10) {
            if (str == null || str.isEmpty()) {
                return;
            }
            x8.h.c(q4.this.i0(), new Runnable() { // from class: mark.via.browser.z4
                @Override // java.lang.Runnable
                public final void run() {
                    q4.r.d(this.f9807c, i10, str, z10);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class s implements GestureTouchEvent.b {
        public s() {
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public boolean a() {
            return q4.this.f9490q1;
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void b() {
            q4.this.R8();
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void c(View view, int i10) {
            if (i10 == 1) {
                ((ImageView) view).setImageDrawable(lb.g.a(q4.this.G(), w7.o.f13822q, w7.u.he));
            } else {
                if (i10 != 2) {
                    return;
                }
                ((ImageView) view).setImageDrawable(lb.g.a(q4.this.G(), w7.o.f13802j0, w7.u.we));
            }
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public boolean d(View view) {
            return ((t4.b) view).m();
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void e(boolean z10) {
            q4.this.k7(z10);
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public int f(View view) {
            int i10 = 0;
            if (!q4.this.f9506y1 || (q4.this.f9486o1 && q4.this.f9482l1 && !q4.this.f9490q1)) {
                return 0;
            }
            t4.b bVar = (t4.b) view;
            boolean z10 = (bVar.canScrollHorizontally(1) || bVar.canScrollHorizontally(-1)) ? false : true;
            int i11 = (z10 && q4.this.M6()) ? 1 : 0;
            if (z10 && q4.this.N6()) {
                i10 = 2;
            }
            return i11 | i10;
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public boolean g() {
            return q4.this.f9487p0.s2() == 1;
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void h(int i10) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                q4.this.x7();
            } else if (q4.this.f9486o1) {
                q4.this.g8();
            } else {
                q4.this.w7();
            }
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void i(float f10) {
            q4.this.v9(f10);
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public void j(boolean z10) {
            q4.this.K6(z10);
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public boolean k(View view) {
            int iS2 = q4.this.f9487p0.s2();
            return ((iS2 != 1 && (iS2 != 2 || q4.this.f9492r1 >= 1.0f)) || q4.this.X0 != 1 || q4.this.A1 || q4.this.f9482l1 || q4.this.T7() || ((b8.h) view).r()) ? false : true;
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public int l() {
            return Math.max(q4.this.A0.getHeight(), q4.this.f9505y0.getHeight());
        }

        @Override // mark.via.common.widget.GestureTouchEvent.b
        public float m() {
            return q4.this.f9492r1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class t implements b8.e {
        public t() {
        }

        public static /* synthetic */ void i(t tVar, JSONObject jSONObject) {
            d8.q qVar = (d8.q) q4.this.x0().n0(d8.q.f3984x0);
            if (qVar != null) {
                qVar.f3(jSONObject.optString("filter"));
            }
        }

        public static /* synthetic */ void l(t tVar, String str, String str2, View view, q5.k.p pVar) {
            q4.this.f9485o0.h0(str, str2);
            q4.this.D7();
            r4.a aVarM = q4.this.M0.m(q4.this.f9478h1);
            if (aVarM != null) {
                c6.b.f1959a.f(new c6.f(aVarM.o()), str2);
            }
        }

        public static /* synthetic */ void n(t tVar, String str, String str2) {
            if (q4.this.a1() == null || q4.this.S0.z(str, str2)) {
                return;
            }
            q4.this.P0.B(str, str2);
        }

        @JavascriptInterface
        public int cmd(int i10) {
            if (i10 == 257) {
                q6.b.b().c().b(new Runnable() { // from class: mark.via.browser.a5
                    @Override // java.lang.Runnable
                    public final void run() {
                        q4.this.G8(true);
                    }
                });
            } else if (i10 == 514) {
                r6.p.c cVarC = q6.b.b().c();
                final q4 q4Var = q4.this;
                cVarC.b(new Runnable() { // from class: mark.via.browser.g5
                    @Override // java.lang.Runnable
                    public final void run() {
                        q4Var.L8();
                    }
                });
            } else if (i10 == 515) {
                return (q4.this.f9490q1 || q4.this.f9498u1) ? 1 : 0;
            }
            return 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @JavascriptInterface
        public boolean postMessage(String str, String str2) {
            if (!q4.this.U7(str) && str2 != null && str2.length() >= 2) {
                try {
                    final JSONObject jSONObject = new JSONObject(str2);
                    int iOptInt = jSONObject.optInt("action", 0);
                    if (iOptInt == 0) {
                        return false;
                    }
                    if (iOptInt == 115) {
                        return q4.this.P0.F(jSONObject);
                    }
                    tc.a.a("post message, action: %d, json: %s", Integer.valueOf(iOptInt), Integer.valueOf(str2.length()));
                    if (iOptInt == 114) {
                        final q4 q4Var = q4.this;
                        x8.h.d(q4Var, new Runnable() { // from class: mark.via.browser.b5
                            @Override // java.lang.Runnable
                            public final void run() {
                                q4Var.S8();
                            }
                        });
                    } else if (iOptInt != 119) {
                        switch (iOptInt) {
                            case 101:
                                if (!q9.s()) {
                                    final int iOptInt2 = jSONObject.optInt("runAt", 0);
                                    final int iOptInt3 = jSONObject.optInt("from", 0);
                                    if (iOptInt3 != 0 && iOptInt2 != 0) {
                                        x8.h.c(q4.this.i0(), new Runnable() { // from class: mark.via.browser.k5
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                q4.t tVar = this.f9277c;
                                                q4.this.g9(q4.this.M0.q(iOptInt3), iOptInt2);
                                            }
                                        });
                                    }
                                }
                                break;
                            case 102:
                                if (!q9.s()) {
                                    x8.h.c(q4.this.i0(), new Runnable() { // from class: mark.via.browser.l5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            q4.t.i(this.f9302c, jSONObject);
                                        }
                                    });
                                }
                                break;
                            case 103:
                                if (!q9.s()) {
                                    final String strOptString = jSONObject.optString("host");
                                    final String strOptString2 = jSONObject.optString("filter");
                                    if (!strOptString.isEmpty() && !strOptString2.isEmpty()) {
                                        x8.h.c(q4.this.i0(), new Runnable() { // from class: mark.via.browser.m5
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                q4.t tVar = this.f9344c;
                                                String str3 = strOptString2;
                                                q5.k.l(q4.this.G()).f0(w7.u.M).K(q4.this.G().getResources().getString(w7.u.H3) + "(" + str3 + ")").X(R.string.ok, new q5.k.m() { // from class: mark.via.browser.f5
                                                    @Override // q5.k.m
                                                    public final void a(View view, q5.k.p pVar) {
                                                        q4.t.l(this.f9130a, str, str3, view, pVar);
                                                    }
                                                }).P(R.string.cancel, null).h0();
                                            }
                                        });
                                    }
                                }
                                break;
                            case 104:
                                q4.this.P0.y(jSONObject.optString("url"), jSONObject.optString("name"));
                                break;
                            case 105:
                                final String strOptString3 = jSONObject.optString("text");
                                if (!strOptString3.isEmpty()) {
                                    x8.h.d(q4.this, new Runnable() { // from class: mark.via.browser.n5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            q4.this.k9(strOptString3);
                                        }
                                    });
                                }
                                break;
                            case 106:
                                final String strOptString4 = jSONObject.optString("text");
                                x8.h.d(q4.this, new Runnable() { // from class: mark.via.browser.o5
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        q4.this.f9485o0.D1(strOptString4);
                                    }
                                });
                                break;
                            case 107:
                                final String strOptString5 = jSONObject.optString("url");
                                if (!strOptString5.isEmpty()) {
                                    q6.b.b().c().b(new Runnable() { // from class: mark.via.browser.d5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            q4.this.P0.K(new mark.via.download.o.b().j(strOptString5).b());
                                        }
                                    });
                                }
                                break;
                            case 108:
                                r6.p.c cVarC = q6.b.b().c();
                                final q4 q4Var2 = q4.this;
                                cVarC.b(new Runnable() { // from class: mark.via.browser.e5
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        q4Var2.D9();
                                    }
                                });
                                break;
                            case 109:
                                if (!q9.s()) {
                                    final boolean z10 = jSONObject.optInt("show", 0) > 0;
                                    q6.b.b().c().b(new Runnable() { // from class: mark.via.browser.i5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            q4.this.E0.N(z10);
                                        }
                                    });
                                }
                                break;
                            case 110:
                                if (!q9.s()) {
                                    final String strOptString6 = jSONObject.optString("user");
                                    final String strOptString7 = jSONObject.optString("pass");
                                    final String strOptString8 = jSONObject.optString("url");
                                    q6.b.b().c().b(new Runnable() { // from class: mark.via.browser.j5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            q4.this.E0.B(strOptString8, strOptString6, strOptString7);
                                        }
                                    });
                                }
                                break;
                            case 111:
                                final int iOptInt4 = jSONObject.optInt("from");
                                final String strOptString9 = jSONObject.optString("token");
                                final boolean zOptBoolean = jSONObject.optBoolean("selected");
                                x8.h.d(q4.this, new Runnable() { // from class: mark.via.browser.h5
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        q4.this.f9477g1.y(iOptInt4, strOptString9, zOptBoolean);
                                    }
                                });
                                break;
                        }
                    } else {
                        final String strOptString10 = jSONObject.optString("url");
                        final String strOptString11 = jSONObject.isNull("data") ? null : jSONObject.optString("data");
                        x8.h.d(q4.this, new Runnable() { // from class: mark.via.browser.c5
                            @Override // java.lang.Runnable
                            public final void run() {
                                q4.t.n(this.f9055c, strOptString10, strOptString11);
                            }
                        });
                    }
                    return true;
                } catch (Exception e10) {
                    tc.a.j(e10);
                }
            }
            return false;
        }

        @JavascriptInterface
        public void toast(String str) {
            com.tuyafeng.support.utils.n.s(q4.this.G(), str);
        }

        public /* synthetic */ t(q4 q4Var, k kVar) {
            this();
        }
    }

    public static /* synthetic */ void A3(q4 q4Var, int i10, TextView textView) {
        q4Var.getClass();
        textView.setText(String.format(Locale.ROOT, "%d%%", Integer.valueOf(i10)));
        textView.setGravity(17);
        textView.setTextSize(0, v8.h.r(q4Var.G()));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(q4Var.G(), w7.k.f13732l));
    }

    public static /* synthetic */ void B3(q4 q4Var, List list, int i10, y9.a aVar, z9.d dVar, String str, boolean z10, String str2, String[] strArr, AdapterView adapterView, View view, int i11, long j10) {
        q4Var.getClass();
        ga.c cVar = (ga.c) list.get(i11);
        if (cVar.d() == i10) {
            return;
        }
        if (aVar != null) {
            aVar.e0(cVar.d());
            if (aVar.r()) {
                dVar.b(str);
            } else {
                dVar.k(str, aVar);
            }
        } else if (z10) {
            q4Var.f9487p0.F2(cVar.d());
        } else {
            q4Var.f9487p0.J(cVar.d());
        }
        q4Var.f9485o0.n1(true);
        if (!s9.d.l(q4Var.G(), str2)) {
            String strG = c6.a2.f1958a.g(str2);
            if (!TextUtils.isEmpty(strG) && !"pan.baidu.com".equalsIgnoreCase(strG) && !"yun.baidu.com".equalsIgnoreCase(strG) && !"eyun.baidu.com".equalsIgnoreCase(strG)) {
                q4Var.U8();
            }
        }
        com.tuyafeng.support.utils.n.s(q4Var.G(), q4Var.Y0(w7.u.F7, q4Var.X0(w7.u.F0), strArr[i11]));
        q4Var.D7();
    }

    public static /* synthetic */ void C3(q4 q4Var, Map map) {
        c8.v1.a aVar = q4Var.G1;
        if (aVar == null) {
            q4Var.H1 = null;
            return;
        }
        if (map == null) {
            aVar.a(q4Var.H1, false);
            q4Var.G1 = null;
            q4Var.H1 = null;
            return;
        }
        HashSet hashSet = new HashSet();
        String[] strArr = q4Var.H1;
        if (strArr != null) {
            for (String str : strArr) {
                if (map.get(str) != Boolean.FALSE) {
                    hashSet.add(str);
                }
            }
        }
        q4Var.G1.a((String[]) hashSet.toArray(new String[0]), false);
        q4Var.G1 = null;
        q4Var.H1 = null;
        if (hashSet.isEmpty()) {
            x8.y1.f(q4Var.i0());
        }
    }

    public static /* synthetic */ void D3(q4 q4Var) {
        q4Var.getClass();
        fa.d.f(la.s.f(), q4Var.R0.f());
    }

    public static /* synthetic */ void D4(q4 q4Var, int i10) {
        if (i10 < 0) {
            q4Var.getClass();
        } else if (i10 < q4Var.i()) {
            q4Var.a7((r4.a) q4Var.c().get(i10));
        }
    }

    public static /* synthetic */ void F3(q4 q4Var, String str, Bundle bundle) {
        q4Var.f9485o0.x1();
        q4Var.L0().x("favoriteChanged");
    }

    public static /* synthetic */ void H3(final q4 q4Var, Boolean bool) {
        q4Var.getClass();
        if (bool.booleanValue()) {
            com.tuyafeng.support.utils.n.r(q4Var.i0(), w7.u.Pb, w7.u.oi, new View.OnClickListener() { // from class: mark.via.browser.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f9405a.H8();
                }
            });
        }
    }

    public static /* synthetic */ void H4(q4 q4Var, Fragment fragment, androidx.lifecycle.j jVar, Lifecycle.Event event) {
        q4Var.getClass();
        if (event == Lifecycle.Event.ON_DESTROY) {
            z5 z5Var = q4Var.f9489q0;
            if (z5Var != null) {
                z5Var.setBlurEnabled(false);
                q4Var.f9489q0.setDescendantFocusability(262144);
                if (q4Var.m1()) {
                    q4Var.f9491r0.f();
                }
            }
            if (!(fragment instanceof tb.k0) || q4Var.D0 == null) {
                return;
            }
            q4Var.x9(true);
        }
    }

    public static /* synthetic */ String I3(q4 q4Var, String str) {
        c8.f0 f0Var = q4Var.Q0;
        if (f0Var == null) {
            return null;
        }
        return f0Var.K(str);
    }

    public static /* synthetic */ void I4(q4 q4Var) {
        q4Var.f9499v0.setAlpha(0.0f);
        q4Var.f9499v0.setVisibility(0);
    }

    public static /* synthetic */ void J3(q4 q4Var, String str, Bundle bundle) {
        q4Var.getClass();
        if (bundle.getString(Name.MARK) != null) {
            q4Var.f9485o0.z1();
        }
        q4Var.L0().x("bookmarkDialogResult2");
    }

    public static /* synthetic */ void K3(q4 q4Var, ImageView imageView) {
        q4Var.getClass();
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setId(w7.p.f13903r);
        imageView.setImageResource(w7.o.C0);
        imageView.setImageDrawable(lb.g.a(q4Var.G(), w7.o.C0, w7.u.De));
        imageView.setColorFilter(-1);
        imageView.setBackgroundResource(w7.o.f13780c);
        imageView.setContentDescription(q4Var.X0(w7.u.Hg));
        imageView.setVisibility(8);
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setElevation(com.tuyafeng.support.utils.x.h(q4Var.G(), 12.0f));
        }
        q4Var.B0.addView(imageView);
    }

    public static /* synthetic */ void M3(WeakReference weakReference, Integer num) {
        d8.w wVar = (d8.w) weakReference.get();
        if (wVar == null || !wVar.g1()) {
            return;
        }
        wVar.j3(num.intValue());
    }

    public static /* synthetic */ void N4(q4 q4Var, String str, Bundle bundle) {
        q4Var.x0().x("menu_result");
        if (bundle.getInt("action", 0) != 0) {
            FragmentUtils.i(q4Var, y8.o.class);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0036  */
    public static /* synthetic */ void O3(q4 q4Var, mark.via.common.widget.m mVar) {
        int i10;
        boolean zE = q4Var.f9487p0.e();
        int i11 = q4Var.U0;
        boolean z10 = false;
        boolean z11 = i11 == 0;
        g9.a aVarQ2 = q4Var.f9487p0.Q2();
        if (!zE) {
            if (!z11 || !aVarQ2.c()) {
                if (com.tuyafeng.support.utils.x.C(z11 ? q4Var.f9487p0.f0() : i11)) {
                    z10 = true;
                }
            } else if (aVarQ2.d()) {
                z10 = true;
            }
        }
        Context contextG = q4Var.G();
        int i12 = R.color.white;
        if (zE) {
            i10 = w7.m.f13744h;
        } else {
            i10 = z10 ? w7.m.f13743g : R.color.white;
        }
        int iB = com.tuyafeng.support.utils.f.b(contextG, i10);
        Context contextG2 = q4Var.G();
        if (zE) {
            i12 = w7.m.f13741e;
        } else if (z10) {
            i12 = w7.m.f13740d;
        }
        mVar.l(iB, com.tuyafeng.support.utils.f.b(contextG2, i12));
        mVar.setBackgroundColor(i11);
    }

    public static /* synthetic */ void O4(final q4 q4Var, View view, q5.k.p pVar) {
        q4Var.getClass();
        if (com.tuyafeng.support.utils.e.e(pVar.f11819c, 1)) {
            return;
        }
        u9.a aVarV = q4Var.f9487p0.v();
        boolean zP = aVarV.p();
        boolean z10 = pVar.f11818b;
        if (zP != z10) {
            aVarV.H(z10);
            q4Var.f9487p0.Z(aVarV);
        }
        ((autodispose2.n) q4Var.f9485o0.P1(x8.c1.o(pVar.f11819c[0]), pVar.f11818b).L(s8.b.b(q4Var.b1(), Lifecycle.Event.ON_DESTROY))).a(new u6.f() { // from class: mark.via.browser.g0
            @Override // u6.f
            public final void accept(Object obj) {
                q4.H3(this.f9148c, (Boolean) obj);
            }
        }, new w7.e0());
    }

    public static /* synthetic */ void P3(q4 q4Var, String str, Bundle bundle) {
        q4Var.getClass();
        String string = bundle.getString("input", null);
        if (!TextUtils.isEmpty(string)) {
            if (bundle.getInt("input_action", 0) == 2) {
                q4Var.l9(bundle.getString("input_query", string), bundle.getInt("input_engine"));
            } else if (string.startsWith("VIA-SWITCH-TAB:")) {
                try {
                    int i10 = Integer.parseInt(string.substring(15));
                    p8 p8Var = q4Var.f9485o0;
                    p8Var.Y1(p8Var.G0(i10));
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } else {
                q4Var.k9(string);
            }
        }
        q4Var.L0().x("input");
    }

    public static /* synthetic */ void Q4(q4 q4Var, Boolean bool) {
        i8.o oVar = q4Var.I0;
        q4Var.I0 = null;
        if (oVar != null) {
            oVar.a(bool);
        }
    }

    public static /* synthetic */ void R4(q4 q4Var, m9.b bVar) {
        q4Var.getClass();
        if (bVar.c() != null) {
            q4Var.z9(a8.n.o3(bVar.c()));
        } else {
            q4Var.z9(a8.n.q3(bVar.g(), bVar.e()));
        }
    }

    private void R7() {
        RelativeLayout relativeLayout = this.f9489q0.f9811c;
        this.B0 = relativeLayout;
        this.f9480j1.o(relativeLayout);
        Window window = i0().getWindow();
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
        this.f9489q0.f9814n.setOnClickListener(this.D1);
        z5 z5Var = this.f9489q0;
        this.A0 = z5Var.f9816p;
        this.f9505y0 = z5Var.f9817q;
        this.f9493s0 = z5Var.f9812e;
        this.f9495t0 = z5Var.f9813m;
        P7();
        Q7();
    }

    public static /* synthetic */ m9.b S4(String str, String str2) {
        m9.b bVarA = la.s.d().a(str);
        if (bVarA != null) {
            return bVarA;
        }
        m9.b bVar = new m9.b();
        bVar.n(str);
        bVar.l(str2);
        return bVar;
    }

    public static /* synthetic */ void T2(q4 q4Var, Activity activity) {
        q4Var.getClass();
        int iA = x8.z.A(activity);
        tc.a.a("on network changed, current: %d", Integer.valueOf(iA));
        q4Var.P0.H(iA);
        boolean z10 = 2 != iA;
        if (z10 != q4Var.f9487p0.n2().x()) {
            q4Var.f9487p0.n2().Z(z10);
            q4Var.f9485o0.m1();
        }
    }

    public static /* synthetic */ void T3(WeakReference weakReference, Integer num) {
        g8.k kVar = (g8.k) weakReference.get();
        if (kVar == null || !kVar.g1()) {
            return;
        }
        kVar.A3(num.intValue());
    }

    public static /* synthetic */ void T4(q4 q4Var, String str, Bundle bundle) {
        q4Var.getClass();
        q4Var.f9485o0.G1(bundle.getStringArray("tabs"), bundle.getString("selected"));
        q4Var.L0().x("restore_tabs");
    }

    public static /* synthetic */ void U4(q4 q4Var, String str, String str2) {
        int i10;
        q4Var.getClass();
        int height = 0;
        if (str2.length() <= 0 || !TextUtils.isDigitsOnly(str2)) {
            q4Var.C8(0, 0, str);
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
            height = ((q4Var.B0.getHeight() - com.tuyafeng.support.utils.x.h(q4Var.G(), i12)) - (q4Var.A0.getVisibility() == 0 ? q4Var.A0.getHeight() : 0)) + com.tuyafeng.support.utils.f.d(q4Var.G(), w7.n.D) + com.tuyafeng.support.utils.x.h(q4Var.G(), 4.0f);
        }
        q4Var.C8(i11, height, str);
    }

    public static /* synthetic */ void V2(WeakReference weakReference) {
        WebView webView = (WebView) weakReference.get();
        if (webView != null) {
            webView.setVisibility(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    public static /* synthetic */ void V4(q4 q4Var, String str, Bundle bundle) {
        r4.a aVarD = q4Var.d();
        if (aVarD != null && bundle.containsKey("qrcode")) {
            String string = bundle.getString("qrcode", "");
            c6.a2 a2Var = c6.a2.f1958a;
            if (a2Var.u(string)) {
                String strW = a2Var.w(string, q4Var.f9487p0.b1());
                if (a2Var.t(strW) || a2Var.m(strW) || a2Var.l(strW)) {
                    aVarD.u(strW);
                } else {
                    aVarD.u(a2Var.a(string, q4Var.X0(w7.u.Qa)));
                }
            } else {
                aVarD.u(a2Var.a(string, q4Var.X0(w7.u.Qa)));
            }
        }
        q4Var.L0().x("qrcode");
    }

    public static /* synthetic */ void W2(t4.b bVar, String str, WebView.WebViewTransport webViewTransport, Message message) {
        bVar.setTag(c8.i.f2216d, Boolean.TRUE);
        bVar.setReferer(str);
        webViewTransport.setWebView(bVar);
        message.sendToTarget();
    }

    public static /* synthetic */ void X3(q4 q4Var, ValueAnimator valueAnimator) {
        q4Var.getClass();
        q4Var.v9(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void Y2(q4 q4Var, String str, View view, q5.k.p pVar) {
        if (q4Var.f9485o0.A0(str)) {
            u9.n.e().q(true);
            q4Var.f9485o0.z1();
        }
    }

    public static /* synthetic */ void Y3(q4 q4Var, List list) {
        q4Var.getClass();
        if (list.size() <= 1) {
            if (q4Var.D0 != null) {
                q4Var.x9(false);
                return;
            }
            return;
        }
        if (q4Var.D0 == null) {
            q4Var.N7();
        }
        if (q4Var.D0 != null) {
            Collections.sort(list, new ib.q(q4Var.f9487p0.I1()));
            q4Var.D0.m(list, null);
            q4Var.ca(q4Var.u7());
        }
    }

    public static /* synthetic */ void Z3(q4 q4Var, int i10, AdapterView adapterView, View view, int i11, long j10) {
        int i12;
        if (i11 == i10) {
            q4Var.getClass();
            return;
        }
        q4Var.f9487p0.T0(i11 + 1);
        int iL0 = q4Var.f9487p0.l0();
        if (iL0 == 2) {
            i12 = 10;
        } else if (iL0 != 3) {
            i12 = iL0 != 4 ? 2 : 0;
        } else {
            i12 = 1;
        }
        x8.j3.i(q4Var.G(), i12);
        com.tuyafeng.support.utils.n.s(q4Var.G(), q4Var.Y0(w7.u.F7, q4Var.X0(w7.u.f13991ba), com.tuyafeng.support.utils.e.c(q4Var.G(), w7.j.f13716g, i11)));
    }

    public static /* synthetic */ void Z4(q4 q4Var, int i10, String[] strArr, AdapterView adapterView, View view, int i11, long j10) {
        if (i11 == i10) {
            q4Var.getClass();
            return;
        }
        u9.p pVarN2 = q4Var.f9487p0.n2();
        if (i11 == 0) {
            pVarN2.T(false);
            pVarN2.S(true);
        } else if (i11 == 1) {
            pVarN2.T(false);
            pVarN2.S(false);
        } else if (i11 == 2) {
            pVarN2.T(true);
            pVarN2.S(true);
        }
        q4Var.f9487p0.F1(pVarN2);
        q4Var.f9485o0.n1(true);
        com.tuyafeng.support.utils.n.s(q4Var.G(), strArr[i11]);
    }

    public static /* synthetic */ void a3(q4 q4Var, String str, String str2, View view) {
        q4Var.getClass();
        if (x8.z.p(str)) {
            com.tuyafeng.support.utils.n.s(q4Var.G(), q4Var.Y0(w7.u.Cg, str2));
        }
    }

    public static /* synthetic */ void a4(q4 q4Var) {
        q4Var.f9496t1 = false;
        if (y.r.F(q4Var.B0)) {
            y.r.V(q4Var.B0);
        }
    }

    public static /* synthetic */ void b3(q4 q4Var) {
        boolean zO1 = q4Var.f9487p0.O1();
        boolean z10 = !zO1;
        q4Var.f9487p0.c(z10);
        q4Var.s9(z10);
        com.tuyafeng.support.utils.n.s(q4Var.G(), q4Var.Y0(!zO1 ? w7.u.f14240t7 : w7.u.f14226s7, q4Var.X0(w7.u.H)));
    }

    public static /* synthetic */ void b4(q4 q4Var, DialogInterface dialogInterface) {
        r4.a aVarD = q4Var.M0.d();
        if (aVarD != null) {
            aVarD.n();
        }
    }

    public static /* synthetic */ void c3(q4 q4Var, ValueAnimator valueAnimator) {
        if (q4Var.g1()) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            q4Var.f9489q0.k(iIntValue, valueAnimator.getAnimatedFraction() != 1.0f);
            q4Var.f9505y0.setBackgroundColor(iIntValue);
            mark.via.common.widget.m mVar = q4Var.D0;
            if (mVar != null) {
                mVar.setBackgroundColor(iIntValue);
            }
        }
    }

    public static /* synthetic */ void c5(q4 q4Var, FragmentManager fragmentManager, Fragment fragment) {
        if (fragment instanceof d8.l0) {
            q4Var.r8((d8.l0) fragment);
            return;
        }
        if (fragment instanceof d8.h) {
            q4Var.e8((d8.h) fragment);
            return;
        }
        if (fragment instanceof mark.via.download.w) {
            ((mark.via.download.w) fragment).s3(q4Var.P0);
            return;
        }
        if (fragment instanceof ta.y) {
            q4Var.p8((ta.y) fragment);
            return;
        }
        if (fragment instanceof d8.q) {
            q4Var.m8((d8.q) fragment);
            return;
        }
        if (fragment instanceof d8.w) {
            q4Var.q8((d8.w) fragment);
        } else if (fragment instanceof g8.k) {
            q4Var.c8((g8.k) fragment);
        } else {
            q4Var.getClass();
        }
    }

    public static /* synthetic */ void d4(q4 q4Var, FragmentManager fragmentManager, String str, Bundle bundle) {
        q4Var.getClass();
        int i10 = bundle.getInt(Name.MARK, 0);
        int i11 = bundle.getInt("flags", 0);
        if (i10 != 0) {
            if ((i11 & 2) != 0) {
                q4Var.o8(i10, i11);
            } else if ((i11 & 1) != 0) {
                q4Var.n8(i10, i11);
            }
        }
        fragmentManager.x("menu_result");
    }

    public static /* synthetic */ s5.a d5(String str, String str2) {
        m9.c cVarD = la.s.d();
        m9.a aVarE = cVarD.e(str);
        if (aVarE == null) {
            aVarE = cVarD.h(str2);
        }
        return s5.a.f(aVarE);
    }

    public static /* synthetic */ void e3(q4 q4Var, boolean z10, int i10, DialogInterface dialogInterface) {
        if (z10) {
            q4Var.K8(i10 | 4);
        } else {
            q4Var.getClass();
        }
    }

    public static /* synthetic */ void e5(q4 q4Var, View view) {
        String strU7 = q4Var.u7();
        if (strU7 == null || strU7.isEmpty()) {
            return;
        }
        x8.e1.k(q4Var.G(), strU7);
    }

    public static /* synthetic */ boolean f3(q4 q4Var, View view, DragEvent dragEvent) {
        q4Var.getClass();
        int action = dragEvent.getAction();
        if (action == 3) {
            y.r.c(view).a(1.0f).d(180L).f();
            return q4Var.y7(dragEvent.getClipData());
        }
        if (action != 4) {
            if (action == 5) {
                y.r.c(view).a(0.3f).d(100L).f();
                return true;
            }
            if (action != 6) {
                return true;
            }
        }
        y.r.c(view).a(1.0f).d(100L).f();
        return true;
    }

    public static /* synthetic */ boolean f4(q4 q4Var, String[] strArr, AdapterView adapterView, View view, int i10, long j10) {
        com.tuyafeng.support.utils.n.a(q4Var.G(), strArr[i10], w7.u.Fg);
        return true;
    }

    public static /* synthetic */ void g3(q4 q4Var, String str, View view, q5.k.p pVar) {
        q4Var.getClass();
        c6.i1 i1Var = c6.i1.f2033a;
        final c6.i0 i0VarA = i1Var.a(str, q4Var.s7(), i1Var.b(pVar.f11817a[0]), pVar.f11819c[0], x8.s1.g());
        if (i0VarA == null) {
            return;
        }
        x8.h.b(new Runnable() { // from class: mark.via.browser.m0
            @Override // java.lang.Runnable
            public final void run() {
                i0VarA.c();
            }
        });
        com.tuyafeng.support.utils.n.q(q4Var.G(), w7.u.f14090ib);
    }

    public static /* synthetic */ void g4(q4 q4Var, t4.b bVar, String str, String str2) {
        if (bVar == q4Var.H() && TextUtils.equals(str, bVar.getUrl()) && !"true".equals(str2)) {
            q4Var.f9485o0.a2();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    public static /* synthetic */ void g5(final q4 q4Var, mark.via.common.widget.t tVar) {
        int i10;
        boolean zE = q4Var.f9487p0.e();
        int iF0 = q4Var.U0;
        boolean z10 = false;
        boolean z11 = iF0 == 0;
        g9.a aVarQ2 = q4Var.f9487p0.Q2();
        if (!zE) {
            if (!z11 || !aVarQ2.c()) {
                if (z11) {
                    iF0 = q4Var.f9487p0.f0();
                }
                if (com.tuyafeng.support.utils.x.C(iF0)) {
                    z10 = true;
                }
            } else if (aVarQ2.d()) {
                z10 = true;
            }
        }
        Context contextG = q4Var.G();
        int i11 = R.color.white;
        if (zE) {
            i10 = w7.m.f13744h;
        } else {
            i10 = z10 ? w7.m.f13743g : R.color.white;
        }
        int iB = com.tuyafeng.support.utils.f.b(contextG, i10);
        Context contextG2 = q4Var.G();
        if (zE) {
            i11 = w7.m.f13741e;
        } else if (z10) {
            i11 = w7.m.f13740d;
        }
        tVar.y(iB, com.tuyafeng.support.utils.f.b(contextG2, i11));
        tVar.setTabs(q4Var.M0.c());
        tVar.setOnDeleteItemClickListener(new mark.via.common.widget.t.d() { // from class: mark.via.browser.e3
            @Override // mark.via.common.widget.t.d
            public final void a(int i12) {
                this.f9102a.f9485o0.D0(i12);
            }
        });
        tVar.setOnNewTabButtonClickListener(new mark.via.common.widget.t.h() { // from class: mark.via.browser.f3
            @Override // mark.via.common.widget.t.h
            public final void onClick(View view) {
                this.f9128a.f9485o0.k1(null, true);
            }
        });
        tVar.setOnTabItemClickListener(new mark.via.common.widget.t.i() { // from class: mark.via.browser.g3
            @Override // mark.via.common.widget.t.i
            public final void a(int i12) {
                this.f9151a.f9485o0.Y1(i12);
            }
        });
        tVar.setOnMoveTabListener(new mark.via.common.widget.t.g() { // from class: mark.via.browser.h3
            @Override // mark.via.common.widget.t.g
            public final boolean onMove(int i12, int i13) {
                return this.f9194a.M0.p(i12, i13);
            }
        });
        tVar.setOnDeleteTabsListener(new mark.via.common.widget.t.e() { // from class: mark.via.browser.i3
            @Override // mark.via.common.widget.t.e
            public final void b(int i12, int i13) {
                this.f9222a.V6(i12, i13);
            }
        });
        tVar.setOnDuplicateTabListener(new mark.via.common.widget.t.f() { // from class: mark.via.browser.j3
            @Override // mark.via.common.widget.t.f
            public final void a(int i12) {
                q4.D4(this.f9248a, i12);
            }
        });
    }

    public static /* synthetic */ void h3(q4 q4Var, q9 q9Var, q9.b bVar, String str) {
        if (q4Var.a1() == null || !q9Var.i(bVar)) {
            return;
        }
        bVar.b(str);
    }

    public static /* synthetic */ void h4(q4 q4Var, s5.a aVar) {
        q4Var.getClass();
        q4Var.w8(aVar.d() ? ((m9.a) aVar.b()).b() : null);
    }

    public static /* synthetic */ void i3(q4 q4Var, List list, View view, q5.k.p pVar) {
        int iK = q4Var.k() + 1;
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            q4Var.f9485o0.h1((String) list.get(i10), i10 == size + (-1), iK);
            i10++;
            iK++;
        }
    }

    public static /* synthetic */ void j4(q4 q4Var, boolean z10) {
        if (q4Var.g1()) {
            q4Var.X9();
            if (!q4Var.f9486o1) {
                q4Var.f9485o0.S1(z10);
                return;
            }
            Intent intent = q4Var.i0().getIntent();
            if (intent != null) {
                q4Var.f9485o0.r1(intent);
            }
        }
    }

    public static /* synthetic */ void k3(q4 q4Var, TextView textView) {
        q4Var.getClass();
        textView.setText(w7.u.f14186p9);
        textView.setGravity(17);
        textView.setTextSize(0, v8.h.t(q4Var.G()));
        textView.setTextColor(v8.h.p(q4Var.G()));
    }

    public static /* synthetic */ void k4(q4 q4Var, String str, Bundle bundle) {
        q4Var.getClass();
        if (bundle.getInt("result_id", -1) >= 0) {
            u9.n.e().u(true);
            if (s9.d.l(q4Var.G(), q4Var.u7())) {
                q4Var.f9485o0.z1();
            } else {
                com.tuyafeng.support.utils.n.q(q4Var.G(), w7.u.B0);
            }
        }
        q4Var.L0().x("fav_result");
    }

    public static /* synthetic */ void l3(q4 q4Var, String str, Bundle bundle) {
        q4Var.getClass();
        List<j8.a> listA = j8.b.a(bundle);
        if (listA != null && !listA.isEmpty()) {
            for (j8.a aVar : listA) {
                int iB = aVar.b();
                if (iB == 1) {
                    q4Var.f9485o0.k1(aVar.a(), true);
                } else if (iB == 2) {
                    q4Var.f9485o0.k1(aVar.a(), false);
                } else if (iB != 3) {
                    q4Var.k9(aVar.a());
                } else {
                    q4Var.g(new r4.b(aVar.a()), q4Var.f9485o0.T0(), false);
                }
            }
        }
        q4Var.L0().x("result");
    }

    public static /* synthetic */ void l4(final q4 q4Var, String str, String str2, Integer num) {
        q4Var.getClass();
        if (num.intValue() != -1 && (!u8.e.f12906a.contains("huawei") || q4Var.f9487p0.X2() >= 1)) {
            z7.u1.x3(str, str2).g3(q4Var.x0(), null);
            return;
        }
        u9.l lVar = q4Var.f9487p0;
        lVar.f1(lVar.X2() + 1);
        q5.k.l(q4Var.G()).f0(w7.u.f14299y0).J(w7.u.P8).X(w7.u.Bc, new q5.k.m() { // from class: mark.via.browser.o0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) throws Throwable {
                u8.e.g(this.f9383a.G());
            }
        }).P(R.string.cancel, null).h0();
    }

    private void l7() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        y.r.e0(this.B0, new y.m() { // from class: mark.via.browser.s2
            @Override // y.m
            public final y.k0 a(View view, y.k0 k0Var) {
                return q4.s4(this.f9635a, view, k0Var);
            }
        });
    }

    public static /* synthetic */ void n3(q4 q4Var, Map map, AdapterView adapterView, View view, int i10, long j10) {
        q4Var.getClass();
        int i11 = (int) j10;
        PendingIntent pendingIntent = (PendingIntent) map.get(Integer.valueOf(i11));
        if (pendingIntent != null) {
            q4Var.n9(pendingIntent);
        }
        String strU7 = q4Var.u7();
        switch (i11) {
            case 990:
                if (strU7 != null && !strU7.isEmpty()) {
                    x8.e1.k(q4Var.G(), strU7);
                    break;
                }
                break;
            case 992:
                if (strU7 != null && !strU7.isEmpty()) {
                    com.tuyafeng.support.utils.n.a(q4Var.G(), strU7, w7.u.Fg);
                    break;
                }
                break;
            case 993:
                q4Var.P8(14);
                break;
            case 994:
                q4Var.P8(6);
                break;
            case 995:
                if (strU7 != null && !strU7.isEmpty()) {
                    x8.z.O(q4Var.G(), strU7);
                    q4Var.i0().finish();
                    break;
                }
                break;
            case 996:
                q4Var.P8(15);
                break;
            case 997:
                if (strU7 != null && !strU7.isEmpty()) {
                    q4Var.M9(strU7);
                    break;
                }
                break;
            case 998:
                q4Var.N8(strU7);
                break;
        }
    }

    public static /* synthetic */ mark.via.common.widget.o0 n4(q4 q4Var, boolean z10, String str, String str2, int i10, int i11) {
        Bitmap bitmapC;
        q4Var.getClass();
        if (z10) {
            bitmapC = BitmapFactory.decodeFile(str);
        } else {
            bitmapC = x8.i.c(str2, i10, i11);
            tc.a.a("using file does not exists, load from original picture", new Object[0]);
        }
        if (bitmapC == null) {
            return null;
        }
        return new mark.via.common.widget.o0(q4Var.R0(), bitmapC);
    }

    public static /* synthetic */ void o3(q4 q4Var, List list, View view, q5.k.p pVar) {
        int iK = q4Var.k() + 1;
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            q4Var.f9485o0.h1((String) list.get(i10), i10 == size + (-1), iK);
            i10++;
            iK++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0255  */
    public static /* synthetic */ void p4(final q4 q4Var, String str, String str2, int i10, int i11, int i12, String str3, String str4, t4.b bVar, String str5, AdapterView adapterView, View view, int i13, long j10) {
        final String strI;
        q4Var.getClass();
        int i14 = (int) j10;
        switch (i14) {
            case 0:
            case 1:
                q4Var.f9485o0.j1(str, i14 == 1);
                break;
            case 2:
                q4Var.f9485o0.l1(str2, true);
                break;
            case 3:
                Context contextG = q4Var.G();
                if (i10 == 6) {
                    str = str.substring(str.indexOf("://") + 3);
                }
                com.tuyafeng.support.utils.n.a(contextG, str, w7.u.Fg);
                break;
            case 6:
                q4Var.S0.C(str2);
                break;
            case 7:
                q4Var.S0.G(str2, i11, i12);
                break;
            case 8:
                q4Var.f7();
                break;
            case 9:
                q4Var.b7(str);
                break;
            case 10:
                if (q4Var.f9485o0.l0(str)) {
                    u9.n.e().u(true);
                    com.tuyafeng.support.utils.n.q(q4Var.G(), w7.u.B0);
                }
                break;
            case 11:
                if (q4Var.f9485o0.B0(str)) {
                    u9.n.e().q(true);
                    q4Var.f9485o0.z1();
                }
                break;
            case 12:
            case 13:
                if (x8.r2.r(str)) {
                    String strSubstring = str.substring(9);
                    try {
                        strSubstring = URLDecoder.decode(str.substring(9), "utf-8");
                        break;
                    } catch (UnsupportedEncodingException unused) {
                    }
                    m9.a aVarH = la.s.d().h(strSubstring);
                    if (aVarH != null) {
                        strI = aVarH.b();
                    } else {
                        strI = null;
                    }
                } else if (x8.r2.n(str)) {
                    strI = x8.r2.i(str);
                } else {
                    strI = null;
                }
                if (strI != null) {
                    if (i14 != 12) {
                        q5.k.l(q4Var.G()).f0(w7.u.f14298y).K(q4Var.Y0(w7.u.f14222s3, strI)).X(w7.u.f14298y, new q5.k.m() { // from class: mark.via.browser.y0
                            @Override // q5.k.m
                            public final void a(View view2, q5.k.p pVar) {
                                q4.Y2(this.f9770a, strI, view2, pVar);
                            }
                        }).P(R.string.cancel, null).h0();
                    } else {
                        q4Var.L0().z1(z7.d0.f15227z0, q4Var, new androidx.fragment.app.i0() { // from class: mark.via.browser.x0
                            @Override // androidx.fragment.app.i0
                            public final void a(String str6, Bundle bundle) {
                                this.f9743a.L0().x(z7.d0.f15227z0);
                            }
                        });
                        FragmentUtils.j(q4Var, z7.d0.class, z7.d0.r3(strI, null, true));
                    }
                    break;
                }
                break;
            case 14:
                q4Var.d7(str);
                break;
            case 15:
                Context contextG2 = q4Var.G();
                final p8 p8Var = q4Var.f9485o0;
                Objects.requireNonNull(p8Var);
                r9.a.a(contextG2, str, new Runnable() { // from class: mark.via.browser.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        p8Var.z1();
                    }
                });
                break;
            case 16:
                r9.e.f(q4Var.G(), str);
                q4Var.f9485o0.z1();
                break;
            case 17:
                Context contextG3 = q4Var.G();
                final p8 p8Var2 = q4Var.f9485o0;
                Objects.requireNonNull(p8Var2);
                r9.e.e(contextG3, new Runnable() { // from class: mark.via.browser.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        p8Var2.z1();
                    }
                });
                break;
            case 18:
                String str6 = str.substring(7, str.lastIndexOf(47) + 1) + Uri.decode(str.substring(str.lastIndexOf("/") + 1));
                if (!x8.c1.g(str6)) {
                    com.tuyafeng.support.utils.n.s(q4Var.G(), q4Var.R0().getString(w7.u.f14250u3) + str6);
                } else {
                    q4Var.f9485o0.z1();
                }
                break;
            case 19:
                q4Var.L6(str, q4Var.t7(str));
                break;
            case 20:
                q4Var.P0.K(new mark.via.download.o.b().j(str).k(q4Var.f9487p0.L1()).c("attachment").d(-1L).b());
                break;
            case 21:
                com.tuyafeng.support.utils.n.e(q4Var.G(), w7.u.f14311z, w7.u.K3, new q5.k.m() { // from class: mark.via.browser.a1
                    @Override // q5.k.m
                    public final void a(View view2, q5.k.p pVar) {
                        this.f8995a.f9485o0.u0();
                    }
                });
                break;
            case 22:
                StringBuilder sb2 = new StringBuilder();
                String strT7 = q4Var.t7(str3);
                if (strT7 != null && !strT7.isEmpty()) {
                    sb2.append(q4Var.X0(w7.u.f14075ha));
                    sb2.append("\n");
                    sb2.append(strT7);
                }
                if (str3 != null && !str3.isEmpty()) {
                    if (sb2.length() > 0) {
                        sb2.append("\n\n");
                    }
                    sb2.append(q4Var.X0(w7.u.f14089ia));
                    sb2.append("\n");
                    sb2.append(str3);
                }
                if (str != null && !str.isEmpty()) {
                    if (sb2.length() > 0) {
                        sb2.append("\n\n");
                    }
                    sb2.append(q4Var.X0(w7.u.f14061ga));
                    sb2.append("\n");
                    sb2.append(str);
                }
                com.tuyafeng.support.utils.n.l(q4Var.G(), w7.u.T, sb2.toString());
                break;
            case 23:
                q4Var.a8();
                break;
            case 24:
            case 25:
                if (i14 == 24) {
                    q4Var.f9485o0.j0(str);
                } else {
                    q4Var.f9485o0.B1(str);
                }
                com.tuyafeng.support.utils.n.s(q4Var.G(), q4Var.Y0(i14 == 24 ? w7.u.H1 : w7.u.sh, c6.a2.f1958a.g(str)));
                break;
            case 26:
            case 27:
                if (i14 == 26) {
                    q4Var.f9485o0.k0(str);
                } else {
                    q4Var.f9485o0.C1(str);
                }
                com.tuyafeng.support.utils.n.s(q4Var.G(), q4Var.Y0(i14 == 26 ? w7.u.H1 : w7.u.sh, str.substring(str.indexOf("://") + 3)));
                break;
            case 29:
                if (str4 != null) {
                    com.tuyafeng.support.utils.n.a(q4Var.G(), str4.trim(), w7.u.Eg);
                }
                break;
            case 31:
                x8.e1.k(q4Var.G(), str);
                break;
            case 32:
                q4Var.B8(str);
                break;
            case 33:
                q4Var.S0.H(str2);
                break;
            case 34:
                q4Var.S0.E(str2);
                break;
            case 35:
                if (q4Var.H() == bVar && TextUtils.equals(str3, q4Var.u7())) {
                    q4Var.f9477g1.C(q4Var.H(), i11, i12, q4Var.f9476f1);
                    break;
                }
                break;
            case 36:
                q4Var.Z7(i11, i12, str5, str2, str4, true);
                break;
            case 37:
                FragmentUtils.i(q4Var, g8.w.class);
                break;
            case 38:
                q4Var.Z6(str2);
                break;
            case 39:
                q4Var.S0.w(str2);
                break;
        }
    }

    public static /* synthetic */ List q4(q4 q4Var) {
        int[] iArrP = com.tuyafeng.support.utils.p.p(com.tuyafeng.support.utils.p.m(q4Var.f9487p0.D()), ',');
        int iM1 = q4Var.f9487p0.M1();
        List listE = x8.q2.e(q4Var.G());
        for (int size = listE.size() - 1; size >= 0; size--) {
            int iD = ((ga.c) listE.get(size)).d();
            if (iM1 != iD && com.tuyafeng.support.utils.a.b(iArrP, iD)) {
                listE.remove(size);
            }
        }
        return listE;
    }

    public static /* synthetic */ void r3(q4 q4Var, String str, String str2, Bundle bundle) {
        q4Var.getClass();
        int i10 = bundle.getInt("changed", 0);
        if ((i10 & 2) != 0) {
            q4Var.H9(true, i10);
        } else if ((i10 & 1) != 0) {
            q4Var.f9485o0.w1(str);
        }
        q4Var.L0().x("result");
    }

    public static /* synthetic */ void r4(q4 q4Var, String str, String str2, AdapterView adapterView, View view, int i10, long j10) {
        q4Var.getClass();
        q4Var.f9485o0.j1(j10 == 1 ? c6.x1.f2137a.a(str, str2) : c6.x1.f2137a.c(str, str2), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r9(int i10, int i11, boolean z10) {
        d8.h hVar = (d8.h) x0().n0(d8.h.f3955x0);
        if (hVar == null) {
            return;
        }
        hVar.f3(i10, i11, z10);
    }

    public static /* synthetic */ void s3(ta.y yVar, String str) {
        if ("null".equals(str)) {
            return;
        }
        if (str.length() >= 2) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        }
        yVar.p3(str);
    }

    public static /* synthetic */ y.k0 s4(q4 q4Var, View view, y.k0 k0Var) {
        q4Var.f9491r0.b(k0Var);
        int iF = y.k0.m.f() | y.k0.m.b();
        y.k0.b bVar = new y.k0.b(k0Var);
        if (!q4Var.f9491r0.i()) {
            iF |= y.k0.m.c();
            bVar.e(y.k0.m.c(), false);
        }
        r.f fVar = r.f.f11874e;
        y.k0 k0VarA = bVar.b(iF, fVar).a();
        x8.h3.v(k0Var);
        if (!x8.h3.l(k0Var, view)) {
            q4Var.m7(view, k0Var, true);
            return k0VarA;
        }
        r.f fVarF = k0Var.f(y.k0.m.b());
        if (fVar.equals(fVarF)) {
            q4Var.m7(view, k0Var, false);
            return k0VarA;
        }
        if (!q4Var.f9487p0.O1() && q4Var.f9482l1) {
            if (Resources.getSystem().getConfiguration().orientation == 2) {
                view.setPadding(fVarF.f11875a, 0, fVarF.f11877c, 0);
            } else {
                view.setPadding(0, fVarF.f11876b, 0, fVarF.f11878d);
            }
            q4Var.A0.setPadding(0, 0, 0, 0);
            q4Var.f9505y0.setPadding(0, 0, 0, 0);
            q4Var.f9501w0.setPadding(0, 0, 0, 0);
            return k0VarA;
        }
        y.c cVarE = k0Var.e();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (cVarE != null && measuredWidth > 0 && measuredHeight > 0) {
            r.f fVarF2 = k0Var.f(y.k0.m.c());
            List<Rect> listA = cVarE.a();
            int[] iArr = {0, 0, 0, 0};
            int[] iArr2 = {0, 0, 0, 0};
            int iH = com.tuyafeng.support.utils.x.h(view.getContext(), 16.0f);
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
                } else if (fVarF2.f11878d <= 0 && rect.bottom >= measuredHeight - iH) {
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
            if (!q4Var.f9472b1 || q4Var.C0 == null || (q4Var.W0 != 1 ? iArr2[3] >= (q4Var.f9505y0.getMeasuredHeight() / 2) * 3 : iArr[1] >= (q4Var.A0.getMeasuredHeight() / 2) * 3)) {
                q4Var.A0.setPadding(iArr[0], 0, iArr[2], 0);
                q4Var.f9505y0.setPadding(iArr2[0], 0, iArr2[2], 0);
                q4Var.f9501w0.setPadding(0, 0, 0, 0);
            } else {
                q4Var.A0.setPadding(0, 0, 0, 0);
                q4Var.f9505y0.setPadding(0, 0, 0, 0);
                if (q4Var.W0 == 1) {
                    q4Var.f9501w0.setPadding(iArr[0], 0, iArr[2], 0);
                } else {
                    q4Var.f9501w0.setPadding(iArr2[0], 0, iArr2[2], 0);
                }
            }
            view.setPadding(0, 0, 0, 0);
        }
        return k0VarA;
    }

    public static /* synthetic */ d7.h t3(q4 q4Var, String str, String str2, String str3, int i10, String str4) {
        q4Var.getClass();
        z8.g.t3(str, new a9.z(str2, str3, str4), i10).g3(q4Var.x0(), null);
        return null;
    }

    public static /* synthetic */ void t4(q4 q4Var, View view, q5.k.p pVar) {
        q4Var.getClass();
        if (pVar.f11818b) {
            u9.a aVarV = q4Var.f9487p0.v();
            aVarV.C(false);
            q4Var.f9487p0.Z(aVarV);
        }
        q4Var.i0().finish();
    }

    public static /* synthetic */ void u4(q4 q4Var, int i10, boolean z10, int i11, TextView textView, String str, mark.via.common.widget.w0 w0Var) {
        q4Var.getClass();
        w0Var.setMax(30);
        w0Var.setProgress((i10 - 50) / 5);
        if (!z10) {
            i11 = 100;
        }
        w0Var.setHighlightProgress((i11 - 50) / 5);
        x8.r3.h(w0Var);
        w0Var.setMinimumHeight(com.tuyafeng.support.utils.x.h(q4Var.G(), 2.0f));
        w0Var.setOnSeekBarChangeListener(q4Var.new d(textView, z10, str));
    }

    public static /* synthetic */ void v4(q4 q4Var, t4.b bVar, String str, String str2) {
        if (q4Var.H() == null) {
            return;
        }
        s4.b.g(bVar, c6.b2.f1963a.j(q4Var.R0.d(), str, str2));
    }

    public static /* synthetic */ void w3(q4 q4Var, View view, q5.k.p pVar) {
        int i10 = q4Var.i();
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
        q4Var.U6(iArr);
    }

    public static /* synthetic */ boolean w4(final q4 q4Var, final String str, final Intent intent, View view) {
        q5.k.l(q4Var.G()).f0(w7.u.f14256u9).K(str).X(w7.u.f14228s9, new q5.k.m() { // from class: mark.via.browser.j0
            @Override // q5.k.m
            public final void a(View view2, q5.k.p pVar) {
                this.f9243a.S9(intent);
            }
        }).P(R.string.cancel, null).T(R.string.copy, new View.OnClickListener() { // from class: mark.via.browser.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.tuyafeng.support.utils.n.a(this.f9271a.G(), str, w7.u.Fg);
            }
        }).h0();
        return true;
    }

    public static /* synthetic */ void x3(q4 q4Var, s5.a aVar) {
        q4Var.getClass();
        q4Var.w8(aVar.d() ? ((m9.a) aVar.b()).b() : null);
    }

    public static /* synthetic */ void y3(q4 q4Var, String[] strArr, AdapterView adapterView, View view, int i10, long j10) {
        q4Var.getClass();
        q4Var.L6(strArr[i10], q4Var.s7());
    }

    public static /* synthetic */ void y4(final q4 q4Var) {
        final androidx.fragment.app.q qVarS0 = q4Var.s0();
        if (qVarS0 == null) {
            return;
        }
        qVarS0.runOnUiThread(new Runnable() { // from class: mark.via.browser.c4
            @Override // java.lang.Runnable
            public final void run() {
                q4.T2(this.f9053c, qVarS0);
            }
        });
    }

    public static /* synthetic */ void z4(final q4 q4Var, mark.via.common.widget.o0 o0Var) {
        q4Var.getClass();
        tc.a.a("init home view done", new Object[0]);
        q4Var.f9489q0.setWindowBackgroundImage(o0Var);
        q4Var.f9493s0.post(new Runnable() { // from class: mark.via.browser.n3
            @Override // java.lang.Runnable
            public final void run() {
                this.f9365c.aa();
            }
        });
    }

    @Override // c8.j.a
    public void A(final boolean z10) {
        if (!this.f9471a1 || z10 == this.E1) {
            return;
        }
        this.E1 = z10;
        this.f9507z0.post(new Runnable() { // from class: mark.via.browser.d4
            @Override // java.lang.Runnable
            public final void run() {
                this.f9077c.f9507z0.t(!z10, true);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        tc.a.a("BrowserFragment::onCreateView", new Object[0]);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        z5 z5Var = new z5(G());
        z5Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f9489q0 = z5Var;
        tc.a.a("BrowserFragment::onCreateView, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return z5Var;
    }

    public final boolean A7() {
        return x0().u0() > 0;
    }

    public final void A8() {
        X7();
        if (this.Z0) {
            C9();
        } else {
            FragmentUtils.i(this, mark.via.download.m1.class);
        }
    }

    public final void A9(final String str) {
        final String strG = c6.a2.f1958a.g(str);
        if (strG == null || strG.isEmpty()) {
            return;
        }
        final String strU = x8.z.u(str);
        if (strU == null || strU.isEmpty()) {
            q5.k.l(G()).g0(Y0(w7.u.gg, strG)).J(w7.u.f14185p8).X(R.string.ok, null).h0();
        } else {
            q5.k.l(G()).g0(Y0(w7.u.gg, strG)).K(strU).X(R.string.copy, new q5.k.m() { // from class: mark.via.browser.w
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    com.tuyafeng.support.utils.n.a(this.f9713a.G(), strU, w7.u.Eg);
                }
            }).P(R.string.cancel, null).T(w7.u.f14298y, new View.OnClickListener() { // from class: mark.via.browser.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q4.a3(this.f9740a, str, strG, view);
                }
            }).h0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        this.N0.b(G());
        G().unregisterReceiver(this.F0);
        this.I1.c();
        super.B1();
    }

    public final boolean B7() {
        return this.f9489q0.h();
    }

    public void B8(final String str) {
        t4.b bVarH = H();
        if (bVarH != null) {
            bVarH.evaluateJavascript("javascript:(function(){var t=document.getElementsByClassName(\"box\"),e=0,n=t.length;if(0<n){var o=t[0].getBoundingClientRect().top;for(i=0;i<n&&t[i].getBoundingClientRect().top==o;i++)e++;return(o>0?o<<6:0)|e}return e})();", new ValueCallback() { // from class: mark.via.browser.b1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    q4.U4(this.f9024a, str, (String) obj);
                }
            });
        } else {
            C8(0, 0, str);
        }
    }

    public final void B9(View view) {
        ArrayList arrayList = new ArrayList();
        final HashMap map = new HashMap();
        Bundle bundleW0 = w0();
        ArrayList<Bundle> arrayListB = bundleW0 == null ? null : com.tuyafeng.support.utils.d.b(bundleW0, "android.support.customtabs.extra.MENU_ITEMS", Bundle.class);
        if (arrayListB != null) {
            int i10 = 0;
            for (Bundle bundle : arrayListB) {
                String string = bundle.getString("android.support.customtabs.customaction.MENU_ITEM_TITLE");
                PendingIntent pendingIntent = (PendingIntent) com.tuyafeng.support.utils.d.a(bundle, "android.support.customtabs.customaction.PENDING_INTENT", PendingIntent.class);
                if (string != null && pendingIntent != null) {
                    i10++;
                    map.put(Integer.valueOf(i10), pendingIntent);
                    arrayList.add(new q5.k.l(i10, string));
                }
            }
        }
        com.tuyafeng.support.widget.e0 e0Var = this.K1;
        if (e0Var != null && e0Var.findViewById(990) == null) {
            arrayList.add(new q5.k.l(990, X0(w7.u.f14037f0)));
        }
        arrayList.add(new q5.k.l(994, X0(w7.u.f13994c)));
        arrayList.add(new q5.k.l(993, X0(w7.u.G)));
        arrayList.add(new q5.k.l(996, X0(w7.u.f14079i0)));
        boolean zC = this.f9487p0.n2().C();
        String strU7 = u7();
        if (zC && c6.a2.f1958a.t(strU7) && !p9.a.a().r(strU7) && kd.c().f().C(strU7)) {
            arrayList.add(new q5.k.l(997, X0(w7.u.qi)));
        }
        arrayList.add(new q5.k.l(992, X0(w7.u.f14218s)));
        arrayList.add(new q5.k.l(998, X0(w7.u.H9)));
        arrayList.add(new q5.k.l(995, X0(w7.u.C9)));
        q5.k.l(G()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.y3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                q4.n3(this.f9774a, map, adapterView, view2, i11, j10);
            }
        }).k0(view, view.getWidth(), com.tuyafeng.support.utils.x.h(G(), 4.0f));
    }

    @Override // c8.i.a
    public boolean C(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        if (this.f9504x1 == null) {
            this.f9504x1 = new GestureTouchEvent(this.f9489q0.f9818r, R6());
        }
        if (this.f9477g1.z(view, motionEvent)) {
            return false;
        }
        this.f9504x1.g(view, motionEvent);
        if (!this.f9482l1) {
            this.O0.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final boolean C7() {
        r4.a aVarD = d();
        return aVarD != null && b8.d.c().g(aVarD.getId());
    }

    public final void C8(int i10, int i11, String str) {
        L0().z1("favoriteChanged", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.f1
            @Override // androidx.fragment.app.i0
            public final void a(String str2, Bundle bundle) {
                q4.F3(this.f9126a, str2, bundle);
            }
        });
        androidx.fragment.app.l0 l0VarX = L0().q().x(true);
        int i12 = w7.i.f13703a;
        int i13 = w7.i.f13709g;
        l0VarX.v(i12, i13, i13, w7.i.f13704b).c(FragmentUtils.f3568a, ma.e1.class, ma.e1.a3(i10, i11), null).g(null).i();
    }

    public final void C9() {
        x0().q().c(w7.p.B, d8.z.class, d8.d.f().g((this.W0 == 1 ? 48 : 80) | 8388613).j(p7()).h(-1).a(), null).g(null).i();
        N9();
        E7();
    }

    @Override // c8.g1.a
    public void D(String str) {
        int iIndexOf;
        String strF = x8.r2.f(str);
        Y9(strF);
        this.f9507z0.u(URLUtil.isHttpsUrl(strF), !this.f9485o0.X1(strF));
        int iI1 = this.f9487p0.i1();
        if (this.f9472b1 && iI1 == 0) {
            iI1 = 2;
        }
        ca(strF);
        com.tuyafeng.support.widget.e0 e0Var = this.K1;
        if (e0Var != null) {
            e0Var.setTitle(c6.a2.f1958a.g(strF));
        }
        if (iI1 == 0 || TextUtils.isEmpty(strF) || s9.d.l(G(), strF)) {
            return;
        }
        String strD = x8.z.D(strF);
        if (iI1 == 2) {
            String strG = c6.a2.f1958a.g(strD);
            if (strG != null && !strG.isEmpty()) {
                strD = strG;
            }
        } else if (URLUtil.isNetworkUrl(strD) && (iIndexOf = (strD = strD.substring(strD.indexOf("://") + 3)).indexOf(47)) == strD.length() - 1) {
            strD = strD.substring(0, iIndexOf);
        }
        this.f9507z0.setTitle(strD);
    }

    @Override // androidx.fragment.app.Fragment
    public void D1() {
        mark.via.browser.c cVar = this.f9479i1;
        if (cVar != null) {
            cVar.n();
            this.f9479i1 = null;
        }
        this.G0.X();
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.f9497u0.J();
        this.f9497u0 = null;
        d9();
        this.f9491r0.g();
        y.r.e0(this.B0, null);
        this.f9493s0.removeAllViews();
        this.M0.h();
        this.f9485o0.p1();
        super.D1();
    }

    public final boolean D7() {
        if (x0().u0() <= 0) {
            return false;
        }
        G9();
        H7();
        x0().e1();
        return true;
    }

    public final void D8() {
        X7();
        FragmentUtils.k(this, bb.i.class, bb.i.m3(true, 2), "RecordContainerFragment");
    }

    public final void D9() {
        final String strU7 = u7();
        if (!URLUtil.isNetworkUrl(strU7)) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.Z1);
            return;
        }
        final String strG = x8.s1.g();
        boolean z10 = (x8.a0.f() || x8.f.h()) && this.f9487p0.M1() != -1;
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(new q5.k.l(1, X0(w7.u.bh)));
        }
        arrayList.add(new q5.k.l(3, X0(w7.u.ch)));
        q5.k.l(G()).f0(w7.u.f14079i0).D(arrayList, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.p2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                q4.r4(this.f9407a, strU7, strG, adapterView, view, i10, j10);
            }
        }).h0();
    }

    @Override // r4.f
    public void E(int i10, int i11, int i12) {
        mark.via.common.widget.t tVar = this.C0;
        if (tVar == null) {
            return;
        }
        tVar.v(i10, i11);
        this.C0.x(i12);
    }

    @Override // androidx.fragment.app.Fragment
    public void E1() {
        L0().o1(this);
        G().unregisterComponentCallbacks(this);
        super.E1();
    }

    public final void E7() {
        F7(true);
    }

    public final void E8() {
        L0().z1("qrcode", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.r2
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                q4.V4(this.f9591a, str, bundle);
            }
        });
        FragmentUtils.i(this, fb.q.class);
    }

    public final void E9() {
        F9(null);
    }

    @Override // r4.f
    public void F(int i10) {
        b8();
        mark.via.common.widget.t tVar = this.C0;
        if (tVar == null) {
            return;
        }
        tVar.w(i10);
    }

    public final void F7(boolean z10) {
        ImageView imageView;
        if (!this.f9498u1 || (imageView = this.f9499v0) == null) {
            return;
        }
        if (z10) {
            y.r.c(imageView).i(new Runnable() { // from class: mark.via.browser.j1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9245c.f9499v0.setVisibility(8);
                }
            }).h(com.tuyafeng.support.utils.x.h(G(), 32.0f)).a(0.0f).d(160L).f();
        } else {
            imageView.setVisibility(8);
        }
        this.f9498u1 = false;
    }

    public final void F8() {
        L0().z1("restore_tabs", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.t0
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                q4.T4(this.f9659a, str, bundle);
            }
        });
        FragmentUtils.i(this, hd.class);
    }

    public final void F9(String str) {
        EditText editText = (EditText) this.f9489q0.f9815o.findViewById(d8.o.f3978c);
        if (editText != null) {
            editText.setText(str);
            return;
        }
        int i10 = this.W0;
        x0().q().c(w7.p.B, d8.h.class, d8.d.f().g(((i10 == 1 || i10 == 4) ? 48 : 80) | 8388613).j(p7()).i(this.V0 && B7()).e("TEXT", str).a(), d8.h.f3955x0).g(null).i();
        E7();
    }

    @Override // androidx.fragment.app.Fragment
    public void G1(boolean z10) {
        super.G1(z10);
        if (!z10) {
            f9();
            return;
        }
        i9();
        int iA = v8.h.a(G());
        x8.h3.u(G(), iA);
        x8.h3.t(G(), iA);
    }

    public final void G7() {
        if (this.X0 == 0 || this.A1) {
            return;
        }
        if (this.f9490q1 || this.f9492r1 < 1.0f) {
            K6(false);
        }
    }

    public final void G8(boolean z10) {
        if (z10) {
            y8(null);
        } else {
            D8();
        }
    }

    public final void G9() {
        if (this.f9482l1 || this.f9498u1 || !this.Y0 || this.f9490q1) {
            return;
        }
        if (this.f9499v0 == null) {
            K7();
        }
        y.r.c(this.f9499v0).j(new Runnable() { // from class: mark.via.browser.l2
            @Override // java.lang.Runnable
            public final void run() {
                q4.I4(this.f9297c);
            }
        }).h(0.0f).a(1.0f).d(160L).f();
        this.f9498u1 = true;
    }

    @Override // c8.d0.a
    public t4.b H() {
        r4.a aVarD = d();
        if (aVarD == null) {
            return null;
        }
        return aVarD.o();
    }

    public final void H7() {
        if (this.f9489q0.i()) {
            this.f9493s0.setImportantForAccessibility(0);
            x8.l.b(this.D0);
        }
    }

    public final void H8() {
        X7();
        FragmentUtils.k(this, bb.i.class, bb.i.m3(true, 3), "RecordContainerFragment");
    }

    public final void H9(final boolean z10, final int i10) {
        final String strU7 = u7();
        final int iU0 = this.f9485o0.U0(strU7);
        final int iH0 = this.f9487p0.H0();
        final boolean z11 = iU0 > 0 || z10;
        if (z11 && iU0 == 0) {
            iU0 = iH0;
        }
        if (!z11) {
            iU0 = iH0;
        }
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.k4
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        final TextView textView = (TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(-1, -2)).r(1, 0, 16, 0, 16).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.l4
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q4.A3(this.f9300a, iU0, (TextView) obj);
            }
        }).l();
        final int i11 = iU0;
        mark.via.common.widget.w0 w0Var = (mark.via.common.widget.w0) new b6.a(new mark.via.common.widget.w0(new ContextThemeWrapper(i0(), w7.v.f14329f)), new LinearLayout.LayoutParams(-1, -2)).H(1, 16, 0, 16, 0).t(1, 16).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.m4
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q4.u4(this.f9338a, i11, z11, iH0, textView, strU7, (mark.via.common.widget.w0) obj);
            }
        }).l();
        linearLayout.addView(textView);
        linearLayout.addView(w0Var);
        if (z11) {
            linearLayout.addView((TextView) new b6.a(new TextView(G()), new LinearLayout.LayoutParams(-1, -2)).r(1, 0, 2, 0, 8).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.n4
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    q4.k3(this.f9366a, (TextView) obj);
                }
            }).l());
        }
        q5.k.l(G()).z(linearLayout).t(2).V(new DialogInterface.OnCancelListener() { // from class: mark.via.browser.o4
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                q4.e3(this.f9388c, z10, i10, dialogInterface);
            }
        }).h0();
    }

    public final void I6() {
        String strU7 = u7();
        String strT7 = t7(strU7);
        if (strT7 == null || strT7.isEmpty()) {
            strT7 = X0(w7.u.Ah);
        }
        c7(strU7, strT7);
    }

    public final void I7() {
        Z9(0, false);
        this.f9493s0.setBackgroundColor(0);
        this.f9493s0.setForeground(this.f9473c1);
        this.f9485o0.s0();
        this.f9485o0.r0();
        this.f9485o0.q0();
        if (this.f9487p0.v().l()) {
            return;
        }
        x8.h3.q(x8.h3.h(y0()), false);
    }

    public final void I8(String str, boolean z10) {
        r4.a aVarD = this.M0.d();
        if (aVarD == null || z10) {
            this.f9485o0.j1(str, true);
        } else {
            aVarD.u(str);
            aVarD.n();
        }
        D7();
    }

    public final void I9() {
        int i10 = this.W0;
        x0().q().c(w7.p.B, d8.q.class, d8.d.f().g(((i10 == 1 || i10 == 4) ? 48 : 80) | 8388613).j(p7()).a(), d8.q.f3984x0).g(null).i();
        E7();
    }

    @Override // c8.v0.a
    public void J(boolean z10, boolean z11, final Message message) {
        if (V7()) {
            message.sendToTarget();
            return;
        }
        String strU7 = u7();
        String strX0 = null;
        if (!this.f9485o0.W1(null, strU7)) {
            if (this.f9487p0.n2().h() && !z11) {
                strX0 = X0(w7.u.I1);
            } else if (c6.a2.f1958a.t(strU7) && !this.f9485o0.d1(strU7)) {
                strX0 = X0(w7.u.Y0);
            }
        }
        if (strX0 == null) {
            O8(message);
        } else {
            if (!o1()) {
                message.sendToTarget();
                return;
            }
            a6.h.b bVarE = new a6.h.b(i0()).h(strX0).b(w7.u.f13968a1).e(new View.OnClickListener() { // from class: mark.via.browser.h4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f9195a.O8(message);
                }
            });
            Objects.requireNonNull(message);
            bVarE.g(new a6.h.c() { // from class: mark.via.browser.i4
                @Override // a6.h.c
                public final void onCancel() {
                    message.sendToTarget();
                }
            }).a().s();
        }
    }

    public final void J6() {
        String strU7 = u7();
        if (s9.d.l(G(), strU7)) {
            e7("https://", null);
        } else {
            e7(strU7, s7());
        }
    }

    public final void J7() {
        ab.a aVarA = ab.b.a();
        this.N0 = aVarA;
        aVarA.c(new ab.a.InterfaceC0004a() { // from class: mark.via.browser.o3
            @Override // ab.a.InterfaceC0004a
            public final void a() {
                q4.y4(this.f9387a);
            }
        });
        this.N0.a(G());
    }

    public final void J8() {
        K8(2);
    }

    public final void J9() {
        if (D7()) {
            return;
        }
        final FragmentManager fragmentManagerX0 = x0();
        String simpleName = g8.k.class.getSimpleName();
        if (fragmentManagerX0.V0() || fragmentManagerX0.N0() || fragmentManagerX0.n0(simpleName) != null) {
            return;
        }
        fragmentManagerX0.z1("menu_result", b1(), new androidx.fragment.app.i0() { // from class: mark.via.browser.i2
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                q4.d4(this.f9220a, fragmentManagerX0, str, bundle);
            }
        });
        int i10 = this.W0 == 1 ? 48 : 80;
        g8.k.y3(u7(), s7(), p7(), i10 | 8388613).h3(fragmentManagerX0, simpleName);
    }

    @Override // c8.b1.a
    public void K(WebView webView) {
        String url;
        if (q9.s() || webView == null || !webView.getSettings().getJavaScriptEnabled() || (url = webView.getUrl()) == null || url.isEmpty() || c6.a2.f1958a.m(url)) {
            return;
        }
        c6.q0.f2089a.a(new c6.f(webView), this.f9476f1, String.valueOf(webView.getId()));
    }

    public final void K6(boolean z10) {
        R8();
        this.f9490q1 = z10;
        float f10 = z10 ? 0.0f : 1.0f;
        if (Math.abs(this.f9492r1 - f10) < 0.001f) {
            k7(z10);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f9492r1, f10);
        this.f9494s1 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(Math.max(1L, (long) (Math.abs(f10 - this.f9492r1) * 180.0f)));
        valueAnimatorOfFloat.setInterpolator(v8.h.b());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mark.via.browser.o2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                q4.X3(this.f9386a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new n(valueAnimatorOfFloat, z10));
        valueAnimatorOfFloat.start();
    }

    public final void K7() {
        if (this.f9499v0 != null) {
            return;
        }
        this.f9499v0 = (ImageView) new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(-2, -2)).E(com.tuyafeng.support.utils.x.h(G(), 10.0f)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.q2
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q4.K3(this.f9469a, (ImageView) obj);
            }
        }).l();
        c9();
        new mark.via.common.widget.t0(this.f9499v0).k(new b());
    }

    public final void K8(int i10) {
        String strU7 = u7();
        if (strU7 != null && !strU7.isEmpty()) {
            c6.a2 a2Var = c6.a2.f1958a;
            if (!a2Var.m(strU7)) {
                final String strF = a2Var.f(strU7);
                if (TextUtils.isEmpty(strF)) {
                    return;
                }
                L0().z1("result", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.r
                    @Override // androidx.fragment.app.i0
                    public final void a(String str, Bundle bundle) {
                        q4.r3(this.f9583a, strF, str, bundle);
                    }
                });
                FragmentUtils.j(this, jb.u4.class, jb.u4.V3(strF, i10));
                return;
            }
        }
        FragmentUtils.i(this, jb.y4.class);
    }

    public final void K9() {
        if (this.X0 == 0 || this.A1) {
            return;
        }
        if (!this.f9490q1 || this.f9492r1 > 0.0f) {
            K6(true);
        }
    }

    @Override // mark.via.browser.r8
    public void L(String str) {
        com.tuyafeng.support.utils.n.s(G(), str);
    }

    public final void L6(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Intent intentH = x8.e1.h(str, str2);
        String strY0 = this.f9487p0.y0();
        if (strY0 == null || strY0.isEmpty()) {
            x8.e1.j(G(), intentH);
            return;
        }
        intentH.setPackage(strY0);
        if (x8.e1.j(G(), intentH)) {
            return;
        }
        intentH.setPackage(null);
        x8.e1.j(G(), intentH);
    }

    public final void L7() {
        this.F0 = new m();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("mark.via.MEDIA_PLAY");
        intentFilter.addAction("mark.via.MEDIA_FASTFORWARD");
        intentFilter.addAction("mark.via.MEDIA_REWIND");
        if (Build.VERSION.SDK_INT >= 33) {
            G().registerReceiver(this.F0, intentFilter, 4);
        } else {
            G().registerReceiver(this.F0, intentFilter);
        }
    }

    public final void L8() {
        M8("");
    }

    public final void L9(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (str.length() > 1024) {
            com.tuyafeng.support.utils.n.r(G(), w7.u.N7, w7.u.f14218s, new View.OnClickListener() { // from class: mark.via.browser.j4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.tuyafeng.support.utils.n.a(this.f9249a.G(), str, w7.u.Fg);
                }
            });
        } else {
            bc.s3(str).g3(x0(), null);
        }
    }

    @Override // mark.via.browser.r8
    public void M(Runnable runnable) {
        x8.h.d(this, runnable);
    }

    @Override // androidx.fragment.app.Fragment
    public void M1() {
        d9();
        this.f9485o0.q1();
        if (this.A1) {
            x8.f.e(this.f9489q0);
        }
        this.f9491r0.g();
        c8.d0 d0Var = this.f9497u0;
        if (d0Var == null || !d0Var.L()) {
            this.M0.f();
        }
        super.M1();
    }

    public final boolean M6() {
        r4.a aVarD = this.M0.d();
        if (aVarD != null) {
            return aVarD.i() || !s9.d.n(G(), aVarD.getUrl());
        }
        return false;
    }

    public final void M7() {
        int i10;
        int iL0 = this.f9487p0.l0();
        if (iL0 == 2) {
            i10 = 10;
        } else if (iL0 != 3) {
            i10 = iL0 != 4 ? 2 : 0;
        } else {
            i10 = 1;
        }
        x8.j3.i(G(), i10);
        this.P0.P();
        boolean zG = this.f9487p0.G();
        this.f9471a1 = zG;
        this.f9507z0.t((zG && C7()) ? false : true, false);
        this.f9506y1 = this.f9487p0.x2();
        da();
        q9(this.f9487p0.z0(), this.f9487p0.v().t());
        this.Y0 = this.f9487p0.s2() == 2;
        this.f9489q0.n(x8.h3.f14580a && !x8.l.d());
        this.f9489q0.m(!x8.l.d() && this.V0 && B7());
        ba();
        this.f9473c1.setColor(Color.argb((!this.f9487p0.e() || this.V0) ? 0 : this.f9487p0.o2(), 0, 0, 0));
        int i11 = com.tuyafeng.support.utils.x.C(this.f9487p0.f0()) ? 128 : 64;
        if (!this.f9487p0.e()) {
            i11 = 0;
        }
        this.f9489q0.setWindowFilterColor(Color.argb(Math.max(i11, (int) ((this.f9487p0.Q2().b() / 100.0f) * 255.0f)), 0, 0, 0));
        this.f9485o0.Z0();
        x9(this.f9487p0.v().r());
        v8.g.f(this.f9507z0);
        this.f9485o0.h2();
        PassController passController = this.E0;
        ViewGroup viewGroup = this.B0;
        View view = this.D0;
        if (view == null) {
            view = this.f9489q0;
        }
        passController.F(viewGroup, view);
    }

    public final void M8(String str) {
        if (W7()) {
            L0().z1("input", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.n2
                @Override // androidx.fragment.app.i0
                public final void a(String str2, Bundle bundle) {
                    q4.P3(this.f9364a, str2, bundle);
                }
            });
            int i10 = this.W0;
            boolean z10 = (i10 == 2 || i10 == 3) ? false : true;
            boolean z11 = (this.U0 == 0 || this.f9487p0.e()) ? false : true;
            boolean z12 = z10 && !z11 && B7();
            String strU7 = u7();
            mark.via.common.widget.m mVar = this.D0;
            x.d dVarI = mVar == null ? null : mVar.i(strU7);
            String str2 = dVarI == null ? null : (String) dVarI.f14456b;
            ga.c cVar = dVarI == null ? null : (ga.c) dVarI.f14455a;
            int iD = (cVar == null || !TextUtils.isEmpty(str)) ? 0 : cVar.d();
            boolean z13 = !this.f9485o0.X1(strU7);
            androidx.fragment.app.l0 l0VarX = L0().q().x(true);
            int i11 = w7.i.f13703a;
            int i12 = w7.i.f13709g;
            l0VarX.v(i11, i12, i12, w7.i.f13704b).c(FragmentUtils.f3568a, tb.k0.class, tb.k0.B3(str, strU7, str2, iD, z10, z11, this.U0, z12, z13), "UrlInputFragment").g(null).i();
        }
    }

    public final void M9(String str) {
        if (FragmentUtils.e(this)) {
            return;
        }
        if (s9.d.l(G(), str)) {
            str = null;
        }
        ta.y.n3(str).g3(x0(), ta.y.class.getSimpleName());
    }

    @Override // c8.g1.a
    public void N(int i10) {
        int iE = this.M0.e(i10);
        if (iE < 0) {
            return;
        }
        f(this.M0.k(iE), iE);
    }

    @Override // androidx.fragment.app.Fragment
    public void N1(boolean z10) {
        super.N1(z10);
        c8.d0 d0Var = this.f9497u0;
        if (d0Var != null) {
            d0Var.N(z10);
        }
        if (z10) {
            this.A0.setVisibility(8);
            this.f9505y0.setVisibility(8);
            return;
        }
        this.A0.setVisibility(0);
        this.f9505y0.setVisibility(0);
        t4.b bVarH = H();
        if (bVarH != null) {
            bVarH.onPause();
        }
    }

    public final boolean N6() {
        r4.a aVarD = this.M0.d();
        return (aVarD != null && aVarD.m()) || this.f9485o0.X0();
    }

    public final void N7() {
        if (this.D0 != null) {
            return;
        }
        mark.via.common.widget.m mVar = (mark.via.common.widget.m) new b6.a(new mark.via.common.widget.m(G()), new RelativeLayout.LayoutParams(-1, com.tuyafeng.support.utils.x.h(G(), 40.0f))).g(64, w7.p.U0).c(true).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.q3
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                q4.O3(this.f9470a, (mark.via.common.widget.m) obj);
            }
        }).l();
        this.D0 = mVar;
        mVar.m(Collections.EMPTY_LIST, null);
        this.D0.setCallback(new a());
    }

    public final void N8(String str) {
        Intent intentF = x8.e1.f(G(), str);
        if (intentF == null) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.A9);
            return;
        }
        try {
            N2(intentF);
        } catch (ActivityNotFoundException unused) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.A9);
        }
    }

    public final void N9() {
        if (this.f9489q0.l()) {
            this.f9493s0.setImportantForAccessibility(4);
            x8.l.c(this.D0);
        }
    }

    @Override // c8.i.a
    public pa.a O(WebView webView) {
        return new pa.a(webView, this.R0, this.f9484n1);
    }

    public final void O6() {
        ValueAnimator valueAnimator = this.f9494s1;
        if (valueAnimator != null) {
            this.f9494s1 = null;
            valueAnimator.cancel();
        }
    }

    public final void O7() {
        this.f9476f1 = UUID.randomUUID().toString();
        this.R0 = kd.c();
        x8.h.b(new Runnable() { // from class: mark.via.browser.e4
            @Override // java.lang.Runnable
            public final void run() {
                q4.D3(this.f9103c);
            }
        });
    }

    public final void O8(final Message message) {
        final t4.b bVarO;
        if (message == null) {
            return;
        }
        final WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        if (webViewTransport == null) {
            message.sendToTarget();
            return;
        }
        final String strU7 = u7();
        this.f9485o0.j1("", true);
        r4.a aVarL0 = this.f9485o0.L0();
        if (aVarL0 == null || (bVarO = aVarL0.o()) == null) {
            message.sendToTarget();
        } else {
            bVarO.post(new Runnable() { // from class: mark.via.browser.s0
                @Override // java.lang.Runnable
                public final void run() {
                    q4.W2(bVarO, strU7, webViewTransport, message);
                }
            });
        }
    }

    public final void O9() {
        q5.k.l(G()).f0(w7.u.f14081i2).K(x8.z.s(G(), n7())).X(R.string.ok, null).h0();
    }

    @Override // c8.i.a
    public boolean P() {
        return !this.f9477g1.v() && this.f9483m1;
    }

    public final void P6() {
        y.r.c(this.f9493s0).b();
        y.r.c(this.A0).b();
        y.r.c(this.f9505y0).b();
        y.r.c(this.f9495t0).b();
        y.r.c(this.f9489q0.f9815o).b();
        mark.via.common.widget.m mVar = this.D0;
        if (mVar != null) {
            y.r.c(mVar).b();
        }
    }

    public final void P7() {
        if (this.f9501w0 == null) {
            this.f9501w0 = (nd) new b6.a(new nd(this, this.f9487p0, new x.a() { // from class: mark.via.browser.f0
                @Override // x.a
                public final void accept(Object obj) {
                    this.f9125a.P8(((Integer) obj).intValue());
                }
            }), new FrameLayout.LayoutParams(-1, -2)).l();
            mark.via.common.widget.g0 g0Var = (mark.via.common.widget.g0) new b6.a(new mark.via.common.widget.g0(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(G(), w7.n.f13749b))).l();
            this.f9503x0 = g0Var;
            this.f9501w0.addView(g0Var);
            this.f9503x0.setOnItemClickListener(this.D1);
            this.f9503x0.setOnItemLongClickListener(this.F1);
        }
    }

    public final void P8(int i10) {
        switch (i10) {
            case 1:
                U8();
                break;
            case 2:
            case 3:
                x8.z.U(H(), i10 != 2 ? 1 : 0);
                break;
            case 4:
                K9();
                L8();
                break;
            case 5:
                this.f9485o0.k1(null, true);
                break;
            case 6:
                I6();
                break;
            case 7:
            case 8:
                G8(i10 == 7);
                break;
            case 9:
                this.f9485o0.C0();
                break;
            case 10:
            case 11:
                int iM0 = this.f9485o0.M0() + (i10 == 10 ? -1 : 1);
                int i11 = this.M0.i();
                if (i11 > 1) {
                    this.f9485o0.Y1((iM0 + i11) % i11);
                }
                D7();
                break;
            case 12:
            case 13:
                if (i10 != 12) {
                    x7();
                } else {
                    w7();
                }
                break;
            case 14:
                if (!D7()) {
                    E9();
                }
                break;
            case 15:
                W9();
                break;
            case 16:
                a9();
                break;
            case 17:
            case 18:
                x8.z.U(H(), i10 != 17 ? 3 : 2);
                break;
            case 19:
                this.f9485o0.Q1();
                break;
            case 20:
                this.f9485o0.j2();
                break;
            case 21:
            case 22:
                i7(i10 == 21);
                break;
            case 23:
                if (!D7()) {
                    Q9();
                }
                break;
            case 24:
                T8();
                break;
            case 25:
                this.f9481k1.x();
                break;
            case 26:
                FragmentUtils.i(this, hb.o6.class);
                break;
            case 27:
                a7(d());
                break;
            case 28:
                A8();
                break;
            case 29:
                z8();
                break;
            case 30:
                u8();
                break;
        }
    }

    public final void P9() {
        String strU7 = u7();
        String strT7 = t7(strU7);
        c6.a2 a2Var = c6.a2.f1958a;
        boolean zT = a2Var.t(strU7);
        if (!zT && strU7 != null && strU7.length() > 0) {
            int length = strU7.length();
            strU7 = x8.r2.f(strU7);
            if (length != strU7.length()) {
                strT7 = a2Var.g(strU7);
            }
        }
        int i10 = ((!zT || n7() == null) ? 0 : 1) | (zT && this.f9485o0.Y0(strU7) ? 2 : 0);
        int i11 = this.W0;
        x0().q().c(w7.p.B, d8.w.class, d8.d.f().g(((i11 == 2 || i11 == 3) ? 80 : 48) | 8388611).j(p7()).i(this.V0 && B7()).e("title", strT7).e("url", strU7).d("flag", i10).a(), null).g(null).i();
        N9();
        E7();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    /* JADX WARN: Code duplicated, block: B:34:0x0078  */
    public final void Q6(int i10, boolean z10, boolean z11) {
        boolean z12;
        int i11;
        Window window;
        tc.a.a("change color: %s, %s", Integer.toHexString(i10), String.valueOf(z10));
        WeakReference weakReference = this.f9475e1;
        if (weakReference != null) {
            Animator animator = (Animator) weakReference.get();
            if (animator != null && animator.isRunning()) {
                animator.cancel();
            }
            this.f9475e1 = null;
        }
        boolean zB7 = B7();
        boolean z13 = i10 == 0;
        this.f9489q0.m(!x8.l.d() && z13 && zB7);
        boolean zE = this.f9487p0.e();
        g9.a aVarQ2 = this.f9487p0.Q2();
        if (zE) {
            z12 = false;
        } else if (!z13 || !aVarQ2.c()) {
            if (com.tuyafeng.support.utils.x.C(z13 ? this.f9487p0.f0() : i10)) {
                z12 = true;
            } else {
                z12 = false;
            }
        } else if (aVarQ2.d()) {
            z12 = true;
        } else {
            z12 = false;
        }
        Context contextG = G();
        int i12 = R.color.white;
        if (zE) {
            i11 = w7.m.f13744h;
        } else {
            i11 = z12 ? w7.m.f13743g : R.color.white;
        }
        int iB = com.tuyafeng.support.utils.f.b(contextG, i11);
        Context contextG2 = G();
        if (zE) {
            i12 = w7.m.f13741e;
        } else if (z12) {
            i12 = w7.m.f13740d;
        }
        int iB2 = com.tuyafeng.support.utils.f.b(contextG2, i12);
        this.f9503x0.setAccentColor(iB2);
        this.f9507z0.r(iB2, iB);
        mark.via.common.widget.t tVar = this.C0;
        if (tVar != null) {
            tVar.y(iB2, iB);
        }
        mark.via.common.widget.m mVar = this.D0;
        if (mVar != null) {
            mVar.l(iB2, iB);
        }
        com.tuyafeng.support.widget.e0 e0Var = this.K1;
        if (e0Var != null) {
            e0Var.setContentColor(iB);
        }
        this.f9473c1.setColor(Color.argb((!zE || z11) ? 0 : this.f9487p0.o2(), 0, 0, 0));
        boolean zS = x8.h3.s(i0(), z12);
        boolean zR = x8.h3.r(i0(), z12);
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 21 && (window = i0().getWindow()) != null) {
            window.setStatusBarColor((!z12 || zS) ? 0 : Color.argb(51, 0, 0, 0));
            int iArgb = (!z12 || zR) ? 0 : Color.argb(51, 0, 0, 0);
            if (i13 < 29 && !z13) {
                iArgb = (!z12 || zR) ? i10 : com.tuyafeng.support.utils.x.G(i10, -16777216, 0.2f);
            }
            window.setNavigationBarColor(iArgb);
            if (i13 >= 28) {
                window.setNavigationBarDividerColor(iArgb);
            }
        }
        int i14 = this.U0;
        this.U0 = i10;
        this.V0 = z11;
        if (i14 == i10) {
            z10 = false;
        }
        if (z10) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i14), Integer.valueOf(i10));
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mark.via.browser.f2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    q4.c3(this.f9127a, valueAnimator);
                }
            });
            valueAnimatorOfObject.setDuration(R0().getInteger(w7.q.f13930a));
            valueAnimatorOfObject.start();
            this.f9475e1 = new WeakReference(valueAnimatorOfObject);
            return;
        }
        if (z13 && zB7) {
            this.f9505y0.setBackgroundColor(0);
            return;
        }
        this.f9489q0.k(i10, false);
        this.f9505y0.setBackgroundColor(i10);
        mark.via.common.widget.m mVar2 = this.D0;
        if (mVar2 != null) {
            mVar2.setBackgroundColor(i10);
        }
    }

    public final void Q7() {
        if (this.f9507z0 == null) {
            mark.via.common.widget.n0 n0Var = (mark.via.common.widget.n0) new b6.a(new mark.via.common.widget.n0(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(G(), w7.n.H))).l();
            this.f9507z0 = n0Var;
            n0Var.setOnItemClickListener(this.D1);
            this.f9507z0.setOnItemLongClickListener(this.F1);
            this.f9507z0.setOnDragListener(new View.OnDragListener() { // from class: mark.via.browser.t
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view, DragEvent dragEvent) {
                    return q4.f3(this.f9658a, view, dragEvent);
                }
            });
            this.U0 = -1;
        }
    }

    public final void Q8() {
        String strD = com.tuyafeng.support.utils.n.d(G());
        if (strD == null || strD.isEmpty()) {
            return;
        }
        final List listE = c6.y1.f2139a.e(strD);
        if (listE.size() > 1) {
            q5.k.l(G()).f0(w7.u.I3).K(strD).G((String[]) listE.toArray(new String[0]), new AdapterView.OnItemClickListener() { // from class: mark.via.browser.a4
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    this.f8999a.f9485o0.j1((String) listE.get(i10), true);
                }
            }).X(w7.u.f14242t9, new q5.k.m() { // from class: mark.via.browser.b4
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    q4.o3(this.f9028a, listE, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
            return;
        }
        if (!listE.isEmpty()) {
            strD = (String) listE.get(0);
        }
        k9(strD);
    }

    public final void Q9() {
        x0().q().c(w7.p.B, d8.l0.class, d8.d.f().g((this.W0 == 1 ? 48 : 80) | 8388613).j(p7()).i(this.V0 && B7()).d("max_height", this.f9489q0.f9815o.getHeight() - com.tuyafeng.support.utils.x.h(G(), 16.0f)).a(), null).g(null).i();
        N9();
        E7();
    }

    @Override // mark.via.browser.r8
    public void R(int i10, int i11, View.OnClickListener onClickListener) {
        com.tuyafeng.support.utils.n.r(G(), i10, i11, onClickListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        if (this.f9489q0.getDescendantFocusability() != 393216) {
            this.f9491r0.f();
        }
        X9();
        c8.d0 d0Var = this.f9497u0;
        if (d0Var == null || !d0Var.L()) {
            this.M0.a();
        }
        this.f9485o0.Z1();
        if (T7()) {
            return;
        }
        M7();
        if (u9.n.e().m()) {
            this.f9485o0.n1(true);
        }
        this.f9485o0.x1();
        this.f9481k1.w();
    }

    public final GestureTouchEvent.b R6() {
        return new s();
    }

    public final void R8() {
        O6();
        P6();
        this.A0.setVisibility(0);
        this.f9505y0.setVisibility(0);
        v9(this.f9492r1);
    }

    public final void R9(int i10, int i11) {
        t4.b bVarH = H();
        if (bVarH == null || bVarH.getWidth() <= 0 || bVarH.getHeight() <= 0) {
            return;
        }
        int[] iArr = new int[2];
        bVarH.getLocationOnScreen(iArr);
        s4.b.g(bVarH, u8.a(y0(), (i10 - iArr[0]) / bVarH.getWidth(), (i11 - iArr[1]) / bVarH.getHeight()));
    }

    @Override // androidx.fragment.app.Fragment
    public void S1(Bundle bundle) {
        super.S1(bundle);
        if (this.f9486o1) {
            return;
        }
        this.f9485o0.O1();
    }

    public final void S6(boolean z10) {
        mark.via.common.widget.t tVar = this.C0;
        if (z10 == (tVar != null)) {
            return;
        }
        if (z10) {
            this.C0 = (mark.via.common.widget.t) new b6.a(new mark.via.common.widget.t(G()), new FrameLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(G(), w7.n.f13772y))).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.g1
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    q4.g5(this.f9149a, (mark.via.common.widget.t) obj);
                }
            }).l();
            return;
        }
        tVar.setOnTabItemClickListener(null);
        this.C0.setOnNewTabButtonClickListener(null);
        this.C0.setOnDeleteItemClickListener(null);
        this.C0.setOnMoveTabListener(null);
        this.C0.setOnDeleteTabsListener(null);
        this.C0.setOnDuplicateTabListener(null);
        this.C0 = null;
    }

    public final void S7() {
        O7();
        this.P0.D();
        this.Z0 = com.tuyafeng.support.utils.x.E(G());
        this.f9508z1 = R0().getConfiguration().orientation;
        this.O0 = new GestureDetector(i0(), new o());
        p4.c cVar = new p4.c(G(), new t4.b.e() { // from class: mark.via.browser.r3
            @Override // t4.b.e
            public final t4.b a(Context context) {
                return new b8.h(context);
            }
        });
        this.M0 = cVar;
        cVar.n(new p());
        this.M0.n(new c8.g1(this.f9487p0, this, this.f9477g1));
        this.M0.n(new c8.x0());
        this.M0.n(new c8.j(b8.d.c(), this));
        c8.b0 b0Var = new c8.b0(G(), new q());
        this.G0 = b0Var;
        this.M0.n(b0Var);
        c8.d0 d0Var = new c8.d0(i0(), this.f9487p0, this);
        this.f9497u0 = d0Var;
        this.M0.n(d0Var);
        this.M0.n(new c8.v0(this));
        this.M0.n(new c8.i(la.s.k(), this.f9487p0, this));
        this.M0.n(new c8.a1(this.f9487p0));
        this.f9484n1 = new r();
        this.M0.n(new c8.b1(this));
        this.M0.n(new c8.u0());
        if (this.Q0 == null) {
            final PassController passController = this.E0;
            Objects.requireNonNull(passController);
            this.Q0 = new c8.f0(this, new c8.f0.a() { // from class: mark.via.browser.s3
                @Override // c8.f0.a
                public final void a(String str, String str2, String str3) {
                    passController.B(str, str2, str3);
                }
            });
        }
        this.M0.n(this.Q0);
        this.M0.n(new c8.d1(b8.g.c(), this.f9487p0, this));
        this.M0.n(new c8.v1(G(), la.s.k(), this.f9487p0, new c8.v1.b() { // from class: mark.via.browser.t3
            @Override // c8.v1.b
            public final void a(String[] strArr, c8.v1.a aVar) {
                this.f9662a.Z8(strArr, aVar);
            }
        }));
        this.M0.r(this);
    }

    public final void S8() {
        T6(H());
    }

    public final boolean S9(Intent intent) {
        try {
            N2(intent);
            return true;
        } catch (Exception unused) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.Ng);
            return false;
        }
    }

    @Override // c8.j.a
    public WebResourceResponse T(WebResourceRequest webResourceRequest, String str, String str2) {
        return this.f9485o0.F0(webResourceRequest, str, str2);
    }

    public final void T6(WebView webView) {
        if (webView == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Context contextI0 = i0();
        if (contextI0 instanceof Shell) {
            contextI0 = ((Shell) i0()).c0();
        }
        PrintManager printManager = (PrintManager) com.tuyafeng.support.utils.f.f(contextI0, PrintManager.class);
        if (printManager == null) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.Ng);
            return;
        }
        String title = webView.getTitle();
        if (title == null || title.isEmpty()) {
            title = c6.a2.f1958a.g(webView.getUrl());
        }
        if (title == null || title.isEmpty()) {
            title = String.format(Locale.getDefault(), "%s - %s", X0(w7.u.Ah), x8.s1.d());
        }
        try {
            printManager.print(title, webView.createPrintDocumentAdapter(title), new PrintAttributes.Builder().build());
        } catch (Exception unused) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.Ng);
        }
    }

    public final boolean T7() {
        c8.d0 d0Var = this.f9497u0;
        return d0Var != null && d0Var.K();
    }

    public final void T8() {
        t4.b bVarH = H();
        if (bVarH == null || !bVarH.isShown()) {
            return;
        }
        if (this.f9485o0.f1(bVarH.getUrl())) {
            this.f9480j1.r(bVarH);
        } else {
            com.tuyafeng.support.utils.n.q(G(), w7.u.f13969a2);
        }
    }

    public final void T9() {
        r4.a aVarD = this.M0.d();
        if (D7() || aVarD == null) {
            return;
        }
        if (aVarD.p()) {
            aVarD.r();
        } else {
            z(100);
        }
    }

    @Override // mark.via.browser.r8
    public void U(String str, int i10, View.OnClickListener onClickListener) {
        new a6.h.b(i0()).h(str).j(true).c(i10, onClickListener).a().s();
    }

    public final void U6(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        if (iArr.length == 1) {
            this.f9485o0.D0(iArr[0]);
            return;
        }
        tc.a.a("delete tabs: %s", Arrays.toString(iArr));
        ArrayList arrayList = new ArrayList();
        int iK = k();
        boolean z10 = false;
        for (int i10 : iArr) {
            if (i10 == iK) {
                z10 = true;
            }
            r4.a aVarK = this.M0.k(i10);
            if (aVarK != null) {
                arrayList.add(aVarK);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f9485o0.M1(arrayList);
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
                this.M0.j(i11);
            } else {
                this.f9485o0.h1("", false, i12);
                if (this.M0.j(i12)) {
                    this.f9485o0.W0();
                }
            }
        }
        for (int i15 : iArr) {
            this.M0.b(i15);
        }
    }

    public final boolean U7(String str) {
        return str == null || str.isEmpty() || !str.equals(this.f9476f1);
    }

    public final void U8() {
        r4.a aVarD = this.M0.d();
        if (D7() || aVarD == null) {
            return;
        }
        b8.g.c().e(aVarD.getUrl());
        aVarD.c();
    }

    public final void U9(boolean z10) {
        u9.n.e().n(true);
        i0().setTheme(z10 ? w7.v.f14324a : w7.v.f14325b);
        D7();
        this.U0 = com.tuyafeng.support.utils.x.H(this.U0);
        if (s9.d.l(G(), u7())) {
            Z9(0, false);
        } else {
            Z9(com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c), false);
        }
        ga(this.W0);
        int i10 = com.tuyafeng.support.utils.x.C(this.f9487p0.f0()) ? 128 : 64;
        if (!z10) {
            i10 = 0;
        }
        this.f9489q0.setWindowFilterColor(Color.argb(Math.max(i10, (int) ((this.f9487p0.Q2().b() / 100.0f) * 255.0f)), 0, 0, 0));
        this.f9485o0.x1();
        this.f9485o0.o1(false, true);
        this.f9480j1.s(true);
        PassController passController = this.E0;
        ViewGroup viewGroup = this.B0;
        View view = this.D0;
        if (view == null) {
            view = this.f9489q0;
        }
        passController.H(viewGroup, view);
        this.f9489q0.setNightModeEnabled(z10);
        if (this.f9487p0.c0()) {
            return;
        }
        FrameLayout frameLayout = this.f9493s0;
        frameLayout.dispatchConfigurationChanged(frameLayout.getResources().getConfiguration());
    }

    @Override // androidx.fragment.app.h0
    public void V(FragmentManager fragmentManager, final Fragment fragment) {
        if ((fragment instanceof tb.k0) || (fragment instanceof ma.e1)) {
            this.f9491r0.g();
            this.f9489q0.setBlurEnabled(true);
            this.f9489q0.setDescendantFocusability(393216);
            this.f9489q0.clearFocus();
            fragment.h0().a(new androidx.lifecycle.h() { // from class: mark.via.browser.o1
                @Override // androidx.lifecycle.h
                public final void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
                    q4.H4(this.f9384c, fragment, jVar, event);
                }
            });
            if (fragment instanceof tb.k0) {
                fa((tb.k0) fragment);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        tc.a.a("BrowserFragment::onViewCreated", new Object[0]);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f9487p0.d1();
        String strU1 = this.f9487p0.U1();
        if (strU1 != null && !strU1.isEmpty()) {
            lb.g.e(x8.c1.G(G(), strU1));
        }
        J7();
        L7();
        S7();
        R7();
        I7();
        final boolean z10 = bundle != null;
        this.f9489q0.post(new Runnable() { // from class: mark.via.browser.h1
            @Override // java.lang.Runnable
            public final void run() {
                q4.j4(this.f9191c, z10);
            }
        });
        this.f9491r0 = new r5(this.f9489q0, la.s.o().b(), new x.a() { // from class: mark.via.browser.i1
            @Override // x.a
            public final void accept(Object obj) {
                this.f9219a.l8(((Boolean) obj).booleanValue());
            }
        });
        l7();
        tc.a.a("BrowserFragment::onViewCreated, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    public final void V6(int i10, int i11) {
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
        U6(com.tuyafeng.support.utils.a.d(arrayList));
    }

    public final boolean V7() {
        return this.f9478h1 > 0;
    }

    public final void V8(boolean z10) {
        r4.a aVarD = this.M0.d();
        if (D7() || aVarD == null) {
            return;
        }
        String strM = c6.z.f2140a.m(aVarD.getUrl(), z10 | this.Z0);
        if (strM == null || strM.isEmpty()) {
            aVarD.c();
        } else {
            b8.g.c().e(strM);
            aVarD.u(strM);
        }
    }

    public final void V9() {
        boolean zE = this.f9487p0.e();
        tc.a.a("current night mode: %s", Boolean.valueOf(zE));
        if (!o1()) {
            U9(zE);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.B0, "alpha", 0.2f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        U9(zE);
        objectAnimatorOfFloat.start();
    }

    @Override // r4.f
    public void W(int i10, int i11) {
        this.f9477g1.q();
        nd ndVar = this.f9501w0;
        e9(ndVar != null && ndVar.i());
        if (V7()) {
            mark.via.browser.c cVar = this.f9479i1;
            if (cVar != null) {
                cVar.n();
            }
            D7();
        }
        this.E0.C();
        mark.via.common.widget.t tVar = this.C0;
        if (tVar == null) {
            return;
        }
        tVar.x(i11);
    }

    public final void W6() {
        GestureTouchEvent gestureTouchEvent = this.f9504x1;
        if (gestureTouchEvent != null) {
            gestureTouchEvent.i();
        }
        this.f9474d1 = -1L;
        if (T7() || !g1() || n1()) {
            return;
        }
        q9(this.f9487p0.z0(), this.f9487p0.v().t());
    }

    public final boolean W7() {
        return L0().u0() == 0;
    }

    public final void W8(WebView webView, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            q9.b bVar = (q9.b) it.next();
            this.f9477g1.B(bVar);
            rd.q(webView).y(bVar);
            mark.via.browser.c.f(webView).i(bVar);
            if (webView == H()) {
                this.E0.I(bVar);
            }
        }
    }

    public final void W9() {
        final t4.b bVarH = H();
        if (bVarH == null) {
            this.f9485o0.a2();
            return;
        }
        if (!URLUtil.isNetworkUrl(bVarH.getUrl())) {
            this.f9485o0.a2();
        } else if (!bVarH.getSettings().getJavaScriptEnabled()) {
            D9();
        } else {
            final String url = bVarH.getUrl();
            bVarH.evaluateJavascript(c6.x1.f2137a.d(this.R0.d()), new ValueCallback() { // from class: mark.via.browser.r1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    q4.g4(this.f9588a, bVarH, url, (String) obj);
                }
            });
        }
    }

    @Override // c8.i.a
    public void X(t4.b bVar, String str, String str2, String str3, String str4, long j10) {
        if (T7() || !o1()) {
            return;
        }
        this.P0.G(bVar, str, str2, str3, str4, j10);
    }

    public final void X6(boolean z10) {
        if (!z10) {
            int i10 = i();
            this.f9485o0.h1(null, true, i10);
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                this.f9485o0.D0(i11);
            }
            x8.h.b(new Runnable() { // from class: mark.via.browser.n0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9361c.f9485o0.i2();
                }
            });
        }
        u9.p pVarN2 = this.f9487p0.n2();
        pVarN2.U(false);
        this.f9487p0.F1(pVarN2);
        u9.n.e().s(true);
        com.tuyafeng.support.utils.n.q(G(), w7.u.f14002c7);
        this.f9485o0.m1();
        this.f9507z0.setIncognitoModeEnabled(true ^ this.f9485o0.X1(u7()));
    }

    public final void X7() {
        L0().z1("result", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.m2
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                q4.l3(this.f9336a, str, bundle);
            }
        });
    }

    public final void X8() {
        final String strU7 = u7();
        if (c6.a2.f1958a.t(strU7)) {
            q5.k.l(G()).f0(w7.u.f14076hb).c0(new String[]{X0(w7.u.f14006cb), X0(w7.u.f13978ab), X0(w7.u.f13992bb)}, -1).i("", X0(w7.u.f14034eb), 1).X(R.string.ok, new q5.k.m() { // from class: mark.via.browser.z3
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    q4.g3(this.f9805a, strU7, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        }
    }

    public final void X9() {
        Y9(u7());
    }

    @Override // r4.f
    public void Y(r4.a aVar, int i10) {
        D7();
        if (this.M0.i() > 1) {
            this.f9503x0.j();
        }
        b8();
        mark.via.common.widget.t tVar = this.C0;
        if (tVar == null) {
            return;
        }
        tVar.u(i10);
    }

    public boolean Y6(KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        boolean zW7 = W7();
        int keyCode = keyEvent.getKeyCode();
        int action = keyEvent.getAction();
        if (zW7) {
            if (action == 0) {
                return j8(keyCode, keyEvent);
            }
            if (action == 1) {
                return k8(keyCode, keyEvent);
            }
            return false;
        }
        if (action != 0 || keyCode != 111) {
            return false;
        }
        L0().e1();
        return true;
    }

    public final void Y7(String str) {
        r4.a aVarD = this.M0.d();
        if (D7() || aVarD == null || str == null || str.isEmpty()) {
            return;
        }
        aVarD.u(str);
    }

    public final void Y8() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        y.r.V(this.B0);
    }

    public final void Y9(String str) {
        this.f9488p1.j(!(x8.j3.g(G()) && y9(str)));
    }

    @Override // m8.d
    public boolean Z(Intent intent) {
        if (intent == null) {
            return false;
        }
        boolean zG = x8.z.G(intent);
        if (zG) {
            L0().g1(null, 1);
        }
        this.f9485o0.r1(intent);
        return zG;
    }

    public final void Z6(String str) {
        if (com.tuyafeng.support.utils.p.f(str)) {
            return;
        }
        this.P0.K(new mark.via.download.o.b().j(str).k(this.f9487p0.L1()).c("attachment").g(URLUtil.isNetworkUrl(str) ? "image/*" : null).i(u7()).d(-1L).b());
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0246  */
    /* JADX WARN: Code duplicated, block: B:156:0x0397  */
    /* JADX WARN: Code duplicated, block: B:158:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:160:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:164:0x03c5 A[LOOP:0: B:157:0x03a2->B:164:0x03c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:166:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:168:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:170:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:172:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:173:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:175:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:177:0x040d  */
    /* JADX WARN: Code duplicated, block: B:179:0x0413  */
    /* JADX WARN: Code duplicated, block: B:183:0x0429  */
    /* JADX WARN: Code duplicated, block: B:185:0x03c8 A[EDGE_INSN: B:185:0x03c8->B:165:0x03c8 BREAK  A[LOOP:0: B:157:0x03a2->B:164:0x03c5], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:78:0x0132  */
    public final void Z7(final int i10, final int i11, String str, final String str2, final String str3, boolean z10) {
        final String str4;
        boolean z11;
        int[] iArrE1;
        ArrayList arrayList;
        ArrayList arrayList2;
        int size;
        final t4.b bVarH = H();
        final String strU7 = u7();
        final int iC = s9.d.c(G(), strU7);
        final String strF = x8.r2.f(str);
        this.f9483m1 = !TextUtils.isEmpty(strF);
        if (iC == 0 && str2 != null) {
            Z6(str2);
            return;
        }
        if (bVarH != null) {
            if (TextUtils.isEmpty(strF) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (iC == 1) {
                str4 = str;
                if ("via://bookmarks".equals(str4) || strU7.equals(strF)) {
                    return;
                }
            } else {
                str4 = str;
            }
            if (str2 != null && !str2.isEmpty() && iC == 13) {
                Z6(str2);
                return;
            }
            if (iC == -1 && !T7()) {
                R9(i10, i11);
            }
            ArrayList arrayList3 = new ArrayList();
            if (!this.f9486o1 && URLUtil.isNetworkUrl(strF)) {
                arrayList3.add(new q5.k.l(0, X0(w7.u.R)));
                arrayList3.add(new q5.k.l(1, X0(w7.u.S)));
            }
            int size2 = 2;
            if (iC != -1) {
                if (iC != 1) {
                    if (iC == 2) {
                        if (strF == null && !strF.isEmpty()) {
                            int size3 = arrayList3.size();
                            boolean zN = x8.r2.n(strF);
                            if (strF.charAt(strF.length() - 1) != '=') {
                                arrayList3.add(new q5.k.l(zN ? 12 : 9, X0(w7.u.E)));
                                if (!zN) {
                                    arrayList3.add(new q5.k.l(10, X0(w7.u.f14022e)));
                                }
                                arrayList3.add(new q5.k.l(zN ? 13 : 11, X0(w7.u.f14298y)));
                            }
                            size2 = arrayList3.size() - size3;
                        }
                    } else if (iC == 3) {
                        arrayList3.add(new q5.k.l(16, X0(w7.u.f14298y)));
                        arrayList3.add(new q5.k.l(17, X0(w7.u.f14311z)));
                    } else if (iC == 6) {
                        int size4 = arrayList3.size();
                        if (iC != 6 && this.f9485o0.c1(strF)) {
                            boolean zW0 = this.f9485o0.w0(strF);
                            boolean zX0 = this.f9485o0.x0(strF);
                            if (zW0 || zX0 || this.f9485o0.U1(strF)) {
                                arrayList3.add(new q5.k.l(zW0 ? 25 : 24, X0(zW0 ? w7.u.f14093j0 : w7.u.f14064h)));
                                arrayList3.add(new q5.k.l(zX0 ? 27 : 26, X0(zX0 ? w7.u.f14107k0 : w7.u.f14078i)));
                            }
                        }
                        if (iC == 10) {
                            arrayList3.add(new q5.k.l(19, X0(w7.u.W)));
                        }
                        arrayList3.add(new q5.k.l(20, X0(w7.u.B)));
                        arrayList3.add(new q5.k.l(21, X0(w7.u.f14311z)));
                        size2 = arrayList3.size() - size4;
                    } else if (iC == 7) {
                        arrayList3.add(new q5.k.l(18, X0(w7.u.f14298y)));
                        size2 = 1;
                    } else if (iC == 10) {
                        int size5 = arrayList3.size();
                        if (iC != 6) {
                        }
                        if (iC == 10) {
                            arrayList3.add(new q5.k.l(19, X0(w7.u.W)));
                        }
                        arrayList3.add(new q5.k.l(20, X0(w7.u.B)));
                        arrayList3.add(new q5.k.l(21, X0(w7.u.f14311z)));
                        size2 = arrayList3.size() - size5;
                    } else if (iC == 11) {
                        if (strF == null) {
                        }
                    }
                } else if (str2 == null) {
                    arrayList3.add(new q5.k.l(32, X0(w7.u.kd)));
                    arrayList3.add(new q5.k.l(14, X0(w7.u.E)));
                    arrayList3.add(new q5.k.l(15, X0(w7.u.f14298y)));
                    size2 = 3;
                }
                if (!TextUtils.isEmpty(strF) && !x8.r2.r(strF) && !x8.r2.x(strF) && !c6.a2.f1958a.m(strF)) {
                    arrayList3.add(new q5.k.l(3, X0(w7.u.f14218s)));
                    arrayList3.add(new q5.k.l(31, X0(w7.u.f14037f0)));
                }
                iArrE1 = this.f9487p0.E1();
                if (iArrE1.length > 0) {
                    arrayList2 = new ArrayList();
                    for (size = arrayList3.size() - 1; size >= 0; size--) {
                        if (com.tuyafeng.support.utils.a.b(iArrE1, ((q5.k.l) arrayList3.get(size)).a())) {
                            arrayList2.add(0, (q5.k.l) arrayList3.remove(size));
                        }
                        if (arrayList2.size() == iArrE1.length) {
                            break;
                        }
                    }
                    if (z10) {
                        if (!arrayList2.isEmpty()) {
                            arrayList2.add(new q5.k.l(37, X0(w7.u.f14012d3)));
                        }
                        arrayList3 = arrayList2;
                    } else if (!arrayList2.isEmpty()) {
                        arrayList3.add(new q5.k.l(36, X0(w7.u.I8)));
                    } else if (arrayList3.size() > size2) {
                        arrayList3.add(new q5.k.l(37, X0(w7.u.f14012d3)));
                    }
                } else if (arrayList3.size() > size2) {
                    arrayList3.add(new q5.k.l(37, X0(w7.u.f14012d3)));
                }
                arrayList = arrayList3;
                if (arrayList.isEmpty()) {
                    return;
                }
                q5.k.l(G()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.h0
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                        q4.p4(this.f9181a, strF, str2, iC, i10, i11, strU7, str3, bVarH, str4, adapterView, view, i12, j10);
                    }
                }).W(new DialogInterface.OnDismissListener() { // from class: mark.via.browser.i0
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        q4.b4(this.f9218c, dialogInterface);
                    }
                }).i0(i10, i11);
            }
            if (TextUtils.isEmpty(str2)) {
                z11 = false;
            } else {
                c6.a2 a2Var = c6.a2.f1958a;
                if (a2Var.t(str2) || a2Var.l(str2) || a2Var.m(str2)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                arrayList3.add(new q5.k.l(2, X0(w7.u.f14135m0)));
                arrayList3.add(new q5.k.l(38, X0(w7.u.C)));
                arrayList3.add(new q5.k.l(6, X0(w7.u.f13981b0)));
                if (z11) {
                    arrayList3.add(new q5.k.l(39, X0(w7.u.f14246u)));
                    arrayList3.add(new q5.k.l(33, X0(w7.u.Lc)));
                }
                if (URLUtil.isNetworkUrl(str2)) {
                    arrayList3.add(new q5.k.l(7, X0(w7.u.f14035ec)));
                }
                if (c6.a2.f1958a.t(strU7) && this.f9485o0.f1(strU7)) {
                    arrayList3.add(new q5.k.l(8, X0(w7.u.V)));
                }
            }
            arrayList3.add(new q5.k.l(22, X0(w7.u.T)));
            if (c6.a2.f1958a.t(strU7) && this.f9485o0.c1(strU7) && this.f9485o0.f1(strU7)) {
                arrayList3.add(new q5.k.l(23, X0(w7.u.M)));
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList3.add(new q5.k.l(29, X0(w7.u.f14259v)));
            }
            if (!TextUtils.isEmpty(strF) && H().getSettings().getJavaScriptEnabled()) {
                arrayList3.add(new q5.k.l(35, X0(w7.u.f14023e0)));
            }
            if (z11) {
                arrayList3.add(new q5.k.l(34, X0(w7.u.Qb)));
            }
            size2 = 0;
            if (!TextUtils.isEmpty(strF)) {
                arrayList3.add(new q5.k.l(3, X0(w7.u.f14218s)));
                arrayList3.add(new q5.k.l(31, X0(w7.u.f14037f0)));
            }
            iArrE1 = this.f9487p0.E1();
            if (iArrE1.length > 0) {
                arrayList2 = new ArrayList();
                while (size >= 0) {
                    if (com.tuyafeng.support.utils.a.b(iArrE1, ((q5.k.l) arrayList3.get(size)).a())) {
                        arrayList2.add(0, (q5.k.l) arrayList3.remove(size));
                    }
                    if (arrayList2.size() == iArrE1.length) {
                        break;
                        break;
                    }
                }
                if (z10) {
                    if (!arrayList2.isEmpty()) {
                        arrayList2.add(new q5.k.l(37, X0(w7.u.f14012d3)));
                    }
                    arrayList3 = arrayList2;
                } else if (!arrayList2.isEmpty()) {
                    arrayList3.add(new q5.k.l(36, X0(w7.u.I8)));
                } else if (arrayList3.size() > size2) {
                    arrayList3.add(new q5.k.l(37, X0(w7.u.f14012d3)));
                }
            } else if (arrayList3.size() > size2) {
                arrayList3.add(new q5.k.l(37, X0(w7.u.f14012d3)));
            }
            arrayList = arrayList3;
            if (arrayList.isEmpty()) {
                return;
            }
            q5.k.l(G()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.h0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                    q4.p4(this.f9181a, strF, str2, iC, i10, i11, strU7, str3, bVarH, str4, adapterView, view, i12, j10);
                }
            }).W(new DialogInterface.OnDismissListener() { // from class: mark.via.browser.i0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    q4.b4(this.f9218c, dialogInterface);
                }
            }).i0(i10, i11);
        }
    }

    public final void Z8(String[] strArr, c8.v1.a aVar) {
        if (strArr == null || strArr.length == 0) {
            aVar.a(new String[0], false);
            return;
        }
        String[] strArr2 = new String[strArr.length];
        int i10 = 0;
        for (String str : strArr) {
            if (!com.tuyafeng.support.utils.f.g(G(), str)) {
                strArr2[i10] = str;
                i10++;
            }
        }
        String[] strArr3 = (String[]) Arrays.copyOf(strArr2, i10);
        if (strArr3.length == 0) {
            aVar.a(strArr, false);
            return;
        }
        this.G1 = aVar;
        this.H1 = strArr;
        try {
            this.I1.a(strArr3);
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    public final void Z9(int i10, boolean z10) {
        if (this.U0 == 0) {
            z10 = false;
        }
        if (i10 != 0) {
            if (!this.f9487p0.B2() || this.f9487p0.e()) {
                i10 = com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c);
            }
            if (i10 != this.U0 || this.V0) {
                Q6(i10, z10, false);
                return;
            }
            return;
        }
        if (!B7()) {
            i10 = this.f9487p0.f0();
            if (i10 == -1) {
                i10 = com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c);
            } else if (this.f9487p0.e()) {
                i10 = com.tuyafeng.support.utils.x.G(-16777216, i10, 0.5f);
            }
        }
        if (i10 == this.U0 && this.V0) {
            return;
        }
        Q6(i10, z10, true);
    }

    @Override // c8.d0.a
    public boolean a() {
        return this.f9482l1;
    }

    @Override // mark.via.browser.r8
    public String a0() {
        return this.f9476f1;
    }

    public final void a7(r4.a aVar) {
        int iE;
        if (aVar != null && (iE = e(aVar.getId())) >= 0) {
            this.f9485o0.i1(new r4.b(aVar.b()), true, iE + 1);
        }
    }

    public final void a8() {
        if (SystemClock.elapsedRealtime() - this.J1 < 300) {
            return;
        }
        this.J1 = SystemClock.elapsedRealtime();
        if (!g1() || D7()) {
            return;
        }
        r4.a aVarD = d();
        if (aVarD != null) {
            c6.a2 a2Var = c6.a2.f1958a;
            String url = aVarD.getUrl();
            if (a2Var.t(url)) {
                if (!this.f9485o0.f1(url)) {
                    com.tuyafeng.support.utils.n.q(G(), w7.u.f13969a2);
                    return;
                }
                if (p9.a.a().p(url)) {
                    com.tuyafeng.support.utils.n.q(G(), w7.u.f13983b2);
                    return;
                }
                this.f9478h1 = aVarD.getId();
                I9();
                if (!q9.s()) {
                    c6.b.f1959a.j(v7(), this.f9476f1);
                    return;
                }
                mark.via.browser.c cVarF = mark.via.browser.c.f(aVarD.o());
                this.f9479i1 = cVarF;
                cVarF.m(new j());
                return;
            }
        }
        com.tuyafeng.support.utils.n.q(G(), w7.u.Z1);
    }

    public final void a9() {
        q5.k.l(G()).f0(w7.u.fg).J(w7.u.f14045f8).X(w7.u.f14120l, new q5.k.m() { // from class: mark.via.browser.h2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                q4.w3(this.f9193a, view, pVar);
            }
        }).P(w7.u.K, null).h0();
    }

    public final void aa() {
        if (s9.d.l(G(), u7())) {
            tc.a.a("is in home page, change color for homepage", new Object[0]);
            this.U0 = com.tuyafeng.support.utils.x.H(this.U0);
            f0(0);
        }
    }

    @Override // mark.via.browser.r8
    public void b(int i10) {
        this.f9485o0.L1(this.M0.k(i10));
        this.M0.b(i10);
    }

    @Override // m8.b
    public void b0(boolean z10) {
        V9();
    }

    public final void b7(String str) {
        c7(str, "");
    }

    public final void b8() {
        X9();
        int i10 = this.M0.i();
        if (i10 == 0) {
            return;
        }
        this.f9503x0.setTabSize(i10);
    }

    public final void b9() {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT < 30 || this.X0 != 1 || this.f9496t1 || (viewGroup = this.B0) == null) {
            return;
        }
        this.f9496t1 = true;
        viewGroup.postOnAnimation(new Runnable() { // from class: mark.via.browser.k1
            @Override // java.lang.Runnable
            public final void run() {
                q4.a4(this.f9273c);
            }
        });
    }

    public final void ba() {
        if (i1()) {
            return;
        }
        final String strD = this.f9487p0.d();
        File file = (strD == null || strD.isEmpty()) ? null : new File(strD);
        if (file == null || !file.exists()) {
            tc.a.a("no background image, use default color", new Object[0]);
            if (B7()) {
                this.f9489q0.k(com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c), false);
                this.f9489q0.setWindowBackgroundImage(null);
                aa();
                return;
            }
            return;
        }
        final String strB = h9.a.b(G());
        File file2 = new File(strB);
        final boolean zExists = file2.exists();
        long jLastModified = file2.lastModified() + ((long) this.f9487p0.Q2().a());
        final int iS = com.tuyafeng.support.utils.x.s(G());
        final int iQ = com.tuyafeng.support.utils.x.q(G());
        if (zExists && jLastModified == this.f9474d1) {
            tc.a.a("init home view, no changed", new Object[0]);
            return;
        }
        this.f9474d1 = jLastModified;
        ((autodispose2.m) r6.f.h(new Callable() { // from class: mark.via.browser.l1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q4.n4(this.f9291c, zExists, strB, strD, iS, iQ);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.browser.m1
            @Override // u6.f
            public final void accept(Object obj) {
                q4.z4(this.f9335c, (mark.via.common.widget.o0) obj);
            }
        }, new w7.a0());
        if (zExists) {
            return;
        }
        x8.h.b(new Runnable() { // from class: mark.via.browser.n1
            @Override // java.lang.Runnable
            public final void run() {
                h9.a.c(this.f9362c.G(), strD);
            }
        });
    }

    @Override // mark.via.browser.r8
    public List c() {
        return this.M0.c();
    }

    @Override // c8.v0.a
    public void c0(t4.b bVar) {
        p4.a aVar;
        if (bVar == null || (aVar = this.M0) == null) {
            return;
        }
        int i10 = aVar.i();
        for (int i11 = 0; i11 < i10; i11++) {
            r4.a aVarK = this.M0.k(i11);
            if (aVarK != null && aVarK.o() == bVar) {
                this.f9485o0.D0(i11);
                return;
            }
        }
    }

    public final void c7(final String str, final String str2) {
        if (str == null || s9.d.l(G(), str)) {
            z9(a8.n.q3("https://", ""));
            return;
        }
        if (str2 == null) {
            str2 = X0(w7.u.Ah);
        }
        ((autodispose2.m) r6.f.h(new Callable() { // from class: mark.via.browser.j2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q4.S4(str, str2);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.browser.k2
            @Override // u6.f
            public final void accept(Object obj) {
                q4.R4(this.f9274c, (m9.b) obj);
            }
        }, new w7.a0());
    }

    public final void c8(g8.k kVar) {
        final WeakReference weakReference = new WeakReference(kVar);
        ReadModeController readModeController = this.f9481k1;
        if (readModeController != null) {
            readModeController.o(new i8.o() { // from class: mark.via.browser.b3
                @Override // i8.o
                public final void a(Object obj) {
                    q4.T3(weakReference, (Integer) obj);
                }
            });
        }
    }

    public final void c9() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(R0().getDimensionPixelSize(w7.n.f13755h), R0().getDimensionPixelSize(w7.n.f13755h));
        int dimensionPixelSize = R0().getDimensionPixelSize(w7.n.f13754g);
        int iT = this.f9487p0.T();
        if ((iT & 3) != 3) {
            if ((iT & 5) == 5) {
                layoutParams.addRule(11, -1);
            } else {
                layoutParams.addRule(14, -1);
            }
            layoutParams.addRule(12, -1);
            layoutParams.topMargin = dimensionPixelSize;
            layoutParams.bottomMargin = dimensionPixelSize;
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize;
            this.f9499v0.setLayoutParams(layoutParams);
        }
        layoutParams.addRule(9, -1);
        if ((iT & 80) == 80) {
            layoutParams.addRule(12, -1);
        } else {
            layoutParams.addRule(15, -1);
        }
        layoutParams.topMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        this.f9499v0.setLayoutParams(layoutParams);
    }

    public final void ca(String str) {
        mark.via.common.widget.m mVar = this.D0;
        if (mVar == null) {
            return;
        }
        boolean z10 = !this.f9482l1 && mVar.n(str);
        if (z10 == (this.D0.getParent() != null)) {
            return;
        }
        if (z10) {
            int i10 = this.D0.getLayoutParams().height;
            this.B0.addView(this.D0, Math.max(this.B0.indexOfChild(this.f9489q0), 0) + 1);
            this.f9493s0.setPadding(0, 0, 0, i10);
        } else {
            this.f9493s0.setPadding(0, 0, 0, 0);
            ViewParent parent = this.D0.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.D0);
            }
        }
    }

    @Override // mark.via.browser.r8
    public r4.a d() {
        p4.a aVar = this.M0;
        if (aVar == null) {
            return null;
        }
        return aVar.d();
    }

    @Override // mark.via.browser.r8
    public void d0(final String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            A(false);
        } else if (strArr.length == 1) {
            L6(strArr[0], str);
        } else {
            q5.k.l(G()).g0(s7()).H(strArr, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.k3
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    q4.y3(this.f9275a, strArr, adapterView, view, i10, j10);
                }
            }, new AdapterView.OnItemLongClickListener() { // from class: mark.via.browser.l3
                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
                    return q4.f4(this.f9298a, strArr, adapterView, view, i10, j10);
                }
            }).h0();
        }
    }

    public final void d7(String str) {
        e7(str, null);
    }

    public final void d8(ActivityResult activityResult) {
        i8.o oVar = this.H0;
        this.H0 = null;
        if (oVar != null) {
            oVar.a(activityResult);
        }
    }

    public final void d9() {
        e9(false);
    }

    public final void da() {
        int i10 = (this.f9486o1 || (!this.f9482l1 && this.f9487p0.s2() <= 0)) ? 0 : 1;
        if (this.X0 == i10) {
            return;
        }
        d9();
        if (i10 != 0) {
            boolean z10 = this.f9487p0.z0() == 2;
            this.f9493s0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (this.A0.getVisibility() == 0) {
                this.f9493s0.setTranslationY(z10 ? 0.0f : this.A0.getHeight());
            }
        } else {
            k7(true);
            this.A0.setVisibility(0);
            this.f9505y0.setVisibility(0);
            this.f9493s0.setTranslationY(0.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.A0.getId());
            layoutParams.addRule(2, this.f9505y0.getId());
            this.f9493s0.setLayoutParams(layoutParams);
        }
        this.X0 = i10;
        if (i10 != 0) {
            b9();
        }
    }

    @Override // mark.via.browser.r8
    public int e(int i10) {
        return this.M0.e(i10);
    }

    @Override // c8.g1.a
    public void e0(String str, String str2) {
        if (!s9.d.j(G(), str2)) {
            this.f9485o0.t0();
        }
        if (this.f9485o0.X1(str2)) {
            r9.e.d(G(), str2, x8.z.F(str, str2));
        }
    }

    public final void e7(String str, String str2) {
        if (FragmentUtils.e(this)) {
            return;
        }
        L0().z1("fav_result", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.s
            @Override // androidx.fragment.app.i0
            public final void a(String str3, Bundle bundle) {
                q4.k4(this.f9629a, str3, bundle);
            }
        });
        ma.h0.G3(str, str2).g3(x0(), ma.h0.class.getSimpleName());
    }

    public final void e8(d8.h hVar) {
        hVar.e3(new h());
    }

    public final void e9(boolean z10) {
        nd ndVar;
        if (!z10 && (ndVar = this.f9501w0) != null) {
            ndVar.l();
        }
        GestureTouchEvent gestureTouchEvent = this.f9504x1;
        if (gestureTouchEvent != null) {
            gestureTouchEvent.i();
        }
        O6();
        P6();
        k7(this.f9490q1);
    }

    public final void ea(int i10) {
        if (i10 == 0 || i10 == 3) {
            this.f9503x0.k();
        } else {
            this.f9503x0.f(this.f9507z0);
        }
    }

    @Override // r4.f
    public void f(r4.a aVar, int i10) {
        mark.via.common.widget.t tVar = this.C0;
        if (tVar == null) {
            return;
        }
        tVar.t(i10);
    }

    @Override // c8.d1.a
    public void f0(int i10) {
        Z9(i10, true);
    }

    public final void f7() {
        t4.b bVarH = H();
        if (bVarH == null) {
            return;
        }
        bVarH.evaluateJavascript(c6.x0.f2135a.a(X0(w7.u.V), X0(w7.u.f13976a9)), null);
    }

    public final void f8(WebView webView, r0.h hVar, Uri uri, boolean z10, r0.c cVar) {
        String strC;
        Uri uri2;
        final q9.b bVarT;
        JSONObject jSONObjectOptJSONObject;
        c8.d0 d0Var;
        if (webView == null || a1() == null) {
            return;
        }
        boolean zEquals = "null".equals(uri.toString());
        if (zEquals || (("https".equals(uri.getScheme()) || "http".equals(uri.getScheme())) && !TextUtils.isEmpty(uri.getHost()))) {
            if (hVar.d() == 1) {
                byte[] bArrB = hVar.b();
                if (bArrB.length < 48 || bArrB.length > 65584) {
                    return;
                }
                q9.b bVarK = q9.m(webView).k(cVar, ByteBuffer.wrap(bArrB).getInt());
                if (bVarK != null) {
                    this.P0.E(bVarK, bArrB);
                    return;
                }
                return;
            }
            if (hVar.d() == 0 && (strC = hVar.c()) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(strC);
                    int iOptInt = jSONObject.optInt("action");
                    if (iOptInt == 118 || !U7(jSONObject.optString("secret"))) {
                        final q9 q9VarM = q9.m(webView);
                        boolean zP = q9VarM.p();
                        if (iOptInt == 120) {
                            W8(webView, q9VarM.u(cVar, jSONObject));
                            if (!zP && q9VarM.p() && webView == H()) {
                                this.E0.C();
                                return;
                            }
                            return;
                        }
                        if (!q9VarM.p() || (z10 && jSONObject.optInt("frame") == 0)) {
                            if (iOptInt == 113) {
                                bVarT = q9VarM.k(cVar, jSONObject.optInt("frame"));
                                uri2 = uri;
                            } else {
                                uri2 = uri;
                                bVarT = q9VarM.t(cVar, uri2, jSONObject.optInt("frame"));
                            }
                            if (bVarT == null) {
                                return;
                            }
                            bVarT.f9567f = z10 && bVarT.f9565d == 0;
                            if (iOptInt == 101) {
                                W8(webView, q9VarM.B(bVarT, jSONObject.optBoolean("evalBlocked")));
                                if (!zP && q9VarM.p() && webView == H()) {
                                    this.E0.C();
                                }
                                if (q9VarM.i(bVarT)) {
                                    int iOptInt2 = jSONObject.optInt("runAt");
                                    String strOptString = jSONObject.optString("url");
                                    if (webView.getSettings().getJavaScriptEnabled()) {
                                        if (iOptInt2 == 1 && !c6.a2.f1958a.m(strOptString)) {
                                            bVarT.b(r7(webView));
                                        }
                                        if (zEquals || bVarT.f9565d != 0) {
                                            return;
                                        }
                                        if ((iOptInt2 == 1 || iOptInt2 == 2 || iOptInt2 == 4) && q9.r(strOptString, uri2.toString())) {
                                            h9(webView, strOptString, iOptInt2, z10, new oa.k1.a() { // from class: mark.via.browser.q0
                                                @Override // oa.k1.a
                                                public final void a(String str) {
                                                    bVarT.b(str);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (iOptInt == 104) {
                                String strOptString2 = jSONObject.optString("url");
                                if (!zEquals || q9VarM.n(strOptString2) == bVarT) {
                                    this.P0.y(strOptString2, jSONObject.optString("name"));
                                    return;
                                }
                                return;
                            }
                            if (iOptInt == 112) {
                                q9VarM.A(bVarT, jSONObject.optString("url"), jSONObject.optBoolean("remove"));
                                return;
                            }
                            if (iOptInt == 113) {
                                W8(webView, q9VarM.w(bVarT));
                                return;
                            }
                            if (iOptInt == 111) {
                                this.f9477g1.y(webView.getId(), jSONObject.optString("token"), jSONObject.optBoolean("selected"));
                                return;
                            }
                            if (iOptInt == 116) {
                                rd rdVarQ = rd.q(webView);
                                rdVarQ.E(bVarT, jSONObject);
                                if (webView == H() && (d0Var = this.f9497u0) != null && d0Var.L()) {
                                    x8.f2.f(y0(), rdVarQ.s());
                                    return;
                                }
                                return;
                            }
                            if (!zEquals && bVarT.f9565d == 0) {
                                if (iOptInt == 118) {
                                    if (webView.getSettings().getJavaScriptEnabled() && (jSONObjectOptJSONObject = jSONObject.optJSONObject("request")) != null) {
                                        O(webView).o(jSONObjectOptJSONObject, new oa.k1.a() { // from class: mark.via.browser.r0
                                            @Override // oa.k1.a
                                            public final void a(String str) {
                                                q4.h3(this.f9585a, q9VarM, bVarT, str);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                if (iOptInt == 117) {
                                    if (q9.r(jSONObject.optString("url"), uri2.toString())) {
                                        mark.via.browser.c.f(webView).h(bVarT);
                                    }
                                } else if (iOptInt == 102) {
                                    mark.via.browser.c.f(webView).g(bVarT, jSONObject);
                                } else if (iOptInt == 114) {
                                    T6(webView);
                                } else if (webView == H()) {
                                    this.E0.G(jSONObject, bVarT);
                                }
                            }
                        }
                    }
                } catch (JSONException unused) {
                    tc.a.i("Invalid frame message", new Object[0]);
                }
            }
        }
    }

    public final void f9() {
        if (Build.VERSION.SDK_INT >= 21 && this.f9500v1 == this.U0) {
            x8.h3.n(G(), this.f9502w1);
        }
    }

    public final void fa(tb.k0 k0Var) {
        if (this.M0 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (r4.a aVar : this.M0.c()) {
            l9.b bVar = new l9.b(aVar.getUrl(), aVar.getTitle());
            bVar.m(aVar.getId());
            arrayList.add(bVar);
        }
        k0Var.O3(arrayList);
    }

    @Override // mark.via.browser.r8
    public void g(r4.g gVar, int i10, boolean z10) {
        r4.a aVarD = this.M0.d();
        r4.a aVarG = this.M0.g(gVar, i10, z10);
        if (this.f9486o1) {
            aVarG.w();
        }
        if (gVar instanceof ka.g) {
            this.f9485o0.p0(((ka.g) gVar).c(), aVarG == null ? -1 : aVarG.getId(), z10);
        }
        if (aVarG == null || !z10 || aVarD == null || aVarD.p()) {
            return;
        }
        this.f9485o0.N1(aVarD);
    }

    @Override // c8.i.a
    public boolean g0(t4.b bVar, String str) {
        return z7(bVar, str) != 0;
    }

    public final void g7() {
        u9.p pVarN2 = this.f9487p0.n2();
        pVarN2.U(true);
        this.f9487p0.F1(pVarN2);
        u9.n.e().s(true);
        this.f9503x0.j();
        com.tuyafeng.support.utils.n.q(G(), w7.u.f14016d7);
        this.f9485o0.m1();
        this.f9507z0.setIncognitoModeEnabled(true ^ this.f9485o0.X1(u7()));
    }

    public void g8() {
        if (!W7()) {
            L0().e1();
            return;
        }
        if (D7()) {
            return;
        }
        if (T7()) {
            this.f9497u0.i();
            return;
        }
        if (this.f9482l1) {
            if (SystemClock.elapsedRealtime() - this.T0 > 1500) {
                com.tuyafeng.support.utils.n.q(G(), w7.u.f14015d6);
                this.T0 = SystemClock.elapsedRealtime();
                return;
            } else {
                this.T0 = 0L;
                t9(false);
                return;
            }
        }
        if (this.f9486o1) {
            r4.a aVarD = this.M0.d();
            if (aVarD != null && aVarD.i()) {
                aVarD.e();
                return;
            } else if (i() > 1) {
                this.f9485o0.C0();
                return;
            } else {
                i0().finish();
                return;
            }
        }
        if (!s9.d.n(G(), u7())) {
            w7();
            return;
        }
        if (this.M0.i() > 1) {
            this.f9485o0.C0();
        } else if (SystemClock.elapsedRealtime() - this.T0 <= 1500) {
            h7();
        } else {
            com.tuyafeng.support.utils.n.s(G(), R0().getString(w7.u.f14129l8));
            this.T0 = SystemClock.elapsedRealtime();
        }
    }

    public boolean g9(final WebView webView, int i10) {
        return webView != null && h9(webView, webView.getUrl(), i10, true, new oa.k1.a() { // from class: mark.via.browser.v0
            @Override // oa.k1.a
            public final void a(String str) {
                s4.b.g(webView, str);
            }
        });
    }

    public final void ga(int i10) {
        if (i10 == 0) {
            this.f9507z0.setBackgroundColor(0);
            return;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new com.tuyafeng.support.utils.g().h(this.f9487p0.e() ? 587202559 : 268435456).c(v8.h.e(G())).a()});
        int iH = com.tuyafeng.support.utils.x.h(G(), 4.0f);
        if (i10 == 3) {
            int i11 = iH * 4;
            this.f9507z0.setPadding(i11, 0, i11, 0);
            layerDrawable.setLayerInset(0, i11, iH, i11, iH);
        } else {
            this.f9507z0.setPadding(0, 0, 0, 0);
            layerDrawable.setLayerInset(0, iH, iH, iH, iH);
        }
        com.tuyafeng.support.utils.x.P(this.f9507z0, layerDrawable);
    }

    public final void h7() {
        this.f9485o0.O1();
        if (this.f9487p0.v().k() && this.f9487p0.n2().s() && (!s9.d.n(G(), u7()) || i() > 1)) {
            q5.k.l(G()).f0(w7.u.f13972a5).J(w7.u.f13986b5).x(w7.u.Y3, false).X(w7.u.f13972a5, new q5.k.m() { // from class: mark.via.browser.t2
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    q4.t4(this.f9661a, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        } else {
            i0().finish();
        }
    }

    public final boolean h8() {
        if (!this.f9487p0.z2()) {
            return false;
        }
        P8(18);
        return true;
    }

    public final boolean h9(WebView webView, String str, int i10, boolean z10, oa.k1.a aVar) {
        if (webView.getSettings().getJavaScriptEnabled() && !TextUtils.isEmpty(str)) {
            c6.a2 a2Var = c6.a2.f1958a;
            if (!a2Var.m(str)) {
                String strG = a2Var.g(str);
                if (TextUtils.isEmpty(strG)) {
                    return false;
                }
                if (i10 == 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(c6.t0.f2104a.c(this.f9476f1));
                    if (!q9.s()) {
                        sb2.append(r7(webView));
                    }
                    String url = webView.getUrl();
                    if (z10) {
                        sb2.append("(function(){var i=\"via-fake-print\";if(!window[i])try{window[i]=!0;var n=window.print;\"function\"==typeof n&&/\\{\\s*\\[native code\\]\\s*\\}/.test(Function.prototype.toString.call(n))&&(window.print=function(){window.via2?window.via2.postMessage(JSON.stringify({secret:\"__SECRET__\",action:114})):window.via.postMessage(\"__SECRET__\",JSON.stringify({action:114}))})}catch(i){}})();".replace("__SECRET__", this.f9476f1));
                        if (!"music.163.com".equals(strG) && !"taobao.com".equals(strG) && this.f9485o0.e1(str)) {
                            sb2.append(jd.a(y0(), 1280));
                        } else if (this.f9487p0.n2().n()) {
                            sb2.append(jd.b(y0()));
                        }
                        if (this.f9487p0.C1() && this.f9487p0.e()) {
                            sb2.append("(function(){if(!document.getElementById('via_inject_css_night')){var css=document.createElement('style');css.id='via_inject_css_night';css.type='text/css';css.rel=\"stylesheet\";var textNode=document.createTextNode('html{background-color:#000!important}*{color:#999!important;box-shadow:none!important;background-color:transparent!important;border-color:#444!important;border-top-color:#444!important;border-bottom-color:#444!important;border-left-color:#444!important;border-right-color:#444!important}body{background-color:transparent!important}:after,:before{background-color:transparent!important;border-color:#444!important}a,a *{color:#409B9B!important;text-decoration:none!important}.link:hover,.link:hover *,[role=button]:hover *,[role=link]:hover,[role=link]:hover *,[role=menuitem]:hover,[role=menuitem]:hover *,a:hover,a:hover *,a:visited:hover,a:visited:hover *,div[onclick]:hover,span[onclick]:hover{color:#F0F0F0!important}a:visited,a:visited *{color:#607069!important}.selected,.selected *,[href=\"#\"],a.active,a.active *,a.highlight,a.highlight *{color:#DDD!important;font-weight:700!important}[class*=header],[class*=header] td,[class*=headline],[id*=header],[id*=headline],h1,h1 *,h2,h2 *,h3,h3 *,h4,h5,h6,strong{color:#DDD!important}[class*=alert],[class*=error],code,div[onclick],span[onclick]{color:#900!important}::-moz-selection{background-color:#377!important;color:#000!important}::selection{background-color:#377!important;color:#000!important}:focus{outline:0!important}div[role=navigation],div[style=\"display: block;\"]{background-color:rgba(0,0,0,.5)!important}table{background-color:rgba(40,30,30,.6)!important;border-radius:6px!important}table>tbody>tr:nth-child(even),table>tbody>tr>td:nth-child(even){background-color:rgba(0,0,0,.2)!important}#ghostery-purple-bubble,#translator-popup,.hovercard,.menu,.tooltip,.vbmenu_popup,[class*=dropdown],[class*=nav] ul,[class*=popup],[class=title],[id*=Menu],[id*=menu],[id*=nav] ul,a[id*=ghosteryfirefox],a[onclick][style*=display],div[role=dialog],div[role=menu],div[style*=\"position:\"][style*=\"left:\"][style*=visible],div[style*=\"z-index:\"][style*=\"left:\"][style*=visible],div[style*=\"-moz-user-select\"],embed,iframe,label [onclick],nav,nav ul,span[class*=script] div,ul[class*=menu],ul[style*=\"display:\"],ul[style*=\"visibility:\"] ul{background-color:rgba(5,5,5,.9)!important;border-radius:5px;box-shadow:1px 1px 5px #000!important}#footer,#header,footer,header{background-color:rgba(19,19,19,.9)!important;box-shadow:0 0 5px #000!important}body>#dialog,body>.xenOverlay{background-color:rgba(19,19,19,.96)!important;background-clip:padding-box!important;box-shadow:0 0 15px #000,inset 0 0 0 1px rgba(200,200,200,.5),inset 0 0 5px #111!important}[id*=lightbox],[id*=overlay],blockquote{background-color:rgba(35,35,35,.9)!important;border-radius:5px}.Message code,dl,pre{background-color:rgba(5,5,5,.5)!important}.install[onclick],[role=button],a.BigButton,a.TabLink,a.button,a.submit,button,input,select{-moz-appearance:none!important;-webkit-appearance:none!important;transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty),a[href=\"javascript:;\"],a[id*=Button]:not(:empty),a[id*=button]:not(:empty),div[class*=button][onclick]{transition:border-color .3s!important;background-color:#060606!important;color:#BBB!important;border-color:#333!important;box-shadow:0 0 2px rgba(0,0,0,.9)!important}a[class*=button]:not(:empty):hover,a[href=\"javascript:;\"]:hover,a[id*=Button]:not(:empty):hover,a[id*=button]:hover,div[class*=button][onclick]:hover{background-color:#151515!important;color:#FFF!important}a.button *,a.submit *,button *,input *,select *{color:#BBB!important}[role=button]:hover,a.BigButton:hover,a.TabLink:hover,a.button:hover,a.submit:hover,button:hover,input:hover,input[type=button]:hover,select:hover{border-top-color:#555!important;border-bottom-color:#555!important;border-left-color:#555!important;border-right-color:#555!important}input:focus,select:focus{box-shadow:0 0 5px #077!important}input :hover *{color:#F0F0F0!important}button[disabled],button[disabled]:focus,button[disabled]:hover,input[disabled],input[disabled]:focus,input[disabled]:hover,select[disabled],select[disabled]:focus,select[disabled]:hover{opacity:.5!important;border-color:#333!important}input[type=checkbox]{border-radius:1px!important}input[type=radio],input[type=radio]:focus{border-radius:100%!important}input[type=checkbox],input[type=radio]{min-width:12px;min-height:12px}input[type=checkbox]:checked,input[type=radio]:checked{border-color:#077!important;box-shadow:0 0 5px #077!important}select{padding-right:15px!important;background-color:#060606!important;transition:border-color .3s,background-position .3s!important}.Active .TabLink,a.BigButton:active,a.TabLink:active,a.button:active,a.submit:active,a[class*=button]:not(:empty):active,button:active,input[type=button]:active,input[type=submit]:active{background-color:#292929!important;color:#FFF!important}textarea{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:rgba(0,0,0,.3)!important;border-radius:3px!important;box-shadow:inset 0 0 8px #000!important;transition:border-color,background,.3s!important}textarea,textarea *{color:#C8C8C8!important}textarea:focus:hover,textarea:hover{border-color:#333!important}textarea:focus{background-color:rgba(0,0,0,.5)!important;border-color:#222!important}textarea:focus,textarea:focus>*{box-shadow:none!important}optgroup,option{-moz-appearance:none!important;-webkit-appearance:none!important;background-color:0 0!important;color:#666!important}optgroup{background-color:#222!important;color:#DDD!important}option:checked,option:focus,option:not([disabled]):hover{background-color:linear-gradient(#333,#292929)!important;color:#DDD!important}img{opacity:.7!important;transition:opacity .2s}#mpiv-popup,a:hover img,img:hover{opacity:1!important}.read-whole-mask .exp-mask,.se-head-tabcover,.wgt-exp-content .exp-img-mask{background-image:none!important}.s_card{background:0 0!important}');css.appendChild(textNode);(document.head||document.documentElement).appendChild(css);};})();");
                            final WeakReference weakReference = new WeakReference(webView);
                            webView.postDelayed(new Runnable() { // from class: mark.via.browser.u0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    q4.V2(weakReference);
                                }
                            }, 300L);
                        }
                        sb2.append("(function(){var i=\"via-fake-notification\";if(!window[i])try{window[i]=!0;window.Notification=function(i,n){};window.Notification.permission=\"denied\";window.Notification.requestPermission=function(i){\"function\"==typeof i&&i(\"denied\");return Promise.resolve(\"denied\")}}catch(i){}})();");
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 >= 21 && i11 < 28) {
                            sb2.append(c6.n0.f2073a.a());
                        }
                    }
                    String strC1 = this.f9487p0.c1();
                    if (strC1 != null && !strC1.isEmpty()) {
                        sb2.append(n9.a(G(), "/" + strC1));
                    }
                    aVar.a(sb2.toString());
                    if (this.f9485o0.c1(url) && a2Var.t(str)) {
                        aVar.a(k8.b.b(strG) + this.f9485o0.J0(strG));
                    }
                } else if (q9.s() && i10 == 2) {
                    aVar.a(c6.b.f1959a.e(this.f9476f1, AdMarkingBridge.FRAME));
                }
                if (z10 && i10 == 4) {
                    if (!q9.s()) {
                        c6.b.f1959a.g(new c6.f(webView), this.f9476f1);
                    }
                    this.f9481k1.m(webView);
                }
                boolean zR = p9.a.a().r(str);
                boolean zC = this.f9487p0.n2().C();
                boolean z11 = !zR && this.R0.e(str, i10, z10, zC, aVar);
                if (i10 == 1 || (z10 && i10 == 4)) {
                    return zR || !zC || z11;
                }
                if (z10) {
                    this.f9481k1.u(webView);
                }
                return z11;
            }
        }
        return false;
    }

    public final void ha() {
        String strC = c6.a2.f1958a.c(u7());
        if (strC.isEmpty()) {
            p5.b.d().b("HISTORY_CACHE");
        } else {
            p5.b.a().e("HISTORY_CACHE").f(180).d("query", strC).a();
        }
        G8(false);
    }

    @Override // mark.via.browser.r8
    public int i() {
        p4.a aVar = this.M0;
        if (aVar == null) {
            return 0;
        }
        return aVar.i();
    }

    public final void i7(boolean z10) {
        t4.b bVarH = H();
        if (bVarH == null) {
            return;
        }
        bVarH.findNext(z10);
    }

    public final boolean i8() {
        if (!this.f9487p0.z2()) {
            return false;
        }
        P8(17);
        return true;
    }

    public final void i9() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.f9502w1 = x8.h3.o(G());
        this.f9500v1 = this.U0;
    }

    @Override // mark.via.browser.r8
    public void j(int i10) {
        r4.a aVarD = d();
        if (!this.M0.j(i10) || aVarD == null || aVarD.p()) {
            return;
        }
        this.f9485o0.N1(aVarD);
    }

    @Override // mark.via.browser.r8
    public void j0(String str) {
        q5.k kVarP = q5.k.l(G()).f0(w7.u.f13995c0).f(0, str, w7.u.f14292x6, 1).X(R.string.ok, new q5.k.m() { // from class: mark.via.browser.y2
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                q4.O4(this.f9773a, view, pVar);
            }
        }).P(R.string.cancel, null);
        if (Build.VERSION.SDK_INT >= 21) {
            kVarP.x(w7.u.Jb, this.f9487p0.v().p());
        }
        kVarP.h0();
    }

    public final void j7(String str) {
        t4.b bVarH = H();
        if (bVarH == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (str.isEmpty()) {
            bVarH.setFindListener(null);
            r9(-1, 0, true);
        } else {
            bVarH.setFindListener(new WebView.FindListener() { // from class: mark.via.browser.u3
                @Override // android.webkit.WebView.FindListener
                public final void onFindResultReceived(int i10, int i11, boolean z10) {
                    this.f9682a.r9(i10, i11, z10);
                }
            });
        }
        bVarH.findAllAsync(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:119:0x011c  */
    public boolean j8(int i10, KeyEvent keyEvent) {
        if (i10 != 3) {
            if (i10 != 30) {
                if (i10 != 40) {
                    if (i10 != 46) {
                        if (i10 != 51) {
                            if (i10 != 61) {
                                if (i10 == 82) {
                                    if (i10 != 82 || keyEvent.isAltPressed()) {
                                        J9();
                                        return true;
                                    }
                                } else {
                                    if (i10 == 84) {
                                        P8(4);
                                        return true;
                                    }
                                    if (i10 == 111) {
                                        D7();
                                        return true;
                                    }
                                    if (i10 == 135) {
                                        P8(1);
                                        return true;
                                    }
                                    if (i10 == 21 || i10 == 22) {
                                        if (keyEvent.isAltPressed()) {
                                            P8(i10 == 21 ? 12 : 13);
                                            return true;
                                        }
                                    } else {
                                        if (i10 == 24) {
                                            return (T7() || this.f9482l1 || A7() || !i8()) ? false : true;
                                        }
                                        if (i10 == 25) {
                                            return (T7() || this.f9482l1 || A7() || !h8()) ? false : true;
                                        }
                                        if (i10 != 48) {
                                            if (i10 != 49) {
                                                if (i10 != 92 && i10 != 93) {
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
                                                                this.f9485o0.Y1(i10 == 16 ? this.M0.i() - 1 : i10 - 8);
                                                                return true;
                                                            }
                                                            break;
                                                        default:
                                                            switch (i10) {
                                                                case 32:
                                                                    if (keyEvent.isCtrlPressed()) {
                                                                        P8(6);
                                                                        return true;
                                                                    }
                                                                    break;
                                                                case 33:
                                                                    if (i10 != 82) {
                                                                        break;
                                                                    }
                                                                    J9();
                                                                    return true;
                                                                case 34:
                                                                    if (keyEvent.isCtrlPressed()) {
                                                                        P8(14);
                                                                        return true;
                                                                    }
                                                                    if (keyEvent.isAltPressed()) {
                                                                        J9();
                                                                        return true;
                                                                    }
                                                                    break;
                                                                case 35:
                                                                    if (keyEvent.isCtrlPressed()) {
                                                                        P8(keyEvent.isShiftPressed() ? 22 : 21);
                                                                        return true;
                                                                    }
                                                                    break;
                                                                case 36:
                                                                    if (keyEvent.isCtrlPressed()) {
                                                                        P8(8);
                                                                        return true;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    x8.z.U(H(), i10 == 92 ? 2 : 3);
                                                    return true;
                                                }
                                            } else if (keyEvent.isCtrlPressed()) {
                                                P8(20);
                                                return true;
                                            }
                                        } else if (keyEvent.isCtrlPressed()) {
                                            P8(5);
                                            L8();
                                            return true;
                                        }
                                    }
                                }
                            } else if (keyEvent.isCtrlPressed()) {
                                P8(keyEvent.isShiftPressed() ? 10 : 11);
                                return true;
                            }
                        } else if (keyEvent.isCtrlPressed()) {
                            P8(9);
                            return true;
                        }
                    } else if (keyEvent.isCtrlPressed()) {
                        P8(1);
                        return true;
                    }
                } else if (keyEvent.isCtrlPressed()) {
                    P8(4);
                    return true;
                }
            } else if (keyEvent.isCtrlPressed() && keyEvent.isShiftPressed()) {
                P8(7);
                return true;
            }
        } else if (keyEvent.isAltPressed()) {
            this.f9485o0.W0();
            return true;
        }
        return false;
    }

    public final void j9(String str, String str2, String str3, boolean z10) {
        String strH = c6.y1.f2139a.h(str2, str);
        r8.f.a().h(str3);
        this.f9485o0.m0(str);
        I8(strH, z10);
    }

    @Override // mark.via.browser.r8
    public int k() {
        return this.M0.l();
    }

    @Override // c8.d0.a
    public void k0(boolean z10) {
        this.f9493s0.setVisibility(z10 ? 4 : 0);
        s9(z10 || this.f9482l1 || this.f9487p0.O1());
        if (!z10 && g1() && !n1()) {
            q9(this.f9487p0.z0(), this.f9487p0.v().t());
        }
        if (z10) {
            F7(false);
        } else if (!this.f9482l1 && !x8.f2.d(y0())) {
            K9();
        }
        X9();
    }

    public final void k7(boolean z10) {
        v9(z10 ? 0.0f : 1.0f);
        if (z10) {
            this.A0.setVisibility(0);
            this.f9505y0.setVisibility(0);
        } else {
            this.A0.setVisibility(8);
            this.f9505y0.setVisibility(8);
            this.f9495t0.setTranslationY(0.0f);
            this.f9489q0.f9815o.setTranslationY(0.0f);
            mark.via.common.widget.m mVar = this.D0;
            if (mVar != null) {
                mVar.setTranslationY(0.0f);
            }
            this.E0.L(0.0f);
        }
        this.f9490q1 = z10;
        if (z10) {
            E7();
        } else {
            G9();
        }
    }

    public boolean k8(int i10, KeyEvent keyEvent) {
        if (i10 == 24 || i10 == 25) {
            return !T7();
        }
        return false;
    }

    public final void k9(String str) {
        m9(str, false);
    }

    public final void l8(boolean z10) {
        if (this.A1 == z10) {
            return;
        }
        this.A1 = z10;
        d9();
        if (!z10) {
            if (this.B1) {
                this.f9505y0.setVisibility(0);
            }
            if (this.C1) {
                G9();
                return;
            }
            return;
        }
        boolean z11 = this.f9505y0.getVisibility() == 0;
        this.B1 = z11;
        this.C1 = this.f9498u1;
        if (z11) {
            this.f9505y0.setVisibility(this.f9491r0.i() ? 4 : 8);
        }
        if (this.C1) {
            F7(false);
        }
    }

    public final void l9(String str, int i10) {
        ga.c cVar;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            Iterator it = x8.q2.e(G()).iterator();
            do {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (ga.c) it.next();
            } while (cVar.d() != i10);
            if (cVar == null) {
                k9(strTrim);
            } else {
                c6.r1 r1VarC = x8.q2.c(cVar.d(), cVar.a());
                j9(strTrim, r1VarC.e(false), r1VarC.a(), false);
            }
        }
    }

    public final void m7(View view, y.k0 k0Var, boolean z10) {
        if (!x8.h3.f14580a || k0Var == null || view == null) {
            return;
        }
        if (!z10) {
            view.setPadding(0, 0, 0, 0);
        } else {
            r.f fVarG = k0Var.g(y.k0.m.f() | y.k0.m.b() | y.k0.m.a());
            view.setPadding(fVarG.f11875a, fVarG.f11876b, fVarG.f11877c, (!this.A1 || this.f9491r0.i()) ? fVarG.f11878d : 0);
        }
    }

    public final void m8(d8.q qVar) {
        qVar.d3(new g());
    }

    public final void m9(String str, boolean z10) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strB1 = this.f9487p0.b1();
            c6.a2 a2Var = c6.a2.f1958a;
            if (!a2Var.u(strTrim) || (z10 && a2Var.q(strTrim))) {
                j9(strTrim, strB1, this.f9487p0.T2(), false);
                return;
            }
            String strW = a2Var.w(strTrim, strB1);
            if (t(strW)) {
                return;
            }
            I8(strW, false);
        }
    }

    @Override // mark.via.browser.r8
    public void n(int i10) {
        com.tuyafeng.support.utils.n.q(G(), i10);
    }

    public SslCertificate n7() {
        r4.a aVarD = this.M0.d();
        if (aVarD == null) {
            return null;
        }
        return aVarD.v();
    }

    public final void n8(int i10, int i11) {
        if (i10 != 21) {
            r8.f.a().f(i10);
        }
        boolean z10 = false;
        switch (i10) {
            case 1:
                boolean z11 = !this.f9487p0.e();
                boolean zA = com.tuyafeng.support.utils.q.a(G());
                if (z11 == zA && Build.VERSION.SDK_INT >= 29) {
                    com.tuyafeng.support.utils.n.q(G(), w7.u.U5);
                }
                this.f9487p0.V0(z11, zA);
                V9();
                break;
            case 2:
            case 3:
            case 13:
                if (i10 == 13) {
                    H8();
                } else {
                    G8(i10 == 2);
                }
                break;
            case 4:
                this.P0.J();
                break;
            case 5:
                u9();
                break;
            case 6:
                this.f9485o0.T1();
                break;
            case 7:
                I6();
                break;
            case 8:
                u9.p pVarN2 = this.f9487p0.n2();
                boolean zL = pVarN2.l();
                boolean z12 = !zL;
                com.tuyafeng.support.utils.n.s(G(), Y0(!zL ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.U)));
                pVarN2.N(z12);
                this.f9487p0.F1(pVarN2);
                this.f9485o0.n1(true);
                if (!s9.d.l(G(), u7())) {
                    V8(z12);
                }
                break;
            case 10:
                P8(26);
                break;
            case 11:
                P8(14);
                break;
            case 12:
                P8(19);
                break;
            case 14:
                P8(15);
                break;
            case 15:
                P8(20);
                break;
            case 16:
                this.f9489q0.postDelayed(new Runnable() { // from class: mark.via.browser.v3
                    @Override // java.lang.Runnable
                    public final void run() {
                        q4.b3(this.f9704c);
                    }
                }, 100L);
                break;
            case 17:
                final String[] strArr = {X0(w7.u.I6), X0(w7.u.H6), X0(w7.u.G6)};
                u9.p pVarN3 = this.f9487p0.n2();
                final int i12 = pVarN3.r() ? 2 : pVarN3.q() ? 0 : 1;
                q5.k.l(G()).f0(w7.u.K6).d0(strArr, i12, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.w3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i13, long j10) {
                        q4.Z4(this.f9720a, i12, strArr, adapterView, view, i13, j10);
                    }
                }).h0();
                break;
            case 18:
                this.f9485o0.u1();
                break;
            case 19:
                w9(false);
                break;
            case 20:
                this.f9485o0.s1();
                break;
            case 21:
                h7();
                break;
            case 23:
                a8();
                break;
            case 24:
                U8();
                break;
            case 25:
                E8();
                break;
            case 26:
                J8();
                break;
            case 27:
                boolean zC = this.f9487p0.n2().C();
                String strU7 = u7();
                if (c6.a2.f1958a.t(strU7) && !p9.a.a().r(strU7) && kd.c().f().C(strU7)) {
                    z10 = true;
                }
                if (!zC) {
                    u9.p pVarN4 = this.f9487p0.n2();
                    pVarN4.g0(true);
                    this.f9487p0.F1(pVarN4);
                    if (z10) {
                        U8();
                    }
                    com.tuyafeng.support.utils.n.q(G(), w7.u.Wb);
                } else if (!z10) {
                    FragmentUtils.i(this, oa.f1.class);
                } else {
                    D7();
                    M9(u7());
                }
                break;
            case 28:
                u9.p pVarN5 = this.f9487p0.n2();
                pVarN5.H(!pVarN5.g());
                this.f9487p0.F1(pVarN5);
                this.f9485o0.m1();
                com.tuyafeng.support.utils.n.s(G(), Y0(pVarN5.g() ? w7.u.f14240t7 : w7.u.f14226s7, X0(w7.u.G1)));
                break;
            case 29:
                H9(false, 0);
                break;
            case 30:
                final int iL0 = this.f9487p0.l0() - 1;
                q5.k.l(G()).f0(w7.u.f13991ba).b0(w7.j.f13716g, iL0, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.x3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i13, long j10) {
                        q4.Z3(this.f9747a, iL0, adapterView, view, i13, j10);
                    }
                }).h0();
                break;
            case 31:
                x8.f0.e(G(), this.f9487p0, la.s.m().f(), la.s.l(), la.s.f());
                break;
            case 32:
                S8();
                break;
            case 33:
                T8();
                break;
            case 34:
                o9();
                break;
            case 35:
                FragmentUtils.i(this, g8.s.class);
                break;
            case 36:
                if ((i11 & 8) == 0) {
                    this.f9481k1.s();
                } else {
                    this.f9481k1.p();
                }
                break;
            case 37:
                N8(u7());
                break;
            case 38:
                t9(!this.f9487p0.a());
                break;
            case 39:
                z8();
                break;
            case 40:
                J6();
                break;
            case 41:
                X8();
                break;
        }
    }

    public final void n9(PendingIntent pendingIntent) {
        Intent data;
        if (pendingIntent == null) {
            return;
        }
        String strU7 = u7();
        if (strU7 != null) {
            try {
                data = strU7.isEmpty() ? null : new Intent().setData(Uri.parse(strU7));
            } catch (Exception e10) {
                tc.a.j(e10);
                return;
            }
        }
        Intent intent = data;
        if (Build.VERSION.SDK_INT < 34) {
            pendingIntent.send(i0(), 0, intent);
            return;
        }
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        x8.d.b(activityOptionsMakeBasic);
        pendingIntent.send(i0(), 0, intent, null, null, null, activityOptionsMakeBasic.toBundle());
    }

    @Override // c8.b1.a
    public void o(WebView webView) {
        if (webView == null) {
            return;
        }
        s4.b.g(webView, "javascript:void(window.__VIA_SECRET__=\"__SECRET__\");".replace("__SECRET__", this.f9476f1));
        String strC1 = this.f9487p0.c1();
        if (strC1 == null || strC1.isEmpty()) {
            return;
        }
        s4.b.g(webView, n9.a(G(), "/" + strC1));
    }

    public final float o7() {
        FrameLayout frameLayout = this.f9489q0.f9815o;
        if (frameLayout.getChildCount() == 1 && (frameLayout.getChildAt(0) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) frameLayout.getChildAt(0);
            if (viewGroup.getChildCount() != 0 && (viewGroup.getChildAt(0).getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                return (((FrameLayout.LayoutParams) viewGroup.getChildAt(0).getLayoutParams()).gravity & 80) == 80 ? this.f9505y0.getHeight() : -this.A0.getHeight();
            }
        }
        return 0.0f;
    }

    public final void o8(int i10, int i11) {
        if (i10 == 1) {
            FragmentUtils.i(this, hb.o4.class);
            return;
        }
        if (i10 == 2) {
            u8();
            return;
        }
        if (i10 == 3) {
            this.f9485o0.t1(3, null);
            return;
        }
        if (i10 == 4) {
            this.P0.N(new Runnable() { // from class: mark.via.browser.p3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9410c.D7();
                }
            });
            return;
        }
        if (i10 == 16) {
            FragmentUtils.i(this, hb.l7.class);
            return;
        }
        if (i10 == 17) {
            FragmentUtils.i(this, jb.n1.class);
            return;
        }
        if (i10 == 19) {
            FragmentUtils.i(this, jb.v5.class);
            return;
        }
        if (i10 == 20 || i10 == 23) {
            FragmentUtils.i(this, y7.u.class);
            return;
        }
        if (i10 == 33) {
            this.f9480j1.u();
            return;
        }
        if (i10 == 36) {
            if ((i11 & 8) != 0) {
                P9();
                return;
            } else {
                FragmentUtils.i(this, hb.o5.class);
                return;
            }
        }
        if (i10 == 39) {
            FragmentUtils.i(this, y8.o.class);
            return;
        }
        switch (i10) {
            case 6:
                N8(u7());
                break;
            case 7:
                o9();
                break;
            case 8:
                w9(true);
                break;
            case 9:
                this.f9485o0.u1();
                break;
            case 10:
                FragmentUtils.i(this, g8.s.class);
                break;
            default:
                switch (i10) {
                    case 26:
                        FragmentUtils.i(this, jb.y4.class);
                        break;
                    case 27:
                        FragmentUtils.i(this, oa.f1.class);
                        break;
                    case 28:
                        FragmentUtils.i(this, y7.d.class);
                        break;
                    case 29:
                        FragmentUtils.i(this, jb.k5.class);
                        break;
                }
                break;
        }
    }

    public final void o9() {
        String strU7 = u7();
        String strT7 = t7(strU7);
        if (strU7 == null || s9.d.l(G(), strU7)) {
            strU7 = "";
            strT7 = "";
        }
        if (strT7 == null || strT7.isEmpty()) {
            strT7 = X0(w7.u.f14066h1);
        }
        p9(strU7, strT7);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f9477g1.q();
        super.onConfigurationChanged(configuration);
        int i10 = configuration.orientation;
        if (i10 != this.f9508z1) {
            this.f9508z1 = i10;
            tc.a.a("on configuration changed, orientation: %d", Integer.valueOf(i10));
            W6();
        }
        ba();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0015  */
    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        int i11;
        if (this.M0 == null) {
            return;
        }
        if (i10 > 15) {
            if (i10 <= 80) {
                if (i10 < 60) {
                    return;
                }
                if (i10 <= 60) {
                    i11 = 2;
                }
            }
            i11 = 3;
        } else {
            if (i10 < 10) {
                return;
            }
            if (i10 > 10) {
                i11 = 2;
            } else {
                i11 = 1;
            }
        }
        tc.a.a("on trim memory, tab level: %d", Integer.valueOf(i11));
        for (r4.a aVar : this.M0.c()) {
            if (aVar != null) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        aVar.l(aVar.d() ? 4 : 2);
                    } else if (i11 == 3) {
                        aVar.l(aVar.d() ? 2 : 1);
                    }
                } else if (!aVar.d()) {
                    aVar.l(4);
                }
            }
        }
    }

    @Override // mark.via.browser.r8
    public void p(final String str, final List list) {
        if (list == null || list.isEmpty()) {
            if (str == null || str.isEmpty()) {
                return;
            }
            q5.k.l(G()).f0(w7.u.I3).K(str).X(w7.u.f14063gc, new q5.k.m() { // from class: mark.via.browser.c1
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f9049a.k9(str);
                }
            }).P(R.string.cancel, null).h0();
            return;
        }
        if (list.size() == 1) {
            this.f9485o0.j1((String) list.get(0), true);
        } else {
            q5.k.l(G()).f0(w7.u.I3).K(str).G((String[]) list.toArray(new String[0]), new AdapterView.OnItemClickListener() { // from class: mark.via.browser.d1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    this.f9073a.f9485o0.j1((String) list.get(i10), true);
                }
            }).X(w7.u.f14242t9, new q5.k.m() { // from class: mark.via.browser.e1
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    q4.i3(this.f9099a, list, view, pVar);
                }
            }).P(R.string.cancel, null).h0();
        }
    }

    public final int p7() {
        ViewGroup viewGroup = this.B0;
        int iMin = viewGroup == null ? 0 : Math.min(viewGroup.getMeasuredWidth(), this.B0.getMeasuredHeight());
        if (iMin == 0) {
            iMin = com.tuyafeng.support.utils.x.p(G());
        }
        return (!this.Z0 || this.W0 == 0) ? iMin : Math.min(iMin - com.tuyafeng.support.utils.x.h(G(), 96.0f), com.tuyafeng.support.utils.x.h(G(), 384.0f));
    }

    public final void p8(final ta.y yVar) {
        final t4.b bVarH = H();
        if (bVarH == null) {
            return;
        }
        bVarH.evaluateJavascript(c6.b2.f1963a.m(this.R0.d()), new ValueCallback() { // from class: mark.via.browser.z2
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                q4.s3(yVar, (String) obj);
            }
        });
        yVar.o3(new ta.y.a() { // from class: mark.via.browser.a3
            @Override // ta.y.a
            public final void a(String str, String str2) {
                q4.v4(this.f8997a, bVarH, str, str2);
            }
        });
    }

    public final void p9(final String str, final String str2) {
        if (!p.a0.e(G())) {
            com.tuyafeng.support.utils.n.q(G(), w7.u.Ng);
        } else if (Build.VERSION.SDK_INT >= 26) {
            z7.u1.x3(str, str2).g3(x0(), null);
        } else {
            ((autodispose2.n) r6.j.v(new Callable() { // from class: mark.via.browser.b0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Integer.valueOf(u8.e.e(this.f9023c.G()));
                }
            }).G(a7.a.c()).C(q6.b.b()).L(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.browser.c0
                @Override // u6.f
                public final void accept(Object obj) {
                    q4.l4(this.f9046c, str, str2, (Integer) obj);
                }
            }, new w7.a0());
        }
    }

    @Override // c8.b1.a
    public void q(String str) {
        new x8.o2(this).l(str);
    }

    public final com.tuyafeng.support.widget.e0 q7() {
        if (this.K1 == null) {
            com.tuyafeng.support.widget.e0 e0Var = (com.tuyafeng.support.widget.e0) new b6.a(new com.tuyafeng.support.widget.e0(G()), new RelativeLayout.LayoutParams(-1, -2)).o(com.tuyafeng.support.utils.x.l()).V(new b6.a.InterfaceC0033a() { // from class: mark.via.browser.u1
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    ((com.tuyafeng.support.widget.e0) obj).setTitle(this.f9679a.X0(w7.u.Ah));
                }
            }).l();
            Bundle bundleW0 = w0();
            if (bundleW0 != null) {
                Bitmap bitmap = (Bitmap) com.tuyafeng.support.utils.d.a(bundleW0, "android.support.customtabs.extra.CLOSE_BUTTON_ICON", Bitmap.class);
                e0Var.m(bitmap != null ? new BitmapDrawable(R0(), bitmap) : lb.g.a(G(), w7.o.f13846y, w7.u.je), X0(w7.u.O8), new View.OnClickListener() { // from class: mark.via.browser.v1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f9701a.i0().finish();
                    }
                });
                Bundle bundle = bundleW0.getBundle("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE");
                if (bundle != null) {
                    Bitmap bitmap2 = (Bitmap) com.tuyafeng.support.utils.d.a(bundle, "android.support.customtabs.customaction.ICON", Bitmap.class);
                    String string = bundle.getString("android.support.customtabs.customaction.DESCRIPTION");
                    final PendingIntent pendingIntent = (PendingIntent) com.tuyafeng.support.utils.d.a(bundle, "android.support.customtabs.customaction.PENDING_INTENT", PendingIntent.class);
                    e0Var.c(new com.tuyafeng.support.widget.e0.b(2, 0, bitmap2 == null ? null : new BitmapDrawable(R0(), bitmap2), string), new View.OnClickListener() { // from class: mark.via.browser.w1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f9716a.n9(pendingIntent);
                        }
                    });
                } else {
                    e0Var.c(new com.tuyafeng.support.widget.e0.b(990, 0, lb.g.a(G(), w7.o.f13809l1, w7.u.Kf), X0(w7.u.f14037f0)), new View.OnClickListener() { // from class: mark.via.browser.x1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            q4.e5(this.f9744a, view);
                        }
                    });
                }
                e0Var.c(new com.tuyafeng.support.widget.e0.b(991, 0, lb.g.a(G(), w7.o.I0, w7.u.tf), X0(w7.u.H8)), new View.OnClickListener() { // from class: mark.via.browser.y1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f9772a.B9(view);
                    }
                });
            }
            this.K1 = e0Var;
        }
        return this.K1;
    }

    public final void q8(d8.w wVar) {
        final WeakReference weakReference = new WeakReference(wVar);
        ReadModeController readModeController = this.f9481k1;
        if (readModeController != null) {
            readModeController.o(new i8.o() { // from class: mark.via.browser.c3
                @Override // i8.o
                public final void a(Object obj) {
                    q4.M3(weakReference, (Integer) obj);
                }
            });
        }
        wVar.i3(new f());
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.fragment.app.Fragment, mark.via.browser.q4] */
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
    /* JADX WARN: Type inference failed for: r6v23, types: [u9.l] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void q9(int i10, boolean z10) {
        boolean z11;
        d9();
        tc.a.a("try to set ui mode: %d, tab bar enabled: %s, orientation: %d", Integer.valueOf(i10), Boolean.valueOf(z10), Integer.valueOf(this.f9508z1));
        int i11 = i10;
        if (i10 < 0 || i10 > 4) {
            i11 = -1;
        }
        ?? r11 = i11;
        if (this.f9486o1) {
            r11 = 4;
            z10 = false;
        }
        if (r11 == -1) {
            r11 = this.Z0;
            this.f9487p0.k(r11);
        }
        if (r11 == 0 || r11 == 3) {
            r11 = r11;
            if (this.f9508z1 == 2) {
                r11 = r11 == 3 ? 2 : 1;
            }
            z10 = false;
        }
        if (this.W0 == r11 && z10 == this.f9472b1) {
            ea(r11);
            return;
        }
        D7();
        int i12 = this.W0;
        if (i12 == -1) {
            z11 = true;
        } else {
            if ((i12 == 0) != (r11 == 0)) {
                z11 = true;
            } else {
                if ((i12 == 3) != (r11 == 3)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
        }
        this.A0.removeAllViews();
        this.f9505y0.removeAllViews();
        S6(z10);
        if (z11) {
            ea(r11);
        }
        if (r11 == 0) {
            this.A0.addView(this.f9507z0);
            mark.via.common.widget.t tVar = this.C0;
            if (tVar != null) {
                this.A0.addView(tVar);
            }
            this.f9505y0.addView(this.f9501w0);
        } else if (r11 == 1 || r11 == 2) {
            if (r11 == 1) {
                this.A0.addView(this.f9501w0);
                mark.via.common.widget.t tVar2 = this.C0;
                if (tVar2 != null) {
                    this.A0.addView(tVar2);
                }
            } else {
                mark.via.common.widget.t tVar3 = this.C0;
                if (tVar3 != null) {
                    this.f9505y0.addView(tVar3);
                }
                this.f9505y0.addView(this.f9501w0);
            }
        } else if (r11 == 3) {
            this.f9505y0.addView(this.f9507z0);
            this.f9505y0.addView(this.f9501w0);
        } else if (r11 == 4) {
            this.A0.addView(q7());
        }
        int iD = com.tuyafeng.support.utils.f.d(G(), w7.n.f13772y);
        int iD2 = com.tuyafeng.support.utils.f.d(G(), w7.n.H) + (z10 ? iD : 0);
        int iD3 = com.tuyafeng.support.utils.f.d(G(), w7.n.f13749b);
        ViewGroup.LayoutParams layoutParams = this.A0.getLayoutParams();
        layoutParams.height = (r11 == 2 || r11 == 3) ? 0 : iD2;
        this.A0.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f9505y0.getLayoutParams();
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
        this.f9505y0.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f9495t0.getLayoutParams();
        boolean z12 = this.A0.getChildCount() > 0;
        layoutParams3.addRule(3, z12 ? this.A0.getId() : 0);
        layoutParams3.addRule(2, z12 ? 0 : this.f9505y0.getId());
        this.f9495t0.setLayoutParams(layoutParams3);
        ga(r11);
        if (this.f9490q1 && this.X0 == 1) {
            this.f9493s0.setTranslationY((r11 == 2 || r11 == 3) ? 0.0f : iD2);
        }
        this.W0 = r11;
        this.f9472b1 = z10;
        Y8();
    }

    @Override // c8.g1.a
    public void r(t4.b bVar) {
        if (bVar == null && this.f9493s0.getChildCount() == 0) {
            return;
        }
        if (this.f9493s0.getChildCount() == 1 && this.f9493s0.getChildAt(0) == bVar) {
            return;
        }
        this.E0.C();
        this.f9493s0.removeAllViews();
        if (bVar == null) {
            return;
        }
        bVar.setFocusable(true);
        this.f9493s0.addView(bVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void r1(int i10, int i11, Intent intent) {
        if (i10 != 911) {
            if (i10 == 111) {
                d8(new ActivityResult(i11, intent));
            }
        } else {
            if (intent == null || !intent.hasExtra("data")) {
                return;
            }
            final String stringExtra = intent.getStringExtra("data");
            q5.k.l(G()).f0(w7.u.I3).K(stringExtra).v(false).X(R.string.ok, new q5.k.m() { // from class: mark.via.browser.u2
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f9680a.k9(stringExtra);
                }
            }).P(R.string.cancel, null).T(R.string.copy, new View.OnClickListener() { // from class: mark.via.browser.v2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q4 q4Var = this.f9702a;
                    com.tuyafeng.support.utils.n.b(q4Var.G(), stringExtra, q4Var.R0().getString(w7.u.Eg));
                }
            }).h0();
        }
    }

    public final String r7(WebView webView) {
        StringBuilder sb2 = new StringBuilder();
        if (q9.s()) {
            sb2.append(sd.b(G(), this.f9476f1));
        }
        int iK0 = this.f9485o0.K0(webView.getUrl());
        if (iK0 == 2) {
            sb2.append(t8.b(G()));
        } else if (iK0 != 3) {
            sb2.append(t8.c(G()));
        } else {
            sb2.append(t8.a(G()));
        }
        sb2.append(u8.b(G(), this.f9476f1));
        sb2.append(mark.via.browser.d.b(G(), this.f9476f1));
        if (this.f9487p0.n2().E()) {
            sb2.append("javascript:(function(){var e=window;try{delete e.RTCPeerConnection,delete e.webkitRTCPeerConnection,delete e.mozRTCPeerConnection}catch(e){}})();");
        }
        if (!this.f9487p0.n2().D()) {
            sb2.append("(function(){var i=\"via-fake-vibrate\";if(!window[i])try{window[i]=!0;var n=function(i){return!0}.bind(window);window.navigator.vibrate=n}catch(i){}})();");
        }
        return sb2.toString();
    }

    public final void r8(d8.l0 l0Var) {
        p4.a aVar = this.M0;
        if (aVar == null) {
            return;
        }
        l0Var.q3(aVar.c(), this.M0.l());
        l0Var.p3(new i());
    }

    @Override // c8.g1.a
    public void s(String str, String str2, SslCertificate sslCertificate) {
        if (str2 != null) {
            int length = str2.length();
            str2 = x8.r2.f(str2);
            if (length != str2.length()) {
                str = x8.z.D(str2);
            }
        }
        if (s9.d.l(G(), str2)) {
            this.f9507z0.setTitle(str);
        } else {
            if (this.f9487p0.i1() != 0 || this.f9472b1) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = X0(w7.u.Ah);
            }
            this.f9507z0.setTitle(x8.z.F(str, str2));
        }
    }

    public final String s7() {
        r4.a aVarD = this.M0.d();
        if (aVarD == null) {
            return null;
        }
        return aVarD.getTitle();
    }

    public void s8(boolean z10) {
        if (this.f9487p0.O1()) {
            s9(true);
        }
    }

    public final void s9(boolean z10) {
        tc.a.a("set fullscreen: %s", Boolean.valueOf(z10));
        x8.h3.q(i0().getWindow(), z10);
        if (z10) {
            return;
        }
        this.B0.setPadding(0, 0, 0, 0);
        this.A0.setPadding(0, 0, 0, 0);
        this.f9505y0.setPadding(0, 0, 0, 0);
        this.f9501w0.setPadding(0, 0, 0, 0);
    }

    @Override // mark.via.browser.r8
    public boolean t(String str) {
        return g0(H(), str);
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        L0().l(this);
        i0().h().h(this, this.f9488p1);
        x0().l(new androidx.fragment.app.h0() { // from class: mark.via.browser.g2
            @Override // androidx.fragment.app.h0
            public final void V(FragmentManager fragmentManager, Fragment fragment) {
                q4.c5(this.f9150c, fragmentManager, fragment);
            }
        });
        G().registerComponentCallbacks(this);
    }

    public final String t7(String str) {
        return x8.z.F(s7(), str);
    }

    public final int t8(t4.b bVar, final String str) {
        final Intent intentG;
        String str2;
        String strA;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (scheme == null) {
            return 0;
        }
        String lowerCase = scheme.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        switch (lowerCase) {
            case "view-source":
            case "ftp":
            case "data":
            case "file":
            case "http":
            case "about":
            case "https":
            case "javascript":
                return 0;
            case "mailto":
                MailTo mailTo = MailTo.parse("mailto:" + str.substring(scheme.length() + 1));
                intentG = x8.e1.g(mailTo.getTo(), mailTo.getSubject(), mailTo.getBody(), mailTo.getCc());
                break;
            case "tg":
                if (str.startsWith("//", scheme.length() + 1)) {
                    str2 = str;
                } else {
                    str2 = "tg://" + str.substring(scheme.length() + 1);
                }
                intentG = x8.e1.c(G(), str2);
                break;
            case "sms":
            case "tel":
                intentG = new Intent("android.intent.action.VIEW", uri);
                break;
            default:
                intentG = x8.e1.c(G(), str);
                break;
        }
        if (intentG == null) {
            return 2;
        }
        int iQ0 = this.f9485o0.Q0(bVar == null ? u7() : bVar.getUrl());
        if (iQ0 == 2 || !W7() || (strA = x8.e1.a(G(), intentG)) == null) {
            return 2;
        }
        if (iQ0 == 1) {
            return S9(intentG) ? 1 : 2;
        }
        new a6.h.b(i0()).h(strA.isEmpty() ? X0(w7.u.N8) : Y0(w7.u.f13982b1, strA)).b(R.string.ok).e(new View.OnClickListener() { // from class: mark.via.browser.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9676a.S9(intentG);
            }
        }).f(new View.OnLongClickListener() { // from class: mark.via.browser.v
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return q4.w4(this.f9697a, str, intentG, view);
            }
        }).a().s();
        return 1;
    }

    public final void t9(boolean z10) {
        if (this.f9482l1 == z10) {
            return;
        }
        this.f9482l1 = z10;
        this.f9487p0.U(z10);
        ca(u7());
        if (z10) {
            s9(true);
            da();
            G7();
        } else {
            K9();
            s9(this.f9487p0.O1());
            this.f9493s0.postDelayed(new Runnable() { // from class: mark.via.browser.m3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9337c.da();
                }
            }, 200L);
        }
        com.tuyafeng.support.utils.n.s(G(), z10 ? X0(w7.u.f14029e6) : Y0(w7.u.f14226s7, X0(w7.u.f14001c6)));
        X9();
    }

    public final String u7() {
        r4.a aVarD = this.M0.d();
        if (aVarD == null) {
            return null;
        }
        return aVarD.getUrl();
    }

    public final void u8() {
        X7();
        z7.k.q3().g3(x0(), z7.k.class.getSimpleName());
    }

    public final void u9() {
        boolean zS = this.f9487p0.n2().s();
        boolean z10 = zS && (i() > 1 || M6() || N6());
        if (!zS) {
            g7();
        } else if (z10) {
            q5.k.l(G()).f0(w7.u.fg).J(w7.u.f14059g8).X(w7.u.f14120l, new q5.k.m() { // from class: mark.via.browser.f4
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    this.f9129a.X6(false);
                }
            }).P(w7.u.K, new View.OnClickListener() { // from class: mark.via.browser.g4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f9152a.X6(true);
                }
            }).h0();
        } else {
            X6(true);
        }
    }

    public final c6.f v7() {
        t4.b bVarH = H();
        if (bVarH == null) {
            return null;
        }
        return new c6.f(bVarH);
    }

    public final void v8(final String str, final String str2) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return q4.d5(str, str2);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this))).a(new u6.f() { // from class: mark.via.browser.z
            @Override // u6.f
            public final void accept(Object obj) {
                q4.x3(this.f9801c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public final void v9(float f10) {
        float f11 = 0.0f;
        this.f9492r1 = this.X0 == 1 ? Math.max(0.0f, Math.min(1.0f, f10)) : 0.0f;
        int height = this.A0.getHeight();
        int height2 = this.f9505y0.getHeight();
        FrameLayout frameLayout = this.f9493s0;
        if (this.X0 == 1) {
            f11 = height * (1.0f - this.f9492r1);
        }
        frameLayout.setTranslationY(f11);
        b9();
        this.A0.setTranslationY((-this.f9492r1) * height);
        float f12 = height2;
        this.f9505y0.setTranslationY(this.f9492r1 * f12);
        ProgressBar progressBar = this.f9495t0;
        float f13 = this.f9492r1;
        if (this.A0.getChildCount() > 0) {
            height2 = -height;
        }
        progressBar.setTranslationY(f13 * height2);
        mark.via.common.widget.m mVar = this.D0;
        if (mVar != null) {
            mVar.setTranslationY(this.f9492r1 * f12);
        }
        this.E0.L(this.f9492r1 * f12);
        this.f9489q0.f9815o.setTranslationY(this.f9492r1 * o7());
    }

    @Override // androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        la.s.b(G()).f().a(this).a(this);
        this.f9480j1 = new ReadAloudController(this, this.f9487p0);
        this.f9481k1 = new ReadModeController(this, this.f9487p0, new a0(this), new l());
        this.P0 = new DownloadController(this, this.f9487p0, new a0(this), new x.h() { // from class: mark.via.browser.z1
            @Override // x.h
            public final Object get() {
                return this.f9803a.f9476f1;
            }
        }, new h.a() { // from class: mark.via.browser.a2
            @Override // h.a
            public final Object apply(Object obj) {
                return q4.I3(this.f8996a, (String) obj);
            }
        }, new Runnable() { // from class: mark.via.browser.b2
            @Override // java.lang.Runnable
            public final void run() {
                this.f9026c.A8();
            }
        });
        for (Fragment fragment : x0().A0()) {
            if (fragment instanceof mark.via.download.w) {
                ((mark.via.download.w) fragment).s3(this.P0);
            }
        }
        this.S0 = new PageImageActions(this, this.f9485o0, this.f9487p0, new x.h() { // from class: mark.via.browser.c2
            @Override // x.h
            public final Object get() {
                return this.f9051a.d();
            }
        }, new x.h() { // from class: mark.via.browser.d2
            @Override // x.h
            public final Object get() {
                return this.f9075a.f9476f1;
            }
        });
        boolean z10 = false;
        if (w0() != null && w0().getBoolean("CUSTOM_TAB", false)) {
            z10 = true;
        }
        this.f9486o1 = z10;
        x0().m(new FragmentManager.m() { // from class: mark.via.browser.e2
            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void a(androidx.activity.b bVar) {
                androidx.fragment.app.e0.c(this, bVar);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void d(Fragment fragment2, boolean z11) {
                androidx.fragment.app.e0.b(this, fragment2, z11);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void h(Fragment fragment2, boolean z11) {
                androidx.fragment.app.e0.d(this, fragment2, z11);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public /* synthetic */ void k() {
                androidx.fragment.app.e0.a(this);
            }

            @Override // androidx.fragment.app.FragmentManager.m
            public final void onBackStackChanged() {
                this.f9101c.X9();
            }
        });
    }

    public final void w7() {
        r4.a aVarD = this.M0.d();
        if (D7() || aVarD == null) {
            return;
        }
        if (aVarD.i()) {
            if (aVarD.p()) {
                aVarD.r();
            }
            aVarD.e();
        } else {
            if (s9.d.n(G(), aVarD.getUrl())) {
                return;
            }
            this.f9485o0.C0();
        }
    }

    public final void w8(String str) {
        X7();
        z7.k.r3(str).g3(x0(), z7.k.class.getSimpleName());
    }

    public final void w9(final boolean z10) {
        int iV;
        final String strU7 = u7();
        c6.a2 a2Var = c6.a2.f1958a;
        final String strF = a2Var.f(strU7);
        final z9.d dVarK = la.s.k();
        y9.b bVarD = (z10 || !a2Var.t(strU7) || s9.d.l(G(), strU7)) ? null : dVarK.d(strF, true);
        final y9.a aVarC = (bVarD == null || !bVarD.s()) ? null : y9.c.c(bVarD);
        final List listE = x8.c4.e(G());
        if (z10) {
            for (int size = listE.size() - 1; size >= 0; size--) {
                int iD = ((ga.c) listE.get(size)).d();
                if (iD < 0 && !x8.c4.f(iD)) {
                    listE.remove(size);
                }
            }
        }
        if (aVarC != null) {
            listE.add(0, ga.c.l(-1000, Y0(w7.u.f14096j3, x8.c4.d(G(), this.f9487p0.o0())), null));
            String strC = aVarC.c(null);
            if (!TextUtils.isEmpty(strC)) {
                listE.add(ga.c.l(-999, X0(w7.u.J0), strC));
            }
        }
        if (aVarC != null) {
            iV = aVarC.j();
        } else {
            u9.l lVar = this.f9487p0;
            iV = z10 ? lVar.V() : lVar.o0();
        }
        int size2 = listE.size();
        final String[] strArr = new String[size2];
        int size3 = -1;
        for (int i10 = 0; i10 < size2; i10++) {
            strArr[i10] = ((ga.c) listE.get(i10)).g();
            if (iV == ((ga.c) listE.get(i10)).d()) {
                size3 = i10;
            }
        }
        if (size3 < 0 && aVarC != null && iV > 0 && !TextUtils.isEmpty(aVarC.c(null))) {
            size3 = listE.size() - 1;
        }
        final int i11 = iV;
        q5.k.l(G()).g0(aVarC != null ? Y0(w7.u.Rh, strF) : X0(z10 ? w7.u.Sh : w7.u.F0)).d0(strArr, size3, new AdapterView.OnItemClickListener() { // from class: mark.via.browser.q
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i12, long j10) {
                q4.B3(this.f9454a, listE, i11, aVarC, dVarK, strF, z10, strU7, strArr, adapterView, view, i12, j10);
            }
        }).h0();
    }

    @Override // c8.i.a
    public void x(o4.a aVar, String str) {
        int iZ7;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iA = aVar.a();
        if (iA != c8.i.f2218f) {
            if (iA == c8.i.f2219g) {
                H().k();
                F9(str);
                return;
            }
            return;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty() || (iZ7 = z7(H(), strTrim)) == 1) {
            return;
        }
        String strB1 = this.f9487p0.b1();
        if (iZ7 == 0) {
            c6.a2 a2Var = c6.a2.f1958a;
            if (a2Var.u(strTrim)) {
                I8(a2Var.w(strTrim, strB1), true);
                return;
            }
        }
        j9(strTrim, strB1, this.f9487p0.T2(), true);
    }

    public final void x7() {
        r4.a aVarD = this.M0.d();
        if (D7() || aVarD == null) {
            return;
        }
        if (!aVarD.m()) {
            this.f9485o0.V0();
            return;
        }
        if (aVarD.p()) {
            aVarD.r();
        }
        aVarD.k();
        this.f9485o0.t0();
    }

    public final void x8(final String str) {
        ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return s5.a.f(la.s.d().h(str));
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(this))).a(new u6.f() { // from class: mark.via.browser.e0
            @Override // u6.f
            public final void accept(Object obj) {
                q4.h4(this.f9098c, (s5.a) obj);
            }
        }, new w7.e0());
    }

    public final void x9(boolean z10) {
        if (a1() == null) {
            return;
        }
        if (!this.f9482l1 && z10) {
            ((autodispose2.r) r6.q.f(new Callable() { // from class: mark.via.browser.s1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return q4.q4(this.f9634c);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.browser.t1
                @Override // u6.f
                public final void accept(Object obj) {
                    q4.Y3(this.f9660c, (List) obj);
                }
            }, new w7.e0());
        } else if (this.D0 != null) {
            ca(null);
            this.D0 = null;
        }
    }

    @Override // c8.i.a
    public b8.e y() {
        if (this.L0 == null) {
            this.L0 = new t(this, null);
        }
        return this.L0;
    }

    public final boolean y7(ClipData clipData) {
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
            } else if (itemAt.getHtmlText() != null) {
                string = Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(itemAt.getHtmlText(), 0).toString() : Html.fromHtml(itemAt.getHtmlText()).toString();
            }
            if (string != null && string.length() > 0) {
                break;
            }
        }
        if (string != null && string.length() != 0) {
            String string2 = string.toString();
            List listE = c6.y1.f2139a.e(string2);
            if (listE.size() == 1) {
                M8((String) listE.get(0));
            } else {
                M8(string2);
            }
        }
        return true;
    }

    public final void y8(String str) {
        X7();
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                cb.f0.S3(strTrim);
            }
        }
        FragmentUtils.k(this, bb.i.class, bb.i.m3(true, 1), "RecordContainerFragment");
    }

    public final boolean y9(String str) {
        return g1() && W7() && !A7() && !T7() && !this.f9482l1 && !this.f9486o1 && i() <= 1 && s9.d.n(G(), str);
    }

    @Override // c8.g1.a
    public void z(int i10) {
        int i11 = i10 + 20;
        this.f9489q0.setProgress(i11);
        if (i11 >= 100) {
            this.f9507z0.s(false, s9.d.n(G(), u7()));
        } else {
            this.f9507z0.s(true, false);
        }
    }

    public final int z7(t4.b bVar, String str) {
        Object obj;
        Object obj2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.length() >= 6 && "via://".equalsIgnoreCase(str.substring(0, 6))) {
            str = "v://" + str.substring(6);
        }
        if (x8.r2.r(str)) {
            String strSubstring = str.substring(9);
            int iC = s9.d.c(G(), u7());
            if (iC == 2 || iC == 11) {
                this.f9485o0.t1(strSubstring.isEmpty() ? 2 : 11, strSubstring);
            } else {
                x8(Uri.decode(strSubstring));
            }
            return 1;
        }
        if (x8.r2.s(str)) {
            this.f9485o0.t1(3, null);
            return 1;
        }
        if (!x8.r2.x(str)) {
            if (str.startsWith("thunder://") || str.startsWith("qqdl://") || str.startsWith("flashget://")) {
                String strC = x8.z.C(str);
                if (!TextUtils.isEmpty(strC)) {
                    this.P0.K(new mark.via.download.o.b().j(strC).k(this.f9487p0.L1()).c("attachment").d(-1L).b());
                }
                return 1;
            }
            if (str.startsWith("baidubox://") || str.startsWith("baiduboxapp://") || str.startsWith("baiduboxlite://")) {
                return 2;
            }
            if (Build.VERSION.SDK_INT < 21 || !str.startsWith("file://") || !"pdf".equals(c6.a2.f1958a.d(str))) {
                return t8(bVar, str);
            }
            FragmentUtils.j(this, za.g.class, p5.a.b().e("pdfPath", str).a());
            return 1;
        }
        if (x8.r2.m(str)) {
            final String strB = x8.r2.b(str);
            c6.a2 a2Var = c6.a2.f1958a;
            if (a2Var.t(strB)) {
                this.f9485o0.n0(a2Var.g(strB));
                this.B0.post(new Runnable() { // from class: mark.via.browser.w2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f9718c.Y7(strB);
                    }
                });
            }
            return 1;
        }
        if (x8.r2.p(str)) {
            final String strF = x8.r2.f(str);
            if (!TextUtils.isEmpty(strF) && !c6.a2.f1958a.q(strF)) {
                this.B0.post(new Runnable() { // from class: mark.via.browser.x2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f9745c.Y7(strF);
                    }
                });
            }
            return 1;
        }
        if (x8.r2.u(str)) {
            E8();
            return 1;
        }
        if (x8.r2.w(str)) {
            FragmentUtils.i(this, lb.p.class);
            return 1;
        }
        if (x8.r2.v(str)) {
            String strK = x8.r2.k(str);
            if (strK == null || strK.isEmpty()) {
                L8();
            } else {
                m9(strK, true);
            }
            return 1;
        }
        if (x8.r2.q(str)) {
            if (s9.d.c(G(), u7()) == 5) {
                this.f9485o0.t1(3, null);
            } else {
                D8();
            }
            return 1;
        }
        if (x8.r2.o(str)) {
            A8();
            return 1;
        }
        if (x8.r2.t(str)) {
            this.f9480j1.u();
            return 1;
        }
        if (!x8.r2.n(str)) {
            if (!x8.r2.y(str)) {
                int iIntValue = ((Integer) x8.z.P(str).f14455a).intValue();
                if (iIntValue != 1) {
                    this.f9485o0.t1(iIntValue, null);
                } else {
                    this.f9485o0.W0();
                }
                return 1;
            }
            x.d dVarJ = x8.r2.j(str);
            if (dVarJ != null && (obj = dVarJ.f14455a) != null && ((String[]) obj).length > 0) {
                this.f9485o0.G1((String[]) obj, (String) dVarJ.f14456b);
            }
            return 1;
        }
        x.d dVarH = x8.r2.h(str);
        int iC2 = s9.d.c(G(), u7());
        if (iC2 == 2 || iC2 == 11 || iC2 == 5) {
            this.f9485o0.t1(com.tuyafeng.support.utils.p.f((String) dVarH.f14455a) ? 2 : 11, (String) dVarH.f14455a);
        } else if (iC2 != 1 || (obj2 = dVarH.f14455a) == null) {
            y8((String) dVarH.f14455a);
        } else if (((String) obj2).isEmpty()) {
            w8("");
        } else {
            v8((String) dVarH.f14455a, (String) dVarH.f14456b);
        }
        return 1;
    }

    public final void z8() {
        String strQ0;
        if (x8.a0.i() && ((strQ0 = this.f9487p0.q0()) == null || strQ0.isEmpty())) {
            FragmentUtils.i(this, y8.o.class);
            return;
        }
        x0().z1("result", b1(), new androidx.fragment.app.i0() { // from class: mark.via.browser.p1
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                q4.N4(this.f9406a, str, bundle);
            }
        });
        final int i10 = (this.W0 == 1 ? 48 : 80) | 8388613;
        t4.b bVarH = H();
        final String strU7 = u7();
        final String strZ = la.s.e().z(strU7);
        if (bVarH == null || !bVarH.getSettings().getJavaScriptEnabled() || !c6.a2.f1958a.t(strU7)) {
            z8.g.s3(strZ, i10).g3(x0(), null);
        } else {
            final String strS7 = s7();
            c6.g1.f2009a.k(new c6.f(bVarH), new p7.l() { // from class: mark.via.browser.q1
                @Override // p7.l
                public final Object invoke(Object obj) {
                    return q4.t3(this.f9464c, strZ, strU7, strS7, i10, (String) obj);
                }
            });
        }
    }

    public final void z9(a8.n nVar) {
        L0().z1("bookmarkDialogResult2", this, new androidx.fragment.app.i0() { // from class: mark.via.browser.d3
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                q4.J3(this.f9076a, str, bundle);
            }
        });
        nVar.g3(x0(), a8.n.class.getSimpleName());
    }
}
