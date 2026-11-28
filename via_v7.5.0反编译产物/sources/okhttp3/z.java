package okhttp3;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class z implements Closeable {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends z {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t f11428c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f11429e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ okio.e f11430m;

        public a(t tVar, long j10, okio.e eVar) {
            this.f11428c = tVar;
            this.f11429e = j10;
            this.f11430m = eVar;
        }

        @Override // okhttp3.z
        public long c() {
            return this.f11429e;
        }

        @Override // okhttp3.z
        public t e() {
            return this.f11428c;
        }

        @Override // okhttp3.z
        public okio.e h() {
            return this.f11430m;
        }
    }

    public static z f(t tVar, long j10, okio.e eVar) {
        if (eVar != null) {
            return new a(tVar, j10, eVar);
        }
        throw new NullPointerException("source == null");
    }

    public static z g(t tVar, byte[] bArr) {
        return f(tVar, bArr.length, new okio.c().write(bArr));
    }

    public final InputStream a() {
        return h().a0();
    }

    public final Charset b() {
        t tVarE = e();
        return tVarE != null ? tVarE.b(ub.c.f12954j) : ub.c.f12954j;
    }

    public abstract long c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ub.c.g(h());
    }

    public abstract t e();

    public abstract okio.e h();

    public final String j() {
        okio.e eVarH = h();
        try {
            return eVarH.K(ub.c.c(eVarH, b()));
        } finally {
            ub.c.g(eVarH);
        }
    }
}
