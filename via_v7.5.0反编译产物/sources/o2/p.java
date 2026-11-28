package o2;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p extends AbstractResolvableFuture implements ScheduledFuture {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ScheduledFuture f10911r;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements b {
        public a() {
        }

        @Override // o2.p.b
        public void a(Throwable th) {
            p.this.q(th);
        }

        @Override // o2.p.b
        public void set(Object obj) {
            p.this.p(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(Throwable th);

        void set(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        ScheduledFuture a(b bVar);
    }

    public p(c cVar) {
        this.f10911r = cVar.a(new a());
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public void d() {
        this.f10911r.cancel(s());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f10911r.getDelay(timeUnit);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f10911r.compareTo(delayed);
    }
}
