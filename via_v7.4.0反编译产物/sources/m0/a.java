package m0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.StartupException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f8537d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f8538e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f8541c;

    /* renamed from: b, reason: collision with root package name */
    public final Set f8540b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final Map f8539a = new HashMap();

    public a(Context context) {
        this.f8541c = context.getApplicationContext();
    }

    public static a d(Context context) {
        if (f8537d == null) {
            synchronized (f8538e) {
                try {
                    if (f8537d == null) {
                        f8537d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f8537d;
    }

    public void a() {
        try {
            try {
                n0.b.a("Startup");
                b(this.f8541c.getPackageManager().getProviderInfo(new ComponentName(this.f8541c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new StartupException(e10);
            }
        } finally {
            n0.b.b();
        }
    }

    public void b(Bundle bundle) throws ClassNotFoundException {
        String string = this.f8541c.getString(c.f8542a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f8540b.add(cls);
                        }
                    }
                }
                Iterator it = this.f8540b.iterator();
                while (it.hasNext()) {
                    c((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new StartupException(e10);
            }
        }
    }

    public final Object c(Class cls, Set set) {
        Object objB;
        if (n0.b.d()) {
            try {
                n0.b.a(cls.getSimpleName());
            } catch (Throwable th) {
                n0.b.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f8539a.containsKey(cls)) {
            objB = this.f8539a.get(cls);
        } else {
            set.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!this.f8539a.containsKey(cls2)) {
                            c(cls2, set);
                        }
                    }
                }
                objB = bVar.b(this.f8541c);
                set.remove(cls);
                this.f8539a.put(cls, objB);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        n0.b.b();
        return objB;
    }
}
