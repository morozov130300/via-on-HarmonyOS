package g;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements Iterable {

    /* renamed from: e, reason: collision with root package name */
    public c f6096e;

    /* renamed from: j, reason: collision with root package name */
    public c f6097j;

    /* renamed from: k, reason: collision with root package name */
    public final WeakHashMap f6098k = new WeakHashMap();

    /* renamed from: l, reason: collision with root package name */
    public int f6099l = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // g.b.e
        public c b(c cVar) {
            return cVar.f6103l;
        }

        @Override // g.b.e
        public c c(c cVar) {
            return cVar.f6102k;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: g.b$b, reason: collision with other inner class name */
    public static class C0070b extends e {
        public C0070b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // g.b.e
        public c b(c cVar) {
            return cVar.f6102k;
        }

        @Override // g.b.e
        public c c(c cVar) {
            return cVar.f6103l;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c implements Map.Entry {

        /* renamed from: e, reason: collision with root package name */
        public final Object f6100e;

        /* renamed from: j, reason: collision with root package name */
        public final Object f6101j;

        /* renamed from: k, reason: collision with root package name */
        public c f6102k;

        /* renamed from: l, reason: collision with root package name */
        public c f6103l;

        public c(Object obj, Object obj2) {
            this.f6100e = obj;
            this.f6101j = obj2;
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
            return this.f6100e.equals(cVar.f6100e) && this.f6101j.equals(cVar.f6101j);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f6100e;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f6101j;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f6100e.hashCode() ^ this.f6101j.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f6100e + "=" + this.f6101j;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends f implements Iterator {

        /* renamed from: e, reason: collision with root package name */
        public c f6104e;

        /* renamed from: j, reason: collision with root package name */
        public boolean f6105j = true;

        public d() {
        }

        @Override // g.b.f
        public void a(c cVar) {
            c cVar2 = this.f6104e;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f6103l;
                this.f6104e = cVar3;
                this.f6105j = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f6105j) {
                this.f6105j = false;
                this.f6104e = b.this.f6096e;
            } else {
                c cVar = this.f6104e;
                this.f6104e = cVar != null ? cVar.f6102k : null;
            }
            return this.f6104e;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f6105j) {
                return b.this.f6096e != null;
            }
            c cVar = this.f6104e;
            return (cVar == null || cVar.f6102k == null) ? false : true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class e extends f implements Iterator {

        /* renamed from: e, reason: collision with root package name */
        public c f6107e;

        /* renamed from: j, reason: collision with root package name */
        public c f6108j;

        public e(c cVar, c cVar2) {
            this.f6107e = cVar2;
            this.f6108j = cVar;
        }

        @Override // g.b.f
        public void a(c cVar) {
            if (this.f6107e == cVar && cVar == this.f6108j) {
                this.f6108j = null;
                this.f6107e = null;
            }
            c cVar2 = this.f6107e;
            if (cVar2 == cVar) {
                this.f6107e = b(cVar2);
            }
            if (this.f6108j == cVar) {
                this.f6108j = e();
            }
        }

        public abstract c b(c cVar);

        public abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f6108j;
            this.f6108j = e();
            return cVar;
        }

        public final c e() {
            c cVar = this.f6108j;
            c cVar2 = this.f6107e;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6108j != null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static abstract class f {
        public abstract void a(c cVar);
    }

    public Map.Entry c() {
        return this.f6096e;
    }

    public Iterator descendingIterator() {
        C0070b c0070b = new C0070b(this.f6097j, this.f6096e);
        this.f6098k.put(c0070b, Boolean.FALSE);
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
        c cVar = this.f6096e;
        while (cVar != null && !cVar.f6100e.equals(obj)) {
            cVar = cVar.f6102k;
        }
        return cVar;
    }

    public d g() {
        d dVar = new d();
        this.f6098k.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry h() {
        return this.f6097j;
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
        a aVar = new a(this.f6096e, this.f6097j);
        this.f6098k.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public c k(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f6099l++;
        c cVar2 = this.f6097j;
        if (cVar2 == null) {
            this.f6096e = cVar;
            this.f6097j = cVar;
            return cVar;
        }
        cVar2.f6102k = cVar;
        cVar.f6103l = cVar2;
        this.f6097j = cVar;
        return cVar;
    }

    public Object n(Object obj, Object obj2) {
        c cVarF = f(obj);
        if (cVarF != null) {
            return cVarF.f6101j;
        }
        k(obj, obj2);
        return null;
    }

    public Object o(Object obj) {
        c cVarF = f(obj);
        if (cVarF == null) {
            return null;
        }
        this.f6099l--;
        if (!this.f6098k.isEmpty()) {
            Iterator it = this.f6098k.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarF);
            }
        }
        c cVar = cVarF.f6103l;
        if (cVar != null) {
            cVar.f6102k = cVarF.f6102k;
        } else {
            this.f6096e = cVarF.f6102k;
        }
        c cVar2 = cVarF.f6102k;
        if (cVar2 != null) {
            cVar2.f6103l = cVar;
        } else {
            this.f6097j = cVar;
        }
        cVarF.f6102k = null;
        cVarF.f6103l = null;
        return cVarF.f6101j;
    }

    public int size() {
        return this.f6099l;
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
