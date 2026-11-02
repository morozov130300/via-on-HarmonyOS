package f2;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzq;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5733e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5734j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5735k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ zzq f5736l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d9 f5737m;

    public u8(d9 d9Var, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar) {
        this.f5737m = d9Var;
        this.f5733e = atomicReference;
        this.f5734j = str2;
        this.f5735k = str3;
        this.f5736l = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        d9 d9Var;
        l3 l3Var;
        synchronized (this.f5733e) {
            try {
                try {
                    d9Var = this.f5737m;
                    l3Var = d9Var.f5098d;
                } catch (RemoteException e10) {
                    this.f5737m.f5030a.d().r().d("(legacy) Failed to get conditional properties; remote exception", null, this.f5734j, e10);
                    this.f5733e.set(Collections.EMPTY_LIST);
                    atomicReference = this.f5733e;
                }
                if (l3Var == null) {
                    d9Var.f5030a.d().r().d("(legacy) Failed to get conditional properties; not connected to service", null, this.f5734j, this.f5735k);
                    this.f5733e.set(Collections.EMPTY_LIST);
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    t1.f.h(this.f5736l);
                    this.f5733e.set(l3Var.E(this.f5734j, this.f5735k, this.f5736l));
                } else {
                    this.f5733e.set(l3Var.q(null, this.f5734j, this.f5735k));
                }
                this.f5737m.E();
                atomicReference = this.f5733e;
                atomicReference.notify();
            } finally {
                this.f5733e.notify();
            }
        }
    }
}
