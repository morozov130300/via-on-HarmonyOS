package za;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tuyafeng.support.widget.y;
import com.tuyafeng.support.widget.z;
import java.io.FileNotFoundException;
import mark.via.common.widget.PdfViewer;
import o8.h;
import pa.r;
import x7.k;
import x7.n;
import x7.u;
import z8.b1;
import z8.r3;
import z8.v3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@TargetApi(21)
/* loaded from: classes.dex */
public class g extends h {

    /* renamed from: o0, reason: collision with root package name */
    public z f14801o0;

    /* renamed from: p0, reason: collision with root package name */
    public PdfViewer f14802p0;

    /* renamed from: q0, reason: collision with root package name */
    public y f14803q0;

    /* renamed from: r0, reason: collision with root package name */
    public TextView f14804r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f14805s0;

    /* renamed from: t0, reason: collision with root package name */
    public float f14806t0;

    /* renamed from: u0, reason: collision with root package name */
    public float f14807u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f14808v0;

    /* renamed from: w0, reason: collision with root package name */
    public final Runnable f14809w0 = new Runnable() { // from class: za.e
        @Override // java.lang.Runnable
        public final void run() {
            this.f14799e.g3();
        }
    };

    public static /* synthetic */ void b3(int i10, int i11) {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ boolean c3(g gVar, View view, MotionEvent motionEvent) {
        gVar.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    gVar.i3();
                    if (gVar.f14802p0.h0()) {
                        gVar.f14808v0 = true;
                        gVar.f14803q0.setGestureEnabled(false);
                        if (view.getParent() != null) {
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                    } else if (motionEvent.getPointerCount() > 1) {
                        gVar.f14808v0 = true;
                        gVar.f14803q0.setGestureEnabled(false);
                        if (view.getParent() != null) {
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                    } else {
                        float x10 = motionEvent.getX() - gVar.f14806t0;
                        float y10 = motionEvent.getY() - gVar.f14807u0;
                        if (gVar.f14808v0) {
                            boolean z10 = Math.abs(x10) <= Math.abs(y10);
                            gVar.f14803q0.setGestureEnabled(z10);
                            if (view.getParent() != null) {
                                view.getParent().requestDisallowInterceptTouchEvent(!z10);
                                return false;
                            }
                        } else if (Math.abs(x10) >= gVar.f14805s0 || Math.abs(y10) >= gVar.f14805s0) {
                            gVar.f14808v0 = true;
                            if (Math.abs(x10) <= Math.abs(y10)) {
                            }
                            gVar.f14803q0.setGestureEnabled(z10);
                            if (view.getParent() != null) {
                            }
                        }
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        gVar.f14808v0 = true;
                        gVar.f14803q0.setGestureEnabled(false);
                        if (view.getParent() != null) {
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                    }
                }
            }
            gVar.f14808v0 = false;
            gVar.f14803q0.setGestureEnabled(true);
            gVar.h3();
            return false;
        }
        gVar.f14806t0 = motionEvent.getX();
        gVar.f14807u0 = motionEvent.getY();
        gVar.f14808v0 = false;
        gVar.f14803q0.setGestureEnabled(false);
        if (gVar.f14802p0.h0() && view.getParent() != null) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    public static /* synthetic */ void d3(g gVar) {
        TextView textView = gVar.f14804r0;
        if (textView == null || textView.getAlpha() != 0.0f) {
            return;
        }
        gVar.f14804r0.setVisibility(4);
    }

    public static /* synthetic */ void f3(g gVar, int i10, int i11) {
        TextView textView = gVar.f14804r0;
        if (textView != null) {
            textView.setText((i10 + 1) + " / " + i11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void F1() {
        PdfViewer pdfViewer = this.f14802p0;
        if (pdfViewer != null) {
            pdfViewer.setOnTouchListener(null);
            this.f14802p0.setOnPageChangedListener(new PdfViewer.e() { // from class: za.d
                @Override // mark.via.common.widget.PdfViewer.e
                public final void a(int i10, int i11) {
                    g.b3(i10, i11);
                }
            });
        }
        TextView textView = this.f14804r0;
        if (textView != null) {
            textView.removeCallbacks(this.f14809w0);
        }
        this.f14803q0.setGestureEnabled(true);
        super.F1();
    }

    @Override // o8.h
    public boolean W2() {
        return true;
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) throws FileNotFoundException {
        super.X1(view, bundle);
        this.f14803q0 = (y) view.findViewById(g6.y.f6242a);
        this.f14805s0 = ViewConfiguration.get(I()).getScaledTouchSlop();
        this.f14802p0.setOnPageChangedListener(new PdfViewer.e() { // from class: za.b
            @Override // mark.via.common.widget.PdfViewer.e
            public final void a(int i10, int i11) {
                g.f3(this.f14797a, i10, i11);
            }
        });
        this.f14802p0.setOnTouchListener(new View.OnTouchListener() { // from class: za.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return g.c3(this.f14798a, view2, motionEvent);
            }
        });
        String string = y0() == null ? null : y0().getString("pdfPath");
        String string2 = y0() != null ? y0().getString("pdfName") : null;
        if (string == null) {
            return;
        }
        Uri uri = Uri.parse(string);
        if (string2 == null) {
            string2 = b1.k(I(), uri);
        }
        this.f14801o0.setTitle(string2);
        this.f14802p0.r0(uri);
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(I());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        PdfViewer pdfViewer = new PdfViewer(I());
        this.f14802p0 = pdfViewer;
        pdfViewer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r3.i(this.f14802p0, -2134061876);
        if (r.j().d() && Build.VERSION.SDK_INT >= 23) {
            this.f14802p0.setForeground(new ColorDrawable(Integer.MIN_VALUE));
        }
        this.f14804r0 = new TextView(I());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388659;
        int iH = g6.y.h(I(), 12.0f);
        layoutParams.leftMargin = iH;
        layoutParams.topMargin = iH;
        this.f14804r0.setLayoutParams(layoutParams);
        this.f14804r0.setTextSize(2, 12.0f);
        this.f14804r0.setTextColor(g6.e.a(I(), k.f13666l));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(g6.e.a(I(), k.f13655a));
        gradientDrawable.setCornerRadius(g6.f.d(I(), n.f13697p));
        this.f14804r0.setBackground(gradientDrawable);
        int iH2 = g6.y.h(I(), 8.0f);
        int iH3 = g6.y.h(I(), 4.0f);
        this.f14804r0.setPadding(iH2, iH3, iH2, iH3);
        this.f14804r0.setAlpha(0.0f);
        this.f14804r0.setVisibility(4);
        frameLayout.addView(this.f14802p0);
        frameLayout.addView(this.f14804r0);
        return frameLayout;
    }

    @Override // o8.h
    public void a3(z zVar) {
        super.a3(zVar);
        this.f14801o0 = zVar;
        v3.a(zVar, u.W);
    }

    public final void g3() {
        TextView textView = this.f14804r0;
        if (textView == null) {
            return;
        }
        textView.animate().cancel();
        this.f14804r0.animate().alpha(0.0f).setDuration(220L).withEndAction(new Runnable() { // from class: za.f
            @Override // java.lang.Runnable
            public final void run() {
                g.d3(this.f14800e);
            }
        }).start();
    }

    public final void h3() {
        TextView textView = this.f14804r0;
        if (textView == null) {
            return;
        }
        textView.removeCallbacks(this.f14809w0);
        this.f14804r0.postDelayed(this.f14809w0, 2000L);
    }

    public final void i3() {
        TextView textView = this.f14804r0;
        if (textView == null) {
            return;
        }
        textView.removeCallbacks(this.f14809w0);
        if (this.f14804r0.getVisibility() != 0 || this.f14804r0.getAlpha() < 0.99f) {
            this.f14804r0.animate().cancel();
            if (this.f14804r0.getVisibility() != 0) {
                this.f14804r0.setVisibility(0);
            }
            this.f14804r0.animate().alpha(1.0f).setDuration(120L).start();
        }
    }
}
