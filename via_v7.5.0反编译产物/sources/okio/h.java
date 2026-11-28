package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f11449e;

    public h(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f11449e = rVar;
    }

    @Override // okio.r
    public r a() {
        return this.f11449e.a();
    }

    @Override // okio.r
    public r b() {
        return this.f11449e.b();
    }

    @Override // okio.r
    public long c() {
        return this.f11449e.c();
    }

    @Override // okio.r
    public r d(long j10) {
        return this.f11449e.d(j10);
    }

    @Override // okio.r
    public boolean e() {
        return this.f11449e.e();
    }

    @Override // okio.r
    public void f() throws InterruptedIOException {
        this.f11449e.f();
    }

    @Override // okio.r
    public r g(long j10, TimeUnit timeUnit) {
        return this.f11449e.g(j10, timeUnit);
    }

    public final r i() {
        return this.f11449e;
    }

    public final h j(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f11449e = rVar;
        return this;
    }
}
