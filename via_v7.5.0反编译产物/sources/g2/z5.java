package g2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z5 extends k3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pa f5487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f5488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5489f;

    public z5(pa paVar, String str) {
        u1.f.h(paVar);
        this.f5487d = paVar;
        this.f5489f = null;
    }

    @Override // g2.l3
    public final void C(zzq zzqVar) {
        f0(zzqVar, false);
        e0(new x5(this, zzqVar));
    }

    @Override // g2.l3
    public final List D(String str, String str2, zzq zzqVar) {
        f0(zzqVar, false);
        String str3 = zzqVar.f3275c;
        u1.f.h(str3);
        try {
            return (List) this.f5487d.f().s(new n5(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f5487d.d().r().b("Failed to get conditional user properties", e10);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // g2.l3
    public final void G(long j10, String str, String str2, String str3) {
        e0(new y5(this, str2, str3, str, j10));
    }

    @Override // g2.l3
    public final void O(zzq zzqVar) {
        u1.f.d(zzqVar.f3275c);
        u1.f.h(zzqVar.F);
        r5 r5Var = new r5(this, zzqVar);
        u1.f.h(r5Var);
        if (this.f5487d.f().C()) {
            r5Var.run();
        } else {
            this.f5487d.f().A(r5Var);
        }
    }

    @Override // g2.l3
    public final List P(String str, String str2, boolean z10, zzq zzqVar) {
        f0(zzqVar, false);
        String str3 = zzqVar.f3275c;
        u1.f.h(str3);
        try {
            List<ta> list = (List) this.f5487d.f().s(new l5(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ta taVar : list) {
                if (z10 || !wa.Y(taVar.f5332c)) {
                    arrayList.add(new zzlk(taVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f5487d.d().r().c("Failed to query user properties. appId", v3.z(zzqVar.f3275c), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            this.f5487d.d().r().c("Failed to query user properties. appId", v3.z(zzqVar.f3275c), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // g2.l3
    public final void R(zzq zzqVar) {
        u1.f.d(zzqVar.f3275c);
        g0(zzqVar.f3275c, false);
        e0(new p5(this, zzqVar));
    }

    @Override // g2.l3
    public final void S(zzac zzacVar, zzq zzqVar) {
        u1.f.h(zzacVar);
        u1.f.h(zzacVar.f3253m);
        f0(zzqVar, false);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.f3251c = zzqVar.f3275c;
        e0(new j5(this, zzacVar2, zzqVar));
    }

    @Override // g2.l3
    public final byte[] V(zzau zzauVar, String str) {
        u1.f.d(str);
        u1.f.h(zzauVar);
        g0(str, true);
        this.f5487d.d().q().b("Log and bundle. event", this.f5487d.W().d(zzauVar.f3263c));
        long jC = this.f5487d.a().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f5487d.f().t(new u5(this, zzauVar, str)).get();
            if (bArr == null) {
                this.f5487d.d().r().b("Log and bundle returned null. appId", v3.z(str));
                bArr = new byte[0];
            }
            this.f5487d.d().q().d("Log and bundle processed. event, size, time_ms", this.f5487d.W().d(zzauVar.f3263c), Integer.valueOf(bArr.length), Long.valueOf((this.f5487d.a().c() / 1000000) - jC));
            return bArr;
        } catch (InterruptedException e10) {
            e = e10;
            this.f5487d.d().r().d("Failed to log and bundle. appId, event, error", v3.z(str), this.f5487d.W().d(zzauVar.f3263c), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            this.f5487d.d().r().d("Failed to log and bundle. appId, event, error", v3.z(str), this.f5487d.W().d(zzauVar.f3263c), e);
            return null;
        }
    }

    @Override // g2.l3
    public final void W(zzlk zzlkVar, zzq zzqVar) {
        u1.f.h(zzlkVar);
        f0(zzqVar, false);
        e0(new v5(this, zzlkVar, zzqVar));
    }

    public final void Z(zzau zzauVar, zzq zzqVar) {
        this.f5487d.e();
        this.f5487d.j(zzauVar, zzqVar);
    }

    public final zzau a0(zzau zzauVar, zzq zzqVar) {
        zzas zzasVar;
        if ("_cmp".equals(zzauVar.f3263c) && (zzasVar = zzauVar.f3264e) != null && zzasVar.c() != 0) {
            String strO = zzauVar.f3264e.o("_cis");
            if ("referrer broadcast".equals(strO) || "referrer API".equals(strO)) {
                this.f5487d.d().u().b("Event has been filtered ", zzauVar.toString());
                return new zzau("_cmpx", zzauVar.f3264e, zzauVar.f3265m, zzauVar.f3266n);
            }
        }
        return zzauVar;
    }

    public final void c0(zzau zzauVar, zzq zzqVar) {
        if (!this.f5487d.Z().C(zzqVar.f3275c)) {
            Z(zzauVar, zzqVar);
            return;
        }
        this.f5487d.d().v().b("EES config found for", zzqVar.f3275c);
        y4 y4VarZ = this.f5487d.Z();
        String str = zzqVar.f3275c;
        com.google.android.gms.internal.measurement.e1 e1Var = TextUtils.isEmpty(str) ? null : (com.google.android.gms.internal.measurement.e1) y4VarZ.f5453j.d(str);
        if (e1Var == null) {
            this.f5487d.d().v().b("EES not loaded for", zzqVar.f3275c);
            Z(zzauVar, zzqVar);
            return;
        }
        try {
            Map mapK = this.f5487d.g0().K(zzauVar.f3264e.g(), true);
            String strA = g6.a(zzauVar.f3263c);
            if (strA == null) {
                strA = zzauVar.f3263c;
            }
            if (e1Var.e(new com.google.android.gms.internal.measurement.b(strA, zzauVar.f3266n, mapK))) {
                if (e1Var.g()) {
                    this.f5487d.d().v().b("EES edited event", zzauVar.f3263c);
                    Z(this.f5487d.g0().C(e1Var.a().b()), zzqVar);
                } else {
                    Z(zzauVar, zzqVar);
                }
                if (e1Var.f()) {
                    for (com.google.android.gms.internal.measurement.b bVar : e1Var.a().c()) {
                        this.f5487d.d().v().b("EES logging created event", bVar.d());
                        Z(this.f5487d.g0().C(bVar), zzqVar);
                    }
                    return;
                }
                return;
            }
        } catch (zzd unused) {
            this.f5487d.d().r().c("EES error. appId, eventName", zzqVar.f3276e, zzauVar.f3263c);
        }
        this.f5487d.d().v().b("EES was not applied to event", zzauVar.f3263c);
        Z(zzauVar, zzqVar);
    }

    public final /* synthetic */ void d0(String str, Bundle bundle) {
        k kVarV = this.f5487d.V();
        kVarV.h();
        kVarV.i();
        byte[] bArrJ = kVarV.f4655b.g0().D(new p(kVarV.f4646a, "", str, "dep", 0L, 0L, bundle)).j();
        kVarV.f4646a.d().v().c("Saving default event parameters, appId, data size", kVarV.f4646a.D().d(str), Integer.valueOf(bArrJ.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrJ);
        try {
            if (kVarV.P().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                kVarV.f4646a.d().r().b("Failed to insert default event parameters (got -1). appId", v3.z(str));
            }
        } catch (SQLiteException e10) {
            kVarV.f4646a.d().r().c("Error storing default event parameters. appId", v3.z(str), e10);
        }
    }

    @Override // g2.l3
    public final void e(zzq zzqVar) {
        f0(zzqVar, false);
        e0(new q5(this, zzqVar));
    }

    public final void e0(Runnable runnable) {
        u1.f.h(runnable);
        if (this.f5487d.f().C()) {
            runnable.run();
        } else {
            this.f5487d.f().z(runnable);
        }
    }

    public final void f0(zzq zzqVar, boolean z10) {
        u1.f.h(zzqVar);
        u1.f.d(zzqVar.f3275c);
        g0(zzqVar.f3275c, false);
        this.f5487d.h0().M(zzqVar.f3276e, zzqVar.A);
    }

    @Override // g2.l3
    public final void g(zzau zzauVar, String str, String str2) {
        u1.f.h(zzauVar);
        u1.f.d(str);
        g0(str, true);
        e0(new t5(this, zzauVar, str));
    }

    public final void g0(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            this.f5487d.d().r().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z10) {
            try {
                if (this.f5488e == null) {
                    this.f5488e = Boolean.valueOf("com.google.android.gms".equals(this.f5489f) || x1.m.a(this.f5487d.c(), Binder.getCallingUid()) || r1.h.a(this.f5487d.c()).c(Binder.getCallingUid()));
                }
                if (this.f5488e.booleanValue()) {
                    return;
                }
            } catch (SecurityException e10) {
                this.f5487d.d().r().b("Measurement Service called with invalid calling package. appId", v3.z(str));
                throw e10;
            }
        }
        if (this.f5489f == null && r1.g.f(this.f5487d.c(), Binder.getCallingUid(), str)) {
            this.f5489f = str;
        }
        if (str.equals(this.f5489f)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // g2.l3
    public final void i(final Bundle bundle, zzq zzqVar) {
        f0(zzqVar, false);
        final String str = zzqVar.f3275c;
        u1.f.h(str);
        e0(new Runnable() { // from class: g2.i5
            @Override // java.lang.Runnable
            public final void run() {
                this.f4963c.d0(str, bundle);
            }
        });
    }

    @Override // g2.l3
    public final List j(String str, String str2, String str3, boolean z10) {
        g0(str, true);
        try {
            List<ta> list = (List) this.f5487d.f().s(new m5(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ta taVar : list) {
                if (z10 || !wa.Y(taVar.f5332c)) {
                    arrayList.add(new zzlk(taVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f5487d.d().r().c("Failed to get user properties as. appId", v3.z(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            this.f5487d.d().r().c("Failed to get user properties as. appId", v3.z(str), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // g2.l3
    public final void l(zzac zzacVar) {
        u1.f.h(zzacVar);
        u1.f.h(zzacVar.f3253m);
        u1.f.d(zzacVar.f3251c);
        g0(zzacVar.f3251c, true);
        e0(new k5(this, new zzac(zzacVar)));
    }

    @Override // g2.l3
    public final List m(zzq zzqVar, boolean z10) {
        f0(zzqVar, false);
        String str = zzqVar.f3275c;
        u1.f.h(str);
        try {
            List<ta> list = (List) this.f5487d.f().s(new w5(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ta taVar : list) {
                if (z10 || !wa.Y(taVar.f5332c)) {
                    arrayList.add(new zzlk(taVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f5487d.d().r().c("Failed to get user properties. appId", v3.z(zzqVar.f3275c), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            this.f5487d.d().r().c("Failed to get user properties. appId", v3.z(zzqVar.f3275c), e);
            return null;
        }
    }

    @Override // g2.l3
    public final String o(zzq zzqVar) {
        f0(zzqVar, false);
        return this.f5487d.j0(zzqVar);
    }

    @Override // g2.l3
    public final void p(zzau zzauVar, zzq zzqVar) {
        u1.f.h(zzauVar);
        f0(zzqVar, false);
        e0(new s5(this, zzauVar, zzqVar));
    }

    @Override // g2.l3
    public final List q(String str, String str2, String str3) {
        g0(str, true);
        try {
            return (List) this.f5487d.f().s(new o5(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f5487d.d().r().b("Failed to get conditional user properties as", e10);
            return Collections.EMPTY_LIST;
        }
    }
}
