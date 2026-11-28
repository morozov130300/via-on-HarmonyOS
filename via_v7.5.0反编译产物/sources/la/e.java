package la;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f7539b;

    public e(d dVar, c7.a aVar) {
        this.f7538a = dVar;
        this.f7539b = aVar;
    }

    public static e a(d dVar, c7.a aVar) {
        return new e(dVar, aVar);
    }

    public static Context c(d dVar, Application application) {
        return (Context) d6.g.b(dVar.b(application), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Context get() {
        return c(this.f7538a, (Application) this.f7539b.get());
    }
}
