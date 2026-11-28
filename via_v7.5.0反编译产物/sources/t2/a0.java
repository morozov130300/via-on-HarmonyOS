package t2;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f12331a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f12332b = new AtomicInteger();

    public void a() {
        this.f12332b.getAndIncrement();
    }

    public void b() {
        this.f12331a.getAndIncrement();
    }

    public void c() {
        this.f12332b.set(0);
    }
}
