package k2;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.u2;
import i2.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import u1.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements k2.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile k2.a f7170c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2.a f7171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7172b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements k2.a.InterfaceC0085a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7173a;

        public a(String str) {
            this.f7173a = str;
        }
    }

    public b(f2.a aVar) {
        f.h(aVar);
        this.f7171a = aVar;
        this.f7172b = new ConcurrentHashMap();
    }

    public static k2.a c(e eVar, Context context, h3.d dVar) {
        f.h(eVar);
        f.h(context);
        f.h(dVar);
        f.h(context.getApplicationContext());
        if (f7170c == null) {
            synchronized (b.class) {
                try {
                    if (f7170c == null) {
                        Bundle bundle = new Bundle(1);
                        if (eVar.u()) {
                            dVar.a(i2.b.class, new Executor() { // from class: k2.c
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new h3.b() { // from class: k2.d
                                @Override // h3.b
                                public final void a(h3.a aVar) {
                                    b.d(aVar);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", eVar.t());
                        }
                        f7170c = new b(u2.q(context, null, null, null, bundle).n());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7170c;
    }

    public static /* synthetic */ void d(h3.a aVar) {
        throw null;
    }

    @Override // k2.a
    public k2.a.InterfaceC0085a a(String str, k2.a.b bVar) {
        Object fVar;
        f.h(bVar);
        if (!l2.b.d(str) || e(str)) {
            return null;
        }
        f2.a aVar = this.f7171a;
        if ("fiam".equals(str)) {
            fVar = new l2.d(aVar, bVar);
        } else {
            fVar = "clx".equals(str) ? new l2.f(aVar, bVar) : null;
        }
        if (fVar == null) {
            return null;
        }
        this.f7172b.put(str, fVar);
        return new a(str);
    }

    @Override // k2.a
    public void b(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (l2.b.d(str) && l2.b.b(str2, bundle) && l2.b.a(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            this.f7171a.a(str, str2, bundle);
        }
    }

    public final boolean e(String str) {
        return (str.isEmpty() || !this.f7172b.containsKey(str) || this.f7172b.get(str) == null) ? false : true;
    }
}
