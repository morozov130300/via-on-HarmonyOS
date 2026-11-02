package t1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f0 implements ServiceConnection, j0 {

    /* renamed from: a, reason: collision with root package name */
    public final Map f12039a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f12040b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12041c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f12042d;

    /* renamed from: e, reason: collision with root package name */
    public final d0 f12043e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f12044f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i0 f12045g;

    public f0(i0 i0Var, d0 d0Var) {
        this.f12045g = i0Var;
        this.f12043e = d0Var;
    }

    public final int a() {
        return this.f12040b;
    }

    public final ComponentName b() {
        return this.f12044f;
    }

    public final IBinder c() {
        return this.f12042d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f12039a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) throws Throwable {
        i0 i0Var;
        this.f12040b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (w1.j.j()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            i0Var = this.f12045g;
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zD = i0Var.f12059j.d(i0Var.f12056g, str, this.f12043e.c(i0Var.f12056g), this, this.f12043e.a(), executor);
            this.f12041c = zD;
            if (zD) {
                this.f12045g.f12057h.sendMessageDelayed(this.f12045g.f12057h.obtainMessage(1, this.f12043e), this.f12045g.f12061l);
            } else {
                this.f12040b = 2;
                try {
                    i0 i0Var2 = this.f12045g;
                    i0Var2.f12059j.c(i0Var2.f12056g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            StrictMode.setVmPolicy(vmPolicy);
            throw th3;
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f12039a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f12045g.f12057h.removeMessages(1, this.f12043e);
        i0 i0Var = this.f12045g;
        i0Var.f12059j.c(i0Var.f12056g, this);
        this.f12041c = false;
        this.f12040b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f12039a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f12039a.isEmpty();
    }

    public final boolean j() {
        return this.f12041c;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f12045g.f12055f) {
            try {
                this.f12045g.f12057h.removeMessages(1, this.f12043e);
                this.f12042d = iBinder;
                this.f12044f = componentName;
                Iterator it = this.f12039a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f12040b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f12045g.f12055f) {
            try {
                this.f12045g.f12057h.removeMessages(1, this.f12043e);
                this.f12042d = null;
                this.f12044f = componentName;
                Iterator it = this.f12039a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f12040b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
