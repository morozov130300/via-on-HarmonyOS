package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v implements d {

    /* renamed from: e, reason: collision with root package name */
    public final u f10765e;

    /* renamed from: j, reason: collision with root package name */
    public final xb.j f10766j;

    /* renamed from: k, reason: collision with root package name */
    public final okio.a f10767k;

    /* renamed from: l, reason: collision with root package name */
    public o f10768l;

    /* renamed from: m, reason: collision with root package name */
    public final w f10769m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f10770n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10771o;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends okio.a {
        public a() {
        }

        @Override // okio.a
        public void t() throws IOException {
            v.this.cancel();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class b extends ub.b {
    }

    public v(u uVar, w wVar, boolean z10) {
        this.f10765e = uVar;
        this.f10769m = wVar;
        this.f10770n = z10;
        this.f10766j = new xb.j(uVar, z10);
        a aVar = new a();
        this.f10767k = aVar;
        aVar.g(uVar.b(), TimeUnit.MILLISECONDS);
    }

    public static v d(u uVar, w wVar, boolean z10) {
        v vVar = new v(uVar, wVar, z10);
        vVar.f10768l = uVar.n().a(vVar);
        return vVar;
    }

    public final void a() {
        this.f10766j.i(ac.f.j().m("response.body().close()"));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v clone() {
        return d(this.f10765e, this.f10769m, this.f10770n);
    }

    public y c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f10765e.r());
        arrayList.add(this.f10766j);
        arrayList.add(new xb.a(this.f10765e.j()));
        this.f10765e.s();
        arrayList.add(new vb.a(null));
        arrayList.add(new wb.a(this.f10765e));
        if (!this.f10770n) {
            arrayList.addAll(this.f10765e.t());
        }
        arrayList.add(new xb.b(this.f10770n));
        return new xb.g(arrayList, null, null, null, 0, this.f10769m, this, this.f10768l, this.f10765e.d(), this.f10765e.C(), this.f10765e.G()).c(this.f10769m);
    }

    @Override // okhttp3.d
    public void cancel() throws IOException {
        this.f10766j.b();
    }

    public IOException e(IOException iOException) {
        if (!this.f10767k.n()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @Override // okhttp3.d
    public y f() {
        synchronized (this) {
            if (this.f10771o) {
                throw new IllegalStateException("Already Executed");
            }
            this.f10771o = true;
        }
        a();
        this.f10767k.k();
        this.f10768l.c(this);
        try {
            try {
                this.f10765e.l().b(this);
                y yVarC = c();
                if (yVarC != null) {
                    return yVarC;
                }
                throw new IOException("Canceled");
            } catch (IOException e10) {
                IOException iOExceptionE = e(e10);
                this.f10768l.b(this, iOExceptionE);
                throw iOExceptionE;
            }
        } finally {
            this.f10765e.l().e(this);
        }
    }
}
