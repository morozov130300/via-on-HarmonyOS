package kotlin.coroutines.jvm.internal;

import h7.a;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(a aVar) {
        super(aVar);
        if (aVar != null && aVar.getContext() != EmptyCoroutineContext.INSTANCE) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, h7.a
    public b getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
