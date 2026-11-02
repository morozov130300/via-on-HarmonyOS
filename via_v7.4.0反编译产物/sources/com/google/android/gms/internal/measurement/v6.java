package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class v6 {

    /* renamed from: g, reason: collision with root package name */
    public static volatile s6 f3840g;

    /* renamed from: a, reason: collision with root package name */
    public final r6 f3844a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3845b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3846c;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f3847d = -1;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f3848e;

    /* renamed from: f, reason: collision with root package name */
    public static final Object f3839f = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReference f3841h = new AtomicReference();

    /* renamed from: i, reason: collision with root package name */
    public static final x6 f3842i = new x6(m6.f3618a);

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicInteger f3843j = new AtomicInteger();

    public /* synthetic */ v6(r6 r6Var, String str, Object obj, boolean z10, u6 u6Var) {
        if (r6Var.f3727a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f3844a = r6Var;
        this.f3845b = str;
        this.f3846c = obj;
    }

    public static void c() {
        f3843j.incrementAndGet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(final Context context) {
        if (f3840g != null || context == null) {
            return;
        }
        Object obj = f3839f;
        synchronized (obj) {
            try {
                if (f3840g == null) {
                    synchronized (obj) {
                        s6 s6Var = f3840g;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (s6Var == null || s6Var.a() != context) {
                            y5.e();
                            w6.c();
                            f6.e();
                            f3840g = new v5(context, g7.a(new d7() { // from class: com.google.android.gms.internal.measurement.l6
                                @Override // com.google.android.gms.internal.measurement.d7
                                public final Object zza() {
                                    Context context2 = context;
                                    Object obj2 = v6.f3839f;
                                    return h6.a(context2);
                                }
                            }));
                            f3843j.incrementAndGet();
                        }
                    }
                }
            } finally {
            }
        }
    }

    public abstract Object a(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[PHI: r2
  0x003e: PHI (r2v1 com.google.android.gms.internal.measurement.zzii) = (r2v0 com.google.android.gms.internal.measurement.zzii), (r2v5 com.google.android.gms.internal.measurement.zzii) binds: [B:8:0x0016, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x0028, B:17:0x0043, B:19:0x0049, B:21:0x0053, B:25:0x0074, B:27:0x007c, B:30:0x0084, B:32:0x008a, B:36:0x009c, B:38:0x00a2, B:35:0x009a, B:40:0x00a8, B:42:0x00ac, B:45:0x00b4, B:46:0x00b7, B:47:0x00bb, B:23:0x0068, B:48:0x00c0, B:49:0x00c5, B:50:0x00c6), top: B:56:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b() {
        String strA;
        y5 y5VarB;
        Object objA;
        Object objA2;
        int i10 = f3843j.get();
        if (this.f3847d < i10) {
            synchronized (this) {
                try {
                    if (this.f3847d < i10) {
                        s6 s6Var = f3840g;
                        zzii zziiVarZzc = zzii.zzc();
                        Object objA3 = null;
                        if (s6Var != null) {
                            zziiVarZzc = (zzii) s6Var.b().zza();
                            if (zziiVarZzc.zzb()) {
                                z5 z5Var = (z5) zziiVarZzc.zza();
                                r6 r6Var = this.f3844a;
                                strA = z5Var.a(r6Var.f3727a, null, r6Var.f3729c, this.f3845b);
                            } else {
                                strA = null;
                            }
                            if (s6Var == null) {
                                throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                            }
                            Uri uri = this.f3844a.f3727a;
                            if (uri != null) {
                                if (i6.a(s6Var.a(), uri)) {
                                    y5VarB = y5.b(s6Var.a().getContentResolver(), this.f3844a.f3727a, new Runnable() { // from class: com.google.android.gms.internal.measurement.k6
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            v6.c();
                                        }
                                    });
                                }
                                objA = (y5VarB != null || (objA2 = y5VarB.a(this.f3845b)) == null) ? null : a(objA2);
                                if (objA == null) {
                                    if (!this.f3844a.f3730d) {
                                        String strC = f6.b(s6Var.a()).a(this.f3844a.f3730d ? null : this.f3845b);
                                        if (strC != null) {
                                            objA3 = a(strC);
                                        }
                                    }
                                    objA = objA3 == null ? this.f3846c : objA3;
                                }
                                if (zziiVarZzc.zzb()) {
                                    objA = strA == null ? this.f3846c : a(strA);
                                }
                                this.f3848e = objA;
                                this.f3847d = i10;
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
                                if (objA == null) {
                                }
                                if (zziiVarZzc.zzb()) {
                                }
                                this.f3848e = objA;
                                this.f3847d = i10;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        return this.f3848e;
    }
}
