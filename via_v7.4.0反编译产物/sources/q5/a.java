package q5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import r5.d;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final List f11329a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ReentrantReadWriteLock f11330b = new ReentrantReadWriteLock();

    @Override // q5.b
    public d a(int i10) {
        this.f11330b.readLock().lock();
        try {
            int iG = g(i10);
            if (iG >= 0) {
                return (d) this.f11329a.get(iG);
            }
            this.f11330b.readLock().unlock();
            return null;
        } finally {
            this.f11330b.readLock().unlock();
        }
    }

    @Override // q5.b
    public d b(int i10) {
        this.f11330b.writeLock().lock();
        try {
            int iG = g(i10);
            if (iG >= 0) {
                return (d) this.f11329a.remove(iG);
            }
            this.f11330b.writeLock().unlock();
            return null;
        } finally {
            this.f11330b.writeLock().unlock();
        }
    }

    @Override // q5.b
    public List c() {
        this.f11330b.readLock().lock();
        try {
            return Collections.unmodifiableList(this.f11329a);
        } finally {
            this.f11330b.readLock().unlock();
        }
    }

    @Override // q5.b
    public d d(String str) {
        this.f11330b.readLock().lock();
        try {
            int iH = h(str);
            if (iH >= 0) {
                return (d) this.f11329a.get(iH);
            }
            this.f11330b.readLock().unlock();
            return null;
        } finally {
            this.f11330b.readLock().unlock();
        }
    }

    @Override // q5.b
    public void e(List list) {
        this.f11330b.writeLock().lock();
        try {
            this.f11329a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d dVarJ = d.j((r5.b) it.next());
                if (dVarJ != null) {
                    this.f11329a.add(dVarJ);
                }
            }
        } finally {
            this.f11330b.writeLock().unlock();
        }
    }

    @Override // q5.b
    public d f(r5.b bVar) {
        d dVarJ = d.j(bVar);
        if (dVarJ == null) {
            b(bVar.g());
            return null;
        }
        this.f11330b.writeLock().lock();
        try {
            int iG = g(bVar.g());
            if (iG >= 0) {
                this.f11329a.set(iG, dVarJ);
            } else {
                this.f11329a.add(dVarJ);
            }
            this.f11330b.writeLock().unlock();
            return dVarJ;
        } catch (Throwable th) {
            this.f11330b.writeLock().unlock();
            throw th;
        }
    }

    public final int g(int i10) {
        int size = this.f11329a.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f11329a.get(i11) != null && ((d) this.f11329a.get(i11)).d() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final int h(String str) {
        if (str != null && !str.isEmpty()) {
            int size = this.f11329a.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (str.equals(((d) this.f11329a.get(i10)).h())) {
                    return i10;
                }
            }
        }
        return -1;
    }
}
