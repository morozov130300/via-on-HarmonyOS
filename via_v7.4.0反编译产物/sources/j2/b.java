package j2;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.u2;
import h2.e;
import j2.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import t1.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements j2.a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile j2.a f7538c;

    /* renamed from: a, reason: collision with root package name */
    public final e2.a f7539a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f7540b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements a.InterfaceC0088a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7541a;

        public a(String str) {
            this.f7541a = str;
        }
    }

    public b(e2.a aVar) {
        f.h(aVar);
        this.f7539a = aVar;
        this.f7540b = new ConcurrentHashMap();
    }

    public static j2.a c(e eVar, Context context, g3.d dVar) {
        f.h(eVar);
        f.h(context);
        f.h(dVar);
        f.h(context.getApplicationContext());
        if (f7538c == null) {
            synchronized (b.class) {
                try {
                    if (f7538c == null) {
                        Bundle bundle = new Bundle(1);
                        if (eVar.u()) {
                            dVar.a(h2.b.class, new Executor() { // from class: j2.c
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new g3.b() { // from class: j2.d
                                @Override // g3.b
                                public final void a(g3.a aVar) {
                                    b.d(aVar);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", eVar.t());
                        }
                        f7538c = new b(u2.q(context, null, null, null, bundle).n());
                    }
                } finally {
                }
            }
        }
        return f7538c;
    }

    public static /* synthetic */ void d(g3.a aVar) {
        throw null;
    }

    @Override // j2.a
    public a.InterfaceC0088a a(String str, a.b bVar) {
        f.h(bVar);
        if (!k2.b.d(str) || e(str)) {
            return null;
        }
        e2.a aVar = this.f7539a;
        Object dVar = "fiam".equals(str) ? new k2.d(aVar, bVar) : "clx".equals(str) ? new k2.f(aVar, bVar) : null;
        if (dVar == null) {
            return null;
        }
        this.f7540b.put(str, dVar);
        return new a(str);
    }

    @Override // j2.a
    public void b(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (k2.b.d(str) && k2.b.b(str2, bundle) && k2.b.a(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            this.f7539a.a(str, str2, bundle);
        }
    }

    public final boolean e(String str) {
        return (str.isEmpty() || !this.f7540b.containsKey(str) || this.f7540b.get(str) == null) ? false : true;
    }
}
