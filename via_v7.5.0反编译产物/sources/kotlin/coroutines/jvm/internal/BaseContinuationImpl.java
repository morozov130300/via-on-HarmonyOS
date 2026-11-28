package kotlin.coroutines.jvm.internal;

import h7.a;
import i7.b;
import i7.d;
import i7.e;
import java.io.Serializable;
import kotlin.Result;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseContinuationImpl implements a, b, Serializable {
    private final a completion;

    public BaseContinuationImpl(a aVar) {
        this.completion = aVar;
    }

    public a create(a completion) {
        h.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public b getCallerFrame() {
        a aVar = this.completion;
        if (aVar instanceof b) {
            return (b) aVar;
        }
        return null;
    }

    public final a getCompletion() {
        return this.completion;
    }

    @Override // h7.a
    public abstract /* synthetic */ kotlin.coroutines.b getContext();

    public StackTraceElement getStackTraceElement() {
        return d.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // h7.a
    public final void resumeWith(Object obj) {
        a aVar = this;
        while (true) {
            e.b(aVar);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) aVar;
            a aVar2 = baseContinuationImpl.completion;
            h.c(aVar2);
            try {
                Object objInvokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                if (objInvokeSuspend == kotlin.coroutines.intrinsics.a.b()) {
                    return;
                } else {
                    obj = Result.m9constructorimpl(objInvokeSuspend);
                }
            } catch (Throwable th) {
                Result.a aVar3 = Result.Companion;
                obj = Result.m9constructorimpl(kotlin.b.a(th));
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(aVar2 instanceof BaseContinuationImpl)) {
                aVar2.resumeWith(obj);
                return;
            }
            aVar = aVar2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public a create(Object obj, a completion) {
        h.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
