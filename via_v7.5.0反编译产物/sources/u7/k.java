package u7;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends j {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f12894a;

        public a(Iterator it) {
            this.f12894a = it;
        }

        @Override // u7.f
        public Iterator iterator() {
            return this.f12894a;
        }
    }

    public static f c(Iterator it) {
        kotlin.jvm.internal.h.f(it, "<this>");
        return d(new a(it));
    }

    public static final f d(f fVar) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        return fVar instanceof u7.a ? fVar : new u7.a(fVar);
    }

    public static final f e() {
        return c.f12876a;
    }

    public static f f(p7.a seedFunction, p7.l nextFunction) {
        kotlin.jvm.internal.h.f(seedFunction, "seedFunction");
        kotlin.jvm.internal.h.f(nextFunction, "nextFunction");
        return new e(seedFunction, nextFunction);
    }
}
