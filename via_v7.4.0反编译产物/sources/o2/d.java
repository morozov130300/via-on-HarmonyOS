package o2;

import android.os.Bundle;
import i3.a;
import j2.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final i3.a f10336a;

    /* renamed from: b, reason: collision with root package name */
    public volatile q2.a f10337b;

    /* renamed from: c, reason: collision with root package name */
    public volatile r2.b f10338c;

    /* renamed from: d, reason: collision with root package name */
    public final List f10339d;

    public d(i3.a aVar) {
        this(aVar, new r2.c(), new q2.f());
    }

    public d(i3.a aVar, r2.b bVar, q2.a aVar2) {
        this.f10336a = aVar;
        this.f10338c = bVar;
        this.f10339d = new ArrayList();
        this.f10337b = aVar2;
        f();
    }

    public static /* synthetic */ void a(d dVar, i3.b bVar) {
        dVar.getClass();
        p2.f.f().b("AnalyticsConnector now available.");
        j2.a aVar = (j2.a) bVar.get();
        q2.e eVar = new q2.e(aVar);
        e eVar2 = new e();
        if (g(aVar, eVar2) == null) {
            p2.f.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        p2.f.f().b("Registered Firebase Analytics listener.");
        q2.d dVar2 = new q2.d();
        q2.c cVar = new q2.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (dVar) {
            try {
                Iterator it = dVar.f10339d.iterator();
                while (it.hasNext()) {
                    dVar2.a((r2.a) it.next());
                }
                eVar2.d(dVar2);
                eVar2.e(cVar);
                dVar.f10338c = dVar2;
                dVar.f10337b = cVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void c(d dVar, r2.a aVar) {
        synchronized (dVar) {
            try {
                if (dVar.f10338c instanceof r2.c) {
                    dVar.f10339d.add(aVar);
                }
                dVar.f10338c.a(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a.InterfaceC0088a g(j2.a aVar, e eVar) {
        a.InterfaceC0088a interfaceC0088aA = aVar.a("clx", eVar);
        if (interfaceC0088aA != null) {
            return interfaceC0088aA;
        }
        p2.f.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
        a.InterfaceC0088a interfaceC0088aA2 = aVar.a("crash", eVar);
        if (interfaceC0088aA2 != null) {
            p2.f.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        }
        return interfaceC0088aA2;
    }

    public q2.a d() {
        return new q2.a() { // from class: o2.b
            @Override // q2.a
            public final void a(String str, Bundle bundle) {
                this.f10334a.f10337b.a(str, bundle);
            }
        };
    }

    public r2.b e() {
        return new r2.b() { // from class: o2.a
            @Override // r2.b
            public final void a(r2.a aVar) {
                d.c(this.f10333a, aVar);
            }
        };
    }

    public final void f() {
        this.f10336a.a(new a.InterfaceC0080a() { // from class: o2.c
            @Override // i3.a.InterfaceC0080a
            public final void a(i3.b bVar) {
                d.a(this.f10335a, bVar);
            }
        });
    }
}
