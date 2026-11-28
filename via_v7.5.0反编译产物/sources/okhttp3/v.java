package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f11378c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xb.j f11379e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final okio.a f11380m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f11381n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final w f11382o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f11383p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11384q;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends okio.a {
        public a() {
        }

        @Override // okio.a
        public void t() {
            v.this.cancel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class b extends ub.b {
    }

    public v(u uVar, w wVar, boolean z10) {
        this.f11378c = uVar;
        this.f11382o = wVar;
        this.f11383p = z10;
        this.f11379e = new xb.j(uVar, z10);
        a aVar = new a();
        this.f11380m = aVar;
        aVar.g(uVar.b(), TimeUnit.MILLISECONDS);
    }

    public static v e(u uVar, w wVar, boolean z10) {
        v vVar = new v(uVar, wVar, z10);
        vVar.f11381n = uVar.n().a(vVar);
        return vVar;
    }

    public final void a() {
        this.f11379e.i(ac.f.j().m("response.body().close()"));
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v clone() {
        return e(this.f11378c, this.f11382o, this.f11383p);
    }

    @Override // okhttp3.d
    public y c() {
        synchronized (this) {
            if (this.f11384q) {
                throw new IllegalStateException("Already Executed");
            }
            this.f11384q = true;
        }
        a();
        this.f11380m.k();
        this.f11381n.c(this);
        try {
            try {
                this.f11378c.l().b(this);
                y yVarD = d();
                if (yVarD == null) {
                    throw new IOException("Canceled");
                }
                this.f11378c.l().e(this);
                return yVarD;
            } catch (IOException e10) {
                IOException iOExceptionI = i(e10);
                this.f11381n.b(this, iOExceptionI);
                throw iOExceptionI;
            }
        } catch (Throwable th) {
            this.f11378c.l().e(this);
            throw th;
        }
        this.f11378c.l().e(this);
        throw th;
    }

    @Override // okhttp3.d
    public void cancel() {
        this.f11379e.b();
    }

    public y d() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f11378c.r());
        arrayList.add(this.f11379e);
        arrayList.add(new xb.a(this.f11378c.k()));
        this.f11378c.s();
        arrayList.add(new vb.a(null));
        arrayList.add(new wb.a(this.f11378c));
        if (!this.f11383p) {
            arrayList.addAll(this.f11378c.t());
        }
        arrayList.add(new xb.b(this.f11383p));
        return new xb.g(arrayList, null, null, null, 0, this.f11382o, this, this.f11381n, this.f11378c.e(), this.f11378c.C(), this.f11378c.G()).c(this.f11382o);
    }

    public IOException i(IOException iOException) {
        if (!this.f11380m.n()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }
}
