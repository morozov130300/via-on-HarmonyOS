package u7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n implements f, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f12896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12897b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Iterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12898c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Iterator f12899e;

        public a(n nVar) {
            this.f12898c = nVar.f12897b;
            this.f12899e = nVar.f12896a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12898c > 0 && this.f12899e.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i10 = this.f12898c;
            if (i10 == 0) {
                throw new NoSuchElementException();
            }
            this.f12898c = i10 - 1;
            return this.f12899e.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public n(f sequence, int i10) {
        kotlin.jvm.internal.h.f(sequence, "sequence");
        this.f12896a = sequence;
        this.f12897b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // u7.b
    public f a(int i10) {
        return i10 >= this.f12897b ? this : new n(this.f12896a, i10);
    }

    @Override // u7.f
    public Iterator iterator() {
        return new a(this);
    }
}
