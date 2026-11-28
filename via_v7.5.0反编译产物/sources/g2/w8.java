package g2;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzq;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5407c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5408e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzq f5410n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f5411o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d9 f5412p;

    public w8(d9 d9Var, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar, boolean z10) {
        this.f5412p = d9Var;
        this.f5407c = atomicReference;
        this.f5408e = str2;
        this.f5409m = str3;
        this.f5410n = zzqVar;
        this.f5411o = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f5407c) {
            try {
                try {
                    d9 d9Var = this.f5412p;
                    l3 l3Var = d9Var.f4714d;
                    if (l3Var == null) {
                        d9Var.f4646a.d().r().d("(legacy) Failed to get user properties; not connected to service", null, this.f5408e, this.f5409m);
                        this.f5407c.set(Collections.EMPTY_LIST);
                        this.f5407c.notify();
                        return;
                    }
                    if (TextUtils.isEmpty(null)) {
                        u1.f.h(this.f5410n);
                        this.f5407c.set(l3Var.P(this.f5408e, this.f5409m, this.f5411o, this.f5410n));
                    } else {
                        this.f5407c.set(l3Var.j(null, this.f5408e, this.f5409m, this.f5411o));
                    }
                    this.f5412p.E();
                    atomicReference = this.f5407c;
                    atomicReference.notify();
                } catch (RemoteException e10) {
                    this.f5412p.f4646a.d().r().d("(legacy) Failed to get user properties; remote exception", null, this.f5408e, e10);
                    this.f5407c.set(Collections.EMPTY_LIST);
                    atomicReference = this.f5407c;
                }
            } catch (Throwable th) {
                this.f5407c.notify();
                throw th;
            }
        }
    }
}
