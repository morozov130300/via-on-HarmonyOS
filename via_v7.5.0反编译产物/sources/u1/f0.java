package u1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements ServiceConnection, j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f12772a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12773b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f12775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d0 f12776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f12777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i0 f12778g;

    public f0(i0 i0Var, d0 d0Var) {
        this.f12778g = i0Var;
        this.f12776e = d0Var;
    }

    public final int a() {
        return this.f12773b;
    }

    public final ComponentName b() {
        return this.f12777f;
    }

    public final IBinder c() {
        return this.f12775d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f12772a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) throws Throwable {
        this.f12773b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (x1.j.j()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            i0 i0Var = this.f12778g;
            try {
                boolean zD = i0Var.f12792j.d(i0Var.f12789g, str, this.f12776e.c(i0Var.f12789g), this, this.f12776e.a(), executor);
                this.f12774c = zD;
                if (zD) {
                    this.f12778g.f12790h.sendMessageDelayed(this.f12778g.f12790h.obtainMessage(1, this.f12776e), this.f12778g.f12794l);
                } else {
                    this.f12773b = 2;
                    try {
                        i0 i0Var2 = this.f12778g;
                        i0Var2.f12792j.c(i0Var2.f12789g, this);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                StrictMode.setVmPolicy(vmPolicy);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                StrictMode.setVmPolicy(vmPolicy);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f12772a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f12778g.f12790h.removeMessages(1, this.f12776e);
        i0 i0Var = this.f12778g;
        i0Var.f12792j.c(i0Var.f12789g, this);
        this.f12774c = false;
        this.f12773b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f12772a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f12772a.isEmpty();
    }

    public final boolean j() {
        return this.f12774c;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f12778g.f12788f) {
            try {
                this.f12778g.f12790h.removeMessages(1, this.f12776e);
                this.f12775d = iBinder;
                this.f12777f = componentName;
                Iterator it = this.f12772a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f12773b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f12778g.f12788f) {
            try {
                this.f12778g.f12790h.removeMessages(1, this.f12776e);
                this.f12775d = null;
                this.f12777f = componentName;
                Iterator it = this.f12772a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f12773b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
