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
import java.util.Iterator;
import java.util.List;
import x8.h3;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w0 extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public FrameLayout f12713o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public EditText f12714p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public View f12715q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public View f12716r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public LinearLayout f12717s0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends y.x.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f12718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f12719d;

        public a(int i10) {
            super(i10);
        }

        @Override // y.x.b
        public void b(y.x xVar) {
            if ((xVar.c() & y.k0.m.c()) != 0) {
                w0.this.f12717s0.setTranslationY(0.0f);
            }
        }

        @Override // y.x.b
        public void c(y.x xVar) {
            if ((xVar.c() & y.k0.m.c()) == 0) {
                return;
            }
            this.f12718c = w0.this.f12717s0.getBottom() + w0.this.f12717s0.getTranslationY();
        }

        @Override // y.x.b
        public y.k0 d(y.k0 k0Var, List list) {
            y.x xVar;
            if (this.f12718c != this.f12719d) {
                Iterator it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        xVar = null;
                        break;
                    }
                    xVar = (y.x) it.next();
                } while ((xVar.c() & y.k0.m.c()) == 0);
                if (xVar != null) {
                    w0.this.f12717s0.setTranslationY((this.f12718c - this.f12719d) * (1.0f - xVar.b()));
                }
            }
            return k0Var;
        }

        @Override // y.x.b
        public y.x.a e(y.x xVar, y.x.a aVar) {
            if ((xVar.c() & y.k0.m.c()) == 0) {
                return aVar;
            }
            this.f12719d = w0.this.f12717s0.getBottom();
            return aVar;
        }
    }

    public static /* synthetic */ boolean T2(w0 w0Var, View view, int i10, KeyEvent keyEvent) {
        w0Var.getClass();
        if (i10 != 66) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            w0Var.f3(w0Var.f12714p0.getText().toString(), true);
        }
        return true;
    }

    public static /* synthetic */ void X2(r5.b bVar) {
        bVar.setFillViewport(true);
        r3.g(bVar);
        r3.i(bVar);
    }

    public static /* synthetic */ void Y2(w0 w0Var, EditText editText) {
        w0Var.getClass();
        v8.g.h(editText);
        editText.setHint(w7.u.f14063gc);
        editText.setImeOptions(2);
        editText.setInputType(655360);
        editText.setSelectAllOnFocus(true);
        editText.setTextColor(com.tuyafeng.support.utils.e.a(w0Var.G(), w7.k.f13732l));
        editText.setHintTextColor(com.tuyafeng.support.utils.e.a(w0Var.G(), w7.k.f13732l));
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setImportantForAutofill(2);
        }
        editText.setTextSize(0, com.tuyafeng.support.utils.f.d(w0Var.G(), w7.n.C));
        editText.setMaxLines(999);
        editText.setSingleLine(false);
        editText.setHorizontallyScrolling(false);
        editText.setGravity(48);
        editText.setLineSpacing(editText.getLineSpacingExtra(), 1.2f);
        r3.o(editText);
        v8.g.d(editText);
    }

    public static /* synthetic */ void a3(w0 w0Var, ImageView imageView) {
        w0Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.f13802j0, w7.u.xe));
        imageView.setContentDescription(w0Var.X0(w7.u.f14063gc));
    }

    public static /* synthetic */ void b3(w0 w0Var, ImageView imageView) {
        w0Var.getClass();
        r3.n(imageView);
        imageView.setImageDrawable(lb.g.a(imageView.getContext(), w7.o.f13849z, w7.u.ke));
        imageView.setContentDescription(w0Var.X0(w7.u.f14315z3));
    }

    public static Bundle d3(String str, int[] iArr) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putIntArray("selection", iArr);
        return bundle;
    }

    private void e3() {
        L0().e1();
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int iD = com.tuyafeng.support.utils.f.d(G(), w7.n.f13749b);
        int iD2 = com.tuyafeng.support.utils.f.d(G(), w7.n.F);
        int iH = com.tuyafeng.support.utils.x.h(G(), 16.0f) - iD2;
        this.f12716r0 = new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(iD, iD)).o(com.tuyafeng.support.utils.x.l()).d(w7.o.f13789f).E(iD2).w(iH).V(new b6.a.InterfaceC0033a() { // from class: tb.m0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                w0.b3(this.f12695a, (ImageView) obj);
            }
        }).l();
        this.f12715q0 = new b6.a(new ImageView(G()), new FrameLayout.LayoutParams(iD, iD)).o(com.tuyafeng.support.utils.x.l()).d(w7.o.f13789f).E(iD2).w(iH).V(new b6.a.InterfaceC0033a() { // from class: tb.n0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                w0.a3(this.f12697a, (ImageView) obj);
            }
        }).l();
        Space space = (Space) new b6.a(new Space(G()), new LinearLayout.LayoutParams(0, -2)).W(1.0f).l();
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(G()), new FrameLayout.LayoutParams(-1, -2)).p(80).V(new b6.a.InterfaceC0033a() { // from class: tb.o0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(0);
            }
        }).l();
        this.f12717s0 = linearLayout;
        linearLayout.addView(this.f12716r0);
        this.f12717s0.addView(space);
        this.f12717s0.addView(this.f12715q0);
        ScrollView scrollView = (ScrollView) new b6.a(new r5.b(G()), new FrameLayout.LayoutParams(-1, -1)).s(com.tuyafeng.support.utils.f.d(G(), w7.n.f13749b)).V(new b6.a.InterfaceC0033a() { // from class: tb.p0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                w0.X2((r5.b) obj);
            }
        }).l();
        this.f12714p0 = (EditText) new b6.a(new EditText(G()), new FrameLayout.LayoutParams(-1, -2)).o(com.tuyafeng.support.utils.x.l()).f(0).E(com.tuyafeng.support.utils.x.h(G(), 16.0f)).V(new b6.a.InterfaceC0033a() { // from class: tb.q0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                w0.Y2(this.f12700a, (EditText) obj);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).f(com.tuyafeng.support.utils.e.a(G(), w7.k.f13723c)).l();
        this.f12713o0 = frameLayout;
        frameLayout.addView(this.f12717s0);
        scrollView.addView(this.f12714p0);
        this.f12713o0.addView(scrollView);
        this.f12713o0.setDescendantFocusability(262144);
        return this.f12713o0;
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        int i10;
        super.V1(view, bundle);
        if (w0() != null) {
            String string = w0().getString("url", "");
            this.f12714p0.setText(string);
            int[] intArray = w0().getIntArray("selection");
            if (intArray == null || intArray.length != 2 || (i10 = intArray[0]) == -1) {
                this.f12714p0.setSelection(string.length());
            } else {
                this.f12714p0.setSelection(i10, intArray[1]);
            }
        }
        this.f12716r0.setOnClickListener(new View.OnClickListener() { // from class: tb.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0 w0Var = this.f12702a;
                w0Var.f3(w0Var.f12714p0.getText().toString(), false);
            }
        });
        this.f12715q0.setOnClickListener(new View.OnClickListener() { // from class: tb.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0 w0Var = this.f12704a;
                w0Var.f3(w0Var.f12714p0.getText().toString(), true);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: tb.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w0.Z2(view2);
            }
        });
        view.setFocusable(false);
        view.setFocusableInTouchMode(false);
        this.f12714p0.setOnKeyListener(new View.OnKeyListener() { // from class: tb.u0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i11, KeyEvent keyEvent) {
                return w0.T2(this.f12707a, view2, i11, keyEvent);
            }
        });
        this.f12714p0.post(new Runnable() { // from class: tb.v0
            @Override // java.lang.Runnable
            public final void run() {
                x8.f.l(this.f12709c.f12714p0);
            }
        });
        h3.e(this.f12713o0);
        y.r.k0(this.f12717s0, new a(0));
    }

    public final void f3(String str, boolean z10) {
        if (str == null || this.f12714p0 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("resultUrl", str);
        bundle.putBoolean("resultGo", z10);
        bundle.putIntArray("resultSelection", new int[]{this.f12714p0.getSelectionStart(), this.f12714p0.getSelectionEnd()});
        L0().y1("resultUrl", bundle);
        e3();
    }

    public static /* synthetic */ void Z2(View view) {
    }
}
