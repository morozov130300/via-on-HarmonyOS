package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11097a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11098b;

    public h(c cVar, i7.a aVar) {
        this.f11097a = cVar;
        this.f11098b = aVar;
    }

    public static h a(c cVar, i7.a aVar) {
        return new h(cVar, aVar);
    }

    public static k6.e c(c cVar, Context context) {
        return (k6.e) j6.g.b(cVar.f(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k6.e get() {
        return c(this.f11097a, (Context) this.f11098b.get());
    }
}
