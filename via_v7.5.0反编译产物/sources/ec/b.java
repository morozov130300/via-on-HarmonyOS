package ec;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f4389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f4390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f4391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f4392e;

    public b() {
        this(0);
    }

    public void a(String str) {
        if (this.f4392e == null) {
            this.f4392e = new TreeSet();
        }
        this.f4392e.add(str);
    }

    public void b(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            a((String) it.next());
        }
    }

    public b c(Character ch) {
        b bVarJ = j(ch);
        if (bVarJ != null) {
            return bVarJ;
        }
        b bVar = new b(this.f4388a + 1);
        this.f4390c.put(ch, bVar);
        return bVar;
    }

    public Collection d() {
        Set set = this.f4392e;
        return set == null ? Collections.EMPTY_LIST : set;
    }

    public b e() {
        return this.f4391d;
    }

    public Collection f() {
        return this.f4390c.values();
    }

    public Collection g() {
        return this.f4390c.keySet();
    }

    public b h(Character ch) {
        return i(ch, false);
    }

    public final b i(Character ch, boolean z10) {
        b bVar;
        b bVar2 = (b) this.f4390c.get(ch);
        return (z10 || bVar2 != null || (bVar = this.f4389b) == null) ? bVar2 : bVar;
    }

    public b j(Character ch) {
        return i(ch, true);
    }

    public void k(b bVar) {
        this.f4391d = bVar;
    }

    public b(int i10) {
        this.f4390c = new HashMap();
        this.f4391d = null;
        this.f4392e = null;
        this.f4388a = i10;
        this.f4389b = i10 == 0 ? this : null;
    }
}
