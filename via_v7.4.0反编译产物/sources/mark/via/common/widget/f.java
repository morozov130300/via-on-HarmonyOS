package mark.via.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import h6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.common.widget.f;
import z8.r3;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public y5.f f9621e;

    /* renamed from: j, reason: collision with root package name */
    public final List f9622j;

    /* renamed from: k, reason: collision with root package name */
    public e f9623k;

    /* renamed from: l, reason: collision with root package name */
    public int f9624l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f9625m;

    /* renamed from: n, reason: collision with root package name */
    public v9.f f9626n;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {
        public a() {
        }

        @Override // v5.c
        public void a(View view) {
            if (f.this.f9623k != null) {
                if (f.this.f9626n != null) {
                    f.this.setPassDetail(null);
                } else {
                    f.this.f9623k.a();
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends y5.a {
        public b() {
        }

        public static /* synthetic */ void l(Context context, TextView textView) {
            r3.p(textView);
            x8.g.m(textView, x8.h.r(textView.getContext()));
            textView.setGravity(17);
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextColor(x8.h.p(context));
        }

        @Override // y5.d
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(b6.g gVar, v9.f fVar) {
            super.b(gVar, fVar);
            TextView textView = (TextView) gVar.f1219a;
            textView.setText(fVar.h());
            textView.setMaxWidth(f.this.f9624l);
            x8.g.d(textView);
        }

        @Override // y5.d
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b6.g d(final Context context, ViewGroup viewGroup) {
            return new b6.g((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).d(x7.o.f13720e).N(1, 8).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.g
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    f.b.l(context, (TextView) obj);
                }
            }).l());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends y5.a {
        public c() {
        }

        public static /* synthetic */ void l(c cVar, Context context, TextView textView) {
            cVar.getClass();
            r3.p(textView);
            x8.g.m(textView, x8.h.r(textView.getContext()));
            textView.setGravity(17);
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextColor(x8.h.p(context));
            textView.setCompoundDrawablePadding(g6.y.h(f.this.getContext(), 2.0f));
            Drawable drawableA = lb.b.a(f.this.getContext(), x7.o.C, 0);
            g6.h.a(drawableA, g6.e.a(f.this.getContext(), x7.k.f13662h));
            int iH = g6.y.h(f.this.getContext(), 18.0f);
            drawableA.setBounds(0, 0, iH, iH);
            androidx.core.widget.c.a(textView, null, null, drawableA, null);
        }

        @Override // y5.d
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(b6.g gVar, String str) {
            super.b(gVar, str);
            boolean z10 = gVar.l() == 1;
            TextView textView = (TextView) gVar.f1219a;
            if (z10) {
                StringBuilder sb2 = new StringBuilder();
                int length = str.length();
                for (int i10 = 0; i10 < length; i10++) {
                    sb2.append('*');
                }
                textView.setText(sb2);
            } else {
                textView.setText(str);
            }
            textView.setMaxWidth(f.this.f9624l);
            x8.g.d(textView);
        }

        @Override // y5.d
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b6.g d(final Context context, ViewGroup viewGroup) {
            return new b6.g((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).d(x7.o.f13720e).N(1, 8).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.h
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    f.c.l(this.f9652a, context, (TextView) obj);
                }
            }).l());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends f.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f9630a;

        public d(List list) {
            this.f9630a = list;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean a(int i10, int i11) {
            return this.f9630a.get(i11).equals(f.this.f9621e.H().get(i10));
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean b(int i10, int i11) {
            Object obj = f.this.f9621e.H().get(i10);
            Object obj2 = this.f9630a.get(i11);
            if (obj.getClass() != obj2.getClass()) {
                return false;
            }
            return obj instanceof v9.f ? u1.a(((v9.f) obj).b(), ((v9.f) obj2).b()) : obj instanceof String;
        }

        @Override // androidx.recyclerview.widget.f.b
        public int d() {
            return this.f9630a.size();
        }

        @Override // androidx.recyclerview.widget.f.b
        public int e() {
            return f.this.f9621e.g();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface e {
        void a();

        void b(v9.f fVar);

        void c();
    }

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9622j = new ArrayList();
        this.f9624l = -1;
        k();
    }

    public static /* synthetic */ boolean a(f fVar, View view) {
        e eVar = fVar.f9623k;
        if (eVar == null) {
            return true;
        }
        eVar.c();
        return true;
    }

    public static /* synthetic */ void b(final f fVar, ImageView imageView) {
        g6.y.S(x8.h.l(fVar.getContext()), imageView);
        imageView.setImageDrawable(lb.b.a(fVar.getContext(), x7.o.L0, x7.u.df));
        imageView.setContentDescription(fVar.getContext().getString(x7.u.f14065la));
        imageView.setOnClickListener(fVar.new a());
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: mark.via.common.widget.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return f.a(this.f9619a, view);
            }
        });
    }

    public static /* synthetic */ void c(f fVar, RecyclerView recyclerView) {
        fVar.getClass();
        recyclerView.setClipToPadding(false);
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        recyclerView.setLayoutManager(new LinearLayoutManager(fVar.getContext(), 0, false));
        recyclerView.k(new com.tuyafeng.support.widget.x(g6.y.h(fVar.getContext(), 6.0f), g6.y.h(fVar.getContext(), 4.0f)));
        r3.d(recyclerView);
    }

    public static /* synthetic */ void e(f fVar, View view, int i10, v9.f fVar2) {
        e eVar = fVar.f9623k;
        if (eVar != null) {
            eVar.b(fVar2);
        }
    }

    public final List j() {
        if (this.f9626n == null) {
            return new ArrayList(this.f9622j);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f9626n.h());
        arrayList.add(this.f9626n.e());
        return arrayList;
    }

    public final void k() {
        m(0);
        RecyclerView recyclerView = (RecyclerView) new h6.a(new RecyclerView(getContext()), new FrameLayout.LayoutParams(-1, -1)).N(1, 12).v(1, 72).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.a
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                f.c(this.f9607a, (RecyclerView) obj);
            }
        }).l();
        addView(recyclerView);
        ImageView imageView = (ImageView) new h6.a(new ImageView(getContext()), new FrameLayout.LayoutParams(-2, -1)).Y(1, 48).p(8388613).v(1, 12).D(1, 5).T(1, 4).N(1, 13).d(x7.o.f13720e).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.b
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                f.b(this.f9609a, (ImageView) obj);
            }
        }).l();
        this.f9625m = imageView;
        addView(imageView);
        this.f9621e = new y5.f(Collections.EMPTY_LIST);
        b bVar = new b();
        bVar.j(new y5.g() { // from class: mark.via.common.widget.c
            @Override // y5.g
            public final void a(View view, int i10, Object obj) {
                f.e(this.f9613a, view, i10, (v9.f) obj);
            }
        });
        c cVar = new c();
        cVar.j(new y5.g() { // from class: mark.via.common.widget.d
            @Override // y5.g
            public final void a(View view, int i10, Object obj) {
                f fVar = this.f9615a;
                g6.n.c(fVar.getContext(), (String) obj, i10 == 1, fVar.getContext().getString(x7.u.og));
            }
        });
        this.f9621e.K(v9.f.class, bVar);
        this.f9621e.K(String.class, cVar);
        recyclerView.setAdapter(this.f9621e);
    }

    public final void l(List list) {
        if (m(list.size())) {
            this.f9621e.M(list);
            this.f9621e.l();
        } else {
            f.e eVarB = androidx.recyclerview.widget.f.b(new d(list));
            this.f9621e.M(list);
            eVarB.c(this.f9621e);
        }
    }

    public final boolean m(int i10) {
        int iH = i10 >= 3 ? g6.y.h(getContext(), 120.0f) : g6.y.h(getContext(), 200.0f);
        if (iH == this.f9624l) {
            return false;
        }
        this.f9624l = iH;
        return true;
    }

    public void setCallback(e eVar) {
        this.f9623k = eVar;
    }

    public void setPassDetail(v9.f fVar) {
        if (fVar == null && this.f9626n == null) {
            return;
        }
        this.f9626n = fVar;
        if (fVar != null) {
            this.f9625m.setImageDrawable(lb.b.a(getContext(), x7.o.f13783z, x7.u.Ud));
            this.f9625m.setContentDescription(getContext().getString(x7.u.C8));
        } else {
            this.f9625m.setImageDrawable(lb.b.a(getContext(), x7.o.L0, x7.u.df));
            this.f9625m.setContentDescription(getContext().getString(x7.u.f14065la));
        }
        l(j());
    }

    public void setPassList(List<v9.f> list) {
        this.f9622j.clear();
        if (list != null && !list.isEmpty()) {
            this.f9622j.addAll(list);
        }
        if (this.f9626n == null) {
            l(j());
        } else {
            setPassDetail(null);
            this.f9621e.l();
        }
    }
}
