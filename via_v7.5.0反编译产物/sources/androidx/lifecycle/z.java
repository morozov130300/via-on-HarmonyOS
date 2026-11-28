package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f990a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f991b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f992c = false;

    public static void f(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final void e() {
        this.f992c = true;
        Map map = this.f990a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator it = this.f990a.values().iterator();
                    while (it.hasNext()) {
                        f(it.next());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Set set = this.f991b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator it2 = this.f991b.iterator();
                    while (it2.hasNext()) {
                        f((Closeable) it2.next());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        h();
    }

    public Object g(String str) {
        Object obj;
        Map map = this.f990a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f990a.get(str);
        }
        return obj;
    }

    public Object i(String str, Object obj) {
        Object obj2;
        synchronized (this.f990a) {
            try {
                obj2 = this.f990a.get(str);
                if (obj2 == null) {
                    this.f990a.put(str, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f992c) {
            f(obj);
        }
        return obj;
    }

    public void h() {
    }
}
