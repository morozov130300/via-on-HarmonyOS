package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11095a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11096b;

    public g(c cVar, i7.a aVar) {
        this.f11095a = cVar;
        this.f11096b = aVar;
    }

    public static g a(c cVar, i7.a aVar) {
        return new g(cVar, aVar);
    }

    public static s9.d c(c cVar, Context context) {
        return (s9.d) j6.g.b(cVar.e(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s9.d get() {
        return c(this.f11095a, (Context) this.f11096b.get());
    }
}
