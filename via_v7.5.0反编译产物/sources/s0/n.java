package s0;

import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n implements r0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScriptHandlerBoundaryInterface f12143a;

    public n(ScriptHandlerBoundaryInterface scriptHandlerBoundaryInterface) {
        this.f12143a = scriptHandlerBoundaryInterface;
    }

    public static n a(InvocationHandler invocationHandler) {
        return new n((ScriptHandlerBoundaryInterface) hc.b.a(ScriptHandlerBoundaryInterface.class, invocationHandler));
    }

    @Override // r0.f
    public void remove() {
        this.f12143a.remove();
    }
}
