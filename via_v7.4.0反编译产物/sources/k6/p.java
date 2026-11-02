package k6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k6.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p implements i.a {

    /* renamed from: a, reason: collision with root package name */
    public final List f8173a;

    /* renamed from: b, reason: collision with root package name */
    public final List f8174b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f8175c = new HashSet(3);

    public p(List list) {
        this.f8173a = list;
        this.f8174b = new ArrayList(list.size());
    }

    public static i c(List list, Class cls) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (cls.isAssignableFrom(iVar.getClass())) {
                return iVar;
            }
        }
        return null;
    }

    @Override // k6.i.a
    public i a(Class cls) {
        return d(cls);
    }

    public final void b(i iVar) {
        if (this.f8174b.contains(iVar)) {
            return;
        }
        if (this.f8175c.contains(iVar)) {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.f8175c);
        }
        this.f8175c.add(iVar);
        iVar.h(this);
        this.f8175c.remove(iVar);
        if (this.f8174b.contains(iVar)) {
            return;
        }
        if (io.noties.markwon.core.a.class.isAssignableFrom(iVar.getClass())) {
            this.f8174b.add(0, iVar);
        } else {
            this.f8174b.add(iVar);
        }
    }

    public final i d(Class cls) {
        i iVarC = c(this.f8174b, cls);
        if (iVarC != null) {
            return iVarC;
        }
        i iVarC2 = c(this.f8173a, cls);
        if (iVarC2 != null) {
            b(iVarC2);
            return iVarC2;
        }
        throw new IllegalStateException("Requested plugin is not added: " + cls.getName() + ", plugins: " + this.f8173a);
    }

    public List e() {
        Iterator it = this.f8173a.iterator();
        while (it.hasNext()) {
            b((i) it.next());
        }
        return this.f8174b;
    }
}
