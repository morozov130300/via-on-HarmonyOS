package c5;

import android.content.Context;
import f5.c;
import java.util.List;
import m5.f;
import m5.i;
import m5.l;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile b f2290d;

    /* renamed from: a, reason: collision with root package name */
    public final i f2291a;

    /* renamed from: b, reason: collision with root package name */
    public final c f2292b;

    /* renamed from: c, reason: collision with root package name */
    public final h5.c f2293c;

    public b(Context context) {
        e5.c cVarF = e5.c.f();
        cVarF.g(context);
        h5.c cVarC = cVarF.c();
        this.f2293c = cVarC;
        c cVarA = cVarF.a();
        this.f2292b = cVarA;
        this.f2291a = new i(new f(), cVarF.e(), cVarA, cVarC);
    }

    public static b r(Context context) {
        if (f2290d == null) {
            synchronized (b.class) {
                try {
                    if (f2290d == null) {
                        f2290d = new b(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f2290d;
    }

    @Override // c5.a
    public List a() {
        return this.f2292b.a();
    }

    @Override // c5.a
    public boolean b(g5.c cVar) {
        return this.f2292b.b(cVar);
    }

    @Override // c5.a
    public void c(j5.c cVar) {
        this.f2293c.c(cVar);
    }

    @Override // c5.a
    public void d(j5.a aVar) {
        this.f2293c.d(aVar);
    }

    @Override // c5.a
    public void e(j5.c cVar) {
        this.f2293c.e(cVar);
    }

    @Override // c5.a
    public void f(j5.a aVar) {
        this.f2293c.f(aVar);
    }

    @Override // c5.a
    public boolean g(long j10) {
        return this.f2291a.m(j10);
    }

    @Override // c5.a
    public g5.c h(long j10) {
        return this.f2292b.l(j10);
    }

    @Override // c5.a
    public boolean i() {
        return this.f2291a.g();
    }

    @Override // c5.a
    public long j(g5.c cVar) {
        return this.f2291a.f(cVar);
    }

    @Override // c5.a
    public boolean k() {
        return this.f2291a.k();
    }

    @Override // c5.a
    public l l(g5.c cVar) {
        return this.f2291a.e(cVar);
    }

    @Override // c5.a
    public boolean m(long j10) {
        return this.f2291a.l(j10);
    }

    @Override // c5.a
    public boolean n(long j10) {
        return this.f2291a.d(j10);
    }

    @Override // c5.a
    public boolean o() {
        return this.f2291a.i();
    }

    @Override // c5.a
    public boolean p(long j10) {
        return this.f2291a.j(j10);
    }

    @Override // c5.a
    public boolean q() {
        return this.f2291a.n();
    }
}
