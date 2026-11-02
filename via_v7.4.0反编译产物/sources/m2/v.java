package m2;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v implements i3.b {

    /* renamed from: b, reason: collision with root package name */
    public volatile Set f8610b = null;

    /* renamed from: a, reason: collision with root package name */
    public volatile Set f8609a = Collections.newSetFromMap(new ConcurrentHashMap());

    public v(Collection collection) {
        this.f8609a.addAll(collection);
    }

    public static v b(Collection collection) {
        return new v((Set) collection);
    }

    public synchronized void a(i3.b bVar) {
        try {
            if (this.f8610b == null) {
                this.f8609a.add(bVar);
            } else {
                this.f8610b.add(bVar.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // i3.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.f8610b == null) {
            synchronized (this) {
                try {
                    if (this.f8610b == null) {
                        this.f8610b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f8610b);
    }

    public final synchronized void d() {
        try {
            Iterator it = this.f8609a.iterator();
            while (it.hasNext()) {
                this.f8610b.add(((i3.b) it.next()).get());
            }
            this.f8609a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
