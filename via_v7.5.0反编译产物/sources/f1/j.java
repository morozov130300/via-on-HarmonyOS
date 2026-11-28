package f1;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f4433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f4434b;

    public j(c7.a aVar, c7.a aVar2) {
        this.f4433a = aVar;
        this.f4434b = aVar2;
    }

    public static j a(c7.a aVar, c7.a aVar2) {
        return new j(aVar, aVar2);
    }

    public static i c(Context context, Object obj) {
        return new i(context, (g) obj);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f4433a.get(), this.f4434b.get());
    }
}
