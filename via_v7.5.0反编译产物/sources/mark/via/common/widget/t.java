package mark.via.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c6.a2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t extends LinearLayout {
    public static final int B = w7.p.f13855b;
    public static final int C = w7.p.f13852a;
    public boolean A;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f10053c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f10054e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public t5.f f10055m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f10056n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f10057o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public h f10058p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f10059q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public g f10060r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f10061s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f f10062t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public androidx.recyclerview.widget.j f10063u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10064v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10065w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10066x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10067y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10068z;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            if (t.this.f10058p != null) {
                t.this.f10058p.onClick(view);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends t5.i {

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a extends p5.c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ w5.g f10072c;

            public a(w5.g gVar) {
                this.f10072c = gVar;
            }

            @Override // p5.c
            public void a(View view) {
                if (t.this.f10057o != null) {
                    t.this.f10057o.a(this.f10072c.l());
                }
            }
        }

        public c() {
        }

        public static /* synthetic */ boolean q(c cVar, w5.g gVar, View view, MotionEvent motionEvent) {
            cVar.getClass();
            if (motionEvent.getAction() == 0 && t.this.f10055m.g() >= 2) {
                t.this.f10068z = true;
                t.this.f10063u.H(gVar);
                return false;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return false;
            }
            t.this.f10068z = false;
            return false;
        }

        public static /* synthetic */ void t(b0 b0Var) {
            b0Var.getTextView().setEllipsize(TextUtils.TruncateAt.END);
            b0Var.getTextView().setHorizontalFadingEdgeEnabled(false);
        }

        @Override // t5.i
        public View o(ViewGroup viewGroup) {
            return new b6.a(new b0(viewGroup.getContext()), new FrameLayout.LayoutParams(-1, -1)).d(w7.o.f13786e).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.u
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    t.c.t((b0) obj);
                }
            }).l();
        }

        public final boolean u(w5.g gVar, int i10) {
            int iL = gVar.l();
            int i11 = i10 + iL;
            return iL != -1 && i11 >= 0 && i11 < t.this.f10055m.g() && t.this.f10060r != null && t.this.f10060r.onMove(iL, i11);
        }

        @Override // t5.i
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public void l(final w5.g gVar, r4.a aVar, int i10) {
            Context context = gVar.f1138a.getContext();
            if (t.this.f10056n == null) {
                t.this.f10056n = com.tuyafeng.support.utils.e.f(lb.g.c(context, w7.o.I1, w7.u.Rf).mutate(), t.this.f10064v);
                int iD = com.tuyafeng.support.utils.f.d(context, w7.n.f13753f);
                t.this.f10056n.setBounds(0, 0, iD, iD);
            }
            b0 b0Var = (b0) gVar.f1138a;
            String title = aVar.getTitle();
            String url = aVar.getUrl();
            float f10 = aVar.d() ? 1.0f : 0.45f;
            TextView textView = b0Var.getTextView();
            if (TextUtils.isEmpty(title)) {
                title = url;
            }
            textView.setText(title);
            b0Var.getTextView().setAlpha(f10);
            b0Var.getIconView().setAlpha(f10);
            b0Var.getCloseView().setAlpha(f10);
            b0Var.getCloseView().setOnClickListener(new a(gVar));
            b0Var.getIconView().setOnTouchListener(new View.OnTouchListener() { // from class: mark.via.common.widget.v
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return t.c.q(this.f10091a, gVar, view, motionEvent);
                }
            });
            x(b0Var, gVar);
            y(gVar, aVar);
            z(gVar);
        }

        @Override // t5.i
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public void m(w5.g gVar, r4.a aVar, int i10, List list) {
            if (list.isEmpty()) {
                l(gVar, aVar, i10);
            } else {
                y(gVar, aVar);
                z(gVar);
            }
        }

        public final void x(b0 b0Var, final w5.g gVar) {
            int iL = gVar.l();
            z.d0.a aVar = new z.d0.a(t.B, t.this.getContext().getString(w7.u.L8));
            z.d0.a aVar2 = new z.d0.a(t.C, t.this.getContext().getString(w7.u.K8));
            if (iL > 0) {
                y.r.U(b0Var, aVar, null, new z.i0() { // from class: mark.via.common.widget.w
                    @Override // z.i0
                    public final boolean a(View view, z.i0.a aVar3) {
                        return this.f10093a.u(gVar, -1);
                    }
                });
            } else {
                y.r.S(b0Var, t.B);
            }
            if (iL < 0 || iL >= t.this.f10055m.g() - 1) {
                y.r.S(b0Var, t.C);
            } else {
                y.r.U(b0Var, aVar2, null, new z.i0() { // from class: mark.via.common.widget.x
                    @Override // z.i0
                    public final boolean a(View view, z.i0.a aVar3) {
                        return this.f10100a.u(gVar, 1);
                    }
                });
            }
        }

        public final void y(w5.g gVar, r4.a aVar) {
            b0 b0Var = (b0) gVar.f1138a;
            r3.m(b0Var.getCloseView(), t.this.f10064v);
            b0Var.getTextView().setTextColor(t.this.f10065w);
            Bitmap bitmapT = aVar.t();
            if (bitmapT == null) {
                bitmapT = x8.x0.c().d(b0Var.getContext(), aVar.getUrl());
            }
            x8.y0.i(b0Var.getIconView(), bitmapT, t.this.f10056n);
        }

        public final void z(w5.g gVar) {
            ViewGroup.LayoutParams layoutParams = gVar.f1138a.getLayoutParams();
            if (layoutParams.width == t.this.f10066x) {
                return;
            }
            layoutParams.width = t.this.f10066x;
            layoutParams.height = -1;
            gVar.f1138a.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface d {
        void a(int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface e {
        void b(int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface f {
        void a(int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface g {
        boolean onMove(int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface h {
        void onClick(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface i {
        void a(int i10);
    }

    public t(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(t tVar, View view, int i10, r4.a aVar) {
        i iVar = tVar.f10059q;
        if (iVar != null) {
            iVar.a(i10);
        }
    }

    public static /* synthetic */ void b(t tVar, ImageView imageView) {
        r3.m(imageView, tVar.f10064v);
        imageView.setImageDrawable(lb.g.a(tVar.getContext(), w7.o.f13810m, w7.u.ge));
        imageView.setOnClickListener(tVar.new a());
    }

    public static /* synthetic */ void c(t tVar, RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(tVar.getContext(), 0, false));
        androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e();
        eVar.U(false);
        recyclerView.setItemAnimator(eVar);
        r3.e(recyclerView);
        androidx.recyclerview.widget.g gVar = new androidx.recyclerview.widget.g(tVar.getContext(), 0);
        int iH = com.tuyafeng.support.utils.x.h(tVar.getContext(), 1.0f);
        gVar.n(new com.tuyafeng.support.utils.g().h(813727872).g(iH, iH).a());
        recyclerView.k(gVar);
    }

    public static /* synthetic */ void d(t tVar, String str, int i10, AdapterView adapterView, View view, int i11, long j10) {
        int i12 = (int) j10;
        switch (i12) {
            case 1:
            case 2:
            case 3:
            case 4:
                e eVar = tVar.f10061s;
                if (eVar != null) {
                    eVar.b(i10, i12);
                }
                break;
            case 5:
                com.tuyafeng.support.utils.n.a(tVar.getContext(), str, w7.u.Fg);
                break;
            case 6:
                f fVar = tVar.f10062t;
                if (fVar != null) {
                    fVar.a(i10);
                }
                break;
            default:
                tVar.getClass();
                break;
        }
    }

    public static /* synthetic */ boolean e(t tVar, View view, int i10, r4.a aVar) {
        if (tVar.f10068z) {
            return true;
        }
        if (i10 < 0 || i10 >= tVar.f10055m.g()) {
            return false;
        }
        tVar.z(view, aVar, i10);
        return true;
    }

    private void setParentWidth(int i10) {
        int i11;
        int I = com.tuyafeng.support.utils.x.I(getContext(), i10);
        if (I < 420) {
            i11 = I / 7;
        } else {
            i11 = I > 900 ? 72 : 60;
        }
        int i12 = I / i11;
        setWeightSum(i12);
        RecyclerView recyclerView = this.f10053c;
        if (recyclerView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
            layoutParams.weight = i12 - 1;
            this.f10053c.setLayoutParams(layoutParams);
            this.f10053c.requestLayout();
        }
        int iMin = Math.min(com.tuyafeng.support.utils.x.h(getContext(), 180.0f), Math.max((((i10 / i12) * (i12 - 1)) - (com.tuyafeng.support.utils.x.h(getContext(), 1.0f) * 2)) / 2, com.tuyafeng.support.utils.x.h(getContext(), 100.0f)));
        post(new Runnable() { // from class: mark.via.common.widget.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f9992c.requestLayout();
            }
        });
        if (this.f10066x != iMin) {
            this.f10066x = iMin;
            t5.f fVar = this.f10055m;
            if (fVar != null) {
                fVar.r(0, fVar.g(), new Object());
                x(this.f10067y);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        setParentWidth(i10);
    }

    public final void s() {
        setOrientation(0);
        this.f10064v = v8.h.l(getContext());
        this.f10065w = v8.h.o(getContext());
        this.A = la.s.j().e();
        this.f10053c = (RecyclerView) new b6.a(new RecyclerView(getContext()), new LinearLayout.LayoutParams(0, -1)).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.o
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.c(this.f10013a, (RecyclerView) obj);
            }
        }).W(Math.min(4.0f, getWeightSum() - 1.0f)).l();
        this.f10054e = (ImageView) new b6.a(new ImageView(getContext()), new LinearLayout.LayoutParams(0, -1)).S((com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13772y) - com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13753f)) / 2).j(getContext().getString(w7.u.P)).d(w7.o.f13783d).W(1.0f).V(new b6.a.InterfaceC0033a() { // from class: mark.via.common.widget.p
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                t.b(this.f10020a, (ImageView) obj);
            }
        }).l();
        addView(this.f10053c);
        addView(this.f10054e);
        androidx.recyclerview.widget.j jVar = new androidx.recyclerview.widget.j(new b(12, 0));
        this.f10063u = jVar;
        jVar.m(this.f10053c);
        this.f10055m = new t5.f(Collections.EMPTY_LIST);
        c cVar = new c();
        cVar.j(new t5.g() { // from class: mark.via.common.widget.q
            @Override // t5.g
            public final void a(View view, int i10, Object obj) {
                t.a(this.f10032a, view, i10, (r4.a) obj);
            }
        });
        cVar.k(new t5.h() { // from class: mark.via.common.widget.r
            @Override // t5.h
            public final boolean a(View view, int i10, Object obj) {
                return t.e(this.f10037a, view, i10, (r4.a) obj);
            }
        });
        this.f10055m.K(r4.a.class, cVar);
        this.f10053c.setAdapter(this.f10055m);
    }

    public void setOnDeleteItemClickListener(d dVar) {
        this.f10057o = dVar;
    }

    public void setOnDeleteTabsListener(e eVar) {
        this.f10061s = eVar;
    }

    public void setOnDuplicateTabListener(f fVar) {
        this.f10062t = fVar;
    }

    public void setOnMoveTabListener(g gVar) {
        this.f10060r = gVar;
    }

    public void setOnNewTabButtonClickListener(h hVar) {
        this.f10058p = hVar;
    }

    public void setOnTabItemClickListener(i iVar) {
        this.f10059q = iVar;
    }

    public void setTabs(List<r4.a> list) {
        this.f10055m.M(list);
        this.f10055m.l();
    }

    public void t(int i10) {
        this.f10055m.m(i10);
    }

    public void u(int i10) {
        this.f10055m.o(i10);
    }

    public void v(int i10, int i11) {
        this.f10055m.p(i10, i11);
    }

    public void w(int i10) {
        this.f10055m.u(i10);
    }

    public void x(int i10) {
        if (this.f10053c == null || i10 < 0 || i10 >= this.f10055m.g()) {
            return;
        }
        this.f10067y = i10;
        this.f10053c.p1(i10);
    }

    public void y(int i10, int i11) {
        boolean zE = la.s.j().e();
        if (this.f10054e != null) {
            if (this.f10064v == i10 && this.f10065w == i11 && this.A == zE) {
                return;
            }
            this.f10064v = i10;
            this.f10065w = i11;
            this.A = zE;
            Drawable drawable = this.f10056n;
            if (drawable != null) {
                com.tuyafeng.support.utils.h.a(drawable, i10);
            }
            r3.m(this.f10054e, i10);
            t5.f fVar = this.f10055m;
            fVar.r(0, fVar.g(), new Object());
        }
    }

    public final void z(View view, r4.a aVar, final int i10) {
        int iG = this.f10055m.g();
        final String url = aVar.getUrl();
        ArrayList arrayList = new ArrayList();
        if (iG > 1) {
            arrayList.add(new q5.k.l(4, getContext().getString(w7.u.f14134m)));
            arrayList.add(new q5.k.l(1, getContext().getString(w7.u.f14148n)));
        }
        if (i10 != 0 && i10 != iG - 1) {
            boolean z10 = getLayoutDirection() == 1;
            arrayList.add(new q5.k.l(z10 ? 2 : 3, getContext().getString(w7.u.f14176p)));
            arrayList.add(new q5.k.l(z10 ? 3 : 2, getContext().getString(w7.u.f14190q)));
        }
        a2 a2Var = a2.f1958a;
        if (a2Var.t(url)) {
            arrayList.add(new q5.k.l(6, getContext().getString(w7.u.f14303y4)));
        }
        if (!a2Var.m(url)) {
            arrayList.add(new q5.k.l(5, getContext().getString(w7.u.f14218s)));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        q5.k.l(getContext()).D(arrayList, new AdapterView.OnItemClickListener() { // from class: mark.via.common.widget.s
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i11, long j10) {
                t.d(this.f10045a, url, i10, adapterView, view2, i11, j10);
            }
        }).j0(view);
    }

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public t(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f10056n = null;
        s();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends androidx.recyclerview.widget.j.i {
        public b(int i10, int i11) {
            super(i10, i11);
        }

        @Override // androidx.recyclerview.widget.j.f
        public void A(RecyclerView.d0 d0Var, int i10) {
            super.A(d0Var, i10);
            if (i10 == 2 && d0Var != null) {
                d0Var.f1138a.setBackgroundColor(com.tuyafeng.support.utils.f.b(t.this.getContext(), w7.m.f13738b));
            } else if (i10 == 0) {
                t.this.f10068z = false;
            }
        }

        @Override // androidx.recyclerview.widget.j.f
        public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            super.c(recyclerView, d0Var);
            com.tuyafeng.support.utils.x.P(d0Var.f1138a, com.tuyafeng.support.utils.f.e(t.this.getContext(), w7.o.f13786e));
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean r() {
            return false;
        }

        @Override // androidx.recyclerview.widget.j.f
        public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            int iL = d0Var.l();
            int iL2 = d0Var2.l();
            return (iL == -1 || iL2 == -1 || t.this.f10060r == null || !t.this.f10060r.onMove(iL, iL2)) ? false : true;
        }

        @Override // androidx.recyclerview.widget.j.f
        public void B(RecyclerView.d0 d0Var, int i10) {
        }
    }
}
