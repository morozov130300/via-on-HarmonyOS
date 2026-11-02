package pa;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11107a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11108b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f11109c;

    public m(c cVar, i7.a aVar, i7.a aVar2) {
        this.f11107a = cVar;
        this.f11108b = aVar;
        this.f11109c = aVar2;
    }

    public static m a(c cVar, i7.a aVar, i7.a aVar2) {
        return new m(cVar, aVar, aVar2);
    }

    public static pb.b c(c cVar, Context context, w9.l lVar) {
        return (pb.b) j6.g.b(cVar.k(context, lVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public pb.b get() {
        return c(this.f11107a, (Context) this.f11108b.get(), (w9.l) this.f11109c.get());
    }
}
