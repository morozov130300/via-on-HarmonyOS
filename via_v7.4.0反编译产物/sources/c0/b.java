package c0;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import c0.a;
import java.util.ArrayList;
import x.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b implements a.b {

    /* renamed from: m, reason: collision with root package name */
    public static final p f2179m = new f("translationX");

    /* renamed from: n, reason: collision with root package name */
    public static final p f2180n = new g("translationY");

    /* renamed from: o, reason: collision with root package name */
    public static final p f2181o = new h("translationZ");

    /* renamed from: p, reason: collision with root package name */
    public static final p f2182p = new i("scaleX");

    /* renamed from: q, reason: collision with root package name */
    public static final p f2183q = new j("scaleY");

    /* renamed from: r, reason: collision with root package name */
    public static final p f2184r = new k("rotation");

    /* renamed from: s, reason: collision with root package name */
    public static final p f2185s = new l("rotationX");

    /* renamed from: t, reason: collision with root package name */
    public static final p f2186t = new m("rotationY");

    /* renamed from: u, reason: collision with root package name */
    public static final p f2187u = new n("x");

    /* renamed from: v, reason: collision with root package name */
    public static final p f2188v = new a("y");

    /* renamed from: w, reason: collision with root package name */
    public static final p f2189w = new C0039b("z");

    /* renamed from: x, reason: collision with root package name */
    public static final p f2190x = new c("alpha");

    /* renamed from: y, reason: collision with root package name */
    public static final p f2191y = new d("scrollX");

    /* renamed from: z, reason: collision with root package name */
    public static final p f2192z = new e("scrollY");

    /* renamed from: d, reason: collision with root package name */
    public final Object f2196d;

    /* renamed from: e, reason: collision with root package name */
    public final c0.c f2197e;

    /* renamed from: j, reason: collision with root package name */
    public float f2202j;

    /* renamed from: a, reason: collision with root package name */
    public float f2193a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f2194b = Float.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2195c = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2198f = false;

    /* renamed from: g, reason: collision with root package name */
    public float f2199g = Float.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public float f2200h = -Float.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public long f2201i = 0;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f2203k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f2204l = new ArrayList();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends p {
        public a(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setY(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: c0.b$b, reason: collision with other inner class name */
    public static class C0039b extends p {
        public C0039b(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return r.C(view);
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            r.k0(view, f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c extends p {
        public c(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d extends p {
        public d(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class e extends p {
        public e(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class f extends p {
        public f(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class g extends p {
        public g(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class h extends p {
        public h(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return r.B(view);
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            r.h0(view, f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class i extends p {
        public i(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class j extends p {
        public j(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class k extends p {
        public k(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotation(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class l extends p {
        public l(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class m extends p {
        public m(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class n extends p {
        public n(String str) {
            super(str, null);
        }

        @Override // c0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // c0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setX(f10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public float f2205a;

        /* renamed from: b, reason: collision with root package name */
        public float f2206b;
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class p extends c0.c {
        public p(String str) {
            super(str);
        }

        public /* synthetic */ p(String str, f fVar) {
            this(str);
        }
    }

    public b(Object obj, c0.c cVar) {
        this.f2196d = obj;
        this.f2197e = cVar;
        if (cVar == f2184r || cVar == f2185s || cVar == f2186t) {
            this.f2202j = 0.1f;
            return;
        }
        if (cVar == f2190x) {
            this.f2202j = 0.00390625f;
        } else if (cVar == f2182p || cVar == f2183q) {
            this.f2202j = 0.00390625f;
        } else {
            this.f2202j = 1.0f;
        }
    }

    public static void g(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // c0.a.b
    public boolean a(long j10) {
        long j11 = this.f2201i;
        if (j11 == 0) {
            this.f2201i = j10;
            h(this.f2194b);
            return false;
        }
        this.f2201i = j10;
        boolean zL = l(j10 - j11);
        float fMin = Math.min(this.f2194b, this.f2199g);
        this.f2194b = fMin;
        float fMax = Math.max(fMin, this.f2200h);
        this.f2194b = fMax;
        h(fMax);
        if (zL) {
            c(false);
        }
        return zL;
    }

    public void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f2198f) {
            c(true);
        }
    }

    public final void c(boolean z10) {
        this.f2198f = false;
        c0.a.d().g(this);
        this.f2201i = 0L;
        this.f2195c = false;
        for (int i10 = 0; i10 < this.f2203k.size(); i10++) {
            if (this.f2203k.get(i10) != null) {
                n.g.a(this.f2203k.get(i10));
                throw null;
            }
        }
        g(this.f2203k);
    }

    public final float d() {
        return this.f2197e.a(this.f2196d);
    }

    public float e() {
        return this.f2202j * 0.75f;
    }

    public boolean f() {
        return this.f2198f;
    }

    public void h(float f10) {
        this.f2197e.b(this.f2196d, f10);
        for (int i10 = 0; i10 < this.f2204l.size(); i10++) {
            if (this.f2204l.get(i10) != null) {
                n.g.a(this.f2204l.get(i10));
                throw null;
            }
        }
        g(this.f2204l);
    }

    public b i(float f10) {
        this.f2194b = f10;
        this.f2195c = true;
        return this;
    }

    public void j() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f2198f) {
            return;
        }
        k();
    }

    public final void k() {
        if (this.f2198f) {
            return;
        }
        this.f2198f = true;
        if (!this.f2195c) {
            this.f2194b = d();
        }
        float f10 = this.f2194b;
        if (f10 > this.f2199g || f10 < this.f2200h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        c0.a.d().a(this, 0L);
    }

    public abstract boolean l(long j10);
}
