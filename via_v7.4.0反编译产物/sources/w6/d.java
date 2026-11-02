package w6;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends n {

    /* renamed from: c, reason: collision with root package name */
    public final Handler f13342c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13343d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends n.b {

        /* renamed from: e, reason: collision with root package name */
        public final Handler f13344e;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f13345j;

        /* renamed from: k, reason: collision with root package name */
        public volatile boolean f13346k;

        public a(Handler handler, boolean z10) {
            this.f13344e = handler;
            this.f13345j = z10;
        }

        @Override // x6.n.b
        public y6.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f13346k) {
                return io.reactivex.rxjava3.disposables.a.a();
            }
            b bVar = new b(this.f13344e, f7.a.q(runnable));
            Message messageObtain = Message.obtain(this.f13344e, bVar);
            messageObtain.obj = this;
            if (this.f13345j) {
                messageObtain.setAsynchronous(true);
            }
            this.f13344e.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
            if (!this.f13346k) {
                return bVar;
            }
            this.f13344e.removeCallbacks(bVar);
            return io.reactivex.rxjava3.disposables.a.a();
        }

        @Override // y6.b
        public void dispose() {
            this.f13346k = true;
            this.f13344e.removeCallbacksAndMessages(this);
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f13346k;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements Runnable, y6.b {

        /* renamed from: e, reason: collision with root package name */
        public final Handler f13347e;

        /* renamed from: j, reason: collision with root package name */
        public final Runnable f13348j;

        /* renamed from: k, reason: collision with root package name */
        public volatile boolean f13349k;

        public b(Handler handler, Runnable runnable) {
            this.f13347e = handler;
            this.f13348j = runnable;
        }

        @Override // y6.b
        public void dispose() {
            this.f13347e.removeCallbacks(this);
            this.f13349k = true;
        }

        @Override // y6.b
        public boolean isDisposed() {
            return this.f13349k;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f13348j.run();
            } catch (Throwable th) {
                f7.a.o(th);
            }
        }
    }

    public d(Handler handler, boolean z10) {
        this.f13342c = handler;
        this.f13343d = z10;
    }

    @Override // x6.n
    public n.b c() {
        return new a(this.f13342c, this.f13343d);
    }

    @Override // x6.n
    public y6.b e(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        b bVar = new b(this.f13342c, f7.a.q(runnable));
        Message messageObtain = Message.obtain(this.f13342c, bVar);
        if (this.f13343d) {
            messageObtain.setAsynchronous(true);
        }
        this.f13342c.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
        return bVar;
    }
}
