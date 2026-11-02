package io.reactivex.rxjava3.internal.operators.single;

import a7.f;
import java.util.Objects;
import x6.o;
import x6.q;
import x6.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends o {

    /* renamed from: a, reason: collision with root package name */
    public final r f7369a;

    /* renamed from: b, reason: collision with root package name */
    public final f f7370b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements q {

        /* renamed from: e, reason: collision with root package name */
        public final q f7371e;

        /* renamed from: j, reason: collision with root package name */
        public final f f7372j;

        public a(q qVar, f fVar) {
            this.f7371e = qVar;
            this.f7372j = fVar;
        }

        @Override // x6.q
        public void onError(Throwable th) {
            this.f7371e.onError(th);
        }

        @Override // x6.q
        public void onSubscribe(y6.b bVar) {
            this.f7371e.onSubscribe(bVar);
        }

        @Override // x6.q
        public void onSuccess(Object obj) {
            try {
                Object objApply = this.f7372j.apply(obj);
                Objects.requireNonNull(objApply, "The mapper function returned a null value.");
                this.f7371e.onSuccess(objApply);
            } catch (Throwable th) {
                z6.a.b(th);
                onError(th);
            }
        }
    }

    public d(r rVar, f fVar) {
        this.f7369a = rVar;
        this.f7370b = fVar;
    }

    @Override // x6.o
    public void k(q qVar) {
        this.f7369a.c(new a(qVar, this.f7370b));
    }
}
