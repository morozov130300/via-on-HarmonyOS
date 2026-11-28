package q1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import b2.e;
import b2.f;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r1.a f11701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f11702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f11704d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f11705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f11706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f11707g;

    /* JADX INFO: renamed from: q1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0113a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f11709b;

        public C0113a(String str, boolean z10) {
            this.f11708a = str;
            this.f11709b = z10;
        }

        public String a() {
            return this.f11708a;
        }

        public boolean b() {
            return this.f11709b;
        }

        public String toString() {
            String str = this.f11708a;
            boolean z10 = this.f11709b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            sb2.append(z10);
            return sb2.toString();
        }
    }

    public a(Context context, long j10, boolean z10, boolean z11) {
        Context applicationContext;
        u1.f.h(context);
        if (z10 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f11706f = context;
        this.f11703c = false;
        this.f11707g = j10;
    }

    public static C0113a a(Context context) {
        a aVar = new a(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0113a c0113aF = aVar.f(-1);
            aVar.e(c0113aF, true, 0.0f, SystemClock.elapsedRealtime() - jElapsedRealtime, "", null);
            aVar.c();
            return c0113aF;
        } catch (Throwable th) {
            try {
                aVar.e(null, true, 0.0f, -1L, "", th);
                throw th;
            } catch (Throwable th2) {
                aVar.c();
                throw th2;
            }
        }
    }

    public final void c() {
        u1.f.g("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f11706f == null || this.f11701a == null) {
                    return;
                }
                try {
                    if (this.f11703c) {
                        w1.b.b().c(this.f11706f, this.f11701a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f11703c = false;
                this.f11702b = null;
                this.f11701a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d(boolean z10) {
        u1.f.g("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f11703c) {
                    c();
                }
                Context context = this.f11706f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iC = r1.b.b().c(context, 12451000);
                    if (iC != 0 && iC != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    r1.a aVar = new r1.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!w1.b.b().a(context, intent, aVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f11701a = aVar;
                        try {
                            this.f11702b = e.Y(aVar.a(10000L, TimeUnit.MILLISECONDS));
                            this.f11703c = true;
                            if (z10) {
                                g();
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } catch (Throwable th2) {
                        throw new IOException(th2);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new GooglePlayServicesNotAvailableException(9);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final boolean e(C0113a c0113a, boolean z10, float f10, long j10, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", "1");
        if (c0113a != null) {
            map.put("limit_ad_tracking", true != c0113a.b() ? "0" : "1");
            String strA = c0113a.a();
            if (strA != null) {
                map.put("ad_id_size", Integer.toString(strA.length()));
            }
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j10));
        new b(this, map).start();
        return true;
    }

    public final C0113a f(int i10) {
        C0113a c0113a;
        u1.f.g("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f11703c) {
                    synchronized (this.f11704d) {
                        c cVar = this.f11705e;
                        if (cVar == null || !cVar.f11714n) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        d(false);
                        if (!this.f11703c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e10) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e10);
                    }
                }
                u1.f.h(this.f11701a);
                u1.f.h(this.f11702b);
                try {
                    c0113a = new C0113a(this.f11702b.b(), this.f11702b.n(true));
                } catch (RemoteException e11) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e11);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return c0113a;
    }

    public final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public final void g() {
        synchronized (this.f11704d) {
            c cVar = this.f11705e;
            if (cVar != null) {
                cVar.f11713m.countDown();
                try {
                    this.f11705e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j10 = this.f11707g;
            if (j10 > 0) {
                this.f11705e = new c(this, j10);
            }
        }
    }

    public static void b(boolean z10) {
    }
}
