package n0;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f10501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f10502e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f10505c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f10504b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10503a = new HashMap();

    public a(Context context) {
        this.f10505c = context.getApplicationContext();
    }

    public static a d(Context context) {
        if (f10501d == null) {
            synchronized (f10502e) {
                try {
                    if (f10501d == null) {
                        f10501d = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10501d;
    }

    public void a() {
        try {
            try {
                o0.b.a("Startup");
                b(this.f10505c.getPackageManager().getProviderInfo(new ComponentName(this.f10505c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                o0.b.b();
            } catch (PackageManager.NameNotFoundException e10) {
                throw new StartupException(e10);
            }
        } catch (Throwable th) {
            o0.b.b();
            throw th;
        }
    }

    public void b(Bundle bundle) {
        String string = this.f10505c.getString(c.f10506a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f10504b.add(cls);
                        }
                    }
                }
                Iterator it = this.f10504b.iterator();
                while (it.hasNext()) {
                    c((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new StartupException(e10);
            }
        }
    }

    public final Object c(Class cls, Set set) {
        Object objA;
        if (o0.b.d()) {
            try {
                o0.b.a(cls.getSimpleName());
            } catch (Throwable th) {
                o0.b.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f10503a.containsKey(cls)) {
            objA = this.f10503a.get(cls);
        } else {
            set.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listB = bVar.b();
                if (!listB.isEmpty()) {
                    for (Class cls2 : listB) {
                        if (!this.f10503a.containsKey(cls2)) {
                            c(cls2, set);
                        }
                    }
                }
                objA = bVar.a(this.f10505c);
                set.remove(cls);
                this.f10503a.put(cls, objA);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        o0.b.b();
        return objA;
    }
}
