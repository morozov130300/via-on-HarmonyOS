package k;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends g implements Map {

    /* renamed from: p, reason: collision with root package name */
    public f f7964p;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: k.a$a, reason: collision with other inner class name */
    public class C0093a extends f {
        public C0093a() {
        }

        @Override // k.f
        public void a() {
            a.this.clear();
        }

        @Override // k.f
        public Object b(int i10, int i11) {
            return a.this.f8013j[(i10 << 1) + i11];
        }

        @Override // k.f
        public Map c() {
            return a.this;
        }

        @Override // k.f
        public int d() {
            return a.this.f8014k;
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

    public a(int i10) {
        super(i10);
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
        if (this.f7964p == null) {
            this.f7964p = new C0093a();
        }
        return this.f7964p;
    }

    public boolean n(Collection collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c(this.f8014k + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return m().n();
    }
}
