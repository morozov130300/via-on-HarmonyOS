package e6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class p implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f4259c = new HashSet(3);

    public p(List list) {
        this.f4257a = list;
        this.f4258b = new ArrayList(list.size());
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

    @Override // e6.i.a
    public i a(Class cls) {
        return d(cls);
    }

    public final void b(i iVar) {
        if (this.f4258b.contains(iVar)) {
            return;
        }
        if (this.f4259c.contains(iVar)) {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.f4259c);
        }
        this.f4259c.add(iVar);
        iVar.h(this);
        this.f4259c.remove(iVar);
        if (this.f4258b.contains(iVar)) {
            return;
        }
        if (io.noties.markwon.core.a.class.isAssignableFrom(iVar.getClass())) {
            this.f4258b.add(0, iVar);
        } else {
            this.f4258b.add(iVar);
        }
    }

    public final i d(Class cls) {
        i iVarC = c(this.f4258b, cls);
        if (iVarC != null) {
            return iVarC;
        }
        i iVarC2 = c(this.f4257a, cls);
        if (iVarC2 != null) {
            b(iVarC2);
            return iVarC2;
        }
        throw new IllegalStateException("Requested plugin is not added: " + cls.getName() + ", plugins: " + this.f4257a);
    }

    public List e() {
        Iterator it = this.f4257a.iterator();
        while (it.hasNext()) {
            b((i) it.next());
        }
        return this.f4258b;
    }
}
