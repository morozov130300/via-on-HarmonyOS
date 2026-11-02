package tb;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Space;
import h6.a;
import java.util.Iterator;
import java.util.List;
import x.k0;
import x.x;
import z8.l3;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w0 extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public FrameLayout f12416m0;

    /* renamed from: n0, reason: collision with root package name */
    public EditText f12417n0;

    /* renamed from: o0, reason: collision with root package name */
    public View f12418o0;

    /* renamed from: p0, reason: collision with root package name */
    public View f12419p0;

    /* renamed from: q0, reason: collision with root package name */
    public LinearLayout f12420q0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends x.b {

        /* renamed from: c, reason: collision with root package name */
        public float f12421c;

        /* renamed from: d, reason: collision with root package name */
        public float f12422d;

        public a(int i10) {
            super(i10);
        }

        @Override // x.x.b
        public void c(x.x xVar) {
            if ((xVar.c() & k0.m.c()) == 0) {
                return;
            }
            this.f12421c = w0.this.f12420q0.getBottom();
        }

        @Override // x.x.b
        public x.k0 d(x.k0 k0Var, List list) {
            x.x xVar;
            if (this.f12421c != this.f12422d) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        xVar = null;
                        break;
                    }
                    xVar = (x.x) it.next();
                    if ((xVar.c() & k0.m.c()) != 0) {
                        break;
                    }
                }
                if (xVar != null) {
                    w0.this.f12420q0.setTranslationY((this.f12421c - this.f12422d) * (1.0f - xVar.b()));
                }
            }
            return k0Var;
        }

        @Override // x.x.b
        public x.a e(x.x xVar, x.a aVar) {
            if ((xVar.c() & k0.m.c()) == 0) {
                return aVar;
            }
            x.k0 k0VarY = x.r.y(w0.this.f12420q0);
            if (k0VarY == null) {
                this.f12422d = this.f12421c;
                return aVar;
            }
            if (k0VarY.k(k0.m.c())) {
                this.f12422d = w0.this.f12420q0.getBottom() - (aVar.b().f11468d - aVar.a().f11468d);
                return aVar;
            }
            this.f12422d = w0.this.f12420q0.getBottom() + (aVar.b().f11468d - aVar.a().f11468d);
            return aVar;
        }
    }

    public static /* synthetic */ boolean V2(w0 w0Var, View view, int i10, KeyEvent keyEvent) {
        w0Var.getClass();
        if (i10 != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            w0Var.h3(w0Var.f12417n0.getText().toString(), true);
        }
        return true;
    }

    public static /* synthetic */ void Z2(w0 w0Var, EditText editText) {
        w0Var.getClass();
        x8.g.h(editText);
        editText.setHint(x7.u.Tb);
        editText.setImeOptions(2);
        editText.setInputType(655360);
        editText.setSelectAllOnFocus(true);
        editText.setTextColor(g6.e.a(w0Var.I(), x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(w0Var.I(), x7.k.f13665k));
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setImportantForAutofill(2);
        }
        editText.setTextSize(0, g6.f.d(w0Var.I(), x7.n.A));
        editText.setMaxLines(999);
        editText.setSingleLine(false);
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        editText.setLineSpacing(editText.getLineSpacingExtra(), 1.2f);
        r3.n(editText);
        x8.g.d(editText);
    }

    public static /* synthetic */ void a3(View view) {
    }

    public static /* synthetic */ void b3(q4.b bVar) {
        bVar.setFillViewport(true);
        r3.f(bVar);
        r3.h(bVar);
    }

    public static /* synthetic */ void c3(w0 w0Var, ImageView imageView) {
        w0Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.f13736j0, x7.u.he));
        imageView.setContentDescription(w0Var.Z0(x7.u.Tb));
    }

    public static /* synthetic */ void d3(w0 w0Var, ImageView imageView) {
        w0Var.getClass();
        r3.m(imageView);
        imageView.setImageDrawable(lb.b.a(imageView.getContext(), x7.o.A, x7.u.Vd));
        imageView.setContentDescription(w0Var.Z0(x7.u.f14072m3));
    }

    public static Bundle f3(String str, int[] iArr) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putIntArray("selection", iArr);
        return bundle;
    }

    private void g3() {
        N0().e1();
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int iD = g6.f.d(I(), x7.n.f13683b);
        int iD2 = g6.f.d(I(), x7.n.D);
        int iH = g6.y.h(I(), 16.0f) - iD2;
        this.f12419p0 = new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(iD, iD)).o(g6.y.l()).d(x7.o.f13726g).E(iD2).w(iH).V(new a.InterfaceC0076a() { // from class: tb.m0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                w0.d3(this.f12397a, (ImageView) obj);
            }
        }).l();
        this.f12418o0 = new h6.a(new ImageView(I()), new FrameLayout.LayoutParams(iD, iD)).o(g6.y.l()).d(x7.o.f13726g).E(iD2).w(iH).V(new a.InterfaceC0076a() { // from class: tb.n0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                w0.c3(this.f12399a, (ImageView) obj);
            }
        }).l();
        Space space = (Space) new h6.a(new Space(I()), new LinearLayout.LayoutParams(0, -2)).W(1.0f).l();
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(I()), new FrameLayout.LayoutParams(-1, -2)).p(80).V(new a.InterfaceC0076a() { // from class: tb.o0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        this.f12420q0 = linearLayout;
        linearLayout.addView(this.f12419p0);
        this.f12420q0.addView(space);
        this.f12420q0.addView(this.f12418o0);
        ScrollView scrollView = (ScrollView) new h6.a(new q4.b(I()), new FrameLayout.LayoutParams(-1, -1)).s(g6.f.d(I(), x7.n.f13683b)).V(new a.InterfaceC0076a() { // from class: tb.p0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                w0.b3((q4.b) obj);
            }
        }).l();
        this.f12417n0 = (EditText) new h6.a(new EditText(I()), new FrameLayout.LayoutParams(-1, -2)).o(g6.y.l()).f(0).E(g6.y.h(I(), 16.0f)).V(new a.InterfaceC0076a() { // from class: tb.q0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                w0.Z2(this.f12403a, (EditText) obj);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -1)).f(g6.e.a(I(), x7.k.f13656b)).l();
        this.f12416m0 = frameLayout;
        frameLayout.addView(this.f12420q0);
        scrollView.addView(this.f12417n0);
        this.f12416m0.addView(scrollView);
        this.f12416m0.setDescendantFocusability(262144);
        return this.f12416m0;
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        int i10;
        super.X1(view, bundle);
        if (y0() != null) {
            String string = y0().getString("url", "");
            this.f12417n0.setText(string);
            int[] intArray = y0().getIntArray("selection");
            if (intArray == null || intArray.length != 2 || (i10 = intArray[0]) == -1) {
                this.f12417n0.setSelection(string.length());
            } else {
                this.f12417n0.setSelection(i10, intArray[1]);
            }
        }
        this.f12419p0.setOnClickListener(new View.OnClickListener() { // from class: tb.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0 w0Var = this.f12405a;
                w0Var.h3(w0Var.f12417n0.getText().toString(), false);
            }
        });
        this.f12418o0.setOnClickListener(new View.OnClickListener() { // from class: tb.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0 w0Var = this.f12407a;
                w0Var.h3(w0Var.f12417n0.getText().toString(), true);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: tb.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0.a3(view2);
            }
        });
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        this.f12417n0.setOnKeyListener(new View.OnKeyListener() { // from class: tb.u0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i11, KeyEvent keyEvent) {
                return w0.V2(this.f12411a, view2, i11, keyEvent);
            }
        });
        this.f12417n0.post(new Runnable() { // from class: tb.v0
            @Override // java.lang.Runnable
            public final void run() {
                z8.f.l(this.f12412e.f12417n0);
            }
        });
        l3.b(this.f12416m0);
        x.r.j0(this.f12420q0, new a(0));
    }

    public final void h3(String str, boolean z10) {
        if (str == null || this.f12417n0 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("resultUrl", str);
        bundle.putBoolean("resultGo", z10);
        bundle.putIntArray("resultSelection", new int[]{this.f12417n0.getSelectionStart(), this.f12417n0.getSelectionEnd()});
        N0().x1("resultUrl", bundle);
        g3();
    }
}
