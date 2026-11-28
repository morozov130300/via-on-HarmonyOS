package a9;

import android.content.Context;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g0 extends t5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f223d = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f224e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f225f = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f226g = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0 f227c;

    public static /* synthetic */ void m(Context context, TextView textView) {
        textView.setTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13730j));
        v8.g.m(textView, v8.h.q(context));
        textView.setSpannableFactory(n6.d.a());
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(i6.a.a());
        o oVar = new o(textView);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new o.a(f223d, context.getString(w7.u.O2)));
        arrayList.add(new o.a(f224e, context.getString(w7.u.X)));
        arrayList.add(new o.a(f225f, context.getString(w7.u.f14298y)));
        oVar.a(arrayList);
        textView.setCustomSelectionActionModeCallback(oVar);
        v8.g.d(textView);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, final d0 d0Var) {
        super.b(gVar, d0Var);
        final TextView textView = (TextView) gVar.P(f226g);
        textView.setText(d0Var.a());
        ActionMode.Callback customSelectionActionModeCallback = textView.getCustomSelectionActionModeCallback();
        if (customSelectionActionModeCallback instanceof o) {
            ((o) customSelectionActionModeCallback).b(new o.b() { // from class: a9.f0
                @Override // a9.o.b
                public final void a(o.a aVar, CharSequence charSequence) {
                    this.f218a.q(textView, aVar, charSequence, d0Var);
                }
            });
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void c(w5.g gVar, d0 d0Var, List list) {
        if (list.isEmpty()) {
            b(gVar, d0Var);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof CharSequence) {
                gVar.X(f226g, d0Var.a());
            }
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(context), new FrameLayout.LayoutParams(-1, -2)).F(1, 16).l();
        frameLayout.addView((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -2)).o(f226g).F(1, 8).p(8388613).z(1, 32).e(new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.e.a(context, w7.k.f13727g)).c(v8.h.e(context)).a()).V(new b6.a.InterfaceC0033a() { // from class: a9.e0
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                g0.m(context, (TextView) obj);
            }
        }).l());
        return new w5.g(frameLayout);
    }

    public final void q(View view, o.a aVar, CharSequence charSequence, d0 d0Var) {
        c0 c0Var = this.f227c;
        if (c0Var != null) {
            c0Var.a(view, aVar, charSequence, d0Var);
        }
    }

    public void r(c0 c0Var) {
        this.f227c = c0Var;
    }
}
