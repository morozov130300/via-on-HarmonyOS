package w1;

import android.os.SystemClock;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final f f13214a = new f();

    public static c d() {
        return f13214a;
    }

    @Override // w1.c
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // w1.c
    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // w1.c
    public final long c() {
        return System.nanoTime();
    }
}
