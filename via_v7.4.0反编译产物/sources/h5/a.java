package h5;

import android.os.SystemClock;
import e5.g;
import j5.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: b, reason: collision with root package name */
    public final g f6374b;

    /* renamed from: c, reason: collision with root package name */
    public final f5.c f6375c;

    /* renamed from: a, reason: collision with root package name */
    public final Map f6373a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final j5.b f6376d = new j5.b();

    /* renamed from: e, reason: collision with root package name */
    public final d f6377e = new d();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: h5.a$a, reason: collision with other inner class name */
    public class RunnableC0075a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g5.c f6378e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f6379j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f6380k;

        public RunnableC0075a(g5.c cVar, int i10, int i11) {
            this.f6378e = cVar;
            this.f6379j = i10;
            this.f6380k = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f6375c.b(this.f6378e);
            a.this.f6377e.J(this.f6378e, this.f6379j, this.f6380k);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g5.c f6382e;

        public b(g5.c cVar) {
            this.f6382e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j5.b bVar = a.this.f6376d;
            g5.c cVar = this.f6382e;
            bVar.v(cVar, cVar.c(), this.f6382e.r());
        }
    }

    public a(g gVar, f5.c cVar) {
        this.f6374b = gVar;
        this.f6375c = cVar;
    }

    @Override // h5.c
    public void a(g5.c cVar, g5.a aVar, long j10, long j11) {
        Long l10 = (Long) this.f6373a.get(Long.valueOf(cVar.j()));
        long jElapsedRealtime = l10 == null ? 0L : SystemClock.elapsedRealtime() - l10.longValue();
        if (l10 == null || jElapsedRealtime > 1000 || (j10 == j11 && cVar.c() != cVar.r())) {
            this.f6373a.put(Long.valueOf(cVar.j()), Long.valueOf(SystemClock.elapsedRealtime()));
            List<g5.a> listI = this.f6375c.i(cVar.j());
            if (listI == null || listI.isEmpty()) {
                return;
            }
            long jB = 0;
            for (g5.a aVar2 : listI) {
                jB += aVar2.b();
                aVar2.g();
            }
            if (cVar.r() <= 0 || jB < cVar.r()) {
                long jC = ((jB < cVar.c() ? jB : jB - cVar.c()) * 1000) / Math.max(100L, jElapsedRealtime);
                if (cVar.p() != 0) {
                    jC = ((cVar.p() * 3) + jC) / 4;
                }
                cVar.O(jC);
            } else {
                cVar.O(-1L);
            }
            cVar.z(jB);
            this.f6375c.c(aVar);
            this.f6375c.b(cVar);
            this.f6374b.a().execute(new b(cVar));
        }
    }

    @Override // h5.c
    public void b(g5.c cVar, int i10, int i11) {
        if (i11 == 92) {
            this.f6373a.put(Long.valueOf(cVar.j()), Long.valueOf(SystemClock.elapsedRealtime()));
        }
        this.f6374b.a().execute(new RunnableC0075a(cVar, i10, i11));
    }

    @Override // h5.c
    public void c(j5.c cVar) {
        this.f6377e.b(cVar);
    }

    @Override // h5.c
    public void d(j5.a aVar) {
        this.f6376d.a(aVar);
    }

    @Override // h5.c
    public void e(j5.c cVar) {
        this.f6377e.a(cVar);
    }

    @Override // h5.c
    public void f(j5.a aVar) {
        this.f6376d.b(aVar);
    }
}
