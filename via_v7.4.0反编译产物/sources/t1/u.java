package t1;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u extends j {

    /* renamed from: d, reason: collision with root package name */
    public a f12075d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12076e;

    public u(a aVar, int i10) {
        this.f12075d = aVar;
        this.f12076e = i10;
    }

    @Override // t1.c
    public final void F(int i10, IBinder iBinder, Bundle bundle) {
        f.i(this.f12075d, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f12075d.A(i10, iBinder, bundle, this.f12076e);
        this.f12075d = null;
    }

    @Override // t1.c
    public final void J(int i10, IBinder iBinder, zzj zzjVar) {
        a aVar = this.f12075d;
        f.i(aVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        f.h(zzjVar);
        a.P(aVar, zzjVar);
        F(i10, iBinder, zzjVar.f3331e);
    }

    @Override // t1.c
    public final void s(int i10, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
