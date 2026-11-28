package a7;

import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import io.reactivex.rxjava3.internal.schedulers.i;
import java.util.concurrent.Executor;
import r6.p;
import u6.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f97a = z6.a.h(new h());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f98b = z6.a.e(new b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f99c = z6.a.f(new c());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f100d = i.g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f101e = z6.a.g(new f());

    /* JADX INFO: renamed from: a7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0003a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f102a = new io.reactivex.rxjava3.internal.schedulers.a();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements j {
        @Override // u6.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p get() {
            return C0003a.f102a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c implements j {
        @Override // u6.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p get() {
            return d.f103a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f103a = new io.reactivex.rxjava3.internal.schedulers.d();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f104a = new io.reactivex.rxjava3.internal.schedulers.e();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class f implements j {
        @Override // u6.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p get() {
            return e.f104a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f105a = new io.reactivex.rxjava3.internal.schedulers.h();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class h implements j {
        @Override // u6.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p get() {
            return g.f105a;
        }
    }

    public static p a() {
        return z6.a.n(f98b);
    }

    public static p b(Executor executor) {
        return new ExecutorScheduler(executor, false, false);
    }

    public static p c() {
        return z6.a.p(f99c);
    }

    public static p d() {
        return z6.a.r(f97a);
    }
}
