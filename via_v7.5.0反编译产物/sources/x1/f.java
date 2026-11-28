package x1;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14462a = new f();

    public static c d() {
        return f14462a;
    }

    @Override // x1.c
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // x1.c
    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // x1.c
    public final long c() {
        return System.nanoTime();
    }
}
