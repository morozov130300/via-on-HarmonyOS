package e1;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f4717a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f4718b;

    public j(i7.a aVar, i7.a aVar2) {
        this.f4717a = aVar;
        this.f4718b = aVar2;
    }

    public static j a(i7.a aVar, i7.a aVar2) {
        return new j(aVar, aVar2);
    }

    public static i c(Context context, Object obj) {
        return new i(context, (g) obj);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f4717a.get(), this.f4718b.get());
    }
}
