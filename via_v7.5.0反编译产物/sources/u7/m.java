package u7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends l {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements Iterable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f12895c;

        public a(f fVar) {
            this.f12895c = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f12895c.iterator();
        }
    }

    public static Iterable g(f fVar) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        return new a(fVar);
    }

    public static f h(f fVar, p7.l predicate) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        kotlin.jvm.internal.h.f(predicate, "predicate");
        return new d(fVar, true, predicate);
    }

    public static f i(f fVar, p7.l transform) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        kotlin.jvm.internal.h.f(transform, "transform");
        return new o(fVar, transform);
    }

    public static f j(f fVar, int i10) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        if (i10 >= 0) {
            if (i10 == 0) {
                return k.e();
            }
            return fVar instanceof b ? ((b) fVar).a(i10) : new n(fVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static List k(f fVar) {
        kotlin.jvm.internal.h.f(fVar, "<this>");
        Iterator it = fVar.iterator();
        if (!it.hasNext()) {
            return e7.o.h();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return e7.n.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
