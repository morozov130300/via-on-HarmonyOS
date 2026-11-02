package f2;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.ed;
import com.google.android.gms.internal.measurement.ke;
import com.google.android.gms.internal.measurement.pc;
import com.google.android.gms.internal.measurement.sc;
import com.google.android.gms.internal.measurement.tb;
import com.google.android.gms.internal.measurement.vc;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class pa implements c6 {
    public static volatile pa F;
    public final Map A;
    public final Map B;
    public v7 C;
    public String D;

    /* renamed from: a, reason: collision with root package name */
    public final y4 f5587a;

    /* renamed from: b, reason: collision with root package name */
    public final b4 f5588b;

    /* renamed from: c, reason: collision with root package name */
    public k f5589c;

    /* renamed from: d, reason: collision with root package name */
    public e4 f5590d;

    /* renamed from: e, reason: collision with root package name */
    public z9 f5591e;

    /* renamed from: f, reason: collision with root package name */
    public b f5592f;

    /* renamed from: g, reason: collision with root package name */
    public final ra f5593g;

    /* renamed from: h, reason: collision with root package name */
    public t7 f5594h;

    /* renamed from: i, reason: collision with root package name */
    public g9 f5595i;

    /* renamed from: j, reason: collision with root package name */
    public final da f5596j;

    /* renamed from: k, reason: collision with root package name */
    public o4 f5597k;

    /* renamed from: l, reason: collision with root package name */
    public final h5 f5598l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5600n;

    /* renamed from: o, reason: collision with root package name */
    public long f5601o;

    /* renamed from: p, reason: collision with root package name */
    public List f5602p;

    /* renamed from: q, reason: collision with root package name */
    public int f5603q;

    /* renamed from: r, reason: collision with root package name */
    public int f5604r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5605s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5606t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5607u;

    /* renamed from: v, reason: collision with root package name */
    public FileLock f5608v;

    /* renamed from: w, reason: collision with root package name */
    public FileChannel f5609w;

    /* renamed from: x, reason: collision with root package name */
    public List f5610x;

    /* renamed from: y, reason: collision with root package name */
    public List f5611y;

    /* renamed from: z, reason: collision with root package name */
    public long f5612z;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5599m = false;
    public final va E = new ka(this);

    public pa(qa qaVar, h5 h5Var) {
        t1.f.h(qaVar);
        this.f5598l = h5.H(qaVar.f5644a, null, null);
        this.f5612z = -1L;
        this.f5596j = new da(this);
        ra raVar = new ra(this);
        raVar.j();
        this.f5593g = raVar;
        b4 b4Var = new b4(this);
        b4Var.j();
        this.f5588b = b4Var;
        y4 y4Var = new y4(this);
        y4Var.j();
        this.f5587a = y4Var;
        this.A = new HashMap();
        this.B = new HashMap();
        f().z(new ea(this, qaVar));
    }

    public static final void G(com.google.android.gms.internal.measurement.i4 i4Var, int i10, String str) {
        List listH = i4Var.H();
        for (int i11 = 0; i11 < listH.size(); i11++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.n4) listH.get(i11)).J())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.m4 m4VarH = com.google.android.gms.internal.measurement.n4.H();
        m4VarH.B("_err");
        m4VarH.A(i10);
        com.google.android.gms.internal.measurement.n4 n4Var = (com.google.android.gms.internal.measurement.n4) m4VarH.o();
        com.google.android.gms.internal.measurement.m4 m4VarH2 = com.google.android.gms.internal.measurement.n4.H();
        m4VarH2.B("_ev");
        m4VarH2.C(str);
        com.google.android.gms.internal.measurement.n4 n4Var2 = (com.google.android.gms.internal.measurement.n4) m4VarH2.o();
        i4Var.x(n4Var);
        i4Var.x(n4Var2);
    }

    public static final void H(com.google.android.gms.internal.measurement.i4 i4Var, String str) {
        List listH = i4Var.H();
        for (int i10 = 0; i10 < listH.size(); i10++) {
            if (str.equals(((com.google.android.gms.internal.measurement.n4) listH.get(i10)).J())) {
                i4Var.z(i10);
                return;
            }
        }
    }

    public static final boolean Q(zzq zzqVar) {
        return (TextUtils.isEmpty(zzqVar.f3977j) && TextUtils.isEmpty(zzqVar.f3992y)) ? false : true;
    }

    public static final ba R(ba baVar) {
        if (baVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (baVar.k()) {
            return baVar;
        }
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(baVar.getClass())));
    }

    public static pa f0(Context context) {
        t1.f.h(context);
        t1.f.h(context.getApplicationContext());
        if (F == null) {
            synchronized (pa.class) {
                try {
                    if (F == null) {
                        F = new pa((qa) t1.f.h(new qa(context)), null);
                    }
                } finally {
                }
            }
        }
        return F;
    }

    public static /* bridge */ /* synthetic */ void k0(pa paVar, qa qaVar) {
        paVar.f().h();
        paVar.f5597k = new o4(paVar);
        k kVar = new k(paVar);
        kVar.j();
        paVar.f5589c = kVar;
        paVar.U().z((f) t1.f.h(paVar.f5587a));
        g9 g9Var = new g9(paVar);
        g9Var.j();
        paVar.f5595i = g9Var;
        b bVar = new b(paVar);
        bVar.j();
        paVar.f5592f = bVar;
        t7 t7Var = new t7(paVar);
        t7Var.j();
        paVar.f5594h = t7Var;
        z9 z9Var = new z9(paVar);
        z9Var.j();
        paVar.f5591e = z9Var;
        paVar.f5590d = new e4(paVar);
        if (paVar.f5603q != paVar.f5604r) {
            paVar.d().r().c("Not all upload components initialized", Integer.valueOf(paVar.f5603q), Integer.valueOf(paVar.f5604r));
        }
        paVar.f5599m = true;
    }

    public final void A(String str, f6 f6Var) {
        f().h();
        g();
        this.A.put(str, f6Var);
        k kVar = this.f5589c;
        R(kVar);
        t1.f.h(str);
        t1.f.h(f6Var);
        kVar.h();
        kVar.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", f6Var.i());
        try {
            if (kVar.P().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                kVar.f5030a.d().r().b("Failed to insert/update consent setting (got -1). appId", v3.z(str));
            }
        } catch (SQLiteException e10) {
            kVar.f5030a.d().r().c("Error storing consent setting. appId, error", v3.z(str), e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B(zzlk zzlkVar, zzq zzqVar) {
        long jLongValue;
        f().h();
        g();
        if (Q(zzqVar)) {
            if (!zzqVar.f3983p) {
                S(zzqVar);
                return;
            }
            int iP0 = h0().p0(zzlkVar.f3970j);
            if (iP0 != 0) {
                wa waVarH0 = h0();
                String str = zzlkVar.f3970j;
                U();
                String strR = waVarH0.r(str, 24, true);
                String str2 = zzlkVar.f3970j;
                h0().C(this.E, zzqVar.f3976e, iP0, "_ev", strR, str2 != null ? str2.length() : 0);
                return;
            }
            int iL0 = h0().l0(zzlkVar.f3970j, zzlkVar.c());
            if (iL0 != 0) {
                wa waVarH02 = h0();
                String str3 = zzlkVar.f3970j;
                U();
                String strR2 = waVarH02.r(str3, 24, true);
                Object objC = zzlkVar.c();
                h0().C(this.E, zzqVar.f3976e, iL0, "_ev", strR2, (objC == null || !((objC instanceof String) || (objC instanceof CharSequence))) ? 0 : objC.toString().length());
                return;
            }
            Object objP = h0().p(zzlkVar.f3970j, zzlkVar.c());
            if (objP == null) {
                return;
            }
            if ("_sid".equals(zzlkVar.f3970j)) {
                long j10 = zzlkVar.f3971k;
                String str4 = zzlkVar.f3974n;
                String str5 = (String) t1.f.h(zzqVar.f3976e);
                k kVar = this.f5589c;
                R(kVar);
                ta taVarX = kVar.X(str5, "_sno");
                if (taVarX != null) {
                    Object obj = taVarX.f5718e;
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                    } else {
                        if (taVarX != null) {
                            d().w().b("Retrieved last session number from database does not contain a valid (long) value", taVarX.f5718e);
                        }
                        k kVar2 = this.f5589c;
                        R(kVar2);
                        q qVarV = kVar2.V(str5, "_s");
                        if (qVarV != null) {
                            jLongValue = qVarV.f5615c;
                            d().v().b("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                        } else {
                            jLongValue = 0;
                        }
                    }
                    B(new zzlk("_sno", j10, Long.valueOf(jLongValue + 1), str4), zzqVar);
                }
            }
            ta taVar = new ta((String) t1.f.h(zzqVar.f3976e), (String) t1.f.h(zzlkVar.f3974n), zzlkVar.f3970j, zzlkVar.f3971k, objP);
            d().v().c("Setting user property", this.f5598l.D().f(taVar.f5716c), objP);
            k kVar3 = this.f5589c;
            R(kVar3);
            kVar3.e0();
            try {
                if ("_id".equals(taVar.f5716c)) {
                    k kVar4 = this.f5589c;
                    R(kVar4);
                    ta taVarX2 = kVar4.X(zzqVar.f3976e, "_id");
                    if (taVarX2 != null && !taVar.f5718e.equals(taVarX2.f5718e)) {
                        k kVar5 = this.f5589c;
                        R(kVar5);
                        kVar5.m(zzqVar.f3976e, "_lair");
                    }
                }
                S(zzqVar);
                k kVar6 = this.f5589c;
                R(kVar6);
                boolean zX = kVar6.x(taVar);
                if (U().B(null, i3.J0) && "_sid".equals(zzlkVar.f3970j)) {
                    ra raVar = this.f5593g;
                    R(raVar);
                    long jY = raVar.y(zzqVar.F);
                    k kVar7 = this.f5589c;
                    R(kVar7);
                    e6 e6VarR = kVar7.R(zzqVar.f3976e);
                    if (e6VarR != null) {
                        e6VarR.K(jY);
                        if (e6VarR.P()) {
                            k kVar8 = this.f5589c;
                            R(kVar8);
                            kVar8.p(e6VarR);
                        }
                    }
                }
                k kVar9 = this.f5589c;
                R(kVar9);
                kVar9.o();
                if (!zX) {
                    d().r().c("Too many unique user properties are set. Ignoring user property", this.f5598l.D().f(taVar.f5716c), taVar.f5718e);
                    h0().C(this.E, zzqVar.f3976e, 9, null, null, 0);
                }
                k kVar10 = this.f5589c;
                R(kVar10);
                kVar10.f0();
            } catch (Throwable th) {
                k kVar11 = this.f5589c;
                R(kVar11);
                kVar11.f0();
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ba A[Catch: all -> 0x0034, TRY_ENTER, TryCatch #15 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:76:0x019c, B:143:0x02bd, B:145:0x02c3, B:147:0x02cf, B:148:0x02d3, B:150:0x02d9, B:152:0x02ed, B:156:0x02f6, B:158:0x02fc, B:164:0x0321, B:161:0x0311, B:163:0x031b, B:165:0x0324, B:167:0x033f, B:171:0x034e, B:173:0x0372, B:175:0x03aa, B:177:0x03af, B:179:0x03b7, B:180:0x03ba, B:182:0x03bf, B:183:0x03c2, B:185:0x03ce, B:186:0x03e4, B:187:0x03ea, B:189:0x03f9, B:191:0x040a, B:192:0x041f, B:194:0x042c, B:196:0x0441, B:198:0x044c, B:199:0x0455, B:195:0x043a, B:201:0x04a3, B:130:0x028d, B:205:0x04bd, B:206:0x04c0, B:142:0x02ba, B:207:0x04c1, B:212:0x04fd, B:232:0x052a, B:234:0x0530, B:236:0x053b, B:220:0x050b, B:240:0x0546, B:241:0x0549), top: B:260:0x0010, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02c3 A[Catch: all -> 0x0034, TryCatch #15 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:76:0x019c, B:143:0x02bd, B:145:0x02c3, B:147:0x02cf, B:148:0x02d3, B:150:0x02d9, B:152:0x02ed, B:156:0x02f6, B:158:0x02fc, B:164:0x0321, B:161:0x0311, B:163:0x031b, B:165:0x0324, B:167:0x033f, B:171:0x034e, B:173:0x0372, B:175:0x03aa, B:177:0x03af, B:179:0x03b7, B:180:0x03ba, B:182:0x03bf, B:183:0x03c2, B:185:0x03ce, B:186:0x03e4, B:187:0x03ea, B:189:0x03f9, B:191:0x040a, B:192:0x041f, B:194:0x042c, B:196:0x0441, B:198:0x044c, B:199:0x0455, B:195:0x043a, B:201:0x04a3, B:130:0x028d, B:205:0x04bd, B:206:0x04c0, B:142:0x02ba, B:207:0x04c1, B:212:0x04fd, B:232:0x052a, B:234:0x0530, B:236:0x053b, B:220:0x050b, B:240:0x0546, B:241:0x0549), top: B:260:0x0010, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04bd A[Catch: all -> 0x0034, TryCatch #15 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:76:0x019c, B:143:0x02bd, B:145:0x02c3, B:147:0x02cf, B:148:0x02d3, B:150:0x02d9, B:152:0x02ed, B:156:0x02f6, B:158:0x02fc, B:164:0x0321, B:161:0x0311, B:163:0x031b, B:165:0x0324, B:167:0x033f, B:171:0x034e, B:173:0x0372, B:175:0x03aa, B:177:0x03af, B:179:0x03b7, B:180:0x03ba, B:182:0x03bf, B:183:0x03c2, B:185:0x03ce, B:186:0x03e4, B:187:0x03ea, B:189:0x03f9, B:191:0x040a, B:192:0x041f, B:194:0x042c, B:196:0x0441, B:198:0x044c, B:199:0x0455, B:195:0x043a, B:201:0x04a3, B:130:0x028d, B:205:0x04bd, B:206:0x04c0, B:142:0x02ba, B:207:0x04c1, B:212:0x04fd, B:232:0x052a, B:234:0x0530, B:236:0x053b, B:220:0x050b, B:240:0x0546, B:241:0x0549), top: B:260:0x0010, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0530 A[Catch: all -> 0x0034, TryCatch #15 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:76:0x019c, B:143:0x02bd, B:145:0x02c3, B:147:0x02cf, B:148:0x02d3, B:150:0x02d9, B:152:0x02ed, B:156:0x02f6, B:158:0x02fc, B:164:0x0321, B:161:0x0311, B:163:0x031b, B:165:0x0324, B:167:0x033f, B:171:0x034e, B:173:0x0372, B:175:0x03aa, B:177:0x03af, B:179:0x03b7, B:180:0x03ba, B:182:0x03bf, B:183:0x03c2, B:185:0x03ce, B:186:0x03e4, B:187:0x03ea, B:189:0x03f9, B:191:0x040a, B:192:0x041f, B:194:0x042c, B:196:0x0441, B:198:0x044c, B:199:0x0455, B:195:0x043a, B:201:0x04a3, B:130:0x028d, B:205:0x04bd, B:206:0x04c0, B:142:0x02ba, B:207:0x04c1, B:212:0x04fd, B:232:0x052a, B:234:0x0530, B:236:0x053b, B:220:0x050b, B:240:0x0546, B:241:0x0549), top: B:260:0x0010, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0136 A[Catch: all -> 0x0034, TryCatch #15 {all -> 0x0034, blocks: (B:3:0x0010, B:5:0x0021, B:11:0x0038, B:13:0x003e, B:15:0x004e, B:17:0x0056, B:19:0x005c, B:21:0x0067, B:23:0x0077, B:25:0x0082, B:27:0x0095, B:29:0x00b4, B:31:0x00ba, B:32:0x00bd, B:34:0x00c9, B:35:0x00e0, B:37:0x00f1, B:39:0x00f7, B:43:0x010c, B:59:0x0131, B:61:0x0136, B:62:0x0139, B:63:0x013a, B:67:0x0162, B:71:0x016a, B:76:0x019c, B:143:0x02bd, B:145:0x02c3, B:147:0x02cf, B:148:0x02d3, B:150:0x02d9, B:152:0x02ed, B:156:0x02f6, B:158:0x02fc, B:164:0x0321, B:161:0x0311, B:163:0x031b, B:165:0x0324, B:167:0x033f, B:171:0x034e, B:173:0x0372, B:175:0x03aa, B:177:0x03af, B:179:0x03b7, B:180:0x03ba, B:182:0x03bf, B:183:0x03c2, B:185:0x03ce, B:186:0x03e4, B:187:0x03ea, B:189:0x03f9, B:191:0x040a, B:192:0x041f, B:194:0x042c, B:196:0x0441, B:198:0x044c, B:199:0x0455, B:195:0x043a, B:201:0x04a3, B:130:0x028d, B:205:0x04bd, B:206:0x04c0, B:142:0x02ba, B:207:0x04c1, B:212:0x04fd, B:232:0x052a, B:234:0x0530, B:236:0x053b, B:220:0x050b, B:240:0x0546, B:241:0x0549), top: B:260:0x0010, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019a A[Catch: all -> 0x01a3, SQLiteException -> 0x01a8, TRY_LEAVE, TryCatch #3 {all -> 0x01a3, blocks: (B:73:0x0194, B:75:0x019a, B:82:0x01af, B:83:0x01b5, B:84:0x01b9, B:86:0x01c6, B:87:0x01db, B:89:0x01e1, B:90:0x01eb, B:92:0x01f1, B:98:0x01fe, B:100:0x0209, B:102:0x020f, B:103:0x0216, B:106:0x022d), top: B:250:0x0194 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01af A[Catch: all -> 0x01a3, SQLiteException -> 0x01a8, TRY_ENTER, TryCatch #3 {all -> 0x01a3, blocks: (B:73:0x0194, B:75:0x019a, B:82:0x01af, B:83:0x01b5, B:84:0x01b9, B:86:0x01c6, B:87:0x01db, B:89:0x01e1, B:90:0x01eb, B:92:0x01f1, B:98:0x01fe, B:100:0x0209, B:102:0x020f, B:103:0x0216, B:106:0x022d), top: B:250:0x0194 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C() {
        Cursor cursor;
        k kVar;
        long jI;
        Cursor cursorRawQuery;
        String string;
        k kVar2;
        Cursor cursor2;
        Cursor cursor3;
        List listSubList;
        String strF;
        String strN;
        Cursor cursorQuery;
        Cursor cursor4;
        byte[] blob;
        ra raVar;
        Cursor cursorRawQuery2;
        f().h();
        g();
        int i10 = 1;
        this.f5607u = true;
        int i11 = 0;
        try {
            this.f5598l.b();
            Boolean boolJ = this.f5598l.L().J();
            if (boolJ == null) {
                d().w().a("Upload data called on the client side before use of service was decided");
                this.f5607u = false;
            } else if (boolJ.booleanValue()) {
                d().r().a("Upload called in the client side when service should be used");
                this.f5607u = false;
            } else if (this.f5601o > 0) {
                M();
                this.f5607u = false;
            } else {
                f().h();
                if (this.f5610x != null) {
                    d().v().a("Uploading requested multiple times");
                    this.f5607u = false;
                } else {
                    b4 b4Var = this.f5588b;
                    R(b4Var);
                    if (b4Var.m()) {
                        long jA = a().a();
                        Cursor cursor5 = null;
                        int iO = U().o(null, i3.T);
                        U();
                        long jI2 = jA - g.I();
                        for (int i12 = 0; i12 < iO && N(null, jI2); i12++) {
                        }
                        long jA2 = this.f5595i.f5219g.a();
                        if (jA2 != 0) {
                            d().q().b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jA - jA2)));
                        }
                        k kVar3 = this.f5589c;
                        R(kVar3);
                        String strZ = kVar3.Z();
                        long j10 = -1;
                        if (TextUtils.isEmpty(strZ)) {
                            try {
                                this.f5612z = -1L;
                                kVar = this.f5589c;
                                R(kVar);
                                U();
                                jI = jA - g.I();
                                kVar.h();
                                kVar.i();
                            } catch (Throwable th) {
                                th = th;
                                cursor = null;
                            }
                            try {
                                cursorRawQuery = kVar.P().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jI)});
                                try {
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    kVar.f5030a.d().r().b("Error selecting expired configs", e);
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    string = null;
                                    if (!TextUtils.isEmpty(string)) {
                                    }
                                    this.f5607u = false;
                                    K();
                                }
                            } catch (SQLiteException e11) {
                                e = e11;
                                cursorRawQuery = null;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = null;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                            if (cursorRawQuery.moveToFirst()) {
                                string = cursorRawQuery.getString(0);
                                cursorRawQuery.close();
                                if (!TextUtils.isEmpty(string)) {
                                }
                            } else {
                                kVar.f5030a.d().v().a("No expired configs for apps with pending events");
                                cursorRawQuery.close();
                                string = null;
                                if (!TextUtils.isEmpty(string)) {
                                    k kVar4 = this.f5589c;
                                    R(kVar4);
                                    e6 e6VarR = kVar4.R(string);
                                    if (e6VarR != null) {
                                        i(e6VarR);
                                    }
                                }
                            }
                        } else {
                            if (this.f5612z == -1) {
                                k kVar5 = this.f5589c;
                                R(kVar5);
                                try {
                                    cursorRawQuery2 = kVar5.P().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    try {
                                        try {
                                            if (cursorRawQuery2.moveToFirst()) {
                                                j10 = cursorRawQuery2.getLong(0);
                                            }
                                        } catch (SQLiteException e12) {
                                            e = e12;
                                            kVar5.f5030a.d().r().b("Error querying raw events", e);
                                            if (cursorRawQuery2 != null) {
                                                cursorRawQuery2.close();
                                            }
                                            this.f5612z = j10;
                                            int iO2 = U().o(strZ, i3.f5311i);
                                            int iMax = Math.max(0, U().o(strZ, i3.f5313j));
                                            kVar2 = this.f5589c;
                                            R(kVar2);
                                            kVar2.h();
                                            kVar2.i();
                                            t1.f.a(iO2 <= 0);
                                            t1.f.a(iMax <= 0);
                                            t1.f.d(strZ);
                                            cursorQuery = kVar2.P().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{strZ}, null, null, "rowid", String.valueOf(iO2));
                                            try {
                                                try {
                                                    if (cursorQuery.moveToFirst()) {
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    cursor4 = cursorQuery;
                                                }
                                            } catch (SQLiteException e13) {
                                                e = e13;
                                                cursor4 = cursorQuery;
                                            }
                                            if (!listSubList.isEmpty()) {
                                            }
                                            this.f5607u = false;
                                            K();
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        cursor5 = cursorRawQuery2;
                                        if (cursor5 != null) {
                                            cursor5.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteException e14) {
                                    e = e14;
                                    cursorRawQuery2 = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (cursor5 != null) {
                                    }
                                    throw th;
                                }
                                cursorRawQuery2.close();
                                this.f5612z = j10;
                            }
                            int iO22 = U().o(strZ, i3.f5311i);
                            int iMax2 = Math.max(0, U().o(strZ, i3.f5313j));
                            kVar2 = this.f5589c;
                            R(kVar2);
                            kVar2.h();
                            kVar2.i();
                            t1.f.a(iO22 <= 0);
                            t1.f.a(iMax2 <= 0);
                            t1.f.d(strZ);
                            try {
                                cursorQuery = kVar2.P().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{strZ}, null, null, "rowid", String.valueOf(iO22));
                                if (cursorQuery.moveToFirst()) {
                                    listSubList = Collections.EMPTY_LIST;
                                    cursorQuery.close();
                                } else {
                                    ArrayList arrayList = new ArrayList();
                                    int length = 0;
                                    while (true) {
                                        long j11 = cursorQuery.getLong(i11);
                                        try {
                                            blob = cursorQuery.getBlob(i10);
                                            raVar = kVar2.f5039b.f5593g;
                                            R(raVar);
                                        } catch (IOException e15) {
                                            e = e15;
                                            cursor4 = cursorQuery;
                                        }
                                        try {
                                            try {
                                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                                                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int i13 = gZIPInputStream.read(bArr);
                                                    if (i13 <= 0) {
                                                        break;
                                                    }
                                                    cursor4 = cursorQuery;
                                                    try {
                                                        try {
                                                            byteArrayOutputStream.write(bArr, 0, i13);
                                                            cursorQuery = cursor4;
                                                        } catch (IOException e16) {
                                                            e = e16;
                                                            try {
                                                                raVar.f5030a.d().r().b("Failed to ungzip content", e);
                                                                throw e;
                                                            } catch (IOException e17) {
                                                                e = e17;
                                                                kVar2.f5030a.d().r().c("Failed to unzip queued bundle. appId", v3.z(strZ), e);
                                                                if (cursor4.moveToNext()) {
                                                                    break;
                                                                } else {
                                                                    break;
                                                                }
                                                                cursor4.close();
                                                                listSubList = arrayList;
                                                                if (!listSubList.isEmpty()) {
                                                                }
                                                                this.f5607u = false;
                                                                K();
                                                            }
                                                        }
                                                    } catch (SQLiteException e18) {
                                                        e = e18;
                                                        cursor3 = cursor4;
                                                        try {
                                                            kVar2.f5030a.d().r().c("Error querying bundles. appId", v3.z(strZ), e);
                                                            listSubList = Collections.EMPTY_LIST;
                                                            if (cursor3 != null) {
                                                            }
                                                            if (!listSubList.isEmpty()) {
                                                            }
                                                            this.f5607u = false;
                                                            K();
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            cursor2 = cursor3;
                                                            if (cursor2 != null) {
                                                                cursor2.close();
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        cursor2 = cursor4;
                                                        if (cursor2 != null) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                gZIPInputStream.close();
                                                byteArrayInputStream.close();
                                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                                if (!arrayList.isEmpty() && byteArray.length + length > iMax2) {
                                                    cursor4 = cursorQuery;
                                                    break;
                                                }
                                                try {
                                                    com.google.android.gms.internal.measurement.t4 t4Var = (com.google.android.gms.internal.measurement.t4) ra.E(com.google.android.gms.internal.measurement.u4.S1(), byteArray);
                                                    if (!cursorQuery.isNull(2)) {
                                                        t4Var.Y(cursorQuery.getInt(2));
                                                    }
                                                    length += byteArray.length;
                                                    arrayList.add(Pair.create((com.google.android.gms.internal.measurement.u4) t4Var.o(), Long.valueOf(j11)));
                                                } catch (IOException e19) {
                                                    kVar2.f5030a.d().r().c("Failed to merge queued bundle. appId", v3.z(strZ), e19);
                                                }
                                                cursor4 = cursorQuery;
                                                if (cursor4.moveToNext() || length > iMax2) {
                                                    break;
                                                    break;
                                                } else {
                                                    cursorQuery = cursor4;
                                                    i10 = 1;
                                                    i11 = 0;
                                                }
                                            } catch (SQLiteException e20) {
                                                e = e20;
                                                cursor4 = cursorQuery;
                                                cursor3 = cursor4;
                                                kVar2.f5030a.d().r().c("Error querying bundles. appId", v3.z(strZ), e);
                                                listSubList = Collections.EMPTY_LIST;
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                                if (!listSubList.isEmpty()) {
                                                }
                                                this.f5607u = false;
                                                K();
                                            }
                                        } catch (IOException e21) {
                                            e = e21;
                                            cursor4 = cursorQuery;
                                        }
                                    }
                                    cursor4.close();
                                    listSubList = arrayList;
                                }
                            } catch (SQLiteException e22) {
                                e = e22;
                                cursor3 = null;
                            } catch (Throwable th8) {
                                th = th8;
                                cursor2 = null;
                            }
                            if (!listSubList.isEmpty()) {
                                if (c0(strZ).j(zzha.AD_STORAGE)) {
                                    Iterator it = listSubList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            strN = null;
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.u4 u4Var = (com.google.android.gms.internal.measurement.u4) ((Pair) it.next()).first;
                                        if (!u4Var.N().isEmpty()) {
                                            strN = u4Var.N();
                                            break;
                                        }
                                    }
                                    if (strN != null) {
                                        int i14 = 0;
                                        while (true) {
                                            if (i14 >= listSubList.size()) {
                                                break;
                                            }
                                            com.google.android.gms.internal.measurement.u4 u4Var2 = (com.google.android.gms.internal.measurement.u4) ((Pair) listSubList.get(i14)).first;
                                            if (!u4Var2.N().isEmpty() && !u4Var2.N().equals(strN)) {
                                                listSubList = listSubList.subList(0, i14);
                                                break;
                                            }
                                            i14++;
                                        }
                                    }
                                }
                                com.google.android.gms.internal.measurement.r4 r4VarD = com.google.android.gms.internal.measurement.s4.D();
                                int size = listSubList.size();
                                ArrayList arrayList2 = new ArrayList(listSubList.size());
                                boolean z10 = U().C(strZ) && c0(strZ).j(zzha.AD_STORAGE);
                                boolean zJ = c0(strZ).j(zzha.AD_STORAGE);
                                boolean zJ2 = c0(strZ).j(zzha.ANALYTICS_STORAGE);
                                ae.b();
                                boolean zB = U().B(strZ, i3.f5328q0);
                                for (int i15 = 0; i15 < size; i15++) {
                                    com.google.android.gms.internal.measurement.t4 t4Var2 = (com.google.android.gms.internal.measurement.t4) ((com.google.android.gms.internal.measurement.u4) ((Pair) listSubList.get(i15)).first).m();
                                    arrayList2.add((Long) ((Pair) listSubList.get(i15)).second);
                                    U().q();
                                    t4Var2.f0(79000L);
                                    t4Var2.e0(jA);
                                    this.f5598l.b();
                                    t4Var2.Z(false);
                                    if (!z10) {
                                        t4Var2.D0();
                                    }
                                    if (!zJ) {
                                        t4Var2.K0();
                                        t4Var2.G0();
                                    }
                                    if (!zJ2) {
                                        t4Var2.A0();
                                    }
                                    h(strZ, t4Var2);
                                    if (!zB) {
                                        t4Var2.L0();
                                    }
                                    if (U().B(strZ, i3.X)) {
                                        byte[] bArrI = ((com.google.android.gms.internal.measurement.u4) t4Var2.o()).i();
                                        ra raVar2 = this.f5593g;
                                        R(raVar2);
                                        t4Var2.B(raVar2.z(bArrI));
                                    }
                                    r4VarD.s(t4Var2);
                                }
                                if (Log.isLoggable(d().D(), 2)) {
                                    ra raVar3 = this.f5593g;
                                    R(raVar3);
                                    strF = raVar3.F((com.google.android.gms.internal.measurement.s4) r4VarD.o());
                                } else {
                                    strF = null;
                                }
                                R(this.f5593g);
                                byte[] bArrI2 = ((com.google.android.gms.internal.measurement.s4) r4VarD.o()).i();
                                ca caVarI = this.f5596j.i(strZ);
                                try {
                                    t1.f.a(!arrayList2.isEmpty());
                                    if (this.f5610x != null) {
                                        d().r().a("Set uploading progress before finishing the previous upload");
                                    } else {
                                        this.f5610x = new ArrayList(arrayList2);
                                    }
                                    this.f5595i.f5220h.b(jA);
                                    d().v().d("Uploading data. app, uncompressed size, data", size > 0 ? r4VarD.t(0).W1() : "?", Integer.valueOf(bArrI2.length), strF);
                                    this.f5606t = true;
                                    b4 b4Var2 = this.f5588b;
                                    R(b4Var2);
                                    URL url = new URL(caVarI.a());
                                    Map mapB = caVarI.b();
                                    fa faVar = new fa(this, strZ);
                                    b4Var2.h();
                                    b4Var2.i();
                                    t1.f.h(url);
                                    t1.f.h(bArrI2);
                                    t1.f.h(faVar);
                                    b4Var2.f5030a.f().y(new a4(b4Var2, strZ, url, bArrI2, mapB, faVar));
                                } catch (MalformedURLException unused) {
                                    d().r().c("Failed to parse upload URL. Not uploading. appId", v3.z(strZ), caVarI.a());
                                }
                            }
                        }
                        this.f5607u = false;
                    } else {
                        d().v().a("Network not connected, ignoring upload request");
                        M();
                        this.f5607u = false;
                    }
                }
            }
            K();
        } catch (Throwable th9) {
            this.f5607u = false;
            K();
            throw th9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x0522 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0561 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05d8 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0625 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0632 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x063f A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0678 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0689 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x06ca A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x06f1 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x06f4 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x078a A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x07d0 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0820 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x082d A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0847 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x08d3 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x08f2 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x09bf A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0a69 A[Catch: all -> 0x01ba, SQLiteException -> 0x0a7f, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0a7f, blocks: (B:283:0x0a5a, B:285:0x0a69), top: B:310:0x0a5a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0a81  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x09cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01da A[Catch: all -> 0x01ba, TRY_ENTER, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0241 A[Catch: all -> 0x01ba, TRY_ENTER, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0251 A[Catch: all -> 0x01ba, TryCatch #3 {all -> 0x01ba, blocks: (B:38:0x0194, B:41:0x01a4, B:43:0x01ae, B:49:0x01bd, B:91:0x0331, B:102:0x036d, B:104:0x03a3, B:106:0x03a8, B:107:0x03bf, B:111:0x03d2, B:113:0x03eb, B:115:0x03f0, B:116:0x0407, B:121:0x042e, B:125:0x044f, B:126:0x0466, B:129:0x0477, B:132:0x0494, B:133:0x04a8, B:135:0x04b2, B:137:0x04bf, B:139:0x04c5, B:140:0x04ce, B:141:0x04dc, B:143:0x04f1, B:152:0x0522, B:153:0x0537, B:155:0x0561, B:158:0x0579, B:161:0x05ba, B:163:0x05e8, B:165:0x0625, B:166:0x062a, B:168:0x0632, B:169:0x0637, B:171:0x063f, B:172:0x0644, B:174:0x064f, B:176:0x065c, B:178:0x066a, B:179:0x066f, B:181:0x0678, B:182:0x067c, B:184:0x0689, B:185:0x068e, B:187:0x06b7, B:189:0x06bf, B:190:0x06c4, B:192:0x06ca, B:193:0x06cd, B:195:0x06f1, B:198:0x06fa, B:201:0x0703, B:202:0x071d, B:204:0x0723, B:206:0x0739, B:208:0x0745, B:210:0x0752, B:215:0x076f, B:216:0x077f, B:221:0x078a, B:222:0x078d, B:224:0x07ab, B:226:0x07af, B:228:0x07c1, B:230:0x07c5, B:232:0x07d0, B:233:0x07d9, B:235:0x0820, B:236:0x0825, B:238:0x082d, B:240:0x0837, B:241:0x083a, B:243:0x0847, B:245:0x0867, B:246:0x0874, B:247:0x08aa, B:249:0x08b2, B:251:0x08bc, B:252:0x08c9, B:254:0x08d3, B:255:0x08e0, B:256:0x08ec, B:258:0x08f2, B:260:0x092c, B:262:0x093c, B:264:0x0946, B:266:0x0959, B:268:0x095f, B:269:0x09a2, B:270:0x09ad, B:271:0x09b9, B:273:0x09bf, B:282:0x0a0c, B:283:0x0a5a, B:285:0x0a69, B:299:0x0acc, B:290:0x0a83, B:291:0x0a86, B:276:0x09cb, B:278:0x09f7, B:296:0x0a9f, B:297:0x0ab6, B:298:0x0ab7, B:196:0x06f4, B:162:0x05d8, B:149:0x0509, B:95:0x0349, B:96:0x0350, B:98:0x0356, B:100:0x0362, B:54:0x01ce, B:57:0x01da, B:59:0x01f1, B:65:0x020d, B:72:0x024b, B:74:0x0251, B:76:0x025f, B:78:0x0270, B:81:0x0279, B:88:0x02f8, B:90:0x0303, B:82:0x029f, B:83:0x02b9, B:87:0x02df, B:86:0x02cc, B:68:0x021b, B:71:0x0241), top: B:312:0x0194, inners: #2, #4, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D(zzau zzauVar, zzq zzqVar) {
        String strO;
        long jLongValue;
        String str;
        ta taVar;
        long length;
        long jDelete;
        q qVarV;
        p pVar;
        q qVar;
        com.google.android.gms.internal.measurement.t4 t4VarS1;
        long j10;
        long j11;
        Map mapC;
        ArrayList arrayList;
        f6 f6VarD;
        zzha zzhaVar;
        e6 e6VarR;
        List listC0;
        int i10;
        k kVar;
        com.google.android.gms.internal.measurement.u4 u4Var;
        k kVar2;
        r rVar;
        int i11;
        ContentValues contentValues;
        Pair pairN;
        Object obj;
        t1.f.h(zzqVar);
        t1.f.d(zzqVar.f3976e);
        long jNanoTime = System.nanoTime();
        f().h();
        g();
        String str2 = zzqVar.f3976e;
        R(this.f5593g);
        if (ra.n(zzauVar, zzqVar)) {
            if (!zzqVar.f3983p) {
                S(zzqVar);
                return;
            }
            y4 y4Var = this.f5587a;
            R(y4Var);
            if (y4Var.F(str2, zzauVar.f3964e)) {
                d().w().c("Dropping blocked event. appId", v3.z(str2), this.f5598l.D().d(zzauVar.f3964e));
                y4 y4Var2 = this.f5587a;
                R(y4Var2);
                if (!y4Var2.D(str2)) {
                    y4 y4Var3 = this.f5587a;
                    R(y4Var3);
                    if (!y4Var3.G(str2)) {
                        if ("_err".equals(zzauVar.f3964e)) {
                            return;
                        }
                        h0().C(this.E, str2, 11, "_ev", zzauVar.f3964e, 0);
                        return;
                    }
                }
                k kVar3 = this.f5589c;
                R(kVar3);
                e6 e6VarR2 = kVar3.R(str2);
                if (e6VarR2 != null) {
                    long jAbs = Math.abs(a().a() - Math.max(e6VarR2.b0(), e6VarR2.S()));
                    U();
                    if (jAbs > ((Long) i3.B.a(null)).longValue()) {
                        d().q().a("Fetching config for blocked app");
                        i(e6VarR2);
                        return;
                    }
                    return;
                }
                return;
            }
            w3 w3VarB = w3.b(zzauVar);
            h0().B(w3VarB, U().n(str2));
            vc.b();
            int iP = U().B(null, i3.C0) ? U().p(str2, i3.S, 10, 35) : 0;
            for (String str3 : new TreeSet(w3VarB.f5785d.keySet())) {
                if ("items".equals(str3)) {
                    wa waVarH0 = h0();
                    Parcelable[] parcelableArray = w3VarB.f5785d.getParcelableArray(str3);
                    vc.b();
                    waVarH0.A(parcelableArray, iP, U().B(null, i3.C0));
                    jNanoTime = jNanoTime;
                }
            }
            long j12 = jNanoTime;
            zzau zzauVarA = w3VarB.a();
            if (Log.isLoggable(d().D(), 2)) {
                d().v().b("Logging event", this.f5598l.D().c(zzauVarA));
            }
            sc.b();
            U().B(null, i3.f5346z0);
            k kVar4 = this.f5589c;
            R(kVar4);
            kVar4.e0();
            try {
                S(zzqVar);
                boolean z10 = "ecommerce_purchase".equals(zzauVarA.f3964e) || "purchase".equals(zzauVarA.f3964e) || "refund".equals(zzauVarA.f3964e);
                if ("_iap".equals(zzauVarA.f3964e)) {
                    strO = zzauVarA.f3965j.o("currency");
                    if (z10) {
                        jLongValue = zzauVarA.f3965j.k("value").longValue();
                    } else {
                        double dDoubleValue = zzauVarA.f3965j.h("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            double dLongValue = zzauVarA.f3965j.k("value").longValue();
                            Double.isNaN(dLongValue);
                            dDoubleValue = dLongValue * 1000000.0d;
                        }
                        if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            d().w().c("Data lost. Currency value is too big. appId", v3.z(str2), Double.valueOf(dDoubleValue));
                            k kVar5 = this.f5589c;
                            R(kVar5);
                            kVar5.o();
                            k kVar6 = this.f5589c;
                            R(kVar6);
                            kVar6.f0();
                            return;
                        }
                        jLongValue = Math.round(dDoubleValue);
                        if ("refund".equals(zzauVarA.f3964e)) {
                            jLongValue = -jLongValue;
                        }
                    }
                    if (TextUtils.isEmpty(strO)) {
                        String upperCase = strO.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String strConcat = "_ltv_".concat(upperCase);
                            k kVar7 = this.f5589c;
                            R(kVar7);
                            ta taVarX = kVar7.X(str2, strConcat);
                            if (taVarX != null) {
                                Object obj2 = taVarX.f5718e;
                                if (obj2 instanceof Long) {
                                    str = "_err";
                                    taVar = new ta(str2, zzauVarA.f3966k, strConcat, a().a(), Long.valueOf(((Long) obj2).longValue() + jLongValue));
                                    str2 = str2;
                                } else {
                                    str = "_err";
                                    k kVar8 = this.f5589c;
                                    R(kVar8);
                                    int iO = U().o(str2, i3.G) - 1;
                                    t1.f.d(str2);
                                    kVar8.h();
                                    kVar8.i();
                                    try {
                                        kVar8.P().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str2, str2, String.valueOf(iO)});
                                    } catch (SQLiteException e10) {
                                        kVar8.f5030a.d().r().c("Error pruning currencies. appId", v3.z(str2), e10);
                                    }
                                    taVar = new ta(str2, zzauVarA.f3966k, strConcat, a().a(), Long.valueOf(jLongValue));
                                    str2 = str2;
                                }
                                k kVar9 = this.f5589c;
                                R(kVar9);
                                if (!kVar9.x(taVar)) {
                                    d().r().d("Too many unique user properties are set. Ignoring user property. appId", v3.z(str2), this.f5598l.D().f(taVar.f5716c), taVar.f5718e);
                                    h0().C(this.E, str2, 9, null, null, 0);
                                }
                            }
                        } else {
                            str = "_err";
                        }
                    }
                } else {
                    if (z10) {
                        z10 = true;
                        strO = zzauVarA.f3965j.o("currency");
                        if (z10) {
                        }
                        if (TextUtils.isEmpty(strO)) {
                        }
                    }
                    str = "_err";
                }
                boolean Z = wa.Z(zzauVarA.f3964e);
                boolean zEquals = str.equals(zzauVarA.f3964e);
                h0();
                zzas zzasVar = zzauVarA.f3965j;
                if (zzasVar == null) {
                    length = 0;
                } else {
                    r rVar2 = new r(zzasVar);
                    length = 0;
                    while (rVar2.hasNext()) {
                        if (zzasVar.n(rVar2.next()) instanceof Parcelable[]) {
                            length += ((Parcelable[]) r11).length;
                        }
                    }
                }
                k kVar10 = this.f5589c;
                R(kVar10);
                long j13 = length;
                String str4 = str2;
                i iVarU = kVar10.U(F(), str4, j13 + 1, true, Z, false, zEquals, false);
                long j14 = iVarU.f5288b;
                U();
                long jIntValue = j14 - ((Integer) i3.f5319m.a(null)).intValue();
                if (jIntValue > 0) {
                    if (jIntValue % 1000 == 1) {
                        d().r().c("Data loss. Too many events logged. appId, count", v3.z(str4), Long.valueOf(iVarU.f5288b));
                    }
                    k kVar11 = this.f5589c;
                    R(kVar11);
                    kVar11.o();
                    k kVar12 = this.f5589c;
                    R(kVar12);
                    kVar12.f0();
                    return;
                }
                if (Z) {
                    long j15 = iVarU.f5287a;
                    U();
                    long jIntValue2 = j15 - ((Integer) i3.f5323o.a(null)).intValue();
                    if (jIntValue2 > 0) {
                        if (jIntValue2 % 1000 == 1) {
                            d().r().c("Data loss. Too many public events logged. appId, count", v3.z(str4), Long.valueOf(iVarU.f5287a));
                        }
                        h0().C(this.E, str4, 16, "_ev", zzauVarA.f3964e, 0);
                        k kVar13 = this.f5589c;
                        R(kVar13);
                        kVar13.o();
                        k kVar14 = this.f5589c;
                        R(kVar14);
                        kVar14.f0();
                        return;
                    }
                }
                if (zEquals) {
                    long jMax = iVarU.f5290d - Math.max(0, Math.min(1000000, U().o(zzqVar.f3976e, i3.f5321n)));
                    if (jMax > 0) {
                        if (jMax == 1) {
                            d().r().c("Too many error events logged. appId, count", v3.z(str4), Long.valueOf(iVarU.f5290d));
                        }
                        k kVar15 = this.f5589c;
                        R(kVar15);
                        kVar15.o();
                        k kVar16 = this.f5589c;
                        R(kVar16);
                        kVar16.f0();
                        return;
                    }
                }
                Bundle bundleG = zzauVarA.f3965j.g();
                h0().D(bundleG, "_o", zzauVarA.f3966k);
                if (h0().U(str4)) {
                    h0().D(bundleG, "_dbg", 1L);
                    h0().D(bundleG, "_r", 1L);
                }
                if ("_s".equals(zzauVarA.f3964e)) {
                    k kVar17 = this.f5589c;
                    R(kVar17);
                    ta taVarX2 = kVar17.X(zzqVar.f3976e, "_sno");
                    if (taVarX2 != null && (taVarX2.f5718e instanceof Long)) {
                        h0().D(bundleG, "_sno", taVarX2.f5718e);
                    }
                }
                k kVar18 = this.f5589c;
                R(kVar18);
                t1.f.d(str4);
                kVar18.h();
                kVar18.i();
                try {
                } catch (SQLiteException e11) {
                    e = e11;
                }
                try {
                    jDelete = kVar18.P().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str4, String.valueOf(Math.max(0, Math.min(1000000, kVar18.f5030a.z().o(str4, i3.f5329r))))});
                } catch (SQLiteException e12) {
                    e = e12;
                    kVar18.f5030a.d().r().c("Error deleting over the limit events. appId", v3.z(str4), e);
                    jDelete = 0;
                    if (jDelete > 0) {
                    }
                    p pVar2 = new p(this.f5598l, zzauVarA.f3966k, str4, zzauVarA.f3964e, zzauVarA.f3967l, 0L, bundleG);
                    k kVar19 = this.f5589c;
                    R(kVar19);
                    qVarV = kVar19.V(str4, pVar2.f5571b);
                    if (qVarV != null) {
                    }
                    k kVar20 = this.f5589c;
                    R(kVar20);
                    kVar20.q(qVar);
                    f().h();
                    g();
                    t1.f.h(pVar);
                    t1.f.h(zzqVar);
                    t1.f.d(pVar.f5570a);
                    t1.f.a(pVar.f5570a.equals(zzqVar.f3976e));
                    t4VarS1 = com.google.android.gms.internal.measurement.u4.S1();
                    t4VarS1.W(1);
                    t4VarS1.R("android");
                    if (!TextUtils.isEmpty(zzqVar.f3976e)) {
                    }
                    if (!TextUtils.isEmpty(zzqVar.f3979l)) {
                    }
                    if (!TextUtils.isEmpty(zzqVar.f3978k)) {
                    }
                    ae.b();
                    if (!TextUtils.isEmpty(zzqVar.F)) {
                        t4VarS1.a0(zzqVar.F);
                    }
                    j10 = zzqVar.f3985r;
                    if (j10 != -2147483648L) {
                    }
                    t4VarS1.N(zzqVar.f3980m);
                    if (!TextUtils.isEmpty(zzqVar.f3977j)) {
                    }
                    t4VarS1.D(c0((String) t1.f.h(zzqVar.f3976e)).d(f6.c(zzqVar.D, 100)).i());
                    if (t4VarS1.k0().isEmpty()) {
                        t4VarS1.u(zzqVar.f3992y);
                    }
                    j11 = zzqVar.f3981n;
                    if (j11 != 0) {
                    }
                    t4VarS1.H(zzqVar.A);
                    ra raVar = this.f5593g;
                    R(raVar);
                    com.google.android.gms.internal.measurement.y5 y5VarB = com.google.android.gms.internal.measurement.y5.b(raVar.f5039b.f5598l.c().getContentResolver(), com.google.android.gms.internal.measurement.j6.a("com.google.android.gms.measurement"), new Runnable() { // from class: f2.u
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.google.android.gms.internal.measurement.v6.c();
                        }
                    });
                    if (y5VarB != null) {
                    }
                    if (mapC == null) {
                    }
                    if (arrayList != null) {
                    }
                    f6VarD = c0((String) t1.f.h(zzqVar.f3976e)).d(f6.c(zzqVar.D, 100));
                    zzhaVar = zzha.AD_STORAGE;
                    if (f6VarD.j(zzhaVar)) {
                        pairN = this.f5595i.n(zzqVar.f3976e, f6VarD);
                        if (!TextUtils.isEmpty((CharSequence) pairN.first)) {
                            t4VarS1.X((String) pairN.first);
                            obj = pairN.second;
                            if (obj != null) {
                            }
                        }
                    }
                    this.f5598l.A().k();
                    t4VarS1.F(Build.MODEL);
                    this.f5598l.A().k();
                    t4VarS1.Q(Build.VERSION.RELEASE);
                    t4VarS1.d0((int) this.f5598l.A().p());
                    t4VarS1.h0(this.f5598l.A().q());
                    ed.b();
                    if (U().B(null, i3.G0)) {
                    }
                    if (this.f5598l.o()) {
                    }
                    k kVar21 = this.f5589c;
                    R(kVar21);
                    e6VarR = kVar21.R(zzqVar.f3976e);
                    if (e6VarR == null) {
                    }
                    if (f6VarD.j(zzha.ANALYTICS_STORAGE)) {
                        t4VarS1.w((String) t1.f.h(e6VarR.m0()));
                    }
                    if (!TextUtils.isEmpty(e6VarR.p0())) {
                    }
                    k kVar22 = this.f5589c;
                    R(kVar22);
                    listC0 = kVar22.c0(zzqVar.f3976e);
                    while (i10 < listC0.size()) {
                    }
                    kVar = this.f5589c;
                    R(kVar);
                    u4Var = (com.google.android.gms.internal.measurement.u4) t4VarS1.o();
                    kVar.h();
                    kVar.i();
                    t1.f.h(u4Var);
                    t1.f.d(u4Var.W1());
                    byte[] bArrI = u4Var.i();
                    ra raVar2 = kVar.f5039b.f5593g;
                    R(raVar2);
                    long jZ = raVar2.z(bArrI);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", u4Var.W1());
                    contentValues2.put("metadata_fingerprint", Long.valueOf(jZ));
                    contentValues2.put("metadata", bArrI);
                    kVar.P().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                    kVar2 = this.f5589c;
                    R(kVar2);
                    rVar = new r(pVar.f5575f);
                    while (true) {
                        if (!rVar.hasNext()) {
                        }
                    }
                    i11 = 1;
                    kVar2.h();
                    kVar2.i();
                    t1.f.h(pVar);
                    t1.f.d(pVar.f5570a);
                    ra raVar3 = kVar2.f5039b.f5593g;
                    R(raVar3);
                    byte[] bArrI2 = raVar3.D(pVar).i();
                    contentValues = new ContentValues();
                    contentValues.put("app_id", pVar.f5570a);
                    contentValues.put("name", pVar.f5571b);
                    contentValues.put("timestamp", Long.valueOf(pVar.f5573d));
                    contentValues.put("metadata_fingerprint", Long.valueOf(jZ));
                    contentValues.put("data", bArrI2);
                    contentValues.put("realtime", Integer.valueOf(i11));
                    try {
                        if (kVar2.P().insert("raw_events", null, contentValues) != -1) {
                        }
                    } catch (SQLiteException e13) {
                        kVar2.f5030a.d().r().c("Error storing raw event. appId", v3.z(pVar.f5570a), e13);
                    }
                    k kVar23 = this.f5589c;
                    R(kVar23);
                    kVar23.o();
                    k kVar24 = this.f5589c;
                    R(kVar24);
                    kVar24.f0();
                    M();
                    d().v().b("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j12) + 500000) / 1000000));
                }
                if (jDelete > 0) {
                    d().w().c("Data lost. Too many events stored on disk, deleted. appId", v3.z(str4), Long.valueOf(jDelete));
                }
                p pVar22 = new p(this.f5598l, zzauVarA.f3966k, str4, zzauVarA.f3964e, zzauVarA.f3967l, 0L, bundleG);
                k kVar192 = this.f5589c;
                R(kVar192);
                qVarV = kVar192.V(str4, pVar22.f5571b);
                if (qVarV != null) {
                    k kVar25 = this.f5589c;
                    R(kVar25);
                    if (kVar25.O(str4) >= U().l(str4) && Z) {
                        d().r().d("Too many event names used, ignoring event. appId, name, supported count", v3.z(str4), this.f5598l.D().d(pVar22.f5571b), Integer.valueOf(U().l(str4)));
                        h0().C(this.E, str4, 8, null, null, 0);
                        k kVar26 = this.f5589c;
                        R(kVar26);
                        kVar26.f0();
                        return;
                    }
                    qVar = new q(str4, pVar22.f5571b, 0L, 0L, 0L, pVar22.f5573d, 0L, null, null, null, null);
                    pVar = pVar22;
                } else {
                    p pVarA = pVar22.a(this.f5598l, qVarV.f5618f);
                    q qVarC = qVarV.c(pVarA.f5573d);
                    pVar = pVarA;
                    qVar = qVarC;
                }
                k kVar202 = this.f5589c;
                R(kVar202);
                kVar202.q(qVar);
                f().h();
                g();
                t1.f.h(pVar);
                t1.f.h(zzqVar);
                t1.f.d(pVar.f5570a);
                t1.f.a(pVar.f5570a.equals(zzqVar.f3976e));
                t4VarS1 = com.google.android.gms.internal.measurement.u4.S1();
                t4VarS1.W(1);
                t4VarS1.R("android");
                if (!TextUtils.isEmpty(zzqVar.f3976e)) {
                    t4VarS1.v(zzqVar.f3976e);
                }
                if (!TextUtils.isEmpty(zzqVar.f3979l)) {
                    t4VarS1.x(zzqVar.f3979l);
                }
                if (!TextUtils.isEmpty(zzqVar.f3978k)) {
                    t4VarS1.y(zzqVar.f3978k);
                }
                ae.b();
                if (!TextUtils.isEmpty(zzqVar.F) && (U().B(null, i3.f5324o0) || U().B(zzqVar.f3976e, i3.f5328q0))) {
                    t4VarS1.a0(zzqVar.F);
                }
                j10 = zzqVar.f3985r;
                if (j10 != -2147483648L) {
                    t4VarS1.z((int) j10);
                }
                t4VarS1.N(zzqVar.f3980m);
                if (!TextUtils.isEmpty(zzqVar.f3977j)) {
                    t4VarS1.M(zzqVar.f3977j);
                }
                t4VarS1.D(c0((String) t1.f.h(zzqVar.f3976e)).d(f6.c(zzqVar.D, 100)).i());
                if (t4VarS1.k0().isEmpty() && !TextUtils.isEmpty(zzqVar.f3992y)) {
                    t4VarS1.u(zzqVar.f3992y);
                }
                j11 = zzqVar.f3981n;
                if (j11 != 0) {
                    t4VarS1.E(j11);
                }
                t4VarS1.H(zzqVar.A);
                ra raVar4 = this.f5593g;
                R(raVar4);
                com.google.android.gms.internal.measurement.y5 y5VarB2 = com.google.android.gms.internal.measurement.y5.b(raVar4.f5039b.f5598l.c().getContentResolver(), com.google.android.gms.internal.measurement.j6.a("com.google.android.gms.measurement"), new Runnable() { // from class: f2.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.android.gms.internal.measurement.v6.c();
                    }
                });
                mapC = y5VarB2 != null ? Collections.EMPTY_MAP : y5VarB2.c();
                if (mapC == null && !mapC.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    int iIntValue = ((Integer) i3.R.a(null)).intValue();
                    for (Map.Entry entry : mapC.entrySet()) {
                        if (((String) entry.getKey()).startsWith("measurement.id.")) {
                            try {
                                int i12 = Integer.parseInt((String) entry.getValue());
                                if (i12 != 0) {
                                    arrayList2.add(Integer.valueOf(i12));
                                    if (arrayList2.size() >= iIntValue) {
                                        raVar4.f5030a.d().w().b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList2.size()));
                                        break;
                                    }
                                    continue;
                                } else {
                                    continue;
                                }
                            } catch (NumberFormatException e14) {
                                raVar4.f5030a.d().w().b("Experiment ID NumberFormatException", e14);
                            }
                        }
                    }
                    arrayList = arrayList2.isEmpty() ? null : arrayList2;
                }
                if (arrayList != null) {
                    t4VarS1.u0(arrayList);
                }
                f6VarD = c0((String) t1.f.h(zzqVar.f3976e)).d(f6.c(zzqVar.D, 100));
                zzhaVar = zzha.AD_STORAGE;
                if (f6VarD.j(zzhaVar) && zzqVar.f3990w) {
                    pairN = this.f5595i.n(zzqVar.f3976e, f6VarD);
                    if (!TextUtils.isEmpty((CharSequence) pairN.first) && zzqVar.f3990w) {
                        t4VarS1.X((String) pairN.first);
                        obj = pairN.second;
                        if (obj != null) {
                            t4VarS1.P(((Boolean) obj).booleanValue());
                        }
                    }
                }
                this.f5598l.A().k();
                t4VarS1.F(Build.MODEL);
                this.f5598l.A().k();
                t4VarS1.Q(Build.VERSION.RELEASE);
                t4VarS1.d0((int) this.f5598l.A().p());
                t4VarS1.h0(this.f5598l.A().q());
                ed.b();
                if (U().B(null, i3.G0)) {
                    t4VarS1.c0(zzqVar.H);
                }
                if (this.f5598l.o()) {
                    t4VarS1.j0();
                    if (!TextUtils.isEmpty(null)) {
                        t4VarS1.G(null);
                    }
                }
                k kVar212 = this.f5589c;
                R(kVar212);
                e6VarR = kVar212.R(zzqVar.f3976e);
                if (e6VarR == null) {
                    e6VarR = new e6(this.f5598l, zzqVar.f3976e);
                    e6VarR.j(i0(f6VarD));
                    e6VarR.x(zzqVar.f3986s);
                    e6VarR.y(zzqVar.f3977j);
                    if (f6VarD.j(zzhaVar)) {
                        e6VarR.H(this.f5595i.o(zzqVar.f3976e, zzqVar.f3990w));
                    }
                    e6VarR.D(0L);
                    e6VarR.E(0L);
                    e6VarR.C(0L);
                    e6VarR.l(zzqVar.f3978k);
                    e6VarR.m(zzqVar.f3985r);
                    e6VarR.k(zzqVar.f3979l);
                    e6VarR.z(zzqVar.f3980m);
                    e6VarR.u(zzqVar.f3981n);
                    e6VarR.F(zzqVar.f3983p);
                    e6VarR.v(zzqVar.A);
                    k kVar27 = this.f5589c;
                    R(kVar27);
                    kVar27.p(e6VarR);
                }
                if (f6VarD.j(zzha.ANALYTICS_STORAGE) && !TextUtils.isEmpty(e6VarR.m0())) {
                    t4VarS1.w((String) t1.f.h(e6VarR.m0()));
                }
                if (!TextUtils.isEmpty(e6VarR.p0())) {
                    t4VarS1.L((String) t1.f.h(e6VarR.p0()));
                }
                k kVar222 = this.f5589c;
                R(kVar222);
                listC0 = kVar222.c0(zzqVar.f3976e);
                for (i10 = 0; i10 < listC0.size(); i10++) {
                    com.google.android.gms.internal.measurement.c5 c5VarG = com.google.android.gms.internal.measurement.d5.G();
                    c5VarG.x(((ta) listC0.get(i10)).f5716c);
                    c5VarG.y(((ta) listC0.get(i10)).f5717d);
                    ra raVar5 = this.f5593g;
                    R(raVar5);
                    raVar5.M(c5VarG, ((ta) listC0.get(i10)).f5718e);
                    t4VarS1.y0(c5VarG);
                    if (U().B(null, i3.J0) && "_sid".equals(((ta) listC0.get(i10)).f5716c) && e6VarR.g0() != 0) {
                        ra raVar6 = this.f5593g;
                        R(raVar6);
                        if (raVar6.y(zzqVar.F) != e6VarR.g0()) {
                            t4VarS1.L0();
                        }
                    }
                }
                try {
                    kVar = this.f5589c;
                    R(kVar);
                    u4Var = (com.google.android.gms.internal.measurement.u4) t4VarS1.o();
                    kVar.h();
                    kVar.i();
                    t1.f.h(u4Var);
                    t1.f.d(u4Var.W1());
                    byte[] bArrI3 = u4Var.i();
                    ra raVar22 = kVar.f5039b.f5593g;
                    R(raVar22);
                    long jZ2 = raVar22.z(bArrI3);
                    ContentValues contentValues22 = new ContentValues();
                    contentValues22.put("app_id", u4Var.W1());
                    contentValues22.put("metadata_fingerprint", Long.valueOf(jZ2));
                    contentValues22.put("metadata", bArrI3);
                } catch (IOException e15) {
                    d().r().c("Data loss. Failed to insert raw event metadata. appId", v3.z(t4VarS1.j0()), e15);
                }
                try {
                    kVar.P().insertWithOnConflict("raw_events_metadata", null, contentValues22, 4);
                    kVar2 = this.f5589c;
                    R(kVar2);
                    rVar = new r(pVar.f5575f);
                    while (true) {
                        if (!rVar.hasNext()) {
                            if ("_r".equals(rVar.next())) {
                                break;
                            }
                        } else {
                            y4 y4Var4 = this.f5587a;
                            R(y4Var4);
                            boolean zE = y4Var4.E(pVar.f5570a, pVar.f5571b);
                            k kVar28 = this.f5589c;
                            R(kVar28);
                            i iVarT = kVar28.T(F(), pVar.f5570a, false, false, false, false, false);
                            if (!zE || iVarT.f5291e >= U().o(pVar.f5570a, i3.f5327q)) {
                                i11 = 0;
                            }
                        }
                    }
                    i11 = 1;
                    kVar2.h();
                    kVar2.i();
                    t1.f.h(pVar);
                    t1.f.d(pVar.f5570a);
                    ra raVar32 = kVar2.f5039b.f5593g;
                    R(raVar32);
                    byte[] bArrI22 = raVar32.D(pVar).i();
                    contentValues = new ContentValues();
                    contentValues.put("app_id", pVar.f5570a);
                    contentValues.put("name", pVar.f5571b);
                    contentValues.put("timestamp", Long.valueOf(pVar.f5573d));
                    contentValues.put("metadata_fingerprint", Long.valueOf(jZ2));
                    contentValues.put("data", bArrI22);
                    contentValues.put("realtime", Integer.valueOf(i11));
                    if (kVar2.P().insert("raw_events", null, contentValues) != -1) {
                        kVar2.f5030a.d().r().b("Failed to insert raw event (got -1). appId", v3.z(pVar.f5570a));
                    } else {
                        this.f5601o = 0L;
                    }
                    k kVar232 = this.f5589c;
                    R(kVar232);
                    kVar232.o();
                    k kVar242 = this.f5589c;
                    R(kVar242);
                    kVar242.f0();
                    M();
                    d().v().b("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j12) + 500000) / 1000000));
                } catch (SQLiteException e16) {
                    kVar.f5030a.d().r().c("Error storing raw event metadata. appId", v3.z(u4Var.W1()), e16);
                    throw e16;
                }
            } catch (Throwable th) {
                k kVar29 = this.f5589c;
                R(kVar29);
                kVar29.f0();
                throw th;
            }
        }
    }

    public final boolean E() throws IOException {
        f().h();
        FileLock fileLock = this.f5608v;
        if (fileLock != null && fileLock.isValid()) {
            d().v().a("Storage concurrent access okay");
            return true;
        }
        this.f5589c.f5030a.z();
        try {
            FileChannel channel = new RandomAccessFile(new File(this.f5598l.c().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.f5609w = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.f5608v = fileLockTryLock;
            if (fileLockTryLock != null) {
                d().v().a("Storage concurrent access okay");
                return true;
            }
            d().r().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e10) {
            d().r().b("Failed to acquire storage lock", e10);
            return false;
        } catch (IOException e11) {
            d().r().b("Failed to access storage lock file", e11);
            return false;
        } catch (OverlappingFileLockException e12) {
            d().w().b("Storage lock already acquired", e12);
            return false;
        }
    }

    public final long F() {
        long jA = a().a();
        g9 g9Var = this.f5595i;
        g9Var.i();
        g9Var.h();
        long jA2 = g9Var.f5221i.a();
        if (jA2 == 0) {
            jA2 = g9Var.f5030a.N().u().nextInt(86400000) + 1;
            g9Var.f5221i.b(jA2);
        }
        return ((((jA + jA2) / 1000) / 60) / 60) / 24;
    }

    public final zzq I(String str) {
        k kVar = this.f5589c;
        R(kVar);
        e6 e6VarR = kVar.R(str);
        if (e6VarR == null || TextUtils.isEmpty(e6VarR.o0())) {
            d().q().b("No app data available; dropping", str);
            return null;
        }
        Boolean boolJ = J(e6VarR);
        if (boolJ != null && !boolJ.booleanValue()) {
            d().r().b("App version does not match; dropping. appId", v3.z(str));
            return null;
        }
        String strA = e6VarR.a();
        String strO0 = e6VarR.o0();
        long jR = e6VarR.R();
        String strN0 = e6VarR.n0();
        long jC0 = e6VarR.c0();
        long jZ = e6VarR.Z();
        boolean zO = e6VarR.O();
        String strP0 = e6VarR.p0();
        e6VarR.A();
        return new zzq(str, strA, strO0, jR, strN0, jC0, jZ, (String) null, zO, false, strP0, 0L, 0L, 0, e6VarR.N(), false, e6VarR.j0(), e6VarR.i0(), e6VarR.a0(), e6VarR.e(), (String) null, c0(str).i(), "", (String) null, e6VarR.Q(), e6VarR.h0());
    }

    public final Boolean J(e6 e6Var) {
        try {
            if (e6Var.R() != -2147483648L) {
                if (e6Var.R() == x1.e.a(this.f5598l.c()).c(e6Var.l0(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = x1.e.a(this.f5598l.c()).c(e6Var.l0(), 0).versionName;
                String strO0 = e6Var.o0();
                if (strO0 != null && strO0.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final void K() {
        f().h();
        if (this.f5605s || this.f5606t || this.f5607u) {
            d().v().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f5605s), Boolean.valueOf(this.f5606t), Boolean.valueOf(this.f5607u));
            return;
        }
        d().v().a("Stopping uploading service(s)");
        List list = this.f5602p;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) t1.f.h(this.f5602p)).clear();
    }

    public final void L(com.google.android.gms.internal.measurement.t4 t4Var, long j10, boolean z10) {
        k kVar = this.f5589c;
        R(kVar);
        String str = true != z10 ? "_lte" : "_se";
        ta taVarX = kVar.X(t4Var.j0(), str);
        ta taVar = (taVarX == null || taVarX.f5718e == null) ? new ta(t4Var.j0(), "auto", str, a().a(), Long.valueOf(j10)) : new ta(t4Var.j0(), "auto", str, a().a(), Long.valueOf(((Long) taVarX.f5718e).longValue() + j10));
        com.google.android.gms.internal.measurement.c5 c5VarG = com.google.android.gms.internal.measurement.d5.G();
        c5VarG.x(str);
        c5VarG.y(a().a());
        c5VarG.w(((Long) taVar.f5718e).longValue());
        com.google.android.gms.internal.measurement.d5 d5Var = (com.google.android.gms.internal.measurement.d5) c5VarG.o();
        int iX = ra.x(t4Var, str);
        if (iX >= 0) {
            t4Var.g0(iX, d5Var);
        } else {
            t4Var.z0(d5Var);
        }
        if (j10 > 0) {
            k kVar2 = this.f5589c;
            R(kVar2);
            kVar2.x(taVar);
            d().v().c("Updated engagement user property. scope, value", true != z10 ? "lifetime" : "session-scoped", taVar.f5718e);
        }
    }

    public final void M() {
        long jMax;
        long jMax2;
        f().h();
        g();
        if (this.f5601o > 0) {
            long jAbs = 3600000 - Math.abs(a().b() - this.f5601o);
            if (jAbs > 0) {
                d().v().b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                Y().c();
                z9 z9Var = this.f5591e;
                R(z9Var);
                z9Var.m();
                return;
            }
            this.f5601o = 0L;
        }
        if (!this.f5598l.r() || !O()) {
            d().v().a("Nothing to upload or uploading impossible");
            Y().c();
            z9 z9Var2 = this.f5591e;
            R(z9Var2);
            z9Var2.m();
            return;
        }
        long jA = a().a();
        U();
        long jMax3 = Math.max(0L, ((Long) i3.C.a(null)).longValue());
        k kVar = this.f5589c;
        R(kVar);
        boolean z10 = true;
        if (!kVar.t()) {
            k kVar2 = this.f5589c;
            R(kVar2);
            if (!kVar2.s()) {
                z10 = false;
            }
        }
        if (z10) {
            String strU = U().u();
            if (TextUtils.isEmpty(strU) || ".none.".equals(strU)) {
                U();
                jMax = Math.max(0L, ((Long) i3.f5339w.a(null)).longValue());
            } else {
                U();
                jMax = Math.max(0L, ((Long) i3.f5341x.a(null)).longValue());
            }
        } else {
            U();
            jMax = Math.max(0L, ((Long) i3.f5337v.a(null)).longValue());
        }
        long jA2 = this.f5595i.f5219g.a();
        long jA3 = this.f5595i.f5220h.a();
        k kVar3 = this.f5589c;
        R(kVar3);
        long j10 = 0;
        long jM = kVar3.M();
        k kVar4 = this.f5589c;
        R(kVar4);
        boolean z11 = z10;
        long jMax4 = Math.max(jM, kVar4.N());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jA - Math.abs(jMax4 - jA);
            long jAbs3 = jA - Math.abs(jA2 - jA);
            long jAbs4 = jA - Math.abs(jA3 - jA);
            jMax2 = jMax3 + jAbs2;
            long jMax5 = Math.max(jAbs3, jAbs4);
            if (z11 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            ra raVar = this.f5593g;
            R(raVar);
            if (!raVar.O(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i10 = 0;
                while (true) {
                    U();
                    if (i10 >= Math.min(20, Math.max(0, ((Integer) i3.E.a(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    U();
                    jMax2 += Math.max(j10, ((Long) i3.D.a(null)).longValue()) * (1 << i10);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                    i10++;
                    j10 = 0;
                }
            }
            j10 = 0;
        }
        if (jMax2 == j10) {
            d().v().a("Next upload time is 0");
            Y().c();
            z9 z9Var3 = this.f5591e;
            R(z9Var3);
            z9Var3.m();
            return;
        }
        b4 b4Var = this.f5588b;
        R(b4Var);
        if (!b4Var.m()) {
            d().v().a("No network");
            Y().b();
            z9 z9Var4 = this.f5591e;
            R(z9Var4);
            z9Var4.m();
            return;
        }
        long jA4 = this.f5595i.f5218f.a();
        U();
        long jMax6 = Math.max(0L, ((Long) i3.f5333t.a(null)).longValue());
        ra raVar2 = this.f5593g;
        R(raVar2);
        if (!raVar2.O(jA4, jMax6)) {
            jMax2 = Math.max(jMax2, jA4 + jMax6);
        }
        Y().c();
        long jA5 = jMax2 - a().a();
        if (jA5 <= 0) {
            U();
            jA5 = Math.max(0L, ((Long) i3.f5343y.a(null)).longValue());
            this.f5595i.f5219g.b(a().a());
        }
        d().v().b("Upload scheduled in approximately ms", Long.valueOf(jA5));
        z9 z9Var5 = this.f5591e;
        R(z9Var5);
        z9Var5.n(jA5);
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0464 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04a4 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0543 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x07f9 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x082d A[PHI: r14
  0x082d: PHI (r14v9 long) = (r14v8 long), (r14v22 long) binds: [B:258:0x07f7, B:450:0x082d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0844 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0867 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x08c7 A[PHI: r10
  0x08c7: PHI (r10v10 f2.q) = (r10v9 f2.q), (r10v17 f2.q) binds: [B:274:0x0871, B:276:0x0886] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0b44 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0365 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x037e A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0399 A[Catch: all -> 0x00ef, TryCatch #4 {all -> 0x00ef, blocks: (B:3:0x0014, B:5:0x002b, B:8:0x0033, B:9:0x0046, B:12:0x0056, B:15:0x0081, B:17:0x00b7, B:20:0x00c9, B:22:0x00d3, B:159:0x0509, B:26:0x0100, B:28:0x010e, B:31:0x012e, B:33:0x0134, B:35:0x0146, B:37:0x0154, B:39:0x0164, B:40:0x0171, B:41:0x0176, B:44:0x018f, B:54:0x01c7, B:57:0x01d1, B:59:0x01df, B:64:0x022a, B:60:0x01fe, B:62:0x020e, B:68:0x0235, B:71:0x0268, B:72:0x0292, B:74:0x02cc, B:76:0x02d2, B:99:0x0399, B:100:0x03a5, B:103:0x03b1, B:109:0x03d4, B:106:0x03c3, B:132:0x0458, B:134:0x0464, B:137:0x0477, B:139:0x0488, B:141:0x0494, B:158:0x04f5, B:145:0x04a4, B:147:0x04b0, B:150:0x04c5, B:152:0x04d6, B:154:0x04e2, B:113:0x03de, B:115:0x03ea, B:117:0x03f6, B:130:0x043c, B:122:0x0414, B:125:0x0426, B:127:0x042c, B:129:0x0436, B:79:0x02de, B:81:0x0314, B:82:0x032f, B:84:0x0335, B:86:0x0343, B:90:0x0356, B:87:0x034b, B:93:0x035d, B:96:0x0365, B:97:0x037e, B:162:0x0522, B:164:0x0530, B:166:0x053b, B:177:0x056d, B:167:0x0543, B:169:0x054e, B:171:0x0554, B:174:0x0560, B:176:0x0568, B:178:0x0570, B:179:0x057c, B:182:0x0584, B:184:0x0596, B:185:0x05a2, B:187:0x05aa, B:191:0x05cf, B:193:0x05f4, B:195:0x0605, B:197:0x060b, B:199:0x0617, B:200:0x0646, B:202:0x064c, B:204:0x065a, B:205:0x065e, B:206:0x0661, B:207:0x0664, B:208:0x0672, B:210:0x0678, B:212:0x0688, B:213:0x068f, B:215:0x069b, B:216:0x06a2, B:217:0x06a5, B:219:0x06e5, B:220:0x06f8, B:222:0x06fe, B:225:0x0719, B:227:0x0734, B:229:0x074b, B:231:0x0750, B:233:0x0754, B:235:0x0758, B:237:0x0762, B:239:0x076f, B:241:0x0773, B:243:0x0779, B:245:0x0786, B:247:0x0794, B:316:0x09d1, B:249:0x079f, B:251:0x07ba, B:257:0x07dd, B:259:0x07f9, B:260:0x0801, B:262:0x0807, B:264:0x0819, B:270:0x082f, B:272:0x0844, B:273:0x0867, B:275:0x0873, B:277:0x0888, B:279:0x08c9, B:285:0x08e5, B:287:0x08f0, B:289:0x08f4, B:291:0x08f8, B:293:0x08fc, B:294:0x0908, B:295:0x0913, B:297:0x0919, B:299:0x0933, B:300:0x0938, B:315:0x09ce, B:301:0x094f, B:303:0x0955, B:307:0x097e, B:309:0x09a2, B:310:0x09a9, B:314:0x09bf, B:304:0x0965, B:254:0x07c2, B:317:0x09dc, B:319:0x09eb, B:320:0x09f1, B:321:0x09f9, B:323:0x09ff, B:326:0x0a1a, B:328:0x0a2b, B:348:0x0a9b, B:350:0x0aa1, B:352:0x0ab9, B:355:0x0ac0, B:360:0x0aef, B:362:0x0b32, B:365:0x0b67, B:366:0x0b6b, B:367:0x0b76, B:369:0x0bb9, B:370:0x0bc6, B:372:0x0bd5, B:375:0x0bee, B:377:0x0c07, B:364:0x0b44, B:356:0x0ac8, B:358:0x0ad4, B:359:0x0ad8, B:378:0x0c1e, B:379:0x0c36, B:382:0x0c3e, B:383:0x0c43, B:384:0x0c53, B:386:0x0c6d, B:387:0x0c88, B:388:0x0c91, B:392:0x0caf, B:391:0x0c9c, B:329:0x0a43, B:331:0x0a49, B:333:0x0a51, B:335:0x0a58, B:341:0x0a66, B:343:0x0a6d, B:345:0x0a8c, B:347:0x0a93, B:346:0x0a90, B:342:0x0a6a, B:334:0x0a55, B:188:0x05af, B:190:0x05b5, B:395:0x0cc2), top: B:409:0x0014, inners: #0, #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean N(String str, long j10) {
        int i10;
        long j11;
        com.google.android.gms.internal.measurement.t4 t4Var;
        Long l10;
        long j12;
        long j13;
        long j14;
        int iR;
        Long l11;
        com.google.android.gms.internal.measurement.t4 t4Var2;
        int i11;
        Long l12;
        ma maVar;
        long jU0;
        int i12;
        String str2;
        boolean z10;
        Long l13;
        int i13;
        String str3;
        int i14;
        int i15;
        int i16;
        boolean z11;
        String str4;
        int i17;
        String str5 = "_ai";
        Long l14 = 1L;
        k kVar = this.f5589c;
        R(kVar);
        kVar.e0();
        try {
            ma maVar2 = new ma(this, null);
            k kVar2 = this.f5589c;
            R(kVar2);
            kVar2.G(null, j10, this.f5612z, maVar2);
            List list = maVar2.f5510c;
            if (list != null && !list.isEmpty()) {
                com.google.android.gms.internal.measurement.t4 t4Var3 = (com.google.android.gms.internal.measurement.t4) maVar2.f5508a.m();
                t4Var3.E0();
                com.google.android.gms.internal.measurement.i4 i4Var = null;
                com.google.android.gms.internal.measurement.i4 i4Var2 = null;
                int i18 = -1;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = -1;
                while (true) {
                    i10 = i20;
                    if (i19 >= maVar2.f5510c.size()) {
                        break;
                    }
                    com.google.android.gms.internal.measurement.i4 i4Var3 = (com.google.android.gms.internal.measurement.i4) ((com.google.android.gms.internal.measurement.j4) maVar2.f5510c.get(i19)).m();
                    y4 y4Var = this.f5587a;
                    R(y4Var);
                    int i23 = i21;
                    com.google.android.gms.internal.measurement.i4 i4Var4 = i4Var;
                    if (y4Var.F(maVar2.f5508a.W1(), i4Var3.G())) {
                        d().w().c("Dropping blocked raw event. appId", v3.z(maVar2.f5508a.W1()), this.f5598l.D().d(i4Var3.G()));
                        y4 y4Var2 = this.f5587a;
                        R(y4Var2);
                        if (!y4Var2.D(maVar2.f5508a.W1())) {
                            y4 y4Var3 = this.f5587a;
                            R(y4Var3);
                            if (!y4Var3.G(maVar2.f5508a.W1()) && !"_err".equals(i4Var3.G())) {
                                h0().C(this.E, maVar2.f5508a.W1(), 11, "_ev", i4Var3.G(), 0);
                            }
                        }
                        str2 = str5;
                        l13 = l14;
                        i16 = i19;
                        i20 = i10;
                        i21 = i23;
                        i4Var = i4Var4;
                    } else {
                        if (i4Var3.G().equals(g6.a(str5))) {
                            i4Var3.A(str5);
                            d().v().a("Renaming ad_impression to _ai");
                            if (Log.isLoggable(d().D(), 5)) {
                                int i24 = 0;
                                while (i24 < i4Var3.s()) {
                                    String str6 = str5;
                                    if ("ad_platform".equals(i4Var3.F(i24).J()) && !i4Var3.F(i24).K().isEmpty() && "admob".equalsIgnoreCase(i4Var3.F(i24).K())) {
                                        d().x().a("AdMob ad impression logged from app. Potentially duplicative.");
                                    }
                                    i24++;
                                    str5 = str6;
                                }
                            }
                        }
                        str2 = str5;
                        y4 y4Var4 = this.f5587a;
                        R(y4Var4);
                        boolean zE = y4Var4.E(maVar2.f5508a.W1(), i4Var3.G());
                        if (zE) {
                            z10 = zE;
                            l13 = l14;
                        } else {
                            R(this.f5593g);
                            String strG = i4Var3.G();
                            t1.f.d(strG);
                            z10 = zE;
                            l13 = l14;
                            if (strG.hashCode() != 95027 || !strG.equals("_ui")) {
                                str3 = "_et";
                                i14 = i19;
                                i13 = i22;
                                z10 = false;
                            }
                            int i25 = i23;
                            if (z10) {
                                i15 = i25;
                            } else {
                                ArrayList arrayList = new ArrayList(i4Var3.H());
                                int i26 = 0;
                                int i27 = -1;
                                int i28 = -1;
                                while (true) {
                                    i15 = i25;
                                    if (i26 >= arrayList.size()) {
                                        break;
                                    }
                                    if ("value".equals(((com.google.android.gms.internal.measurement.n4) arrayList.get(i26)).J())) {
                                        i27 = i26;
                                    } else if ("currency".equals(((com.google.android.gms.internal.measurement.n4) arrayList.get(i26)).J())) {
                                        i28 = i26;
                                    }
                                    i26++;
                                    i25 = i15;
                                }
                                if (i27 != -1) {
                                    if (((com.google.android.gms.internal.measurement.n4) arrayList.get(i27)).Y() || ((com.google.android.gms.internal.measurement.n4) arrayList.get(i27)).W()) {
                                        if (i28 != -1) {
                                            String strK = ((com.google.android.gms.internal.measurement.n4) arrayList.get(i28)).K();
                                            if (strK.length() == 3) {
                                                int iCharCount = 0;
                                                while (iCharCount < strK.length()) {
                                                    int iCodePointAt = strK.codePointAt(iCharCount);
                                                    if (Character.isLetter(iCodePointAt)) {
                                                        iCharCount += Character.charCount(iCodePointAt);
                                                    }
                                                }
                                            }
                                        }
                                        d().x().a("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                        i4Var3.z(i27);
                                        H(i4Var3, "_c");
                                        G(i4Var3, 19, "currency");
                                        break;
                                    }
                                    d().x().a("Value must be specified with a numeric type.");
                                    i4Var3.z(i27);
                                    H(i4Var3, "_c");
                                    G(i4Var3, 18, "value");
                                }
                                if ("_e".equals(i4Var3.G())) {
                                    R(this.f5593g);
                                    if (ra.o((com.google.android.gms.internal.measurement.j4) i4Var3.o(), "_fr") == null) {
                                        if (i4Var2 != null && Math.abs(i4Var2.u() - i4Var3.u()) <= 1000) {
                                            com.google.android.gms.internal.measurement.i4 i4Var5 = (com.google.android.gms.internal.measurement.i4) i4Var2.clone();
                                            if (P(i4Var3, i4Var5)) {
                                                t4Var3.K(i18, i4Var5);
                                                i22 = i13;
                                                i4Var = null;
                                                i4Var2 = null;
                                                i16 = i14;
                                                maVar2.f5510c.set(i16, (com.google.android.gms.internal.measurement.j4) i4Var3.o());
                                                i20 = i10 + 1;
                                                t4Var3.x0(i4Var3);
                                                i21 = i15;
                                            }
                                        }
                                        i4Var = i4Var3;
                                        i22 = i10;
                                        i16 = i14;
                                        maVar2.f5510c.set(i16, (com.google.android.gms.internal.measurement.j4) i4Var3.o());
                                        i20 = i10 + 1;
                                        t4Var3.x0(i4Var3);
                                        i21 = i15;
                                    }
                                    i22 = i13;
                                    i4Var = i4Var4;
                                    i16 = i14;
                                    maVar2.f5510c.set(i16, (com.google.android.gms.internal.measurement.j4) i4Var3.o());
                                    i20 = i10 + 1;
                                    t4Var3.x0(i4Var3);
                                    i21 = i15;
                                } else if ("_vs".equals(i4Var3.G())) {
                                    R(this.f5593g);
                                    if (ra.o((com.google.android.gms.internal.measurement.j4) i4Var3.o(), str3) == null) {
                                        if (i4Var4 != null && Math.abs(i4Var4.u() - i4Var3.u()) <= 1000) {
                                            com.google.android.gms.internal.measurement.i4 i4Var6 = (com.google.android.gms.internal.measurement.i4) i4Var4.clone();
                                            if (P(i4Var6, i4Var3)) {
                                                int i29 = i13;
                                                t4Var3.K(i29, i4Var6);
                                                i22 = i29;
                                                i4Var = null;
                                                i4Var2 = null;
                                                i16 = i14;
                                                maVar2.f5510c.set(i16, (com.google.android.gms.internal.measurement.j4) i4Var3.o());
                                                i20 = i10 + 1;
                                                t4Var3.x0(i4Var3);
                                                i21 = i15;
                                            }
                                        }
                                        i4Var2 = i4Var3;
                                        i22 = i13;
                                        i18 = i10;
                                    } else {
                                        i22 = i13;
                                    }
                                    i4Var = i4Var4;
                                    i16 = i14;
                                    maVar2.f5510c.set(i16, (com.google.android.gms.internal.measurement.j4) i4Var3.o());
                                    i20 = i10 + 1;
                                    t4Var3.x0(i4Var3);
                                    i21 = i15;
                                }
                            }
                            if ("_e".equals(i4Var3.G())) {
                            }
                        }
                        int i30 = 0;
                        boolean z12 = false;
                        boolean z13 = false;
                        while (true) {
                            z11 = z12;
                            if (i30 >= i4Var3.s()) {
                                break;
                            }
                            if ("_c".equals(i4Var3.F(i30).J())) {
                                com.google.android.gms.internal.measurement.m4 m4Var = (com.google.android.gms.internal.measurement.m4) i4Var3.F(i30).m();
                                i17 = i22;
                                m4Var.A(1L);
                                i4Var3.C(i30, (com.google.android.gms.internal.measurement.n4) m4Var.o());
                                z12 = z11;
                                z13 = true;
                            } else {
                                i17 = i22;
                                if ("_r".equals(i4Var3.F(i30).J())) {
                                    com.google.android.gms.internal.measurement.m4 m4Var2 = (com.google.android.gms.internal.measurement.m4) i4Var3.F(i30).m();
                                    m4Var2.A(1L);
                                    i4Var3.C(i30, (com.google.android.gms.internal.measurement.n4) m4Var2.o());
                                    z12 = true;
                                } else {
                                    z12 = z11;
                                }
                            }
                            i30++;
                            i22 = i17;
                        }
                        i13 = i22;
                        if (z13 || !z10) {
                            str4 = "_et";
                            i14 = i19;
                        } else {
                            i14 = i19;
                            d().v().b("Marking event as conversion", this.f5598l.D().d(i4Var3.G()));
                            com.google.android.gms.internal.measurement.m4 m4VarH = com.google.android.gms.internal.measurement.n4.H();
                            m4VarH.B("_c");
                            str4 = "_et";
                            m4VarH.A(1L);
                            i4Var3.w(m4VarH);
                        }
                        if (!z11) {
                            d().v().b("Marking event as real-time", this.f5598l.D().d(i4Var3.G()));
                            com.google.android.gms.internal.measurement.m4 m4VarH2 = com.google.android.gms.internal.measurement.n4.H();
                            m4VarH2.B("_r");
                            m4VarH2.A(1L);
                            i4Var3.w(m4VarH2);
                        }
                        k kVar3 = this.f5589c;
                        R(kVar3);
                        str3 = str4;
                        if (kVar3.T(F(), maVar2.f5508a.W1(), false, false, false, false, true).f5291e > U().o(maVar2.f5508a.W1(), i3.f5327q)) {
                            H(i4Var3, "_r");
                        } else {
                            i23 = 1;
                        }
                        if (wa.Z(i4Var3.G()) && z10) {
                            k kVar4 = this.f5589c;
                            R(kVar4);
                            if (kVar4.T(F(), maVar2.f5508a.W1(), false, false, true, false, false).f5289c > U().o(maVar2.f5508a.W1(), i3.f5325p)) {
                                d().w().b("Too many conversions. Not logging as conversion. appId", v3.z(maVar2.f5508a.W1()));
                                com.google.android.gms.internal.measurement.m4 m4Var3 = null;
                                boolean z14 = false;
                                int i31 = -1;
                                for (int i32 = 0; i32 < i4Var3.s(); i32++) {
                                    com.google.android.gms.internal.measurement.n4 n4VarF = i4Var3.F(i32);
                                    if ("_c".equals(n4VarF.J())) {
                                        m4Var3 = (com.google.android.gms.internal.measurement.m4) n4VarF.m();
                                        i31 = i32;
                                    } else if ("_err".equals(n4VarF.J())) {
                                        z14 = true;
                                    }
                                }
                                if (z14) {
                                    if (m4Var3 != null) {
                                        i4Var3.z(i31);
                                    } else {
                                        m4Var3 = null;
                                        if (m4Var3 == null) {
                                        }
                                    }
                                } else if (m4Var3 == null) {
                                    com.google.android.gms.internal.measurement.m4 m4Var4 = (com.google.android.gms.internal.measurement.m4) m4Var3.clone();
                                    m4Var4.B("_err");
                                    m4Var4.A(10L);
                                    i4Var3.C(i31, (com.google.android.gms.internal.measurement.n4) m4Var4.o());
                                } else {
                                    d().r().b("Did not find conversion parameter. appId", v3.z(maVar2.f5508a.W1()));
                                }
                            }
                        }
                        int i252 = i23;
                        if (z10) {
                        }
                        if ("_e".equals(i4Var3.G())) {
                        }
                    }
                    i19 = i16 + 1;
                    str5 = str2;
                    l14 = l13;
                }
                Long l15 = l14;
                int i33 = i21;
                long j15 = 0;
                long jLongValue = 0;
                int i34 = i10;
                int i35 = 0;
                while (i35 < i34) {
                    com.google.android.gms.internal.measurement.j4 j4VarR0 = t4Var3.r0(i35);
                    if ("_e".equals(j4VarR0.K())) {
                        R(this.f5593g);
                        if (ra.o(j4VarR0, "_fr") != null) {
                            t4Var3.s(i35);
                            i34--;
                            i35--;
                        } else {
                            R(this.f5593g);
                            com.google.android.gms.internal.measurement.n4 n4VarO = ra.o(j4VarR0, "_et");
                            if (n4VarO != null) {
                                Long lValueOf = n4VarO.Y() ? Long.valueOf(n4VarO.G()) : null;
                                if (lValueOf != null && lValueOf.longValue() > 0) {
                                    jLongValue += lValueOf.longValue();
                                }
                            }
                        }
                    }
                    i35++;
                }
                L(t4Var3, jLongValue, false);
                Iterator it = t4Var3.m0().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if ("_s".equals(((com.google.android.gms.internal.measurement.j4) it.next()).K())) {
                        k kVar5 = this.f5589c;
                        R(kVar5);
                        kVar5.m(t4Var3.j0(), "_se");
                        break;
                    }
                }
                if (ra.x(t4Var3, "_sid") >= 0) {
                    L(t4Var3, jLongValue, true);
                } else {
                    int iX = ra.x(t4Var3, "_se");
                    if (iX >= 0) {
                        t4Var3.t(iX);
                        d().r().b("Session engagement user property is in the bundle without session ID. appId", v3.z(maVar2.f5508a.W1()));
                    }
                }
                ra raVar = this.f5593g;
                R(raVar);
                raVar.f5030a.d().v().a("Checking account type status for ad personalization signals");
                y4 y4Var5 = raVar.f5039b.f5587a;
                R(y4Var5);
                if (y4Var5.B(t4Var3.j0())) {
                    k kVar6 = raVar.f5039b.f5589c;
                    R(kVar6);
                    e6 e6VarR = kVar6.R(t4Var3.j0());
                    if (e6VarR != null && e6VarR.N() && raVar.f5030a.A().s()) {
                        raVar.f5030a.d().q().a("Turning off ad personalization due to account type");
                        com.google.android.gms.internal.measurement.c5 c5VarG = com.google.android.gms.internal.measurement.d5.G();
                        c5VarG.x("_npa");
                        c5VarG.y(raVar.f5030a.A().o());
                        c5VarG.w(1L);
                        com.google.android.gms.internal.measurement.d5 d5Var = (com.google.android.gms.internal.measurement.d5) c5VarG.o();
                        int i36 = 0;
                        while (true) {
                            if (i36 >= t4Var3.o0()) {
                                t4Var3.z0(d5Var);
                                break;
                            }
                            if ("_npa".equals(t4Var3.i0(i36).I())) {
                                t4Var3.g0(i36, d5Var);
                                break;
                            }
                            i36++;
                        }
                    }
                }
                t4Var3.b0(Long.MAX_VALUE);
                t4Var3.I(Long.MIN_VALUE);
                for (int i37 = 0; i37 < t4Var3.S(); i37++) {
                    com.google.android.gms.internal.measurement.j4 j4VarR02 = t4Var3.r0(i37);
                    if (j4VarR02.G() < t4Var3.q0()) {
                        t4Var3.b0(j4VarR02.G());
                    }
                    if (j4VarR02.G() > t4Var3.p0()) {
                        t4Var3.I(j4VarR02.G());
                    }
                }
                t4Var3.M0();
                t4Var3.B0();
                b bVar = this.f5592f;
                R(bVar);
                t4Var3.s0(bVar.m(t4Var3.j0(), t4Var3.m0(), t4Var3.n0(), Long.valueOf(t4Var3.q0()), Long.valueOf(t4Var3.p0())));
                if (U().F(maVar2.f5508a.W1())) {
                    HashMap map = new HashMap();
                    ArrayList arrayList2 = new ArrayList();
                    SecureRandom secureRandomU = h0().u();
                    int i38 = 0;
                    while (i38 < t4Var3.S()) {
                        com.google.android.gms.internal.measurement.i4 i4Var7 = (com.google.android.gms.internal.measurement.i4) t4Var3.r0(i38).m();
                        if (i4Var7.G().equals("_ep")) {
                            R(this.f5593g);
                            String str7 = (String) ra.p((com.google.android.gms.internal.measurement.j4) i4Var7.o(), "_en");
                            q qVarV = (q) map.get(str7);
                            if (qVarV == null) {
                                k kVar7 = this.f5589c;
                                R(kVar7);
                                qVarV = kVar7.V(maVar2.f5508a.W1(), (String) t1.f.h(str7));
                                if (qVarV != null) {
                                    map.put(str7, qVarV);
                                }
                            }
                            if (qVarV == null || qVarV.f5621i != null) {
                                l10 = l15;
                            } else {
                                Long l16 = qVarV.f5622j;
                                if (l16 != null && l16.longValue() > 1) {
                                    R(this.f5593g);
                                    ra.m(i4Var7, "_sr", qVarV.f5622j);
                                }
                                Boolean bool = qVarV.f5623k;
                                if (bool == null || !bool.booleanValue()) {
                                    l10 = l15;
                                } else {
                                    R(this.f5593g);
                                    l10 = l15;
                                    ra.m(i4Var7, "_efs", l10);
                                }
                                arrayList2.add((com.google.android.gms.internal.measurement.j4) i4Var7.o());
                            }
                            t4Var3.K(i38, i4Var7);
                            j12 = j15;
                        } else {
                            l10 = l15;
                            y4 y4Var6 = this.f5587a;
                            R(y4Var6);
                            String strW1 = maVar2.f5508a.W1();
                            String strE = y4Var6.e(strW1, "measurement.account.time_zone_offset_minutes");
                            if (TextUtils.isEmpty(strE)) {
                                j12 = j15;
                            } else {
                                try {
                                    j13 = Long.parseLong(strE);
                                    j12 = j15;
                                } catch (NumberFormatException e10) {
                                    j12 = j15;
                                    y4Var6.f5030a.d().w().c("Unable to parse timezone offset. appId", v3.z(strW1), e10);
                                }
                                long jU02 = h0().u0(i4Var7.u(), j13);
                                com.google.android.gms.internal.measurement.j4 j4Var = (com.google.android.gms.internal.measurement.j4) i4Var7.o();
                                if (TextUtils.isEmpty("_dbg")) {
                                    for (com.google.android.gms.internal.measurement.n4 n4Var : j4Var.L()) {
                                        j14 = j13;
                                        if (!"_dbg".equals(n4Var.J())) {
                                            j13 = j14;
                                        } else if (l10.equals(Long.valueOf(n4Var.G()))) {
                                            iR = 1;
                                            if (iR > 0) {
                                            }
                                        } else {
                                            y4 y4Var7 = this.f5587a;
                                            R(y4Var7);
                                            iR = y4Var7.r(maVar2.f5508a.W1(), i4Var7.G());
                                            if (iR > 0) {
                                                d().w().c("Sample rate must be positive. event, rate", i4Var7.G(), Integer.valueOf(iR));
                                                arrayList2.add((com.google.android.gms.internal.measurement.j4) i4Var7.o());
                                                t4Var3.K(i38, i4Var7);
                                            } else {
                                                q qVarA = (q) map.get(i4Var7.G());
                                                if (qVarA == null) {
                                                    k kVar8 = this.f5589c;
                                                    R(kVar8);
                                                    qVarA = kVar8.V(maVar2.f5508a.W1(), i4Var7.G());
                                                    if (qVarA == null) {
                                                        l11 = l10;
                                                        d().w().c("Event being bundled has no eventAggregate. appId, eventName", maVar2.f5508a.W1(), i4Var7.G());
                                                        qVarA = new q(maVar2.f5508a.W1(), i4Var7.G(), 1L, 1L, 1L, i4Var7.u(), 0L, null, null, null, null);
                                                    } else {
                                                        l11 = l10;
                                                    }
                                                    R(this.f5593g);
                                                    Long l17 = (Long) ra.p((com.google.android.gms.internal.measurement.j4) i4Var7.o(), "_eid");
                                                    boolean z15 = l17 != null;
                                                    if (iR == 1) {
                                                        arrayList2.add((com.google.android.gms.internal.measurement.j4) i4Var7.o());
                                                        if (z15 && (qVarA.f5621i != null || qVarA.f5622j != null || qVarA.f5623k != null)) {
                                                            map.put(i4Var7.G(), qVarA.a(null, null, null));
                                                        }
                                                        t4Var3.K(i38, i4Var7);
                                                        t4Var2 = t4Var3;
                                                        i12 = i38;
                                                        maVar = maVar2;
                                                        l10 = l11;
                                                    } else {
                                                        if (secureRandomU.nextInt(iR) == 0) {
                                                            R(this.f5593g);
                                                            boolean z16 = z15;
                                                            Long lValueOf2 = Long.valueOf(iR);
                                                            ra.m(i4Var7, "_sr", lValueOf2);
                                                            arrayList2.add((com.google.android.gms.internal.measurement.j4) i4Var7.o());
                                                            if (z16) {
                                                                qVarA = qVarA.a(null, lValueOf2, null);
                                                            }
                                                            map.put(i4Var7.G(), qVarA.b(i4Var7.u(), jU02));
                                                            t4Var2 = t4Var3;
                                                            i12 = i38;
                                                            maVar = maVar2;
                                                            l10 = l11;
                                                        } else {
                                                            boolean z17 = z15;
                                                            Long l18 = qVarA.f5620h;
                                                            if (l18 != null) {
                                                                i11 = i38;
                                                                l12 = l17;
                                                                maVar = maVar2;
                                                                t4Var2 = t4Var3;
                                                                jU0 = l18.longValue();
                                                            } else {
                                                                t4Var2 = t4Var3;
                                                                i11 = i38;
                                                                l12 = l17;
                                                                maVar = maVar2;
                                                                jU0 = h0().u0(i4Var7.t(), j14);
                                                            }
                                                            if (jU0 != jU02) {
                                                                R(this.f5593g);
                                                                l10 = l11;
                                                                ra.m(i4Var7, "_efs", l10);
                                                                R(this.f5593g);
                                                                Long lValueOf3 = Long.valueOf(iR);
                                                                ra.m(i4Var7, "_sr", lValueOf3);
                                                                arrayList2.add((com.google.android.gms.internal.measurement.j4) i4Var7.o());
                                                                if (z17) {
                                                                    qVarA = qVarA.a(null, lValueOf3, Boolean.TRUE);
                                                                }
                                                                map.put(i4Var7.G(), qVarA.b(i4Var7.u(), jU02));
                                                            } else {
                                                                l10 = l11;
                                                                if (z17) {
                                                                    map.put(i4Var7.G(), qVarA.a(l12, null, null));
                                                                }
                                                            }
                                                            i12 = i11;
                                                        }
                                                        t4Var2.K(i12, i4Var7);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j14 = j13;
                                    y4 y4Var72 = this.f5587a;
                                    R(y4Var72);
                                    iR = y4Var72.r(maVar2.f5508a.W1(), i4Var7.G());
                                    if (iR > 0) {
                                    }
                                } else {
                                    j14 = j13;
                                    y4 y4Var722 = this.f5587a;
                                    R(y4Var722);
                                    iR = y4Var722.r(maVar2.f5508a.W1(), i4Var7.G());
                                    if (iR > 0) {
                                    }
                                }
                                i38 = i12 + 1;
                                l15 = l10;
                                t4Var3 = t4Var2;
                                j15 = j12;
                                maVar2 = maVar;
                            }
                            j13 = j12;
                            long jU022 = h0().u0(i4Var7.u(), j13);
                            com.google.android.gms.internal.measurement.j4 j4Var2 = (com.google.android.gms.internal.measurement.j4) i4Var7.o();
                            if (TextUtils.isEmpty("_dbg")) {
                            }
                            i38 = i12 + 1;
                            l15 = l10;
                            t4Var3 = t4Var2;
                            j15 = j12;
                            maVar2 = maVar;
                        }
                        t4Var2 = t4Var3;
                        i12 = i38;
                        maVar = maVar2;
                        i38 = i12 + 1;
                        l15 = l10;
                        t4Var3 = t4Var2;
                        j15 = j12;
                        maVar2 = maVar;
                    }
                    j11 = j15;
                    t4Var = t4Var3;
                    ma maVar3 = maVar2;
                    if (arrayList2.size() < t4Var.S()) {
                        t4Var.E0();
                        t4Var.t0(arrayList2);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        k kVar9 = this.f5589c;
                        R(kVar9);
                        kVar9.q((q) entry.getValue());
                    }
                    maVar2 = maVar3;
                } else {
                    j11 = 0;
                    t4Var = t4Var3;
                }
                String strW12 = maVar2.f5508a.W1();
                k kVar10 = this.f5589c;
                R(kVar10);
                e6 e6VarR2 = kVar10.R(strW12);
                if (e6VarR2 == null) {
                    d().r().b("Bundling raw events w/o app info. appId", v3.z(maVar2.f5508a.W1()));
                } else if (t4Var.S() > 0) {
                    long jD0 = e6VarR2.d0();
                    if (jD0 != j11) {
                        t4Var.U(jD0);
                    } else {
                        t4Var.I0();
                    }
                    long jF0 = e6VarR2.f0();
                    if (jF0 != j11) {
                        jD0 = jF0;
                    }
                    if (jD0 != j11) {
                        t4Var.V(jD0);
                    } else {
                        t4Var.J0();
                    }
                    e6VarR2.g();
                    t4Var.A((int) e6VarR2.e0());
                    e6VarR2.E(t4Var.q0());
                    e6VarR2.C(t4Var.p0());
                    String strK0 = e6VarR2.k0();
                    if (strK0 != null) {
                        t4Var.O(strK0);
                    } else {
                        t4Var.F0();
                    }
                    k kVar11 = this.f5589c;
                    R(kVar11);
                    kVar11.p(e6VarR2);
                }
                if (t4Var.S() > 0) {
                    this.f5598l.b();
                    y4 y4Var8 = this.f5587a;
                    R(y4Var8);
                    com.google.android.gms.internal.measurement.v3 v3VarT = y4Var8.t(maVar2.f5508a.W1());
                    if (v3VarT != null && v3VarT.W()) {
                        t4Var.C(v3VarT.F());
                    } else if (maVar2.f5508a.J().isEmpty()) {
                        t4Var.C(-1L);
                    } else {
                        d().w().b("Did not find measurement config or missing version info. appId", v3.z(maVar2.f5508a.W1()));
                    }
                    k kVar12 = this.f5589c;
                    R(kVar12);
                    com.google.android.gms.internal.measurement.u4 u4Var = (com.google.android.gms.internal.measurement.u4) t4Var.o();
                    kVar12.h();
                    kVar12.i();
                    t1.f.h(u4Var);
                    t1.f.d(u4Var.W1());
                    t1.f.k(u4Var.n1());
                    kVar12.h0();
                    long jA = kVar12.f5030a.a().a();
                    long jJ1 = u4Var.J1();
                    kVar12.f5030a.z();
                    if (jJ1 >= jA - g.i()) {
                        long jJ12 = u4Var.J1();
                        kVar12.f5030a.z();
                        if (jJ12 > g.i() + jA) {
                            kVar12.f5030a.d().w().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", v3.z(u4Var.W1()), Long.valueOf(jA), Long.valueOf(u4Var.J1()));
                        }
                        byte[] bArrI = u4Var.i();
                        try {
                            ra raVar2 = kVar12.f5039b.f5593g;
                            R(raVar2);
                            byte[] bArrQ = raVar2.Q(bArrI);
                            kVar12.f5030a.d().v().b("Saving bundle, size", Integer.valueOf(bArrQ.length));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("app_id", u4Var.W1());
                            contentValues.put("bundle_end_timestamp", Long.valueOf(u4Var.J1()));
                            contentValues.put("data", bArrQ);
                            contentValues.put("has_realtime", Integer.valueOf(i33));
                            if (u4Var.t1()) {
                                contentValues.put("retry_count", Integer.valueOf(u4Var.D1()));
                            }
                            try {
                                if (kVar12.P().insert("queue", null, contentValues) == -1) {
                                    kVar12.f5030a.d().r().b("Failed to insert bundle (got -1). appId", v3.z(u4Var.W1()));
                                }
                            } catch (SQLiteException e11) {
                                kVar12.f5030a.d().r().c("Error storing bundle. appId", v3.z(u4Var.W1()), e11);
                            }
                        } catch (IOException e12) {
                            kVar12.f5030a.d().r().c("Data loss. Failed to serialize bundle. appId", v3.z(u4Var.W1()), e12);
                        }
                    }
                }
                k kVar13 = this.f5589c;
                R(kVar13);
                List list2 = maVar2.f5509b;
                t1.f.h(list2);
                kVar13.h();
                kVar13.i();
                StringBuilder sb2 = new StringBuilder("rowid in (");
                for (int i39 = 0; i39 < list2.size(); i39++) {
                    if (i39 != 0) {
                        sb2.append(",");
                    }
                    sb2.append(((Long) list2.get(i39)).longValue());
                }
                sb2.append(")");
                int iDelete = kVar13.P().delete("raw_events", sb2.toString(), null);
                if (iDelete != list2.size()) {
                    kVar13.f5030a.d().r().c("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list2.size()));
                }
                k kVar14 = this.f5589c;
                R(kVar14);
                try {
                    kVar14.P().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strW12, strW12});
                } catch (SQLiteException e13) {
                    kVar14.f5030a.d().r().c("Failed to remove unused event metadata. appId", v3.z(strW12), e13);
                }
                k kVar15 = this.f5589c;
                R(kVar15);
                kVar15.o();
                k kVar16 = this.f5589c;
                R(kVar16);
                kVar16.f0();
                return true;
            }
            k kVar17 = this.f5589c;
            R(kVar17);
            kVar17.o();
            k kVar18 = this.f5589c;
            R(kVar18);
            kVar18.f0();
            return false;
        } catch (Throwable th) {
            k kVar19 = this.f5589c;
            R(kVar19);
            kVar19.f0();
            throw th;
        }
    }

    public final boolean O() {
        f().h();
        g();
        k kVar = this.f5589c;
        R(kVar);
        if (kVar.r()) {
            return true;
        }
        k kVar2 = this.f5589c;
        R(kVar2);
        return !TextUtils.isEmpty(kVar2.Z());
    }

    public final boolean P(com.google.android.gms.internal.measurement.i4 i4Var, com.google.android.gms.internal.measurement.i4 i4Var2) {
        t1.f.a("_e".equals(i4Var.G()));
        R(this.f5593g);
        com.google.android.gms.internal.measurement.n4 n4VarO = ra.o((com.google.android.gms.internal.measurement.j4) i4Var.o(), "_sc");
        String strK = n4VarO == null ? null : n4VarO.K();
        R(this.f5593g);
        com.google.android.gms.internal.measurement.n4 n4VarO2 = ra.o((com.google.android.gms.internal.measurement.j4) i4Var2.o(), "_pc");
        String strK2 = n4VarO2 != null ? n4VarO2.K() : null;
        if (strK2 == null || !strK2.equals(strK)) {
            return false;
        }
        t1.f.a("_e".equals(i4Var.G()));
        R(this.f5593g);
        com.google.android.gms.internal.measurement.n4 n4VarO3 = ra.o((com.google.android.gms.internal.measurement.j4) i4Var.o(), "_et");
        if (n4VarO3 == null || !n4VarO3.Y() || n4VarO3.G() <= 0) {
            return true;
        }
        long jG = n4VarO3.G();
        R(this.f5593g);
        com.google.android.gms.internal.measurement.n4 n4VarO4 = ra.o((com.google.android.gms.internal.measurement.j4) i4Var2.o(), "_et");
        if (n4VarO4 != null && n4VarO4.G() > 0) {
            jG += n4VarO4.G();
        }
        R(this.f5593g);
        ra.m(i4Var2, "_et", Long.valueOf(jG));
        R(this.f5593g);
        ra.m(i4Var, "_fr", 1L);
        return true;
    }

    public final e6 S(zzq zzqVar) {
        f().h();
        g();
        t1.f.h(zzqVar);
        t1.f.d(zzqVar.f3976e);
        na naVar = null;
        if (!zzqVar.E.isEmpty()) {
            this.B.put(zzqVar.f3976e, new oa(this, zzqVar.E));
        }
        k kVar = this.f5589c;
        R(kVar);
        e6 e6VarR = kVar.R(zzqVar.f3976e);
        f6 f6VarD = c0(zzqVar.f3976e).d(f6.c(zzqVar.D, 100));
        zzha zzhaVar = zzha.AD_STORAGE;
        String strO = f6VarD.j(zzhaVar) ? this.f5595i.o(zzqVar.f3976e, zzqVar.f3990w) : "";
        if (e6VarR == null) {
            e6VarR = new e6(this.f5598l, zzqVar.f3976e);
            if (f6VarD.j(zzha.ANALYTICS_STORAGE)) {
                e6VarR.j(i0(f6VarD));
            }
            if (f6VarD.j(zzhaVar)) {
                e6VarR.H(strO);
            }
        } else if (f6VarD.j(zzhaVar) && strO != null && !strO.equals(e6VarR.c())) {
            e6VarR.H(strO);
            if (zzqVar.f3990w && !"00000000-0000-0000-0000-000000000000".equals(this.f5595i.n(zzqVar.f3976e, f6VarD).first)) {
                e6VarR.j(i0(f6VarD));
                k kVar2 = this.f5589c;
                R(kVar2);
                if (kVar2.X(zzqVar.f3976e, "_id") != null) {
                    k kVar3 = this.f5589c;
                    R(kVar3);
                    if (kVar3.X(zzqVar.f3976e, "_lair") == null) {
                        ta taVar = new ta(zzqVar.f3976e, "auto", "_lair", a().a(), 1L);
                        k kVar4 = this.f5589c;
                        R(kVar4);
                        kVar4.x(taVar);
                    }
                }
            }
        } else if (TextUtils.isEmpty(e6VarR.m0()) && f6VarD.j(zzha.ANALYTICS_STORAGE)) {
            e6VarR.j(i0(f6VarD));
        }
        e6VarR.y(zzqVar.f3977j);
        e6VarR.h(zzqVar.f3992y);
        if (!TextUtils.isEmpty(zzqVar.f3986s)) {
            e6VarR.x(zzqVar.f3986s);
        }
        long j10 = zzqVar.f3980m;
        if (j10 != 0) {
            e6VarR.z(j10);
        }
        if (!TextUtils.isEmpty(zzqVar.f3978k)) {
            e6VarR.l(zzqVar.f3978k);
        }
        e6VarR.m(zzqVar.f3985r);
        String str = zzqVar.f3979l;
        if (str != null) {
            e6VarR.k(str);
        }
        e6VarR.u(zzqVar.f3981n);
        e6VarR.F(zzqVar.f3983p);
        if (!TextUtils.isEmpty(zzqVar.f3982o)) {
            e6VarR.B(zzqVar.f3982o);
        }
        e6VarR.i(zzqVar.f3990w);
        e6VarR.G(zzqVar.f3993z);
        e6VarR.v(zzqVar.A);
        ae.b();
        if (U().B(null, i3.f5324o0) || U().B(zzqVar.f3976e, i3.f5328q0)) {
            e6VarR.J(zzqVar.F);
        }
        tb.b();
        if (U().B(null, i3.f5322n0)) {
            e6VarR.I(zzqVar.B);
        } else {
            tb.b();
            if (U().B(null, i3.f5320m0)) {
                e6VarR.I(null);
            }
        }
        ke.b();
        if (U().B(null, i3.f5332s0)) {
            e6VarR.L(zzqVar.G);
        }
        ed.b();
        if (U().B(null, i3.G0)) {
            e6VarR.M(zzqVar.H);
        }
        if (e6VarR.P()) {
            k kVar5 = this.f5589c;
            R(kVar5);
            kVar5.p(e6VarR);
        }
        return e6VarR;
    }

    public final b T() {
        b bVar = this.f5592f;
        R(bVar);
        return bVar;
    }

    public final g U() {
        return ((h5) t1.f.h(this.f5598l)).z();
    }

    public final k V() {
        k kVar = this.f5589c;
        R(kVar);
        return kVar;
    }

    public final q3 W() {
        return this.f5598l.D();
    }

    public final b4 X() {
        b4 b4Var = this.f5588b;
        R(b4Var);
        return b4Var;
    }

    public final e4 Y() {
        e4 e4Var = this.f5590d;
        if (e4Var != null) {
            return e4Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final y4 Z() {
        y4 y4Var = this.f5587a;
        R(y4Var);
        return y4Var;
    }

    @Override // f2.c6
    public final w1.c a() {
        return ((h5) t1.f.h(this.f5598l)).a();
    }

    @Override // f2.c6
    public final c b() {
        throw null;
    }

    public final h5 b0() {
        return this.f5598l;
    }

    @Override // f2.c6
    public final Context c() {
        return this.f5598l.c();
    }

    public final f6 c0(String str) {
        String string;
        f6 f6Var = f6.f5178c;
        f().h();
        g();
        f6 f6Var2 = (f6) this.A.get(str);
        if (f6Var2 != null) {
            return f6Var2;
        }
        k kVar = this.f5589c;
        R(kVar);
        t1.f.h(str);
        kVar.h();
        kVar.i();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = kVar.P().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursorRawQuery.moveToFirst()) {
                    string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                } else {
                    cursorRawQuery.close();
                    string = "G1";
                }
                f6 f6VarC = f6.c(string, 100);
                A(str, f6VarC);
                return f6VarC;
            } catch (SQLiteException e10) {
                kVar.f5030a.d().r().c("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // f2.c6
    public final v3 d() {
        return ((h5) t1.f.h(this.f5598l)).d();
    }

    public final t7 d0() {
        t7 t7Var = this.f5594h;
        R(t7Var);
        return t7Var;
    }

    public final void e() {
        f().h();
        g();
        if (this.f5600n) {
            return;
        }
        this.f5600n = true;
        if (E()) {
            FileChannel fileChannel = this.f5609w;
            f().h();
            int i10 = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                d().r().a("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i11 = fileChannel.read(byteBufferAllocate);
                    if (i11 == 4) {
                        byteBufferAllocate.flip();
                        i10 = byteBufferAllocate.getInt();
                    } else if (i11 != -1) {
                        d().w().b("Unexpected data length. Bytes read", Integer.valueOf(i11));
                    }
                } catch (IOException e10) {
                    d().r().b("Failed to read from channel", e10);
                }
            }
            int iP = this.f5598l.B().p();
            f().h();
            if (i10 > iP) {
                d().r().c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i10), Integer.valueOf(iP));
                return;
            }
            if (i10 < iP) {
                FileChannel fileChannel2 = this.f5609w;
                f().h();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    d().r().a("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iP);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            d().r().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        d().v().c("Storage version upgraded. Previous, current version", Integer.valueOf(i10), Integer.valueOf(iP));
                        return;
                    } catch (IOException e11) {
                        d().r().b("Failed to write to channel", e11);
                    }
                }
                d().r().c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i10), Integer.valueOf(iP));
            }
        }
    }

    public final g9 e0() {
        return this.f5595i;
    }

    @Override // f2.c6
    public final e5 f() {
        return ((h5) t1.f.h(this.f5598l)).f();
    }

    public final void g() {
        if (!this.f5599m) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final ra g0() {
        ra raVar = this.f5593g;
        R(raVar);
        return raVar;
    }

    public final void h(String str, com.google.android.gms.internal.measurement.t4 t4Var) {
        int iX;
        int iIndexOf;
        y4 y4Var = this.f5587a;
        R(y4Var);
        Set setY = y4Var.y(str);
        if (setY != null) {
            t4Var.v0(setY);
        }
        y4 y4Var2 = this.f5587a;
        R(y4Var2);
        if (y4Var2.J(str)) {
            t4Var.C0();
        }
        y4 y4Var3 = this.f5587a;
        R(y4Var3);
        if (y4Var3.M(str)) {
            if (U().B(str, i3.f5334t0)) {
                String strL0 = t4Var.l0();
                if (!TextUtils.isEmpty(strL0) && (iIndexOf = strL0.indexOf(".")) != -1) {
                    t4Var.Q(strL0.substring(0, iIndexOf));
                }
            } else {
                t4Var.H0();
            }
        }
        y4 y4Var4 = this.f5587a;
        R(y4Var4);
        if (y4Var4.N(str) && (iX = ra.x(t4Var, "_id")) != -1) {
            t4Var.t(iX);
        }
        y4 y4Var5 = this.f5587a;
        R(y4Var5);
        if (y4Var5.L(str)) {
            t4Var.D0();
        }
        y4 y4Var6 = this.f5587a;
        R(y4Var6);
        if (y4Var6.I(str)) {
            t4Var.A0();
            oa oaVar = (oa) this.B.get(str);
            if (oaVar == null || oaVar.f5569b + U().r(str, i3.V) < a().b()) {
                oaVar = new oa(this);
                this.B.put(str, oaVar);
            }
            t4Var.J(oaVar.f5568a);
        }
        y4 y4Var7 = this.f5587a;
        R(y4Var7);
        if (y4Var7.K(str)) {
            t4Var.L0();
        }
    }

    public final wa h0() {
        return ((h5) t1.f.h(this.f5598l)).N();
    }

    public final void i(e6 e6Var) {
        f().h();
        if (TextUtils.isEmpty(e6Var.a()) && TextUtils.isEmpty(e6Var.j0())) {
            n((String) t1.f.h(e6Var.l0()), 204, null, null, null);
            return;
        }
        da daVar = this.f5596j;
        Uri.Builder builder = new Uri.Builder();
        String strA = e6Var.a();
        if (TextUtils.isEmpty(strA)) {
            strA = e6Var.j0();
        }
        k.a aVar = null;
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) i3.f5307g.a(null)).encodedAuthority((String) i3.f5309h.a(null)).path("config/app/".concat(String.valueOf(strA))).appendQueryParameter("platform", "android");
        daVar.f5030a.z().q();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(79000L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            String str = (String) t1.f.h(e6Var.l0());
            URL url = new URL(string);
            d().v().b("Fetching remote configuration", str);
            y4 y4Var = this.f5587a;
            R(y4Var);
            com.google.android.gms.internal.measurement.v3 v3VarT = y4Var.t(str);
            y4 y4Var2 = this.f5587a;
            R(y4Var2);
            String strV = y4Var2.v(str);
            if (v3VarT != null) {
                if (!TextUtils.isEmpty(strV)) {
                    aVar = new k.a();
                    aVar.put("If-Modified-Since", strV);
                }
                y4 y4Var3 = this.f5587a;
                R(y4Var3);
                String strU = y4Var3.u(str);
                if (!TextUtils.isEmpty(strU)) {
                    if (aVar == null) {
                        aVar = new k.a();
                    }
                    aVar.put("If-None-Match", strU);
                }
            }
            this.f5605s = true;
            b4 b4Var = this.f5588b;
            R(b4Var);
            ga gaVar = new ga(this);
            b4Var.h();
            b4Var.i();
            t1.f.h(url);
            t1.f.h(gaVar);
            b4Var.f5030a.f().y(new a4(b4Var, str, url, null, aVar, gaVar));
        } catch (MalformedURLException unused) {
            d().r().c("Failed to parse config URL. Not fetching. appId", v3.z(e6Var.l0()), string);
        }
    }

    public final String i0(f6 f6Var) {
        if (!f6Var.j(zzha.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        h0().u().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final void j(zzau zzauVar, zzq zzqVar) {
        List<zzac> listB0;
        List<zzac> listB02;
        List<zzac> listB03;
        String str;
        t1.f.h(zzqVar);
        t1.f.d(zzqVar.f3976e);
        f().h();
        g();
        String str2 = zzqVar.f3976e;
        long j10 = zzauVar.f3967l;
        w3 w3VarB = w3.b(zzauVar);
        f().h();
        v7 v7Var = null;
        if (this.C != null && (str = this.D) != null && str.equals(str2)) {
            v7Var = this.C;
        }
        wa.y(v7Var, w3VarB.f5785d, false);
        zzau zzauVarA = w3VarB.a();
        R(this.f5593g);
        if (ra.n(zzauVarA, zzqVar)) {
            if (!zzqVar.f3983p) {
                S(zzqVar);
                return;
            }
            List list = zzqVar.B;
            if (list != null) {
                if (!list.contains(zzauVarA.f3964e)) {
                    d().q().d("Dropping non-safelisted event. appId, event name, origin", str2, zzauVarA.f3964e, zzauVarA.f3966k);
                    return;
                } else {
                    Bundle bundleG = zzauVarA.f3965j.g();
                    bundleG.putLong("ga_safelisted", 1L);
                    zzauVarA = new zzau(zzauVarA.f3964e, new zzas(bundleG), zzauVarA.f3966k, zzauVarA.f3967l);
                }
            }
            k kVar = this.f5589c;
            R(kVar);
            kVar.e0();
            try {
                k kVar2 = this.f5589c;
                R(kVar2);
                t1.f.d(str2);
                kVar2.h();
                kVar2.i();
                if (j10 < 0) {
                    kVar2.f5030a.d().w().c("Invalid time querying timed out conditional properties", v3.z(str2), Long.valueOf(j10));
                    listB0 = Collections.EMPTY_LIST;
                } else {
                    listB0 = kVar2.b0("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
                }
                for (zzac zzacVar : listB0) {
                    if (zzacVar != null) {
                        d().v().d("User property timed out", zzacVar.f3952e, this.f5598l.D().f(zzacVar.f3954k.f3970j), zzacVar.f3954k.c());
                        zzau zzauVar2 = zzacVar.f3958o;
                        if (zzauVar2 != null) {
                            D(new zzau(zzauVar2, j10), zzqVar);
                        }
                        k kVar3 = this.f5589c;
                        R(kVar3);
                        kVar3.J(str2, zzacVar.f3954k.f3970j);
                    }
                }
                k kVar4 = this.f5589c;
                R(kVar4);
                t1.f.d(str2);
                kVar4.h();
                kVar4.i();
                if (j10 < 0) {
                    kVar4.f5030a.d().w().c("Invalid time querying expired conditional properties", v3.z(str2), Long.valueOf(j10));
                    listB02 = Collections.EMPTY_LIST;
                } else {
                    listB02 = kVar4.b0("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
                }
                ArrayList arrayList = new ArrayList(listB02.size());
                for (zzac zzacVar2 : listB02) {
                    if (zzacVar2 != null) {
                        d().v().d("User property expired", zzacVar2.f3952e, this.f5598l.D().f(zzacVar2.f3954k.f3970j), zzacVar2.f3954k.c());
                        k kVar5 = this.f5589c;
                        R(kVar5);
                        kVar5.m(str2, zzacVar2.f3954k.f3970j);
                        zzau zzauVar3 = zzacVar2.f3962s;
                        if (zzauVar3 != null) {
                            arrayList.add(zzauVar3);
                        }
                        k kVar6 = this.f5589c;
                        R(kVar6);
                        kVar6.J(str2, zzacVar2.f3954k.f3970j);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    D(new zzau((zzau) it.next(), j10), zzqVar);
                }
                k kVar7 = this.f5589c;
                R(kVar7);
                String str3 = zzauVarA.f3964e;
                t1.f.d(str2);
                t1.f.d(str3);
                kVar7.h();
                kVar7.i();
                if (j10 < 0) {
                    kVar7.f5030a.d().w().d("Invalid time querying triggered conditional properties", v3.z(str2), kVar7.f5030a.D().d(str3), Long.valueOf(j10));
                    listB03 = Collections.EMPTY_LIST;
                } else {
                    listB03 = kVar7.b0("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j10)});
                }
                ArrayList arrayList2 = new ArrayList(listB03.size());
                for (zzac zzacVar3 : listB03) {
                    if (zzacVar3 != null) {
                        zzlk zzlkVar = zzacVar3.f3954k;
                        ta taVar = new ta((String) t1.f.h(zzacVar3.f3952e), zzacVar3.f3953j, zzlkVar.f3970j, j10, t1.f.h(zzlkVar.c()));
                        k kVar8 = this.f5589c;
                        R(kVar8);
                        if (kVar8.x(taVar)) {
                            d().v().d("User property triggered", zzacVar3.f3952e, this.f5598l.D().f(taVar.f5716c), taVar.f5718e);
                        } else {
                            d().r().d("Too many active user properties, ignoring", v3.z(zzacVar3.f3952e), this.f5598l.D().f(taVar.f5716c), taVar.f5718e);
                        }
                        zzau zzauVar4 = zzacVar3.f3960q;
                        if (zzauVar4 != null) {
                            arrayList2.add(zzauVar4);
                        }
                        zzacVar3.f3954k = new zzlk(taVar);
                        zzacVar3.f3956m = true;
                        k kVar9 = this.f5589c;
                        R(kVar9);
                        kVar9.w(zzacVar3);
                    }
                }
                D(zzauVarA, zzqVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    D(new zzau((zzau) it2.next(), j10), zzqVar);
                }
                k kVar10 = this.f5589c;
                R(kVar10);
                kVar10.o();
                k kVar11 = this.f5589c;
                R(kVar11);
                kVar11.f0();
            } catch (Throwable th) {
                k kVar12 = this.f5589c;
                R(kVar12);
                kVar12.f0();
                throw th;
            }
        }
    }

    public final String j0(zzq zzqVar) {
        try {
            return (String) f().s(new ia(this, zzqVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            d().r().c("Failed to get app instance id. appId", v3.z(zzqVar.f3976e), e10);
            return null;
        }
    }

    public final void k(zzau zzauVar, String str) {
        k kVar = this.f5589c;
        R(kVar);
        e6 e6VarR = kVar.R(str);
        if (e6VarR == null || TextUtils.isEmpty(e6VarR.o0())) {
            d().q().b("No app data available; dropping event", str);
            return;
        }
        Boolean boolJ = J(e6VarR);
        if (boolJ == null) {
            if (!"_ui".equals(zzauVar.f3964e)) {
                d().w().b("Could not find package. appId", v3.z(str));
            }
        } else if (!boolJ.booleanValue()) {
            d().r().b("App version does not match; dropping event. appId", v3.z(str));
            return;
        }
        String strA = e6VarR.a();
        String strO0 = e6VarR.o0();
        long jR = e6VarR.R();
        String strN0 = e6VarR.n0();
        long jC0 = e6VarR.c0();
        long jZ = e6VarR.Z();
        boolean zO = e6VarR.O();
        String strP0 = e6VarR.p0();
        e6VarR.A();
        l(zzauVar, new zzq(str, strA, strO0, jR, strN0, jC0, jZ, (String) null, zO, false, strP0, 0L, 0L, 0, e6VarR.N(), false, e6VarR.j0(), e6VarR.i0(), e6VarR.a0(), e6VarR.e(), (String) null, c0(str).i(), "", (String) null, e6VarR.Q(), e6VarR.h0()));
    }

    public final void l(zzau zzauVar, zzq zzqVar) {
        t1.f.d(zzqVar.f3976e);
        w3 w3VarB = w3.b(zzauVar);
        wa waVarH0 = h0();
        Bundle bundle = w3VarB.f5785d;
        k kVar = this.f5589c;
        R(kVar);
        waVarH0.z(bundle, kVar.Q(zzqVar.f3976e));
        h0().B(w3VarB, U().n(zzqVar.f3976e));
        zzau zzauVarA = w3VarB.a();
        if ("_cmp".equals(zzauVarA.f3964e) && "referrer API v2".equals(zzauVarA.f3965j.o("_cis"))) {
            String strO = zzauVarA.f3965j.o("gclid");
            if (!TextUtils.isEmpty(strO)) {
                B(new zzlk("_lgclid", zzauVarA.f3967l, strO, "auto"), zzqVar);
            }
        }
        j(zzauVarA, zzqVar);
    }

    public final void l0(Runnable runnable) {
        f().h();
        if (this.f5602p == null) {
            this.f5602p = new ArrayList();
        }
        this.f5602p.add(runnable);
    }

    public final void m() {
        this.f5604r++;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(String str, int i10, Throwable th, byte[] bArr, Map map) {
        boolean z10;
        f().h();
        g();
        t1.f.d(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.f5605s = false;
                K();
                throw th2;
            }
        }
        t3 t3VarV = d().v();
        Integer numValueOf = Integer.valueOf(bArr.length);
        t3VarV.b("onConfigFetched. Response size", numValueOf);
        k kVar = this.f5589c;
        R(kVar);
        kVar.e0();
        try {
            k kVar2 = this.f5589c;
            R(kVar2);
            e6 e6VarR = kVar2.R(str);
            if (i10 == 200 || i10 == 204) {
                z10 = th != null;
            } else {
                if (i10 == 304) {
                    i10 = 304;
                    if (th != null) {
                    }
                }
            }
            if (e6VarR == null) {
                d().w().b("App does not exist in onConfigFetched. appId", v3.z(str));
            } else if (z10 || i10 == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.isEmpty()) ? null : (String) list.get(0);
                List list2 = map != null ? (List) map.get("ETag") : null;
                String str3 = (list2 == null || list2.isEmpty()) ? null : (String) list2.get(0);
                if (i10 == 404 || i10 == 304) {
                    y4 y4Var = this.f5587a;
                    R(y4Var);
                    if (y4Var.t(str) == null) {
                        y4 y4Var2 = this.f5587a;
                        R(y4Var2);
                        y4Var2.H(str, null, null, null);
                    }
                } else {
                    y4 y4Var3 = this.f5587a;
                    R(y4Var3);
                    y4Var3.H(str, bArr, str2, str3);
                }
                e6VarR.n(a().a());
                k kVar3 = this.f5589c;
                R(kVar3);
                kVar3.p(e6VarR);
                if (i10 == 404) {
                    d().x().b("Config not found. Using empty config. appId", str);
                } else {
                    d().v().c("Successfully fetched config. Got network response. code, size", Integer.valueOf(i10), numValueOf);
                }
                b4 b4Var = this.f5588b;
                R(b4Var);
                if (b4Var.m() && O()) {
                    C();
                } else {
                    M();
                }
            } else {
                e6VarR.w(a().a());
                k kVar4 = this.f5589c;
                R(kVar4);
                kVar4.p(e6VarR);
                d().v().c("Fetching config failed. code, error", Integer.valueOf(i10), th);
                y4 y4Var4 = this.f5587a;
                R(y4Var4);
                y4Var4.z(str);
                this.f5595i.f5220h.b(a().a());
                if (i10 == 503 || i10 == 429) {
                    this.f5595i.f5218f.b(a().a());
                }
                M();
            }
            k kVar5 = this.f5589c;
            R(kVar5);
            kVar5.o();
            k kVar6 = this.f5589c;
            R(kVar6);
            kVar6.f0();
            this.f5605s = false;
            K();
        } catch (Throwable th3) {
            k kVar7 = this.f5589c;
            R(kVar7);
            kVar7.f0();
            throw th3;
        }
    }

    public final void o(boolean z10) {
        M();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0151 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:7:0x0013, B:50:0x0129, B:55:0x0160, B:54:0x0151, B:14:0x002a, B:38:0x00ca, B:40:0x00df, B:42:0x00e5, B:46:0x00f2, B:45:0x00eb, B:47:0x00f5, B:48:0x00fd, B:49:0x00fe), top: B:61:0x000d, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(int i10, Throwable th, byte[] bArr, String str) {
        k kVar;
        long jLongValue;
        f().h();
        g();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.f5606t = false;
                K();
                throw th2;
            }
        }
        List<Long> list = (List) t1.f.h(this.f5610x);
        this.f5610x = null;
        if (i10 != 200) {
            if (i10 == 204) {
                i10 = 204;
                if (th != null) {
                }
            }
            d().v().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th);
            this.f5595i.f5220h.b(a().a());
            if (i10 != 503) {
                this.f5595i.f5218f.b(a().a());
                k kVar2 = this.f5589c;
                R(kVar2);
                kVar2.g0(list);
                M();
            }
        } else if (th != null) {
            try {
                this.f5595i.f5219g.b(a().a());
                this.f5595i.f5220h.b(0L);
                M();
                d().v().c("Successful upload. Got network response. code, size", Integer.valueOf(i10), Integer.valueOf(bArr.length));
                k kVar3 = this.f5589c;
                R(kVar3);
                kVar3.e0();
                try {
                    for (Long l10 : list) {
                        try {
                            kVar = this.f5589c;
                            R(kVar);
                            jLongValue = l10.longValue();
                            kVar.h();
                            kVar.i();
                            try {
                            } catch (SQLiteException e10) {
                                kVar.f5030a.d().r().b("Failed to delete a bundle in a queue table", e10);
                                throw e10;
                            }
                        } catch (SQLiteException e11) {
                            List list2 = this.f5611y;
                            if (list2 == null || !list2.contains(l10)) {
                                throw e11;
                            }
                        }
                        if (kVar.P().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    k kVar4 = this.f5589c;
                    R(kVar4);
                    kVar4.o();
                    k kVar5 = this.f5589c;
                    R(kVar5);
                    kVar5.f0();
                    this.f5611y = null;
                    b4 b4Var = this.f5588b;
                    R(b4Var);
                    if (b4Var.m() && O()) {
                        C();
                    } else {
                        this.f5612z = -1L;
                        M();
                    }
                    this.f5601o = 0L;
                } catch (Throwable th3) {
                    k kVar6 = this.f5589c;
                    R(kVar6);
                    kVar6.f0();
                    throw th3;
                }
            } catch (SQLiteException e12) {
                d().r().b("Database error while trying to delete uploaded bundles", e12);
                this.f5601o = a().b();
                d().v().b("Disable upload, time", Long.valueOf(this.f5601o));
            }
        } else {
            d().v().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th);
            this.f5595i.f5220h.b(a().a());
            if (i10 != 503 || i10 == 429) {
                this.f5595i.f5218f.b(a().a());
            }
            k kVar22 = this.f5589c;
            R(kVar22);
            kVar22.g0(list);
            M();
        }
        this.f5606t = false;
        K();
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x052e A[Catch: all -> 0x00c3, TryCatch #1 {all -> 0x00c3, blocks: (B:23:0x00a8, B:25:0x00b5, B:45:0x0101, B:47:0x0115, B:49:0x012d, B:50:0x0154, B:52:0x01ac, B:54:0x01b4, B:58:0x01c0, B:66:0x01f4, B:68:0x01ff, B:72:0x020c, B:75:0x021a, B:79:0x0225, B:81:0x0229, B:82:0x024a, B:84:0x024f, B:87:0x026e, B:91:0x0282, B:93:0x02ae, B:96:0x02b6, B:98:0x02c5, B:127:0x03ab, B:129:0x03d7, B:130:0x03da, B:132:0x0403, B:172:0x04cc, B:173:0x04cf, B:181:0x054c, B:134:0x0418, B:139:0x043d, B:141:0x0445, B:143:0x044b, B:147:0x045e, B:151:0x0471, B:155:0x047d, B:158:0x048b, B:163:0x04af, B:165:0x04b5, B:167:0x04bd, B:169:0x04c3, B:161:0x049c, B:149:0x0469, B:137:0x0429, B:99:0x02d6, B:101:0x0301, B:102:0x0312, B:104:0x0319, B:106:0x031f, B:108:0x0329, B:110:0x032f, B:112:0x0335, B:114:0x033b, B:115:0x0340, B:121:0x0364, B:123:0x0368, B:124:0x037c, B:125:0x038c, B:126:0x039c, B:174:0x04e5, B:176:0x0515, B:177:0x0518, B:178:0x052e, B:180:0x0532, B:85:0x025e, B:62:0x01d8, B:31:0x00c6, B:33:0x00ca, B:37:0x00db, B:39:0x00ec, B:41:0x00f6, B:44:0x00fe), top: B:189:0x00a8, inners: #0, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f4 A[Catch: all -> 0x00c3, TryCatch #1 {all -> 0x00c3, blocks: (B:23:0x00a8, B:25:0x00b5, B:45:0x0101, B:47:0x0115, B:49:0x012d, B:50:0x0154, B:52:0x01ac, B:54:0x01b4, B:58:0x01c0, B:66:0x01f4, B:68:0x01ff, B:72:0x020c, B:75:0x021a, B:79:0x0225, B:81:0x0229, B:82:0x024a, B:84:0x024f, B:87:0x026e, B:91:0x0282, B:93:0x02ae, B:96:0x02b6, B:98:0x02c5, B:127:0x03ab, B:129:0x03d7, B:130:0x03da, B:132:0x0403, B:172:0x04cc, B:173:0x04cf, B:181:0x054c, B:134:0x0418, B:139:0x043d, B:141:0x0445, B:143:0x044b, B:147:0x045e, B:151:0x0471, B:155:0x047d, B:158:0x048b, B:163:0x04af, B:165:0x04b5, B:167:0x04bd, B:169:0x04c3, B:161:0x049c, B:149:0x0469, B:137:0x0429, B:99:0x02d6, B:101:0x0301, B:102:0x0312, B:104:0x0319, B:106:0x031f, B:108:0x0329, B:110:0x032f, B:112:0x0335, B:114:0x033b, B:115:0x0340, B:121:0x0364, B:123:0x0368, B:124:0x037c, B:125:0x038c, B:126:0x039c, B:174:0x04e5, B:176:0x0515, B:177:0x0518, B:178:0x052e, B:180:0x0532, B:85:0x025e, B:62:0x01d8, B:31:0x00c6, B:33:0x00ca, B:37:0x00db, B:39:0x00ec, B:41:0x00f6, B:44:0x00fe), top: B:189:0x00a8, inners: #0, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024f A[Catch: all -> 0x00c3, TryCatch #1 {all -> 0x00c3, blocks: (B:23:0x00a8, B:25:0x00b5, B:45:0x0101, B:47:0x0115, B:49:0x012d, B:50:0x0154, B:52:0x01ac, B:54:0x01b4, B:58:0x01c0, B:66:0x01f4, B:68:0x01ff, B:72:0x020c, B:75:0x021a, B:79:0x0225, B:81:0x0229, B:82:0x024a, B:84:0x024f, B:87:0x026e, B:91:0x0282, B:93:0x02ae, B:96:0x02b6, B:98:0x02c5, B:127:0x03ab, B:129:0x03d7, B:130:0x03da, B:132:0x0403, B:172:0x04cc, B:173:0x04cf, B:181:0x054c, B:134:0x0418, B:139:0x043d, B:141:0x0445, B:143:0x044b, B:147:0x045e, B:151:0x0471, B:155:0x047d, B:158:0x048b, B:163:0x04af, B:165:0x04b5, B:167:0x04bd, B:169:0x04c3, B:161:0x049c, B:149:0x0469, B:137:0x0429, B:99:0x02d6, B:101:0x0301, B:102:0x0312, B:104:0x0319, B:106:0x031f, B:108:0x0329, B:110:0x032f, B:112:0x0335, B:114:0x033b, B:115:0x0340, B:121:0x0364, B:123:0x0368, B:124:0x037c, B:125:0x038c, B:126:0x039c, B:174:0x04e5, B:176:0x0515, B:177:0x0518, B:178:0x052e, B:180:0x0532, B:85:0x025e, B:62:0x01d8, B:31:0x00c6, B:33:0x00ca, B:37:0x00db, B:39:0x00ec, B:41:0x00f6, B:44:0x00fe), top: B:189:0x00a8, inners: #0, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x025e A[Catch: all -> 0x00c3, TryCatch #1 {all -> 0x00c3, blocks: (B:23:0x00a8, B:25:0x00b5, B:45:0x0101, B:47:0x0115, B:49:0x012d, B:50:0x0154, B:52:0x01ac, B:54:0x01b4, B:58:0x01c0, B:66:0x01f4, B:68:0x01ff, B:72:0x020c, B:75:0x021a, B:79:0x0225, B:81:0x0229, B:82:0x024a, B:84:0x024f, B:87:0x026e, B:91:0x0282, B:93:0x02ae, B:96:0x02b6, B:98:0x02c5, B:127:0x03ab, B:129:0x03d7, B:130:0x03da, B:132:0x0403, B:172:0x04cc, B:173:0x04cf, B:181:0x054c, B:134:0x0418, B:139:0x043d, B:141:0x0445, B:143:0x044b, B:147:0x045e, B:151:0x0471, B:155:0x047d, B:158:0x048b, B:163:0x04af, B:165:0x04b5, B:167:0x04bd, B:169:0x04c3, B:161:0x049c, B:149:0x0469, B:137:0x0429, B:99:0x02d6, B:101:0x0301, B:102:0x0312, B:104:0x0319, B:106:0x031f, B:108:0x0329, B:110:0x032f, B:112:0x0335, B:114:0x033b, B:115:0x0340, B:121:0x0364, B:123:0x0368, B:124:0x037c, B:125:0x038c, B:126:0x039c, B:174:0x04e5, B:176:0x0515, B:177:0x0518, B:178:0x052e, B:180:0x0532, B:85:0x025e, B:62:0x01d8, B:31:0x00c6, B:33:0x00ca, B:37:0x00db, B:39:0x00ec, B:41:0x00f6, B:44:0x00fe), top: B:189:0x00a8, inners: #0, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x026e A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #1 {all -> 0x00c3, blocks: (B:23:0x00a8, B:25:0x00b5, B:45:0x0101, B:47:0x0115, B:49:0x012d, B:50:0x0154, B:52:0x01ac, B:54:0x01b4, B:58:0x01c0, B:66:0x01f4, B:68:0x01ff, B:72:0x020c, B:75:0x021a, B:79:0x0225, B:81:0x0229, B:82:0x024a, B:84:0x024f, B:87:0x026e, B:91:0x0282, B:93:0x02ae, B:96:0x02b6, B:98:0x02c5, B:127:0x03ab, B:129:0x03d7, B:130:0x03da, B:132:0x0403, B:172:0x04cc, B:173:0x04cf, B:181:0x054c, B:134:0x0418, B:139:0x043d, B:141:0x0445, B:143:0x044b, B:147:0x045e, B:151:0x0471, B:155:0x047d, B:158:0x048b, B:163:0x04af, B:165:0x04b5, B:167:0x04bd, B:169:0x04c3, B:161:0x049c, B:149:0x0469, B:137:0x0429, B:99:0x02d6, B:101:0x0301, B:102:0x0312, B:104:0x0319, B:106:0x031f, B:108:0x0329, B:110:0x032f, B:112:0x0335, B:114:0x033b, B:115:0x0340, B:121:0x0364, B:123:0x0368, B:124:0x037c, B:125:0x038c, B:126:0x039c, B:174:0x04e5, B:176:0x0515, B:177:0x0518, B:178:0x052e, B:180:0x0532, B:85:0x025e, B:62:0x01d8, B:31:0x00c6, B:33:0x00ca, B:37:0x00db, B:39:0x00ec, B:41:0x00f6, B:44:0x00fe), top: B:189:0x00a8, inners: #0, #3, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(zzq zzqVar) {
        long j10;
        long j11;
        int i10;
        q qVarV;
        boolean z10;
        PackageInfo packageInfoC;
        ApplicationInfo applicationInfoB;
        long j12;
        boolean z11;
        SQLiteDatabase sQLiteDatabaseP;
        String[] strArr;
        int iDelete;
        f().h();
        g();
        t1.f.h(zzqVar);
        t1.f.d(zzqVar.f3976e);
        if (Q(zzqVar)) {
            k kVar = this.f5589c;
            R(kVar);
            e6 e6VarR = kVar.R(zzqVar.f3976e);
            if (e6VarR != null && TextUtils.isEmpty(e6VarR.a()) && !TextUtils.isEmpty(zzqVar.f3977j)) {
                e6VarR.n(0L);
                k kVar2 = this.f5589c;
                R(kVar2);
                kVar2.p(e6VarR);
                y4 y4Var = this.f5587a;
                R(y4Var);
                y4Var.A(zzqVar.f3976e);
            }
            if (!zzqVar.f3983p) {
                S(zzqVar);
                return;
            }
            long jA = zzqVar.f3988u;
            if (jA == 0) {
                jA = a().a();
            }
            long j13 = jA;
            this.f5598l.A().r();
            int i11 = zzqVar.f3989v;
            if (i11 != 0 && i11 != 1) {
                d().w().c("Incorrect app type, assuming installed app. appId, appType", v3.z(zzqVar.f3976e), Integer.valueOf(i11));
                i11 = 0;
            }
            k kVar3 = this.f5589c;
            R(kVar3);
            kVar3.e0();
            try {
                k kVar4 = this.f5589c;
                R(kVar4);
                ta taVarX = kVar4.X(zzqVar.f3976e, "_npa");
                if (taVarX != null && !"auto".equals(taVarX.f5715b)) {
                    j10 = 1;
                } else if (zzqVar.f3993z != null) {
                    j10 = 1;
                    zzlk zzlkVar = new zzlk("_npa", j13, Long.valueOf(true != zzqVar.f3993z.booleanValue() ? 0L : 1L), "auto");
                    if (taVarX == null || !taVarX.f5718e.equals(zzlkVar.f3972l)) {
                        B(zzlkVar, zzqVar);
                    }
                } else {
                    j10 = 1;
                    if (taVarX != null) {
                        u("_npa", zzqVar);
                    }
                }
                k kVar5 = this.f5589c;
                R(kVar5);
                e6 e6VarR2 = kVar5.R((String) t1.f.h(zzqVar.f3976e));
                if (e6VarR2 != null) {
                    j11 = j10;
                    if (h0().d0(zzqVar.f3977j, e6VarR2.a(), zzqVar.f3992y, e6VarR2.j0())) {
                        d().w().b("New GMP App Id passed in. Removing cached database data. appId", v3.z(e6VarR2.l0()));
                        k kVar6 = this.f5589c;
                        R(kVar6);
                        String strL0 = e6VarR2.l0();
                        kVar6.i();
                        kVar6.h();
                        t1.f.d(strL0);
                        try {
                            sQLiteDatabaseP = kVar6.P();
                            strArr = new String[]{strL0};
                            iDelete = sQLiteDatabaseP.delete("events", "app_id=?", strArr) + sQLiteDatabaseP.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseP.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseP.delete("apps", "app_id=?", strArr) + sQLiteDatabaseP.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseP.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseP.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseP.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseP.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseP.delete("consent_settings", "app_id=?", strArr);
                            pc.b();
                            i10 = i11;
                        } catch (SQLiteException e10) {
                            e = e10;
                            i10 = i11;
                        }
                        try {
                            if (kVar6.f5030a.z().B(null, i3.f5338v0)) {
                                iDelete += sQLiteDatabaseP.delete("default_event_params", "app_id=?", strArr);
                            }
                            if (iDelete > 0) {
                                kVar6.f5030a.d().v().c("Deleted application data. app, records", strL0, Integer.valueOf(iDelete));
                            }
                        } catch (SQLiteException e11) {
                            e = e11;
                            kVar6.f5030a.d().r().c("Error deleting application data. appId, error", v3.z(strL0), e);
                            e6VarR2 = null;
                            if (e6VarR2 != null) {
                            }
                            S(zzqVar);
                            if (i10 == 0) {
                            }
                            if (qVarV == null) {
                            }
                            k kVar7 = this.f5589c;
                            R(kVar7);
                            kVar7.o();
                            k kVar8 = this.f5589c;
                            R(kVar8);
                            kVar8.f0();
                        }
                        e6VarR2 = null;
                    }
                    if (e6VarR2 != null) {
                        boolean z12 = (e6VarR2.R() == -2147483648L || e6VarR2.R() == zzqVar.f3985r) ? false : true;
                        String strO0 = e6VarR2.o0();
                        if (z12 | ((e6VarR2.R() != -2147483648L || strO0 == null || strO0.equals(zzqVar.f3978k)) ? false : true)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", strO0);
                            zzau zzauVar = new zzau("_au", new zzas(bundle), "auto", j13);
                            j13 = j13;
                            j(zzauVar, zzqVar);
                        }
                    }
                    S(zzqVar);
                    if (i10 == 0) {
                        k kVar9 = this.f5589c;
                        R(kVar9);
                        qVarV = kVar9.V(zzqVar.f3976e, "_f");
                        z10 = false;
                    } else {
                        k kVar10 = this.f5589c;
                        R(kVar10);
                        qVarV = kVar10.V(zzqVar.f3976e, "_v");
                        z10 = true;
                    }
                    if (qVarV == null) {
                        long j14 = ((j13 / 3600000) + j11) * 3600000;
                        if (z10) {
                            B(new zzlk("_fvt", j13, Long.valueOf(j14), "auto"), zzqVar);
                            f().h();
                            g();
                            Bundle bundle2 = new Bundle();
                            bundle2.putLong("_c", 1L);
                            bundle2.putLong("_r", 1L);
                            bundle2.putLong("_et", 1L);
                            if (zzqVar.f3991x) {
                                bundle2.putLong("_dac", 1L);
                            }
                            l(new zzau("_v", new zzas(bundle2), "auto", j13), zzqVar);
                        } else {
                            B(new zzlk("_fot", j13, Long.valueOf(j14), "auto"), zzqVar);
                            f().h();
                            o4 o4Var = (o4) t1.f.h(this.f5597k);
                            String str = zzqVar.f3976e;
                            if (str == null || str.isEmpty()) {
                                o4Var.f5544a.d().y().a("Install Referrer Reporter was called with invalid app package name");
                            } else {
                                o4Var.f5544a.f().h();
                                if (o4Var.a()) {
                                    n4 n4Var = new n4(o4Var, str);
                                    o4Var.f5544a.f().h();
                                    Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                    intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                    PackageManager packageManager = o4Var.f5544a.c().getPackageManager();
                                    if (packageManager == null) {
                                        o4Var.f5544a.d().y().a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                    } else {
                                        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                            o4Var.f5544a.d().u().a("Play Service for fetching Install Referrer is unavailable on device");
                                        } else {
                                            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                                            if (serviceInfo != null) {
                                                String str2 = serviceInfo.packageName;
                                                if (serviceInfo.name != null && "com.android.vending".equals(str2) && o4Var.a()) {
                                                    try {
                                                        o4Var.f5544a.d().v().b("Install Referrer Service is", v1.b.b().a(o4Var.f5544a.c(), new Intent(intent), n4Var, 1) ? "available" : "not available");
                                                    } catch (RuntimeException e12) {
                                                        o4Var.f5544a.d().r().b("Exception occurred while binding to Install Referrer Service", e12.getMessage());
                                                    }
                                                } else {
                                                    o4Var.f5544a.d().w().a("Play Store version 8.3.73 or higher required for Install Referrer");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    o4Var.f5544a.d().u().a("Install Referrer Reporter is not available");
                                }
                            }
                            f().h();
                            g();
                            Bundle bundle3 = new Bundle();
                            long j15 = j11;
                            bundle3.putLong("_c", j15);
                            bundle3.putLong("_r", j15);
                            bundle3.putLong("_uwa", 0L);
                            bundle3.putLong("_pfo", 0L);
                            bundle3.putLong("_sys", 0L);
                            bundle3.putLong("_sysu", 0L);
                            bundle3.putLong("_et", j15);
                            if (zzqVar.f3991x) {
                                bundle3.putLong("_dac", j15);
                            }
                            String str3 = (String) t1.f.h(zzqVar.f3976e);
                            k kVar11 = this.f5589c;
                            R(kVar11);
                            t1.f.d(str3);
                            kVar11.h();
                            kVar11.i();
                            long jL = kVar11.L(str3, "first_open_count");
                            if (this.f5598l.c().getPackageManager() == null) {
                                d().r().b("PackageManager is null, first open report might be inaccurate. appId", v3.z(str3));
                            } else {
                                try {
                                    packageInfoC = x1.e.a(this.f5598l.c()).c(str3, 0);
                                } catch (PackageManager.NameNotFoundException e13) {
                                    d().r().c("Package info is null, first open report might be inaccurate. appId", v3.z(str3), e13);
                                    packageInfoC = null;
                                }
                                if (packageInfoC != null) {
                                    long j16 = packageInfoC.firstInstallTime;
                                    if (j16 != 0) {
                                        if (j16 != packageInfoC.lastUpdateTime) {
                                            applicationInfoB = null;
                                            if (!U().B(null, i3.f5306f0)) {
                                                bundle3.putLong("_uwa", 1L);
                                            } else if (jL == 0) {
                                                bundle3.putLong("_uwa", 1L);
                                                z11 = false;
                                                jL = 0;
                                            }
                                            z11 = false;
                                        } else {
                                            applicationInfoB = null;
                                            z11 = true;
                                        }
                                        B(new zzlk("_fi", j13, Long.valueOf(true != z11 ? 0L : 1L), "auto"), zzqVar);
                                    } else {
                                        applicationInfoB = null;
                                    }
                                    try {
                                        applicationInfoB = x1.e.a(this.f5598l.c()).b(str3, 0);
                                    } catch (PackageManager.NameNotFoundException e14) {
                                        d().r().c("Application info is null, first open report might be inaccurate. appId", v3.z(str3), e14);
                                    }
                                    if (applicationInfoB != null) {
                                        if ((applicationInfoB.flags & 1) != 0) {
                                            j12 = 1;
                                            bundle3.putLong("_sys", 1L);
                                        } else {
                                            j12 = 1;
                                        }
                                        if ((applicationInfoB.flags & 128) != 0) {
                                            bundle3.putLong("_sysu", j12);
                                        }
                                    }
                                }
                            }
                            if (jL >= 0) {
                                bundle3.putLong("_pfo", jL);
                            }
                            l(new zzau("_f", new zzas(bundle3), "auto", j13), zzqVar);
                        }
                    } else if (zzqVar.f3984q) {
                        l(new zzau("_cd", new zzas(new Bundle()), "auto", j13), zzqVar);
                    }
                    k kVar72 = this.f5589c;
                    R(kVar72);
                    kVar72.o();
                    k kVar82 = this.f5589c;
                    R(kVar82);
                    kVar82.f0();
                }
                j11 = j10;
                i10 = i11;
                if (e6VarR2 != null) {
                }
                S(zzqVar);
                if (i10 == 0) {
                }
                if (qVarV == null) {
                }
                k kVar722 = this.f5589c;
                R(kVar722);
                kVar722.o();
                k kVar822 = this.f5589c;
                R(kVar822);
                kVar822.f0();
            } catch (Throwable th) {
                k kVar12 = this.f5589c;
                R(kVar12);
                kVar12.f0();
                throw th;
            }
        }
    }

    public final void r() {
        this.f5603q++;
    }

    public final void s(zzac zzacVar) {
        zzq zzqVarI = I((String) t1.f.h(zzacVar.f3952e));
        if (zzqVarI != null) {
            t(zzacVar, zzqVarI);
        }
    }

    public final void t(zzac zzacVar, zzq zzqVar) {
        t1.f.h(zzacVar);
        t1.f.d(zzacVar.f3952e);
        t1.f.h(zzacVar.f3954k);
        t1.f.d(zzacVar.f3954k.f3970j);
        f().h();
        g();
        if (Q(zzqVar)) {
            if (!zzqVar.f3983p) {
                S(zzqVar);
                return;
            }
            k kVar = this.f5589c;
            R(kVar);
            kVar.e0();
            try {
                S(zzqVar);
                String str = (String) t1.f.h(zzacVar.f3952e);
                k kVar2 = this.f5589c;
                R(kVar2);
                zzac zzacVarS = kVar2.S(str, zzacVar.f3954k.f3970j);
                if (zzacVarS != null) {
                    d().q().c("Removing conditional user property", zzacVar.f3952e, this.f5598l.D().f(zzacVar.f3954k.f3970j));
                    k kVar3 = this.f5589c;
                    R(kVar3);
                    kVar3.J(str, zzacVar.f3954k.f3970j);
                    if (zzacVarS.f3956m) {
                        k kVar4 = this.f5589c;
                        R(kVar4);
                        kVar4.m(str, zzacVar.f3954k.f3970j);
                    }
                    zzau zzauVar = zzacVar.f3962s;
                    if (zzauVar != null) {
                        zzas zzasVar = zzauVar.f3965j;
                        D((zzau) t1.f.h(h0().y0(str, ((zzau) t1.f.h(zzacVar.f3962s)).f3964e, zzasVar != null ? zzasVar.g() : null, zzacVarS.f3953j, zzacVar.f3962s.f3967l, true, true)), zzqVar);
                    }
                } else {
                    d().w().c("Conditional user property doesn't exist", v3.z(zzacVar.f3952e), this.f5598l.D().f(zzacVar.f3954k.f3970j));
                }
                k kVar5 = this.f5589c;
                R(kVar5);
                kVar5.o();
                k kVar6 = this.f5589c;
                R(kVar6);
                kVar6.f0();
            } catch (Throwable th) {
                k kVar7 = this.f5589c;
                R(kVar7);
                kVar7.f0();
                throw th;
            }
        }
    }

    public final void u(String str, zzq zzqVar) {
        f().h();
        g();
        if (Q(zzqVar)) {
            if (!zzqVar.f3983p) {
                S(zzqVar);
                return;
            }
            if ("_npa".equals(str) && zzqVar.f3993z != null) {
                d().q().a("Falling back to manifest metadata value for ad personalization");
                B(new zzlk("_npa", a().a(), Long.valueOf(true != zzqVar.f3993z.booleanValue() ? 0L : 1L), "auto"), zzqVar);
                return;
            }
            d().q().b("Removing user property", this.f5598l.D().f(str));
            k kVar = this.f5589c;
            R(kVar);
            kVar.e0();
            try {
                S(zzqVar);
                if ("_id".equals(str)) {
                    k kVar2 = this.f5589c;
                    R(kVar2);
                    kVar2.m((String) t1.f.h(zzqVar.f3976e), "_lair");
                }
                k kVar3 = this.f5589c;
                R(kVar3);
                kVar3.m((String) t1.f.h(zzqVar.f3976e), str);
                k kVar4 = this.f5589c;
                R(kVar4);
                kVar4.o();
                d().q().b("User property removed", this.f5598l.D().f(str));
                k kVar5 = this.f5589c;
                R(kVar5);
                kVar5.f0();
            } catch (Throwable th) {
                k kVar6 = this.f5589c;
                R(kVar6);
                kVar6.f0();
                throw th;
            }
        }
    }

    public final void v(zzq zzqVar) {
        if (this.f5610x != null) {
            ArrayList arrayList = new ArrayList();
            this.f5611y = arrayList;
            arrayList.addAll(this.f5610x);
        }
        k kVar = this.f5589c;
        R(kVar);
        String str = (String) t1.f.h(zzqVar.f3976e);
        t1.f.d(str);
        kVar.h();
        kVar.i();
        try {
            SQLiteDatabase sQLiteDatabaseP = kVar.P();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseP.delete("apps", "app_id=?", strArr) + sQLiteDatabaseP.delete("events", "app_id=?", strArr) + sQLiteDatabaseP.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseP.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseP.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseP.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseP.delete("queue", "app_id=?", strArr) + sQLiteDatabaseP.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseP.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseP.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                kVar.f5030a.d().v().c("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e10) {
            kVar.f5030a.d().r().c("Error resetting analytics data. appId, error", v3.z(str), e10);
        }
        if (zzqVar.f3983p) {
            q(zzqVar);
        }
    }

    public final void w(String str, v7 v7Var) {
        f().h();
        String str2 = this.D;
        if (str2 == null || str2.equals(str) || v7Var != null) {
            this.D = str;
            this.C = v7Var;
        }
    }

    public final void x() {
        f().h();
        k kVar = this.f5589c;
        R(kVar);
        kVar.h0();
        if (this.f5595i.f5219g.a() == 0) {
            this.f5595i.f5219g.b(a().a());
        }
        M();
    }

    public final void y(zzac zzacVar) {
        zzq zzqVarI = I((String) t1.f.h(zzacVar.f3952e));
        if (zzqVarI != null) {
            z(zzacVar, zzqVarI);
        }
    }

    public final void z(zzac zzacVar, zzq zzqVar) {
        t1.f.h(zzacVar);
        t1.f.d(zzacVar.f3952e);
        t1.f.h(zzacVar.f3953j);
        t1.f.h(zzacVar.f3954k);
        t1.f.d(zzacVar.f3954k.f3970j);
        f().h();
        g();
        if (Q(zzqVar)) {
            if (!zzqVar.f3983p) {
                S(zzqVar);
                return;
            }
            zzac zzacVar2 = new zzac(zzacVar);
            boolean z10 = false;
            zzacVar2.f3956m = false;
            k kVar = this.f5589c;
            R(kVar);
            kVar.e0();
            try {
                k kVar2 = this.f5589c;
                R(kVar2);
                zzac zzacVarS = kVar2.S((String) t1.f.h(zzacVar2.f3952e), zzacVar2.f3954k.f3970j);
                if (zzacVarS != null && !zzacVarS.f3953j.equals(zzacVar2.f3953j)) {
                    d().w().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f5598l.D().f(zzacVar2.f3954k.f3970j), zzacVar2.f3953j, zzacVarS.f3953j);
                }
                if (zzacVarS != null && zzacVarS.f3956m) {
                    zzacVar2.f3953j = zzacVarS.f3953j;
                    zzacVar2.f3955l = zzacVarS.f3955l;
                    zzacVar2.f3959p = zzacVarS.f3959p;
                    zzacVar2.f3957n = zzacVarS.f3957n;
                    zzacVar2.f3960q = zzacVarS.f3960q;
                    zzacVar2.f3956m = true;
                    zzlk zzlkVar = zzacVar2.f3954k;
                    zzacVar2.f3954k = new zzlk(zzlkVar.f3970j, zzacVarS.f3954k.f3971k, zzlkVar.c(), zzacVarS.f3954k.f3974n);
                } else if (TextUtils.isEmpty(zzacVar2.f3957n)) {
                    zzlk zzlkVar2 = zzacVar2.f3954k;
                    zzacVar2.f3954k = new zzlk(zzlkVar2.f3970j, zzacVar2.f3955l, zzlkVar2.c(), zzacVar2.f3954k.f3974n);
                    zzacVar2.f3956m = true;
                    z10 = true;
                }
                if (zzacVar2.f3956m) {
                    zzlk zzlkVar3 = zzacVar2.f3954k;
                    ta taVar = new ta((String) t1.f.h(zzacVar2.f3952e), zzacVar2.f3953j, zzlkVar3.f3970j, zzlkVar3.f3971k, t1.f.h(zzlkVar3.c()));
                    k kVar3 = this.f5589c;
                    R(kVar3);
                    if (kVar3.x(taVar)) {
                        d().q().d("User property updated immediately", zzacVar2.f3952e, this.f5598l.D().f(taVar.f5716c), taVar.f5718e);
                    } else {
                        d().r().d("(2)Too many active user properties, ignoring", v3.z(zzacVar2.f3952e), this.f5598l.D().f(taVar.f5716c), taVar.f5718e);
                    }
                    if (z10 && zzacVar2.f3960q != null) {
                        D(new zzau(zzacVar2.f3960q, zzacVar2.f3955l), zzqVar);
                    }
                }
                k kVar4 = this.f5589c;
                R(kVar4);
                if (kVar4.w(zzacVar2)) {
                    d().q().d("Conditional property added", zzacVar2.f3952e, this.f5598l.D().f(zzacVar2.f3954k.f3970j), zzacVar2.f3954k.c());
                } else {
                    d().r().d("Too many conditional properties, ignoring", v3.z(zzacVar2.f3952e), this.f5598l.D().f(zzacVar2.f3954k.f3970j), zzacVar2.f3954k.c());
                }
                k kVar5 = this.f5589c;
                R(kVar5);
                kVar5.o();
                k kVar6 = this.f5589c;
                R(kVar6);
                kVar6.f0();
            } catch (Throwable th) {
                k kVar7 = this.f5589c;
                R(kVar7);
                kVar7.f0();
                throw th;
            }
        }
    }
}
