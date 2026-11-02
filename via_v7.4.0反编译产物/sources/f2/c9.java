package f2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import t1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c9 implements ServiceConnection, a.InterfaceC0122a, a.b {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f5073a;

    /* renamed from: b, reason: collision with root package name */
    public volatile r3 f5074b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d9 f5075c;

    public c9(d9 d9Var) {
        this.f5075c = d9Var;
    }

    @Override // t1.a.InterfaceC0122a
    public final void a(int i10) {
        t1.f.c("MeasurementServiceConnection.onConnectionSuspended");
        this.f5075c.f5030a.d().q().a("Service connection suspended");
        this.f5075c.f5030a.f().z(new a9(this));
    }

    @Override // t1.a.b
    public final void b(ConnectionResult connectionResult) {
        t1.f.c("MeasurementServiceConnection.onConnectionFailed");
        v3 v3VarE = this.f5075c.f5030a.E();
        if (v3VarE != null) {
            v3VarE.w().b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f5073a = false;
            this.f5074b = null;
        }
        this.f5075c.f5030a.f().z(new b9(this));
    }

    @Override // t1.a.InterfaceC0122a
    public final void c(Bundle bundle) {
        t1.f.c("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                t1.f.h(this.f5074b);
                this.f5075c.f5030a.f().z(new z8(this, (l3) this.f5074b.q()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f5074b = null;
                this.f5073a = false;
            }
        }
    }

    public final void e(Intent intent) {
        this.f5075c.h();
        Context contextC = this.f5075c.f5030a.c();
        v1.b bVarB = v1.b.b();
        synchronized (this) {
            try {
                if (this.f5073a) {
                    this.f5075c.f5030a.d().v().a("Connection attempt already in progress");
                    return;
                }
                this.f5075c.f5030a.d().v().a("Using local app measurement service");
                this.f5073a = true;
                bVarB.a(contextC, intent, this.f5075c.f5097c, 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        this.f5075c.h();
        Context contextC = this.f5075c.f5030a.c();
        synchronized (this) {
            try {
                if (this.f5073a) {
                    this.f5075c.f5030a.d().v().a("Connection attempt already in progress");
                    return;
                }
                if (this.f5074b != null && (this.f5074b.w() || this.f5074b.v())) {
                    this.f5075c.f5030a.d().v().a("Already awaiting connection attempt");
                    return;
                }
                this.f5074b = new r3(contextC, Looper.getMainLooper(), this, this);
                this.f5075c.f5030a.d().v().a("Connecting to remote service");
                this.f5073a = true;
                t1.f.h(this.f5074b);
                this.f5074b.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        if (this.f5074b != null && (this.f5074b.v() || this.f5074b.w())) {
            this.f5074b.e();
        }
        this.f5074b = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        t1.f.c("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f5073a = false;
                this.f5075c.f5030a.d().r().a("Service connected with null binder");
                return;
            }
            l3 j3Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    j3Var = iInterfaceQueryLocalInterface instanceof l3 ? (l3) iInterfaceQueryLocalInterface : new j3(iBinder);
                    this.f5075c.f5030a.d().v().a("Bound to IMeasurementService interface");
                } else {
                    this.f5075c.f5030a.d().r().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f5075c.f5030a.d().r().a("Service connect failed to get IMeasurementService");
            }
            if (j3Var == null) {
                this.f5073a = false;
                try {
                    v1.b.b().c(this.f5075c.f5030a.c(), this.f5075c.f5097c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f5075c.f5030a.f().z(new x8(this, j3Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        t1.f.c("MeasurementServiceConnection.onServiceDisconnected");
        this.f5075c.f5030a.d().q().a("Service disconnected");
        this.f5075c.f5030a.f().z(new y8(this, componentName));
    }
}
