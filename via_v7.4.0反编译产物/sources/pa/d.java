package pa;

import android.app.Application;
import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11087a;

    /* renamed from: b, reason: collision with root package name */
    public final i7.a f11088b;

    public d(c cVar, i7.a aVar) {
        this.f11087a = cVar;
        this.f11088b = aVar;
    }

    public static d a(c cVar, i7.a aVar) {
        return new d(cVar, aVar);
    }

    public static Context c(c cVar, Application application) {
        return (Context) j6.g.b(cVar.b(application), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Context get() {
        return c(this.f11087a, (Application) this.f11088b.get());
    }
}
