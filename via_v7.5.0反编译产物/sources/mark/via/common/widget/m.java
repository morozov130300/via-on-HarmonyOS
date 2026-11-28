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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x8.q2;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f9972c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t5.f f9973e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f9975n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f9976o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9977p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9978q;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends t5.a {
        public a() {
        }

        public static /* synthetic */ void l(TextView textView) {
            v8.g.m(textView, v8.h.t(textView.getContext()));
            textView.setGravity(17);
            textView.setSingleLine();
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setMaxWidth(com.tuyafeng.support.utils.x.h(textView.getContext(), 96.0f));
            textView.setTypeface(Typeface.DEFAULT);
        }

        @Override // t5.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public long a(ga.c cVar) {
            return cVar.d();
        }

        @Override // t5.d
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void b(w5.g gVar, ga.c cVar) {
            super.b(gVar, cVar);
            boolean z10 = gVar.l() == m.this.f9974m;
            TextView textView = (TextView) gVar.f1138a;
            textView.setText(cVar.g());
            textView.setSelected(z10);
            q(gVar);
            v8.g.d(textView);
        }

        @Override // t5.d
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public void c(w5.g gVar, ga.c cVar, List list) {
            super.c(gVar, cVar, list);
            if (list.isEmpty()) {
                b(gVar, cVar);
            } else {
                q(gVar);
            }
        }

        @Override // t5.d
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public w5.g d(Context context, ViewGroup viewGroup) {
            return new w5.g((TextView) new b6.a(new TextView(context), new FrameLayout.LayoutParams(-2, -1)).e(v8.h.f(context)).N(1, 12).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.l
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    m.a.l((TextView) obj);
                }
            }).l());
        }

        public final void q(w5.g gVar) {
            TextView textView = (TextView) gVar.f1138a;
            if (textView.getTextColors().getDefaultColor() == m.this.f9978q) {
                return;
            }
            textView.setTextColor(v8.h.g(m.this.getContext(), m.this.f9978q));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends t5.a {
        public b() {
        }

        private void p(w5.g gVar) {
            com.tuyafeng.support.utils.x.T(m.this.f9977p, (ImageView) gVar.f1138a);
        }

        @Override // t5.d
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public long a(com.tuyafeng.support.widget.e0.b bVar) {
            return bVar.f3738a;
        }

        @Override // t5.d
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(w5.g gVar, com.tuyafeng.support.widget.e0.b bVar) {
            super.b(gVar, bVar);
            ImageView imageView = (ImageView) gVar.f1138a;
            imageView.setContentDescription(bVar.f3740c);
            imageView.setImageDrawable(bVar.f3741d);
            p(gVar);
        }

        @Override // t5.d
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void c(w5.g gVar, com.tuyafeng.support.widget.e0.b bVar, List list) {
            super.c(gVar, bVar, list);
            if (list.isEmpty()) {
                b(gVar, bVar);
            } else {
                p(gVar);
            }
        }

        @Override // t5.d
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public w5.g d(Context context, ViewGroup viewGroup) {
            return new w5.g((ImageView) new b6.a(new ImageView(m.this.getContext()), new LinearLayout.LayoutParams(com.tuyafeng.support.utils.x.h(m.this.getContext(), 48.0f), -1)).F(1, 4).d(w7.o.f13783d).l());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends androidx.recyclerview.widget.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f9981a;

        public c(List list) {
            this.f9981a = list;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean a(int i10, int i11) {
            return this.f9981a.get(i11).equals(m.this.f9973e.H().get(i10));
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean b(int i10, int i11) {
            Object obj = m.this.f9973e.H().get(i10);
            Object obj2 = this.f9981a.get(i11);
            if (obj.getClass() != obj2.getClass()) {
                return false;
            }
            if (obj instanceof ga.c) {
                return ((ga.c) obj).d() == ((ga.c) obj2).d();
            }
            return (obj instanceof com.tuyafeng.support.widget.e0.b) && ((com.tuyafeng.support.widget.e0.b) obj).f3738a == ((com.tuyafeng.support.widget.e0.b) obj2).f3738a;
        }

        @Override // androidx.recyclerview.widget.f.b
        public int d() {
            return this.f9981a.size();
        }

        @Override // androidx.recyclerview.widget.f.b
        public int e() {
            return m.this.f9973e.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface d {
        void a();

        boolean b(ga.c cVar);
    }

    public m(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(m mVar, RecyclerView recyclerView) {
        mVar.getClass();
        recyclerView.setClipToPadding(false);
        recyclerView.setItemAnimator(new androidx.recyclerview.widget.e());
        recyclerView.setLayoutManager(new LinearLayoutManager(mVar.getContext(), 0, false));
        recyclerView.k(new com.tuyafeng.support.widget.c0(com.tuyafeng.support.utils.x.h(mVar.getContext(), 6.0f), com.tuyafeng.support.utils.x.h(mVar.getContext(), 4.0f)));
        r3.e(recyclerView);
    }

    public static /* synthetic */ void b(m mVar, View view, int i10, com.tuyafeng.support.widget.e0.b bVar) {
        d dVar = mVar.f9976o;
        if (dVar != null) {
            dVar.a();
        }
    }

    public static /* synthetic */ void c(m mVar, View view, int i10, ga.c cVar) {
        d dVar;
        if (i10 == mVar.f9974m || (dVar = mVar.f9976o) == null || !dVar.b(cVar)) {
            return;
        }
        int i11 = mVar.f9974m;
        mVar.f9974m = i10;
        mVar.f9973e.m(i11);
        mVar.f9973e.m(i10);
    }

    public final List h() {
        ArrayList arrayList = new ArrayList(this.f9975n);
        arrayList.add(new com.tuyafeng.support.widget.e0.b(1, 0, lb.g.a(getContext(), w7.o.f13803j1, w7.u.Jf), getContext().getString(w7.u.f14161nc)));
        return arrayList;
    }

    public x.d i(String str) {
        x.d dVarJ = j(this.f9975n, str);
        if (((Integer) dVarJ.f14455a).intValue() < 0) {
            return null;
        }
        return x.d.a((ga.c) this.f9975n.get(((Integer) dVarJ.f14455a).intValue()), (String) dVarJ.f14456b);
    }

    public final x.d j(List list, String str) {
        if (list == null || list.isEmpty() || str == null || str.isEmpty()) {
            return x.d.a(-1, null);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ga.c cVar = (ga.c) list.get(i10);
            String strB = q2.c(cVar.d(), cVar.a()).b(str);
            if (strB != null && !strB.isEmpty()) {
                return x.d.a(Integer.valueOf(i10), strB);
            }
        }
        return x.d.a(-1, null);
    }

    public final void k() {
        RecyclerView recyclerView = (RecyclerView) new b6.a(new RecyclerView(getContext()), new FrameLayout.LayoutParams(-1, -1)).N(1, 12).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.i
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                m.a(this.f9949a, (RecyclerView) obj);
            }
        }).l();
        this.f9972c = recyclerView;
        addView(recyclerView);
        this.f9973e = new t5.f(Collections.EMPTY_LIST);
        a aVar = new a();
        aVar.j(new t5.g() { // from class: mark.via.common.widget.j
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                m.c(this.f9956a, view, i10, (ga.c) obj);
            }
        });
        this.f9973e.K(ga.c.class, aVar);
        b bVar = new b();
        bVar.j(new t5.g() { // from class: mark.via.common.widget.k
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                m.b(this.f9959a, view, i10, (com.tuyafeng.support.widget.e0.b) obj);
            }
        });
        this.f9973e.K(com.tuyafeng.support.widget.e0.b.class, bVar);
        this.f9972c.setAdapter(this.f9973e);
    }

    public void l(int i10, int i11) {
        t5.f fVar = this.f9973e;
        if (fVar != null) {
            if (this.f9977p == i10 && this.f9978q == i11) {
                return;
            }
            this.f9977p = i10;
            this.f9978q = i11;
            fVar.r(0, fVar.g(), new Object());
        }
    }

    public void m(List list, String str) {
        this.f9974m = ((Integer) j(list, str).f14455a).intValue();
        this.f9975n.clear();
        if (list != null) {
            this.f9975n.addAll(list);
        }
        o(h());
    }

    public boolean n(String str) {
        if (s9.d.l(getContext(), str)) {
            return false;
        }
        x.d dVarJ = j(this.f9975n, str);
        int iIntValue = ((Integer) dVarJ.f14455a).intValue();
        int i10 = this.f9974m;
        if (iIntValue != i10) {
            this.f9974m = ((Integer) dVarJ.f14455a).intValue();
            this.f9973e.m(i10);
            this.f9973e.m(this.f9974m);
            int i11 = this.f9974m;
            if (i11 >= 0) {
                this.f9972c.x1(i11);
            }
        }
        return this.f9974m >= 0;
    }

    public final void o(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new c(list));
        this.f9973e.M(list);
        eVarB.c(this.f9973e);
    }

    public void setCallback(d dVar) {
        this.f9976o = dVar;
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9974m = -1;
        this.f9975n = new ArrayList();
        k();
    }
}
