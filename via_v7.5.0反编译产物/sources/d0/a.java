package d0;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import k.g;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f3794g = new ThreadLocal();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f3798d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f3795a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3796b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0052a f3797c = new C0052a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3799e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3800f = false;

    /* JADX INFO: renamed from: d0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0052a {
        public C0052a() {
        }

        public void a() {
            a.this.f3799e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f3799e);
            if (a.this.f3796b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        boolean a(long j10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0052a f3802a;

        public c(C0052a c0052a) {
            this.f3802a = c0052a;
        }

        public abstract void a();
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Choreographer f3803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f3804c;

        /* JADX INFO: renamed from: d0.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class ChoreographerFrameCallbackC0053a implements Choreographer.FrameCallback {
            public ChoreographerFrameCallbackC0053a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                d.this.f3802a.a();
            }
        }

        public d(C0052a c0052a) {
            super(c0052a);
            this.f3803b = Choreographer.getInstance();
            this.f3804c = new ChoreographerFrameCallbackC0053a();
        }

        @Override // d0.a.c
        public void a() {
            this.f3803b.postFrameCallback(this.f3804c);
        }
    }

    public static a d() {
        ThreadLocal threadLocal = f3794g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return (a) threadLocal.get();
    }

    public void a(b bVar, long j10) {
        if (this.f3796b.size() == 0) {
            e().a();
        }
        if (!this.f3796b.contains(bVar)) {
            this.f3796b.add(bVar);
        }
        if (j10 > 0) {
            this.f3795a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    public final void b() {
        if (this.f3800f) {
            for (int size = this.f3796b.size() - 1; size >= 0; size--) {
                if (this.f3796b.get(size) == null) {
                    this.f3796b.remove(size);
                }
            }
            this.f3800f = false;
        }
    }

    public void c(long j10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f3796b.size(); i10++) {
            b bVar = (b) this.f3796b.get(i10);
            if (bVar != null && f(bVar, jUptimeMillis)) {
                bVar.a(j10);
            }
        }
        b();
    }

    public c e() {
        if (this.f3798d == null) {
            this.f3798d = new d(this.f3797c);
        }
        return this.f3798d;
    }

    public final boolean f(b bVar, long j10) {
        Long l10 = (Long) this.f3795a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f3795a.remove(bVar);
        return true;
    }

    public void g(b bVar) {
        this.f3795a.remove(bVar);
        int iIndexOf = this.f3796b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f3796b.set(iIndexOf, null);
            this.f3800f = true;
        }
    }
}
