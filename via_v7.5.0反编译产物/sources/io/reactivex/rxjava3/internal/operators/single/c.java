package io.reactivex.rxjava3.internal.operators.single;

import java.util.Objects;
import r6.q;
import r6.s;
import r6.t;
import u6.g;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f6599b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements s {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s f6600c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final g f6601e;

        public a(s sVar, g gVar) {
            this.f6600c = sVar;
            this.f6601e = gVar;
        }

        @Override // r6.s
        public void onError(Throwable th) {
            this.f6600c.onError(th);
        }

        @Override // r6.s
        public void onSubscribe(s6.b bVar) {
            this.f6600c.onSubscribe(bVar);
        }

        @Override // r6.s
        public void onSuccess(Object obj) {
            try {
                Object objApply = this.f6601e.apply(obj);
                Objects.requireNonNull(objApply, "The mapper function returned a null value.");
                this.f6600c.onSuccess(objApply);
            } catch (Throwable th) {
                t6.a.b(th);
                onError(th);
            }
        }
    }

    public c(t tVar, g gVar) {
        this.f6598a = tVar;
        this.f6599b = gVar;
    }

    @Override // r6.q
    public void j(s sVar) {
        this.f6598a.c(new a(sVar, this.f6599b));
    }
}
