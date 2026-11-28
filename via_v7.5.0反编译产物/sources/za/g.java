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
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.d0;
import com.tuyafeng.support.widget.e0;
import la.s;
import mark.via.common.widget.PdfViewer;
import w7.k;
import w7.n;
import w7.u;
import x8.b1;
import x8.r3;
import x8.v3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
public class g extends m8.g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public e0 f15538r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public PdfViewer f15539s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public d0 f15540t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public TextView f15541u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f15542v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public float f15543w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public float f15544x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f15545y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final Runnable f15546z0 = new Runnable() { // from class: za.e
        @Override // java.lang.Runnable
        public final void run() {
            this.f15536c.f3();
        }
    };

    /* JADX WARN: Code duplicated, block: B:38:0x009f  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ad  */
    public static /* synthetic */ boolean b3(g gVar, View view, MotionEvent motionEvent) {
        boolean z10;
        gVar.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    gVar.h3();
                    if (gVar.f15539s0.h0()) {
                        gVar.f15545y0 = true;
                        gVar.f15540t0.setGestureEnabled(false);
                        if (view.getParent() != null) {
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                    } else if (motionEvent.getPointerCount() > 1) {
                        gVar.f15545y0 = true;
                        gVar.f15540t0.setGestureEnabled(false);
                        if (view.getParent() != null) {
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                    } else {
                        float x10 = motionEvent.getX() - gVar.f15543w0;
                        float y10 = motionEvent.getY() - gVar.f15544x0;
                        if (gVar.f15545y0) {
                            if (Math.abs(x10) > Math.abs(y10)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            gVar.f15540t0.setGestureEnabled(z10);
                            if (view.getParent() != null) {
                                view.getParent().requestDisallowInterceptTouchEvent(!z10);
                                return false;
                            }
                        } else if (Math.abs(x10) >= gVar.f15542v0 || Math.abs(y10) >= gVar.f15542v0) {
                            gVar.f15545y0 = true;
                            if (Math.abs(x10) > Math.abs(y10)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            gVar.f15540t0.setGestureEnabled(z10);
                            if (view.getParent() != null) {
                                view.getParent().requestDisallowInterceptTouchEvent(!z10);
                                return false;
                            }
                        }
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        gVar.f15545y0 = true;
                        gVar.f15540t0.setGestureEnabled(false);
                        if (view.getParent() != null) {
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                    }
                }
            }
            gVar.f15545y0 = false;
            gVar.f15540t0.setGestureEnabled(true);
            gVar.g3();
            return false;
        }
        gVar.f15543w0 = motionEvent.getX();
        gVar.f15544x0 = motionEvent.getY();
        gVar.f15545y0 = false;
        gVar.f15540t0.setGestureEnabled(false);
        if (gVar.f15539s0.h0() && view.getParent() != null) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    public static /* synthetic */ void c3(g gVar) {
        TextView textView = gVar.f15541u0;
        if (textView == null || textView.getAlpha() != 0.0f) {
            return;
        }
        gVar.f15541u0.setVisibility(4);
    }

    public static /* synthetic */ void e3(g gVar, int i10, int i11) {
        TextView textView = gVar.f15541u0;
        if (textView != null) {
            textView.setText((i10 + 1) + " / " + i11);
        }
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void D1() {
        PdfViewer pdfViewer = this.f15539s0;
        if (pdfViewer != null) {
            pdfViewer.setOnTouchListener(null);
            this.f15539s0.setOnPageChangedListener(new PdfViewer.e() { // from class: za.d
                @Override // mark.via.common.widget.PdfViewer.e
                public final void a(int i10, int i11) {
                    g.a3(i10, i11);
                }
            });
        }
        TextView textView = this.f15541u0;
        if (textView != null) {
            textView.removeCallbacks(this.f15546z0);
        }
        this.f15540t0.setGestureEnabled(true);
        super.D1();
    }

    @Override // m8.g
    public boolean U2() {
        return true;
    }

    @Override // m8.g, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f15540t0 = (d0) view.findViewById(x.f3593a);
        this.f15542v0 = ViewConfiguration.get(G()).getScaledTouchSlop();
        this.f15539s0.setOnPageChangedListener(new PdfViewer.e() { // from class: za.b
            @Override // mark.via.common.widget.PdfViewer.e
            public final void a(int i10, int i11) {
                g.e3(this.f15534a, i10, i11);
            }
        });
        this.f15539s0.setOnTouchListener(new View.OnTouchListener() { // from class: za.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return g.b3(this.f15535a, view2, motionEvent);
            }
        });
        String string = w0() == null ? null : w0().getString("pdfPath");
        String string2 = w0() != null ? w0().getString("pdfName") : null;
        if (string == null) {
            return;
        }
        Uri uri = Uri.parse(string);
        if (string2 == null) {
            string2 = b1.k(G(), uri);
        }
        this.f15538r0.setTitle(string2);
        this.f15539s0.r0(uri);
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(G());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        PdfViewer pdfViewer = new PdfViewer(G());
        this.f15539s0 = pdfViewer;
        pdfViewer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r3.j(this.f15539s0, -2134061876);
        if (s.j().e() && Build.VERSION.SDK_INT >= 23) {
            this.f15539s0.setForeground(new ColorDrawable(Integer.MIN_VALUE));
        }
        this.f15541u0 = new TextView(G());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388659;
        int iH = x.h(G(), 12.0f);
        layoutParams.leftMargin = iH;
        layoutParams.topMargin = iH;
        this.f15541u0.setLayoutParams(layoutParams);
        this.f15541u0.setTextSize(2, 12.0f);
        this.f15541u0.setTextColor(com.tuyafeng.support.utils.e.a(G(), k.f13733m));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.tuyafeng.support.utils.e.a(G(), k.f13722b));
        gradientDrawable.setCornerRadius(com.tuyafeng.support.utils.f.d(G(), n.f13763p));
        this.f15541u0.setBackground(gradientDrawable);
        int iH2 = x.h(G(), 8.0f);
        int iH3 = x.h(G(), 4.0f);
        this.f15541u0.setPadding(iH2, iH3, iH2, iH3);
        this.f15541u0.setAlpha(0.0f);
        this.f15541u0.setVisibility(4);
        frameLayout.addView(this.f15539s0);
        frameLayout.addView(this.f15541u0);
        return frameLayout;
    }

    @Override // m8.g
    public void Z2(e0 e0Var) {
        super.Z2(e0Var);
        this.f15538r0 = e0Var;
        v3.a(e0Var, u.X);
    }

    public final void f3() {
        TextView textView = this.f15541u0;
        if (textView == null) {
            return;
        }
        textView.animate().cancel();
        this.f15541u0.animate().alpha(0.0f).setDuration(220L).withEndAction(new Runnable() { // from class: za.f
            @Override // java.lang.Runnable
            public final void run() {
                g.c3(this.f15537c);
            }
        }).start();
    }

    public final void g3() {
        TextView textView = this.f15541u0;
        if (textView == null) {
            return;
        }
        textView.removeCallbacks(this.f15546z0);
        this.f15541u0.postDelayed(this.f15546z0, 2000L);
    }

    public final void h3() {
        TextView textView = this.f15541u0;
        if (textView == null) {
            return;
        }
        textView.removeCallbacks(this.f15546z0);
        if (this.f15541u0.getVisibility() != 0 || this.f15541u0.getAlpha() < 0.99f) {
            this.f15541u0.animate().cancel();
            if (this.f15541u0.getVisibility() != 0) {
                this.f15541u0.setVisibility(0);
            }
            this.f15541u0.animate().alpha(1.0f).setDuration(120L).start();
        }
    }

    public static /* synthetic */ void a3(int i10, int i11) {
    }
}
