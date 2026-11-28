package i2;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import n2.o;
import n2.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f6199k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map f6200l = new k.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f6203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f6204d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f6207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j3.b f6208h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f6205e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f6206f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f6209i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f6210j = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(boolean z10);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b implements t1.a.InterfaceC0122a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AtomicReference f6211a = new AtomicReference();

        public static void c(Context context) {
            if (x1.j.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f6211a.get() == null) {
                    b bVar = new b();
                    if (autodispose2.c.a(f6211a, null, bVar)) {
                        t1.a.c(application);
                        t1.a.b().a(bVar);
                    }
                }
            }
        }

        @Override // t1.a.InterfaceC0122a
        public void a(boolean z10) {
            synchronized (e.f6199k) {
                try {
                    for (e eVar : new ArrayList(e.f6200l.values())) {
                        if (eVar.f6205e.get()) {
                            eVar.w(z10);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static AtomicReference f6212b = new AtomicReference();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f6213a;

        public c(Context context) {
            this.f6213a = context;
        }

        public static void b(Context context) {
            if (f6212b.get() == null) {
                c cVar = new c(context);
                if (autodispose2.c.a(f6212b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f6213a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (e.f6199k) {
                try {
                    Iterator it = e.f6200l.values().iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).p();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            c();
        }
    }

    public e(final Context context, String str, k kVar) {
        this.f6201a = (Context) u1.f.h(context);
        this.f6202b = u1.f.d(str);
        this.f6203c = (k) u1.f.h(kVar);
        l lVarB = FirebaseInitProvider.b();
        q3.c.b("Firebase");
        q3.c.b("ComponentDiscovery");
        List listB = n2.g.c(context, ComponentDiscoveryService.class).b();
        q3.c.a();
        q3.c.b("Runtime");
        o.b bVarF = o.m(UiExecutor.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(n2.c.q(context, Context.class, new Class[0])).b(n2.c.q(this, e.class, new Class[0])).b(n2.c.q(kVar, k.class, new Class[0])).f(new q3.b());
        if (v.u.a(context) && FirebaseInitProvider.c()) {
            bVarF.b(n2.c.q(lVarB, l.class, new Class[0]));
        }
        o oVarE = bVarF.e();
        this.f6204d = oVarE;
        q3.c.a();
        this.f6207g = new u(new j3.b() { // from class: i2.c
            @Override // j3.b
            public final Object get() {
                return e.b(this.f6196a, context);
            }
        });
        this.f6208h = oVarE.d(i3.f.class);
        g(new a() { // from class: i2.d
            @Override // i2.e.a
            public final void a(boolean z10) {
                e.a(this.f6198a, z10);
            }
        });
        q3.c.a();
    }

    public static /* synthetic */ void a(e eVar, boolean z10) {
        if (z10) {
            eVar.getClass();
        } else {
            ((i3.f) eVar.f6208h.get()).g();
        }
    }

    public static /* synthetic */ o3.a b(e eVar, Context context) {
        return new o3.a(context, eVar.o(), (h3.c) eVar.f6204d.a(h3.c.class));
    }

    public static List k(Context context) {
        ArrayList arrayList;
        synchronized (f6199k) {
            arrayList = new ArrayList(f6200l.values());
        }
        return arrayList;
    }

    public static e l() {
        e eVar;
        synchronized (f6199k) {
            try {
                eVar = (e) f6200l.get("[DEFAULT]");
                if (eVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + x1.k.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public static e q(Context context) {
        synchronized (f6199k) {
            try {
                if (f6200l.containsKey("[DEFAULT]")) {
                    return l();
                }
                k kVarA = k.a(context);
                if (kVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return r(context, kVarA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static e r(Context context, k kVar) {
        return s(context, kVar, "[DEFAULT]");
    }

    public static e s(Context context, k kVar, String str) {
        e eVar;
        b.c(context);
        String strV = v(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f6199k) {
            Map map = f6200l;
            u1.f.l(!map.containsKey(strV), "FirebaseApp name " + strV + " already exists!");
            u1.f.i(context, "Application context cannot be null.");
            eVar = new e(context, strV, kVar);
            map.put(strV, eVar);
        }
        eVar.p();
        return eVar;
    }

    public static String v(String str) {
        return str.trim();
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f6202b.equals(((e) obj).m());
        }
        return false;
    }

    public void g(a aVar) {
        h();
        if (this.f6205e.get() && t1.a.b().d()) {
            aVar.a(true);
        }
        this.f6209i.add(aVar);
    }

    public final void h() {
        u1.f.l(!this.f6206f.get(), "FirebaseApp was deleted");
    }

    public int hashCode() {
        return this.f6202b.hashCode();
    }

    public Object i(Class cls) {
        h();
        return this.f6204d.a(cls);
    }

    public Context j() {
        h();
        return this.f6201a;
    }

    public String m() {
        h();
        return this.f6202b;
    }

    public k n() {
        h();
        return this.f6203c;
    }

    public String o() {
        return x1.b.a(m().getBytes(Charset.defaultCharset())) + "+" + x1.b.a(n().c().getBytes(Charset.defaultCharset()));
    }

    public final void p() {
        if (!v.u.a(this.f6201a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + m());
            c.b(this.f6201a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + m());
        this.f6204d.p(u());
        ((i3.f) this.f6208h.get()).g();
    }

    public boolean t() {
        h();
        return ((o3.a) this.f6207g.get()).b();
    }

    public String toString() {
        return u1.e.c(this).a("name", this.f6202b).a("options", this.f6203c).toString();
    }

    public boolean u() {
        return "[DEFAULT]".equals(m());
    }

    public final void w(boolean z10) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f6209i.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z10);
        }
    }
}
