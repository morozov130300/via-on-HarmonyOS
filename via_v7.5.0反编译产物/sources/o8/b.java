package o8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10974a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f10975b = null;

    public void a(int i10, Object obj) {
        this.f10974a.add(i10, obj);
        g(i10, obj);
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f10975b == null) {
            this.f10975b = new ArrayList();
        }
        this.f10975b.add(aVar);
    }

    public Object c(int i10) {
        return this.f10974a.get(i10);
    }

    public List d() {
        return this.f10974a;
    }

    public boolean e() {
        return this.f10974a.isEmpty();
    }

    public final void f() {
        List list = this.f10975b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(this.f10974a);
        }
    }

    public final void g(int i10, Object obj) {
        List list = this.f10975b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i10, obj);
        }
    }

    public final void h(int i10, Object obj) {
        List list = this.f10975b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).d(i10, obj);
        }
    }

    public final void i(int i10, Object obj, Object obj2) {
        List list = this.f10975b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(i10, obj, obj2);
        }
    }

    public void j(int i10) {
        h(i10, this.f10974a.remove(i10));
    }

    public void k(int i10, Object obj, Object obj2) {
        this.f10974a.set(i10, obj);
        i(i10, obj, obj2);
    }

    public void l(List list) {
        this.f10974a.clear();
        if (list != null) {
            this.f10974a.addAll(list);
        }
        f();
    }

    public int m() {
        return this.f10974a.size();
    }
}
