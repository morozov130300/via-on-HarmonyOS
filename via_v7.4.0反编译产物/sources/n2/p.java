package n2;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p extends AbstractResolvableFuture implements ScheduledFuture {

    /* renamed from: p, reason: collision with root package name */
    public final ScheduledFuture f10187p;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements b {
        public a() {
        }

        @Override // n2.p.b
        public void a(Throwable th) {
            p.this.o(th);
        }

        @Override // n2.p.b
        public void set(Object obj) {
            p.this.n(obj);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(Throwable th);

        void set(Object obj);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        ScheduledFuture a(b bVar);
    }

    public p(c cVar) {
        this.f10187p = cVar.a(new a());
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public void b() {
        this.f10187p.cancel(q());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f10187p.getDelay(timeUnit);
    }

    @Override // java.lang.Comparable
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f10187p.compareTo(delayed);
    }
}
