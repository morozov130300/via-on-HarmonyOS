package g2;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzq;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5349c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5350e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5351m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzq f5352n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d9 f5353o;

    public u8(d9 d9Var, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar) {
        this.f5353o = d9Var;
        this.f5349c = atomicReference;
        this.f5350e = str2;
        this.f5351m = str3;
        this.f5352n = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f5349c) {
            try {
                try {
                    d9 d9Var = this.f5353o;
                    l3 l3Var = d9Var.f4714d;
                    if (l3Var == null) {
                        d9Var.f4646a.d().r().d("(legacy) Failed to get conditional properties; not connected to service", null, this.f5350e, this.f5351m);
                        this.f5349c.set(Collections.EMPTY_LIST);
                        this.f5349c.notify();
                        return;
                    }
                    if (TextUtils.isEmpty(null)) {
                        u1.f.h(this.f5352n);
                        this.f5349c.set(l3Var.D(this.f5350e, this.f5351m, this.f5352n));
                    } else {
                        this.f5349c.set(l3Var.q(null, this.f5350e, this.f5351m));
                    }
                    this.f5353o.E();
                    atomicReference = this.f5349c;
                    atomicReference.notify();
                } catch (RemoteException e10) {
                    this.f5353o.f4646a.d().r().d("(legacy) Failed to get conditional properties; remote exception", null, this.f5350e, e10);
                    this.f5349c.set(Collections.EMPTY_LIST);
                    atomicReference = this.f5349c;
                }
            } catch (Throwable th) {
                this.f5349c.notify();
                throw th;
            }
        }
    }
}
