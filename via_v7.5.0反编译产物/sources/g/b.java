package g;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements Iterable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f4609c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f4610e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WeakHashMap f4611m = new WeakHashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4612n = 0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // g.b.e
        public c b(c cVar) {
            return cVar.f4616n;
        }

        @Override // g.b.e
        public c c(c cVar) {
            return cVar.f4615m;
        }
    }

    /* JADX INFO: renamed from: g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0070b extends e {
        public C0070b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // g.b.e
        public c b(c cVar) {
            return cVar.f4615m;
        }

        @Override // g.b.e
        public c c(c cVar) {
            return cVar.f4616n;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c implements Map.Entry {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f4613c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f4614e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public c f4615m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public c f4616n;

        public c(Object obj, Object obj2) {
            this.f4613c = obj;
            this.f4614e = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f4613c.equals(cVar.f4613c) && this.f4614e.equals(cVar.f4614e);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f4613c;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f4614e;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f4613c.hashCode() ^ this.f4614e.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f4613c + "=" + this.f4614e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends f implements Iterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f4617c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4618e = true;

        public d() {
        }

        @Override // g.b.f
        public void a(c cVar) {
            c cVar2 = this.f4617c;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f4616n;
                this.f4617c = cVar3;
                this.f4618e = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f4618e) {
                this.f4618e = false;
                this.f4617c = b.this.f4609c;
            } else {
                c cVar = this.f4617c;
                this.f4617c = cVar != null ? cVar.f4615m : null;
            }
            return this.f4617c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f4618e) {
                return b.this.f4609c != null;
            }
            c cVar = this.f4617c;
            return (cVar == null || cVar.f4615m == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class e extends f implements Iterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f4620c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f4621e;

        public e(c cVar, c cVar2) {
            this.f4620c = cVar2;
            this.f4621e = cVar;
        }

        @Override // g.b.f
        public void a(c cVar) {
            if (this.f4620c == cVar && cVar == this.f4621e) {
                this.f4621e = null;
                this.f4620c = null;
            }
            c cVar2 = this.f4620c;
            if (cVar2 == cVar) {
                this.f4620c = b(cVar2);
            }
            if (this.f4621e == cVar) {
                this.f4621e = e();
            }
        }

        public abstract c b(c cVar);

        public abstract c c(c cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f4621e;
            this.f4621e = e();
            return cVar;
        }

        public final c e() {
            c cVar = this.f4621e;
            c cVar2 = this.f4620c;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4621e != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static abstract class f {
        public abstract void a(c cVar);
    }

    public Map.Entry c() {
        return this.f4609c;
    }

    public Iterator descendingIterator() {
        C0070b c0070b = new C0070b(this.f4610e, this.f4609c);
        this.f4611m.put(c0070b, Boolean.FALSE);
        return c0070b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public c f(Object obj) {
        c cVar = this.f4609c;
        while (cVar != null && !cVar.f4613c.equals(obj)) {
            cVar = cVar.f4615m;
        }
        return cVar;
    }

    public d g() {
        d dVar = new d();
        this.f4611m.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry h() {
        return this.f4610e;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f4609c, this.f4610e);
        this.f4611m.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public c k(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f4612n++;
        c cVar2 = this.f4610e;
        if (cVar2 == null) {
            this.f4609c = cVar;
            this.f4610e = cVar;
            return cVar;
        }
        cVar2.f4615m = cVar;
        cVar.f4616n = cVar2;
        this.f4610e = cVar;
        return cVar;
    }

    public Object n(Object obj, Object obj2) {
        c cVarF = f(obj);
        if (cVarF != null) {
            return cVarF.f4614e;
        }
        k(obj, obj2);
        return null;
    }

    public Object o(Object obj) {
        c cVarF = f(obj);
        if (cVarF == null) {
            return null;
        }
        this.f4612n--;
        if (!this.f4611m.isEmpty()) {
            Iterator it = this.f4611m.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarF);
            }
        }
        c cVar = cVarF.f4616n;
        if (cVar != null) {
            cVar.f4615m = cVarF.f4615m;
        } else {
            this.f4609c = cVarF.f4615m;
        }
        c cVar2 = cVarF.f4615m;
        if (cVar2 != null) {
            cVar2.f4616n = cVar;
        } else {
            this.f4610e = cVar;
        }
        cVarF.f4615m = null;
        cVarF.f4616n = null;
        return cVarF.f4614e;
    }

    public int size() {
        return this.f4612n;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb2.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
