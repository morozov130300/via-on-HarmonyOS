package ca;

import d6.d;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f2357a;

    public c(c7.a aVar) {
        this.f2357a = aVar;
    }

    public static c a(c7.a aVar) {
        return new c(aVar);
    }

    public static b c(o9.a aVar) {
        return new b(aVar);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b get() {
        return c((o9.a) this.f2357a.get());
    }
}
