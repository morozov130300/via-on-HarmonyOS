package mark.via.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.tuyafeng.support.widget.z;
import h6.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mark.via.common.widget.m;
import z8.r3;
import z8.v2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public RecyclerView f9681e;

    /* renamed from: j, reason: collision with root package name */
    public y5.f f9682j;

    /* renamed from: k, reason: collision with root package name */
    public int f9683k;

    /* renamed from: l, reason: collision with root package name */
    public final List f9684l;

    /* renamed from: m, reason: collision with root package name */
    public d f9685m;

    /* renamed from: n, reason: collision with root package name */
    public int f9686n;

    /* renamed from: o, reason: collision with root package name */
    public int f9687o;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends y5.a {
        public a() {
        }

        public static /* synthetic */ void l(TextView textView) {
            x8.g.m(textView, x8.h.u(textView.getContext()));
            textView.setGravity(17);
            textView.setSingleLine();
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setMaxWidth(g6.y.h(textView.getContext(), 96.0f));
            textView.setTypeface(Typeface.DEFAULT);
        }

        @Override // y5.d
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public long a(ja.c cVar) {
            return cVar.d();
        }

        @Override // y5.d
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void b(b6.g gVar, ja.c cVar) {
            super.b(gVar, cVar);
            boolean z10 = gVar.l() == m.this.f9683k;
            TextView textView = (TextView) gVar.f1219a;
            textView.setText(cVar.g());
            textView.setSelected(z10);
            q(gVar);
            x8.g.d(textView);
        }

        @Override // y5.d
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(b6.g gVar, ja.c cVar, List list) {
            super.c(gVar, cVar, list);
            if (list.isEmpty()) {
                b(gVar, cVar);
            } else {
                q(gVar);
            }
        }

        @Override // y5.d
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b6.g d(Context context, ViewGroup viewGroup) {
            return new b6.g((TextView) new h6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).e(x8.h.f(context)).N(1, 12).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.l
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    m.a.l((TextView) obj);
                }
            }).l());
        }

        public final void q(b6.g gVar) {
            TextView textView = (TextView) gVar.f1219a;
            if (textView.getTextColors().getDefaultColor() == m.this.f9687o) {
                return;
            }
            textView.setTextColor(x8.h.g(m.this.getContext(), m.this.f9687o));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends y5.a {
        public b() {
        }

        private void p(b6.g gVar) {
            g6.y.S(m.this.f9686n, (ImageView) gVar.f1219a);
        }

        @Override // y5.d
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public long a(z.b bVar) {
            return bVar.f4420a;
        }

        @Override // y5.d
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(b6.g gVar, z.b bVar) {
            super.b(gVar, bVar);
            ImageView imageView = (ImageView) gVar.f1219a;
            imageView.setContentDescription(bVar.f4422c);
            imageView.setImageDrawable(bVar.f4423d);
            p(gVar);
        }

        @Override // y5.d
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(b6.g gVar, z.b bVar, List list) {
            super.c(gVar, bVar, list);
            if (list.isEmpty()) {
                b(gVar, bVar);
            } else {
                p(gVar);
            }
        }

        @Override // y5.d
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public b6.g d(Context context, ViewGroup viewGroup) {
            return new b6.g((ImageView) new h6.a(new ImageView(m.this.getContext()), new LinearLayout.LayoutParams(g6.y.h(m.this.getContext(), 48.0f), -1)).F(1, 4).d(x7.o.f13720e).l());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c extends f.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f9690a;

        public c(List list) {
            this.f9690a = list;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean a(int i10, int i11) {
            return this.f9690a.get(i11).equals(m.this.f9682j.H().get(i10));
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean b(int i10, int i11) {
            Object obj = m.this.f9682j.H().get(i10);
            Object obj2 = this.f9690a.get(i11);
            if (obj.getClass() != obj2.getClass()) {
                return false;
            }
            return obj instanceof ja.c ? ((ja.c) obj).d() == ((ja.c) obj2).d() : (obj instanceof z.b) && ((z.b) obj).f4420a == ((z.b) obj2).f4420a;
        }

        @Override // androidx.recyclerview.widget.f.b
        public int d() {
            return this.f9690a.size();
        }

        @Override // androidx.recyclerview.widget.f.b
        public int e() {
            return m.this.f9682j.g();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface d {
        boolean a(ja.c cVar);

        void b();
    }

    public m(Context context) {
        this(context, null);
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9683k = -1;
        this.f9684l = new ArrayList();
        k();
    }

    public static /* synthetic */ void a(m mVar, RecyclerView recyclerView) {
        mVar.getClass();
        recyclerView.setClipToPadding(false);
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        recyclerView.setLayoutManager(new LinearLayoutManager(mVar.getContext(), 0, false));
        recyclerView.k(new com.tuyafeng.support.widget.x(g6.y.h(mVar.getContext(), 6.0f), g6.y.h(mVar.getContext(), 4.0f)));
        r3.d(recyclerView);
    }

    public static /* synthetic */ void b(m mVar, View view, int i10, z.b bVar) {
        d dVar = mVar.f9685m;
        if (dVar != null) {
            dVar.b();
        }
    }

    public static /* synthetic */ void c(m mVar, View view, int i10, ja.c cVar) {
        d dVar;
        if (i10 == mVar.f9683k || (dVar = mVar.f9685m) == null || !dVar.a(cVar)) {
            return;
        }
        int i11 = mVar.f9683k;
        mVar.f9683k = i10;
        mVar.f9682j.m(i11);
        mVar.f9682j.m(i10);
    }

    public final List h() {
        ArrayList arrayList = new ArrayList(this.f9684l);
        arrayList.add(new z.b(1, 0, lb.b.a(getContext(), x7.o.f13743l1, x7.u.sf), getContext().getString(x7.u.Zb)));
        return arrayList;
    }

    public w.d i(String str) {
        w.d dVarJ = j(this.f9684l, str);
        if (((Integer) dVarJ.f13207a).intValue() < 0) {
            return null;
        }
        return w.d.a((ja.c) this.f9684l.get(((Integer) dVarJ.f13207a).intValue()), (String) dVarJ.f13208b);
    }

    public final w.d j(List list, String str) {
        if (list == null || list.isEmpty() || str == null || str.isEmpty()) {
            return w.d.a(-1, null);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ja.c cVar = (ja.c) list.get(i10);
            String strG = i6.g0.f6993a.g(str, v2.c(cVar.d(), cVar.a()).getUrl());
            if (strG != null && !strG.isEmpty()) {
                return w.d.a(Integer.valueOf(i10), strG);
            }
        }
        return w.d.a(-1, null);
    }

    public final void k() {
        RecyclerView recyclerView = (RecyclerView) new h6.a(new RecyclerView(getContext()), new FrameLayout.LayoutParams(-1, -1)).N(1, 12).V(new a.InterfaceC0076a() { // from class: mark.via.common.widget.i
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                m.a(this.f9658a, (RecyclerView) obj);
            }
        }).l();
        this.f9681e = recyclerView;
        addView(recyclerView);
        this.f9682j = new y5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new y5.g() { // from class: mark.via.common.widget.j
            @Override // y5.g
            public final void a(View view, int i10, Object obj) {
                m.c(this.f9665a, view, i10, (ja.c) obj);
            }
        });
        this.f9682j.K(ja.c.class, aVar);
        b bVar = new b();
        bVar.j(new y5.g() { // from class: mark.via.common.widget.k
            @Override // y5.g
            public final void a(View view, int i10, Object obj) {
                m.b(this.f9668a, view, i10, (z.b) obj);
            }
        });
        this.f9682j.K(z.b.class, bVar);
        this.f9681e.setAdapter(this.f9682j);
    }

    public void l(int i10, int i11) {
        y5.f fVar = this.f9682j;
        if (fVar != null) {
            if (this.f9686n == i10 && this.f9687o == i11) {
                return;
            }
            this.f9686n = i10;
            this.f9687o = i11;
            fVar.r(0, fVar.g(), new Object());
        }
    }

    public void m(List list, String str) {
        this.f9683k = ((Integer) j(list, str).f13207a).intValue();
        this.f9684l.clear();
        if (list != null) {
            this.f9684l.addAll(list);
        }
        o(h());
    }

    public boolean n(String str) {
        if (u9.d.m(getContext(), str)) {
            return false;
        }
        w.d dVarJ = j(this.f9684l, str);
        int iIntValue = ((Integer) dVarJ.f13207a).intValue();
        int i10 = this.f9683k;
        if (iIntValue != i10) {
            this.f9683k = ((Integer) dVarJ.f13207a).intValue();
            this.f9682j.m(i10);
            this.f9682j.m(this.f9683k);
            int i11 = this.f9683k;
            if (i11 >= 0) {
                this.f9681e.x1(i11);
            }
        }
        return this.f9683k >= 0;
    }

    public final void o(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new c(list));
        this.f9682j.M(list);
        eVarB.c(this.f9682j);
    }

    public void setCallback(d dVar) {
        this.f9685m = dVar;
    }
}
