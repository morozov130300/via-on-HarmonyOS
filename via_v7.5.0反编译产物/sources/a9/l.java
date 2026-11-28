package a9;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l extends t5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f237d = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f238e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f239f = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f240g = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f241h = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f242i = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0 f243c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w5.g f244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f245d;

        public a(w5.g gVar, g gVar2) {
            this.f244c = gVar;
            this.f245d = gVar2;
        }

        @Override // p5.c
        public void a(View view) {
            if (l.this.f12547a != null) {
                l.this.f12547a.a(view, this.f244c.l(), this.f245d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w5.g f247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f248b;

        public b(w5.g gVar, g gVar2) {
            this.f247a = gVar;
            this.f248b = gVar2;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return l.this.f12548b != null && l.this.f12548b.a(view, this.f247a.l(), this.f248b);
        }
    }

    public static /* synthetic */ void m(Context context, TextView textView) {
        v8.g.l(textView);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setAllCaps(true);
        v8.g.m(textView, v8.h.q(context));
        textView.setText(context.getString(w7.u.f14136m1));
        v8.g.d(textView);
    }

    public static /* synthetic */ void o(Context context, TextView textView) {
        v8.g.l(textView);
        v8.g.m(textView, v8.h.q(context));
        textView.setSpannableFactory(n6.d.a());
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(i6.a.a());
        o oVar = new o(textView);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new o.a(f237d, context.getString(w7.u.O2)));
        arrayList.add(new o.a(f238e, context.getString(w7.u.X)));
        arrayList.add(new o.a(f239f, context.getString(w7.u.f14298y)));
        oVar.a(arrayList);
        textView.setCustomSelectionActionModeCallback(oVar);
        v8.g.d(textView);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, final g gVar2) {
        final TextView textView = (TextView) gVar.P(f241h);
        textView.setText(gVar2.a());
        ActionMode.Callback customSelectionActionModeCallback = textView.getCustomSelectionActionModeCallback();
        if (customSelectionActionModeCallback instanceof o) {
            ((o) customSelectionActionModeCallback).b(new o.b() { // from class: a9.k
                @Override // a9.o.b
                public final void a(o.a aVar, CharSequence charSequence) {
                    this.f233a.w(textView, aVar, charSequence, gVar2);
                }
            });
        }
        View viewP = gVar.P(f242i);
        viewP.setOnClickListener(new a(gVar, gVar2));
        viewP.setOnLongClickListener(new b(gVar, gVar2));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void c(w5.g gVar, g gVar2, List list) {
        if (list.isEmpty()) {
            b(gVar, gVar2);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof CharSequence) {
                gVar.X(f241h, gVar2.a());
            }
        }
    }

    @Override // t5.d
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-1, -2)).F(1, 16).V(new b6.a.InterfaceC0033a() { // from class: a9.h
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        TextView textView = (TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).o(f240g).J(1, 4).V(new b6.a.InterfaceC0033a() { // from class: a9.i
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                l.m(context, (TextView) obj);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(context), new LinearLayout.LayoutParams(-2, -2)).o(f242i).F(1, 8).e(new com.tuyafeng.support.utils.g().h(360743040).j(813727872).c(v8.h.e(context)).a()).l();
        TextView textView2 = (TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -2)).o(f241h).V(new b6.a.InterfaceC0033a() { // from class: a9.j
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                l.o(context, (TextView) obj);
            }
        }).l();
        linearLayout.addView(textView);
        frameLayout.addView(textView2);
        linearLayout.addView(frameLayout);
        return new w5.g(linearLayout);
    }

    public final void w(View view, o.a aVar, CharSequence charSequence, g gVar) {
        c0 c0Var = this.f243c;
        if (c0Var != null) {
            c0Var.a(view, aVar, charSequence, gVar);
        }
    }

    public void x(c0 c0Var) {
        this.f243c = c0Var;
    }
}
