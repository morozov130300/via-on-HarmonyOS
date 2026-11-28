package w6;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u6.g f13674a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f13675b = new f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u6.a f13676c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u6.f f13677d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u6.f f13678e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u6.f f13679f = new l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u6.h f13680g = new e();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u6.i f13681h = new m();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u6.i f13682i = new h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u6.j f13683j = new k();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u6.f f13684k = new j();

    /* JADX INFO: renamed from: w6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0155a implements u6.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u6.b f13685a;

        public C0155a(u6.b bVar) {
            this.f13685a = bVar;
        }

        @Override // u6.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f13685a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements u6.j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13686c;

        public b(int i10) {
            this.f13686c = i10;
        }

        @Override // u6.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new ArrayList(this.f13686c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class e implements u6.h {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class g implements u6.f {
        @Override // u6.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            z6.a.o(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class h implements u6.i {
        @Override // u6.i
        public boolean test(Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class j implements u6.f {
        public void a(sc.b bVar) {
            bVar.a(Long.MAX_VALUE);
        }

        @Override // u6.f
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            n.g.a(obj);
            a(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class k implements u6.j {
        @Override // u6.j
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class l implements u6.f {
        @Override // u6.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            z6.a.o(new OnErrorNotImplementedException(th));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class m implements u6.i {
        @Override // u6.i
        public boolean test(Object obj) {
            return true;
        }
    }

    public static u6.j a(int i10) {
        return new b(i10);
    }

    public static u6.f b() {
        return f13677d;
    }

    public static u6.g c() {
        return f13674a;
    }

    public static u6.g d(u6.b bVar) {
        return new C0155a(bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c implements u6.a {
        public String toString() {
            return "EmptyAction";
        }

        @Override // u6.a
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class d implements u6.f {
        public String toString() {
            return "EmptyConsumer";
        }

        @Override // u6.f
        public void accept(Object obj) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class f implements Runnable {
        public String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class i implements u6.g {
        public String toString() {
            return "IdentityFunction";
        }

        @Override // u6.g
        public Object apply(Object obj) {
            return obj;
        }
    }
}
