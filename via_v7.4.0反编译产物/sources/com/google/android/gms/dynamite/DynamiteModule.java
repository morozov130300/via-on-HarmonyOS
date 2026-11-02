package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f3370h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f3371i = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f3372j = false;

    /* renamed from: k, reason: collision with root package name */
    public static int f3373k = -1;

    /* renamed from: l, reason: collision with root package name */
    public static Boolean f3374l;

    /* renamed from: q, reason: collision with root package name */
    public static z1.h f3379q;

    /* renamed from: r, reason: collision with root package name */
    public static z1.i f3380r;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3381a;

    /* renamed from: m, reason: collision with root package name */
    public static final ThreadLocal f3375m = new ThreadLocal();

    /* renamed from: n, reason: collision with root package name */
    public static final ThreadLocal f3376n = new z1.d();

    /* renamed from: o, reason: collision with root package name */
    public static final a.InterfaceC0046a f3377o = new com.google.android.gms.dynamite.a();

    /* renamed from: b, reason: collision with root package name */
    public static final a f3364b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final a f3365c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final a f3366d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final a f3367e = new e();

    /* renamed from: f, reason: collision with root package name */
    public static final a f3368f = new f();

    /* renamed from: g, reason: collision with root package name */
    public static final a f3369g = new g();

    /* renamed from: p, reason: collision with root package name */
    public static final a f3378p = new h();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, Throwable th, z1.g gVar) {
            super(str, th);
        }

        public /* synthetic */ LoadingException(String str, z1.g gVar) {
            super(str);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a, reason: collision with other inner class name */
        public interface InterfaceC0046a {
            int a(Context context, String str, boolean z10);

            int b(Context context, String str);
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public int f3382a = 0;

            /* renamed from: b, reason: collision with root package name */
            public int f3383b = 0;

            /* renamed from: c, reason: collision with root package name */
            public int f3384c = 0;
        }

        b a(Context context, String str, InterfaceC0046a interfaceC0046a);
    }

    public DynamiteModule(Context context) {
        t1.f.h(context);
        this.f3381a = context;
    }

    public static int a(Context context, String str) throws NoSuchFieldException, ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (t1.e.a(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    public static int b(Context context, String str) {
        return e(context, str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #1 {all -> 0x0075, blocks: (B:5:0x003a, B:9:0x006f, B:16:0x007b, B:19:0x0081, B:30:0x009d, B:117:0x0218, B:118:0x0223, B:121:0x0226, B:122:0x0227, B:123:0x022f, B:140:0x0286, B:141:0x029d, B:124:0x0230, B:126:0x024e, B:128:0x025d, B:138:0x027d, B:139:0x0285, B:142:0x029e, B:143:0x02ce), top: B:155:0x003a, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DynamiteModule d(Context context, a aVar, String str) throws Throwable {
        long j10;
        Boolean bool;
        y1.a aVarD0;
        DynamiteModule dynamiteModule;
        z1.i iVar;
        boolean z10;
        y1.a aVarA0;
        ThreadLocal threadLocal = f3375m;
        z1.f fVar = (z1.f) threadLocal.get();
        z1.g gVar = null;
        z1.f fVar2 = new z1.f(null);
        threadLocal.set(fVar2);
        ThreadLocal threadLocal2 = f3376n;
        Long l10 = (Long) threadLocal2.get();
        long jLongValue = l10.longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            a.b bVarA = aVar.a(context, str, f3377o);
            j10 = 0;
            try {
                Log.i("DynamiteModule", "Considering local module " + str + ":" + bVarA.f3382a + " and remote module " + str + ":" + bVarA.f3383b);
                int i10 = bVarA.f3384c;
                if (i10 != 0) {
                    if (i10 != -1) {
                        if (i10 == 1 || bVarA.f3383b != 0) {
                            if (i10 != -1) {
                                DynamiteModule dynamiteModuleG = g(context, str);
                                if (jLongValue == 0) {
                                    threadLocal2.remove();
                                } else {
                                    threadLocal2.set(l10);
                                }
                                Cursor cursor = fVar2.f14557a;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                threadLocal.set(fVar);
                                return dynamiteModuleG;
                            }
                            if (i10 != 1) {
                                throw new LoadingException("VersionPolicy returned invalid code:" + i10, null);
                            }
                            try {
                                int i11 = bVarA.f3383b;
                                try {
                                    synchronized (DynamiteModule.class) {
                                        if (!j(context)) {
                                            throw new LoadingException("Remote loading disabled", null);
                                        }
                                        bool = f3370h;
                                    }
                                    if (bool == null) {
                                        throw new LoadingException("Failed to determine which loading route to use.", null);
                                    }
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i11);
                                        synchronized (DynamiteModule.class) {
                                            iVar = f3380r;
                                        }
                                        if (iVar == null) {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                        }
                                        z1.f fVar3 = (z1.f) threadLocal.get();
                                        if (fVar3 == null || fVar3.f14557a == null) {
                                            throw new LoadingException("No result cursor", null);
                                        }
                                        Context applicationContext = context.getApplicationContext();
                                        Cursor cursor2 = fVar3.f14557a;
                                        y1.b.b0(null);
                                        synchronized (DynamiteModule.class) {
                                            z10 = f3373k >= 2;
                                        }
                                        if (z10) {
                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                            aVarA0 = iVar.b0(y1.b.b0(applicationContext), str, i11, y1.b.b0(cursor2));
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                            aVarA0 = iVar.a0(y1.b.b0(applicationContext), str, i11, y1.b.b0(cursor2));
                                        }
                                        Context context2 = (Context) y1.b.a0(aVarA0);
                                        if (context2 == null) {
                                            throw new LoadingException("Failed to get module context", gVar);
                                        }
                                        dynamiteModule = new DynamiteModule(context2);
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i11);
                                        z1.h hVarK = k(context);
                                        if (hVarK == null) {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                        }
                                        int iA0 = hVarK.a0();
                                        if (iA0 >= 3) {
                                            z1.f fVar4 = (z1.f) threadLocal.get();
                                            if (fVar4 == null) {
                                                throw new LoadingException("No cached result cursor holder", null);
                                            }
                                            aVarD0 = hVarK.e0(y1.b.b0(context), str, i11, y1.b.b0(fVar4.f14557a));
                                        } else if (iA0 == 2) {
                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                            aVarD0 = hVarK.f0(y1.b.b0(context), str, i11);
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            aVarD0 = hVarK.d0(y1.b.b0(context), str, i11);
                                        }
                                        Object objA0 = y1.b.a0(aVarD0);
                                        if (objA0 == null) {
                                            throw new LoadingException("Failed to load remote module.", null);
                                        }
                                        dynamiteModule = new DynamiteModule((Context) objA0);
                                    }
                                    if (jLongValue == 0) {
                                        threadLocal2.remove();
                                    } else {
                                        threadLocal2.set(l10);
                                    }
                                    Cursor cursor3 = fVar2.f14557a;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal.set(fVar);
                                    return dynamiteModule;
                                } catch (RemoteException e10) {
                                    throw new LoadingException("Failed to load remote module.", e10, null);
                                } catch (LoadingException e11) {
                                    throw e11;
                                } catch (Throwable th) {
                                    w1.e.a(context, th);
                                    throw new LoadingException("Failed to load remote module.", th, null);
                                }
                            } catch (LoadingException e12) {
                                Log.w("DynamiteModule", "Failed to load remote module: " + e12.getMessage());
                                int i12 = bVarA.f3382a;
                                if (i12 == 0 || aVar.a(context, str, new i(i12, 0)).f3384c != -1) {
                                    throw new LoadingException("Remote load failed. No local fallback found.", e12, null);
                                }
                                DynamiteModule dynamiteModuleG2 = g(context, str);
                                if (jLongValue == 0) {
                                    f3376n.remove();
                                } else {
                                    f3376n.set(l10);
                                }
                                Cursor cursor4 = fVar2.f14557a;
                                if (cursor4 != null) {
                                    cursor4.close();
                                }
                                f3375m.set(fVar);
                                return dynamiteModuleG2;
                            }
                        }
                    } else if (bVarA.f3382a != 0) {
                        i10 = -1;
                        if (i10 == 1) {
                        }
                        if (i10 != -1) {
                        }
                    }
                }
                throw new LoadingException("No acceptable module " + str + " found. Local version is " + bVarA.f3382a + " and remote version is " + bVarA.f3383b + ".", null);
            } catch (Throwable th2) {
                th = th2;
                if (jLongValue == j10) {
                    f3376n.remove();
                } else {
                    f3376n.set(l10);
                }
                Cursor cursor5 = fVar2.f14557a;
                if (cursor5 != null) {
                    cursor5.close();
                }
                f3375m.set(fVar);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j10 = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x017b A[Catch: all -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00ea, blocks: (B:3:0x0002, B:64:0x00df, B:66:0x00e5, B:74:0x010b, B:102:0x016d, B:106:0x017b, B:124:0x01d0, B:125:0x01d3, B:119:0x01c7, B:72:0x00f0, B:127:0x01d5, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:62:0x00dc, B:21:0x0049, B:45:0x009f, B:48:0x00a2, B:55:0x00ba, B:63:0x00de, B:61:0x00c0), top: B:134:0x0002, inners: #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae A[Catch: all -> 0x0036, TryCatch #9 {, blocks: (B:9:0x0026, B:11:0x0032, B:52:0x00b7, B:16:0x003b, B:18:0x0042, B:20:0x0048, B:25:0x004f, B:27:0x0053, B:31:0x005d, B:33:0x0065, B:36:0x006c, B:43:0x0096, B:44:0x009e, B:39:0x0073, B:41:0x0079, B:42:0x0088, B:47:0x00a1, B:50:0x00a4, B:51:0x00ae, B:17:0x003e), top: B:141:0x0026, inners: #12 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x01c5 -> B:135:0x01ca). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x01c7 -> B:135:0x01ca). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(Context context, String str, boolean z10) {
        Field declaredField;
        Throwable th;
        RemoteException remoteException;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f3370h;
                int iB0 = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e10) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e10.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                h(classLoader);
                            } catch (LoadingException unused) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            if (!j(context)) {
                                return 0;
                            }
                            if (!f3372j) {
                                Boolean bool2 = Boolean.TRUE;
                                if (bool2.equals(null)) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        int iF = f(context, str, z10, true);
                                        String str2 = f3371i;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader classLoaderA = z1.b.a();
                                            if (classLoaderA == null) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    String str3 = f3371i;
                                                    t1.f.h(str3);
                                                    classLoaderA = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                                } else {
                                                    String str4 = f3371i;
                                                    t1.f.h(str4);
                                                    classLoaderA = new z1.c(str4, ClassLoader.getSystemClassLoader());
                                                }
                                            }
                                            h(classLoaderA);
                                            declaredField.set(null, classLoaderA);
                                            f3370h = bool2;
                                            return iF;
                                        }
                                        return iF;
                                    } catch (LoadingException unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                        }
                        f3370h = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return f(context, str, z10, false);
                    } catch (LoadingException e11) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e11.getMessage());
                        return 0;
                    }
                }
                z1.h hVarK = k(context);
                try {
                    if (hVarK != null) {
                        try {
                            int iA0 = hVarK.a0();
                            if (iA0 >= 3) {
                                z1.f fVar = (z1.f) f3375m.get();
                                if (fVar == null || (cursor = fVar.f14557a) == null) {
                                    Cursor cursor2 = (Cursor) y1.b.a0(hVarK.g0(y1.b.b0(context), str, z10, ((Long) f3376n.get()).longValue()));
                                    if (cursor2 != null) {
                                        try {
                                            if (cursor2.moveToFirst()) {
                                                int i10 = cursor2.getInt(0);
                                                cursor = (i10 <= 0 || !i(cursor2)) ? cursor2 : null;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                iB0 = i10;
                                            } else {
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                            }
                                        } catch (RemoteException e12) {
                                            remoteException = e12;
                                            cursor = cursor2;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + remoteException.getMessage());
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            return iB0;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor = cursor2;
                                            if (cursor == null) {
                                                throw th;
                                            }
                                            cursor.close();
                                            throw th;
                                        }
                                    } else {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor2 != null) {
                                        }
                                    }
                                } else {
                                    iB0 = cursor.getInt(0);
                                }
                            } else if (iA0 == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iB0 = hVarK.c0(y1.b.b0(context), str, z10);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iB0 = hVarK.b0(y1.b.b0(context), str, z10);
                            }
                        } catch (RemoteException e13) {
                            remoteException = e13;
                        }
                    }
                    return iB0;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            w1.e.a(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int f(Context context, String str, boolean z10, boolean z11) throws Throwable {
        Throwable th;
        Exception exc;
        ?? r12 = 0;
        ?? r13 = 0;
        ?? r14 = 0;
        ?? r15 = 0;
        try {
            try {
                boolean z12 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z10 ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) f3376n.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z13 = false;
                            int i10 = cursorQuery.getInt(0);
                            if (i10 > 0) {
                                synchronized (DynamiteModule.class) {
                                    try {
                                        f3371i = cursorQuery.getString(2);
                                        int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            f3373k = cursorQuery.getInt(columnIndex);
                                        }
                                        int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                        if (columnIndex2 >= 0) {
                                            if (cursorQuery.getInt(columnIndex2) == 0) {
                                                z12 = false;
                                            }
                                            f3372j = z12;
                                            z13 = z12;
                                        }
                                    } finally {
                                    }
                                }
                                if (i(cursorQuery)) {
                                    cursorQuery = null;
                                }
                            }
                            if (z11 && z13) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl", r14 == true ? 1 : 0);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i10;
                        }
                    } catch (Exception e10) {
                        exc = e10;
                        if (exc instanceof LoadingException) {
                            throw exc;
                        }
                        throw new LoadingException("V2 version check failed", exc, r13 == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", r15 == true ? 1 : 0);
            } catch (Throwable th2) {
                th = th2;
                r12 = context;
                if (r12 != 0) {
                    throw th;
                }
                r12.close();
                throw th;
            }
        } catch (Exception e11) {
            exc = e11;
        } catch (Throwable th3) {
            th = th3;
            if (r12 != 0) {
            }
        }
    }

    public static DynamiteModule g(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context.getApplicationContext());
    }

    public static void h(ClassLoader classLoader) throws LoadingException {
        z1.i iVar;
        z1.g gVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                iVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                iVar = iInterfaceQueryLocalInterface instanceof z1.i ? (z1.i) iInterfaceQueryLocalInterface : new z1.i(iBinder);
            }
            f3380r = iVar;
        } catch (ClassNotFoundException e10) {
            e = e10;
            throw new LoadingException("Failed to instantiate dynamite loader", e, gVar);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw new LoadingException("Failed to instantiate dynamite loader", e, gVar);
        } catch (InstantiationException e12) {
            e = e12;
            throw new LoadingException("Failed to instantiate dynamite loader", e, gVar);
        } catch (NoSuchMethodException e13) {
            e = e13;
            throw new LoadingException("Failed to instantiate dynamite loader", e, gVar);
        } catch (InvocationTargetException e14) {
            e = e14;
            throw new LoadingException("Failed to instantiate dynamite loader", e, gVar);
        }
    }

    public static boolean i(Cursor cursor) {
        z1.f fVar = (z1.f) f3375m.get();
        if (fVar == null || fVar.f14557a != null) {
            return false;
        }
        fVar.f14557a = cursor;
        return true;
    }

    public static boolean j(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f3374l)) {
            return true;
        }
        boolean z10 = false;
        if (f3374l == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (q1.b.b().c(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z10 = true;
            }
            f3374l = Boolean.valueOf(z10);
            if (z10 && providerInfoResolveContentProvider != null && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f3372j = true;
            }
        }
        if (!z10) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z10;
    }

    public static z1.h k(Context context) {
        z1.h hVar;
        synchronized (DynamiteModule.class) {
            z1.h hVar2 = f3379q;
            if (hVar2 != null) {
                return hVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    hVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    hVar = iInterfaceQueryLocalInterface instanceof z1.h ? (z1.h) iInterfaceQueryLocalInterface : new z1.h(iBinder);
                }
                if (hVar != null) {
                    f3379q = hVar;
                    return hVar;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
            return null;
        }
    }

    public IBinder c(String str) throws LoadingException {
        try {
            return (IBinder) this.f3381a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e10, null);
        }
    }
}
