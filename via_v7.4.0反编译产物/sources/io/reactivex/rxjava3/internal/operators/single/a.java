package io.reactivex.rxjava3.internal.operators.single;

import a7.e;
import x6.o;
import x6.q;
import x6.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends o {

    /* renamed from: a, reason: collision with root package name */
    public final r f7363a;

    /* renamed from: b, reason: collision with root package name */
    public final e f7364b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: io.reactivex.rxjava3.internal.operators.single.a$a, reason: collision with other inner class name */
    public final class C0084a implements q {

        /* renamed from: e, reason: collision with root package name */
        public final q f7365e;

        public C0084a(q qVar) {
            this.f7365e = qVar;
        }

        @Override // x6.q
        public void onError(Throwable th) {
            this.f7365e.onError(th);
        }

        @Override // x6.q
        public void onSubscribe(y6.b bVar) {
            this.f7365e.onSubscribe(bVar);
        }

        @Override // x6.q
        public void onSuccess(Object obj) {
            try {
                a.this.f7364b.accept(obj);
                this.f7365e.onSuccess(obj);
            } catch (Throwable th) {
                z6.a.b(th);
                this.f7365e.onError(th);
            }
        }
    }

    public a(r rVar, e eVar) {
        this.f7363a = rVar;
        this.f7364b = eVar;
    }

    @Override // x6.o
    public void k(q qVar) {
        this.f7363a.c(new C0084a(qVar));
    }
}
