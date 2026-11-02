package f2;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzq;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w8 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5791e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5792j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5793k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ zzq f5794l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f5795m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d9 f5796n;

    public w8(d9 d9Var, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar, boolean z10) {
        this.f5796n = d9Var;
        this.f5791e = atomicReference;
        this.f5792j = str2;
        this.f5793k = str3;
        this.f5794l = zzqVar;
        this.f5795m = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        d9 d9Var;
        l3 l3Var;
        synchronized (this.f5791e) {
            try {
                try {
                    d9Var = this.f5796n;
                    l3Var = d9Var.f5098d;
                } catch (RemoteException e10) {
                    this.f5796n.f5030a.d().r().d("(legacy) Failed to get user properties; remote exception", null, this.f5792j, e10);
                    this.f5791e.set(Collections.EMPTY_LIST);
                    atomicReference = this.f5791e;
                }
                if (l3Var == null) {
                    d9Var.f5030a.d().r().d("(legacy) Failed to get user properties; not connected to service", null, this.f5792j, this.f5793k);
                    this.f5791e.set(Collections.EMPTY_LIST);
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    t1.f.h(this.f5794l);
                    this.f5791e.set(l3Var.Q(this.f5792j, this.f5793k, this.f5795m, this.f5794l));
                } else {
                    this.f5791e.set(l3Var.j(null, this.f5792j, this.f5793k, this.f5795m));
                }
                this.f5796n.E();
                atomicReference = this.f5791e;
                atomicReference.notify();
            } finally {
                this.f5791e.notify();
            }
        }
    }
}
