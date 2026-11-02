package h2;

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
import m2.o;
import m2.u;
import s1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f6330k = new Object();

    /* renamed from: l, reason: collision with root package name */
    public static final Map f6331l = new k.a();

    /* renamed from: a, reason: collision with root package name */
    public final Context f6332a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6333b;

    /* renamed from: c, reason: collision with root package name */
    public final k f6334c;

    /* renamed from: d, reason: collision with root package name */
    public final o f6335d;

    /* renamed from: g, reason: collision with root package name */
    public final u f6338g;

    /* renamed from: h, reason: collision with root package name */
    public final i3.b f6339h;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f6336e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f6337f = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    public final List f6340i = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final List f6341j = new CopyOnWriteArrayList();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(boolean z10);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b implements a.InterfaceC0119a {

        /* renamed from: a, reason: collision with root package name */
        public static AtomicReference f6342a = new AtomicReference();

        public static void c(Context context) {
            if (w1.j.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f6342a.get() == null) {
                    b bVar = new b();
                    if (autodispose2.c.a(f6342a, null, bVar)) {
                        s1.a.c(application);
                        s1.a.b().a(bVar);
                    }
                }
            }
        }

        @Override // s1.a.InterfaceC0119a
        public void a(boolean z10) {
            synchronized (e.f6330k) {
                try {
                    Iterator it = new ArrayList(e.f6331l.values()).iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (eVar.f6336e.get()) {
                            eVar.w(z10);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        public static AtomicReference f6343b = new AtomicReference();

        /* renamed from: a, reason: collision with root package name */
        public final Context f6344a;

        public c(Context context) {
            this.f6344a = context;
        }

        public static void b(Context context) {
            if (f6343b.get() == null) {
                c cVar = new c(context);
                if (autodispose2.c.a(f6343b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f6344a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (e.f6330k) {
                try {
                    Iterator it = e.f6331l.values().iterator();
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
        this.f6332a = (Context) t1.f.h(context);
        this.f6333b = t1.f.d(str);
        this.f6334c = (k) t1.f.h(kVar);
        l lVarB = FirebaseInitProvider.b();
        p3.c.b("Firebase");
        p3.c.b("ComponentDiscovery");
        List listB = m2.g.c(context, ComponentDiscoveryService.class).b();
        p3.c.a();
        p3.c.b("Runtime");
        o.b bVarF = o.m(UiExecutor.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(m2.c.q(context, Context.class, new Class[0])).b(m2.c.q(this, e.class, new Class[0])).b(m2.c.q(kVar, k.class, new Class[0])).f(new p3.b());
        if (u.u.a(context) && FirebaseInitProvider.c()) {
            bVarF.b(m2.c.q(lVarB, l.class, new Class[0]));
        }
        o oVarE = bVarF.e();
        this.f6335d = oVarE;
        p3.c.a();
        this.f6338g = new u(new i3.b() { // from class: h2.c
            @Override // i3.b
            public final Object get() {
                return e.b(this.f6327a, context);
            }
        });
        this.f6339h = oVarE.c(h3.f.class);
        g(new a() { // from class: h2.d
            @Override // h2.e.a
            public final void a(boolean z10) {
                e.a(this.f6329a, z10);
            }
        });
        p3.c.a();
    }

    public static /* synthetic */ void a(e eVar, boolean z10) {
        if (z10) {
            eVar.getClass();
        } else {
            ((h3.f) eVar.f6339h.get()).g();
        }
    }

    public static /* synthetic */ n3.a b(e eVar, Context context) {
        return new n3.a(context, eVar.o(), (g3.c) eVar.f6335d.a(g3.c.class));
    }

    public static List k(Context context) {
        ArrayList arrayList;
        synchronized (f6330k) {
            arrayList = new ArrayList(f6331l.values());
        }
        return arrayList;
    }

    public static e l() {
        e eVar;
        synchronized (f6330k) {
            try {
                eVar = (e) f6331l.get("[DEFAULT]");
                if (eVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + w1.k.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public static e q(Context context) {
        synchronized (f6330k) {
            try {
                if (f6331l.containsKey("[DEFAULT]")) {
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
        synchronized (f6330k) {
            Map map = f6331l;
            t1.f.l(!map.containsKey(strV), "FirebaseApp name " + strV + " already exists!");
            t1.f.i(context, "Application context cannot be null.");
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
            return this.f6333b.equals(((e) obj).m());
        }
        return false;
    }

    public void g(a aVar) {
        h();
        if (this.f6336e.get() && s1.a.b().d()) {
            aVar.a(true);
        }
        this.f6340i.add(aVar);
    }

    public final void h() {
        t1.f.l(!this.f6337f.get(), "FirebaseApp was deleted");
    }

    public int hashCode() {
        return this.f6333b.hashCode();
    }

    public Object i(Class cls) {
        h();
        return this.f6335d.a(cls);
    }

    public Context j() {
        h();
        return this.f6332a;
    }

    public String m() {
        h();
        return this.f6333b;
    }

    public k n() {
        h();
        return this.f6334c;
    }

    public String o() {
        return w1.b.a(m().getBytes(Charset.defaultCharset())) + "+" + w1.b.a(n().c().getBytes(Charset.defaultCharset()));
    }

    public final void p() {
        if (!u.u.a(this.f6332a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + m());
            c.b(this.f6332a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + m());
        this.f6335d.p(u());
        ((h3.f) this.f6339h.get()).g();
    }

    public boolean t() {
        h();
        return ((n3.a) this.f6338g.get()).b();
    }

    public String toString() {
        return t1.e.c(this).a("name", this.f6333b).a("options", this.f6334c).toString();
    }

    public boolean u() {
        return "[DEFAULT]".equals(m());
    }

    public final void w(boolean z10) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f6340i.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z10);
        }
    }
}
