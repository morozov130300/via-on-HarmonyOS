package f2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d9 extends c4 {

    /* renamed from: c, reason: collision with root package name */
    public final c9 f5097c;

    /* renamed from: d, reason: collision with root package name */
    public l3 f5098d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Boolean f5099e;

    /* renamed from: f, reason: collision with root package name */
    public final n f5100f;

    /* renamed from: g, reason: collision with root package name */
    public final v9 f5101g;

    /* renamed from: h, reason: collision with root package name */
    public final List f5102h;

    /* renamed from: i, reason: collision with root package name */
    public final n f5103i;

    public d9(h5 h5Var) {
        super(h5Var);
        this.f5102h = new ArrayList();
        this.f5101g = new v9(h5Var.a());
        this.f5097c = new c9(this);
        this.f5100f = new n8(this, h5Var);
        this.f5103i = new p8(this, h5Var);
    }

    public static /* bridge */ /* synthetic */ void M(d9 d9Var, ComponentName componentName) {
        d9Var.h();
        if (d9Var.f5098d != null) {
            d9Var.f5098d = null;
            d9Var.f5030a.d().v().b("Disconnected from device MeasurementService", componentName);
            d9Var.h();
            d9Var.P();
        }
    }

    public final boolean A() {
        h();
        i();
        return !B() || this.f5030a.N().q0() >= ((Integer) i3.f5314j0.a(null)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean B() {
        h();
        i();
        if (this.f5099e == null) {
            h();
            i();
            l4 l4VarF = this.f5030a.F();
            l4VarF.h();
            boolean z10 = false;
            Boolean boolValueOf = !l4VarF.o().contains("use_service") ? null : Boolean.valueOf(l4VarF.o().getBoolean("use_service", false));
            if (boolValueOf == null || !boolValueOf.booleanValue()) {
                this.f5030a.b();
                if (this.f5030a.B().o() == 1) {
                    z10 = true;
                    if (!z10 && this.f5030a.z().G()) {
                        this.f5030a.d().r().a("No way to upload. Consider using the full version of Analytics");
                    } else if (z) {
                        l4 l4VarF2 = this.f5030a.F();
                        l4VarF2.h();
                        SharedPreferences.Editor editorEdit = l4VarF2.o().edit();
                        editorEdit.putBoolean("use_service", z10);
                        editorEdit.apply();
                    }
                    z = z10;
                } else {
                    this.f5030a.d().v().a("Checking service availability");
                    int iR0 = this.f5030a.N().r0(12451000);
                    if (iR0 != 0) {
                        if (iR0 != 1) {
                            if (iR0 == 2) {
                                this.f5030a.d().q().a("Service container out of date");
                                if (this.f5030a.N().q0() >= 17443) {
                                    z10 = boolValueOf == null;
                                }
                            } else if (iR0 == 3) {
                                this.f5030a.d().w().a("Service disabled");
                            } else if (iR0 == 9) {
                                this.f5030a.d().w().a("Service invalid");
                            } else if (iR0 != 18) {
                                this.f5030a.d().w().b("Unexpected service status", Integer.valueOf(iR0));
                            } else {
                                this.f5030a.d().w().a("Service updating");
                            }
                            z = false;
                        } else {
                            this.f5030a.d().v().a("Service missing");
                        }
                        if (!z10) {
                            if (z) {
                            }
                            z = z10;
                        }
                    } else {
                        this.f5030a.d().v().a("Service available");
                    }
                    z10 = true;
                    if (!z10) {
                    }
                }
            }
            this.f5099e = Boolean.valueOf(z);
        }
        return this.f5099e.booleanValue();
    }

    public final zzq C(boolean z10) {
        Pair pairA;
        this.f5030a.b();
        m3 m3VarB = this.f5030a.B();
        String str = null;
        if (z10) {
            v3 v3VarD = this.f5030a.d();
            if (v3VarD.f5030a.F().f5430d != null && (pairA = v3VarD.f5030a.F().f5430d.a()) != null && pairA != l4.f5428y) {
                str = String.valueOf(pairA.second) + ":" + ((String) pairA.first);
            }
        }
        return m3VarB.q(str);
    }

    public final void D() {
        h();
        this.f5030a.d().v().b("Processing queued up service tasks", Integer.valueOf(this.f5102h.size()));
        Iterator it = this.f5102h.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e10) {
                this.f5030a.d().r().b("Task exception while flushing queue", e10);
            }
        }
        this.f5102h.clear();
        this.f5103i.b();
    }

    public final void E() {
        h();
        this.f5101g.b();
        n nVar = this.f5100f;
        this.f5030a.z();
        nVar.d(((Long) i3.L.a(null)).longValue());
    }

    public final void F(Runnable runnable) {
        h();
        if (z()) {
            runnable.run();
            return;
        }
        long size = this.f5102h.size();
        this.f5030a.z();
        if (size >= 1000) {
            this.f5030a.d().r().a("Discarding data. Max runnable queue size reached");
            return;
        }
        this.f5102h.add(runnable);
        this.f5103i.d(60000L);
        P();
    }

    public final boolean G() {
        this.f5030a.b();
        return true;
    }

    public final Boolean J() {
        return this.f5099e;
    }

    public final void O() {
        h();
        i();
        zzq zzqVarC = C(true);
        this.f5030a.C().r();
        F(new k8(this, zzqVarC));
    }

    public final void P() {
        h();
        i();
        if (z()) {
            return;
        }
        if (B()) {
            this.f5097c.f();
            return;
        }
        if (this.f5030a.z().G()) {
            return;
        }
        this.f5030a.b();
        List<ResolveInfo> listQueryIntentServices = this.f5030a.c().getPackageManager().queryIntentServices(new Intent().setClassName(this.f5030a.c(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.f5030a.d().r().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextC = this.f5030a.c();
        this.f5030a.b();
        intent.setComponent(new ComponentName(contextC, "com.google.android.gms.measurement.AppMeasurementService"));
        this.f5097c.e(intent);
    }

    public final void Q() {
        h();
        i();
        this.f5097c.g();
        try {
            v1.b.b().c(this.f5030a.c(), this.f5097c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f5098d = null;
    }

    public final void R(com.google.android.gms.internal.measurement.k1 k1Var) {
        h();
        i();
        F(new j8(this, C(false), k1Var));
    }

    public final void S(AtomicReference atomicReference) {
        h();
        i();
        F(new i8(this, atomicReference, C(false)));
    }

    public final void T(com.google.android.gms.internal.measurement.k1 k1Var, String str, String str2) {
        h();
        i();
        F(new v8(this, str, str2, C(false), k1Var));
    }

    public final void U(AtomicReference atomicReference, String str, String str2, String str3) {
        h();
        i();
        F(new u8(this, atomicReference, null, str2, str3, C(false)));
    }

    public final void V(com.google.android.gms.internal.measurement.k1 k1Var, String str, String str2, boolean z10) {
        h();
        i();
        F(new f8(this, str, str2, C(false), z10, k1Var));
    }

    public final void W(AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        h();
        i();
        F(new w8(this, atomicReference, null, str2, str3, C(false), z10));
    }

    @Override // f2.c4
    public final boolean n() {
        return false;
    }

    public final void o(zzau zzauVar, String str) {
        t1.f.h(zzauVar);
        h();
        i();
        G();
        F(new s8(this, true, C(true), this.f5030a.C().v(zzauVar), zzauVar, str));
    }

    public final void p(com.google.android.gms.internal.measurement.k1 k1Var, zzau zzauVar, String str) {
        h();
        i();
        if (this.f5030a.N().r0(12451000) == 0) {
            F(new o8(this, zzauVar, str, k1Var));
        } else {
            this.f5030a.d().w().a("Not bundling data. Service unavailable or out of date");
            this.f5030a.N().H(k1Var, new byte[0]);
        }
    }

    public final void q() {
        h();
        i();
        zzq zzqVarC = C(false);
        G();
        this.f5030a.C().q();
        F(new h8(this, zzqVarC));
    }

    public final void r(l3 l3Var, AbstractSafeParcelable abstractSafeParcelable, zzq zzqVar) {
        int size;
        h();
        i();
        G();
        this.f5030a.z();
        int i10 = 0;
        int i11 = 100;
        while (i10 < 1001 && i11 == 100) {
            ArrayList arrayList = new ArrayList();
            List listP = this.f5030a.C().p(100);
            if (listP != null) {
                arrayList.addAll(listP);
                size = listP.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            for (int i12 = 0; i12 < size2; i12++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i12);
                if (abstractSafeParcelable2 instanceof zzau) {
                    try {
                        l3Var.p((zzau) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e10) {
                        this.f5030a.d().r().b("Failed to send event to the service", e10);
                    }
                } else if (abstractSafeParcelable2 instanceof zzlk) {
                    try {
                        l3Var.W((zzlk) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e11) {
                        this.f5030a.d().r().b("Failed to send user property to the service", e11);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        l3Var.T((zzac) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e12) {
                        this.f5030a.d().r().b("Failed to send conditional user property to the service", e12);
                    }
                } else {
                    this.f5030a.d().r().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i10++;
            i11 = size;
        }
    }

    public final void s(zzac zzacVar) {
        t1.f.h(zzacVar);
        h();
        i();
        this.f5030a.b();
        F(new t8(this, true, C(true), this.f5030a.C().u(zzacVar), new zzac(zzacVar), zzacVar));
    }

    public final void t(boolean z10) {
        h();
        i();
        if (z10) {
            G();
            this.f5030a.C().q();
        }
        if (A()) {
            F(new r8(this, C(false)));
        }
    }

    public final void u(v7 v7Var) {
        h();
        i();
        F(new l8(this, v7Var));
    }

    public final void v(Bundle bundle) {
        h();
        i();
        F(new m8(this, C(false), bundle));
    }

    public final void w() {
        h();
        i();
        F(new q8(this, C(true)));
    }

    public final void x(l3 l3Var) {
        h();
        t1.f.h(l3Var);
        this.f5098d = l3Var;
        E();
        D();
    }

    public final void y(zzlk zzlkVar) {
        h();
        i();
        G();
        F(new g8(this, C(true), this.f5030a.C().w(zzlkVar), zzlkVar));
    }

    public final boolean z() {
        h();
        i();
        return this.f5098d != null;
    }
}
