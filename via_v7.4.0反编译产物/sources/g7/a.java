package g7;

import a7.i;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import java.util.concurrent.Executor;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final n f6259a = f7.a.h(new h());

    /* renamed from: b, reason: collision with root package name */
    public static final n f6260b = f7.a.e(new b());

    /* renamed from: c, reason: collision with root package name */
    public static final n f6261c = f7.a.f(new c());

    /* renamed from: d, reason: collision with root package name */
    public static final n f6262d = io.reactivex.rxjava3.internal.schedulers.h.f();

    /* renamed from: e, reason: collision with root package name */
    public static final n f6263e = f7.a.g(new f());

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: g7.a$a, reason: collision with other inner class name */
    public static final class C0072a {

        /* renamed from: a, reason: collision with root package name */
        public static final n f6264a = new io.reactivex.rxjava3.internal.schedulers.a();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements i {
        @Override // a7.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n get() {
            return C0072a.f6264a;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c implements i {
        @Override // a7.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n get() {
            return d.f6265a;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final n f6265a = new io.reactivex.rxjava3.internal.schedulers.c();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final n f6266a = new io.reactivex.rxjava3.internal.schedulers.d();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class f implements i {
        @Override // a7.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n get() {
            return e.f6266a;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public static final n f6267a = new io.reactivex.rxjava3.internal.schedulers.g();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class h implements i {
        @Override // a7.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n get() {
            return g.f6267a;
        }
    }

    public static n a() {
        return f7.a.n(f6260b);
    }

    public static n b(Executor executor) {
        return new ExecutorScheduler(executor, false, false);
    }

    public static n c() {
        return f7.a.p(f6261c);
    }

    public static n d() {
        return f7.a.r(f6259a);
    }
}
