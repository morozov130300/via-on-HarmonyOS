package n2;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v implements j3.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set f10574b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set f10573a = Collections.newSetFromMap(new ConcurrentHashMap());

    public v(Collection collection) {
        this.f10573a.addAll(collection);
    }

    public static v b(Collection collection) {
        return new v((Set) collection);
    }

    public synchronized void a(j3.b bVar) {
        try {
            if (this.f10574b == null) {
                this.f10573a.add(bVar);
            } else {
                this.f10574b.add(bVar.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // j3.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.f10574b == null) {
            synchronized (this) {
                try {
                    if (this.f10574b == null) {
                        this.f10574b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Collections.unmodifiableSet(this.f10574b);
    }

    public final synchronized void d() {
        try {
            Iterator it = this.f10573a.iterator();
            while (it.hasNext()) {
                this.f10574b.add(((j3.b) it.next()).get());
            }
            this.f10573a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
