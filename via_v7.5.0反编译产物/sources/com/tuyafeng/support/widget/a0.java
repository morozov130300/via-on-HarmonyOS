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
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import mark.via.data.preference.VideoGesture;
import x8.f2;
import x8.j3;
import y.k0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a0 extends FrameLayout {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final float[] f3642g0 = {5.0f, 3.0f, 2.0f, 1.5f, 1.25f, 1.0f, 0.75f, 0.5f};
    public float A;
    public final int B;
    public b C;
    public float D;
    public int E;
    public float F;
    public final u9.l G;
    public final boolean H;
    public final boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f3643a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3644b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f3645c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f3646c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f3647d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f3648e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Runnable f3649e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Runnable f3650f0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f3651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f3652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageView f3653o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f3654p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final FrameLayout f3655q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f3656r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f3657s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f3658t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Runnable f3659u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f3660v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3661w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AudioManager f3662x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3663y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3664z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            if (a0.this.C != null) {
                a0.this.F = a0.f3642g0[i10];
                a0.this.C.c(a0.this.F);
                a0.this.f3656r.setText(String.format(Locale.ROOT, "%sX", Float.valueOf(a0.this.F)));
                a0.this.W();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(ValueCallback valueCallback);

        void b(int i10);

        void c(float f10);

        float d();

        Object e();

        Runnable f(float f10, float f11);

        float getDuration();
    }

    public a0(Context context) {
        this(context, null, 0);
    }

    public static /* synthetic */ void b(a0 a0Var, AdapterView adapterView, View view, int i10, long j10) {
        a0Var.getClass();
        a0Var.S = i10 == 1 || i10 == 2;
        a0Var.R = i10 == 1;
        a0Var.T = i10 == 3;
        a0Var.G.o(i10);
        a0Var.U();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0063  */
    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    public static /* synthetic */ k0 c(int i10, int i11, View view, View view2, k0 k0Var) {
        int iC;
        int iMax;
        int iD;
        ViewGroup.LayoutParams layoutParams;
        int i12;
        int i13;
        y.c cVarE = k0Var.e();
        if (cVarE != null && cVarE.c() > 0) {
            int height = view2.getHeight() / 2;
            int i14 = i11 + i10;
            Iterator it = cVarE.a().iterator();
            iMax = 0;
            while (true) {
                if (!it.hasNext()) {
                    iC = 0;
                    break;
                }
                Rect rect = (Rect) it.next();
                if (rect.left < cVarE.c() && (i12 = rect.bottom) > height - i14 && (i13 = rect.top) < height + i14) {
                    int iMax2 = Math.max(height - i13, i12 - height);
                    if (rect.height() > i10 || iMax2 + i14 > height) {
                        iC = cVarE.c();
                    } else {
                        iMax = Math.max(iMax, iMax2 * 2);
                    }
                }
            }
            if (cVarE == null) {
                iD = 0;
            } else {
                iD = cVarE.d();
            }
            view2.setPadding(iC, 0, iD, 0);
            layoutParams = view.getLayoutParams();
            if (layoutParams.height != iMax) {
                layoutParams.height = iMax;
                view.setLayoutParams(layoutParams);
            }
            return k0Var;
        }
        iC = 0;
        iMax = 0;
        if (cVarE == null) {
            iD = 0;
        } else {
            iD = cVarE.d();
        }
        view2.setPadding(iC, 0, iD, 0);
        layoutParams = view.getLayoutParams();
        if (layoutParams.height != iMax) {
            layoutParams.height = iMax;
            view.setLayoutParams(layoutParams);
        }
        return k0Var;
    }

    public static /* synthetic */ void f(final a0 a0Var, View view) {
        if (a0Var.H) {
            if (!f2.c(a0Var.getContext())) {
                com.tuyafeng.support.utils.n.o(a0Var.getContext(), w7.u.tg);
                return;
            }
            if (f2.a(a0Var.getContext())) {
                a0Var.setInPipMode(true);
                b bVar = a0Var.C;
                if (bVar != null) {
                    bVar.a(new ValueCallback() { // from class: com.tuyafeng.support.widget.u
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(Object obj) {
                            f2.f(this.f3773a.getContext(), ((Integer) obj).intValue());
                        }
                    });
                }
            }
        }
    }

    public static /* synthetic */ void h(final a0 a0Var, View view) {
        a0Var.y();
        q5.k.m(view.getContext(), w7.v.f14324a).C(com.tuyafeng.support.utils.x.h(view.getContext(), 110.0f)).W(new DialogInterface.OnDismissListener() { // from class: com.tuyafeng.support.widget.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f3764c.N();
            }
        }).e0(new String[]{a0Var.getContext().getString(w7.u.f14005ca), a0Var.getContext().getString(w7.u.f14019da), a0Var.getContext().getString(w7.u.f14033ea), a0Var.getContext().getString(w7.u.T5)}, a0Var.G.r0(), new AdapterView.OnItemClickListener() { // from class: com.tuyafeng.support.widget.o
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i10, long j10) {
                a0.b(this.f3765a, adapterView, view2, i10, j10);
            }
        }).j0(view);
    }

    public static /* synthetic */ void i(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i12 - i10 == i16 - i14 && i13 - i11 == i17 - i15) {
            return;
        }
        y.r.V(view);
    }

    public static /* synthetic */ void l(a0 a0Var, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        a0Var.getClass();
        if (i10 == i14 && i12 == i16 && i11 == i15 && i13 == i17) {
            return;
        }
        Rect rect = new Rect();
        a0Var.getGlobalVisibleRect(rect);
        Activity activityA = com.tuyafeng.support.utils.f.a(a0Var.getContext());
        if (activityA != null) {
            activityA.setPictureInPictureParams(new PictureInPictureParams.Builder().setSourceRectHint(rect).build());
        }
    }

    public static /* synthetic */ void n(final a0 a0Var, View view) {
        a0Var.y();
        String[] strArr = new String[f3642g0.length];
        int i10 = -1;
        int i11 = 0;
        while (true) {
            float[] fArr = f3642g0;
            if (i11 >= fArr.length) {
                q5.k.m(view.getContext(), w7.v.f14324a).C(com.tuyafeng.support.utils.x.h(view.getContext(), 78.0f)).W(new DialogInterface.OnDismissListener() { // from class: com.tuyafeng.support.widget.t
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f3772c.N();
                    }
                }).e0(strArr, i10, a0Var.new a()).j0(view);
                return;
            }
            strArr[i11] = String.valueOf(fArr[i11]);
            if (fArr[i11] == a0Var.F) {
                i10 = i11;
            }
            i11++;
        }
    }

    public static /* synthetic */ void p(a0 a0Var) {
        if (a0Var.isShown()) {
            a0Var.F();
        }
    }

    public static /* synthetic */ void q(a0 a0Var, int[] iArr, AdapterView adapterView, View view, int i10, long j10) {
        u9.l lVar = a0Var.G;
        lVar.E2(iArr[i10] ^ lVar.j0());
    }

    public final void A() {
        if (this.W) {
            return;
        }
        this.W = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, this.f3643a0, this.f3644b0, 0);
        super.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final int B() {
        return R() & (this.G.j0() ^ (-1));
    }

    public final void C(View view) {
        y.r.c(view).b();
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        } else if (view.getAlpha() == 1.0f) {
            return;
        }
        y.r.c(view).a(1.0f).e(v8.h.b()).d(150L).f();
    }

    public final void D() {
        if (!this.V || this.U) {
            return;
        }
        C(this.f3651m);
        if (this.P) {
            E(this.f3648e);
            E(this.f3645c);
            E(this.f3655q);
            E(this.f3652n);
            E(this.f3653o);
            E(this.f3654p);
            return;
        }
        if (this.K) {
            C(this.f3648e);
            C(this.f3645c);
        }
        if (this.L) {
            C(this.f3655q);
        }
        if (this.I) {
            C(this.f3652n);
        }
        if (R() != 0 && this.G.G1()) {
            C(this.f3654p);
        }
        if (this.H) {
            C(this.f3653o);
        }
    }

    public final void E(final View view) {
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        y.r.c(view).a(0.0f).i(new Runnable() { // from class: com.tuyafeng.support.widget.m
            @Override // java.lang.Runnable
            public final void run() {
                view.setVisibility(8);
            }
        }).e(v8.h.b()).d(150L).f();
    }

    public final void F() {
        View[] viewArr = {this.f3648e, this.f3645c, this.f3655q, this.f3652n, this.f3651m, this.f3653o, this.f3654p};
        for (int i10 = 0; i10 < 7; i10++) {
            E(viewArr[i10]);
        }
    }

    public final void G() {
        View viewFindViewById = findViewById(w7.p.f13916v0);
        final View viewFindViewById2 = viewFindViewById.findViewById(w7.p.f13892n0);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(w7.n.f13771x);
        final int dimensionPixelSize2 = getResources().getDimensionPixelSize(w7.n.f13770w);
        viewFindViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tuyafeng.support.widget.p
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                a0.i(view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        y.r.e0(viewFindViewById, new y.m() { // from class: com.tuyafeng.support.widget.q
            @Override // y.m
            public final k0 a(View view, k0 k0Var) {
                return a0.c(dimensionPixelSize, dimensionPixelSize2, viewFindViewById2, view, k0Var);
            }
        });
    }

    public boolean H() {
        return this.U;
    }

    public final void I() {
        y();
        boolean z10 = this.P;
        this.P = !z10;
        this.f3651m.setImageDrawable(!z10 ? lb.g.a(getContext(), w7.o.f13850z0, w7.u.wf) : lb.g.a(getContext(), w7.o.E1, w7.u.Af));
        this.f3651m.setContentDescription(getContext().getString(this.P ? w7.u.vh : w7.u.W7));
        N();
        U();
    }

    public final void J(float f10) {
        float f11 = this.A + f10;
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        if (f11 < 0.01d) {
            f11 = 0.01f;
        }
        j3.j(getContext(), f11);
        int i10 = (int) (f11 * 100.0f);
        this.f3657s.setText(i10 + "%");
    }

    public final void K(float f10) {
        int iMin = (int) (f10 * Math.min(this.D, 300.0f));
        this.E = iMin;
        this.f3657s.setText(String.format("%s%02d:%02d", iMin >= 0 ? "+" : "-", Integer.valueOf(Math.abs(iMin / 60)), Integer.valueOf(Math.abs(this.E % 60))));
    }

    public final void L(float f10) {
        float f11 = this.f3664z;
        int i10 = this.f3663y;
        float f12 = (f11 / i10) + f10;
        if (f12 < 0.0f) {
            f12 = 0.0f;
        }
        if (f12 > 1.0f) {
            f12 = 1.0f;
        }
        int i11 = (int) (i10 * f12);
        this.f3657s.setText(((int) (f12 * 100.0f)) + "%");
        this.f3662x.setStreamVolume(3, i11, 0);
    }

    public void M(int i10, int i11) {
        this.Q = i10 > i11;
        U();
        f2.g(getContext(), i10, i11);
    }

    public final void N() {
        if (isShown()) {
            this.f3656r.removeCallbacks(this.f3650f0);
            this.f3656r.postDelayed(this.f3650f0, 3000L);
            D();
        }
    }

    public final void O(View view) {
        int iR = R();
        if (iR == 0) {
            return;
        }
        y();
        Context context = view.getContext();
        int iJ0 = this.G.j0();
        int iBitCount = Integer.bitCount(iR);
        String[] strArr = new String[iBitCount];
        final int[] iArr = new int[iBitCount];
        int[] iArr2 = new int[iBitCount];
        int i10 = 0;
        int i11 = 0;
        for (VideoGesture videoGesture : VideoGesture.values()) {
            int i12 = videoGesture.flag;
            if ((iR & i12) != 0) {
                strArr[i11] = context.getString(videoGesture.label);
                iArr[i11] = i12;
                if ((iJ0 & i12) == 0) {
                    iArr2[i10] = i11;
                    i10++;
                }
                i11++;
            }
        }
        q5.k.m(context, w7.v.f14324a).C(com.tuyafeng.support.utils.x.h(context, 220.0f)).N(strArr, Arrays.copyOf(iArr2, i10), new AdapterView.OnItemClickListener() { // from class: com.tuyafeng.support.widget.r
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i13, long j10) {
                a0.q(this.f3769a, iArr, adapterView, view2, i13, j10);
            }
        }).W(new DialogInterface.OnDismissListener() { // from class: com.tuyafeng.support.widget.s
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f3771c.N();
            }
        }).j0(view);
    }

    public final void P() {
        b bVar;
        if (this.f3661w != 0 || (B() & VideoGesture.HOLD.flag) == 0 || this.P || this.U || (bVar = this.C) == null) {
            return;
        }
        float f10 = this.F;
        this.f3659u = bVar.f(f10 <= 2.5f ? 3.0f : 0.5f + f10, f10);
        this.f3658t.setVisibility(0);
        A();
    }

    public final void Q() {
        removeCallbacks(this.f3649e0);
        if (this.f3659u == null) {
            return;
        }
        this.f3661w = 1;
        this.f3658t.setVisibility(8);
        Runnable runnable = this.f3659u;
        this.f3659u = null;
        runnable.run();
    }

    public final int R() {
        boolean z10 = this.M;
        return ((z10 && this.L) ? VideoGesture.HOLD.flag : 0) | (z10 ? VideoGesture.SEEK.flag : 0) | (this.O ? VideoGesture.BRIGHTNESS.flag : 0) | (this.N ? VideoGesture.VOLUME.flag : 0);
    }

    public final boolean S(View view) {
        if (view.getVisibility() != 0 || !view.isEnabled()) {
            return false;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.contains(this.f3643a0, this.f3644b0);
    }

    public final void T(int i10) {
        Drawable drawableE;
        if (i10 != 0) {
            int iH = com.tuyafeng.support.utils.x.h(this.f3657s.getContext(), 24.0f);
            drawableE = com.tuyafeng.support.utils.f.e(this.f3657s.getContext(), i10);
            if (drawableE != null) {
                drawableE.setBounds(0, 0, iH, iH);
            }
        } else {
            drawableE = null;
        }
        androidx.core.widget.d.a(this.f3657s, drawableE, null, null, null);
        C(this.f3657s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U() {
        int iF;
        if (this.I && isShown()) {
            if (this.T) {
                j3.i(getContext(), this.J);
                return;
            }
            boolean z10 = this.S ? this.R : this.Q;
            if (this.P) {
                iF = j3.f(getContext());
                if ((z10 == 0 || (iF != 0 && iF != 8)) && (z10 != 0 || (iF != 1 && iF != 8))) {
                    iF = !z10;
                }
            } else {
                iF = z10 != 0 ? 6 : 7;
            }
            j3.i(getContext(), iF);
        }
    }

    public final void V(int i10) {
        if (!this.H || Build.VERSION.SDK_INT < 26) {
            return;
        }
        Context context = getContext();
        if (i10 <= 0) {
            com.tuyafeng.support.utils.f.a(context).setPictureInPictureParams(new PictureInPictureParams.Builder().setActions(Collections.EMPTY_LIST).build());
            return;
        }
        RemoteAction remoteAction = new RemoteAction(Icon.createWithResource(context, w7.o.f13776a1), context.getString(w7.u.Db), context.getString(w7.u.Db), PendingIntent.getBroadcast(context, 0, new Intent("mark.via.MEDIA_REWIND"), 201326592));
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("mark.via.MEDIA_PLAY"), 201326592);
        RemoteAction remoteAction2 = i10 == 1 ? new RemoteAction(Icon.createWithResource(context, w7.o.M0), context.getString(w7.u.f13985b4), context.getString(w7.u.f13985b4), broadcast) : new RemoteAction(Icon.createWithResource(context, w7.o.K0), context.getString(w7.u.f13971a4), context.getString(w7.u.f13971a4), broadcast);
        RemoteAction remoteAction3 = new RemoteAction(Icon.createWithResource(context, w7.o.P), context.getString(w7.u.f14265v5), context.getString(w7.u.f14265v5), PendingIntent.getBroadcast(context, 0, new Intent("mark.via.MEDIA_FASTFORWARD"), 201326592));
        ArrayList arrayList = new ArrayList();
        arrayList.add(remoteAction);
        arrayList.add(remoteAction2);
        arrayList.add(remoteAction3);
        com.tuyafeng.support.utils.f.a(context).setPictureInPictureParams(new PictureInPictureParams.Builder().setActions(arrayList).build());
    }

    public final void W() {
        this.f3655q.setContentDescription(getContext().getString(w7.u.Ha, Float.valueOf(this.F)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q();
            this.W = false;
        }
        if (this.f3659u != null) {
            if (actionMasked == 1 || actionMasked == 3 || actionMasked == 5) {
                Q();
            }
            return true;
        }
        if (actionMasked == 0) {
            removeCallbacks(this.f3649e0);
            this.f3643a0 = (int) motionEvent.getX();
            this.f3644b0 = (int) motionEvent.getY();
            int iH = com.tuyafeng.support.utils.x.h(getContext(), 24.0f);
            if (S(this.f3651m) || S(this.f3655q) || S(this.f3652n) || S(this.f3653o) || S(this.f3654p)) {
                this.f3661w = 1;
            } else {
                int i10 = this.f3643a0;
                if (i10 < iH || i10 >= getWidth() - iH) {
                    this.f3661w = 1;
                    this.W = (this.P || this.U || B() == 0) ? false : true;
                } else {
                    this.f3646c0 = this.f3643a0;
                    this.f3647d0 = this.f3644b0;
                    this.f3661w = 0;
                    if ((B() & VideoGesture.HOLD.flag) != 0 && !this.P && !this.U) {
                        postDelayed(this.f3649e0, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        } else if (actionMasked == 1) {
            removeCallbacks(this.f3649e0);
            int i11 = this.f3661w;
            if (i11 == 3 || i11 == 2 || i11 == 4) {
                E(this.f3657s);
                if (this.f3661w == 4) {
                    x();
                }
            } else if (i11 == 0) {
                if (this.f3651m.getVisibility() == 0) {
                    y();
                    this.f3650f0.run();
                } else if (this.V) {
                    N();
                }
            }
            this.f3661w = 0;
        } else if (actionMasked == 2) {
            if (Math.abs(motionEvent.getX() - this.f3643a0) > this.B || Math.abs(motionEvent.getY() - this.f3644b0) > this.B) {
                removeCallbacks(this.f3649e0);
            }
            if (this.f3661w == 1) {
                return this.W || super.dispatchTouchEvent(motionEvent);
            }
            int x10 = ((int) motionEvent.getX()) - this.f3646c0;
            int y10 = ((int) motionEvent.getY()) - this.f3647d0;
            this.f3646c0 = (int) motionEvent.getX();
            this.f3647d0 = (int) motionEvent.getY();
            if (!this.P && this.f3661w == 0 && (Math.abs(x10) > this.B || Math.abs(y10) > this.B)) {
                this.f3661w = 1;
                int iB = B();
                double dAbs = Math.abs(y10);
                double dAbs2 = Math.abs(x10);
                Double.isNaN(dAbs2);
                if (dAbs > dAbs2 * 1.4d) {
                    int width = getWidth();
                    int i12 = this.f3643a0;
                    if ((i12 < width / 3 && (VideoGesture.BRIGHTNESS.flag & iB) != 0) || (i12 > (width * 2) / 3 && (VideoGesture.VOLUME.flag & iB) != 0)) {
                        this.f3664z = this.f3662x.getStreamVolume(3);
                        this.A = this.A == -1.0f ? j3.d(getContext()) : j3.e(getContext());
                        boolean z10 = this.f3643a0 < getWidth() / 3;
                        this.f3661w = z10 ? 2 : 3;
                        T(z10 ? w7.o.f13843x : w7.o.H1);
                    }
                } else if (Math.abs(x10) > Math.abs(y10) * 3 && (VideoGesture.SEEK.flag & iB) != 0) {
                    this.f3661w = 4;
                    T(0);
                }
            }
            int i13 = this.f3661w;
            if (i13 == 3 || i13 == 2 || i13 == 4) {
                A();
                if (this.f3661w == 4) {
                    K((this.f3646c0 - this.f3643a0) / getWidth());
                } else {
                    float height = ((this.f3644b0 - this.f3647d0) * 2.0f) / getHeight();
                    if (this.f3661w == 2) {
                        J(height);
                    } else {
                        L(height);
                    }
                }
            }
        } else if (actionMasked == 3 || actionMasked == 5) {
            removeCallbacks(this.f3649e0);
            z();
            E(this.f3657s);
            this.f3661w = 1;
        }
        return this.W || super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Q();
        j3.j(getContext(), -1.0f);
        this.A = -1.0f;
        super.onDetachedFromWindow();
    }

    public void setBrightnessGestureEnabled(boolean z10) {
        this.O = z10;
    }

    public void setControllerCallback(b bVar) {
        Object objE = bVar == null ? null : bVar.e();
        if (this.f3660v != objE) {
            Q();
            z();
        }
        this.f3660v = objE;
        this.C = bVar;
        if (bVar == null) {
            setProgressGestureEnabled(false);
            setSpeedAdjustable(false);
            return;
        }
        this.D = bVar.getDuration();
        if (this.f3659u == null) {
            this.F = bVar.d();
        }
        this.f3656r.setText(String.format(Locale.ROOT, "%sX", Float.valueOf(this.F)));
        W();
        boolean z10 = this.D > 0.0f;
        setSpeedAdjustable(this.L & z10);
        setProgressGestureEnabled(this.M & z10);
    }

    public void setInPipMode(boolean z10) {
        if (this.U == z10) {
            return;
        }
        if (z10) {
            Q();
        }
        this.U = z10;
        if (z10) {
            F();
        } else {
            D();
        }
    }

    public void setProgressGestureEnabled(boolean z10) {
        this.M = z10;
        if (z10) {
            return;
        }
        Q();
        z();
    }

    public void setSpeedAdjustable(boolean z10) {
        this.L = z10;
        if (!z10) {
            Q();
        }
        if (z10 || this.f3655q.getVisibility() != 0) {
            return;
        }
        this.f3655q.setVisibility(8);
    }

    public void setSystemOrientation(int i10) {
        this.J = i10;
    }

    public void setTitle(String str) {
        boolean zF = com.tuyafeng.support.utils.p.f(str);
        this.K = !zF;
        this.f3648e.setVisibility(!zF ? 8 : 0);
        this.f3648e.setText(str);
    }

    public void setToolbarEnabled(boolean z10) {
        y();
        F();
        this.V = z10;
    }

    public void setVolumeGestureEnabled(boolean z10) {
        this.N = z10;
    }

    public final void x() {
        this.C.b(this.E);
        this.E = 0;
    }

    public final void y() {
        this.f3656r.removeCallbacks(this.f3650f0);
    }

    public final void z() {
        if (this.f3661w == 4) {
            this.f3661w = 1;
            this.E = 0;
            E(this.f3657s);
        }
    }

    public a0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3661w = 0;
        this.A = -1.0f;
        this.F = 1.0f;
        this.J = -1;
        this.f3649e0 = new Runnable() { // from class: com.tuyafeng.support.widget.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f3774c.P();
            }
        };
        this.f3650f0 = new Runnable() { // from class: com.tuyafeng.support.widget.w
            @Override // java.lang.Runnable
            public final void run() {
                a0.p(this.f3775c);
            }
        };
        boolean zE = f2.e(context);
        this.H = zE;
        this.I = j3.a(context);
        u9.l lVarJ = la.s.j();
        this.G = lVarJ;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.f3662x = audioManager;
        this.f3663y = audioManager.getStreamMaxVolume(3);
        this.B = 12;
        int iR0 = lVarJ.r0();
        this.S = iR0 == 1 || iR0 == 2;
        this.R = iR0 == 1;
        this.T = iR0 == 3;
        LayoutInflater.from(context).inflate(w7.r.C, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(w7.p.H1);
        this.f3648e = textView;
        View viewFindViewById = findViewById(w7.p.K1);
        this.f3645c = viewFindViewById;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1879048192, 0});
        gradientDrawable.setShape(0);
        com.tuyafeng.support.utils.x.P(viewFindViewById, gradientDrawable);
        ImageView imageView = (ImageView) findViewById(w7.p.U);
        this.f3651m = imageView;
        com.tuyafeng.support.utils.g gVarJ = new com.tuyafeng.support.utils.g().c(com.tuyafeng.support.utils.x.h(getContext(), 24.0f)).h(855638016).j(1711276032);
        com.tuyafeng.support.utils.x.P(imageView, gVarJ.a());
        imageView.setImageDrawable(lb.g.a(context, w7.o.E1, w7.u.Af));
        ImageView imageView2 = (ImageView) findViewById(w7.p.f13856b0);
        this.f3652n = imageView2;
        com.tuyafeng.support.utils.x.P(imageView2, gVarJ.a());
        imageView2.setImageDrawable(lb.g.a(context, w7.o.f13779b1, w7.u.yf));
        ImageView imageView3 = (ImageView) findViewById(w7.p.Z);
        this.f3653o = imageView3;
        com.tuyafeng.support.utils.x.P(imageView3, gVarJ.a());
        imageView3.setImageDrawable(lb.g.a(context, w7.o.L0, w7.u.xf));
        ImageView imageView4 = (ImageView) findViewById(w7.p.Q);
        this.f3654p = imageView4;
        com.tuyafeng.support.utils.x.P(imageView4, gVarJ.a());
        imageView4.setImageDrawable(lb.g.a(context, w7.o.f13811m0, w7.u.vf));
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3776a.O(view);
            }
        });
        this.f3656r = (TextView) findViewById(w7.p.C1);
        FrameLayout frameLayout = (FrameLayout) findViewById(w7.p.F);
        this.f3655q = frameLayout;
        W();
        com.tuyafeng.support.utils.x.P(frameLayout, gVarJ.a());
        ImageView imageView5 = (ImageView) findViewById(w7.p.f13865e0);
        imageView5.setImportantForAccessibility(2);
        imageView5.setImageDrawable(lb.g.a(context, w7.o.f13818o1, w7.u.zf));
        TextView textView2 = (TextView) findViewById(w7.p.D1);
        this.f3658t = textView2;
        com.tuyafeng.support.utils.x.P(textView2, new com.tuyafeng.support.utils.g().c(com.tuyafeng.support.utils.x.h(getContext(), 8.0f)).h(1493172224).a());
        TextView textView3 = (TextView) findViewById(w7.p.f13905r1);
        this.f3657s = textView3;
        com.tuyafeng.support.utils.x.P(textView3, new com.tuyafeng.support.utils.g().c(com.tuyafeng.support.utils.x.h(getContext(), 18.0f)).h(Integer.MIN_VALUE).a());
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.n(this.f3777a, view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3778a.I();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.f(this.f3760a, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tuyafeng.support.widget.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a0.h(this.f3761a, view);
            }
        });
        textView.setVisibility(8);
        viewFindViewById.setVisibility(8);
        frameLayout.setVisibility(8);
        imageView.setVisibility(8);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
        if (zE && Build.VERSION.SDK_INT >= 26) {
            V(2);
            addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tuyafeng.support.widget.l
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                    a0.l(this.f3762a, view, i11, i12, i13, i14, i15, i16, i17, i18);
                }
            });
        }
        G();
    }
}
