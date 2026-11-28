package mark.via.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class r0 extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f10038c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f10039e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f10040m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EditText f10041n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.tuyafeng.support.widget.f0 f10042o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f10043p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10044q;

    public r0(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(v0 v0Var) {
        v0Var.setLayoutManager(new LinearLayoutManager(v0Var.getContext()));
        v0Var.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.e(v0Var);
    }

    public static /* synthetic */ void b(r0 r0Var, Context context, EditText editText) {
        r0Var.getClass();
        v8.g.h(editText);
        editText.setTextSize(0, v8.h.q(context));
        editText.setCompoundDrawablePadding(com.tuyafeng.support.utils.x.h(context, 12.0f));
        editText.setHint(w7.u.f14063gc);
        editText.setInputType(1);
        editText.setImeOptions(6);
        Drawable drawableA = lb.g.a(context, w7.o.f13846y, w7.u.je);
        r0Var.f10043p = drawableA;
        com.tuyafeng.support.utils.x.Q(editText, drawableA);
        r3.o(editText);
        v8.g.d(editText);
    }

    public final void c() {
        setOrientation(1);
        final Context context = getContext();
        this.f10038c = (RecyclerView) new b6.a(new v0(context), new LinearLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.p0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                r0.a((v0) obj);
            }
        }).l();
        ViewGroup viewGroup = (ViewGroup) new b6.a(new FrameLayout(context), new LinearLayout.LayoutParams(-1, 0)).W(1.0f).l();
        this.f10039e = viewGroup;
        viewGroup.addView(this.f10038c);
        this.f10041n = (EditText) new b6.a(new EditText(context), new FrameLayout.LayoutParams(-1, -2)).w(com.tuyafeng.support.utils.x.h(context, 14.0f)).C(com.tuyafeng.support.utils.x.h(context, 10.0f)).M(com.tuyafeng.support.utils.x.h(context, 16.0f)).S(com.tuyafeng.support.utils.x.h(context, 10.0f)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.q0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                r0.b(this.f10033a, context, (EditText) obj);
            }
        }).l();
        this.f10040m = r3.b(context);
        this.f10040m.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f10040m.setVisibility(8);
        this.f10039e.addView(this.f10040m);
        this.f10042o = (com.tuyafeng.support.widget.f0) new b6.a(new com.tuyafeng.support.widget.f0(context), new FrameLayout.LayoutParams(-1, -2)).p(80).l();
        addView(this.f10041n);
        addView(this.f10039e);
        addView(this.f10042o);
        d();
    }

    public void d() {
        Context context = getContext();
        this.f10041n.setBackgroundResource(com.tuyafeng.support.utils.e.b(context, w7.k.f13721a));
        r3.k(this.f10041n);
        this.f10041n.setHintTextColor(v8.h.n(context));
        com.tuyafeng.support.utils.h.a(this.f10043p, v8.h.l(context));
        this.f10040m.setTextColor(v8.h.p(context));
        this.f10042o.i();
        r3.i(this.f10038c);
        r3.d(this.f10038c);
    }

    public void setEmpty(boolean z10) {
        if (z10 == this.f10044q) {
            return;
        }
        this.f10044q = z10;
        this.f10040m.setVisibility(z10 ? 0 : 8);
        this.f10038c.setVisibility(z10 ? 4 : 0);
    }

    public void setSearchVisible(boolean z10) {
        if (!z10 && this.f10041n.hasFocus()) {
            x8.f.e(this.f10041n);
            this.f10041n.clearFocus();
        }
        this.f10041n.setVisibility(z10 ? 0 : 8);
    }

    public r0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public r0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c();
    }
}
