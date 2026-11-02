package t7;

import kotlin.jvm.internal.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c extends t7.a {

    /* renamed from: m, reason: collision with root package name */
    public static final a f12281m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    public static final c f12282n = new c(1, 0);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // t7.a
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

    @Override // t7.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + f();
    }

    @Override // t7.a
    public boolean isEmpty() {
        return c() > f();
    }

    public boolean k(int i10) {
        return c() <= i10 && i10 <= f();
    }

    @Override // t7.a
    public String toString() {
        return c() + ".." + f();
    }
}
