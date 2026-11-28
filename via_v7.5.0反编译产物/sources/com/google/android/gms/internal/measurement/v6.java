package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class v6 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile s6 f3139g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r6 f3143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f3146d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f3147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f3138f = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReference f3140h = new AtomicReference();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x6 f3141i = new x6(m6.f2917a);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicInteger f3142j = new AtomicInteger();

    public /* synthetic */ v6(r6 r6Var, String str, Object obj, boolean z10, u6 u6Var) {
        if (r6Var.f3026a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f3143a = r6Var;
        this.f3144b = str;
        this.f3145c = obj;
    }

    public static void c() {
        f3142j.incrementAndGet();
    }

    public static void d(final Context context) {
        if (f3139g != null || context == null) {
            return;
        }
        Object obj = f3138f;
        synchronized (obj) {
            try {
                if (f3139g == null) {
                    synchronized (obj) {
                        try {
                            s6 s6Var = f3139g;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                context = applicationContext;
                            }
                            if (s6Var == null || s6Var.a() != context) {
                                y5.e();
                                w6.c();
                                f6.e();
                                f3139g = new v5(context, g7.a(new d7() { // from class: com.google.android.gms.internal.measurement.l6
                                    @Override // com.google.android.gms.internal.measurement.d7
                                    public final Object zza() {
                                        Context context2 = context;
                                        Object obj2 = v6.f3138f;
                                        return h6.a(context2);
                                    }
                                }));
                                f3142j.incrementAndGet();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract Object a(Object obj);

    /* JADX WARN: Code duplicated, block: B:14:0x003e A[PHI: r2
  0x003e: PHI (r2v1 com.google.android.gms.internal.measurement.zzii) = (r2v0 com.google.android.gms.internal.measurement.zzii), (r2v5 com.google.android.gms.internal.measurement.zzii) binds: [B:8:0x0016, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:28:0x0081  */
    /* JADX WARN: Code duplicated, block: B:30:0x0084 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008a A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    /* JADX WARN: Code duplicated, block: B:35:0x009a A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a2 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b4 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b7 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    public final Object b() {
        String strA;
        y5 y5VarB;
        Object objA;
        String str;
        String strC;
        Object objA2;
        int i10 = f3142j.get();
        if (this.f3146d < i10) {
            synchronized (this) {
                try {
                    if (this.f3146d < i10) {
                        s6 s6Var = f3139g;
                        zzii zziiVarZzc = zzii.zzc();
                        Object objA3 = null;
                        if (s6Var != null) {
                            zziiVarZzc = (zzii) s6Var.b().zza();
                            if (zziiVarZzc.zzb()) {
                                z5 z5Var = (z5) zziiVarZzc.zza();
                                r6 r6Var = this.f3143a;
                                strA = z5Var.a(r6Var.f3026a, null, r6Var.f3028c, this.f3144b);
                            } else {
                                strA = null;
                            }
                        } else {
                            strA = null;
                        }
                        if (s6Var == null) {
                            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                        }
                        Uri uri = this.f3143a.f3026a;
                        if (uri != null) {
                            if (i6.a(s6Var.a(), uri)) {
                                y5VarB = y5.b(s6Var.a().getContentResolver(), this.f3143a.f3026a, new Runnable() { // from class: com.google.android.gms.internal.measurement.k6
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        v6.c();
                                    }
                                });
                            }
                            if (y5VarB != null || (objA2 = y5VarB.a(this.f3144b)) == null) {
                                objA = null;
                            } else {
                                objA = a(objA2);
                            }
                            if (objA == null) {
                                if (!this.f3143a.f3029d) {
                                    f6 f6VarB = f6.b(s6Var.a());
                                    if (this.f3143a.f3029d) {
                                        str = null;
                                    } else {
                                        str = this.f3144b;
                                    }
                                    strC = f6VarB.a(str);
                                    if (strC != null) {
                                        objA3 = a(strC);
                                    }
                                }
                                if (objA3 == null) {
                                    objA = this.f3145c;
                                } else {
                                    objA = objA3;
                                }
                            }
                            if (zziiVarZzc.zzb()) {
                                if (strA == null) {
                                    objA = this.f3145c;
                                } else {
                                    objA = a(strA);
                                }
                            }
                            this.f3147e = objA;
                            this.f3146d = i10;
                        } else {
                            w6.b(s6Var.a(), null, new Runnable() { // from class: com.google.android.gms.internal.measurement.k6
                                @Override // java.lang.Runnable
                                public final void run() {
                                    v6.c();
                                }
                            });
                        }
                        y5VarB = null;
                        if (y5VarB != null) {
                            objA = null;
                        } else {
                            objA = null;
                        }
                        if (objA == null) {
                            if (!this.f3143a.f3029d) {
                                f6 f6VarB2 = f6.b(s6Var.a());
                                if (this.f3143a.f3029d) {
                                    str = null;
                                } else {
                                    str = this.f3144b;
                                }
                                strC = f6VarB2.a(str);
                                if (strC != null) {
                                    objA3 = a(strC);
                                }
                            }
                            if (objA3 == null) {
                                objA = this.f3145c;
                            } else {
                                objA = objA3;
                            }
                        }
                        if (zziiVarZzc.zzb()) {
                            if (strA == null) {
                                objA = this.f3145c;
                            } else {
                                objA = a(strA);
                            }
                        }
                        this.f3147e = objA;
                        this.f3146d = i10;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f3147e;
    }
}
