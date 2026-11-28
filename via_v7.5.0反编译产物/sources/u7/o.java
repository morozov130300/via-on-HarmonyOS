package u7;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f12900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p7.l f12901b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Iterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Iterator f12902c;

        public a() {
            this.f12902c = o.this.f12900a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12902c.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return o.this.f12901b.invoke(this.f12902c.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public o(f sequence, p7.l transformer) {
        kotlin.jvm.internal.h.f(sequence, "sequence");
        kotlin.jvm.internal.h.f(transformer, "transformer");
        this.f12900a = sequence;
        this.f12901b = transformer;
    }

    @Override // u7.f
    public Iterator iterator() {
        return new a();
    }
}
