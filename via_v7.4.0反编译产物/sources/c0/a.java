package c0;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import k.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f2167g = new ThreadLocal();

    /* renamed from: d, reason: collision with root package name */
    public c f2171d;

    /* renamed from: a, reason: collision with root package name */
    public final g f2168a = new g();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2169b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final C0037a f2170c = new C0037a();

    /* renamed from: e, reason: collision with root package name */
    public long f2172e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2173f = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: c0.a$a, reason: collision with other inner class name */
    public class C0037a {
        public C0037a() {
        }

        public void a() {
            a.this.f2172e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f2172e);
            if (a.this.f2169b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        boolean a(long j10);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final C0037a f2175a;

        public c(C0037a c0037a) {
            this.f2175a = c0037a;
        }

        public abstract void a();
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        public final Choreographer f2176b;

        /* renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f2177c;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: c0.a$d$a, reason: collision with other inner class name */
        public class ChoreographerFrameCallbackC0038a implements Choreographer.FrameCallback {
            public ChoreographerFrameCallbackC0038a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                d.this.f2175a.a();
            }
        }

        public d(C0037a c0037a) {
            super(c0037a);
            this.f2176b = Choreographer.getInstance();
            this.f2177c = new ChoreographerFrameCallbackC0038a();
        }

        @Override // c0.a.c
        public void a() {
            this.f2176b.postFrameCallback(this.f2177c);
        }
    }

    public static a d() {
        ThreadLocal threadLocal = f2167g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return (a) threadLocal.get();
    }

    public void a(b bVar, long j10) {
        if (this.f2169b.size() == 0) {
            e().a();
        }
        if (!this.f2169b.contains(bVar)) {
            this.f2169b.add(bVar);
        }
        if (j10 > 0) {
            this.f2168a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    public final void b() {
        if (this.f2173f) {
            for (int size = this.f2169b.size() - 1; size >= 0; size--) {
                if (this.f2169b.get(size) == null) {
                    this.f2169b.remove(size);
                }
            }
            this.f2173f = false;
        }
    }

    public void c(long j10) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f2169b.size(); i10++) {
            b bVar = (b) this.f2169b.get(i10);
            if (bVar != null && f(bVar, jUptimeMillis)) {
                bVar.a(j10);
            }
        }
        b();
    }

    public c e() {
        if (this.f2171d == null) {
            this.f2171d = new d(this.f2170c);
        }
        return this.f2171d;
    }

    public final boolean f(b bVar, long j10) {
        Long l10 = (Long) this.f2168a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f2168a.remove(bVar);
        return true;
    }

    public void g(b bVar) {
        this.f2168a.remove(bVar);
        int iIndexOf = this.f2169b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f2169b.set(iIndexOf, null);
            this.f2173f = true;
        }
    }
}
