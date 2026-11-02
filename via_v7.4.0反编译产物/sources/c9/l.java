package c9;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import c9.o;
import h6.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l extends y5.a {

    /* renamed from: d, reason: collision with root package name */
    public static final int f3008d = g6.y.l();

    /* renamed from: e, reason: collision with root package name */
    public static final int f3009e = g6.y.l();

    /* renamed from: f, reason: collision with root package name */
    public static final int f3010f = g6.y.l();

    /* renamed from: g, reason: collision with root package name */
    public static final int f3011g = g6.y.l();

    /* renamed from: h, reason: collision with root package name */
    public static final int f3012h = g6.y.l();

    /* renamed from: i, reason: collision with root package name */
    public static final int f3013i = g6.y.l();

    /* renamed from: c, reason: collision with root package name */
    public c0 f3014c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b6.g f3015c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f3016d;

        public a(b6.g gVar, g gVar2) {
            this.f3015c = gVar;
            this.f3016d = gVar2;
        }

        @Override // v5.c
        public void a(View view) {
            if (l.this.f14455a != null) {
                l.this.f14455a.a(view, this.f3015c.l(), this.f3016d);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b6.g f3018a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f3019b;

        public b(b6.g gVar, g gVar2) {
            this.f3018a = gVar;
            this.f3019b = gVar2;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return l.this.f14456b != null && l.this.f14456b.a(view, this.f3018a.l(), this.f3019b);
        }
    }

    public static /* synthetic */ void m(Context context, TextView textView) {
        x8.g.l(textView);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setAllCaps(true);
        x8.g.m(textView, x8.h.r(context));
        textView.setText(context.getString(x7.u.f14028j1));
        x8.g.d(textView);
    }

    public static /* synthetic */ void o(Context context, TextView textView) {
        x8.g.l(textView);
        x8.g.m(textView, x8.h.r(context));
        textView.setSpannableFactory(t6.d.a());
        textView.setTextIsSelectable(true);
        textView.setMovementMethod(o6.a.a());
        o oVar = new o(textView);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new o.a(f3008d, context.getString(x7.u.C2)));
        arrayList.add(new o.a(f3009e, context.getString(x7.u.W)));
        arrayList.add(new o.a(f3010f, context.getString(x7.u.f14215x)));
        oVar.a(arrayList);
        textView.setCustomSelectionActionModeCallback(oVar);
        x8.g.d(textView);
    }

    @Override // y5.d
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void b(b6.g gVar, final g gVar2) {
        final TextView textView = (TextView) gVar.P(f3012h);
        textView.setText(gVar2.a());
        ActionMode.Callback customSelectionActionModeCallback = textView.getCustomSelectionActionModeCallback();
        if (customSelectionActionModeCallback instanceof o) {
            ((o) customSelectionActionModeCallback).b(new o.b() { // from class: c9.k
                @Override // c9.o.b
                public final void a(o.a aVar, CharSequence charSequence) {
                    this.f3004a.w(textView, aVar, charSequence, gVar2);
                }
            });
        }
        View viewP = gVar.P(f3013i);
        viewP.setOnClickListener(new a(gVar, gVar2));
        viewP.setOnLongClickListener(new b(gVar, gVar2));
    }

    @Override // y5.d
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void c(b6.g gVar, g gVar2, List list) {
        if (list.isEmpty()) {
            b(gVar, gVar2);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof CharSequence) {
                gVar.X(f3012h, gVar2.a());
            }
        }
    }

    @Override // y5.d
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public b6.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-1, -2)).F(1, 16).V(new a.InterfaceC0076a() { // from class: c9.h
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                ((LinearLayout) obj).setOrientation(1);
            }
        }).l();
        TextView textView = (TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-1, -2)).o(f3011g).J(1, 4).V(new a.InterfaceC0076a() { // from class: c9.i
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                l.m(context, (TextView) obj);
            }
        }).l();
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(context), new LinearLayout.LayoutParams(-2, -2)).o(f3013i).F(1, 8).e(new g6.g().h(360743040).j(813727872).c(x8.h.e(context)).a()).l();
        TextView textView2 = (TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -2)).o(f3012h).V(new a.InterfaceC0076a() { // from class: c9.j
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                l.o(context, (TextView) obj);
            }
        }).l();
        linearLayout.addView(textView);
        frameLayout.addView(textView2);
        linearLayout.addView(frameLayout);
        return new b6.g(linearLayout);
    }

    public final void w(View view, o.a aVar, CharSequence charSequence, g gVar) {
        c0 c0Var = this.f3014c;
        if (c0Var != null) {
            c0Var.a(view, aVar, charSequence, gVar);
        }
    }

    public void x(c0 c0Var) {
        this.f3014c = c0Var;
    }
}
