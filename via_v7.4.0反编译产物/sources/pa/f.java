package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11093a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11094b;

    public f(c cVar, i7.a aVar) {
        this.f11093a = cVar;
        this.f11094b = aVar;
    }

    public static f a(c cVar, i7.a aVar) {
        return new f(cVar, aVar);
    }

    public static p9.o c(c cVar, Context context) {
        return (p9.o) j6.g.b(cVar.d(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p9.o get() {
        return c(this.f11093a, (Context) this.f11094b.get());
    }
}
