package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11113a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11114b;

    public o(c cVar, i7.a aVar) {
        this.f11113a = cVar;
        this.f11114b = aVar;
    }

    public static o a(c cVar, i7.a aVar) {
        return new o(cVar, aVar);
    }

    public static w9.r c(c cVar, Context context) {
        return (w9.r) j6.g.b(cVar.m(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w9.r get() {
        return c(this.f11113a, (Context) this.f11114b.get());
    }
}
