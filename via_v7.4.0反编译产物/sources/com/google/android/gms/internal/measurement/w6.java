package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.StrictMode;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class w6 implements c6 {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f3863a = new k.a();

    public static w6 b(Context context, String str, Runnable runnable) {
        if (u5.b()) {
            throw null;
        }
        synchronized (w6.class) {
            n.g.a(f3863a.get(null));
            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                throw null;
            } finally {
            }
        }
    }

    public static synchronized void c() {
        Map map = f3863a;
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            n.g.a(it.next());
            throw null;
        }
        map.clear();
    }
}
