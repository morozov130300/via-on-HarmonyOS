package mark.via.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import h6.a;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r0 extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public RecyclerView f9734e;

    /* renamed from: j, reason: collision with root package name */
    public ViewGroup f9735j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f9736k;

    /* renamed from: l, reason: collision with root package name */
    public EditText f9737l;

    /* renamed from: m, reason: collision with root package name */
    public com.tuyafeng.support.widget.a0 f9738m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9739n;

    public r0(Context context) {
        this(context, null);
    }

    public r0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public r0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c();
    }

    public static /* synthetic */ void a(Context context, EditText editText) {
        x8.g.h(editText);
        editText.setTextSize(0, x8.h.r(context));
        editText.setTextColor(g6.e.a(context, x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(context, x7.k.f13664j));
        editText.setCompoundDrawablePadding(g6.y.h(context, 12.0f));
        editText.setHint(x7.u.Tb);
        editText.setInputType(1);
        editText.setImeOptions(6);
        g6.y.P(editText, lb.b.a(context, x7.o.f13783z, x7.u.Ud));
        r3.n(editText);
        x8.g.d(editText);
    }

    public static /* synthetic */ void b(v0 v0Var) {
        v0Var.setLayoutManager(new LinearLayoutManager(v0Var.getContext()));
        v0Var.setItemAnimator(new androidx.recyclerview.widget.e());
        r3.d(v0Var);
        r3.h(v0Var);
    }

    public final void c() {
        setOrientation(1);
        final Context context = getContext();
        this.f9734e = (RecyclerView) new h6.a(new v0(context), new LinearLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.p0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                r0.b((v0) obj);
            }
        }).l();
        ViewGroup viewGroup = (ViewGroup) new h6.a(new FrameLayout(context), new LinearLayout.LayoutParams(-1, 0)).W(1.0f).l();
        this.f9735j = viewGroup;
        viewGroup.addView(this.f9734e);
        this.f9737l = (EditText) new h6.a(new EditText(context), new FrameLayout.LayoutParams(-1, -2)).w(g6.y.h(context, 14.0f)).C(g6.y.h(context, 10.0f)).M(g6.y.h(context, 16.0f)).S(g6.y.h(context, 10.0f)).d(x7.o.f13708a).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.q0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                r0.a(context, (EditText) obj);
            }
        }).l();
        this.f9736k = r3.b(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.f9736k.setLayoutParams(layoutParams);
        this.f9736k.setVisibility(8);
        this.f9738m = (com.tuyafeng.support.widget.a0) new h6.a(new com.tuyafeng.support.widget.a0(context), new FrameLayout.LayoutParams(-1, -2)).p(80).l();
        addView(this.f9737l);
        addView(this.f9735j);
        addView(this.f9736k);
        addView(this.f9738m);
    }

    public void setEmpty(boolean z10) {
        if (z10 == this.f9739n) {
            return;
        }
        this.f9739n = z10;
        this.f9736k.setVisibility(z10 ? 0 : 8);
        this.f9735j.setVisibility(z10 ? 8 : 0);
    }
}
