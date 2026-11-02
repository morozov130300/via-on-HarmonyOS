package t1;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.zzj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public boolean A;
    public volatile zzj B;
    public AtomicInteger C;

    /* renamed from: a, reason: collision with root package name */
    public int f11999a;

    /* renamed from: b, reason: collision with root package name */
    public long f12000b;

    /* renamed from: c, reason: collision with root package name */
    public long f12001c;

    /* renamed from: d, reason: collision with root package name */
    public int f12002d;

    /* renamed from: e, reason: collision with root package name */
    public long f12003e;

    /* renamed from: f, reason: collision with root package name */
    public volatile String f12004f;

    /* renamed from: g, reason: collision with root package name */
    public k0 f12005g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f12006h;

    /* renamed from: i, reason: collision with root package name */
    public final Looper f12007i;

    /* renamed from: j, reason: collision with root package name */
    public final t1.b f12008j;

    /* renamed from: k, reason: collision with root package name */
    public final q1.b f12009k;

    /* renamed from: l, reason: collision with root package name */
    public final Handler f12010l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f12011m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f12012n;

    /* renamed from: o, reason: collision with root package name */
    public t1.d f12013o;

    /* renamed from: p, reason: collision with root package name */
    public c f12014p;

    /* renamed from: q, reason: collision with root package name */
    public IInterface f12015q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f12016r;

    /* renamed from: s, reason: collision with root package name */
    public v f12017s;

    /* renamed from: t, reason: collision with root package name */
    public int f12018t;

    /* renamed from: u, reason: collision with root package name */
    public final InterfaceC0122a f12019u;

    /* renamed from: v, reason: collision with root package name */
    public final b f12020v;

    /* renamed from: w, reason: collision with root package name */
    public final int f12021w;

    /* renamed from: x, reason: collision with root package name */
    public final String f12022x;

    /* renamed from: y, reason: collision with root package name */
    public volatile String f12023y;

    /* renamed from: z, reason: collision with root package name */
    public ConnectionResult f12024z;
    public static final Feature[] E = new Feature[0];
    public static final String[] D = {"service_esmobile", "service_googleme"};

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: t1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0122a {
        void a(int i10);

        void c(Bundle bundle);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void b(ConnectionResult connectionResult);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void a(ConnectionResult connectionResult);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d implements c {
        public d() {
        }

        @Override // t1.a.c
        public final void a(ConnectionResult connectionResult) {
            if (connectionResult.h()) {
                a aVar = a.this;
                aVar.o(null, aVar.p());
            } else if (a.this.f12020v != null) {
                a.this.f12020v.b(connectionResult);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(Context context, Looper looper, int i10, InterfaceC0122a interfaceC0122a, b bVar, String str) {
        t1.b bVarB = t1.b.b(context);
        q1.b bVarB2 = q1.b.b();
        f.h(interfaceC0122a);
        f.h(bVar);
        this(context, looper, bVarB, bVarB2, i10, interfaceC0122a, bVar, str);
    }

    public a(Context context, Looper looper, t1.b bVar, q1.b bVar2, int i10, InterfaceC0122a interfaceC0122a, b bVar3, String str) {
        this.f12004f = null;
        this.f12011m = new Object();
        this.f12012n = new Object();
        this.f12016r = new ArrayList();
        this.f12018t = 1;
        this.f12024z = null;
        this.A = false;
        this.B = null;
        this.C = new AtomicInteger(0);
        f.i(context, "Context must not be null");
        this.f12006h = context;
        f.i(looper, "Looper must not be null");
        this.f12007i = looper;
        f.i(bVar, "Supervisor must not be null");
        this.f12008j = bVar;
        f.i(bVar2, "API availability must not be null");
        this.f12009k = bVar2;
        this.f12010l = new s(this, looper);
        this.f12021w = i10;
        this.f12019u = interfaceC0122a;
        this.f12020v = bVar3;
        this.f12022x = str;
    }

    public static /* bridge */ /* synthetic */ void P(a aVar, zzj zzjVar) {
        aVar.B = zzjVar;
        if (aVar.F()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.f3334l;
            g.a().b(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.n());
        }
    }

    public static /* bridge */ /* synthetic */ void Q(a aVar, int i10) {
        int i11;
        int i12;
        synchronized (aVar.f12011m) {
            i11 = aVar.f12018t;
        }
        if (i11 == 3) {
            aVar.A = true;
            i12 = 5;
        } else {
            i12 = 4;
        }
        Handler handler = aVar.f12010l;
        handler.sendMessage(handler.obtainMessage(i12, aVar.C.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean T(a aVar, int i10, int i11, IInterface iInterface) {
        synchronized (aVar.f12011m) {
            try {
                if (aVar.f12018t != i10) {
                    return false;
                }
                aVar.V(i11, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean U(a aVar) throws ClassNotFoundException {
        if (aVar.A || TextUtils.isEmpty(aVar.r()) || TextUtils.isEmpty(aVar.m())) {
            return false;
        }
        try {
            Class.forName(aVar.r());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void A(int i10, IBinder iBinder, Bundle bundle, int i11) {
        Handler handler = this.f12010l;
        handler.sendMessage(handler.obtainMessage(1, i11, -1, new w(this, i10, iBinder, bundle)));
    }

    public boolean B() {
        return false;
    }

    public boolean C() {
        return false;
    }

    public void D(int i10) {
        Handler handler = this.f12010l;
        handler.sendMessage(handler.obtainMessage(6, this.C.get(), i10));
    }

    public void E(c cVar, int i10, PendingIntent pendingIntent) {
        f.i(cVar, "Connection progress callbacks cannot be null.");
        this.f12014p = cVar;
        Handler handler = this.f12010l;
        handler.sendMessage(handler.obtainMessage(3, this.C.get(), i10, pendingIntent));
    }

    public boolean F() {
        return false;
    }

    public final String K() {
        String str = this.f12022x;
        return str == null ? this.f12006h.getClass().getName() : str;
    }

    public final void R(int i10, Bundle bundle, int i11) {
        Handler handler = this.f12010l;
        handler.sendMessage(handler.obtainMessage(7, i11, -1, new x(this, i10, null)));
    }

    public final void V(int i10, IInterface iInterface) {
        k0 k0Var;
        f.a((i10 == 4) == (iInterface != null));
        synchronized (this.f12011m) {
            try {
                this.f12018t = i10;
                this.f12015q = iInterface;
                if (i10 == 1) {
                    v vVar = this.f12017s;
                    if (vVar != null) {
                        t1.b bVar = this.f12008j;
                        String strC = this.f12005g.c();
                        f.h(strC);
                        bVar.e(strC, this.f12005g.b(), this.f12005g.a(), vVar, K(), this.f12005g.d());
                        this.f12017s = null;
                    }
                } else if (i10 == 2 || i10 == 3) {
                    v vVar2 = this.f12017s;
                    if (vVar2 != null && (k0Var = this.f12005g) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + k0Var.c() + " on " + k0Var.b());
                        t1.b bVar2 = this.f12008j;
                        String strC2 = this.f12005g.c();
                        f.h(strC2);
                        bVar2.e(strC2, this.f12005g.b(), this.f12005g.a(), vVar2, K(), this.f12005g.d());
                        this.C.incrementAndGet();
                    }
                    v vVar3 = new v(this, this.C.get());
                    this.f12017s = vVar3;
                    k0 k0Var2 = (this.f12018t != 3 || m() == null) ? new k0(t(), s(), false, t1.b.a(), u()) : new k0(k().getPackageName(), m(), true, t1.b.a(), false);
                    this.f12005g = k0Var2;
                    if (k0Var2.d() && n() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f12005g.c())));
                    }
                    t1.b bVar3 = this.f12008j;
                    String strC3 = this.f12005g.c();
                    f.h(strC3);
                    if (!bVar3.f(new d0(strC3, this.f12005g.b(), this.f12005g.a(), this.f12005g.d()), vVar3, K(), i())) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f12005g.c() + " on " + this.f12005g.b());
                        R(16, null, this.C.get());
                    }
                } else if (i10 == 4) {
                    f.h(iInterface);
                    x(iInterface);
                }
            } finally {
            }
        }
    }

    public void a() throws PackageManager.NameNotFoundException {
        int iC = this.f12009k.c(this.f12006h, n());
        if (iC == 0) {
            c(new d());
        } else {
            V(1, null);
            E(new d(), iC, null);
        }
    }

    public final void b() {
        if (!v()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void c(c cVar) {
        f.i(cVar, "Connection progress callbacks cannot be null.");
        this.f12014p = cVar;
        V(2, null);
    }

    public abstract IInterface d(IBinder iBinder);

    public void e() {
        this.C.incrementAndGet();
        synchronized (this.f12016r) {
            try {
                int size = this.f12016r.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((t) this.f12016r.get(i10)).d();
                }
                this.f12016r.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f12012n) {
            this.f12013o = null;
        }
        V(1, null);
    }

    public boolean f() {
        return false;
    }

    public Account g() {
        return null;
    }

    public Feature[] h() {
        return E;
    }

    public Executor i() {
        return null;
    }

    public Bundle j() {
        return null;
    }

    public final Context k() {
        return this.f12006h;
    }

    public Bundle l() {
        return new Bundle();
    }

    public String m() {
        return null;
    }

    public abstract int n();

    public void o(com.google.android.gms.common.internal.b bVar, Set set) {
        Bundle bundleL = l();
        int i10 = this.f12021w;
        String str = this.f12023y;
        int i11 = q1.b.f11237a;
        Scope[] scopeArr = GetServiceRequest.f3309w;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f3310x;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i10, i11, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f3314l = this.f12006h.getPackageName();
        getServiceRequest.f3317o = bundleL;
        if (set != null) {
            getServiceRequest.f3316n = (Scope[]) set.toArray(new Scope[0]);
        }
        if (C()) {
            Account accountG = g();
            if (accountG == null) {
                accountG = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.f3318p = accountG;
            if (bVar != null) {
                getServiceRequest.f3315m = bVar.asBinder();
            }
        } else if (B()) {
            getServiceRequest.f3318p = g();
        }
        getServiceRequest.f3319q = E;
        getServiceRequest.f3320r = h();
        if (F()) {
            getServiceRequest.f3323u = true;
        }
        try {
            synchronized (this.f12012n) {
                try {
                    t1.d dVar = this.f12013o;
                    if (dVar != null) {
                        dVar.t(new u(this, this.C.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e10) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e10);
            D(3);
        } catch (RemoteException e11) {
            e = e11;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            A(8, null, null, this.C.get());
        } catch (SecurityException e12) {
            throw e12;
        } catch (RuntimeException e13) {
            e = e13;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            A(8, null, null, this.C.get());
        }
    }

    public Set p() {
        return Collections.EMPTY_SET;
    }

    public final IInterface q() {
        IInterface iInterface;
        synchronized (this.f12011m) {
            try {
                if (this.f12018t == 5) {
                    throw new DeadObjectException();
                }
                b();
                iInterface = this.f12015q;
                f.i(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String r();

    public abstract String s();

    public String t() {
        return "com.google.android.gms";
    }

    public boolean u() {
        return n() >= 211700000;
    }

    public boolean v() {
        boolean z10;
        synchronized (this.f12011m) {
            z10 = this.f12018t == 4;
        }
        return z10;
    }

    public boolean w() {
        boolean z10;
        synchronized (this.f12011m) {
            int i10 = this.f12018t;
            z10 = true;
            if (i10 != 2 && i10 != 3) {
                z10 = false;
            }
        }
        return z10;
    }

    public void x(IInterface iInterface) {
        this.f12001c = System.currentTimeMillis();
    }

    public void y(ConnectionResult connectionResult) {
        this.f12002d = connectionResult.c();
        this.f12003e = System.currentTimeMillis();
    }

    public void z(int i10) {
        this.f11999a = i10;
        this.f12000b = System.currentTimeMillis();
    }
}
