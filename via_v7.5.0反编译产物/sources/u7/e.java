package u7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p7.a f12884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p7.l f12885b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Iterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f12886c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12887e = -2;

        public a() {
        }

        public final void a() {
            Object objInvoke;
            if (this.f12887e == -2) {
                objInvoke = e.this.f12884a.invoke();
            } else {
                p7.l lVar = e.this.f12885b;
                Object obj = this.f12886c;
                kotlin.jvm.internal.h.c(obj);
                objInvoke = lVar.invoke(obj);
            }
            this.f12886c = objInvoke;
            this.f12887e = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f12887e < 0) {
                a();
            }
            return this.f12887e == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f12887e < 0) {
                a();
            }
            if (this.f12887e == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f12886c;
            kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f12887e = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(p7.a getInitialValue, p7.l getNextValue) {
        kotlin.jvm.internal.h.f(getInitialValue, "getInitialValue");
        kotlin.jvm.internal.h.f(getNextValue, "getNextValue");
        this.f12884a = getInitialValue;
        this.f12885b = getNextValue;
    }

    @Override // u7.f
    public Iterator iterator() {
        return new a();
    }
}
