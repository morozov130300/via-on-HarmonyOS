package ib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import java.util.List;
import mark.via.common.widget.n0;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k0 extends t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6373a = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6374b = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6375c = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6376d = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6377e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6378f = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends LinearLayout {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends LinearLayout {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onSizeChanged(int i10, int i11, int i12, int i13) {
            super.onSizeChanged(i10, i11, i12, i13);
            k0.this.t(this, i10);
        }
    }

    public static /* synthetic */ void i(LinearLayout linearLayout) {
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(8);
    }

    public static /* synthetic */ void m(Context context, mark.via.common.widget.b0 b0Var) {
        Drawable drawableF = com.tuyafeng.support.utils.e.f(lb.g.a(context, w7.o.I1, w7.u.Rf).mutate(), v8.h.l(context));
        int iD = com.tuyafeng.support.utils.f.d(context, w7.n.f13753f);
        drawableF.setBounds(0, 0, iD, iD);
        b0Var.getIconView().setImageDrawable(drawableF);
        b0Var.getTextView().setEllipsize(TextUtils.TruncateAt.END);
        b0Var.getTextView().setHorizontalFadingEdgeEnabled(false);
        b0Var.getTextView().setText(w7.u.f14163o0);
        b0Var.getTextView().setTextColor(v8.h.o(context));
    }

    public static /* synthetic */ void n(Context context, ImageView imageView) {
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(context, w7.o.f13810m, w7.u.ge));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, b0 b0Var) {
        u(gVar, b0Var.a());
        gVar.P(f6378f).setVisibility(b0Var.c() ? 0 : 8);
        v((n0) gVar.P(f6374b), b0Var.b());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void c(w5.g gVar, b0 b0Var, List list) {
        if (list.isEmpty()) {
            b(gVar, b0Var);
            return;
        }
        int iIntValue = 0;
        for (Object obj : list) {
            if (obj instanceof Integer) {
                iIntValue |= ((Integer) obj).intValue();
            }
        }
        if (iIntValue == 0) {
            return;
        }
        if ((iIntValue & 1) == 1) {
            u(gVar, b0Var.a());
        }
        if ((iIntValue & 2) == 2) {
            ((LinearLayout) gVar.P(f6378f)).setVisibility(b0Var.c() ? 0 : 8);
        }
        if ((iIntValue & 4) == 4) {
            v((n0) gVar.P(f6374b), b0Var.b());
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        a aVar = new a(context);
        aVar.setOrientation(1);
        aVar.setDescendantFocusability(393216);
        aVar.setImportantForAccessibility(4);
        aVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new LinearLayout.LayoutParams(-1, -2)).n(1, 300).e(new com.tuyafeng.support.utils.g().c(v8.h.e(context)).l(com.tuyafeng.support.utils.x.h(context, 2.0f)).k(com.tuyafeng.support.utils.f.b(context, w7.m.f13739c)).a()).V(new b6.a.InterfaceC0033a() { // from class: ib.d0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        LinearLayout linearLayout2 = (LinearLayout) new b6.a(new LinearLayout(context), new LinearLayout.LayoutParams(-1, -2)).o(f6373a).V(new b6.a.InterfaceC0033a() { // from class: ib.e0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        n0 n0Var = (n0) new b6.a(new n0(context), new LinearLayout.LayoutParams(-1, -2)).o(f6374b).m(com.tuyafeng.support.utils.f.d(context, w7.n.H)).l();
        View viewL = new b6.a(new View(context), new LinearLayout.LayoutParams(-1, 0)).o(f6377e).W(1.0f).l();
        mark.via.common.widget.g0 g0Var = (mark.via.common.widget.g0) new b6.a(new mark.via.common.widget.g0(context), new LinearLayout.LayoutParams(-1, com.tuyafeng.support.utils.f.d(context, w7.n.f13749b))).o(f6376d).l();
        LinearLayout linearLayout3 = (LinearLayout) new b6.a(new LinearLayout(context), new LinearLayout.LayoutParams(-1, -2)).o(f6375c).V(new b6.a.InterfaceC0033a() { // from class: ib.f0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        LinearLayout linearLayout4 = (LinearLayout) new b6.a(new b(context), new LinearLayout.LayoutParams(-1, -2)).o(f6378f).m(com.tuyafeng.support.utils.f.d(context, w7.n.f13772y)).V(new b6.a.InterfaceC0033a() { // from class: ib.g0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.i((LinearLayout) obj);
            }
        }).l();
        mark.via.common.widget.b0 b0Var = (mark.via.common.widget.b0) new b6.a(new mark.via.common.widget.b0(context), new LinearLayout.LayoutParams(0, -1)).V(new b6.a.InterfaceC0033a() { // from class: ib.h0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.m(context, (mark.via.common.widget.b0) obj);
            }
        }).l();
        Space space = (Space) new b6.a(new Space(context), new LinearLayout.LayoutParams(0, -1)).l();
        View viewL2 = new b6.a(new ImageView(context), new LinearLayout.LayoutParams(0, -1)).W(1.0f).S((com.tuyafeng.support.utils.f.d(context, w7.n.f13772y) - com.tuyafeng.support.utils.f.d(context, w7.n.f13753f)) / 2).V(new b6.a.InterfaceC0033a() { // from class: ib.i0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                k0.n(context, (ImageView) obj);
            }
        }).l();
        linearLayout2.addView(n0Var);
        linearLayout3.addView(g0Var);
        linearLayout4.addView(b0Var);
        linearLayout4.addView(space);
        linearLayout4.addView(viewL2);
        linearLayout2.addView(linearLayout4);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(viewL);
        linearLayout.addView(linearLayout3);
        aVar.addView(linearLayout);
        linearLayout.setScaleX(0.8f);
        linearLayout.setScaleY(0.8f);
        return new w5.g(aVar);
    }

    public final void s(View view, int i10) {
        com.tuyafeng.support.utils.x.P(view, new com.tuyafeng.support.utils.g().h(411074688).d((i10 == 2 || i10 == 3) ? v8.h.e(view.getContext()) : 0, i10 == 1 ? v8.h.e(view.getContext()) : 0).a());
    }

    public final void t(final LinearLayout linearLayout, int i10) {
        int i11;
        if (i10 <= 0) {
            return;
        }
        int I = com.tuyafeng.support.utils.x.I(linearLayout.getContext(), i10);
        if (I < 420) {
            i11 = I / 7;
        } else {
            i11 = I > 900 ? 72 : 60;
        }
        int i12 = I / i11;
        if (linearLayout.getChildCount() < 1) {
            return;
        }
        View childAt = linearLayout.getChildAt(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
        layoutParams.weight = Math.max(3, ((i12 - 1) / 2) - 1);
        childAt.setLayoutParams(layoutParams);
        View childAt2 = linearLayout.getChildAt(1);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
        layoutParams2.weight = Math.max((i12 - layoutParams.weight) - 1.0f, 1.0f);
        childAt2.setLayoutParams(layoutParams2);
        linearLayout.post(new Runnable() { // from class: ib.j0
            @Override // java.lang.Runnable
            public final void run() {
                linearLayout.requestLayout();
            }
        });
    }

    public final void u(w5.g gVar, int i10) {
        LinearLayout linearLayout = (LinearLayout) gVar.P(f6373a);
        n0 n0Var = (n0) gVar.P(f6374b);
        LinearLayout linearLayout2 = (LinearLayout) gVar.P(f6375c);
        mark.via.common.widget.g0 g0Var = (mark.via.common.widget.g0) gVar.P(f6376d);
        View viewP = gVar.P(f6377e);
        LinearLayout linearLayout3 = (LinearLayout) gVar.P(f6378f);
        linearLayout.removeAllViews();
        linearLayout2.removeAllViews();
        g0Var.k();
        if (i10 == 0) {
            linearLayout.addView(n0Var);
            linearLayout2.addView(g0Var);
        } else if (i10 == 1) {
            g0Var.f(n0Var);
            linearLayout.addView(g0Var);
            linearLayout.addView(linearLayout3);
        } else if (i10 == 2) {
            linearLayout2.addView(linearLayout3);
            g0Var.f(n0Var);
            linearLayout2.addView(g0Var);
        } else if (i10 == 3) {
            linearLayout2.addView(n0Var);
            linearLayout2.addView(g0Var);
        }
        w(n0Var, i10);
        s(viewP, i10);
    }

    public final void v(n0 n0Var, int i10) {
        if (i10 == 0) {
            n0Var.setTitle(n0Var.getContext().getString(w7.u.f14163o0));
        } else if (i10 == 1) {
            n0Var.setTitle("https://example.com/");
        } else {
            n0Var.setTitle("example.com");
        }
    }

    public final void w(View view, int i10) {
        if (i10 == 0) {
            view.setBackgroundColor(0);
            int iH = com.tuyafeng.support.utils.x.h(view.getContext(), 12.0f);
            view.setPadding(iH, 0, iH, 0);
            return;
        }
        Context context = view.getContext();
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new com.tuyafeng.support.utils.g().h(la.s.j().e() ? 587202559 : 268435456).c(v8.h.e(context)).a()});
        int iH2 = com.tuyafeng.support.utils.x.h(context, 4.0f);
        if (i10 == 3) {
            int i11 = iH2 * 4;
            view.setPadding(i11, 0, i11, 0);
            layerDrawable.setLayerInset(0, i11, iH2, i11, iH2);
        } else {
            view.setPadding(0, 0, 0, 0);
            layerDrawable.setLayerInset(0, iH2, iH2, iH2, iH2);
        }
        com.tuyafeng.support.utils.x.P(view, layerDrawable);
    }
}
