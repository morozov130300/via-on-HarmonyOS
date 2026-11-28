package i7;

import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final void a(int i10, int i11) {
        if (i11 <= i10) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i10 + ", got " + i11 + ". Please update the Kotlin standard library.").toString());
    }

    public static final c b(BaseContinuationImpl baseContinuationImpl) {
        return (c) baseContinuationImpl.getClass().getAnnotation(c.class);
    }

    public static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(BaseContinuationImpl baseContinuationImpl) {
        String strC;
        h.f(baseContinuationImpl, "<this>");
        c cVarB = b(baseContinuationImpl);
        if (cVarB == null) {
            return null;
        }
        a(1, cVarB.v());
        int iC = c(baseContinuationImpl);
        int i10 = iC < 0 ? -1 : cVarB.l()[iC];
        String strB = f.f6297a.b(baseContinuationImpl);
        if (strB == null) {
            strC = cVarB.c();
        } else {
            strC = strB + '/' + cVarB.c();
        }
        return new StackTraceElement(strC, cVarB.m(), cVarB.f(), i10);
    }
}
