package h5;

import android.os.SystemClock;
import e5.g;
import j5.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f5688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f5.c f5689c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5687a = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j5.b f5690d = new j5.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f5691e = new d();

    /* JADX INFO: renamed from: h5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class RunnableC0073a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g5.c f5692c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f5693e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f5694m;

        public RunnableC0073a(g5.c cVar, int i10, int i11) {
            this.f5692c = cVar;
            this.f5693e = i10;
            this.f5694m = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f5689c.b(this.f5692c);
            a.this.f5691e.I(this.f5692c, this.f5693e, this.f5694m);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g5.c f5696c;

        public b(g5.c cVar) {
            this.f5696c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j5.b bVar = a.this.f5690d;
            g5.c cVar = this.f5696c;
            bVar.u(cVar, cVar.c(), this.f5696c.r());
        }
    }

    public a(g gVar, f5.c cVar) {
        this.f5688b = gVar;
        this.f5689c = cVar;
    }

    @Override // h5.c
    public void a(g5.c cVar, g5.a aVar, long j10, long j11) {
        Long l10 = (Long) this.f5687a.get(Long.valueOf(cVar.j()));
        long jElapsedRealtime = l10 == null ? 0L : SystemClock.elapsedRealtime() - l10.longValue();
        if (l10 == null || jElapsedRealtime > 1000 || (j10 == j11 && cVar.c() != cVar.r())) {
            this.f5687a.put(Long.valueOf(cVar.j()), Long.valueOf(SystemClock.elapsedRealtime()));
            List<g5.a> listH = this.f5689c.h(cVar.j());
            if (listH == null || listH.isEmpty()) {
                return;
            }
            long jB = 0;
            for (g5.a aVar2 : listH) {
                jB += aVar2.b();
                aVar2.g();
            }
            if (cVar.r() <= 0 || jB < cVar.r()) {
                long jC = ((jB < cVar.c() ? jB : jB - cVar.c()) * 1000) / Math.max(100L, jElapsedRealtime);
                if (cVar.p() != 0) {
                    jC = ((cVar.p() * 3) + jC) / 4;
                }
                cVar.P(jC);
            } else {
                cVar.P(-1L);
            }
            cVar.z(jB);
            this.f5689c.d(aVar);
            this.f5689c.b(cVar);
            this.f5688b.a().execute(new b(cVar));
        }
    }

    @Override // h5.c
    public void b(g5.c cVar, int i10, int i11) {
        if (i11 == 92) {
            this.f5687a.put(Long.valueOf(cVar.j()), Long.valueOf(SystemClock.elapsedRealtime()));
        }
        this.f5688b.a().execute(new RunnableC0073a(cVar, i10, i11));
    }

    @Override // h5.c
    public void c(j5.c cVar) {
        this.f5691e.b(cVar);
    }

    @Override // h5.c
    public void d(j5.a aVar) {
        this.f5690d.a(aVar);
    }

    @Override // h5.c
    public void e(j5.c cVar) {
        this.f5691e.a(cVar);
    }

    @Override // h5.c
    public void f(j5.a aVar) {
        this.f5690d.b(aVar);
    }
}
