package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11110a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11111b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f11112c;

    public n(c cVar, i7.a aVar, i7.a aVar2) {
        this.f11110a = cVar;
        this.f11111b = aVar;
        this.f11112c = aVar2;
    }

    public static n a(c cVar, i7.a aVar, i7.a aVar2) {
        return new n(cVar, aVar, aVar2);
    }

    public static n5.b c(c cVar, Context context, w9.l lVar) {
        return (n5.b) j6.g.b(cVar.l(context, lVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n5.b get() {
        return c(this.f11110a, (Context) this.f11111b.get(), (w9.l) this.f11112c.get());
    }
}
