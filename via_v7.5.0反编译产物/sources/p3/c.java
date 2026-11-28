package p3;

import java.util.Iterator;
import java.util.Set;
import n2.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f11567b;

    public c(Set set, d dVar) {
        this.f11566a = d(set);
        this.f11567b = dVar;
    }

    public static /* synthetic */ i b(n2.e eVar) {
        return new c(eVar.h(f.class), d.a());
    }

    public static n2.c c() {
        return n2.c.c(i.class).b(r.l(f.class)).e(new n2.h() { // from class: p3.b
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return c.b(eVar);
            }
        }).c();
    }

    public static String d(Set set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            sb2.append(fVar.b());
            sb2.append('/');
            sb2.append(fVar.c());
            if (it.hasNext()) {
                sb2.append(' ');
            }
        }
        return sb2.toString();
    }

    @Override // p3.i
    public String a() {
        if (this.f11567b.b().isEmpty()) {
            return this.f11566a;
        }
        return this.f11566a + ' ' + d(this.f11567b.b());
    }
}
