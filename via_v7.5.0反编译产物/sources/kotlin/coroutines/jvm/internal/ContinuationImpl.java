package kotlin.coroutines.jvm.internal;

import h7.a;
import kotlin.coroutines.b;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final b _context;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient a f7301c;

    public ContinuationImpl(a aVar, b bVar) {
        super(aVar);
        this._context = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, h7.a
    public b getContext() {
        b bVar = this._context;
        h.c(bVar);
        return bVar;
    }

    public final a intercepted() {
        a aVar = this.f7301c;
        if (aVar != null) {
            return aVar;
        }
        getContext().get(kotlin.coroutines.a.f7297k);
        this.f7301c = this;
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        a aVar = this.f7301c;
        if (aVar == null || aVar == this) {
            this.f7301c = i7.a.f6296c;
        } else {
            getContext().get(kotlin.coroutines.a.f7297k);
            h.c(null);
            throw null;
        }
    }

    public ContinuationImpl(a aVar) {
        this(aVar, aVar != null ? aVar.getContext() : null);
    }
}
