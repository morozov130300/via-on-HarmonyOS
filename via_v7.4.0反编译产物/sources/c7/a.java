package c7;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a7.f f2308a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final Runnable f2309b = new f();

    /* renamed from: c, reason: collision with root package name */
    public static final a7.a f2310c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final a7.e f2311d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final a7.e f2312e = new g();

    /* renamed from: f, reason: collision with root package name */
    public static final a7.e f2313f = new l();

    /* renamed from: g, reason: collision with root package name */
    public static final a7.g f2314g = new e();

    /* renamed from: h, reason: collision with root package name */
    public static final a7.h f2315h = new m();

    /* renamed from: i, reason: collision with root package name */
    public static final a7.h f2316i = new h();

    /* renamed from: j, reason: collision with root package name */
    public static final a7.i f2317j = new k();

    /* renamed from: k, reason: collision with root package name */
    public static final a7.e f2318k = new j();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: c7.a$a, reason: collision with other inner class name */
    public static final class C0042a implements a7.f {

        /* renamed from: a, reason: collision with root package name */
        public final a7.b f2319a;

        public C0042a(a7.b bVar) {
            this.f2319a = bVar;
        }

        @Override // a7.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f2319a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements a7.i {

        /* renamed from: e, reason: collision with root package name */
        public final int f2320e;

        public b(int i10) {
            this.f2320e = i10;
        }

        @Override // a7.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new ArrayList(this.f2320e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c implements a7.a {
        @Override // a7.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class d implements a7.e {
        @Override // a7.e
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class e implements a7.g {
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class f implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class g implements a7.e {
        @Override // a7.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            f7.a.o(th);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class h implements a7.h {
        @Override // a7.h
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class i implements a7.f {
        @Override // a7.f
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class j implements a7.e {
        public void a(oc.b bVar) {
            bVar.a(Long.MAX_VALUE);
        }

        @Override // a7.e
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            n.g.a(obj);
            a(null);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class k implements a7.i {
        @Override // a7.i
        public Object get() {
            return null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class l implements a7.e {
        @Override // a7.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            f7.a.o(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class m implements a7.h {
        @Override // a7.h
        public boolean test(Object obj) {
            return true;
        }
    }

    public static a7.i a(int i10) {
        return new b(i10);
    }

    public static a7.e b() {
        return f2311d;
    }

    public static a7.f c() {
        return f2308a;
    }

    public static a7.f d(a7.b bVar) {
        return new C0042a(bVar);
    }
}
