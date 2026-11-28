package q6;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import r6.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f11822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11823d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends p.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f11824c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f11825e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public volatile boolean f11826m;

        public a(Handler handler, boolean z10) {
            this.f11824c = handler;
            this.f11825e = z10;
        }

        @Override // r6.p.c
        public s6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f11826m) {
                return io.reactivex.rxjava3.disposables.a.a();
            }
            b bVar = new b(this.f11824c, z6.a.q(runnable));
            Message messageObtain = Message.obtain(this.f11824c, bVar);
            messageObtain.obj = this;
            if (this.f11825e) {
                messageObtain.setAsynchronous(true);
            }
            this.f11824c.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
            if (!this.f11826m) {
                return bVar;
            }
            this.f11824c.removeCallbacks(bVar);
            return io.reactivex.rxjava3.disposables.a.a();
        }

        @Override // s6.b
        public void dispose() {
            this.f11826m = true;
            this.f11824c.removeCallbacksAndMessages(this);
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f11826m;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements Runnable, s6.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f11827c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Runnable f11828e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public volatile boolean f11829m;

        public b(Handler handler, Runnable runnable) {
            this.f11827c = handler;
            this.f11828e = runnable;
        }

        @Override // s6.b
        public void dispose() {
            this.f11827c.removeCallbacks(this);
            this.f11829m = true;
        }

        @Override // s6.b
        public boolean isDisposed() {
            return this.f11829m;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f11828e.run();
            } catch (Throwable th) {
                z6.a.o(th);
            }
        }
    }

    public d(Handler handler, boolean z10) {
        this.f11822c = handler;
        this.f11823d = z10;
    }

    @Override // r6.p
    public p.c c() {
        return new a(this.f11822c, this.f11823d);
    }

    @Override // r6.p
    public s6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        b bVar = new b(this.f11822c, z6.a.q(runnable));
        Message messageObtain = Message.obtain(this.f11822c, bVar);
        if (this.f11823d) {
            messageObtain.setAsynchronous(true);
        }
        this.f11822c.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
        return bVar;
    }
}
