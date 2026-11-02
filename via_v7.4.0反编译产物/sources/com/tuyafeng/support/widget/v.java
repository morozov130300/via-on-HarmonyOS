package com.tuyafeng.support.widget;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Icon;
import android.media.AudioManager;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import x.k0;
import z8.g2;
import z8.l3;
import z8.n3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v extends FrameLayout {
    public static final float[] V = {5.0f, 3.0f, 2.0f, 1.5f, 1.25f, 1.0f, 0.75f, 0.5f};
    public final w9.l A;
    public final boolean B;
    public final boolean C;
    public int D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public final Runnable U;

    /* renamed from: e, reason: collision with root package name */
    public final View f4354e;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f4355j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f4356k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f4357l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f4358m;

    /* renamed from: n, reason: collision with root package name */
    public final FrameLayout f4359n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f4360o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f4361p;

    /* renamed from: q, reason: collision with root package name */
    public int f4362q;

    /* renamed from: r, reason: collision with root package name */
    public final AudioManager f4363r;

    /* renamed from: s, reason: collision with root package name */
    public final int f4364s;

    /* renamed from: t, reason: collision with root package name */
    public int f4365t;

    /* renamed from: u, reason: collision with root package name */
    public float f4366u;

    /* renamed from: v, reason: collision with root package name */
    public final int f4367v;

    /* renamed from: w, reason: collision with root package name */
    public b f4368w;

    /* renamed from: x, reason: collision with root package name */
    public float f4369x;

    /* renamed from: y, reason: collision with root package name */
    public int f4370y;

    /* renamed from: z, reason: collision with root package name */
    public float f4371z;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            if (v.this.f4368w != null) {
                v.this.f4371z = v.V[i10];
                v.this.f4368w.c(v.this.f4371z);
                v.this.f4360o.setText(String.format(Locale.ROOT, "%sX", Float.valueOf(v.this.f4371z)));
                v.this.J();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(ValueCallback valueCallback);

        void b(int i10);

        void c(float f10);

        float d();

        float getDuration();
    }

    public v(Context context) {
        this(context, null, 0);
    }

    public v(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4362q = 0;
        this.f4366u = -1.0f;
        this.f4371z = 1.0f;
        this.D = -1;
        this.U = new Runnable() { // from class: com.tuyafeng.support.widget.q
            @Override // java.lang.Runnable
            public final void run() {
                v.k(this.f4349e);
            }
        };
        boolean zE = g2.e(context);
        this.B = zE;
        this.C = n3.a(context);
        w9.l lVarJ = pa.r.j();
        this.A = lVarJ;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.f4363r = audioManager;
        this.f4364s = audioManager.getStreamMaxVolume(3);
        this.f4367v = 12;
        int iO0 = lVarJ.o0();
        this.M = iO0 == 1 || iO0 == 2;
        this.L = iO0 == 1;
        this.N = iO0 == 3;
        LayoutInflater.from(context).inflate(x7.r.D, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(x7.p.H1);
        this.f4355j = textView;
        View viewFindViewById = findViewById(x7.p.L1);
        this.f4354e = viewFindViewById;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1879048192, 0});
        gradientDrawable.setShape(0);
        g6.y.O(viewFindViewById, gradientDrawable);
        ImageView imageView = (ImageView) findViewById(x7.p.V);
        this.f4356k = imageView;
        g6.g gVarJ = new g6.g().c(g6.y.h(getContext(), 24.0f)).h(855638016).j(1711276032);
        g6.y.O(imageView, gVarJ.a());
        imageView.setImageDrawable(lb.b.a(context, x7.o.H1, x7.u.jf));
        ImageView imageView2 = (ImageView) findViewById(x7.p.f13796d0);
        this.f4357l = imageView2;
        g6.y.O(imageView2, gVarJ.a());
        imageView2.setImageDrawable(lb.b.a(context, x7.o.f13719d1, x7.u.gf));
        ImageView imageView3 = (ImageView) findViewById(x7.p.f13787a0);
        this.f4358m = imageView3;
        g6.y.O(imageView3, gVarJ.a());
        imageView3.setImageDrawable(lb.b.a(context, x7.o.N0, x7.u.ff));
        this.f4360o = (TextView) findViewById(x7.p.C1);
        FrameLayout frameLayout = (FrameLayout) findViewById(x7.p.G);
        this.f4359n = frameLayout;
        J();
        g6.y.O(frameLayout, gVarJ.a());
        ImageView imageView4 = (ImageView) findViewById(x7.p.f13805g0);
        int i11 = Build.VERSION.SDK_INT;
        imageView4.setImportantForAccessibility(2);
        imageView4.setImageDrawable(lb.b.a(context, x7.o.f13758q1, x7.u.hf));
        TextView textView2 = (TextView) findViewById(x7.p.f13839r1);
        this.f4361p = textView2;
        g6.y.O(textView2, new g6.g().c(g6.y.h(getContext(), 18.0f)).h(Integer.MIN_VALUE).a());
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.l(this.f4350a, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4351a.A();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.e(this.f4352a, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.g(this.f4353a, view);
            }
        });
        textView.setVisibility(8);
        viewFindViewById.setVisibility(8);
        frameLayout.setVisibility(8);
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
        if (zE && i11 >= 26) {
            I(2);
            addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tuyafeng.support.widget.j
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                    v.j(this.f4342a, view, i12, i13, i14, i15, i16, i17, i18, i19);
                }
            });
        }
        y();
    }

    public static /* synthetic */ void a(v vVar, AdapterView adapterView, View view, int i10, long j10) {
        vVar.getClass();
        vVar.M = i10 == 1 || i10 == 2;
        vVar.L = i10 == 1;
        vVar.N = i10 == 3;
        vVar.A.m(i10);
        vVar.H();
    }

    public static /* synthetic */ k0 d(v vVar, View view, k0 k0Var) {
        vVar.getClass();
        x.c cVarE = k0Var.e();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (cVarE != null && measuredWidth > 0 && measuredHeight > 0) {
            int iMax = 0;
            view.setPadding(0, 0, cVarE.d(), 0);
            List<Rect> listA = cVarE.a();
            int iH = g6.y.h(view.getContext(), 16.0f);
            for (Rect rect : listA) {
                int i10 = measuredHeight / 2;
                if (rect.contains(iH, i10)) {
                    iMax = Math.max(iMax, (rect.bottom - i10) + g6.y.h(vVar.getContext(), 32.0f));
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vVar.f4358m.getLayoutParams();
            layoutParams.topMargin = iMax;
            vVar.f4358m.setLayoutParams(layoutParams);
        }
        return k0Var;
    }

    public static /* synthetic */ void e(final v vVar, View view) {
        if (vVar.B) {
            if (!g2.c(vVar.getContext())) {
                g6.n.o(vVar.getContext(), x7.u.dg);
                return;
            }
            if (g2.a(vVar.getContext())) {
                vVar.setInPipMode(true);
                b bVar = vVar.f4368w;
                if (bVar != null) {
                    bVar.a(new ValueCallback() { // from class: com.tuyafeng.support.widget.p
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(Object obj) {
                            g2.f(this.f4348a.getContext(), ((Integer) obj).intValue());
                        }
                    });
                }
            }
        }
    }

    public static /* synthetic */ void g(final v vVar, View view) {
        vVar.t();
        w5.k.l(view.getContext()).B(g6.y.h(view.getContext(), 110.0f)).U(new DialogInterface.OnDismissListener() { // from class: com.tuyafeng.support.widget.l
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f4344e.F();
            }
        }).c0(new String[]{vVar.getContext().getString(x7.u.Q9), vVar.getContext().getString(x7.u.R9), vVar.getContext().getString(x7.u.S9), vVar.getContext().getString(x7.u.H5)}, vVar.A.o0(), new AdapterView.OnItemClickListener() { // from class: com.tuyafeng.support.widget.m
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                v.a(this.f4345a, adapterView, view2, i10, j10);
            }
        }).h0(view);
    }

    public static /* synthetic */ void j(v vVar, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        vVar.getClass();
        if (i10 == i14 && i12 == i16 && i11 == i15 && i13 == i17) {
            return;
        }
        Rect rect = new Rect();
        vVar.getGlobalVisibleRect(rect);
        Activity activityA = g6.f.a(vVar.getContext());
        if (activityA != null) {
            activityA.setPictureInPictureParams(new PictureInPictureParams.Builder().setSourceRectHint(rect).build());
        }
    }

    public static /* synthetic */ void k(v vVar) {
        if (vVar.isShown()) {
            vVar.x();
        }
    }

    public static /* synthetic */ void l(final v vVar, View view) {
        vVar.t();
        String[] strArr = new String[V.length];
        int i10 = -1;
        int i11 = 0;
        while (true) {
            float[] fArr = V;
            if (i11 >= fArr.length) {
                w5.k.l(view.getContext()).B(g6.y.h(view.getContext(), 78.0f)).U(new DialogInterface.OnDismissListener() { // from class: com.tuyafeng.support.widget.o
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f4347e.F();
                    }
                }).c0(strArr, i10, vVar.new a()).h0(view);
                return;
            }
            strArr[i11] = String.valueOf(fArr[i11]);
            if (fArr[i11] == vVar.f4371z) {
                i10 = i11;
            }
            i11++;
        }
    }

    public final void A() {
        t();
        boolean z10 = this.J;
        this.J = !z10;
        this.f4356k.setImageDrawable(!z10 ? lb.b.a(getContext(), x7.o.B0, x7.u.ef) : lb.b.a(getContext(), x7.o.H1, x7.u.jf));
        this.f4356k.setContentDescription(getContext().getString(this.J ? x7.u.Wg : x7.u.K7));
        F();
        H();
    }

    public final void B(float f10) {
        float f11 = this.f4366u + f10;
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        if (f11 < 0.01d) {
            f11 = 0.01f;
        }
        n3.j(getContext(), f11);
        int i10 = (int) (f11 * 100.0f);
        this.f4361p.setText(i10 + "%");
    }

    public final void C(float f10) {
        int iMin = (int) (f10 * Math.min(this.f4369x, 300.0f));
        this.f4370y = iMin;
        this.f4361p.setText(String.format("%s%02d:%02d", iMin >= 0 ? "+" : "-", Integer.valueOf(Math.abs(iMin / 60)), Integer.valueOf(Math.abs(this.f4370y % 60))));
    }

    public final void D(float f10) {
        float f11 = this.f4365t;
        int i10 = this.f4364s;
        float f12 = (f11 / i10) + f10;
        if (f12 < 0.0f) {
            f12 = 0.0f;
        }
        if (f12 > 1.0f) {
            f12 = 1.0f;
        }
        int i11 = (int) (i10 * f12);
        this.f4361p.setText(((int) (f12 * 100.0f)) + "%");
        this.f4363r.setStreamVolume(3, i11, 0);
    }

    public void E(int i10, int i11) {
        this.K = i10 > i11;
        H();
        g2.g(getContext(), i10, i11);
    }

    public final void F() {
        if (isShown()) {
            this.f4360o.removeCallbacks(this.U);
            this.f4360o.postDelayed(this.U, 3000L);
            v();
        }
    }

    public final void G(int i10) {
        Drawable drawableE;
        if (i10 != 0) {
            int iH = g6.y.h(this.f4361p.getContext(), 24.0f);
            drawableE = g6.f.e(this.f4361p.getContext(), i10);
            if (drawableE != null) {
                drawableE.setBounds(0, 0, iH, iH);
            }
        } else {
            drawableE = null;
        }
        androidx.core.widget.c.a(this.f4361p, drawableE, null, null, null);
        u(this.f4361p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H() {
        int iF;
        if (this.C && isShown()) {
            if (this.N) {
                n3.i(getContext(), this.D);
                return;
            }
            boolean z10 = this.M ? this.L : this.K;
            if (this.J) {
                iF = n3.f(getContext());
                if ((z10 == 0 || (iF != 0 && iF != 8)) && (z10 != 0 || (iF != 1 && iF != 8))) {
                    iF = !z10;
                }
            } else {
                iF = z10 != 0 ? 6 : 7;
            }
            n3.i(getContext(), iF);
        }
    }

    public final void I(int i10) {
        if (!this.B || Build.VERSION.SDK_INT < 26) {
            return;
        }
        Context context = getContext();
        if (i10 <= 0) {
            g6.f.a(context).setPictureInPictureParams(new PictureInPictureParams.Builder().setActions(Collections.EMPTY_LIST).build());
            return;
        }
        RemoteAction remoteAction = new RemoteAction(Icon.createWithResource(context, x7.o.f13716c1), context.getString(x7.u.f14136qb), context.getString(x7.u.f14136qb), PendingIntent.getBroadcast(context, 0, new Intent("mark.via.MEDIA_REWIND"), 201326592));
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("mark.via.MEDIA_PLAY"), 201326592);
        RemoteAction remoteAction2 = i10 == 1 ? new RemoteAction(Icon.createWithResource(context, x7.o.O0), context.getString(x7.u.O3), context.getString(x7.u.O3), broadcast) : new RemoteAction(Icon.createWithResource(context, x7.o.M0), context.getString(x7.u.N3), context.getString(x7.u.N3), broadcast);
        RemoteAction remoteAction3 = new RemoteAction(Icon.createWithResource(context, x7.o.Q), context.getString(x7.u.f14046k5), context.getString(x7.u.f14046k5), PendingIntent.getBroadcast(context, 0, new Intent("mark.via.MEDIA_FASTFORWARD"), 201326592));
        ArrayList arrayList = new ArrayList();
        arrayList.add(remoteAction);
        arrayList.add(remoteAction2);
        arrayList.add(remoteAction3);
        g6.f.a(context).setPictureInPictureParams(new PictureInPictureParams.Builder().setActions(arrayList).build());
    }

    public final void J() {
        this.f4359n.setContentDescription(getContext().getString(x7.u.f14200va, Float.valueOf(this.f4371z)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Q = (int) motionEvent.getX();
            this.R = (int) motionEvent.getY();
            int iH = g6.y.h(getContext(), 48.0f);
            int i11 = (iH * 3) / 2;
            int i12 = this.R;
            if (i12 < iH || i12 > getHeight() - i11 || (i10 = this.Q) < iH / 2 || i10 > getWidth() - iH) {
                this.f4362q = 1;
            } else {
                this.S = this.Q;
                this.T = this.R;
                this.f4362q = 0;
            }
        } else if (actionMasked == 1) {
            int i13 = this.f4362q;
            if (i13 == 3 || i13 == 2 || i13 == 4) {
                w(this.f4361p);
                if (this.f4362q == 4) {
                    s();
                }
            } else if (i13 == 0) {
                if (this.f4356k.getVisibility() == 0) {
                    t();
                    this.U.run();
                } else if (this.P) {
                    F();
                }
            }
            this.f4362q = 0;
        } else if (actionMasked == 2) {
            if (this.f4362q == 1) {
                return super.dispatchTouchEvent(motionEvent);
            }
            int x10 = ((int) motionEvent.getX()) - this.S;
            int y10 = ((int) motionEvent.getY()) - this.T;
            this.S = (int) motionEvent.getX();
            this.T = (int) motionEvent.getY();
            if (!this.J && this.f4362q == 0 && (Math.abs(x10) > this.f4367v || Math.abs(y10) > this.f4367v)) {
                double dAbs = Math.abs(y10);
                double dAbs2 = Math.abs(x10);
                Double.isNaN(dAbs2);
                if (dAbs > dAbs2 * 1.4d) {
                    int width = getWidth();
                    int i14 = this.Q;
                    if ((i14 < width / 3 && this.I) || (i14 > (width * 2) / 3 && this.H)) {
                        this.f4365t = this.f4363r.getStreamVolume(3);
                        this.f4366u = this.f4366u == -1.0f ? n3.d(getContext()) : n3.e(getContext());
                        boolean z10 = this.Q < getWidth() / 3;
                        this.f4362q = z10 ? 2 : 3;
                        G(z10 ? x7.o.f13780y : x7.o.K1);
                    }
                } else if (Math.abs(x10) <= Math.abs(y10) * 3) {
                    this.f4362q = 1;
                } else if (this.G) {
                    this.f4362q = 4;
                    G(0);
                }
            }
            int i15 = this.f4362q;
            if (i15 == 3 || i15 == 2 || i15 == 4) {
                if (i15 == 4) {
                    C((this.S - this.Q) / getWidth());
                } else {
                    float height = ((this.R - this.T) * 2.0f) / getHeight();
                    if (this.f4362q == 2) {
                        B(height);
                    } else {
                        D(height);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        n3.j(getContext(), -1.0f);
        this.f4366u = -1.0f;
        super.onDetachedFromWindow();
    }

    public final void s() {
        this.f4368w.b(this.f4370y);
        this.f4370y = 0;
    }

    public void setBrightnessGestureEnabled(boolean z10) {
        this.I = z10;
    }

    public void setControllerCallback(b bVar) {
        this.f4368w = bVar;
        if (bVar == null) {
            setProgressGestureEnabled(false);
            setSpeedAdjustable(false);
            return;
        }
        this.f4369x = bVar.getDuration();
        float fD = bVar.d();
        this.f4371z = fD;
        this.f4360o.setText(String.format(Locale.ROOT, "%sX", Float.valueOf(fD)));
        J();
        boolean z10 = this.f4369x > 0.0f;
        setSpeedAdjustable(this.F & z10);
        setProgressGestureEnabled(this.G & z10);
    }

    public void setInPipMode(boolean z10) {
        if (this.O == z10) {
            return;
        }
        this.O = z10;
        if (z10) {
            x();
        } else {
            v();
        }
    }

    public void setProgressGestureEnabled(boolean z10) {
        this.G = z10;
    }

    public void setSpeedAdjustable(boolean z10) {
        this.F = z10;
        if (z10 || this.f4359n.getVisibility() != 0) {
            return;
        }
        this.f4359n.setVisibility(8);
    }

    public void setSystemOrientation(int i10) {
        this.D = i10;
    }

    public void setTitle(String str) {
        boolean zF = g6.p.f(str);
        this.E = !zF;
        this.f4355j.setVisibility(!zF ? 8 : 0);
        this.f4355j.setText(str);
    }

    public void setToolbarEnabled(boolean z10) {
        t();
        x();
        this.P = z10;
    }

    public void setVolumeGestureEnabled(boolean z10) {
        this.H = z10;
    }

    public final void t() {
        this.f4360o.removeCallbacks(this.U);
    }

    public final void u(View view) {
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        view.setAlpha(0.0f);
        view.setVisibility(0);
        x.r.c(view).a(1.0f).e(x8.h.b()).d(150L).f();
    }

    public final void v() {
        u(this.f4356k);
        if (this.J) {
            w(this.f4355j);
            w(this.f4354e);
            w(this.f4359n);
            w(this.f4357l);
            w(this.f4358m);
            return;
        }
        if (this.E) {
            u(this.f4355j);
            u(this.f4354e);
        }
        if (this.F) {
            u(this.f4359n);
        }
        if (this.C) {
            u(this.f4357l);
        }
        if (this.B) {
            u(this.f4358m);
        }
    }

    public final void w(final View view) {
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        x.r.c(view).a(0.0f).i(new Runnable() { // from class: com.tuyafeng.support.widget.k
            @Override // java.lang.Runnable
            public final void run() {
                view.setVisibility(8);
            }
        }).e(x8.h.b()).d(150L).f();
    }

    public final void x() {
        View[] viewArr = {this.f4355j, this.f4354e, this.f4359n, this.f4357l, this.f4356k, this.f4358m};
        for (int i10 = 0; i10 < 6; i10++) {
            w(viewArr[i10]);
        }
    }

    public final void y() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(x7.p.f13862z0);
        if (relativeLayout == null) {
            return;
        }
        if (this.B) {
            x.r.d0(relativeLayout, new x.m() { // from class: com.tuyafeng.support.widget.n
                @Override // x.m
                public final k0 a(View view, k0 k0Var) {
                    return v.d(this.f4346a, view, k0Var);
                }
            });
        } else {
            l3.b(relativeLayout);
        }
    }

    public boolean z() {
        return this.O;
    }
}
