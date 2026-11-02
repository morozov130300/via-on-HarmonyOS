package e1;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f4709a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f4710b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.a f4711c;

    public h(i7.a aVar, i7.a aVar2, i7.a aVar3) {
        this.f4709a = aVar;
        this.f4710b = aVar2;
        this.f4711c = aVar3;
    }

    public static h a(i7.a aVar, i7.a aVar2, i7.a aVar3) {
        return new h(aVar, aVar2, aVar3);
    }

    public static g c(Context context, n1.a aVar, n1.a aVar2) {
        return new g(context, aVar, aVar2);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c((Context) this.f4709a.get(), (n1.a) this.f4710b.get(), (n1.a) this.f4711c.get());
    }
}
