package t1;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i0 extends b {

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f12055f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Context f12056g;

    /* renamed from: h, reason: collision with root package name */
    public volatile Handler f12057h;

    /* renamed from: i, reason: collision with root package name */
    public final h0 f12058i;

    /* renamed from: j, reason: collision with root package name */
    public final v1.b f12059j;

    /* renamed from: k, reason: collision with root package name */
    public final long f12060k;

    /* renamed from: l, reason: collision with root package name */
    public final long f12061l;

    public i0(Context context, Looper looper) {
        h0 h0Var = new h0(this, null);
        this.f12058i = h0Var;
        this.f12056g = context.getApplicationContext();
        this.f12057h = new b2.d(looper, h0Var);
        this.f12059j = v1.b.b();
        this.f12060k = 5000L;
        this.f12061l = 300000L;
    }

    @Override // t1.b
    public final void d(d0 d0Var, ServiceConnection serviceConnection, String str) {
        f.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f12055f) {
            try {
                f0 f0Var = (f0) this.f12055f.get(d0Var);
                if (f0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + d0Var.toString());
                }
                if (!f0Var.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + d0Var.toString());
                }
                f0Var.f(serviceConnection, str);
                if (f0Var.i()) {
                    this.f12057h.sendMessageDelayed(this.f12057h.obtainMessage(0, d0Var), this.f12060k);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t1.b
    public final boolean f(d0 d0Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zJ;
        f.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f12055f) {
            try {
                f0 f0Var = (f0) this.f12055f.get(d0Var);
                if (f0Var == null) {
                    f0Var = new f0(this, d0Var);
                    f0Var.d(serviceConnection, serviceConnection, str);
                    f0Var.e(str, executor);
                    this.f12055f.put(d0Var, f0Var);
                } else {
                    this.f12057h.removeMessages(0, d0Var);
                    if (f0Var.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + d0Var.toString());
                    }
                    f0Var.d(serviceConnection, serviceConnection, str);
                    int iA = f0Var.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(f0Var.b(), f0Var.c());
                    } else if (iA == 2) {
                        f0Var.e(str, executor);
                    }
                }
                zJ = f0Var.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zJ;
    }
}
