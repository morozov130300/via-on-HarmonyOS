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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x8.r3;
import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t5.f f9912c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f9913e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f9914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f9916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t9.f f9917p;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            if (f.this.f9914m != null) {
                if (f.this.f9917p != null) {
                    f.this.setPassDetail(null);
                } else {
                    f.this.f9914m.b();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends t5.a {
        public b() {
        }

        public static /* synthetic */ void l(Context context, TextView textView) {
            r3.q(textView);
            v8.g.m(textView, v8.h.q(textView.getContext()));
            textView.setGravity(17);
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextColor(v8.h.o(context));
        }

        @Override // t5.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(w5.g gVar, t9.f fVar) {
            super.b(gVar, fVar);
            TextView textView = (TextView) gVar.f1138a;
            textView.setText(fVar.h());
            textView.setMaxWidth(f.this.f9915n);
            v8.g.d(textView);
        }

        @Override // t5.d
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public w5.g d(final Context context, ViewGroup viewGroup) {
            return new w5.g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).d(w7.o.f13783d).N(1, 8).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.g
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    f.b.l(context, (TextView) obj);
                }
            }).l());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends t5.a {
        public c() {
        }

        public static /* synthetic */ void l(c cVar, Context context, TextView textView) {
            cVar.getClass();
            r3.q(textView);
            v8.g.m(textView, v8.h.q(textView.getContext()));
            textView.setGravity(17);
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setTextColor(v8.h.o(context));
            textView.setCompoundDrawablePadding(com.tuyafeng.support.utils.x.h(f.this.getContext(), 2.0f));
            Drawable drawableA = lb.g.a(f.this.getContext(), w7.o.B, 0);
            com.tuyafeng.support.utils.h.a(drawableA, com.tuyafeng.support.utils.e.a(f.this.getContext(), w7.k.f13729i));
            int iH = com.tuyafeng.support.utils.x.h(f.this.getContext(), 18.0f);
            drawableA.setBounds(0, 0, iH, iH);
            androidx.core.widget.d.a(textView, null, null, drawableA, null);
        }

        @Override // t5.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(w5.g gVar, String str) {
            super.b(gVar, str);
            boolean z10 = gVar.l() == 1;
            TextView textView = (TextView) gVar.f1138a;
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
            textView.setMaxWidth(f.this.f9915n);
            v8.g.d(textView);
        }

        @Override // t5.d
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public w5.g d(final Context context, ViewGroup viewGroup) {
            return new w5.g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).d(w7.o.f13783d).N(1, 8).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.h
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    f.c.l(this.f9943a, context, (TextView) obj);
                }
            }).l());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends androidx.recyclerview.widget.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f9921a;

        public d(List list) {
            this.f9921a = list;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean a(int i10, int i11) {
            return this.f9921a.get(i11).equals(f.this.f9912c.H().get(i10));
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean b(int i10, int i11) {
            Object obj = f.this.f9912c.H().get(i10);
            Object obj2 = this.f9921a.get(i11);
            if (obj.getClass() != obj2.getClass()) {
                return false;
            }
            if (obj instanceof t9.f) {
                return t1.a(((t9.f) obj).b(), ((t9.f) obj2).b());
            }
            return obj instanceof String;
        }

        @Override // androidx.recyclerview.widget.f.b
        public int d() {
            return this.f9921a.size();
        }

        @Override // androidx.recyclerview.widget.f.b
        public int e() {
            return f.this.f9912c.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface e {
        void a(t9.f fVar);

        void b();

        void c();
    }

    public f(Context context) {
        this(context, null);
    }

    public static /* synthetic */ boolean a(f fVar, View view) {
        e eVar = fVar.f9914m;
        if (eVar == null) {
            return true;
        }
        eVar.c();
        return true;
    }

    public static /* synthetic */ void b(final f fVar, ImageView imageView) {
        com.tuyafeng.support.utils.x.T(v8.h.l(fVar.getContext()), imageView);
        imageView.setImageDrawable(lb.g.a(fVar.getContext(), w7.o.J0, w7.u.uf));
        imageView.setContentDescription(fVar.getContext().getString(w7.u.f14296xa));
        imageView.setOnClickListener(fVar.new a());
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: mark.via.common.widget.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return f.a(this.f9910a, view);
            }
        });
    }

    public static /* synthetic */ void c(f fVar, RecyclerView recyclerView) {
        fVar.getClass();
        recyclerView.setClipToPadding(false);
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        recyclerView.setLayoutManager(new LinearLayoutManager(fVar.getContext(), 0, false));
        recyclerView.k(new com.tuyafeng.support.widget.c0(com.tuyafeng.support.utils.x.h(fVar.getContext(), 6.0f), com.tuyafeng.support.utils.x.h(fVar.getContext(), 4.0f)));
        r3.e(recyclerView);
    }

    public static /* synthetic */ void e(f fVar, View view, int i10, t9.f fVar2) {
        e eVar = fVar.f9914m;
        if (eVar != null) {
            eVar.a(fVar2);
        }
    }

    public final List j() {
        if (this.f9917p == null) {
            return new ArrayList(this.f9913e);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f9917p.h());
        arrayList.add(this.f9917p.e());
        return arrayList;
    }

    public final void k() {
        m(0);
        RecyclerView recyclerView = (RecyclerView) new b6.a(new RecyclerView(getContext()), new FrameLayout.LayoutParams(-1, -1)).v(1, 72).N(1, 12).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.a
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.c(this.f9898a, (RecyclerView) obj);
            }
        }).l();
        addView(recyclerView);
        ImageView imageView = (ImageView) new b6.a(new ImageView(getContext()), new FrameLayout.LayoutParams(-2, -1)).Y(1, 48).p(8388613).v(1, 12).D(1, 5).T(1, 4).N(1, 13).d(w7.o.f13783d).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.b
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.b(this.f9900a, (ImageView) obj);
            }
        }).l();
        this.f9916o = imageView;
        addView(imageView);
        this.f9912c = new t5.f(Collections.EMPTY_LIST);
        b bVar = new b();
        bVar.j(new t5.g() { // from class: mark.via.common.widget.c
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                f.e(this.f9904a, view, i10, (t9.f) obj);
            }
        });
        c cVar = new c();
        cVar.j(new t5.g() { // from class: mark.via.common.widget.d
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                f fVar = this.f9906a;
                com.tuyafeng.support.utils.n.c(fVar.getContext(), (String) obj, i10 == 1, fVar.getContext().getString(w7.u.Eg));
            }
        });
        this.f9912c.K(t9.f.class, bVar);
        this.f9912c.K(String.class, cVar);
        recyclerView.setAdapter(this.f9912c);
    }

    public final void l(List list) {
        if (m(list.size())) {
            this.f9912c.M(list);
            this.f9912c.l();
        } else {
            androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new d(list));
            this.f9912c.M(list);
            eVarB.c(this.f9912c);
        }
    }

    public final boolean m(int i10) {
        int iH = i10 >= 3 ? com.tuyafeng.support.utils.x.h(getContext(), 120.0f) : com.tuyafeng.support.utils.x.h(getContext(), 200.0f);
        if (iH == this.f9915n) {
            return false;
        }
        this.f9915n = iH;
        return true;
    }

    public void setCallback(e eVar) {
        this.f9914m = eVar;
    }

    public void setPassDetail(t9.f fVar) {
        if (fVar == null && this.f9917p == null) {
            return;
        }
        this.f9917p = fVar;
        if (fVar != null) {
            this.f9916o.setImageDrawable(lb.g.a(getContext(), w7.o.f13846y, w7.u.je));
            this.f9916o.setContentDescription(getContext().getString(w7.u.O8));
        } else {
            this.f9916o.setImageDrawable(lb.g.a(getContext(), w7.o.J0, w7.u.uf));
            this.f9916o.setContentDescription(getContext().getString(w7.u.f14296xa));
        }
        l(j());
    }

    public void setPassList(List<t9.f> list) {
        this.f9913e.clear();
        if (list != null && !list.isEmpty()) {
            this.f9913e.addAll(list);
        }
        if (this.f9917p == null) {
            l(j());
        } else {
            setPassDetail(null);
            this.f9912c.l();
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9913e = new ArrayList();
        this.f9915n = -1;
        k();
    }
}
