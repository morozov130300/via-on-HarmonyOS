package p2;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.a f11553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile r2.a f11554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile s2.b f11555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11556d;

    public d(j3.a aVar) {
        this(aVar, new s2.c(), new r2.f());
    }

    public static /* synthetic */ void a(d dVar, j3.b bVar) {
        dVar.getClass();
        q2.f.f().b("AnalyticsConnector now available.");
        k2.a aVar = (k2.a) bVar.get();
        r2.e eVar = new r2.e(aVar);
        e eVar2 = new e();
        if (g(aVar, eVar2) == null) {
            q2.f.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        q2.f.f().b("Registered Firebase Analytics listener.");
        r2.d dVar2 = new r2.d();
        r2.c cVar = new r2.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (dVar) {
            try {
                Iterator it = dVar.f11556d.iterator();
                while (it.hasNext()) {
                    dVar2.a((s2.a) it.next());
                }
                eVar2.d(dVar2);
                eVar2.e(cVar);
                dVar.f11555c = dVar2;
                dVar.f11554b = cVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void c(d dVar, s2.a aVar) {
        synchronized (dVar) {
            try {
                if (dVar.f11555c instanceof s2.c) {
                    dVar.f11556d.add(aVar);
                }
                dVar.f11555c.a(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static k2.a.InterfaceC0085a g(k2.a aVar, e eVar) {
        k2.a.InterfaceC0085a interfaceC0085aA = aVar.a("clx", eVar);
        if (interfaceC0085aA != null) {
            return interfaceC0085aA;
        }
        q2.f.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
        k2.a.InterfaceC0085a interfaceC0085aA2 = aVar.a("crash", eVar);
        if (interfaceC0085aA2 != null) {
            q2.f.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        }
        return interfaceC0085aA2;
    }

    public r2.a d() {
        return new r2.a() { // from class: p2.b
            @Override // r2.a
            public final void a(String str, Bundle bundle) {
                this.f11551a.f11554b.a(str, bundle);
            }
        };
    }

    public s2.b e() {
        return new s2.b() { // from class: p2.a
            @Override // s2.b
            public final void a(s2.a aVar) {
                d.c(this.f11550a, aVar);
            }
        };
    }

    public final void f() {
        this.f11553a.a(new j3.a.InterfaceC0083a() { // from class: p2.c
            @Override // j3.a.InterfaceC0083a
            public final void a(j3.b bVar) {
                d.a(this.f11552a, bVar);
            }
        });
    }

    public d(j3.a aVar, s2.b bVar, r2.a aVar2) {
        this.f11553a = aVar;
        this.f11555c = bVar;
        this.f11556d = new ArrayList();
        this.f11554b = aVar2;
        f();
    }
}
