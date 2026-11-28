package u7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f12877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p7.l f12879c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Iterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Iterator f12880c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12881e = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f12882m;

        public a() {
            this.f12880c = d.this.f12877a.iterator();
        }

        public final void a() {
            while (this.f12880c.hasNext()) {
                Object next = this.f12880c.next();
                if (((Boolean) d.this.f12879c.invoke(next)).booleanValue() == d.this.f12878b) {
                    this.f12882m = next;
                    this.f12881e = 1;
                    return;
                }
            }
            this.f12881e = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12881e == -1) {
                a();
            }
            return this.f12881e == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f12881e == -1) {
                a();
            }
            if (this.f12881e == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f12882m;
            this.f12882m = null;
            this.f12881e = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(f sequence, boolean z10, p7.l predicate) {
        kotlin.jvm.internal.h.f(sequence, "sequence");
        kotlin.jvm.internal.h.f(predicate, "predicate");
        this.f12877a = sequence;
        this.f12878b = z10;
        this.f12879c = predicate;
    }

    @Override // u7.f
    public Iterator iterator() {
        return new a();
    }
}
