package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y5 implements c6 {

    /* renamed from: h, reason: collision with root package name */
    public static final Map f3892h = new k.a();

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f3893i = {"key", "value"};

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f3894a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f3895b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f3896c;

    /* renamed from: d, reason: collision with root package name */
    public final ContentObserver f3897d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f3898e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Map f3899f;

    /* renamed from: g, reason: collision with root package name */
    public final List f3900g;

    public y5(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        x5 x5Var = new x5(this, null);
        this.f3897d = x5Var;
        this.f3898e = new Object();
        this.f3900g = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.f3894a = contentResolver;
        this.f3895b = uri;
        this.f3896c = runnable;
        contentResolver.registerContentObserver(uri, false, x5Var);
    }

    public static y5 b(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        y5 y5Var;
        synchronized (y5.class) {
            Map map = f3892h;
            y5Var = (y5) map.get(uri);
            if (y5Var == null) {
                try {
                    y5 y5Var2 = new y5(contentResolver, uri, runnable);
                    try {
                        map.put(uri, y5Var2);
                    } catch (SecurityException unused) {
                    }
                    y5Var = y5Var2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return y5Var;
    }

    public static synchronized void e() {
        try {
            for (y5 y5Var : f3892h.values()) {
                y5Var.f3894a.unregisterContentObserver(y5Var.f3897d);
            }
            f3892h.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.c6
    public final /* bridge */ /* synthetic */ Object a(String str) {
        return (String) c().get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map c() {
        Map map;
        Map map2;
        Map map3 = this.f3899f;
        Map map4 = map3;
        if (map3 == null) {
            synchronized (this.f3898e) {
                Map map5 = this.f3899f;
                if (map5 != null) {
                    map2 = map5;
                } else {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            map = (Map) a6.a(new b6() { // from class: com.google.android.gms.internal.measurement.w5
                                @Override // com.google.android.gms.internal.measurement.b6
                                public final Object zza() {
                                    return this.f3862a.d();
                                }
                            });
                        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                            Log.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            map = null;
                        }
                        this.f3899f = map;
                        threadPolicyAllowThreadDiskReads = map;
                        map2 = threadPolicyAllowThreadDiskReads;
                    } finally {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    }
                }
            }
            map4 = map2;
        }
        return map4 != null ? map4 : Collections.EMPTY_MAP;
    }

    public final /* synthetic */ Map d() {
        Cursor cursorQuery = this.f3894a.query(this.f3895b, f3893i, null, null, null);
        if (cursorQuery == null) {
            return Collections.EMPTY_MAP;
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.EMPTY_MAP;
            }
            Map aVar = count <= 256 ? new k.a(count) : new HashMap(count, 1.0f);
            while (cursorQuery.moveToNext()) {
                aVar.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return aVar;
        } finally {
            cursorQuery.close();
        }
    }

    public final void f() {
        synchronized (this.f3898e) {
            this.f3899f = null;
            this.f3896c.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.f3900g.iterator();
                if (it.hasNext()) {
                    n.g.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
