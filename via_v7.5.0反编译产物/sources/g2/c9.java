package g2;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c9 implements ServiceConnection, u1.a.InterfaceC0128a, u1.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f4689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile r3 f4690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d9 f4691c;

    public c9(d9 d9Var) {
        this.f4691c = d9Var;
    }

    @Override // u1.a.InterfaceC0128a
    public final void a(int i10) {
        u1.f.c("MeasurementServiceConnection.onConnectionSuspended");
        this.f4691c.f4646a.d().q().a("Service connection suspended");
        this.f4691c.f4646a.f().z(new a9(this));
    }

    @Override // u1.a.b
    public final void b(ConnectionResult connectionResult) {
        u1.f.c("MeasurementServiceConnection.onConnectionFailed");
        v3 v3VarE = this.f4691c.f4646a.E();
        if (v3VarE != null) {
            v3VarE.w().b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f4689a = false;
            this.f4690b = null;
        }
        this.f4691c.f4646a.f().z(new b9(this));
    }

    @Override // u1.a.InterfaceC0128a
    public final void c(Bundle bundle) {
        u1.f.c("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                u1.f.h(this.f4690b);
                this.f4691c.f4646a.f().z(new z8(this, (l3) this.f4690b.q()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f4690b = null;
                this.f4689a = false;
            }
        }
    }

    public final void e(Intent intent) {
        this.f4691c.h();
        Context contextC = this.f4691c.f4646a.c();
        w1.b bVarB = w1.b.b();
        synchronized (this) {
            try {
                if (this.f4689a) {
                    this.f4691c.f4646a.d().v().a("Connection attempt already in progress");
                    return;
                }
                this.f4691c.f4646a.d().v().a("Using local app measurement service");
                this.f4689a = true;
                bVarB.a(contextC, intent, this.f4691c.f4713c, 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        this.f4691c.h();
        Context contextC = this.f4691c.f4646a.c();
        synchronized (this) {
            try {
                if (this.f4689a) {
                    this.f4691c.f4646a.d().v().a("Connection attempt already in progress");
                    return;
                }
                if (this.f4690b != null && (this.f4690b.w() || this.f4690b.v())) {
                    this.f4691c.f4646a.d().v().a("Already awaiting connection attempt");
                    return;
                }
                this.f4690b = new r3(contextC, Looper.getMainLooper(), this, this);
                this.f4691c.f4646a.d().v().a("Connecting to remote service");
                this.f4689a = true;
                u1.f.h(this.f4690b);
                this.f4690b.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        if (this.f4690b != null && (this.f4690b.v() || this.f4690b.w())) {
            this.f4690b.e();
        }
        this.f4690b = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        u1.f.c("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f4689a = false;
                this.f4691c.f4646a.d().r().a("Service connected with null binder");
                return;
            }
            l3 j3Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    j3Var = iInterfaceQueryLocalInterface instanceof l3 ? (l3) iInterfaceQueryLocalInterface : new j3(iBinder);
                    this.f4691c.f4646a.d().v().a("Bound to IMeasurementService interface");
                } else {
                    this.f4691c.f4646a.d().r().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f4691c.f4646a.d().r().a("Service connect failed to get IMeasurementService");
            }
            if (j3Var == null) {
                this.f4689a = false;
                try {
                    w1.b.b().c(this.f4691c.f4646a.c(), this.f4691c.f4713c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f4691c.f4646a.f().z(new x8(this, j3Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        u1.f.c("MeasurementServiceConnection.onServiceDisconnected");
        this.f4691c.f4646a.d().q().a("Service disconnected");
        this.f4691c.f4646a.f().z(new y8(this, componentName));
    }
}
