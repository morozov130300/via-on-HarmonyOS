package c5;

import android.content.Context;
import f5.c;
import java.util.List;
import m5.f;
import m5.i;
import m5.m;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f1951d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f1953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h5.c f1954c;

    public b(Context context) {
        e5.c cVarF = e5.c.f();
        cVarF.g(context);
        h5.c cVarC = cVarF.c();
        this.f1954c = cVarC;
        c cVarA = cVarF.a();
        this.f1953b = cVarA;
        this.f1952a = new i(new f(), cVarF.e(), cVarA, cVarC);
    }

    public static b r(Context context) {
        if (f1951d == null) {
            synchronized (b.class) {
                try {
                    if (f1951d == null) {
                        f1951d = new b(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1951d;
    }

    @Override // c5.a
    public List a() {
        return this.f1953b.a();
    }

    @Override // c5.a
    public boolean b(g5.c cVar) {
        return this.f1953b.b(cVar);
    }

    @Override // c5.a
    public void c(j5.c cVar) {
        this.f1954c.c(cVar);
    }

    @Override // c5.a
    public void d(j5.a aVar) {
        this.f1954c.d(aVar);
    }

    @Override // c5.a
    public void e(j5.c cVar) {
        this.f1954c.e(cVar);
    }

    @Override // c5.a
    public void f(j5.a aVar) {
        this.f1954c.f(aVar);
    }

    @Override // c5.a
    public boolean g(long j10) {
        return this.f1952a.l(j10);
    }

    @Override // c5.a
    public g5.c h(long j10) {
        return this.f1953b.l(j10);
    }

    @Override // c5.a
    public boolean i() {
        return this.f1952a.f();
    }

    @Override // c5.a
    public long j(g5.c cVar) {
        return this.f1952a.e(cVar);
    }

    @Override // c5.a
    public boolean k() {
        return this.f1952a.j();
    }

    @Override // c5.a
    public boolean l(long j10) {
        return this.f1952a.k(j10);
    }

    @Override // c5.a
    public boolean m(long j10) {
        return this.f1952a.c(j10);
    }

    @Override // c5.a
    public boolean n() {
        return this.f1952a.g();
    }

    @Override // c5.a
    public boolean o(long j10) {
        return this.f1952a.i(j10);
    }

    @Override // c5.a
    public boolean p() {
        return this.f1952a.m();
    }

    public m q(g5.c cVar) {
        return this.f1952a.d(cVar);
    }
}
