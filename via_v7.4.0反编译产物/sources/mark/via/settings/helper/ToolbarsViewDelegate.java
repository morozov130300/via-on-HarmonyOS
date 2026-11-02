package mark.via.settings.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import com.tuyafeng.support.widget.a;
import g6.e;
import g6.f;
import g6.g;
import g6.y;
import h6.a;
import java.util.List;
import mark.via.common.widget.b0;
import mark.via.common.widget.g0;
import mark.via.common.widget.n0;
import mark.via.settings.helper.ToolbarsViewDelegate;
import pa.r;
import x7.m;
import x7.n;
import x7.o;
import x7.u;
import x8.h;
import y5.d;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class ToolbarsViewDelegate extends d {

    /* renamed from: b, reason: collision with root package name */
    public static final int f9999b = y.l();

    /* renamed from: c, reason: collision with root package name */
    public static final int f10000c = y.l();

    /* renamed from: d, reason: collision with root package name */
    public static final int f10001d = y.l();

    /* renamed from: e, reason: collision with root package name */
    public static final int f10002e = y.l();

    /* renamed from: f, reason: collision with root package name */
    public static final int f10003f = y.l();

    /* renamed from: g, reason: collision with root package name */
    public static final int f10004g = y.l();

    /* renamed from: h, reason: collision with root package name */
    public static final int f10005h = y.l();

    /* renamed from: i, reason: collision with root package name */
    public static final int f10006i = y.l();

    /* renamed from: a, reason: collision with root package name */
    public final b f10007a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum GestureTarget {
        BACK,
        FORWARD,
        HOME,
        TABS,
        MENU,
        SWIPE_BACK,
        SWIPE_FORWARD,
        FAB,
        FAB_LEFT,
        FAB_RIGHT,
        FAB_UP,
        FAB_DOWN
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends LinearLayout {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onSizeChanged(int i10, int i11, int i12, int i13) {
            super.onSizeChanged(i10, i11, i12, i13);
            ToolbarsViewDelegate.this.y(this, i10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void K(GestureTarget gestureTarget);

        void R(GestureTarget gestureTarget);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c extends com.tuyafeng.support.widget.a {

        /* renamed from: p, reason: collision with root package name */
        public final int f10010p;

        /* renamed from: q, reason: collision with root package name */
        public float f10011q;

        /* renamed from: r, reason: collision with root package name */
        public float f10012r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f10013s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f10014t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f10015u;

        /* renamed from: v, reason: collision with root package name */
        public com.tuyafeng.support.widget.y f10016v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f10017w;

        public c(Context context) {
            super(context);
            this.f10010p = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        @Override // com.tuyafeng.support.widget.a, android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f10011q = motionEvent.getX();
                this.f10012r = motionEvent.getY();
                this.f10013s = false;
                this.f10014t = false;
                this.f10015u = false;
                setDraggale(true);
                j();
                ViewParent parent = getParent();
                while (true) {
                    if (parent == null) {
                        break;
                    }
                    if (parent instanceof com.tuyafeng.support.widget.y) {
                        com.tuyafeng.support.widget.y yVar = (com.tuyafeng.support.widget.y) parent;
                        this.f10016v = yVar;
                        this.f10017w = yVar.u();
                        this.f10016v.setGestureEnabled(false);
                        break;
                    }
                    parent = parent.getParent();
                }
            } else if (actionMasked == 2 && !this.f10013s && !this.f10014t) {
                float fAbs = Math.abs(motionEvent.getX() - this.f10011q);
                float fAbs2 = Math.abs(motionEvent.getY() - this.f10012r);
                if (Math.max(fAbs, fAbs2) > this.f10010p) {
                    boolean z10 = fAbs > fAbs2;
                    this.f10013s = z10;
                    this.f10014t = !z10;
                    if (z10) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        setDraggale(false);
                    }
                }
            } else if (actionMasked == 3) {
                this.f10015u = true;
            }
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked != 1 && actionMasked != 3) {
                return zDispatchTouchEvent;
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            setDraggale(true);
            j();
            return zDispatchTouchEvent;
        }

        public final void j() {
            com.tuyafeng.support.widget.y yVar = this.f10016v;
            if (yVar != null) {
                yVar.setGestureEnabled(this.f10017w);
                this.f10016v = null;
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            j();
            super.onDetachedFromWindow();
        }

        @Override // com.tuyafeng.support.widget.a, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return this.f10013s && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // com.tuyafeng.support.widget.a, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return !this.f10013s || super.onTouchEvent(motionEvent);
        }
    }

    public ToolbarsViewDelegate(b bVar) {
        this.f10007a = bVar;
    }

    public static /* synthetic */ void j(LinearLayout linearLayout) {
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(8);
    }

    public static /* synthetic */ boolean k(ToolbarsViewDelegate toolbarsViewDelegate, c cVar, View view) {
        toolbarsViewDelegate.getClass();
        cVar.setDraggale(false);
        toolbarsViewDelegate.f10007a.R(v(view.getId()));
        return true;
    }

    public static /* synthetic */ void l(ToolbarsViewDelegate toolbarsViewDelegate, c cVar, float f10, boolean z10) {
        toolbarsViewDelegate.getClass();
        if (!z10 || cVar.f10015u || Math.abs(f10) <= 0.8f) {
            return;
        }
        toolbarsViewDelegate.f10007a.K(f10 > 0.0f ? GestureTarget.SWIPE_BACK : GestureTarget.SWIPE_FORWARD);
    }

    public static /* synthetic */ void o(Context context, ImageView imageView) {
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(context, o.f13747n, u.Rd));
    }

    public static /* synthetic */ void q(Context context, b0 b0Var) {
        Drawable drawableF = e.f(lb.b.a(context, o.L1, u.Bf).mutate(), h.l(context));
        int iD = f.d(context, n.f13687f);
        drawableF.setBounds(0, 0, iD, iD);
        b0Var.getIconView().setImageDrawable(drawableF);
        b0Var.getTextView().setEllipsize(TextUtils.TruncateAt.END);
        b0Var.getTextView().setHorizontalFadingEdgeEnabled(false);
        b0Var.getTextView().setText(u.f14069m0);
        b0Var.getTextView().setTextColor(h.p(context));
    }

    public static GestureTarget v(int i10) {
        if (i10 == g0.f9639p) {
            return GestureTarget.BACK;
        }
        if (i10 == g0.f9640q) {
            return GestureTarget.FORWARD;
        }
        if (i10 == g0.f9641r) {
            return GestureTarget.HOME;
        }
        if (i10 == g0.f9642s) {
            return GestureTarget.TABS;
        }
        if (i10 == g0.f9643t) {
            return GestureTarget.MENU;
        }
        throw new IllegalArgumentException("Unknown toolbar button: " + i10);
    }

    public final void A(n0 n0Var, int i10) {
        if (i10 == 0) {
            n0Var.setTitle(n0Var.getContext().getString(u.f14069m0));
        } else if (i10 == 1) {
            n0Var.setTitle("https://example.com/");
        } else {
            n0Var.setTitle("example.com");
        }
    }

    public final void B(View view, int i10) {
        if (i10 == 0) {
            view.setBackgroundColor(0);
            int iH = y.h(view.getContext(), 12.0f);
            view.setPadding(iH, 0, iH, 0);
            return;
        }
        Context context = view.getContext();
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new g().h(r.j().d() ? 587202559 : 268435456).c(h.e(context)).a()});
        int iH2 = y.h(context, 4.0f);
        if (i10 == 3) {
            int i11 = iH2 * 4;
            view.setPadding(i11, 0, i11, 0);
            layerDrawable.setLayerInset(0, i11, iH2, i11, iH2);
        } else {
            view.setPadding(0, 0, 0, 0);
            layerDrawable.setLayerInset(0, iH2, iH2, iH2, iH2);
        }
        y.O(view, layerDrawable);
    }

    @Override // y5.d
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, ib.b0 b0Var) {
        z(gVar, b0Var.b());
        x(gVar, b0Var);
        gVar.P(f10006i).setVisibility(b0Var.e() ? 0 : 8);
        A((n0) gVar.P(f10000c), b0Var.c());
    }

    @Override // y5.d
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void c(b6.g gVar, ib.b0 b0Var, List list) {
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
            z(gVar, b0Var.b());
        }
        if ((iIntValue & 2) == 2) {
            ((LinearLayout) gVar.P(f10006i)).setVisibility(b0Var.e() ? 0 : 8);
        }
        if ((iIntValue & 8) == 8) {
            x(gVar, b0Var);
        }
        if ((iIntValue & 4) == 4) {
            A((n0) gVar.P(f10000c), b0Var.c());
        }
    }

    @Override // y5.d
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = (LinearLayout) new h6.a(new LinearLayout(context), new LinearLayout.LayoutParams(-1, -2)).n(1, 300).e(new g().c(h.e(context)).l(y.h(context, 2.0f)).k(f.b(context, m.f13673c)).a()).V(new a.InterfaceC0076a() { // from class: ib.d0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        LinearLayout linearLayout3 = (LinearLayout) new h6.a(new LinearLayout(context), new LinearLayout.LayoutParams(-1, -2)).o(f9999b).V(new a.InterfaceC0076a() { // from class: ib.e0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        n0 n0Var = (n0) new h6.a(new n0(context), new LinearLayout.LayoutParams(-1, -2)).o(f10000c).m(f.d(context, n.F)).l();
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(context), new LinearLayout.LayoutParams(-1, 0)).o(f10005h).W(1.0f).l();
        mark.via.settings.helper.a aVar = new mark.via.settings.helper.a(context, this.f10007a);
        aVar.setId(f10004g);
        int iD = f.d(context, n.f13689h);
        frameLayout.addView(aVar, new FrameLayout.LayoutParams(iD, iD));
        g0 g0Var = (g0) new h6.a(new g0(context), new FrameLayout.LayoutParams(-1, -1)).o(f10003f).l();
        final c cVar = new c(context);
        cVar.setId(f10002e);
        cVar.setLayoutParams(new LinearLayout.LayoutParams(-1, f.d(context, n.f13683b)));
        cVar.setDragDistance(y.h(context, 84.0f));
        cVar.addView(g0Var);
        g0Var.setOnItemClickListener(new View.OnClickListener() { // from class: ib.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7139a.f10007a.K(ToolbarsViewDelegate.v(view.getId()));
            }
        });
        g0Var.setOnItemLongClickListener(new View.OnLongClickListener() { // from class: ib.g0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ToolbarsViewDelegate.k(this.f7140a, cVar, view);
            }
        });
        cVar.g(new a.b() { // from class: ib.h0
            @Override // com.tuyafeng.support.widget.a.b
            public final void a(float f10, boolean z10) {
                ToolbarsViewDelegate.l(this.f7142a, cVar, f10, z10);
            }
        });
        LinearLayout linearLayout4 = (LinearLayout) new h6.a(new LinearLayout(context), new LinearLayout.LayoutParams(-1, -2)).o(f10001d).V(new a.InterfaceC0076a() { // from class: ib.i0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        LinearLayout linearLayout5 = (LinearLayout) new h6.a(new a(context), new LinearLayout.LayoutParams(-1, -2)).o(f10006i).m(f.d(context, n.f13704w)).V(new a.InterfaceC0076a() { // from class: ib.j0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ToolbarsViewDelegate.j((LinearLayout) obj);
            }
        }).l();
        b0 b0Var = (b0) new h6.a(new b0(context), new LinearLayout.LayoutParams(0, -1)).V(new a.InterfaceC0076a() { // from class: ib.k0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ToolbarsViewDelegate.q(context, (mark.via.common.widget.b0) obj);
            }
        }).l();
        Space space = (Space) new h6.a(new Space(context), new LinearLayout.LayoutParams(0, -1)).l();
        View viewL = new h6.a(new ImageView(context), new LinearLayout.LayoutParams(0, -1)).W(1.0f).S((f.d(context, n.f13704w) - f.d(context, n.f13687f)) / 2).V(new a.InterfaceC0076a() { // from class: ib.l0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ToolbarsViewDelegate.o(context, (ImageView) obj);
            }
        }).l();
        linearLayout3.addView(n0Var);
        linearLayout4.addView(cVar);
        linearLayout5.addView(b0Var);
        linearLayout5.addView(space);
        linearLayout5.addView(viewL);
        linearLayout3.addView(linearLayout5);
        linearLayout2.addView(linearLayout3);
        linearLayout2.addView(frameLayout);
        linearLayout2.addView(linearLayout4);
        linearLayout.addView(linearLayout2);
        linearLayout2.setScaleX(0.8f);
        linearLayout2.setScaleY(0.8f);
        return new b6.g(linearLayout);
    }

    public final void w(View view, int i10) {
        y.O(view, new g().h(411074688).d((i10 == 2 || i10 == 3) ? h.e(view.getContext()) : 0, i10 == 1 ? h.e(view.getContext()) : 0).a());
    }

    public final void x(b6.g gVar, ib.b0 b0Var) {
        mark.via.settings.helper.a aVar = (mark.via.settings.helper.a) gVar.P(f10004g);
        aVar.c();
        aVar.setVisibility(b0Var.d() ? 0 : 8);
        int iA = b0Var.a();
        int i10 = 3;
        if ((iA & 3) != 3) {
            i10 = 5;
            if ((iA & 5) != 5) {
                i10 = 1;
            }
        }
        int i11 = 80;
        if (i10 != 1 && (iA & 80) != 80) {
            i11 = 16;
        }
        int iD = f.d(aVar.getContext(), n.f13689h);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iD, iD, i11 | i10);
        int iH = y.h(aVar.getContext(), 12.0f);
        layoutParams.setMargins(iH, iH, iH, iH);
        aVar.setLayoutParams(layoutParams);
    }

    public final void y(final LinearLayout linearLayout, int i10) {
        if (i10 <= 0) {
            return;
        }
        int I = y.I(linearLayout.getContext(), i10);
        int i11 = I / (I < 420 ? I / 7 : I > 900 ? 72 : 60);
        if (linearLayout.getChildCount() < 1) {
            return;
        }
        View childAt = linearLayout.getChildAt(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
        layoutParams.weight = Math.max(3, ((i11 - 1) / 2) - 1);
        childAt.setLayoutParams(layoutParams);
        View childAt2 = linearLayout.getChildAt(1);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
        layoutParams2.weight = Math.max((i11 - layoutParams.weight) - 1.0f, 1.0f);
        childAt2.setLayoutParams(layoutParams2);
        linearLayout.post(new Runnable() { // from class: ib.m0
            @Override // java.lang.Runnable
            public final void run() {
                linearLayout.requestLayout();
            }
        });
    }

    public final void z(b6.g gVar, int i10) {
        LinearLayout linearLayout = (LinearLayout) gVar.P(f9999b);
        n0 n0Var = (n0) gVar.P(f10000c);
        LinearLayout linearLayout2 = (LinearLayout) gVar.P(f10001d);
        g0 g0Var = (g0) gVar.P(f10003f);
        com.tuyafeng.support.widget.a aVar = (com.tuyafeng.support.widget.a) gVar.P(f10002e);
        View viewP = gVar.P(f10005h);
        LinearLayout linearLayout3 = (LinearLayout) gVar.P(f10006i);
        linearLayout.removeAllViews();
        linearLayout2.removeAllViews();
        g0Var.k();
        if (i10 == 0) {
            linearLayout.addView(n0Var);
            linearLayout2.addView(aVar);
        } else if (i10 == 1) {
            g0Var.f(n0Var);
            linearLayout.addView(aVar);
            linearLayout.addView(linearLayout3);
        } else if (i10 == 2) {
            linearLayout2.addView(linearLayout3);
            g0Var.f(n0Var);
            linearLayout2.addView(aVar);
        } else if (i10 == 3) {
            linearLayout2.addView(n0Var);
            linearLayout2.addView(aVar);
        }
        B(n0Var, i10);
        w(viewP, i10);
    }
}
