package okhttp3;

import java.io.File;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class x {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f10784a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10785b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f10786c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f10787d;

        public a(t tVar, int i10, byte[] bArr, int i11) {
            this.f10784a = tVar;
            this.f10785b = i10;
            this.f10786c = bArr;
            this.f10787d = i11;
        }

        @Override // okhttp3.x
        public long a() {
            return this.f10785b;
        }

        @Override // okhttp3.x
        public t b() {
            return this.f10784a;
        }

        @Override // okhttp3.x
        public void g(okio.d dVar) {
            dVar.write(this.f10786c, this.f10787d, this.f10785b);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f10788a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f10789b;

        public b(t tVar, File file) {
            this.f10788a = tVar;
            this.f10789b = file;
        }

        @Override // okhttp3.x
        public long a() {
            return this.f10789b.length();
        }

        @Override // okhttp3.x
        public t b() {
            return this.f10788a;
        }

        @Override // okhttp3.x
        public void g(okio.d dVar) {
            okio.q qVarF = null;
            try {
                qVarF = okio.k.f(this.f10789b);
                dVar.K(qVarF);
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
        Charset charset = ub.c.f12944j;
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
