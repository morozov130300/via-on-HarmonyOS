package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11099a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11100b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f11101c;

    public i(c cVar, i7.a aVar, i7.a aVar2) {
        this.f11099a = cVar;
        this.f11100b = aVar;
        this.f11101c = aVar2;
    }

    public static i a(c cVar, i7.a aVar, i7.a aVar2) {
        return new i(cVar, aVar, aVar2);
    }

    public static v9.g c(c cVar, Context context, w9.l lVar) {
        return (v9.g) j6.g.b(cVar.g(context, lVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v9.g get() {
        return c(this.f11099a, (Context) this.f11100b.get(), (w9.l) this.f11101c.get());
    }
}
