package mark.via;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import c6.x;
import i8.d;
import java.io.File;
import la.a;
import la.q;
import la.r;
import mark.via.BrowserApp;
import r8.f;
import x8.a0;
import x8.c1;
import x8.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class BrowserApp extends Application {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f8084c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f8085e;

    public static /* synthetic */ void a(Throwable th) {
        tc.a.e(th);
        f.a().c("UncaughtException", th.getMessage(), th);
    }

    public static /* synthetic */ void b(BrowserApp browserApp, Thread thread, Throwable th) {
        browserApp.getClass();
        try {
            String str = "Exception Happend\n" + thread + "\n" + th.toString();
            tc.a.e(th);
            Toast.makeText(browserApp, str, 0).show();
            f.a().c("UncaughtException", th.getMessage(), th);
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void c(final BrowserApp browserApp, final Thread thread, final Throwable th) {
        browserApp.getClass();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: w7.e
            @Override // java.lang.Runnable
            public final void run() {
                BrowserApp.b(this.f13694c, thread, th);
            }
        });
    }

    public static /* synthetic */ void d(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile == null) {
            return;
        }
        c1.f(parentFile);
        c1.N(parentFile);
    }

    public static a e() {
        return f8084c;
    }

    public static String f() {
        return f8085e;
    }

    public final void g() {
        com.tuyafeng.support.crash.a.b(new com.tuyafeng.support.crash.a.c() { // from class: w7.b
            @Override // com.tuyafeng.support.crash.a.c
            public final void a(Thread thread, Throwable th) {
                BrowserApp.c(this.f13688a, thread, th);
            }
        });
        z6.a.w(new u6.f() { // from class: w7.c
            @Override // u6.f
            public final void accept(Object obj) {
                BrowserApp.a((Throwable) obj);
            }
        });
    }

    public final void h() {
        f8084c = q.K().a(this);
    }

    public final void j() {
        final String strY = c1.y(this, "logs", "log.txt");
        if (strY == null) {
            return;
        }
        tc.a.h(new d(strY, 5));
        if (f8084c.o().I() < 20261125) {
            h.b(new Runnable() { // from class: w7.d
                @Override // java.lang.Runnable
                public final void run() {
                    BrowserApp.d(strY);
                }
            });
        }
    }

    public final void k() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        String processName = Application.getProcessName();
        String packageName = getPackageName();
        if (TextUtils.isEmpty(processName) || processName.equals(packageName)) {
            return;
        }
        WebView.setDataDirectorySuffix(processName);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        tc.a.a("BrowserApp::onCreate", new Object[0]);
        r.b(this);
        x.f2131a.f(a0.f() || x8.f.h());
        f8085e = a0.d(this);
        i();
        h();
        j();
        g();
        k();
        tc.a.a("BrowserApp::onCreate, cost time: %d", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    public final void i() {
    }
}
