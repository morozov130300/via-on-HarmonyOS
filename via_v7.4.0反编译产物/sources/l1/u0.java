package l1;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u0 implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f8386a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f8387b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f8388c;

    public u0(i7.a aVar, i7.a aVar2, i7.a aVar3) {
        this.f8386a = aVar;
        this.f8387b = aVar2;
        this.f8388c = aVar3;
    }

    public static u0 a(i7.a aVar, i7.a aVar2, i7.a aVar3) {
        return new u0(aVar, aVar2, aVar3);
    }

    public static t0 c(Context context, String str, int i10) {
        return new t0(context, str, i10);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t0 get() {
        return c((Context) this.f8386a.get(), (String) this.f8387b.get(), ((Integer) this.f8388c.get()).intValue());
    }
}
