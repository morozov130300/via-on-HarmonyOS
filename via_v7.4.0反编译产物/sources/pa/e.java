package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11089a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11090b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f11091c;

    /* renamed from: d, reason: collision with root package name */
    public final i7.a f11092d;

    public e(c cVar, i7.a aVar, i7.a aVar2, i7.a aVar3) {
        this.f11089a = cVar;
        this.f11090b = aVar;
        this.f11091c = aVar2;
        this.f11092d = aVar3;
    }

    public static e a(c cVar, i7.a aVar, i7.a aVar2, i7.a aVar3) {
        return new e(cVar, aVar, aVar2, aVar3);
    }

    public static u4.a c(c cVar, Context context, w9.l lVar, w9.r rVar) {
        return (u4.a) j6.g.b(cVar.c(context, lVar, rVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u4.a get() {
        return c(this.f11089a, (Context) this.f11090b.get(), (w9.l) this.f11091c.get(), (w9.r) this.f11092d.get());
    }
}
