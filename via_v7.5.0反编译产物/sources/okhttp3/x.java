package okhttp3;

import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f11397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f11399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f11400d;

        public a(t tVar, int i10, byte[] bArr, int i11) {
            this.f11397a = tVar;
            this.f11398b = i10;
            this.f11399c = bArr;
            this.f11400d = i11;
        }

        @Override // okhttp3.x
        public long a() {
            return this.f11398b;
        }

        @Override // okhttp3.x
        public t b() {
            return this.f11397a;
        }

        @Override // okhttp3.x
        public void g(okio.d dVar) {
            dVar.write(this.f11399c, this.f11400d, this.f11398b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f11401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f11402b;

        public b(t tVar, File file) {
            this.f11401a = tVar;
            this.f11402b = file;
        }

        @Override // okhttp3.x
        public long a() {
            return this.f11402b.length();
        }

        @Override // okhttp3.x
        public t b() {
            return this.f11401a;
        }

        @Override // okhttp3.x
        public void g(okio.d dVar) {
            okio.q qVarF = null;
            try {
                qVarF = okio.k.f(this.f11402b);
                dVar.M(qVarF);
            } finally {
                ub.c.g(qVarF);
            }
        }
    }

    public static x c(t tVar, File file) {
        if (file != null) {
            return new b(tVar, file);
        }
        throw new NullPointerException("file == null");
    }

    public static x d(t tVar, String str) {
        Charset charset = ub.c.f12954j;
        if (tVar != null) {
            Charset charsetA = tVar.a();
            if (charsetA == null) {
                tVar = t.d(tVar + "; charset=utf-8");
            } else {
                charset = charsetA;
            }
        }
        return e(tVar, str.getBytes(charset));
    }

    public static x e(t tVar, byte[] bArr) {
        return f(tVar, bArr, 0, bArr.length);
    }

    public static x f(t tVar, byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        ub.c.f(bArr.length, i10, i11);
        return new a(tVar, i11, bArr, i10);
    }

    public abstract long a();

    public abstract t b();

    public abstract void g(okio.d dVar);
}
