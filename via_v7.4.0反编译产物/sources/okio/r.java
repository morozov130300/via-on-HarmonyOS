package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class r {

    /* renamed from: d, reason: collision with root package name */
    public static final r f10868d = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f10869a;

    /* renamed from: b, reason: collision with root package name */
    public long f10870b;

    /* renamed from: c, reason: collision with root package name */
    public long f10871c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends r {
        @Override // okio.r
        public r d(long j10) {
            return this;
        }

        @Override // okio.r
        public void f() {
        }

        @Override // okio.r
        public r g(long j10, TimeUnit timeUnit) {
            return this;
        }
    }

    public r a() {
        this.f10869a = false;
        return this;
    }

    public r b() {
        this.f10871c = 0L;
        return this;
    }

    public long c() {
        if (this.f10869a) {
            return this.f10870b;
        }
        throw new IllegalStateException("No deadline");
    }

    public r d(long j10) {
        this.f10869a = true;
        this.f10870b = j10;
        return this;
    }

    public boolean e() {
        return this.f10869a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f10869a && this.f10870b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public r g(long j10, TimeUnit timeUnit) {
        if (j10 >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f10871c = timeUnit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j10);
    }

    public long h() {
        return this.f10871c;
    }
}
