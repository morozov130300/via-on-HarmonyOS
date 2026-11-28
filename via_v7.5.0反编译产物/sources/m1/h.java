package m1;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7811a;

    public h(c7.a aVar) {
        this.f7811a = aVar;
    }

    public static h a(c7.a aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) g1.d.c(f.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f7811a.get());
    }
}
