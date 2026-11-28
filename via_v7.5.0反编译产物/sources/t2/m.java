package t2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i2.e f12399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f12400c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f12403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f12404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f12406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v f12407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y2.g f12408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s2.b f12409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r2.a f12410m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ExecutorService f12411n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h f12412o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q2.a f12413p;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f12402e = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0 f12401d = new a0();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Callable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a3.g f12414c;

        public a(a3.g gVar) {
            this.f12414c = gVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h2.f call() {
            return m.this.f(this.f12414c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a3.g f12416c;

        public b(a3.g gVar) {
            this.f12416c = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.f(this.f12416c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements Callable {
        public c() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            try {
                boolean zD = m.this.f12403f.d();
                if (!zD) {
                    q2.f.f().k("Initialization marker file was not properly removed.");
                }
                return Boolean.valueOf(zD);
            } catch (Exception e10) {
                q2.f.f().e("Problem encountered deleting Crashlytics initialization marker.", e10);
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements Callable {
        public d() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(m.this.f12406i.s());
        }
    }

    public m(i2.e eVar, v vVar, q2.a aVar, s sVar, s2.b bVar, r2.a aVar2, y2.g gVar, ExecutorService executorService) {
        this.f12399b = eVar;
        this.f12400c = sVar;
        this.f12398a = eVar.j();
        this.f12407j = vVar;
        this.f12413p = aVar;
        this.f12409l = bVar;
        this.f12410m = aVar2;
        this.f12411n = executorService;
        this.f12408k = gVar;
        this.f12412o = new h(executorService);
    }

    public static String i() {
        return "18.3.7";
    }

    public static boolean j(String str, boolean z10) {
        if (!z10) {
            q2.f.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }

    public final void d() {
        try {
            this.f12405h = Boolean.TRUE.equals((Boolean) u0.f(this.f12412o.g(new d())));
        } catch (Exception unused) {
            this.f12405h = false;
        }
    }

    public boolean e() {
        return this.f12403f.c();
    }

    public final h2.f f(a3.g gVar) {
        m();
        try {
            this.f12409l.a(new s2.a() { // from class: t2.l
                @Override // s2.a
                public final void a(String str) {
                    this.f12397a.k(str);
                }
            });
            this.f12406i.R();
            if (!gVar.b().f31b.f38a) {
                q2.f.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return h2.i.d(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f12406i.z(gVar)) {
                q2.f.f().k("Previous sessions could not be finalized.");
            }
            return this.f12406i.T(gVar.a());
        } catch (Exception e10) {
            q2.f.f().e("Crashlytics encountered a problem during asynchronous initialization.", e10);
            return h2.i.d(e10);
        } finally {
            l();
        }
    }

    public h2.f g(a3.g gVar) {
        return u0.h(this.f12411n, new a(gVar));
    }

    public final void h(a3.g gVar) {
        Future<?> futureSubmit = this.f12411n.submit(new b(gVar));
        q2.f.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            q2.f.f().e("Crashlytics was interrupted during initialization.", e10);
        } catch (ExecutionException e11) {
            q2.f.f().e("Crashlytics encountered a problem during initialization.", e11);
        } catch (TimeoutException e12) {
            q2.f.f().e("Crashlytics timed out during initialization.", e12);
        }
    }

    public void k(String str) {
        this.f12406i.W(System.currentTimeMillis() - this.f12402e, str);
    }

    public void l() {
        this.f12412o.g(new c());
    }

    public void m() {
        this.f12412o.b();
        this.f12403f.a();
        q2.f.f().i("Initialization marker file was created.");
    }

    public boolean n(t2.a aVar, a3.g gVar) {
        if (!j(aVar.f12324b, CommonUtils.k(this.f12398a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
        String string = new g(this.f12407j).toString();
        try {
            this.f12404g = new n("crash_marker", this.f12408k);
            this.f12403f = new n("initialization_marker", this.f12408k);
            u2.h hVar = new u2.h(string, this.f12408k, this.f12412o);
            u2.c cVar = new u2.c(this.f12408k);
            this.f12406i = new k(this.f12398a, this.f12412o, this.f12407j, this.f12400c, this.f12408k, this.f12404g, aVar, hVar, cVar, n0.g(this.f12398a, this.f12407j, this.f12408k, aVar, cVar, hVar, new b3.a(1024, new b3.c(10)), gVar, this.f12401d), this.f12413p, this.f12410m);
            boolean zE = e();
            d();
            this.f12406i.x(string, Thread.getDefaultUncaughtExceptionHandler(), gVar);
            if (!zE || !CommonUtils.c(this.f12398a)) {
                q2.f.f().b("Successfully configured exception handler.");
                return true;
            }
            q2.f.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            h(gVar);
            return false;
        } catch (Exception e10) {
            q2.f.f().e("Crashlytics was not started due to an exception during initialization", e10);
            this.f12406i = null;
            return false;
        }
    }
}
