package f2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.af;
import com.google.android.gms.internal.measurement.bf;
import com.google.android.gms.internal.measurement.ge;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y4 extends ba implements f {

    /* renamed from: d, reason: collision with root package name */
    public final Map f5831d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f5832e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f5833f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f5834g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f5835h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f5836i;

    /* renamed from: j, reason: collision with root package name */
    public final k.e f5837j;

    /* renamed from: k, reason: collision with root package name */
    public final ge f5838k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f5839l;

    /* renamed from: m, reason: collision with root package name */
    public final Map f5840m;

    /* renamed from: n, reason: collision with root package name */
    public final Map f5841n;

    public y4(pa paVar) {
        super(paVar);
        this.f5831d = new k.a();
        this.f5832e = new k.a();
        this.f5833f = new k.a();
        this.f5834g = new k.a();
        this.f5835h = new k.a();
        this.f5839l = new k.a();
        this.f5840m = new k.a();
        this.f5841n = new k.a();
        this.f5836i = new k.a();
        this.f5837j = new v4(this, 20);
        this.f5838k = new w4(this);
    }

    public static final Map q(com.google.android.gms.internal.measurement.v3 v3Var) {
        k.a aVar = new k.a();
        if (v3Var != null) {
            for (com.google.android.gms.internal.measurement.z3 z3Var : v3Var.R()) {
                aVar.put(z3Var.E(), z3Var.F());
            }
        }
        return aVar;
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.internal.measurement.e1 s(y4 y4Var, String str) throws Throwable {
        y4Var.i();
        t1.f.d(str);
        if (!y4Var.C(str)) {
            return null;
        }
        if (!y4Var.f5835h.containsKey(str) || y4Var.f5835h.get(str) == null) {
            y4Var.o(str);
        } else {
            y4Var.p(str, (com.google.android.gms.internal.measurement.v3) y4Var.f5835h.get(str));
        }
        return (com.google.android.gms.internal.measurement.e1) y4Var.f5837j.i().get(str);
    }

    public final void A(String str) {
        h();
        this.f5835h.remove(str);
    }

    public final boolean B(String str) {
        h();
        com.google.android.gms.internal.measurement.v3 v3VarT = t(str);
        if (v3VarT == null) {
            return false;
        }
        return v3VarT.U();
    }

    public final boolean C(String str) {
        com.google.android.gms.internal.measurement.v3 v3Var;
        return (TextUtils.isEmpty(str) || (v3Var = (com.google.android.gms.internal.measurement.v3) this.f5835h.get(str)) == null || v3Var.D() == 0) ? false : true;
    }

    public final boolean D(String str) {
        return "1".equals(e(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean E(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        o(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f5834g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean F(String str, String str2) throws Throwable {
        Boolean bool;
        h();
        o(str);
        if (D(str) && wa.Y(str2)) {
            return true;
        }
        if (G(str) && wa.Z(str2)) {
            return true;
        }
        Map map = (Map) this.f5833f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean G(String str) {
        return "1".equals(e(str, "measurement.upload.blacklist_public"));
    }

    public final boolean H(String str, byte[] bArr, String str2, String str3) throws Throwable {
        i();
        h();
        t1.f.d(str);
        com.google.android.gms.internal.measurement.u3 u3Var = (com.google.android.gms.internal.measurement.u3) m(str, bArr).m();
        n(str, u3Var);
        p(str, (com.google.android.gms.internal.measurement.v3) u3Var.o());
        this.f5835h.put(str, (com.google.android.gms.internal.measurement.v3) u3Var.o());
        this.f5839l.put(str, u3Var.w());
        this.f5840m.put(str, str2);
        this.f5841n.put(str, str3);
        this.f5831d.put(str, q((com.google.android.gms.internal.measurement.v3) u3Var.o()));
        this.f5039b.V().n(str, new ArrayList(u3Var.x()));
        try {
            u3Var.u();
            bArr = ((com.google.android.gms.internal.measurement.v3) u3Var.o()).i();
        } catch (RuntimeException e10) {
            this.f5030a.d().w().c("Unable to serialize reduced-size config. Storing full config instead. appId", v3.z(str), e10);
        }
        k kVarV = this.f5039b.V();
        t1.f.d(str);
        kVarV.h();
        kVarV.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (kVarV.P().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                kVarV.f5030a.d().r().b("Failed to update remote config (got 0). appId", v3.z(str));
            }
        } catch (SQLiteException e11) {
            kVarV.f5030a.d().r().c("Error storing remote config. appId", v3.z(str), e11);
        }
        this.f5835h.put(str, (com.google.android.gms.internal.measurement.v3) u3Var.o());
        return true;
    }

    public final boolean I(String str) throws Throwable {
        h();
        o(str);
        return this.f5832e.get(str) != null && ((Set) this.f5832e.get(str)).contains("app_instance_id");
    }

    public final boolean J(String str) throws Throwable {
        h();
        o(str);
        if (this.f5832e.get(str) != null) {
            return ((Set) this.f5832e.get(str)).contains("device_model") || ((Set) this.f5832e.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean K(String str) throws Throwable {
        h();
        o(str);
        return this.f5832e.get(str) != null && ((Set) this.f5832e.get(str)).contains("enhanced_user_id");
    }

    public final boolean L(String str) throws Throwable {
        h();
        o(str);
        return this.f5832e.get(str) != null && ((Set) this.f5832e.get(str)).contains("google_signals");
    }

    public final boolean M(String str) throws Throwable {
        h();
        o(str);
        if (this.f5832e.get(str) != null) {
            return ((Set) this.f5832e.get(str)).contains("os_version") || ((Set) this.f5832e.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean N(String str) throws Throwable {
        h();
        o(str);
        return this.f5832e.get(str) != null && ((Set) this.f5832e.get(str)).contains("user_id");
    }

    @Override // f2.f
    public final String e(String str, String str2) throws Throwable {
        h();
        o(str);
        Map map = (Map) this.f5831d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // f2.ba
    public final boolean l() {
        return false;
    }

    public final com.google.android.gms.internal.measurement.v3 m(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.v3.J();
        }
        try {
            com.google.android.gms.internal.measurement.v3 v3Var = (com.google.android.gms.internal.measurement.v3) ((com.google.android.gms.internal.measurement.u3) ra.E(com.google.android.gms.internal.measurement.v3.H(), bArr)).o();
            this.f5030a.d().v().c("Parsed config. version, gmp_app_id", v3Var.W() ? Long.valueOf(v3Var.F()) : null, v3Var.V() ? v3Var.K() : null);
            return v3Var;
        } catch (zzll e10) {
            this.f5030a.d().w().c("Unable to merge remote config. appId", v3.z(str), e10);
            return com.google.android.gms.internal.measurement.v3.J();
        } catch (RuntimeException e11) {
            this.f5030a.d().w().c("Unable to merge remote config. appId", v3.z(str), e11);
            return com.google.android.gms.internal.measurement.v3.J();
        }
    }

    public final void n(String str, com.google.android.gms.internal.measurement.u3 u3Var) {
        HashSet hashSet = new HashSet();
        k.a aVar = new k.a();
        k.a aVar2 = new k.a();
        k.a aVar3 = new k.a();
        Iterator it = u3Var.y().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.r3) it.next()).E());
        }
        for (int i10 = 0; i10 < u3Var.s(); i10++) {
            com.google.android.gms.internal.measurement.s3 s3Var = (com.google.android.gms.internal.measurement.s3) u3Var.t(i10).m();
            if (s3Var.u().isEmpty()) {
                this.f5030a.d().w().a("EventConfig contained null event name");
            } else {
                String strU = s3Var.u();
                String strB = g6.b(s3Var.u());
                if (!TextUtils.isEmpty(strB)) {
                    s3Var.t(strB);
                    u3Var.v(i10, s3Var);
                }
                if (s3Var.x() && s3Var.v()) {
                    aVar.put(strU, Boolean.TRUE);
                }
                if (s3Var.y() && s3Var.w()) {
                    aVar2.put(s3Var.u(), Boolean.TRUE);
                }
                if (s3Var.z()) {
                    if (s3Var.s() < 2 || s3Var.s() > 65535) {
                        this.f5030a.d().w().c("Invalid sampling rate. Event name, sample rate", s3Var.u(), Integer.valueOf(s3Var.s()));
                    } else {
                        aVar3.put(s3Var.u(), Integer.valueOf(s3Var.s()));
                    }
                }
            }
        }
        this.f5832e.put(str, hashSet);
        this.f5833f.put(str, aVar);
        this.f5834g.put(str, aVar2);
        this.f5836i.put(str, aVar3);
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0083: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:22:0x0083 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Cursor cursor;
        h hVar;
        i();
        h();
        t1.f.d(str);
        if (this.f5835h.get(str) != null) {
            return;
        }
        k kVarV = this.f5039b.V();
        t1.f.d(str);
        kVarV.h();
        kVarV.i();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = kVarV.P().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                } catch (SQLiteException e10) {
                    e = e10;
                    kVarV.f5030a.d().r().c("Error querying remote config. appId", v3.z(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    hVar = null;
                    if (hVar != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    throw th;
                }
                cursor2.close();
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
        }
        if (cursorQuery.moveToFirst()) {
            byte[] blob = cursorQuery.getBlob(0);
            String string = cursorQuery.getString(1);
            String string2 = cursorQuery.getString(2);
            if (cursorQuery.moveToNext()) {
                kVarV.f5030a.d().r().b("Got multiple records for app config, expected one. appId", v3.z(str));
            }
            if (blob != null) {
                hVar = new h(blob, string, string2);
                cursorQuery.close();
                if (hVar != null) {
                    com.google.android.gms.internal.measurement.u3 u3Var = (com.google.android.gms.internal.measurement.u3) m(str, hVar.f5227a).m();
                    n(str, u3Var);
                    this.f5831d.put(str, q((com.google.android.gms.internal.measurement.v3) u3Var.o()));
                    this.f5835h.put(str, (com.google.android.gms.internal.measurement.v3) u3Var.o());
                    p(str, (com.google.android.gms.internal.measurement.v3) u3Var.o());
                    this.f5839l.put(str, u3Var.w());
                    this.f5840m.put(str, hVar.f5228b);
                    this.f5841n.put(str, hVar.f5229c);
                    return;
                }
                this.f5831d.put(str, null);
                this.f5833f.put(str, null);
                this.f5832e.put(str, null);
                this.f5834g.put(str, null);
                this.f5835h.put(str, null);
                this.f5839l.put(str, null);
                this.f5840m.put(str, null);
                this.f5841n.put(str, null);
                this.f5836i.put(str, null);
                return;
            }
        }
        cursorQuery.close();
        hVar = null;
        if (hVar != null) {
        }
    }

    public final void p(final String str, com.google.android.gms.internal.measurement.v3 v3Var) {
        if (v3Var.D() == 0) {
            this.f5837j.f(str);
            return;
        }
        this.f5030a.d().v().b("EES programs found", Integer.valueOf(v3Var.D()));
        com.google.android.gms.internal.measurement.k5 k5Var = (com.google.android.gms.internal.measurement.k5) v3Var.Q().get(0);
        try {
            com.google.android.gms.internal.measurement.e1 e1Var = new com.google.android.gms.internal.measurement.e1();
            e1Var.d("internal.remoteConfig", new Callable() { // from class: f2.s4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.oa("internal.remoteConfig", new x4(this.f5671e, str));
                }
            });
            e1Var.d("internal.appMetadata", new Callable() { // from class: f2.t4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final y4 y4Var = this.f5694e;
                    final String str2 = str;
                    return new bf("internal.appMetadata", new Callable() { // from class: f2.r4
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            y4 y4Var2 = y4Var;
                            String str3 = str2;
                            e6 e6VarR = y4Var2.f5039b.V().R(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            y4Var2.f5030a.z().q();
                            map.put("gmp_version", 79000L);
                            if (e6VarR != null) {
                                String strO0 = e6VarR.o0();
                                if (strO0 != null) {
                                    map.put("app_version", strO0);
                                }
                                map.put("app_version_int", Long.valueOf(e6VarR.R()));
                                map.put("dynamite_version", Long.valueOf(e6VarR.a0()));
                            }
                            return map;
                        }
                    });
                }
            });
            e1Var.d("internal.logger", new Callable() { // from class: f2.u4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new af(this.f5724e.f5838k);
                }
            });
            e1Var.c(k5Var);
            this.f5837j.e(str, e1Var);
            this.f5030a.d().v().c("EES program loaded for appId, activities", str, Integer.valueOf(k5Var.D().D()));
            Iterator it = k5Var.D().G().iterator();
            while (it.hasNext()) {
                this.f5030a.d().v().b("EES program activity", ((com.google.android.gms.internal.measurement.i5) it.next()).E());
            }
        } catch (zzd unused) {
            this.f5030a.d().r().b("Failed to load EES program. appId", str);
        }
    }

    public final int r(String str, String str2) throws Throwable {
        Integer num;
        h();
        o(str);
        Map map = (Map) this.f5836i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final com.google.android.gms.internal.measurement.v3 t(String str) {
        i();
        h();
        t1.f.d(str);
        o(str);
        return (com.google.android.gms.internal.measurement.v3) this.f5835h.get(str);
    }

    public final String u(String str) {
        h();
        return (String) this.f5841n.get(str);
    }

    public final String v(String str) {
        h();
        return (String) this.f5840m.get(str);
    }

    public final String w(String str) throws Throwable {
        h();
        o(str);
        return (String) this.f5839l.get(str);
    }

    public final Set y(String str) {
        h();
        o(str);
        return (Set) this.f5832e.get(str);
    }

    public final void z(String str) {
        h();
        this.f5840m.put(str, null);
    }
}
