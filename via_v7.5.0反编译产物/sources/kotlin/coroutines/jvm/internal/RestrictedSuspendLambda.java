package kotlin.coroutines.jvm.internal;

import h7.a;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements g {
    private final int arity;

    public RestrictedSuspendLambda(int i10, a aVar) {
        super(aVar);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strD = j.d(this);
        h.e(strD, "renderLambdaToString(...)");
        return strD;
    }

    public RestrictedSuspendLambda(int i10) {
        this(i10, null);
    }
}
