package d0;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;
import y.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements d0.a.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final p f3806m = new f("translationX");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final p f3807n = new g("translationY");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final p f3808o = new h("translationZ");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final p f3809p = new i("scaleX");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final p f3810q = new j("scaleY");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final p f3811r = new k("rotation");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final p f3812s = new l("rotationX");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final p f3813t = new m("rotationY");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final p f3814u = new n("x");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final p f3815v = new a("y");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final p f3816w = new C0054b("z");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final p f3817x = new c("alpha");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final p f3818y = new d("scrollX");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final p f3819z = new e("scrollY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d0.c f3824e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3829j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3820a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3821b = Float.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3822c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3825f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3826g = Float.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3827h = -Float.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f3828i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f3830k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f3831l = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends p {
        public a(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setY(f10);
        }
    }

    /* JADX INFO: renamed from: d0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0054b extends p {
        public C0054b(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return r.C(view);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            r.l0(view, f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c extends p {
        public c(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d extends p {
        public d(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class e extends p {
        public e(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class f extends p {
        public f(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class g extends p {
        public g(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class h extends p {
        public h(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return r.B(view);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            r.i0(view, f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class i extends p {
        public i(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class j extends p {
        public j(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class k extends p {
        public k(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotation(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class l extends p {
        public l(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class m extends p {
        public m(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class n extends p {
        public n(String str) {
            super(str, null);
        }

        @Override // d0.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // d0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f10) {
            view.setX(f10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3833b;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class p extends d0.c {
        public /* synthetic */ p(String str, f fVar) {
            this(str);
        }

        public p(String str) {
            super(str);
        }
    }

    public b(Object obj, d0.c cVar) {
        this.f3823d = obj;
        this.f3824e = cVar;
        if (cVar == f3811r || cVar == f3812s || cVar == f3813t) {
            this.f3829j = 0.1f;
            return;
        }
        if (cVar == f3817x) {
            this.f3829j = 0.00390625f;
        } else if (cVar == f3809p || cVar == f3810q) {
            this.f3829j = 0.00390625f;
        } else {
            this.f3829j = 1.0f;
        }
    }

    public static void g(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // d0.a.b
    public boolean a(long j10) {
        long j11 = this.f3828i;
        if (j11 == 0) {
            this.f3828i = j10;
            h(this.f3821b);
            return false;
        }
        this.f3828i = j10;
        boolean zL = l(j10 - j11);
        float fMin = Math.min(this.f3821b, this.f3826g);
        this.f3821b = fMin;
        float fMax = Math.max(fMin, this.f3827h);
        this.f3821b = fMax;
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
        if (this.f3825f) {
            c(true);
        }
    }

    public final void c(boolean z10) {
        this.f3825f = false;
        d0.a.d().g(this);
        this.f3828i = 0L;
        this.f3822c = false;
        for (int i10 = 0; i10 < this.f3830k.size(); i10++) {
            if (this.f3830k.get(i10) != null) {
                n.g.a(this.f3830k.get(i10));
                throw null;
            }
        }
        g(this.f3830k);
    }

    public final float d() {
        return this.f3824e.a(this.f3823d);
    }

    public float e() {
        return this.f3829j * 0.75f;
    }

    public boolean f() {
        return this.f3825f;
    }

    public void h(float f10) {
        this.f3824e.b(this.f3823d, f10);
        for (int i10 = 0; i10 < this.f3831l.size(); i10++) {
            if (this.f3831l.get(i10) != null) {
                n.g.a(this.f3831l.get(i10));
                throw null;
            }
        }
        g(this.f3831l);
    }

    public b i(float f10) {
        this.f3821b = f10;
        this.f3822c = true;
        return this;
    }

    public void j() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f3825f) {
            return;
        }
        k();
    }

    public final void k() {
        if (this.f3825f) {
            return;
        }
        this.f3825f = true;
        if (!this.f3822c) {
            this.f3821b = d();
        }
        float f10 = this.f3821b;
        if (f10 > this.f3826g || f10 < this.f3827h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        d0.a.d().a(this, 0L);
    }

    public abstract boolean l(long j10);
}
