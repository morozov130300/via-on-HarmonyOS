package s2;

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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11730a;

    /* renamed from: b, reason: collision with root package name */
    public final h2.e f11731b;

    /* renamed from: c, reason: collision with root package name */
    public final s f11732c;

    /* renamed from: f, reason: collision with root package name */
    public n f11735f;

    /* renamed from: g, reason: collision with root package name */
    public n f11736g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11737h;

    /* renamed from: i, reason: collision with root package name */
    public k f11738i;

    /* renamed from: j, reason: collision with root package name */
    public final v f11739j;

    /* renamed from: k, reason: collision with root package name */
    public final x2.g f11740k;

    /* renamed from: l, reason: collision with root package name */
    public final r2.b f11741l;

    /* renamed from: m, reason: collision with root package name */
    public final q2.a f11742m;

    /* renamed from: n, reason: collision with root package name */
    public final ExecutorService f11743n;

    /* renamed from: o, reason: collision with root package name */
    public final h f11744o;

    /* renamed from: p, reason: collision with root package name */
    public final p2.a f11745p;

    /* renamed from: e, reason: collision with root package name */
    public final long f11734e = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    public final a0 f11733d = new a0();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Callable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ z2.g f11746e;

        public a(z2.g gVar) {
            this.f11746e = gVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g2.f call() {
            return m.this.f(this.f11746e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ z2.g f11748e;

        public b(z2.g gVar) {
            this.f11748e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.f(this.f11748e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements Callable {
        public c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            try {
                boolean zD = m.this.f11735f.d();
                if (!zD) {
                    p2.f.f().k("Initialization marker file was not properly removed.");
                }
                return Boolean.valueOf(zD);
            } catch (Exception e10) {
                p2.f.f().e("Problem encountered deleting Crashlytics initialization marker.", e10);
                return Boolean.FALSE;
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements Callable {
        public d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(m.this.f11738i.s());
        }
    }

    public m(h2.e eVar, v vVar, p2.a aVar, s sVar, r2.b bVar, q2.a aVar2, x2.g gVar, ExecutorService executorService) {
        this.f11731b = eVar;
        this.f11732c = sVar;
        this.f11730a = eVar.j();
        this.f11739j = vVar;
        this.f11745p = aVar;
        this.f11741l = bVar;
        this.f11742m = aVar2;
        this.f11743n = executorService;
        this.f11740k = gVar;
        this.f11744o = new h(executorService);
    }

    public static String i() {
        return "18.3.7";
    }

    public static boolean j(String str, boolean z10) {
        if (!z10) {
            p2.f.f().i("Configured not to require a build ID.");
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
            this.f11737h = Boolean.TRUE.equals((Boolean) u0.f(this.f11744o.g(new d())));
        } catch (Exception unused) {
            this.f11737h = false;
        }
    }

    public boolean e() {
        return this.f11735f.c();
    }

    public final g2.f f(z2.g gVar) {
        m();
        try {
            this.f11741l.a(new r2.a() { // from class: s2.l
                @Override // r2.a
                public final void a(String str) {
                    this.f11729a.k(str);
                }
            });
            this.f11738i.R();
            if (!gVar.b().f14563b.f14570a) {
                p2.f.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return g2.i.d(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f11738i.z(gVar)) {
                p2.f.f().k("Previous sessions could not be finalized.");
            }
            return this.f11738i.T(gVar.a());
        } catch (Exception e10) {
            p2.f.f().e("Crashlytics encountered a problem during asynchronous initialization.", e10);
            return g2.i.d(e10);
        } finally {
            l();
        }
    }

    public g2.f g(z2.g gVar) {
        return u0.h(this.f11743n, new a(gVar));
    }

    public final void h(z2.g gVar) throws ExecutionException, InterruptedException, TimeoutException {
        Future<?> futureSubmit = this.f11743n.submit(new b(gVar));
        p2.f.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            p2.f.f().e("Crashlytics was interrupted during initialization.", e10);
        } catch (ExecutionException e11) {
            p2.f.f().e("Crashlytics encountered a problem during initialization.", e11);
        } catch (TimeoutException e12) {
            p2.f.f().e("Crashlytics timed out during initialization.", e12);
        }
    }

    public void k(String str) {
        this.f11738i.W(System.currentTimeMillis() - this.f11734e, str);
    }

    public void l() {
        this.f11744o.g(new c());
    }

    public void m() {
        this.f11744o.b();
        this.f11735f.a();
        p2.f.f().i("Initialization marker file was created.");
    }

    public boolean n(s2.a aVar, z2.g gVar) {
        if (!j(aVar.f11656b, CommonUtils.k(this.f11730a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
        String string = new g(this.f11739j).toString();
        try {
            this.f11736g = new n("crash_marker", this.f11740k);
            this.f11735f = new n("initialization_marker", this.f11740k);
            t2.h hVar = new t2.h(string, this.f11740k, this.f11744o);
            t2.c cVar = new t2.c(this.f11740k);
            this.f11738i = new k(this.f11730a, this.f11744o, this.f11739j, this.f11732c, this.f11740k, this.f11736g, aVar, hVar, cVar, n0.g(this.f11730a, this.f11739j, this.f11740k, aVar, cVar, hVar, new a3.a(1024, new a3.c(10)), gVar, this.f11733d), this.f11745p, this.f11742m);
            boolean zE = e();
            d();
            this.f11738i.x(string, Thread.getDefaultUncaughtExceptionHandler(), gVar);
            if (!zE || !CommonUtils.c(this.f11730a)) {
                p2.f.f().b("Successfully configured exception handler.");
                return true;
            }
            p2.f.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            h(gVar);
            return false;
        } catch (Exception e10) {
            p2.f.f().e("Crashlytics was not started due to an exception during initialization", e10);
            this.f11738i = null;
            return false;
        }
    }
}
