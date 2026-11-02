package k9;

import android.content.Context;
import j6.d;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f8232a;

    public b(i7.a aVar) {
        this.f8232a = aVar;
    }

    public static b a(i7.a aVar) {
        return new b(aVar);
    }

    public static a c(Context context) {
        return new a(context);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a get() {
        return c((Context) this.f8232a.get());
    }
}
