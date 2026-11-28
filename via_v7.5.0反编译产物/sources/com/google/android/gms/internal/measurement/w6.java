package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.StrictMode;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class w6 implements c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f3162a = new k.a();

    public static w6 b(Context context, String str, Runnable runnable) {
        if (u5.b()) {
            throw null;
        }
        synchronized (w6.class) {
            n.g.a(f3162a.get(null));
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                throw null;
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th;
            }
        }
    }

    public static synchronized void c() {
        Map map = f3162a;
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            n.g.a(it.next());
            throw null;
        }
        map.clear();
    }
}
