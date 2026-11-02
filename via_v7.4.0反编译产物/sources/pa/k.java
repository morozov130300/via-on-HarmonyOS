package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11104a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11105b;

    public k(c cVar, i7.a aVar) {
        this.f11104a = cVar;
        this.f11105b = aVar;
    }

    public static k a(c cVar, i7.a aVar) {
        return new k(cVar, aVar);
    }

    public static s8.b c(c cVar, Context context) {
        return (s8.b) j6.g.b(cVar.i(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s8.b get() {
        return c(this.f11104a, (Context) this.f11105b.get());
    }
}
