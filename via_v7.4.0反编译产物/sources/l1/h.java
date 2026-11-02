package l1;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h implements f1.b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f8337a;

    public h(i7.a aVar) {
        this.f8337a = aVar;
    }

    public static h a(i7.a aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) f1.d.c(f.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f8337a.get());
    }
}
