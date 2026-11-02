package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11102a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11103b;

    public j(c cVar, i7.a aVar) {
        this.f11102a = cVar;
        this.f11103b = aVar;
    }

    public static j a(c cVar, i7.a aVar) {
        return new j(cVar, aVar);
    }

    public static w9.l c(c cVar, Context context) {
        return (w9.l) j6.g.b(cVar.h(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w9.l get() {
        return c(this.f11102a, (Context) this.f11103b.get());
    }
}
