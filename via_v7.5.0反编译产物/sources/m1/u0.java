package m1;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u0 implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.a f7862c;

    public u0(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        this.f7860a = aVar;
        this.f7861b = aVar2;
        this.f7862c = aVar3;
    }

    public static u0 a(c7.a aVar, c7.a aVar2, c7.a aVar3) {
        return new u0(aVar, aVar2, aVar3);
    }

    public static t0 c(Context context, String str, int i10) {
        return new t0(context, str, i10);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t0 get() {
        return c((Context) this.f7860a.get(), (String) this.f7861b.get(), ((Integer) this.f7862c.get()).intValue());
    }
}
