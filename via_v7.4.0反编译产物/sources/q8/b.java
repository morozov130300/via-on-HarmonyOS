package q8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final List f11331a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public List f11332b = null;

    public void a(int i10, Object obj) {
        this.f11331a.add(i10, obj);
        g(i10, obj);
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f11332b == null) {
            this.f11332b = new ArrayList();
        }
        this.f11332b.add(aVar);
    }

    public Object c(int i10) {
        return this.f11331a.get(i10);
    }

    public List d() {
        return this.f11331a;
    }

    public boolean e() {
        return this.f11331a.isEmpty();
    }

    public final void f() {
        List list = this.f11332b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(this.f11331a);
        }
    }

    public final void g(int i10, Object obj) {
        List list = this.f11332b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i10, obj);
        }
    }

    public final void h(int i10, Object obj) {
        List list = this.f11332b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).d(i10, obj);
        }
    }

    public final void i(int i10, Object obj, Object obj2) {
        List list = this.f11332b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(i10, obj, obj2);
        }
    }

    public void j(int i10) {
        h(i10, this.f11331a.remove(i10));
    }

    public void k(int i10, Object obj, Object obj2) {
        this.f11331a.set(i10, obj);
        i(i10, obj, obj2);
    }

    public void l(List list) {
        this.f11331a.clear();
        if (list != null) {
            this.f11331a.addAll(list);
        }
        f();
    }

    public int m() {
        return this.f11331a.size();
    }
}
