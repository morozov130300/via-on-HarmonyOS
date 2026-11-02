package c9;

import android.content.Context;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import c9.o;
import h6.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g0 extends y5.a {

    /* renamed from: d, reason: collision with root package name */
    public static final int f2994d = g6.y.l();

    /* renamed from: e, reason: collision with root package name */
    public static final int f2995e = g6.y.l();

    /* renamed from: f, reason: collision with root package name */
    public static final int f2996f = g6.y.l();

    /* renamed from: g, reason: collision with root package name */
    public static final int f2997g = g6.y.l();

    /* renamed from: c, reason: collision with root package name */
    public c0 f2998c;

    public static /* synthetic */ void m(Context context, TextView textView) {
        textView.setTextColor(g6.e.a(context, x7.k.f13663i));
        x8.g.m(textView, x8.h.r(context));
        textView.setSpannableFactory(t6.d.a());
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(o6.a.a());
        o oVar = new o(textView);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new o.a(f2994d, context.getString(x7.u.C2)));
        arrayList.add(new o.a(f2995e, context.getString(x7.u.W)));
        arrayList.add(new o.a(f2996f, context.getString(x7.u.f14215x)));
        oVar.a(arrayList);
        textView.setCustomSelectionActionModeCallback(oVar);
        x8.g.d(textView);
    }

    @Override // y5.d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, final d0 d0Var) {
        super.b(gVar, d0Var);
        final TextView textView = (TextView) gVar.P(f2997g);
        textView.setText(d0Var.a());
        ActionMode.Callback customSelectionActionModeCallback = textView.getCustomSelectionActionModeCallback();
        if (customSelectionActionModeCallback instanceof o) {
            ((o) customSelectionActionModeCallback).b(new o.b() { // from class: c9.f0
                @Override // c9.o.b
                public final void a(o.a aVar, CharSequence charSequence) {
                    this.f2989a.q(textView, aVar, charSequence, d0Var);
                }
            });
        }
    }

    @Override // y5.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void c(b6.g gVar, d0 d0Var, List list) {
        if (list.isEmpty()) {
            b(gVar, d0Var);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof CharSequence) {
                gVar.X(f2997g, d0Var.a());
            }
        }
    }

    @Override // y5.d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(context), new FrameLayout.LayoutParams(-1, -2)).F(1, 16).l();
        frameLayout.addView((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -2)).o(f2997g).F(1, 8).p(8388613).z(1, 32).e(new g6.g().h(g6.e.a(context, x7.k.f13660f)).c(x8.h.e(context)).a()).V(new a.InterfaceC0076a() { // from class: c9.e0
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                g0.m(context, (TextView) obj);
            }
        }).l());
        return new b6.g(frameLayout);
    }

    public final void q(View view, o.a aVar, CharSequence charSequence, d0 d0Var) {
        c0 c0Var = this.f2998c;
        if (c0Var != null) {
            c0Var.a(view, aVar, charSequence, d0Var);
        }
    }

    public void r(c0 c0Var) {
        this.f2998c = c0Var;
    }
}
