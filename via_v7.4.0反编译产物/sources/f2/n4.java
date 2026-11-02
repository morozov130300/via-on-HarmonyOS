package f2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n4 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final String f5521a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o4 f5522b;

    public n4(o4 o4Var, String str) {
        this.f5522b = o4Var;
        this.f5521a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f5522b.f5544a.d().w().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.t0 t0VarZ = com.google.android.gms.internal.measurement.s0.Z(iBinder);
            if (t0VarZ == null) {
                this.f5522b.f5544a.d().w().a("Install Referrer Service implementation was not found");
            } else {
                this.f5522b.f5544a.d().v().a("Install Referrer Service connected");
                this.f5522b.f5544a.f().z(new m4(this, t0VarZ, this));
            }
        } catch (RuntimeException e10) {
            this.f5522b.f5544a.d().w().b("Exception occurred while calling Install Referrer API", e10);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5522b.f5544a.d().v().a("Install Referrer Service disconnected");
    }
}
