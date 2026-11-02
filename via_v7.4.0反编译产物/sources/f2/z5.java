package f2;

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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z5 extends k3 {

    /* renamed from: d, reason: collision with root package name */
    public final pa f5871d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f5872e;

    /* renamed from: f, reason: collision with root package name */
    public String f5873f;

    public z5(pa paVar, String str) {
        t1.f.h(paVar);
        this.f5871d = paVar;
        this.f5873f = null;
    }

    @Override // f2.l3
    public final void D(zzq zzqVar) {
        f0(zzqVar, false);
        e0(new x5(this, zzqVar));
    }

    @Override // f2.l3
    public final List E(String str, String str2, zzq zzqVar) {
        f0(zzqVar, false);
        String str3 = zzqVar.f3976e;
        t1.f.h(str3);
        try {
            return (List) this.f5871d.f().s(new n5(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f5871d.d().r().b("Failed to get conditional user properties", e10);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // f2.l3
    public final void H(long j10, String str, String str2, String str3) {
        e0(new y5(this, str2, str3, str, j10));
    }

    @Override // f2.l3
    public final void P(zzq zzqVar) {
        t1.f.d(zzqVar.f3976e);
        t1.f.h(zzqVar.D);
        r5 r5Var = new r5(this, zzqVar);
        t1.f.h(r5Var);
        if (this.f5871d.f().C()) {
            r5Var.run();
        } else {
            this.f5871d.f().A(r5Var);
        }
    }

    @Override // f2.l3
    public final List Q(String str, String str2, boolean z10, zzq zzqVar) {
        f0(zzqVar, false);
        String str3 = zzqVar.f3976e;
        t1.f.h(str3);
        try {
            List<ta> list = (List) this.f5871d.f().s(new l5(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ta taVar : list) {
                if (z10 || !wa.Y(taVar.f5716c)) {
                    arrayList.add(new zzlk(taVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f5871d.d().r().c("Failed to query user properties. appId", v3.z(zzqVar.f3976e), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            this.f5871d.d().r().c("Failed to query user properties. appId", v3.z(zzqVar.f3976e), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // f2.l3
    public final void S(zzq zzqVar) {
        t1.f.d(zzqVar.f3976e);
        g0(zzqVar.f3976e, false);
        e0(new p5(this, zzqVar));
    }

    @Override // f2.l3
    public final void T(zzac zzacVar, zzq zzqVar) {
        t1.f.h(zzacVar);
        t1.f.h(zzacVar.f3954k);
        f0(zzqVar, false);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.f3952e = zzqVar.f3976e;
        e0(new j5(this, zzacVar2, zzqVar));
    }

    @Override // f2.l3
    public final byte[] V(zzau zzauVar, String str) {
        t1.f.d(str);
        t1.f.h(zzauVar);
        g0(str, true);
        this.f5871d.d().q().b("Log and bundle. event", this.f5871d.W().d(zzauVar.f3964e));
        long jC = this.f5871d.a().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f5871d.f().t(new u5(this, zzauVar, str)).get();
            if (bArr == null) {
                this.f5871d.d().r().b("Log and bundle returned null. appId", v3.z(str));
                bArr = new byte[0];
            }
            this.f5871d.d().q().d("Log and bundle processed. event, size, time_ms", this.f5871d.W().d(zzauVar.f3964e), Integer.valueOf(bArr.length), Long.valueOf((this.f5871d.a().c() / 1000000) - jC));
            return bArr;
        } catch (InterruptedException e10) {
            e = e10;
            this.f5871d.d().r().d("Failed to log and bundle. appId, event, error", v3.z(str), this.f5871d.W().d(zzauVar.f3964e), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            this.f5871d.d().r().d("Failed to log and bundle. appId, event, error", v3.z(str), this.f5871d.W().d(zzauVar.f3964e), e);
            return null;
        }
    }

    @Override // f2.l3
    public final void W(zzlk zzlkVar, zzq zzqVar) {
        t1.f.h(zzlkVar);
        f0(zzqVar, false);
        e0(new v5(this, zzlkVar, zzqVar));
    }

    public final void Z(zzau zzauVar, zzq zzqVar) {
        this.f5871d.e();
        this.f5871d.j(zzauVar, zzqVar);
    }

    public final zzau a0(zzau zzauVar, zzq zzqVar) {
        zzas zzasVar;
        if ("_cmp".equals(zzauVar.f3964e) && (zzasVar = zzauVar.f3965j) != null && zzasVar.c() != 0) {
            String strO = zzauVar.f3965j.o("_cis");
            if ("referrer broadcast".equals(strO) || "referrer API".equals(strO)) {
                this.f5871d.d().u().b("Event has been filtered ", zzauVar.toString());
                return new zzau("_cmpx", zzauVar.f3965j, zzauVar.f3966k, zzauVar.f3967l);
            }
        }
        return zzauVar;
    }

    public final void c0(zzau zzauVar, zzq zzqVar) {
        if (!this.f5871d.Z().C(zzqVar.f3976e)) {
            Z(zzauVar, zzqVar);
            return;
        }
        this.f5871d.d().v().b("EES config found for", zzqVar.f3976e);
        y4 y4VarZ = this.f5871d.Z();
        String str = zzqVar.f3976e;
        com.google.android.gms.internal.measurement.e1 e1Var = TextUtils.isEmpty(str) ? null : (com.google.android.gms.internal.measurement.e1) y4VarZ.f5837j.d(str);
        if (e1Var == null) {
            this.f5871d.d().v().b("EES not loaded for", zzqVar.f3976e);
            Z(zzauVar, zzqVar);
            return;
        }
        try {
            Map mapK = this.f5871d.g0().K(zzauVar.f3965j.g(), true);
            String strA = g6.a(zzauVar.f3964e);
            if (strA == null) {
                strA = zzauVar.f3964e;
            }
            if (e1Var.e(new com.google.android.gms.internal.measurement.b(strA, zzauVar.f3967l, mapK))) {
                if (e1Var.g()) {
                    this.f5871d.d().v().b("EES edited event", zzauVar.f3964e);
                    Z(this.f5871d.g0().C(e1Var.a().b()), zzqVar);
                } else {
                    Z(zzauVar, zzqVar);
                }
                if (e1Var.f()) {
                    for (com.google.android.gms.internal.measurement.b bVar : e1Var.a().c()) {
                        this.f5871d.d().v().b("EES logging created event", bVar.d());
                        Z(this.f5871d.g0().C(bVar), zzqVar);
                    }
                    return;
                }
                return;
            }
        } catch (zzd unused) {
            this.f5871d.d().r().c("EES error. appId, eventName", zzqVar.f3977j, zzauVar.f3964e);
        }
        this.f5871d.d().v().b("EES was not applied to event", zzauVar.f3964e);
        Z(zzauVar, zzqVar);
    }

    public final /* synthetic */ void d0(String str, Bundle bundle) {
        k kVarV = this.f5871d.V();
        kVarV.h();
        kVarV.i();
        byte[] bArrI = kVarV.f5039b.g0().D(new p(kVarV.f5030a, "", str, "dep", 0L, 0L, bundle)).i();
        kVarV.f5030a.d().v().c("Saving default event parameters, appId, data size", kVarV.f5030a.D().d(str), Integer.valueOf(bArrI.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrI);
        try {
            if (kVarV.P().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                kVarV.f5030a.d().r().b("Failed to insert default event parameters (got -1). appId", v3.z(str));
            }
        } catch (SQLiteException e10) {
            kVarV.f5030a.d().r().c("Error storing default event parameters. appId", v3.z(str), e10);
        }
    }

    @Override // f2.l3
    public final void e(zzq zzqVar) {
        f0(zzqVar, false);
        e0(new q5(this, zzqVar));
    }

    public final void e0(Runnable runnable) {
        t1.f.h(runnable);
        if (this.f5871d.f().C()) {
            runnable.run();
        } else {
            this.f5871d.f().z(runnable);
        }
    }

    public final void f0(zzq zzqVar, boolean z10) {
        t1.f.h(zzqVar);
        t1.f.d(zzqVar.f3976e);
        g0(zzqVar.f3976e, false);
        this.f5871d.h0().M(zzqVar.f3977j, zzqVar.f3992y);
    }

    @Override // f2.l3
    public final void g(zzau zzauVar, String str, String str2) {
        t1.f.h(zzauVar);
        t1.f.d(str);
        g0(str, true);
        e0(new t5(this, zzauVar, str));
    }

    public final void g0(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            this.f5871d.d().r().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z10) {
            try {
                if (this.f5872e == null) {
                    this.f5872e = Boolean.valueOf("com.google.android.gms".equals(this.f5873f) || w1.m.a(this.f5871d.c(), Binder.getCallingUid()) || q1.h.a(this.f5871d.c()).c(Binder.getCallingUid()));
                }
                if (this.f5872e.booleanValue()) {
                    return;
                }
            } catch (SecurityException e10) {
                this.f5871d.d().r().b("Measurement Service called with invalid calling package. appId", v3.z(str));
                throw e10;
            }
        }
        if (this.f5873f == null && q1.g.f(this.f5871d.c(), Binder.getCallingUid(), str)) {
            this.f5873f = str;
        }
        if (str.equals(this.f5873f)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // f2.l3
    public final void i(final Bundle bundle, zzq zzqVar) {
        f0(zzqVar, false);
        final String str = zzqVar.f3976e;
        t1.f.h(str);
        e0(new Runnable() { // from class: f2.i5
            @Override // java.lang.Runnable
            public final void run() {
                this.f5347e.d0(str, bundle);
            }
        });
    }

    @Override // f2.l3
    public final List j(String str, String str2, String str3, boolean z10) {
        g0(str, true);
        try {
            List<ta> list = (List) this.f5871d.f().s(new m5(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ta taVar : list) {
                if (z10 || !wa.Y(taVar.f5716c)) {
                    arrayList.add(new zzlk(taVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f5871d.d().r().c("Failed to get user properties as. appId", v3.z(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e11) {
            e = e11;
            this.f5871d.d().r().c("Failed to get user properties as. appId", v3.z(str), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // f2.l3
    public final void l(zzac zzacVar) {
        t1.f.h(zzacVar);
        t1.f.h(zzacVar.f3954k);
        t1.f.d(zzacVar.f3952e);
        g0(zzacVar.f3952e, true);
        e0(new k5(this, new zzac(zzacVar)));
    }

    @Override // f2.l3
    public final List m(zzq zzqVar, boolean z10) {
        f0(zzqVar, false);
        String str = zzqVar.f3976e;
        t1.f.h(str);
        try {
            List<ta> list = (List) this.f5871d.f().s(new w5(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ta taVar : list) {
                if (z10 || !wa.Y(taVar.f5716c)) {
                    arrayList.add(new zzlk(taVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.f5871d.d().r().c("Failed to get user properties. appId", v3.z(zzqVar.f3976e), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            this.f5871d.d().r().c("Failed to get user properties. appId", v3.z(zzqVar.f3976e), e);
            return null;
        }
    }

    @Override // f2.l3
    public final String o(zzq zzqVar) {
        f0(zzqVar, false);
        return this.f5871d.j0(zzqVar);
    }

    @Override // f2.l3
    public final void p(zzau zzauVar, zzq zzqVar) {
        t1.f.h(zzauVar);
        f0(zzqVar, false);
        e0(new s5(this, zzauVar, zzqVar));
    }

    @Override // f2.l3
    public final List q(String str, String str2, String str3) {
        g0(str, true);
        try {
            return (List) this.f5871d.f().s(new o5(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f5871d.d().r().b("Failed to get conditional user properties as", e10);
            return Collections.EMPTY_LIST;
        }
    }
}
