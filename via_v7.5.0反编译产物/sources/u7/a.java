package u7;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f12875a;

    public a(f sequence) {
        kotlin.jvm.internal.h.f(sequence, "sequence");
        this.f12875a = new AtomicReference(sequence);
    }

    @Override // u7.f
    public Iterator iterator() {
        f fVar = (f) this.f12875a.getAndSet(null);
        if (fVar != null) {
            return fVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
