package ha;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f6459a;

    public f(i7.a aVar) {
        this.f6459a = aVar;
    }

    public static f a(i7.a aVar) {
        return new f(aVar);
    }

    public static e c(Context context) {
        return new e(context);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c((Context) this.f6459a.get());
    }
}
