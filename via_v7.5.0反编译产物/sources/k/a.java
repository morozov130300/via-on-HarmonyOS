package k;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends g implements Map {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f f7064r;

    /* JADX INFO: renamed from: k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0084a extends f {
        public C0084a() {
        }

        @Override // k.f
        public void a() {
            a.this.clear();
        }

        @Override // k.f
        public Object b(int i10, int i11) {
            return a.this.f7113e[(i10 << 1) + i11];
        }

        @Override // k.f
        public Map c() {
            return a.this;
        }

        @Override // k.f
        public int d() {
            return a.this.f7114m;
        }

        @Override // k.f
        public int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // k.f
        public int f(Object obj) {
            return a.this.h(obj);
        }

        @Override // k.f
        public void g(Object obj, Object obj2) {
            a.this.put(obj, obj2);
        }

        @Override // k.f
        public void h(int i10) {
            a.this.j(i10);
        }

        @Override // k.f
        public Object i(int i10, Object obj) {
            return a.this.k(i10, obj);
        }
    }

    public a() {
    }

    @Override // java.util.Map
    public Set entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set keySet() {
        return m().m();
    }

    public final f m() {
        if (this.f7064r == null) {
            this.f7064r = new C0084a();
        }
        return this.f7064r;
    }

    public boolean n(Collection collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c(this.f7114m + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return m().n();
    }

    public a(int i10) {
        super(i10);
    }
}
