package okhttp3;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class z implements Closeable {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends z {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ t f10815e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ long f10816j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ okio.e f10817k;

        public a(t tVar, long j10, okio.e eVar) {
            this.f10815e = tVar;
            this.f10816j = j10;
            this.f10817k = eVar;
        }

        @Override // okhttp3.z
        public long d() {
            return this.f10816j;
        }

        @Override // okhttp3.z
        public t f() {
            return this.f10815e;
        }

        @Override // okhttp3.z
        public okio.e i() {
            return this.f10817k;
        }
    }

    public static z g(t tVar, long j10, okio.e eVar) {
        if (eVar != null) {
            return new a(tVar, j10, eVar);
        }
        throw new NullPointerException("source == null");
    }

    public static z h(t tVar, byte[] bArr) {
        return g(tVar, bArr.length, new okio.c().write(bArr));
    }

    public final InputStream a() {
        return i().a0();
    }

    public final Charset b() {
        t tVarF = f();
        return tVarF != null ? tVarF.b(ub.c.f12944j) : ub.c.f12944j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ub.c.g(i());
    }

    public abstract long d();

    public abstract t f();

    public abstract okio.e i();

    public final String j() {
        okio.e eVarI = i();
        try {
            return eVarI.H(ub.c.c(eVarI, b()));
        } finally {
            ub.c.g(eVarI);
        }
    }
}
