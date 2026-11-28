package s7;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends s7.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f12224o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c f12225p = new c(1, 0);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        public final c a() {
            return c.f12225p;
        }

        public a() {
        }
    }

    public c(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // s7.a
    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return c() == cVar.c() && f() == cVar.f();
    }

    @Override // s7.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + f();
    }

    @Override // s7.a
    public boolean isEmpty() {
        return c() > f();
    }

    public Integer n() {
        return Integer.valueOf(f());
    }

    public Integer o() {
        return Integer.valueOf(c());
    }

    @Override // s7.a
    public String toString() {
        return c() + ".." + f();
    }
}
